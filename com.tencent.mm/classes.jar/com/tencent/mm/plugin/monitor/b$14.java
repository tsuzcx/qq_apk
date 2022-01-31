package com.tencent.mm.plugin.monitor;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class b$14
  implements Runnable
{
  final Map<String, Integer> msx = this.msy;
  
  b$14(b paramb, Map paramMap, a.a parama, com.tencent.mm.vfs.b paramb1, a parama1) {}
  
  public final void run()
  {
    y.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan start fileScanResult[%s], subDirMap[%d]", new Object[] { this.msz, Integer.valueOf(this.msy.size()) });
    long l = System.currentTimeMillis();
    b.a(this.msl, this.msA, this.msz, this.msx);
    if (this.msy.size() > 0)
    {
      Iterator localIterator = this.msy.entrySet().iterator();
      while ((localIterator != null) && (localIterator.hasNext()))
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.msz.mrO.add(new a.b((String)localEntry.getKey(), ((Integer)localEntry.getValue()).intValue()));
      }
    }
    this.msz.mrN = (System.currentTimeMillis() - l);
    y.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan end takes[%d], emptySubDir[%d], fileScanResult[%s], tid[%d]", new Object[] { Long.valueOf(this.msz.mrN), Integer.valueOf(this.msy.values().size()), this.msz, Long.valueOf(Thread.currentThread().getId()) });
    this.msw.a(0, this.msz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.14
 * JD-Core Version:    0.7.0.1
 */