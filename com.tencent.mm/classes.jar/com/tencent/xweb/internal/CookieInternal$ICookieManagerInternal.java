package com.tencent.xweb.internal;

import com.tencent.xweb.WebView;

public abstract interface CookieInternal$ICookieManagerInternal
{
  public abstract void b(WebView paramWebView, boolean paramBoolean);
  
  public abstract String getCookie(String paramString);
  
  public abstract void removeAllCookie();
  
  public abstract void removeSessionCookie();
  
  public abstract void setAcceptCookie(boolean paramBoolean);
  
  public abstract void setCookie(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
 * JD-Core Version:    0.7.0.1
 */