import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import org.json.JSONObject;

public class adyb
  implements Runnable
{
  public adyb(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.i = this.jdField_a_of_type_OrgJsonJSONObject.optString("callback");
    ScreenShotUtil.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a(), new adyc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyb
 * JD-Core Version:    0.7.0.1
 */