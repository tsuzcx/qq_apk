import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

final class acvr
  implements DialogInterface.OnClickListener
{
  acvr(QQAppInterface paramQQAppInterface, acxb paramacxb, long paramLong, Context paramContext, acxa paramacxa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_Acxb.jdField_a_of_type_Int, this.jdField_a_of_type_Acxb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Acxb.jdField_c_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_Acxb.jdField_a_of_type_Boolean) {
      bcef.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Acxb.b = false;
    this.jdField_a_of_type_Acxb.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Acxb.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Acxa, this.jdField_a_of_type_Acxb);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvr
 * JD-Core Version:    0.7.0.1
 */