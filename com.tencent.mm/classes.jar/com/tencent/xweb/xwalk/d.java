package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.XWalkCookieManager;

public final class d
  implements b.a
{
  XWalkCookieManager BJw;
  
  public d()
  {
    AppMethodBeat.i(85208);
    this.BJw = new XWalkCookieManager();
    AppMethodBeat.o(85208);
  }
  
  public final void dYh()
  {
    AppMethodBeat.i(85209);
    this.BJw.setAcceptCookie(true);
    AppMethodBeat.o(85209);
  }
  
  public final void f(WebView paramWebView) {}
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(85211);
    paramString = this.BJw.getCookie(paramString);
    AppMethodBeat.o(85211);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(85210);
    this.BJw.removeAllCookie();
    AppMethodBeat.o(85210);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(85213);
    this.BJw.removeSessionCookie();
    AppMethodBeat.o(85213);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(85212);
    this.BJw.setCookie(paramString1, paramString2);
    AppMethodBeat.o(85212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d
 * JD-Core Version:    0.7.0.1
 */