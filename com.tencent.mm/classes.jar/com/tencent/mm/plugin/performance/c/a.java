package com.tencent.mm.plugin.performance.c;

import android.os.Environment;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Printer;
import com.tencent.e.d.e;
import com.tencent.e.d.f;
import com.tencent.e.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import d.a.j;
import d.g.b.w;
import d.l;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver$IOnScreenshotTakenListener;", "Lcom/tencent/mm/app/IPhoneScreenListener;", "()V", "aboutUITimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "batteryRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$BatteryRecord;", "blowoutCount", "", "checkQueue", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "existThreadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "isNeedReport", "", "lastCheckTime", "", "looperPrepareMonitor", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1;", "mainLooperListener", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1;", "maxBlowoutCount", "methodInfoMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "otherTaskCount", "Ljava/util/concurrent/atomic/AtomicLong;", "otherThreadTime", "otherTime", "runCallback", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1;", "runnableMethodInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "runningCount", "screenShotObserver", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver;", "screenShotObserver2", "screenShotPath", "screenShotPath2", "taskPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1;", "threadPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1;", "timeRecord", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "uiBusyConcurrent", "", "uiTaskCount", "uiThreadTime", "uiTime", "checkExpiredTask", "", "dumpThreadPool", "dumpUIAbout", "getStackTrace", "thread", "Ljava/lang/Thread;", "onAppBackground", "activity", "onAppForeground", "onScreen", "isScreenOff", "onScreenshotTaken", "path", "open", "isProcessMain", "reportStatistics", "BatteryRecord", "CheckInfo", "Companion", "ReportType", "TimeRecord", "plugin-performance_release"})
public final class a
  implements com.tencent.mm.app.n, o, u.a
{
  public static boolean cuo;
  private static final d.f vCP;
  public static final c vCQ;
  private long lastCheckTime;
  private final HashMap<String, List<Pair<String, String>>> qjJ;
  private AtomicLong vCA;
  private AtomicLong vCB;
  private AtomicLong vCC;
  private int[] vCD;
  public final n vCE;
  public final i vCF;
  public final m vCG;
  private final ArrayList<Pair<String, String>> vCH;
  private final String vCI;
  private final String vCJ;
  private final com.tencent.mm.pluginsdk.model.u vCK;
  private final com.tencent.mm.pluginsdk.model.u vCL;
  private final j vCM;
  public final au vCN;
  private final l vCO;
  private final AtomicInteger vCp;
  private final AtomicInteger vCq;
  private final ConcurrentHashMap<String, a.b> vCr;
  private final boolean vCs;
  private final ConcurrentHashMap<String, a.a> vCt;
  private final ConcurrentHashMap<String, a.f> vCu;
  private volatile int vCv;
  private int vCw;
  private AtomicLong vCx;
  private AtomicLong vCy;
  private AtomicLong vCz;
  
  static
  {
    AppMethodBeat.i(184684);
    vCQ = new c((byte)0);
    vCP = d.g.K((d.g.a.a)a.d.vCS);
    AppMethodBeat.o(184684);
  }
  
  public a()
  {
    AppMethodBeat.i(184683);
    this.vCp = new AtomicInteger();
    this.vCq = new AtomicInteger();
    this.vCr = new ConcurrentHashMap();
    int i;
    int j;
    if ((com.tencent.mm.protocal.d.DId) || (com.tencent.mm.protocal.d.DIe))
    {
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOj, 10);
      j = new Random().nextInt(100000);
      if (i < j) {
        break label579;
      }
    }
    label579:
    for (boolean bool = true;; bool = false)
    {
      ac.i("ThreadPool.Profiler", "[isNeedReport] rand=" + i + " test=" + j + " isEnable=" + bool + " isRelease=" + com.tencent.mm.protocal.d.DId + " isTest=" + com.tencent.mm.protocal.d.DIe);
      this.vCs = bool;
      this.vCt = new ConcurrentHashMap(100);
      this.vCu = new ConcurrentHashMap(100);
      this.vCx = new AtomicLong();
      this.vCy = new AtomicLong();
      this.vCz = new AtomicLong();
      this.vCA = new AtomicLong();
      this.vCB = new AtomicLong();
      this.vCC = new AtomicLong();
      this.vCD = new int[2];
      this.vCE = new n(this);
      this.vCF = new i(this);
      this.vCG = new m(this);
      this.qjJ = new HashMap();
      this.vCH = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder();
      File localFile = Environment.getExternalStorageDirectory();
      d.g.b.k.g(localFile, "Environment.getExternalStorageDirectory()");
      this.vCI = (localFile.getPath() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator);
      localStringBuilder = new StringBuilder();
      localFile = Environment.getExternalStorageDirectory();
      d.g.b.k.g(localFile, "Environment.getExternalStorageDirectory()");
      this.vCJ = (localFile.getPath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Screenshots" + File.separator);
      this.vCK = new com.tencent.mm.pluginsdk.model.u(this.vCI, (u.a)this);
      this.vCL = new com.tencent.mm.pluginsdk.model.u(this.vCJ, (u.a)this);
      this.vCM = new j(this);
      this.vCN = new au(com.tencent.e.j.a.aTF("ThreadPool.Profiler"), (au.a)new g(this), true);
      this.vCO = new l(this);
      AppMethodBeat.o(184683);
      return;
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOk, 100000);
      break;
    }
  }
  
  private final void dox()
  {
    AppMethodBeat.i(184681);
    StringBuilder localStringBuilder = new StringBuilder(" \n[RunningTask]\n");
    Object localObject1 = com.tencent.e.h.JZO.fEb();
    d.g.b.k.g(localObject1, "ThreadPool.PROFILE.dumpRunningTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    Object localObject3;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = localStringBuilder.append("\t").append((String)((Map.Entry)localObject3).getKey()).append(" => ");
      localObject3 = ((Map.Entry)localObject3).getValue();
      d.g.b.k.g(localObject3, "it.value");
      ((StringBuilder)localObject2).append(((Number)localObject3).intValue()).append("\n");
    }
    ac.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    d.g.b.k.g(localStringBuilder, "sb");
    d.n.n.h(localStringBuilder);
    localStringBuilder.append(" \n[WaitingTask]\n");
    localObject1 = com.tencent.e.h.JZO.fEc();
    d.g.b.k.g(localObject1, "ThreadPool.PROFILE.dumpWaitingTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localStringBuilder.append("# ").append((String)((Map.Entry)localObject2).getKey()).append("\n");
      localObject2 = ((Map.Entry)localObject2).getValue();
      d.g.b.k.g(localObject2, "entry.value");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Pair)((Iterator)localObject2).next();
        localObject3 = localStringBuilder.append("\t|* ").append((String)((Pair)localObject4).first).append(" => ");
        localObject4 = ((Pair)localObject4).second;
        d.g.b.k.g(localObject4, "it.second");
        ((StringBuilder)localObject3).append(((Number)localObject4).intValue()).append("\n");
      }
    }
    ac.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    ac.i("ThreadPool.Profiler", "[dumpThreadPool] Alive Thread Count = " + this.vCq.get() + " Global Running Count = " + this.vCp.get() + " maxRunningCount=" + this.vCv);
    doy();
    AppMethodBeat.o(184681);
  }
  
  private final void doy()
  {
    AppMethodBeat.i(184682);
    ac.i("ThreadPool.Profiler", "[dumpThreadPool]\n averageUITime=" + (float)this.vCA.get() * 1.0F / (float)this.vCC.get() + " averageUIThreadTime=" + (float)this.vCB.get() * 1.0F / (float)this.vCC.get() + '\n' + "averageOtherTime=" + (float)this.vCx.get() * 1.0F / (float)this.vCz.get() + " averageOtherThreadTime=" + (float)this.vCy.get() * 1.0F / (float)this.vCz.get() + '\n' + "uiTaskCount=" + this.vCC.get() + " otherTaskCount=" + this.vCz.get() + '\n' + "uiBusyConcurrent=" + this.vCD[1] + " averageUIConcurrent=" + this.vCD[0] * 1.0F / this.vCD[1] + " concurrentRadio=" + this.vCD[1] * 1.0F / (float)this.vCC.get());
    AppMethodBeat.o(184682);
  }
  
  public final void cb(boolean paramBoolean)
  {
    AppMethodBeat.i(184677);
    long l;
    LinkedList localLinkedList;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int i;
    label176:
    Object localObject4;
    Object localObject5;
    if (!paramBoolean)
    {
      l = SystemClock.uptimeMillis();
      if ((l - this.lastCheckTime >= 900000L) && (this.vCs))
      {
        localLinkedList = new LinkedList();
        localObject2 = (Map)this.vCr;
        localObject1 = (Map)new LinkedHashMap();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if ((SystemClock.uptimeMillis() - ((a.b)((Map.Entry)localObject3).getValue()).time >= 60000L) && (((a.b)((Map.Entry)localObject3).getValue()).type == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label176;
            }
            ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
            break;
          }
        }
        localObject4 = ((Map)localObject1).entrySet().iterator();
        i = 0;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          localObject1 = ((Map.Entry)localObject5).getKey();
          if (d.n.n.a((CharSequence)localObject1, '@', 0, 6) >= 0)
          {
            i = 1;
            label246:
            if (i == 0) {
              break label643;
            }
            label250:
            localObject1 = (String)localObject1;
            if (localObject1 != null)
            {
              localObject1 = ((String)localObject1).subSequence(0, d.n.n.a((CharSequence)localObject1, '@', 0, 6));
              if (localObject1 != null) {
                break label1366;
              }
            }
            localObject1 = (CharSequence)((Map.Entry)localObject5).getKey();
          }
        }
      }
    }
    label333:
    label337:
    label1366:
    for (;;)
    {
      localObject2 = ((Map.Entry)localObject5).getKey();
      if (d.n.n.a((CharSequence)localObject2, '#', 0, 6) >= 0)
      {
        i = 1;
        if (i == 0) {
          break label654;
        }
        localObject2 = (String)localObject2;
        if (localObject2 != null)
        {
          localObject3 = ((String)localObject2).subSequence(0, d.n.n.a((CharSequence)localObject2, '#', 0, 6));
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = (CharSequence)((Map.Entry)localObject5).getKey();
        }
        localObject2 = com.tencent.e.j.a.aTG(localObject2.toString());
        if (localObject2 == null) {
          break label660;
        }
        localObject2 = ((com.tencent.e.j.a)localObject2).fEE();
        StringBuilder localStringBuilder = new StringBuilder().append((String)((Map.Entry)localObject5).getKey()).append(" has expired ").append(SystemClock.uptimeMillis() - ((a.b)((Map.Entry)localObject5).getValue()).time).append("ms size=");
        if (localObject2 == null) {
          break label666;
        }
        localObject3 = Integer.valueOf(((com.tencent.e.j.d)localObject2).size());
        label485:
        localObject3 = localStringBuilder.append(localObject3).append(" queue is null=");
        if (localObject2 != null) {
          break label672;
        }
        paramBoolean = true;
        label507:
        localStringBuilder = ((StringBuilder)localObject3).append(paramBoolean).append(" isRunning=");
        if (localObject2 == null) {
          break label677;
        }
        localObject3 = Boolean.valueOf(((com.tencent.e.j.d)localObject2).isRunning());
        localObject3 = localObject3;
        ac.e("ThreadPool.Profiler", (String)localObject3);
        if (localObject2 != null) {
          break label683;
        }
        i = 0;
      }
      for (;;)
      {
        e.wTc.f(18762, new Object[] { Integer.valueOf(e.vCT.value), localObject3, localObject1, Integer.valueOf(17), ai.getProcessName(), Integer.valueOf(i) });
        localLinkedList.add(((Map.Entry)localObject5).getKey());
        i = 1;
        break;
        i = 0;
        break label246;
        localObject1 = null;
        break label250;
        i = 0;
        break label333;
        localObject2 = null;
        break label337;
        localObject2 = null;
        break label416;
        localObject3 = null;
        break label485;
        paramBoolean = false;
        break label507;
        localObject3 = null;
        break label536;
        if (((com.tencent.e.j.d)localObject2).isRunning()) {
          i = 2;
        } else {
          i = 1;
        }
      }
      localObject1 = com.tencent.e.b.JZl;
      d.g.b.k.g(localObject1, "ForkThreadPoolExecutor.sGlobalForkThreadPool");
      localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (com.tencent.e.b)((WeakReference)((Iterator)localObject3).next()).get();
        if (localObject5 != null)
        {
          localObject4 = ((com.tencent.e.b)localObject5).getName();
          int j = (int)((com.tencent.e.b)localObject5).getCompletedTaskCount();
          int k = ((com.tencent.e.b)localObject5).getQueue().size();
          localObject2 = (a.b)this.vCr.get(localObject4);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new a.b(SystemClock.uptimeMillis(), 1);
            localObject2 = (Map)this.vCr;
            d.g.b.k.g(localObject4, "key");
            ((Map)localObject2).put(localObject4, localObject1);
          }
          d.g.b.k.g(localObject1, "checkQueue[key] ?: run {…eckInfo\n                }");
          int m = ((a.b)localObject1).count;
          if ((j > 0) && (k > 0) && (j - m == 0) && (SystemClock.uptimeMillis() - ((a.b)localObject1).time >= 60000L))
          {
            localObject2 = "[ForkThreadPoolExecutor] " + (String)localObject4 + " has expired " + (SystemClock.uptimeMillis() - ((a.b)localObject1).time) + "ms " + localObject5;
            ac.e("ThreadPool.Profiler", (String)localObject2);
            e.wTc.f(18762, new Object[] { Integer.valueOf(e.vCT.value), localObject2, localObject4, Integer.valueOf(17), ai.getProcessName() });
            localLinkedList.add(localObject4);
            i = 1;
          }
          for (;;)
          {
            ((a.b)localObject1).count = j;
            break;
            ((a.b)localObject1).time = SystemClock.uptimeMillis();
          }
        }
      }
      if (i != 0) {
        dox();
      }
      localObject1 = ((Iterable)localLinkedList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.vCr.remove(localObject2);
      }
      try
      {
        if (this.vCt.values().size() > 1)
        {
          localObject1 = this.vCt.values();
          d.g.b.k.g(localObject1, "batteryRecord.values");
          localObject1 = (Iterable)j.a((Iterable)localObject1, (Comparator)new a.h()).subList(0, d.k.h.lb(30, this.vCt.values().size() - 1));
          i = 0;
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              j.fOc();
            }
            localObject2 = (a.a)localObject2;
            ac.i("ThreadPool.Profiler", "[batteryRecord]#" + i + ' ' + localObject2);
            e.wTc.f(18883, new Object[] { Integer.valueOf(17), Integer.valueOf(e.vDh.value), Long.valueOf(((a.a)localObject2).vCR), ai.getProcessName(), ((a.a)localObject2).name, Integer.valueOf(((a.a)localObject2).count) });
            i += 1;
          }
          this.vCt.clear();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("ThreadPool.Profiler", (Throwable)localException, "", new Object[0]);
        }
      }
      this.lastCheckTime = l;
      AppMethodBeat.o(184677);
      return;
    }
  }
  
  public final void dow()
  {
    AppMethodBeat.i(184680);
    if (!cuo)
    {
      AppMethodBeat.o(184680);
      return;
    }
    com.tencent.mm.ac.b localb = new com.tencent.mm.ac.b("ThreadPool.Profiler#onScreenshotTaken");
    dox();
    localb.aic();
    AppMethodBeat.o(184680);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(184679);
    if (!cuo)
    {
      AppMethodBeat.o(184679);
      return;
    }
    this.vCK.stopWatching();
    this.vCL.stopWatching();
    AppMethodBeat.o(184679);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(184678);
    if (!cuo)
    {
      AppMethodBeat.o(184678);
      return;
    }
    this.vCK.startWatching();
    this.vCL.startWatching();
    AppMethodBeat.o(184678);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$Companion;", "", "()V", "CHECK_EXPIRED_TIME", "", "CHECK_TIMEOUT_TIME", "DELAY_REPORT", "", "EXPIRED_TIME", "KV_NORMAL_ID", "KV_STATISTICS_ID", "LOOP_PRINT", "TAG", "", "TAG_EXECUTE", "TOP_OF_BLOWOUT_COUNT", "getTOP_OF_BLOWOUT_COUNT", "()I", "TOP_OF_BLOWOUT_COUNT$delegate", "Lkotlin/Lazy;", "VERSION", "isDebug", "", "plugin-performance_release"})
  public static final class c
  {
    static
    {
      AppMethodBeat.i(184655);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(c.class), "TOP_OF_BLOWOUT_COUNT", "getTOP_OF_BLOWOUT_COUNT()I")) };
      AppMethodBeat.o(184655);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$ReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_EXPIRED", "TYPE_CONTROL", "TYPE_REJECT", "TYPE_TIMEOUT", "TYPE_STATISTICS_COUNT_BLOWOUT", "TYPE_STATISTICS_UI_TIME", "TYPE_STATISTICS_UI_THREAD_TIME", "TYPE_STATISTICS_UI_TIME_RADIO", "TYPE_STATISTICS_OTHER_TIME", "TYPE_STATISTICS_OTHER_THREAD_TIME", "TYPE_STATISTICS_OTHER_TIME_RADIO", "TYPE_STATISTICS_THREAD_COUNT", "TYPE_STATISTICS_UI_OTHER_AVERAGE", "TYPE_STATISTICS_MAX_COUNT_BLOWOUT", "TYPE_STATISTICS_TASK_THREAD_TIME", "TYPE_LOOPER_PREPARE", "plugin-performance_release"})
  public static enum e
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(184657);
      e locale1 = new e("TYPE_EXPIRED", 0, 1);
      vCT = locale1;
      e locale2 = new e("TYPE_CONTROL", 1, 2);
      vCU = locale2;
      e locale3 = new e("TYPE_REJECT", 2, 3);
      vCV = locale3;
      e locale4 = new e("TYPE_TIMEOUT", 3, 4);
      vCW = locale4;
      e locale5 = new e("TYPE_STATISTICS_COUNT_BLOWOUT", 4, 5);
      vCX = locale5;
      e locale6 = new e("TYPE_STATISTICS_UI_TIME", 5, 6);
      vCY = locale6;
      e locale7 = new e("TYPE_STATISTICS_UI_THREAD_TIME", 6, 7);
      vCZ = locale7;
      e locale8 = new e("TYPE_STATISTICS_UI_TIME_RADIO", 7, 8);
      vDa = locale8;
      e locale9 = new e("TYPE_STATISTICS_OTHER_TIME", 8, 9);
      vDb = locale9;
      e locale10 = new e("TYPE_STATISTICS_OTHER_THREAD_TIME", 9, 10);
      vDc = locale10;
      e locale11 = new e("TYPE_STATISTICS_OTHER_TIME_RADIO", 10, 11);
      vDd = locale11;
      e locale12 = new e("TYPE_STATISTICS_THREAD_COUNT", 11, 12);
      vDe = locale12;
      e locale13 = new e("TYPE_STATISTICS_UI_OTHER_AVERAGE", 12, 13);
      vDf = locale13;
      e locale14 = new e("TYPE_STATISTICS_MAX_COUNT_BLOWOUT", 13, 14);
      vDg = locale14;
      e locale15 = new e("TYPE_STATISTICS_TASK_THREAD_TIME", 14, 15);
      vDh = locale15;
      e locale16 = new e("TYPE_LOOPER_PREPARE", 15, 16);
      vDi = locale16;
      vDj = new e[] { locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8, locale9, locale10, locale11, locale12, locale13, locale14, locale15, locale16 };
      AppMethodBeat.o(184657);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class g
    implements au.a
  {
    g(a parama) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(184662);
      a.k(this.vDl);
      AppMethodBeat.o(184662);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/threadpool/ThreadModuleBoot$ILooperPrepareMonitor;", "isResetLooper", "", "()Z", "reportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "isHookResetLooper", "isOpenCheck", "isThrowException", "onLooperPreparedAtTask", "", "thread", "Ljava/lang/Thread;", "task", "plugin-performance_release"})
  public static final class i
    implements g.b
  {
    private final boolean vDm;
    private final ConcurrentHashMap<String, String> vDn;
    
    i()
    {
      AppMethodBeat.i(206497);
      boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOl, true);
      ac.w("ThreadPool.Profiler", "[isHookResetLooper] ".concat(String.valueOf(bool)));
      this.vDm = bool;
      this.vDn = new ConcurrentHashMap();
      AppMethodBeat.o(206497);
    }
    
    public final void a(Thread paramThread, String paramString)
    {
      AppMethodBeat.i(206496);
      d.g.b.k.h(paramThread, "thread");
      d.g.b.k.h(paramString, "task");
      if (a.c(this.vDl))
      {
        Object localObject = (CharSequence)paramString;
        localObject = new d.n.k("[0-9]\\d*").d((CharSequence)localObject, "?");
        if (!this.vDn.contains(localObject))
        {
          String str = "task=" + (String)localObject + ' ' + paramThread;
          ac.w("ThreadPool.Profiler", "[onLooperPreparedAtTask] ".concat(String.valueOf(str)));
          e.wTc.f(18762, new Object[] { Integer.valueOf(a.e.vDi.value), str, paramString, Integer.valueOf(17), ai.getProcessName() });
          ((Map)this.vDn).put(localObject, String.valueOf(paramThread));
        }
      }
      AppMethodBeat.o(206496);
    }
    
    public final boolean doB()
    {
      return true;
    }
    
    public final boolean doC()
    {
      return this.vDm;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Landroid/util/Printer;", "record", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "getRecord", "()Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "setRecord", "(Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;)V", "onDispatchEnd", "", "x", "", "onDispatchStart", "println", "plugin-performance_release"})
  public static final class j
    implements Printer
  {
    private a.f vDo;
    
    j()
    {
      AppMethodBeat.i(184664);
      this.vDo = new a.f(true, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte)0);
      AppMethodBeat.o(184664);
    }
    
    public final void println(String paramString)
    {
      AppMethodBeat.i(184663);
      d.g.b.k.h(paramString, "x");
      if (paramString.charAt(0) == '>')
      {
        d.g.b.k.h(paramString, "x");
        this.vDo.time = SystemClock.uptimeMillis();
        this.vDo.vCR = SystemClock.currentThreadTimeMillis();
        int i = a.f(this.vDl).get();
        if (i > 0)
        {
          paramString = a.g(this.vDl);
          paramString[0] = (i + paramString[0]);
          paramString = a.g(this.vDl);
          paramString[1] += 1;
        }
        AppMethodBeat.o(184663);
        return;
      }
      if (paramString.charAt(0) == '<')
      {
        d.g.b.k.h(paramString, "x");
        paramString = this.vDo;
        long l1 = SystemClock.uptimeMillis();
        long l2 = paramString.time;
        long l3 = SystemClock.currentThreadTimeMillis();
        long l4 = paramString.vCR;
        a.h(this.vDl).addAndGet(l1 - l2);
        a.i(this.vDl).addAndGet(l3 - l4);
        a.j(this.vDl).incrementAndGet();
      }
      AppMethodBeat.o(184663);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$open$1", "Ljava/lang/Runnable;", "run", "", "plugin-performance_release"})
  public static final class k
    implements Runnable
  {
    public k(ao paramao) {}
    
    public final void run()
    {
      AppMethodBeat.i(184665);
      a.a(this.vDl);
      this.vDp.postDelayed((Runnable)this, 1800000L);
      AppMethodBeat.o(184665);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mainThreadId", "", "getMainThreadId", "()J", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-performance_release"})
  public static final class l
    implements com.tencent.mm.hellhoundlib.a.c
  {
    private final long vDq;
    
    l()
    {
      AppMethodBeat.i(184668);
      Object localObject = Looper.getMainLooper();
      d.g.b.k.g(localObject, "Looper.getMainLooper()");
      localObject = ((Looper)localObject).getThread();
      d.g.b.k.g(localObject, "Looper.getMainLooper().thread");
      this.vDq = ((Thread)localObject).getId();
      AppMethodBeat.o(184668);
    }
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184666);
      d.g.b.k.h(paramString1, "className");
      int i = a.f(this.vDl).incrementAndGet();
      if (i > a.l(this.vDl)) {
        a.a(this.vDl, i);
      }
      paramString2 = a.vCQ;
      if (i > a.c.doA())
      {
        paramString2 = this.vDl;
        a.b(paramString2, a.m(paramString2) + 1);
      }
      long l = this.vDq;
      paramString2 = Thread.currentThread();
      d.g.b.k.g(paramString2, "Thread.currentThread()");
      if (l != paramString2.getId())
      {
        paramString2 = (Map)a.n(this.vDl);
        paramString1 = new StringBuilder().append(paramString1);
        if (paramObject == null) {
          break label169;
        }
      }
      label169:
      for (i = paramObject.hashCode();; i = 0)
      {
        paramString2.put(i, new a.f(false, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte)0));
        AppMethodBeat.o(184666);
        return;
      }
    }
    
    public final void f(String paramString, Object paramObject)
    {
      AppMethodBeat.i(184667);
      d.g.b.k.h(paramString, "className");
      a.f(this.vDl).decrementAndGet();
      long l1 = this.vDq;
      Object localObject = Thread.currentThread();
      d.g.b.k.g(localObject, "Thread.currentThread()");
      if (l1 != ((Thread)localObject).getId())
      {
        localObject = a.n(this.vDl);
        paramString = new StringBuilder().append(paramString);
        if (paramObject != null) {}
        for (int i = paramObject.hashCode();; i = 0)
        {
          paramString = (a.f)((ConcurrentHashMap)localObject).remove(i);
          if (paramString == null) {
            break;
          }
          l1 = SystemClock.uptimeMillis();
          long l2 = paramString.time;
          long l3 = SystemClock.currentThreadTimeMillis();
          long l4 = paramString.vCR;
          a.o(this.vDl).addAndGet(l3 - l4);
          a.p(this.vDl).addAndGet(l1 - l2);
          a.q(this.vDl).incrementAndGet();
          AppMethodBeat.o(184667);
          return;
        }
      }
      AppMethodBeat.o(184667);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/threadpool/Printer$TaskPrinter;", "error", "", "key", "", "hash", "", "e", "", "print", "state", "Lcom/tencent/threadpool/State;", "time", "", "costThreadMs", "pool", "isLogging", "", "rejected", "isShutdown", "shutdown", "wait", "runningCount", "waitFor", "plugin-performance_release"})
  public static final class m
    implements d.e
  {
    public final void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
    {
      AppMethodBeat.i(184671);
      d.g.b.k.h(paramString1, "key");
      d.g.b.k.h(paramString2, "pool");
      paramString2 = "[wait] " + paramString1 + '@' + paramInt1 + " runningCount=" + paramInt2 + " waitFor=" + paramLong / 100000L + "ms " + paramString2;
      ac.w("ThreadPool.Profiler", paramString2);
      String str = ai.getProcessName();
      e.wTc.f(18762, new Object[] { Integer.valueOf(a.e.vCU.value), paramString2, paramString1, Integer.valueOf(17), str });
      AppMethodBeat.o(184671);
    }
    
    public final void a(String paramString1, int paramInt, com.tencent.e.f paramf, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(185183);
      d.g.b.k.h(paramString1, "key");
      d.g.b.k.h(paramf, "state");
      d.g.b.k.h(paramString2, "pool");
      int i;
      Object localObject;
      if ((a.c(this.vDl)) && (paramf == com.tencent.e.f.JZK))
      {
        if (d.n.n.a((CharSequence)paramString1, '@', 0, 6) < 0) {
          break label227;
        }
        i = 1;
        if (i == 0) {
          break label233;
        }
        localObject = paramString1;
        label67:
        if (localObject != null)
        {
          localObject = ((String)localObject).subSequence(0, d.n.n.a((CharSequence)localObject, '@', 0, 6)).toString();
          if (localObject != null) {
            break label905;
          }
        }
        localObject = paramString1;
      }
      label905:
      for (;;)
      {
        a.a locala2 = (a.a)a.d(this.vDl).get(localObject);
        a.a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a.a((String)localObject);
          ((Map)a.d(this.vDl)).put(localObject, locala1);
        }
        d.g.b.k.g(locala1, "batteryRecord[keyRecord]… record\n                }");
        locala1.count += 1;
        if (locala1.count % 2 == 1) {
          locala1.vCR += 1L;
        }
        locala1.vCR += paramLong2;
        if (!paramBoolean)
        {
          AppMethodBeat.o(185183);
          return;
          label227:
          i = 0;
          break;
          label233:
          localObject = null;
          break label67;
        }
        switch (b.cfA[paramf.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(185183);
          return;
          if (paramLong1 < 0L) {}
          for (paramLong1 = 0L;; paramLong1 /= 1000000L)
          {
            if (a.c(this.vDl)) {
              ((Map)a.e(this.vDl)).put(paramString1 + '@' + paramInt, new a.b(SystemClock.uptimeMillis() + paramLong1));
            }
            ac.i("ThreadPool.Execute", "=== " + paramString1 + '@' + paramInt + " state=" + paramf + " delay=" + paramLong1 + "ms");
            AppMethodBeat.o(185183);
            return;
          }
          if (a.c(this.vDl))
          {
            localObject = (a.b)a.e(this.vDl).get(paramString1 + '@' + paramInt);
            if (localObject != null) {
              ((a.b)localObject).thread = Thread.currentThread();
            }
            a.e(this.vDl).remove(paramString1 + '@' + paramInt);
          }
          ac.i("ThreadPool.Execute", ">>> " + paramString1 + '@' + paramInt + " state=" + paramf + ' ' + paramString2);
          AppMethodBeat.o(185183);
          return;
          paramf = "<<< " + paramString1 + '@' + paramInt + " state=" + paramf + " cost=" + paramLong1 + "ms/" + paramLong2 + "ms " + paramString2;
          ac.i("ThreadPool.Execute", paramf);
          if ((a.c(this.vDl)) && (paramLong1 >= 600000L))
          {
            paramString2 = ai.getProcessName();
            e.wTc.f(18762, new Object[] { Integer.valueOf(a.e.vCW.value), paramf, paramString1, Integer.valueOf(17), paramString2 });
            AppMethodBeat.o(185183);
            return;
            if (a.c(this.vDl)) {
              a.e(this.vDl).remove(paramString1 + '@' + paramInt);
            }
            ac.i("ThreadPool.Execute", "||| " + paramString1 + '@' + paramInt + " state=" + paramf);
            AppMethodBeat.o(185183);
            return;
            if (a.c(this.vDl)) {
              a.e(this.vDl).remove(paramString1 + '@' + paramInt);
            }
            ac.i("ThreadPool.Execute", "*** " + paramString1 + '@' + paramInt + " state=" + paramf);
          }
        }
      }
    }
    
    public final void a(String paramString, int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(184670);
      d.g.b.k.h(paramString, "key");
      d.g.b.k.h(paramThrowable, "e");
      ac.e("ThreadPool.Profiler", paramString + '@' + paramInt + ' ' + paramThrowable);
      AppMethodBeat.o(184670);
    }
    
    public final void f(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(184672);
      d.g.b.k.h(paramString1, "key");
      d.g.b.k.h(paramString2, "pool");
      paramString2 = "[rejected] " + paramString1 + ' ' + paramString2 + " isShutdown=true";
      ac.w("ThreadPool.Profiler", paramString2);
      if (a.c(this.vDl))
      {
        a.e(this.vDl).remove(paramString1 + '@' + paramInt);
        String str = ai.getProcessName();
        e.wTc.f(18762, new Object[] { Integer.valueOf(a.e.vCV.value), paramString2, paramString1, Integer.valueOf(17), str });
      }
      AppMethodBeat.o(184672);
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(184673);
      ac.w("ThreadPool.Profiler", "shutdown");
      a.e(this.vDl).clear();
      AppMethodBeat.o(184673);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/threadpool/Printer$ThreadPrinter;", "onExit", "", "thread", "Ljava/lang/Thread;", "name", "", "id", "", "onInterrupt", "onStart", "plugin-performance_release"})
  public static final class n
    implements d.f
  {
    public final void a(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184674);
      d.g.b.k.h(paramThread, "thread");
      d.g.b.k.h(paramString, "name");
      ac.i("ThreadPool.Profiler", "[onInterrupt] name=" + paramString + " id=" + paramLong);
      AppMethodBeat.o(184674);
    }
    
    public final void b(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184675);
      d.g.b.k.h(paramThread, "thread");
      d.g.b.k.h(paramString, "name");
      ac.i("ThreadPool.Profiler", "[onThreadStart] name=" + paramString + " id=" + paramLong);
      a.b(this.vDl).incrementAndGet();
      AppMethodBeat.o(184675);
    }
    
    public final void c(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184676);
      d.g.b.k.h(paramThread, "thread");
      d.g.b.k.h(paramString, "name");
      ac.i("ThreadPool.Profiler", "[onThreadExit] name=" + paramString + " id=" + paramLong);
      a.b(this.vDl).decrementAndGet();
      AppMethodBeat.o(184676);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.a
 * JD-Core Version:    0.7.0.1
 */