package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class e$h
  implements am.a
{
  e$h(e parame) {}
  
  public final boolean tC()
  {
    if (!e.a(this.nlG))
    {
      e.a(this.nlG, e.f.nlD);
      localObject1 = e.nlp;
      y.d(e.access$getTAG$cp(), "status: %s", new Object[] { e.b(this.nlG) });
      localObject1 = e.c(this.nlG);
      if (localObject1 != null)
      {
        if (((Location)localObject1).clg())
        {
          localObject1 = e.nlp;
          y.e(e.access$getTAG$cp(), "error! location is null!");
          return false;
        }
        Object localObject2 = e.nlp;
        y.d(e.access$getTAG$cp(), "do once search");
        localObject2 = this.nlG;
        float f1 = ((Location)localObject1).elk;
        float f2 = ((Location)localObject1).ell;
        int i = ((Location)localObject1).accuracy;
        int j = ((Location)localObject1).bTe;
        String str = ((Location)localObject1).mac;
        a.d.b.g.j(str, "it.mac");
        localObject1 = ((Location)localObject1).bTg;
        a.d.b.g.j(localObject1, "it.cellId");
        e.a((e)localObject2, new b(1, f1, f2, i, j, str, (String)localObject1));
        com.tencent.mm.kernel.g.Dk().d((m)e.d(this.nlG));
        return false;
      }
      localObject1 = e.nlp;
      y.e(e.access$getTAG$cp(), "error! location is null!");
      return false;
    }
    Object localObject1 = e.nlp;
    y.d(e.access$getTAG$cp(), "cancel radar searching");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.h
 * JD-Core Version:    0.7.0.1
 */