import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class aapt
  implements DialogInterface.OnClickListener
{
  public aapt(QQAppInterface paramQQAppInterface, aaqb paramaaqb, long paramLong, Context paramContext, aaqa paramaaqa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    atbe localatbe = (atbe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
    if (localatbe != null) {
      localatbe.a((byte)0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
    if (this.jdField_a_of_type_Aaqb.a) {
      axqy.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Aaqb.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aaqa, this.jdField_a_of_type_Aaqb);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aapt
 * JD-Core Version:    0.7.0.1
 */