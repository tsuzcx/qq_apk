package com.tencent.mm.plugin.performance.watchdogs;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.e.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class d
  implements Runnable
{
  private static final d GRt;
  private int GPz;
  public boolean dgo;
  private final ActivityManager mActivityManager;
  
  static
  {
    AppMethodBeat.i(200711);
    GRt = new d();
    AppMethodBeat.o(200711);
  }
  
  private d()
  {
    AppMethodBeat.i(200704);
    this.dgo = false;
    this.GPz = 0;
    this.mActivityManager = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity"));
    AppMethodBeat.o(200704);
  }
  
  public static d foB()
  {
    return GRt;
  }
  
  public final List<a> foC()
  {
    AppMethodBeat.i(200710);
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
            ((a)localObject2).GRu = arrayOfMemoryInfo[0].getTotalPss();
          }
          localArrayList.add(localObject2);
        }
      }
    }
    Log.i("MicroMsg.ProcessWatchDog", "dumpProcess cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(200710);
    return localArrayList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(200705);
    Object localObject1 = foC();
    if (!((List)localObject1).isEmpty())
    {
      int i = ((List)localObject1).size();
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(new IDKey(1474, 0, 1));
      if (i <= 127) {
        ((ArrayList)localObject2).add(new IDKey(1474, i, 1));
      }
      f.Iyx.b((ArrayList)localObject2, false);
      int j = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vXW, 12);
      localObject2 = ((List)localObject1).iterator();
      for (l = 0L; ((Iterator)localObject2).hasNext(); l = ((a)((Iterator)localObject2).next()).GRu + l) {}
      localObject1 = Arrays.toString(((List)localObject1).toArray()).replace(",", ";");
      if ((i >= j) && (i > this.GPz))
      {
        this.GPz = i;
        f.Iyx.a(20846, new Object[] { Integer.valueOf(i), localObject1, Long.valueOf(l) });
      }
      Log.i("MicroMsg.ProcessWatchDog", "DumpProcesses: %s || pssSum : %s", new Object[] { localObject1, Long.valueOf(l) });
    }
    localObject1 = com.tencent.e.h.ZvG;
    if (this.dgo) {}
    for (long l = 300000L;; l = 1800000L)
    {
      ((i)localObject1).o(this, l);
      AppMethodBeat.o(200705);
      return;
    }
  }
  
  static final class a
  {
    long GRu;
    int pid;
    String processName;
    
    public a(String paramString, int paramInt)
    {
      this.processName = paramString;
      this.pid = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200685);
      String str = this.processName + "|pid:" + this.pid + "|pss:" + this.GRu;
      AppMethodBeat.o(200685);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.d
 * JD-Core Version:    0.7.0.1
 */