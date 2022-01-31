package com.tencent.mm.plugin.scanner.util;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$c$a
  implements Runnable
{
  public static final a qCk;
  
  static
  {
    AppMethodBeat.i(151717);
    qCk = new a();
    AppMethodBeat.o(151717);
  }
  
  public final void run()
  {
    AppMethodBeat.i(151716);
    Object localObject = g.Rc();
    j.p(localObject, "MMKernel.getNetSceneQueue()");
    int i = ((p)localObject).adt();
    localObject = c.qCh;
    ab.i("MicroMsg.OfflineScanManager", "alvinluo OfflineScan onNetworkChange netWorkStatus: %d, current: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(c.cjn()) });
    localObject = g.Rc();
    j.p(localObject, "MMKernel.getNetSceneQueue()");
    if (((p)localObject).adt() != 6)
    {
      localObject = g.Rc();
      j.p(localObject, "MMKernel.getNetSceneQueue()");
      if (((p)localObject).adt() != 4) {}
    }
    else
    {
      localObject = c.qCh;
      i = c.cjn();
      localObject = g.Rc();
      j.p(localObject, "MMKernel.getNetSceneQueue()");
      if (i == ((p)localObject).adt())
      {
        AppMethodBeat.o(151716);
        return;
      }
      localObject = c.qCh;
      localObject = g.Rc();
      j.p(localObject, "MMKernel.getNetSceneQueue()");
      c.CM(((p)localObject).adt());
      localObject = c.qCh;
      c.cjo();
      AppMethodBeat.o(151716);
      return;
    }
    localObject = c.qCh;
    localObject = g.Rc();
    j.p(localObject, "MMKernel.getNetSceneQueue()");
    c.CM(((p)localObject).adt());
    AppMethodBeat.o(151716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c.c.a
 * JD-Core Version:    0.7.0.1
 */