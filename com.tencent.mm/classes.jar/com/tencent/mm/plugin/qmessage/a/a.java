package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bd.l;
import com.tencent.mm.f.a.an;
import com.tencent.mm.f.a.an.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

final class a
  extends IListener<an>
{
  a()
  {
    AppMethodBeat.i(161424);
    this.__eventId = an.class.getName().hashCode();
    AppMethodBeat.o(161424);
  }
  
  private static boolean a(an paraman)
  {
    AppMethodBeat.i(27710);
    if (!(paraman instanceof an))
    {
      Log.f("MicroMsg.QMsg.EventListener", "not bind qq event");
      AppMethodBeat.o(27710);
      return false;
    }
    if (paraman.fvU.fvW == 0) {}
    try
    {
      int i = z.bdn() | 0x20;
      bh.beI();
      c.aHp().i(34, Integer.valueOf(i));
      bh.beI();
      c.bbK().d(new l("", "", "", "", "", "", "", "", i, "", ""));
      g.fsc();
      Log.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
      AppMethodBeat.o(27710);
      return false;
    }
    catch (Exception paraman)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.QMsg.EventListener", paraman, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.a
 * JD-Core Version:    0.7.0.1
 */