package com.tencent.mm.storage;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.plugin.webcanvas.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.l;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class p$e
  implements Runnable
{
  p$e(int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(207318);
    Object localObject1 = b.nOV;
    b.bMy().encode("biz_canvas_card_expose_preload_crash_times", this.InZ + 1);
    ad.i("MicroMsg.BizCardLogic", "exposePreload set crash flag");
    localObject1 = ag.aGf().aaH(637534257);
    Object localObject2;
    p localp;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (w)((Iterator)localObject1).next();
        if (Math.abs(((w)localObject2).field_createTime - System.currentTimeMillis()) < 86400000L)
        {
          localp = p.InU;
          d.g.b.p.g(localObject2, "info");
          localp.n((w)localObject2);
          localObject2 = f.DyX;
          f.Cj(12L);
        }
      }
    }
    localObject1 = ag.aGf().aaH(620757041);
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (w)((Iterator)localObject1).next();
        if (Math.abs(((w)localObject2).field_createTime - System.currentTimeMillis()) < 86400000L)
        {
          localp = p.InU;
          d.g.b.p.g(localObject2, "info");
          if (localp.n((w)localObject2))
          {
            localObject2 = f.DyX;
            f.Cj(13L);
          }
        }
      }
    }
    h.LTJ.r((Runnable)1.Ioa, 5000L);
    AppMethodBeat.o(207318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.p.e
 * JD-Core Version:    0.7.0.1
 */