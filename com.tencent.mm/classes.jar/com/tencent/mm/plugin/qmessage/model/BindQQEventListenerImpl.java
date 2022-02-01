package com.tencent.mm.plugin.qmessage.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aq.a;
import com.tencent.mm.ay.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class BindQQEventListenerImpl
  extends IListener<com.tencent.mm.autogen.a.aq>
{
  public BindQQEventListenerImpl()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161424);
    this.__eventId = com.tencent.mm.autogen.a.aq.class.getName().hashCode();
    AppMethodBeat.o(161424);
  }
  
  private static boolean a(com.tencent.mm.autogen.a.aq paramaq)
  {
    AppMethodBeat.i(27710);
    if (!(paramaq instanceof com.tencent.mm.autogen.a.aq))
    {
      Log.f("MicroMsg.QMsg.EventListener", "not bind qq event");
      AppMethodBeat.o(27710);
      return false;
    }
    if (paramaq.hAp.hAr == 0) {}
    try
    {
      int i = z.bBf() | 0x20;
      bh.bCz();
      c.ban().B(34, Integer.valueOf(i));
      bh.bCz();
      c.bzz().d(new l("", "", "", "", "", "", "", "", i, "", ""));
      f.gDK();
      Log.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
      AppMethodBeat.o(27710);
      return false;
    }
    catch (Exception paramaq)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.QMsg.EventListener", paramaq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.model.BindQQEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */