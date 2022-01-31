package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class fd$3
  extends eb<Number>
{
  public final Number a(ff paramff)
  {
    AppMethodBeat.i(147815);
    fg localfg = paramff.f();
    switch (fd.26.a[localfg.ordinal()])
    {
    case 2: 
    case 3: 
    default: 
      paramff = new dy("Expecting number, got: ".concat(String.valueOf(localfg)));
      AppMethodBeat.o(147815);
      throw paramff;
    case 4: 
      paramff.j();
      AppMethodBeat.o(147815);
      return null;
    }
    paramff = new em(paramff.h());
    AppMethodBeat.o(147815);
    return paramff;
  }
  
  public final void a(fh paramfh, Number paramNumber)
  {
    AppMethodBeat.i(147816);
    paramfh.a(paramNumber);
    AppMethodBeat.o(147816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.3
 * JD-Core Version:    0.7.0.1
 */