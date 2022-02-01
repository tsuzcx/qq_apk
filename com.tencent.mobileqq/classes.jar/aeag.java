import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

final class aeag
  implements DialogInterface.OnClickListener
{
  aeag(QQAppInterface paramQQAppInterface, aeca paramaeca, long paramLong, Context paramContext, aebz paramaebz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axwo localaxwo = (axwo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
    if (localaxwo != null) {
      localaxwo.a((byte)0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
    if (this.jdField_a_of_type_Aeca.a) {
      bdll.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Aeca.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aebz, this.jdField_a_of_type_Aeca);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeag
 * JD-Core Version:    0.7.0.1
 */