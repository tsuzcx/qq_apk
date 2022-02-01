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
    AppMethodBeat.i(192942);
    Bitmap localBitmap = this.b.getDefaultVideoPoster();
    AppMethodBeat.o(192942);
    return localBitmap;
  }
  
  public void getVisitedHistory(android.webkit.ValueCallback<String[]> paramValueCallback) {}
  
  public void onCloseWindow(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(192943);
    this.a.a(paramIX5WebViewBase);
    this.b.onCloseWindow(this.a);
    AppMethodBeat.o(192943);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(192944);
    boolean bool = this.b.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(192944);
    return bool;
  }
  
  public boolean onCreateWindow(final IX5WebViewBase paramIX5WebViewBase, boolean paramBoolean1, boolean paramBoolean2, final Message paramMessage)
  {
    AppMethodBeat.i(192945);
    paramIX5WebViewBase = this.a;
    paramIX5WebViewBase.getClass();
    paramIX5WebViewBase = new WebView.WebViewTransport(paramIX5WebViewBase);
    paramMessage = Message.obtain(paramMessage.getTarget(), new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(192597);
        WebView localWebView = paramIX5WebViewBase.getWebView();
        if (localWebView != null) {
          ((IX5WebViewBase.WebViewTransport)paramMessage.obj).setWebView(localWebView.c());
        }
        paramMessage.sendToTarget();
        AppMethodBeat.o(192597);
      }
    });
    paramMessage.obj = paramIX5WebViewBase;
    paramBoolean1 = this.b.onCreateWindow(this.a, paramBoolean1, paramBoolean2, paramMessage);
    AppMethodBeat.o(192945);
    return paramBoolean1;
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(192941);
    this.b.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new a(paramQuotaUpdater));
    AppMethodBeat.o(192941);
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(192946);
    this.b.onGeolocationPermissionsHidePrompt();
    AppMethodBeat.o(192946);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    AppMethodBeat.i(192947);
    this.b.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    AppMethodBeat.o(192947);
  }
  
  public void onHideCustomView()
  {
    AppMethodBeat.i(192948);
    this.b.onHideCustomView();
    AppMethodBeat.o(192948);
  }
  
  public boolean onJsAlert(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(192949);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsAlert(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(192949);
    return bool;
  }
  
  public boolean onJsBeforeUnload(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(192952);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsBeforeUnload(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(192952);
    return bool;
  }
  
  public boolean onJsConfirm(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(192950);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsConfirm(this.a, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(192950);
    return bool;
  }
  
  public boolean onJsPrompt(IX5WebViewBase paramIX5WebViewBase, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(192951);
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onJsPrompt(this.a, paramString1, paramString2, paramString3, paramJsPromptResult);
    AppMethodBeat.o(192951);
    return bool;
  }
  
  public boolean onJsTimeout()
  {
    AppMethodBeat.i(192953);
    boolean bool = this.b.onJsTimeout();
    AppMethodBeat.o(192953);
    return bool;
  }
  
  public void onProgressChanged(IX5WebViewBase paramIX5WebViewBase, int paramInt)
  {
    AppMethodBeat.i(192954);
    this.a.a(paramIX5WebViewBase);
    this.b.onProgressChanged(this.a, paramInt);
    AppMethodBeat.o(192954);
  }
  
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(192955);
    this.b.onReachedMaxAppCacheSize(paramLong1, paramLong2, new a(paramQuotaUpdater));
    AppMethodBeat.o(192955);
  }
  
  public void onReceivedIcon(IX5WebViewBase paramIX5WebViewBase, Bitmap paramBitmap)
  {
    AppMethodBeat.i(192956);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedIcon(this.a, paramBitmap);
    AppMethodBeat.o(192956);
  }
  
  public void onReceivedTitle(IX5WebViewBase paramIX5WebViewBase, String paramString)
  {
    AppMethodBeat.i(192958);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedTitle(this.a, paramString);
    AppMethodBeat.o(192958);
  }
  
  public void onReceivedTouchIconUrl(IX5WebViewBase paramIX5WebViewBase, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(192957);
    this.a.a(paramIX5WebViewBase);
    this.b.onReceivedTouchIconUrl(this.a, paramString, paramBoolean);
    AppMethodBeat.o(192957);
  }
  
  public void onRequestFocus(IX5WebViewBase paramIX5WebViewBase)
  {
    AppMethodBeat.i(192959);
    this.a.a(paramIX5WebViewBase);
    this.b.onRequestFocus(this.a);
    AppMethodBeat.o(192959);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(192961);
    this.b.onShowCustomView(paramView, paramInt, paramCustomViewCallback);
    AppMethodBeat.o(192961);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(192960);
    this.b.onShowCustomView(paramView, paramCustomViewCallback);
    AppMethodBeat.o(192960);
  }
  
  public boolean onShowFileChooser(IX5WebViewBase paramIX5WebViewBase, final android.webkit.ValueCallback<Uri[]> paramValueCallback, final IX5WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    AppMethodBeat.i(192963);
    paramValueCallback = new ValueCallback()
    {
      public void a(Uri[] paramAnonymousArrayOfUri)
      {
        AppMethodBeat.i(192792);
        paramValueCallback.onReceiveValue(paramAnonymousArrayOfUri);
        AppMethodBeat.o(192792);
      }
    };
    paramFileChooserParams = new WebChromeClient.FileChooserParams()
    {
      public Intent createIntent()
      {
        AppMethodBeat.i(192938);
        Intent localIntent = paramFileChooserParams.createIntent();
        AppMethodBeat.o(192938);
        return localIntent;
      }
      
      public String[] getAcceptTypes()
      {
        AppMethodBeat.i(192934);
        String[] arrayOfString = paramFileChooserParams.getAcceptTypes();
        AppMethodBeat.o(192934);
        return arrayOfString;
      }
      
      public String getFilenameHint()
      {
        AppMethodBeat.i(192937);
        String str = paramFileChooserParams.getFilenameHint();
        AppMethodBeat.o(192937);
        return str;
      }
      
      public int getMode()
      {
        AppMethodBeat.i(192933);
        int i = paramFileChooserParams.getMode();
        AppMethodBeat.o(192933);
        return i;
      }
      
      public CharSequence getTitle()
      {
        AppMethodBeat.i(192936);
        CharSequence localCharSequence = paramFileChooserParams.getTitle();
        AppMethodBeat.o(192936);
        return localCharSequence;
      }
      
      public boolean isCaptureEnabled()
      {
        AppMethodBeat.i(192935);
        boolean bool = paramFileChooserParams.isCaptureEnabled();
        AppMethodBeat.o(192935);
        return bool;
      }
    };
    this.a.a(paramIX5WebViewBase);
    boolean bool = this.b.onShowFileChooser(this.a, paramValueCallback, paramFileChooserParams);
    AppMethodBeat.o(192963);
    return bool;
  }
  
  public void openFileChooser(final android.webkit.ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(192962);
    this.b.openFileChooser(new ValueCallback()
    {
      public void a(Uri paramAnonymousUri)
      {
        AppMethodBeat.i(192563);
        paramValueCallback.onReceiveValue(new Uri[] { paramAnonymousUri });
        AppMethodBeat.o(192563);
      }
    }, paramString1, paramString2);
    AppMethodBeat.o(192962);
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
      AppMethodBeat.i(192588);
      this.a.updateQuota(paramLong);
      AppMethodBeat.o(192588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.j
 * JD-Core Version:    0.7.0.1
 */