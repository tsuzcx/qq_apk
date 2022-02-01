package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkCookieManager;

public final class e
  implements CookieInternal.ICookieManagerInternal
{
  private XWalkCookieManager aioL;
  
  public e()
  {
    AppMethodBeat.i(154256);
    this.aioL = new XWalkCookieManager();
    AppMethodBeat.o(154256);
  }
  
  public final void b(WebView paramWebView, boolean paramBoolean)
  {
    AppMethodBeat.i(212863);
    Log.i("XWCookieManagerWrapper", "setAcceptThirdPartyCookies:".concat("true"));
    AppMethodBeat.o(212863);
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(154259);
    Log.i("XWCookieManagerWrapper", "getCookie, url:".concat(String.valueOf(paramString)));
    paramString = this.aioL.getCookie(paramString);
    AppMethodBeat.o(154259);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(154258);
    Log.i("XWCookieManagerWrapper", "removeAllCookie");
    this.aioL.removeAllCookie();
    AppMethodBeat.o(154258);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(154261);
    Log.i("XWCookieManagerWrapper", "removeSessionCookie");
    this.aioL.removeSessionCookie();
    AppMethodBeat.o(154261);
  }
  
  public final void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(212860);
    Log.i("XWCookieManagerWrapper", "setAcceptCookie:".concat("true"));
    this.aioL.setAcceptCookie(true);
    AppMethodBeat.o(212860);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(154260);
    Log.i("XWCookieManagerWrapper", "setCookie, key:".concat(String.valueOf(paramString1)));
    this.aioL.setCookie(paramString1, paramString2);
    AppMethodBeat.o(154260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.e
 * JD-Core Version:    0.7.0.1
 */