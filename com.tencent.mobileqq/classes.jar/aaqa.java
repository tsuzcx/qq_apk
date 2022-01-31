import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class aaqa
  implements DialogInterface.OnClickListener
{
  public aaqa(QQAppInterface paramQQAppInterface, aaqf paramaaqf, long paramLong, Context paramContext, aaqe paramaaqe) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_Aaqf.jdField_a_of_type_Int, this.jdField_a_of_type_Aaqf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaqf.jdField_c_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_Aaqf.jdField_a_of_type_Boolean) {
      axqw.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Aaqf.b = false;
    this.jdField_a_of_type_Aaqf.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Aaqf.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aaqe, this.jdField_a_of_type_Aaqf);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaqa
 * JD-Core Version:    0.7.0.1
 */