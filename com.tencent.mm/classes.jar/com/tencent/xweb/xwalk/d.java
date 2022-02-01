package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import org.xwalk.core.XWalkCookieManager;

public final class d
  implements CookieInternal.ICookieManagerInternal
{
  XWalkCookieManager ITD;
  
  public d()
  {
    AppMethodBeat.i(154256);
    this.ITD = new XWalkCookieManager();
    AppMethodBeat.o(154256);
  }
  
  public final void e(WebView paramWebView) {}
  
  public final void fqD()
  {
    AppMethodBeat.i(154257);
    this.ITD.setAcceptCookie(true);
    AppMethodBeat.o(154257);
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(154259);
    paramString = this.ITD.getCookie(paramString);
    AppMethodBeat.o(154259);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(154258);
    this.ITD.removeAllCookie();
    AppMethodBeat.o(154258);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(154261);
    this.ITD.removeSessionCookie();
    AppMethodBeat.o(154261);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154260);
    this.ITD.setCookie(paramString1, paramString2);
    AppMethodBeat.o(154260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d
 * JD-Core Version:    0.7.0.1
 */