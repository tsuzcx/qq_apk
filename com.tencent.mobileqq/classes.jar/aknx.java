import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public class aknx
  extends aknz
{
  public aknx(WebViewWrapper paramWebViewWrapper)
  {
    super(paramWebViewWrapper);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aknx
 * JD-Core Version:    0.7.0.1
 */