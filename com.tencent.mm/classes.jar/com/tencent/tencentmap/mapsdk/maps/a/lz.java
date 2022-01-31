package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cs.b;

public class lz
  implements cs.b
{
  public int colorForValue(double paramDouble)
  {
    AppMethodBeat.i(149263);
    double d = paramDouble;
    if (paramDouble > 1.0D) {
      d = 1.0D;
    }
    paramDouble = Math.sqrt(d);
    int k = 119;
    if (paramDouble > 0.7D) {
      k = 78;
    }
    for (int j = 1;; j = 3)
    {
      int i;
      if (paramDouble > 0.6D) {
        i = (int)(Math.pow(paramDouble - 0.7D, 3.0D) * 20000.0D + 240.0D);
      }
      for (;;)
      {
        int m = i;
        if (i > 255) {
          m = 255;
        }
        i = Color.argb(m, 255, k, j);
        AppMethodBeat.o(149263);
        return i;
        if (paramDouble > 0.4D) {
          i = (int)(Math.pow(paramDouble - 0.5D, 3.0D) * 20000.0D + 200.0D);
        } else if (paramDouble > 0.2D) {
          i = (int)(Math.pow(paramDouble - 0.3D, 3.0D) * 20000.0D + 160.0D);
        } else {
          i = (int)(paramDouble * 700.0D);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lz
 * JD-Core Version:    0.7.0.1
 */