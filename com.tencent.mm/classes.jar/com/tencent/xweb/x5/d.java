package com.tencent.xweb.x5;

import com.tencent.smtt.sdk.CookieManager;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.Log;

public final class d
  implements b.a
{
  CookieManager xko = CookieManager.getInstance();
  
  public final void c(com.tencent.xweb.WebView paramWebView)
  {
    if (paramWebView == null)
    {
      Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is null");
      return;
    }
    paramWebView = paramWebView.getWebViewUI();
    if (!(paramWebView instanceof com.tencent.smtt.sdk.WebView))
    {
      Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is not x5 webview");
      return;
    }
    this.xko.setAcceptThirdPartyCookies((com.tencent.smtt.sdk.WebView)paramWebView, true);
  }
  
  public final void cSf()
  {
    this.xko.setAcceptCookie(true);
  }
  
  public final String getCookie(String paramString)
  {
    return this.xko.getCookie(paramString);
  }
  
  public final void removeAllCookie()
  {
    this.xko.removeAllCookie();
  }
  
  public final void removeSessionCookie()
  {
    this.xko.removeSessionCookie();
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    this.xko.setCookie(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.x5.d
 * JD-Core Version:    0.7.0.1
 */