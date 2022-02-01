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
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.model.z;
import com.tencent.mm.pluginsdk.model.z.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
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
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.k.i;
import kotlin.l;
import kotlin.n.k;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver$IOnScreenshotTakenListener;", "Lcom/tencent/mm/app/IPhoneScreenListener;", "()V", "aboutUITimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "batteryRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$BatteryRecord;", "blowoutCount", "", "checkQueue", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "existThreadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "isNeedReport", "", "lastCheckTime", "", "lastDumpTime", "looperPrepareMonitor", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1;", "mainLooperListener", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1;", "mapOfRunningTasks", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TaskStatusInfo;", "maxBlowoutCount", "methodInfoMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "otherTaskCount", "Ljava/util/concurrent/atomic/AtomicLong;", "otherThreadTime", "otherTime", "runCallback", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1;", "runnableMethodInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "runningCount", "screenShotObserver", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver;", "screenShotObserver2", "screenShotPath", "screenShotPath2", "taskPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1;", "threadPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1;", "timeRecord", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "uiBusyConcurrent", "", "uiTaskCount", "uiThreadTime", "uiTime", "checkExpiredTask", "", "dumpRunningTasks", "dumpThreadPool", "dumpUIAbout", "getStackTrace", "thread", "Ljava/lang/Thread;", "onAppBackground", "activity", "onAppForeground", "onScreen", "isScreenOff", "onScreenshotTaken", "path", "open", "isProcessMain", "reportStatistics", "BatteryRecord", "CheckInfo", "Companion", "ReportType", "TaskStatusInfo", "TimeRecord", "plugin-performance_release"})
public final class a
  implements o, com.tencent.mm.app.p, z.a
{
  private static final kotlin.f GOP;
  public static final a.c GOQ;
  public static boolean dal;
  private final ConcurrentHashMap<String, a.g> AIP;
  private AtomicLong GOA;
  private AtomicLong GOB;
  private AtomicLong GOC;
  private int[] GOD;
  public final o GOE;
  public final j GOF;
  public final n GOG;
  private final ArrayList<Pair<String, String>> GOH;
  private final String GOI;
  private final String GOJ;
  private final z GOK;
  private final z GOL;
  private final k GOM;
  public final MTimerHandler GON;
  private final m GOO;
  private final AtomicInteger GOp;
  private final AtomicInteger GOq;
  private final ConcurrentHashMap<String, b> GOr;
  private final boolean GOs;
  private final ConcurrentHashMap<String, f> GOt;
  private final ConcurrentHashMap<String, a.a> GOu;
  private volatile int GOv;
  private int GOw;
  private AtomicLong GOx;
  private AtomicLong GOy;
  private AtomicLong GOz;
  private long jVv;
  private long lastCheckTime;
  private final HashMap<String, List<Pair<String, String>>> wfY;
  
  static
  {
    AppMethodBeat.i(184684);
    GOQ = new a.c((byte)0);
    GOP = g.ar((kotlin.g.a.a)d.GOS);
    AppMethodBeat.o(184684);
  }
  
  public a()
  {
    AppMethodBeat.i(184683);
    this.GOp = new AtomicInteger();
    this.GOq = new AtomicInteger();
    this.GOr = new ConcurrentHashMap();
    int i;
    int j;
    if ((com.tencent.mm.protocal.d.RAE) || (com.tencent.mm.protocal.d.RAF))
    {
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxy, 10);
      j = new Random().nextInt(100000);
      if (i < j) {
        break label592;
      }
    }
    label592:
    for (boolean bool = true;; bool = false)
    {
      Log.i("ThreadPool.Profiler", "[isNeedReport] rand=" + i + " test=" + j + " isEnable=" + bool + " isRelease=" + com.tencent.mm.protocal.d.RAE + " isTest=" + com.tencent.mm.protocal.d.RAF);
      this.GOs = bool;
      this.GOt = new ConcurrentHashMap();
      this.GOu = new ConcurrentHashMap(100);
      this.AIP = new ConcurrentHashMap(100);
      this.GOx = new AtomicLong();
      this.GOy = new AtomicLong();
      this.GOz = new AtomicLong();
      this.GOA = new AtomicLong();
      this.GOB = new AtomicLong();
      this.GOC = new AtomicLong();
      this.GOD = new int[2];
      this.GOE = new o(this);
      this.GOF = new j(this);
      this.GOG = new n(this);
      this.wfY = new HashMap();
      this.GOH = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder();
      File localFile = Environment.getExternalStorageDirectory();
      kotlin.g.b.p.j(localFile, "Environment.getExternalStorageDirectory()");
      this.GOI = (localFile.getPath() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator);
      localStringBuilder = new StringBuilder();
      localFile = Environment.getExternalStorageDirectory();
      kotlin.g.b.p.j(localFile, "Environment.getExternalStorageDirectory()");
      this.GOJ = (localFile.getPath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Screenshots" + File.separator);
      this.GOK = new z(this.GOI, (z.a)this);
      this.GOL = new z(this.GOJ, (z.a)this);
      this.GOM = new k(this);
      this.GON = new MTimerHandler(com.tencent.e.j.a.bDn("ThreadPool.Profiler"), (MTimerHandler.CallBack)new h(this), true);
      this.GOO = new m(this);
      AppMethodBeat.o(184683);
      return;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxz, 100000);
      break;
    }
  }
  
  private final void fom()
  {
    AppMethodBeat.i(184681);
    StringBuilder localStringBuilder = new StringBuilder(" \n[RunningTask]\n");
    kotlin.g.b.p.j(localStringBuilder, "StringBuilder(\" \\n[RunningTask]\").append(\"\\n\")");
    Object localObject1 = com.tencent.e.h.ZvH.ipD();
    kotlin.g.b.p.j(localObject1, "ThreadPool.PROFILE.dumpRunningTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    Object localObject3;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = localStringBuilder.append("\t").append((String)((Map.Entry)localObject3).getKey()).append(" => ");
      localObject3 = ((Map.Entry)localObject3).getValue();
      kotlin.g.b.p.j(localObject3, "it.value");
      ((StringBuilder)localObject2).append(((Number)localObject3).intValue()).append("\n");
    }
    Log.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    n.h(localStringBuilder);
    localStringBuilder.append(" \n[WaitingTask]\n");
    localObject1 = com.tencent.e.h.ZvH.ipE();
    kotlin.g.b.p.j(localObject1, "ThreadPool.PROFILE.dumpWaitingTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localStringBuilder.append("# ").append((String)((Map.Entry)localObject2).getKey()).append("\n");
      localObject2 = ((Map.Entry)localObject2).getValue();
      kotlin.g.b.p.j(localObject2, "entry.value");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Pair)((Iterator)localObject2).next();
        localObject3 = localStringBuilder.append("\t|* ").append((String)((Pair)localObject4).first).append(" => ");
        localObject4 = ((Pair)localObject4).second;
        kotlin.g.b.p.j(localObject4, "it.second");
        ((StringBuilder)localObject3).append(((Number)localObject4).intValue()).append("\n");
      }
    }
    Log.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    Log.i("ThreadPool.Profiler", "[dumpThreadPool] Alive Thread Count = " + this.GOq.get() + " Global Running Count = " + this.GOp.get() + " maxRunningCount=" + this.GOv);
    fon();
    AppMethodBeat.o(184681);
  }
  
  private final void fon()
  {
    AppMethodBeat.i(184682);
    Log.i("ThreadPool.Profiler", "[dumpThreadPool]\n averageUITime=" + (float)this.GOA.get() * 1.0F / (float)this.GOC.get() + " averageUIThreadTime=" + (float)this.GOB.get() * 1.0F / (float)this.GOC.get() + '\n' + "averageOtherTime=" + (float)this.GOx.get() * 1.0F / (float)this.GOz.get() + " averageOtherThreadTime=" + (float)this.GOy.get() * 1.0F / (float)this.GOz.get() + '\n' + "uiTaskCount=" + this.GOC.get() + " otherTaskCount=" + this.GOz.get() + '\n' + "uiBusyConcurrent=" + this.GOD[1] + " averageUIConcurrent=" + this.GOD[0] * 1.0F / this.GOD[1] + " concurrentRadio=" + this.GOD[1] * 1.0F / (float)this.GOC.get());
    AppMethodBeat.o(184682);
  }
  
  public final void di(boolean paramBoolean)
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
      if ((l - this.lastCheckTime >= 900000L) && (this.GOs))
      {
        localLinkedList = new LinkedList();
        localObject2 = (Map)this.GOr;
        localObject1 = (Map)new LinkedHashMap();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if ((SystemClock.uptimeMillis() - ((b)((Map.Entry)localObject3).getValue()).time >= 60000L) && (((b)((Map.Entry)localObject3).getValue()).type == 0)) {}
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
          if (n.a((CharSequence)localObject1, '@', 0, false, 6) >= 0)
          {
            i = 1;
            label247:
            if (i == 0) {
              break label647;
            }
            label251:
            localObject1 = (String)localObject1;
            if (localObject1 != null)
            {
              localObject1 = ((String)localObject1).subSequence(0, n.a((CharSequence)localObject1, '@', 0, false, 6));
              if (localObject1 != null) {
                break label1374;
              }
            }
            localObject1 = (CharSequence)((Map.Entry)localObject5).getKey();
          }
        }
      }
    }
    label336:
    label340:
    label1374:
    for (;;)
    {
      localObject2 = ((Map.Entry)localObject5).getKey();
      if (n.a((CharSequence)localObject2, '#', 0, false, 6) >= 0)
      {
        i = 1;
        if (i == 0) {
          break label658;
        }
        localObject2 = (String)localObject2;
        if (localObject2 != null)
        {
          localObject3 = ((String)localObject2).subSequence(0, n.a((CharSequence)localObject2, '#', 0, false, 6));
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = (CharSequence)((Map.Entry)localObject5).getKey();
        }
        localObject2 = com.tencent.e.j.a.bDo(localObject2.toString());
        if (localObject2 == null) {
          break label664;
        }
        localObject2 = ((com.tencent.e.j.a)localObject2).iqh();
        StringBuilder localStringBuilder = new StringBuilder().append((String)((Map.Entry)localObject5).getKey()).append(" has expired ").append(SystemClock.uptimeMillis() - ((b)((Map.Entry)localObject5).getValue()).time).append("ms size=");
        if (localObject2 == null) {
          break label670;
        }
        localObject3 = Integer.valueOf(((com.tencent.e.j.d)localObject2).size());
        label489:
        localObject3 = localStringBuilder.append(localObject3).append(" queue is null=");
        if (localObject2 != null) {
          break label676;
        }
        paramBoolean = true;
        label511:
        localStringBuilder = ((StringBuilder)localObject3).append(paramBoolean).append(" isRunning=");
        if (localObject2 == null) {
          break label681;
        }
        localObject3 = Boolean.valueOf(((com.tencent.e.j.d)localObject2).isRunning());
        localObject3 = localObject3;
        Log.e("ThreadPool.Profiler", (String)localObject3);
        if (localObject2 != null) {
          break label687;
        }
        i = 0;
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.f.Iyx.a(18762, new Object[] { Integer.valueOf(e.GOT.value), localObject3, localObject1, Integer.valueOf(17), MMApplicationContext.getProcessName(), Integer.valueOf(i) });
        localLinkedList.add(((Map.Entry)localObject5).getKey());
        i = 1;
        break;
        i = 0;
        break label247;
        localObject1 = null;
        break label251;
        i = 0;
        break label336;
        localObject2 = null;
        break label340;
        localObject2 = null;
        break label420;
        localObject3 = null;
        break label489;
        paramBoolean = false;
        break label511;
        localObject3 = null;
        break label540;
        if (((com.tencent.e.j.d)localObject2).isRunning()) {
          i = 2;
        } else {
          i = 1;
        }
      }
      localObject1 = com.tencent.e.b.Zve;
      kotlin.g.b.p.j(localObject1, "ForkThreadPoolExecutor.sGlobalForkThreadPool");
      localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (com.tencent.e.b)((WeakReference)((Iterator)localObject3).next()).get();
        if (localObject5 != null)
        {
          localObject4 = ((com.tencent.e.b)localObject5).getName();
          int j = (int)((com.tencent.e.b)localObject5).ipB();
          int k = ((com.tencent.e.b)localObject5).ipA().size();
          localObject2 = (b)this.GOr.get(localObject4);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new b(SystemClock.uptimeMillis(), 1);
            localObject2 = (Map)this.GOr;
            kotlin.g.b.p.j(localObject4, "key");
            ((Map)localObject2).put(localObject4, localObject1);
          }
          kotlin.g.b.p.j(localObject1, "checkQueue[key] ?: run {…eckInfo\n                }");
          int m = ((b)localObject1).count;
          if ((j > 0) && (k > 0) && (j - m == 0) && (SystemClock.uptimeMillis() - ((b)localObject1).time >= 60000L))
          {
            localObject2 = "[ForkThreadPoolExecutor] " + (String)localObject4 + " has expired " + (SystemClock.uptimeMillis() - ((b)localObject1).time) + "ms " + localObject5;
            Log.e("ThreadPool.Profiler", (String)localObject2);
            com.tencent.mm.plugin.report.f.Iyx.a(18762, new Object[] { Integer.valueOf(e.GOT.value), localObject2, localObject4, Integer.valueOf(17), MMApplicationContext.getProcessName() });
            localLinkedList.add(localObject4);
            i = 1;
          }
          for (;;)
          {
            ((b)localObject1).count = j;
            break;
            ((b)localObject1).time = SystemClock.uptimeMillis();
          }
        }
      }
      if (i != 0) {
        fom();
      }
      localObject1 = ((Iterable)localLinkedList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.GOr.remove(localObject2);
      }
      try
      {
        if (this.GOu.values().size() > 1)
        {
          localObject1 = this.GOu.values();
          kotlin.g.b.p.j(localObject1, "batteryRecord.values");
          localObject1 = (Iterable)j.a((Iterable)localObject1, (Comparator)new a.i()).subList(0, i.ow(30, this.GOu.values().size() - 1));
          i = 0;
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              j.iBO();
            }
            localObject2 = (a.a)localObject2;
            Log.i("ThreadPool.Profiler", "[batteryRecord]#" + i + ' ' + localObject2);
            com.tencent.mm.plugin.report.f.Iyx.a(18883, new Object[] { Integer.valueOf(17), Integer.valueOf(e.GPh.value), Long.valueOf(((a.a)localObject2).GOR), MMApplicationContext.getProcessName(), ((a.a)localObject2).name, Integer.valueOf(((a.a)localObject2).count) });
            i += 1;
          }
          this.GOu.clear();
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
      fol();
      AppMethodBeat.o(184677);
      return;
    }
  }
  
  public final void fok()
  {
    AppMethodBeat.i(184680);
    if (!dal)
    {
      AppMethodBeat.o(184680);
      return;
    }
    com.tencent.mm.ae.c localc = new com.tencent.mm.ae.c("ThreadPool.Profiler#onScreenshotTaken");
    fom();
    localc.aIZ();
    AppMethodBeat.o(184680);
  }
  
  public final void fol()
  {
    AppMethodBeat.i(200498);
    long l = SystemClock.uptimeMillis();
    if (l - this.jVv < 300000L)
    {
      AppMethodBeat.o(200498);
      return;
    }
    this.GOG.fol();
    this.jVv = l;
    AppMethodBeat.o(200498);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(184679);
    if (!dal)
    {
      AppMethodBeat.o(184679);
      return;
    }
    this.GOK.stopWatching();
    this.GOL.stopWatching();
    AppMethodBeat.o(184679);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(184678);
    if (!dal)
    {
      AppMethodBeat.o(184678);
      return;
    }
    this.GOK.startWatching();
    this.GOL.startWatching();
    AppMethodBeat.o(184678);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "", "time", "", "thread", "Ljava/lang/Thread;", "type", "", "(JLjava/lang/Thread;I)V", "count", "getCount", "()I", "setCount", "(I)V", "getThread", "()Ljava/lang/Thread;", "setThread", "(Ljava/lang/Thread;)V", "getTime", "()J", "setTime", "(J)V", "getType", "setType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-performance_release"})
  static final class b
  {
    int count;
    Thread thread;
    long time;
    int type;
    
    public b(long paramLong, int paramInt)
    {
      this.time = paramLong;
      this.thread = null;
      this.type = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(184652);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.time != paramObject.time) || (!kotlin.g.b.p.h(this.thread, paramObject.thread)) || (this.type != paramObject.type)) {}
        }
      }
      else
      {
        AppMethodBeat.o(184652);
        return true;
      }
      AppMethodBeat.o(184652);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(184651);
      long l = this.time;
      int j = (int)(l ^ l >>> 32);
      Thread localThread = this.thread;
      if (localThread != null) {}
      for (int i = localThread.hashCode();; i = 0)
      {
        int k = this.type;
        AppMethodBeat.o(184651);
        return (i + j * 31) * 31 + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(184650);
      String str = "CheckInfo(time=" + this.time + ", thread=" + this.thread + ", type=" + this.type + ")";
      AppMethodBeat.o(184650);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final d GOS;
    
    static
    {
      AppMethodBeat.i(184654);
      GOS = new d();
      AppMethodBeat.o(184654);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$ReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_EXPIRED", "TYPE_CONTROL", "TYPE_REJECT", "TYPE_TIMEOUT", "TYPE_STATISTICS_COUNT_BLOWOUT", "TYPE_STATISTICS_UI_TIME", "TYPE_STATISTICS_UI_THREAD_TIME", "TYPE_STATISTICS_UI_TIME_RADIO", "TYPE_STATISTICS_OTHER_TIME", "TYPE_STATISTICS_OTHER_THREAD_TIME", "TYPE_STATISTICS_OTHER_TIME_RADIO", "TYPE_STATISTICS_THREAD_COUNT", "TYPE_STATISTICS_UI_OTHER_AVERAGE", "TYPE_STATISTICS_MAX_COUNT_BLOWOUT", "TYPE_STATISTICS_TASK_THREAD_TIME", "TYPE_LOOPER_PREPARE", "plugin-performance_release"})
  public static enum e
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(184657);
      e locale1 = new e("TYPE_EXPIRED", 0, 1);
      GOT = locale1;
      e locale2 = new e("TYPE_CONTROL", 1, 2);
      GOU = locale2;
      e locale3 = new e("TYPE_REJECT", 2, 3);
      GOV = locale3;
      e locale4 = new e("TYPE_TIMEOUT", 3, 4);
      GOW = locale4;
      e locale5 = new e("TYPE_STATISTICS_COUNT_BLOWOUT", 4, 5);
      GOX = locale5;
      e locale6 = new e("TYPE_STATISTICS_UI_TIME", 5, 6);
      GOY = locale6;
      e locale7 = new e("TYPE_STATISTICS_UI_THREAD_TIME", 6, 7);
      GOZ = locale7;
      e locale8 = new e("TYPE_STATISTICS_UI_TIME_RADIO", 7, 8);
      GPa = locale8;
      e locale9 = new e("TYPE_STATISTICS_OTHER_TIME", 8, 9);
      GPb = locale9;
      e locale10 = new e("TYPE_STATISTICS_OTHER_THREAD_TIME", 9, 10);
      GPc = locale10;
      e locale11 = new e("TYPE_STATISTICS_OTHER_TIME_RADIO", 10, 11);
      GPd = locale11;
      e locale12 = new e("TYPE_STATISTICS_THREAD_COUNT", 11, 12);
      GPe = locale12;
      e locale13 = new e("TYPE_STATISTICS_UI_OTHER_AVERAGE", 12, 13);
      GPf = locale13;
      e locale14 = new e("TYPE_STATISTICS_MAX_COUNT_BLOWOUT", 13, 14);
      GPg = locale14;
      e locale15 = new e("TYPE_STATISTICS_TASK_THREAD_TIME", 14, 15);
      GPh = locale15;
      e locale16 = new e("TYPE_LOOPER_PREPARE", 15, 16);
      GPi = locale16;
      GPj = new e[] { locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8, locale9, locale10, locale11, locale12, locale13, locale14, locale15, locale16 };
      AppMethodBeat.o(184657);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TaskStatusInfo;", "", "startTime", "", "delayTime", "runningTime", "state", "Lcom/tencent/threadpool/State;", "pool", "", "(JJJLcom/tencent/threadpool/State;Ljava/lang/String;)V", "getDelayTime", "()J", "setDelayTime", "(J)V", "getPool", "()Ljava/lang/String;", "setPool", "(Ljava/lang/String;)V", "getRunningTime", "setRunningTime", "getStartTime", "setStartTime", "getState", "()Lcom/tencent/threadpool/State;", "setState", "(Lcom/tencent/threadpool/State;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-performance_release"})
  static final class f
  {
    long GPk;
    com.tencent.e.f GPl;
    String GPm;
    long delayTime;
    long startTime;
    
    public f(long paramLong1, long paramLong2, com.tencent.e.f paramf)
    {
      AppMethodBeat.i(201380);
      this.startTime = paramLong1;
      this.delayTime = paramLong2;
      this.GPk = 0L;
      this.GPl = paramf;
      this.GPm = null;
      AppMethodBeat.o(201380);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(201390);
      if (this != paramObject)
      {
        if ((paramObject instanceof f))
        {
          paramObject = (f)paramObject;
          if ((this.startTime != paramObject.startTime) || (this.delayTime != paramObject.delayTime) || (this.GPk != paramObject.GPk) || (!kotlin.g.b.p.h(this.GPl, paramObject.GPl)) || (!kotlin.g.b.p.h(this.GPm, paramObject.GPm))) {}
        }
      }
      else
      {
        AppMethodBeat.o(201390);
        return true;
      }
      AppMethodBeat.o(201390);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(201387);
      long l = this.startTime;
      int k = (int)(l ^ l >>> 32);
      l = this.delayTime;
      int m = (int)(l ^ l >>> 32);
      l = this.GPk;
      int n = (int)(l ^ l >>> 32);
      Object localObject = this.GPl;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.GPm;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(201387);
        return (i + ((k * 31 + m) * 31 + n) * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201382);
      String str = "TaskStatusInfo(startTime=" + this.startTime + ", delayTime=" + this.delayTime + ", runningTime=" + this.GPk + ", state=" + this.GPl + ", pool=" + this.GPm + ")";
      AppMethodBeat.o(201382);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class h
    implements MTimerHandler.CallBack
  {
    h(a parama) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(184662);
      a.l(this.GPo);
      AppMethodBeat.o(184662);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/threadpool/ThreadModuleBoot$ILooperPrepareMonitor;", "isResetLooper", "", "()Z", "reportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "isHookResetLooper", "isOpenCheck", "isThrowException", "onLooperPreparedAtTask", "", "thread", "Ljava/lang/Thread;", "task", "plugin-performance_release"})
  public static final class j
    implements g.b
  {
    private final boolean GPp;
    private final ConcurrentHashMap<String, String> zKV;
    
    j()
    {
      AppMethodBeat.i(201252);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxA, true);
      Log.w("ThreadPool.Profiler", "[isHookResetLooper] ".concat(String.valueOf(bool)));
      this.GPp = bool;
      this.zKV = new ConcurrentHashMap();
      AppMethodBeat.o(201252);
    }
    
    public final void a(Thread paramThread, String paramString)
    {
      AppMethodBeat.i(201251);
      kotlin.g.b.p.k(paramThread, "thread");
      kotlin.g.b.p.k(paramString, "task");
      if (a.c(this.GPo))
      {
        Object localObject = (CharSequence)paramString;
        localObject = new k("[0-9]\\d*").e((CharSequence)localObject, "?");
        if (!this.zKV.contains(localObject))
        {
          String str = "task=" + (String)localObject + ' ' + paramThread;
          Log.w("ThreadPool.Profiler", "[onLooperPreparedAtTask] ".concat(String.valueOf(str)));
          com.tencent.mm.plugin.report.f.Iyx.a(18762, new Object[] { Integer.valueOf(a.e.GPi.value), str, paramString, Integer.valueOf(17), MMApplicationContext.getProcessName() });
          ((Map)this.zKV).put(localObject, String.valueOf(paramThread));
        }
      }
      AppMethodBeat.o(201251);
    }
    
    public final boolean fop()
    {
      return true;
    }
    
    public final boolean foq()
    {
      return this.GPp;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Landroid/util/Printer;", "record", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "getRecord", "()Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "setRecord", "(Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;)V", "onDispatchEnd", "", "x", "", "onDispatchStart", "println", "plugin-performance_release"})
  public static final class k
    implements Printer
  {
    private a.g GPq;
    
    k()
    {
      AppMethodBeat.i(184664);
      this.GPq = new a.g(true, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte)0);
      AppMethodBeat.o(184664);
    }
    
    public final void println(String paramString)
    {
      AppMethodBeat.i(184663);
      kotlin.g.b.p.k(paramString, "x");
      if (paramString.charAt(0) == '>')
      {
        kotlin.g.b.p.k(paramString, "x");
        this.GPq.time = SystemClock.uptimeMillis();
        this.GPq.GOR = SystemClock.currentThreadTimeMillis();
        int i = a.g(this.GPo).get();
        if (i > 0)
        {
          paramString = a.h(this.GPo);
          paramString[0] = (i + paramString[0]);
          paramString = a.h(this.GPo);
          paramString[1] += 1;
        }
        AppMethodBeat.o(184663);
        return;
      }
      if (paramString.charAt(0) == '<')
      {
        kotlin.g.b.p.k(paramString, "x");
        paramString = this.GPq;
        long l1 = SystemClock.uptimeMillis();
        long l2 = paramString.time;
        long l3 = SystemClock.currentThreadTimeMillis();
        long l4 = paramString.GOR;
        a.i(this.GPo).addAndGet(l1 - l2);
        a.j(this.GPo).addAndGet(l3 - l4);
        a.k(this.GPo).incrementAndGet();
      }
      AppMethodBeat.o(184663);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$open$1", "Ljava/lang/Runnable;", "run", "", "plugin-performance_release"})
  public static final class l
    implements Runnable
  {
    public l(MMHandler paramMMHandler) {}
    
    public final void run()
    {
      AppMethodBeat.i(184665);
      a.a(this.GPo);
      this.GPr.postDelayed((Runnable)this, 1800000L);
      AppMethodBeat.o(184665);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mainThreadId", "", "getMainThreadId", "()J", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-performance_release"})
  public static final class m
    implements com.tencent.mm.hellhoundlib.a.d
  {
    private final long GPs;
    
    m()
    {
      AppMethodBeat.i(184668);
      Object localObject = Looper.getMainLooper();
      kotlin.g.b.p.j(localObject, "Looper.getMainLooper()");
      localObject = ((Looper)localObject).getThread();
      kotlin.g.b.p.j(localObject, "Looper.getMainLooper().thread");
      this.GPs = ((Thread)localObject).getId();
      AppMethodBeat.o(184668);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(200953);
      kotlin.g.b.p.k(paramString1, "className");
      a.g(this.GPo).decrementAndGet();
      long l1 = this.GPs;
      paramString2 = Thread.currentThread();
      kotlin.g.b.p.j(paramString2, "Thread.currentThread()");
      if (l1 != paramString2.getId())
      {
        paramString2 = a.o(this.GPo);
        paramString1 = new StringBuilder().append(paramString1);
        if (paramObject1 != null) {}
        for (int i = paramObject1.hashCode();; i = 0)
        {
          paramString1 = (a.g)paramString2.remove(i);
          if (paramString1 == null) {
            break;
          }
          l1 = SystemClock.uptimeMillis();
          long l2 = paramString1.time;
          long l3 = SystemClock.currentThreadTimeMillis();
          long l4 = paramString1.GOR;
          a.p(this.GPo).addAndGet(l3 - l4);
          a.q(this.GPo).addAndGet(l1 - l2);
          a.r(this.GPo).incrementAndGet();
          AppMethodBeat.o(200953);
          return;
        }
      }
      AppMethodBeat.o(200953);
    }
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184666);
      kotlin.g.b.p.k(paramString1, "className");
      int i = a.g(this.GPo).incrementAndGet();
      if (i > a.m(this.GPo)) {
        a.a(this.GPo, i);
      }
      paramString2 = a.GOQ;
      paramString2 = a.foo();
      paramString3 = a.GOQ;
      if (i > ((Number)paramString2.getValue()).intValue())
      {
        paramString2 = this.GPo;
        a.b(paramString2, a.n(paramString2) + 1);
      }
      long l = this.GPs;
      paramString2 = Thread.currentThread();
      kotlin.g.b.p.j(paramString2, "Thread.currentThread()");
      if (l != paramString2.getId())
      {
        paramString2 = (Map)a.o(this.GPo);
        paramString1 = new StringBuilder().append(paramString1);
        if (paramObject == null) {
          break label186;
        }
      }
      label186:
      for (i = paramObject.hashCode();; i = 0)
      {
        paramString2.put(i, new a.g(false, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte)0));
        AppMethodBeat.o(184666);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/threadpool/Printer$TaskPrinter;", "dumpRunningTasks", "", "error", "key", "", "hash", "", "e", "", "print", "state", "Lcom/tencent/threadpool/State;", "time", "", "costThreadMs", "pool", "isLogging", "", "rejected", "isShutdown", "shutdown", "wait", "runningCount", "waitFor", "plugin-performance_release"})
  public static final class n
    implements d.e
  {
    public final void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
    {
      AppMethodBeat.i(184671);
      kotlin.g.b.p.k(paramString1, "key");
      kotlin.g.b.p.k(paramString2, "pool");
      paramString2 = "[wait] " + paramString1 + '@' + paramInt1 + " runningCount=" + paramInt2 + " waitFor=" + paramLong / 100000L + "ms " + paramString2;
      Log.w("ThreadPool.Profiler", paramString2);
      String str = MMApplicationContext.getProcessName();
      com.tencent.mm.plugin.report.f.Iyx.a(18762, new Object[] { Integer.valueOf(a.e.GOU.value), paramString2, paramString1, Integer.valueOf(17), str });
      AppMethodBeat.o(184671);
    }
    
    public final void a(String paramString1, int paramInt, com.tencent.e.f paramf, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(185183);
      kotlin.g.b.p.k(paramString1, "key");
      kotlin.g.b.p.k(paramf, "state");
      kotlin.g.b.p.k(paramString2, "pool");
      int i;
      Object localObject1;
      if ((a.c(this.GPo)) && (paramf == com.tencent.e.f.ZvD))
      {
        if (n.a((CharSequence)paramString1, '@', 0, false, 6) < 0) {
          break label229;
        }
        i = 1;
        if (i == 0) {
          break label235;
        }
        localObject1 = paramString1;
        label68:
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).subSequence(0, n.a((CharSequence)localObject1, '@', 0, false, 6)).toString();
          if (localObject1 != null) {
            break label1213;
          }
        }
        localObject1 = paramString1;
      }
      label1035:
      label1040:
      label1203:
      label1208:
      label1213:
      for (;;)
      {
        a.a locala = (a.a)a.d(this.GPo).get(localObject1);
        Object localObject2 = locala;
        if (locala == null)
        {
          localObject2 = new a.a((String)localObject1);
          ((Map)a.d(this.GPo)).put(localObject1, localObject2);
        }
        kotlin.g.b.p.j(localObject2, "batteryRecord[keyRecord]… record\n                }");
        ((a.a)localObject2).count += 1;
        if (((a.a)localObject2).count % 2 == 1) {
          ((a.a)localObject2).GOR += 1L;
        }
        ((a.a)localObject2).GOR += paramLong2;
        if (!paramBoolean)
        {
          AppMethodBeat.o(185183);
          return;
          label229:
          i = 0;
          break;
          label235:
          localObject1 = null;
          break label68;
        }
        localObject2 = paramString1 + '@' + paramInt;
        switch (b.$EnumSwitchMapping$0[paramf.ordinal()])
        {
        default: 
          AppMethodBeat.o(185183);
          return;
        case 1: 
          if (paramLong1 < 0L) {}
          for (paramLong1 = 0L;; paramLong1 /= 1000000L)
          {
            if (a.c(this.GPo)) {
              ((Map)a.e(this.GPo)).put(localObject2, new a.b(SystemClock.uptimeMillis() + paramLong1));
            }
            Log.d("ThreadPool.Execute", "=== " + (String)localObject2 + " state=" + paramf + " delay=" + paramLong1 + "ms");
            ((Map)a.f(this.GPo)).put(localObject2, new a.f(System.currentTimeMillis(), paramLong1, paramf));
            AppMethodBeat.o(185183);
            return;
          }
        case 2: 
          if (a.c(this.GPo))
          {
            paramString1 = (a.b)a.e(this.GPo).get(localObject2);
            if (paramString1 != null) {
              paramString1.thread = Thread.currentThread();
            }
            a.e(this.GPo).remove(localObject2);
          }
          Log.d("ThreadPool.Execute", ">>> " + (String)localObject2 + " state=" + paramf + ' ' + paramString2);
          paramString1 = (a.f)a.f(this.GPo).get(localObject2);
          if (paramString1 != null) {
            paramString1.GPk = System.currentTimeMillis();
          }
          if (paramString1 != null)
          {
            kotlin.g.b.p.k(paramf, "<set-?>");
            paramString1.GPl = paramf;
          }
          if (paramString1 != null)
          {
            paramString1.GPm = paramString2;
            AppMethodBeat.o(185183);
            return;
          }
          AppMethodBeat.o(185183);
          return;
        case 3: 
          localObject1 = (a.f)a.f(this.GPo).remove(localObject2);
          paramString2 = new StringBuilder("<<< ").append((String)localObject2).append(" state=").append(paramf).append(" cost=").append(paramLong1).append("ms/").append(paramLong2).append("ms ").append(paramString2).append(" start@=");
          if (localObject1 != null)
          {
            paramf = Long.valueOf(((a.f)localObject1).startTime);
            paramString2 = paramString2.append(paramf).append("ms delay=");
            if (localObject1 == null) {
              break label864;
            }
            paramf = Long.valueOf(((a.f)localObject1).delayTime);
            paramString2 = paramString2.append(paramf).append("ms run@=");
            if (localObject1 == null) {
              break label869;
            }
          }
          for (paramf = Long.valueOf(((a.f)localObject1).GPk);; paramf = null)
          {
            paramf = paramf;
            Log.i("ThreadPool.Execute", paramf);
            if ((!a.c(this.GPo)) || (paramLong1 < 600000L)) {
              break;
            }
            paramString2 = MMApplicationContext.getProcessName();
            com.tencent.mm.plugin.report.f.Iyx.a(18762, new Object[] { Integer.valueOf(a.e.GOW.value), paramf, paramString1, Integer.valueOf(17), paramString2 });
            AppMethodBeat.o(185183);
            return;
            paramf = null;
            break label711;
            paramf = null;
            break label739;
          }
        case 4: 
          label711:
          label739:
          label869:
          if (a.c(this.GPo)) {
            a.e(this.GPo).remove(localObject2);
          }
          label864:
          paramString2 = (a.f)a.f(this.GPo).remove(localObject2);
          paramf = new StringBuilder("||| ").append((String)localObject2).append(" state=").append(paramf).append(" start@=");
          if (paramString2 != null)
          {
            paramString1 = Long.valueOf(paramString2.startTime);
            paramf = paramf.append(paramString1).append("ms delay=");
            if (paramString2 == null) {
              break label1035;
            }
            paramString1 = Long.valueOf(paramString2.delayTime);
            label985:
            paramf = paramf.append(paramString1).append("ms run@=");
            if (paramString2 == null) {
              break label1040;
            }
          }
          for (paramString1 = Long.valueOf(paramString2.GPk);; paramString1 = null)
          {
            Log.i("ThreadPool.Execute", paramString1);
            AppMethodBeat.o(185183);
            return;
            paramString1 = null;
            break;
            paramString1 = null;
            break label985;
          }
        }
        if (a.c(this.GPo)) {
          a.e(this.GPo).remove(localObject2);
        }
        paramString2 = (a.f)a.f(this.GPo).remove(localObject2);
        paramf = new StringBuilder("*** ").append((String)localObject2).append(" state=").append(paramf).append(" start@=");
        if (paramString2 != null)
        {
          paramString1 = Long.valueOf(paramString2.startTime);
          label1130:
          paramf = paramf.append(paramString1).append("ms delay=");
          if (paramString2 == null) {
            break label1203;
          }
          paramString1 = Long.valueOf(paramString2.delayTime);
          paramf = paramf.append(paramString1).append("ms run@=");
          if (paramString2 == null) {
            break label1208;
          }
        }
        for (paramString1 = Long.valueOf(paramString2.GPk);; paramString1 = null)
        {
          Log.i("ThreadPool.Execute", paramString1);
          break;
          paramString1 = null;
          break label1130;
          paramString1 = null;
          break label1156;
        }
      }
    }
    
    public final void a(String paramString, int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(184670);
      kotlin.g.b.p.k(paramString, "key");
      kotlin.g.b.p.k(paramThrowable, "e");
      Log.e("ThreadPool.Profiler", paramString + '@' + paramInt + ' ' + paramThrowable);
      AppMethodBeat.o(184670);
    }
    
    public final void fol()
    {
      AppMethodBeat.i(201172);
      for (;;)
      {
        try
        {
          Iterator localIterator = ((Map)new HashMap((Map)a.f(this.GPo))).entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder("~~~ ").append((String)localEntry.getKey()).append(" state=");
          Object localObject1 = (a.f)localEntry.getValue();
          if (localObject1 != null)
          {
            localObject1 = ((a.f)localObject1).GPl;
            localStringBuilder = localStringBuilder.append(localObject1).append(" pool=");
            localObject1 = (a.f)localEntry.getValue();
            if (localObject1 == null) {
              break label288;
            }
            localObject1 = ((a.f)localObject1).GPm;
            localStringBuilder = localStringBuilder.append((String)localObject1).append(" start@=");
            localObject1 = (a.f)localEntry.getValue();
            if (localObject1 == null) {
              break label293;
            }
            localObject1 = Long.valueOf(((a.f)localObject1).startTime);
            localStringBuilder = localStringBuilder.append(localObject1).append("ms delay=");
            localObject1 = (a.f)localEntry.getValue();
            if (localObject1 == null) {
              break label298;
            }
            localObject1 = Long.valueOf(((a.f)localObject1).delayTime);
            localStringBuilder = localStringBuilder.append(localObject1).append("ms run@=");
            localObject1 = (a.f)localEntry.getValue();
            if (localObject1 == null) {
              break label303;
            }
            localObject1 = Long.valueOf(((a.f)localObject1).GPk);
            Log.i("ThreadPool.Execute", localObject1);
            continue;
          }
          localObject2 = null;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("ThreadPool.Profiler", localThrowable, "", new Object[0]);
          AppMethodBeat.o(201172);
          return;
        }
        continue;
        label288:
        Object localObject2 = null;
        continue;
        label293:
        localObject2 = null;
        continue;
        label298:
        localObject2 = null;
        continue;
        label303:
        localObject2 = null;
      }
      AppMethodBeat.o(201172);
    }
    
    public final void g(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(184672);
      kotlin.g.b.p.k(paramString1, "key");
      kotlin.g.b.p.k(paramString2, "pool");
      paramString2 = "[rejected] " + paramString1 + ' ' + paramString2 + " isShutdown=true";
      Log.w("ThreadPool.Profiler", paramString2);
      if (a.c(this.GPo))
      {
        a.e(this.GPo).remove(paramString1 + '@' + paramInt);
        String str = MMApplicationContext.getProcessName();
        com.tencent.mm.plugin.report.f.Iyx.a(18762, new Object[] { Integer.valueOf(a.e.GOV.value), paramString2, paramString1, Integer.valueOf(17), str });
      }
      AppMethodBeat.o(184672);
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(184673);
      Log.w("ThreadPool.Profiler", "shutdown");
      a.e(this.GPo).clear();
      AppMethodBeat.o(184673);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/threadpool/Printer$ThreadPrinter;", "onExit", "", "thread", "Ljava/lang/Thread;", "name", "", "id", "", "onInterrupt", "onStart", "plugin-performance_release"})
  public static final class o
    implements d.f
  {
    public final void a(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184674);
      kotlin.g.b.p.k(paramThread, "thread");
      kotlin.g.b.p.k(paramString, "name");
      Log.i("ThreadPool.Profiler", "[onInterrupt] name=" + paramString + " id=" + paramLong);
      AppMethodBeat.o(184674);
    }
    
    public final void b(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184675);
      kotlin.g.b.p.k(paramThread, "thread");
      kotlin.g.b.p.k(paramString, "name");
      Log.i("ThreadPool.Profiler", "[onThreadStart] name=" + paramString + " id=" + paramLong);
      a.b(this.GPo).incrementAndGet();
      AppMethodBeat.o(184675);
    }
    
    public final void c(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184676);
      kotlin.g.b.p.k(paramThread, "thread");
      kotlin.g.b.p.k(paramString, "name");
      Log.i("ThreadPool.Profiler", "[onThreadExit] name=" + paramString + " id=" + paramLong);
      a.b(this.GPo).decrementAndGet();
      AppMethodBeat.o(184676);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.a
 * JD-Core Version:    0.7.0.1
 */