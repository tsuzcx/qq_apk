package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bd.l;
import com.tencent.mm.f.a.an;
import com.tencent.mm.f.a.an.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class a
  extends IListener<an>
{
  public a()
  {
    AppMethodBeat.i(161672);
    this.__eventId = an.class.getName().hashCode();
    AppMethodBeat.o(161672);
  }
  
  private static boolean a(an paraman)
  {
    AppMethodBeat.i(122652);
    if (!(paraman instanceof an))
    {
      Log.f("MicroMsg.QQMail.EventListener", "not bind qq event");
      AppMethodBeat.o(122652);
      return false;
    }
    if (paraman.fvU.fvW == 0)
    {
      paraman = (String)h.aHG().aHp().get(ar.a.VDk, null);
      Log.i("MicroMsg.QQMail.EventListener", "unbind qq, bindXMail is [%s]", new Object[] { paraman });
      if (!Util.isNullOrNil(paraman)) {}
    }
    try
    {
      h.aHG().aHp().i(17, Integer.valueOf(2));
      int i = z.bdn() | 0x1;
      h.aHG().aHp().i(34, Integer.valueOf(i));
      ((n)h.ae(n.class)).bbK().d(new l("", "", "", "", "", "", "", "", i, "", ""));
      ac.fsw();
      Log.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
      AppMethodBeat.o(122652);
      return false;
    }
    catch (Exception paraman)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.QQMail.EventListener", paraman, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.a
 * JD-Core Version:    0.7.0.1
 */