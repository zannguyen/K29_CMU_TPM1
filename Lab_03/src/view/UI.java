package view;

import javax.swing.*;
import java.awt.*;
import view.*;

public class UI extends JFrame {
    private JTextField txtSo1, txtSo2, txtKetQua, txtPhepToan;
    private JButton btnThucHien;

    public UI() {
        setTitle("Máy tính chia theo chức năng");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Các thành phần giao diện
        add(new JLabel("Số thứ nhất:"));
        txtSo1 = new JTextField();
        add(txtSo1);

        add(new JLabel("Số thứ hai:"));
        txtSo2 = new JTextField();
        add(txtSo2);

        add(new JLabel("Phép toán (+ - * /):"));
        txtPhepToan = new JTextField();
        add(txtPhepToan);

        btnThucHien = new JButton("Thực hiện");
        add(btnThucHien);

        add(new JLabel("Kết quả:"));
        txtKetQua = new JTextField();
        txtKetQua.setEditable(false);
        add(txtKetQua);

        btnThucHien.addActionListener(e -> thucHien());
    }

    private void thucHien() {
        try {
            int a = Integer.parseInt(txtSo1.getText());
            int b = Integer.parseInt(txtSo2.getText());
            String dau = txtPhepToan.getText().trim();
            String kq;

            switch (dau) {
                case "+":
                    kq = String.valueOf(Cong.tinh(a, b));
                    break;
                case "-":
                    kq = String.valueOf(Tru.tinh(a, b));
                    break;
                case "*":
                    kq = String.valueOf(Nhan.tinh(a, b));
                    break;
                case "/":
                    kq = Chia.tinh(a, b);
                    break;
                default:
                    kq = "Dấu không hợp lệ";
            }

            txtKetQua.setText(kq);
        } catch (NumberFormatException e) {
            txtKetQua.setText("Sai định dạng số");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UI().setVisible(true));
    }
}