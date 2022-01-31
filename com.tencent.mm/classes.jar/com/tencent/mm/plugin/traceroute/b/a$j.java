package com.tencent.mm.plugin.traceroute.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(25978);
    this.tmW.mD(false);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long l1 = bo.aoy();
    Object localObject1 = new java.sql.Date(l1);
    ab.i("MicroMsg.MMTraceRoute", "mmtraceroute start time " + localSimpleDateFormat.format((java.util.Date)localObject1));
    localObject1 = this.tmW.tmQ.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      a.i locali = new a.i(this.tmW, (String)((Map.Entry)localObject2).getKey());
      if (a.tmM != null) {
        a.tmM.execute(locali);
      }
      localObject2 = new a.a(this.tmW, (String)((Map.Entry)localObject2).getKey(), (Set)((Map.Entry)localObject2).getValue());
      if (a.tmM != null) {
        a.tmM.execute((Runnable)localObject2);
      }
    }
    try
    {
      do
      {
        Thread.sleep(500L);
        if ((this.tmW.cKF()) || (a.tmM.getActiveCount() <= 0)) {
          break;
        }
        ab.d("MicroMsg.MMTraceRoute", "task count: " + String.valueOf(a.tmM.getActiveCount()));
        l2 = bo.aoy();
      } while (l2 - l1 < 120000L);
      ab.i("MicroMsg.MMTraceRoute", "traceroute timeout: " + (l2 - l1) / 1000L);
      this.tmW.mD(true);
      this.tmW.stop();
      if (this.tmW.tmR != null) {
        this.tmW.tmR.cKK();
      }
      AppMethodBeat.o(25978);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMTraceRoute", "wait for command end err: " + localException.getMessage());
        ab.printErrStackTrace("MicroMsg.MMTraceRoute", localException, "", new Object[0]);
      }
      long l2 = bo.aoy();
      ab.i("MicroMsg.MMTraceRoute", "mmtraceroute end time " + localSimpleDateFormat.format(new java.util.Date(l2)));
      ab.i("MicroMsg.MMTraceRoute", "mmtraceroute total time " + (l2 - l1) / 1000L);
      if ((this.tmW.tmS != null) && (!this.tmW.cKF())) {
        this.tmW.tmS.asg();
      }
      AppMethodBeat.o(25978);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.a.j
 * JD-Core Version:    0.7.0.1
 */