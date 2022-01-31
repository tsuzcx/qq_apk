package com.tencent.mm.plugin.radar.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/model/RadarAddContact$verifyContact$add$1", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContactHelper;", "canAddContact", "", "ok", "", "hasSentVerify", "respUsername", "", "errMsg", "plugin-radar_release"})
public final class c$m
  implements c.d
{
  public c$m(String paramString, long paramLong) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(102883);
    if (paramBoolean1)
    {
      Object localObject1 = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(localObject1, "service(IMessengerStorage::class.java)");
      Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject1).YA().arw(paramString1);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        paramBoolean2 = paramBoolean1;
        if (((ad)localObject2).Od() != 0) {}
      }
      else
      {
        localObject1 = c.a(bi.d.asm(this.pQg));
        localObject2 = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        a.f.b.j.p(localObject2, "service(IMessengerStorage::class.java)");
        if (!((com.tencent.mm.plugin.messenger.foundation.a.j)localObject2).YA().Y((ad)localObject1))
        {
          ab.e(c.access$getTAG$cp(), "canAddContact fail, insert fail");
          paramBoolean1 = false;
        }
        localObject2 = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        a.f.b.j.p(localObject2, "service(IMessengerStorage::class.java)");
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject2).YA().arw(((ad)localObject1).getUsername());
        paramBoolean2 = paramBoolean1;
      }
      ab.d(c.access$getTAG$cp(), "verifyContact return ok");
      t.q((ad)localObject1);
      c.dc(paramString1, 1);
    }
    for (;;)
    {
      c.a(this.pPT, paramBoolean2, paramString2, paramString1, this.pPZ);
      AppMethodBeat.o(102883);
      return;
      ab.d(c.access$getTAG$cp(), "verifyContact return not ok");
      paramBoolean2 = paramBoolean1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c.m
 * JD-Core Version:    0.7.0.1
 */