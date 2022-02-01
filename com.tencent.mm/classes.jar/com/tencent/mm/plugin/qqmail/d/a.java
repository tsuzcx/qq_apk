package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

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
      ad.f("MicroMsg.QQMail.EventListener", "not bind qq event");
      AppMethodBeat.o(122652);
      return false;
    }
    if (paramak.dkW.dkY == 0)
    {
      paramak = (String)g.ajC().ajl().get(al.a.IJH, null);
      ad.i("MicroMsg.QQMail.EventListener", "unbind qq, bindXMail is [%s]", new Object[] { paramak });
      if (!bt.isNullOrNil(paramak)) {}
    }
    try
    {
      g.ajC().ajl().set(17, Integer.valueOf(2));
      int i = u.aAy() | 0x1;
      g.ajC().ajl().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new com.tencent.mm.bb.l("", "", "", "", "", "", "", "", i, "", ""));
      ac.dCm();
      ad.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
      AppMethodBeat.o(122652);
      return false;
    }
    catch (Exception paramak)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.QQMail.EventListener", paramak, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.a
 * JD-Core Version:    0.7.0.1
 */