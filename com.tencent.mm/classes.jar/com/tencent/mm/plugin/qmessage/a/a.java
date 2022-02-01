package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.l;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

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
      ae.f("MicroMsg.QMsg.EventListener", "not bind qq event");
      AppMethodBeat.o(27710);
      return false;
    }
    if (paramak.dlY.dma == 0) {}
    try
    {
      int i = v.aAO() | 0x20;
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(34, Integer.valueOf(i));
      bc.aCg();
      com.tencent.mm.model.c.azE().d(new l("", "", "", "", "", "", "", "", i, "", ""));
      g.dFm();
      ae.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
      AppMethodBeat.o(27710);
      return false;
    }
    catch (Exception paramak)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.QMsg.EventListener", paramak, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.a
 * JD-Core Version:    0.7.0.1
 */