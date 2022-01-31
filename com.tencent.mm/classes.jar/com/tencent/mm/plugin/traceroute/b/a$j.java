package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a$j
  implements Runnable
{
  private a$j(a parama) {}
  
  public final void run()
  {
    this.pII.jM(false);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long l1 = bk.UY();
    Object localObject1 = new java.sql.Date(l1);
    y.i("MicroMsg.MMTraceRoute", "mmtraceroute start time " + localSimpleDateFormat.format((java.util.Date)localObject1));
    localObject1 = this.pII.pIC.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      a.i locali = new a.i(this.pII, (String)((Map.Entry)localObject2).getKey());
      if (a.pIy != null) {
        a.pIy.execute(locali);
      }
      localObject2 = new a.a(this.pII, (String)((Map.Entry)localObject2).getKey(), (Set)((Map.Entry)localObject2).getValue());
      if (a.pIy != null) {
        a.pIy.execute((Runnable)localObject2);
      }
    }
    try
    {
      do
      {
        Thread.sleep(500L);
        if ((this.pII.bOK()) || (a.pIy.getActiveCount() <= 0)) {
          break;
        }
        y.d("MicroMsg.MMTraceRoute", "task count: " + String.valueOf(a.pIy.getActiveCount()));
        l2 = bk.UY();
      } while (l2 - l1 < 120000L);
      y.i("MicroMsg.MMTraceRoute", "traceroute timeout: " + (l2 - l1) / 1000L);
      this.pII.jM(true);
      this.pII.stop();
      if (this.pII.pID != null) {
        this.pII.pID.bOO();
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          y.e("MicroMsg.MMTraceRoute", "wait for command end err: " + localException.getMessage());
          y.printErrStackTrace("MicroMsg.MMTraceRoute", localException, "", new Object[0]);
        }
        long l2 = bk.UY();
        y.i("MicroMsg.MMTraceRoute", "mmtraceroute end time " + localSimpleDateFormat.format(new java.util.Date(l2)));
        y.i("MicroMsg.MMTraceRoute", "mmtraceroute total time " + (l2 - l1) / 1000L);
      } while ((this.pII.pIE == null) || (this.pII.bOK()));
      this.pII.pIE.Yw();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.a.j
 * JD-Core Version:    0.7.0.1
 */