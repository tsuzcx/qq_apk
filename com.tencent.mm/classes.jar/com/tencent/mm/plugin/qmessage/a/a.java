package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.k;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.aj.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;

final class a
  extends com.tencent.mm.sdk.b.c<aj>
{
  a()
  {
    AppMethodBeat.i(161424);
    this.__eventId = aj.class.getName().hashCode();
    AppMethodBeat.o(161424);
  }
  
  private static boolean a(aj paramaj)
  {
    AppMethodBeat.i(27710);
    if (!(paramaj instanceof aj))
    {
      ad.f("MicroMsg.QMsg.EventListener", "not bind qq event");
      AppMethodBeat.o(27710);
      return false;
    }
    if (paramaj.dcf.dch == 0) {}
    try
    {
      int i = u.aqS() | 0x20;
      az.arV();
      com.tencent.mm.model.c.afk().set(34, Integer.valueOf(i));
      az.arV();
      com.tencent.mm.model.c.apL().c(new k("", "", "", "", "", "", "", "", i, "", ""));
      g.ddL();
      ad.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
      AppMethodBeat.o(27710);
      return false;
    }
    catch (Exception paramaj)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.QMsg.EventListener", paramaj, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.a
 * JD-Core Version:    0.7.0.1
 */