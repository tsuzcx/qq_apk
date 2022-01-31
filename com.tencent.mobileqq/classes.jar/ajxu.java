import android.net.Uri;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public class ajxu
  extends ajxy
{
  public ajxu(AbsWebView paramAbsWebView)
  {
    super(paramAbsWebView, null);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "new shouldInterceptRequest");
    }
    return a(paramWebView, paramWebResourceRequest.getUrl().toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajxu
 * JD-Core Version:    0.7.0.1
 */