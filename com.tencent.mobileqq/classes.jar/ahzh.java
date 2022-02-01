import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;

class ahzh
  implements View.OnClickListener
{
  ahzh(ahzf paramahzf) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(anhk.y)) {
      if (this.a.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
        this.a.I();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtra("nickname", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
      ((Intent)localObject1).putExtra("bitmap", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2, false));
      Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).getString("square_url_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((Intent)localObject1).putExtra("url", (String)localObject2);
      }
      for (;;)
      {
        bmqo.a().a(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, "com.tencent.device.activities.DeviceSquareActivity", 0, null, SmartDevicePluginProxyActivity.class);
        break;
        ((Intent)localObject1).putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
      }
      localObject1 = (abqn)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      localObject2 = ((abqn)localObject1).a(Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
      if (this.a.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        if (ahzf.a(this.a)) {
          ((abqn)localObject1).a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (DeviceInfo)localObject2, false);
        }
        this.a.I();
      }
      else
      {
        ((abqn)localObject1).a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (DeviceInfo)localObject2, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzh
 * JD-Core Version:    0.7.0.1
 */