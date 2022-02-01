package com.tencent.xweb.internal;

import android.content.Context;
import com.tencent.xweb.WebView;

public final class CookieInternal
{
  public static abstract interface ICookieManagerInternal
  {
    public abstract void e(WebView paramWebView);
    
    public abstract String getCookie(String paramString);
    
    public abstract void hsq();
    
    public abstract void removeAllCookie();
    
    public abstract void removeSessionCookie();
    
    public abstract void setCookie(String paramString1, String paramString2);
  }
  
  public static abstract interface ICookieSyncManagerInternal
  {
    public abstract void init(Context paramContext);
    
    public abstract void sync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.internal.CookieInternal
 * JD-Core Version:    0.7.0.1
 */