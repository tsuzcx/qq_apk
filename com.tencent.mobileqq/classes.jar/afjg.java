import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class afjg
  implements DialogInterface.OnClickListener
{
  afjg(afje paramafje) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bdee.g(this.a.a.jdField_a_of_type_AndroidContentContext)) {
      bfhq.a().a(2131691612);
    }
    do
    {
      return;
      paramDialogInterface = (zpa)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      paramDialogInterface.a(Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, 1, 0);
      paramDialogInterface = paramDialogInterface.a(Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
    } while (paramDialogInterface == null);
    aabm.a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), "Usr_AIO_Menu", 5, 0, paramDialogInterface.productId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjg
 * JD-Core Version:    0.7.0.1
 */