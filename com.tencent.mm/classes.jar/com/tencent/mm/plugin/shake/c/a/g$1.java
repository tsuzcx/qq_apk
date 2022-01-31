package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.ab;

final class g$1
  implements b.a
{
  g$1(g paramg) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(24528);
    if (!paramBoolean)
    {
      AppMethodBeat.o(24528);
      return true;
    }
    if ((g.a(this.qNX) == -85.0F) && (g.b(this.qNX) == -1000.0F))
    {
      g.a(this.qNX, paramFloat2);
      g.b(this.qNX, paramFloat1);
      m.clt().dZu = g.a(this.qNX);
      m.clt().dZv = g.b(this.qNX);
      if (g.c(this.qNX))
      {
        ab.i("MicroMsg.ShakeCardService", "ShakeCardService do netscen from onGetLocation()");
        g.d(this.qNX);
      }
    }
    AppMethodBeat.o(24528);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.g.1
 * JD-Core Version:    0.7.0.1
 */