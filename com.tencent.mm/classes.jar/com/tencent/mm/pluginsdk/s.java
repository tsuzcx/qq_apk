package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
{
  public static double c(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(151617);
    paramDouble1 = 3.141592653589793D * paramDouble1 / 180.0D;
    paramDouble3 = 3.141592653589793D * paramDouble3 / 180.0D;
    paramDouble2 = (paramDouble2 - paramDouble4) * 3.141592653589793D / 180.0D;
    paramDouble4 = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    paramDouble1 = Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin(paramDouble2 / 2.0D), 2.0D) + paramDouble4)) * 2.0D * 6378137.0D * 10000.0D) / 10000L;
    AppMethodBeat.o(151617);
    return paramDouble1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.s
 * JD-Core Version:    0.7.0.1
 */