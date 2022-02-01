package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class a
  extends c<ak>
{
  public a()
  {
    AppMethodBeat.i(161672);
    this.__eventId = ak.class.getName().hashCode();
    AppMethodBeat.o(161672);
  }
  
  private static boolean a(ak paramak)
  {
    AppMethodBeat.i(122652);
    if (!(paramak instanceof ak))
    {
      ae.f("MicroMsg.QQMail.EventListener", "not bind qq event");
      AppMethodBeat.o(122652);
      return false;
    }
    if (paramak.dlY.dma == 0)
    {
      paramak = (String)g.ajR().ajA().get(am.a.Jen, null);
      ae.i("MicroMsg.QQMail.EventListener", "unbind qq, bindXMail is [%s]", new Object[] { paramak });
      if (!bu.isNullOrNil(paramak)) {}
    }
    try
    {
      g.ajR().ajA().set(17, Integer.valueOf(2));
      int i = v.aAO() | 0x1;
      g.ajR().ajA().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
      ac.dFD();
      ae.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
      AppMethodBeat.o(122652);
      return false;
    }
    catch (Exception paramak)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.QQMail.EventListener", paramak, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.a
 * JD-Core Version:    0.7.0.1
 */