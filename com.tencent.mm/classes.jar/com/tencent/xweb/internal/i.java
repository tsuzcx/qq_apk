package com.tencent.xweb.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.e.a;
import org.xwalk.core.Log;

public final class i
{
  public double QHt;
  public double aaeW;
  public double aaeX;
  public double[] aaeY;
  
  public i()
  {
    AppMethodBeat.i(197667);
    this.aaeY = new double[0];
    this.QHt = 1.0D;
    AppMethodBeat.o(197667);
  }
  
  public static i bFx(String paramString)
  {
    AppMethodBeat.i(197693);
    i locali = new i();
    paramString = paramString.replace("(", "-").replace(")", "").split("-");
    if ((paramString == null) || (paramString.length < 2))
    {
      Log.e("getTimeRangeItem", "length error");
      AppMethodBeat.o(197693);
      return null;
    }
    double d = e.bFD(paramString[0]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("getTimeRangeItem", "bind.rangeFrom.timeStart parse error");
      AppMethodBeat.o(197693);
      return null;
    }
    locali.aaeW = d;
    d = e.bFD(paramString[1]);
    if ((d < 0.0D) || (d > 24.0D))
    {
      Log.e("getTimeRangeItem", "bind.rangeFrom.timeEnd parse error");
      AppMethodBeat.o(197693);
      return null;
    }
    locali.aaeX = d;
    if (paramString.length == 3)
    {
      paramString = e.bFB(paramString[2]);
      if (!paramString.aafP)
      {
        Log.e("getTimeRangeItem", "scale parse error");
        AppMethodBeat.o(197693);
        return null;
      }
      d = paramString.doubleValue();
      if ((d < 0.0D) || (d > 1000000.0000999999D))
      {
        Log.e("getTimeRangeItem", "scale parse value error");
        AppMethodBeat.o(197693);
        return null;
      }
      locali.QHt = d;
    }
    for (;;)
    {
      AppMethodBeat.o(197693);
      return locali;
      if (paramString.length > 3)
      {
        double[] arrayOfDouble = new double[paramString.length - 2];
        int i = 0;
        while (i + 2 < paramString.length)
        {
          e.a locala = e.bFB(paramString[(i + 2)]);
          if (!locala.aafP)
          {
            Log.e("getTimeRangeItem", "scales parse error");
            AppMethodBeat.o(197693);
            return null;
          }
          d = locala.doubleValue();
          if ((d < 0.0D) || (d > 1000000.0000999999D))
          {
            Log.e("getTimeRangeItem", "scales parse value error");
            AppMethodBeat.o(197693);
            return null;
          }
          arrayOfDouble[i] = d;
          i += 1;
        }
        locali.aaeY = arrayOfDouble;
      }
    }
  }
  
  public final double J(double paramDouble)
  {
    int i = 0;
    if ((paramDouble < this.aaeW) || (paramDouble > this.aaeX)) {
      return 0.0D;
    }
    if ((this.aaeY == null) || (this.aaeY.length == 0)) {
      return this.QHt;
    }
    if (this.aaeY.length == 1) {
      return this.aaeY[0];
    }
    if (paramDouble == this.aaeX) {
      return this.aaeY[(this.aaeY.length - 1)];
    }
    int j = this.aaeY.length - 1;
    double d1 = (this.aaeX - this.aaeW) / j;
    paramDouble -= this.aaeW;
    while (i < j)
    {
      double d3 = i + 1;
      double d2 = i;
      if (paramDouble <= d3 * d1)
      {
        d3 = this.aaeY[i];
        return (this.aaeY[(i + 1)] - this.aaeY[i]) * (paramDouble - d2 * d1) / d1 + d3;
      }
      i += 1;
    }
    return this.aaeY[(this.aaeY.length - 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.internal.i
 * JD-Core Version:    0.7.0.1
 */