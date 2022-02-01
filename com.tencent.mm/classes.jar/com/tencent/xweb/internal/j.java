package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.i;
import com.tencent.xweb.util.i.a;
import org.xwalk.core.Log;

public final class j
{
  public double XAR;
  public double aikg;
  public double aikh;
  public double[] aiki;
  
  public j()
  {
    AppMethodBeat.i(212568);
    this.XAR = 1.0D;
    this.aiki = new double[0];
    AppMethodBeat.o(212568);
  }
  
  public static j bHR(String paramString)
  {
    AppMethodBeat.i(212575);
    j localj = new j();
    paramString = paramString.replace("(", "-").replace(")", "").split("-");
    if ((paramString == null) || (paramString.length < 2))
    {
      Log.e("TimeRange", "getTimeRange, length error");
      AppMethodBeat.o(212575);
      return null;
    }
    double d = i.bIc(paramString[0]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("TimeRange", "getTimeRange, bind.rangeFrom.timeStart parse error");
      AppMethodBeat.o(212575);
      return null;
    }
    localj.aikg = d;
    d = i.bIc(paramString[1]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("TimeRange", "getTimeRange, bind.rangeFrom.timeEnd parse error");
      AppMethodBeat.o(212575);
      return null;
    }
    localj.aikh = d;
    if (paramString.length == 3)
    {
      paramString = i.bIa(paramString[2]);
      if (!paramString.aimD)
      {
        Log.e("TimeRange", "getTimeRange, scale parse error");
        AppMethodBeat.o(212575);
        return null;
      }
      d = paramString.doubleValue();
      if ((d < 0.0D) || (d > 1000000.0000999999D))
      {
        Log.e("TimeRange", "getTimeRange, scale parse value error");
        AppMethodBeat.o(212575);
        return null;
      }
      localj.XAR = d;
    }
    for (;;)
    {
      AppMethodBeat.o(212575);
      return localj;
      if (paramString.length > 3)
      {
        double[] arrayOfDouble = new double[paramString.length - 2];
        int i = 0;
        while (i + 2 < paramString.length)
        {
          i.a locala = i.bIa(paramString[(i + 2)]);
          if (!locala.aimD)
          {
            Log.e("TimeRange", "getTimeRange, scales parse error");
            AppMethodBeat.o(212575);
            return null;
          }
          d = locala.doubleValue();
          if ((d < 0.0D) || (d > 1000000.0000999999D))
          {
            Log.e("TimeRange", "getTimeRange, scales parse value error");
            AppMethodBeat.o(212575);
            return null;
          }
          arrayOfDouble[i] = d;
          i += 1;
        }
        localj.aiki = arrayOfDouble;
      }
    }
  }
  
  public final double ae(double paramDouble)
  {
    int i = 0;
    if ((paramDouble < this.aikg) || (paramDouble > this.aikh)) {
      return 0.0D;
    }
    if ((this.aiki == null) || (this.aiki.length == 0)) {
      return this.XAR;
    }
    if (this.aiki.length == 1) {
      return this.aiki[0];
    }
    if (paramDouble == this.aikh) {
      return this.aiki[(this.aiki.length - 1)];
    }
    int j = this.aiki.length - 1;
    double d1 = (this.aikh - this.aikg) / j;
    paramDouble -= this.aikg;
    while (i < j)
    {
      double d3 = i + 1;
      double d2 = i;
      if (paramDouble <= d3 * d1)
      {
        d3 = this.aiki[i];
        return (this.aiki[(i + 1)] - this.aiki[i]) * (paramDouble - d2 * d1) / d1 + d3;
      }
      i += 1;
    }
    return this.aiki[(this.aiki.length - 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.internal.j
 * JD-Core Version:    0.7.0.1
 */