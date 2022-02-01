package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.sw.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

final class c$2
  extends com.tencent.mm.sdk.b.c<sw>
{
  c$2(c paramc)
  {
    AppMethodBeat.i(161764);
    this.__eventId = sw.class.getName().hashCode();
    AppMethodBeat.o(161764);
  }
  
  private boolean a(sw paramsw)
  {
    AppMethodBeat.i(110788);
    boolean bool = paramsw.dIB.dwL;
    ae.i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (bu.rZ(bu.i((Long)g.ajR().ajA().get(am.a.IUF, Long.valueOf(0L)))) > 60L))
    {
      g.ajR().ajA().set(am.a.IUF, Long.valueOf(bu.aRi()));
      c.a(this.EYr, 2);
    }
    AppMethodBeat.o(110788);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c.2
 * JD-Core Version:    0.7.0.1
 */