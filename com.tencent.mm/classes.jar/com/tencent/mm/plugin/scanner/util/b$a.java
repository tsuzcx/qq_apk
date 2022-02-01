package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.n.n;
import d.v;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class b$a
  implements Runnable
{
  b$a(Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(52476);
    Object localObject = this.yzk;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(52476);
      throw ((Throwable)localObject);
    }
    localObject = n.a((CharSequence)localObject, new String[] { "," });
    ad.i("MicroMsg.OfflineScanManager", "alvinluo notifyMessage localStr: %d, context size: %d", new Object[] { Integer.valueOf(((String)this.yzk).length()), Integer.valueOf(((List)localObject).size()) });
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (((CharSequence)str).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label154;
        }
        b localb = b.yzj;
        b.awV(str);
        break;
      }
      label154:
      ad.i("MicroMsg.OfflineScanManager", "alvinluo notifyOfflineScanMessage context is empty, ignore");
    }
    localObject = b.yzj;
    b.dMI();
    AppMethodBeat.o(52476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.b.a
 * JD-Core Version:    0.7.0.1
 */