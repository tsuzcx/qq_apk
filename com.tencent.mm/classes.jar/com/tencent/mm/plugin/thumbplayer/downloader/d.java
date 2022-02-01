package com.tencent.mm.plugin.thumbplayer.downloader;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/downloader/CdnVideoResourceDownloader;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader;", "task", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;", "(Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoResourceDownloader$VideoDownloadCallback;", "continuousSizes", "", "downloadedPercent", "", "finished", "", "finishedContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "finishedRet", "", "lock", "Ljava/lang/Object;", "mediaId", "getMediaId", "()Ljava/lang/String;", "moovReady", "moovReadyContinuation", "", "parser", "Lcom/tencent/mm/plugin/Atom/Mp4Parser;", "reporters", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/DownloadReporter;", "Lkotlin/collections/HashSet;", "requestRanges", "requestingData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "started", "svrLength", "", "Ljava/lang/Long;", "totalLength", "getTotalLength", "()J", "videoEventListener", "com/tencent/mm/plugin/thumbplayer/downloader/CdnVideoResourceDownloader$videoEventListener$1", "Lcom/tencent/mm/plugin/thumbplayer/downloader/CdnVideoResourceDownloader$videoEventListener$1;", "videoTime", "addReporter", "reporter", "awaitFinished", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitMoovReady", "cachedMills", "checkAvailable", "offset", "length", "checkHevcDownloadFinish", "isDownloaded", "isDownloading", "isTaskFinished", "onDataAvailable", "onDuplicateFileFound", "onFinish", "ret", "onMoovReady", "onProgress", "total", "progress", "request", "requestAll", "reset", "savedPath", "setCallback", "start", "stop", "toString", "Companion", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements i
{
  public static final d.a TCg;
  private com.tencent.mm.plugin.a.j RhG;
  private final String TAG;
  private final h TCh;
  private p<? super ah> TCi;
  private p<? super Boolean> TCj;
  private int TCk;
  private volatile boolean TCl;
  private float TCm;
  public i.d TCn;
  private final HashSet<String> TCo;
  private final long[] TCp;
  private Long TCq;
  private final AtomicBoolean TCr;
  private final HashSet<com.tencent.mm.plugin.thumbplayer.f.a> TCs;
  private final CdnVideoResourceDownloader.videoEventListener.1 TCt;
  private final Object lock;
  public volatile boolean mhq;
  private boolean started;
  private long videoTime;
  
  static
  {
    AppMethodBeat.i(272334);
    TCg = new d.a((byte)0);
    AppMethodBeat.o(272334);
  }
  
  public d(h paramh)
  {
    AppMethodBeat.i(272191);
    this.TCh = paramh;
    this.TAG = s.X("MicroMsg.CdnVideoResourceDownloader@", Integer.valueOf(hashCode()));
    this.RhG = new com.tencent.mm.plugin.a.j();
    this.TCo = new HashSet();
    this.lock = new Object();
    this.TCp = new long[2];
    this.TCr = new AtomicBoolean(false);
    this.TCs = new HashSet();
    this.TCt = new CdnVideoResourceDownloader.videoEventListener.1(this, f.hfK);
    AppMethodBeat.o(272191);
  }
  
  private final void bq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272216);
    Log.i(this.TAG, "onMoovReady: offset=" + paramLong1 + ", length=" + paramLong2 + ", mediaId=" + getMediaId());
    this.TCl = true;
    Object localObject1 = this.TCi;
    if (localObject1 != null)
    {
      localObject1 = (kotlin.d.d)localObject1;
      localObject2 = ah.aiuX;
      Result.Companion localCompanion = Result.Companion;
      ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(localObject2));
    }
    this.TCi = null;
    localObject1 = ((Iterable)this.TCs).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.f.a)((Iterator)localObject1).next()).bq(paramLong1, paramLong2);
    }
    localObject1 = this.TCh.hso();
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
      i = 1;
    }
    while ((i != 0) || (!com.tencent.mm.vfs.y.ZC((String)localObject1)))
    {
      Log.w(this.TAG, "onMoovReady but file is invalid, seems it has been deleted: path=" + localObject1 + ", filename=" + this.TCh.fZN());
      localObject1 = ((Iterable)this.TCs).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          ((com.tencent.mm.plugin.thumbplayer.f.a)((Iterator)localObject1).next()).hLw();
          continue;
          i = 0;
          break;
        }
      }
      AppMethodBeat.o(272216);
      return;
    }
    if (this.RhG.O((String)localObject1, paramLong1))
    {
      localObject1 = this.TCn;
      if (localObject1 != null) {
        ((i.d)localObject1).o(this.TCh.hsp());
      }
      localObject1 = ((Iterable)this.TCs).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.thumbplayer.f.a)((Iterator)localObject1).next()).hLx();
      }
      AppMethodBeat.o(272216);
      return;
    }
    localObject1 = ((Iterable)this.TCs).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.f.a)((Iterator)localObject1).next()).hLw();
    }
    v.bOi();
    com.tencent.mm.modelcdntran.j.v(getMediaId(), 0, -1);
    ab.bf(this.TCh.fZN(), 15);
    AppMethodBeat.o(272216);
  }
  
  private final void br(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272222);
    this.TCq = Long.valueOf(paramLong2);
    this.TCm = ((float)paramLong1 * 100.0F / (float)paramLong2);
    Log.i(this.TAG, "onProgress: " + paramLong1 + " / " + paramLong2 + " (" + this.TCm + "%)");
    i.d locald = this.TCn;
    if (locald != null) {
      locald.a(this.TCh.hsp(), paramLong1, paramLong2);
    }
    AppMethodBeat.o(272222);
  }
  
  private final void hKF()
  {
    AppMethodBeat.i(272199);
    if (com.tencent.mm.modelvideo.y.isH265Video(this.TCh.hso()))
    {
      Log.i(this.TAG, "download finish and is hevc need complete " + this.TCh.fZN() + " , mediaId=" + getMediaId());
      if (ab.Qs(this.TCh.fZN()))
      {
        Iterator localIterator = ((Iterable)this.TCs).iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.thumbplayer.f.a)localIterator.next()).hLA();
        }
      }
    }
    AppMethodBeat.o(272199);
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.f.a parama)
  {
    AppMethodBeat.i(272458);
    s.u(parama, "reporter");
    this.TCs.add(parama);
    AppMethodBeat.o(272458);
  }
  
  public final boolean aVB()
  {
    AppMethodBeat.i(272438);
    this.TCh.bDL();
    if (((this.mhq) && (this.TCk == 0)) || (this.TCh.isFinished()))
    {
      AppMethodBeat.o(272438);
      return true;
    }
    AppMethodBeat.o(272438);
    return false;
  }
  
  public final Object ao(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(272366);
    Object localObject1;
    if ((paramd instanceof d))
    {
      localObject1 = (d)paramd;
      if ((((d)localObject1).label & 0x80000000) != 0) {
        ((d)localObject1).label += -2147483648;
      }
    }
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new d(this, paramd))
    {
      localObject2 = paramd.result;
      localObject1 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272366);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    if (this.TCl)
    {
      paramd = ah.aiuX;
      AppMethodBeat.o(272366);
      return paramd;
    }
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject2 = new q(kotlin.d.a.b.au(paramd), 1);
    ((q)localObject2).kBA();
    p localp = (p)localObject2;
    this.TCi = localp;
    localp.bg((kotlin.g.a.b)new d.e(this));
    localObject2 = ((q)localObject2).getResult();
    if (localObject2 == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    paramd = this;
    if (localObject2 == localObject1)
    {
      AppMethodBeat.o(272366);
      return localObject1;
      paramd = (d)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    paramd.TCi = null;
    paramd = ah.aiuX;
    AppMethodBeat.o(272366);
    return paramd;
  }
  
  public final Object ap(kotlin.d.d<? super Boolean> paramd)
  {
    boolean bool1 = true;
    AppMethodBeat.i(272389);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject1;; paramd = new b(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272389);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    if (this.mhq)
    {
      if (this.TCk == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        AppMethodBeat.o(272389);
        return Boolean.valueOf(bool1);
      }
    }
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject1 = new q(kotlin.d.a.b.au(paramd), 1);
    ((q)localObject1).kBA();
    Object localObject2 = (p)localObject1;
    this.TCj = ((p)localObject2);
    ((p)localObject2).bg((kotlin.g.a.b)new c(this));
    localObject2 = ((q)localObject1).getResult();
    if (localObject2 == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    localObject1 = localObject2;
    paramd = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(272389);
      return locala;
      paramd = (d)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    boolean bool2 = ((Boolean)localObject1).booleanValue();
    paramd.TCj = null;
    if (bool2) {}
    for (;;)
    {
      AppMethodBeat.o(272389);
      return Boolean.valueOf(bool1);
      bool1 = false;
    }
  }
  
  public final long bo(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272398);
    if (aVB())
    {
      AppMethodBeat.o(272398);
      return paramLong2;
    }
    CdnLogic.queryContinuousSize(getMediaId(), paramLong1, this.TCp);
    paramLong1 = Math.min(this.TCp[0], paramLong2);
    AppMethodBeat.o(272398);
    return paramLong1;
  }
  
  public final boolean bp(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272406);
    if (this.TCr.get())
    {
      AppMethodBeat.o(272406);
      return false;
    }
    synchronized (this.lock)
    {
      boolean bool = this.TCo.contains("0_-1");
      if (bool)
      {
        AppMethodBeat.o(272406);
        return false;
      }
      bool = this.TCo.add(paramLong1 + '_' + paramLong2);
      if (!bool)
      {
        AppMethodBeat.o(272406);
        return false;
      }
      ah localah = ah.aiuX;
      Log.i(this.TAG, "request(" + paramLong1 + ", " + paramLong2 + "), mediaId=" + getMediaId());
      v.bOi();
      com.tencent.mm.modelcdntran.j.v(getMediaId(), (int)paramLong1, (int)paramLong2);
      this.TCr.set(true);
      AppMethodBeat.o(272406);
      return true;
    }
  }
  
  public final String getMediaId()
  {
    AppMethodBeat.i(272342);
    String str = this.TCh.getMediaId();
    AppMethodBeat.o(272342);
    return str;
  }
  
  public final long getTotalLength()
  {
    AppMethodBeat.i(272347);
    Long localLong = this.TCq;
    if (localLong == null)
    {
      l = this.TCh.RU();
      AppMethodBeat.o(272347);
      return l;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(272347);
    return l;
  }
  
  public final void hKC()
  {
    AppMethodBeat.i(272415);
    Log.i(this.TAG, "request all");
    synchronized (this.lock)
    {
      this.TCo.add("0_-1");
      v.bOi();
      com.tencent.mm.modelcdntran.j.v(getMediaId(), 0, -1);
      ??? = ((Iterable)this.TCs).iterator();
      if (((Iterator)???).hasNext()) {
        ((com.tencent.mm.plugin.thumbplayer.f.a)((Iterator)???).next()).hLz();
      }
    }
  }
  
  public final String hKD()
  {
    AppMethodBeat.i(272445);
    String str = this.TCh.hso();
    AppMethodBeat.o(272445);
    return str;
  }
  
  public final long hKE()
  {
    return this.videoTime;
  }
  
  public final float hKG()
  {
    return this.TCm;
  }
  
  public final boolean isDownloading()
  {
    AppMethodBeat.i(272423);
    if ((this.started) && (this.TCh.isDownloading()))
    {
      AppMethodBeat.o(272423);
      return true;
    }
    AppMethodBeat.o(272423);
    return false;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(272358);
    Log.i(this.TAG, s.X("start(), mediaId=", getMediaId()));
    if (!this.TCh.start())
    {
      Log.w(this.TAG, "task is not started successfully");
      AppMethodBeat.o(272358);
      return false;
    }
    this.started = true;
    this.TCt.alive();
    Log.i(this.TAG, "Start download online video " + getMediaId() + '-' + this.TCh.fZN());
    Object localObject = ((Iterable)this.TCs).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.f.a)((Iterator)localObject).next()).gZM();
    }
    localObject = this.TCh.hsr();
    if (localObject != null)
    {
      Log.i(this.TAG, "task is already in progress");
      if (((h.a)localObject).TCy > 0L) {
        bq(((h.a)localObject).TCx, ((h.a)localObject).TCy);
      }
      if (((h.a)localObject).qHg > 0L) {
        br(((h.a)localObject).hQO, ((h.a)localObject).qHg);
      }
    }
    AppMethodBeat.o(272358);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(272434);
    if (!this.started)
    {
      Log.w(this.TAG, "downloader hasn't been started, ignore call");
      AppMethodBeat.o(272434);
      return;
    }
    Log.i(this.TAG, "stop()");
    ??? = ((Iterable)this.TCs).iterator();
    while (((Iterator)???).hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.f.a)((Iterator)???).next()).hLs();
    }
    Log.i(this.TAG, s.X("reset(), mediaId=", getMediaId()));
    for (;;)
    {
      synchronized (this.lock)
      {
        this.TCo.clear();
        ah localah = ah.aiuX;
        if (EventCenter.instance.hadListened((IListener)this.TCt)) {
          this.TCt.dead();
        }
        this.TCr.set(false);
        ??? = this.TCi;
        if (??? != null) {
          ((p)???).P(null);
        }
        this.TCi = null;
        ??? = this.TCj;
        if (??? != null) {
          ((p)???).P(null);
        }
        this.TCj = null;
        ??? = (CharSequence)getMediaId();
        if ((??? == null) || (((CharSequence)???).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          AppMethodBeat.o(272434);
          return;
        }
      }
      int i = 0;
    }
    if (this.mhq) {
      hKF();
    }
    if ((this.TCm >= this.TCh.hsq()) && (!this.mhq))
    {
      this.TCh.hst();
      ??? = ((Iterable)this.TCs).iterator();
      while (((Iterator)???).hasNext()) {
        ((com.tencent.mm.plugin.thumbplayer.f.a)((Iterator)???).next()).hLu();
      }
      Log.i(this.TAG, "start complete video, downloaded (" + this.TCm + ") more than config (" + this.TCh.hsq() + ").");
    }
    this.TCh.stop();
    AppMethodBeat.o(272434);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(272467);
    String str = "CdnVideoResourceDownloader: mediaId=" + getMediaId() + ", savedPath=" + hKD() + ", moovReady=" + this.TCl + ", finished=" + this.mhq + ", totalLength=" + getTotalLength() + ", started=" + this.started + ", hashCode=" + hashCode();
    AppMethodBeat.o(272467);
    return str;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    b(d paramd, kotlin.d.d<? super b> paramd1)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272138);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.TCu.ap((kotlin.d.d)this);
      AppMethodBeat.o(272138);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Throwable, ah>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    d(d paramd, kotlin.d.d<? super d> paramd1)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(272133);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.TCu.ao((kotlin.d.d)this);
      AppMethodBeat.o(272133);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.downloader.d
 * JD-Core Version:    0.7.0.1
 */