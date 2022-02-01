package com.tencent.mm.plugin.performance.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class d
  implements Runnable
{
  private static final d wKt;
  public boolean cBJ;
  private int wJs;
  private final ActivityManager wKu;
  
  static
  {
    AppMethodBeat.i(211804);
    wKt = new d();
    AppMethodBeat.o(211804);
  }
  
  private d()
  {
    AppMethodBeat.i(211801);
    this.cBJ = false;
    this.wJs = 0;
    this.wKu = ((ActivityManager)aj.getContext().getSystemService("activity"));
    AppMethodBeat.o(211801);
  }
  
  public static d dzd()
  {
    return wKt;
  }
  
  public final List<a> dze()
  {
    AppMethodBeat.i(211803);
    long l = System.currentTimeMillis();
    Object localObject1 = this.wKu.getRunningAppProcesses();
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        Debug.MemoryInfo[] arrayOfMemoryInfo = this.wKu.getProcessMemoryInfo(new int[] { ((ActivityManager.RunningAppProcessInfo)localObject2).pid });
        localObject2 = new a(((ActivityManager.RunningAppProcessInfo)localObject2).processName, ((ActivityManager.RunningAppProcessInfo)localObject2).pid);
        if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length == 1)) {
          ((a)localObject2).wKv = arrayOfMemoryInfo[0].getTotalPss();
        }
        localArrayList.add(localObject2);
      }
    }
    ad.i("MicroMsg.ProcessWatchDog", "dumpProcess cost: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(211803);
    return localArrayList;
  }
  
  public final void run()
  {
    AppMethodBeat.i(211802);
    Object localObject1 = dze();
    if (!((List)localObject1).isEmpty())
    {
      int i = ((List)localObject1).size();
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(new IDKey(1474, 0, 1));
      ((ArrayList)localObject2).add(new IDKey(1474, i, 1));
      e.ygI.b((ArrayList)localObject2, false);
      int j = ((b)g.ab(b.class)).a(b.a.qId, 11);
      localObject2 = ((List)localObject1).iterator();
      for (l = 0L; ((Iterator)localObject2).hasNext(); l = ((a)((Iterator)localObject2).next()).wKv + l) {}
      localObject1 = Arrays.toString(((List)localObject1).toArray());
      if ((i >= j) && (i > this.wJs))
      {
        this.wJs = i;
        e.ygI.f(20772, new Object[] { Integer.valueOf(i), localObject1, Long.valueOf(l) });
      }
      ad.i("MicroMsg.ProcessWatchDog", "DumpProcesses: %s || pssSum : %s", new Object[] { localObject1, Long.valueOf(l) });
    }
    localObject1 = h.LTJ;
    if (this.cBJ) {}
    for (long l = 300000L;; l = 1800000L)
    {
      ((i)localObject1).r(this, l);
      AppMethodBeat.o(211802);
      return;
    }
  }
  
  static final class a
  {
    int pid;
    String processName;
    long wKv;
    
    public a(String paramString, int paramInt)
    {
      this.processName = paramString;
      this.pid = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(211800);
      String str = this.processName + "|pid:" + this.pid + "|pss:" + this.wKv;
      AppMethodBeat.o(211800);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.d
 * JD-Core Version:    0.7.0.1
 */