import android.text.TextUtils;
import com.tencent.open.wadl.WLog;
import com.tencent.open.wadl.WadlJsBridge;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class aljo
  implements Runnable
{
  public aljo(WadlJsBridge paramWadlJsBridge, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridge.getWebview() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          WLog.b("WadlJsBridge", "##@WadlJavaScript:" + this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridge.getWebview().loadUrl(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      WLog.a("WadlJsBridge", "webview loadUrl jsCallBack()>>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aljo
 * JD-Core Version:    0.7.0.1
 */