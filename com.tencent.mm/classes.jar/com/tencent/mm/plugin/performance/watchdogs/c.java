package com.tencent.mm.plugin.performance.watchdogs;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.f.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
  private static final c AXa;
  public int AXb;
  public int AXc;
  private int AXd;
  private final Set<String> AXe;
  private boolean AXf;
  private volatile boolean AXg;
  private long AXh;
  private long AXi;
  private long AXj;
  private long AXk;
  public long AXl;
  private boolean AXm;
  private boolean AXn;
  private long AXo;
  public final ActivityManager aJf;
  private volatile String activity;
  public volatile boolean cPB;
  
  static
  {
    AppMethodBeat.i(201176);
    AXa = new c();
    AppMethodBeat.o(201176);
  }
  
  private c()
  {
    AppMethodBeat.i(201152);
    this.AXd = 0;
    this.AXe = new HashSet();
    this.AXf = true;
    this.cPB = true;
    this.AXg = false;
    this.aJf = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity"));
    this.AXh = 524288000L;
    this.AXi = 1258291L;
    this.AXm = false;
    this.AXn = false;
    com.tencent.mm.performance.a.a.jJE = new com.tencent.mm.performance.a.a.a()
    {
      public final void bkR()
      {
        AppMethodBeat.i(201144);
        c.this.S(true, 0);
        AppMethodBeat.o(201144);
      }
    };
    com.tencent.matrix.a.cPA.a(new com.tencent.matrix.b.c()
    {
      public final void onForeground(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201145);
        Log.d("MicroMsg.MemoryWatchDog", "[%s] isProcessForeground: %s", new Object[] { MMApplicationContext.getProcessName(), Boolean.valueOf(paramAnonymousBoolean) });
        c.a(c.this, paramAnonymousBoolean);
        if (!paramAnonymousBoolean) {
          c.a(c.this, System.currentTimeMillis());
        }
        AppMethodBeat.o(201145);
      }
    });
    com.tencent.mm.plugin.performance.b.a.AUa.a(new com.tencent.mm.plugin.performance.b.a.a()
    {
      public final String Lb()
      {
        return "MicroMsg.MemoryWatchDog";
      }
      
      public final void eCj()
      {
        AppMethodBeat.i(201146);
        c.a(c.this);
        AppMethodBeat.o(201146);
      }
      
      public final double eCk()
      {
        AppMethodBeat.i(201147);
        double d = 1.0D / ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shf, -1L);
        AppMethodBeat.o(201147);
        return d;
      }
      
      public final long eCl()
      {
        return 0L;
      }
    });
    AppMethodBeat.o(201152);
  }
  
  private void Us(final int paramInt)
  {
    AppMethodBeat.i(201157);
    com.tencent.f.h.RTc.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201148);
        c.a locala = c.this.S(false, paramInt);
        Log.i("MicroMsg.MemoryWatchDog", "[dumpMemoryAsync] %s", new Object[] { locala });
        if (c.b(c.this)) {
          c.a(c.this, locala, paramInt);
        }
        AppMethodBeat.o(201148);
      }
    }, 2000L);
    AppMethodBeat.o(201157);
  }
  
  private void a(a parama, int paramInt)
  {
    AppMethodBeat.i(201170);
    Log.i("MicroMsg.MemoryWatchDog", "check triggerMemoryHook");
    if (!BuildInfo.IS_ARM64)
    {
      Log.i("MicroMsg.MemoryWatchDog", "not trigger on 32-bit devices");
      AppMethodBeat.o(201170);
      return;
    }
    if (!this.AXn)
    {
      if (((parama.AXv > 209715200L) || (parama.AXF > 1048576)) && (Build.VERSION.SDK_INT >= 26))
      {
        Log.i("MicroMsg.MemoryWatchDog", "trigger hook");
        parama = "<cmd><diagnostic><MemoryHook enable='1' source='auto' process='" + processCmd() + "' duration='24' hook='" + ".*com\\.tencent\\.mm.*\\.so$" + "' stack='1' min='0' max='0' force='1' enableExpt='0' sampling='1' mmap='0'/></diagnostic></cmd>";
        com.tencent.mm.plugin.performance.a.a.ASb.aJQ(parama);
        parama = new ArrayList();
        IDKey localIDKey1 = new IDKey(1571, 1, 1);
        IDKey localIDKey2 = new IDKey(1571, getWatchDogTriggerProcessKey(), 1);
        parama.add(localIDKey1);
        parama.add(localIDKey2);
        com.tencent.mm.plugin.report.service.h.CyF.b(parama, false);
        this.AXn = true;
      }
      AppMethodBeat.o(201170);
      return;
    }
    if ((parama.AXv > this.AXh) || (parama.AXF > this.AXi))
    {
      this.AXh = (parama.AXv + 104857600L);
      if (this.AXi >= 2097152L) {
        break label350;
      }
    }
    label350:
    for (this.AXi = (parama.AXF + 102400);; this.AXi = 9223372036854775807L)
    {
      Log.i("MicroMsg.MemoryWatchDog", "trigger report, next threshold : native %s pss %s, isFg=%s, fgSvs=%s, bgDur=%s", new Object[] { Long.valueOf(this.AXh), Long.valueOf(this.AXi), Boolean.valueOf(parama.cPB), Arrays.toString(parama.AXr.toArray()), Long.valueOf(parama.AXD) });
      if (paramInt != 3)
      {
        Log.i("MicroMsg.MemoryWatchDog", "not SOURCE_AUTO_CHECK, dumpForegroundService");
        i(parama);
      }
      ((com.tencent.mm.plugin.performance.diagnostic.b.b)com.tencent.mm.plugin.performance.a.a.ASb.aT(com.tencent.mm.plugin.performance.diagnostic.b.b.class)).a(parama);
      AppMethodBeat.o(201170);
      return;
    }
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
  
  private boolean axz()
  {
    AppMethodBeat.i(201161);
    long l = SystemClock.uptimeMillis();
    if (l - this.AXo > 2000L) {}
    for (boolean bool = true;; bool = false)
    {
      this.AXo = l;
      AppMethodBeat.o(201161);
      return bool;
    }
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(201159);
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
          break label62;
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
    label62:
    AppMethodBeat.o(201159);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(201159);
    return paramInputStream;
  }
  
  public static c eCH()
  {
    return AXa;
  }
  
  private a[] eCI()
  {
    AppMethodBeat.i(201155);
    Object localObject1 = this.aJf.getRunningAppProcesses();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < ((List)localObject1).size())
    {
      Object localObject2 = (ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i);
      String str = WeChatBrands.AppInfo.current().getPackageName();
      Log.d("MicroMsg.MemoryWatchDog", "pkg name is [%s]", new Object[] { str });
      if ((Process.myUid() != ((ActivityManager.RunningAppProcessInfo)localObject2).uid) || (TextUtils.isEmpty(((ActivityManager.RunningAppProcessInfo)localObject2).processName)) || (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.startsWith(str))) {
        Log.e("MicroMsg.MemoryWatchDog", "info with uid [%s] & process name [%s] is not current app [%s][%s]", new Object[] { Integer.valueOf(((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).uid), ((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).processName, Integer.valueOf(Process.myUid()), str });
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = new a();
        ((a)localObject2).pid = ((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).pid;
        ((a)localObject2).processName = ((ActivityManager.RunningAppProcessInfo)((List)localObject1).get(i)).processName;
        localArrayList.add(localObject2);
        Log.d("MicroMsg.MemoryWatchDog", "pid = %s, process = %s", new Object[] { Integer.valueOf(((a)localObject2).pid), ((a)localObject2).processName });
      }
    }
    localObject1 = new a[localArrayList.size()];
    localArrayList.toArray((Object[])localObject1);
    AppMethodBeat.o(201155);
    return localObject1;
  }
  
  static boolean eCK()
  {
    AppMethodBeat.i(201165);
    if ((MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      AppMethodBeat.o(201165);
      return true;
    }
    AppMethodBeat.o(201165);
    return false;
  }
  
  private boolean eCM()
  {
    AppMethodBeat.i(201167);
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sok, false))
    {
      AppMethodBeat.o(201167);
      return false;
    }
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (d.KyR) || (WeChatEnvironment.hasDebugger()) || (this.AXm))
    {
      AppMethodBeat.o(201167);
      return true;
    }
    AppMethodBeat.o(201167);
    return false;
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(201160);
    Object localObject1 = new o(paramString);
    paramString = null;
    try
    {
      localObject1 = s.ao((o)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      AppMethodBeat.o(201160);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(201160);
    }
  }
  
  private static String getVmSize()
  {
    AppMethodBeat.i(201158);
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
          AppMethodBeat.o(201158);
          return str;
        }
        i += 1;
      }
      Log.w("MicroMsg.MemoryWatchDog", "[getVmSize] Wrong!", new Object[] { localObject[12] });
      localObject = localObject[12];
      AppMethodBeat.o(201158);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(201158);
    }
    return "";
  }
  
  private static int getWatchDogTriggerProcessKey()
  {
    AppMethodBeat.i(201169);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(201169);
      return 30;
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(201169);
      return 31;
    }
    if ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsIsolatedProcess()))
    {
      AppMethodBeat.o(201169);
      return 32;
    }
    AppMethodBeat.o(201169);
    return -1;
  }
  
  private void i(a parama)
  {
    AppMethodBeat.i(201154);
    long l = System.currentTimeMillis();
    Iterator localIterator = this.aJf.getRunningServices(2147483647).iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)localIterator.next();
      if (localRunningServiceInfo.uid == Process.myUid())
      {
        Log.d("MicroMsg.MemoryWatchDog", "foreground %s, stared %s, lastActivityTime %s, activeSince %s, class %s", new Object[] { Boolean.valueOf(localRunningServiceInfo.foreground), Boolean.valueOf(localRunningServiceInfo.started), Long.valueOf(localRunningServiceInfo.lastActivityTime), Long.valueOf(localRunningServiceInfo.activeSince), localRunningServiceInfo.service.getClassName() });
        if (localRunningServiceInfo.foreground) {
          parama.AXr.add(localRunningServiceInfo.service.getClassName());
        }
      }
    }
    Log.d("MicroMsg.MemoryWatchDog", "getting running service info cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(201154);
  }
  
  private static String processCmd()
  {
    AppMethodBeat.i(201171);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(201171);
      return "mm";
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(201171);
      return "appbrand";
    }
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      AppMethodBeat.o(201171);
      return "tools";
    }
    AppMethodBeat.o(201171);
    return "all";
  }
  
  public final a S(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(201153);
    long l1 = System.currentTimeMillis();
    a locala = new a();
    if (this.activity != null) {
      locala.activity = this.activity;
    }
    locala.source = paramInt;
    locala.AXA = this.AXb;
    locala.AXB = this.AXc;
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      try
      {
        long l2 = System.currentTimeMillis();
        Object localObject1 = this.aJf.getProcessMemoryInfo(new int[] { Process.myPid() });
        Log.d("MicroMsg.MemoryWatchDog", "pidMemInfoArray size = " + localObject1.length);
        if ((localObject1 != null) && (localObject1.length == 1))
        {
          localObject1 = localObject1[0];
          locala.AXF = ((Debug.MemoryInfo)localObject1).getTotalPss();
          if (Build.VERSION.SDK_INT >= 23) {
            locala.map = ((Debug.MemoryInfo)localObject1).getMemoryStats();
          }
        }
        else
        {
          Log.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
          if (!MMApplicationContext.isMainProcess()) {
            continue;
          }
          l2 = System.currentTimeMillis();
          localObject1 = eCI();
          Debug.MemoryInfo[] arrayOfMemoryInfo = this.aJf.getProcessMemoryInfo(a((a[])localObject1));
          if (arrayOfMemoryInfo == null) {
            continue;
          }
          Log.d("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 size = %s, memoryInfos size = %s", new Object[] { Integer.valueOf(arrayOfMemoryInfo.length), Integer.valueOf(localObject1.length) });
          if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!WeChatEnvironment.isCoolassistEnv())) {
            break label1199;
          }
          Assert.assertEquals(localObject1.length, arrayOfMemoryInfo.length);
          break label1199;
          if (paramInt >= Math.min(arrayOfMemoryInfo.length, localObject1.length)) {
            continue;
          }
          Log.d("MicroMsg.MemoryWatchDog", "total pss = %d", new Object[] { Integer.valueOf(arrayOfMemoryInfo[paramInt].getTotalPss()) });
          localObject1[paramInt].AXF = arrayOfMemoryInfo[paramInt].getTotalPss();
          i += localObject1[paramInt].AXF;
          paramInt += 1;
          continue;
        }
        Log.d("MicroMsg.MemoryWatchDog", "API level < 23, reflect to get stat");
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
        Log.d("MicroMsg.MemoryWatchDog", "reflect stat: %s", new Object[] { locala.map });
        continue;
        Object localObject2;
        if (eCK()) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MemoryWatchDog", localException, "", new Object[0]);
        locala.hju = (System.currentTimeMillis() - l1);
        if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!paramBoolean) && (locala.hju > 30L) && (this.AXf))
        {
          this.AXd += 1;
          if (this.AXd > 10)
          {
            Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
            this.AXf = false;
          }
        }
        if (locala.AXE == null)
        {
          Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
          locala.AXE = new ActivityManager.MemoryInfo();
        }
        locala.cPB = this.cPB;
        locala.AXg = this.AXg;
        if (eCK()) {
          locala.AXt = this.AXe.isEmpty();
        }
        if ((eCK()) && (!locala.AXg))
        {
          locala.AXD = (System.currentTimeMillis() - this.AXk);
          AppMethodBeat.o(201153);
          return locala;
          locala.AXG = i;
          locala.AXH = localException;
          Log.d("MicroMsg.MemoryWatchDog", "getting process memory info costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
          i(locala);
          localObject2 = Pattern.compile("\\d+").matcher(getVmSize());
          if (((Matcher)localObject2).find()) {
            locala.AXq = Util.safeParseInt(((Matcher)localObject2).group());
          }
          locala.AXu = Debug.getNativeHeapSize();
          locala.AXv = Debug.getNativeHeapAllocatedSize();
          locala.AXw = Debug.getNativeHeapFreeSize();
          locala.AXx = Runtime.getRuntime().totalMemory();
          locala.AXy = Runtime.getRuntime().freeMemory();
          locala.AXz = Runtime.getRuntime().maxMemory();
          localObject2 = new ActivityManager.MemoryInfo();
          this.aJf.getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
          locala.AXE = ((ActivityManager.MemoryInfo)localObject2);
          locala.hju = (System.currentTimeMillis() - l1);
          if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!paramBoolean) && (locala.hju > 30L) && (this.AXf))
          {
            this.AXd += 1;
            if (this.AXd > 10)
            {
              Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
              this.AXf = false;
            }
          }
          if (locala.AXE != null) {
            continue;
          }
          Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
          locala.AXE = new ActivityManager.MemoryInfo();
          continue;
          Log.e("MicroMsg.MemoryWatchDog", "pidMemInfoArray2 == null");
          continue;
        }
      }
      finally
      {
        locala.hju = (System.currentTimeMillis() - l1);
        if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!paramBoolean) && (locala.hju > 30L) && (this.AXf))
        {
          this.AXd += 1;
          if (this.AXd > 10)
          {
            Log.w("MicroMsg.MemoryWatchDog", "adjust for printing async!");
            this.AXf = false;
          }
        }
        if (locala.AXE == null)
        {
          Log.e("MicroMsg.MemoryWatchDog", "Something wrong when dumping memory");
          locala.AXE = new ActivityManager.MemoryInfo();
        }
        AppMethodBeat.o(201153);
      }
      if (!locala.cPB)
      {
        locala.AXD = (System.currentTimeMillis() - this.AXj);
        continue;
        label1199:
        i = 0;
        paramInt = 0;
      }
    }
  }
  
  public final void cy(boolean paramBoolean)
  {
    AppMethodBeat.i(201162);
    Log.d("MicroMsg.MemoryWatchDog", "isAppForeground: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.cPB = paramBoolean;
    if (!paramBoolean)
    {
      this.AXj = System.currentTimeMillis();
      AppMethodBeat.o(201162);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.AXl > 300000L)
    {
      Log.i("MicroMsg.MemoryWatchDog", "onAppForeground: forward check");
      this.AXl = l;
      com.tencent.f.h.RTc.bqo("MicroMsg.MemoryWatchDog");
      com.tencent.f.h.RTc.a(this, 300000L, "MicroMsg.MemoryWatchDog");
    }
    AppMethodBeat.o(201162);
  }
  
  public final a eCJ()
  {
    AppMethodBeat.i(258590);
    a locala = S(true, 0);
    AppMethodBeat.o(258590);
    return locala;
  }
  
  public final void eCL()
  {
    boolean bool = true;
    AppMethodBeat.i(201166);
    a locala = S(true, 3);
    new StringBuilder("[AutoCheck] ").append(locala);
    Log.i("MicroMsg.MemoryWatchDog", "[AutoCheck] process = %s AppForeground = %s %s", new Object[] { MMApplicationContext.getProcessName(), Boolean.valueOf(this.cPB), locala });
    if (!this.AXe.isEmpty()) {}
    for (;;)
    {
      b.a(locala, bool);
      if (eCM()) {
        a(locala, 3);
      }
      AppMethodBeat.o(201166);
      return;
      bool = false;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(201172);
    if ((MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()))
    {
      paramActivity = paramActivity.toString() + ":" + paramActivity.hashCode();
      this.AXe.add(paramActivity);
      Log.i("MicroMsg.MemoryWatchDog", "onActivityCreated: %s, mActivities.size = %s", new Object[] { paramActivity, Integer.valueOf(this.AXe.size()) });
    }
    AppMethodBeat.o(201172);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(201173);
    if ((MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()))
    {
      paramActivity = paramActivity.toString() + ":" + paramActivity.hashCode();
      this.AXe.remove(paramActivity);
      Log.i("MicroMsg.MemoryWatchDog", "onActivityDestroyed: %s, mActivities.size = %s", new Object[] { paramActivity, Integer.valueOf(this.AXe.size()) });
    }
    AppMethodBeat.o(201173);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(201163);
    this.activity = paramActivity.getClass().getSimpleName();
    if (axz()) {
      Us(1);
    }
    AppMethodBeat.o(201163);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(201164);
    if (axz()) {
      Us(2);
    }
    AppMethodBeat.o(201164);
  }
  
  public final void run()
  {
    AppMethodBeat.i(201168);
    eCL();
    this.AXl = System.currentTimeMillis();
    i locali = com.tencent.f.h.RTc;
    if (this.cPB) {}
    for (long l = 300000L;; l = 1800000L)
    {
      locali.a(this, l, "MicroMsg.MemoryWatchDog");
      AppMethodBeat.o(201168);
      return;
    }
  }
  
  public static final class a
  {
    public long AXA;
    public long AXB;
    public long AXC;
    public long AXD;
    public ActivityManager.MemoryInfo AXE;
    public int AXF;
    public int AXG;
    public a[] AXH;
    public boolean AXg;
    public int AXq;
    public List<String> AXr;
    public boolean AXs;
    public boolean AXt;
    public long AXu;
    public long AXv;
    public long AXw;
    public long AXx;
    public long AXy;
    public long AXz;
    public String activity;
    public boolean cPB;
    public long hju;
    public Map<String, String> map;
    public int pid;
    public String processName;
    public int source;
    
    public a()
    {
      AppMethodBeat.i(201149);
      this.processName = "current";
      this.source = 0;
      this.activity = "default";
      this.AXr = new ArrayList();
      this.AXs = c.eCK();
      this.AXC = Thread.currentThread().getId();
      this.AXD = -1L;
      AppMethodBeat.o(201149);
    }
    
    private static String aE(Map<String, String> paramMap)
    {
      AppMethodBeat.i(201151);
      if (paramMap == null)
      {
        AppMethodBeat.o(201151);
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
      AppMethodBeat.o(201151);
      return paramMap;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201150);
      StringBuilder localStringBuilder1 = new StringBuilder(" \n");
      StringBuilder localStringBuilder2 = localStringBuilder1.append(String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> MemoryInfo(tid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { Long.valueOf(this.AXC) })).append("\n| Activity:\t").append(this.activity).append("\tAppForeground:").append(this.cPB).append("\tProcessForeground:").append(this.AXg);
      if (c.eCK())
      {
        localObject = "\thasActivity:";
        localStringBuilder2 = localStringBuilder2.append((String)localObject);
        if (!c.eCK()) {
          break label463;
        }
      }
      label463:
      for (Object localObject = Boolean.valueOf(this.AXt);; localObject = "")
      {
        localStringBuilder2.append(localObject).append("\n| Source:\t ").append(this.source).append("\n| VmSize:\t ").append(this.AXq).append("kB\n| SystemMemoryInfo:\t totalMem=").append(this.AXE.totalMem).append(", availMem=").append(this.AXE.availMem).append(", lowMemory=").append(this.AXE.lowMemory).append(", threshold=").append(this.AXE.threshold).append("\n| Dalvik:\t memClass=").append(this.AXA).append(", memLargeClass=").append(this.AXB).append(" B, TalMemory=").append(this.AXx).append(" B, FreeMemory=").append(this.AXy).append(" B, MaxMemory=").append(this.AXz).append(" B\n| NATIVE:\t HeapSize=").append(this.AXu).append(" B, AllocatedSize=").append(this.AXv).append(" B, FreeSize=").append(this.AXw).append(" B\n| Stats:\t pss-sum:").append(this.AXG).append(" KB, ").append(aE(this.map)).append("\n| FgService:\t").append(Arrays.toString(this.AXr.toArray())).append("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:").append(this.hju).append("ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        if (this.AXH == null) {
          break label469;
        }
        localObject = this.AXH;
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder2 = localObject[i];
          localStringBuilder1.append("| Process: ").append(localStringBuilder2.processName).append(", pid: ").append(localStringBuilder2.pid).append(", totalPss: ").append(localStringBuilder2.AXF).append("\n");
          i += 1;
        }
        localObject = "";
        break;
      }
      label469:
      localObject = localStringBuilder1.toString();
      AppMethodBeat.o(201150);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.c
 * JD-Core Version:    0.7.0.1
 */