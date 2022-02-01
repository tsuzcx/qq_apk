package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import org.xwalk.core.Log;

public final class a
  implements CookieInternal.ICookieManagerInternal
{
  private CookieManager ailZ;
  
  public a()
  {
    AppMethodBeat.i(153648);
    this.ailZ = CookieManager.getInstance();
    AppMethodBeat.o(153648);
  }
  
  public final void b(com.tencent.xweb.WebView paramWebView, boolean paramBoolean)
  {
    AppMethodBeat.i(212651);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramWebView != null) && (paramWebView.getWebViewUI() != null) && ((paramWebView.getWebViewUI() instanceof android.webkit.WebView)))
      {
        this.ailZ.setAcceptThirdPartyCookies((android.webkit.WebView)paramWebView.getWebViewUI(), true);
        AppMethodBeat.o(212651);
        return;
      }
      Log.e("SysCookieManagerWrapper", "setAcceptThirdPartyCookies, webview kind not match");
    }
    AppMethodBeat.o(212651);
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(153652);
    paramString = this.ailZ.getCookie(paramString);
    AppMethodBeat.o(153652);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(153651);
    this.ailZ.removeAllCookie();
    AppMethodBeat.o(153651);
  }
  
  public final void removeSessionCookie()
  {
    AppMethodBeat.i(153654);
    this.ailZ.removeSessionCookie();
    AppMethodBeat.o(153654);
  }
  
  public final void setAcceptCookie(boolean paramBoolean)
  {
    AppMethodBeat.i(212648);
    this.ailZ.setAcceptCookie(true);
    AppMethodBeat.o(212648);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153653);
    this.ailZ.setCookie(paramString1, paramString2);
    AppMethodBeat.o(153653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.a
 * JD-Core Version:    0.7.0.1
 */