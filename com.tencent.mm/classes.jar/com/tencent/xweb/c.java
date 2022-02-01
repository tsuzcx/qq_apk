package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;

public final class c
{
  private static c Mpb;
  public CookieInternal.ICookieManagerInternal Mpc;
  
  public static c gaw()
  {
    try
    {
      AppMethodBeat.i(156717);
      if (Mpb == null) {
        Mpb = new c();
      }
      c localc = Mpb;
      AppMethodBeat.o(156717);
      return localc;
    }
    finally {}
  }
  
  public final void e(WebView paramWebView)
  {
    try
    {
      AppMethodBeat.i(156722);
      if (this.Mpc != null) {
        this.Mpc.e(paramWebView);
      }
      AppMethodBeat.o(156722);
      return;
    }
    finally {}
  }
  
  public final void gax()
  {
    try
    {
      AppMethodBeat.i(156721);
      if (this.Mpc != null) {
        this.Mpc.gax();
      }
      AppMethodBeat.o(156721);
      return;
    }
    finally {}
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(156719);
    paramString = this.Mpc.getCookie(paramString);
    AppMethodBeat.o(156719);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(156718);
    this.Mpc.removeAllCookie();
    AppMethodBeat.o(156718);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156720);
      this.Mpc.setCookie(paramString1, paramString2);
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