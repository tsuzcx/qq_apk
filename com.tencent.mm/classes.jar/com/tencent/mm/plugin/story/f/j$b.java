package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class j$b
  implements Runnable
{
  j$b(j paramj, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(109643);
    j.a(this.sCm, this.sBp);
    j.b(this.sCm, this.sBq);
    Object localObject1 = ((ArrayList)j.a(this.sCm).get(this.sBp)).get(this.sBq);
    a.f.b.j.p(localObject1, "dateGalleryMap[row][column]");
    localObject1 = (g)localObject1;
    Object localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    localObject2 = com.tencent.mm.plugin.story.model.j.b.cAB().Gb(((g)localObject1).syr.cIp);
    Object localObject3 = com.tencent.mm.plugin.story.model.j.svi;
    com.tencent.mm.plugin.story.model.j.b.cAB().adF(((g)localObject1).syr.cIp + '_' + ((g)localObject1).syr.fDT);
    if (localObject2 != null)
    {
      ab.i(j.f(this.sCm), "LogStory: deleteItem2 storyinfo " + localObject1 + " deleteItemRow " + j.b(this.sCm) + " deleteItemCol " + j.c(this.sCm) + " localid " + ((g)localObject1).syr.cIp + ' ' + ((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID);
      if (((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID == 0L) {
        break label301;
      }
      if ((j.b(this.sCm) != -1) && (j.c(this.sCm) != -1))
      {
        localObject3 = n.svx;
        n.a.G(((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID, ((g)localObject1).syr.cIp);
      }
    }
    for (;;)
    {
      if (((g)localObject1).syr.cBM())
      {
        localObject2 = com.tencent.mm.plugin.story.model.j.svi;
        com.tencent.mm.plugin.story.model.j.b.coO().post((Runnable)new j.b.1(this, (g)localObject1));
      }
      AppMethodBeat.o(109643);
      return;
      label301:
      localObject2 = n.svx;
      n.a.FH(((g)localObject1).syr.cIp);
      j.g(this.sCm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.j.b
 * JD-Core Version:    0.7.0.1
 */