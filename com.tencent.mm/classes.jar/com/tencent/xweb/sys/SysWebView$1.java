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
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.j;
import org.xwalk.core.Log;
import org.xwalk.core.R.layout;

class SysWebView$1
  extends WebChromeClient
{
  SysWebView$1(e parame) {}
  
  public View getVideoLoadingProgressView()
  {
    if (this.xjZ.xjS != null) {
      return this.xjZ.xjS.getVideoLoadingProgressView();
    }
    return LayoutInflater.from(this.xjZ.xjP.getContext()).inflate(R.layout.video_progress, null);
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    Log.i("SysWebView", "onConsoleMessage " + paramConsoleMessage.message());
    if (this.xjZ.xjS != null) {
      return this.xjZ.xjS.onConsoleMessage(paramConsoleMessage);
    }
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    Log.i("SysWebView", "onGeolocationPermissionsHidePrompt");
    if (this.xjZ.xjS == null) {
      super.onGeolocationPermissionsHidePrompt();
    }
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    Log.i("SysWebView", "onGeolocationPermissionsShowPrompt");
    if (this.xjZ.xjS != null)
    {
      this.xjZ.xjS.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      return;
    }
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
  }
  
  public void onHideCustomView()
  {
    Log.i("SysWebView", "onHideCustomView");
    if (this.xjZ.xjS != null) {
      this.xjZ.xjS.ajc();
    }
    if (this.xjZ.xjW != null)
    {
      this.xjZ.xjW.onHideCustomView();
      return;
    }
    if (this.xjZ.xjS != null)
    {
      this.xjZ.xjS.onHideCustomView();
      return;
    }
    super.onHideCustomView();
  }
  
  public boolean onJsAlert(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Log.i("SysWebView", "onJsAlert");
    if (this.xjZ.xjS != null) {
      return this.xjZ.xjS.a(this.xjZ.xjP, paramString1, paramString2, new c.d(paramJsResult));
    }
    return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsConfirm(android.webkit.WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    Log.i("SysWebView", "onJsConfirm");
    if (this.xjZ.xjS != null) {
      return this.xjZ.xjS.b(this.xjZ.xjP, paramString1, paramString2, new c.d(paramJsResult));
    }
    return super.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsPrompt(android.webkit.WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    Log.i("SysWebView", "onJsPrompt");
    if (this.xjZ.xjS != null) {
      return this.xjZ.xjS.a(this.xjZ.xjP, paramString1, paramString2, paramString3, new c.c(paramJsPromptResult));
    }
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public void onProgressChanged(android.webkit.WebView paramWebView, int paramInt)
  {
    Log.i("SysWebView", "onProgressChanged, progress = " + paramInt);
    if (this.xjZ.xjS != null)
    {
      this.xjZ.xjS.a(this.xjZ.xjP, paramInt);
      return;
    }
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(android.webkit.WebView paramWebView, String paramString)
  {
    Log.i("SysWebView", "onReceivedTitle: " + paramString);
    b localb;
    if (this.xjZ.xjW != null)
    {
      localb = this.xjZ.xjW;
      if (this.xjZ.xjP.getFullscreenVideoKind() != WebView.a.xhl) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      localb.aa(true, bool);
      if (this.xjZ.xjS == null) {
        break;
      }
      this.xjZ.xjS.d(this.xjZ.xjP, paramString);
      return;
    }
    super.onReceivedTitle(paramWebView, paramString);
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    Log.i("SysWebView", "onShowCustomView");
    if (this.xjZ.xjS != null) {
      this.xjZ.xjS.anw();
    }
    com.tencent.xweb.util.e.cSU();
    if (this.xjZ.xjW != null)
    {
      this.xjZ.xjW.onShowCustomView(paramView, paramCustomViewCallback);
      return;
    }
    if (this.xjZ.xjS != null)
    {
      this.xjZ.xjS.onShowCustomView(paramView, paramCustomViewCallback);
      return;
    }
    super.onShowCustomView(paramView, paramCustomViewCallback);
  }
  
  public boolean onShowFileChooser(android.webkit.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    Log.i("SysWebView", "onShowFileChooser last method");
    if (this.xjZ.xjS != null) {
      return this.xjZ.xjS.a(this.xjZ.xjP, paramValueCallback, new c.b(paramFileChooserParams));
    }
    return super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback)
  {
    Log.i("SysWebView", "openFileChooser with one param");
    if (this.xjZ.xjS != null)
    {
      this.xjZ.xjS.openFileChooser(paramValueCallback, null, null);
      return;
    }
    paramValueCallback.onReceiveValue(null);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
  {
    Log.i("SysWebView", "openFileChooser with two param");
    if (this.xjZ.xjS != null)
    {
      this.xjZ.xjS.openFileChooser(paramValueCallback, paramString, null);
      return;
    }
    paramValueCallback.onReceiveValue(null);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    Log.i("SysWebView", "openFileChooser with three param");
    if (this.xjZ.xjS != null)
    {
      this.xjZ.xjS.openFileChooser(paramValueCallback, paramString1, paramString2);
      return;
    }
    paramValueCallback.onReceiveValue(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebView.1
 * JD-Core Version:    0.7.0.1
 */