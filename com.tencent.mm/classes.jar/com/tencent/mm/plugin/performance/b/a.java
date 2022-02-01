package com.tencent.mm.plugin.performance.b;

import android.os.Environment;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Printer;
import com.tencent.e.d.e;
import com.tencent.e.d.f;
import com.tencent.e.g.b;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.l;
import d.n.k;
import d.n.n;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver$IOnScreenshotTakenListener;", "Lcom/tencent/mm/app/IPhoneScreenListener;", "()V", "aboutUITimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "batteryRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$BatteryRecord;", "blowoutCount", "", "checkQueue", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "existThreadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "isNeedReport", "", "lastCheckTime", "", "looperPrepareMonitor", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1;", "mainLooperListener", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1;", "maxBlowoutCount", "methodInfoMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "otherTaskCount", "Ljava/util/concurrent/atomic/AtomicLong;", "otherThreadTime", "otherTime", "runCallback", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1;", "runnableMethodInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "runningCount", "screenShotObserver", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver;", "screenShotObserver2", "screenShotPath", "screenShotPath2", "taskPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1;", "threadPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1;", "timeRecord", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "uiBusyConcurrent", "", "uiTaskCount", "uiThreadTime", "uiTime", "checkExpiredTask", "", "dumpThreadPool", "dumpUIAbout", "getStackTrace", "thread", "Ljava/lang/Thread;", "onAppBackground", "activity", "onAppForeground", "onScreen", "isScreenOff", "onScreenshotTaken", "path", "open", "isProcessMain", "reportStatistics", "BatteryRecord", "CheckInfo", "Companion", "ReportType", "TimeRecord", "plugin-performance_release"})
public final class a
  implements o, com.tencent.mm.app.p, u.a
{
  public static boolean cFS;
  private static final d.f wYv;
  public static final a.c wYw;
  private long lastCheckTime;
  private final HashMap<String, List<Pair<String, String>>> qZN;
  private final AtomicInteger wXV;
  private final AtomicInteger wXW;
  private final ConcurrentHashMap<String, a.b> wXX;
  private final boolean wXY;
  private final ConcurrentHashMap<String, a.a> wXZ;
  private final ConcurrentHashMap<String, a.f> wYa;
  private volatile int wYb;
  private int wYc;
  private AtomicLong wYd;
  private AtomicLong wYe;
  private AtomicLong wYf;
  private AtomicLong wYg;
  private AtomicLong wYh;
  private AtomicLong wYi;
  private int[] wYj;
  public final n wYk;
  public final i wYl;
  public final m wYm;
  private final ArrayList<Pair<String, String>> wYn;
  private final String wYo;
  private final String wYp;
  private final u wYq;
  private final u wYr;
  private final j wYs;
  public final aw wYt;
  private final l wYu;
  
  static
  {
    AppMethodBeat.i(184684);
    wYw = new a.c((byte)0);
    wYv = d.g.O((d.g.a.a)a.d.wYy);
    AppMethodBeat.o(184684);
  }
  
  public a()
  {
    AppMethodBeat.i(184683);
    this.wXV = new AtomicInteger();
    this.wXW = new AtomicInteger();
    this.wXX = new ConcurrentHashMap();
    int i;
    int j;
    if ((com.tencent.mm.protocal.d.FFI) || (com.tencent.mm.protocal.d.FFJ))
    {
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyX, 10);
      j = new Random().nextInt(100000);
      if (i < j) {
        break label577;
      }
    }
    label577:
    for (boolean bool = true;; bool = false)
    {
      ae.i("ThreadPool.Profiler", "[isNeedReport] rand=" + i + " test=" + j + " isEnable=" + bool + " isRelease=" + com.tencent.mm.protocal.d.FFI + " isTest=" + com.tencent.mm.protocal.d.FFJ);
      this.wXY = bool;
      this.wXZ = new ConcurrentHashMap(100);
      this.wYa = new ConcurrentHashMap(100);
      this.wYd = new AtomicLong();
      this.wYe = new AtomicLong();
      this.wYf = new AtomicLong();
      this.wYg = new AtomicLong();
      this.wYh = new AtomicLong();
      this.wYi = new AtomicLong();
      this.wYj = new int[2];
      this.wYk = new n(this);
      this.wYl = new i(this);
      this.wYm = new m(this);
      this.qZN = new HashMap();
      this.wYn = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder();
      File localFile = Environment.getExternalStorageDirectory();
      d.g.b.p.g(localFile, "Environment.getExternalStorageDirectory()");
      this.wYo = (localFile.getPath() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator);
      localStringBuilder = new StringBuilder();
      localFile = Environment.getExternalStorageDirectory();
      d.g.b.p.g(localFile, "Environment.getExternalStorageDirectory()");
      this.wYp = (localFile.getPath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Screenshots" + File.separator);
      this.wYq = new u(this.wYo, (u.a)this);
      this.wYr = new u(this.wYp, (u.a)this);
      this.wYs = new j(this);
      this.wYt = new aw(com.tencent.e.j.a.bbi("ThreadPool.Profiler"), (aw.a)new g(this), true);
      this.wYu = new l(this);
      AppMethodBeat.o(184683);
      return;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyY, 100000);
      break;
    }
  }
  
  private final void dCj()
  {
    AppMethodBeat.i(184681);
    StringBuilder localStringBuilder = new StringBuilder(" \n[RunningTask]\n");
    Object localObject1 = h.MqG.fZS();
    d.g.b.p.g(localObject1, "ThreadPool.PROFILE.dumpRunningTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    Object localObject3;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = localStringBuilder.append("\t").append((String)((Map.Entry)localObject3).getKey()).append(" => ");
      localObject3 = ((Map.Entry)localObject3).getValue();
      d.g.b.p.g(localObject3, "it.value");
      ((StringBuilder)localObject2).append(((Number)localObject3).intValue()).append("\n");
    }
    ae.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    d.g.b.p.g(localStringBuilder, "sb");
    n.h(localStringBuilder);
    localStringBuilder.append(" \n[WaitingTask]\n");
    localObject1 = h.MqG.fZT();
    d.g.b.p.g(localObject1, "ThreadPool.PROFILE.dumpWaitingTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localStringBuilder.append("# ").append((String)((Map.Entry)localObject2).getKey()).append("\n");
      localObject2 = ((Map.Entry)localObject2).getValue();
      d.g.b.p.g(localObject2, "entry.value");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Pair)((Iterator)localObject2).next();
        localObject3 = localStringBuilder.append("\t|* ").append((String)((Pair)localObject4).first).append(" => ");
        localObject4 = ((Pair)localObject4).second;
        d.g.b.p.g(localObject4, "it.second");
        ((StringBuilder)localObject3).append(((Number)localObject4).intValue()).append("\n");
      }
    }
    ae.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    ae.i("ThreadPool.Profiler", "[dumpThreadPool] Alive Thread Count = " + this.wXW.get() + " Global Running Count = " + this.wXV.get() + " maxRunningCount=" + this.wYb);
    dCk();
    AppMethodBeat.o(184681);
  }
  
  private final void dCk()
  {
    AppMethodBeat.i(184682);
    ae.i("ThreadPool.Profiler", "[dumpThreadPool]\n averageUITime=" + (float)this.wYg.get() * 1.0F / (float)this.wYi.get() + " averageUIThreadTime=" + (float)this.wYh.get() * 1.0F / (float)this.wYi.get() + '\n' + "averageOtherTime=" + (float)this.wYd.get() * 1.0F / (float)this.wYf.get() + " averageOtherThreadTime=" + (float)this.wYe.get() * 1.0F / (float)this.wYf.get() + '\n' + "uiTaskCount=" + this.wYi.get() + " otherTaskCount=" + this.wYf.get() + '\n' + "uiBusyConcurrent=" + this.wYj[1] + " averageUIConcurrent=" + this.wYj[0] * 1.0F / this.wYj[1] + " concurrentRadio=" + this.wYj[1] * 1.0F / (float)this.wYi.get());
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
      if ((l - this.lastCheckTime >= 900000L) && (this.wXY))
      {
        localLinkedList = new LinkedList();
        localObject2 = (Map)this.wXX;
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
          if (n.a((CharSequence)localObject1, '@', 0, 6) >= 0)
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
              localObject1 = ((String)localObject1).subSequence(0, n.a((CharSequence)localObject1, '@', 0, 6));
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
      if (n.a((CharSequence)localObject2, '#', 0, 6) >= 0)
      {
        i = 1;
        if (i == 0) {
          break label653;
        }
        localObject2 = (String)localObject2;
        if (localObject2 != null)
        {
          localObject3 = ((String)localObject2).subSequence(0, n.a((CharSequence)localObject2, '#', 0, 6));
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = (CharSequence)((Map.Entry)localObject5).getKey();
        }
        localObject2 = com.tencent.e.j.a.bbj(localObject2.toString());
        if (localObject2 == null) {
          break label659;
        }
        localObject2 = ((com.tencent.e.j.a)localObject2).gav();
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
        ae.e("ThreadPool.Profiler", (String)localObject3);
        if (localObject2 != null) {
          break label682;
        }
        i = 0;
      }
      for (;;)
      {
        e.ywz.f(18762, new Object[] { Integer.valueOf(e.wYz.value), localObject3, localObject1, Integer.valueOf(17), ak.getProcessName(), Integer.valueOf(i) });
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
      localObject1 = com.tencent.e.b.Mqd;
      d.g.b.p.g(localObject1, "ForkThreadPoolExecutor.sGlobalForkThreadPool");
      localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (com.tencent.e.b)((WeakReference)((Iterator)localObject3).next()).get();
        if (localObject5 != null)
        {
          localObject4 = ((com.tencent.e.b)localObject5).getName();
          int j = (int)((com.tencent.e.b)localObject5).getCompletedTaskCount();
          int k = ((com.tencent.e.b)localObject5).getQueue().size();
          localObject2 = (a.b)this.wXX.get(localObject4);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new a.b(SystemClock.uptimeMillis(), 1);
            localObject2 = (Map)this.wXX;
            d.g.b.p.g(localObject4, "key");
            ((Map)localObject2).put(localObject4, localObject1);
          }
          d.g.b.p.g(localObject1, "checkQueue[key] ?: run {…eckInfo\n                }");
          int m = ((a.b)localObject1).count;
          if ((j > 0) && (k > 0) && (j - m == 0) && (SystemClock.uptimeMillis() - ((a.b)localObject1).time >= 60000L))
          {
            localObject2 = "[ForkThreadPoolExecutor] " + (String)localObject4 + " has expired " + (SystemClock.uptimeMillis() - ((a.b)localObject1).time) + "ms " + localObject5;
            ae.e("ThreadPool.Profiler", (String)localObject2);
            e.ywz.f(18762, new Object[] { Integer.valueOf(e.wYz.value), localObject2, localObject4, Integer.valueOf(17), ak.getProcessName() });
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
        dCj();
      }
      localObject1 = ((Iterable)localLinkedList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.wXX.remove(localObject2);
      }
      try
      {
        if (this.wXZ.values().size() > 1)
        {
          localObject1 = this.wXZ.values();
          d.g.b.p.g(localObject1, "batteryRecord.values");
          localObject1 = (Iterable)d.a.j.a((Iterable)localObject1, (Comparator)new a.h()).subList(0, d.k.j.lx(30, this.wXZ.values().size() - 1));
          i = 0;
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              d.a.j.gkd();
            }
            localObject2 = (a.a)localObject2;
            ae.i("ThreadPool.Profiler", "[batteryRecord]#" + i + ' ' + localObject2);
            e.ywz.f(18883, new Object[] { Integer.valueOf(17), Integer.valueOf(e.wYN.value), Long.valueOf(((a.a)localObject2).wYx), ak.getProcessName(), ((a.a)localObject2).name, Integer.valueOf(((a.a)localObject2).count) });
            i += 1;
          }
          this.wXZ.clear();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("ThreadPool.Profiler", (Throwable)localException, "", new Object[0]);
        }
      }
      this.lastCheckTime = l;
      AppMethodBeat.o(184677);
      return;
    }
  }
  
  public final void dCi()
  {
    AppMethodBeat.i(184680);
    if (!cFS)
    {
      AppMethodBeat.o(184680);
      return;
    }
    com.tencent.mm.ac.b localb = new com.tencent.mm.ac.b("ThreadPool.Profiler#onScreenshotTaken");
    dCj();
    localb.ald();
    AppMethodBeat.o(184680);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(184679);
    if (!cFS)
    {
      AppMethodBeat.o(184679);
      return;
    }
    this.wYq.stopWatching();
    this.wYr.stopWatching();
    AppMethodBeat.o(184679);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(184678);
    if (!cFS)
    {
      AppMethodBeat.o(184678);
      return;
    }
    this.wYq.startWatching();
    this.wYr.startWatching();
    AppMethodBeat.o(184678);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$ReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_EXPIRED", "TYPE_CONTROL", "TYPE_REJECT", "TYPE_TIMEOUT", "TYPE_STATISTICS_COUNT_BLOWOUT", "TYPE_STATISTICS_UI_TIME", "TYPE_STATISTICS_UI_THREAD_TIME", "TYPE_STATISTICS_UI_TIME_RADIO", "TYPE_STATISTICS_OTHER_TIME", "TYPE_STATISTICS_OTHER_THREAD_TIME", "TYPE_STATISTICS_OTHER_TIME_RADIO", "TYPE_STATISTICS_THREAD_COUNT", "TYPE_STATISTICS_UI_OTHER_AVERAGE", "TYPE_STATISTICS_MAX_COUNT_BLOWOUT", "TYPE_STATISTICS_TASK_THREAD_TIME", "TYPE_LOOPER_PREPARE", "plugin-performance_release"})
  public static enum e
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(184657);
      e locale1 = new e("TYPE_EXPIRED", 0, 1);
      wYz = locale1;
      e locale2 = new e("TYPE_CONTROL", 1, 2);
      wYA = locale2;
      e locale3 = new e("TYPE_REJECT", 2, 3);
      wYB = locale3;
      e locale4 = new e("TYPE_TIMEOUT", 3, 4);
      wYC = locale4;
      e locale5 = new e("TYPE_STATISTICS_COUNT_BLOWOUT", 4, 5);
      wYD = locale5;
      e locale6 = new e("TYPE_STATISTICS_UI_TIME", 5, 6);
      wYE = locale6;
      e locale7 = new e("TYPE_STATISTICS_UI_THREAD_TIME", 6, 7);
      wYF = locale7;
      e locale8 = new e("TYPE_STATISTICS_UI_TIME_RADIO", 7, 8);
      wYG = locale8;
      e locale9 = new e("TYPE_STATISTICS_OTHER_TIME", 8, 9);
      wYH = locale9;
      e locale10 = new e("TYPE_STATISTICS_OTHER_THREAD_TIME", 9, 10);
      wYI = locale10;
      e locale11 = new e("TYPE_STATISTICS_OTHER_TIME_RADIO", 10, 11);
      wYJ = locale11;
      e locale12 = new e("TYPE_STATISTICS_THREAD_COUNT", 11, 12);
      wYK = locale12;
      e locale13 = new e("TYPE_STATISTICS_UI_OTHER_AVERAGE", 12, 13);
      wYL = locale13;
      e locale14 = new e("TYPE_STATISTICS_MAX_COUNT_BLOWOUT", 13, 14);
      wYM = locale14;
      e locale15 = new e("TYPE_STATISTICS_TASK_THREAD_TIME", 14, 15);
      wYN = locale15;
      e locale16 = new e("TYPE_LOOPER_PREPARE", 15, 16);
      wYO = locale16;
      wYP = new e[] { locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8, locale9, locale10, locale11, locale12, locale13, locale14, locale15, locale16 };
      AppMethodBeat.o(184657);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class g
    implements aw.a
  {
    g(a parama) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(184662);
      a.k(this.wYR);
      AppMethodBeat.o(184662);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/threadpool/ThreadModuleBoot$ILooperPrepareMonitor;", "isResetLooper", "", "()Z", "reportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "isHookResetLooper", "isOpenCheck", "isThrowException", "onLooperPreparedAtTask", "", "thread", "Ljava/lang/Thread;", "task", "plugin-performance_release"})
  public static final class i
    implements g.b
  {
    private final boolean wYS;
    private final ConcurrentHashMap<String, String> wYT;
    
    i()
    {
      AppMethodBeat.i(215488);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyZ, true);
      ae.w("ThreadPool.Profiler", "[isHookResetLooper] ".concat(String.valueOf(bool)));
      this.wYS = bool;
      this.wYT = new ConcurrentHashMap();
      AppMethodBeat.o(215488);
    }
    
    public final void a(Thread paramThread, String paramString)
    {
      AppMethodBeat.i(215487);
      d.g.b.p.h(paramThread, "thread");
      d.g.b.p.h(paramString, "task");
      if (a.c(this.wYR))
      {
        Object localObject = (CharSequence)paramString;
        localObject = new k("[0-9]\\d*").e((CharSequence)localObject, "?");
        if (!this.wYT.contains(localObject))
        {
          String str = "task=" + (String)localObject + ' ' + paramThread;
          ae.w("ThreadPool.Profiler", "[onLooperPreparedAtTask] ".concat(String.valueOf(str)));
          e.ywz.f(18762, new Object[] { Integer.valueOf(a.e.wYO.value), str, paramString, Integer.valueOf(17), ak.getProcessName() });
          ((Map)this.wYT).put(localObject, String.valueOf(paramThread));
        }
      }
      AppMethodBeat.o(215487);
    }
    
    public final boolean dCm()
    {
      return true;
    }
    
    public final boolean dCn()
    {
      return this.wYS;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Landroid/util/Printer;", "record", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "getRecord", "()Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "setRecord", "(Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;)V", "onDispatchEnd", "", "x", "", "onDispatchStart", "println", "plugin-performance_release"})
  public static final class j
    implements Printer
  {
    private a.f wYU;
    
    j()
    {
      AppMethodBeat.i(184664);
      this.wYU = new a.f(true, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte)0);
      AppMethodBeat.o(184664);
    }
    
    public final void println(String paramString)
    {
      AppMethodBeat.i(184663);
      d.g.b.p.h(paramString, "x");
      if (paramString.charAt(0) == '>')
      {
        d.g.b.p.h(paramString, "x");
        this.wYU.time = SystemClock.uptimeMillis();
        this.wYU.wYx = SystemClock.currentThreadTimeMillis();
        int i = a.f(this.wYR).get();
        if (i > 0)
        {
          paramString = a.g(this.wYR);
          paramString[0] = (i + paramString[0]);
          paramString = a.g(this.wYR);
          paramString[1] += 1;
        }
        AppMethodBeat.o(184663);
        return;
      }
      if (paramString.charAt(0) == '<')
      {
        d.g.b.p.h(paramString, "x");
        paramString = this.wYU;
        long l1 = SystemClock.uptimeMillis();
        long l2 = paramString.time;
        long l3 = SystemClock.currentThreadTimeMillis();
        long l4 = paramString.wYx;
        a.h(this.wYR).addAndGet(l1 - l2);
        a.i(this.wYR).addAndGet(l3 - l4);
        a.j(this.wYR).incrementAndGet();
      }
      AppMethodBeat.o(184663);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$open$1", "Ljava/lang/Runnable;", "run", "", "plugin-performance_release"})
  public static final class k
    implements Runnable
  {
    public k(aq paramaq) {}
    
    public final void run()
    {
      AppMethodBeat.i(184665);
      a.a(this.wYR);
      this.wYV.postDelayed((Runnable)this, 1800000L);
      AppMethodBeat.o(184665);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mainThreadId", "", "getMainThreadId", "()J", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-performance_release"})
  public static final class l
    implements com.tencent.mm.hellhoundlib.a.c
  {
    private final long wYW;
    
    l()
    {
      AppMethodBeat.i(184668);
      Object localObject = Looper.getMainLooper();
      d.g.b.p.g(localObject, "Looper.getMainLooper()");
      localObject = ((Looper)localObject).getThread();
      d.g.b.p.g(localObject, "Looper.getMainLooper().thread");
      this.wYW = ((Thread)localObject).getId();
      AppMethodBeat.o(184668);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(215489);
      d.g.b.p.h(paramString1, "className");
      a.f(this.wYR).decrementAndGet();
      long l1 = this.wYW;
      paramString2 = Thread.currentThread();
      d.g.b.p.g(paramString2, "Thread.currentThread()");
      if (l1 != paramString2.getId())
      {
        paramString2 = a.n(this.wYR);
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
          long l4 = paramString1.wYx;
          a.o(this.wYR).addAndGet(l3 - l4);
          a.p(this.wYR).addAndGet(l1 - l2);
          a.q(this.wYR).incrementAndGet();
          AppMethodBeat.o(215489);
          return;
        }
      }
      AppMethodBeat.o(215489);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184666);
      d.g.b.p.h(paramString1, "className");
      int i = a.f(this.wYR).incrementAndGet();
      if (i > a.l(this.wYR)) {
        a.a(this.wYR, i);
      }
      paramString2 = a.wYw;
      paramString2 = a.dCl();
      paramString3 = a.wYw;
      if (i > ((Number)paramString2.getValue()).intValue())
      {
        paramString2 = this.wYR;
        a.b(paramString2, a.m(paramString2) + 1);
      }
      long l = this.wYW;
      paramString2 = Thread.currentThread();
      d.g.b.p.g(paramString2, "Thread.currentThread()");
      if (l != paramString2.getId())
      {
        paramString2 = (Map)a.n(this.wYR);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/threadpool/Printer$TaskPrinter;", "error", "", "key", "", "hash", "", "e", "", "print", "state", "Lcom/tencent/threadpool/State;", "time", "", "costThreadMs", "pool", "isLogging", "", "rejected", "isShutdown", "shutdown", "wait", "runningCount", "waitFor", "plugin-performance_release"})
  public static final class m
    implements d.e
  {
    public final void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
    {
      AppMethodBeat.i(184671);
      d.g.b.p.h(paramString1, "key");
      d.g.b.p.h(paramString2, "pool");
      paramString2 = "[wait] " + paramString1 + '@' + paramInt1 + " runningCount=" + paramInt2 + " waitFor=" + paramLong / 100000L + "ms " + paramString2;
      ae.w("ThreadPool.Profiler", paramString2);
      String str = ak.getProcessName();
      e.ywz.f(18762, new Object[] { Integer.valueOf(a.e.wYA.value), paramString2, paramString1, Integer.valueOf(17), str });
      AppMethodBeat.o(184671);
    }
    
    public final void a(String paramString1, int paramInt, com.tencent.e.f paramf, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(185183);
      d.g.b.p.h(paramString1, "key");
      d.g.b.p.h(paramf, "state");
      d.g.b.p.h(paramString2, "pool");
      int i;
      Object localObject;
      if ((a.c(this.wYR)) && (paramf == com.tencent.e.f.MqC))
      {
        if (n.a((CharSequence)paramString1, '@', 0, 6) < 0) {
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
          localObject = ((String)localObject).subSequence(0, n.a((CharSequence)localObject, '@', 0, 6)).toString();
          if (localObject != null) {
            break label905;
          }
        }
        localObject = paramString1;
      }
      label905:
      for (;;)
      {
        a.a locala2 = (a.a)a.d(this.wYR).get(localObject);
        a.a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a.a((String)localObject);
          ((Map)a.d(this.wYR)).put(localObject, locala1);
        }
        d.g.b.p.g(locala1, "batteryRecord[keyRecord]… record\n                }");
        locala1.count += 1;
        if (locala1.count % 2 == 1) {
          locala1.wYx += 1L;
        }
        locala1.wYx += paramLong2;
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
        switch (b.cqt[paramf.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(185183);
          return;
          if (paramLong1 < 0L) {}
          for (paramLong1 = 0L;; paramLong1 /= 1000000L)
          {
            if (a.c(this.wYR)) {
              ((Map)a.e(this.wYR)).put(paramString1 + '@' + paramInt, new a.b(SystemClock.uptimeMillis() + paramLong1));
            }
            ae.i("ThreadPool.Execute", "=== " + paramString1 + '@' + paramInt + " state=" + paramf + " delay=" + paramLong1 + "ms");
            AppMethodBeat.o(185183);
            return;
          }
          if (a.c(this.wYR))
          {
            localObject = (a.b)a.e(this.wYR).get(paramString1 + '@' + paramInt);
            if (localObject != null) {
              ((a.b)localObject).thread = Thread.currentThread();
            }
            a.e(this.wYR).remove(paramString1 + '@' + paramInt);
          }
          ae.i("ThreadPool.Execute", ">>> " + paramString1 + '@' + paramInt + " state=" + paramf + ' ' + paramString2);
          AppMethodBeat.o(185183);
          return;
          paramf = "<<< " + paramString1 + '@' + paramInt + " state=" + paramf + " cost=" + paramLong1 + "ms/" + paramLong2 + "ms " + paramString2;
          ae.i("ThreadPool.Execute", paramf);
          if ((a.c(this.wYR)) && (paramLong1 >= 600000L))
          {
            paramString2 = ak.getProcessName();
            e.ywz.f(18762, new Object[] { Integer.valueOf(a.e.wYC.value), paramf, paramString1, Integer.valueOf(17), paramString2 });
            AppMethodBeat.o(185183);
            return;
            if (a.c(this.wYR)) {
              a.e(this.wYR).remove(paramString1 + '@' + paramInt);
            }
            ae.i("ThreadPool.Execute", "||| " + paramString1 + '@' + paramInt + " state=" + paramf);
            AppMethodBeat.o(185183);
            return;
            if (a.c(this.wYR)) {
              a.e(this.wYR).remove(paramString1 + '@' + paramInt);
            }
            ae.i("ThreadPool.Execute", "*** " + paramString1 + '@' + paramInt + " state=" + paramf);
          }
        }
      }
    }
    
    public final void a(String paramString, int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(184670);
      d.g.b.p.h(paramString, "key");
      d.g.b.p.h(paramThrowable, "e");
      ae.e("ThreadPool.Profiler", paramString + '@' + paramInt + ' ' + paramThrowable);
      AppMethodBeat.o(184670);
    }
    
    public final void f(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(184672);
      d.g.b.p.h(paramString1, "key");
      d.g.b.p.h(paramString2, "pool");
      paramString2 = "[rejected] " + paramString1 + ' ' + paramString2 + " isShutdown=true";
      ae.w("ThreadPool.Profiler", paramString2);
      if (a.c(this.wYR))
      {
        a.e(this.wYR).remove(paramString1 + '@' + paramInt);
        String str = ak.getProcessName();
        e.ywz.f(18762, new Object[] { Integer.valueOf(a.e.wYB.value), paramString2, paramString1, Integer.valueOf(17), str });
      }
      AppMethodBeat.o(184672);
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(184673);
      ae.w("ThreadPool.Profiler", "shutdown");
      a.e(this.wYR).clear();
      AppMethodBeat.o(184673);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/threadpool/Printer$ThreadPrinter;", "onExit", "", "thread", "Ljava/lang/Thread;", "name", "", "id", "", "onInterrupt", "onStart", "plugin-performance_release"})
  public static final class n
    implements d.f
  {
    public final void a(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184674);
      d.g.b.p.h(paramThread, "thread");
      d.g.b.p.h(paramString, "name");
      ae.i("ThreadPool.Profiler", "[onInterrupt] name=" + paramString + " id=" + paramLong);
      AppMethodBeat.o(184674);
    }
    
    public final void b(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184675);
      d.g.b.p.h(paramThread, "thread");
      d.g.b.p.h(paramString, "name");
      ae.i("ThreadPool.Profiler", "[onThreadStart] name=" + paramString + " id=" + paramLong);
      a.b(this.wYR).incrementAndGet();
      AppMethodBeat.o(184675);
    }
    
    public final void c(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184676);
      d.g.b.p.h(paramThread, "thread");
      d.g.b.p.h(paramString, "name");
      ae.i("ThreadPool.Profiler", "[onThreadExit] name=" + paramString + " id=" + paramLong);
      a.b(this.wYR).decrementAndGet();
      AppMethodBeat.o(184676);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a
 * JD-Core Version:    0.7.0.1
 */