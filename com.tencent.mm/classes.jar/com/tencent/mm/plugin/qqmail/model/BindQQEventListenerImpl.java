package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aq.a;
import com.tencent.mm.ay.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;

public class BindQQEventListenerImpl
  extends IListener<com.tencent.mm.autogen.a.aq>
{
  public BindQQEventListenerImpl()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161672);
    this.__eventId = com.tencent.mm.autogen.a.aq.class.getName().hashCode();
    AppMethodBeat.o(161672);
  }
  
  private static boolean a(com.tencent.mm.autogen.a.aq paramaq)
  {
    AppMethodBeat.i(122652);
    if (!(paramaq instanceof com.tencent.mm.autogen.a.aq))
    {
      Log.f("MicroMsg.QQMail.EventListener", "not bind qq event");
      AppMethodBeat.o(122652);
      return false;
    }
    if (paramaq.hAp.hAr == 0)
    {
      paramaq = (String)h.baE().ban().get(at.a.adgf, null);
      Log.i("MicroMsg.QQMail.EventListener", "unbind qq, bindXMail is [%s]", new Object[] { paramaq });
      if (!Util.isNullOrNil(paramaq)) {}
    }
    try
    {
      h.baE().ban().B(17, Integer.valueOf(2));
      int i = z.bBf() | 0x1;
      h.baE().ban().B(34, Integer.valueOf(i));
      ((n)h.ax(n.class)).bzz().d(new l("", "", "", "", "", "", "", "", i, "", ""));
      ab.gEe();
      Log.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
      AppMethodBeat.o(122652);
      return false;
    }
    catch (Exception paramaq)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.QQMail.EventListener", paramaq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.BindQQEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */