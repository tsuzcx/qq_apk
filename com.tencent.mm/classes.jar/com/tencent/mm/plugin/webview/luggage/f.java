package com.tencent.mm.plugin.webview.luggage;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.q;
import com.tencent.xweb.z;
import com.tencent.xweb.z.a;

public class f
  extends z
{
  private z WFN;
  
  public f()
  {
    AppMethodBeat.i(78223);
    this.WFN = new z();
    AppMethodBeat.o(78223);
  }
  
  public final void a(WebView paramWebView, int paramInt)
  {
    AppMethodBeat.i(78233);
    this.WFN.a(paramWebView, paramInt);
    AppMethodBeat.o(78233);
  }
  
  public final void a(z paramz)
  {
    if (paramz != null) {
      this.WFN = paramz;
    }
  }
  
  public final boolean a(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, z.a parama)
  {
    AppMethodBeat.i(78232);
    boolean bool = this.WFN.a(paramWebView, paramValueCallback, parama);
    AppMethodBeat.o(78232);
    return bool;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(78227);
    boolean bool = this.WFN.a(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(78227);
    return bool;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, q paramq)
  {
    AppMethodBeat.i(78229);
    boolean bool = this.WFN.a(paramWebView, paramString1, paramString2, paramString3, paramq);
    AppMethodBeat.o(78229);
    return bool;
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(78228);
    boolean bool = this.WFN.b(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(78228);
    return bool;
  }
  
  public void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(78234);
    this.WFN.d(paramWebView, paramString);
    AppMethodBeat.o(78234);
  }
  
  public final View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(78230);
    View localView = this.WFN.getVideoLoadingProgressView();
    AppMethodBeat.o(78230);
    return localView;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(78224);
    boolean bool = this.WFN.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(78224);
    return bool;
  }
  
  public final void onGeolocationPermissionsHidePrompt()
  {
    AppMethodBeat.i(295933);
    this.WFN.onGeolocationPermissionsHidePrompt();
    AppMethodBeat.o(295933);
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(78225);
    this.WFN.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    AppMethodBeat.o(78225);
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(78226);
    this.WFN.onHideCustomView();
    AppMethodBeat.o(78226);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(78235);
    this.WFN.onShowCustomView(paramView, paramCustomViewCallback);
    AppMethodBeat.o(78235);
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(78231);
    this.WFN.openFileChooser(paramValueCallback, paramString1, paramString2);
    AppMethodBeat.o(78231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.f
 * JD-Core Version:    0.7.0.1
 */