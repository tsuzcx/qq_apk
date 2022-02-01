package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import org.xwalk.core.Log;

public final class b
  implements CookieInternal.ICookieManagerInternal
{
  private CookieManager aimW;
  
  public b()
  {
    AppMethodBeat.i(153834);
    this.aimW = CookieManager.getInstance();
    AppMethodBeat.o(153834);
  }
  
  public final void b(com.tencent.xweb.WebView paramWebView, boolean paramBoolean)
  {
    AppMethodBeat.i(213203);
    if (paramWebView == null)
    {
      Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies, the webview is null");
      AppMethodBeat.o(213203);
      return;
    }
    paramWebView = paramWebView.getWebViewUI();
    if (!(paramWebView instanceof com.tencent.smtt.sdk.WebView))
    {
      Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies, the webview is not x5 webview");
      AppMethodBeat.o(213203);
      return;
    }
    this.aimW.setAcceptThirdPartyCookies((com.tencent.smtt.sdk.WebView)paramWebView, true);
    AppMethodBeat.o(213203);
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(153838);
    paramString = this.aimW.getCookie(paramString);
    AppMethodBeat.o(153838);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(153837);
    this.aimW.removeAllCookie();
    AppMethodBeat.o(153837);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(153840);
    this.aimW.removeSessionCookie();
    AppMethodBeat.o(153840);
  }
  
  public final void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(213198);
    this.aimW.setAcceptCookie(true);
    AppMethodBeat.o(213198);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153839);
    this.aimW.setCookie(paramString1, paramString2);
    AppMethodBeat.o(153839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.b
 * JD-Core Version:    0.7.0.1
 */