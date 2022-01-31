package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.g.a.ag.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

final class b
  extends c<ag>
{
  b()
  {
    AppMethodBeat.i(67917);
    this.__eventId = ag.class.getName().hashCode();
    AppMethodBeat.o(67917);
  }
  
  private static boolean a(ag paramag)
  {
    AppMethodBeat.i(67918);
    if (!(paramag instanceof ag))
    {
      ab.f("MicroMsg.QQMail.EventListener", "not bind qq event");
      AppMethodBeat.o(67918);
      return false;
    }
    if (paramag.cno.cnq == 0) {}
    try
    {
      g.RL().Ru().set(17, Integer.valueOf(2));
      int i = r.Zy() | 0x1;
      g.RL().Ru().set(34, Integer.valueOf(i));
      ((j)g.E(j.class)).Yz().c(new k("", "", "", "", "", "", "", "", i, "", ""));
      ac.cdS();
      ab.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
      AppMethodBeat.o(67918);
      return false;
    }
    catch (Exception paramag)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.QQMail.EventListener", paramag, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.b
 * JD-Core Version:    0.7.0.1
 */