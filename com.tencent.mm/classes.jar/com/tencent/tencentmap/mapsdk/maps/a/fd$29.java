package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class fd$29
  extends eb<Number>
{
  public final Number a(ff paramff)
  {
    AppMethodBeat.i(147811);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147811);
      return null;
    }
    try
    {
      short s = (short)paramff.m();
      AppMethodBeat.o(147811);
      return Short.valueOf(s);
    }
    catch (NumberFormatException paramff)
    {
      paramff = new dy(paramff);
      AppMethodBeat.o(147811);
      throw paramff;
    }
  }
  
  public final void a(fh paramfh, Number paramNumber)
  {
    AppMethodBeat.i(147812);
    paramfh.a(paramNumber);
    AppMethodBeat.o(147812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.29
 * JD-Core Version:    0.7.0.1
 */