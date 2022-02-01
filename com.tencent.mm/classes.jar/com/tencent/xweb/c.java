package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;

public final class c
{
  private static c KyF;
  public CookieInternal.ICookieManagerInternal KyG;
  
  public static c fJa()
  {
    try
    {
      AppMethodBeat.i(156717);
      if (KyF == null) {
        KyF = new c();
      }
      c localc = KyF;
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
      if (this.KyG != null) {
        this.KyG.e(paramWebView);
      }
      AppMethodBeat.o(156722);
      return;
    }
    finally {}
  }
  
  public final void fJb()
  {
    try
    {
      AppMethodBeat.i(156721);
      if (this.KyG != null) {
        this.KyG.fJb();
      }
      AppMethodBeat.o(156721);
      return;
    }
    finally {}
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(156719);
    paramString = this.KyG.getCookie(paramString);
    AppMethodBeat.o(156719);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(156718);
    this.KyG.removeAllCookie();
    AppMethodBeat.o(156718);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156720);
      this.KyG.setCookie(paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.c
 * JD-Core Version:    0.7.0.1
 */