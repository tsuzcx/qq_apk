package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

class mz$1
  implements od<md<Double, mu>>
{
  mz$1(mz parammz, double paramDouble, int paramInt, HashMap paramHashMap, ArrayList paramArrayList) {}
  
  public void a(md<Double, mu> parammd)
  {
    AppMethodBeat.i(149359);
    double d1 = ((Double)parammd.a()).doubleValue() / this.a;
    lw locallw = new lw();
    parammd = (mu)parammd.b();
    int i = (int)parammd.b();
    int j = (int)parammd.c();
    locallw.a = (i - i % this.b + this.b / 2);
    locallw.b = (j - j % this.b + this.b / 2);
    parammd = (ly)this.c.get(locallw);
    if (parammd == null)
    {
      parammd = new ly(locallw, d1);
      this.c.put(locallw, parammd);
      this.d.add(parammd);
      AppMethodBeat.o(149359);
      return;
    }
    parammd.a(d1 + parammd.b());
    AppMethodBeat.o(149359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mz.1
 * JD-Core Version:    0.7.0.1
 */