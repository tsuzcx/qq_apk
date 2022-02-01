package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.h;
import com.tencent.mm.ba.l;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;

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
      ac.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
      AppMethodBeat.o(102659);
      return false;
    }
    if (paramak.cZE.cZG == 0) {}
    try
    {
      int i = u.axI() | 0x40000;
      com.tencent.mm.kernel.g.agR().agA().set(34, Integer.valueOf(i));
      paramak = new cft();
      paramak.DNd = 262144;
      paramak.Fuc = 1;
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(new j.a(39, paramak));
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(new l("", "", "", "", "", "", "", "", i, "", ""));
      g.b(new g.a()
      {
        public final void dtd() {}
      });
      i = u.axC();
      com.tencent.mm.kernel.g.agR().agA().set(40, Integer.valueOf(i & 0xFFFFFFDF));
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(new h(21, 2));
      ac.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
      AppMethodBeat.o(102659);
      return false;
    }
    catch (Exception paramak)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", paramak, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.a
 * JD-Core Version:    0.7.0.1
 */