import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.filemanager.app.UniformDownload;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.DownloadListener;

public class akvl
  implements DownloadListener
{
  public akvl(WebViewWrapper paramWebViewWrapper, TouchWebView paramTouchWebView, boolean paramBoolean, Activity paramActivity) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, "start UniformDownloadActivity");
    }
    String str = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
    Bundle localBundle = new Bundle();
    localBundle.putLong("_filesize", paramLong);
    localBundle.putString("param_user_agent", paramString2);
    localBundle.putString("param_content_des", paramString3);
    localBundle.putString("param_mime_type", paramString4);
    localBundle.putString("param_refer_url", str);
    localBundle.putBoolean("fromArkAppDownload", this.jdField_a_of_type_Boolean);
    UniformDownload.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akvl
 * JD-Core Version:    0.7.0.1
 */