package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.am.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class a
  extends IListener<am>
{
  public a()
  {
    AppMethodBeat.i(161672);
    this.__eventId = am.class.getName().hashCode();
    AppMethodBeat.o(161672);
  }
  
  private static boolean a(am paramam)
  {
    AppMethodBeat.i(122652);
    if (!(paramam instanceof am))
    {
      Log.f("MicroMsg.QQMail.EventListener", "not bind qq event");
      AppMethodBeat.o(122652);
      return false;
    }
    if (paramam.dDo.dDq == 0)
    {
      paramam = (String)g.aAh().azQ().get(ar.a.OnU, null);
      Log.i("MicroMsg.QQMail.EventListener", "unbind qq, bindXMail is [%s]", new Object[] { paramam });
      if (!Util.isNullOrNil(paramam)) {}
    }
    try
    {
      g.aAh().azQ().set(17, Integer.valueOf(2));
      int i = z.aUl() | 0x1;
      g.aAh().azQ().set(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
      ac.eGs();
      Log.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
      AppMethodBeat.o(122652);
      return false;
    }
    catch (Exception paramam)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.QQMail.EventListener", paramam, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.a
 * JD-Core Version:    0.7.0.1
 */