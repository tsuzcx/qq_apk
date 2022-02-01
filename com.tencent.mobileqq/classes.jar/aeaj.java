import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

final class aeaj
  implements DialogInterface.OnClickListener
{
  aeaj(QQAppInterface paramQQAppInterface, aeca paramaeca, long paramLong, Context paramContext, aebz paramaebz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_Aeca.jdField_a_of_type_Int, this.jdField_a_of_type_Aeca.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aeca.jdField_c_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_Aeca.jdField_a_of_type_Boolean) {
      bdll.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Aeca.b = false;
    this.jdField_a_of_type_Aeca.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Aeca.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aebz, this.jdField_a_of_type_Aeca);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeaj
 * JD-Core Version:    0.7.0.1
 */