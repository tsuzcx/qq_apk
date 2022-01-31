package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class hb$a
  extends hb
{
  double d;
  
  hb$a(float paramFloat)
  {
    this.a = paramFloat;
    this.b = Double.TYPE;
  }
  
  hb$a(float paramFloat, double paramDouble)
  {
    this.a = paramFloat;
    this.d = paramDouble;
    this.b = Double.TYPE;
    this.c = true;
  }
  
  public Object a()
  {
    AppMethodBeat.i(148032);
    double d1 = this.d;
    AppMethodBeat.o(148032);
    return Double.valueOf(d1);
  }
  
  public a e()
  {
    AppMethodBeat.i(148033);
    a locala = new a(b(), this.d);
    locala.a(c());
    AppMethodBeat.o(148033);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hb.a
 * JD-Core Version:    0.7.0.1
 */