import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;

final class acvo
  implements DialogInterface.OnClickListener
{
  acvo(QQAppInterface paramQQAppInterface, acxb paramacxb, long paramLong, Context paramContext, acxa paramacxa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    awjw localawjw = (awjw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(66);
    if (localawjw != null) {
      localawjw.a((byte)0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNearbyProxy().a(true);
    if (this.jdField_a_of_type_Acxb.a) {
      bcef.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Acxb.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Acxa, this.jdField_a_of_type_Acxb);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvo
 * JD-Core Version:    0.7.0.1
 */