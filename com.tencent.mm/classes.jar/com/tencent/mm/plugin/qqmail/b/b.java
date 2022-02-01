package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.l;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;

public final class b
  extends c<ak>
{
  public b()
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
      ac.f("MicroMsg.QQMail.EventListener", "not bind qq event");
      AppMethodBeat.o(122652);
      return false;
    }
    if (paramak.cZE.cZG == 0) {}
    try
    {
      g.agR().agA().set(17, Integer.valueOf(2));
      int i = u.axI() | 0x1;
      g.agR().agA().set(34, Integer.valueOf(i));
      ((k)g.ab(k.class)).awA().c(new l("", "", "", "", "", "", "", "", i, "", ""));
      ad.drO();
      ac.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
      AppMethodBeat.o(122652);
      return false;
    }
    catch (Exception paramak)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.QQMail.EventListener", paramak, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.b
 * JD-Core Version:    0.7.0.1
 */