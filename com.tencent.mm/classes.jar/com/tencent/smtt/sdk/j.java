package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.WebViewTransport;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;

class j
  extends X5ProxyWebChromeClient
{
  private WebView a;
  private WebChromeClient b;
  
  public j(IX5WebChromeClient paramIX5WebChromeClient, WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    super(paramIX5WebChromeClient);
    this.a = paramWebView;
    this.b = paramWebChromeClient;
  }
  
  public Bitmap getDefaultVideoPoster()
  {
    AppMethodBeat.i(188043);
    Bitmap localBitmap = this.b.getDefaultVideoPoster();
    AppMethodBeat.o(188043);
    return localBitmap;
  }
  
  public void getVisitedHistory(ValueCallback<String[]> paramValueCallback) {}
  
  public void onCloseWindow(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(188044);
    this.a.a(paramIX5WebViewBase);
    this.b.onCloseWindow(this.a);
    AppMethodBeat.o(188044);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(188045);
    boolean bool = this.b.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(188045);
    return bool;
  }
  
  public boolean onCreateWindow(final IX5WebViewBase paramIX5WebViewBase, boolean paramBoolean1, boolean paramBoolean2, final Message paramMessage)
  {
    AppMethodBeat.i(188046);
    paramIX5WebViewBase = this.a;
    paramIX5WebViewBase.getClass();
    paramIX5WebViewBase = new WebView.WebViewTransport(paramIX5WebViewBase);
    paramMessage = Message.obtain(paramMessage.getTarget(), new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(188388);
        WebView localWebView = paramIX5WebViewBase.getWebView();
        if (localWebView != null) {
          ((IX5WebViewBase.WebViewTransport)paramMessage.obj).setWebView(localWebView.c());
        }
        paramMessage.sendToTarget();
        AppMethodBeat.o(188388);
      }
    });
    paramMessage.obj = paramIX5WebViewBase;
    paramBoolean1 = this.b.onCreateWindow(this.a, paramBoolean1, paramBoolean2, paramMessage);
    AppMethodBeat.o(188046);
    return paramBoolean1;
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(188042);
    this.b.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new a(paramQuotaUpdater));
    AppMethodBeat.o(188042);
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(188047);
    this.b.onGeolocationPermissionsHidePrompt();
    AppMethodBeat.o(188047);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    AppMethodBeat.i(188048);
    this.b.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    AppMethodBeat.o(188048);
  }
  
  public void onHideCustomView()
  {
    AppMethodBeat.i(188049);
    this.b.onHideCustomView();
    AppMethodBeat.o(188049);
  }
  
  public boolean onJsAlert(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(188050);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsAlert(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(188050);
    return bool;
  }
  
  public boolean onJsBeforeUnload(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(188053);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsBeforeUnload(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(188053);
    return bool;
  }
  
  public boolean onJsConfirm(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(188051);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsConfirm(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(188051);
    return bool;
  }
  
  public boolean onJsPrompt(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(188052);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsPrompt(this.a, paramString1, paramString2, paramString3, paramJsPromptResult);
    AppMethodBeat.o(188052);
    return bool;
  }
  
  public boolean onJsTimeout()
  {
    AppMethodBeat.i(188054);
    boolean bool = this.b.onJsTimeout();
    AppMethodBeat.o(188054);
    return bool;
  }
  
  public void onProgressChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt)
  {
    AppMethodBeat.i(188055);
    this.a.a(paramIX5WebViewBase);
    this.b.onProgressChanged(this.a, paramInt);
    AppMethodBeat.o(188055);
  }
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(188056);
    this.b.onReachedMaxAppCacheSize(paramLong1, paramLong2, new a(paramQuotaUpdater));
    AppMethodBeat.o(188056);
  }
  
  public void onReceivedIcon(IX5WebViewBase paramIX5WebViewBase, Bitmap paramBitmap)
  {
    AppMethodBeat.i(188057);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedIcon(this.a, paramBitmap);
    AppMethodBeat.o(188057);
  }
  
  public void onReceivedTitle(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(188059);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedTitle(this.a, paramString);
    AppMethodBeat.o(188059);
  }
  
  public void onReceivedTouchIconUrl(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(188058);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedTouchIconUrl(this.a, paramString, paramBoolean);
    AppMethodBeat.o(188058);
  }
  
  public void onRequestFocus(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(188060);
    this.a.a(paramIX5WebViewBase);
    this.b.onRequestFocus(this.a);
    AppMethodBeat.o(188060);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(188062);
    this.b.onShowCustomView(paramView, paramInt, paramCustomViewCallback);
    AppMethodBeat.o(188062);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(188061);
    this.b.onShowCustomView(paramView, paramCustomViewCallback);
    AppMethodBeat.o(188061);
  }
  
  public boolean onShowFileChooser(IX5WebViewBase paramIX5WebViewBase, ValueCallback<Uri[]> paramValueCallback, IX5WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    AppMethodBeat.i(188064);
    paramValueCallback = new j.3(this, paramValueCallback);
    paramFileChooserParams = new j.4(this, paramFileChooserParams);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onShowFileChooser(this.a, paramValueCallback, paramFileChooserParams);
    AppMethodBeat.o(188064);
    return bool;
  }
  
  public void openFileChooser(ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(188063);
    this.b.openFileChooser(new j.2(this, paramValueCallback), paramString1, paramString2);
    AppMethodBeat.o(188063);
  }
  
  class a
    implements WebStorage.QuotaUpdater
  {
    QuotaUpdater a;
    
    a(QuotaUpdater paramQuotaUpdater)
    {
      this.a = paramQuotaUpdater;
    }
    
    public void updateQuota(long paramLong)
    {
      AppMethodBeat.i(188069);
      this.a.updateQuota(paramLong);
      AppMethodBeat.o(188069);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.j
 * JD-Core Version:    0.7.0.1
 */