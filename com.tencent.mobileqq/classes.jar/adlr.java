import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class adlr
  implements DialogInterface.OnClickListener
{
  adlr(adnn paramadnn, int paramInt, long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, adnm paramadnm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Adnn.a)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label130;
      }
      bdla.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "1", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Adnn.b = false;
      this.jdField_a_of_type_Adnn.c = false;
      this.jdField_a_of_type_Adnn.e = false;
      ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Adnm, this.jdField_a_of_type_Adnn);
      if (QLog.isColorLevel()) {
        QLog.d("chenlong", 2, "" + (System.currentTimeMillis() - l));
      }
      return;
      label130:
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {
        bdla.b(null, "CliOper", "", "", "Two_call", "Clk_3G_tips_btn", 0, 0, "1", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlr
 * JD-Core Version:    0.7.0.1
 */