package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.e.a;
import org.xwalk.core.Log;

public final class i
{
  public double JIb;
  public double SDM;
  public double SDN;
  public double[] SDO;
  
  public i()
  {
    AppMethodBeat.i(219071);
    this.SDO = new double[0];
    this.JIb = 1.0D;
    AppMethodBeat.o(219071);
  }
  
  public static i bsy(String paramString)
  {
    AppMethodBeat.i(219072);
    i locali = new i();
    paramString = paramString.replace("(", "-").replace(")", "").split("-");
    if ((paramString == null) || (paramString.length < 2))
    {
      Log.e("getTimeRangeItem", "length error");
      AppMethodBeat.o(219072);
      return null;
    }
    double d = e.bsE(paramString[0]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("getTimeRangeItem", "bind.rangeFrom.timeStart parse error");
      AppMethodBeat.o(219072);
      return null;
    }
    locali.SDM = d;
    d = e.bsE(paramString[1]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("getTimeRangeItem", "bind.rangeFrom.timeEnd parse error");
      AppMethodBeat.o(219072);
      return null;
    }
    locali.SDN = d;
    if (paramString.length == 3)
    {
      paramString = e.bsC(paramString[2]);
      if (!paramString.SEF)
      {
        Log.e("getTimeRangeItem", "scale parse error");
        AppMethodBeat.o(219072);
        return null;
      }
      d = paramString.doubleValue();
      if ((d < 0.0D) || (d > 1000000.0000999999D))
      {
        Log.e("getTimeRangeItem", "scale parse value error");
        AppMethodBeat.o(219072);
        return null;
      }
      locali.JIb = d;
    }
    for (;;)
    {
      AppMethodBeat.o(219072);
      return locali;
      if (paramString.length > 3)
      {
        double[] arrayOfDouble = new double[paramString.length - 2];
        int i = 0;
        while (i + 2 < paramString.length)
        {
          e.a locala = e.bsC(paramString[(i + 2)]);
          if (!locala.SEF)
          {
            Log.e("getTimeRangeItem", "scales parse error");
            AppMethodBeat.o(219072);
            return null;
          }
          d = locala.doubleValue();
          if ((d < 0.0D) || (d > 1000000.0000999999D))
          {
            Log.e("getTimeRangeItem", "scales parse value error");
            AppMethodBeat.o(219072);
            return null;
          }
          arrayOfDouble[i] = d;
          i += 1;
        }
        locali.SDO = arrayOfDouble;
      }
    }
  }
  
  public final double H(double paramDouble)
  {
    int i = 0;
    if ((paramDouble < this.SDM) || (paramDouble > this.SDN)) {
      return 0.0D;
    }
    if ((this.SDO == null) || (this.SDO.length == 0)) {
      return this.JIb;
    }
    if (this.SDO.length == 1) {
      return this.SDO[0];
    }
    if (paramDouble == this.SDN) {
      return this.SDO[(this.SDO.length - 1)];
    }
    int j = this.SDO.length - 1;
    double d1 = (this.SDN - this.SDM) / j;
    paramDouble -= this.SDM;
    while (i < j)
    {
      double d3 = i + 1;
      double d2 = i;
      if (paramDouble <= d3 * d1)
      {
        d3 = this.SDO[i];
        return (this.SDO[(i + 1)] - this.SDO[i]) * (paramDouble - d2 * d1) / d1 + d3;
      }
      i += 1;
    }
    return this.SDO[(this.SDO.length - 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.internal.i
 * JD-Core Version:    0.7.0.1
 */