package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class fd$30
  extends eb<Number>
{
  public final Number a(ff paramff)
  {
    AppMethodBeat.i(147819);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147819);
      return null;
    }
    try
    {
      int i = paramff.m();
      AppMethodBeat.o(147819);
      return Integer.valueOf(i);
    }
    catch (NumberFormatException paramff)
    {
      paramff = new dy(paramff);
      AppMethodBeat.o(147819);
      throw paramff;
    }
  }
  
  public final void a(fh paramfh, Number paramNumber)
  {
    AppMethodBeat.i(147820);
    paramfh.a(paramNumber);
    AppMethodBeat.o(147820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.30
 * JD-Core Version:    0.7.0.1
 */