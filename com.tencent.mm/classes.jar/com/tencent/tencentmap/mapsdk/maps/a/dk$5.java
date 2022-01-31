package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class dk$5
  extends eb<Number>
{
  dk$5(dk paramdk) {}
  
  public Number a(ff paramff)
  {
    AppMethodBeat.i(147460);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147460);
      return null;
    }
    long l = paramff.l();
    AppMethodBeat.o(147460);
    return Long.valueOf(l);
  }
  
  public void a(fh paramfh, Number paramNumber)
  {
    AppMethodBeat.i(147461);
    if (paramNumber == null)
    {
      paramfh.f();
      AppMethodBeat.o(147461);
      return;
    }
    paramfh.b(paramNumber.toString());
    AppMethodBeat.o(147461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.dk.5
 * JD-Core Version:    0.7.0.1
 */