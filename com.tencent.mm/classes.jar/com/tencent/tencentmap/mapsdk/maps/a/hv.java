package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class hv
{
  public static final hv g;
  public static final hv h;
  public static final hv i;
  public int a;
  public double[] b;
  public long c = -1L;
  public boolean d = false;
  public boolean e;
  public Runnable f;
  private hw j;
  
  static
  {
    AppMethodBeat.i(99620);
    g = new hv(1, null);
    h = new hv(2, null, true);
    i = new hv(104, null);
    AppMethodBeat.o(99620);
  }
  
  public hv() {}
  
  public hv(int paramInt, double[] paramArrayOfDouble)
  {
    this(paramInt, paramArrayOfDouble, false);
  }
  
  public hv(int paramInt, double[] paramArrayOfDouble, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramArrayOfDouble;
    this.e = paramBoolean;
  }
  
  public hv(Runnable paramRunnable)
  {
    this.a = 6;
    this.f = paramRunnable;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  boolean a(hx.a parama)
  {
    AppMethodBeat.i(148117);
    if (this.j != null) {
      this.j.a();
    }
    boolean bool = a();
    parama.a(this);
    AppMethodBeat.o(148117);
    return bool;
  }
  
  public void b()
  {
    AppMethodBeat.i(148118);
    if (this.j != null) {
      this.j.b();
    }
    AppMethodBeat.o(148118);
  }
  
  public void c()
  {
    AppMethodBeat.i(148119);
    if (this.j != null) {
      this.j.c();
    }
    AppMethodBeat.o(148119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hv
 * JD-Core Version:    0.7.0.1
 */