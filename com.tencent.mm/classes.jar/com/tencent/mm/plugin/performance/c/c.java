package com.tencent.mm.plugin.performance.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.e;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class c
  implements Application.ActivityLifecycleCallbacks, Runnable
{
  private static final c wJY;
  public final ActivityManager aJm;
  private volatile String activity;
  public boolean cBJ;
  private long guk;
  public int wJZ;
  public int wKa;
  private int wKb;
  private final Set<String> wKc;
  private boolean wKd;
  
  static
  {
    AppMethodBeat.i(211799);
    wJY = new c();
    AppMethodBeat.o(211799);
  }
  
  private c()
  {
    AppMethodBeat.i(211784);
    this.wKb = 0;
    this.wKc = new HashSet();
    this.wKd = true;
    this.cBJ = true;
    this.aJm = ((ActivityManager)aj.getContext().getSystemService("activity"));
    this.guk = 0L;
    com.tencent.mm.performance.a.a.iJX = new c.1(this);
    AppMethodBeat.o(211784);
  }
  
  private void Mz(int paramInt)
  {
    AppMethodBeat.i(211788);
    h.LTJ.aR(new c.2(this, paramInt));
    AppMethodBeat.o(211788);
  }
  
  private static int[] a(a[] paramArrayOfa)
  {
    int[] arrayOfInt = new int[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      arrayOfInt[i] = paramArrayOfa[i].pid;
      i += 1;
    }
    return arrayOfInt;
  }
  
  private boolean agY()
  {
    AppMethodBeat.i(211792);
    long l = SystemClock.uptimeMillis();
    if (l - this.guk > 2000L) {}
    for (boolean bool = true;; bool = false)
    {
      this.guk = l;
      AppMethodBeat.o(211792);
      return bool;
    }
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(211790);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      try
      {
        for (;;)
        {
          paramInputStream = localBufferedReader.readLine();
          if (paramInputStream == null) {
            break;
          }
          localStringBuilder.append(paramInputStream).append('\n');
        }
        if (localBufferedReader == null) {
          break label61;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
    localBufferedReader.close();
    label61:
    AppMethodBeat.o(211790);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(211790);
    return paramInputStream;
  }
  
  public static c dyZ()
  {
    return wJY;
  }
  
  private a[] dza()
  {
    AppMethodBeat.i(211786);
    Object localObject = this.aJm.getRunningAppProcesses();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < ((List)localObject).size())
    {
      if (Process.myUid() != ((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).uid) {
        ad.e("MicroMsg.MemoryWatchDog", "info with uid [%s] & process name [%s] is not current app [%s]", new Object[] { Integer.valueOf(((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).uid), ((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).processName, Integer.valueOf(Process.myUid()) });
      }
      for (;;)
      {
        i += 1;
        break;
        a locala = new a();
        locala.pid = ((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).pid;
        locala.processName = ((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).processName;
        localArrayList.add(locala);
        ad.d("MicroMsg.MemoryWatchDog", "pid = %s, process = %s", new Object[] { Integer.valueOf(locala.pid), locala.processName });
      }
    }
    localObject = new a[localArrayList.size()];
    localArrayList.toArray((Object[])localObject);
    AppMethodBeat.o(211786);
    return localObject;
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(211791);
    Object localObject1 = new e(paramString);
    paramString = null;
    try
    {
      localObject1 = com.tencent.mm.vfs.i.ai((e)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      AppMethodBeat.o(211791);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(211791);
    }
  }
  
  private static String getVmSize()
  {
    AppMethodBeat.i(211789);
    Object localObject = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      localObject = getStringFromFile((String)localObject).trim().split("\n");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        boolean bool = str.startsWith("VmSize");
        if (bool)
        {
          AppMethodBeat.o(211789);
          return str;
        }
        i += 1;
      }
      ad.w("MicroMsg.MemoryWatchDog", "[getVmSize] Wrong!", new Object[] { localObject[12] });
      localObject = localObject[12];
      AppMethodBeat.o(211789);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(211789);
    }
    return "";
  }
  
  public final a M(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(211785);
    long l1 = System.currentTimeMillis();
    a locala = new a();
    if (this.activity != null) {
      locala.activity = this.activity;
    }
    locala.dnh = paramInt;
    locala.wKm = this.wJZ;
    locala.wKn = this.wKa;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        long l2 = System.currentTimeMillis();
        Object localObject1 = this.aJm.getProcessMemoryInfo(new int[] { Process.myPid() });
        ad.d("MicroMsg.MemoryWatchDog", "pidMemInfoArray size = " + localObject1.length);
        if ((localObject1 != null) && (localObject1.length == 1))
        {
          localObject1 = localObject1[0];
          locala.wKq = ((Debug.MemoryInfo)localObject1).getTotalPss();
          if (Build.VERSION.SDK_INT >= 23) {
            locala.map = ((Debug.MemoryInfo)localObject1).getMemoryStats();
          }
        }
        else
        {
          ad.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
          if (!aj.cmR()) {
            continue;
          }
          l2 = System.currentTimeMillis();
          localObject1 = dza();
          Debug.MemoryInfo[] arrayOfMemoryInfo = this.aJm.getProcessMemoryInfo(a((a[])localObject1));
          if (arrayOfMemoryInfo == null) {
            continue;
          }
          ad.d("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 size = %s, memoryInfos size = %s", new Object[] { Integer.valueOf(arrayOfMemoryInfo.length), Integer.valueOf(localObject1.length) });
          if ((!com.tencent.mm.sdk.platformtools.i.DEBUG) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) && (!bu.flW())) {
            break label1098;
          }
          Assert.assertEquals(localObject1.length, arrayOfMemoryInfo.length);
          break label1098;
          if (paramInt >= Math.min(arrayOfMemoryInfo.length, localObject1.length)) {
            continue;
          }
          ad.d("MicroMsg.MemoryWatchDog", "total pss = %d", new Object[] { Integer.valueOf(arrayOfMemoryInfo[paramInt].getTotalPss()) });
          localObject1[paramInt].wKq = arrayOfMemoryInfo[paramInt].getTotalPss();
          i += localObject1[paramInt].wKq;
          paramInt += 1;
          continue;
        }
        ad.d("MicroMsg.MemoryWatchDog", "API level < 23, reflect to get stat");
        locala.map = new HashMap();
        locala.map.put("summary.java-heap", String.valueOf(((Debug.MemoryInfo)localObject1).dalvikPrivateDirty));
        locala.map.put("summary.native-heap", String.valueOf(((Debug.MemoryInfo)localObject1).nativePrivateDirty));
        locala.map.put("summary.code", "-1");
        locala.map.put("summary.stack", "-1");
        locala.map.put("summary.graphics", "-1");
        locala.map.put("summary.private-other", "-1");
        locala.map.put("summary.system", String.valueOf(((Debug.MemoryInfo)localObject1).getTotalPss() - ((Debug.MemoryInfo)localObject1).getTotalPrivateClean() - ((Debug.MemoryInfo)localObject1).getTotalPrivateDirty()));
        locala.map.put("summary.total-pss", String.valueOf(((Debug.MemoryInfo)localObject1).getTotalPss()));
        locala.map.put("summary.total-swap", "-1");
        ad.d("MicroMsg.MemoryWatchDog", "reflect stat: %s", new Object[] { locala.map });
        continue;
        Object localObject2;
        int i = 0;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MemoryWatchDog", localException, "", new Object[0]);
        return locala;
        locala.wKr = i;
        locala.wKs = localException;
        ad.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
        localObject2 = Pattern.compile("\\d+").matcher(getVmSize());
        if (((Matcher)localObject2).find()) {
          locala.wKf = bt.aRe(((Matcher)localObject2).group());
        }
        locala.wKg = Debug.getNativeHeapSize();
        locala.wKh = Debug.getNativeHeapAllocatedSize();
        locala.wKi = Debug.getNativeHeapFreeSize();
        locala.wKj = Runtime.getRuntime().totalMemory();
        locala.wKk = Runtime.getRuntime().freeMemory();
        locala.wKl = Runtime.getRuntime().maxMemory();
        localObject2 = new ActivityManager.MemoryInfo();
        this.aJm.getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
        locala.wKp = ((ActivityManager.MemoryInfo)localObject2);
        locala.gtZ = (System.currentTimeMillis() - l1);
        if ((!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) && (!paramBoolean) && (locala.gtZ > 30L) && (this.wKd))
        {
          this.wKb += 1;
          if (this.wKb > 10)
          {
            ad.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
            this.wKd = false;
          }
        }
        if (locala.wKp != null) {
          continue;
        }
        ad.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
        locala.wKp = new ActivityManager.MemoryInfo();
        continue;
        ad.e("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 == null");
        continue;
      }
      finally
      {
        locala.gtZ = (System.currentTimeMillis() - l1);
        if ((!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) && (!paramBoolean) && (locala.gtZ > 30L) && (this.wKd))
        {
          this.wKb += 1;
          if (this.wKb > 10)
          {
            ad.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
            this.wKd = false;
          }
        }
        if (locala.wKp == null)
        {
          ad.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
          locala.wKp = new ActivityManager.MemoryInfo();
        }
        AppMethodBeat.o(211785);
      }
      label1098:
      paramInt = 0;
    }
  }
  
  public final a dzb()
  {
    AppMethodBeat.i(221356);
    a locala = M(true, 0);
    AppMethodBeat.o(221356);
    return locala;
  }
  
  public final void dzc()
  {
    boolean bool = true;
    AppMethodBeat.i(211795);
    a locala = M(true, 3);
    new StringBuilder("[AutoCheck] ").append(locala);
    ad.i("MicroMsg.MemoryWatchDog", "[AutoCheck] process = %s AppForeground = %s %s", new Object[] { aj.getProcessName(), Boolean.valueOf(this.cBJ), locala });
    if (!this.wKc.isEmpty()) {}
    for (;;)
    {
      b.a(locala, bool);
      AppMethodBeat.o(211795);
      return;
      bool = false;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(211797);
    if ((aj.isAppBrandProcess()) || (aj.fkJ()) || (aj.fkI()))
    {
      paramActivity = paramActivity.toString() + ":" + paramActivity.hashCode();
      this.wKc.add(paramActivity);
      ad.i("MicroMsg.MemoryWatchDog", "onActivityCreated: %s, mActivities.size = %s", new Object[] { paramActivity, Integer.valueOf(this.wKc.size()) });
    }
    AppMethodBeat.o(211797);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(211798);
    if ((aj.isAppBrandProcess()) || (aj.fkJ()) || (aj.fkI()))
    {
      paramActivity = paramActivity.toString() + ":" + paramActivity.hashCode();
      this.wKc.remove(paramActivity);
      ad.i("MicroMsg.MemoryWatchDog", "onActivityDestroyed: %s, mActivities.size = %s", new Object[] { paramActivity, Integer.valueOf(this.wKc.size()) });
    }
    AppMethodBeat.o(211798);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(211793);
    this.activity = paramActivity.getClass().getSimpleName();
    if (agY())
    {
      if (this.wKd)
      {
        ad.i("MicroMsg.MemoryWatchDog", "[onActivityResumed] activity:%s %s", new Object[] { this.activity, M(false, 1) });
        AppMethodBeat.o(211793);
        return;
      }
      Mz(1);
    }
    AppMethodBeat.o(211793);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(211794);
    if (agY())
    {
      if (this.wKd)
      {
        ad.i("MicroMsg.MemoryWatchDog", "[onActivityStopped] activity:%s %s", new Object[] { paramActivity.getClass().getSimpleName(), M(false, 2) });
        AppMethodBeat.o(211794);
        return;
      }
      Mz(2);
    }
    AppMethodBeat.o(211794);
  }
  
  public final void run()
  {
    AppMethodBeat.i(211796);
    dzc();
    com.tencent.e.i locali = h.LTJ;
    if (this.cBJ) {}
    for (long l = 300000L;; l = 1800000L)
    {
      locali.r(this, l);
      AppMethodBeat.o(211796);
      return;
    }
  }
  
  public static final class a
  {
    String activity;
    int dnh;
    long gtZ;
    Map<String, String> map;
    int pid;
    String processName;
    int wKf;
    long wKg;
    long wKh;
    long wKi;
    long wKj;
    long wKk;
    long wKl;
    long wKm;
    long wKn;
    long wKo;
    ActivityManager.MemoryInfo wKp;
    int wKq;
    int wKr;
    a[] wKs;
    
    public a()
    {
      AppMethodBeat.i(211781);
      this.processName = "current";
      this.dnh = 0;
      this.activity = "default";
      this.wKo = Thread.currentThread().getId();
      AppMethodBeat.o(211781);
    }
    
    private static String ay(Map<String, String> paramMap)
    {
      AppMethodBeat.i(211783);
      if (paramMap == null)
      {
        AppMethodBeat.o(211783);
        return "null";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if ((!((String)localEntry.getKey()).equals("java-heap")) && (!((String)localEntry.getKey()).equals("native-heap"))) {
          localStringBuilder.append(((String)localEntry.getKey()).replaceFirst("summary.", "")).append("=").append((String)localEntry.getValue()).append(", ");
        }
      }
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      paramMap = localStringBuilder.toString();
      AppMethodBeat.o(211783);
      return paramMap;
    }
    
    public final String toString()
    {
      int i = 0;
      AppMethodBeat.i(211782);
      Object localObject = new StringBuilder(" \n");
      ((StringBuilder)localObject).append(String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> MemoryInfo(pid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { Long.valueOf(this.wKo) })).append("\n| Activity:\t ").append(this.activity).append("\n| Source:\t ").append(this.dnh).append("\n| VmSize:\t ").append(this.wKf).append("kB\n| SystemMemoryInfo:\t totalMem=").append(this.wKp.totalMem).append(", availMem=").append(this.wKp.availMem).append(", lowMemory=").append(this.wKp.lowMemory).append(", threshold=").append(this.wKp.threshold).append("\n| Dalvik:\t memClass=").append(this.wKm).append(", memLargeClass=").append(this.wKn).append(" B, TalMemory=").append(this.wKj).append(" B, FreeMemory=").append(this.wKk).append(" B, MaxMemory=").append(this.wKl).append(" B\n| NATIVE:\t HeapSize=").append(this.wKg).append(" B, AllocatedSize=").append(this.wKh).append(" B, FreeSize=").append(this.wKi).append(" B\n| Stats:\t pss-sum:").append(this.wKr).append(" KB, ").append(ay(this.map)).append("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:").append(this.gtZ).append("ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
      if (this.wKs != null)
      {
        a[] arrayOfa = this.wKs;
        int j = arrayOfa.length;
        while (i < j)
        {
          a locala = arrayOfa[i];
          ((StringBuilder)localObject).append("| Process: ").append(locala.processName).append(", pid: ").append(locala.pid).append(", totalPss: ").append(locala.wKq).append("\n");
          i += 1;
        }
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(211782);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.c
 * JD-Core Version:    0.7.0.1
 */