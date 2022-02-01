package com.tencent.xweb.sys;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.util.h;
import com.tencent.xweb.x;
import org.xwalk.core.Log;
import org.xwalk.core.R.layout;

class SysWebView$2
  extends WebChromeClient
{
  SysWebView$2(e parame) {}
  
  public View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(153705);
    if (this.aafF.aafy != null)
    {
      localView = this.aafF.aafy.getVideoLoadingProgressView();
      AppMethodBeat.o(153705);
      return localView;
    }
    View localView = LayoutInflater.from(this.aafF.aafv.getContext()).inflate(R.layout.video_progress, null);
    AppMethodBeat.o(153705);
    return localView;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(153700);
    if (this.aafF.aafy != null)
    {
      bool = this.aafF.aafy.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(153700);
      return bool;
    }
    boolean bool = super.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(153700);
    return bool;
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(153699);
    Log.i("SysWebView", "onGeolocationPermissionsHidePrompt");
    if (this.aafF.aafy != null)
    {
      this.aafF.aafy.onGeolocationPermissionsHidePrompt();
      AppMethodBeat.o(153699);
      return;
    }
    super.onGeolocationPermissionsHidePrompt();
    AppMethodBeat.o(153699);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(153698);
    Log.i("SysWebView", "onGeolocationPermissionsShowPrompt");
    if (this.aafF.aafy != null)
    {
      this.aafF.aafy.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      AppMethodBeat.o(153698);
      return;
    }
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    AppMethodBeat.o(153698);
  }
  
  public void onHideCustomView()
  {
    boolean bool = false;
    AppMethodBeat.i(153694);
    Log.i("SysWebView", "onHideCustomView");
    e.a(this.aafF, null);
    e.a(this.aafF, false);
    if (this.aafF.aafy != null) {
      bool = this.aafF.aafy.bXA();
    }
    if (bool)
    {
      Log.i("SysWebView", "onHideCustomView isHandled:true");
      AppMethodBeat.o(153694);
      return;
    }
    if (e.a(this.aafF) != null)
    {
      e.a(this.aafF).onHideCustomView();
      AppMethodBeat.o(153694);
      return;
    }
    if (this.aafF.aafy != null)
    {
      this.aafF.aafy.onHideCustomView();
      AppMethodBeat.o(153694);
      return;
    }
    super.onHideCustomView();
    AppMethodBeat.o(153694);
  }
  
  public boolean onJsAlert(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(153695);
    Log.i("SysWebView", "onJsAlert");
    if (this.aafF.aafy != null)
    {
      bool = this.aafF.aafy.a(this.aafF.aafv, paramString1, paramString2, new c.e(paramJsResult));
      AppMethodBeat.o(153695);
      return bool;
    }
    boolean bool = super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(153695);
    return bool;
  }
  
  public boolean onJsConfirm(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(153696);
    Log.i("SysWebView", "onJsConfirm");
    if (this.aafF.aafy != null)
    {
      bool = this.aafF.aafy.b(this.aafF.aafv, paramString1, paramString2, new c.e(paramJsResult));
      AppMethodBeat.o(153696);
      return bool;
    }
    boolean bool = super.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(153696);
    return bool;
  }
  
  public boolean onJsPrompt(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    AppMethodBeat.i(153697);
    Log.i("SysWebView", "onJsPrompt");
    if (this.aafF.aafy != null)
    {
      bool = this.aafF.aafy.a(this.aafF.aafv, paramString1, paramString2, paramString3, new c.d(paramJsPromptResult));
      AppMethodBeat.o(153697);
      return bool;
    }
    boolean bool = super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
    AppMethodBeat.o(153697);
    return bool;
  }
  
  public void onPermissionRequest(PermissionRequest paramPermissionRequest)
  {
    AppMethodBeat.i(211046);
    Log.i("SysWebView", "onPermissionRequest");
    if (this.aafF.aafy != null)
    {
      this.aafF.aafy.onPermissionRequest(paramPermissionRequest);
      AppMethodBeat.o(211046);
      return;
    }
    super.onPermissionRequest(paramPermissionRequest);
    AppMethodBeat.o(211046);
  }
  
  public void onPermissionRequestCanceled(PermissionRequest paramPermissionRequest)
  {
    AppMethodBeat.i(211049);
    Log.i("SysWebView", "onPermissionRequestCanceled");
    if (this.aafF.aafy != null)
    {
      this.aafF.aafy.onPermissionRequestCanceled(paramPermissionRequest);
      AppMethodBeat.o(211049);
      return;
    }
    super.onPermissionRequestCanceled(paramPermissionRequest);
    AppMethodBeat.o(211049);
  }
  
  public void onProgressChanged(android.webkit.WebView paramWebView, int paramInt)
  {
    AppMethodBeat.i(153691);
    if (this.aafF.aafy != null)
    {
      this.aafF.aafy.a(this.aafF.aafv, paramInt);
      AppMethodBeat.o(153691);
      return;
    }
    super.onProgressChanged(paramWebView, paramInt);
    AppMethodBeat.o(153691);
  }
  
  public void onReceivedTitle(android.webkit.WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(153692);
    Log.i("SysWebView", "onReceivedTitle: ".concat(String.valueOf(paramString)));
    b localb;
    if (e.a(this.aafF) != null)
    {
      localb = e.a(this.aafF);
      if (this.aafF.aafv.getFullscreenVideoKind() != WebView.a.aabj) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      localb.bu(true, bool);
      if (this.aafF.aafy == null) {
        break;
      }
      this.aafF.aafy.d(this.aafF.aafv, paramString);
      AppMethodBeat.o(153692);
      return;
    }
    super.onReceivedTitle(paramWebView, paramString);
    AppMethodBeat.o(153692);
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(153693);
    Log.i("SysWebView", "onShowCustomView");
    e.a(this.aafF, paramCustomViewCallback);
    e.a(this.aafF, true);
    boolean bool = false;
    if (this.aafF.aafy != null) {
      bool = this.aafF.aafy.a(paramView, paramCustomViewCallback);
    }
    h.ixQ();
    if (bool)
    {
      Log.i("SysWebView", "onShowCustomView isHandled:true");
      AppMethodBeat.o(153693);
      return;
    }
    if (e.a(this.aafF) != null)
    {
      e.a(this.aafF).onShowCustomView(paramView, paramCustomViewCallback);
      AppMethodBeat.o(153693);
      return;
    }
    if (this.aafF.aafy != null)
    {
      this.aafF.aafy.onShowCustomView(paramView, paramCustomViewCallback);
      AppMethodBeat.o(153693);
      return;
    }
    super.onShowCustomView(paramView, paramCustomViewCallback);
    AppMethodBeat.o(153693);
  }
  
  public boolean onShowFileChooser(android.webkit.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    AppMethodBeat.i(153704);
    Log.i("SysWebView", "onShowFileChooser last method");
    if (this.aafF.aafy != null)
    {
      bool = this.aafF.aafy.a(this.aafF.aafv, paramValueCallback, new c.c(paramFileChooserParams));
      AppMethodBeat.o(153704);
      return bool;
    }
    boolean bool = super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
    AppMethodBeat.o(153704);
    return bool;
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback)
  {
    AppMethodBeat.i(153701);
    Log.i("SysWebView", "openFileChooser with one param");
    if (this.aafF.aafy != null)
    {
      this.aafF.aafy.openFileChooser(paramValueCallback, null, null);
      AppMethodBeat.o(153701);
      return;
    }
    paramValueCallback.onReceiveValue(null);
    AppMethodBeat.o(153701);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
  {
    AppMethodBeat.i(153702);
    Log.i("SysWebView", "openFileChooser with two param");
    if (this.aafF.aafy != null)
    {
      this.aafF.aafy.openFileChooser(paramValueCallback, paramString, null);
      AppMethodBeat.o(153702);
      return;
    }
    paramValueCallback.onReceiveValue(null);
    AppMethodBeat.o(153702);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(153703);
    Log.i("SysWebView", "openFileChooser with three param");
    if (this.aafF.aafy != null)
    {
      this.aafF.aafy.openFileChooser(paramValueCallback, paramString1, paramString2);
      AppMethodBeat.o(153703);
      return;
    }
    paramValueCallback.onReceiveValue(null);
    AppMethodBeat.o(153703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebView.2
 * JD-Core Version:    0.7.0.1
 */