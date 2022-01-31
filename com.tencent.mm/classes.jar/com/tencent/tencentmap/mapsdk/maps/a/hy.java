package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class hy
  implements ia
{
  private ia a;
  
  public hy(ik paramik, jd paramjd)
  {
    AppMethodBeat.i(148130);
    if ((paramik == null) || (paramjd == null))
    {
      AppMethodBeat.o(148130);
      return;
    }
    this.a = new hz(paramik, paramjd);
    AppMethodBeat.o(148130);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(99699);
    if (this.a == null)
    {
      AppMethodBeat.o(99699);
      return;
    }
    this.a.a(paramBoolean);
    AppMethodBeat.o(99699);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(99697);
    if (this.a == null)
    {
      AppMethodBeat.o(99697);
      return false;
    }
    boolean bool = this.a.a();
    AppMethodBeat.o(99697);
    return bool;
  }
  
  public void b()
  {
    AppMethodBeat.i(148131);
    if (this.a == null)
    {
      AppMethodBeat.o(148131);
      return;
    }
    this.a.b();
    AppMethodBeat.o(148131);
  }
  
  public void c()
  {
    AppMethodBeat.i(148132);
    if (this.a == null)
    {
      AppMethodBeat.o(148132);
      return;
    }
    this.a.c();
    AppMethodBeat.o(148132);
  }
  
  public void d()
  {
    AppMethodBeat.i(99702);
    if (this.a == null)
    {
      AppMethodBeat.o(99702);
      return;
    }
    this.a.d();
    AppMethodBeat.o(99702);
  }
  
  public void e()
  {
    AppMethodBeat.i(148133);
    if (this.a == null)
    {
      AppMethodBeat.o(148133);
      return;
    }
    this.a.e();
    this.a = null;
    AppMethodBeat.o(148133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hy
 * JD-Core Version:    0.7.0.1
 */