package com.tencent.xweb;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.f;

public class p
{
  f BDF;
  
  public void a(WebView paramWebView, int paramInt) {}
  
  public boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (this.BDF != null) {}
    return false;
  }
  
  public boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, p.a parama)
  {
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(3820);
    if (this.BDF != null)
    {
      boolean bool = this.BDF.a(paramString1, paramString2, paramj);
      AppMethodBeat.o(3820);
      return bool;
    }
    AppMethodBeat.o(3820);
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, i parami)
  {
    AppMethodBeat.i(3822);
    if (this.BDF != null)
    {
      boolean bool = this.BDF.a(paramString1, paramString2, paramString3, parami);
      AppMethodBeat.o(3822);
      return bool;
    }
    AppMethodBeat.o(3822);
    return false;
  }
  
  public boolean aJH()
  {
    if (this.BDF != null) {}
    return false;
  }
  
  public boolean b(WebView paramWebView, String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(3821);
    if (this.BDF != null)
    {
      boolean bool = this.BDF.b(paramString1, paramString2, paramj);
      AppMethodBeat.o(3821);
      return bool;
    }
    AppMethodBeat.o(3821);
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
    AppMethodBeat.i(3818);
    paramCallback.invoke(paramString, true, true);
    AppMethodBeat.o(3818);
  }
  
  public void onHideCustomView()
  {
    AppMethodBeat.i(3819);
    if (this.BDF != null) {
      this.BDF.onHideCustomView();
    }
    AppMethodBeat.o(3819);
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(3824);
    if (this.BDF != null) {
      this.BDF.onShowCustomView(paramView, paramCustomViewCallback);
    }
    AppMethodBeat.o(3824);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(3823);
    paramValueCallback.onReceiveValue(null);
    AppMethodBeat.o(3823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.p
 * JD-Core Version:    0.7.0.1
 */