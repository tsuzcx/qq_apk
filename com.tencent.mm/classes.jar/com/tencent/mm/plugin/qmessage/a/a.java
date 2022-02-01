package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.l;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;

final class a
  extends com.tencent.mm.sdk.b.c<ak>
{
  a()
  {
    AppMethodBeat.i(161424);
    this.__eventId = ak.class.getName().hashCode();
    AppMethodBeat.o(161424);
  }
  
  private static boolean a(ak paramak)
  {
    AppMethodBeat.i(27710);
    if (!(paramak instanceof ak))
    {
      ad.f("MicroMsg.QMsg.EventListener", "not bind qq event");
      AppMethodBeat.o(27710);
      return false;
    }
    if (paramak.dkW.dkY == 0) {}
    try
    {
      int i = u.aAy() | 0x20;
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(34, Integer.valueOf(i));
      ba.aBQ();
      com.tencent.mm.model.c.azo().c(new l("", "", "", "", "", "", "", "", i, "", ""));
      g.dBV();
      ad.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
      AppMethodBeat.o(27710);
      return false;
    }
    catch (Exception paramak)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.QMsg.EventListener", paramak, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.a
 * JD-Core Version:    0.7.0.1
 */