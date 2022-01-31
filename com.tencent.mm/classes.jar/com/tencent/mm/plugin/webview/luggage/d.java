package com.tencent.mm.plugin.webview.luggage;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;
import com.tencent.xweb.j.a;

public class d
  extends j
{
  private j rbz = new j();
  
  public final void a(WebView paramWebView, int paramInt)
  {
    this.rbz.a(paramWebView, paramInt);
  }
  
  public final void a(j paramj)
  {
    if (paramj != null) {
      this.rbz = paramj;
    }
  }
  
  public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, j.a parama)
  {
    return this.rbz.a(paramWebView, paramValueCallback, parama);
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, f paramf)
  {
    return this.rbz.a(paramWebView, paramString1, paramString2, paramf);
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, e parame)
  {
    return this.rbz.a(paramWebView, paramString1, paramString2, paramString3, parame);
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, f paramf)
  {
    return this.rbz.b(paramWebView, paramString1, paramString2, paramf);
  }
  
  public void d(WebView paramWebView, String paramString)
  {
    this.rbz.d(paramWebView, paramString);
  }
  
  public final View getVideoLoadingProgressView()
  {
    return this.rbz.getVideoLoadingProgressView();
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return this.rbz.onConsoleMessage(paramConsoleMessage);
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    this.rbz.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
  }
  
  public final void onHideCustomView()
  {
    this.rbz.onHideCustomView();
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.rbz.onShowCustomView(paramView, paramCustomViewCallback);
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    this.rbz.openFileChooser(paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d
 * JD-Core Version:    0.7.0.1
 */