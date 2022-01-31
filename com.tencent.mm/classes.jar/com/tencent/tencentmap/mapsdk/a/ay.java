package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class ay
{
  private ca a = null;
  
  public ay(ca paramca)
  {
    this.a = paramca;
  }
  
  public final dh a(di paramdi)
  {
    AppMethodBeat.i(149782);
    if (this.a == null)
    {
      AppMethodBeat.o(149782);
      return null;
    }
    paramdi = this.a.a(paramdi, this);
    AppMethodBeat.o(149782);
    return paramdi;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a = null;
    }
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(149783);
    if (this.a == null)
    {
      AppMethodBeat.o(149783);
      return;
    }
    this.a.a(paramString);
    AppMethodBeat.o(149783);
  }
  
  public final void a(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149787);
    if (this.a == null)
    {
      AppMethodBeat.o(149787);
      return;
    }
    this.a.a(paramString, paramFloat);
    AppMethodBeat.o(149787);
  }
  
  public final void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(149784);
    if (this.a == null)
    {
      AppMethodBeat.o(149784);
      return;
    }
    this.a.a(paramString, paramInt);
    AppMethodBeat.o(149784);
  }
  
  public final void a(String paramString, List<cz> paramList)
  {
    AppMethodBeat.i(149785);
    if (this.a == null)
    {
      AppMethodBeat.o(149785);
      return;
    }
    this.a.a(paramString, paramList);
    AppMethodBeat.o(149785);
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149788);
    if (this.a == null)
    {
      AppMethodBeat.o(149788);
      return;
    }
    this.a.a(paramString, paramBoolean);
    AppMethodBeat.o(149788);
  }
  
  public List<j> b(String paramString)
  {
    AppMethodBeat.i(149791);
    if (this.a != null)
    {
      paramString = this.a.b(paramString);
      AppMethodBeat.o(149791);
      return paramString;
    }
    AppMethodBeat.o(149791);
    return null;
  }
  
  public final void b()
  {
    AppMethodBeat.i(149790);
    if (this.a == null)
    {
      AppMethodBeat.o(149790);
      return;
    }
    this.a.b();
    AppMethodBeat.o(149790);
  }
  
  public final void b(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149789);
    if (this.a == null)
    {
      AppMethodBeat.o(149789);
      return;
    }
    this.a.b(paramString, paramFloat);
    AppMethodBeat.o(149789);
  }
  
  public final void b(String paramString, int paramInt)
  {
    AppMethodBeat.i(149786);
    if (this.a == null)
    {
      AppMethodBeat.o(149786);
      return;
    }
    this.a.b(paramString, paramInt);
    AppMethodBeat.o(149786);
  }
  
  public void c(String paramString, int paramInt)
  {
    AppMethodBeat.i(149792);
    if (this.a == null)
    {
      AppMethodBeat.o(149792);
      return;
    }
    this.a.c(paramString, paramInt);
    AppMethodBeat.o(149792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ay
 * JD-Core Version:    0.7.0.1
 */