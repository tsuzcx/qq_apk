package com.tencent.xweb.pinus.sdk;

import android.webkit.ValueCallback;

public abstract interface CookieManagerInterface
{
  public abstract boolean acceptCookie();
  
  public abstract boolean allowFileSchemeCookies();
  
  public abstract void flush();
  
  public abstract String getCookie(String paramString);
  
  public abstract boolean hasCookies();
  
  public abstract void removeAllCookie();
  
  public abstract void removeAllCookie(ValueCallback<Boolean> paramValueCallback);
  
  public abstract void removeExpiredCookie();
  
  public abstract void removeSessionCookie();
  
  public abstract void removeSessionCookie(ValueCallback<Boolean> paramValueCallback);
  
  public abstract void setAcceptCookie(boolean paramBoolean);
  
  public abstract void setAcceptFileSchemeCookies(boolean paramBoolean);
  
  public abstract void setCookie(String paramString1, String paramString2);
  
  public abstract void setCookie(String paramString1, String paramString2, ValueCallback<Boolean> paramValueCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.CookieManagerInterface
 * JD-Core Version:    0.7.0.1
 */