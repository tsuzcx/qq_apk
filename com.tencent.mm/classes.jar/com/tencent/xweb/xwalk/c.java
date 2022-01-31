package com.tencent.xweb.xwalk;

import com.tencent.xweb.WebView;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.XWalkCookieManager;

public final class c
  implements b.a
{
  XWalkCookieManager xlO = new XWalkCookieManager();
  
  public final void c(WebView paramWebView) {}
  
  public final void cSf()
  {
    this.xlO.setAcceptCookie(true);
  }
  
  public final String getCookie(String paramString)
  {
    return this.xlO.getCookie(paramString);
  }
  
  public final void removeAllCookie()
  {
    this.xlO.removeAllCookie();
  }
  
  public final void removeSessionCookie()
  {
    this.xlO.removeSessionCookie();
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    this.xlO.setCookie(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c
 * JD-Core Version:    0.7.0.1
 */