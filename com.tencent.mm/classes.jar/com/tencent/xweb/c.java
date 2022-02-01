package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;

public final class c
{
  private static c aiem;
  CookieInternal.ICookieManagerInternal aien;
  
  public static c kfo()
  {
    try
    {
      AppMethodBeat.i(156717);
      if (aiem == null) {
        aiem = new c();
      }
      c localc = aiem;
      AppMethodBeat.o(156717);
      return localc;
    }
    finally {}
  }
  
  @Deprecated
  public final void g(WebView paramWebView)
  {
    try
    {
      AppMethodBeat.i(156722);
      if (this.aien != null) {
        this.aien.b(paramWebView, true);
      }
      AppMethodBeat.o(156722);
      return;
    }
    finally {}
  }
  
  @Deprecated
  public final void kfp()
  {
    try
    {
      AppMethodBeat.i(156721);
      if (this.aien != null) {
        this.aien.setAcceptCookie(true);
      }
      AppMethodBeat.o(156721);
      return;
    }
    finally {}
  }
  
  @Deprecated
  public final void setCookie(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(156720);
      if (this.aien != null) {
        this.aien.setCookie(paramString1, paramString2);
      }
      AppMethodBeat.o(156720);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.c
 * JD-Core Version:    0.7.0.1
 */