import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;

class agtu
  implements aueo
{
  agtu(agtf paramagtf) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    paramView.putExtra("uinname", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
    bmij.a().a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView, "com.tencent.device.activities.DeviceGroupChatConfirmActivity", -1, null, SmartDevicePluginProxyActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtu
 * JD-Core Version:    0.7.0.1
 */