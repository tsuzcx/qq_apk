package com.tencent.mm.plugin.thumbplayer.d;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.af;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.plugin.thumbplayer.e.d;>;
import java.util.ListIterator;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.a.m;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController;", "", "()V", "TAG", "", "callStartTime", "", "composition", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectVideoComposition;", "effectController", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController;", "firstFrameRenderCallback", "Lkotlin/Function0;", "", "getFirstFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFirstFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "freePlayers", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaPlayer;", "lastProgressUpdateTime", "logFirstFrameRender", "", "loop", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "Lkotlin/collections/ArrayList;", "mute", "onPlayFinishListener", "getOnPlayFinishListener", "setOnPlayFinishListener", "onProgressCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "timeMs", "mediaInfo", "getOnProgressCallback", "()Lkotlin/jvm/functions/Function2;", "setOnProgressCallback", "(Lkotlin/jvm/functions/Function2;)V", "pauseOnVideoPlay", "getPauseOnVideoPlay", "()Z", "setPauseOnVideoPlay", "(Z)V", "pendingPlayers", "playMediaChangeListener", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "getPlayMediaChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "setPlayMediaChangeListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;)V", "playRangeEndMs", "playRangeStartMs", "playStatus", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayStatus;", "playStatusChangeListener", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "getPlayStatusChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "setPlayStatusChangeListener", "(Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;)V", "playingPlayers", "progressUpdateFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "renderPts", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "setReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;)V", "seekTimeMs", "surface", "Landroid/graphics/SurfaceTexture;", "targetHeight", "", "targetWidth", "applyTrackListTransitions", "attachSurface", "callNextMediaChange", "currentMediaIndex", "callbackProgress", "checkLoopStartOrPlayFinished", "checkRemovePlayerTexture", "pts", "checkToPlayNext", "clearPlayRange", "createDefaultTransitionEffect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "createPlayerFromTrack", "track", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;", "needPreloadMedia", "detachSurface", "getCurrentPositionMs", "getDuration", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getMediaList", "", "getThumbFetcherExtraData", "locatePlayerMediaIndex", "player", "onFrameRender", "parseMediaList", "pause", "preloadMedia", "nextMediaIndex", "refreshFrame", "release", "releasePlayers", "requestSnapshot", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "resume", "seekTo", "seekToIndex", "index", "seekToIndexTime", "seekToTrackImpl", "trackSeekTime", "setLoop", "setMediaList", "resumePlayPosition", "setMute", "setPlayLoopForMedia", "media", "setPlayRange", "startTimeMs", "endTimeMs", "setPlayerSurface", "setSize", "width", "height", "setTrackTransition", "from", "to", "setTransition", "prevTransitionMedia", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "transitionPath", "setupPlayer", "start", "startProgressUpdate", "stop", "stopProgressUpdate", "videoAwaitStartProgress", "Companion", "PlayStatus", "PlayerStatusChangeListener", "plugin-thumbplayer_release"})
public final class c
{
  private static final long MQC = 500L;
  private static final String MQD = "pag/overlap.pag";
  private static final long MQE = 33L;
  public static final c.a MQF;
  public SurfaceTexture FhU;
  private long MQA;
  public com.tencent.mm.plugin.thumbplayer.e.c MQB;
  public c MQh;
  public com.tencent.mm.plugin.thumbplayer.view.d MQi;
  public boolean MQj;
  public kotlin.g.a.a<x> MQk;
  public m<? super Long, ? super com.tencent.mm.plugin.thumbplayer.e.d, x> MQl;
  public kotlin.g.a.a<x> MQm;
  public final com.tencent.mm.videocomposition.effect.g MQn;
  public ConcurrentLinkedDeque<com.tencent.mm.plugin.thumbplayer.d.a.a> MQo;
  public ConcurrentLinkedDeque<com.tencent.mm.plugin.thumbplayer.d.a.a> MQp;
  public ConcurrentLinkedDeque<com.tencent.mm.plugin.thumbplayer.d.a.a> MQq;
  public f MQr;
  public volatile b MQs;
  public volatile long MQt;
  private com.tencent.e.i.d<?> MQu;
  private long MQv;
  private volatile long MQw;
  private volatile long MQx;
  public volatile long MQy;
  private boolean MQz;
  public final String TAG;
  public boolean lhf;
  private boolean loop;
  private int targetHeight;
  private int targetWidth;
  public ArrayList<com.tencent.mm.plugin.thumbplayer.e.d> xoX;
  
  static
  {
    AppMethodBeat.i(190830);
    MQF = new c.a((byte)0);
    com.tencent.mm.plugin.xlabeffect.c localc = com.tencent.mm.plugin.xlabeffect.c.QPp;
    com.tencent.mm.plugin.xlabeffect.c.eON();
    com.tencent.mm.plugin.xlabeffect.g.hfh();
    MQC = 500L;
    MQD = "pag/overlap.pag";
    MQE = 33L;
    AppMethodBeat.o(190830);
  }
  
  public c()
  {
    AppMethodBeat.i(190826);
    this.TAG = ("MicroMsg.MultiMediaEffectController@" + hashCode());
    this.MQn = new com.tencent.mm.videocomposition.effect.g();
    this.MQo = new ConcurrentLinkedDeque();
    this.MQp = new ConcurrentLinkedDeque();
    this.MQq = new ConcurrentLinkedDeque();
    this.xoX = new ArrayList();
    this.MQs = b.MQG;
    this.MQv = -1L;
    this.MQw = -1L;
    this.MQx = -1L;
    this.MQy = -1L;
    this.MQB = new com.tencent.mm.plugin.thumbplayer.e.c();
    this.MQn.no(0, 0);
    this.MQn.YIS = ((kotlin.g.a.b)new n()
    {
      public final kotlin.l.d Vc() {}
      
      public final String getName() {}
      
      public final String getSignature() {}
    });
    AppMethodBeat.o(190826);
  }
  
  private final void a(com.tencent.mm.plugin.thumbplayer.d.a.a parama)
  {
    AppMethodBeat.i(190737);
    Log.i(this.TAG, "setupPlayer:".concat(String.valueOf(parama)));
    parama.MRG = ((kotlin.g.a.b)new i(this));
    parama.MRH = ((kotlin.g.a.b)new j(this));
    parama.MRI = ((m)c.k.MQS);
    AppMethodBeat.o(190737);
  }
  
  private final void a(e parame1, e parame2)
  {
    AppMethodBeat.i(190717);
    Object localObject = this.MQn.ANo;
    com.tencent.mm.videocomposition.g localg = parame1.MQX;
    if (localg.isValid())
    {
      if (localg.NnT == null) {
        localg.NnT = ((EffectManager)localObject).a(com.tencent.mm.xeffect.effect.j.YZB, localg.path);
      }
      long l1 = parame1.endTimeMs;
      long l2 = parame1.endTimeMs + parame2.MQX.duration;
      if ((l1 > 0L) && (l2 > 0L))
      {
        parame1 = localg.NnT;
        if (parame1 != null) {
          parame1.aZ(l1, l2);
        }
        ((EffectManager)localObject).b(localg.NnT);
      }
      parame2 = this.TAG;
      localObject = new StringBuilder("set track transition time range:[").append(l1).append(',').append(l2).append("], effect:");
      parame1 = localg.NnT;
      if (parame1 == null) {
        break label190;
      }
    }
    label190:
    for (parame1 = Long.valueOf(parame1.id);; parame1 = null)
    {
      Log.i(parame2, parame1);
      AppMethodBeat.o(190717);
      return;
    }
  }
  
  private final void ajq(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(190729);
    Object localObject1 = this.MQr;
    if (localObject1 == null)
    {
      AppMethodBeat.o(190729);
      return;
    }
    if (paramInt >= ((f)localObject1).MQY.size())
    {
      AppMethodBeat.o(190729);
      return;
    }
    localObject1 = ((f)localObject1).MQY.get(paramInt);
    p.j(localObject1, "composition.trackList[nextMediaIndex]");
    e locale = (e)localObject1;
    com.tencent.mm.plugin.thumbplayer.e.d locald = locale.GhE;
    Iterator localIterator = ((Iterable)this.MQq).iterator();
    Object localObject3;
    label132:
    String str;
    if (localIterator.hasNext())
    {
      localObject3 = localIterator.next();
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject3).MRJ;
      if (localObject1 != null)
      {
        localObject1 = ((e)localObject1).GhE;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).mediaId;
          if (locald == null) {
            break label295;
          }
          str = locald.mediaId;
          label144:
          if (!p.h(localObject1, str)) {
            break label299;
          }
          localObject1 = localObject3;
          label156:
          localObject1 = (com.tencent.mm.plugin.thumbplayer.d.a.a)localObject1;
          if (localObject1 == null) {
            break label306;
          }
          this.MQq.remove(localObject1);
          this.MQp.add(localObject1);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      str = this.TAG;
      localObject3 = new StringBuilder("preloadMedia, pendingPlayers.size:").append(this.MQp.size()).append(", nextMediaIndex:").append(paramInt).append(", mediaId:");
      localObject1 = localObject2;
      if (locald != null) {
        localObject1 = locald.mediaId;
      }
      Log.i(str, (String)localObject1 + ", fromFreePlayer:" + bool + ", freePlayers.size:" + this.MQq.size());
      AppMethodBeat.o(190729);
      return;
      localObject1 = null;
      break label132;
      label295:
      str = null;
      break label144;
      label299:
      break;
      localObject1 = null;
      break label156;
      label306:
      localObject1 = a(locale);
      if (localObject1 == null)
      {
        AppMethodBeat.o(190729);
        return;
      }
      this.MQp.add(localObject1);
    }
  }
  
  private final void gnV()
  {
    AppMethodBeat.i(190705);
    Object localObject1 = this.MQr;
    if (localObject1 != null)
    {
      localObject1 = ((f)localObject1).MQY;
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(190705);
      return;
    }
    int j = ((ArrayList)localObject1).size();
    int i = 1;
    while (i < j)
    {
      Object localObject2 = ((ArrayList)localObject1).get(i - 1);
      p.j(localObject2, "trackList[i - 1]");
      localObject2 = (e)localObject2;
      Object localObject3 = ((ArrayList)localObject1).get(i);
      p.j(localObject3, "trackList[i]");
      a((e)localObject2, (e)localObject3);
      i += 1;
    }
    AppMethodBeat.o(190705);
  }
  
  private final void gnW()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(190743);
        Log.i(this.TAG, "startProgressUpdate " + this.MQs);
        if (this.MQu != null)
        {
          AppMethodBeat.o(190743);
          return;
        }
        TimerTask localTimerTask = (TimerTask)new l(this);
        if (this.MQs == b.MQI)
        {
          localTimerTask.run();
          this.MQv = -1L;
          Log.i(this.TAG, "do startProgressUpdate");
          AppMethodBeat.o(190743);
        }
        else
        {
          this.MQu = h.ZvG.b((Runnable)localObject, 0L, MQE);
        }
      }
      finally {}
    }
  }
  
  private final void gnX()
  {
    AppMethodBeat.i(190746);
    Log.i(this.TAG, "stopProgressUpdate");
    com.tencent.e.i.d locald = this.MQu;
    if (locald != null) {
      locald.cancel(false);
    }
    this.MQu = null;
    AppMethodBeat.o(190746);
  }
  
  private final void gnY()
  {
    try
    {
      AppMethodBeat.i(190760);
      Iterator localIterator1 = ((Iterable)this.MQo).iterator();
      while (localIterator1.hasNext())
      {
        com.tencent.mm.plugin.thumbplayer.d.a.a locala = (com.tencent.mm.plugin.thumbplayer.d.a.a)localIterator1.next();
        locala.stop();
        locala.release();
        this.MQn.bCg(locala.key);
      }
      localIterator2 = ((Iterable)this.MQq).iterator();
    }
    finally {}
    while (localIterator2.hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.d.a.a)localIterator2.next()).release();
    }
    Iterator localIterator2 = ((Iterable)this.MQp).iterator();
    while (localIterator2.hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.d.a.a)localIterator2.next()).release();
    }
    this.MQo.clear();
    this.MQp.clear();
    this.MQq.clear();
    AppMethodBeat.o(190760);
  }
  
  private final void iw(List<? extends com.tencent.mm.plugin.thumbplayer.e.d> paramList)
  {
    AppMethodBeat.i(190699);
    this.MQn.ANo.ike();
    Object localObject1 = this.MQn.ANo.ikd();
    ((com.tencent.mm.xeffect.effect.l)localObject1).ikg();
    if (((com.tencent.mm.xeffect.effect.l)localObject1).YZZ != 0.42F)
    {
      VLogEffectJNI.INSTANCE.nSetGradientBlurContentOffsetPercent(((af)localObject1).ptr, 0.42F);
      ((com.tencent.mm.xeffect.effect.l)localObject1).YZZ = 0.42F;
    }
    Object localObject2 = new ArrayList();
    localObject1 = null;
    Object localObject3 = ((Iterable)paramList).iterator();
    int i = 0;
    paramList = (List<? extends com.tencent.mm.plugin.thumbplayer.e.d>)localObject1;
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject4 = (com.tencent.mm.plugin.thumbplayer.e.d)localObject1;
      localObject1 = new e();
      ((e)localObject1).GhE = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4);
      label216:
      float f;
      label246:
      int j;
      if ((((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSE >= 0L) && (((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSF > 0L))
      {
        ((e)localObject1).startTimeMs = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSE;
        ((e)localObject1).endTimeMs = (((e)localObject1).startTimeMs + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSF);
        ((e)localObject1).MQV = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSG;
        ((e)localObject1).MQW = (((e)localObject1).MQV + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSF);
        if ((localObject4 instanceof com.tencent.mm.plugin.thumbplayer.e.e))
        {
          if (((com.tencent.mm.plugin.thumbplayer.e.e)localObject4).MSI <= 0.0F) {
            break label620;
          }
          f = ((com.tencent.mm.plugin.thumbplayer.e.e)localObject4).MSI;
          ((e)localObject1).pvh = f;
        }
        ((e)localObject1).MQX.duration = MQC;
        paramList = ((e)localObject1).GhE;
        if ((paramList != null) && (!paramList.MSD))
        {
          paramList = (com.tencent.mm.plugin.thumbplayer.e.e)localObject4;
          if (paramList == null) {
            break label625;
          }
          paramList = paramList.MSK;
          label295:
          Object localObject5 = (CharSequence)paramList;
          if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
            break label630;
          }
          j = 1;
          label319:
          if ((j == 0) && (u.agG(paramList))) {
            break label636;
          }
          paramList = ((e)localObject1).MQX;
          localObject5 = this.MQn.ANo;
          com.tencent.mm.xeffect.effect.j localj = com.tencent.mm.xeffect.effect.j.YZB;
          Object localObject6 = MMApplicationContext.getContext();
          p.j(localObject6, "MMApplicationContext.getContext()");
          localObject6 = ((Context)localObject6).getAssets();
          p.j(localObject6, "MMApplicationContext.getContext().assets");
          paramList.NnT = ((EffectManager)localObject5).a(localj, (AssetManager)localObject6, MQD);
          ((e)localObject1).MQX.setPath(MQD);
        }
        label406:
        if (!(localObject4 instanceof com.tencent.mm.plugin.thumbplayer.e.e)) {
          break label659;
        }
        if (!((com.tencent.mm.plugin.thumbplayer.e.e)localObject4).gop()) {
          break label648;
        }
        ((e)localObject1).a(com.tencent.mm.plugin.thumbplayer.d.a.b.MRM);
      }
      for (;;)
      {
        ((ArrayList)localObject2).add(localObject1);
        Log.i(this.TAG, "create track, media:" + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).mediaId + ", type:" + ((e)localObject1).MQU + ", timeRange:[" + ((e)localObject1).startTimeMs + ',' + ((e)localObject1).endTimeMs + "], trackTimeRange:[" + ((e)localObject1).MQV + ',' + ((e)localObject1).MQW + ']');
        i += 1;
        paramList = (List<? extends com.tencent.mm.plugin.thumbplayer.e.d>)localObject1;
        break;
        if (((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).sTg <= 0L) {
          break label216;
        }
        if (paramList != null) {}
        for (long l = paramList.endTimeMs;; l = 0L)
        {
          ((e)localObject1).startTimeMs = l;
          ((e)localObject1).endTimeMs = (((e)localObject1).startTimeMs + ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).sTg);
          ((e)localObject1).MQV = 0L;
          ((e)localObject1).MQW = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).sTg;
          break;
        }
        label620:
        f = 1.0F;
        break label246;
        label625:
        paramList = null;
        break label295;
        label630:
        j = 0;
        break label319;
        label636:
        ((e)localObject1).MQX.setPath(paramList);
        break label406;
        label648:
        ((e)localObject1).a(com.tencent.mm.plugin.thumbplayer.d.a.b.MRN);
        continue;
        label659:
        ((e)localObject1).a(com.tencent.mm.plugin.thumbplayer.d.a.b.MRN);
      }
    }
    this.MQr = new f((List)localObject2);
    gnV();
    localObject1 = this.TAG;
    localObject2 = new StringBuilder("parseMediaList finished, total duration:");
    paramList = this.MQr;
    if (paramList != null)
    {
      paramList = Long.valueOf(paramList.getDuration());
      Log.i((String)localObject1, paramList);
      paramList = this.MQr;
      if (paramList == null) {
        break label930;
      }
      paramList = paramList.MQY;
      if (paramList == null) {
        break label930;
      }
      localObject1 = ((Iterable)paramList).iterator();
      label768:
      if (!((Iterator)localObject1).hasNext()) {
        break label923;
      }
      localObject2 = (e)((Iterator)localObject1).next();
      localObject3 = this.TAG;
      localObject4 = new StringBuilder("track media:");
      paramList = ((e)localObject2).GhE;
      if (paramList == null) {
        break label918;
      }
    }
    label918:
    for (paramList = paramList.mediaId;; paramList = null)
    {
      Log.i((String)localObject3, paramList + ", type:" + ((e)localObject2).MQU + ", timeRange:[" + ((e)localObject2).startTimeMs + ',' + ((e)localObject2).endTimeMs + "], trackTimeRange:[" + ((e)localObject2).MQV + ',' + ((e)localObject2).MQW + ']');
      break label768;
      paramList = null;
      break;
    }
    label923:
    AppMethodBeat.o(190699);
    return;
    label930:
    AppMethodBeat.o(190699);
  }
  
  public final com.tencent.mm.plugin.thumbplayer.d.a.a a(e parame)
  {
    Object localObject1 = null;
    AppMethodBeat.i(190756);
    com.tencent.mm.plugin.thumbplayer.e.d locald = parame.GhE;
    if (locald == null)
    {
      AppMethodBeat.o(190756);
      return null;
    }
    Object localObject2 = parame.MQU;
    switch (d.$EnumSwitchMapping$0[localObject2.ordinal()])
    {
    default: 
      Log.e(this.TAG, "unknown track type!");
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject1).MRJ = parame;
        if ((parame.MQV >= 0L) && (parame.MQW > 0L)) {
          ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject1).aG(parame.MQV, parame.MQW);
        }
        ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject1).aH(parame.startTimeMs, parame.endTimeMs);
        ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject1).setLoop(locald.loop);
        ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject1).setMute(this.lhf);
        ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject1).goe();
        a((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject1);
      }
      AppMethodBeat.o(190756);
      return localObject1;
      localObject1 = (c)this;
      localObject2 = new com.tencent.mm.plugin.thumbplayer.d.a.e();
      ((com.tencent.mm.plugin.thumbplayer.d.a.e)localObject2).kv(((c)localObject1).targetWidth, ((c)localObject1).targetHeight);
      ((com.tencent.mm.plugin.thumbplayer.d.a.e)localObject2).setMediaInfo(locald);
      if (((locald instanceof com.tencent.mm.plugin.thumbplayer.e.e)) && (((com.tencent.mm.plugin.thumbplayer.e.e)locald).MSI > 0.0F)) {
        ((com.tencent.mm.plugin.thumbplayer.d.a.e)localObject2).setPlayRate(((com.tencent.mm.plugin.thumbplayer.e.e)locald).MSI);
      }
      ((com.tencent.mm.plugin.thumbplayer.d.a.e)localObject2).setLoop(locald.loop);
      localObject1 = (com.tencent.mm.plugin.thumbplayer.d.a.a)localObject2;
      continue;
      localObject1 = (c)this;
      localObject2 = new com.tencent.mm.plugin.thumbplayer.d.a.c();
      ((com.tencent.mm.plugin.thumbplayer.d.a.c)localObject2).kv(((c)localObject1).targetWidth, ((c)localObject1).targetHeight);
      ((com.tencent.mm.plugin.thumbplayer.d.a.c)localObject2).setMediaInfo(locald);
      ((com.tencent.mm.plugin.thumbplayer.d.a.c)localObject2).J(locald.path, locald.url, locald.decodeKey, locald.zZu);
      localObject1 = (com.tencent.mm.plugin.thumbplayer.d.a.a)localObject2;
    }
  }
  
  public final void a(e parame, final long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(190814);
    gnX();
    Object localObject3 = (com.tencent.mm.plugin.thumbplayer.d.a.a)kotlin.a.j.f((Iterable)this.MQo);
    this.MQs = b.MQK;
    Object localObject4;
    if ((localObject3 != null) && (p.h(((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject3).MRJ, parame)))
    {
      localObject4 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("seekTo locate to first playing player, trackSeekTime:").append(paramLong).append(", isStarted:").append(((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject3).isStarted()).append(", isPlaying:").append(((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject3).isPlaying()).append(", defaultVideo:");
      com.tencent.mm.plugin.thumbplayer.e.d locald = parame.GhE;
      localObject1 = localObject2;
      if (locald != null) {
        localObject1 = Boolean.valueOf(locald.MSD);
      }
      Log.i((String)localObject4, localObject1);
      parame = parame.GhE;
      if ((parame != null) && (!parame.MSD)) {
        ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject3).b(paramLong, (kotlin.g.a.a)new g(this, paramLong, (com.tencent.mm.plugin.thumbplayer.d.a.a)localObject3));
      }
    }
    while (!((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject3).isStarted())
    {
      this.MQs = b.MQH;
      if (((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject3).ayN())
      {
        ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject3).resume();
        AppMethodBeat.o(190814);
        return;
        this.MQs = b.MQH;
        gnW();
      }
      else
      {
        ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject3).start();
        AppMethodBeat.o(190814);
        return;
        gnY();
        localObject2 = a(parame);
        if (localObject2 == null)
        {
          AppMethodBeat.o(190814);
          return;
        }
        ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject2).start();
        localObject3 = parame.GhE;
        if ((localObject3 != null) && (!((com.tencent.mm.plugin.thumbplayer.e.d)localObject3).MSD)) {
          ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject2).b(paramLong, null);
        }
        this.MQo.add(localObject2);
        localObject2 = this.TAG;
        localObject3 = new StringBuilder("seekTo create new player, trackSeekTime:").append(paramLong).append(", playingPlayers.size:").append(this.MQo.size()).append(", defaultVideo:");
        localObject4 = parame.GhE;
        parame = (e)localObject1;
        if (localObject4 != null) {
          parame = Boolean.valueOf(((com.tencent.mm.plugin.thumbplayer.e.d)localObject4).MSD);
        }
        Log.i((String)localObject2, parame);
      }
    }
    AppMethodBeat.o(190814);
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.e.e parame, String paramString)
  {
    AppMethodBeat.i(190661);
    p.k(parame, "prevTransitionMedia");
    Log.i(this.TAG, "setTransition, mediaId:" + parame.mediaId + ", transitionPath:" + paramString);
    Object localObject1 = this.MQr;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((f)localObject1).MQY;
      if (localObject2 != null) {}
    }
    else
    {
      AppMethodBeat.o(190661);
      return;
    }
    Object localObject3 = ((List)localObject2).iterator();
    int i = 0;
    label135:
    int j;
    if (((Iterator)localObject3).hasNext())
    {
      e locale = (e)((Iterator)localObject3).next();
      localObject1 = locale.GhE;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).mediaId;
        if (!p.h(localObject1, parame.mediaId)) {
          break label376;
        }
        localObject1 = locale.GhE;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSE != parame.MSE)) {
          break label376;
        }
        localObject1 = locale.GhE;
        if ((localObject1 == null) || (((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).MSF != parame.MSF)) {
          break label376;
        }
        j = 1;
        label200:
        if (j == 0) {
          break label382;
        }
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "found transition trackIndex:" + localObject2 + ", trackList.size:" + ((ArrayList)localObject2).size());
      if ((i >= 0) && (i < ((ArrayList)localObject2).size() - 1))
      {
        parame = this.MQn.ANo;
        localObject1 = ((ArrayList)localObject2).get(i);
        p.j(localObject1, "trackList[trackIndex]");
        localObject1 = (e)localObject1;
        localObject2 = ((ArrayList)localObject2).get(i + 1);
        p.j(localObject2, "trackList[trackIndex + 1]");
        localObject2 = (e)localObject2;
        localObject3 = ((e)localObject1).MQX;
        if (((com.tencent.mm.videocomposition.g)localObject3).NnT != null)
        {
          parame.c(((com.tencent.mm.videocomposition.g)localObject3).NnT);
          ((com.tencent.mm.videocomposition.g)localObject3).NnT = null;
        }
        if (paramString != null)
        {
          ((com.tencent.mm.videocomposition.g)localObject3).setPath(paramString);
          a((e)localObject1, (e)localObject2);
        }
      }
      AppMethodBeat.o(190661);
      return;
      localObject1 = null;
      break label135;
      label376:
      j = 0;
      break label200;
      label382:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void aG(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(190668);
    Log.i(this.TAG, "setPlayRange:[" + paramLong1 + ", " + paramLong2 + "], renderPts:" + this.MQt + ", playStatus:" + this.MQs);
    this.MQw = paramLong1;
    this.MQx = paramLong2;
    if (this.MQs == b.MQH) {
      seekTo(this.MQw);
    }
    AppMethodBeat.o(190668);
  }
  
  public final void fhc()
  {
    AppMethodBeat.i(190731);
    this.MQn.WD(this.MQt);
    AppMethodBeat.o(190731);
  }
  
  public final void gnU()
  {
    AppMethodBeat.i(190671);
    Log.i(this.TAG, "clearPlayRange");
    this.MQw = -1L;
    this.MQx = -1L;
    AppMethodBeat.o(190671);
  }
  
  public final void iv(List<? extends com.tencent.mm.plugin.thumbplayer.e.d> paramList)
  {
    AppMethodBeat.i(190640);
    p.k(paramList, "mediaList");
    Log.i(this.TAG, "setMediaList size:" + paramList.size() + ", playStatus:" + this.MQs + ", resumePlayPosition:false, renderPts:" + this.MQt);
    gnX();
    gnY();
    this.xoX.clear();
    this.MQr = null;
    this.xoX.addAll((Collection)paramList);
    iw(paramList);
    if (this.MQs == b.MQG)
    {
      ajq(0);
      AppMethodBeat.o(190640);
      return;
    }
    if (this.MQs == b.MQK)
    {
      paramList = this.MQr;
      if (paramList != null)
      {
        paramList = paramList.MQY;
        if (paramList != null)
        {
          paramList = (List)paramList;
          paramList = paramList.listIterator(paramList.size());
          long l2;
          long l3;
          if (paramList.hasPrevious())
          {
            e locale = (e)paramList.previous();
            long l1 = locale.startTimeMs;
            l2 = locale.endTimeMs;
            l3 = this.MQy;
            if (l1 > l3)
            {
              label219:
              i = 0;
              label221:
              if (i == 0) {
                break label312;
              }
            }
          }
          for (int i = paramList.nextIndex();; i = -1)
          {
            Log.i(this.TAG, "setMediaList in seeking, seekTime:" + this.MQy + ", trackIndex:" + i);
            ajq(i);
            paramList = (com.tencent.mm.plugin.thumbplayer.d.a.a)this.MQp.removeLast();
            this.MQo.add(paramList);
            AppMethodBeat.o(190640);
            return;
            if (l2 < l3) {
              break label219;
            }
            i = 1;
            break label221;
            label312:
            break;
          }
        }
      }
      AppMethodBeat.o(190640);
      return;
    }
    if (this.MQs == b.MQH)
    {
      this.MQt = 0L;
      start();
    }
    AppMethodBeat.o(190640);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(190780);
    Log.i(this.TAG, "pause, current status:" + this.MQs + ", playingPlayers.size:" + this.MQo.size());
    if (this.MQo.isEmpty())
    {
      AppMethodBeat.o(190780);
      return;
    }
    ((com.tencent.mm.plugin.thumbplayer.d.a.a)this.MQo.getFirst()).pause();
    this.MQs = b.MQI;
    c localc = this.MQh;
    if (localc != null) {
      localc.onPause();
    }
    gnX();
    AppMethodBeat.o(190780);
  }
  
  public final void release()
  {
    try
    {
      AppMethodBeat.i(190762);
      this.MQn.release();
      this.MQn.igN();
      gnY();
      this.MQr = null;
      this.xoX.clear();
      this.MQs = b.MQG;
      AppMethodBeat.o(190762);
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
    AppMethodBeat.i(190773);
    Log.i(this.TAG, "resume: " + this.MQs + ", " + this.MQo.size());
    if (this.MQs == b.MQH)
    {
      AppMethodBeat.o(190773);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.thumbplayer.d.a.a)kotlin.a.j.f((Iterable)this.MQo);
    if (localObject == null)
    {
      AppMethodBeat.o(190773);
      return;
    }
    Log.i(this.TAG, "resume: " + ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject).ayN());
    if (!((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject).ayN())
    {
      this.MQs = b.MQH;
      AppMethodBeat.o(190773);
      return;
    }
    ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject).resume();
    this.MQs = b.MQH;
    localObject = this.MQh;
    if (localObject != null) {
      ((c)localObject).onResume();
    }
    gnW();
    AppMethodBeat.o(190773);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(190796);
    Object localObject2 = this.TAG;
    Object localObject3 = new StringBuilder("seekTo:").append(paramLong).append(", renderPts:").append(this.MQt).append(", playingPlayers.size:").append(this.MQo.size()).append(", status:").append(this.MQs).append(", trackList.size:");
    Object localObject1 = this.MQr;
    label174:
    long l2;
    label221:
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((f)localObject1).MQY;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
        Log.printInfoStack((String)localObject2, localObject1, new Object[0]);
        localObject1 = this.MQr;
        if (localObject1 != null)
        {
          localObject1 = ((f)localObject1).MQY;
          if (localObject1 != null)
          {
            localObject1 = (List)localObject1;
            localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
            if (!((ListIterator)localObject2).hasPrevious()) {
              break label264;
            }
            localObject1 = ((ListIterator)localObject2).previous();
            localObject3 = (e)localObject1;
            l1 = ((e)localObject3).startTimeMs;
            l2 = ((e)localObject3).endTimeMs;
            if (l1 <= paramLong) {
              break label252;
            }
            i = 0;
            label223:
            if (i == 0) {
              break label262;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = (e)localObject1;
      if (localObject1 != null) {
        break label270;
      }
      AppMethodBeat.o(190796);
      return;
      localObject1 = null;
      break;
      label252:
      if (l2 < paramLong) {
        break label221;
      }
      i = 1;
      break label223;
      label262:
      break label174;
      label264:
      localObject1 = null;
    }
    label270:
    long l1 = paramLong - ((e)localObject1).startTimeMs + ((e)localObject1).MQV;
    Log.i(this.TAG, "found seek target track:" + localObject1 + ", trackSeekTime:" + l1 + ", trackStartTimeMs:" + ((e)localObject1).MQV);
    this.MQy = paramLong;
    a((e)localObject1, l1);
    AppMethodBeat.o(190796);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(190647);
    Log.i(this.TAG, "setLoop:".concat(String.valueOf(paramBoolean)));
    this.loop = paramBoolean;
    AppMethodBeat.o(190647);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190628);
    Log.i(this.TAG, "setSize:[" + paramInt1 + ',' + paramInt2 + ']');
    this.MQn.setSize(paramInt1, paramInt2);
    this.targetWidth = paramInt1;
    this.targetHeight = paramInt2;
    Iterator localIterator = ((Iterable)this.MQo).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.d.a.a)localIterator.next()).kv(paramInt1, paramInt2);
    }
    localIterator = ((Iterable)this.MQp).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.thumbplayer.d.a.a)localIterator.next()).kv(paramInt1, paramInt2);
    }
    AppMethodBeat.o(190628);
  }
  
  public final void start()
  {
    AppMethodBeat.i(190770);
    Log.i(this.TAG, "start, current status:" + this.MQs + ", playingPlayers.size:" + this.MQo.size() + ", pendingPlayers.size:" + this.MQp.size());
    if (this.xoX.isEmpty())
    {
      Log.e(this.TAG, "start ignore not set mediaList");
      AppMethodBeat.o(190770);
      return;
    }
    if (this.MQs != b.MQH) {
      if (((Collection)this.MQo).isEmpty()) {
        break label334;
      }
    }
    label334:
    for (int i = 1;; i = 0)
    {
      Object localObject;
      if (this.MQo.isEmpty())
      {
        this.MQt = 0L;
        if (this.MQp.isEmpty()) {
          ajq(0);
        }
        localObject = (com.tencent.mm.plugin.thumbplayer.d.a.a)this.MQp.removeFirst();
        this.MQo.add(localObject);
      }
      if (this.MQo.isEmpty()) {
        Log.e(this.TAG, "start error playingPlayers is empty");
      }
      this.MQs = b.MQH;
      ((com.tencent.mm.plugin.thumbplayer.d.a.a)kotlin.a.j.e((Iterable)this.MQo)).start();
      if (i != 0)
      {
        localObject = this.MQh;
        if (localObject != null) {
          ((c)localObject).onResume();
        }
      }
      Log.i(this.TAG, "start finished, playingPlayers.size:" + this.MQo.size());
      if (this.MQw > 0L)
      {
        Log.i(this.TAG, "start finished seekTo playRange start:" + this.MQw);
        seekTo(this.MQw);
      }
      this.MQA = Util.currentTicks();
      this.MQz = false;
      this.MQB.jID = Util.currentTicks();
      AppMethodBeat.o(190770);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(190782);
    Log.i(this.TAG, "stop, current status:" + this.MQs + ", playingPlayers.size:" + this.MQo.size());
    if (this.MQo.isEmpty())
    {
      AppMethodBeat.o(190782);
      return;
    }
    ((com.tencent.mm.plugin.thumbplayer.d.a.a)this.MQo.getFirst()).stop();
    gnY();
    this.MQs = b.MQJ;
    gnX();
    AppMethodBeat.o(190782);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayStatus;", "", "(Ljava/lang/String;I)V", "Unknown", "Started", "Pause", "Stop", "Seeking", "plugin-thumbplayer_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(191023);
      b localb1 = new b("Unknown", 0);
      MQG = localb1;
      b localb2 = new b("Started", 1);
      MQH = localb2;
      b localb3 = new b("Pause", 2);
      MQI = localb3;
      b localb4 = new b("Stop", 3);
      MQJ = localb4;
      b localb5 = new b("Seeking", 4);
      MQK = localb5;
      MQL = new b[] { localb1, localb2, localb3, localb4, localb5 };
      AppMethodBeat.o(191023);
    }
    
    private b() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "", "onPause", "", "onResume", "plugin-thumbplayer_release"})
  public static abstract interface c
  {
    public abstract void onPause();
    
    public abstract void onResume();
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(c paramc, long paramLong, com.tencent.mm.plugin.thumbplayer.d.a.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "surface", "Landroid/graphics/SurfaceTexture;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<SurfaceTexture, x>
  {
    h(c paramc, com.tencent.mm.plugin.thumbplayer.d.a.e parame, com.tencent.mm.plugin.thumbplayer.d.a.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaPlayer;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.d.a.a, x>
  {
    i(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaPlayer;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.d.a.a, x>
  {
    j(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
  public static final class l
    extends TimerTask
  {
    public l(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(191993);
      if ((c.c(this.MQM).isEmpty()) && (c.g(this.MQM).isEmpty()))
      {
        Log.i(c.a(this.MQM), "finished play all player");
        c.h(this.MQM);
      }
      long l1;
      long l2;
      if (c.i(this.MQM) >= 0L)
      {
        c.a(this.MQM, c.i(this.MQM));
        Log.i(c.a(this.MQM), "onProgressUpdate set renderPts to seekTime:" + c.i(this.MQM));
        c.j(this.MQM);
        c.m(this.MQM).WD(c.k(this.MQM));
        c.c(this.MQM, c.k(this.MQM));
        c.d(this.MQM, c.k(this.MQM));
        l1 = c.k(this.MQM);
        l2 = c.o(this.MQM);
        if (1L <= l2) {
          break label259;
        }
      }
      for (;;)
      {
        c.q(this.MQM);
        c.b(this.MQM, Util.currentTicks());
        AppMethodBeat.o(191993);
        return;
        c localc = this.MQM;
        l2 = c.k(localc);
        if (c.l(this.MQM) > 0L) {}
        for (l1 = Util.currentTicks() - c.l(this.MQM);; l1 = c.gnZ())
        {
          c.a(localc, l1 + l2);
          break;
        }
        label259:
        if ((l1 >= l2) && (c.n(this.MQM) >= 0L)) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$startProgressUpdate$task$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(c.l paraml)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
  static final class m
    implements SurfaceTexture.OnFrameAvailableListener
  {
    m(c paramc, SurfaceTexture paramSurfaceTexture) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(191728);
      Log.i(c.a(this.MQM), "first frame available");
      c.f(this.MQM);
      this.BbE.setOnFrameAvailableListener(null);
      AppMethodBeat.o(191728);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.c
 * JD-Core Version:    0.7.0.1
 */