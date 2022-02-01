import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.DownloadListener;

public class abds
  implements DownloadListener
{
  public abds(AbsBaseWebViewActivity paramAbsBaseWebViewActivity, TouchWebView paramTouchWebView) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "start UniformDownloadActivity");
    }
    String str = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
    Bundle localBundle = new Bundle();
    localBundle.putLong("_filesize", paramLong);
    localBundle.putString("param_user_agent", paramString2);
    localBundle.putString("param_content_des", paramString3);
    localBundle.putString("param_mime_type", paramString4);
    localBundle.putString("param_refer_url", str);
    auqy.a(this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity, paramString1, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abds
 * JD-Core Version:    0.7.0.1
 */