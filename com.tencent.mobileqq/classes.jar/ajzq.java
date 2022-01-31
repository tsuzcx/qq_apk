import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public class ajzq
  extends ajzs
{
  public ajzq(WebViewWrapper paramWebViewWrapper)
  {
    super(paramWebViewWrapper);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajzq
 * JD-Core Version:    0.7.0.1
 */