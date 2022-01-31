package com.tencent.xweb;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;

public class j
{
  com.tencent.xweb.c.f xgI;
  
  public void a(WebView paramWebView, int paramInt) {}
  
  public boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, a parama)
  {
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, f paramf)
  {
    if (this.xgI != null) {
      return this.xgI.a(paramString1, paramString2, paramf);
    }
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, e parame)
  {
    if (this.xgI != null) {
      return this.xgI.a(paramString1, paramString2, paramString3, parame);
    }
    return false;
  }
  
  public void ajc() {}
  
  public void anw() {}
  
  public boolean b(WebView paramWebView, String paramString1, String paramString2, f paramf)
  {
    if (this.xgI != null) {
      return this.xgI.b(paramString1, paramString2, paramf);
    }
    return false;
  }
  
  public void d(WebView paramWebView, String paramString) {}
  
  public View getVideoLoadingProgressView()
  {
    return null;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return false;
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    paramCallback.invoke(paramString, true, true);
  }
  
  public void onHideCustomView()
  {
    if (this.xgI != null) {
      this.xgI.onHideCustomView();
    }
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (this.xgI != null) {
      this.xgI.onShowCustomView(paramView, paramCustomViewCallback);
    }
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    paramValueCallback.onReceiveValue(null);
  }
  
  public static abstract class a
  {
    public abstract String[] getAcceptTypes();
    
    public abstract int getMode();
    
    public abstract boolean isCaptureEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.j
 * JD-Core Version:    0.7.0.1
 */