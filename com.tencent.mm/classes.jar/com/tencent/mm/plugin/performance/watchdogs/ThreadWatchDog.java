package com.tencent.mm.plugin.performance.watchdogs;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.support.annotation.Keep;
import com.tencent.f.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.f.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.b.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Keep
public class ThreadWatchDog
  implements Application.ActivityLifecycleCallbacks
{
  private static final int HOOK_ID_KEY = 1571;
  public static final int HOOK_THRESHOLD = 20;
  private static final int LIMIT_THREAD_COUNT_150 = 150;
  private static final int LIMIT_THREAD_COUNT_200 = 200;
  private static final int LIMIT_THREAD_COUNT_300 = 300;
  private static final int OVER_300 = 2;
  private static final int OVER_500 = 1;
  private static final int OVER_500_WHITE_THREAD = 3;
  protected static final int REPORT_ID = 960;
  private static final int REPORT_KV_ID = 16470;
  private static final String TAG = "MicroMsg.ThreadWatchDog";
  private static volatile int TOP_THREAD_COUNT = 500;
  private boolean enableTriggerPthreadHook;
  private boolean isSensitiveMode;
  private volatile StringBuilder mContent;
  private volatile int mJavaThreadCount;
  private int mLastReportedThreadCount;
  private long mLastWangTime;
  private volatile int mProcessThreadCount;
  private volatile boolean mShouldPreventThrow;
  
  public ThreadWatchDog()
  {
    AppMethodBeat.i(201188);
    this.mProcessThreadCount = 0;
    this.mJavaThreadCount = 0;
    com.tencent.mm.plugin.performance.b.a.AUa.a(new a.a()
    {
      public final String Lb()
      {
        return "MicroMsg.ThreadWatchDog";
      }
      
      public final void eCj()
      {
        AppMethodBeat.i(201182);
        Log.i("MicroMsg.ThreadWatchDog", "enable trigger pthread hook");
        ThreadWatchDog.access$002(ThreadWatchDog.this, true);
        AppMethodBeat.o(201182);
      }
      
      public final double eCk()
      {
        AppMethodBeat.i(201183);
        double d = 1.0D / ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.she, -1);
        AppMethodBeat.o(201183);
        return d;
      }
      
      public final long eCl()
      {
        return 0L;
      }
    });
    this.isSensitiveMode = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.shl, false);
    AppMethodBeat.o(201188);
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(201199);
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
    AppMethodBeat.o(201199);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(201199);
    return paramInputStream;
  }
  
  private void dumpThreadCountAndReportAsync()
  {
    AppMethodBeat.i(201190);
    com.tencent.f.h.RTc.aY(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201184);
        long l = SystemClock.uptimeMillis();
        try
        {
          LinkedList localLinkedList = new LinkedList();
          ThreadWatchDog.access$102(ThreadWatchDog.this, ThreadWatchDog.getProcessThreadCount());
          ThreadWatchDog.access$202(ThreadWatchDog.this, ThreadWatchDog.getJavaThreads(localLinkedList));
          ThreadWatchDog.access$300(ThreadWatchDog.this);
          Log.w("MicroMsg.ThreadWatchDog", "[dumpAsync][%s:%s]:%s", new Object[] { Integer.valueOf(ThreadWatchDog.this.mJavaThreadCount), Integer.valueOf(ThreadWatchDog.this.mProcessThreadCount), localLinkedList.toString() });
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.ThreadWatchDog", localThrowable, "dump thread count failed", new Object[0]);
          return;
        }
        finally
        {
          Log.i("MicroMsg.ThreadWatchDog", "[dumpAsync] Cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
          AppMethodBeat.o(201184);
        }
      }
    });
    AppMethodBeat.o(201190);
  }
  
  private void enablePthreadHook(List<String> paramList)
  {
    AppMethodBeat.i(201194);
    if ((BuildInfo.IS_FLAVOR_RED) || (d.KyR) || (WeChatEnvironment.isCoolassistEnv()) || (WeChatEnvironment.hasDebugger()) || (this.enableTriggerPthreadHook)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ThreadWatchDog", "enable auto trigger? %s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(201194);
      return;
    }
    if (paramList.isEmpty())
    {
      Log.w("MicroMsg.ThreadWatchDog", "threadNames is empty, just return");
      AppMethodBeat.o(201194);
      return;
    }
    Object localObject2 = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = ((String)localIterator.next()).replace("[", "\\[").replace("]", "\\]").replace("?", ".*");
      paramList = (List<String>)localObject1;
      if (((String)localObject1).length() > 1)
      {
        paramList = (List<String>)localObject1;
        if (((String)localObject1).endsWith("J")) {
          paramList = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
      }
      ((StringBuilder)localObject2).append(paramList).append(";");
    }
    paramList = "<cmd><diagnostic><PthreadHook\n enable='1' process='" + processCmd() + "' duration='1' hook='.*\\.so$' thread='" + ((StringBuilder)localObject2).toString() + "'/></diagnostic></cmd>";
    com.tencent.mm.plugin.performance.a.a.ASb.aJQ(paramList);
    paramList = new ArrayList();
    Object localObject1 = new IDKey(1571, 11, 1);
    localObject2 = new IDKey(1571, getWatchDogTriggerProcessKey(), 1);
    paramList.add(localObject1);
    paramList.add(localObject2);
    com.tencent.mm.plugin.report.service.h.CyF.b(paramList, false);
    AppMethodBeat.o(201194);
  }
  
  public static int getJavaThreadCount()
  {
    AppMethodBeat.i(201201);
    ThreadGroup localThreadGroup = Looper.getMainLooper().getThread().getThreadGroup();
    int i = localThreadGroup.enumerate(new Thread[localThreadGroup.activeCount() * 2]);
    AppMethodBeat.o(201201);
    return i;
  }
  
  public static int getJavaThreads(List<ThreadWatchDog.a> paramList)
  {
    AppMethodBeat.i(201202);
    Object localObject2 = new HashMap();
    Object localObject1 = Looper.getMainLooper().getThread().getThreadGroup();
    Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject1).activeCount() * 2];
    int k = ((ThreadGroup)localObject1).enumerate(arrayOfThread);
    int j = 0;
    int i = 0;
    label142:
    if (j < k)
    {
      localObject1 = arrayOfThread[j].getName();
      if (Util.isNullOrNil((String)localObject1)) {
        break label268;
      }
      localObject1 = ((String)localObject1).replaceAll("[0-9]\\d*", "?");
      if (!((String)localObject1).contains("Binder:")) {
        break label265;
      }
      localObject1 = "Binder:?_?";
      label100:
      if (((Map)localObject2).containsKey(localObject1))
      {
        ((Map)localObject2).put(localObject1, Integer.valueOf(((Integer)((Map)localObject2).get(localObject1)).intValue() + 1));
        i += 1;
      }
    }
    label265:
    label268:
    for (;;)
    {
      j += 1;
      break;
      ((Map)localObject2).put(localObject1, Integer.valueOf(1));
      break label142;
      localObject1 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        paramList.add(new ThreadWatchDog.a((String)((Map.Entry)localObject2).getKey(), ((Integer)((Map.Entry)localObject2).getValue()).intValue()));
      }
      Collections.sort(paramList, new Comparator() {});
      AppMethodBeat.o(201202);
      return i;
      break label100;
    }
  }
  
  public static int getProcessThreadCount()
  {
    AppMethodBeat.i(201198);
    Object localObject1 = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      localObject1 = getStringFromFile((String)localObject1).trim().split("\n");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (((String)localObject2).startsWith("Threads"))
        {
          localObject2 = Pattern.compile("\\d+").matcher((CharSequence)localObject2);
          if (((Matcher)localObject2).find())
          {
            i = Util.safeParseInt(((Matcher)localObject2).group());
            AppMethodBeat.o(201198);
            return i;
          }
        }
        i += 1;
      }
      Log.w("MicroMsg.ThreadWatchDog", "[getProcessThreadCount] Wrong!", new Object[] { localObject1[24] });
      i = Util.safeParseInt(localObject1[24].trim());
      AppMethodBeat.o(201198);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(201198);
    }
    return 0;
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(201200);
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
      AppMethodBeat.o(201200);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(201200);
    }
  }
  
  private int getWatchDogTriggerProcessKey()
  {
    AppMethodBeat.i(201195);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(201195);
      return 60;
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(201195);
      return 61;
    }
    if ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsIsolatedProcess()))
    {
      AppMethodBeat.o(201195);
      return 62;
    }
    AppMethodBeat.o(201195);
    return -1;
  }
  
  private boolean isCheck()
  {
    AppMethodBeat.i(201197);
    if (SystemClock.uptimeMillis() - this.mLastWangTime >= 10000L)
    {
      this.mLastWangTime = SystemClock.uptimeMillis();
      AppMethodBeat.o(201197);
      return true;
    }
    AppMethodBeat.o(201197);
    return false;
  }
  
  public static boolean isSB()
  {
    AppMethodBeat.i(201203);
    if ((BuildInfo.IS_FLAVOR_PURPLE) && ((z.aTY().contains("caicy1662")) || (z.aTY().contains("foreverzeus")) || (z.aTY().contains("10618855"))))
    {
      AppMethodBeat.o(201203);
      return true;
    }
    AppMethodBeat.o(201203);
    return false;
  }
  
  private boolean onOverThread(int paramInt1, int paramInt2, int paramInt3, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(201193);
    long l = System.currentTimeMillis();
    boolean bool1 = false;
    Object localObject1 = com.tencent.matrix.f.a.To();
    a.d[] arrayOfd = new a.d[3];
    Object localObject2 = ((List)localObject1).iterator();
    int j = 0;
    for (;;)
    {
      boolean bool2 = bool1;
      int i = paramInt1;
      Object localObject3;
      String str2;
      e locale;
      String str3;
      label205:
      label224:
      label243:
      Object localObject4;
      label259:
      label278:
      label298:
      String str1;
      label314:
      Object localObject5;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (a.d)((Iterator)localObject2).next();
        arrayOfd[j] = localObject3;
        bool2 = bool1;
        i = paramInt1;
        if (1 == paramInt1)
        {
          if (!e.a.gi(((a.d)localObject3).name)) {
            break label517;
          }
          k = 1;
          bool2 = bool1;
          i = paramInt1;
          if (k != 0)
          {
            bool2 = true;
            i = 3;
          }
        }
        j += 1;
        if (j < 3) {
          break label699;
        }
      }
      else
      {
        str2 = localObject1.toString();
        Log.d("MicroMsg.ThreadWatchDog", "content %s", new Object[] { str2 });
        locale = e.Cxv;
        str3 = String.format("ThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), str2 });
        if (arrayOfd[0] == null) {
          break label523;
        }
        localObject1 = arrayOfd[0].name;
        if (arrayOfd[0] == null) {
          break label531;
        }
        localObject2 = Integer.valueOf(arrayOfd[0].getSize());
        if ((arrayOfd[0] == null) || (!arrayOfd[0].Tr())) {
          break label539;
        }
        paramInt1 = 1;
        if (arrayOfd[1] == null) {
          break label544;
        }
        localObject3 = arrayOfd[1].name;
        if (arrayOfd[1] == null) {
          break label552;
        }
        localObject4 = Integer.valueOf(arrayOfd[1].getSize());
        if ((arrayOfd[1] == null) || (!arrayOfd[1].Tr())) {
          break label560;
        }
        j = 1;
        if (arrayOfd[2] == null) {
          break label566;
        }
        str1 = arrayOfd[2].name;
        if (arrayOfd[2] == null) {
          break label574;
        }
        localObject5 = Integer.valueOf(arrayOfd[2].getSize());
        label333:
        if ((arrayOfd[2] == null) || (!arrayOfd[2].Tr())) {
          break label582;
        }
      }
      label517:
      label523:
      label531:
      label539:
      label544:
      label552:
      label560:
      label566:
      label574:
      label582:
      for (int k = 1;; k = 0)
      {
        locale.a(16470, new Object[] { str3, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), localObject1, localObject2, Integer.valueOf(paramInt1), localObject3, localObject4, Integer.valueOf(j), str1, localObject5, Integer.valueOf(k), MMApplicationContext.getProcessName() });
        localObject1 = new ArrayList();
        paramInt1 = 0;
        while (paramInt1 < 3)
        {
          if ((arrayOfd[paramInt1] != null) && (arrayOfd[paramInt1].getSize() > 20)) {
            ((List)localObject1).add(arrayOfd[paramInt1].name);
          }
          paramInt1 += 1;
        }
        k = 0;
        break;
        localObject1 = "null";
        break label205;
        localObject2 = "0";
        break label224;
        paramInt1 = 0;
        break label243;
        localObject3 = "null";
        break label259;
        localObject4 = "0";
        break label278;
        j = 0;
        break label298;
        str1 = "null";
        break label314;
        localObject5 = "0";
        break label333;
      }
      if ((1 == i) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()) || (d.KyR) || (d.KyP) || (this.isSensitiveMode)) {
        ((com.tencent.mm.plugin.performance.diagnostic.c.b)com.tencent.mm.plugin.performance.a.a.ASb.aT(com.tencent.mm.plugin.performance.diagnostic.c.b.class)).hd(false);
      }
      enablePthreadHook((List)localObject1);
      Log.i("MicroMsg.ThreadWatchDog", "onOverThread: dump costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if (paramStringBuilder != null) {
        paramStringBuilder.append(str2);
      }
      AppMethodBeat.o(201193);
      return bool2;
      label699:
      bool1 = bool2;
      paramInt1 = i;
    }
  }
  
  private final String processCmd()
  {
    AppMethodBeat.i(201196);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(201196);
      return "mm";
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(201196);
      return "appbrand";
    }
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      AppMethodBeat.o(201196);
      return "tools";
    }
    AppMethodBeat.o(201196);
    return "all";
  }
  
  private void report()
  {
    AppMethodBeat.i(201192);
    long l = SystemClock.uptimeMillis();
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 100;
    }
    for (;;)
    {
      if (i == -1)
      {
        AppMethodBeat.o(201192);
        return;
        if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
        {
          i = 120;
          continue;
        }
        if (MMApplicationContext.isAppBrandProcess()) {
          i = 140;
        }
      }
      else
      {
        for (;;)
        {
          try
          {
            if (this.mProcessThreadCount > TOP_THREAD_COUNT)
            {
              this.mContent = new StringBuilder();
              Log.i("MicroMsg.ThreadWatchDog", "trigger Over 500");
              this.mShouldPreventThrow = onOverThread(1, this.mJavaThreadCount, this.mProcessThreadCount, this.mContent);
              e.Cxv.idkeyStat(960L, i + 1, 1L, true);
              if (this.mJavaThreadCount <= TOP_THREAD_COUNT) {
                break label356;
              }
              e.Cxv.idkeyStat(960L, i + 4, 1L, true);
              return;
            }
            if (this.mProcessThreadCount > 300)
            {
              e.Cxv.idkeyStat(960L, i, 1L, true);
              if (this.mProcessThreadCount - this.mLastReportedThreadCount < 50) {
                continue;
              }
              this.mLastReportedThreadCount = this.mProcessThreadCount;
              com.tencent.f.h.RTc.aY(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(201185);
                  Log.i("MicroMsg.ThreadWatchDog", "trigger Over 300");
                  ThreadWatchDog.access$400(ThreadWatchDog.this, 2, ThreadWatchDog.this.mJavaThreadCount, ThreadWatchDog.this.mProcessThreadCount, null);
                  AppMethodBeat.o(201185);
                }
              });
              continue;
            }
            if (this.mProcessThreadCount <= 200) {
              break label309;
            }
          }
          finally
          {
            Log.i("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
            AppMethodBeat.o(201192);
          }
          e.Cxv.idkeyStat(960L, i + 2, 1L, true);
          continue;
          label309:
          if (this.mProcessThreadCount > 150)
          {
            e.Cxv.idkeyStat(960L, i + 3, 1L, true);
          }
          else
          {
            e.Cxv.idkeyStat(960L, i + 8, 1L, true);
            continue;
            label356:
            if (this.mJavaThreadCount > 300) {
              e.Cxv.idkeyStat(960L, i + 5, 1L, true);
            } else if (this.mJavaThreadCount > 200) {
              e.Cxv.idkeyStat(960L, i + 6, 1L, true);
            } else if (this.mJavaThreadCount > 150) {
              e.Cxv.idkeyStat(960L, i + 7, 1L, true);
            } else {
              e.Cxv.idkeyStat(960L, i + 9, 1L, true);
            }
          }
        }
      }
      i = -1;
    }
  }
  
  private void wang()
  {
    AppMethodBeat.i(201191);
    if (this.mProcessThreadCount > TOP_THREAD_COUNT)
    {
      if (this.mShouldPreventThrow)
      {
        Log.i("MicroMsg.ThreadWatchDog", "prevent throw Exception");
        TOP_THREAD_COUNT += 1024;
        AppMethodBeat.o(201191);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("MicroMsg.ThreadWatchDog");
      int i = this.mJavaThreadCount;
      int j = this.mProcessThreadCount;
      if (this.mContent == null) {}
      for (Object localObject = "null";; localObject = this.mContent.toString())
      {
        localObject = new RuntimeException(String.format("\nThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject }));
        AppMethodBeat.o(201191);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(201191);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(201189);
    if (isCheck())
    {
      wang();
      dumpThreadCountAndReportAsync();
    }
    AppMethodBeat.o(201189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog
 * JD-Core Version:    0.7.0.1
 */