package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class ba
{
  private cb a = null;
  
  public ba(cb paramcb)
  {
    this.a = paramcb;
  }
  
  public final dj a(dk paramdk)
  {
    AppMethodBeat.i(100727);
    if (this.a == null)
    {
      AppMethodBeat.o(100727);
      return null;
    }
    paramdk = this.a.a(paramdk, this);
    AppMethodBeat.o(100727);
    return paramdk;
  }
  
  public final void a()
  {
    if (this.a != null) {
      this.a = null;
    }
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(100728);
    if (this.a == null)
    {
      AppMethodBeat.o(100728);
      return;
    }
    this.a.a(paramString);
    AppMethodBeat.o(100728);
  }
  
  public final void a(String paramString, float paramFloat)
  {
    AppMethodBeat.i(100732);
    if (this.a == null)
    {
      AppMethodBeat.o(100732);
      return;
    }
    this.a.a(paramString, paramFloat);
    AppMethodBeat.o(100732);
  }
  
  public final void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(100729);
    if (this.a == null)
    {
      AppMethodBeat.o(100729);
      return;
    }
    this.a.a(paramString, paramInt);
    AppMethodBeat.o(100729);
  }
  
  public final void a(String paramString, int paramInt, cz paramcz)
  {
    AppMethodBeat.i(149808);
    if (this.a == null)
    {
      AppMethodBeat.o(149808);
      return;
    }
    this.a.a(paramString, paramInt, paramcz);
    AppMethodBeat.o(149808);
  }
  
  public final void a(String paramString, ck paramck)
  {
    AppMethodBeat.i(149807);
    if (this.a == null)
    {
      AppMethodBeat.o(149807);
      return;
    }
    this.a.a(paramString, paramck);
    AppMethodBeat.o(149807);
  }
  
  public final void a(String paramString, List<cz> paramList)
  {
    AppMethodBeat.i(100730);
    if (this.a == null)
    {
      AppMethodBeat.o(100730);
      return;
    }
    this.a.a(paramString, paramList);
    AppMethodBeat.o(100730);
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(100733);
    if (this.a == null)
    {
      AppMethodBeat.o(100733);
      return;
    }
    this.a.a(paramString, paramBoolean);
    AppMethodBeat.o(100733);
  }
  
  public final List<j> b(String paramString)
  {
    AppMethodBeat.i(100736);
    if (this.a != null)
    {
      paramString = this.a.b(paramString);
      AppMethodBeat.o(100736);
      return paramString;
    }
    AppMethodBeat.o(100736);
    return null;
  }
  
  public final void b()
  {
    AppMethodBeat.i(100735);
    if (this.a == null)
    {
      AppMethodBeat.o(100735);
      return;
    }
    this.a.b();
    AppMethodBeat.o(100735);
  }
  
  public final void b(String paramString, float paramFloat)
  {
    AppMethodBeat.i(100734);
    if (this.a == null)
    {
      AppMethodBeat.o(100734);
      return;
    }
    this.a.b(paramString, paramFloat);
    AppMethodBeat.o(100734);
  }
  
  public final void b(String paramString, int paramInt)
  {
    AppMethodBeat.i(100731);
    if (this.a == null)
    {
      AppMethodBeat.o(100731);
      return;
    }
    this.a.b(paramString, paramInt);
    AppMethodBeat.o(100731);
  }
  
  public final void b(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149809);
    if (this.a == null)
    {
      AppMethodBeat.o(149809);
      return;
    }
    this.a.b(paramString, paramBoolean);
    AppMethodBeat.o(149809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ba
 * JD-Core Version:    0.7.0.1
 */