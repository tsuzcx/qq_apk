package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class b$a
  implements Runnable
{
  b$a(Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(52476);
    Object localObject = this.IYB;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(52476);
      throw ((Throwable)localObject);
    }
    localObject = n.a((CharSequence)localObject, new String[] { "," });
    Log.i("MicroMsg.OfflineScanManager", "alvinluo notifyMessage localStr: %d, context size: %d", new Object[] { Integer.valueOf(((String)this.IYB).length()), Integer.valueOf(((List)localObject).size()) });
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
        b localb = b.IYA;
        b.aXw(str);
        break;
      }
      label154:
      Log.i("MicroMsg.OfflineScanManager", "alvinluo notifyOfflineScanMessage context is empty, ignore");
    }
    localObject = b.IYA;
    b.fEN();
    AppMethodBeat.o(52476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.b.a
 * JD-Core Version:    0.7.0.1
 */