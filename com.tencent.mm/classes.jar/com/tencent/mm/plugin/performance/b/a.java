package com.tencent.mm.plugin.performance.b;

import android.os.Environment;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Printer;
import com.tencent.e.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.a.j;
import d.g.b.p;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver$IOnScreenshotTakenListener;", "Lcom/tencent/mm/app/IPhoneScreenListener;", "()V", "aboutUITimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "batteryRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$BatteryRecord;", "blowoutCount", "", "checkQueue", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "existThreadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "isNeedReport", "", "lastCheckTime", "", "looperPrepareMonitor", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1;", "mainLooperListener", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1;", "maxBlowoutCount", "methodInfoMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "otherTaskCount", "Ljava/util/concurrent/atomic/AtomicLong;", "otherThreadTime", "otherTime", "runCallback", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1;", "runnableMethodInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "runningCount", "screenShotObserver", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver;", "screenShotObserver2", "screenShotPath", "screenShotPath2", "taskPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1;", "threadPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1;", "timeRecord", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "uiBusyConcurrent", "", "uiTaskCount", "uiThreadTime", "uiTime", "checkExpiredTask", "", "dumpThreadPool", "dumpUIAbout", "getStackTrace", "thread", "Ljava/lang/Thread;", "onAppBackground", "activity", "onAppForeground", "onScreen", "isScreenOff", "onScreenshotTaken", "path", "open", "isProcessMain", "reportStatistics", "BatteryRecord", "CheckInfo", "Companion", "ReportType", "TimeRecord", "plugin-performance_release"})
public final class a
  implements com.tencent.mm.app.n, o, u.a
{
  public static boolean cFj;
  private static final d.f wIK;
  public static final a.c wIL;
  private long lastCheckTime;
  private final HashMap<String, List<Pair<String, String>>> qRP;
  public final a.i wIA;
  public final m wIB;
  private final ArrayList<Pair<String, String>> wIC;
  private final String wID;
  private final String wIE;
  private final u wIF;
  private final u wIG;
  private final j wIH;
  public final av wII;
  private final l wIJ;
  private final AtomicInteger wIk;
  private final AtomicInteger wIl;
  private final ConcurrentHashMap<String, a.b> wIm;
  private final boolean wIn;
  private final ConcurrentHashMap<String, a.a> wIo;
  private final ConcurrentHashMap<String, a.f> wIp;
  private volatile int wIq;
  private int wIr;
  private AtomicLong wIs;
  private AtomicLong wIt;
  private AtomicLong wIu;
  private AtomicLong wIv;
  private AtomicLong wIw;
  private AtomicLong wIx;
  private int[] wIy;
  public final a.n wIz;
  
  static
  {
    AppMethodBeat.i(184684);
    wIL = new a.c((byte)0);
    wIK = d.g.O((d.g.a.a)a.d.wIN);
    AppMethodBeat.o(184684);
  }
  
  public a()
  {
    AppMethodBeat.i(184683);
    this.wIk = new AtomicInteger();
    this.wIl = new AtomicInteger();
    this.wIm = new ConcurrentHashMap();
    int i;
    int j;
    if ((com.tencent.mm.protocal.d.Fnk) || (com.tencent.mm.protocal.d.Fnl))
    {
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsi, 10);
      j = new Random().nextInt(100000);
      if (i < j) {
        break label576;
      }
    }
    label576:
    for (boolean bool = true;; bool = false)
    {
      ad.i("ThreadPool.Profiler", "[isNeedReport] rand=" + i + " test=" + j + " isEnable=" + bool + " isRelease=" + com.tencent.mm.protocal.d.Fnk + " isTest=" + com.tencent.mm.protocal.d.Fnl);
      this.wIn = bool;
      this.wIo = new ConcurrentHashMap(100);
      this.wIp = new ConcurrentHashMap(100);
      this.wIs = new AtomicLong();
      this.wIt = new AtomicLong();
      this.wIu = new AtomicLong();
      this.wIv = new AtomicLong();
      this.wIw = new AtomicLong();
      this.wIx = new AtomicLong();
      this.wIy = new int[2];
      this.wIz = new a.n(this);
      this.wIA = new a.i(this);
      this.wIB = new m(this);
      this.qRP = new HashMap();
      this.wIC = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder();
      File localFile = Environment.getExternalStorageDirectory();
      p.g(localFile, "Environment.getExternalStorageDirectory()");
      this.wID = (localFile.getPath() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator);
      localStringBuilder = new StringBuilder();
      localFile = Environment.getExternalStorageDirectory();
      p.g(localFile, "Environment.getExternalStorageDirectory()");
      this.wIE = (localFile.getPath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Screenshots" + File.separator);
      this.wIF = new u(this.wID, (u.a)this);
      this.wIG = new u(this.wIE, (u.a)this);
      this.wIH = new j(this);
      this.wII = new av(com.tencent.e.j.a.aZF("ThreadPool.Profiler"), (av.a)new g(this), true);
      this.wIJ = new l(this);
      AppMethodBeat.o(184683);
      return;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsj, 100000);
      break;
    }
  }
  
  private final void dyS()
  {
    AppMethodBeat.i(184681);
    StringBuilder localStringBuilder = new StringBuilder(" \n[RunningTask]\n");
    Object localObject1 = com.tencent.e.h.LTK.fVt();
    p.g(localObject1, "ThreadPool.PROFILE.dumpRunningTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    Object localObject3;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = localStringBuilder.append("\t").append((String)((Map.Entry)localObject3).getKey()).append(" => ");
      localObject3 = ((Map.Entry)localObject3).getValue();
      p.g(localObject3, "it.value");
      ((StringBuilder)localObject2).append(((Number)localObject3).intValue()).append("\n");
    }
    ad.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    p.g(localStringBuilder, "sb");
    d.n.n.h(localStringBuilder);
    localStringBuilder.append(" \n[WaitingTask]\n");
    localObject1 = com.tencent.e.h.LTK.fVu();
    p.g(localObject1, "ThreadPool.PROFILE.dumpWaitingTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localStringBuilder.append("# ").append((String)((Map.Entry)localObject2).getKey()).append("\n");
      localObject2 = ((Map.Entry)localObject2).getValue();
      p.g(localObject2, "entry.value");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Pair)((Iterator)localObject2).next();
        localObject3 = localStringBuilder.append("\t|* ").append((String)((Pair)localObject4).first).append(" => ");
        localObject4 = ((Pair)localObject4).second;
        p.g(localObject4, "it.second");
        ((StringBuilder)localObject3).append(((Number)localObject4).intValue()).append("\n");
      }
    }
    ad.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    ad.i("ThreadPool.Profiler", "[dumpThreadPool] Alive Thread Count = " + this.wIl.get() + " Global Running Count = " + this.wIk.get() + " maxRunningCount=" + this.wIq);
    dyT();
    AppMethodBeat.o(184681);
  }
  
  private final void dyT()
  {
    AppMethodBeat.i(184682);
    ad.i("ThreadPool.Profiler", "[dumpThreadPool]\n averageUITime=" + (float)this.wIv.get() * 1.0F / (float)this.wIx.get() + " averageUIThreadTime=" + (float)this.wIw.get() * 1.0F / (float)this.wIx.get() + '\n' + "averageOtherTime=" + (float)this.wIs.get() * 1.0F / (float)this.wIu.get() + " averageOtherThreadTime=" + (float)this.wIt.get() * 1.0F / (float)this.wIu.get() + '\n' + "uiTaskCount=" + this.wIx.get() + " otherTaskCount=" + this.wIu.get() + '\n' + "uiBusyConcurrent=" + this.wIy[1] + " averageUIConcurrent=" + this.wIy[0] * 1.0F / this.wIy[1] + " concurrentRadio=" + this.wIy[1] * 1.0F / (float)this.wIx.get());
    AppMethodBeat.o(184682);
  }
  
  public final void cd(boolean paramBoolean)
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
      if ((l - this.lastCheckTime >= 900000L) && (this.wIn))
      {
        localLinkedList = new LinkedList();
        localObject2 = (Map)this.wIm;
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
              break label642;
            }
            label250:
            localObject1 = (String)localObject1;
            if (localObject1 != null)
            {
              localObject1 = ((String)localObject1).subSequence(0, d.n.n.a((CharSequence)localObject1, '@', 0, 6));
              if (localObject1 != null) {
                break label1362;
              }
            }
            localObject1 = (CharSequence)((Map.Entry)localObject5).getKey();
          }
        }
      }
    }
    label333:
    label337:
    label1362:
    for (;;)
    {
      localObject2 = ((Map.Entry)localObject5).getKey();
      if (d.n.n.a((CharSequence)localObject2, '#', 0, 6) >= 0)
      {
        i = 1;
        if (i == 0) {
          break label653;
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
        localObject2 = com.tencent.e.j.a.aZG(localObject2.toString());
        if (localObject2 == null) {
          break label659;
        }
        localObject2 = ((com.tencent.e.j.a)localObject2).fVW();
        StringBuilder localStringBuilder = new StringBuilder().append((String)((Map.Entry)localObject5).getKey()).append(" has expired ").append(SystemClock.uptimeMillis() - ((a.b)((Map.Entry)localObject5).getValue()).time).append("ms size=");
        if (localObject2 == null) {
          break label665;
        }
        localObject3 = Integer.valueOf(((com.tencent.e.j.d)localObject2).size());
        label485:
        localObject3 = localStringBuilder.append(localObject3).append(" queue is null=");
        if (localObject2 != null) {
          break label671;
        }
        paramBoolean = true;
        label507:
        localStringBuilder = ((StringBuilder)localObject3).append(paramBoolean).append(" isRunning=");
        if (localObject2 == null) {
          break label676;
        }
        localObject3 = Boolean.valueOf(((com.tencent.e.j.d)localObject2).isRunning());
        localObject3 = localObject3;
        ad.e("ThreadPool.Profiler", (String)localObject3);
        if (localObject2 != null) {
          break label682;
        }
        i = 0;
      }
      for (;;)
      {
        e.ygI.f(18762, new Object[] { Integer.valueOf(e.wIO.value), localObject3, localObject1, Integer.valueOf(17), aj.getProcessName(), Integer.valueOf(i) });
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
      localObject1 = com.tencent.e.b.LTg;
      p.g(localObject1, "ForkThreadPoolExecutor.sGlobalForkThreadPool");
      localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (com.tencent.e.b)((WeakReference)((Iterator)localObject3).next()).get();
        if (localObject5 != null)
        {
          localObject4 = ((com.tencent.e.b)localObject5).getName();
          int j = (int)((com.tencent.e.b)localObject5).getCompletedTaskCount();
          int k = ((com.tencent.e.b)localObject5).getQueue().size();
          localObject2 = (a.b)this.wIm.get(localObject4);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new a.b(SystemClock.uptimeMillis(), 1);
            localObject2 = (Map)this.wIm;
            p.g(localObject4, "key");
            ((Map)localObject2).put(localObject4, localObject1);
          }
          p.g(localObject1, "checkQueue[key] ?: run {…eckInfo\n                }");
          int m = ((a.b)localObject1).count;
          if ((j > 0) && (k > 0) && (j - m == 0) && (SystemClock.uptimeMillis() - ((a.b)localObject1).time >= 60000L))
          {
            localObject2 = "[ForkThreadPoolExecutor] " + (String)localObject4 + " has expired " + (SystemClock.uptimeMillis() - ((a.b)localObject1).time) + "ms " + localObject5;
            ad.e("ThreadPool.Profiler", (String)localObject2);
            e.ygI.f(18762, new Object[] { Integer.valueOf(e.wIO.value), localObject2, localObject4, Integer.valueOf(17), aj.getProcessName() });
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
        dyS();
      }
      localObject1 = ((Iterable)localLinkedList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.wIm.remove(localObject2);
      }
      try
      {
        if (this.wIo.values().size() > 1)
        {
          localObject1 = this.wIo.values();
          p.g(localObject1, "batteryRecord.values");
          localObject1 = (Iterable)j.a((Iterable)localObject1, (Comparator)new a.h()).subList(0, d.k.h.lq(30, this.wIo.values().size() - 1));
          i = 0;
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              j.gfB();
            }
            localObject2 = (a.a)localObject2;
            ad.i("ThreadPool.Profiler", "[batteryRecord]#" + i + ' ' + localObject2);
            e.ygI.f(18883, new Object[] { Integer.valueOf(17), Integer.valueOf(e.wJc.value), Long.valueOf(((a.a)localObject2).wIM), aj.getProcessName(), ((a.a)localObject2).name, Integer.valueOf(((a.a)localObject2).count) });
            i += 1;
          }
          this.wIo.clear();
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
  
  public final void dyR()
  {
    AppMethodBeat.i(184680);
    if (!cFj)
    {
      AppMethodBeat.o(184680);
      return;
    }
    com.tencent.mm.ad.b localb = new com.tencent.mm.ad.b("ThreadPool.Profiler#onScreenshotTaken");
    dyS();
    localb.akO();
    AppMethodBeat.o(184680);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(184679);
    if (!cFj)
    {
      AppMethodBeat.o(184679);
      return;
    }
    this.wIF.stopWatching();
    this.wIG.stopWatching();
    AppMethodBeat.o(184679);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(184678);
    if (!cFj)
    {
      AppMethodBeat.o(184678);
      return;
    }
    this.wIF.startWatching();
    this.wIG.startWatching();
    AppMethodBeat.o(184678);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$ReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_EXPIRED", "TYPE_CONTROL", "TYPE_REJECT", "TYPE_TIMEOUT", "TYPE_STATISTICS_COUNT_BLOWOUT", "TYPE_STATISTICS_UI_TIME", "TYPE_STATISTICS_UI_THREAD_TIME", "TYPE_STATISTICS_UI_TIME_RADIO", "TYPE_STATISTICS_OTHER_TIME", "TYPE_STATISTICS_OTHER_THREAD_TIME", "TYPE_STATISTICS_OTHER_TIME_RADIO", "TYPE_STATISTICS_THREAD_COUNT", "TYPE_STATISTICS_UI_OTHER_AVERAGE", "TYPE_STATISTICS_MAX_COUNT_BLOWOUT", "TYPE_STATISTICS_TASK_THREAD_TIME", "TYPE_LOOPER_PREPARE", "plugin-performance_release"})
  public static enum e
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(184657);
      e locale1 = new e("TYPE_EXPIRED", 0, 1);
      wIO = locale1;
      e locale2 = new e("TYPE_CONTROL", 1, 2);
      wIP = locale2;
      e locale3 = new e("TYPE_REJECT", 2, 3);
      wIQ = locale3;
      e locale4 = new e("TYPE_TIMEOUT", 3, 4);
      wIR = locale4;
      e locale5 = new e("TYPE_STATISTICS_COUNT_BLOWOUT", 4, 5);
      wIS = locale5;
      e locale6 = new e("TYPE_STATISTICS_UI_TIME", 5, 6);
      wIT = locale6;
      e locale7 = new e("TYPE_STATISTICS_UI_THREAD_TIME", 6, 7);
      wIU = locale7;
      e locale8 = new e("TYPE_STATISTICS_UI_TIME_RADIO", 7, 8);
      wIV = locale8;
      e locale9 = new e("TYPE_STATISTICS_OTHER_TIME", 8, 9);
      wIW = locale9;
      e locale10 = new e("TYPE_STATISTICS_OTHER_THREAD_TIME", 9, 10);
      wIX = locale10;
      e locale11 = new e("TYPE_STATISTICS_OTHER_TIME_RADIO", 10, 11);
      wIY = locale11;
      e locale12 = new e("TYPE_STATISTICS_THREAD_COUNT", 11, 12);
      wIZ = locale12;
      e locale13 = new e("TYPE_STATISTICS_UI_OTHER_AVERAGE", 12, 13);
      wJa = locale13;
      e locale14 = new e("TYPE_STATISTICS_MAX_COUNT_BLOWOUT", 13, 14);
      wJb = locale14;
      e locale15 = new e("TYPE_STATISTICS_TASK_THREAD_TIME", 14, 15);
      wJc = locale15;
      e locale16 = new e("TYPE_LOOPER_PREPARE", 15, 16);
      wJd = locale16;
      wJe = new e[] { locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8, locale9, locale10, locale11, locale12, locale13, locale14, locale15, locale16 };
      AppMethodBeat.o(184657);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class g
    implements av.a
  {
    g(a parama) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(184662);
      a.k(this.wJg);
      AppMethodBeat.o(184662);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Landroid/util/Printer;", "record", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "getRecord", "()Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "setRecord", "(Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;)V", "onDispatchEnd", "", "x", "", "onDispatchStart", "println", "plugin-performance_release"})
  public static final class j
    implements Printer
  {
    private a.f wJj;
    
    j()
    {
      AppMethodBeat.i(184664);
      this.wJj = new a.f(true, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte)0);
      AppMethodBeat.o(184664);
    }
    
    public final void println(String paramString)
    {
      AppMethodBeat.i(184663);
      p.h(paramString, "x");
      if (paramString.charAt(0) == '>')
      {
        p.h(paramString, "x");
        this.wJj.time = SystemClock.uptimeMillis();
        this.wJj.wIM = SystemClock.currentThreadTimeMillis();
        int i = a.f(this.wJg).get();
        if (i > 0)
        {
          paramString = a.g(this.wJg);
          paramString[0] = (i + paramString[0]);
          paramString = a.g(this.wJg);
          paramString[1] += 1;
        }
        AppMethodBeat.o(184663);
        return;
      }
      if (paramString.charAt(0) == '<')
      {
        p.h(paramString, "x");
        paramString = this.wJj;
        long l1 = SystemClock.uptimeMillis();
        long l2 = paramString.time;
        long l3 = SystemClock.currentThreadTimeMillis();
        long l4 = paramString.wIM;
        a.h(this.wJg).addAndGet(l1 - l2);
        a.i(this.wJg).addAndGet(l3 - l4);
        a.j(this.wJg).incrementAndGet();
      }
      AppMethodBeat.o(184663);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$open$1", "Ljava/lang/Runnable;", "run", "", "plugin-performance_release"})
  public static final class k
    implements Runnable
  {
    public k(ap paramap) {}
    
    public final void run()
    {
      AppMethodBeat.i(184665);
      a.a(this.wJg);
      this.wJk.postDelayed((Runnable)this, 1800000L);
      AppMethodBeat.o(184665);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mainThreadId", "", "getMainThreadId", "()J", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-performance_release"})
  public static final class l
    implements com.tencent.mm.hellhoundlib.a.c
  {
    private final long wJl;
    
    l()
    {
      AppMethodBeat.i(184668);
      Object localObject = Looper.getMainLooper();
      p.g(localObject, "Looper.getMainLooper()");
      localObject = ((Looper)localObject).getThread();
      p.g(localObject, "Looper.getMainLooper().thread");
      this.wJl = ((Thread)localObject).getId();
      AppMethodBeat.o(184668);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(211730);
      p.h(paramString1, "className");
      a.f(this.wJg).decrementAndGet();
      long l1 = this.wJl;
      paramString2 = Thread.currentThread();
      p.g(paramString2, "Thread.currentThread()");
      if (l1 != paramString2.getId())
      {
        paramString2 = a.n(this.wJg);
        paramString1 = new StringBuilder().append(paramString1);
        if (paramObject1 != null) {}
        for (int i = paramObject1.hashCode();; i = 0)
        {
          paramString1 = (a.f)paramString2.remove(i);
          if (paramString1 == null) {
            break;
          }
          l1 = SystemClock.uptimeMillis();
          long l2 = paramString1.time;
          long l3 = SystemClock.currentThreadTimeMillis();
          long l4 = paramString1.wIM;
          a.o(this.wJg).addAndGet(l3 - l4);
          a.p(this.wJg).addAndGet(l1 - l2);
          a.q(this.wJg).incrementAndGet();
          AppMethodBeat.o(211730);
          return;
        }
      }
      AppMethodBeat.o(211730);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184666);
      p.h(paramString1, "className");
      int i = a.f(this.wJg).incrementAndGet();
      if (i > a.l(this.wJg)) {
        a.a(this.wJg, i);
      }
      paramString2 = a.wIL;
      paramString2 = a.dyU();
      paramString3 = a.wIL;
      if (i > ((Number)paramString2.getValue()).intValue())
      {
        paramString2 = this.wJg;
        a.b(paramString2, a.m(paramString2) + 1);
      }
      long l = this.wJl;
      paramString2 = Thread.currentThread();
      p.g(paramString2, "Thread.currentThread()");
      if (l != paramString2.getId())
      {
        paramString2 = (Map)a.n(this.wJg);
        paramString1 = new StringBuilder().append(paramString1);
        if (paramObject == null) {
          break label186;
        }
      }
      label186:
      for (i = paramObject.hashCode();; i = 0)
      {
        paramString2.put(i, new a.f(false, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte)0));
        AppMethodBeat.o(184666);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/threadpool/Printer$TaskPrinter;", "error", "", "key", "", "hash", "", "e", "", "print", "state", "Lcom/tencent/threadpool/State;", "time", "", "costThreadMs", "pool", "isLogging", "", "rejected", "isShutdown", "shutdown", "wait", "runningCount", "waitFor", "plugin-performance_release"})
  public static final class m
    implements d.e
  {
    public final void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
    {
      AppMethodBeat.i(184671);
      p.h(paramString1, "key");
      p.h(paramString2, "pool");
      paramString2 = "[wait] " + paramString1 + '@' + paramInt1 + " runningCount=" + paramInt2 + " waitFor=" + paramLong / 100000L + "ms " + paramString2;
      ad.w("ThreadPool.Profiler", paramString2);
      String str = aj.getProcessName();
      e.ygI.f(18762, new Object[] { Integer.valueOf(a.e.wIP.value), paramString2, paramString1, Integer.valueOf(17), str });
      AppMethodBeat.o(184671);
    }
    
    public final void a(String paramString1, int paramInt, com.tencent.e.f paramf, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(185183);
      p.h(paramString1, "key");
      p.h(paramf, "state");
      p.h(paramString2, "pool");
      int i;
      Object localObject;
      if ((a.c(this.wJg)) && (paramf == com.tencent.e.f.LTG))
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
        a.a locala2 = (a.a)a.d(this.wJg).get(localObject);
        a.a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a.a((String)localObject);
          ((Map)a.d(this.wJg)).put(localObject, locala1);
        }
        p.g(locala1, "batteryRecord[keyRecord]… record\n                }");
        locala1.count += 1;
        if (locala1.count % 2 == 1) {
          locala1.wIM += 1L;
        }
        locala1.wIM += paramLong2;
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
        switch (b.cpQ[paramf.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(185183);
          return;
          if (paramLong1 < 0L) {}
          for (paramLong1 = 0L;; paramLong1 /= 1000000L)
          {
            if (a.c(this.wJg)) {
              ((Map)a.e(this.wJg)).put(paramString1 + '@' + paramInt, new a.b(SystemClock.uptimeMillis() + paramLong1));
            }
            ad.i("ThreadPool.Execute", "=== " + paramString1 + '@' + paramInt + " state=" + paramf + " delay=" + paramLong1 + "ms");
            AppMethodBeat.o(185183);
            return;
          }
          if (a.c(this.wJg))
          {
            localObject = (a.b)a.e(this.wJg).get(paramString1 + '@' + paramInt);
            if (localObject != null) {
              ((a.b)localObject).thread = Thread.currentThread();
            }
            a.e(this.wJg).remove(paramString1 + '@' + paramInt);
          }
          ad.i("ThreadPool.Execute", ">>> " + paramString1 + '@' + paramInt + " state=" + paramf + ' ' + paramString2);
          AppMethodBeat.o(185183);
          return;
          paramf = "<<< " + paramString1 + '@' + paramInt + " state=" + paramf + " cost=" + paramLong1 + "ms/" + paramLong2 + "ms " + paramString2;
          ad.i("ThreadPool.Execute", paramf);
          if ((a.c(this.wJg)) && (paramLong1 >= 600000L))
          {
            paramString2 = aj.getProcessName();
            e.ygI.f(18762, new Object[] { Integer.valueOf(a.e.wIR.value), paramf, paramString1, Integer.valueOf(17), paramString2 });
            AppMethodBeat.o(185183);
            return;
            if (a.c(this.wJg)) {
              a.e(this.wJg).remove(paramString1 + '@' + paramInt);
            }
            ad.i("ThreadPool.Execute", "||| " + paramString1 + '@' + paramInt + " state=" + paramf);
            AppMethodBeat.o(185183);
            return;
            if (a.c(this.wJg)) {
              a.e(this.wJg).remove(paramString1 + '@' + paramInt);
            }
            ad.i("ThreadPool.Execute", "*** " + paramString1 + '@' + paramInt + " state=" + paramf);
          }
        }
      }
    }
    
    public final void a(String paramString, int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(184670);
      p.h(paramString, "key");
      p.h(paramThrowable, "e");
      ad.e("ThreadPool.Profiler", paramString + '@' + paramInt + ' ' + paramThrowable);
      AppMethodBeat.o(184670);
    }
    
    public final void f(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(184672);
      p.h(paramString1, "key");
      p.h(paramString2, "pool");
      paramString2 = "[rejected] " + paramString1 + ' ' + paramString2 + " isShutdown=true";
      ad.w("ThreadPool.Profiler", paramString2);
      if (a.c(this.wJg))
      {
        a.e(this.wJg).remove(paramString1 + '@' + paramInt);
        String str = aj.getProcessName();
        e.ygI.f(18762, new Object[] { Integer.valueOf(a.e.wIQ.value), paramString2, paramString1, Integer.valueOf(17), str });
      }
      AppMethodBeat.o(184672);
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(184673);
      ad.w("ThreadPool.Profiler", "shutdown");
      a.e(this.wJg).clear();
      AppMethodBeat.o(184673);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a
 * JD-Core Version:    0.7.0.1
 */