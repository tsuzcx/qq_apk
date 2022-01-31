package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.Log;

public final class a
  implements b.a
{
  CookieManager BHg;
  
  public a()
  {
    AppMethodBeat.i(84640);
    this.BHg = CookieManager.getInstance();
    AppMethodBeat.o(84640);
  }
  
  public final void dYh()
  {
    AppMethodBeat.i(84641);
    this.BHg.setAcceptCookie(true);
    AppMethodBeat.o(84641);
  }
  
  public final void f(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(84642);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramWebView != null) && (paramWebView.getWebViewUI() != null) && ((paramWebView.getWebViewUI() instanceof android.webkit.WebView)))
      {
        this.BHg.setAcceptThirdPartyCookies((android.webkit.WebView)paramWebView.getWebViewUI(), true);
        AppMethodBeat.o(84642);
        return;
      }
      Log.e("SysCookieManagerWrapper", "webview kind not match");
    }
    AppMethodBeat.o(84642);
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(84644);
    paramString = this.BHg.getCookie(paramString);
    AppMethodBeat.o(84644);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(84643);
    this.BHg.removeAllCookie();
    AppMethodBeat.o(84643);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(84646);
    this.BHg.removeSessionCookie();
    AppMethodBeat.o(84646);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(84645);
    this.BHg.setCookie(paramString1, paramString2);
    AppMethodBeat.o(84645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.sys.a
 * JD-Core Version:    0.7.0.1
 */