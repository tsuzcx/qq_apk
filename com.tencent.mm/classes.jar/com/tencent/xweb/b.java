package com.tencent.xweb;

import com.tencent.xweb.c.b.a;

public final class b
{
  private static b xgp;
  public b.a xgq;
  
  public static b cSe()
  {
    try
    {
      if (xgp == null) {
        xgp = new b();
      }
      b localb = xgp;
      return localb;
    }
    finally {}
  }
  
  public final void c(WebView paramWebView)
  {
    try
    {
      if (this.xgq != null) {
        this.xgq.c(paramWebView);
      }
      return;
    }
    finally
    {
      paramWebView = finally;
      throw paramWebView;
    }
  }
  
  public final void cSf()
  {
    try
    {
      if (this.xgq != null) {
        this.xgq.cSf();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String getCookie(String paramString)
  {
    return this.xgq.getCookie(paramString);
  }
  
  public final void removeAllCookie()
  {
    this.xgq.removeAllCookie();
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    try
    {
      this.xgq.setCookie(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.b
 * JD-Core Version:    0.7.0.1
 */