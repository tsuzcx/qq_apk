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
    AppMethodBeat.i(219442);
    Bitmap localBitmap = this.b.getDefaultVideoPoster();
    AppMethodBeat.o(219442);
    return localBitmap;
  }
  
  public void getVisitedHistory(android.webkit.ValueCallback<String[]> paramValueCallback) {}
  
  public void onCloseWindow(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(219448);
    this.a.a(paramIX5WebViewBase);
    this.b.onCloseWindow(this.a);
    AppMethodBeat.o(219448);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(219456);
    boolean bool = this.b.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(219456);
    return bool;
  }
  
  public boolean onCreateWindow(final IX5WebViewBase paramIX5WebViewBase, boolean paramBoolean1, boolean paramBoolean2, final Message paramMessage)
  {
    AppMethodBeat.i(219463);
    paramIX5WebViewBase = this.a;
    paramIX5WebViewBase.getClass();
    paramIX5WebViewBase = new WebView.WebViewTransport(paramIX5WebViewBase);
    paramMessage = Message.obtain(paramMessage.getTarget(), new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(219503);
        WebView localWebView = paramIX5WebViewBase.getWebView();
        if (localWebView != null) {
          ((IX5WebViewBase.WebViewTransport)paramMessage.obj).setWebView(localWebView.c());
        }
        paramMessage.sendToTarget();
        AppMethodBeat.o(219503);
      }
    });
    paramMessage.obj = paramIX5WebViewBase;
    paramBoolean1 = this.b.onCreateWindow(this.a, paramBoolean1, paramBoolean2, paramMessage);
    AppMethodBeat.o(219463);
    return paramBoolean1;
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(219438);
    this.b.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new a(paramQuotaUpdater));
    AppMethodBeat.o(219438);
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(219466);
    this.b.onGeolocationPermissionsHidePrompt();
    AppMethodBeat.o(219466);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    AppMethodBeat.i(219471);
    this.b.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    AppMethodBeat.o(219471);
  }
  
  public void onHideCustomView()
  {
    AppMethodBeat.i(219477);
    this.b.onHideCustomView();
    AppMethodBeat.o(219477);
  }
  
  public boolean onJsAlert(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(219480);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsAlert(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(219480);
    return bool;
  }
  
  public boolean onJsBeforeUnload(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(219494);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsBeforeUnload(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(219494);
    return bool;
  }
  
  public boolean onJsConfirm(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(219484);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsConfirm(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(219484);
    return bool;
  }
  
  public boolean onJsPrompt(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(219491);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsPrompt(this.a, paramString1, paramString2, paramString3, paramJsPromptResult);
    AppMethodBeat.o(219491);
    return bool;
  }
  
  public boolean onJsTimeout()
  {
    AppMethodBeat.i(219500);
    boolean bool = this.b.onJsTimeout();
    AppMethodBeat.o(219500);
    return bool;
  }
  
  public void onProgressChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt)
  {
    AppMethodBeat.i(219507);
    this.a.a(paramIX5WebViewBase);
    this.b.onProgressChanged(this.a, paramInt);
    AppMethodBeat.o(219507);
  }
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(219511);
    this.b.onReachedMaxAppCacheSize(paramLong1, paramLong2, new a(paramQuotaUpdater));
    AppMethodBeat.o(219511);
  }
  
  public void onReceivedIcon(IX5WebViewBase paramIX5WebViewBase, Bitmap paramBitmap)
  {
    AppMethodBeat.i(219516);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedIcon(this.a, paramBitmap);
    AppMethodBeat.o(219516);
  }
  
  public void onReceivedTitle(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(219526);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedTitle(this.a, paramString);
    AppMethodBeat.o(219526);
  }
  
  public void onReceivedTouchIconUrl(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219521);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedTouchIconUrl(this.a, paramString, paramBoolean);
    AppMethodBeat.o(219521);
  }
  
  public void onRequestFocus(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(219531);
    this.a.a(paramIX5WebViewBase);
    this.b.onRequestFocus(this.a);
    AppMethodBeat.o(219531);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(219540);
    this.b.onShowCustomView(paramView, paramInt, paramCustomViewCallback);
    AppMethodBeat.o(219540);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(219535);
    this.b.onShowCustomView(paramView, paramCustomViewCallback);
    AppMethodBeat.o(219535);
  }
  
  public boolean onShowFileChooser(IX5WebViewBase paramIX5WebViewBase, final android.webkit.ValueCallback<Uri[]> paramValueCallback, final IX5WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    AppMethodBeat.i(219552);
    paramValueCallback = new ValueCallback()
    {
      public void a(Uri[] paramAnonymousArrayOfUri)
      {
        AppMethodBeat.i(219493);
        paramValueCallback.onReceiveValue(paramAnonymousArrayOfUri);
        AppMethodBeat.o(219493);
      }
    };
    paramFileChooserParams = new WebChromeClient.FileChooserParams()
    {
      public Intent createIntent()
      {
        AppMethodBeat.i(219474);
        Intent localIntent = paramFileChooserParams.createIntent();
        AppMethodBeat.o(219474);
        return localIntent;
      }
      
      public String[] getAcceptTypes()
      {
        AppMethodBeat.i(219453);
        String[] arrayOfString = paramFileChooserParams.getAcceptTypes();
        AppMethodBeat.o(219453);
        return arrayOfString;
      }
      
      public String getFilenameHint()
      {
        AppMethodBeat.i(219469);
        String str = paramFileChooserParams.getFilenameHint();
        AppMethodBeat.o(219469);
        return str;
      }
      
      public int getMode()
      {
        AppMethodBeat.i(219449);
        int i = paramFileChooserParams.getMode();
        AppMethodBeat.o(219449);
        return i;
      }
      
      public CharSequence getTitle()
      {
        AppMethodBeat.i(219464);
        CharSequence localCharSequence = paramFileChooserParams.getTitle();
        AppMethodBeat.o(219464);
        return localCharSequence;
      }
      
      public boolean isCaptureEnabled()
      {
        AppMethodBeat.i(219459);
        boolean bool = paramFileChooserParams.isCaptureEnabled();
        AppMethodBeat.o(219459);
        return bool;
      }
    };
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onShowFileChooser(this.a, paramValueCallback, paramFileChooserParams);
    AppMethodBeat.o(219552);
    return bool;
  }
  
  public void openFileChooser(final android.webkit.ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(219545);
    this.b.openFileChooser(new ValueCallback()
    {
      public void a(Uri paramAnonymousUri)
      {
        AppMethodBeat.i(219485);
        paramValueCallback.onReceiveValue(new Uri[] { paramAnonymousUri });
        AppMethodBeat.o(219485);
      }
    }, paramString1, paramString2);
    AppMethodBeat.o(219545);
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
      AppMethodBeat.i(219785);
      this.a.updateQuota(paramLong);
      AppMethodBeat.o(219785);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.j
 * JD-Core Version:    0.7.0.1
 */