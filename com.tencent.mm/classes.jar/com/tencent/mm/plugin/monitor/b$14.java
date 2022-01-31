package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class b$14
  implements Runnable
{
  final Map<String, Integer> oSi;
  
  b$14(b paramb, Map paramMap, a.a parama, com.tencent.mm.vfs.b paramb1, a parama1)
  {
    AppMethodBeat.i(84534);
    this.oSi = this.oSj;
    AppMethodBeat.o(84534);
  }
  
  public final void run()
  {
    AppMethodBeat.i(84535);
    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan start fileScanResult[%s], subDirMap[%d]", new Object[] { this.oSk, Integer.valueOf(this.oSj.size()) });
    long l = System.currentTimeMillis();
    b.a(this.oRW, this.oSl, this.oSk, this.oSi);
    if (this.oSj.size() > 0)
    {
      Iterator localIterator = this.oSj.entrySet().iterator();
      while ((localIterator != null) && (localIterator.hasNext()))
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.oSk.oRB.add(new a.b((String)localEntry.getKey(), ((Integer)localEntry.getValue()).intValue()));
      }
    }
    this.oSk.cew = (System.currentTimeMillis() - l);
    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan end takes[%d], emptySubDir[%d], fileScanResult[%s], tid[%d]", new Object[] { Long.valueOf(this.oSk.cew), Integer.valueOf(this.oSj.values().size()), this.oSk, Long.valueOf(Thread.currentThread().getId()) });
    this.oSh.a(0, this.oSk);
    AppMethodBeat.o(84535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.14
 * JD-Core Version:    0.7.0.1
 */