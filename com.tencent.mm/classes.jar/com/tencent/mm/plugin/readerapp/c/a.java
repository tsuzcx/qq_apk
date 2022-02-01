package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.h;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.am.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

final class a
  extends IListener<am>
{
  a()
  {
    AppMethodBeat.i(161674);
    this.__eventId = am.class.getName().hashCode();
    AppMethodBeat.o(161674);
  }
  
  private boolean a(am paramam)
  {
    AppMethodBeat.i(102659);
    if (!(paramam instanceof am))
    {
      Log.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
      AppMethodBeat.o(102659);
      return false;
    }
    if (paramam.dDo.dDq == 0) {}
    try
    {
      int i = z.aUl() | 0x40000;
      com.tencent.mm.kernel.g.aAh().azQ().set(34, Integer.valueOf(i));
      paramam = new dbw();
      paramam.KEc = 262144;
      paramam.MGK = 1;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(39, paramam));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
      g.b(new g.a()
      {
        public final void eHF() {}
      });
      i = z.aUe();
      com.tencent.mm.kernel.g.aAh().azQ().set(40, Integer.valueOf(i & 0xFFFFFFDF));
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new h(21, 2));
      Log.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
      AppMethodBeat.o(102659);
      return false;
    }
    catch (Exception paramam)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", paramam, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.a
 * JD-Core Version:    0.7.0.1
 */