package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class iy
  implements ht
{
  private ik a = null;
  private ix b = null;
  private jd c = null;
  
  public iy(ik paramik, jd paramjd)
  {
    this.a = paramik;
    this.c = paramjd;
  }
  
  public void a()
  {
    AppMethodBeat.i(99904);
    if (this.b != null) {
      synchronized (this.b)
      {
        this.b.notify();
        AppMethodBeat.o(99904);
        return;
      }
    }
    AppMethodBeat.o(99904);
  }
  
  public void b()
  {
    AppMethodBeat.i(99905);
    if (this.a == null)
    {
      AppMethodBeat.o(99905);
      return;
    }
    this.a.a().a(this);
    if (this.b == null) {
      this.b = new ix(this.a, this.c);
    }
    try
    {
      this.b.start();
      AppMethodBeat.o(99905);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(99905);
    }
  }
  
  public void c()
  {
    AppMethodBeat.i(99906);
    if (this.b != null) {
      this.b.a();
    }
    AppMethodBeat.o(99906);
  }
  
  public void d()
  {
    AppMethodBeat.i(99909);
    if (this.b != null)
    {
      this.b.b();
      a();
    }
    AppMethodBeat.o(99909);
  }
  
  public void e()
  {
    AppMethodBeat.i(99907);
    if (this.a == null)
    {
      AppMethodBeat.o(99907);
      return;
    }
    this.a.a().b(this);
    if (this.b != null)
    {
      this.b.c();
      this.b = null;
    }
    AppMethodBeat.o(99907);
  }
  
  public void f()
  {
    AppMethodBeat.i(99910);
    e();
    AppMethodBeat.o(99910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.iy
 * JD-Core Version:    0.7.0.1
 */