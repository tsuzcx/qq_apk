import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class alll
  implements Runnable
{
  public alll(BaseInterface paramBaseInterface, long paramLong, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    String str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('batchCallback',{guid:" + this.jdField_a_of_type_Long + ",'r':-2,'data':['" + this.jdField_a_of_type_JavaLangString + "']})};";
    LogUtility.e("Response<callBatch>", str);
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(str);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alll
 * JD-Core Version:    0.7.0.1
 */