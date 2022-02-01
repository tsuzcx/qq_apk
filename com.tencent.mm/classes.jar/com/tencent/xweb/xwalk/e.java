package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import org.xwalk.core.XWalkCookieManager;

public final class e
  implements CookieInternal.ICookieManagerInternal
{
  XWalkCookieManager aaie;
  
  public e()
  {
    AppMethodBeat.i(154256);
    this.aaie = new XWalkCookieManager();
    AppMethodBeat.o(154256);
  }
  
  public final void f(WebView paramWebView) {}
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(154259);
    paramString = this.aaie.getCookie(paramString);
    AppMethodBeat.o(154259);
    return paramString;
  }
  
  public final void ivY()
  {
    AppMethodBeat.i(154257);
    this.aaie.setAcceptCookie(true);
    AppMethodBeat.o(154257);
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(154258);
    this.aaie.removeAllCookie();
    AppMethodBeat.o(154258);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(154261);
    this.aaie.removeSessionCookie();
    AppMethodBeat.o(154261);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154260);
    this.aaie.setCookie(paramString1, paramString2);
    AppMethodBeat.o(154260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.e
 * JD-Core Version:    0.7.0.1
 */