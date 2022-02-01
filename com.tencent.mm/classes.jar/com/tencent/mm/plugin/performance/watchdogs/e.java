package com.tencent.mm.plugin.performance.watchdogs;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class e
  implements Runnable
{
  private static final e MOR;
  private int MMQ;
  public boolean ffv;
  private final ActivityManager mActivityManager;
  
  static
  {
    AppMethodBeat.i(301026);
    MOR = new e();
    AppMethodBeat.o(301026);
  }
  
  private e()
  {
    AppMethodBeat.i(301020);
    this.ffv = false;
    this.MMQ = 0;
    this.mActivityManager = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity"));
    AppMethodBeat.o(301020);
  }
  
  public static e gzB()
  {
    return MOR;
  }
  
  public final List<a> gzC()
  {
    AppMethodBeat.i(301043);
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
          localObject2 = new a(((ActivityManager.RunningAppProcessInfo)localObject2).processName, ((ActivityManager.RunningAppProcessInfo)localObject2).pid);
          if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length == 1) && (arrayOfMemoryInfo[0] != null)) {
            ((a)localObject2).MOS = arrayOfMemoryInfo[0].getTotalPss();
          }
          localArrayList.add(localObject2);
        }
      }
    }
    Log.i("MicroMsg.ProcessWatchDog", "dumpProcess cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(301043);
    return localArrayList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(301037);
    Object localObject1 = gzC();
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      localObject1 = com.tencent.threadpool.h.ahAA;
      if (!this.ffv) {
        break label280;
      }
    }
    label280:
    for (long l = 300000L;; l = 1800000L)
    {
      ((i)localObject1).p(this, l);
      AppMethodBeat.o(301037);
      return;
      int i = ((List)localObject1).size();
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(new IDKey(1474, 0, 1));
      if (i <= 127) {
        ((ArrayList)localObject2).add(new IDKey(1474, i, 1));
      }
      f.Ozc.b((ArrayList)localObject2, false);
      int j = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zqL, 12);
      localObject2 = ((List)localObject1).iterator();
      for (l = 0L; ((Iterator)localObject2).hasNext(); l = ((a)((Iterator)localObject2).next()).MOS + l) {}
      localObject1 = Arrays.toString(((List)localObject1).toArray()).replace(",", ";");
      if ((i >= j) && (i > this.MMQ))
      {
        this.MMQ = i;
        f.Ozc.b(20846, new Object[] { Integer.valueOf(i), localObject1, Long.valueOf(l) });
      }
      Log.i("MicroMsg.ProcessWatchDog", "DumpProcesses: %s || pssSum : %s", new Object[] { localObject1, Long.valueOf(l) });
      break;
    }
  }
  
  static final class a
  {
    long MOS;
    int pid;
    String processName;
    
    public a(String paramString, int paramInt)
    {
      this.processName = paramString;
      this.pid = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(300982);
      String str = this.processName + "|pid:" + this.pid + "|pss:" + this.MOS;
      AppMethodBeat.o(300982);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.e
 * JD-Core Version:    0.7.0.1
 */