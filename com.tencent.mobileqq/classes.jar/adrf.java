import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

final class adrf
  implements DialogInterface.OnClickListener
{
  adrf(QQAppInterface paramQQAppInterface, adsy paramadsy, long paramLong, Context paramContext, adsx paramadsx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axdv localaxdv = (axdv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
    if (localaxdv != null) {
      localaxdv.a((byte)0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
    if (this.jdField_a_of_type_Adsy.a) {
      bcst.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Adsy.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Adsx, this.jdField_a_of_type_Adsy);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrf
 * JD-Core Version:    0.7.0.1
 */