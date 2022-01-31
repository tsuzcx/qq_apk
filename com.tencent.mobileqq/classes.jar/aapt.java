import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.qphone.base.util.QLog;

public class aapt
  implements Runnable
{
  public aapt(ArkAppModuleReg.ModuleQQ paramModuleQQ, ArkAppMessage paramArkAppMessage) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof FragmentActivity))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 27);
      localBundle.putString("forward_ark_app_name", this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appName);
      localBundle.putString("forward_ark_app_view", this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appView);
      localBundle.putString("forward_ark_app_ver", this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appMinVersion);
      localBundle.putString("forward_ark_app_prompt", this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.promptText);
      localBundle.putString("forward_ark_app_config", this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.config);
      localBundle.putString("forward_ark_app_desc", this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appDesc);
      localBundle.putString("forward_ark_app_compat", this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.compatibleText);
      localBundle.putString("forward_ark_app_meta", this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.metaList);
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      ForwardBaseOption.a(localBaseActivity, localIntent, 21);
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 1, "QQ.SendMessage light success.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapt
 * JD-Core Version:    0.7.0.1
 */