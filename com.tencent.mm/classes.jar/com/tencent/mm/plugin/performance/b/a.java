package com.tencent.mm.plugin.performance.b;

import android.os.Environment;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q;
import com.tencent.mm.app.r;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.model.ab;
import com.tencent.mm.pluginsdk.model.ab.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.threadpool.b;
import com.tencent.threadpool.d.e;
import com.tencent.threadpool.d.f;
import com.tencent.threadpool.g.b;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver$IOnScreenshotTakenListener;", "Lcom/tencent/mm/app/IPhoneScreenListener;", "()V", "aboutUITimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "batteryRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$BatteryRecord;", "blowoutCount", "", "checkQueue", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "existThreadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "isNeedReport", "", "lastCheckTime", "", "lastDumpTime", "looperPrepareMonitor", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1;", "mainLooperListener", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1;", "mapOfRunningTasks", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TaskStatusInfo;", "maxBlowoutCount", "methodInfoMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "otherTaskCount", "Ljava/util/concurrent/atomic/AtomicLong;", "otherThreadTime", "otherTime", "runCallback", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1;", "runnableMethodInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "runningCount", "screenShotObserver", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver;", "screenShotObserver2", "screenShotPath", "screenShotPath2", "taskPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1;", "threadPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1;", "timeRecord", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "uiBusyConcurrent", "", "uiTaskCount", "uiThreadTime", "uiTime", "checkExpiredTask", "", "dumpRunningTasks", "dumpThreadPool", "dumpUIAbout", "getStackTrace", "thread", "Ljava/lang/Thread;", "onAppBackground", "activity", "onAppForeground", "onScreen", "isScreenOff", "onScreenshotTaken", "path", "open", "isProcessMain", "reportStatistics", "BatteryRecord", "CheckInfo", "Companion", "ReportType", "TaskStatusInfo", "TimeRecord", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements q, r, ab.a
{
  public static final a.c MLE;
  private static final j<Integer> MMf;
  public static boolean eYL;
  private long GgE;
  private final ConcurrentHashMap<String, a.g> Gln;
  private final AtomicInteger MLF;
  private final AtomicInteger MLG;
  private final ConcurrentHashMap<String, a.b> MLH;
  private final boolean MLI;
  private final ConcurrentHashMap<String, a.f> MLJ;
  private final ConcurrentHashMap<String, a.a> MLK;
  private volatile int MLL;
  private int MLM;
  private AtomicLong MLN;
  private AtomicLong MLO;
  private AtomicLong MLP;
  private AtomicLong MLQ;
  private AtomicLong MLR;
  private AtomicLong MLS;
  private int[] MLT;
  public final n MLU;
  public final i MLV;
  public final m MLW;
  private final ArrayList<Pair<String, String>> MLX;
  private final String MLY;
  private final String MLZ;
  private final ab MMa;
  private final ab MMb;
  private final j MMc;
  public final MTimerHandler MMd;
  private final l MMe;
  private long lastCheckTime;
  private final HashMap<String, List<Pair<String, String>>> zCa;
  
  static
  {
    AppMethodBeat.i(184684);
    MLE = new a.c((byte)0);
    MMf = kotlin.k.cm((kotlin.g.a.a)d.MMh);
    AppMethodBeat.o(184684);
  }
  
  public a()
  {
    AppMethodBeat.i(184683);
    this.MLF = new AtomicInteger();
    this.MLG = new AtomicInteger();
    this.MLH = new ConcurrentHashMap();
    int i;
    int j;
    if ((com.tencent.mm.protocal.d.Yxi) || (com.tencent.mm.protocal.d.Yxj))
    {
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLa, 10);
      j = new Random().nextInt(100000);
      if (i < j) {
        break label557;
      }
    }
    label557:
    for (boolean bool = true;; bool = false)
    {
      Log.i("ThreadPool.Profiler", "[isNeedReport] rand=" + i + " test=" + j + " isEnable=" + bool + " isRelease=" + com.tencent.mm.protocal.d.Yxi + " isTest=" + com.tencent.mm.protocal.d.Yxj);
      this.MLI = bool;
      this.MLJ = new ConcurrentHashMap();
      this.MLK = new ConcurrentHashMap(100);
      this.Gln = new ConcurrentHashMap(100);
      this.MLN = new AtomicLong();
      this.MLO = new AtomicLong();
      this.MLP = new AtomicLong();
      this.MLQ = new AtomicLong();
      this.MLR = new AtomicLong();
      this.MLS = new AtomicLong();
      this.MLT = new int[2];
      this.MLU = new n(this);
      this.MLV = new i(this);
      this.MLW = new m(this);
      this.zCa = new HashMap();
      this.MLX = new ArrayList();
      this.MLY = (Environment.getExternalStorageDirectory().getPath() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator);
      this.MLZ = (Environment.getExternalStorageDirectory().getPath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Screenshots" + File.separator);
      this.MMa = new ab(this.MLY, (ab.a)this);
      this.MMb = new ab(this.MLZ, (ab.a)this);
      this.MMc = new j(this);
      this.MMd = new MTimerHandler(com.tencent.threadpool.j.a.bFV("ThreadPool.Profiler"), new a..ExternalSyntheticLambda0(this), true);
      this.MMe = new l(this);
      AppMethodBeat.o(184683);
      return;
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLb, 100000);
      break;
    }
  }
  
  private static final boolean a(a parama)
  {
    AppMethodBeat.i(300856);
    s.u(parama, "this$0");
    parama.gzi();
    AppMethodBeat.o(300856);
    return true;
  }
  
  private final void gzh()
  {
    AppMethodBeat.i(184681);
    StringBuilder localStringBuilder = new StringBuilder(" \n[RunningTask]\n");
    Object localObject1 = com.tencent.threadpool.h.ahAB.jYS();
    s.s(localObject1, "PROFILE.dumpRunningTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    Object localObject3;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = localStringBuilder.append("\t").append((String)((Map.Entry)localObject3).getKey()).append(" => ");
      localObject3 = ((Map.Entry)localObject3).getValue();
      s.s(localObject3, "it.value");
      ((StringBuilder)localObject2).append(((Number)localObject3).intValue()).append("\n");
    }
    Log.i("ThreadPool.Profiler", s.X("[dumpThreadPool] ", localStringBuilder));
    s.s(localStringBuilder, "sb");
    n.i(localStringBuilder);
    localStringBuilder.append(" \n[WaitingTask]\n");
    localObject1 = com.tencent.threadpool.h.ahAB.jYT();
    s.s(localObject1, "PROFILE.dumpWaitingTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localStringBuilder.append("# ").append((String)((Map.Entry)localObject2).getKey()).append("\n");
      localObject2 = ((Map.Entry)localObject2).getValue();
      s.s(localObject2, "entry.value");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Pair)((Iterator)localObject2).next();
        localObject3 = localStringBuilder.append("\t|* ").append((String)((Pair)localObject4).first).append(" => ");
        localObject4 = ((Pair)localObject4).second;
        s.s(localObject4, "it.second");
        ((StringBuilder)localObject3).append(((Number)localObject4).intValue()).append("\n");
      }
    }
    Log.i("ThreadPool.Profiler", s.X("[dumpThreadPool] ", localStringBuilder));
    Log.i("ThreadPool.Profiler", "[dumpThreadPool] Alive Thread Count = " + this.MLG.get() + " Global Running Count = " + this.MLF.get() + " maxRunningCount=" + this.MLL);
    gzi();
    AppMethodBeat.o(184681);
  }
  
  private final void gzi()
  {
    AppMethodBeat.i(184682);
    Log.i("ThreadPool.Profiler", "[dumpThreadPool]\n averageUITime=" + (float)this.MLQ.get() * 1.0F / (float)this.MLS.get() + " averageUIThreadTime=" + (float)this.MLR.get() * 1.0F / (float)this.MLS.get() + "\naverageOtherTime=" + (float)this.MLN.get() * 1.0F / (float)this.MLP.get() + " averageOtherThreadTime=" + (float)this.MLO.get() * 1.0F / (float)this.MLP.get() + "\nuiTaskCount=" + this.MLS.get() + " otherTaskCount=" + this.MLP.get() + "\nuiBusyConcurrent=" + this.MLT[1] + " averageUIConcurrent=" + this.MLT[0] * 1.0F / this.MLT[1] + " concurrentRadio=" + this.MLT[1] * 1.0F / (float)this.MLS.get());
    AppMethodBeat.o(184682);
  }
  
  public final void gzf()
  {
    AppMethodBeat.i(184680);
    if (!eYL)
    {
      AppMethodBeat.o(184680);
      return;
    }
    com.tencent.mm.ae.c localc = new com.tencent.mm.ae.c("ThreadPool.Profiler#onScreenshotTaken");
    gzh();
    localc.bbW();
    AppMethodBeat.o(184680);
  }
  
  public final void gzg()
  {
    AppMethodBeat.i(300967);
    long l = SystemClock.uptimeMillis();
    if (l - this.GgE < 300000L)
    {
      AppMethodBeat.o(300967);
      return;
    }
    this.MLW.gzg();
    this.GgE = l;
    AppMethodBeat.o(300967);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(184679);
    if (!eYL)
    {
      AppMethodBeat.o(184679);
      return;
    }
    this.MMa.stopWatching();
    this.MMb.stopWatching();
    AppMethodBeat.o(184679);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(184678);
    if (!eYL)
    {
      AppMethodBeat.o(184678);
      return;
    }
    this.MMa.startWatching();
    this.MMb.startWatching();
    AppMethodBeat.o(184678);
  }
  
  public final void onScreen(boolean paramBoolean)
  {
    AppMethodBeat.i(184677);
    long l;
    LinkedList localLinkedList;
    Object localObject2;
    Object localObject1;
    int i;
    if (!paramBoolean)
    {
      l = SystemClock.uptimeMillis();
      if ((l - this.lastCheckTime >= 900000L) && (this.MLI))
      {
        localLinkedList = new LinkedList();
        localObject2 = (Map)this.MLH;
        localObject1 = (Map)new LinkedHashMap();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        label176:
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
        Object localObject4 = ((Map)localObject1).entrySet().iterator();
        i = 0;
        Object localObject5;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject4).next();
          localObject1 = ((Map.Entry)localObject5).getKey();
          if (n.a((CharSequence)localObject1, '@', 0, false, 6) >= 0)
          {
            i = 1;
            label247:
            if (i == 0) {
              break label591;
            }
            label251:
            localObject1 = (String)localObject1;
            if (localObject1 != null) {
              break label597;
            }
            localObject1 = null;
            label266:
            if (localObject1 != null) {
              break label622;
            }
            localObject2 = (CharSequence)((Map.Entry)localObject5).getKey();
            label286:
            localObject1 = ((Map.Entry)localObject5).getKey();
            if (n.a((CharSequence)localObject1, '#', 0, false, 6) < 0) {
              break label629;
            }
            i = 1;
            label317:
            if (i == 0) {
              break label634;
            }
            label321:
            localObject1 = (String)localObject1;
            if (localObject1 != null) {
              break label640;
            }
            localObject1 = null;
            label336:
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = (CharSequence)((Map.Entry)localObject5).getKey();
            }
            localObject1 = com.tencent.threadpool.j.a.bFW(localObject3.toString());
            if (localObject1 != null) {
              break label665;
            }
            localObject1 = null;
            label378:
            StringBuilder localStringBuilder = new StringBuilder().append((String)((Map.Entry)localObject5).getKey()).append(" has expired ").append(SystemClock.uptimeMillis() - ((a.b)((Map.Entry)localObject5).getValue()).time).append("ms size=");
            if (localObject1 != null) {
              break label675;
            }
            localObject3 = null;
            label440:
            localObject3 = localStringBuilder.append(localObject3).append(" queue is null=");
            if (localObject1 != null) {
              break label700;
            }
            paramBoolean = true;
            label462:
            localStringBuilder = ((StringBuilder)localObject3).append(paramBoolean).append(" isRunning=");
            if (localObject1 != null) {
              break label705;
            }
            localObject3 = null;
            label484:
            localObject3 = localObject3;
            Log.e("ThreadPool.Profiler", (String)localObject3);
            if (localObject1 != null) {
              break label718;
            }
            i = 0;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.f.Ozc.b(18762, new Object[] { Integer.valueOf(e.MMi.value), localObject3, localObject2, Integer.valueOf(17), MMApplicationContext.getProcessName(), Integer.valueOf(i) });
            localLinkedList.add(((Map.Entry)localObject5).getKey());
            i = 1;
            break;
            i = 0;
            break label247;
            label591:
            localObject1 = null;
            break label251;
            label597:
            localObject1 = ((String)localObject1).subSequence(0, n.a((CharSequence)localObject1, '@', 0, false, 6));
            break label266;
            label622:
            localObject2 = localObject1;
            break label286;
            label629:
            i = 0;
            break label317;
            label634:
            localObject1 = null;
            break label321;
            label640:
            localObject1 = ((String)localObject1).subSequence(0, n.a((CharSequence)localObject1, '#', 0, false, 6));
            break label336;
            label665:
            localObject1 = ((com.tencent.threadpool.j.a)localObject1).ahCy;
            break label378;
            label675:
            localObject3 = Integer.valueOf(((com.tencent.threadpool.j.d)localObject1).ahCJ.size() + ((com.tencent.threadpool.j.d)localObject1).ahCI.size());
            break label440;
            label700:
            paramBoolean = false;
            break label462;
            label705:
            localObject3 = Boolean.valueOf(((com.tencent.threadpool.j.d)localObject1).Uz);
            break label484;
            label718:
            if (((com.tencent.threadpool.j.d)localObject1).Uz) {
              i = 2;
            } else {
              i = 1;
            }
          }
        }
        localObject1 = b.ahzY;
        s.s(localObject1, "sGlobalForkThreadPool");
        Object localObject3 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject5 = (b)((WeakReference)((Iterator)localObject3).next()).get();
          if (localObject5 == null) {
            break label1402;
          }
          localObject4 = ((b)localObject5).name;
          int j = (int)((b)localObject5).jYQ();
          int k = ((b)localObject5).ahzZ.size();
          localObject2 = (a.b)this.MLH.get(localObject4);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new a.b(SystemClock.uptimeMillis(), 1);
            localObject2 = (Map)this.MLH;
            s.s(localObject4, "key");
            ((Map)localObject2).put(localObject4, localObject1);
          }
          int m = ((a.b)localObject1).count;
          if ((j > 0) && (k > 0) && (j - m == 0) && (SystemClock.uptimeMillis() - ((a.b)localObject1).time >= 60000L))
          {
            localObject2 = "[ForkThreadPoolExecutor] " + localObject4 + " has expired " + (SystemClock.uptimeMillis() - ((a.b)localObject1).time) + "ms " + localObject5;
            Log.e("ThreadPool.Profiler", (String)localObject2);
            com.tencent.mm.plugin.report.f.Ozc.b(18762, new Object[] { Integer.valueOf(e.MMi.value), localObject2, localObject4, Integer.valueOf(17), MMApplicationContext.getProcessName() });
            localLinkedList.add(localObject4);
            i = 1;
            label1040:
            ((a.b)localObject1).count = j;
            localObject1 = ah.aiuX;
          }
        }
      }
    }
    label1402:
    for (;;)
    {
      break;
      ((a.b)localObject1).time = SystemClock.uptimeMillis();
      break label1040;
      if (i != 0) {
        gzh();
      }
      localObject1 = ((Iterable)localLinkedList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.MLH.remove(localObject2);
      }
      try
      {
        if (this.MLK.values().size() > 1)
        {
          localObject1 = this.MLK.values();
          s.s(localObject1, "batteryRecord.values");
          localObject1 = (Iterable)p.a((Iterable)localObject1, (Comparator)new a.h()).subList(0, kotlin.k.k.qv(30, this.MLK.values().size() - 1));
          i = 0;
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              p.kkW();
            }
            localObject2 = (a.a)localObject2;
            Log.i("ThreadPool.Profiler", "[batteryRecord]#" + i + ' ' + localObject2);
            com.tencent.mm.plugin.report.f.Ozc.b(18883, new Object[] { Integer.valueOf(17), Integer.valueOf(e.MMw.value), Long.valueOf(((a.a)localObject2).MMg), MMApplicationContext.getProcessName(), ((a.a)localObject2).name, Integer.valueOf(((a.a)localObject2).count) });
            i += 1;
          }
          this.MLK.clear();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("ThreadPool.Profiler", (Throwable)localException, "", new Object[0]);
        }
      }
      this.lastCheckTime = l;
      gzg();
      AppMethodBeat.o(184677);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final d MMh;
    
    static
    {
      AppMethodBeat.i(184654);
      MMh = new d();
      AppMethodBeat.o(184654);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$ReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_EXPIRED", "TYPE_CONTROL", "TYPE_REJECT", "TYPE_TIMEOUT", "TYPE_STATISTICS_COUNT_BLOWOUT", "TYPE_STATISTICS_UI_TIME", "TYPE_STATISTICS_UI_THREAD_TIME", "TYPE_STATISTICS_UI_TIME_RADIO", "TYPE_STATISTICS_OTHER_TIME", "TYPE_STATISTICS_OTHER_THREAD_TIME", "TYPE_STATISTICS_OTHER_TIME_RADIO", "TYPE_STATISTICS_THREAD_COUNT", "TYPE_STATISTICS_UI_OTHER_AVERAGE", "TYPE_STATISTICS_MAX_COUNT_BLOWOUT", "TYPE_STATISTICS_TASK_THREAD_TIME", "TYPE_LOOPER_PREPARE", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum e
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(184657);
      MMi = new e("TYPE_EXPIRED", 0, 1);
      MMj = new e("TYPE_CONTROL", 1, 2);
      MMk = new e("TYPE_REJECT", 2, 3);
      MMl = new e("TYPE_TIMEOUT", 3, 4);
      MMm = new e("TYPE_STATISTICS_COUNT_BLOWOUT", 4, 5);
      MMn = new e("TYPE_STATISTICS_UI_TIME", 5, 6);
      MMo = new e("TYPE_STATISTICS_UI_THREAD_TIME", 6, 7);
      MMp = new e("TYPE_STATISTICS_UI_TIME_RADIO", 7, 8);
      MMq = new e("TYPE_STATISTICS_OTHER_TIME", 8, 9);
      MMr = new e("TYPE_STATISTICS_OTHER_THREAD_TIME", 9, 10);
      MMs = new e("TYPE_STATISTICS_OTHER_TIME_RADIO", 10, 11);
      MMt = new e("TYPE_STATISTICS_THREAD_COUNT", 11, 12);
      MMu = new e("TYPE_STATISTICS_UI_OTHER_AVERAGE", 12, 13);
      MMv = new e("TYPE_STATISTICS_MAX_COUNT_BLOWOUT", 13, 14);
      MMw = new e("TYPE_STATISTICS_TASK_THREAD_TIME", 14, 15);
      MMx = new e("TYPE_LOOPER_PREPARE", 15, 16);
      MMy = new e[] { MMi, MMj, MMk, MMl, MMm, MMn, MMo, MMp, MMq, MMr, MMs, MMt, MMu, MMv, MMw, MMx };
      AppMethodBeat.o(184657);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/threadpool/ThreadModuleBoot$ILooperPrepareMonitor;", "isResetLooper", "", "()Z", "reportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "isHookResetLooper", "isOpenCheck", "isThrowException", "onLooperPreparedAtTask", "", "thread", "Ljava/lang/Thread;", "task", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements g.b
  {
    private final ConcurrentHashMap<String, String> EVH;
    private final boolean MMD;
    
    i(a parama)
    {
      AppMethodBeat.i(300831);
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLc, true);
      Log.w("ThreadPool.Profiler", s.X("[isHookResetLooper] ", Boolean.valueOf(bool)));
      parama = ah.aiuX;
      this.MMD = bool;
      this.EVH = new ConcurrentHashMap();
      AppMethodBeat.o(300831);
    }
    
    public final void a(Thread paramThread, String paramString)
    {
      AppMethodBeat.i(300845);
      s.u(paramThread, "thread");
      s.u(paramString, "task");
      if (a.d(this.MME))
      {
        Object localObject = (CharSequence)paramString;
        localObject = new kotlin.n.k("[0-9]\\d*").e((CharSequence)localObject, "?");
        if (!this.EVH.contains(localObject))
        {
          String str = "task=" + (String)localObject + ' ' + paramThread;
          Log.w("ThreadPool.Profiler", s.X("[onLooperPreparedAtTask] ", str));
          com.tencent.mm.plugin.report.f.Ozc.b(18762, new Object[] { Integer.valueOf(a.e.MMx.value), str, paramString, Integer.valueOf(17), MMApplicationContext.getProcessName() });
          ((Map)this.EVH).put(localObject, String.valueOf(paramThread));
        }
      }
      AppMethodBeat.o(300845);
    }
    
    public final boolean gzk()
    {
      return true;
    }
    
    public final boolean gzl()
    {
      return false;
    }
    
    public final boolean gzm()
    {
      return this.MMD;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Landroid/util/Printer;", "record", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "getRecord", "()Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "setRecord", "(Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;)V", "onDispatchEnd", "", "x", "", "onDispatchStart", "println", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements Printer
  {
    private a.g MMF;
    
    j(a parama)
    {
      AppMethodBeat.i(184664);
      this.MMF = new a.g(true, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte)0);
      AppMethodBeat.o(184664);
    }
    
    public final void println(String paramString)
    {
      AppMethodBeat.i(184663);
      s.u(paramString, "x");
      if (paramString.charAt(0) == '>')
      {
        s.u(paramString, "x");
        this.MMF.time = SystemClock.uptimeMillis();
        this.MMF.MMg = SystemClock.currentThreadTimeMillis();
        int i = a.h(this.MME).get();
        if (i > 0)
        {
          paramString = a.i(this.MME);
          paramString[0] = (i + paramString[0]);
          paramString = a.i(this.MME);
          paramString[1] += 1;
        }
        AppMethodBeat.o(184663);
        return;
      }
      if (paramString.charAt(0) == '<')
      {
        s.u(paramString, "x");
        paramString = this.MMF;
        a locala = this.MME;
        long l1 = SystemClock.uptimeMillis();
        long l2 = paramString.time;
        long l3 = SystemClock.currentThreadTimeMillis();
        long l4 = paramString.MMg;
        a.j(locala).addAndGet(l1 - l2);
        a.k(locala).addAndGet(l3 - l4);
        a.l(locala).incrementAndGet();
      }
      AppMethodBeat.o(184663);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$open$1", "Ljava/lang/Runnable;", "run", "", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements Runnable
  {
    public k(a parama, MMHandler paramMMHandler) {}
    
    public final void run()
    {
      AppMethodBeat.i(184665);
      a.b(this.MME);
      this.GlF.postDelayed((Runnable)this, 1800000L);
      AppMethodBeat.o(184665);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mainThreadId", "", "getMainThreadId", "()J", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements com.tencent.mm.hellhoundlib.a.d
  {
    private final long MMG;
    
    l(a parama)
    {
      AppMethodBeat.i(184668);
      this.MMG = Looper.getMainLooper().getThread().getId();
      AppMethodBeat.o(184668);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(300822);
      s.u(paramString1, "className");
      a.h(this.MME).decrementAndGet();
      if (this.MMG != Thread.currentThread().getId())
      {
        paramString2 = a.o(this.MME);
        paramString1 = new StringBuilder().append(paramString1);
        if (paramObject1 == null) {
          break label156;
        }
      }
      label156:
      for (int i = paramObject1.hashCode();; i = 0)
      {
        paramString1 = (a.g)paramString2.remove(i);
        if (paramString1 != null)
        {
          paramString2 = this.MME;
          long l1 = SystemClock.uptimeMillis();
          long l2 = paramString1.time;
          long l3 = SystemClock.currentThreadTimeMillis();
          long l4 = paramString1.MMg;
          a.p(paramString2).addAndGet(l3 - l4);
          a.q(paramString2).addAndGet(l1 - l2);
          a.r(paramString2).incrementAndGet();
        }
        AppMethodBeat.o(300822);
        return;
      }
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184666);
      s.u(paramString1, "className");
      int i = a.h(this.MME).incrementAndGet();
      if (i > a.m(this.MME)) {
        a.a(this.MME, i);
      }
      paramString2 = a.MLE;
      if (i > ((Number)a.gzj().getValue()).intValue())
      {
        paramString2 = this.MME;
        a.b(paramString2, a.n(paramString2) + 1);
      }
      if (this.MMG != Thread.currentThread().getId())
      {
        paramString2 = (Map)a.o(this.MME);
        paramString1 = new StringBuilder().append(paramString1);
        if (paramObject == null) {
          break label168;
        }
      }
      label168:
      for (i = paramObject.hashCode();; i = 0)
      {
        paramString2.put(i, new a.g(false, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte)0));
        AppMethodBeat.o(184666);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/threadpool/Printer$TaskPrinter;", "dumpRunningTasks", "", "error", "key", "", "hash", "", "e", "", "print", "state", "Lcom/tencent/threadpool/State;", "time", "", "costThreadMs", "pool", "isLogging", "", "rejected", "isShutdown", "shutdown", "wait", "runningCount", "waitFor", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements d.e
  {
    m(a parama) {}
    
    public final void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
    {
      AppMethodBeat.i(184671);
      s.u(paramString1, "key");
      s.u(paramString2, "pool");
      paramString2 = "[wait] " + paramString1 + '@' + paramInt1 + " runningCount=" + paramInt2 + " waitFor=" + paramLong / 100000L + "ms " + paramString2;
      Log.w("ThreadPool.Profiler", paramString2);
      String str = MMApplicationContext.getProcessName();
      com.tencent.mm.plugin.report.f.Ozc.b(18762, new Object[] { Integer.valueOf(a.e.MMj.value), paramString2, paramString1, Integer.valueOf(17), str });
      AppMethodBeat.o(184671);
    }
    
    public final void a(String paramString1, int paramInt, com.tencent.threadpool.f paramf, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(185183);
      s.u(paramString1, "key");
      s.u(paramf, "state");
      s.u(paramString2, "pool");
      int i;
      Object localObject1;
      if ((a.d(this.MME)) && (paramf == com.tencent.threadpool.f.ahAx))
      {
        if (n.a((CharSequence)paramString1, '@', 0, false, 6) < 0) {
          break label204;
        }
        i = 1;
        if (i == 0) {
          break label210;
        }
        localObject1 = paramString1;
        label68:
        if (localObject1 != null) {
          break label216;
        }
        localObject1 = null;
        label76:
        if (localObject1 != null) {
          break label244;
        }
        localObject1 = paramString1;
      }
      label204:
      label210:
      label216:
      label244:
      for (;;)
      {
        Object localObject3 = (a.a)a.e(this.MME).get(localObject1);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject3 = this.MME;
          localObject2 = new a.a((String)localObject1);
          ((Map)a.e((a)localObject3)).put(localObject1, localObject2);
        }
        ((a.a)localObject2).count += 1;
        if (((a.a)localObject2).count % 2 == 1) {
          ((a.a)localObject2).MMg += 1L;
        }
        ((a.a)localObject2).MMg += paramLong2;
        if (paramBoolean) {
          break label247;
        }
        AppMethodBeat.o(185183);
        return;
        i = 0;
        break;
        localObject1 = null;
        break label68;
        localObject1 = ((String)localObject1).subSequence(0, n.a((CharSequence)localObject1, '@', 0, false, 6)).toString();
        break label76;
      }
      label247:
      Object localObject2 = paramString1 + '@' + paramInt;
      switch (a.$EnumSwitchMapping$0[paramf.ordinal()])
      {
      default: 
      case 1: 
      case 2: 
        do
        {
          AppMethodBeat.o(185183);
          return;
          if (paramLong1 < 0L) {}
          for (paramLong1 = 0L;; paramLong1 /= 1000000L)
          {
            if (a.d(this.MME)) {
              ((Map)a.f(this.MME)).put(localObject2, new a.b(SystemClock.uptimeMillis() + paramLong1));
            }
            Log.d("ThreadPool.Execute", "=== " + (String)localObject2 + " state=" + paramf + " delay=" + paramLong1 + "ms");
            ((Map)a.g(this.MME)).put(localObject2, new a.f(System.currentTimeMillis(), paramLong1, paramf));
            AppMethodBeat.o(185183);
            return;
          }
          if (a.d(this.MME))
          {
            paramString1 = (a.b)a.f(this.MME).get(localObject2);
            if (paramString1 != null) {
              paramString1.thread = Thread.currentThread();
            }
            a.f(this.MME).remove(localObject2);
          }
          Log.d("ThreadPool.Execute", ">>> " + (String)localObject2 + " state=" + paramf + ' ' + paramString2);
          paramString1 = (a.f)a.g(this.MME).get(localObject2);
          if (paramString1 != null) {
            paramString1.MMz = System.currentTimeMillis();
          }
          if (paramString1 != null)
          {
            s.u(paramf, "<set-?>");
            paramString1.MMA = paramf;
          }
        } while (paramString1 == null);
        paramString1.MMB = paramString2;
        AppMethodBeat.o(185183);
        return;
      case 3: 
        localObject1 = (a.f)a.g(this.MME).remove(localObject2);
        paramString2 = new StringBuilder("<<< ").append((String)localObject2).append(" state=").append(paramf).append(" cost=").append(paramLong1).append("ms/").append(paramLong2).append("ms ").append(paramString2).append(" start@=");
        if (localObject1 == null)
        {
          paramf = null;
          paramString2 = paramString2.append(paramf).append("ms delay=");
          if (localObject1 != null) {
            break label852;
          }
          paramf = null;
          paramString2 = paramString2.append(paramf).append("ms run@=");
          if (localObject1 != null) {
            break label864;
          }
        }
        for (paramf = null;; paramf = Long.valueOf(((a.f)localObject1).MMz))
        {
          paramf = paramf;
          Log.i("ThreadPool.Execute", paramf);
          if ((!a.d(this.MME)) || (paramLong1 < 600000L)) {
            break;
          }
          paramString2 = MMApplicationContext.getProcessName();
          com.tencent.mm.plugin.report.f.Ozc.b(18762, new Object[] { Integer.valueOf(a.e.MMl.value), paramf, paramString1, Integer.valueOf(17), paramString2 });
          AppMethodBeat.o(185183);
          return;
          paramf = Long.valueOf(((a.f)localObject1).startTime);
          break label706;
          paramf = Long.valueOf(((a.f)localObject1).delayTime);
          break label727;
        }
      case 4: 
        label706:
        label727:
        label864:
        if (a.d(this.MME)) {
          a.f(this.MME).remove(localObject2);
        }
        label852:
        paramString2 = (a.f)a.g(this.MME).remove(localObject2);
        paramf = new StringBuilder("||| ").append((String)localObject2).append(" state=").append(paramf).append(" start@=");
        if (paramString2 == null)
        {
          paramString1 = null;
          paramf = paramf.append(paramString1).append("ms delay=");
          if (paramString2 != null) {
            break label1023;
          }
          paramString1 = null;
          label973:
          paramf = paramf.append(paramString1).append("ms run@=");
          if (paramString2 != null) {
            break label1035;
          }
        }
        label1035:
        for (paramString1 = null;; paramString1 = Long.valueOf(paramString2.MMz))
        {
          Log.i("ThreadPool.Execute", paramString1);
          AppMethodBeat.o(185183);
          return;
          paramString1 = Long.valueOf(paramString2.startTime);
          break;
          label1023:
          paramString1 = Long.valueOf(paramString2.delayTime);
          break label973;
        }
      }
      if (a.d(this.MME)) {
        a.f(this.MME).remove(localObject2);
      }
      paramString2 = (a.f)a.g(this.MME).remove(localObject2);
      paramf = new StringBuilder("*** ").append((String)localObject2).append(" state=").append(paramf).append(" start@=");
      if (paramString2 == null)
      {
        paramString1 = null;
        label1125:
        paramf = paramf.append(paramString1).append("ms delay=");
        if (paramString2 != null) {
          break label1191;
        }
        paramString1 = null;
        label1144:
        paramf = paramf.append(paramString1).append("ms run@=");
        if (paramString2 != null) {
          break label1203;
        }
      }
      label1191:
      label1203:
      for (paramString1 = null;; paramString1 = Long.valueOf(paramString2.MMz))
      {
        Log.i("ThreadPool.Execute", paramString1);
        break;
        paramString1 = Long.valueOf(paramString2.startTime);
        break label1125;
        paramString1 = Long.valueOf(paramString2.delayTime);
        break label1144;
      }
    }
    
    public final void a(String paramString, int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(184670);
      s.u(paramString, "key");
      s.u(paramThrowable, "e");
      Log.e("ThreadPool.Profiler", paramString + '@' + paramInt + ' ' + paramThrowable);
      AppMethodBeat.o(184670);
    }
    
    public final void gzg()
    {
      AppMethodBeat.i(300836);
      for (;;)
      {
        try
        {
          Iterator localIterator = ((Map)new HashMap((Map)a.g(this.MME))).entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder("~~~ ").append(localEntry.getKey()).append(" state=");
          a.f localf = (a.f)localEntry.getValue();
          if (localf == null)
          {
            localf = null;
            localStringBuilder = localStringBuilder.append(localf).append(" pool=");
            localf = (a.f)localEntry.getValue();
            if (localf != null) {
              break label274;
            }
            localf = null;
            localStringBuilder = localStringBuilder.append(localf).append(" start@=");
            localf = (a.f)localEntry.getValue();
            if (localf != null) {
              break label282;
            }
            localf = null;
            localStringBuilder = localStringBuilder.append(localf).append("ms delay=");
            localf = (a.f)localEntry.getValue();
            if (localf != null) {
              break label293;
            }
            localf = null;
            localStringBuilder = localStringBuilder.append(localf).append("ms run@=");
            localf = (a.f)localEntry.getValue();
            if (localf != null) {
              break label304;
            }
            localf = null;
            Log.i("ThreadPool.Execute", localf);
            continue;
          }
          localObject = localThrowable.MMA;
        }
        finally
        {
          Log.printErrStackTrace("ThreadPool.Profiler", localThrowable, "", new Object[0]);
          AppMethodBeat.o(300836);
          return;
        }
        continue;
        label274:
        Object localObject = ((a.f)localObject).MMB;
        continue;
        label282:
        localObject = Long.valueOf(((a.f)localObject).startTime);
        continue;
        label293:
        localObject = Long.valueOf(((a.f)localObject).delayTime);
        continue;
        label304:
        long l = ((a.f)localObject).MMz;
        localObject = Long.valueOf(l);
      }
      AppMethodBeat.o(300836);
    }
    
    public final void h(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(184672);
      s.u(paramString1, "key");
      s.u(paramString2, "pool");
      paramString2 = "[rejected] " + paramString1 + ' ' + paramString2 + " isShutdown=true";
      Log.w("ThreadPool.Profiler", paramString2);
      if (a.d(this.MME))
      {
        a.f(this.MME).remove(paramString1 + '@' + paramInt);
        String str = MMApplicationContext.getProcessName();
        com.tencent.mm.plugin.report.f.Ozc.b(18762, new Object[] { Integer.valueOf(a.e.MMk.value), paramString2, paramString1, Integer.valueOf(17), str });
      }
      AppMethodBeat.o(184672);
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(184673);
      Log.w("ThreadPool.Profiler", "shutdown");
      a.f(this.MME).clear();
      AppMethodBeat.o(184673);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/threadpool/Printer$ThreadPrinter;", "onExit", "", "thread", "Ljava/lang/Thread;", "name", "", "id", "", "onInterrupt", "onStart", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements d.f
  {
    n(a parama) {}
    
    public final void a(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184674);
      s.u(paramThread, "thread");
      s.u(paramString, "name");
      Log.i("ThreadPool.Profiler", "[onInterrupt] name=" + paramString + " id=" + paramLong);
      AppMethodBeat.o(184674);
    }
    
    public final void b(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184675);
      s.u(paramThread, "thread");
      s.u(paramString, "name");
      Log.i("ThreadPool.Profiler", "[onThreadStart] name=" + paramString + " id=" + paramLong);
      a.c(this.MME).incrementAndGet();
      AppMethodBeat.o(184675);
    }
    
    public final void c(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184676);
      s.u(paramThread, "thread");
      s.u(paramString, "name");
      Log.i("ThreadPool.Profiler", "[onThreadExit] name=" + paramString + " id=" + paramLong);
      a.c(this.MME).decrementAndGet();
      AppMethodBeat.o(184676);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a
 * JD-Core Version:    0.7.0.1
 */