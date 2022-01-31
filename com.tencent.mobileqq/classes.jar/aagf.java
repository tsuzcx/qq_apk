import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public final class aagf
  implements DialogInterface.OnClickListener
{
  public aagf(QQAppInterface paramQQAppInterface, aagn paramaagn, long paramLong, Context paramContext, aagm paramaagm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    asey localasey = (asey)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
    if (localasey != null) {
      localasey.a((byte)0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
    if (this.jdField_a_of_type_Aagn.a) {
      awqx.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Aagn.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aagm, this.jdField_a_of_type_Aagn);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aagf
 * JD-Core Version:    0.7.0.1
 */