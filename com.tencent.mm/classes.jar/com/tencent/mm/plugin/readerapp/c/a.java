package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bd.l;
import com.tencent.mm.f.a.an;
import com.tencent.mm.f.a.an.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dlm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

final class a
  extends IListener<an>
{
  a()
  {
    AppMethodBeat.i(161674);
    this.__eventId = an.class.getName().hashCode();
    AppMethodBeat.o(161674);
  }
  
  private boolean a(an paraman)
  {
    AppMethodBeat.i(102659);
    if (!(paraman instanceof an))
    {
      Log.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
      AppMethodBeat.o(102659);
      return false;
    }
    if (paraman.fvU.fvW == 0) {}
    try
    {
      int i = z.bdn() | 0x40000;
      com.tencent.mm.kernel.h.aHG().aHp().i(34, Integer.valueOf(i));
      paraman = new dlm();
      paraman.RFu = 262144;
      paraman.TSy = 1;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(39, paraman));
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new l("", "", "", "", "", "", "", "", i, "", ""));
      g.b(new g.a()
      {
        public final void ftK() {}
      });
      i = z.bdf();
      com.tencent.mm.kernel.h.aHG().aHp().i(40, Integer.valueOf(i & 0xFFFFFFDF));
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new com.tencent.mm.bd.h(21, 2));
      Log.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
      AppMethodBeat.o(102659);
      return false;
    }
    catch (Exception paraman)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", paraman, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.a
 * JD-Core Version:    0.7.0.1
 */