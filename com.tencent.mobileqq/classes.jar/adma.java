import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

final class adma
  implements DialogInterface.OnClickListener
{
  adma(QQAppInterface paramQQAppInterface, adnn paramadnn, long paramLong, Context paramContext, adnm paramadnm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axpy localaxpy = (axpy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER);
    if (localaxpy != null) {
      localaxpy.a((byte)0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNearbyProxy().a(true);
    if (this.jdField_a_of_type_Adnn.a) {
      bdla.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_Adnn.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Adnm, this.jdField_a_of_type_Adnn);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adma
 * JD-Core Version:    0.7.0.1
 */