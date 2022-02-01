package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
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

class h
  extends X5ProxyWebChromeClient
{
  private WebView a;
  private WebChromeClient b;
  
  public h(IX5WebChromeClient paramIX5WebChromeClient, WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    super(paramIX5WebChromeClient);
    this.a = paramWebView;
    this.b = paramWebChromeClient;
  }
  
  public Bitmap getDefaultVideoPoster()
  {
    AppMethodBeat.i(55459);
    Bitmap localBitmap = this.b.getDefaultVideoPoster();
    AppMethodBeat.o(55459);
    return localBitmap;
  }
  
  public void getVisitedHistory(android.webkit.ValueCallback<String[]> paramValueCallback) {}
  
  public void onCloseWindow(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(55460);
    this.a.a(paramIX5WebViewBase);
    this.b.onCloseWindow(this.a);
    AppMethodBeat.o(55460);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(55461);
    boolean bool = this.b.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(55461);
    return bool;
  }
  
  public boolean onCreateWindow(final IX5WebViewBase paramIX5WebViewBase, boolean paramBoolean1, boolean paramBoolean2, final Message paramMessage)
  {
    AppMethodBeat.i(55462);
    paramIX5WebViewBase = this.a;
    paramIX5WebViewBase.getClass();
    paramIX5WebViewBase = new WebView.WebViewTransport(paramIX5WebViewBase);
    paramMessage = Message.obtain(paramMessage.getTarget(), new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(55191);
        WebView localWebView = paramIX5WebViewBase.getWebView();
        if (localWebView != null) {
          ((IX5WebViewBase.WebViewTransport)paramMessage.obj).setWebView(localWebView.c());
        }
        paramMessage.sendToTarget();
        AppMethodBeat.o(55191);
      }
    });
    paramMessage.obj = paramIX5WebViewBase;
    paramBoolean1 = this.b.onCreateWindow(this.a, paramBoolean1, paramBoolean2, paramMessage);
    AppMethodBeat.o(55462);
    return paramBoolean1;
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(55458);
    this.b.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new a(paramQuotaUpdater));
    AppMethodBeat.o(55458);
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(55463);
    this.b.onGeolocationPermissionsHidePrompt();
    AppMethodBeat.o(55463);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    AppMethodBeat.i(55464);
    this.b.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    AppMethodBeat.o(55464);
  }
  
  public void onHideCustomView()
  {
    AppMethodBeat.i(55465);
    this.b.onHideCustomView();
    AppMethodBeat.o(55465);
  }
  
  public boolean onJsAlert(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(55466);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsAlert(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(55466);
    return bool;
  }
  
  public boolean onJsBeforeUnload(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(55469);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsBeforeUnload(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(55469);
    return bool;
  }
  
  public boolean onJsConfirm(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(55467);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsConfirm(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(55467);
    return bool;
  }
  
  public boolean onJsPrompt(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(55468);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsPrompt(this.a, paramString1, paramString2, paramString3, paramJsPromptResult);
    AppMethodBeat.o(55468);
    return bool;
  }
  
  public boolean onJsTimeout()
  {
    AppMethodBeat.i(55470);
    boolean bool = this.b.onJsTimeout();
    AppMethodBeat.o(55470);
    return bool;
  }
  
  public void onProgressChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt)
  {
    AppMethodBeat.i(55471);
    this.a.a(paramIX5WebViewBase);
    this.b.onProgressChanged(this.a, paramInt);
    AppMethodBeat.o(55471);
  }
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(55472);
    this.b.onReachedMaxAppCacheSize(paramLong1, paramLong2, new a(paramQuotaUpdater));
    AppMethodBeat.o(55472);
  }
  
  public void onReceivedIcon(IX5WebViewBase paramIX5WebViewBase, Bitmap paramBitmap)
  {
    AppMethodBeat.i(55473);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedIcon(this.a, paramBitmap);
    AppMethodBeat.o(55473);
  }
  
  public void onReceivedTitle(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(55475);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedTitle(this.a, paramString);
    AppMethodBeat.o(55475);
  }
  
  public void onReceivedTouchIconUrl(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(55474);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedTouchIconUrl(this.a, paramString, paramBoolean);
    AppMethodBeat.o(55474);
  }
  
  public void onRequestFocus(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(55476);
    this.a.a(paramIX5WebViewBase);
    this.b.onRequestFocus(this.a);
    AppMethodBeat.o(55476);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(55478);
    this.b.onShowCustomView(paramView, paramInt, paramCustomViewCallback);
    AppMethodBeat.o(55478);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(55477);
    this.b.onShowCustomView(paramView, paramCustomViewCallback);
    AppMethodBeat.o(55477);
  }
  
  public boolean onShowFileChooser(IX5WebViewBase paramIX5WebViewBase, final android.webkit.ValueCallback<Uri[]> paramValueCallback, final IX5WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    AppMethodBeat.i(55480);
    paramValueCallback = new ValueCallback()
    {
      public void a(Uri[] paramAnonymousArrayOfUri)
      {
        AppMethodBeat.i(54688);
        paramValueCallback.onReceiveValue(paramAnonymousArrayOfUri);
        AppMethodBeat.o(54688);
      }
    };
    paramFileChooserParams = new WebChromeClient.FileChooserParams()
    {
      public Intent createIntent()
      {
        AppMethodBeat.i(55500);
        Intent localIntent = paramFileChooserParams.createIntent();
        AppMethodBeat.o(55500);
        return localIntent;
      }
      
      public String[] getAcceptTypes()
      {
        AppMethodBeat.i(55496);
        String[] arrayOfString = paramFileChooserParams.getAcceptTypes();
        AppMethodBeat.o(55496);
        return arrayOfString;
      }
      
      public String getFilenameHint()
      {
        AppMethodBeat.i(55499);
        String str = paramFileChooserParams.getFilenameHint();
        AppMethodBeat.o(55499);
        return str;
      }
      
      public int getMode()
      {
        AppMethodBeat.i(55495);
        int i = paramFileChooserParams.getMode();
        AppMethodBeat.o(55495);
        return i;
      }
      
      public CharSequence getTitle()
      {
        AppMethodBeat.i(55498);
        CharSequence localCharSequence = paramFileChooserParams.getTitle();
        AppMethodBeat.o(55498);
        return localCharSequence;
      }
      
      public boolean isCaptureEnabled()
      {
        AppMethodBeat.i(55497);
        boolean bool = paramFileChooserParams.isCaptureEnabled();
        AppMethodBeat.o(55497);
        return bool;
      }
    };
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onShowFileChooser(this.a, paramValueCallback, paramFileChooserParams);
    AppMethodBeat.o(55480);
    return bool;
  }
  
  public void openFileChooser(final android.webkit.ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(55479);
    this.b.openFileChooser(new ValueCallback()
    {
      public void a(Uri paramAnonymousUri)
      {
        AppMethodBeat.i(54053);
        paramValueCallback.onReceiveValue(new Uri[] { paramAnonymousUri });
        AppMethodBeat.o(54053);
      }
    }, paramString1, paramString2);
    AppMethodBeat.o(55479);
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
      AppMethodBeat.i(54647);
      this.a.updateQuota(paramLong);
      AppMethodBeat.o(54647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.h
 * JD-Core Version:    0.7.0.1
 */