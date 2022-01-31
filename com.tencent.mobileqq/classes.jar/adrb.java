import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class adrb
  implements DialogInterface.OnClickListener
{
  adrb(adqz paramadqz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bbfj.g(this.a.a.jdField_a_of_type_AndroidContentContext)) {
      bdis.a().a(2131691557);
    }
    do
    {
      return;
      paramDialogInterface = (yah)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      paramDialogInterface.a(Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), 0, 1, 0);
      paramDialogInterface = paramDialogInterface.a(Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
    } while (paramDialogInterface == null);
    ymt.a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), "Usr_AIO_Menu", 5, 0, paramDialogInterface.productId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrb
 * JD-Core Version:    0.7.0.1
 */