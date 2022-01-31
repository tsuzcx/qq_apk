package com.tencent.mm.plugin.scanner.util;

import a.l;
import a.l.m;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$b
  implements Runnable
{
  c$b(Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(151715);
    Object localObject = this.qCj;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(151715);
      throw ((Throwable)localObject);
    }
    localObject = m.a((CharSequence)localObject, new String[] { "," });
    ab.i("MicroMsg.OfflineScanManager", "alvinluo notifyMessage localStr: %d, context size: %d", new Object[] { Integer.valueOf(((String)this.qCj).length()), Integer.valueOf(((List)localObject).size()) });
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
        c localc = c.qCh;
        c.YI(str);
        break;
      }
      label154:
      ab.i("MicroMsg.OfflineScanManager", "alvinluo notifyOfflineScanMessage context is empty, ignore");
    }
    localObject = c.qCh;
    c.cjm();
    AppMethodBeat.o(151715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c.b
 * JD-Core Version:    0.7.0.1
 */