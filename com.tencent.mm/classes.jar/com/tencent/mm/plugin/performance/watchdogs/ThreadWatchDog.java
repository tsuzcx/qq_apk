package com.tencent.mm.plugin.performance.watchdogs;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.tracer.SignalAnrTracer;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.performance.diagnostic.c.b;
import com.tencent.mm.plugin.performance.dice.a.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.concurrent.ConcurrentSkipListSet;

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
  private static final int OVER_INC_50 = 4;
  protected static final int REPORT_ID = 960;
  private static final int REPORT_KV_ID = 16470;
  private static final String TAG = "MicroMsg.ThreadWatchDog";
  private static volatile int TOP_THREAD_COUNT = 500;
  private boolean enableTriggerPthreadHook;
  private boolean isSensitiveMode;
  private volatile StringBuilder mContent;
  private volatile int mJavaThreadCount;
  private volatile int mLastJavaThreadCount;
  private volatile int mLastProcessThreadCount;
  private int mLastReportedThreadCount;
  private long mLastWangTime;
  private volatile int mProcessThreadCount;
  private final Collection<String> mScenes;
  private volatile boolean mShouldPreventThrow;
  
  public ThreadWatchDog()
  {
    AppMethodBeat.i(301008);
    this.mProcessThreadCount = 0;
    this.mJavaThreadCount = 0;
    this.mLastProcessThreadCount = 0;
    this.mLastJavaThreadCount = 0;
    this.mScenes = new ConcurrentSkipListSet();
    com.tencent.mm.plugin.performance.dice.a.MKN.a(new a.a()
    {
      public final void action(double paramAnonymousDouble)
      {
        AppMethodBeat.i(301057);
        Log.i("MicroMsg.ThreadWatchDog", "enable trigger pthread hook");
        ThreadWatchDog.access$002(ThreadWatchDog.this, true);
        AppMethodBeat.o(301057);
      }
      
      public final long cycleMinutes()
      {
        return 0L;
      }
      
      public final String key()
      {
        return "MicroMsg.ThreadWatchDog";
      }
      
      public final double rate()
      {
        AppMethodBeat.i(301073);
        double d = 1.0D / ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjL, 5);
        AppMethodBeat.o(301073);
        return d;
      }
    });
    this.isSensitiveMode = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zjS, false);
    AppMethodBeat.o(301008);
  }
  
  private void dumpThreadCountAndReportAsync(String paramString)
  {
    AppMethodBeat.i(301012);
    com.tencent.threadpool.h.ahAA.bn(new j()
    {
      public final String getKey()
      {
        return "MicroMsg.ThreadWatchDog";
      }
      
      public final boolean isLogging()
      {
        return false;
      }
      
      public final void run()
      {
        AppMethodBeat.i(301079);
        long l1 = SystemClock.uptimeMillis();
        try
        {
          ThreadWatchDog.access$102(ThreadWatchDog.this, ThreadWatchDog.this.mProcessThreadCount);
          ThreadWatchDog.access$302(ThreadWatchDog.this, ThreadWatchDog.this.mJavaThreadCount);
          ThreadWatchDog.access$202(ThreadWatchDog.this, f.gzF());
          Collection localCollection = f.gzE();
          Object localObject1 = localCollection.iterator();
          for (int i = 0; ((Iterator)localObject1).hasNext(); i = ((f.c)((Iterator)localObject1).next()).getSize() + i) {}
          ThreadWatchDog.access$402(ThreadWatchDog.this, i);
          Object localObject3 = ThreadWatchDog.access$500(ThreadWatchDog.this);
          localObject1 = localObject3;
          if (BuildInfo.DEBUG)
          {
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = Arrays.toString(f.gzG().toArray());
            }
          }
          long l2 = SystemClock.uptimeMillis();
          i = ThreadWatchDog.this.mJavaThreadCount;
          int j = ThreadWatchDog.this.mProcessThreadCount;
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = localCollection.toString();
          }
          Log.w("MicroMsg.ThreadWatchDog", "[dumpAsync][Cost:%s][%s:%s]:%s", new Object[] { Long.valueOf(l2 - l1), Integer.valueOf(i), Integer.valueOf(j), localObject3 });
          ThreadWatchDog.this.mScenes.clear();
          AppMethodBeat.o(301079);
          return;
        }
        finally
        {
          try
          {
            Log.printErrStackTrace("MicroMsg.ThreadWatchDog", localThrowable, "dump thread count failed", new Object[0]);
            return;
          }
          finally
          {
            ThreadWatchDog.this.mScenes.clear();
            AppMethodBeat.o(301079);
          }
        }
      }
    });
    AppMethodBeat.o(301012);
  }
  
  private void enablePthreadHook(List<String> paramList)
  {
    AppMethodBeat.i(301049);
    if ((BuildInfo.IS_FLAVOR_RED) || (d.Yxk) || (WeChatEnvironment.isCoolassistEnv()) || (WeChatEnvironment.hasDebugger()) || (this.enableTriggerPthreadHook)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ThreadWatchDog", "enable auto trigger? %s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(301049);
      return;
    }
    if (paramList.isEmpty())
    {
      Log.w("MicroMsg.ThreadWatchDog", "threadNames is empty, just return");
      AppMethodBeat.o(301049);
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
    com.tencent.mm.plugin.performance.a.a.MIk.aRq(paramList);
    paramList = new ArrayList();
    Object localObject1 = new IDKey(1571, 11, 1);
    localObject2 = new IDKey(1571, getWatchDogTriggerProcessKey(), 1);
    paramList.add(localObject1);
    paramList.add(localObject2);
    com.tencent.mm.plugin.report.service.h.OAn.b(paramList, false);
    AppMethodBeat.o(301049);
  }
  
  private int getWatchDogTriggerProcessKey()
  {
    AppMethodBeat.i(301056);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(301056);
      return 60;
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(301056);
      return 61;
    }
    if ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsIsolatedProcess()))
    {
      AppMethodBeat.o(301056);
      return 62;
    }
    AppMethodBeat.o(301056);
    return -1;
  }
  
  private boolean isCheck()
  {
    AppMethodBeat.i(301069);
    if (SystemClock.uptimeMillis() - this.mLastWangTime >= 10000L)
    {
      this.mLastWangTime = SystemClock.uptimeMillis();
      AppMethodBeat.o(301069);
      return true;
    }
    AppMethodBeat.o(301069);
    return false;
  }
  
  private void onOverInc()
  {
    AppMethodBeat.i(301041);
    if (this.mContent == null) {
      this.mContent = new StringBuilder(f.gzG().toString());
    }
    String str1 = String.format("ThreadInc[%s:%s->%s:%s]: %s", new Object[] { Integer.valueOf(this.mLastJavaThreadCount), Integer.valueOf(this.mLastProcessThreadCount), Integer.valueOf(this.mJavaThreadCount), Integer.valueOf(this.mProcessThreadCount), this.mContent.toString() });
    String str2 = com.tencent.mm.plugin.performance.c.v(this.mScenes.toArray());
    Log.i("MicroMsg.ThreadWatchDog", "ThreadInc[%s:%s->%s:%s] passedScenes:%s", new Object[] { Integer.valueOf(this.mLastJavaThreadCount), Integer.valueOf(this.mLastProcessThreadCount), Integer.valueOf(this.mJavaThreadCount), Integer.valueOf(this.mProcessThreadCount), str2 });
    com.tencent.mm.plugin.report.f.Ozc.b(16470, new Object[] { str1, Integer.valueOf(4), Integer.valueOf(this.mJavaThreadCount), Integer.valueOf(this.mProcessThreadCount), "", "", "", "", "", "", "", "", "", MMApplicationContext.getProcessName(), str2 });
    AppMethodBeat.o(301041);
  }
  
  private boolean onOverThread(int paramInt1, int paramInt2, int paramInt3, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(301033);
    boolean bool1 = false;
    Object localObject1 = f.gzG();
    f.c[] arrayOfc = new f.c[3];
    Object localObject2 = ((List)localObject1).iterator();
    int k = 0;
    for (;;)
    {
      boolean bool2 = bool1;
      int i = paramInt1;
      Object localObject3;
      int j;
      String str2;
      String str3;
      label160:
      com.tencent.mm.plugin.report.f localf;
      String str4;
      label243:
      Object localObject4;
      label262:
      label281:
      label297:
      label316:
      label336:
      String str1;
      label352:
      Object localObject5;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (f.c)((Iterator)localObject2).next();
        arrayOfc[k] = localObject3;
        bool2 = bool1;
        i = paramInt1;
        if (1 == paramInt1)
        {
          localObject3 = ((f.c)localObject3).name;
          if (!g.a.is((String)localObject3)) {
            break label561;
          }
          j = 1;
          bool2 = bool1;
          i = paramInt1;
          if (j != 0)
          {
            bool2 = true;
            i = 3;
          }
        }
        k += 1;
        if (k < 3) {
          break label741;
        }
      }
      else
      {
        str2 = localObject1.toString();
        str3 = com.tencent.mm.plugin.performance.c.v(this.mScenes.toArray());
        if (i != 2) {
          break label581;
        }
        localObject1 = "300";
        Log.i("MicroMsg.ThreadWatchDog", "trigger Over %s: passed scenes: %s", new Object[] { localObject1, str3 });
        if (i == 1) {
          SignalAnrTracer.azZ();
        }
        localf = com.tencent.mm.plugin.report.f.Ozc;
        str4 = String.format("ThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), str2 });
        if (arrayOfc[0] == null) {
          break label589;
        }
        localObject1 = arrayOfc[0].name;
        if (arrayOfc[0] == null) {
          break label597;
        }
        localObject2 = Integer.valueOf(arrayOfc[0].getSize());
        if ((arrayOfc[0] == null) || (!arrayOfc[0].gzJ())) {
          break label605;
        }
        paramInt1 = 1;
        if (arrayOfc[1] == null) {
          break label610;
        }
        localObject3 = arrayOfc[1].name;
        if (arrayOfc[1] == null) {
          break label618;
        }
        localObject4 = Integer.valueOf(arrayOfc[1].getSize());
        if ((arrayOfc[1] == null) || (!arrayOfc[1].gzJ())) {
          break label626;
        }
        j = 1;
        if (arrayOfc[2] == null) {
          break label632;
        }
        str1 = arrayOfc[2].name;
        if (arrayOfc[2] == null) {
          break label640;
        }
        localObject5 = Integer.valueOf(arrayOfc[2].getSize());
        label371:
        if ((arrayOfc[2] == null) || (!arrayOfc[2].gzJ())) {
          break label648;
        }
      }
      label640:
      label648:
      for (k = 1;; k = 0)
      {
        localf.b(16470, new Object[] { str4, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), localObject1, localObject2, Integer.valueOf(paramInt1), localObject3, localObject4, Integer.valueOf(j), str1, localObject5, Integer.valueOf(k), MMApplicationContext.getProcessName(), str3 });
        localObject1 = new ArrayList();
        paramInt1 = 0;
        while (paramInt1 < 3)
        {
          if ((arrayOfc[paramInt1] != null) && (arrayOfc[paramInt1].getSize() > 20)) {
            ((List)localObject1).add(arrayOfc[paramInt1].name);
          }
          paramInt1 += 1;
        }
        label561:
        if (g.b.Vk((String)localObject3))
        {
          j = 1;
          break;
        }
        j = 0;
        break;
        label581:
        localObject1 = "500";
        break label160;
        label589:
        localObject1 = "null";
        break label243;
        label597:
        localObject2 = "0";
        break label262;
        label605:
        paramInt1 = 0;
        break label281;
        label610:
        localObject3 = "null";
        break label297;
        label618:
        localObject4 = "0";
        break label316;
        label626:
        j = 0;
        break label336;
        label632:
        str1 = "null";
        break label352;
        localObject5 = "0";
        break label371;
      }
      if ((1 == i) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()) || (d.Yxk) || (d.Yxi) || (this.isSensitiveMode)) {
        ((b)com.tencent.mm.plugin.performance.a.a.MIk.bX(b.class)).iT(false);
      }
      enablePthreadHook((List)localObject1);
      if (paramStringBuilder != null) {
        paramStringBuilder.append(str2);
      }
      AppMethodBeat.o(301033);
      return bool2;
      label741:
      bool1 = bool2;
      paramInt1 = i;
    }
  }
  
  private final String processCmd()
  {
    AppMethodBeat.i(301061);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(301061);
      return "mm";
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(301061);
      return "appbrand";
    }
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      AppMethodBeat.o(301061);
      return "tools";
    }
    AppMethodBeat.o(301061);
    return "all";
  }
  
  private String report()
  {
    AppMethodBeat.i(301021);
    int i = -1;
    if (MMApplicationContext.isMainProcess()) {
      i = 100;
    }
    while (i == -1)
    {
      AppMethodBeat.o(301021);
      return null;
      if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess())) {
        i = 120;
      } else if (MMApplicationContext.isAppBrandProcess()) {
        i = 140;
      }
    }
    this.mContent = null;
    for (;;)
    {
      try
      {
        if (this.mProcessThreadCount > TOP_THREAD_COUNT)
        {
          this.mContent = new StringBuilder();
          this.mShouldPreventThrow = onOverThread(1, this.mJavaThreadCount, this.mProcessThreadCount, this.mContent);
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(960L, i + 1, 1L, true);
          if (this.mJavaThreadCount > TOP_THREAD_COUNT)
          {
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(960L, i + 4, 1L, true);
            com.tencent.mm.plugin.expt.b.c localc = (com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class);
            c.a locala = c.a.zjT;
            if (BuildInfo.DEBUG) {
              break label513;
            }
            if (!WeChatEnvironment.hasDebugger()) {
              continue;
            }
            break label513;
            i = localc.a(locala, i);
            if ((this.mLastProcessThreadCount >= 200) && (this.mProcessThreadCount - this.mLastProcessThreadCount >= i)) {
              onOverInc();
            }
            if (this.mContent != null) {
              continue;
            }
            AppMethodBeat.o(301021);
            return null;
          }
        }
        else if (this.mProcessThreadCount > 300)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(960L, i, 1L, true);
          if (this.mProcessThreadCount - this.mLastReportedThreadCount < 50) {
            continue;
          }
          this.mLastReportedThreadCount = this.mProcessThreadCount;
          onOverThread(2, this.mJavaThreadCount, this.mProcessThreadCount, this.mContent);
          continue;
        }
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.ThreadWatchDog", localThrowable, "", new Object[0]);
        continue;
        if (this.mProcessThreadCount > 200)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(960L, i + 2, 1L, true);
          continue;
        }
        if (this.mProcessThreadCount > 150)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(960L, i + 3, 1L, true);
          continue;
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(960L, i + 8, 1L, true);
        continue;
        if (this.mJavaThreadCount > 300)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(960L, i + 5, 1L, true);
          continue;
        }
        if (this.mJavaThreadCount > 200)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(960L, i + 6, 1L, true);
          continue;
        }
        if (this.mJavaThreadCount > 150)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(960L, i + 7, 1L, true);
          continue;
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(960L, i + 9, 1L, true);
        continue;
        i = 2147483647;
        continue;
        String str = this.mContent.toString();
        AppMethodBeat.o(301021);
        return str;
      }
      label513:
      i = 30;
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(301110);
    paramActivity = paramActivity.getClass().getSimpleName();
    this.mScenes.add(paramActivity);
    if (isCheck())
    {
      wang();
      dumpThreadCountAndReportAsync(paramActivity);
    }
    AppMethodBeat.o(301110);
  }
  
  public void wang()
  {
    AppMethodBeat.i(301116);
    if (this.mProcessThreadCount > TOP_THREAD_COUNT)
    {
      if (this.mShouldPreventThrow)
      {
        Log.i("MicroMsg.ThreadWatchDog", "prevent throw Exception");
        TOP_THREAD_COUNT += 1024;
        AppMethodBeat.o(301116);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("MicroMsg.ThreadWatchDog");
      int i = this.mJavaThreadCount;
      int j = this.mProcessThreadCount;
      if (this.mContent == null) {}
      for (Object localObject = "null";; localObject = this.mContent.toString())
      {
        localObject = new RuntimeException(String.format("\nThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject }));
        AppMethodBeat.o(301116);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(301116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog
 * JD-Core Version:    0.7.0.1
 */