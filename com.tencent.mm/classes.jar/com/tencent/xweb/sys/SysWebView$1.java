package com.tencent.xweb.sys;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.p;
import com.tencent.xweb.util.f;
import org.xwalk.core.Log;

class SysWebView$1
  extends WebChromeClient
{
  SysWebView$1(e parame) {}
  
  public View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(84685);
    if (this.BHD.BHw != null)
    {
      localView = this.BHD.BHw.getVideoLoadingProgressView();
      AppMethodBeat.o(84685);
      return localView;
    }
    View localView = LayoutInflater.from(this.BHD.BHt.getContext()).inflate(2130971070, null);
    AppMethodBeat.o(84685);
    return localView;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(84680);
    Log.i("SysWebView", "onConsoleMessage " + paramConsoleMessage.message());
    if (this.BHD.BHw != null)
    {
      bool = this.BHD.BHw.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(84680);
      return bool;
    }
    boolean bool = super.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(84680);
    return bool;
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(84679);
    Log.i("SysWebView", "onGeolocationPermissionsHidePrompt");
    if (this.BHD.BHw == null) {
      super.onGeolocationPermissionsHidePrompt();
    }
    AppMethodBeat.o(84679);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(84678);
    Log.i("SysWebView", "onGeolocationPermissionsShowPrompt");
    if (this.BHD.BHw != null)
    {
      this.BHD.BHw.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      AppMethodBeat.o(84678);
      return;
    }
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    AppMethodBeat.o(84678);
  }
  
  public void onHideCustomView()
  {
    AppMethodBeat.i(84674);
    Log.i("SysWebView", "onHideCustomView");
    boolean bool = false;
    if (this.BHD.BHw != null) {
      bool = this.BHD.BHw.aJH();
    }
    if (bool)
    {
      Log.i("SysWebView", "onHideCustomView isHandled:true");
      AppMethodBeat.o(84674);
      return;
    }
    if (this.BHD.BHA != null)
    {
      this.BHD.BHA.onHideCustomView();
      AppMethodBeat.o(84674);
      return;
    }
    if (this.BHD.BHw != null)
    {
      this.BHD.BHw.onHideCustomView();
      AppMethodBeat.o(84674);
      return;
    }
    super.onHideCustomView();
    AppMethodBeat.o(84674);
  }
  
  public boolean onJsAlert(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(84675);
    Log.i("SysWebView", "onJsAlert");
    if (this.BHD.BHw != null)
    {
      bool = this.BHD.BHw.a(this.BHD.BHt, paramString1, paramString2, new c.d(paramJsResult));
      AppMethodBeat.o(84675);
      return bool;
    }
    boolean bool = super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(84675);
    return bool;
  }
  
  public boolean onJsConfirm(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(84676);
    Log.i("SysWebView", "onJsConfirm");
    if (this.BHD.BHw != null)
    {
      bool = this.BHD.BHw.b(this.BHD.BHt, paramString1, paramString2, new c.d(paramJsResult));
      AppMethodBeat.o(84676);
      return bool;
    }
    boolean bool = super.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(84676);
    return bool;
  }
  
  public boolean onJsPrompt(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(84677);
    Log.i("SysWebView", "onJsPrompt");
    if (this.BHD.BHw != null)
    {
      bool = this.BHD.BHw.a(this.BHD.BHt, paramString1, paramString2, paramString3, new c.c(paramJsPromptResult));
      AppMethodBeat.o(84677);
      return bool;
    }
    boolean bool = super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
    AppMethodBeat.o(84677);
    return bool;
  }
  
  public void onProgressChanged(android.webkit.WebView paramWebView, int paramInt)
  {
    AppMethodBeat.i(84671);
    if (this.BHD.BHw != null)
    {
      this.BHD.BHw.a(this.BHD.BHt, paramInt);
      AppMethodBeat.o(84671);
      return;
    }
    super.onProgressChanged(paramWebView, paramInt);
    AppMethodBeat.o(84671);
  }
  
  public void onReceivedTitle(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(84672);
    Log.i("SysWebView", "onReceivedTitle: ".concat(String.valueOf(paramString)));
    b localb;
    if (this.BHD.BHA != null)
    {
      localb = this.BHD.BHA;
      if (this.BHD.BHt.getFullscreenVideoKind() != WebView.a.BEn) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      localb.ao(true, bool);
      if (this.BHD.BHw == null) {
        break;
      }
      this.BHD.BHw.d(this.BHD.BHt, paramString);
      AppMethodBeat.o(84672);
      return;
    }
    super.onReceivedTitle(paramWebView, paramString);
    AppMethodBeat.o(84672);
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(84673);
    Log.i("SysWebView", "onShowCustomView");
    boolean bool = false;
    if (this.BHD.BHw != null) {
      bool = this.BHD.BHw.a(paramView, paramCustomViewCallback);
    }
    f.dZl();
    if (bool)
    {
      Log.i("SysWebView", "onShowCustomView isHandled:true");
      AppMethodBeat.o(84673);
      return;
    }
    if (this.BHD.BHA != null)
    {
      this.BHD.BHA.onShowCustomView(paramView, paramCustomViewCallback);
      AppMethodBeat.o(84673);
      return;
    }
    if (this.BHD.BHw != null)
    {
      this.BHD.BHw.onShowCustomView(paramView, paramCustomViewCallback);
      AppMethodBeat.o(84673);
      return;
    }
    super.onShowCustomView(paramView, paramCustomViewCallback);
    AppMethodBeat.o(84673);
  }
  
  public boolean onShowFileChooser(android.webkit.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    AppMethodBeat.i(84684);
    Log.i("SysWebView", "onShowFileChooser last method");
    if (this.BHD.BHw != null)
    {
      bool = this.BHD.BHw.a(this.BHD.BHt, paramValueCallback, new c.b(paramFileChooserParams));
      AppMethodBeat.o(84684);
      return bool;
    }
    boolean bool = super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
    AppMethodBeat.o(84684);
    return bool;
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback)
  {
    AppMethodBeat.i(84681);
    Log.i("SysWebView", "openFileChooser with one param");
    if (this.BHD.BHw != null)
    {
      this.BHD.BHw.openFileChooser(paramValueCallback, null, null);
      AppMethodBeat.o(84681);
      return;
    }
    paramValueCallback.onReceiveValue(null);
    AppMethodBeat.o(84681);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
  {
    AppMethodBeat.i(84682);
    Log.i("SysWebView", "openFileChooser with two param");
    if (this.BHD.BHw != null)
    {
      this.BHD.BHw.openFileChooser(paramValueCallback, paramString, null);
      AppMethodBeat.o(84682);
      return;
    }
    paramValueCallback.onReceiveValue(null);
    AppMethodBeat.o(84682);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(84683);
    Log.i("SysWebView", "openFileChooser with three param");
    if (this.BHD.BHw != null)
    {
      this.BHD.BHw.openFileChooser(paramValueCallback, paramString1, paramString2);
      AppMethodBeat.o(84683);
      return;
    }
    paramValueCallback.onReceiveValue(null);
    AppMethodBeat.o(84683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebView.1
 * JD-Core Version:    0.7.0.1
 */