package com.tencent.mm.plugin.performance.c;

import android.os.Environment;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Printer;
import com.tencent.f.d.e;
import com.tencent.f.d.f;
import com.tencent.f.g.b;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.model.v.a;
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
import kotlin.l;
import kotlin.n.k;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver$IOnScreenshotTakenListener;", "Lcom/tencent/mm/app/IPhoneScreenListener;", "()V", "aboutUITimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "batteryRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$BatteryRecord;", "blowoutCount", "", "checkQueue", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "existThreadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "isNeedReport", "", "lastCheckTime", "", "looperPrepareMonitor", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1;", "mainLooperListener", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1;", "maxBlowoutCount", "methodInfoMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "otherTaskCount", "Ljava/util/concurrent/atomic/AtomicLong;", "otherThreadTime", "otherTime", "runCallback", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1;", "runnableMethodInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "runningCount", "screenShotObserver", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver;", "screenShotObserver2", "screenShotPath", "screenShotPath2", "taskPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1;", "threadPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1;", "timeRecord", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "uiBusyConcurrent", "", "uiTaskCount", "uiThreadTime", "uiTime", "checkExpiredTask", "", "dumpThreadPool", "dumpUIAbout", "getStackTrace", "thread", "Ljava/lang/Thread;", "onAppBackground", "activity", "onAppForeground", "onScreen", "isScreenOff", "onScreenshotTaken", "path", "open", "isProcessMain", "reportStatistics", "BatteryRecord", "CheckInfo", "Companion", "ReportType", "TimeRecord", "plugin-performance_release"})
public final class a
  implements o, com.tencent.mm.app.p, v.a
{
  private static final kotlin.f AVu;
  public static final a.c AVv;
  public static boolean cWq;
  private final AtomicInteger AUU;
  private final AtomicInteger AUV;
  private final ConcurrentHashMap<String, b> AUW;
  private final boolean AUX;
  private final ConcurrentHashMap<String, a.a> AUY;
  private final ConcurrentHashMap<String, a.f> AUZ;
  private volatile int AVa;
  private int AVb;
  private AtomicLong AVc;
  private AtomicLong AVd;
  private AtomicLong AVe;
  private AtomicLong AVf;
  private AtomicLong AVg;
  private AtomicLong AVh;
  private int[] AVi;
  public final n AVj;
  public final i AVk;
  public final m AVl;
  private final ArrayList<Pair<String, String>> AVm;
  private final String AVn;
  private final String AVo;
  private final v AVp;
  private final v AVq;
  private final j AVr;
  public final MTimerHandler AVs;
  private final l AVt;
  private long lastCheckTime;
  private final HashMap<String, List<Pair<String, String>>> sAe;
  
  static
  {
    AppMethodBeat.i(184684);
    AVv = new a.c((byte)0);
    AVu = kotlin.g.ah((kotlin.g.a.a)a.d.AVx);
    AppMethodBeat.o(184684);
  }
  
  public a()
  {
    AppMethodBeat.i(184683);
    this.AUU = new AtomicInteger();
    this.AUV = new AtomicInteger();
    this.AUW = new ConcurrentHashMap();
    int i;
    int j;
    if ((com.tencent.mm.protocal.d.KyP) || (com.tencent.mm.protocal.d.KyQ))
    {
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRe, 10);
      j = new Random().nextInt(100000);
      if (i < j) {
        break label577;
      }
    }
    label577:
    for (boolean bool = true;; bool = false)
    {
      Log.i("ThreadPool.Profiler", "[isNeedReport] rand=" + i + " test=" + j + " isEnable=" + bool + " isRelease=" + com.tencent.mm.protocal.d.KyP + " isTest=" + com.tencent.mm.protocal.d.KyQ);
      this.AUX = bool;
      this.AUY = new ConcurrentHashMap(100);
      this.AUZ = new ConcurrentHashMap(100);
      this.AVc = new AtomicLong();
      this.AVd = new AtomicLong();
      this.AVe = new AtomicLong();
      this.AVf = new AtomicLong();
      this.AVg = new AtomicLong();
      this.AVh = new AtomicLong();
      this.AVi = new int[2];
      this.AVj = new n(this);
      this.AVk = new i(this);
      this.AVl = new m(this);
      this.sAe = new HashMap();
      this.AVm = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder();
      File localFile = Environment.getExternalStorageDirectory();
      kotlin.g.b.p.g(localFile, "Environment.getExternalStorageDirectory()");
      this.AVn = (localFile.getPath() + File.separator + Environment.DIRECTORY_PICTURES + File.separator + "Screenshots" + File.separator);
      localStringBuilder = new StringBuilder();
      localFile = Environment.getExternalStorageDirectory();
      kotlin.g.b.p.g(localFile, "Environment.getExternalStorageDirectory()");
      this.AVo = (localFile.getPath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Screenshots" + File.separator);
      this.AVp = new v(this.AVn, (v.a)this);
      this.AVq = new v(this.AVo, (v.a)this);
      this.AVr = new j(this);
      this.AVs = new MTimerHandler(com.tencent.f.j.a.bqt("ThreadPool.Profiler"), (MTimerHandler.CallBack)new g(this), true);
      this.AVt = new l(this);
      AppMethodBeat.o(184683);
      return;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRf, 100000);
      break;
    }
  }
  
  private final void eCA()
  {
    AppMethodBeat.i(184682);
    Log.i("ThreadPool.Profiler", "[dumpThreadPool]\n averageUITime=" + (float)this.AVf.get() * 1.0F / (float)this.AVh.get() + " averageUIThreadTime=" + (float)this.AVg.get() * 1.0F / (float)this.AVh.get() + '\n' + "averageOtherTime=" + (float)this.AVc.get() * 1.0F / (float)this.AVe.get() + " averageOtherThreadTime=" + (float)this.AVd.get() * 1.0F / (float)this.AVe.get() + '\n' + "uiTaskCount=" + this.AVh.get() + " otherTaskCount=" + this.AVe.get() + '\n' + "uiBusyConcurrent=" + this.AVi[1] + " averageUIConcurrent=" + this.AVi[0] * 1.0F / this.AVi[1] + " concurrentRadio=" + this.AVi[1] * 1.0F / (float)this.AVh.get());
    AppMethodBeat.o(184682);
  }
  
  private final void eCz()
  {
    AppMethodBeat.i(184681);
    StringBuilder localStringBuilder = new StringBuilder(" \n[RunningTask]\n");
    kotlin.g.b.p.g(localStringBuilder, "StringBuilder(\" \\n[RunningTask]\").append(\"\\n\")");
    Object localObject1 = h.RTd.hmd();
    kotlin.g.b.p.g(localObject1, "ThreadPool.PROFILE.dumpRunningTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    Object localObject3;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = localStringBuilder.append("\t").append((String)((Map.Entry)localObject3).getKey()).append(" => ");
      localObject3 = ((Map.Entry)localObject3).getValue();
      kotlin.g.b.p.g(localObject3, "it.value");
      ((StringBuilder)localObject2).append(((Number)localObject3).intValue()).append("\n");
    }
    Log.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    n.h(localStringBuilder);
    localStringBuilder.append(" \n[WaitingTask]\n");
    localObject1 = h.RTd.hme();
    kotlin.g.b.p.g(localObject1, "ThreadPool.PROFILE.dumpWaitingTask()");
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localStringBuilder.append("# ").append((String)((Map.Entry)localObject2).getKey()).append("\n");
      localObject2 = ((Map.Entry)localObject2).getValue();
      kotlin.g.b.p.g(localObject2, "entry.value");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Pair)((Iterator)localObject2).next();
        localObject3 = localStringBuilder.append("\t|* ").append((String)((Pair)localObject4).first).append(" => ");
        localObject4 = ((Pair)localObject4).second;
        kotlin.g.b.p.g(localObject4, "it.second");
        ((StringBuilder)localObject3).append(((Number)localObject4).intValue()).append("\n");
      }
    }
    Log.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(localStringBuilder)));
    Log.i("ThreadPool.Profiler", "[dumpThreadPool] Alive Thread Count = " + this.AUV.get() + " Global Running Count = " + this.AUU.get() + " maxRunningCount=" + this.AVa);
    eCA();
    AppMethodBeat.o(184681);
  }
  
  public final void cM(boolean paramBoolean)
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
      if ((l - this.lastCheckTime >= 900000L) && (this.AUX))
      {
        localLinkedList = new LinkedList();
        localObject2 = (Map)this.AUW;
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
              break label646;
            }
            label251:
            localObject1 = (String)localObject1;
            if (localObject1 != null)
            {
              localObject1 = ((String)localObject1).subSequence(0, n.a((CharSequence)localObject1, '@', 0, false, 6));
              if (localObject1 != null) {
                break label1366;
              }
            }
            localObject1 = (CharSequence)((Map.Entry)localObject5).getKey();
          }
        }
      }
    }
    label336:
    label340:
    label1366:
    for (;;)
    {
      localObject2 = ((Map.Entry)localObject5).getKey();
      if (n.a((CharSequence)localObject2, '#', 0, false, 6) >= 0)
      {
        i = 1;
        if (i == 0) {
          break label657;
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
        localObject2 = com.tencent.f.j.a.bqu(localObject2.toString());
        if (localObject2 == null) {
          break label663;
        }
        localObject2 = ((com.tencent.f.j.a)localObject2).hmG();
        StringBuilder localStringBuilder = new StringBuilder().append((String)((Map.Entry)localObject5).getKey()).append(" has expired ").append(SystemClock.uptimeMillis() - ((b)((Map.Entry)localObject5).getValue()).time).append("ms size=");
        if (localObject2 == null) {
          break label669;
        }
        localObject3 = Integer.valueOf(((com.tencent.f.j.d)localObject2).size());
        label489:
        localObject3 = localStringBuilder.append(localObject3).append(" queue is null=");
        if (localObject2 != null) {
          break label675;
        }
        paramBoolean = true;
        label511:
        localStringBuilder = ((StringBuilder)localObject3).append(paramBoolean).append(" isRunning=");
        if (localObject2 == null) {
          break label680;
        }
        localObject3 = Boolean.valueOf(((com.tencent.f.j.d)localObject2).isRunning());
        localObject3 = localObject3;
        Log.e("ThreadPool.Profiler", (String)localObject3);
        if (localObject2 != null) {
          break label686;
        }
        i = 0;
      }
      for (;;)
      {
        e.Cxv.a(18762, new Object[] { Integer.valueOf(e.AVy.value), localObject3, localObject1, Integer.valueOf(17), MMApplicationContext.getProcessName(), Integer.valueOf(i) });
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
        if (((com.tencent.f.j.d)localObject2).isRunning()) {
          i = 2;
        } else {
          i = 1;
        }
      }
      localObject1 = com.tencent.f.b.RSA;
      kotlin.g.b.p.g(localObject1, "ForkThreadPoolExecutor.sGlobalForkThreadPool");
      localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject5 = (com.tencent.f.b)((WeakReference)((Iterator)localObject3).next()).get();
        if (localObject5 != null)
        {
          localObject4 = ((com.tencent.f.b)localObject5).getName();
          int j = (int)((com.tencent.f.b)localObject5).getCompletedTaskCount();
          int k = ((com.tencent.f.b)localObject5).getQueue().size();
          localObject2 = (b)this.AUW.get(localObject4);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new b(SystemClock.uptimeMillis(), 1);
            localObject2 = (Map)this.AUW;
            kotlin.g.b.p.g(localObject4, "key");
            ((Map)localObject2).put(localObject4, localObject1);
          }
          kotlin.g.b.p.g(localObject1, "checkQueue[key] ?: run {…eckInfo\n                }");
          int m = ((b)localObject1).count;
          if ((j > 0) && (k > 0) && (j - m == 0) && (SystemClock.uptimeMillis() - ((b)localObject1).time >= 60000L))
          {
            localObject2 = "[ForkThreadPoolExecutor] " + (String)localObject4 + " has expired " + (SystemClock.uptimeMillis() - ((b)localObject1).time) + "ms " + localObject5;
            Log.e("ThreadPool.Profiler", (String)localObject2);
            e.Cxv.a(18762, new Object[] { Integer.valueOf(e.AVy.value), localObject2, localObject4, Integer.valueOf(17), MMApplicationContext.getProcessName() });
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
        eCz();
      }
      localObject1 = ((Iterable)localLinkedList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.AUW.remove(localObject2);
      }
      try
      {
        if (this.AUY.values().size() > 1)
        {
          localObject1 = this.AUY.values();
          kotlin.g.b.p.g(localObject1, "batteryRecord.values");
          localObject1 = (Iterable)kotlin.a.j.a((Iterable)localObject1, (Comparator)new a.h()).subList(0, kotlin.k.j.na(30, this.AUY.values().size() - 1));
          i = 0;
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              kotlin.a.j.hxH();
            }
            localObject2 = (a.a)localObject2;
            Log.i("ThreadPool.Profiler", "[batteryRecord]#" + i + ' ' + localObject2);
            e.Cxv.a(18883, new Object[] { Integer.valueOf(17), Integer.valueOf(e.AVM.value), Long.valueOf(((a.a)localObject2).AVw), MMApplicationContext.getProcessName(), ((a.a)localObject2).name, Integer.valueOf(((a.a)localObject2).count) });
            i += 1;
          }
          this.AUY.clear();
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
      AppMethodBeat.o(184677);
      return;
    }
  }
  
  public final void eCy()
  {
    AppMethodBeat.i(184680);
    if (!cWq)
    {
      AppMethodBeat.o(184680);
      return;
    }
    com.tencent.mm.ac.c localc = new com.tencent.mm.ac.c("ThreadPool.Profiler#onScreenshotTaken");
    eCz();
    localc.aBw();
    AppMethodBeat.o(184680);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(184679);
    if (!cWq)
    {
      AppMethodBeat.o(184679);
      return;
    }
    this.AVp.stopWatching();
    this.AVq.stopWatching();
    AppMethodBeat.o(184679);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(184678);
    if (!cWq)
    {
      AppMethodBeat.o(184678);
      return;
    }
    this.AVp.startWatching();
    this.AVq.startWatching();
    AppMethodBeat.o(184678);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "", "time", "", "thread", "Ljava/lang/Thread;", "type", "", "(JLjava/lang/Thread;I)V", "count", "getCount", "()I", "setCount", "(I)V", "getThread", "()Ljava/lang/Thread;", "setThread", "(Ljava/lang/Thread;)V", "getTime", "()J", "setTime", "(J)V", "getType", "setType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-performance_release"})
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
          if ((this.time != paramObject.time) || (!kotlin.g.b.p.j(this.thread, paramObject.thread)) || (this.type != paramObject.type)) {}
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$ReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_EXPIRED", "TYPE_CONTROL", "TYPE_REJECT", "TYPE_TIMEOUT", "TYPE_STATISTICS_COUNT_BLOWOUT", "TYPE_STATISTICS_UI_TIME", "TYPE_STATISTICS_UI_THREAD_TIME", "TYPE_STATISTICS_UI_TIME_RADIO", "TYPE_STATISTICS_OTHER_TIME", "TYPE_STATISTICS_OTHER_THREAD_TIME", "TYPE_STATISTICS_OTHER_TIME_RADIO", "TYPE_STATISTICS_THREAD_COUNT", "TYPE_STATISTICS_UI_OTHER_AVERAGE", "TYPE_STATISTICS_MAX_COUNT_BLOWOUT", "TYPE_STATISTICS_TASK_THREAD_TIME", "TYPE_LOOPER_PREPARE", "plugin-performance_release"})
  public static enum e
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(184657);
      e locale1 = new e("TYPE_EXPIRED", 0, 1);
      AVy = locale1;
      e locale2 = new e("TYPE_CONTROL", 1, 2);
      AVz = locale2;
      e locale3 = new e("TYPE_REJECT", 2, 3);
      AVA = locale3;
      e locale4 = new e("TYPE_TIMEOUT", 3, 4);
      AVB = locale4;
      e locale5 = new e("TYPE_STATISTICS_COUNT_BLOWOUT", 4, 5);
      AVC = locale5;
      e locale6 = new e("TYPE_STATISTICS_UI_TIME", 5, 6);
      AVD = locale6;
      e locale7 = new e("TYPE_STATISTICS_UI_THREAD_TIME", 6, 7);
      AVE = locale7;
      e locale8 = new e("TYPE_STATISTICS_UI_TIME_RADIO", 7, 8);
      AVF = locale8;
      e locale9 = new e("TYPE_STATISTICS_OTHER_TIME", 8, 9);
      AVG = locale9;
      e locale10 = new e("TYPE_STATISTICS_OTHER_THREAD_TIME", 9, 10);
      AVH = locale10;
      e locale11 = new e("TYPE_STATISTICS_OTHER_TIME_RADIO", 10, 11);
      AVI = locale11;
      e locale12 = new e("TYPE_STATISTICS_THREAD_COUNT", 11, 12);
      AVJ = locale12;
      e locale13 = new e("TYPE_STATISTICS_UI_OTHER_AVERAGE", 12, 13);
      AVK = locale13;
      e locale14 = new e("TYPE_STATISTICS_MAX_COUNT_BLOWOUT", 13, 14);
      AVL = locale14;
      e locale15 = new e("TYPE_STATISTICS_TASK_THREAD_TIME", 14, 15);
      AVM = locale15;
      e locale16 = new e("TYPE_LOOPER_PREPARE", 15, 16);
      AVN = locale16;
      AVO = new e[] { locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8, locale9, locale10, locale11, locale12, locale13, locale14, locale15, locale16 };
      AppMethodBeat.o(184657);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class g
    implements MTimerHandler.CallBack
  {
    g(a parama) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(184662);
      a.k(this.AVQ);
      AppMethodBeat.o(184662);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/threadpool/ThreadModuleBoot$ILooperPrepareMonitor;", "isResetLooper", "", "()Z", "reportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "isHookResetLooper", "isOpenCheck", "isThrowException", "onLooperPreparedAtTask", "", "thread", "Ljava/lang/Thread;", "task", "plugin-performance_release"})
  public static final class i
    implements g.b
  {
    private final boolean AVR;
    private final ConcurrentHashMap<String, String> uUF;
    
    i()
    {
      AppMethodBeat.i(200991);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRg, true);
      Log.w("ThreadPool.Profiler", "[isHookResetLooper] ".concat(String.valueOf(bool)));
      this.AVR = bool;
      this.uUF = new ConcurrentHashMap();
      AppMethodBeat.o(200991);
    }
    
    public final void a(Thread paramThread, String paramString)
    {
      AppMethodBeat.i(200990);
      kotlin.g.b.p.h(paramThread, "thread");
      kotlin.g.b.p.h(paramString, "task");
      if (a.c(this.AVQ))
      {
        Object localObject = (CharSequence)paramString;
        localObject = new k("[0-9]\\d*").e((CharSequence)localObject, "?");
        if (!this.uUF.contains(localObject))
        {
          String str = "task=" + (String)localObject + ' ' + paramThread;
          Log.w("ThreadPool.Profiler", "[onLooperPreparedAtTask] ".concat(String.valueOf(str)));
          e.Cxv.a(18762, new Object[] { Integer.valueOf(a.e.AVN.value), str, paramString, Integer.valueOf(17), MMApplicationContext.getProcessName() });
          ((Map)this.uUF).put(localObject, String.valueOf(paramThread));
        }
      }
      AppMethodBeat.o(200990);
    }
    
    public final boolean eCC()
    {
      return true;
    }
    
    public final boolean eCD()
    {
      return this.AVR;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Landroid/util/Printer;", "record", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "getRecord", "()Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "setRecord", "(Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;)V", "onDispatchEnd", "", "x", "", "onDispatchStart", "println", "plugin-performance_release"})
  public static final class j
    implements Printer
  {
    private a.f AVS;
    
    j()
    {
      AppMethodBeat.i(184664);
      this.AVS = new a.f(true, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte)0);
      AppMethodBeat.o(184664);
    }
    
    public final void println(String paramString)
    {
      AppMethodBeat.i(184663);
      kotlin.g.b.p.h(paramString, "x");
      if (paramString.charAt(0) == '>')
      {
        kotlin.g.b.p.h(paramString, "x");
        this.AVS.time = SystemClock.uptimeMillis();
        this.AVS.AVw = SystemClock.currentThreadTimeMillis();
        int i = a.f(this.AVQ).get();
        if (i > 0)
        {
          paramString = a.g(this.AVQ);
          paramString[0] = (i + paramString[0]);
          paramString = a.g(this.AVQ);
          paramString[1] += 1;
        }
        AppMethodBeat.o(184663);
        return;
      }
      if (paramString.charAt(0) == '<')
      {
        kotlin.g.b.p.h(paramString, "x");
        paramString = this.AVS;
        long l1 = SystemClock.uptimeMillis();
        long l2 = paramString.time;
        long l3 = SystemClock.currentThreadTimeMillis();
        long l4 = paramString.AVw;
        a.h(this.AVQ).addAndGet(l1 - l2);
        a.i(this.AVQ).addAndGet(l3 - l4);
        a.j(this.AVQ).incrementAndGet();
      }
      AppMethodBeat.o(184663);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$open$1", "Ljava/lang/Runnable;", "run", "", "plugin-performance_release"})
  public static final class k
    implements Runnable
  {
    public k(MMHandler paramMMHandler) {}
    
    public final void run()
    {
      AppMethodBeat.i(184665);
      a.a(this.AVQ);
      this.AVT.postDelayed((Runnable)this, 1800000L);
      AppMethodBeat.o(184665);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mainThreadId", "", "getMainThreadId", "()J", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-performance_release"})
  public static final class l
    implements com.tencent.mm.hellhoundlib.a.c
  {
    private final long AVU;
    
    l()
    {
      AppMethodBeat.i(184668);
      Object localObject = Looper.getMainLooper();
      kotlin.g.b.p.g(localObject, "Looper.getMainLooper()");
      localObject = ((Looper)localObject).getThread();
      kotlin.g.b.p.g(localObject, "Looper.getMainLooper().thread");
      this.AVU = ((Thread)localObject).getId();
      AppMethodBeat.o(184668);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(200992);
      kotlin.g.b.p.h(paramString1, "className");
      a.f(this.AVQ).decrementAndGet();
      long l1 = this.AVU;
      paramString2 = Thread.currentThread();
      kotlin.g.b.p.g(paramString2, "Thread.currentThread()");
      if (l1 != paramString2.getId())
      {
        paramString2 = a.n(this.AVQ);
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
          long l4 = paramString1.AVw;
          a.o(this.AVQ).addAndGet(l3 - l4);
          a.p(this.AVQ).addAndGet(l1 - l2);
          a.q(this.AVQ).incrementAndGet();
          AppMethodBeat.o(200992);
          return;
        }
      }
      AppMethodBeat.o(200992);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184666);
      kotlin.g.b.p.h(paramString1, "className");
      int i = a.f(this.AVQ).incrementAndGet();
      if (i > a.l(this.AVQ)) {
        a.a(this.AVQ, i);
      }
      paramString2 = a.AVv;
      paramString2 = a.eCB();
      paramString3 = a.AVv;
      if (i > ((Number)paramString2.getValue()).intValue())
      {
        paramString2 = this.AVQ;
        a.b(paramString2, a.m(paramString2) + 1);
      }
      long l = this.AVU;
      paramString2 = Thread.currentThread();
      kotlin.g.b.p.g(paramString2, "Thread.currentThread()");
      if (l != paramString2.getId())
      {
        paramString2 = (Map)a.n(this.AVQ);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/threadpool/Printer$TaskPrinter;", "error", "", "key", "", "hash", "", "e", "", "print", "state", "Lcom/tencent/threadpool/State;", "time", "", "costThreadMs", "pool", "isLogging", "", "rejected", "isShutdown", "shutdown", "wait", "runningCount", "waitFor", "plugin-performance_release"})
  public static final class m
    implements d.e
  {
    public final void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
    {
      AppMethodBeat.i(184671);
      kotlin.g.b.p.h(paramString1, "key");
      kotlin.g.b.p.h(paramString2, "pool");
      paramString2 = "[wait] " + paramString1 + '@' + paramInt1 + " runningCount=" + paramInt2 + " waitFor=" + paramLong / 100000L + "ms " + paramString2;
      Log.w("ThreadPool.Profiler", paramString2);
      String str = MMApplicationContext.getProcessName();
      e.Cxv.a(18762, new Object[] { Integer.valueOf(a.e.AVz.value), paramString2, paramString1, Integer.valueOf(17), str });
      AppMethodBeat.o(184671);
    }
    
    public final void a(String paramString1, int paramInt, com.tencent.f.f paramf, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(185183);
      kotlin.g.b.p.h(paramString1, "key");
      kotlin.g.b.p.h(paramf, "state");
      kotlin.g.b.p.h(paramString2, "pool");
      int i;
      Object localObject;
      if ((a.c(this.AVQ)) && (paramf == com.tencent.f.f.RSZ))
      {
        if (n.a((CharSequence)paramString1, '@', 0, false, 6) < 0) {
          break label229;
        }
        i = 1;
        if (i == 0) {
          break label235;
        }
        localObject = paramString1;
        label68:
        if (localObject != null)
        {
          localObject = ((String)localObject).subSequence(0, n.a((CharSequence)localObject, '@', 0, false, 6)).toString();
          if (localObject != null) {
            break label908;
          }
        }
        localObject = paramString1;
      }
      label908:
      for (;;)
      {
        a.a locala2 = (a.a)a.d(this.AVQ).get(localObject);
        a.a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a.a((String)localObject);
          ((Map)a.d(this.AVQ)).put(localObject, locala1);
        }
        kotlin.g.b.p.g(locala1, "batteryRecord[keyRecord]… record\n                }");
        locala1.count += 1;
        if (locala1.count % 2 == 1) {
          locala1.AVw += 1L;
        }
        locala1.AVw += paramLong2;
        if (!paramBoolean)
        {
          AppMethodBeat.o(185183);
          return;
          label229:
          i = 0;
          break;
          label235:
          localObject = null;
          break label68;
        }
        switch (b.$EnumSwitchMapping$0[paramf.ordinal()])
        {
        }
        for (;;)
        {
          AppMethodBeat.o(185183);
          return;
          if (paramLong1 < 0L) {}
          for (paramLong1 = 0L;; paramLong1 /= 1000000L)
          {
            if (a.c(this.AVQ)) {
              ((Map)a.e(this.AVQ)).put(paramString1 + '@' + paramInt, new a.b(SystemClock.uptimeMillis() + paramLong1));
            }
            Log.i("ThreadPool.Execute", "=== " + paramString1 + '@' + paramInt + " state=" + paramf + " delay=" + paramLong1 + "ms");
            AppMethodBeat.o(185183);
            return;
          }
          if (a.c(this.AVQ))
          {
            localObject = (a.b)a.e(this.AVQ).get(paramString1 + '@' + paramInt);
            if (localObject != null) {
              ((a.b)localObject).thread = Thread.currentThread();
            }
            a.e(this.AVQ).remove(paramString1 + '@' + paramInt);
          }
          Log.i("ThreadPool.Execute", ">>> " + paramString1 + '@' + paramInt + " state=" + paramf + ' ' + paramString2);
          AppMethodBeat.o(185183);
          return;
          paramf = "<<< " + paramString1 + '@' + paramInt + " state=" + paramf + " cost=" + paramLong1 + "ms/" + paramLong2 + "ms " + paramString2;
          Log.i("ThreadPool.Execute", paramf);
          if ((a.c(this.AVQ)) && (paramLong1 >= 600000L))
          {
            paramString2 = MMApplicationContext.getProcessName();
            e.Cxv.a(18762, new Object[] { Integer.valueOf(a.e.AVB.value), paramf, paramString1, Integer.valueOf(17), paramString2 });
            AppMethodBeat.o(185183);
            return;
            if (a.c(this.AVQ)) {
              a.e(this.AVQ).remove(paramString1 + '@' + paramInt);
            }
            Log.i("ThreadPool.Execute", "||| " + paramString1 + '@' + paramInt + " state=" + paramf);
            AppMethodBeat.o(185183);
            return;
            if (a.c(this.AVQ)) {
              a.e(this.AVQ).remove(paramString1 + '@' + paramInt);
            }
            Log.i("ThreadPool.Execute", "*** " + paramString1 + '@' + paramInt + " state=" + paramf);
          }
        }
      }
    }
    
    public final void a(String paramString, int paramInt, Throwable paramThrowable)
    {
      AppMethodBeat.i(184670);
      kotlin.g.b.p.h(paramString, "key");
      kotlin.g.b.p.h(paramThrowable, "e");
      Log.e("ThreadPool.Profiler", paramString + '@' + paramInt + ' ' + paramThrowable);
      AppMethodBeat.o(184670);
    }
    
    public final void g(String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(184672);
      kotlin.g.b.p.h(paramString1, "key");
      kotlin.g.b.p.h(paramString2, "pool");
      paramString2 = "[rejected] " + paramString1 + ' ' + paramString2 + " isShutdown=true";
      Log.w("ThreadPool.Profiler", paramString2);
      if (a.c(this.AVQ))
      {
        a.e(this.AVQ).remove(paramString1 + '@' + paramInt);
        String str = MMApplicationContext.getProcessName();
        e.Cxv.a(18762, new Object[] { Integer.valueOf(a.e.AVA.value), paramString2, paramString1, Integer.valueOf(17), str });
      }
      AppMethodBeat.o(184672);
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(184673);
      Log.w("ThreadPool.Profiler", "shutdown");
      a.e(this.AVQ).clear();
      AppMethodBeat.o(184673);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/threadpool/Printer$ThreadPrinter;", "onExit", "", "thread", "Ljava/lang/Thread;", "name", "", "id", "", "onInterrupt", "onStart", "plugin-performance_release"})
  public static final class n
    implements d.f
  {
    public final void a(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184674);
      kotlin.g.b.p.h(paramThread, "thread");
      kotlin.g.b.p.h(paramString, "name");
      Log.i("ThreadPool.Profiler", "[onInterrupt] name=" + paramString + " id=" + paramLong);
      AppMethodBeat.o(184674);
    }
    
    public final void b(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184675);
      kotlin.g.b.p.h(paramThread, "thread");
      kotlin.g.b.p.h(paramString, "name");
      Log.i("ThreadPool.Profiler", "[onThreadStart] name=" + paramString + " id=" + paramLong);
      a.b(this.AVQ).incrementAndGet();
      AppMethodBeat.o(184675);
    }
    
    public final void c(Thread paramThread, String paramString, long paramLong)
    {
      AppMethodBeat.i(184676);
      kotlin.g.b.p.h(paramThread, "thread");
      kotlin.g.b.p.h(paramString, "name");
      Log.i("ThreadPool.Profiler", "[onThreadExit] name=" + paramString + " id=" + paramLong);
      a.b(this.AVQ).decrementAndGet();
      AppMethodBeat.o(184676);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.a
 * JD-Core Version:    0.7.0.1
 */