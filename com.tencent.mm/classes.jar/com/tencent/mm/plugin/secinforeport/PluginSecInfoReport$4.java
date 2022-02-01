package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.b.a;
import com.tencent.mm.plugin.normsg.c.i;
import com.tencent.mm.sdk.platformtools.ad;

final class PluginSecInfoReport$4
  implements Runnable
{
  PluginSecInfoReport$4(PluginSecInfoReport paramPluginSecInfoReport) {}
  
  public final void run()
  {
    int i = -1;
    AppMethodBeat.i(186712);
    i locali = new i();
    if (!com.tencent.mm.plugin.normsg.a.b.ufs.cWW())
    {
      localObject = com.tencent.mm.plugin.normsg.a.b.ufs.Iz(1);
      if (localObject == null) {}
      for (;;)
      {
        ad.d("TrustRequestManager", "[debug] doScene type:[init] dlen:[%d]", new Object[] { Integer.valueOf(i) });
        if ((localObject != null) && (localObject.length != 0)) {
          break;
        }
        AppMethodBeat.o(186712);
        return;
        i = localObject.length;
      }
      locali.cXv();
      if (g.afw()) {}
      for (localObject = new com.tencent.mm.plugin.normsg.b.b(false, (byte[])localObject);; localObject = new com.tencent.mm.plugin.normsg.b.b(true, (byte[])localObject))
      {
        if (!g.aeS().a((n)localObject, 0))
        {
          ad.e("TrustRequestManager", "[debug] doScene faild");
          locali.cXw();
        }
        AppMethodBeat.o(186712);
        return;
      }
    }
    Object localObject = com.tencent.mm.plugin.normsg.a.b.ufs.Iz(2);
    if (localObject == null) {}
    for (;;)
    {
      ad.d("TrustRequestManager", "[debug] doScene type:[refesh] dlen:[%d]", new Object[] { Integer.valueOf(i) });
      if ((localObject != null) && (localObject.length != 0)) {
        break;
      }
      AppMethodBeat.o(186712);
      return;
      i = localObject.length;
    }
    locali.cXv();
    if (g.afw()) {}
    for (localObject = new a(false, (byte[])localObject);; localObject = new a(true, (byte[])localObject))
    {
      if (!g.aeS().a((n)localObject, 0))
      {
        ad.e("TrustRequestManager", "[debug] doScene faild");
        locali.cXw();
      }
      AppMethodBeat.o(186712);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.4
 * JD-Core Version:    0.7.0.1
 */