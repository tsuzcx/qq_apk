package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.sv.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

final class c$2
  extends com.tencent.mm.sdk.b.c<sv>
{
  c$2(c paramc)
  {
    AppMethodBeat.i(161764);
    this.__eventId = sv.class.getName().hashCode();
    AppMethodBeat.o(161764);
  }
  
  private boolean a(sv paramsv)
  {
    AppMethodBeat.i(110788);
    boolean bool = paramsv.dHw.dvG;
    ad.i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (bt.rM(bt.g((Long)g.ajC().ajl().get(al.a.IAg, Long.valueOf(0L)))) > 60L))
    {
      g.ajC().ajl().set(al.a.IAg, Long.valueOf(bt.aQJ()));
      c.a(this.EFV, 2);
    }
    AppMethodBeat.o(110788);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c.2
 * JD-Core Version:    0.7.0.1
 */