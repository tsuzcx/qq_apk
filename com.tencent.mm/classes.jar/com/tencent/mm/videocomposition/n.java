package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.b.a;
import com.tencent.mm.videocomposition.b.e;
import com.tencent.mm.videocomposition.b.f;
import com.tencent.mm.videocomposition.b.g;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.AssetExportSessionStatus;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.composition.MutableVideoComposition;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/VideoComposition;", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "(Ljava/util/List;)V", "origin", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "()V", "assetHeight", "", "assetWidth", "audioProcessorFactory", "Lcom/tencent/mm/videocomposition/audio/IAudioProcessorFactory;", "checkPerformance", "", "effect", "Lcom/tencent/mm/videocomposition/render/VLogDirectorMultiVideoCompositionEffect;", "enableOriginAudio", "exportSession", "Lcom/tencent/tav/core/AssetExportSession;", "id", "", "getId", "()J", "setId", "(J)V", "isAudioTracksMerge", "isRevert", "isVideoTracksMerge", "outputCrop", "Landroid/graphics/Rect;", "playEnd", "getPlayEnd", "playFps", "", "playStart", "getPlayStart", "renderCallback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallbackList;", "setEnd", "getSetEnd", "setSetEnd", "setStart", "getSetStart", "setSetStart", "sourceEnd", "getSourceEnd", "sourceStart", "getSourceStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "viewRect", "addRenderProcessCallback", "", "callback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "addTrack", "track", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildTrackChannel", "Lcom/tencent/tavkit/composition/TAVClip;", "cancelExport", "createComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "enableVideoSound", "enable", "export", "path", "", "config", "Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "Lkotlin/Function2;", "progressCallback", "Lkotlin/Function1;", "exportImpl", "videoEncoder", "Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;", "exportWithCustomEncoder", "getAssetSize", "Landroid/util/Size;", "getDisplayScreenRect", "getDurationMs", "getOutputSize", "getPerformanceReport", "Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getRenderSize", "getSourceDuration", "getThumbBitmap", "widthLimit", "Landroid/graphics/Bitmap;", "getTrackByTimeMs", "timeMs", "getTrackList", "isEnableOriginSound", "removeRenderProcessCallback", "removeTrack", "setAssetSize", "width", "height", "setAudioProcessorFactory", "setAudioTracksMerge", "audioTracksMerge", "setCheckPerformance", "check", "setDisplayScreenRect", "rect", "setOutputCrop", "setPlayFps", "fps", "setPlayRange", "start", "end", "setRenderSize", "setRevert", "revert", "setTrackList", "setVLogEffectMgr", "setVideoTracksMerge", "videoTracksMerge", "updateTrack", "index", "Companion", "VideoOutputConfig", "video_composition_release"})
public final class n
{
  public static final n.a Rhv;
  public EffectManager GAw;
  public final ArrayList<d> Gzn;
  private boolean Gzo;
  public boolean QEl;
  private final long Rhk;
  public long Rhl;
  public long Rhm;
  private int Rhn;
  private int Rho;
  public float Rhp;
  private final Rect Rhq;
  private f Rhr;
  public g Rhs;
  public com.tencent.mm.videocomposition.a.b Rht;
  private boolean Rhu;
  public AssetExportSession exportSession;
  public long id;
  private boolean isAudioTracksMerge;
  private boolean isVideoTracksMerge;
  public Rect viewRect;
  
  static
  {
    AppMethodBeat.i(216792);
    Rhv = new n.a((byte)0);
    h localh = h.Rhg;
    h.efp();
    AppMethodBeat.o(216792);
  }
  
  public n()
  {
    AppMethodBeat.i(216791);
    this.Rhl = -1L;
    this.Rhm = -1L;
    this.viewRect = new Rect();
    this.Rhp = 30.0F;
    this.Rhq = new Rect();
    this.Rhr = new f();
    this.Gzn = new ArrayList();
    this.isVideoTracksMerge = true;
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "create VLogComposition", new Object[0]);
    AppMethodBeat.o(216791);
  }
  
  private final AssetExportSession a(String paramString, n.b paramb, AssetWriterVideoEncoder paramAssetWriterVideoEncoder, m<? super Boolean, ? super Integer, x> paramm, kotlin.g.a.b<? super Float, x> paramb1)
  {
    AppMethodBeat.i(216788);
    TAVSource localTAVSource = buildSource();
    ExportConfig localExportConfig = new ExportConfig(paramb.Rhw.getWidth(), paramb.Rhw.getHeight());
    localExportConfig.setOutputFilePath(paramString);
    localExportConfig.setVideoBitRate(paramb.videoBitrate);
    localExportConfig.setVideoFrameRate(paramb.fps);
    localExportConfig.setVideoIFrameInterval(paramb.idB);
    localExportConfig.setHighProfile(paramb.Rhx);
    localExportConfig.setAudioBitRate(paramb.audioBitrate);
    localExportConfig.setAudioSampleRateHz(paramb.audioSampleRate);
    localExportConfig.setAudioChannelCount(paramb.audioChannelCount);
    localExportConfig.setAudioEncodeNeedCodecSpecificData(paramb.Rhy);
    localExportConfig.setEncodeHevc(paramb.Lnr);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export: config: " + localExportConfig.getOutputWidth() + ", " + localExportConfig.getOutputHeight() + "; video: " + localExportConfig.getVideoBitRate() + ", " + localExportConfig.getVideoFrameRate() + ", " + paramb.idB + ", " + paramb.Rhx + "; audio: " + paramb.audioBitrate + ", " + paramb.audioSampleRate + ", " + paramb.audioChannelCount + ", aacEncodeNeedCodecSpecificData:" + paramb.Rhy + ',' + "outputHevc:" + paramb.Lnr, new Object[0]);
    paramb = new AssetExportSession(localTAVSource.getAsset(), localExportConfig);
    paramb.setOutputFilePath(paramString);
    paramb.setOutputFileType("mp4");
    paramb.setVideoComposition(localTAVSource.getVideoComposition());
    paramb.setAudioMix(localTAVSource.getAudioMix());
    paramb.setTimeRange(hfo());
    paramb.setRevertMode(this.QEl);
    paramb.setVideoEncoder(paramAssetWriterVideoEncoder);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export duration:" + (hfn() - this.Rhk) + " playRange:" + hfo(), new Object[0]);
    paramb.exportAsynchronouslyWithCompletionHandler((AssetExportSession.ExportCallbackHandler)new c(paramb1, SystemClock.elapsedRealtime(), paramm));
    this.exportSession = paramb;
    AppMethodBeat.o(216788);
    return paramb;
  }
  
  private long hfn()
  {
    AppMethodBeat.i(216772);
    Object localObject2 = (Iterable)this.Gzn;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((d)localObject3).fCr()) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    Object localObject3 = ((Iterable)localObject1).iterator();
    if (!((Iterator)localObject3).hasNext()) {
      localObject1 = null;
    }
    do
    {
      localObject1 = (d)localObject1;
      if (localObject1 == null) {
        break;
      }
      l1 = ((d)localObject1).endTimeMs;
      AppMethodBeat.o(216772);
      return l1;
      localObject1 = ((Iterator)localObject3).next();
    } while (!((Iterator)localObject3).hasNext());
    long l1 = ((d)localObject1).endTimeMs;
    label164:
    localObject2 = ((Iterator)localObject3).next();
    long l2 = ((d)localObject2).endTimeMs;
    if (l1 < l2)
    {
      l1 = l2;
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext())
      {
        break;
        AppMethodBeat.o(216772);
        return 0L;
      }
      break label164;
    }
  }
  
  private final TAVComposition ka(List<d> paramList)
  {
    AppMethodBeat.i(216779);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "createComposition: track size " + paramList.size(), new Object[0]);
    if (paramList.isEmpty())
    {
      paramList = new TAVComposition();
      AppMethodBeat.o(216779);
      return paramList;
    }
    TAVComposition localTAVComposition = new TAVComposition();
    Object localObject1 = (Iterable)paramList;
    Object localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", "add track type:" + locald.type + " startTime:" + locald.startTimeMs + ", endTime:" + locald.endTimeMs + ", trackStartTime:" + locald.GGz + ", trackEndTime:" + locald.GGA, new Object[0]);
      boolean bool = this.Gzo;
      Object localObject3;
      if (locald.type != 0)
      {
        localObject1 = new TAVClip(i.Rhj.c(locald));
        ((TAVClip)localObject1).setStartTime(new CMTime(locald.startTimeMs, 1000));
        ((TAVClip)localObject1).setDuration(new CMTime(locald.getDurationMs(), 1000));
        localObject3 = ((TAVClip)localObject1).getResource();
        p.g(localObject3, "clip.resource");
        ((TAVResource)localObject3).setSourceTimeRange(new CMTimeRange(new CMTime(locald.GGz, 1000), new CMTime(locald.GGA - locald.GGz, 1000)));
        if ((locald.type == 2) && (!bool))
        {
          localObject3 = ((TAVClip)localObject1).getAudioConfiguration();
          p.g(localObject3, "clip.audioConfiguration");
          ((TAVAudioConfiguration)localObject3).setVolume(0.0F);
          label380:
          com.tencent.mm.videocomposition.c.b.i("CompositionTrack", locald.id + " buildClip buildVideoClip, path:" + locald.path + ", video startEnd:[" + locald.GGz + ", " + locald.GGA + "], material startEnd:[" + locald.startTimeMs + ", " + locald.endTimeMs + "], volume: " + locald.volume, new Object[0]);
          label492:
          localObject3 = this.Rht;
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.videocomposition.a.b)localObject3).f(locald);
            ((TAVClip)localObject1).getAudioConfiguration().addAudioProcessorNode((TAVAudioProcessorNode)localObject3);
          }
          ((TAVClip)localObject1).putExtraTrackInfo("key_extra_track", locald);
          if (locald.startTimeMs <= 0L) {
            break label721;
          }
          localObject3 = new TAVClip((TAVResource)new TAVEmptyResource(new CMTime(locald.startTimeMs, 1000)));
          ((TAVClip)localObject3).setStartTime(CMTime.CMTimeZero);
          ((TAVClip)localObject3).setDuration(new CMTime(locald.startTimeMs, 1000));
          com.tencent.mm.videocomposition.c.b.i("VideoComposition", "add front empty clip duration:" + locald.startTimeMs, new Object[0]);
        }
      }
      label721:
      for (localObject1 = kotlin.a.j.listOf(new TAVClip[] { localObject3, localObject1 });; localObject1 = kotlin.a.j.listOf(localObject1))
      {
        ((Collection)localObject2).add(localObject1);
        break;
        localObject3 = ((TAVClip)localObject1).getAudioConfiguration();
        p.g(localObject3, "clip.audioConfiguration");
        ((TAVAudioConfiguration)localObject3).setVolume(locald.volume);
        break label380;
        localObject1 = new TAVClip((TAVResource)new TAVEmptyResource(CMTime.CMTimeZero));
        break label492;
      }
    }
    localObject1 = ((Iterable)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject2 = (List)localObject2;
      if (((d)paramList.get(i)).fCr()) {
        localTAVComposition.addVideoChannel((List)localObject2);
      }
      if ((((d)paramList.get(i)).type == 2) || (((d)paramList.get(i)).type == 3) || (((d)paramList.get(i)).type == 1)) {
        localTAVComposition.addAudioChannel((List)localObject2);
      }
      i += 1;
    }
    paramList = new StringBuilder("finish build composition, duration:");
    localObject1 = localTAVComposition.getDuration();
    p.g(localObject1, "composition.duration");
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", ((CMTime)localObject1).getTimeUs() / 1000L, new Object[0]);
    AppMethodBeat.o(216779);
    return localTAVComposition;
  }
  
  public final AssetExportSession a(String paramString, n.b paramb, m<? super Boolean, ? super Integer, x> paramm, kotlin.g.a.b<? super Float, x> paramb1)
  {
    AppMethodBeat.i(216789);
    p.h(paramString, "path");
    p.h(paramb, "config");
    paramString = a(paramString, paramb, null, paramm, paramb1);
    AppMethodBeat.o(216789);
    return paramString;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(216785);
    if (parame != null) {
      this.Rhr.b(parame);
    }
    AppMethodBeat.o(216785);
  }
  
  public final void at(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(216777);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']', new Object[0]);
    this.Rhl = paramLong1;
    this.Rhm = paramLong2;
    AppMethodBeat.o(216777);
  }
  
  public final AssetExportSession b(String paramString, n.b paramb, AssetWriterVideoEncoder paramAssetWriterVideoEncoder, m<? super Boolean, ? super Integer, x> paramm, kotlin.g.a.b<? super Float, x> paramb1)
  {
    AppMethodBeat.i(216790);
    p.h(paramString, "path");
    p.h(paramb, "config");
    paramString = a(paramString, paramb, paramAssetWriterVideoEncoder, paramm, paramb1);
    AppMethodBeat.o(216790);
    return paramString;
  }
  
  public final TAVSource buildSource()
  {
    AppMethodBeat.i(216786);
    Object localObject2 = ka((List)this.Gzn);
    g localg = new g();
    this.Rhs = localg;
    long l = System.currentTimeMillis();
    Object localObject1 = this.GAw;
    if (localObject1 != null) {
      ((EffectManager)localObject1).b(com.tencent.mm.xeffect.effect.j.RxV);
    }
    int j = this.Gzn.size();
    int i = 1;
    if (i < j)
    {
      localObject1 = this.Gzn.get(i - 1);
      p.g(localObject1, "trackList[i - 1]");
      d locald1 = (d)localObject1;
      localObject1 = this.Gzn.get(i);
      p.g(localObject1, "trackList[i]");
      d locald2 = (d)localObject1;
      k localk = locald2.Rhc;
      if (localk.isValid()) {
        if (localk.GAn == null)
        {
          localObject1 = this.GAw;
          if (localObject1 == null) {
            break label236;
          }
        }
      }
      label236:
      for (localObject1 = ((EffectManager)localObject1).a(com.tencent.mm.xeffect.effect.j.RxV, localk.path);; localObject1 = null)
      {
        localk.GAn = ((ad)localObject1);
        localObject1 = localk.GAn;
        if (localObject1 != null) {
          ((ad)localObject1).aH(locald2.startTimeMs, locald1.endTimeMs);
        }
        localObject1 = this.GAw;
        if (localObject1 != null) {
          ((EffectManager)localObject1).a(localk.GAn);
        }
        i += 1;
        break;
      }
    }
    new StringBuilder("buildSource: update transition cost ").append(System.currentTimeMillis() - l);
    localg.lY(this.Rhn, this.Rho);
    localg.b(this.GAw);
    localg.t(this.Rhq);
    localg.Rhu = this.Rhu;
    localg.Rib = ((e)this.Rhr);
    ((TAVComposition)localObject2).setVideoMixEffect((TAVVideoMixEffect)new com.tencent.mm.videocomposition.b.b((a)localg));
    localObject1 = new TAVCompositionBuilder((TAVComposition)localObject2);
    ((TAVCompositionBuilder)localObject1).setReloadChannels(false);
    ((TAVCompositionBuilder)localObject1).setVideoTracksMerge(this.isVideoTracksMerge);
    ((TAVCompositionBuilder)localObject1).setAudioTracksMerge(this.isAudioTracksMerge);
    new StringBuilder("buildSource, videoTracksMerge:").append(this.isVideoTracksMerge).append(", audioTracksMerge:").append(this.isAudioTracksMerge);
    localObject1 = ((TAVCompositionBuilder)localObject1).buildSource();
    p.g(localObject1, "source");
    localObject2 = ((TAVSource)localObject1).getVideoComposition();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.tav.core.composition.MutableVideoComposition");
      AppMethodBeat.o(216786);
      throw ((Throwable)localObject1);
    }
    ((MutableVideoComposition)localObject2).setFrameDuration(new CMTime(1000L, (int)(this.Rhp * 1000.0F)));
    AppMethodBeat.o(216786);
    return localObject1;
  }
  
  public final void c(int paramInt, kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    AppMethodBeat.i(216787);
    p.h(paramb, "callback");
    Object localObject = c.RgU;
    localObject = c.a.b(this);
    if (!this.Rhq.isEmpty()) {}
    for (int i = (int)(this.Rhq.height() * 1.0F / this.Rhq.width() * paramInt);; i = (int)(this.Rho * 1.0F / this.Rhn * paramInt))
    {
      ((c)localObject).setSize(paramInt, i);
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", "getThumbBitmap request width:" + paramInt + ", height:" + i, new Object[0]);
      ((c)localObject).b(kotlin.a.j.listOf(Long.valueOf(getPlayStart())), (m)new n.d(paramb));
      AppMethodBeat.o(216787);
      return;
    }
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(216774);
    p.h(paramd, "track");
    this.Gzn.add(paramd);
    AppMethodBeat.o(216774);
  }
  
  public final long fBz()
  {
    AppMethodBeat.i(216773);
    if (this.Rhm >= 0L)
    {
      l = this.Rhm;
      AppMethodBeat.o(216773);
      return l;
    }
    long l = hfn();
    AppMethodBeat.o(216773);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(216775);
    long l1 = fBz();
    long l2 = getPlayStart();
    AppMethodBeat.o(216775);
    return l1 - l2;
  }
  
  public final long getPlayStart()
  {
    if (this.Rhl >= 0L) {
      return this.Rhl;
    }
    return this.Rhk;
  }
  
  public final long getSourceDuration()
  {
    AppMethodBeat.i(216776);
    long l1 = hfn();
    long l2 = this.Rhk;
    AppMethodBeat.o(216776);
    return l1 - l2;
  }
  
  public final CMTimeRange hfo()
  {
    AppMethodBeat.i(216778);
    CMTimeRange localCMTimeRange = new CMTimeRange(new CMTime(getPlayStart(), 1000), new CMTime(fBz() - getPlayStart(), 1000));
    AppMethodBeat.o(216778);
    return localCMTimeRange;
  }
  
  public final Size hfp()
  {
    AppMethodBeat.i(216781);
    Size localSize = new Size(this.Rhn, this.Rho);
    AppMethodBeat.o(216781);
    return localSize;
  }
  
  public final Size hfq()
  {
    AppMethodBeat.i(216783);
    if (this.Rhq.isEmpty())
    {
      localSize = hfp();
      AppMethodBeat.o(216783);
      return localSize;
    }
    Size localSize = new Size(this.Rhq.width(), this.Rhq.height());
    AppMethodBeat.o(216783);
    return localSize;
  }
  
  public final com.tencent.mm.videocomposition.b.d hfr()
  {
    g localg = this.Rhs;
    if (localg != null) {
      return localg.Rie;
    }
    return null;
  }
  
  public final void lW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216780);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setAssetSize: " + paramInt1 + ", " + paramInt2, new Object[0]);
    this.Rhn = paramInt1;
    this.Rho = paramInt2;
    g localg = this.Rhs;
    if (localg != null) {
      localg.lY(paramInt1, paramInt2);
    }
    this.viewRect.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(216780);
  }
  
  public final void t(Rect paramRect)
  {
    AppMethodBeat.i(216782);
    p.h(paramRect, "rect");
    this.Rhq.set(paramRect);
    AppMethodBeat.o(216782);
  }
  
  public final void wB(boolean paramBoolean)
  {
    AppMethodBeat.i(216784);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "enableVideoSound:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.Gzo = paramBoolean;
    AppMethodBeat.o(216784);
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"<anonymous>", "", "assetExportSession", "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "handlerCallback"})
  static final class c
    implements AssetExportSession.ExportCallbackHandler
  {
    c(kotlin.g.a.b paramb, long paramLong, m paramm) {}
    
    public final void handlerCallback(AssetExportSession paramAssetExportSession)
    {
      AppMethodBeat.i(216770);
      p.g(paramAssetExportSession, "assetExportSession");
      AssetExportSession.AssetExportSessionStatus localAssetExportSessionStatus = paramAssetExportSession.getStatus();
      int i = paramAssetExportSession.getErrCode();
      float f = paramAssetExportSession.getProgress();
      if (localAssetExportSessionStatus == null) {}
      for (;;)
      {
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export failed other status:" + localAssetExportSessionStatus + ", progress:" + f, new Object[0]);
        paramAssetExportSession = this.nzd;
        if (paramAssetExportSession == null) {
          break;
        }
        paramAssetExportSession.invoke(Boolean.FALSE, Integer.valueOf(i));
        AppMethodBeat.o(216770);
        return;
        switch (o.$EnumSwitchMapping$0[localAssetExportSessionStatus.ordinal()])
        {
        }
      }
      paramAssetExportSession = this.Rhz;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.invoke(Float.valueOf(f));
        AppMethodBeat.o(216770);
        return;
      }
      AppMethodBeat.o(216770);
      return;
      paramAssetExportSession = new StringBuilder("export completed: ").append(f).append(", cost:");
      long l = this.qVz;
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", SystemClock.elapsedRealtime() - l, new Object[0]);
      paramAssetExportSession = this.nzd;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.invoke(Boolean.TRUE, Integer.valueOf(i));
        AppMethodBeat.o(216770);
        return;
      }
      AppMethodBeat.o(216770);
      return;
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export failed: status:" + localAssetExportSessionStatus + ", progress:" + f, new Object[0]);
      paramAssetExportSession = this.nzd;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.invoke(Boolean.FALSE, Integer.valueOf(i));
        AppMethodBeat.o(216770);
        return;
      }
      AppMethodBeat.o(216770);
      return;
      AppMethodBeat.o(216770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.n
 * JD-Core Version:    0.7.0.1
 */