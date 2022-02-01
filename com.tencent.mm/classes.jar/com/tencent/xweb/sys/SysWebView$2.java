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
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.extension.video.a;
import com.tencent.xweb.extension.video.d;
import com.tencent.xweb.util.l;
import com.tencent.xweb.z;
import org.xwalk.core.Log;
import org.xwalk.core.R.layout;

class SysWebView$2
  extends WebChromeClient
{
  SysWebView$2(f paramf) {}
  
  public View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(153705);
    if (f.e(this.aimq) != null)
    {
      localView = f.e(this.aimq).getVideoLoadingProgressView();
      AppMethodBeat.o(153705);
      return localView;
    }
    View localView = LayoutInflater.from(f.a(this.aimq).getContext()).inflate(R.layout.xweb_video_progress, null);
    AppMethodBeat.o(153705);
    return localView;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(153700);
    if (f.e(this.aimq) != null)
    {
      bool = f.e(this.aimq).onConsoleMessage(paramConsoleMessage);
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
    if (f.e(this.aimq) != null)
    {
      f.e(this.aimq).onGeolocationPermissionsHidePrompt();
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
    if (f.e(this.aimq) != null)
    {
      f.e(this.aimq).onGeolocationPermissionsShowPrompt(paramString, paramCallback);
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
    f.a(this.aimq, null);
    f.a(this.aimq, false);
    if (f.e(this.aimq) != null) {
      bool = f.e(this.aimq).cxL();
    }
    if (bool)
    {
      Log.i("SysWebView", "onHideCustomView, isHandled:true");
      AppMethodBeat.o(153694);
      return;
    }
    if (f.d(this.aimq) != null)
    {
      f.d(this.aimq).onHideCustomView();
      AppMethodBeat.o(153694);
      return;
    }
    if (f.e(this.aimq) != null)
    {
      f.e(this.aimq).onHideCustomView();
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
    if (f.e(this.aimq) != null)
    {
      bool = f.e(this.aimq).a(f.a(this.aimq), paramString1, paramString2, new c.e(paramJsResult));
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
    if (f.e(this.aimq) != null)
    {
      bool = f.e(this.aimq).b(f.a(this.aimq), paramString1, paramString2, new c.e(paramJsResult));
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
    if (f.e(this.aimq) != null)
    {
      bool = f.e(this.aimq).a(f.a(this.aimq), paramString1, paramString2, paramString3, new c.d(paramJsPromptResult));
      AppMethodBeat.o(153697);
      return bool;
    }
    boolean bool = super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
    AppMethodBeat.o(153697);
    return bool;
  }
  
  public void onPermissionRequest(PermissionRequest paramPermissionRequest)
  {
    AppMethodBeat.i(212730);
    Log.i("SysWebView", "onPermissionRequest");
    if (f.e(this.aimq) != null)
    {
      f.e(this.aimq).onPermissionRequest(paramPermissionRequest);
      AppMethodBeat.o(212730);
      return;
    }
    super.onPermissionRequest(paramPermissionRequest);
    AppMethodBeat.o(212730);
  }
  
  public void onPermissionRequestCanceled(PermissionRequest paramPermissionRequest)
  {
    AppMethodBeat.i(212735);
    Log.i("SysWebView", "onPermissionRequestCanceled");
    if (f.e(this.aimq) != null)
    {
      f.e(this.aimq).onPermissionRequestCanceled(paramPermissionRequest);
      AppMethodBeat.o(212735);
      return;
    }
    super.onPermissionRequestCanceled(paramPermissionRequest);
    AppMethodBeat.o(212735);
  }
  
  public void onProgressChanged(android.webkit.WebView paramWebView, int paramInt)
  {
    AppMethodBeat.i(153691);
    if (f.e(this.aimq) != null)
    {
      f.e(this.aimq).a(f.a(this.aimq), paramInt);
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
    a locala;
    if (f.d(this.aimq) != null)
    {
      locala = f.d(this.aimq);
      if (f.a(this.aimq).getFullscreenVideoKind() != WebView.a.aifF) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      locala.bV(true, bool);
      if (f.e(this.aimq) == null) {
        break;
      }
      f.e(this.aimq).d(f.a(this.aimq), paramString);
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
    f.a(this.aimq, paramCustomViewCallback);
    f.a(this.aimq, true);
    boolean bool = false;
    if (f.e(this.aimq) != null) {
      bool = f.e(this.aimq).a(paramView, paramCustomViewCallback);
    }
    l.khW();
    if (bool)
    {
      Log.i("SysWebView", "onShowCustomView, isHandled:true");
      AppMethodBeat.o(153693);
      return;
    }
    if (f.d(this.aimq) != null)
    {
      l.a(WebView.WebViewKind.aifK, f.d(this.aimq) instanceof d, this.aimq.getUrl());
      f.d(this.aimq).onShowCustomView(paramView, paramCustomViewCallback);
      AppMethodBeat.o(153693);
      return;
    }
    if (f.e(this.aimq) != null)
    {
      f.e(this.aimq).onShowCustomView(paramView, paramCustomViewCallback);
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
    if (f.e(this.aimq) != null)
    {
      bool = f.e(this.aimq).a(f.a(this.aimq), paramValueCallback, new c.c(paramFileChooserParams));
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
    if (f.e(this.aimq) != null)
    {
      f.e(this.aimq).openFileChooser(paramValueCallback, null, null);
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
    if (f.e(this.aimq) != null)
    {
      f.e(this.aimq).openFileChooser(paramValueCallback, paramString, null);
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
    if (f.e(this.aimq) != null)
    {
      f.e(this.aimq).openFileChooser(paramValueCallback, paramString1, paramString2);
      AppMethodBeat.o(153703);
      return;
    }
    paramValueCallback.onReceiveValue(null);
    AppMethodBeat.o(153703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebView.2
 * JD-Core Version:    0.7.0.1
 */