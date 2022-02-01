package com.tencent.mm.plugin.readerapp.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aq.a;
import com.tencent.mm.ay.l;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.edx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class BindQQEventListenerImpl
  extends IListener<com.tencent.mm.autogen.a.aq>
{
  public BindQQEventListenerImpl()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161674);
    this.__eventId = com.tencent.mm.autogen.a.aq.class.getName().hashCode();
    AppMethodBeat.o(161674);
  }
  
  private boolean a(com.tencent.mm.autogen.a.aq paramaq)
  {
    AppMethodBeat.i(102659);
    if (!(paramaq instanceof com.tencent.mm.autogen.a.aq))
    {
      Log.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
      AppMethodBeat.o(102659);
      return false;
    }
    if (paramaq.hAp.hAr == 0) {}
    try
    {
      int i = z.bBf() | 0x40000;
      com.tencent.mm.kernel.h.baE().ban().B(34, Integer.valueOf(i));
      paramaq = new edx();
      paramaq.YBX = 262144;
      paramaq.abiW = 1;
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(39, paramaq));
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new l("", "", "", "", "", "", "", "", i, "", ""));
      d.b(new d.a()
      {
        public final boolean aMJ()
        {
          return false;
        }
        
        public final void gFy() {}
      });
      i = z.bAU();
      com.tencent.mm.kernel.h.baE().ban().B(40, Integer.valueOf(i & 0xFFFFFFDF));
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new com.tencent.mm.ay.h(21, 2));
      Log.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
      AppMethodBeat.o(102659);
      return false;
    }
    catch (Exception paramaq)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", paramaq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.model.BindQQEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */