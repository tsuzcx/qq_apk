package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;

public final class c
{
  private static c ZZD;
  public CookieInternal.ICookieManagerInternal ZZE;
  
  public static c ivX()
  {
    try
    {
      AppMethodBeat.i(156717);
      if (ZZD == null) {
        ZZD = new c();
      }
      c localc = ZZD;
      AppMethodBeat.o(156717);
      return localc;
    }
    finally {}
  }
  
  public final void f(WebView paramWebView)
  {
    try
    {
      AppMethodBeat.i(156722);
      if (this.ZZE != null) {
        this.ZZE.f(paramWebView);
      }
      AppMethodBeat.o(156722);
      return;
    }
    finally {}
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(156719);
    paramString = this.ZZE.getCookie(paramString);
    AppMethodBeat.o(156719);
    return paramString;
  }
  
  public final void ivY()
  {
    try
    {
      AppMethodBeat.i(156721);
      if (this.ZZE != null) {
        this.ZZE.ivY();
      }
      AppMethodBeat.o(156721);
      return;
    }
    finally {}
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(156718);
    this.ZZE.removeAllCookie();
    AppMethodBeat.o(156718);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156720);
      this.ZZE.setCookie(paramString1, paramString2);
      AppMethodBeat.o(156720);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.c
 * JD-Core Version:    0.7.0.1
 */