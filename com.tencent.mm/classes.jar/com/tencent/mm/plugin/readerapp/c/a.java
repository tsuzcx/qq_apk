package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.h;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

final class a
  extends c<ak>
{
  a()
  {
    AppMethodBeat.i(161674);
    this.__eventId = ak.class.getName().hashCode();
    AppMethodBeat.o(161674);
  }
  
  private boolean a(ak paramak)
  {
    AppMethodBeat.i(102659);
    if (!(paramak instanceof ak))
    {
      ae.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
      AppMethodBeat.o(102659);
      return false;
    }
    if (paramak.dlY.dma == 0) {}
    try
    {
      int i = v.aAO() | 0x40000;
      com.tencent.mm.kernel.g.ajR().ajA().set(34, Integer.valueOf(i));
      paramak = new clm();
      paramak.FKG = 262144;
      paramak.HxH = 1;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(39, paramak));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
      g.b(new g.a()
      {
        public final void dGR() {}
      });
      i = v.aAI();
      com.tencent.mm.kernel.g.ajR().ajA().set(40, Integer.valueOf(i & 0xFFFFFFDF));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new h(21, 2));
      ae.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
      AppMethodBeat.o(102659);
      return false;
    }
    catch (Exception paramak)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", paramak, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.a
 * JD-Core Version:    0.7.0.1
 */