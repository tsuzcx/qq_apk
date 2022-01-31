import com.tencent.open.wadl.WLog;
import com.tencent.open.wadl.WadlJsBridgeCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class akuc
  implements Runnable
{
  public akuc(WadlJsBridgeCallBack paramWadlJsBridgeCallBack, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        WLog.b(WadlJsBridgeCallBack.jdField_a_of_type_JavaLangString, "doJsCallback call:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      WLog.a(WadlJsBridgeCallBack.jdField_a_of_type_JavaLangString, "doJsCallback exception ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akuc
 * JD-Core Version:    0.7.0.1
 */