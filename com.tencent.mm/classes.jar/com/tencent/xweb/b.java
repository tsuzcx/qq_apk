package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.b.a;

public final class b
{
  private static b BCU;
  public b.a BCV;
  
  public static b dYg()
  {
    try
    {
      AppMethodBeat.i(3795);
      if (BCU == null) {
        BCU = new b();
      }
      b localb = BCU;
      AppMethodBeat.o(3795);
      return localb;
    }
    finally {}
  }
  
  public final void dYh()
  {
    try
    {
      AppMethodBeat.i(3799);
      if (this.BCV != null) {
        this.BCV.dYh();
      }
      AppMethodBeat.o(3799);
      return;
    }
    finally {}
  }
  
  public final void f(WebView paramWebView)
  {
    try
    {
      AppMethodBeat.i(3800);
      if (this.BCV != null) {
        this.BCV.f(paramWebView);
      }
      AppMethodBeat.o(3800);
      return;
    }
    finally {}
  }
  
  public final String getCookie(String paramString)
  {
    AppMethodBeat.i(3797);
    paramString = this.BCV.getCookie(paramString);
    AppMethodBeat.o(3797);
    return paramString;
  }
  
  public final void removeAllCookie()
  {
    AppMethodBeat.i(3796);
    this.BCV.removeAllCookie();
    AppMethodBeat.o(3796);
  }
  
  public final void setCookie(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(3798);
      this.BCV.setCookie(paramString1, paramString2);
      AppMethodBeat.o(3798);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.b
 * JD-Core Version:    0.7.0.1
 */