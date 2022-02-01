package com.tencent.mm.plugin.performance.watchdogs;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class d
  implements Runnable
{
  private static final d AXI;
  private int AWb;
  public boolean cQp;
  private final ActivityManager mActivityManager;
  
  static
  {
    AppMethodBeat.i(201181);
    AXI = new d();
    AppMethodBeat.o(201181);
  }
  
  private d()
  {
    AppMethodBeat.i(201178);
    this.cQp = false;
    this.AWb = 0;
    this.mActivityManager = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity"));
    AppMethodBeat.o(201178);
  }
  
  public static d eCN()
  {
    return AXI;
  }
  
  public final List<d.a> eCO()
  {
    AppMethodBeat.i(201180);
    long l = System.currentTimeMillis();
    Object localObject1 = this.mActivityManager.getRunningAppProcesses();
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        if (Process.myUid() != ((ActivityManager.RunningAppProcessInfo)localObject2).uid)
        {
          Log.e("MicroMsg.ProcessWatchDog", "info with uid [%s] & process name [%s] is not current app [%s]", new Object[] { Integer.valueOf(((ActivityManager.RunningAppProcessInfo)localObject2).uid), ((ActivityManager.RunningAppProcessInfo)localObject2).processName, Integer.valueOf(Process.myUid()) });
        }
        else
        {
          Debug.MemoryInfo[] arrayOfMemoryInfo = this.mActivityManager.getProcessMemoryInfo(new int[] { ((ActivityManager.RunningAppProcessInfo)localObject2).pid });
          localObject2 = new d.a(((ActivityManager.RunningAppProcessInfo)localObject2).processName, ((ActivityManager.RunningAppProcessInfo)localObject2).pid);
          if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length == 1) && (arrayOfMemoryInfo[0] != null)) {
            ((d.a)localObject2).AXJ = arrayOfMemoryInfo[0].getTotalPss();
          }
          localArrayList.add(localObject2);
        }
      }
    }
    Log.i("MicroMsg.ProcessWatchDog", "dumpProcess cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(201180);
    return localArrayList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(201179);
    Object localObject1 = eCO();
    if (!((List)localObject1).isEmpty())
    {
      int i = ((List)localObject1).size();
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(new IDKey(1474, 0, 1));
      ((ArrayList)localObject2).add(new IDKey(1474, i, 1));
      e.Cxv.b((ArrayList)localObject2, false);
      int j = ((b)g.af(b.class)).a(b.a.smU, 12);
      localObject2 = ((List)localObject1).iterator();
      for (l = 0L; ((Iterator)localObject2).hasNext(); l = ((d.a)((Iterator)localObject2).next()).AXJ + l) {}
      localObject1 = Arrays.toString(((List)localObject1).toArray()).replace(",", ";");
      if ((i >= j) && (i > this.AWb))
      {
        this.AWb = i;
        e.Cxv.a(20846, new Object[] { Integer.valueOf(i), localObject1, Long.valueOf(l) });
      }
      Log.i("MicroMsg.ProcessWatchDog", "DumpProcesses: %s || pssSum : %s", new Object[] { localObject1, Long.valueOf(l) });
    }
    localObject1 = h.RTc;
    if (this.cQp) {}
    for (long l = 300000L;; l = 1800000L)
    {
      ((i)localObject1).o(this, l);
      AppMethodBeat.o(201179);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.d
 * JD-Core Version:    0.7.0.1
 */