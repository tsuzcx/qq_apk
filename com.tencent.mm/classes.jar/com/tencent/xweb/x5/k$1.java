package com.tencent.xweb.x5;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.p;
import org.xwalk.core.Log;

final class k$1
  extends b
{
  k$1(k paramk) {}
  
  public final View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(84895);
    if (this.BIu.BHw != null)
    {
      localView = this.BIu.BHw.getVideoLoadingProgressView();
      AppMethodBeat.o(84895);
      return localView;
    }
    View localView = super.getVideoLoadingProgressView();
    AppMethodBeat.o(84895);
    return localView;
  }
  
  public final boolean onConsoleMessage(com.tencent.smtt.export.external.interfaces.ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(84892);
    Log.i("X5WebView", "onConsoleMessage " + paramConsoleMessage.message());
    if (this.BIu.BHw != null)
    {
      p localp = this.BIu.BHw;
      if (paramConsoleMessage == null)
      {
        paramConsoleMessage = null;
        bool = localp.onConsoleMessage(paramConsoleMessage);
        AppMethodBeat.o(84892);
        return bool;
      }
      ConsoleMessage.MessageLevel localMessageLevel = ConsoleMessage.MessageLevel.DEBUG;
      switch (g.1.BHW[paramConsoleMessage.messageLevel().ordinal()])
      {
      }
      for (;;)
      {
        paramConsoleMessage = new android.webkit.ConsoleMessage(paramConsoleMessage.message(), paramConsoleMessage.sourceId(), paramConsoleMessage.lineNumber(), localMessageLevel);
        break;
        localMessageLevel = ConsoleMessage.MessageLevel.DEBUG;
        continue;
        localMessageLevel = ConsoleMessage.MessageLevel.ERROR;
        continue;
        localMessageLevel = ConsoleMessage.MessageLevel.LOG;
        continue;
        localMessageLevel = ConsoleMessage.MessageLevel.TIP;
        continue;
        localMessageLevel = ConsoleMessage.MessageLevel.WARNING;
      }
    }
    boolean bool = super.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(84892);
    return bool;
  }
  
  public final void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(84891);
    Log.i("X5WebView", "onGeolocationPermissionsHidePrompt");
    if (this.BIu.BHw == null) {
      super.onGeolocationPermissionsHidePrompt();
    }
    AppMethodBeat.o(84891);
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    AppMethodBeat.i(84890);
    Log.i("X5WebView", "onGeolocationPermissionsShowPrompt");
    if (this.BIu.BHw != null)
    {
      this.BIu.BHw.onGeolocationPermissionsShowPrompt(paramString, new g.e(paramGeolocationPermissionsCallback));
      AppMethodBeat.o(84890);
      return;
    }
    super.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    AppMethodBeat.o(84890);
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(84886);
    Log.i("X5WebView", "onHideCustomView");
    if (this.BIu.BHw != null)
    {
      this.BIu.BHw.onHideCustomView();
      AppMethodBeat.o(84886);
      return;
    }
    super.onHideCustomView();
    AppMethodBeat.o(84886);
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(84887);
    Log.i("X5WebView", "onJsAlert");
    if (this.BIu.BHw != null)
    {
      bool = this.BIu.BHw.a(this.BIu.BHt, paramString1, paramString2, new g.f(paramJsResult));
      AppMethodBeat.o(84887);
      return bool;
    }
    boolean bool = super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(84887);
    return bool;
  }
  
  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(84888);
    Log.i("X5WebView", "onJsConfirm");
    if (this.BIu.BHw != null)
    {
      bool = this.BIu.BHw.b(this.BIu.BHt, paramString1, paramString2, new g.f(paramJsResult));
      AppMethodBeat.o(84888);
      return bool;
    }
    boolean bool = super.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(84888);
    return bool;
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(84889);
    Log.i("X5WebView", "onJsPrompt");
    if (this.BIu.BHw != null)
    {
      bool = this.BIu.BHw.a(this.BIu.BHt, paramString1, paramString2, paramString3, new g.g(paramJsPromptResult));
      AppMethodBeat.o(84889);
      return bool;
    }
    boolean bool = super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
    AppMethodBeat.o(84889);
    return bool;
  }
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    AppMethodBeat.i(84883);
    if (this.BIu.BHw != null)
    {
      this.BIu.BHw.a(this.BIu.BHt, paramInt);
      AppMethodBeat.o(84883);
      return;
    }
    super.onProgressChanged(paramWebView, paramInt);
    AppMethodBeat.o(84883);
  }
  
  public final void onReceivedTitle(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(84884);
    Log.i("X5WebView", "onReceivedTitle: ".concat(String.valueOf(paramString)));
    if (this.BIu.BHw != null)
    {
      this.BIu.BHw.d(this.BIu.BHt, paramString);
      AppMethodBeat.o(84884);
      return;
    }
    super.onReceivedTitle(paramWebView, paramString);
    AppMethodBeat.o(84884);
  }
  
  public final void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(84885);
    Log.i("X5WebView", "onShowCustomView");
    if (this.BIu.BHw != null)
    {
      this.BIu.BHw.onShowCustomView(paramView, new g.c(paramCustomViewCallback));
      AppMethodBeat.o(84885);
      return;
    }
    super.onShowCustomView(paramView, paramCustomViewCallback);
    AppMethodBeat.o(84885);
  }
  
  public final boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    AppMethodBeat.i(84894);
    Log.i("X5WebView", "onShowFileChooser last method");
    if (this.BIu.BHw != null)
    {
      bool = this.BIu.BHw.a(this.BIu.BHt, paramValueCallback, new g.d(paramFileChooserParams));
      AppMethodBeat.o(84894);
      return bool;
    }
    boolean bool = super.onShowFileChooser(paramWebView, new a.d(paramValueCallback), paramFileChooserParams);
    AppMethodBeat.o(84894);
    return bool;
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(84893);
    Log.i("X5WebView", "openFileChooser with three param");
    if (this.BIu.BHw != null)
    {
      this.BIu.BHw.openFileChooser(paramValueCallback, paramString1, paramString2);
      AppMethodBeat.o(84893);
      return;
    }
    paramValueCallback.onReceiveValue(null);
    AppMethodBeat.o(84893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.k.1
 * JD-Core Version:    0.7.0.1
 */