import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.sonic.SonicJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicDiffDataCallback;
import org.json.JSONObject;

public class akmn
  implements SonicDiffDataCallback
{
  public akmn(SonicJsPlugin paramSonicJsPlugin, boolean paramBoolean, CustomWebView paramCustomWebView, String paramString) {}
  
  public void callback(String paramString)
  {
    str = "";
    try
    {
      paramString = new JSONObject(paramString);
      if (!this.jdField_a_of_type_Boolean) {
        paramString.remove("result");
      }
      paramString = paramString.toString();
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("SonicSdkImpl_SonicJsPlugin", 1, "reloadHttpData error!", paramString);
        paramString = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SonicSdkImpl_SonicJsPlugin", 2, "reloadHttpData , notify data: " + paramString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.jdField_a_of_type_JavaLangString, new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akmn
 * JD-Core Version:    0.7.0.1
 */