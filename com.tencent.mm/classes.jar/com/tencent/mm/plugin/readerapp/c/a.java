package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.g.a.ag.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

final class a
  extends c<ag>
{
  a()
  {
    AppMethodBeat.i(76752);
    this.__eventId = ag.class.getName().hashCode();
    AppMethodBeat.o(76752);
  }
  
  private boolean a(ag paramag)
  {
    AppMethodBeat.i(76753);
    if (!(paramag instanceof ag))
    {
      ab.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
      AppMethodBeat.o(76753);
      return false;
    }
    if (paramag.cno.cnq == 0) {}
    try
    {
      int i = r.Zy() | 0x40000;
      com.tencent.mm.kernel.g.RL().Ru().set(34, Integer.valueOf(i));
      paramag = new bmq();
      paramag.wmt = 262144;
      paramag.xBb = 1;
      ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new j.a(39, paramag));
      ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new k("", "", "", "", "", "", "", "", i, "", ""));
      g.b(new g.a()
      {
        public final void cfi() {}
      });
      i = r.Zt();
      com.tencent.mm.kernel.g.RL().Ru().set(40, Integer.valueOf(i & 0xFFFFFFDF));
      ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new com.tencent.mm.az.g(21, 2));
      ab.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
      AppMethodBeat.o(76753);
      return false;
    }
    catch (Exception paramag)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", paramag, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.a
 * JD-Core Version:    0.7.0.1
 */