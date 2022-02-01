package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.aj.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;

final class a
  extends c<aj>
{
  a()
  {
    AppMethodBeat.i(161674);
    this.__eventId = aj.class.getName().hashCode();
    AppMethodBeat.o(161674);
  }
  
  private boolean a(aj paramaj)
  {
    AppMethodBeat.i(102659);
    if (!(paramaj instanceof aj))
    {
      ad.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
      AppMethodBeat.o(102659);
      return false;
    }
    if (paramaj.dcf.dch == 0) {}
    try
    {
      int i = u.aqS() | 0x40000;
      com.tencent.mm.kernel.g.afB().afk().set(34, Integer.valueOf(i));
      paramaj = new cau();
      paramaj.CuI = 262144;
      paramaj.DXj = 1;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(39, paramaj));
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new com.tencent.mm.bb.k("", "", "", "", "", "", "", "", i, "", ""));
      g.b(new g.a()
      {
        public final void dfw() {}
      });
      i = u.aqM();
      com.tencent.mm.kernel.g.afB().afk().set(40, Integer.valueOf(i & 0xFFFFFFDF));
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new com.tencent.mm.bb.g(21, 2));
      ad.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
      AppMethodBeat.o(102659);
      return false;
    }
    catch (Exception paramaj)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", paramaj, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.a
 * JD-Core Version:    0.7.0.1
 */