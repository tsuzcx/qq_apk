package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;

public final class c
{
  private static c MLX;
  public CookieInternal.ICookieManagerInternal MLY;
  
  public static c geY()
  {
    try
    {
      AppMethodBeat.i(156717);
      if (MLX == null) {
        MLX = new c();
      }
      c localc = MLX;
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
      if (this.MLY != null) {
        this.MLY.e(paramWebView);
      }
      AppMethodBeat.o(156722);
      return;
    }
    finally {}
  }
  
  public final void geZ()
  {
    try
    {
      AppMethodBeat.i(156721);
      if (this.MLY != null) {
        this.MLY.geZ();
      }
      AppMethodBeat.o(156721);
      return;
    }
    finally {}
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(156719);
    paramString = this.MLY.getCookie(paramString);
    AppMethodBeat.o(156719);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(156718);
    this.MLY.removeAllCookie();
    AppMethodBeat.o(156718);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156720);
      this.MLY.setCookie(paramString1, paramString2);
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