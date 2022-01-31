package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class dk$4
  extends eb<Number>
{
  dk$4(dk paramdk) {}
  
  public Float a(ff paramff)
  {
    AppMethodBeat.i(147456);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147456);
      return null;
    }
    float f = (float)paramff.k();
    AppMethodBeat.o(147456);
    return Float.valueOf(f);
  }
  
  public void a(fh paramfh, Number paramNumber)
  {
    AppMethodBeat.i(147457);
    if (paramNumber == null)
    {
      paramfh.f();
      AppMethodBeat.o(147457);
      return;
    }
    float f = paramNumber.floatValue();
    dk.a(this.a, f);
    paramfh.a(paramNumber);
    AppMethodBeat.o(147457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.dk.4
 * JD-Core Version:    0.7.0.1
 */