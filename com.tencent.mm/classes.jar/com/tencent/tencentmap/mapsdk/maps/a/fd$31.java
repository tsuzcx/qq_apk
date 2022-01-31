package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class fd$31
  extends eb<Number>
{
  public final Number a(ff paramff)
  {
    AppMethodBeat.i(147823);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147823);
      return null;
    }
    try
    {
      long l = paramff.l();
      AppMethodBeat.o(147823);
      return Long.valueOf(l);
    }
    catch (NumberFormatException paramff)
    {
      paramff = new dy(paramff);
      AppMethodBeat.o(147823);
      throw paramff;
    }
  }
  
  public final void a(fh paramfh, Number paramNumber)
  {
    AppMethodBeat.i(147824);
    paramfh.a(paramNumber);
    AppMethodBeat.o(147824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.31
 * JD-Core Version:    0.7.0.1
 */