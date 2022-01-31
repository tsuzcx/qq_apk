package com.tencent.mm.plugin.webview.luggage;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.i;
import com.tencent.xweb.j;
import com.tencent.xweb.p;
import com.tencent.xweb.p.a;

public class d
  extends p
{
  private p uRj;
  
  public d()
  {
    AppMethodBeat.i(5989);
    this.uRj = new p();
    AppMethodBeat.o(5989);
  }
  
  public final void a(WebView paramWebView, int paramInt)
  {
    AppMethodBeat.i(5999);
    this.uRj.a(paramWebView, paramInt);
    AppMethodBeat.o(5999);
  }
  
  public final void a(p paramp)
  {
    if (paramp != null) {
      this.uRj = paramp;
    }
  }
  
  public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, p.a parama)
  {
    AppMethodBeat.i(5998);
    boolean bool = this.uRj.a(paramWebView, paramValueCallback, parama);
    AppMethodBeat.o(5998);
    return bool;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(5993);
    boolean bool = this.uRj.a(paramWebView, paramString1, paramString2, paramj);
    AppMethodBeat.o(5993);
    return bool;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, i parami)
  {
    AppMethodBeat.i(5995);
    boolean bool = this.uRj.a(paramWebView, paramString1, paramString2, paramString3, parami);
    AppMethodBeat.o(5995);
    return bool;
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(5994);
    boolean bool = this.uRj.b(paramWebView, paramString1, paramString2, paramj);
    AppMethodBeat.o(5994);
    return bool;
  }
  
  public void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(6000);
    this.uRj.d(paramWebView, paramString);
    AppMethodBeat.o(6000);
  }
  
  public final View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(5996);
    View localView = this.uRj.getVideoLoadingProgressView();
    AppMethodBeat.o(5996);
    return localView;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(5990);
    boolean bool = this.uRj.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(5990);
    return bool;
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(5991);
    this.uRj.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    AppMethodBeat.o(5991);
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(5992);
    this.uRj.onHideCustomView();
    AppMethodBeat.o(5992);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(6001);
    this.uRj.onShowCustomView(paramView, paramCustomViewCallback);
    AppMethodBeat.o(6001);
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(5997);
    this.uRj.openFileChooser(paramValueCallback, paramString1, paramString2);
    AppMethodBeat.o(5997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d
 * JD-Core Version:    0.7.0.1
 */