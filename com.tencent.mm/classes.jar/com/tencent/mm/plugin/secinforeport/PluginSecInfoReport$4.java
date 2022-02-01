package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.b.a;
import com.tencent.mm.plugin.normsg.c.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class PluginSecInfoReport$4
  implements Runnable
{
  PluginSecInfoReport$4(PluginSecInfoReport paramPluginSecInfoReport) {}
  
  public final void run()
  {
    int i = -1;
    AppMethodBeat.i(210877);
    j localj = new j();
    if (!com.tencent.mm.plugin.normsg.a.b.wJt.dyg())
    {
      localObject = com.tencent.mm.plugin.normsg.a.b.wJt.MF(1);
      if (localObject == null) {}
      for (;;)
      {
        ae.d("TrustRequestManager", "[debug] doScene type:[init] dlen:[%d]", new Object[] { Integer.valueOf(i) });
        if ((localObject != null) && (localObject.length != 0)) {
          break;
        }
        AppMethodBeat.o(210877);
        return;
        i = localObject.length;
      }
      localj.dyJ();
      if (g.ajM()) {}
      for (localObject = new com.tencent.mm.plugin.normsg.b.b(false, (byte[])localObject);; localObject = new com.tencent.mm.plugin.normsg.b.b(true, (byte[])localObject))
      {
        if (!g.ajj().a((n)localObject, 0))
        {
          ae.e("TrustRequestManager", "[debug] doScene faild");
          localj.dyK();
        }
        AppMethodBeat.o(210877);
        return;
      }
    }
    Object localObject = com.tencent.mm.plugin.normsg.a.b.wJt.MF(2);
    if (localObject == null) {}
    for (;;)
    {
      ae.d("TrustRequestManager", "[debug] doScene type:[refesh] dlen:[%d]", new Object[] { Integer.valueOf(i) });
      if ((localObject != null) && (localObject.length != 0)) {
        break;
      }
      AppMethodBeat.o(210877);
      return;
      i = localObject.length;
    }
    localj.dyJ();
    if (g.ajM()) {}
    for (localObject = new a(false, (byte[])localObject);; localObject = new a(true, (byte[])localObject))
    {
      if (!g.ajj().a((n)localObject, bu.jA(600000, 0)))
      {
        ae.e("TrustRequestManager", "[debug] doScene faild");
        localj.dyK();
      }
      AppMethodBeat.o(210877);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.4
 * JD-Core Version:    0.7.0.1
 */