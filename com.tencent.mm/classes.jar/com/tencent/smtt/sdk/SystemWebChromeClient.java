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
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;

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
    Bitmap localBitmap2 = this.b.getDefaultVideoPoster();
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = localBitmap2;
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 24) {
        localBitmap1 = BitmapFactory.decodeResource(this.a.getResources(), 17301540);
      }
      return localBitmap1;
    }
    catch (Exception localException) {}
    return localBitmap2;
  }
  
  @TargetApi(7)
  public View getVideoLoadingProgressView()
  {
    return this.b.getVideoLoadingProgressView();
  }
  
  public void getVisitedHistory(ValueCallback<String[]> paramValueCallback)
  {
    this.b.getVisitedHistory(new y(this, paramValueCallback));
  }
  
  public void onCloseWindow(android.webkit.WebView paramWebView)
  {
    this.a.a(paramWebView);
    this.b.onCloseWindow(this.a);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    this.b.onConsoleMessage(new SystemWebChromeClient.a(paramString1, paramString2, paramInt));
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return this.b.onConsoleMessage(new SystemWebChromeClient.a(paramConsoleMessage));
  }
  
  public boolean onCreateWindow(android.webkit.WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    paramWebView = this.a;
    paramWebView.getClass();
    paramWebView = new WebView.WebViewTransport(paramWebView);
    paramMessage = Message.obtain(paramMessage.getTarget(), new z(this, paramWebView, paramMessage));
    paramMessage.obj = paramWebView;
    return this.b.onCreateWindow(this.a, paramBoolean1, paramBoolean2, paramMessage);
  }
  
  @Deprecated
  @TargetApi(5)
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    this.b.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new SystemWebChromeClient.f(this, paramQuotaUpdater));
  }
  
  @TargetApi(5)
  public void onGeolocationPermissionsHidePrompt()
  {
    this.b.onGeolocationPermissionsHidePrompt();
  }
  
  @TargetApi(5)
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    this.b.onGeolocationPermissionsShowPrompt(paramString, new SystemWebChromeClient.c(this, paramCallback));
  }
  
  @TargetApi(7)
  public void onHideCustomView()
  {
    this.b.onHideCustomView();
  }
  
  public boolean onJsAlert(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.a.a(paramWebView);
    return this.b.onJsAlert(this.a, paramString1, paramString2, new SystemWebChromeClient.e(this, paramJsResult));
  }
  
  public boolean onJsBeforeUnload(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.a.a(paramWebView);
    return this.b.onJsBeforeUnload(this.a, paramString1, paramString2, new SystemWebChromeClient.e(this, paramJsResult));
  }
  
  public boolean onJsConfirm(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    this.a.a(paramWebView);
    return this.b.onJsConfirm(this.a, paramString1, paramString2, new SystemWebChromeClient.e(this, paramJsResult));
  }
  
  public boolean onJsPrompt(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    this.a.a(paramWebView);
    return this.b.onJsPrompt(this.a, paramString1, paramString2, paramString3, new SystemWebChromeClient.d(this, paramJsPromptResult));
  }
  
  @TargetApi(7)
  public boolean onJsTimeout()
  {
    return this.b.onJsTimeout();
  }
  
  public void onProgressChanged(android.webkit.WebView paramWebView, int paramInt)
  {
    this.a.a(paramWebView);
    this.b.onProgressChanged(this.a, paramInt);
  }
  
  @Deprecated
  @TargetApi(7)
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    this.b.onReachedMaxAppCacheSize(paramLong1, paramLong2, new SystemWebChromeClient.f(this, paramQuotaUpdater));
  }
  
  public void onReceivedIcon(android.webkit.WebView paramWebView, Bitmap paramBitmap)
  {
    this.a.a(paramWebView);
    this.b.onReceivedIcon(this.a, paramBitmap);
  }
  
  public void onReceivedTitle(android.webkit.WebView paramWebView, String paramString)
  {
    this.a.a(paramWebView);
    this.b.onReceivedTitle(this.a, paramString);
  }
  
  @TargetApi(7)
  public void onReceivedTouchIconUrl(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    this.a.a(paramWebView);
    this.b.onReceivedTouchIconUrl(this.a, paramString, paramBoolean);
  }
  
  public void onRequestFocus(android.webkit.WebView paramWebView)
  {
    this.a.a(paramWebView);
    this.b.onRequestFocus(this.a);
  }
  
  @Deprecated
  @TargetApi(14)
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.b.onShowCustomView(paramView, paramInt, new b(paramCustomViewCallback));
  }
  
  @TargetApi(7)
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.b.onShowCustomView(paramView, new b(paramCustomViewCallback));
  }
  
  public boolean onShowFileChooser(android.webkit.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    paramValueCallback = new ab(this, paramValueCallback);
    paramFileChooserParams = new ac(this, paramFileChooserParams);
    this.a.a(paramWebView);
    return this.b.onShowFileChooser(this.a, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback)
  {
    openFileChooser(paramValueCallback, null, null);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
  {
    openFileChooser(paramValueCallback, paramString, null);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    this.b.openFileChooser(new aa(this, paramValueCallback), paramString1, paramString2);
  }
  
  public void setupAutoFill(Message paramMessage) {}
  
  class b
    implements IX5WebChromeClient.CustomViewCallback
  {
    WebChromeClient.CustomViewCallback a;
    
    b(WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      this.a = paramCustomViewCallback;
    }
    
    public void onCustomViewHidden()
    {
      this.a.onCustomViewHidden();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient
 * JD-Core Version:    0.7.0.1
 */