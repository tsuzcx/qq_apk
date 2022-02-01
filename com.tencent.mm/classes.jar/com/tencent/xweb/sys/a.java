package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import org.xwalk.core.Log;

public final class a
  implements CookieInternal.ICookieManagerInternal
{
  CookieManager aafe;
  
  public a()
  {
    AppMethodBeat.i(153648);
    this.aafe = CookieManager.getInstance();
    AppMethodBeat.o(153648);
  }
  
  public final void f(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(153650);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramWebView != null) && (paramWebView.getWebViewUI() != null) && ((paramWebView.getWebViewUI() instanceof android.webkit.WebView)))
      {
        this.aafe.setAcceptThirdPartyCookies((android.webkit.WebView)paramWebView.getWebViewUI(), true);
        AppMethodBeat.o(153650);
        return;
      }
      Log.e("SysCookieManagerWrapper", "webview kind not match");
    }
    AppMethodBeat.o(153650);
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(153652);
    paramString = this.aafe.getCookie(paramString);
    AppMethodBeat.o(153652);
    return paramString;
  }
  
  public final void ivY()
  {
    AppMethodBeat.i(153649);
    this.aafe.setAcceptCookie(true);
    AppMethodBeat.o(153649);
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(153651);
    this.aafe.removeAllCookie();
    AppMethodBeat.o(153651);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(153654);
    this.aafe.removeSessionCookie();
    AppMethodBeat.o(153654);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153653);
    this.aafe.setCookie(paramString1, paramString2);
    AppMethodBeat.o(153653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.a
 * JD-Core Version:    0.7.0.1
 */