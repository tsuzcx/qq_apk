package com.tencent.mm.videocomposition;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.f;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.tav.codec.IMediaFactory;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.AssetExportSessionStatus;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.core.AssetParallelExportSession;
import com.tencent.tav.core.AssetParallelExportSession.ExportCallbackHandler;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.composition.MutableVideoComposition;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.w;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/VideoComposition;", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "(Ljava/util/List;)V", "origin", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "()V", "assetHeight", "", "assetWidth", "audioProcessorFactory", "Lcom/tencent/mm/videocomposition/audio/IAudioProcessorFactory;", "cancelCallback", "Lkotlin/Function0;", "", "getCancelCallback", "()Lkotlin/jvm/functions/Function0;", "setCancelCallback", "(Lkotlin/jvm/functions/Function0;)V", "checkPerformance", "", "effect", "Lcom/tencent/mm/videocomposition/render/VLogDirectorMultiVideoCompositionEffect;", "enableOriginAudio", "exportSession", "Lcom/tencent/tav/core/AssetExportSession;", "id", "", "getId", "()J", "setId", "(J)V", "isAudioTracksMerge", "isRevert", "isVideoTracksMerge", "mediaFactory", "Lcom/tencent/tav/codec/IMediaFactory;", "getMediaFactory", "()Lcom/tencent/tav/codec/IMediaFactory;", "setMediaFactory", "(Lcom/tencent/tav/codec/IMediaFactory;)V", "outputCrop", "Landroid/graphics/Rect;", "playEnd", "getPlayEnd", "playFps", "", "playStart", "getPlayStart", "renderCallback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallbackList;", "setEnd", "getSetEnd", "setSetEnd", "setStart", "getSetStart", "setSetStart", "sourceEnd", "getSourceEnd", "sourceStart", "getSourceStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "viewRect", "addRenderProcessCallback", "callback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "addTrack", "track", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "isEdited", "buildTrackChannel", "Lcom/tencent/tavkit/composition/TAVClip;", "cancelExport", "createComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "enableVideoSound", "enable", "export", "path", "", "config", "Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "Lkotlin/Function2;", "progressCallback", "Lkotlin/Function1;", "exportImpl", "exportWithCustomEncoder", "getAssetSize", "Landroid/util/Size;", "getDisplayScreenRect", "getDurationMs", "getExportPerformanceReport", "Lcom/tencent/tav/report/ExportReportSession;", "getOutputSize", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getRenderPerformanceReport", "Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "getRenderSize", "getSourceDuration", "getThumbBitmap", "widthLimit", "Landroid/graphics/Bitmap;", "getTrackByTimeMs", "timeMs", "getTrackList", "getVLogEffectMgr", "isEnableOriginSound", "parallelExport", "Lcom/tencent/tav/core/AssetParallelExportSession;", "Lkotlin/Function3;", "Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;", "removeRenderProcessCallback", "removeTrack", "setAssetSize", "width", "height", "setAudioProcessorFactory", "setAudioTracksMerge", "audioTracksMerge", "setCheckPerformance", "check", "setDisplayScreenRect", "rect", "setOutputCrop", "setPlayFps", "fps", "setPlayRange", "start", "end", "setRenderSize", "setRevert", "revert", "setTrackList", "setVLogEffectMgr", "setVideoTracksMerge", "videoTracksMerge", "updateTrack", "index", "Companion", "VideoOutputConfig", "video_composition_release"}, k=1, mv={1, 1, 15})
public class j
{
  public static final j.a agDW;
  public kotlin.g.a.a<ah> Eox;
  public final ArrayList<b> TDz;
  public boolean Uax;
  public EffectManager UbK;
  public final long agDK;
  public long agDL;
  public long agDM;
  public int agDN;
  public int agDO;
  public float agDP;
  public final Rect agDQ;
  private f agDR;
  private com.tencent.mm.videocomposition.c.g agDS;
  public com.tencent.mm.videocomposition.a.b agDT;
  public boolean agDU;
  private boolean agDV;
  private AssetExportSession exportSession;
  private boolean isAudioTracksMerge;
  private boolean isVideoTracksMerge;
  public IMediaFactory mediaFactory;
  private Rect viewRect;
  
  static
  {
    AppMethodBeat.i(233579);
    agDW = new j.a((byte)0);
    d locald = d.agDG;
    d.fXr();
    AppMethodBeat.o(233579);
  }
  
  public j()
  {
    AppMethodBeat.i(233568);
    this.agDL = -1L;
    this.agDM = -1L;
    this.viewRect = new Rect();
    this.agDP = 30.0F;
    this.agDQ = new Rect();
    this.agDR = new f();
    this.TDz = new ArrayList();
    this.isVideoTracksMerge = true;
    com.tencent.mm.videocomposition.d.b.i("VideoComposition", "create VLogComposition", new Object[0]);
    AppMethodBeat.o(233568);
  }
  
  public j(List<b> paramList)
  {
    this();
    AppMethodBeat.i(233573);
    this.TDz.addAll((Collection)paramList);
    AppMethodBeat.o(233573);
  }
  
  private TAVSource NW(boolean paramBoolean)
  {
    AppMethodBeat.i(233532);
    Object localObject3 = (List)this.TDz;
    com.tencent.mm.videocomposition.d.b.i("VideoComposition", "createComposition: track size " + ((List)localObject3).size(), new Object[0]);
    long l;
    int i;
    label100:
    Object localObject5;
    Object localObject4;
    if (((List)localObject3).isEmpty())
    {
      localObject1 = new TAVComposition();
      l = System.currentTimeMillis();
      localObject2 = this.UbK;
      if (localObject2 != null) {
        ((EffectManager)localObject2).b(com.tencent.mm.xeffect.effect.j.agXN);
      }
      int j = this.TDz.size();
      i = 1;
      if (i >= j) {
        break label1161;
      }
      localObject2 = this.TDz.get(i - 1);
      s.r(localObject2, "trackList[i - 1]");
      localObject3 = (b)localObject2;
      localObject2 = this.TDz.get(i);
      s.r(localObject2, "trackList[i]");
      localObject5 = (b)localObject2;
      localObject4 = ((b)localObject5).TDy;
      if (((g)localObject4).isValid()) {
        if (((g)localObject4).Uby == null)
        {
          localObject2 = this.UbK;
          if (localObject2 == null) {
            break label1155;
          }
        }
      }
    }
    label1155:
    for (Object localObject2 = ((EffectManager)localObject2).a(com.tencent.mm.xeffect.effect.j.agXN, ((g)localObject4).path);; localObject2 = null)
    {
      ((g)localObject4).Uby = ((af)localObject2);
      localObject2 = ((g)localObject4).Uby;
      if (localObject2 != null) {
        ((af)localObject2).bL(((b)localObject5).startTimeMs, ((b)localObject3).endTimeMs);
      }
      localObject2 = this.UbK;
      if (localObject2 != null) {
        ((EffectManager)localObject2).b(((g)localObject4).Uby);
      }
      i += 1;
      break label100;
      localObject2 = new TAVComposition();
      localObject1 = (Iterable)localObject3;
      localObject4 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
      localObject5 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject5).hasNext())
      {
        b localb = (b)((Iterator)localObject5).next();
        com.tencent.mm.videocomposition.d.b.i("VideoComposition", "add track type:" + localb.type + " startTime:" + localb.startTimeMs + ", endTime:" + localb.endTimeMs + ", trackStartTime:" + localb.TDw + ", trackEndTime:" + localb.TDx, new Object[0]);
        boolean bool = this.Uax;
        Object localObject6;
        if (localb.type != 0)
        {
          localObject1 = new TAVClip(e.agDJ.e(localb));
          ((TAVClip)localObject1).setStartTime(new CMTime(localb.startTimeMs, 1000));
          ((TAVClip)localObject1).setDuration(new CMTime(localb.getDurationMs(), 1000));
          localObject6 = ((TAVClip)localObject1).getResource();
          s.r(localObject6, "clip.resource");
          ((TAVResource)localObject6).setSourceTimeRange(new CMTimeRange(new CMTime(localb.TDw, 1000), new CMTime(localb.TDx - localb.TDw, 1000)));
          if ((localb.type == 2) && (!bool))
          {
            localObject6 = ((TAVClip)localObject1).getAudioConfiguration();
            s.r(localObject6, "clip.audioConfiguration");
            ((TAVAudioConfiguration)localObject6).setVolume(0.0F);
            label590:
            localb.agDE = ((TAVClip)localObject1);
            com.tencent.mm.videocomposition.d.b.i("CompositionTrack", localb.id + " buildClip buildVideoClip, path:" + localb.path + ", video startEnd:[" + localb.TDw + ", " + localb.TDx + "], material startEnd:[" + localb.startTimeMs + ", " + localb.endTimeMs + "], volume: " + localb.volume, new Object[0]);
            label709:
            localObject6 = this.agDT;
            if (localObject6 != null)
            {
              localObject6 = ((com.tencent.mm.videocomposition.a.b)localObject6).h(localb);
              if (localObject6 != null) {
                ((TAVClip)localObject1).getAudioConfiguration().addAudioProcessorNode((TAVAudioProcessorNode)localObject6);
              }
            }
            ((TAVClip)localObject1).putExtraTrackInfo("key_extra_track", localb);
            if (localb.startTimeMs <= 0L) {
              break label943;
            }
            localObject6 = new TAVClip((TAVResource)new TAVEmptyResource(new CMTime(localb.startTimeMs, 1000)));
            ((TAVClip)localObject6).setStartTime(CMTime.CMTimeZero);
            ((TAVClip)localObject6).setDuration(new CMTime(localb.startTimeMs, 1000));
            com.tencent.mm.videocomposition.d.b.i("VideoComposition", "add front empty clip duration:" + localb.startTimeMs, new Object[0]);
          }
        }
        label943:
        for (localObject1 = p.listOf(new TAVClip[] { localObject6, localObject1 });; localObject1 = p.listOf(localObject1))
        {
          ((Collection)localObject4).add(localObject1);
          break;
          localObject6 = ((TAVClip)localObject1).getAudioConfiguration();
          s.r(localObject6, "clip.audioConfiguration");
          ((TAVAudioConfiguration)localObject6).setVolume(localb.volume);
          break label590;
          localObject1 = new TAVClip((TAVResource)new TAVEmptyResource(CMTime.CMTimeZero));
          break label709;
        }
      }
      localObject1 = ((Iterable)localObject4).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localObject4 = (List)localObject4;
        if (((b)((List)localObject3).get(i)).hSf()) {
          ((TAVComposition)localObject2).addVideoChannel((List)localObject4);
        }
        if ((((b)((List)localObject3).get(i)).type == 2) || (((b)((List)localObject3).get(i)).type == 3) || (((b)((List)localObject3).get(i)).type == 1)) {
          ((TAVComposition)localObject2).addAudioChannel((List)localObject4);
        }
        i += 1;
      }
      localObject1 = new StringBuilder("finish build composition, duration:");
      localObject3 = ((TAVComposition)localObject2).getDuration();
      s.r(localObject3, "composition.duration");
      com.tencent.mm.videocomposition.d.b.i("VideoComposition", ((CMTime)localObject3).getTimeUs() / 1000L, new Object[0]);
      localObject1 = localObject2;
      break;
    }
    label1161:
    new StringBuilder("buildSource: update transition cost ").append(System.currentTimeMillis() - l);
    if (paramBoolean)
    {
      localObject2 = new com.tencent.mm.videocomposition.c.g();
      this.agDS = ((com.tencent.mm.videocomposition.c.g)localObject2);
      ((com.tencent.mm.videocomposition.c.g)localObject2).pm(this.agDN, this.agDO);
      localObject3 = this.UbK;
      if ((s.p(localObject3, ((com.tencent.mm.videocomposition.c.g)localObject2).UbK) ^ true))
      {
        ((com.tencent.mm.videocomposition.c.g)localObject2).UbK = ((EffectManager)localObject3);
        ((com.tencent.mm.videocomposition.c.g)localObject2).agFC = true;
      }
      localObject3 = this.agDQ;
      s.t(localObject3, "rect");
      ((com.tencent.mm.videocomposition.c.g)localObject2).agDQ.set((Rect)localObject3);
      if (!((com.tencent.mm.videocomposition.c.g)localObject2).agDQ.isEmpty())
      {
        ((com.tencent.mm.videocomposition.c.g)localObject2).outputWidth = ((com.tencent.mm.videocomposition.c.g)localObject2).agDQ.width();
        ((com.tencent.mm.videocomposition.c.g)localObject2).outputHeight = ((com.tencent.mm.videocomposition.c.g)localObject2).agDQ.height();
      }
      ((com.tencent.mm.videocomposition.c.g)localObject2).agDV = this.agDV;
      ((com.tencent.mm.videocomposition.c.g)localObject2).agFB = ((com.tencent.mm.videocomposition.c.e)this.agDR);
      ((TAVComposition)localObject1).setVideoMixEffect((TAVVideoMixEffect)new com.tencent.mm.videocomposition.c.b((com.tencent.mm.videocomposition.c.a)localObject2));
    }
    Object localObject1 = new TAVCompositionBuilder((TAVComposition)localObject1);
    ((TAVCompositionBuilder)localObject1).setReloadChannels(false);
    ((TAVCompositionBuilder)localObject1).setVideoTracksMerge(this.isVideoTracksMerge);
    ((TAVCompositionBuilder)localObject1).setAudioTracksMerge(this.isAudioTracksMerge);
    new StringBuilder("buildSource, videoTracksMerge:").append(this.isVideoTracksMerge).append(", audioTracksMerge:").append(this.isAudioTracksMerge);
    localObject1 = ((TAVCompositionBuilder)localObject1).buildSource();
    if (!paramBoolean)
    {
      s.r(localObject1, "source");
      localObject2 = ((TAVSource)localObject1).getVideoComposition();
      if (localObject2 == null)
      {
        localObject1 = new w("null cannot be cast to non-null type com.tencent.tav.core.composition.MutableVideoComposition");
        AppMethodBeat.o(233532);
        throw ((Throwable)localObject1);
      }
      ((MutableVideoComposition)localObject2).setCustomVideoCompositorClass(com.tencent.mm.videocomposition.b.a.class);
    }
    s.r(localObject1, "source");
    localObject2 = ((TAVSource)localObject1).getVideoComposition();
    if (localObject2 == null)
    {
      localObject1 = new w("null cannot be cast to non-null type com.tencent.tav.core.composition.MutableVideoComposition");
      AppMethodBeat.o(233532);
      throw ((Throwable)localObject1);
    }
    ((MutableVideoComposition)localObject2).setFrameDuration(new CMTime(1000L, (int)(this.agDP * 1000.0F)));
    AppMethodBeat.o(233532);
    return localObject1;
  }
  
  private final AssetExportSession a(final String paramString, b paramb, boolean paramBoolean, m<? super Boolean, ? super Integer, ah> paramm, final kotlin.g.a.b<? super Float, ah> paramb1)
  {
    AppMethodBeat.i(233553);
    TAVSource localTAVSource = NW(paramBoolean);
    Object localObject = new ExportConfig(paramb.agDY.getWidth(), paramb.agDY.getHeight());
    ((ExportConfig)localObject).setOutputFilePath(paramString);
    ((ExportConfig)localObject).setNeedCorrectSizeByCodecCapabilities(paramb.correctSizeByCodecCapabilities);
    ((ExportConfig)localObject).setVideoBitRate(paramb.videoBitrate);
    ((ExportConfig)localObject).setVideoFrameRate(paramb.fps);
    ((ExportConfig)localObject).setVideoIFrameInterval(paramb.nxQ);
    ((ExportConfig)localObject).setHighProfile(paramb.agDZ);
    ((ExportConfig)localObject).setAudioBitRate(paramb.audioBitrate);
    ((ExportConfig)localObject).setAudioSampleRateHz(paramb.audioSampleRate);
    ((ExportConfig)localObject).setAudioChannelCount(paramb.audioChannelCount);
    ((ExportConfig)localObject).setAudioEncodeNeedCodecSpecificData(paramb.agEa);
    ((ExportConfig)localObject).setEncodeHevc(paramb.oYa);
    if (Build.VERSION.SDK_INT >= 24) {
      ((ExportConfig)localObject).setColorSpace(paramb.colorRange, paramb.colorStandard, paramb.colorTransfer);
    }
    com.tencent.mm.videocomposition.d.b.i("VideoComposition", "export: config: " + ((ExportConfig)localObject).getOutputWidth() + ", " + ((ExportConfig)localObject).getOutputHeight() + "; video: " + ((ExportConfig)localObject).getVideoBitRate() + ", " + ((ExportConfig)localObject).getVideoFrameRate() + ", " + paramb.nxQ + ", " + paramb.agDZ + "; audio: " + paramb.audioBitrate + ", " + paramb.audioSampleRate + ", " + paramb.audioChannelCount + ", aacEncodeNeedCodecSpecificData:" + paramb.agEa + ", outputHevc:" + paramb.oYa + ", correctSizeByCodecCapabilities:" + paramb.correctSizeByCodecCapabilities, new Object[0]);
    localObject = new AssetExportSession(localTAVSource.getAsset(), (ExportConfig)localObject);
    if (!paramBoolean) {
      ((AssetExportSession)localObject).setAppliesPreferredTrackTransform(true);
    }
    ((AssetExportSession)localObject).setOutputFilePath(paramString);
    ((AssetExportSession)localObject).setOutputFileType("mp4");
    ((AssetExportSession)localObject).setVideoComposition(localTAVSource.getVideoComposition());
    ((AssetExportSession)localObject).setAudioMix(localTAVSource.getAudioMix());
    ((AssetExportSession)localObject).setTimeRange(jLV());
    ((AssetExportSession)localObject).setRevertMode(this.agDU);
    ((AssetExportSession)localObject).setMediaFactory(this.mediaFactory);
    ((AssetExportSession)localObject).setTimeoutParameter(paramb.agDX, paramb.timeoutInterruptWork);
    com.tencent.mm.videocomposition.d.b.i("VideoComposition", "export duration:" + (jLU() - this.agDK) + " playRange:" + jLV(), new Object[0]);
    final long l = SystemClock.elapsedRealtime();
    paramString = new ah.a();
    paramString.aiwY = false;
    ((AssetExportSession)localObject).exportAsynchronouslyWithCompletionHandler((AssetExportSession.ExportCallbackHandler)new c(this, paramb1, paramString, l, paramm));
    this.exportSession = ((AssetExportSession)localObject);
    AppMethodBeat.o(233553);
    return localObject;
  }
  
  public final void FO(boolean paramBoolean)
  {
    AppMethodBeat.i(233646);
    com.tencent.mm.videocomposition.d.b.i("VideoComposition", "enableVideoSound:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.Uax = paramBoolean;
    AppMethodBeat.o(233646);
  }
  
  public final void L(Rect paramRect)
  {
    AppMethodBeat.i(233635);
    s.t(paramRect, "rect");
    this.agDQ.set(paramRect);
    AppMethodBeat.o(233635);
  }
  
  public final AssetParallelExportSession a(String paramString, b paramb, q<? super Boolean, ? super Integer, ? super ArrayList<PipelineIndicatorInfo>, ah> paramq, final kotlin.g.a.b<? super Float, ah> paramb1)
  {
    AppMethodBeat.i(233671);
    s.t(paramString, "path");
    s.t(paramb, "config");
    TAVSource localTAVSource = NW(false);
    Object localObject = new ExportConfig(paramb.agDY.getWidth(), paramb.agDY.getHeight());
    ((ExportConfig)localObject).setOutputFilePath(paramString);
    ((ExportConfig)localObject).setVideoBitRate(paramb.videoBitrate);
    ((ExportConfig)localObject).setVideoFrameRate(paramb.fps);
    ((ExportConfig)localObject).setVideoIFrameInterval(paramb.nxQ);
    ((ExportConfig)localObject).setHighProfile(paramb.agDZ);
    ((ExportConfig)localObject).setAudioBitRate(paramb.audioBitrate);
    ((ExportConfig)localObject).setAudioSampleRateHz(paramb.audioSampleRate);
    ((ExportConfig)localObject).setAudioChannelCount(paramb.audioChannelCount);
    ((ExportConfig)localObject).setAudioEncodeNeedCodecSpecificData(paramb.agEa);
    ((ExportConfig)localObject).setEncodeHevc(paramb.oYa);
    ((ExportConfig)localObject).setSuggestParallelCount(paramb.suggestParallelCount);
    com.tencent.mm.videocomposition.d.b.i("VideoComposition", "export: config: " + ((ExportConfig)localObject).getOutputWidth() + ", " + ((ExportConfig)localObject).getOutputHeight() + "; video: " + ((ExportConfig)localObject).getVideoBitRate() + ", " + ((ExportConfig)localObject).getVideoFrameRate() + ", " + paramb.nxQ + ", " + paramb.agDZ + "; audio: " + paramb.audioBitrate + ", " + paramb.audioSampleRate + ", " + paramb.audioChannelCount + ", aacEncodeNeedCodecSpecificData:" + paramb.agEa + ',' + "outputHevc:" + paramb.oYa, new Object[0]);
    localObject = new AssetParallelExportSession(localTAVSource.getAsset(), (ExportConfig)localObject);
    ((AssetParallelExportSession)localObject).setAppliesPreferredTrackTransform(true);
    ((AssetParallelExportSession)localObject).outputFilePath = paramString;
    ((AssetParallelExportSession)localObject).outputFileType = "mp4";
    ((AssetParallelExportSession)localObject).videoComposition = localTAVSource.getVideoComposition();
    ((AssetParallelExportSession)localObject).setAudioMix(localTAVSource.getAudioMix());
    ((AssetParallelExportSession)localObject).timeRange = jLV();
    ((AssetParallelExportSession)localObject).setRevertMode(this.agDU);
    ((AssetParallelExportSession)localObject).setMediaFactory(this.mediaFactory);
    ((AssetParallelExportSession)localObject).setTimeoutParameter(paramb.agDX, paramb.timeoutInterruptWork);
    com.tencent.mm.videocomposition.d.b.i("VideoComposition", "export duration:" + (jLU() - this.agDK) + " playRange:" + jLV(), new Object[0]);
    ((AssetParallelExportSession)localObject).exportAsynchronouslyWithCompletionHandler((AssetParallelExportSession.ExportCallbackHandler)new e(this, paramb1, SystemClock.elapsedRealtime(), paramq));
    AppMethodBeat.o(233671);
    return localObject;
  }
  
  public final void a(com.tencent.mm.videocomposition.c.e parame)
  {
    AppMethodBeat.i(233654);
    if (parame != null) {
      this.agDR.b(parame);
    }
    AppMethodBeat.o(233654);
  }
  
  public final AssetExportSession b(String paramString, b paramb, boolean paramBoolean, m<? super Boolean, ? super Integer, ah> paramm, kotlin.g.a.b<? super Float, ah> paramb1)
  {
    AppMethodBeat.i(233661);
    s.t(paramString, "path");
    s.t(paramb, "config");
    paramString = a(paramString, paramb, paramBoolean, paramm, paramb1);
    AppMethodBeat.o(233661);
    return paramString;
  }
  
  public final void bs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(233616);
    com.tencent.mm.videocomposition.d.b.i("VideoComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']', new Object[0]);
    this.agDL = paramLong1;
    this.agDM = paramLong2;
    AppMethodBeat.o(233616);
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(233600);
    s.t(paramb, "track");
    this.TDz.add(paramb);
    AppMethodBeat.o(233600);
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(233604);
    long l1 = hQW();
    long l2 = getPlayStart();
    AppMethodBeat.o(233604);
    return l1 - l2;
  }
  
  public final long getPlayStart()
  {
    if (this.agDL >= 0L) {
      return this.agDL;
    }
    return this.agDK;
  }
  
  public final long getSourceDuration()
  {
    AppMethodBeat.i(233612);
    long l1 = jLU();
    long l2 = this.agDK;
    AppMethodBeat.o(233612);
    return l1 - l2;
  }
  
  public final long hQW()
  {
    AppMethodBeat.i(233595);
    if (this.agDM >= 0L)
    {
      l = this.agDM;
      AppMethodBeat.o(233595);
      return l;
    }
    long l = jLU();
    AppMethodBeat.o(233595);
    return l;
  }
  
  public final long jLU()
  {
    AppMethodBeat.i(233588);
    Object localObject2 = (Iterable)this.TDz;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((b)localObject3).hSf()) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    Object localObject3 = ((Iterable)localObject1).iterator();
    if (!((Iterator)localObject3).hasNext()) {
      localObject1 = null;
    }
    do
    {
      localObject1 = (b)localObject1;
      if (localObject1 == null) {
        break;
      }
      l1 = ((b)localObject1).endTimeMs;
      AppMethodBeat.o(233588);
      return l1;
      localObject1 = ((Iterator)localObject3).next();
    } while (!((Iterator)localObject3).hasNext());
    long l1 = ((b)localObject1).endTimeMs;
    label164:
    localObject2 = ((Iterator)localObject3).next();
    long l2 = ((b)localObject2).endTimeMs;
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
        AppMethodBeat.o(233588);
        return 0L;
      }
      break label164;
    }
  }
  
  public final CMTimeRange jLV()
  {
    AppMethodBeat.i(233621);
    CMTimeRange localCMTimeRange = new CMTimeRange(new CMTime(getPlayStart(), 1000), new CMTime(hQW() - getPlayStart(), 1000));
    AppMethodBeat.o(233621);
    return localCMTimeRange;
  }
  
  public final Size jLW()
  {
    AppMethodBeat.i(233631);
    Size localSize = new Size(this.agDN, this.agDO);
    AppMethodBeat.o(233631);
    return localSize;
  }
  
  public final Size jLX()
  {
    AppMethodBeat.i(233639);
    if (this.agDQ.isEmpty())
    {
      localSize = jLW();
      AppMethodBeat.o(233639);
      return localSize;
    }
    Size localSize = new Size(this.agDQ.width(), this.agDQ.height());
    AppMethodBeat.o(233639);
    return localSize;
  }
  
  public final com.tencent.mm.videocomposition.c.d jLY()
  {
    com.tencent.mm.videocomposition.c.g localg = this.agDS;
    if (localg != null) {
      return localg.agFD;
    }
    return null;
  }
  
  public final boolean jLZ()
  {
    AppMethodBeat.i(233688);
    AssetExportSession localAssetExportSession = this.exportSession;
    if (localAssetExportSession != null) {
      localAssetExportSession.cancelExport();
    }
    AppMethodBeat.o(233688);
    return true;
  }
  
  public final void pk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233626);
    com.tencent.mm.videocomposition.d.b.i("VideoComposition", "setAssetSize: " + paramInt1 + ", " + paramInt2, new Object[0]);
    this.agDN = paramInt1;
    this.agDO = paramInt2;
    com.tencent.mm.videocomposition.c.g localg = this.agDS;
    if (localg != null) {
      localg.pm(paramInt1, paramInt2);
    }
    this.viewRect.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(233626);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "", "targetSize", "Landroid/util/Size;", "videoBitrate", "", "fps", "iFrameInterval", "audioBitrate", "audioSampleRate", "audioChannelCount", "highProfileEnable", "", "aacEncodeNeedCodecSpecificData", "outputHevc", "suggestParallelCount", "(Landroid/util/Size;IIIIIIZZZI)V", "getAacEncodeNeedCodecSpecificData", "()Z", "getAudioBitrate", "()I", "getAudioChannelCount", "getAudioSampleRate", "checkFrameProcessTimeout", "getCheckFrameProcessTimeout", "setCheckFrameProcessTimeout", "(Z)V", "colorRange", "getColorRange", "setColorRange", "(I)V", "colorStandard", "getColorStandard", "setColorStandard", "colorTransfer", "getColorTransfer", "setColorTransfer", "correctSizeByCodecCapabilities", "getCorrectSizeByCodecCapabilities", "setCorrectSizeByCodecCapabilities", "getFps", "getHighProfileEnable", "getIFrameInterval", "getOutputHevc", "setOutputHevc", "getSuggestParallelCount", "setSuggestParallelCount", "getTargetSize", "()Landroid/util/Size;", "timeoutInterruptWork", "getTimeoutInterruptWork", "setTimeoutInterruptWork", "getVideoBitrate", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static final class b
  {
    public boolean agDX;
    final Size agDY;
    final boolean agDZ;
    final boolean agEa;
    public final int audioBitrate;
    public final int audioChannelCount;
    public final int audioSampleRate;
    public int colorRange;
    public int colorStandard;
    public int colorTransfer;
    public boolean correctSizeByCodecCapabilities;
    public final int fps;
    final int nxQ;
    public boolean oYa;
    public int suggestParallelCount;
    boolean timeoutInterruptWork;
    final int videoBitrate;
    
    private b(Size paramSize, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(233536);
      this.agDY = paramSize;
      this.videoBitrate = paramInt1;
      this.fps = paramInt2;
      this.nxQ = paramInt3;
      this.audioBitrate = paramInt4;
      this.audioSampleRate = paramInt5;
      this.audioChannelCount = paramInt6;
      this.agDZ = paramBoolean1;
      this.agEa = false;
      this.oYa = paramBoolean2;
      this.suggestParallelCount = -1;
      this.correctSizeByCodecCapabilities = true;
      this.agDX = true;
      AppMethodBeat.o(233536);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(233562);
      if (this != paramObject)
      {
        if (!(paramObject instanceof b)) {
          break label263;
        }
        paramObject = (b)paramObject;
        if (!s.p(this.agDY, paramObject.agDY)) {
          break label263;
        }
        if (this.videoBitrate != paramObject.videoBitrate) {
          break label213;
        }
        i = 1;
        if (i == 0) {
          break label263;
        }
        if (this.fps != paramObject.fps) {
          break label218;
        }
        i = 1;
        label66:
        if (i == 0) {
          break label263;
        }
        if (this.nxQ != paramObject.nxQ) {
          break label223;
        }
        i = 1;
        label83:
        if (i == 0) {
          break label263;
        }
        if (this.audioBitrate != paramObject.audioBitrate) {
          break label228;
        }
        i = 1;
        label100:
        if (i == 0) {
          break label263;
        }
        if (this.audioSampleRate != paramObject.audioSampleRate) {
          break label233;
        }
        i = 1;
        label117:
        if (i == 0) {
          break label263;
        }
        if (this.audioChannelCount != paramObject.audioChannelCount) {
          break label238;
        }
        i = 1;
        label134:
        if (i == 0) {
          break label263;
        }
        if (this.agDZ != paramObject.agDZ) {
          break label243;
        }
        i = 1;
        label151:
        if (i == 0) {
          break label263;
        }
        if (this.agEa != paramObject.agEa) {
          break label248;
        }
        i = 1;
        label168:
        if (i == 0) {
          break label263;
        }
        if (this.oYa != paramObject.oYa) {
          break label253;
        }
        i = 1;
        label185:
        if (i == 0) {
          break label263;
        }
        if (this.suggestParallelCount != paramObject.suggestParallelCount) {
          break label258;
        }
      }
      label258:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label263;
        }
        AppMethodBeat.o(233562);
        return true;
        label213:
        i = 0;
        break;
        label218:
        i = 0;
        break label66;
        label223:
        i = 0;
        break label83;
        label228:
        i = 0;
        break label100;
        label233:
        i = 0;
        break label117;
        label238:
        i = 0;
        break label134;
        label243:
        i = 0;
        break label151;
        label248:
        i = 0;
        break label168;
        label253:
        i = 0;
        break label185;
      }
      label263:
      AppMethodBeat.o(233562);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(233550);
      String str = "VideoOutputConfig(targetSize=" + this.agDY + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", iFrameInterval=" + this.nxQ + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", highProfileEnable=" + this.agDZ + ", aacEncodeNeedCodecSpecificData=" + this.agEa + ", outputHevc=" + this.oYa + ", suggestParallelCount=" + this.suggestParallelCount + ")";
      AppMethodBeat.o(233550);
      return str;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "assetExportSession", "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "handlerCallback"}, k=3, mv={1, 1, 15})
  static final class c
    implements AssetExportSession.ExportCallbackHandler
  {
    c(j paramj, kotlin.g.a.b paramb, ah.a parama, long paramLong, m paramm) {}
    
    public final void handlerCallback(AssetExportSession paramAssetExportSession)
    {
      AppMethodBeat.i(233542);
      s.r(paramAssetExportSession, "assetExportSession");
      AssetExportSession.AssetExportSessionStatus localAssetExportSessionStatus = paramAssetExportSession.getStatus();
      int k = paramAssetExportSession.getErrCode();
      float f = paramAssetExportSession.getProgress();
      int i;
      int j;
      label49:
      boolean bool;
      if (localAssetExportSessionStatus == AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting)
      {
        i = 1;
        if (localAssetExportSessionStatus != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled) {
          break label95;
        }
        j = 1;
        if (localAssetExportSessionStatus != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted) {
          break label101;
        }
        bool = true;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramAssetExportSession = paramb1;
          if (paramAssetExportSession != null)
          {
            paramAssetExportSession.invoke(Float.valueOf(f));
            AppMethodBeat.o(233542);
            return;
            i = 0;
            break;
            label95:
            j = 0;
            break label49;
            label101:
            bool = false;
            continue;
          }
          AppMethodBeat.o(233542);
          return;
        }
      }
      paramAssetExportSession = new StringBuilder("export finish: finish:").append(paramString.aiwY).append(" status:").append(localAssetExportSessionStatus).append(", progress:").append(f).append(", cost:");
      long l = l;
      com.tencent.mm.videocomposition.d.b.i("VideoComposition", SystemClock.elapsedRealtime() - l, new Object[0]);
      if (!paramString.aiwY)
      {
        paramString.aiwY = true;
        if (j != 0)
        {
          paramAssetExportSession = this.agEb.Eox;
          if (paramAssetExportSession != null) {
            paramAssetExportSession.invoke();
          }
        }
        paramAssetExportSession = this.tGw;
        if (paramAssetExportSession != null) {
          paramAssetExportSession.invoke(Boolean.valueOf(bool), Integer.valueOf(k));
        }
        if (!bool) {
          this.agEb.jLZ();
        }
      }
      AppMethodBeat.o(233542);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "assetExportSession", "Lcom/tencent/tav/core/AssetParallelExportSession;", "kotlin.jvm.PlatformType", "handlerCallback"}, k=3, mv={1, 1, 15})
  static final class e
    implements AssetParallelExportSession.ExportCallbackHandler
  {
    e(j paramj, kotlin.g.a.b paramb, long paramLong, q paramq) {}
    
    public final void handlerCallback(AssetParallelExportSession paramAssetParallelExportSession)
    {
      AppMethodBeat.i(233543);
      Object localObject = paramAssetParallelExportSession.status;
      s.r(paramAssetParallelExportSession, "assetExportSession");
      int i = paramAssetParallelExportSession.getErrCode();
      float f = paramAssetParallelExportSession.progress;
      if (localObject == null) {}
      Boolean localBoolean;
      for (;;)
      {
        com.tencent.mm.videocomposition.d.b.i("VideoComposition", "export failed other status:" + localObject + ", progress:" + f, new Object[0]);
        localObject = this.vSY;
        if (localObject == null) {
          break;
        }
        localBoolean = Boolean.FALSE;
        paramAssetParallelExportSession = paramAssetParallelExportSession.getIndicatorInfo();
        s.r(paramAssetParallelExportSession, "assetExportSession.indicatorInfo");
        ((q)localObject).invoke(localBoolean, Integer.valueOf(i), paramAssetParallelExportSession);
        AppMethodBeat.o(233543);
        return;
        switch (k.$EnumSwitchMapping$0[localObject.ordinal()])
        {
        }
      }
      paramAssetParallelExportSession = paramb1;
      if (paramAssetParallelExportSession != null)
      {
        paramAssetParallelExportSession.invoke(Float.valueOf(f));
        AppMethodBeat.o(233543);
        return;
      }
      AppMethodBeat.o(233543);
      return;
      localObject = new StringBuilder("export completed: ").append(f).append(", cost:");
      long l = this.Uj;
      com.tencent.mm.videocomposition.d.b.i("VideoComposition", SystemClock.elapsedRealtime() - l, new Object[0]);
      localObject = this.vSY;
      if (localObject != null)
      {
        localBoolean = Boolean.TRUE;
        paramAssetParallelExportSession = paramAssetParallelExportSession.getIndicatorInfo();
        s.r(paramAssetParallelExportSession, "assetExportSession.indicatorInfo");
        ((q)localObject).invoke(localBoolean, Integer.valueOf(i), paramAssetParallelExportSession);
        AppMethodBeat.o(233543);
        return;
      }
      AppMethodBeat.o(233543);
      return;
      com.tencent.mm.videocomposition.d.b.i("VideoComposition", "export canceled: ".concat(String.valueOf(f)), new Object[0]);
      if (this.agEb.Eox != null)
      {
        paramAssetParallelExportSession = this.agEb.Eox;
        if (paramAssetParallelExportSession != null)
        {
          paramAssetParallelExportSession.invoke();
          AppMethodBeat.o(233543);
          return;
        }
        AppMethodBeat.o(233543);
        return;
      }
      localObject = this.vSY;
      if (localObject != null)
      {
        localBoolean = Boolean.FALSE;
        paramAssetParallelExportSession = paramAssetParallelExportSession.getIndicatorInfo();
        s.r(paramAssetParallelExportSession, "assetExportSession.indicatorInfo");
        ((q)localObject).invoke(localBoolean, Integer.valueOf(i), paramAssetParallelExportSession);
        AppMethodBeat.o(233543);
        return;
      }
      AppMethodBeat.o(233543);
      return;
      com.tencent.mm.videocomposition.d.b.i("VideoComposition", "export failed: status:" + localObject + ", progress:" + f, new Object[0]);
      localObject = this.vSY;
      if (localObject != null)
      {
        localBoolean = Boolean.FALSE;
        paramAssetParallelExportSession = paramAssetParallelExportSession.getIndicatorInfo();
        s.r(paramAssetParallelExportSession, "assetExportSession.indicatorInfo");
        ((q)localObject).invoke(localBoolean, Integer.valueOf(i), paramAssetParallelExportSession);
        AppMethodBeat.o(233543);
        return;
      }
      AppMethodBeat.o(233543);
      return;
      AppMethodBeat.o(233543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.j
 * JD-Core Version:    0.7.0.1
 */