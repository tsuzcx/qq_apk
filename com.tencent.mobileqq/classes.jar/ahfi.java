import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class ahfi
  implements DialogInterface.OnClickListener
{
  ahfi(ahfg paramahfg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bhnv.g(this.a.a.jdField_a_of_type_AndroidContentContext)) {
      bjuh.a().a(2131691366);
    }
    do
    {
      return;
      paramDialogInterface = (abur)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      paramDialogInterface.a(Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, 1, 0);
      paramDialogInterface = paramDialogInterface.a(Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
    } while (paramDialogInterface == null);
    achd.a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), "Usr_AIO_Menu", 5, 0, paramDialogInterface.productId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfi
 * JD-Core Version:    0.7.0.1
 */