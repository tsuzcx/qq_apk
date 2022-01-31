package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.Log;

public final class a
  implements b.a
{
  CookieManager xjB = CookieManager.getInstance();
  
  public final void c(com.tencent.xweb.WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramWebView != null) && (paramWebView.getWebViewUI() != null) && ((paramWebView.getWebViewUI() instanceof android.webkit.WebView))) {
        this.xjB.setAcceptThirdPartyCookies((android.webkit.WebView)paramWebView.getWebViewUI(), true);
      }
    }
    else {
      return;
    }
    Log.e("SysCookieManagerWrapper", "webview kind not match");
  }
  
  public final void cSf()
  {
    this.xjB.setAcceptCookie(true);
  }
  
  public final String getCookie(String paramString)
  {
    return this.xjB.getCookie(paramString);
  }
  
  public final void removeAllCookie()
  {
    this.xjB.removeAllCookie();
  }
  
  public final void removeSessionCookie()
  {
    this.xjB.removeSessionCookie();
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    this.xjB.setCookie(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.sys.a
 * JD-Core Version:    0.7.0.1
 */