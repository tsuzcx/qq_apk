package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.aj.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.ab;

public final class b
  extends c<aj>
{
  public b()
  {
    AppMethodBeat.i(161672);
    this.__eventId = aj.class.getName().hashCode();
    AppMethodBeat.o(161672);
  }
  
  private static boolean a(aj paramaj)
  {
    AppMethodBeat.i(122652);
    if (!(paramaj instanceof aj))
    {
      com.tencent.mm.sdk.platformtools.ad.f("MicroMsg.QQMail.EventListener", "not bind qq event");
      AppMethodBeat.o(122652);
      return false;
    }
    if (paramaj.dcf.dch == 0) {}
    try
    {
      g.afB().afk().set(17, Integer.valueOf(2));
      int i = u.aqS() | 0x1;
      g.afB().afk().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new com.tencent.mm.bb.k("", "", "", "", "", "", "", "", i, "", ""));
      ad.deg();
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
      AppMethodBeat.o(122652);
      return false;
    }
    catch (Exception paramaj)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.QQMail.EventListener", paramaj, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.b
 * JD-Core Version:    0.7.0.1
 */