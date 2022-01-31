package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class e$i
  implements a.a
{
  e$i(e parame) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    e.b localb;
    if (e.a(this.nlG))
    {
      localb = e.nlp;
      y.d(e.access$getTAG$cp(), "cancel location");
      return false;
    }
    if (e.c(this.nlG) != null) {
      return false;
    }
    if (paramBoolean)
    {
      o.a(2006, paramFloat1, paramFloat2, (int)paramDouble2);
      localb = e.nlp;
      y.d(e.access$getTAG$cp(), "lat:%f lng:%f accuracy:%f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Double.valueOf(paramDouble2) });
      e.a(this.nlG, new Location(paramFloat2, paramFloat1, (int)paramDouble2, paramInt, "", ""));
      e.e(this.nlG).hq(0L);
    }
    for (;;)
    {
      e.c(this.nlG);
      e.buB();
      return false;
      e.f(this.nlG);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.i
 * JD-Core Version:    0.7.0.1
 */