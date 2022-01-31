import com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class almg
  implements Runnable
{
  public almg(OpenJsBridge.OpenJsBridgeListener paramOpenJsBridgeListener, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    LogUtility.b("Response", "AsyncInterface_end:javascript:window.JsBridge&&JsBridge.callback('interface." + this.jdField_a_of_type_JavaLangString + "',{guid:" + this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge$OpenJsBridgeListener.b + ",'r':-2,'data':'no such method'});");
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('interface." + this.jdField_a_of_type_JavaLangString + "',{guid:" + this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge$OpenJsBridgeListener.b + ",'r':-2,'data':'no such method'});");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     almg
 * JD-Core Version:    0.7.0.1
 */