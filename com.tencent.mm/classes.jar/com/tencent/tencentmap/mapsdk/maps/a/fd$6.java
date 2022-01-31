package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;

final class fd$6
  extends eb<BigDecimal>
{
  public final BigDecimal a(ff paramff)
  {
    AppMethodBeat.i(147839);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147839);
      return null;
    }
    try
    {
      paramff = new BigDecimal(paramff.h());
      AppMethodBeat.o(147839);
      return paramff;
    }
    catch (NumberFormatException paramff)
    {
      paramff = new dy(paramff);
      AppMethodBeat.o(147839);
      throw paramff;
    }
  }
  
  public final void a(fh paramfh, BigDecimal paramBigDecimal)
  {
    AppMethodBeat.i(147840);
    paramfh.a(paramBigDecimal);
    AppMethodBeat.o(147840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.6
 * JD-Core Version:    0.7.0.1
 */