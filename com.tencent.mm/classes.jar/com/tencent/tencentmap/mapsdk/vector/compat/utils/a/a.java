package com.tencent.tencentmap.mapsdk.vector.compat.utils.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public final double a;
  public final double b;
  public final double c;
  public final double d;
  public final double e;
  public final double f;
  
  public a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(247343);
    this.a = paramDouble1;
    this.b = paramDouble3;
    this.c = paramDouble2;
    this.d = paramDouble4;
    this.e = ((paramDouble1 + paramDouble2) / 2.0D);
    this.f = ((paramDouble3 + paramDouble4) / 2.0D);
    AppMethodBeat.o(247343);
  }
  
  public boolean a(double paramDouble1, double paramDouble2)
  {
    return (this.a <= paramDouble1) && (paramDouble1 <= this.c) && (this.b <= paramDouble2) && (paramDouble2 <= this.d);
  }
  
  public boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return (paramDouble1 < this.c) && (this.a < paramDouble2) && (paramDouble3 < this.d) && (this.b < paramDouble4);
  }
  
  public boolean a(a parama)
  {
    AppMethodBeat.i(247347);
    boolean bool = a(parama.a, parama.c, parama.b, parama.d);
    AppMethodBeat.o(247347);
    return bool;
  }
  
  public boolean a(b paramb)
  {
    AppMethodBeat.i(247346);
    boolean bool = a(paramb.a, paramb.b);
    AppMethodBeat.o(247346);
    return bool;
  }
  
  public boolean b(a parama)
  {
    return (parama.a >= this.a) && (parama.c <= this.c) && (parama.b >= this.b) && (parama.d <= this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.a.a
 * JD-Core Version:    0.7.0.1
 */