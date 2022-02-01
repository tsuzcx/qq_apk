package com.tencent.xweb.pinus;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.pinus.sdk.CookieManager;
import org.xwalk.core.Log;

public final class b
  implements CookieInternal.ICookieManagerInternal
{
  private CookieManager aikq;
  
  public b()
  {
    AppMethodBeat.i(213316);
    this.aikq = CookieManager.getInstance();
    AppMethodBeat.o(213316);
  }
  
  public final void b(WebView paramWebView, boolean paramBoolean)
  {
    AppMethodBeat.i(213338);
    Log.i("PinusCookieManagerWrapper", "setAcceptThirdPartyCookies:".concat("true"));
    AppMethodBeat.o(213338);
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(213366);
    Log.i("PinusCookieManagerWrapper", "getCookie, url:".concat(String.valueOf(paramString)));
    paramString = this.aikq.getCookie(paramString);
    AppMethodBeat.o(213366);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(213350);
    Log.i("PinusCookieManagerWrapper", "removeAllCookie");
    this.aikq.removeAllCookie();
    AppMethodBeat.o(213350);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(213395);
    Log.i("PinusCookieManagerWrapper", "removeSessionCookie");
    this.aikq.removeSessionCookie();
    AppMethodBeat.o(213395);
  }
  
  public final void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(213327);
    Log.i("PinusCookieManagerWrapper", "setAcceptCookie:".concat("true"));
    this.aikq.setAcceptCookie(true);
    AppMethodBeat.o(213327);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213383);
    Log.i("PinusCookieManagerWrapper", "setCookie, key:".concat(String.valueOf(paramString1)));
    this.aikq.setCookie(paramString1, paramString2);
    AppMethodBeat.o(213383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.b
 * JD-Core Version:    0.7.0.1
 */