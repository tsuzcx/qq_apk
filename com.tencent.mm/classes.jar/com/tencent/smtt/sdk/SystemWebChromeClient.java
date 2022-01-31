package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebStorage.QuotaUpdater;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SystemWebChromeClient
  extends android.webkit.WebChromeClient
{
  private WebView a;
  private WebChromeClient b;
  
  SystemWebChromeClient(WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    this.a = paramWebView;
    this.b = paramWebChromeClient;
  }
  
  @TargetApi(7)
  public Bitmap getDefaultVideoPoster()
  {
    AppMethodBeat.i(64171);
    Bitmap localBitmap1 = this.b.getDefaultVideoPoster();
    if (localBitmap1 == null) {
      try
      {
        if (Build.VERSION.SDK_INT >= 24)
        {
          Bitmap localBitmap2 = BitmapFactory.decodeResource(this.a.getResources(), 17301540);
          AppMethodBeat.o(64171);
          return localBitmap2;
        }
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(64171);
    return localBitmap1;
  }
  
  @TargetApi(7)
  public View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(64172);
    View localView = this.b.getVideoLoadingProgressView();
    AppMethodBeat.o(64172);
    return localView;
  }
  
  public void getVisitedHistory(ValueCallback<String[]> paramValueCallback)
  {
    AppMethodBeat.i(64173);
    this.b.getVisitedHistory(new z(this, paramValueCallback));
    AppMethodBeat.o(64173);
  }
  
  public void onCloseWindow(android.webkit.WebView paramWebView)
  {
    AppMethodBeat.i(64174);
    this.a.a(paramWebView);
    this.b.onCloseWindow(this.a);
    AppMethodBeat.o(64174);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(64176);
    this.b.onConsoleMessage(new SystemWebChromeClient.a(paramString1, paramString2, paramInt));
    AppMethodBeat.o(64176);
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(64175);
    boolean bool = this.b.onConsoleMessage(new SystemWebChromeClient.a(paramConsoleMessage));
    AppMethodBeat.o(64175);
    return bool;
  }
  
  public boolean onCreateWindow(android.webkit.WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    AppMethodBeat.i(64177);
    paramWebView = this.a;
    paramWebView.getClass();
    paramWebView = new WebView.WebViewTransport(paramWebView);
    paramMessage = Message.obtain(paramMessage.getTarget(), new aa(this, paramWebView, paramMessage));
    paramMessage.obj = paramWebView;
    paramBoolean1 = this.b.onCreateWindow(this.a, paramBoolean1, paramBoolean2, paramMessage);
    AppMethodBeat.o(64177);
    return paramBoolean1;
  }
  
  @Deprecated
  @TargetApi(5)
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(64178);
    this.b.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new SystemWebChromeClient.f(this, paramQuotaUpdater));
    AppMethodBeat.o(64178);
  }
  
  @TargetApi(5)
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(64179);
    this.b.onGeolocationPermissionsHidePrompt();
    AppMethodBeat.o(64179);
  }
  
  @TargetApi(5)
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(64180);
    this.b.onGeolocationPermissionsShowPrompt(paramString, new SystemWebChromeClient.c(this, paramCallback));
    AppMethodBeat.o(64180);
  }
  
  @TargetApi(7)
  public void onHideCustomView()
  {
    AppMethodBeat.i(64181);
    this.b.onHideCustomView();
    AppMethodBeat.o(64181);
  }
  
  public boolean onJsAlert(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(64182);
    this.a.a(paramWebView);
    boolean bool = this.b.onJsAlert(this.a, paramString1, paramString2, new SystemWebChromeClient.e(this, paramJsResult));
    AppMethodBeat.o(64182);
    return bool;
  }
  
  public boolean onJsBeforeUnload(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(64183);
    this.a.a(paramWebView);
    boolean bool = this.b.onJsBeforeUnload(this.a, paramString1, paramString2, new SystemWebChromeClient.e(this, paramJsResult));
    AppMethodBeat.o(64183);
    return bool;
  }
  
  public boolean onJsConfirm(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(64184);
    this.a.a(paramWebView);
    boolean bool = this.b.onJsConfirm(this.a, paramString1, paramString2, new SystemWebChromeClient.e(this, paramJsResult));
    AppMethodBeat.o(64184);
    return bool;
  }
  
  public boolean onJsPrompt(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(64185);
    this.a.a(paramWebView);
    boolean bool = this.b.onJsPrompt(this.a, paramString1, paramString2, paramString3, new SystemWebChromeClient.d(this, paramJsPromptResult));
    AppMethodBeat.o(64185);
    return bool;
  }
  
  @TargetApi(7)
  public boolean onJsTimeout()
  {
    AppMethodBeat.i(64186);
    boolean bool = this.b.onJsTimeout();
    AppMethodBeat.o(64186);
    return bool;
  }
  
  public void onProgressChanged(android.webkit.WebView paramWebView, int paramInt)
  {
    AppMethodBeat.i(64187);
    this.a.a(paramWebView);
    this.b.onProgressChanged(this.a, paramInt);
    AppMethodBeat.o(64187);
  }
  
  @Deprecated
  @TargetApi(7)
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(64188);
    this.b.onReachedMaxAppCacheSize(paramLong1, paramLong2, new SystemWebChromeClient.f(this, paramQuotaUpdater));
    AppMethodBeat.o(64188);
  }
  
  public void onReceivedIcon(android.webkit.WebView paramWebView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(64189);
    this.a.a(paramWebView);
    this.b.onReceivedIcon(this.a, paramBitmap);
    AppMethodBeat.o(64189);
  }
  
  public void onReceivedTitle(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(64190);
    this.a.a(paramWebView);
    this.b.onReceivedTitle(this.a, paramString);
    AppMethodBeat.o(64190);
  }
  
  @TargetApi(7)
  public void onReceivedTouchIconUrl(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(64191);
    this.a.a(paramWebView);
    this.b.onReceivedTouchIconUrl(this.a, paramString, paramBoolean);
    AppMethodBeat.o(64191);
  }
  
  public void onRequestFocus(android.webkit.WebView paramWebView)
  {
    AppMethodBeat.i(64192);
    this.a.a(paramWebView);
    this.b.onRequestFocus(this.a);
    AppMethodBeat.o(64192);
  }
  
  @Deprecated
  @TargetApi(14)
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(64194);
    this.b.onShowCustomView(paramView, paramInt, new SystemWebChromeClient.b(this, paramCustomViewCallback));
    AppMethodBeat.o(64194);
  }
  
  @TargetApi(7)
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(64193);
    this.b.onShowCustomView(paramView, new SystemWebChromeClient.b(this, paramCustomViewCallback));
    AppMethodBeat.o(64193);
  }
  
  public boolean onShowFileChooser(android.webkit.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    AppMethodBeat.i(64198);
    paramValueCallback = new ac(this, paramValueCallback);
    paramFileChooserParams = new ad(this, paramFileChooserParams);
    this.a.a(paramWebView);
    boolean bool = this.b.onShowFileChooser(this.a, paramValueCallback, paramFileChooserParams);
    AppMethodBeat.o(64198);
    return bool;
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback)
  {
    AppMethodBeat.i(64195);
    openFileChooser(paramValueCallback, null, null);
    AppMethodBeat.o(64195);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
  {
    AppMethodBeat.i(64196);
    openFileChooser(paramValueCallback, paramString, null);
    AppMethodBeat.o(64196);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(64197);
    this.b.openFileChooser(new ab(this, paramValueCallback), paramString1, paramString2);
    AppMethodBeat.o(64197);
  }
  
  public void setupAutoFill(Message paramMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient
 * JD-Core Version:    0.7.0.1
 */