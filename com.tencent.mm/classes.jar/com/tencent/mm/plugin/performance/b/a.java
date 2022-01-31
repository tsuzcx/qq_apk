package com.tencent.mm.plugin.performance.b;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.f;
import com.tencent.mm.sdk.g.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  implements f
{
  private ak psX;
  private Runnable psY;
  final AtomicInteger psZ;
  
  public a()
  {
    AppMethodBeat.i(111074);
    this.psY = new a.1(this);
    this.psZ = new AtomicInteger(0);
    HandlerThread localHandlerThread = c.aqv("ThreadPoolProfile");
    localHandlerThread.start();
    this.psX = new ak(localHandlerThread.getLooper());
    AppMethodBeat.o(111074);
  }
  
  public final void E(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(111083);
    if (ab.getLogLevel() <= 1) {
      ab.d("MicroMsg.ThreadPool.Profile", "[onLog] %s %s %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
    AppMethodBeat.o(111083);
  }
  
  public final void a(int paramInt, List<com.tencent.mm.sdk.g.e> paramList1, List<com.tencent.mm.sdk.g.e> paramList2)
  {
    AppMethodBeat.i(111080);
    HashMap localHashMap = new HashMap();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      com.tencent.mm.sdk.g.e locale = (com.tencent.mm.sdk.g.e)paramList2.next();
      if (localHashMap.containsKey(locale.name))
      {
        int i = ((Integer)localHashMap.get(locale.name)).intValue();
        localHashMap.put(locale.name, Integer.valueOf(i + 1));
      }
      else
      {
        localHashMap.put(locale.name, Integer.valueOf(1));
      }
    }
    paramList2 = localHashMap.toString();
    ab.w("MicroMsg.ThreadPool.Profile", "[onBusy] coreSize:%s waiting:%s running:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList1.size()), paramList2 });
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(960L, 0L, 1L, false);
    this.psX.postDelayed(this.psY, 1800000L);
    AppMethodBeat.o(111080);
  }
  
  public final void a(com.tencent.mm.sdk.g.e parame)
  {
    AppMethodBeat.i(111075);
    ab.i("MicroMsg.ThreadPool.Profile", "[onTaskAdded] %s", new Object[] { parame });
    if ((this.psZ.incrementAndGet() >= 60) && (Thread.currentThread() != Looper.getMainLooper().getThread()))
    {
      ab.w("MicroMsg.ThreadPool.Profile", "dumpRunningTask: %s", new Object[] { com.tencent.mm.sdk.g.d.ysm.dut() });
      parame = com.tencent.mm.sdk.g.d.ysm.cjN();
      if ((parame instanceof com.tencent.mm.sdk.g.b.e))
      {
        parame = (com.tencent.mm.sdk.g.b.e)parame;
        if ((parame.yth instanceof com.tencent.mm.sdk.g.b.d)) {
          ab.w("MicroMsg.ThreadPool.Profile", "printWorkerStatus: %s", new Object[] { ((com.tencent.mm.sdk.g.b.d)parame.yth).duE() });
        }
      }
      this.psZ.set(0);
    }
    AppMethodBeat.o(111075);
  }
  
  public final void a(Object paramObject, Throwable paramThrowable)
  {
    AppMethodBeat.i(111082);
    ab.e("MicroMsg.ThreadPool.Profile", "[onException] %s %s", new Object[] { paramObject, paramThrowable });
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(960L, 5L, 1L, false);
    AppMethodBeat.o(111082);
  }
  
  public final void b(com.tencent.mm.sdk.g.e parame)
  {
    AppMethodBeat.i(111076);
    ab.i("MicroMsg.ThreadPool.Profile", "[onTaskBeforeExecute] %s", new Object[] { parame });
    this.psZ.decrementAndGet();
    AppMethodBeat.o(111076);
  }
  
  public final void c(com.tencent.mm.sdk.g.e parame)
  {
    AppMethodBeat.i(111077);
    ab.i("MicroMsg.ThreadPool.Profile", "[onTaskAfterExecuted] %s", new Object[] { parame });
    AppMethodBeat.o(111077);
  }
  
  public final void d(com.tencent.mm.sdk.g.e parame)
  {
    AppMethodBeat.i(111078);
    ab.i("MicroMsg.ThreadPool.Profile", "[onTaskRemove] %s", new Object[] { parame });
    AppMethodBeat.o(111078);
  }
  
  public final void e(com.tencent.mm.sdk.g.e parame)
  {
    AppMethodBeat.i(111079);
    ab.i("MicroMsg.ThreadPool.Profile", "[onTaskTimeout] %s", new Object[] { parame });
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(960L, 1L, 1L, false);
    com.tencent.mm.plugin.report.e.qrI.e(16347, new Object[] { "", Integer.valueOf(0), parame.toString(), Long.valueOf(1800000L), Integer.valueOf(1) });
    AppMethodBeat.o(111079);
  }
  
  public final void kP(long paramLong)
  {
    AppMethodBeat.i(111081);
    this.psX.removeCallbacks(this.psY);
    ab.w("MicroMsg.ThreadPool.Profile", "[onRelax] duration:%s", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(960L, 2L, 1L, false);
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(960L, 4L, Math.max(1L, paramLong), false);
    AppMethodBeat.o(111081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a
 * JD-Core Version:    0.7.0.1
 */