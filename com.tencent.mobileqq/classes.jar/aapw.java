import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class aapw
  implements DialogInterface.OnClickListener
{
  public aapw(QQAppInterface paramQQAppInterface, aaqb paramaaqb, long paramLong, Context paramContext, aaqa paramaaqa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, this.jdField_a_of_type_Aaqb.jdField_a_of_type_Int, this.jdField_a_of_type_Aaqb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aaqb.jdField_c_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_Aaqb.jdField_a_of_type_Boolean) {
      axqy.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Aaqb.b = false;
    this.jdField_a_of_type_Aaqb.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Aaqb.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aaqa, this.jdField_a_of_type_Aaqb);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aapw
 * JD-Core Version:    0.7.0.1
 */