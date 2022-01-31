import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class acgu
  implements DialogInterface.OnClickListener
{
  public acgu(QQAppInterface paramQQAppInterface, acgz paramacgz, long paramLong, Context paramContext, acgy paramacgy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_Acgz.jdField_a_of_type_Int, this.jdField_a_of_type_Acgz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Acgz.jdField_c_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_Acgz.jdField_a_of_type_Boolean) {
      azmj.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Acgz.b = false;
    this.jdField_a_of_type_Acgz.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Acgz.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Acgy, this.jdField_a_of_type_Acgz);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgu
 * JD-Core Version:    0.7.0.1
 */