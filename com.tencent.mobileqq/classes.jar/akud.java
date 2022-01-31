import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.sonic.SonicJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicDiffDataCallback;

public class akud
  implements SonicDiffDataCallback
{
  public akud(SonicJsPlugin paramSonicJsPlugin, CustomWebView paramCustomWebView, String paramString) {}
  
  public void callback(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SonicSdkImpl_SonicJsPlugin", 2, "getDiffData callback updated data: " + paramString.toString());
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.jdField_a_of_type_JavaLangString, new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akud
 * JD-Core Version:    0.7.0.1
 */