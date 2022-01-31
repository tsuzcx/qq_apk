import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.troop.NearbyVideoChatProxyActivity;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

class aemc
  implements TroopMemberApiClient.Callback
{
  aemc(aemb paramaemb, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("isOtherTypeChatting", false))
    {
      paramBundle = DialogUtil.a(this.jdField_a_of_type_Aemb.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), 230);
      paramBundle.setMessage(this.jdField_a_of_type_Aemb.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a().getString(2131428992));
      paramBundle.setNegativeButton("确定", new aemd(this));
      paramBundle.show();
      return;
    }
    TroopMemberApiClient.a();
    paramBundle = new oidb_0x8dd.SelfInfo();
    paramBundle.uint32_gender.set(this.jdField_a_of_type_Aemb.jdField_a_of_type_Int);
    paramBundle.uint32_charm_level.set(this.jdField_a_of_type_Aemb.b);
    paramBundle.uint32_age.set(this.jdField_a_of_type_Aemb.c);
    NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_Aemb.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), this.jdField_a_of_type_Aemb.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface.mRuntime.a(), null, this.jdField_a_of_type_JavaLangString, paramBundle, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aemc
 * JD-Core Version:    0.7.0.1
 */