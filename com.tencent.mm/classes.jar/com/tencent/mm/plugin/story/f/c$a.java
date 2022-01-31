package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$a
  implements Runnable
{
  c$a(c paramc, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(109555);
    c.a(this.sBo, this.sBp);
    c.b(this.sBo, this.sBq);
    Object localObject1 = ((ArrayList)c.a(this.sBo).get(this.sBp)).get(this.sBq);
    a.f.b.j.p(localObject1, "dateGalleryMap[row][column]");
    localObject1 = (g)localObject1;
    Object localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    localObject2 = j.b.cAB().Gb(((g)localObject1).syr.cIp);
    Object localObject3 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAB().adF(((g)localObject1).syr.cIp + '_' + ((g)localObject1).syr.fDT);
    if (localObject2 != null)
    {
      ab.i(c.g(this.sBo), "LogStory: deleteItem2 storyinfo " + localObject1 + " deleteItemRow " + c.b(this.sBo) + " deleteItemCol " + c.c(this.sBo) + " localid " + ((g)localObject1).syr.cIp + ' ' + ((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID);
      if (((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID == 0L) {
        break label301;
      }
      if ((c.b(this.sBo) != -1) && (c.c(this.sBo) != -1))
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
        j.b.coO().post((Runnable)new c.a.1(this, (g)localObject1));
      }
      AppMethodBeat.o(109555);
      return;
      label301:
      localObject2 = n.svx;
      n.a.FH(((g)localObject1).syr.cIp);
      c.h(this.sBo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.a
 * JD-Core Version:    0.7.0.1
 */