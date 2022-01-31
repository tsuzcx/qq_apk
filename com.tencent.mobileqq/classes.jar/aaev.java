import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class aaev
  implements DialogInterface.OnClickListener
{
  public aaev(aagn paramaagn, int paramInt, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, aagm paramaagm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Aagn.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label130;
      }
      awqx.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "1", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Aagn.b = false;
      this.jdField_a_of_type_Aagn.c = false;
      this.jdField_a_of_type_Aagn.e = false;
      ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aagm, this.jdField_a_of_type_Aagn);
      if (QLog.isColorLevel()) {
        QLog.d("chenlong", 2, "" + (System.currentTimeMillis() - l));
      }
      return;
      label130:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        awqx.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "1", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaev
 * JD-Core Version:    0.7.0.1
 */