package com.tencent.mm.plugin.performance.b;

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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver$IOnScreenshotTakenListener;", "Lcom/tencent/mm/app/IPhoneScreenListener;", "()V", "aboutUITimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "batteryRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$BatteryRecord;", "blowoutCount", "", "checkQueue", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "existThreadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "isNeedReport", "", "lastCheckTime", "", "looperPrepareMonitor", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1;", "mainLooperListener", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1;", "maxBlowoutCount", "methodInfoMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "otherTaskCount", "Ljava/util/concurrent/atomic/AtomicLong;", "otherThreadTime", "otherTime", "runCallback", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1;", "runnableMethodInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "runningCount", "screenShotObserver", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver;", "screenShotObserver2", "screenShotPath", "screenShotPath2", "taskPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1;", "threadPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1;", "timeRecord", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "uiBusyConcurrent", "", "uiTaskCount", "uiThreadTime", "uiTime", "checkExpiredTask", "", "dumpThreadPool", "dumpUIAbout", "getStackTrace", "thread", "Ljava/lang/Thread;", "onAppBackground", "activity", "onAppForeground", "onScreen", "isScreenOff", "onScreenshotTaken", "path", "open", "isProcessMain", "reportStatistics", "BatteryRecord", "CheckInfo", "Companion", "ReportType", "TimeRecord", "plugin-performance_release"})
public final class a
  implements com.tencent.mm.app.n, o, u.a
{
  public static boolean cxf;
  private static final d.f uts;
  public static final c utt;
  private long lastCheckTime;
  private final HashMap<String, List<Pair<String, String>>> pEW;
  private final AtomicInteger usS;
  private final AtomicInteger usT;
  private final ConcurrentHashMap<String, a.b> usU;
  private final boolean usV;
  private final ConcurrentHashMap<String, a.a> usW;
  private final ConcurrentHashMap<String, a.f> usX;
  private volatile int usY;
  private int usZ;
  private AtomicLong uta;
  private AtomicLong utb;
  private AtomicLong utc;
  private AtomicLong utd;
  private AtomicLong ute;
  private AtomicLong utf;
  private int[] utg;
  public final n uth;
  public final i uti;
  public final m utj;
  private final ArrayList<Pair<String, String>> utk;
  private final String utl;
  private final String utm;
  private final com.tencent.mm.pluginsdk.model.u utn;
  private final com.tencent.mm.pluginsdk.model.u uto;
  private final j utp;
  public final av utq;
  private final l utr;
  
  static
  {
    AppMethodBeat.i(184684);
    utt = new c((byte)0);
    uts = d.g.E((d.g.a.a)a.d.utv);
    AppMethodBeat.o(184684);
  }
  
  public a()
  {
    AppMethodBeat.i(184683);
    this.usS = new AtomicInteger();
    this.usT = new AtomicInteger();
    this.usU = new ConcurrentHashMap();
    int i;
    int j;
    if ((com.tencent.mm.protocal.d.CpL) || (com.tencent.mm.protocal.d.CpM))
    {
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pkS, 10);
      j = new Random().nextInt(100000);
      if (i < j) {
        break label579;
      }
    }
    label579:
    for (boolean bool = true;; bool = false)
    {
      ad.i("ThreadPool.Profiler", "[isNeedReport] rand=" + i + " test=" + j + " isEnable=" + bool + " isRelease=" + com.tencent.mm.protocal.d.CpL + " isTest=" + com.tencent.mm.protocal.d.CpM);
      this.usV = bool;
      this.usW = new ConcurrentHashMap(100);
      this.usX = new ConcurrentHashMap(100);
      this.uta = new AtomicLong();
      this.utb = new AtomicLong();
      this.utc = new AtomicLong();
      this.utd = new AtomicLong();
      this.ute = new AtomicLong();
      this.utf = new AtomicLong();
      this.utg = new int[2];
      this.uth = new n(this);
      this.uti = new i(this);
      this.utj = new m(this);
      this.pEW = new HashMap();
      this.utk = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder();
      File localFile = Environment.getExternalStorageDirectory();
      d.g.b.k.g(localFile, "Environment.getExternalStorageDirectory()");
      this.utl = (localFile.getPath() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator);
      localStringBuilder = new StringBuilder();
      localFile = Environment.getExternalStorageDirectory();
      d.g.b.k.g(localFile, "Environment.getExternalStorageDirectory()");
      this.utm = (localFile.getPath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Screenshots" + File.separator);
      this.utn = new com.tencent.mm.pluginsdk.model.u(this.utl, (u.a)this);
      this.uto = new com.tencent.mm.pluginsdk.model.u(this.utm, (u.a)this);
      this.utp = new j(this);
      this.utq = new av(com.tencent.e.j.a.aOc("ThreadPool.Profiler"), (av.a)new g(this), true);
      this.utr = new l(this);
      AppMethodBeat.o(184683);
      return;
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pkT, 100000);
      break;
    }
  }
  
  private final void daN()
  {
    AppMethodBeat.i(184681);
    StringBuilder localStringBuilder = new StringBuilder(" \n[RunningTask]\n");
    Object localObject1 = com.tencent.e.h.Iyf.fnL();
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
    ad.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    d.g.b.k.g(localStringBuilder, "sb");
    d.n.n.h(localStringBuilder);
    localStringBuilder.append(" \n[WaitingTask]\n");
    localObject1 = com.tencent.e.h.Iyf.fnM();
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
    ad.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    ad.i("ThreadPool.Profiler", "[dumpThreadPool] Alive Thread Count = " + this.usT.get() + " Global Running Count = " + this.usS.get() + " maxRunningCount=" + this.usY);
    daO();
    AppMethodBeat.o(184681);
  }
  
  private final void daO()
  {
    AppMethodBeat.i(184682);
    ad.i("ThreadPool.Profiler", "[dumpThreadPool]\n averageUITime=" + (float)this.utd.get() * 1.0F / (float)this.utf.get() + " averageUIThreadTime=" + (float)this.ute.get() * 1.0F / (float)this.utf.get() + '\n' + "averageOtherTime=" + (float)this.uta.get() * 1.0F / (float)this.utc.get() + " averageOtherThreadTime=" + (float)this.utb.get() * 1.0F / (float)this.utc.get() + '\n' + "uiTaskCount=" + this.utf.get() + " otherTaskCount=" + this.utc.get() + '\n' + "uiBusyConcurrent=" + this.utg[1] + " averageUIConcurrent=" + this.utg[0] * 1.0F / this.utg[1] + " concurrentRadio=" + this.utg[1] * 1.0F / (float)this.utf.get());
    AppMethodBeat.o(184682);
  }
  
  public final void ca(boolean paramBoolean)
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
      if ((l - this.lastCheckTime >= 900000L) && (this.usV))
      {
        localLinkedList = new LinkedList();
        localObject2 = (Map)this.usU;
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
        localObject2 = com.tencent.e.j.a.aOd(localObject2.toString());
        if (localObject2 == null) {
          break label660;
        }
        localObject2 = ((com.tencent.e.j.a)localObject2).foo();
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
        ad.e("ThreadPool.Profiler", (String)localObject3);
        if (localObject2 != null) {
          break label683;
        }
        i = 0;
      }
      for (;;)
      {
        e.vIY.f(18762, new Object[] { Integer.valueOf(e.utw.value), localObject3, localObject1, Integer.valueOf(17), aj.getProcessName(), Integer.valueOf(i) });
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
      localObject1 = com.tencent.e.b.IxC;
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
          localObject2 = (a.b)this.usU.get(localObject4);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new a.b(SystemClock.uptimeMillis(), 1);
            localObject2 = (Map)this.usU;
            d.g.b.k.g(localObject4, "key");
            ((Map)localObject2).put(localObject4, localObject1);
          }
          d.g.b.k.g(localObject1, "checkQueue[key] ?: run {…eckInfo\n                }");
          int m = ((a.b)localObject1).count;
          if ((j > 0) && (k > 0) && (j - m == 0) && (SystemClock.uptimeMillis() - ((a.b)localObject1).time >= 60000L))
          {
            localObject2 = "[ForkThreadPoolExecutor] " + (String)localObject4 + " has expired " + (SystemClock.uptimeMillis() - ((a.b)localObject1).time) + "ms " + localObject5;
            ad.e("ThreadPool.Profiler", (String)localObject2);
            e.vIY.f(18762, new Object[] { Integer.valueOf(e.utw.value), localObject2, localObject4, Integer.valueOf(17), aj.getProcessName() });
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
        daN();
      }
      localObject1 = ((Iterable)localLinkedList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.usU.remove(localObject2);
      }
      try
      {
        if (this.usW.values().size() > 1)
        {
          localObject1 = this.usW.values();
          d.g.b.k.g(localObject1, "batteryRecord.values");
          localObject1 = (Iterable)j.a((Iterable)localObject1, (Comparator)new a.h()).subList(0, d.k.h.kL(30, this.usW.values().size() - 1));
          i = 0;
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              j.fvx();
            }
            localObject2 = (a.a)localObject2;
            ad.i("ThreadPool.Profiler", "[batteryRecord]#" + i + ' ' + localObject2);
            e.vIY.f(18883, new Object[] { Integer.valueOf(17), Integer.valueOf(e.utK.value), Long.valueOf(((a.a)localObject2).utu), aj.getProcessName(), ((a.a)localObject2).name, Integer.valueOf(((a.a)localObject2).count) });
            i += 1;
          }
          this.usW.clear();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("ThreadPool.Profiler", (Throwable)localException, "", new Object[0]);
        }
      }
      this.lastCheckTime = l;
      AppMethodBeat.o(184677);
      return;
    }
  }
  
  public final void daM()
  {
    AppMethodBeat.i(184680);
    if (!cxf)
    {
      AppMethodBeat.o(184680);
      return;
    }
    com.tencent.mm.ad.b localb = new com.tencent.mm.ad.b("ThreadPool.Profiler#onScreenshotTaken");
    daN();
    localb.agL();
    AppMethodBeat.o(184680);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(184679);
    if (!cxf)
    {
      AppMethodBeat.o(184679);
      return;
    }
    this.utn.stopWatching();
    this.uto.stopWatching();
    AppMethodBeat.o(184679);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(184678);
    if (!cxf)
    {
      AppMethodBeat.o(184678);
      return;
    }
    this.utn.startWatching();
    this.uto.startWatching();
    AppMethodBeat.o(184678);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$Companion;", "", "()V", "CHECK_EXPIRED_TIME", "", "CHECK_TIMEOUT_TIME", "DELAY_REPORT", "", "EXPIRED_TIME", "KV_NORMAL_ID", "KV_STATISTICS_ID", "LOOP_PRINT", "TAG", "", "TAG_EXECUTE", "TOP_OF_BLOWOUT_COUNT", "getTOP_OF_BLOWOUT_COUNT", "()I", "TOP_OF_BLOWOUT_COUNT$delegate", "Lkotlin/Lazy;", "VERSION", "isDebug", "", "plugin-performance_release"})
  public static final class c
  {
    static
    {
      AppMethodBeat.i(184655);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(c.class), "TOP_OF_BLOWOUT_COUNT", "getTOP_OF_BLOWOUT_COUNT()I")) };
      AppMethodBeat.o(184655);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$ReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_EXPIRED", "TYPE_CONTROL", "TYPE_REJECT", "TYPE_TIMEOUT", "TYPE_STATISTICS_COUNT_BLOWOUT", "TYPE_STATISTICS_UI_TIME", "TYPE_STATISTICS_UI_THREAD_TIME", "TYPE_STATISTICS_UI_TIME_RADIO", "TYPE_STATISTICS_OTHER_TIME", "TYPE_STATISTICS_OTHER_THREAD_TIME", "TYPE_STATISTICS_OTHER_TIME_RADIO", "TYPE_STATISTICS_THREAD_COUNT", "TYPE_STATISTICS_UI_OTHER_AVERAGE", "TYPE_STATISTICS_MAX_COUNT_BLOWOUT", "TYPE_STATISTICS_TASK_THREAD_TIME", "TYPE_LOOPER_PREPARE", "plugin-performance_release"})
  public static enum e
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(184657);
      e locale1 = new e("TYPE_EXPIRED", 0, 1);
      utw = locale1;
      e locale2 = new e("TYPE_CONTROL", 1, 2);
      utx = locale2;
      e locale3 = new e("TYPE_REJECT", 2, 3);
      uty = locale3;
      e locale4 = new e("TYPE_TIMEOUT", 3, 4);
      utz = locale4;
      e locale5 = new e("TYPE_STATISTICS_COUNT_BLOWOUT", 4, 5);
      utA = locale5;
      e locale6 = new e("TYPE_STATISTICS_UI_TIME", 5, 6);
      utB = locale6;
      e locale7 = new e("TYPE_STATISTICS_UI_THREAD_TIME", 6, 7);
      utC = locale7;
      e locale8 = new e("TYPE_STATISTICS_UI_TIME_RADIO", 7, 8);
      utD = locale8;
      e locale9 = new e("TYPE_STATISTICS_OTHER_TIME", 8, 9);
      utE = locale9;
      e locale10 = new e("TYPE_STATISTICS_OTHER_THREAD_TIME", 9, 10);
      utF = locale10;
      e locale11 = new e("TYPE_STATISTICS_OTHER_TIME_RADIO", 10, 11);
      utG = locale11;
      e locale12 = new e("TYPE_STATISTICS_THREAD_COUNT", 11, 12);
      utH = locale12;
      e locale13 = new e("TYPE_STATISTICS_UI_OTHER_AVERAGE", 12, 13);
      utI = locale13;
      e locale14 = new e("TYPE_STATISTICS_MAX_COUNT_BLOWOUT", 13, 14);
      utJ = locale14;
      e locale15 = new e("TYPE_STATISTICS_TASK_THREAD_TIME", 14, 15);
      utK = locale15;
      e locale16 = new e("TYPE_LOOPER_PREPARE", 15, 16);
      utL = locale16;
      utM = new e[] { locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8, locale9, locale10, locale11, locale12, locale13, locale14, locale15, locale16 };
      AppMethodBeat.o(184657);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class g
    implements av.a
  {
    g(a parama) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(184662);
      a.k(this.utO);
      AppMethodBeat.o(184662);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/threadpool/ThreadModuleBoot$ILooperPrepareMonitor;", "isResetLooper", "", "()Z", "reportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "isHookResetLooper", "isOpenCheck", "isThrowException", "onLooperPreparedAtTask", "", "thread", "Ljava/lang/Thread;", "task", "plugin-performance_release"})
  public static final class i
    implements g.b
  {
    private final boolean utP;
    private final ConcurrentHashMap<String, String> utQ;
    
    i()
    {
      AppMethodBeat.i(193439);
      boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pkU, true);
      ad.w("ThreadPool.Profiler", "[isHookResetLooper] ".concat(String.valueOf(bool)));
      this.utP = bool;
      this.utQ = new ConcurrentHashMap();
      AppMethodBeat.o(193439);
    }
    
    public final void a(Thread paramThread, String paramString)
    {
      AppMethodBeat.i(193438);
      d.g.b.k.h(paramThread, "thread");
      d.g.b.k.h(paramString, "task");
      if (a.c(this.utO))
      {
        Object localObject = (CharSequence)paramString;
        localObject = new d.n.k("[0-9]\\d*").c((CharSequence)localObject, "?");
        if (!this.utQ.contains(localObject))
        {
          String str = "task=" + (String)localObject + ' ' + paramThread;
          ad.w("ThreadPool.Profiler", "[onLooperPreparedAtTask] ".concat(String.valueOf(str)));
          e.vIY.f(18762, new Object[] { Integer.valueOf(a.e.utL.value), str, paramString, Integer.valueOf(17), aj.getProcessName() });
          ((Map)this.utQ).put(localObject, String.valueOf(paramThread));
        }
      }
      AppMethodBeat.o(193438);
    }
    
    public final boolean daR()
    {
      return true;
    }
    
    public final boolean daS()
    {
      return this.utP;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Landroid/util/Printer;", "record", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "getRecord", "()Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "setRecord", "(Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;)V", "onDispatchEnd", "", "x", "", "onDispatchStart", "println", "plugin-performance_release"})
  public static final class j
    implements Printer
  {
    private a.f utR;
    
    j()
    {
      AppMethodBeat.i(184664);
      this.utR = new a.f(true, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte)0);
      AppMethodBeat.o(184664);
    }
    
    public final void println(String paramString)
    {
      AppMethodBeat.i(184663);
      d.g.b.k.h(paramString, "x");
      if (paramString.charAt(0) == '>')
      {
        d.g.b.k.h(paramString, "x");
        this.utR.time = SystemClock.uptimeMillis();
        this.utR.utu = SystemClock.currentThreadTimeMillis();
        int i = a.f(this.utO).get();
        if (i > 0)
        {
          paramString = a.g(this.utO);
          paramString[0] = (i + paramString[0]);
          paramString = a.g(this.utO);
          paramString[1] += 1;
        }
        AppMethodBeat.o(184663);
        return;
      }
      if (paramString.charAt(0) == '<')
      {
        d.g.b.k.h(paramString, "x");
        paramString = this.utR;
        long l1 = SystemClock.uptimeMillis();
        long l2 = paramString.time;
        long l3 = SystemClock.currentThreadTimeMillis();
        long l4 = paramString.utu;
        a.h(this.utO).addAndGet(l1 - l2);
        a.i(this.utO).addAndGet(l3 - l4);
        a.j(this.utO).incrementAndGet();
      }
      AppMethodBeat.o(184663);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$open$1", "Ljava/lang/Runnable;", "run", "", "plugin-performance_release"})
  public static final class k
    implements Runnable
  {
    public k(ap paramap) {}
    
    public final void run()
    {
      AppMethodBeat.i(184665);
      a.a(this.utO);
      this.utS.postDelayed((Runnable)this, 1800000L);
      AppMethodBeat.o(184665);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mainThreadId", "", "getMainThreadId", "()J", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-performance_release"})
  public static final class l
    implements com.tencent.mm.hellhoundlib.a.c
  {
    private final long utT;
    
    l()
    {
      AppMethodBeat.i(184668);
      Object localObject = Looper.getMainLooper();
      d.g.b.k.g(localObject, "Looper.getMainLooper()");
      localObject = ((Looper)localObject).getThread();
      d.g.b.k.g(localObject, "Looper.getMainLooper().thread");
      this.utT = ((Thread)localObject).getId();
      AppMethodBeat.o(184668);
    }
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184666);
      d.g.b.k.h(paramString1, "className");
      int i = a.f(this.utO).incrementAndGet();
      if (i > a.l(this.utO)) {
        a.a(this.utO, i);
      }
      paramString2 = a.utt;
      if (i > a.c.daQ())
      {
        paramString2 = this.utO;
        a.b(paramString2, a.m(paramString2) + 1);
      }
      long l = this.utT;
      paramString2 = Thread.currentThread();
      d.g.b.k.g(paramString2, "Thread.currentThread()");
      if (l != paramString2.getId())
      {
        paramString2 = (Map)a.n(this.utO);
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
    
    public final void g(String paramString, Object paramObject)
    {
      AppMethodBeat.i(184667);
      d.g.b.k.h(paramString, "className");
      a.f(this.utO).decrementAndGet();
      long l1 = this.utT;
      Object localObject = Thread.currentThread();
      d.g.b.k.g(localObject, "Thread.currentThread()");
      if (l1 != ((Thread)localObject).getId())
      {
        localObject = a.n(this.utO);
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
          long l4 = paramString.utu;
          a.o(this.utO).addAndGet(l3 - l4);
          a.p(this.utO).addAndGet(l1 - l2);
          a.q(this.utO).incrementAndGet();
          AppMethodBeat.o(184667);
          return;
        }
      }
      AppMethodBeat.o(184667);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/threadpool/Printer$TaskPrinter;", "error", "", "key", "", "hash", "", "e", "", "print", "state", "Lcom/tencent/threadpool/State;", "time", "", "costThreadMs", "pool", "isLogging", "", "rejected", "isShutdown", "shutdown", "wait", "runningCount", "waitFor", "plugin-performance_release"})
  public static final class m
    implements d.e
  {
    public final void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
    {
      AppMethodBeat.i(184671);
      d.g.b.k.h(paramString1, "key");
      d.g.b.k.h(paramString2, "pool");
      paramString2 = "[wait] " + paramString1 + '@' + paramInt1 + " runningCount=" + paramInt2 + " waitFor=" + paramLong / 100000L + "ms " + paramString2;
      ad.w("ThreadPool.Profiler", paramString2);
      String str = aj.getProcessName();
      e.vIY.f(18762, new Object[] { Integer.valueOf(a.e.utx.value), paramString2, paramString1, Integer.valueOf(17), str });
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
      if ((a.c(this.utO)) && (paramf == com.tencent.e.f.Iyb))
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
        a.a locala2 = (a.a)a.d(this.utO).get(localObject);
        a.a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a.a((String)localObject);
          ((Map)a.d(this.utO)).put(localObject, locala1);
        }
        d.g.b.k.g(locala1, "batteryRecord[keyRecord]… record\n                }");
        locala1.count += 1;
        if (locala1.count % 2 == 1) {
          locala1.utu += 1L;
        }
        locala1.utu += paramLong2;
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
        switch (b.ciE[paramf.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(185183);
          return;
          if (paramLong1 < 0L) {}
          for (paramLong1 = 0L;; paramLong1 /= 1000000L)
          {
            if (a.c(this.utO)) {
              ((Map)a.e(this.utO)).put(paramString1 + '@' + paramInt, new a.b(SystemClock.uptimeMillis() + paramLong1));
            }
            ad.i("ThreadPool.Execute", "=== " + paramString1 + '@' + paramInt + " state=" + paramf + " delay=" + paramLong1 + "ms");
            AppMethodBeat.o(185183);
            return;
          }
          if (a.c(this.utO))
          {
            localObject = (a.b)a.e(this.utO).get(paramString1 + '@' + paramInt);
            if (localObject != null) {
              ((a.b)localObject).thread = Thread.currentThread();
            }
            a.e(this.utO).remove(paramString1 + '@' + paramInt);
          }
          ad.i("ThreadPool.Execute", ">>> " + paramString1 + '@' + paramInt + " state=" + paramf + ' ' + paramString2);
          AppMethodBeat.o(185183);
          return;
          paramf = "<<< " + paramString1 + '@' + paramInt + " state=" + paramf + " cost=" + paramLong1 + "ms/" + paramLong2 + "ms " + paramString2;
          ad.i("ThreadPool.Execute", paramf);
          if ((a.c(this.utO)) && (paramLong1 >= 600000L))
          {
            paramString2 = aj.getProcessName();
            e.vIY.f(18762, new Object[] { Integer.valueOf(a.e.utz.value), paramf, paramString1, Integer.valueOf(17), paramString2 });
            AppMethodBeat.o(185183);
            return;
            if (a.c(this.utO)) {
              a.e(this.utO).remove(paramString1 + '@' + paramInt);
            }
            ad.i("ThreadPool.Execute", "||| " + paramString1 + '@' + paramInt + " state=" + paramf);
            AppMethodBeat.o(185183);
            return;
            if (a.c(this.utO)) {
              a.e(this.utO).remove(paramString1 + '@' + paramInt);
            }
            ad.i("ThreadPool.Execute", "*** " + paramString1 + '@' + paramInt + " state=" + paramf);
          }
        }
      }
    }
    
    public final void a(String paramString, int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(184670);
      d.g.b.k.h(paramString, "key");
      d.g.b.k.h(paramThrowable, "e");
      ad.e("ThreadPool.Profiler", paramString + '@' + paramInt + ' ' + paramThrowable);
      AppMethodBeat.o(184670);
    }
    
    public final void f(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(184672);
      d.g.b.k.h(paramString1, "key");
      d.g.b.k.h(paramString2, "pool");
      paramString2 = "[rejected] " + paramString1 + ' ' + paramString2 + " isShutdown=true";
      ad.w("ThreadPool.Profiler", paramString2);
      if (a.c(this.utO))
      {
        a.e(this.utO).remove(paramString1 + '@' + paramInt);
        String str = aj.getProcessName();
        e.vIY.f(18762, new Object[] { Integer.valueOf(a.e.uty.value), paramString2, paramString1, Integer.valueOf(17), str });
      }
      AppMethodBeat.o(184672);
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(184673);
      ad.w("ThreadPool.Profiler", "shutdown");
      a.e(this.utO).clear();
      AppMethodBeat.o(184673);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/threadpool/Printer$ThreadPrinter;", "onExit", "", "thread", "Ljava/lang/Thread;", "name", "", "id", "", "onInterrupt", "onStart", "plugin-performance_release"})
  public static final class n
    implements d.f
  {
    public final void a(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184674);
      d.g.b.k.h(paramThread, "thread");
      d.g.b.k.h(paramString, "name");
      ad.i("ThreadPool.Profiler", "[onInterrupt] name=" + paramString + " id=" + paramLong);
      AppMethodBeat.o(184674);
    }
    
    public final void b(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184675);
      d.g.b.k.h(paramThread, "thread");
      d.g.b.k.h(paramString, "name");
      ad.i("ThreadPool.Profiler", "[onThreadStart] name=" + paramString + " id=" + paramLong);
      a.b(this.utO).incrementAndGet();
      AppMethodBeat.o(184675);
    }
    
    public final void c(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184676);
      d.g.b.k.h(paramThread, "thread");
      d.g.b.k.h(paramString, "name");
      ad.i("ThreadPool.Profiler", "[onThreadExit] name=" + paramString + " id=" + paramLong);
      a.b(this.utO).decrementAndGet();
      AppMethodBeat.o(184676);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a
 * JD-Core Version:    0.7.0.1
 */