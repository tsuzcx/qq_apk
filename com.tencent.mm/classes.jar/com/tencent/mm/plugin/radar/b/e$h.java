package com.tencent.mm.plugin.radar.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onTimerExpired"})
final class e$h
  implements ap.a
{
  e$h(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(102919);
    if (!e.a(this.pQV))
    {
      e.a(this.pQV, e.f.pQS);
      ab.d(e.access$getTAG$cp(), "status: %s", new Object[] { e.b(this.pQV) });
      Object localObject = e.c(this.pQV);
      if (localObject != null)
      {
        if (((Location)localObject).dlP())
        {
          ab.e(e.access$getTAG$cp(), "error! location is null!");
          AppMethodBeat.o(102919);
          return false;
        }
        ab.d(e.access$getTAG$cp(), "do once search");
        e locale = this.pQV;
        float f1 = ((Location)localObject).fBB;
        float f2 = ((Location)localObject).fBC;
        int i = ((Location)localObject).accuracy;
        int j = ((Location)localObject).cAJ;
        String str = ((Location)localObject).mac;
        j.p(str, "it.mac");
        localObject = ((Location)localObject).cAL;
        j.p(localObject, "it.cellId");
        e.a(locale, new b(1, f1, f2, i, j, str, (String)localObject));
        g.Rc().b((m)e.d(this.pQV));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102919);
      return false;
      ab.e(e.access$getTAG$cp(), "error! location is null!");
      AppMethodBeat.o(102919);
      return false;
      ab.d(e.access$getTAG$cp(), "cancel radar searching");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.h
 * JD-Core Version:    0.7.0.1
 */