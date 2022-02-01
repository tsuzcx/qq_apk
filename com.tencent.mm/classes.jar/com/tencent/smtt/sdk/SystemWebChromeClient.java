package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
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
    AppMethodBeat.i(54842);
    Bitmap localBitmap1 = this.b.getDefaultVideoPoster();
    if (localBitmap1 == null) {
      try
      {
        if (Build.VERSION.SDK_INT >= 24)
        {
          Bitmap localBitmap2 = BitmapFactory.decodeResource(this.a.getResources(), 17301540);
          AppMethodBeat.o(54842);
          return localBitmap2;
        }
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(54842);
    return localBitmap1;
  }
  
  @TargetApi(7)
  public View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(54843);
    View localView = this.b.getVideoLoadingProgressView();
    AppMethodBeat.o(54843);
    return localView;
  }
  
  public void getVisitedHistory(ValueCallback<String[]> paramValueCallback)
  {
    AppMethodBeat.i(54844);
    this.b.getVisitedHistory(new SystemWebChromeClient.1(this, paramValueCallback));
    AppMethodBeat.o(54844);
  }
  
  public void onCloseWindow(android.webkit.WebView paramWebView)
  {
    AppMethodBeat.i(54845);
    this.a.a(paramWebView);
    this.b.onCloseWindow(this.a);
    AppMethodBeat.o(54845);
  }
  
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(54847);
    this.b.onConsoleMessage(new a(paramString1, paramString2, paramInt));
    AppMethodBeat.o(54847);
  }
  
  public boolean onConsoleMessage(android.webkit.ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(54846);
    boolean bool = this.b.onConsoleMessage(new a(paramConsoleMessage));
    AppMethodBeat.o(54846);
    return bool;
  }
  
  public boolean onCreateWindow(final android.webkit.WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, final Message paramMessage)
  {
    AppMethodBeat.i(54848);
    paramWebView = this.a;
    paramWebView.getClass();
    paramWebView = new WebView.WebViewTransport(paramWebView);
    paramMessage = Message.obtain(paramMessage.getTarget(), new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(54353);
        WebView localWebView = paramWebView.getWebView();
        if (localWebView != null) {
          ((android.webkit.WebView.WebViewTransport)paramMessage.obj).setWebView(localWebView.b());
        }
        paramMessage.sendToTarget();
        AppMethodBeat.o(54353);
      }
    });
    paramMessage.obj = paramWebView;
    paramBoolean1 = this.b.onCreateWindow(this.a, paramBoolean1, paramBoolean2, paramMessage);
    AppMethodBeat.o(54848);
    return paramBoolean1;
  }
  
  @Deprecated
  @TargetApi(5)
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, android.webkit.WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(54849);
    this.b.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, new f(paramQuotaUpdater));
    AppMethodBeat.o(54849);
  }
  
  @TargetApi(5)
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(54850);
    this.b.onGeolocationPermissionsHidePrompt();
    AppMethodBeat.o(54850);
  }
  
  @TargetApi(5)
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(54851);
    this.b.onGeolocationPermissionsShowPrompt(paramString, new c(paramCallback));
    AppMethodBeat.o(54851);
  }
  
  @TargetApi(7)
  public void onHideCustomView()
  {
    AppMethodBeat.i(54852);
    this.b.onHideCustomView();
    AppMethodBeat.o(54852);
  }
  
  public boolean onJsAlert(android.webkit.WebView paramWebView, String paramString1, String paramString2, android.webkit.JsResult paramJsResult)
  {
    AppMethodBeat.i(54853);
    this.a.a(paramWebView);
    boolean bool = this.b.onJsAlert(this.a, paramString1, paramString2, new e(paramJsResult));
    AppMethodBeat.o(54853);
    return bool;
  }
  
  public boolean onJsBeforeUnload(android.webkit.WebView paramWebView, String paramString1, String paramString2, android.webkit.JsResult paramJsResult)
  {
    AppMethodBeat.i(54854);
    this.a.a(paramWebView);
    boolean bool = this.b.onJsBeforeUnload(this.a, paramString1, paramString2, new e(paramJsResult));
    AppMethodBeat.o(54854);
    return bool;
  }
  
  public boolean onJsConfirm(android.webkit.WebView paramWebView, String paramString1, String paramString2, android.webkit.JsResult paramJsResult)
  {
    AppMethodBeat.i(54855);
    this.a.a(paramWebView);
    boolean bool = this.b.onJsConfirm(this.a, paramString1, paramString2, new e(paramJsResult));
    AppMethodBeat.o(54855);
    return bool;
  }
  
  public boolean onJsPrompt(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3, android.webkit.JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(54856);
    this.a.a(paramWebView);
    boolean bool = this.b.onJsPrompt(this.a, paramString1, paramString2, paramString3, new d(paramJsPromptResult));
    AppMethodBeat.o(54856);
    return bool;
  }
  
  @TargetApi(7)
  public boolean onJsTimeout()
  {
    AppMethodBeat.i(54857);
    boolean bool = this.b.onJsTimeout();
    AppMethodBeat.o(54857);
    return bool;
  }
  
  public void onProgressChanged(android.webkit.WebView paramWebView, int paramInt)
  {
    AppMethodBeat.i(54858);
    this.a.a(paramWebView);
    this.b.onProgressChanged(this.a, paramInt);
    AppMethodBeat.o(54858);
  }
  
  @Deprecated
  @TargetApi(7)
  public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, android.webkit.WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    AppMethodBeat.i(54859);
    this.b.onReachedMaxAppCacheSize(paramLong1, paramLong2, new f(paramQuotaUpdater));
    AppMethodBeat.o(54859);
  }
  
  public void onReceivedIcon(android.webkit.WebView paramWebView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(54860);
    this.a.a(paramWebView);
    this.b.onReceivedIcon(this.a, paramBitmap);
    AppMethodBeat.o(54860);
  }
  
  public void onReceivedTitle(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(54861);
    this.a.a(paramWebView);
    this.b.onReceivedTitle(this.a, paramString);
    AppMethodBeat.o(54861);
  }
  
  @TargetApi(7)
  public void onReceivedTouchIconUrl(android.webkit.WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(54862);
    this.a.a(paramWebView);
    this.b.onReceivedTouchIconUrl(this.a, paramString, paramBoolean);
    AppMethodBeat.o(54862);
  }
  
  public void onRequestFocus(android.webkit.WebView paramWebView)
  {
    AppMethodBeat.i(54863);
    this.a.a(paramWebView);
    this.b.onRequestFocus(this.a);
    AppMethodBeat.o(54863);
  }
  
  @Deprecated
  @TargetApi(14)
  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(54865);
    this.b.onShowCustomView(paramView, paramInt, new b(paramCustomViewCallback));
    AppMethodBeat.o(54865);
  }
  
  @TargetApi(7)
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(54864);
    this.b.onShowCustomView(paramView, new b(paramCustomViewCallback));
    AppMethodBeat.o(54864);
  }
  
  public boolean onShowFileChooser(android.webkit.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    AppMethodBeat.i(54869);
    paramValueCallback = new SystemWebChromeClient.4(this, paramValueCallback);
    paramFileChooserParams = new SystemWebChromeClient.5(this, paramFileChooserParams);
    this.a.a(paramWebView);
    boolean bool = this.b.onShowFileChooser(this.a, paramValueCallback, paramFileChooserParams);
    AppMethodBeat.o(54869);
    return bool;
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback)
  {
    AppMethodBeat.i(54866);
    openFileChooser(paramValueCallback, null, null);
    AppMethodBeat.o(54866);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
  {
    AppMethodBeat.i(54867);
    openFileChooser(paramValueCallback, paramString, null);
    AppMethodBeat.o(54867);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(54868);
    this.b.openFileChooser(new SystemWebChromeClient.3(this, paramValueCallback), paramString1, paramString2);
    AppMethodBeat.o(54868);
  }
  
  public void setupAutoFill(Message paramMessage) {}
  
  static class a
    implements com.tencent.smtt.export.external.interfaces.ConsoleMessage
  {
    private com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel a;
    private String b;
    private String c;
    private int d;
    
    a(android.webkit.ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(54870);
      this.a = com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel.valueOf(paramConsoleMessage.messageLevel().name());
      this.b = paramConsoleMessage.message();
      this.c = paramConsoleMessage.sourceId();
      this.d = paramConsoleMessage.lineNumber();
      AppMethodBeat.o(54870);
    }
    
    a(String paramString1, String paramString2, int paramInt)
    {
      this.a = com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel.LOG;
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramInt;
    }
    
    public int lineNumber()
    {
      return this.d;
    }
    
    public String message()
    {
      return this.b;
    }
    
    public com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel messageLevel()
    {
      return this.a;
    }
    
    public String sourceId()
    {
      return this.c;
    }
  }
  
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
      AppMethodBeat.i(55132);
      this.a.onCustomViewHidden();
      AppMethodBeat.o(55132);
    }
  }
  
  class c
    implements GeolocationPermissionsCallback
  {
    GeolocationPermissions.Callback a;
    
    c(GeolocationPermissions.Callback paramCallback)
    {
      this.a = paramCallback;
    }
    
    public void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(54335);
      this.a.invoke(paramString, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(54335);
    }
  }
  
  class d
    implements com.tencent.smtt.export.external.interfaces.JsPromptResult
  {
    android.webkit.JsPromptResult a;
    
    d(android.webkit.JsPromptResult paramJsPromptResult)
    {
      this.a = paramJsPromptResult;
    }
    
    public void cancel()
    {
      AppMethodBeat.i(54065);
      this.a.cancel();
      AppMethodBeat.o(54065);
    }
    
    public void confirm()
    {
      AppMethodBeat.i(54066);
      this.a.confirm();
      AppMethodBeat.o(54066);
    }
    
    public void confirm(String paramString)
    {
      AppMethodBeat.i(54067);
      this.a.confirm(paramString);
      AppMethodBeat.o(54067);
    }
  }
  
  class e
    implements com.tencent.smtt.export.external.interfaces.JsResult
  {
    android.webkit.JsResult a;
    
    e(android.webkit.JsResult paramJsResult)
    {
      this.a = paramJsResult;
    }
    
    public void cancel()
    {
      AppMethodBeat.i(54319);
      this.a.cancel();
      AppMethodBeat.o(54319);
    }
    
    public void confirm()
    {
      AppMethodBeat.i(54320);
      this.a.confirm();
      AppMethodBeat.o(54320);
    }
  }
  
  class f
    implements WebStorage.QuotaUpdater
  {
    android.webkit.WebStorage.QuotaUpdater a;
    
    f(android.webkit.WebStorage.QuotaUpdater paramQuotaUpdater)
    {
      this.a = paramQuotaUpdater;
    }
    
    public void updateQuota(long paramLong)
    {
      AppMethodBeat.i(54871);
      this.a.updateQuota(paramLong);
      AppMethodBeat.o(54871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient
 * JD-Core Version:    0.7.0.1
 */