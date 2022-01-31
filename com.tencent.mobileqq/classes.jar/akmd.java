import android.annotation.SuppressLint;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;

public class akmd
  extends CustomWebChromeClient
{
  public akmd(AbsWebView paramAbsWebView) {}
  
  private void a(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "show custom view called");
    }
    this.a.a(paramView, paramInt, paramCustomViewCallback);
  }
  
  public View getVideoLoadingProgressView()
  {
    return this.a.c();
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "onGeolocationPermissionsShowPrompt:" + paramString);
    }
    this.a.a(paramString, paramGeolocationPermissionsCallback);
  }
  
  public void onHideCustomView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "hide custom view called");
    }
    this.a.A();
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.a.a(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "onProgressChanged:" + paramInt);
    }
    if ((this.a.a != null) && (this.a.a.b() == 0)) {
      this.a.a.a((byte)1);
    }
    if (paramInt == 100) {
      this.a.d(false);
    }
    this.a.a(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.a.a(paramWebView, paramString);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, paramInt, paramCustomViewCallback);
  }
  
  @SuppressLint({"InlinedApi"})
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, 10, paramCustomViewCallback);
  }
  
  public void openFileChooser(ValueCallback paramValueCallback, String paramString1, String paramString2)
  {
    this.a.a(paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akmd
 * JD-Core Version:    0.7.0.1
 */