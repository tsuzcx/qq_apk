package com.tencent.mm.plugin.thumbplayer.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.c.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.g;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.mm.xeffect.effect.j;
import com.tencent.mm.xeffect.effect.l;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.plugin.thumbplayer.a.b;>;
import java.util.ListIterator;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController;", "", "()V", "TAG", "", "callStartTime", "", "composition", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectVideoComposition;", "effectController", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController;", "firstFrameRenderCallback", "Lkotlin/Function0;", "", "getFirstFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFirstFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "freePlayers", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaPlayer;", "lastProgressUpdateTime", "logFirstFrameRender", "", "loop", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "Lkotlin/collections/ArrayList;", "mute", "onPlayFinishListener", "getOnPlayFinishListener", "setOnPlayFinishListener", "onProgressCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "timeMs", "mediaInfo", "getOnProgressCallback", "()Lkotlin/jvm/functions/Function2;", "setOnProgressCallback", "(Lkotlin/jvm/functions/Function2;)V", "pauseOnVideoPlay", "getPauseOnVideoPlay", "()Z", "setPauseOnVideoPlay", "(Z)V", "pendingPlayers", "playMediaChangeListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "getPlayMediaChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "setPlayMediaChangeListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;)V", "playRangeEndMs", "playRangeStartMs", "playStatus", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayStatus;", "playStatusChangeListener", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "getPlayStatusChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "setPlayStatusChangeListener", "(Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;)V", "playingPlayers", "progressUpdateFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "renderPts", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;)V", "seekTimeMs", "surface", "Landroid/graphics/SurfaceTexture;", "targetHeight", "", "targetWidth", "applyTrackListTransitions", "attachSurface", "callNextMediaChange", "currentMediaIndex", "callbackProgress", "checkLoopStartOrPlayFinished", "checkRemovePlayerTexture", "pts", "checkToPlayNext", "clearPlayRange", "createDefaultTransitionEffect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "createPlayerFromTrack", "track", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;", "needPreloadMedia", "detachSurface", "getCurrentPositionMs", "getDuration", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getMediaList", "", "getThumbFetcherExtraData", "locatePlayerMediaIndex", "player", "onFrameRender", "parseMediaList", "pause", "preloadMedia", "nextMediaIndex", "refreshFrame", "release", "releasePlayers", "requestSnapshot", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "resume", "seekTo", "seekToIndex", "index", "seekToIndexTime", "seekToTrackImpl", "trackSeekTime", "setLoop", "setMediaList", "resumePlayPosition", "setMute", "setPlayLoopForMedia", "media", "setPlayRange", "startTimeMs", "endTimeMs", "setPlayerSurface", "setSize", "width", "height", "setTrackTransition", "from", "to", "setTransition", "prevTransitionMedia", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "transitionPath", "setupPlayer", "start", "startProgressUpdate", "stop", "stopProgressUpdate", "videoAwaitStartProgress", "Companion", "PlayStatus", "PlayerStatusChangeListener", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a TCJ;
  private static final long TDg;
  private static final String TDh;
  private static final long TDi;
  public SurfaceTexture Ldt;
  public final String TAG;
  public c TCK;
  public com.tencent.mm.plugin.thumbplayer.view.d TCL;
  public boolean TCM;
  public kotlin.g.a.a<ah> TCN;
  public kotlin.g.a.m<? super Long, ? super com.tencent.mm.plugin.thumbplayer.a.b, ah> TCO;
  public kotlin.g.a.a<ah> TCQ;
  public final com.tencent.mm.videocomposition.effect.h TCR;
  public ConcurrentLinkedDeque<com.tencent.mm.plugin.thumbplayer.c.a.a> TCS;
  public ConcurrentLinkedDeque<com.tencent.mm.plugin.thumbplayer.c.a.a> TCT;
  public ConcurrentLinkedDeque<com.tencent.mm.plugin.thumbplayer.c.a.a> TCU;
  public d TCV;
  public volatile b TCW;
  public volatile long TCX;
  private com.tencent.threadpool.i.d<?> TCY;
  private long TCZ;
  private volatile long TDa;
  private volatile long TDb;
  public volatile long TDc;
  private boolean TDd;
  private long TDe;
  public com.tencent.mm.plugin.thumbplayer.d.c TDf;
  private boolean loop;
  public boolean nLP;
  private int nxO;
  private int nxP;
  public ArrayList<com.tencent.mm.plugin.thumbplayer.a.b> ofu;
  
  static
  {
    AppMethodBeat.i(272688);
    TCJ = new b.a((byte)0);
    com.tencent.mm.plugin.xlabeffect.c localc = com.tencent.mm.plugin.xlabeffect.c.XJQ;
    com.tencent.mm.plugin.xlabeffect.c.fXr();
    com.tencent.mm.plugin.xlabeffect.m.iGg();
    TDg = 500L;
    TDh = "pag/overlap.pag";
    TDi = 33L;
    AppMethodBeat.o(272688);
  }
  
  public b()
  {
    AppMethodBeat.i(272496);
    this.TAG = s.X("MicroMsg.MultiMediaEffectController@", Integer.valueOf(hashCode()));
    this.TCR = new com.tencent.mm.videocomposition.effect.h();
    this.TCS = new ConcurrentLinkedDeque();
    this.TCT = new ConcurrentLinkedDeque();
    this.TCU = new ConcurrentLinkedDeque();
    this.ofu = new ArrayList();
    this.TCW = b.TDj;
    this.TCZ = -1L;
    this.TDa = -1L;
    this.TDb = -1L;
    this.TDc = -1L;
    this.TDf = new com.tencent.mm.plugin.thumbplayer.d.c();
    this.TCR.pl(0, 0);
    this.TCR.agEA = ((kotlin.g.a.b)new b.1(this));
    AppMethodBeat.o(272496);
  }
  
  private final void a(com.tencent.mm.plugin.thumbplayer.c.a.a parama)
  {
    AppMethodBeat.i(272568);
    Log.i(this.TAG, s.X("setupPlayer:", parama));
    parama.TEd = ((kotlin.g.a.b)new j(this));
    parama.TEe = ((kotlin.g.a.b)new k(this));
    parama.TEf = ((kotlin.g.a.m)b.l.TDu);
    AppMethodBeat.o(272568);
  }
  
  private static final void a(b paramb, SurfaceTexture paramSurfaceTexture1, SurfaceTexture paramSurfaceTexture2)
  {
    AppMethodBeat.i(272591);
    s.u(paramb, "this$0");
    Log.i(paramb.TAG, "first frame available");
    paramb.hKK();
    paramSurfaceTexture1.setOnFrameAvailableListener(null);
    AppMethodBeat.o(272591);
  }
  
  private final void a(c paramc1, c paramc2)
  {
    AppMethodBeat.i(272552);
    Object localObject = this.TCR.GpO;
    g localg = paramc1.TDy;
    if (localg.isValid())
    {
      if (localg.Uby == null)
      {
        if (!y.ZC(localg.path)) {
          break label195;
        }
        localg.Uby = ((EffectManager)localObject).a(j.agXN, localg.path);
      }
      long l1 = paramc1.endTimeMs;
      long l2 = paramc1.endTimeMs + paramc2.TDy.duration;
      if ((l1 > 0L) && (l2 > 0L))
      {
        paramc1 = localg.Uby;
        if (paramc1 != null) {
          paramc1.bL(l1, l2);
        }
        ((EffectManager)localObject).b(localg.Uby);
      }
      paramc2 = this.TAG;
      localObject = new StringBuilder("set track transition time range:[").append(l1).append(',').append(l2).append("], effect:");
      paramc1 = localg.Uby;
      if (paramc1 != null) {
        break label207;
      }
    }
    label195:
    label207:
    for (paramc1 = null;; paramc1 = Long.valueOf(paramc1.id))
    {
      Log.i(paramc2, paramc1);
      AppMethodBeat.o(272552);
      return;
      localg.Uby = hKI();
      break;
    }
  }
  
  private final void aoE(int paramInt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(272563);
    Object localObject1 = this.TCV;
    if (localObject1 == null)
    {
      AppMethodBeat.o(272563);
      return;
    }
    if (paramInt >= ((d)localObject1).TDz.size())
    {
      AppMethodBeat.o(272563);
      return;
    }
    localObject1 = ((d)localObject1).TDz.get(paramInt);
    s.s(localObject1, "composition.trackList[nextMediaIndex]");
    c localc = (c)localObject1;
    com.tencent.mm.plugin.thumbplayer.a.b localb = localc.GvR;
    Iterator localIterator = ((Iterable)this.TCU).iterator();
    Object localObject4;
    label120:
    Object localObject2;
    label128:
    label140:
    boolean bool;
    if (localIterator.hasNext())
    {
      localObject4 = localIterator.next();
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject4).TEg;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localb != null) {
          break label290;
        }
        localObject2 = null;
        if (!s.p(localObject1, localObject2)) {
          break label298;
        }
        localObject1 = localObject4;
        localObject1 = (com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1;
        if (localObject1 == null) {
          break label305;
        }
        this.TCU.remove(localObject1);
        this.TCT.add(localObject1);
        bool = true;
        label169:
        localObject2 = this.TAG;
        localObject4 = new StringBuilder("preloadMedia, pendingPlayers.size:").append(this.TCT.size()).append(", nextMediaIndex:").append(paramInt).append(", mediaId:");
        if (localb != null) {
          break label337;
        }
      }
    }
    label290:
    label298:
    label305:
    label337:
    for (localObject1 = localObject3;; localObject1 = localb.mediaId)
    {
      Log.i((String)localObject2, localObject1 + ", fromFreePlayer:" + bool + ", freePlayers.size:" + this.TCU.size());
      AppMethodBeat.o(272563);
      return;
      localObject1 = ((c)localObject1).GvR;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label120;
      }
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).mediaId;
      break label120;
      localObject2 = localb.mediaId;
      break label128;
      break;
      localObject1 = null;
      break label140;
      localObject1 = a(localc);
      if (localObject1 == null)
      {
        AppMethodBeat.o(272563);
        return;
      }
      this.TCT.add(localObject1);
      bool = false;
      break label169;
    }
  }
  
  private final af hKI()
  {
    AppMethodBeat.i(272511);
    Object localObject = this.TCR.GpO;
    j localj = j.agXN;
    AssetManager localAssetManager = MMApplicationContext.getContext().getAssets();
    s.s(localAssetManager, "getContext().assets");
    localObject = ((EffectManager)localObject).a(localj, localAssetManager, TDh);
    AppMethodBeat.o(272511);
    return localObject;
  }
  
  private final void hKJ()
  {
    AppMethodBeat.i(272542);
    Object localObject1 = this.TCV;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((d)localObject1).TDz)
    {
      AppMethodBeat.o(272542);
      return;
    }
    int k = ((ArrayList)localObject1).size();
    if (1 < k) {}
    int j;
    for (int i = 1;; i = j)
    {
      j = i + 1;
      Object localObject2 = ((ArrayList)localObject1).get(i - 1);
      s.s(localObject2, "trackList[i - 1]");
      localObject2 = (c)localObject2;
      Object localObject3 = ((ArrayList)localObject1).get(i);
      s.s(localObject3, "trackList[i]");
      a((c)localObject2, (c)localObject3);
      if (j >= k)
      {
        AppMethodBeat.o(272542);
        return;
      }
    }
  }
  
  private final void hKK()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(272575);
        Log.i(this.TAG, s.X("startProgressUpdate ", this.TCW));
        if (this.TCY != null)
        {
          AppMethodBeat.o(272575);
          return;
        }
        TimerTask localTimerTask = (TimerTask)new m(this);
        if (this.TCW == b.TDl)
        {
          localTimerTask.run();
          this.TCZ = -1L;
          Log.i(this.TAG, "do startProgressUpdate");
          AppMethodBeat.o(272575);
        }
        else
        {
          this.TCY = com.tencent.threadpool.h.ahAA.b((Runnable)localObject, 0L, TDi);
        }
      }
      finally {}
    }
  }
  
  private final void hKL()
  {
    AppMethodBeat.i(272583);
    Log.i(this.TAG, "stopProgressUpdate");
    com.tencent.threadpool.i.d locald = this.TCY;
    if (locald != null) {
      locald.cancel(false);
    }
    this.TCY = null;
    AppMethodBeat.o(272583);
  }
  
  private final void hKM()
  {
    try
    {
      AppMethodBeat.i(272587);
      Iterator localIterator1 = ((Iterable)this.TCS).iterator();
      while (localIterator1.hasNext())
      {
        com.tencent.mm.plugin.thumbplayer.c.a.a locala = (com.tencent.mm.plugin.thumbplayer.c.a.a)localIterator1.next();
        locala.stop();
        locala.release();
        this.TCR.bEz(locala.key);
      }
      localIterator2 = ((Iterable)this.TCU).iterator();
    }
    finally {}
    while (localIterator2.hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.c.a.a)localIterator2.next()).release();
    }
    Iterator localIterator2 = ((Iterable)this.TCT).iterator();
    while (localIterator2.hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.c.a.a)localIterator2.next()).release();
    }
    this.TCS.clear();
    this.TCT.clear();
    this.TCU.clear();
    AppMethodBeat.o(272587);
  }
  
  private final void lC(List<? extends com.tencent.mm.plugin.thumbplayer.a.b> paramList)
  {
    AppMethodBeat.i(272532);
    this.TCR.GpO.jQl();
    Object localObject1 = this.TCR.GpO.jQk();
    ((l)localObject1).jQn();
    if (((l)localObject1).agYl != 0.42F)
    {
      VLogEffectJNI.INSTANCE.nSetGradientBlurContentOffsetPercent(((af)localObject1).ptr, 0.42F);
      ((l)localObject1).agYl = 0.42F;
    }
    Object localObject2 = new ArrayList();
    paramList = (Iterable)paramList;
    int i = 0;
    Object localObject3 = paramList.iterator();
    paramList = null;
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if (i < 0) {
        p.kkW();
      }
      localObject4 = (com.tencent.mm.plugin.thumbplayer.a.b)localObject1;
      localObject1 = new c();
      ((c)localObject1).GvR = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject4);
      label214:
      float f;
      label244:
      int j;
      if ((((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).TBM >= 0L) && (((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).TBN > 0L))
      {
        ((c)localObject1).startTimeMs = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).TBM;
        ((c)localObject1).endTimeMs = (((c)localObject1).startTimeMs + ((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).TBN);
        ((c)localObject1).TDw = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).TBO;
        ((c)localObject1).TDx = (((c)localObject1).TDw + ((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).TBN);
        if ((localObject4 instanceof com.tencent.mm.plugin.thumbplayer.d.d))
        {
          if (((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TEV <= 0.0F) {
            break label571;
          }
          f = ((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).TEV;
          ((c)localObject1).sAn = f;
        }
        ((c)localObject1).TDy.duration = TDg;
        paramList = ((c)localObject1).GvR;
        if ((paramList == null) || (paramList.TBL)) {
          break label576;
        }
        j = 1;
        label281:
        if (j != 0)
        {
          paramList = (com.tencent.mm.plugin.thumbplayer.d.d)localObject4;
          if (paramList != null) {
            break label582;
          }
          paramList = null;
          label298:
          CharSequence localCharSequence = (CharSequence)paramList;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label590;
          }
          j = 1;
          label322:
          if ((j == 0) && (y.ZC(paramList))) {
            break label596;
          }
          ((c)localObject1).TDy.Uby = hKI();
          ((c)localObject1).TDy.setPath(TDh);
        }
        label357:
        if (!(localObject4 instanceof com.tencent.mm.plugin.thumbplayer.d.d)) {
          break label619;
        }
        if (!((com.tencent.mm.plugin.thumbplayer.d.d)localObject4).hLc()) {
          break label608;
        }
        ((c)localObject1).a(com.tencent.mm.plugin.thumbplayer.c.a.b.TEj);
      }
      for (;;)
      {
        ((ArrayList)localObject2).add(localObject1);
        Log.i(this.TAG, "create track, media:" + ((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).mediaId + ", type:" + ((c)localObject1).TDv + ", timeRange:[" + ((c)localObject1).startTimeMs + ',' + ((c)localObject1).endTimeMs + "], trackTimeRange:[" + ((c)localObject1).TDw + ',' + ((c)localObject1).TDx + ']');
        i += 1;
        paramList = (List<? extends com.tencent.mm.plugin.thumbplayer.a.b>)localObject1;
        break;
        if (((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).vYw <= 0L) {
          break label214;
        }
        if (paramList == null) {}
        for (long l = 0L;; l = paramList.endTimeMs)
        {
          ((c)localObject1).startTimeMs = l;
          ((c)localObject1).endTimeMs = (((c)localObject1).startTimeMs + ((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).vYw);
          ((c)localObject1).TDw = 0L;
          ((c)localObject1).TDx = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject4).vYw;
          break;
        }
        label571:
        f = 1.0F;
        break label244;
        label576:
        j = 0;
        break label281;
        label582:
        paramList = paramList.TEX;
        break label298;
        label590:
        j = 0;
        break label322;
        label596:
        ((c)localObject1).TDy.setPath(paramList);
        break label357;
        label608:
        ((c)localObject1).a(com.tencent.mm.plugin.thumbplayer.c.a.b.TEk);
        continue;
        label619:
        ((c)localObject1).a(com.tencent.mm.plugin.thumbplayer.c.a.b.TEk);
      }
    }
    this.TCV = new d((List)localObject2);
    hKJ();
    localObject1 = this.TAG;
    paramList = this.TCV;
    if (paramList == null)
    {
      paramList = null;
      Log.i((String)localObject1, s.X("parseMediaList finished, total duration:", paramList));
      paramList = this.TCV;
      if (paramList == null) {
        break label869;
      }
      paramList = paramList.TDz;
      if (paramList == null) {
        break label869;
      }
      localObject1 = ((Iterable)paramList).iterator();
      label708:
      if (!((Iterator)localObject1).hasNext()) {
        break label869;
      }
      localObject2 = (c)((Iterator)localObject1).next();
      localObject3 = this.TAG;
      localObject4 = new StringBuilder("track media:");
      paramList = ((c)localObject2).GvR;
      if (paramList != null) {
        break label861;
      }
    }
    label861:
    for (paramList = null;; paramList = paramList.mediaId)
    {
      Log.i((String)localObject3, paramList + ", type:" + ((c)localObject2).TDv + ", timeRange:[" + ((c)localObject2).startTimeMs + ',' + ((c)localObject2).endTimeMs + "], trackTimeRange:[" + ((c)localObject2).TDw + ',' + ((c)localObject2).TDx + ']');
      break label708;
      paramList = Long.valueOf(paramList.getDuration());
      break;
    }
    label869:
    AppMethodBeat.o(272532);
  }
  
  public final com.tencent.mm.plugin.thumbplayer.c.a.a a(c paramc)
  {
    Object localObject1 = null;
    AppMethodBeat.i(272732);
    com.tencent.mm.plugin.thumbplayer.a.b localb = paramc.GvR;
    if (localb == null)
    {
      AppMethodBeat.o(272732);
      return null;
    }
    Object localObject2 = paramc.TDv;
    switch (b.d.$EnumSwitchMapping$0[localObject2.ordinal()])
    {
    default: 
      Log.e(this.TAG, "unknown track type!");
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1).TEg = paramc;
        if ((paramc.TDw >= 0L) && (paramc.TDx > 0L)) {
          ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1).bs(paramc.TDw, paramc.TDx);
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1).bt(paramc.startTimeMs, paramc.endTimeMs);
        ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1).setLoop(localb.loop);
        ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1).setMute(this.nLP);
        ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1).hKS();
        a((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1);
      }
      AppMethodBeat.o(272732);
      return localObject1;
      localObject1 = new e();
      ((e)localObject1).mi(this.nxO, this.nxP);
      ((e)localObject1).setMediaInfo(localb);
      if (((localb instanceof com.tencent.mm.plugin.thumbplayer.d.d)) && (((com.tencent.mm.plugin.thumbplayer.d.d)localb).TEV > 0.0F)) {
        ((e)localObject1).setPlayRate(((com.tencent.mm.plugin.thumbplayer.d.d)localb).TEV);
      }
      ((e)localObject1).setLoop(localb.loop);
      localObject1 = (com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1;
      continue;
      localObject1 = new com.tencent.mm.plugin.thumbplayer.c.a.c();
      ((com.tencent.mm.plugin.thumbplayer.c.a.c)localObject1).mi(this.nxO, this.nxP);
      ((com.tencent.mm.plugin.thumbplayer.c.a.c)localObject1).setMediaInfo(localb);
      localObject2 = localb.path;
      s.s(localObject2, "mediaInfo.path");
      String str = localb.url;
      s.s(str, "mediaInfo.url");
      ((com.tencent.mm.plugin.thumbplayer.c.a.c)localObject1).L((String)localObject2, str, localb.decodeKey, localb.msf);
      localObject1 = (com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1;
    }
  }
  
  public final void a(c paramc, final long paramLong)
  {
    int i = 1;
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(272755);
    hKL();
    Object localObject3 = (com.tencent.mm.plugin.thumbplayer.c.a.a)p.f((Iterable)this.TCS);
    this.TCW = b.TDn;
    if ((localObject3 != null) && (s.p(((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject3).TEg, paramc)))
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("seekTo locate to first playing player, trackSeekTime:").append(paramLong).append(", isStarted:").append(((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject3).isStarted()).append(", isPlaying:").append(((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject3).isPlaying()).append(", defaultVideo:");
      localObject1 = paramc.GvR;
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        Log.i(str, localObject1);
        paramc = paramc.GvR;
        if ((paramc == null) || (paramc.TBL)) {
          break label233;
        }
        label160:
        if (i == 0) {
          break label239;
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject3).d(paramLong, (kotlin.g.a.a)new h(this, paramLong, (com.tencent.mm.plugin.thumbplayer.c.a.a)localObject3));
      }
    }
    for (;;)
    {
      if (!((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject3).isStarted())
      {
        this.TCW = b.TDk;
        if (((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject3).cxs())
        {
          ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject3).resume();
          AppMethodBeat.o(272755);
          return;
          localObject1 = Boolean.valueOf(((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).TBL);
          break;
          label233:
          i = 0;
          break label160;
          label239:
          this.TCW = b.TDk;
          hKK();
          continue;
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject3).start();
        AppMethodBeat.o(272755);
        return;
        hKM();
        localObject2 = a(paramc);
        if (localObject2 == null)
        {
          AppMethodBeat.o(272755);
          return;
        }
        ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject2).start();
        localObject3 = paramc.GvR;
        if ((localObject3 == null) || (((com.tencent.mm.plugin.thumbplayer.a.b)localObject3).TBL)) {
          break label414;
        }
        i = 1;
        if (i != 0) {
          ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject2).d(paramLong, null);
        }
        this.TCS.add(localObject2);
        localObject2 = this.TAG;
        localObject3 = new StringBuilder("seekTo create new player, trackSeekTime:").append(paramLong).append(", playingPlayers.size:").append(this.TCS.size()).append(", defaultVideo:");
        paramc = paramc.GvR;
        if (paramc != null) {
          break label420;
        }
      }
    }
    label414:
    label420:
    for (paramc = (c)localObject1;; paramc = Boolean.valueOf(paramc.TBL))
    {
      Log.i((String)localObject2, paramc);
      AppMethodBeat.o(272755);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.d.d paramd, String paramString)
  {
    AppMethodBeat.i(272713);
    s.u(paramd, "prevTransitionMedia");
    Log.i(this.TAG, "setTransition, mediaId:" + paramd.mediaId + ", transitionPath:" + paramString);
    Object localObject1 = this.TCV;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((d)localObject1).TDz)
    {
      AppMethodBeat.o(272713);
      return;
    }
    Object localObject3 = ((List)localObject1).iterator();
    int i = 0;
    Object localObject2;
    label137:
    int j;
    if (((Iterator)localObject3).hasNext())
    {
      c localc = (c)((Iterator)localObject3).next();
      localObject2 = localc.GvR;
      if (localObject2 == null)
      {
        localObject2 = null;
        if (!s.p(localObject2, paramd.mediaId)) {
          break label410;
        }
        localObject2 = localc.GvR;
        if ((localObject2 == null) || (((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).TBM != paramd.TBM)) {
          break label398;
        }
        j = 1;
        label177:
        if (j == 0) {
          break label410;
        }
        localObject2 = localc.GvR;
        if ((localObject2 == null) || (((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).TBN != paramd.TBN)) {
          break label404;
        }
        j = 1;
        label210:
        if (j == 0) {
          break label410;
        }
        j = 1;
        label218:
        if (j == 0) {
          break label416;
        }
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "found transition trackIndex:" + localObject1 + ", trackList.size:" + ((ArrayList)localObject1).size());
      if ((i >= 0) && (i < ((ArrayList)localObject1).size() - 1))
      {
        paramd = this.TCR.GpO;
        localObject2 = ((ArrayList)localObject1).get(i);
        s.s(localObject2, "trackList[trackIndex]");
        localObject2 = (c)localObject2;
        localObject1 = ((ArrayList)localObject1).get(i + 1);
        s.s(localObject1, "trackList[trackIndex + 1]");
        localObject1 = (c)localObject1;
        localObject3 = ((c)localObject2).TDy;
        if (((g)localObject3).Uby != null)
        {
          paramd.c(((g)localObject3).Uby);
          ((g)localObject3).Uby = null;
        }
        if (paramString != null)
        {
          ((g)localObject3).setPath(paramString);
          a((c)localObject2, (c)localObject1);
        }
      }
      AppMethodBeat.o(272713);
      return;
      localObject2 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2).mediaId;
      break label137;
      label398:
      j = 0;
      break label177;
      label404:
      j = 0;
      break label210;
      label410:
      j = 0;
      break label218;
      label416:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void bs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272717);
    Log.i(this.TAG, "setPlayRange:[" + paramLong1 + ", " + paramLong2 + "], renderPts:" + this.TCX + ", playStatus:" + this.TCW);
    this.TDa = paramLong1;
    this.TDb = paramLong2;
    if (this.TCW == b.TDk) {
      seekTo(this.TDa);
    }
    AppMethodBeat.o(272717);
  }
  
  public final void gqM()
  {
    AppMethodBeat.i(272723);
    this.TCR.ls(this.TCX);
    AppMethodBeat.o(272723);
  }
  
  public final void hKH()
  {
    AppMethodBeat.i(272720);
    Log.i(this.TAG, "clearPlayRange");
    this.TDa = -1L;
    this.TDb = -1L;
    AppMethodBeat.o(272720);
  }
  
  public final void lB(List<? extends com.tencent.mm.plugin.thumbplayer.a.b> paramList)
  {
    AppMethodBeat.i(272701);
    s.u(paramList, "mediaList");
    Log.i(this.TAG, "setMediaList size:" + paramList.size() + ", playStatus:" + this.TCW + ", resumePlayPosition:false, renderPts:" + this.TCX);
    hKL();
    hKM();
    this.ofu.clear();
    this.TCV = null;
    this.ofu.addAll((Collection)paramList);
    lC(paramList);
    if (this.TCW == b.TDj)
    {
      aoE(0);
      AppMethodBeat.o(272701);
      return;
    }
    if (this.TCW == b.TDn)
    {
      paramList = this.TCV;
      if (paramList == null) {
        paramList = null;
      }
      while (paramList == null)
      {
        AppMethodBeat.o(272701);
        return;
        paramList = paramList.TDz;
        if (paramList == null)
        {
          paramList = null;
        }
        else
        {
          paramList = (List)paramList;
          paramList = paramList.listIterator(paramList.size());
          label191:
          if (paramList.hasPrevious())
          {
            c localc = (c)paramList.previous();
            long l1 = localc.startTimeMs;
            long l2 = localc.endTimeMs;
            long l3 = this.TDc;
            if (l1 <= l3) {
              if (l3 <= l2)
              {
                i = 1;
                label247:
                if (i == 0) {
                  break label274;
                }
              }
            }
          }
          for (i = paramList.nextIndex();; i = -1)
          {
            paramList = Integer.valueOf(i);
            break;
            i = 0;
            break label247;
            i = 0;
            break label247;
            label274:
            break label191;
          }
        }
      }
      int i = paramList.intValue();
      Log.i(this.TAG, "setMediaList in seeking, seekTime:" + this.TDc + ", trackIndex:" + i);
      aoE(i);
      paramList = (com.tencent.mm.plugin.thumbplayer.c.a.a)this.TCT.removeLast();
      this.TCS.add(paramList);
      AppMethodBeat.o(272701);
      return;
    }
    if (this.TCW == b.TDk)
    {
      this.TCX = 0L;
      start();
    }
    AppMethodBeat.o(272701);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(272747);
    Log.i(this.TAG, "pause, current status:" + this.TCW + ", playingPlayers.size:" + this.TCS.size());
    if (this.TCS.isEmpty())
    {
      AppMethodBeat.o(272747);
      return;
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a.a)this.TCS.getFirst()).pause();
    this.TCW = b.TDl;
    c localc = this.TCK;
    if (localc != null) {
      localc.onPause();
    }
    hKL();
    AppMethodBeat.o(272747);
  }
  
  public final void q(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(272726);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.setOnFrameAvailableListener(new b..ExternalSyntheticLambda0(this, paramSurfaceTexture));
    }
    AppMethodBeat.o(272726);
  }
  
  public final void release()
  {
    try
    {
      AppMethodBeat.i(272736);
      this.TCR.release();
      this.TCR.jMc();
      hKM();
      this.TCV = null;
      this.ofu.clear();
      this.TCW = b.TDj;
      AppMethodBeat.o(272736);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(272745);
    Log.i(this.TAG, "resume: " + this.TCW + ", " + this.TCS.size());
    if (this.TCW == b.TDk)
    {
      AppMethodBeat.o(272745);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.thumbplayer.c.a.a)p.f((Iterable)this.TCS);
    if (localObject == null)
    {
      AppMethodBeat.o(272745);
      return;
    }
    Log.i(this.TAG, s.X("resume: ", Boolean.valueOf(((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject).cxs())));
    if (!((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject).cxs())
    {
      this.TCW = b.TDk;
      AppMethodBeat.o(272745);
      return;
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject).resume();
    this.TCW = b.TDk;
    localObject = this.TCK;
    if (localObject != null) {
      ((c)localObject).onResume();
    }
    hKK();
    AppMethodBeat.o(272745);
  }
  
  public final void seekTo(long paramLong)
  {
    ListIterator localListIterator = null;
    AppMethodBeat.i(272751);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("seekTo:").append(paramLong).append(", renderPts:").append(this.TCX).append(", playingPlayers.size:").append(this.TCS.size()).append(", status:").append(this.TCW).append(", trackList.size:");
    Object localObject1 = this.TCV;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.printInfoStack((String)localObject2, localObject1, new Object[0]);
      localObject1 = this.TCV;
      if (localObject1 != null) {
        break label170;
      }
      localObject1 = localListIterator;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(272751);
        return;
        localObject1 = ((d)localObject1).TDz;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
        break;
        label170:
        localObject2 = ((d)localObject1).TDz;
        localObject1 = localListIterator;
        if (localObject2 != null)
        {
          localObject1 = (List)localObject2;
          localListIterator = ((List)localObject1).listIterator(((List)localObject1).size());
          label209:
          int i;
          if (localListIterator.hasPrevious())
          {
            localObject1 = localListIterator.previous();
            localObject2 = (c)localObject1;
            l = ((c)localObject2).startTimeMs;
            if (paramLong <= ((c)localObject2).endTimeMs) {
              if (l <= paramLong)
              {
                i = 1;
                label261:
                if (i == 0) {
                  break label283;
                }
              }
            }
          }
          for (;;)
          {
            localObject1 = (c)localObject1;
            break;
            i = 0;
            break label261;
            i = 0;
            break label261;
            label283:
            break label209;
            localObject1 = null;
          }
        }
      }
    }
    long l = paramLong - ((c)localObject1).startTimeMs + ((c)localObject1).TDw;
    Log.i(this.TAG, "found seek target track:" + localObject1 + ", trackSeekTime:" + l + ", trackStartTimeMs:" + ((c)localObject1).TDw);
    this.TDc = paramLong;
    a((c)localObject1, l);
    AppMethodBeat.o(272751);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(272707);
    Log.i(this.TAG, s.X("setLoop:", Boolean.valueOf(paramBoolean)));
    this.loop = paramBoolean;
    AppMethodBeat.o(272707);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272695);
    Log.i(this.TAG, "setSize:[" + paramInt1 + ',' + paramInt2 + ']');
    this.TCR.setSize(paramInt1, paramInt2);
    this.nxO = paramInt1;
    this.nxP = paramInt2;
    Iterator localIterator = ((Iterable)this.TCS).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.c.a.a)localIterator.next()).mi(paramInt1, paramInt2);
    }
    localIterator = ((Iterable)this.TCT).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.c.a.a)localIterator.next()).mi(paramInt1, paramInt2);
    }
    AppMethodBeat.o(272695);
  }
  
  public final void start()
  {
    AppMethodBeat.i(272742);
    Log.i(this.TAG, "start, current status:" + this.TCW + ", playingPlayers.size:" + this.TCS.size() + ", pendingPlayers.size:" + this.TCT.size());
    if (this.ofu.isEmpty())
    {
      Log.e(this.TAG, "start ignore not set mediaList");
      AppMethodBeat.o(272742);
      return;
    }
    if (this.TCW != b.TDk) {
      if (((Collection)this.TCS).isEmpty()) {
        break label320;
      }
    }
    label320:
    for (int i = 1;; i = 0)
    {
      Object localObject;
      if (this.TCS.isEmpty())
      {
        this.TCX = 0L;
        if (this.TCT.isEmpty()) {
          aoE(0);
        }
        localObject = (com.tencent.mm.plugin.thumbplayer.c.a.a)this.TCT.removeFirst();
        this.TCS.add(localObject);
      }
      if (this.TCS.isEmpty()) {
        Log.e(this.TAG, "start error playingPlayers is empty");
      }
      this.TCW = b.TDk;
      ((com.tencent.mm.plugin.thumbplayer.c.a.a)p.e((Iterable)this.TCS)).start();
      if (i != 0)
      {
        localObject = this.TCK;
        if (localObject != null) {
          ((c)localObject).onResume();
        }
      }
      Log.i(this.TAG, s.X("start finished, playingPlayers.size:", Integer.valueOf(this.TCS.size())));
      if (this.TDa > 0L)
      {
        Log.i(this.TAG, s.X("start finished seekTo playRange start:", Long.valueOf(this.TDa)));
        seekTo(this.TDa);
      }
      this.TDe = Util.currentTicks();
      this.TDd = false;
      this.TDf.moe = Util.currentTicks();
      AppMethodBeat.o(272742);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(272749);
    Log.i(this.TAG, "stop, current status:" + this.TCW + ", playingPlayers.size:" + this.TCS.size());
    if (this.TCS.isEmpty())
    {
      AppMethodBeat.o(272749);
      return;
    }
    ((com.tencent.mm.plugin.thumbplayer.c.a.a)this.TCS.getFirst()).stop();
    hKM();
    this.TCW = b.TDm;
    hKL();
    AppMethodBeat.o(272749);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayStatus;", "", "(Ljava/lang/String;I)V", "Unknown", "Started", "Pause", "Stop", "Seeking", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(272561);
      TDj = new b("Unknown", 0);
      TDk = new b("Started", 1);
      TDl = new b("Pause", 2);
      TDm = new b("Stop", 3);
      TDn = new b("Seeking", 4);
      TDo = new b[] { TDj, TDk, TDl, TDm, TDn };
      AppMethodBeat.o(272561);
    }
    
    private b() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "", "onPause", "", "onResume", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void onPause();
    
    public abstract void onResume();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(b paramb, long paramLong, com.tencent.mm.plugin.thumbplayer.c.a.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaPlayer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.c.a.a, ah>
  {
    j(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaPlayer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.c.a.a, ah>
  {
    k(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class m
    extends TimerTask
  {
    public m(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(272489);
      if ((b.c(this.TDp).isEmpty()) && (b.h(this.TDp).isEmpty()))
      {
        Log.i(b.a(this.TDp), "finished play all player");
        b.i(this.TDp);
      }
      long l1;
      long l2;
      int i;
      if (b.j(this.TDp) >= 0L)
      {
        b.a(this.TDp, b.j(this.TDp));
        Log.i(b.a(this.TDp), s.X("onProgressUpdate set renderPts to seekTime:", Long.valueOf(b.j(this.TDp))));
        b.k(this.TDp);
        b.m(this.TDp).ls(b.f(this.TDp));
        b.b(this.TDp, b.f(this.TDp));
        b.c(this.TDp, b.f(this.TDp));
        l1 = b.f(this.TDp);
        l2 = b.n(this.TDp);
        if (1L > l2) {
          break label303;
        }
        if (l2 > l1) {
          break label298;
        }
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (b.o(this.TDp) >= 0L)) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.n(this.TDp));
        }
        b.q(this.TDp);
        b.d(this.TDp, Util.currentTicks());
        AppMethodBeat.o(272489);
        return;
        b localb = this.TDp;
        l2 = b.f(localb);
        if (b.l(this.TDp) > 0L) {}
        for (l1 = Util.currentTicks() - b.l(this.TDp);; l1 = b.hKN())
        {
          b.a(localb, l1 + l2);
          break;
        }
        label298:
        i = 0;
        continue;
        label303:
        i = 0;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<ah>
  {
    n(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.b
 * JD-Core Version:    0.7.0.1
 */