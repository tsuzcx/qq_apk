package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import org.xwalk.core.Log;

public final class a
  implements CookieInternal.ICookieManagerInternal
{
  CookieManager MQQ;
  
  public a()
  {
    AppMethodBeat.i(153648);
    this.MQQ = CookieManager.getInstance();
    AppMethodBeat.o(153648);
  }
  
  public final void e(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(153650);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramWebView != null) && (paramWebView.getWebViewUI() != null) && ((paramWebView.getWebViewUI() instanceof android.webkit.WebView)))
      {
        this.MQQ.setAcceptThirdPartyCookies((android.webkit.WebView)paramWebView.getWebViewUI(), true);
        AppMethodBeat.o(153650);
        return;
      }
      Log.e("SysCookieManagerWrapper", "webview kind not match");
    }
    AppMethodBeat.o(153650);
  }
  
  public final void geZ()
  {
    AppMethodBeat.i(153649);
    this.MQQ.setAcceptCookie(true);
    AppMethodBeat.o(153649);
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(153652);
    paramString = this.MQQ.getCookie(paramString);
    AppMethodBeat.o(153652);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(153651);
    this.MQQ.removeAllCookie();
    AppMethodBeat.o(153651);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(153654);
    this.MQQ.removeSessionCookie();
    AppMethodBeat.o(153654);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153653);
    this.MQQ.setCookie(paramString1, paramString2);
    AppMethodBeat.o(153653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.a
 * JD-Core Version:    0.7.0.1
 */