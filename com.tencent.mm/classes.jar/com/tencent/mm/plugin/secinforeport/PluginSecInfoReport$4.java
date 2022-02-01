package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.b.a;
import com.tencent.mm.plugin.normsg.c.i;
import com.tencent.mm.sdk.platformtools.ac;

final class PluginSecInfoReport$4
  implements Runnable
{
  PluginSecInfoReport$4(PluginSecInfoReport paramPluginSecInfoReport) {}
  
  public final void run()
  {
    int i = -1;
    AppMethodBeat.i(207464);
    i locali = new i();
    if (!com.tencent.mm.plugin.normsg.a.b.vor.dkE())
    {
      localObject = com.tencent.mm.plugin.normsg.a.b.vor.Ky(1);
      if (localObject == null) {}
      for (;;)
      {
        ac.d("TrustRequestManager", "[debug] doScene type:[init] dlen:[%d]", new Object[] { Integer.valueOf(i) });
        if ((localObject != null) && (localObject.length != 0)) {
          break;
        }
        AppMethodBeat.o(207464);
        return;
        i = localObject.length;
      }
      locali.dld();
      if (g.agM()) {}
      for (localObject = new com.tencent.mm.plugin.normsg.b.b(false, (byte[])localObject);; localObject = new com.tencent.mm.plugin.normsg.b.b(true, (byte[])localObject))
      {
        if (!g.agi().a((n)localObject, 0))
        {
          ac.e("TrustRequestManager", "[debug] doScene faild");
          locali.dle();
        }
        AppMethodBeat.o(207464);
        return;
      }
    }
    Object localObject = com.tencent.mm.plugin.normsg.a.b.vor.Ky(2);
    if (localObject == null) {}
    for (;;)
    {
      ac.d("TrustRequestManager", "[debug] doScene type:[refesh] dlen:[%d]", new Object[] { Integer.valueOf(i) });
      if ((localObject != null) && (localObject.length != 0)) {
        break;
      }
      AppMethodBeat.o(207464);
      return;
      i = localObject.length;
    }
    locali.dld();
    if (g.agM()) {}
    for (localObject = new a(false, (byte[])localObject);; localObject = new a(true, (byte[])localObject))
    {
      if (!g.agi().a((n)localObject, 0))
      {
        ac.e("TrustRequestManager", "[debug] doScene faild");
        locali.dle();
      }
      AppMethodBeat.o(207464);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.4
 * JD-Core Version:    0.7.0.1
 */