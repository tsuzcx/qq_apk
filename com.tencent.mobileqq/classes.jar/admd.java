import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

final class admd
  implements DialogInterface.OnClickListener
{
  admd(QQAppInterface paramQQAppInterface, adnn paramadnn, long paramLong, Context paramContext, adnm paramadnm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_Adnn.jdField_a_of_type_Int, this.jdField_a_of_type_Adnn.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Adnn.jdField_c_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_Adnn.jdField_a_of_type_Boolean) {
      bdla.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Adnn.b = false;
    this.jdField_a_of_type_Adnn.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Adnn.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Adnm, this.jdField_a_of_type_Adnn);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admd
 * JD-Core Version:    0.7.0.1
 */