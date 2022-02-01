package com.tencent.mm.plugin.performance.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class d
  implements Runnable
{
  private static final d xae;
  public boolean cCq;
  private int wZd;
  private final ActivityManager xaf;
  
  static
  {
    AppMethodBeat.i(215474);
    xae = new d();
    AppMethodBeat.o(215474);
  }
  
  private d()
  {
    AppMethodBeat.i(215471);
    this.cCq = false;
    this.wZd = 0;
    this.xaf = ((ActivityManager)ak.getContext().getSystemService("activity"));
    AppMethodBeat.o(215471);
  }
  
  public static d dCu()
  {
    return xae;
  }
  
  public final List<a> dCv()
  {
    AppMethodBeat.i(215473);
    long l = System.currentTimeMillis();
    Object localObject1 = this.xaf.getRunningAppProcesses();
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        if (Process.myUid() != ((ActivityManager.RunningAppProcessInfo)localObject2).uid)
        {
          ae.e("MicroMsg.ProcessWatchDog", "info with uid [%s] & process name [%s] is not current app [%s]", new Object[] { Integer.valueOf(((ActivityManager.RunningAppProcessInfo)localObject2).uid), ((ActivityManager.RunningAppProcessInfo)localObject2).processName, Integer.valueOf(Process.myUid()) });
        }
        else
        {
          Debug.MemoryInfo[] arrayOfMemoryInfo = this.xaf.getProcessMemoryInfo(new int[] { ((ActivityManager.RunningAppProcessInfo)localObject2).pid });
          localObject2 = new a(((ActivityManager.RunningAppProcessInfo)localObject2).processName, ((ActivityManager.RunningAppProcessInfo)localObject2).pid);
          if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length == 1)) {
            ((a)localObject2).xag = arrayOfMemoryInfo[0].getTotalPss();
          }
          localArrayList.add(localObject2);
        }
      }
    }
    ae.i("MicroMsg.ProcessWatchDog", "dumpProcess cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(215473);
    return localArrayList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(215472);
    Object localObject1 = dCv();
    if (!((List)localObject1).isEmpty())
    {
      int i = ((List)localObject1).size();
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(new IDKey(1474, 0, 1));
      ((ArrayList)localObject2).add(new IDKey(1474, i, 1));
      e.ywz.b((ArrayList)localObject2, false);
      int j = ((b)g.ab(b.class)).a(b.a.qPJ, 12);
      localObject2 = ((List)localObject1).iterator();
      for (l = 0L; ((Iterator)localObject2).hasNext(); l = ((a)((Iterator)localObject2).next()).xag + l) {}
      localObject1 = Arrays.toString(((List)localObject1).toArray()).replace(",", ";");
      if ((i >= j) && (i > this.wZd))
      {
        this.wZd = i;
        e.ywz.f(20846, new Object[] { Integer.valueOf(i), localObject1, Long.valueOf(l) });
      }
      ae.i("MicroMsg.ProcessWatchDog", "DumpProcesses: %s || pssSum : %s", new Object[] { localObject1, Long.valueOf(l) });
    }
    localObject1 = h.MqF;
    if (this.cCq) {}
    for (long l = 300000L;; l = 1800000L)
    {
      ((i)localObject1).r(this, l);
      AppMethodBeat.o(215472);
      return;
    }
  }
  
  static final class a
  {
    int pid;
    String processName;
    long xag;
    
    public a(String paramString, int paramInt)
    {
      this.processName = paramString;
      this.pid = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(215470);
      String str = this.processName + "|pid:" + this.pid + "|pss:" + this.xag;
      AppMethodBeat.o(215470);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.d
 * JD-Core Version:    0.7.0.1
 */