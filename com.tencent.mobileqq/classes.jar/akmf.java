import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.utils.WebStateReporter;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.WebViewClient;

public class akmf
  extends WebViewClient
{
  private akmf(AbsWebView paramAbsWebView) {}
  
  protected WebResourceResponse a(WebView paramWebView, String paramString)
  {
    WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).a();
    if (localWebViewPluginEngine == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doInterceptRequest url = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.startsWith("https://jsbridge/"))
      {
        paramWebView = paramString.replace("https://jsbridge/", "jsbridge://");
        label72:
        localWebView = paramWebView;
        if (QLog.isColorLevel()) {
          QLog.d("AbsWebView", 2, "doInterceptRequest  https://jsbridge/ temp url = " + paramWebView);
        }
      }
    }
    for (WebView localWebView = paramWebView;; localWebView = null)
    {
      if ((!TextUtils.isEmpty(localWebView)) && (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView != null))
      {
        this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.post(new akmg(this, localWebViewPluginEngine, localWebView));
        return new WebResourceResponse("text/html", "utf-8", null);
        if (!paramString.startsWith("http://jsbridge/")) {
          break label261;
        }
        paramWebView = paramString.replace("http://jsbridge/", "jsbridge://");
        break label72;
      }
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge")) && (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView != null)) {
        this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.post(new akmh(this, localWebViewPluginEngine, paramString));
      }
      try
      {
        paramWebView = (WebResourceResponse)localWebViewPluginEngine.a(paramString, 8L);
        return paramWebView;
      }
      catch (Exception paramWebView) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AbsWebView", 2, "shouldInterceptRequest got exception!", paramWebView);
      return null;
      label261:
      paramWebView = null;
      break label72;
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    QLog.i("AbsWebView", 1, "onDetectedBlankScreen, status: " + paramInt + ", url:" + paramString);
    this.b.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.a(this.b.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, paramInt);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "onPageFinished:" + paramString);
    }
    if (this.b.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) {
      this.b.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)2);
    }
    super.onPageFinished(paramWebView, paramString);
    this.b.b(paramWebView, paramString);
    paramWebView = ((CustomWebView)paramWebView).a();
    if (paramWebView != null) {
      paramWebView.a(paramString, 8589934594L, null);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "onPageStarted:" + paramString);
    }
    if (!"about:blank".equalsIgnoreCase(paramString)) {
      this.b.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.a(2);
    }
    if ((!this.b.h) && (this.b.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) && (this.b.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.b() != 0)) {
      this.b.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)0);
    }
    if (this.b.h)
    {
      this.b.h = false;
      this.b.c = System.currentTimeMillis();
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.b.a(paramWebView, paramString, paramBitmap);
    paramWebView = ((CustomWebView)paramWebView).a();
    if (paramWebView != null) {
      paramWebView.a(paramString, 8589934593L, null);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "onReceivedError:" + paramInt + ", desc=" + paramString1 + ", url=" + paramString2);
    }
    this.b.a(paramWebView, paramInt, paramString1, paramString2);
    paramWebView = ((CustomWebView)paramWebView).a();
    if (paramWebView != null) {
      paramWebView.a(paramString2, 8589934595L, paramInt);
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    SslCertificate localSslCertificate = paramSslError.getCertificate();
    String str = paramWebView.getUrl();
    paramSslError = new StringBuilder().append("onReceivedSslError:").append(paramSslError.getPrimaryError()).append(", cert=");
    if (localSslCertificate == null) {}
    for (paramWebView = "null";; paramWebView = localSslCertificate.toString())
    {
      QLog.w("AbsWebView", 1, paramWebView + ", pageUrl=" + Util.b(str, new String[0]));
      paramSslErrorHandler.cancel();
      return;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "shouldOverrideUrlLoading " + Util.b(paramString, new String[0]));
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      this.b.g = false;
      this.b.b = System.currentTimeMillis();
    }
    if ((TextUtils.isEmpty(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString))) {
      return true;
    }
    if (((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      CustomWebView.b(Util.b(paramString, new String[0]));
    }
    try
    {
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        localObject = paramWebView.getHitTestResult();
        if ((localObject != null) && (((WebView.HitTestResult)localObject).getType() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i("AbsWebView", 2, "shouldOverrideUrlLoading detect 302 url: " + paramString);
          }
          this.b.jdField_a_of_type_Long = System.currentTimeMillis();
          this.b.i = paramString;
          SwiftBrowserCookieMonster.d();
        }
      }
      Object localObject = ((CustomWebView)paramWebView).a();
      if ((localObject != null) && (((WebViewPluginEngine)localObject).a(paramString))) {
        return true;
      }
      if (this.b.a(paramWebView, paramString)) {
        return true;
      }
      if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        if ((localObject == null) || (!((WebViewPluginEngine)localObject).a(paramString, 16L, null))) {
          break label453;
        }
        return true;
      }
      if (paramString.startsWith("tnow://openpage/recordstory"))
      {
        paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramWebView.setFlags(268435456);
        this.b.e.startActivity(paramWebView);
      }
    }
    catch (RuntimeException paramWebView)
    {
      paramString = QLog.getStackTraceString(paramWebView);
      if (paramString.length() <= 255) {
        break label448;
      }
      for (paramWebView = paramString.substring(0, 255);; paramWebView = paramString)
      {
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("AbsWebView", 2, paramString);
        break;
      }
    }
    return true;
    label448:
    label453:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akmf
 * JD-Core Version:    0.7.0.1
 */