package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class fd$28
  extends eb<Number>
{
  public final Number a(ff paramff)
  {
    AppMethodBeat.i(147807);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147807);
      return null;
    }
    try
    {
      byte b = (byte)paramff.m();
      AppMethodBeat.o(147807);
      return Byte.valueOf(b);
    }
    catch (NumberFormatException paramff)
    {
      paramff = new dy(paramff);
      AppMethodBeat.o(147807);
      throw paramff;
    }
  }
  
  public final void a(fh paramfh, Number paramNumber)
  {
    AppMethodBeat.i(147808);
    paramfh.a(paramNumber);
    AppMethodBeat.o(147808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.28
 * JD-Core Version:    0.7.0.1
 */