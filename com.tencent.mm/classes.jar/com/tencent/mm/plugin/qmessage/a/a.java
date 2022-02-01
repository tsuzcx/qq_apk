package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.l;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.am.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

final class a
  extends IListener<am>
{
  a()
  {
    AppMethodBeat.i(161424);
    this.__eventId = am.class.getName().hashCode();
    AppMethodBeat.o(161424);
  }
  
  private static boolean a(am paramam)
  {
    AppMethodBeat.i(27710);
    if (!(paramam instanceof am))
    {
      Log.f("MicroMsg.QMsg.EventListener", "not bind qq event");
      AppMethodBeat.o(27710);
      return false;
    }
    if (paramam.dDo.dDq == 0) {}
    try
    {
      int i = z.aUl() | 0x20;
      bg.aVF();
      c.azQ().set(34, Integer.valueOf(i));
      bg.aVF();
      c.aSM().d(new l("", "", "", "", "", "", "", "", i, "", ""));
      g.eGb();
      Log.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
      AppMethodBeat.o(27710);
      return false;
    }
    catch (Exception paramam)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.QMsg.EventListener", paramam, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.a
 * JD-Core Version:    0.7.0.1
 */