package com.tencent.mm.plugin.thumbplayer.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.e;
import com.tencent.mm.f.a.pn;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.d.d<-Lkotlin.x;>;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.m;
import kotlinx.coroutines.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/downloader/CdnVideoResourceDownloader;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "task", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;", "(Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;)V", "continuousSizes", "", "downloadedPercent", "", "finished", "", "finishedContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "finishedRet", "", "lock", "Ljava/lang/Object;", "mediaId", "", "getMediaId", "()Ljava/lang/String;", "moovReady", "moovReadyContinuation", "", "parser", "Lcom/tencent/mm/plugin/Atom/Mp4Parser;", "reporters", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/DownloadReporter;", "Lkotlin/collections/HashSet;", "requestRanges", "requestingData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "started", "svrLength", "", "Ljava/lang/Long;", "totalLength", "getTotalLength", "()J", "videoEventListener", "com/tencent/mm/plugin/thumbplayer/downloader/CdnVideoResourceDownloader$videoEventListener$1", "Lcom/tencent/mm/plugin/thumbplayer/downloader/CdnVideoResourceDownloader$videoEventListener$1;", "videoTime", "addReporter", "reporter", "awaitFinished", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitMoovReady", "cachedMills", "checkAvailable", "offset", "length", "checkHevcDownloadFinish", "isDownloaded", "isTaskFinished", "onDataAvailable", "onDuplicateFileFound", "onFinish", "ret", "onMoovReady", "onProgress", "total", "progress", "request", "requestAll", "reset", "savedPath", "start", "stop", "Companion", "plugin-thumbplayer_release"})
public final class d
  implements i
{
  public static final d.a MPS;
  private j KIg;
  private m<? super x> MPG;
  private m<? super Boolean> MPH;
  private int MPI;
  private volatile boolean MPJ;
  private float MPK;
  private final HashSet<String> MPL;
  private final long[] MPM;
  private Long MPN;
  private final AtomicBoolean MPO;
  private final HashSet<com.tencent.mm.plugin.thumbplayer.g.a> MPP;
  private final f MPQ;
  private final h MPR;
  private volatile boolean jHM;
  private final Object lock;
  private boolean started;
  private long videoTime;
  
  static
  {
    AppMethodBeat.i(191313);
    MPS = new d.a((byte)0);
    AppMethodBeat.o(191313);
  }
  
  public d(h paramh)
  {
    AppMethodBeat.i(191310);
    this.MPR = paramh;
    this.KIg = new j();
    this.MPL = new HashSet();
    this.lock = new Object();
    this.MPM = new long[2];
    this.MPO = new AtomicBoolean(false);
    this.MPP = new HashSet();
    this.MPQ = new f(this);
    AppMethodBeat.o(191310);
  }
  
  private final void gnS()
  {
    AppMethodBeat.i(191304);
    if (v.isH265Video(this.MPR.fZd()))
    {
      Log.i("MicroMsg.CdnVideoResourceDownloader", "download finish and is hevc need complete " + this.MPR.eRe() + " , mediaId=" + getMediaId());
      if (y.Yo(this.MPR.eRe()))
      {
        Iterator localIterator = ((Iterable)this.MPP).iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.thumbplayer.g.a)localIterator.next()).goH();
        }
      }
    }
    AppMethodBeat.o(191304);
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.g.a parama)
  {
    AppMethodBeat.i(191308);
    p.k(parama, "reporter");
    this.MPP.add(parama);
    AppMethodBeat.o(191308);
  }
  
  public final boolean aCE()
  {
    AppMethodBeat.i(191296);
    this.MPR.bfU();
    if (((this.jHM) && (this.MPI == 0)) || (this.MPR.isFinished()))
    {
      AppMethodBeat.o(191296);
      return true;
    }
    AppMethodBeat.o(191296);
    return false;
  }
  
  public final long aE(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191287);
    if (aCE())
    {
      AppMethodBeat.o(191287);
      return paramLong2;
    }
    CdnLogic.queryContinuousSize(getMediaId(), paramLong1, this.MPM);
    paramLong1 = Math.min(this.MPM[0], paramLong2);
    AppMethodBeat.o(191287);
    return paramLong1;
  }
  
  public final boolean aF(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191289);
    if (this.MPO.get())
    {
      AppMethodBeat.o(191289);
      return false;
    }
    synchronized (this.lock)
    {
      boolean bool = this.MPL.contains("0_-1");
      if (bool)
      {
        AppMethodBeat.o(191289);
        return false;
      }
      bool = this.MPL.add(paramLong1 + '_' + paramLong2);
      if (!bool)
      {
        AppMethodBeat.o(191289);
        return false;
      }
      x localx = x.aazN;
      Log.i("MicroMsg.CdnVideoResourceDownloader", "request(" + paramLong1 + ", " + paramLong2 + "), mediaId=" + getMediaId());
      s.bqC();
      e.s(getMediaId(), (int)paramLong1, (int)paramLong2);
      this.MPO.set(true);
      AppMethodBeat.o(191289);
      return true;
    }
  }
  
  public final Object f(kotlin.d.d<? super x> paramd)
  {
    AppMethodBeat.i(191277);
    Object localObject1;
    if ((paramd instanceof e))
    {
      localObject1 = (e)paramd;
      if ((((e)localObject1).label & 0x80000000) != 0) {
        ((e)localObject1).label += -2147483648;
      }
    }
    for (paramd = (kotlin.d.d<? super x>)localObject1;; paramd = new e(this, paramd))
    {
      localObject2 = paramd.result;
      localObject1 = kotlin.d.a.a.aaAA;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(191277);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    if (this.MPJ)
    {
      paramd = x.aazN;
      AppMethodBeat.o(191277);
      return paramd;
    }
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject2 = new n(kotlin.d.a.b.k(paramd), 1);
    ((n)localObject2).iQM();
    m localm = (m)localObject2;
    this.MPG = localm;
    localm.am((kotlin.g.a.b)new d(this));
    localObject2 = ((n)localObject2).getResult();
    if (localObject2 == kotlin.d.a.a.aaAA) {
      p.k(paramd, "frame");
    }
    paramd = this;
    if (localObject2 == localObject1)
    {
      AppMethodBeat.o(191277);
      return localObject1;
      paramd = (d)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    paramd.MPG = null;
    paramd = x.aazN;
    AppMethodBeat.o(191277);
    return paramd;
  }
  
  public final Object g(kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(191283);
    if ((paramd instanceof c))
    {
      localObject1 = (c)paramd;
      if ((((c)localObject1).label & 0x80000000) != 0) {
        ((c)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject1;; paramd = new c(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aaAA;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(191283);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    if (this.jHM)
    {
      if (this.MPI == 0) {}
      for (bool = true;; bool = false)
      {
        AppMethodBeat.o(191283);
        return Boolean.valueOf(bool);
      }
    }
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject1 = new n(kotlin.d.a.b.k(paramd), 1);
    ((n)localObject1).iQM();
    Object localObject2 = (m)localObject1;
    this.MPH = ((m)localObject2);
    ((m)localObject2).am((kotlin.g.a.b)new b(this));
    localObject2 = ((n)localObject1).getResult();
    if (localObject2 == kotlin.d.a.a.aaAA) {
      p.k(paramd, "frame");
    }
    localObject1 = localObject2;
    paramd = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(191283);
      return locala;
      paramd = (d)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    boolean bool = ((Boolean)localObject1).booleanValue();
    paramd.MPH = null;
    AppMethodBeat.o(191283);
    return Boolean.valueOf(bool);
  }
  
  public final String getMediaId()
  {
    AppMethodBeat.i(191268);
    String str = this.MPR.getMediaId();
    AppMethodBeat.o(191268);
    return str;
  }
  
  public final long getTotalLength()
  {
    AppMethodBeat.i(191269);
    Long localLong = this.MPN;
    if (localLong != null)
    {
      l = localLong.longValue();
      AppMethodBeat.o(191269);
      return l;
    }
    long l = this.MPR.sr();
    AppMethodBeat.o(191269);
    return l;
  }
  
  public final void gnP()
  {
    AppMethodBeat.i(191291);
    Log.i("MicroMsg.CdnVideoResourceDownloader", "request all");
    synchronized (this.lock)
    {
      this.MPL.add("0_-1");
      s.bqC();
      e.s(getMediaId(), 0, -1);
      ??? = ((Iterable)this.MPP).iterator();
      if (((Iterator)???).hasNext()) {
        ((com.tencent.mm.plugin.thumbplayer.g.a)((Iterator)???).next()).goG();
      }
    }
  }
  
  public final String gnQ()
  {
    AppMethodBeat.i(191300);
    String str = u.n(this.MPR.fZd(), false);
    AppMethodBeat.o(191300);
    return str;
  }
  
  public final long gnR()
  {
    return this.videoTime;
  }
  
  public final float gnT()
  {
    return this.MPK;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(191273);
    Log.i("MicroMsg.CdnVideoResourceDownloader", "start(), mediaId=" + getMediaId());
    if (!this.MPR.start())
    {
      Log.w("MicroMsg.CdnVideoResourceDownloader", "task is not started successfully");
      AppMethodBeat.o(191273);
      return false;
    }
    this.started = true;
    this.MPQ.alive();
    Log.i("MicroMsg.CdnVideoResourceDownloader", "Start download online video " + getMediaId() + '-' + this.MPR.eRe());
    Iterator localIterator = ((Iterable)this.MPP).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.g.a)localIterator.next()).fJU();
    }
    AppMethodBeat.o(191273);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(191295);
    if (!this.started)
    {
      Log.w("MicroMsg.CdnVideoResourceDownloader", "downloader has been started, ignore call");
      AppMethodBeat.o(191295);
      return;
    }
    Log.i("MicroMsg.CdnVideoResourceDownloader", "stop()");
    ??? = ((Iterable)this.MPP).iterator();
    while (((Iterator)???).hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.g.a)((Iterator)???).next()).goz();
    }
    Log.i("MicroMsg.CdnVideoResourceDownloader", "reset(), mediaId=" + getMediaId());
    for (;;)
    {
      synchronized (this.lock)
      {
        this.MPL.clear();
        x localx = x.aazN;
        if (EventCenter.instance.hadListened((IListener)this.MPQ)) {
          this.MPQ.dead();
        }
        this.MPO.set(false);
        ??? = this.MPG;
        if (??? != null) {
          ((m)???).A(null);
        }
        this.MPG = null;
        ??? = this.MPH;
        if (??? != null) {
          ((m)???).A(null);
        }
        this.MPH = null;
        ??? = (CharSequence)getMediaId();
        if ((??? == null) || (((CharSequence)???).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          AppMethodBeat.o(191295);
          return;
        }
      }
      int i = 0;
    }
    if (this.jHM) {
      gnS();
    }
    if ((this.MPK >= this.MPR.fZe()) && (!this.jHM))
    {
      this.MPR.fZf();
      ??? = ((Iterable)this.MPP).iterator();
      while (((Iterator)???).hasNext()) {
        ((com.tencent.mm.plugin.thumbplayer.g.a)((Iterator)???).next()).goB();
      }
      Log.i("MicroMsg.CdnVideoResourceDownloader", "start complete video, downloaded (" + this.MPK + ") more than config (" + this.MPR.fZe() + ").");
    }
    this.MPR.stop();
    AppMethodBeat.o(191295);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/thumbplayer/downloader/CdnVideoResourceDownloader$awaitFinished$result$1$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<Throwable, x>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"awaitFinished", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    c(d paramd, kotlin.d.d paramd1)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(191820);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.MPT.g(this);
      AppMethodBeat.o(191820);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/thumbplayer/downloader/CdnVideoResourceDownloader$awaitMoovReady$2$1"})
  static final class d
    extends q
    implements kotlin.g.a.b<Throwable, x>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"awaitMoovReady", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    e(d paramd, kotlin.d.d paramd1)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(193265);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.MPT.f(this);
      AppMethodBeat.o(193265);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/thumbplayer/downloader/CdnVideoResourceDownloader$videoEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/OnlineVideoEvent;", "callback", "", "event", "plugin-thumbplayer_release"})
  public static final class f
    extends IListener<pn>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.d
 * JD-Core Version:    0.7.0.1
 */