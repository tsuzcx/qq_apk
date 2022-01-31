import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import cooperation.troop.TroopManageProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class aegg
  implements TroopMemberApiClient.Callback
{
  public aegg(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    int i = 12;
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("isSuccess"))
      {
        paramBundle = new Intent();
        paramBundle.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a() != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a().a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin, (byte)12);
        }
        TroopManageProxyActivity.a("troop_manage_plugin.apk", "管理群", TroopManageProxyActivity.class, this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a(), paramBundle, TroopManageProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a()), "com.tencent.mobileqq.activity.TroopSetJoinTypeActivity", this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a().getAccount(), i);
      }
    }
    else {
      return;
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("gc", this.jdField_a_of_type_JavaLangString);
      paramBundle.put("ret", 1);
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.m, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegg
 * JD-Core Version:    0.7.0.1
 */