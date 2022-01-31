package com.tencent.mm.plugin.performance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.g.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class a$1
  implements b
{
  a$1(a parama) {}
  
  public final String getKey()
  {
    return "checkBusyTimeout";
  }
  
  public final void run()
  {
    AppMethodBeat.i(111073);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    d.ysm.d(localHashMap1, localHashMap2);
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(960L, 6L, 1L, false);
    com.tencent.mm.plugin.report.e.qrI.e(16347, new Object[] { localHashMap1.toString(), Integer.valueOf(d.ysm.cjN().getCorePoolSize()), "", Long.valueOf(1800000L), Integer.valueOf(2) });
    ab.w("MicroMsg.ThreadPool.Profile", "on busy timeout! runningMap:%s", new Object[] { localHashMap1 });
    ab.w("MicroMsg.ThreadPool.Profile", "on busy timeout! waitingMap:%s", new Object[] { localHashMap2 });
    AppMethodBeat.o(111073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a.1
 * JD-Core Version:    0.7.0.1
 */