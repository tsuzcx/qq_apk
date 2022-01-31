package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;

final class fd$7
  extends eb<BigInteger>
{
  public final BigInteger a(ff paramff)
  {
    AppMethodBeat.i(147843);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147843);
      return null;
    }
    try
    {
      paramff = new BigInteger(paramff.h());
      AppMethodBeat.o(147843);
      return paramff;
    }
    catch (NumberFormatException paramff)
    {
      paramff = new dy(paramff);
      AppMethodBeat.o(147843);
      throw paramff;
    }
  }
  
  public final void a(fh paramfh, BigInteger paramBigInteger)
  {
    AppMethodBeat.i(147844);
    paramfh.a(paramBigInteger);
    AppMethodBeat.o(147844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.7
 * JD-Core Version:    0.7.0.1
 */