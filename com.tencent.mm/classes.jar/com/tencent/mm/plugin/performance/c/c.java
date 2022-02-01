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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
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
  private static final c wZJ;
  public final ActivityManager aJm;
  private volatile String activity;
  public boolean cCq;
  private long gwR;
  public int wZK;
  public int wZL;
  private int wZM;
  private final Set<String> wZN;
  private boolean wZO;
  
  static
  {
    AppMethodBeat.i(215469);
    wZJ = new c();
    AppMethodBeat.o(215469);
  }
  
  private c()
  {
    AppMethodBeat.i(215454);
    this.wZM = 0;
    this.wZN = new HashSet();
    this.wZO = true;
    this.cCq = true;
    this.aJm = ((ActivityManager)ak.getContext().getSystemService("activity"));
    this.gwR = 0L;
    com.tencent.mm.performance.a.a.iMQ = new c.1(this);
    AppMethodBeat.o(215454);
  }
  
  private void Nf(int paramInt)
  {
    AppMethodBeat.i(215458);
    h.MqF.aO(new c.2(this, paramInt));
    AppMethodBeat.o(215458);
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
  
  private boolean ahn()
  {
    AppMethodBeat.i(215462);
    long l = SystemClock.uptimeMillis();
    if (l - this.gwR > 2000L) {}
    for (boolean bool = true;; bool = false)
    {
      this.gwR = l;
      AppMethodBeat.o(215462);
      return bool;
    }
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(215460);
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
    AppMethodBeat.o(215460);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(215460);
    return paramInputStream;
  }
  
  public static c dCq()
  {
    return wZJ;
  }
  
  private a[] dCr()
  {
    AppMethodBeat.i(215456);
    Object localObject = this.aJm.getRunningAppProcesses();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < ((List)localObject).size())
    {
      if (Process.myUid() != ((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).uid) {
        ae.e("MicroMsg.MemoryWatchDog", "info with uid [%s] & process name [%s] is not current app [%s]", new Object[] { Integer.valueOf(((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).uid), ((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).processName, Integer.valueOf(Process.myUid()) });
      }
      for (;;)
      {
        i += 1;
        break;
        a locala = new a();
        locala.pid = ((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).pid;
        locala.processName = ((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).processName;
        localArrayList.add(locala);
        ae.d("MicroMsg.MemoryWatchDog", "pid = %s, process = %s", new Object[] { Integer.valueOf(locala.pid), locala.processName });
      }
    }
    localObject = new a[localArrayList.size()];
    localArrayList.toArray((Object[])localObject);
    AppMethodBeat.o(215456);
    return localObject;
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(215461);
    Object localObject1 = new k(paramString);
    paramString = null;
    try
    {
      localObject1 = o.ai((k)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      AppMethodBeat.o(215461);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(215461);
    }
  }
  
  private static String getVmSize()
  {
    AppMethodBeat.i(215459);
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
          AppMethodBeat.o(215459);
          return str;
        }
        i += 1;
      }
      ae.w("MicroMsg.MemoryWatchDog", "[getVmSize] Wrong!", new Object[] { localObject[12] });
      localObject = localObject[12];
      AppMethodBeat.o(215459);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(215459);
    }
    return "";
  }
  
  public final a P(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(215455);
    long l1 = System.currentTimeMillis();
    a locala = new a();
    if (this.activity != null) {
      locala.activity = this.activity;
    }
    locala.doj = paramInt;
    locala.wZX = this.wZK;
    locala.wZY = this.wZL;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        long l2 = System.currentTimeMillis();
        Object localObject1 = this.aJm.getProcessMemoryInfo(new int[] { Process.myPid() });
        ae.d("MicroMsg.MemoryWatchDog", "pidMemInfoArray size = " + localObject1.length);
        if ((localObject1 != null) && (localObject1.length == 1))
        {
          localObject1 = localObject1[0];
          locala.xab = ((Debug.MemoryInfo)localObject1).getTotalPss();
          if (Build.VERSION.SDK_INT >= 23) {
            locala.map = ((Debug.MemoryInfo)localObject1).getMemoryStats();
          }
        }
        else
        {
          ae.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
          if (!ak.coh()) {
            continue;
          }
          l2 = System.currentTimeMillis();
          localObject1 = dCr();
          Debug.MemoryInfo[] arrayOfMemoryInfo = this.aJm.getProcessMemoryInfo(a((a[])localObject1));
          if (arrayOfMemoryInfo == null) {
            continue;
          }
          ae.d("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 size = %s, memoryInfos size = %s", new Object[] { Integer.valueOf(arrayOfMemoryInfo.length), Integer.valueOf(localObject1.length) });
          if ((!j.DEBUG) && (!j.IS_FLAVOR_RED) && (!bv.fpR())) {
            break label1098;
          }
          Assert.assertEquals(localObject1.length, arrayOfMemoryInfo.length);
          break label1098;
          if (paramInt >= Math.min(arrayOfMemoryInfo.length, localObject1.length)) {
            continue;
          }
          ae.d("MicroMsg.MemoryWatchDog", "total pss = %d", new Object[] { Integer.valueOf(arrayOfMemoryInfo[paramInt].getTotalPss()) });
          localObject1[paramInt].xab = arrayOfMemoryInfo[paramInt].getTotalPss();
          i += localObject1[paramInt].xab;
          paramInt += 1;
          continue;
        }
        ae.d("MicroMsg.MemoryWatchDog", "API level < 23, reflect to get stat");
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
        ae.d("MicroMsg.MemoryWatchDog", "reflect stat: %s", new Object[] { locala.map });
        continue;
        Object localObject2;
        int i = 0;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MemoryWatchDog", localException, "", new Object[0]);
        return locala;
        locala.xac = i;
        locala.xad = localException;
        ae.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
        localObject2 = Pattern.compile("\\d+").matcher(getVmSize());
        if (((Matcher)localObject2).find()) {
          locala.wZQ = bu.aSB(((Matcher)localObject2).group());
        }
        locala.wZR = Debug.getNativeHeapSize();
        locala.wZS = Debug.getNativeHeapAllocatedSize();
        locala.wZT = Debug.getNativeHeapFreeSize();
        locala.wZU = Runtime.getRuntime().totalMemory();
        locala.wZV = Runtime.getRuntime().freeMemory();
        locala.wZW = Runtime.getRuntime().maxMemory();
        localObject2 = new ActivityManager.MemoryInfo();
        this.aJm.getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
        locala.xaa = ((ActivityManager.MemoryInfo)localObject2);
        locala.gwG = (System.currentTimeMillis() - l1);
        if ((!j.IS_FLAVOR_RED) && (!j.IS_FLAVOR_PURPLE) && (!paramBoolean) && (locala.gwG > 30L) && (this.wZO))
        {
          this.wZM += 1;
          if (this.wZM > 10)
          {
            ae.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
            this.wZO = false;
          }
        }
        if (locala.xaa != null) {
          continue;
        }
        ae.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
        locala.xaa = new ActivityManager.MemoryInfo();
        continue;
        ae.e("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 == null");
        continue;
      }
      finally
      {
        locala.gwG = (System.currentTimeMillis() - l1);
        if ((!j.IS_FLAVOR_RED) && (!j.IS_FLAVOR_PURPLE) && (!paramBoolean) && (locala.gwG > 30L) && (this.wZO))
        {
          this.wZM += 1;
          if (this.wZM > 10)
          {
            ae.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
            this.wZO = false;
          }
        }
        if (locala.xaa == null)
        {
          ae.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
          locala.xaa = new ActivityManager.MemoryInfo();
        }
        AppMethodBeat.o(215455);
      }
      label1098:
      paramInt = 0;
    }
  }
  
  public final a dCs()
  {
    AppMethodBeat.i(224465);
    a locala = P(true, 0);
    AppMethodBeat.o(224465);
    return locala;
  }
  
  public final void dCt()
  {
    boolean bool = true;
    AppMethodBeat.i(215465);
    a locala = P(true, 3);
    new StringBuilder("[AutoCheck] ").append(locala);
    ae.i("MicroMsg.MemoryWatchDog", "[AutoCheck] process = %s AppForeground = %s %s", new Object[] { ak.getProcessName(), Boolean.valueOf(this.cCq), locala });
    if (!this.wZN.isEmpty()) {}
    for (;;)
    {
      b.a(locala, bool);
      AppMethodBeat.o(215465);
      return;
      bool = false;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(215467);
    if ((ak.isAppBrandProcess()) || (ak.foD()) || (ak.foC()))
    {
      paramActivity = paramActivity.toString() + ":" + paramActivity.hashCode();
      this.wZN.add(paramActivity);
      ae.i("MicroMsg.MemoryWatchDog", "onActivityCreated: %s, mActivities.size = %s", new Object[] { paramActivity, Integer.valueOf(this.wZN.size()) });
    }
    AppMethodBeat.o(215467);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(215468);
    if ((ak.isAppBrandProcess()) || (ak.foD()) || (ak.foC()))
    {
      paramActivity = paramActivity.toString() + ":" + paramActivity.hashCode();
      this.wZN.remove(paramActivity);
      ae.i("MicroMsg.MemoryWatchDog", "onActivityDestroyed: %s, mActivities.size = %s", new Object[] { paramActivity, Integer.valueOf(this.wZN.size()) });
    }
    AppMethodBeat.o(215468);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(215463);
    this.activity = paramActivity.getClass().getSimpleName();
    if (ahn())
    {
      if (this.wZO)
      {
        ae.i("MicroMsg.MemoryWatchDog", "[onActivityResumed] activity:%s %s", new Object[] { this.activity, P(false, 1) });
        AppMethodBeat.o(215463);
        return;
      }
      Nf(1);
    }
    AppMethodBeat.o(215463);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(215464);
    if (ahn())
    {
      if (this.wZO)
      {
        ae.i("MicroMsg.MemoryWatchDog", "[onActivityStopped] activity:%s %s", new Object[] { paramActivity.getClass().getSimpleName(), P(false, 2) });
        AppMethodBeat.o(215464);
        return;
      }
      Nf(2);
    }
    AppMethodBeat.o(215464);
  }
  
  public final void run()
  {
    AppMethodBeat.i(215466);
    dCt();
    i locali = h.MqF;
    if (this.cCq) {}
    for (long l = 300000L;; l = 1800000L)
    {
      locali.r(this, l);
      AppMethodBeat.o(215466);
      return;
    }
  }
  
  public static final class a
  {
    String activity;
    int doj;
    long gwG;
    Map<String, String> map;
    int pid;
    String processName;
    int wZQ;
    long wZR;
    long wZS;
    long wZT;
    long wZU;
    long wZV;
    long wZW;
    long wZX;
    long wZY;
    long wZZ;
    ActivityManager.MemoryInfo xaa;
    int xab;
    int xac;
    a[] xad;
    
    public a()
    {
      AppMethodBeat.i(215451);
      this.processName = "current";
      this.doj = 0;
      this.activity = "default";
      this.wZZ = Thread.currentThread().getId();
      AppMethodBeat.o(215451);
    }
    
    private static String aE(Map<String, String> paramMap)
    {
      AppMethodBeat.i(215453);
      if (paramMap == null)
      {
        AppMethodBeat.o(215453);
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
      AppMethodBeat.o(215453);
      return paramMap;
    }
    
    public final String toString()
    {
      int i = 0;
      AppMethodBeat.i(215452);
      Object localObject = new StringBuilder(" \n");
      ((StringBuilder)localObject).append(String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> MemoryInfo(pid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { Long.valueOf(this.wZZ) })).append("\n| Activity:\t ").append(this.activity).append("\n| Source:\t ").append(this.doj).append("\n| VmSize:\t ").append(this.wZQ).append("kB\n| SystemMemoryInfo:\t totalMem=").append(this.xaa.totalMem).append(", availMem=").append(this.xaa.availMem).append(", lowMemory=").append(this.xaa.lowMemory).append(", threshold=").append(this.xaa.threshold).append("\n| Dalvik:\t memClass=").append(this.wZX).append(", memLargeClass=").append(this.wZY).append(" B, TalMemory=").append(this.wZU).append(" B, FreeMemory=").append(this.wZV).append(" B, MaxMemory=").append(this.wZW).append(" B\n| NATIVE:\t HeapSize=").append(this.wZR).append(" B, AllocatedSize=").append(this.wZS).append(" B, FreeSize=").append(this.wZT).append(" B\n| Stats:\t pss-sum:").append(this.xac).append(" KB, ").append(aE(this.map)).append("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:").append(this.gwG).append("ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
      if (this.xad != null)
      {
        a[] arrayOfa = this.xad;
        int j = arrayOfa.length;
        while (i < j)
        {
          a locala = arrayOfa[i];
          ((StringBuilder)localObject).append("| Process: ").append(locala.processName).append(", pid: ").append(locala.pid).append(", totalPss: ").append(locala.xab).append("\n");
          i += 1;
        }
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(215452);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.c
 * JD-Core Version:    0.7.0.1
 */