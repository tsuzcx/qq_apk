import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import org.json.JSONObject;

public class adoa
  implements Runnable
{
  public adoa(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.i = this.jdField_a_of_type_OrgJsonJSONObject.optString("callback");
    ScreenShotUtil.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a(), new adob(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adoa
 * JD-Core Version:    0.7.0.1
 */