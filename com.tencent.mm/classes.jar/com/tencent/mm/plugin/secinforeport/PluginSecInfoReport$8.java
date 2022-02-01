package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.normsg.b.a;
import com.tencent.mm.plugin.normsg.b.b;
import com.tencent.mm.plugin.normsg.d.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class PluginSecInfoReport$8
  implements Runnable
{
  PluginSecInfoReport$8(PluginSecInfoReport paramPluginSecInfoReport) {}
  
  public final void run()
  {
    int i = -1;
    AppMethodBeat.i(214383);
    j localj = new j();
    if (!d.AEF.exL())
    {
      localObject = d.AEF.TM(1);
      if (localObject == null) {}
      for (;;)
      {
        Log.d("TrustRequestManager", "[debug] doScene type:[init] dlen:[%d]", new Object[] { Integer.valueOf(i) });
        if ((localObject != null) && (localObject.length != 0)) {
          break;
        }
        AppMethodBeat.o(214383);
        return;
        i = localObject.length;
      }
      localj.eyq();
      if (g.aAc()) {}
      for (localObject = new b(false, (byte[])localObject);; localObject = new b(true, (byte[])localObject))
      {
        if (!g.azz().a((q)localObject, 0))
        {
          Log.e("TrustRequestManager", "[debug] doScene faild");
          localj.eyr();
        }
        AppMethodBeat.o(214383);
        return;
      }
    }
    Object localObject = d.AEF.TM(2);
    if (localObject == null) {}
    for (;;)
    {
      Log.d("TrustRequestManager", "[debug] doScene type:[refesh] dlen:[%d]", new Object[] { Integer.valueOf(i) });
      if ((localObject != null) && (localObject.length != 0)) {
        break;
      }
      AppMethodBeat.o(214383);
      return;
      i = localObject.length;
    }
    localj.eyq();
    if (g.aAc()) {}
    for (localObject = new a(false, (byte[])localObject);; localObject = new a(true, (byte[])localObject))
    {
      if (!g.azz().a((q)localObject, Util.getIntRandom(600000, 0)))
      {
        Log.e("TrustRequestManager", "[debug] doScene faild");
        localj.eyr();
      }
      AppMethodBeat.o(214383);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.8
 * JD-Core Version:    0.7.0.1
 */