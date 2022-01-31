package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.g.a.ag.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

final class a
  extends com.tencent.mm.sdk.b.c<ag>
{
  a()
  {
    AppMethodBeat.i(24069);
    this.__eventId = ag.class.getName().hashCode();
    AppMethodBeat.o(24069);
  }
  
  private static boolean a(ag paramag)
  {
    AppMethodBeat.i(24070);
    if (!(paramag instanceof ag))
    {
      ab.f("MicroMsg.QMsg.EventListener", "not bind qq event");
      AppMethodBeat.o(24070);
      return false;
    }
    if (paramag.cno.cnq == 0) {}
    try
    {
      int i = r.Zy() | 0x20;
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(34, Integer.valueOf(i));
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new k("", "", "", "", "", "", "", "", i, "", ""));
      g.cdt();
      ab.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
      AppMethodBeat.o(24070);
      return false;
    }
    catch (Exception paramag)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.QMsg.EventListener", paramag, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.a
 * JD-Core Version:    0.7.0.1
 */