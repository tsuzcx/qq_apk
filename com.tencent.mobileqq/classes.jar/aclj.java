import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class aclj
  implements DialogInterface.OnClickListener
{
  public aclj(QQAppInterface paramQQAppInterface, aclo paramaclo, long paramLong, Context paramContext, acln paramacln) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_Aclo.jdField_a_of_type_Int, this.jdField_a_of_type_Aclo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aclo.jdField_c_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_Aclo.jdField_a_of_type_Boolean) {
      azqs.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Aclo.b = false;
    this.jdField_a_of_type_Aclo.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Aclo.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Acln, this.jdField_a_of_type_Aclo);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclj
 * JD-Core Version:    0.7.0.1
 */