import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public class ajxv
  extends ajxy
{
  public ajxv(AbsWebView paramAbsWebView)
  {
    super(paramAbsWebView, null);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "old shouldInterceptRequest");
    }
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajxv
 * JD-Core Version:    0.7.0.1
 */