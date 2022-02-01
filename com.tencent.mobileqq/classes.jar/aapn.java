import android.graphics.Bitmap;
import android.net.Uri;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public class aapn
  extends aaps
{
  public aapn(AbsBaseWebViewActivity paramAbsBaseWebViewActivity)
  {
    super(paramAbsBaseWebViewActivity, null);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return a(paramWebView, paramWebResourceRequest.getUrl().toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapn
 * JD-Core Version:    0.7.0.1
 */