package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import org.xwalk.core.Log;

public final class d
  implements CookieInternal.ICookieManagerInternal
{
  CookieManager KEo;
  
  public d()
  {
    AppMethodBeat.i(153834);
    this.KEo = CookieManager.getInstance();
    AppMethodBeat.o(153834);
  }
  
  public final void e(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(153836);
    if (paramWebView == null)
    {
      Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is null");
      AppMethodBeat.o(153836);
      return;
    }
    paramWebView = paramWebView.getWebViewUI();
    if (!(paramWebView instanceof com.tencent.smtt.sdk.WebView))
    {
      Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is not x5 webview");
      AppMethodBeat.o(153836);
      return;
    }
    this.KEo.setAcceptThirdPartyCookies((com.tencent.smtt.sdk.WebView)paramWebView, true);
    AppMethodBeat.o(153836);
  }
  
  public final void fJb()
  {
    AppMethodBeat.i(153835);
    this.KEo.setAcceptCookie(true);
    AppMethodBeat.o(153835);
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(153838);
    paramString = this.KEo.getCookie(paramString);
    AppMethodBeat.o(153838);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(153837);
    this.KEo.removeAllCookie();
    AppMethodBeat.o(153837);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(153840);
    this.KEo.removeSessionCookie();
    AppMethodBeat.o(153840);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153839);
    this.KEo.setCookie(paramString1, paramString2);
    AppMethodBeat.o(153839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.d
 * JD-Core Version:    0.7.0.1
 */