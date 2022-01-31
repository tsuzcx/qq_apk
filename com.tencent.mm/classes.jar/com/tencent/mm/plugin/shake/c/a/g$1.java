package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements a.a
{
  g$1(g paramg) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return true;
    }
    if ((g.a(this.nZN) == -85.0F) && (g.b(this.nZN) == -1000.0F))
    {
      g.a(this.nZN, paramFloat2);
      g.b(this.nZN, paramFloat1);
      m.bAa().dia = g.a(this.nZN);
      m.bAa().dib = g.b(this.nZN);
      if (g.c(this.nZN))
      {
        y.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
        g.d(this.nZN);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.g.1
 * JD-Core Version:    0.7.0.1
 */