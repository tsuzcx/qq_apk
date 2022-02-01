package com.tencent.mm.plugin.performance.watchdogs;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Keep;
import com.tencent.e.i;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.b.a.a;
import com.tencent.mm.plugin.performance.diagnostic.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;

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
    AppMethodBeat.i(201851);
    this.mProcessThreadCount = 0;
    this.mJavaThreadCount = 0;
    com.tencent.mm.plugin.performance.b.a.GNv.a(new a.a()
    {
      public final void action(double paramAnonymousDouble)
      {
        AppMethodBeat.i(201320);
        Log.i("MicroMsg.ThreadWatchDog", "enable trigger pthread hook");
        ThreadWatchDog.access$002(ThreadWatchDog.this, true);
        AppMethodBeat.o(201320);
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
        AppMethodBeat.i(201321);
        double d = 1.0D / ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRc, 5);
        AppMethodBeat.o(201321);
        return d;
      }
    });
    this.isSensitiveMode = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRj, false);
    AppMethodBeat.o(201851);
  }
  
  private void dumpThreadCountAndReportAsync()
  {
    AppMethodBeat.i(201858);
    com.tencent.e.h.ZvG.bf(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201199);
        long l = SystemClock.uptimeMillis();
        for (;;)
        {
          int i;
          try
          {
            ThreadWatchDog.access$102(ThreadWatchDog.this, e.foE());
            HashMap localHashMap = new HashMap();
            Object localObject1 = Looper.getMainLooper().getThread().getThreadGroup();
            Object localObject3;
            if (localObject1 == null)
            {
              Log.e("MicroMsg.ThreadInfoReader", "getJavaThreads failed");
              localObject1 = localHashMap.values();
              localObject3 = ((Collection)localObject1).iterator();
              i = 0;
              if (((Iterator)localObject3).hasNext())
              {
                i = ((e.b)((Iterator)localObject3).next()).getSize() + i;
                continue;
              }
            }
            else
            {
              Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject1).activeCount() * 2];
              int j = ((ThreadGroup)localObject1).enumerate(arrayOfThread);
              i = 0;
              if (i < j)
              {
                localObject3 = arrayOfThread[i];
                localObject1 = ((Thread)localObject3).getName();
                if (Util.isNullOrNil((String)localObject1)) {
                  break label493;
                }
                localObject1 = ((String)localObject1).replaceAll("[0-9]\\d*", "?");
                if (!((String)localObject1).contains("Binder:")) {
                  break label490;
                }
                localObject1 = "Binder:?_?";
                e.c localc = new e.c();
                localc.name = ((String)localObject1);
                localc.tid = ((Thread)localObject3).getId();
                e.b localb = (e.b)localHashMap.get(localObject1);
                localObject3 = localb;
                if (localb == null)
                {
                  localObject3 = new e.b((String)localObject1);
                  localHashMap.put(localObject1, localObject3);
                }
                ((e.b)localObject3).list.add(localc);
                break label493;
              }
              localObject1 = new LinkedList(localHashMap.values());
              Collections.sort((List)localObject1, new e.1());
              continue;
            }
            ThreadWatchDog.access$202(ThreadWatchDog.this, i);
            Log.d("MicroMsg.ThreadWatchDog", "[dumpAsync] group size = %s, %s", new Object[] { Integer.valueOf(ThreadWatchDog.this.mJavaThreadCount), Integer.valueOf(e.foD()) });
            ThreadWatchDog.access$300(ThreadWatchDog.this);
            Log.w("MicroMsg.ThreadWatchDog", "[dumpAsync][%s:%s]:%s", new Object[] { Integer.valueOf(ThreadWatchDog.this.mJavaThreadCount), Integer.valueOf(ThreadWatchDog.this.mProcessThreadCount), localObject1.toString() });
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
            AppMethodBeat.o(201199);
          }
          label490:
          continue;
          label493:
          i += 1;
        }
      }
    });
    AppMethodBeat.o(201858);
  }
  
  private void enablePthreadHook(List<String> paramList)
  {
    AppMethodBeat.i(201904);
    if ((BuildInfo.IS_FLAVOR_RED) || (d.RAG) || (WeChatEnvironment.isCoolassistEnv()) || (WeChatEnvironment.hasDebugger()) || (this.enableTriggerPthreadHook)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ThreadWatchDog", "enable auto trigger? %s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(201904);
      return;
    }
    if (paramList.isEmpty())
    {
      Log.w("MicroMsg.ThreadWatchDog", "threadNames is empty, just return");
      AppMethodBeat.o(201904);
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
    com.tencent.mm.plugin.performance.a.a.GLp.aUm(paramList);
    paramList = new ArrayList();
    Object localObject1 = new IDKey(1571, 11, 1);
    localObject2 = new IDKey(1571, getWatchDogTriggerProcessKey(), 1);
    paramList.add(localObject1);
    paramList.add(localObject2);
    com.tencent.mm.plugin.report.service.h.IzE.b(paramList, false);
    AppMethodBeat.o(201904);
  }
  
  private int getWatchDogTriggerProcessKey()
  {
    AppMethodBeat.i(201909);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(201909);
      return 60;
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(201909);
      return 61;
    }
    if ((MMApplicationContext.isToolsMpProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsIsolatedProcess()))
    {
      AppMethodBeat.o(201909);
      return 62;
    }
    AppMethodBeat.o(201909);
    return -1;
  }
  
  private boolean isCheck()
  {
    AppMethodBeat.i(201914);
    if (SystemClock.uptimeMillis() - this.mLastWangTime >= 10000L)
    {
      this.mLastWangTime = SystemClock.uptimeMillis();
      AppMethodBeat.o(201914);
      return true;
    }
    AppMethodBeat.o(201914);
    return false;
  }
  
  private boolean onOverThread(int paramInt1, int paramInt2, int paramInt3, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(201892);
    long l = System.currentTimeMillis();
    boolean bool1 = false;
    Object localObject1 = e.foF();
    e.b[] arrayOfb = new e.b[3];
    Object localObject2 = ((List)localObject1).iterator();
    int j = 0;
    for (;;)
    {
      boolean bool2 = bool1;
      int i = paramInt1;
      Object localObject3;
      String str2;
      f localf;
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
        localObject3 = (e.b)((Iterator)localObject2).next();
        arrayOfb[j] = localObject3;
        bool2 = bool1;
        i = paramInt1;
        if (1 == paramInt1)
        {
          if (!f.a.gS(((e.b)localObject3).name)) {
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
        localf = f.Iyx;
        str3 = String.format("ThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), str2 });
        if (arrayOfb[0] == null) {
          break label523;
        }
        localObject1 = arrayOfb[0].name;
        if (arrayOfb[0] == null) {
          break label531;
        }
        localObject2 = Integer.valueOf(arrayOfb[0].getSize());
        if ((arrayOfb[0] == null) || (!arrayOfb[0].foG())) {
          break label539;
        }
        paramInt1 = 1;
        if (arrayOfb[1] == null) {
          break label544;
        }
        localObject3 = arrayOfb[1].name;
        if (arrayOfb[1] == null) {
          break label552;
        }
        localObject4 = Integer.valueOf(arrayOfb[1].getSize());
        if ((arrayOfb[1] == null) || (!arrayOfb[1].foG())) {
          break label560;
        }
        j = 1;
        if (arrayOfb[2] == null) {
          break label566;
        }
        str1 = arrayOfb[2].name;
        if (arrayOfb[2] == null) {
          break label574;
        }
        localObject5 = Integer.valueOf(arrayOfb[2].getSize());
        label333:
        if ((arrayOfb[2] == null) || (!arrayOfb[2].foG())) {
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
        localf.a(16470, new Object[] { str3, Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), localObject1, localObject2, Integer.valueOf(paramInt1), localObject3, localObject4, Integer.valueOf(j), str1, localObject5, Integer.valueOf(k), MMApplicationContext.getProcessName() });
        localObject1 = new ArrayList();
        paramInt1 = 0;
        while (paramInt1 < 3)
        {
          if ((arrayOfb[paramInt1] != null) && (arrayOfb[paramInt1].getSize() > 20)) {
            ((List)localObject1).add(arrayOfb[paramInt1].name);
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
      if ((1 == i) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()) || (d.RAG) || (d.RAE) || (this.isSensitiveMode)) {
        ((com.tencent.mm.plugin.performance.diagnostic.c.b)com.tencent.mm.plugin.performance.a.a.GLp.bn(com.tencent.mm.plugin.performance.diagnostic.c.b.class)).hU(false);
      }
      enablePthreadHook((List)localObject1);
      Log.i("MicroMsg.ThreadWatchDog", "onOverThread: dump costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if (paramStringBuilder != null) {
        paramStringBuilder.append(str2);
      }
      AppMethodBeat.o(201892);
      return bool2;
      label699:
      bool1 = bool2;
      paramInt1 = i;
    }
  }
  
  private final String processCmd()
  {
    AppMethodBeat.i(201911);
    if (MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(201911);
      return "mm";
    }
    if (MMApplicationContext.isAppBrandProcess())
    {
      AppMethodBeat.o(201911);
      return "appbrand";
    }
    if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
    {
      AppMethodBeat.o(201911);
      return "tools";
    }
    AppMethodBeat.o(201911);
    return "all";
  }
  
  private void report()
  {
    AppMethodBeat.i(201883);
    long l = SystemClock.uptimeMillis();
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 100;
    }
    for (;;)
    {
      if (i == -1)
      {
        AppMethodBeat.o(201883);
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
              f.Iyx.idkeyStat(960L, i + 1, 1L, true);
              if (this.mJavaThreadCount <= TOP_THREAD_COUNT) {
                break label356;
              }
              f.Iyx.idkeyStat(960L, i + 4, 1L, true);
              return;
            }
            if (this.mProcessThreadCount > 300)
            {
              f.Iyx.idkeyStat(960L, i, 1L, true);
              if (this.mProcessThreadCount - this.mLastReportedThreadCount < 50) {
                continue;
              }
              this.mLastReportedThreadCount = this.mProcessThreadCount;
              com.tencent.e.h.ZvG.bf(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(200792);
                  Log.i("MicroMsg.ThreadWatchDog", "trigger Over 300");
                  ThreadWatchDog.access$400(ThreadWatchDog.this, 2, ThreadWatchDog.this.mJavaThreadCount, ThreadWatchDog.this.mProcessThreadCount, null);
                  AppMethodBeat.o(200792);
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
            AppMethodBeat.o(201883);
          }
          f.Iyx.idkeyStat(960L, i + 2, 1L, true);
          continue;
          label309:
          if (this.mProcessThreadCount > 150)
          {
            f.Iyx.idkeyStat(960L, i + 3, 1L, true);
          }
          else
          {
            f.Iyx.idkeyStat(960L, i + 8, 1L, true);
            continue;
            label356:
            if (this.mJavaThreadCount > 300) {
              f.Iyx.idkeyStat(960L, i + 5, 1L, true);
            } else if (this.mJavaThreadCount > 200) {
              f.Iyx.idkeyStat(960L, i + 6, 1L, true);
            } else if (this.mJavaThreadCount > 150) {
              f.Iyx.idkeyStat(960L, i + 7, 1L, true);
            } else {
              f.Iyx.idkeyStat(960L, i + 9, 1L, true);
            }
          }
        }
      }
      i = -1;
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
    AppMethodBeat.i(201856);
    if (isCheck())
    {
      wang();
      dumpThreadCountAndReportAsync();
    }
    AppMethodBeat.o(201856);
  }
  
  public void wang()
  {
    AppMethodBeat.i(201864);
    if (this.mProcessThreadCount > TOP_THREAD_COUNT)
    {
      if (this.mShouldPreventThrow)
      {
        Log.i("MicroMsg.ThreadWatchDog", "prevent throw Exception");
        TOP_THREAD_COUNT += 1024;
        AppMethodBeat.o(201864);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("MicroMsg.ThreadWatchDog");
      int i = this.mJavaThreadCount;
      int j = this.mProcessThreadCount;
      if (this.mContent == null) {}
      for (Object localObject = "null";; localObject = this.mContent.toString())
      {
        localObject = new RuntimeException(String.format("\nThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject }));
        AppMethodBeat.o(201864);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(201864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog
 * JD-Core Version:    0.7.0.1
 */