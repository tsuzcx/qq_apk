import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;

class aguk
  implements DialogInterface.OnClickListener
{
  aguk(agui paramagui) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a.a.jdField_a_of_type_AndroidContentContext)) {
      bjkv.a().a(2131691491);
    }
    do
    {
      return;
      paramDialogInterface = (abgm)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      paramDialogInterface.a(Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin), 0, 1, 0);
      paramDialogInterface = paramDialogInterface.a(Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin));
    } while (paramDialogInterface == null);
    absy.a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin), "Usr_AIO_Menu", 5, 0, paramDialogInterface.productId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguk
 * JD-Core Version:    0.7.0.1
 */