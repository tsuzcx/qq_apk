package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.Log;

public final class d
  implements b.a
{
  CookieManager BHT;
  
  public d()
  {
    AppMethodBeat.i(84799);
    this.BHT = CookieManager.getInstance();
    AppMethodBeat.o(84799);
  }
  
  public final void dYh()
  {
    AppMethodBeat.i(84800);
    this.BHT.setAcceptCookie(true);
    AppMethodBeat.o(84800);
  }
  
  public final void f(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(84801);
    if (paramWebView == null)
    {
      Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is null");
      AppMethodBeat.o(84801);
      return;
    }
    paramWebView = paramWebView.getWebViewUI();
    if (!(paramWebView instanceof com.tencent.smtt.sdk.WebView))
    {
      Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is not x5 webview");
      AppMethodBeat.o(84801);
      return;
    }
    this.BHT.setAcceptThirdPartyCookies((com.tencent.smtt.sdk.WebView)paramWebView, true);
    AppMethodBeat.o(84801);
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(84803);
    paramString = this.BHT.getCookie(paramString);
    AppMethodBeat.o(84803);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(84802);
    this.BHT.removeAllCookie();
    AppMethodBeat.o(84802);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(84805);
    this.BHT.removeSessionCookie();
    AppMethodBeat.o(84805);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(84804);
    this.BHT.setCookie(paramString1, paramString2);
    AppMethodBeat.o(84804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.d
 * JD-Core Version:    0.7.0.1
 */