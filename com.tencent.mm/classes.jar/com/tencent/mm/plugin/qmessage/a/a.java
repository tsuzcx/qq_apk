package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.l;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;

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
      ac.f("MicroMsg.QMsg.EventListener", "not bind qq event");
      AppMethodBeat.o(27710);
      return false;
    }
    if (paramak.cZE.cZG == 0) {}
    try
    {
      int i = u.axI() | 0x20;
      az.ayM();
      com.tencent.mm.model.c.agA().set(34, Integer.valueOf(i));
      az.ayM();
      com.tencent.mm.model.c.awA().c(new l("", "", "", "", "", "", "", "", i, "", ""));
      g.drt();
      ac.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
      AppMethodBeat.o(27710);
      return false;
    }
    catch (Exception paramak)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.QMsg.EventListener", paramak, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.a
 * JD-Core Version:    0.7.0.1
 */