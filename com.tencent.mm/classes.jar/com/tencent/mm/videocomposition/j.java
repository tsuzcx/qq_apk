package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.b.f;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.af;
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
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/VideoComposition;", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "(Ljava/util/List;)V", "origin", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "()V", "assetHeight", "", "assetWidth", "audioProcessorFactory", "Lcom/tencent/mm/videocomposition/audio/IAudioProcessorFactory;", "cancelCallback", "Lkotlin/Function0;", "", "getCancelCallback", "()Lkotlin/jvm/functions/Function0;", "setCancelCallback", "(Lkotlin/jvm/functions/Function0;)V", "checkPerformance", "", "effect", "Lcom/tencent/mm/videocomposition/render/VLogDirectorMultiVideoCompositionEffect;", "enableOriginAudio", "exportSession", "Lcom/tencent/tav/core/AssetExportSession;", "id", "", "getId", "()J", "setId", "(J)V", "isAudioTracksMerge", "isRevert", "isVideoTracksMerge", "outputCrop", "Landroid/graphics/Rect;", "playEnd", "getPlayEnd", "playFps", "", "playStart", "getPlayStart", "renderCallback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallbackList;", "setEnd", "getSetEnd", "setSetEnd", "setStart", "getSetStart", "setSetStart", "sourceEnd", "getSourceEnd", "sourceStart", "getSourceStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "viewRect", "addRenderProcessCallback", "callback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "addTrack", "track", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildTrackChannel", "Lcom/tencent/tavkit/composition/TAVClip;", "cancelExport", "createComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "enableVideoSound", "enable", "export", "path", "", "config", "Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "Lkotlin/Function2;", "progressCallback", "Lkotlin/Function1;", "exportImpl", "videoEncoder", "Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;", "exportWithCustomEncoder", "getAssetSize", "Landroid/util/Size;", "getDisplayScreenRect", "getDurationMs", "getExportPerformanceReport", "Lcom/tencent/tav/report/ExportReportSession;", "getOutputSize", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getRenderPerformanceReport", "Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "getRenderSize", "getSourceDuration", "getThumbBitmap", "widthLimit", "Landroid/graphics/Bitmap;", "getTrackByTimeMs", "timeMs", "getTrackList", "isEnableOriginSound", "removeRenderProcessCallback", "removeTrack", "setAssetSize", "width", "height", "setAudioProcessorFactory", "setAudioTracksMerge", "audioTracksMerge", "setCheckPerformance", "check", "setDisplayScreenRect", "rect", "setOutputCrop", "setPlayFps", "fps", "setPlayRange", "start", "end", "setRenderSize", "setRevert", "revert", "setTrackList", "setVLogEffectMgr", "setVideoTracksMerge", "videoTracksMerge", "updateTrack", "index", "Companion", "VideoOutputConfig", "video_composition_release"})
public class j
{
  public static final a YIq;
  public final ArrayList<b> MQY;
  public boolean NmU;
  public EffectManager Noe;
  public final long YId;
  public long YIe;
  public long YIf;
  public int YIg;
  public int YIh;
  public float YIi;
  public final Rect YIj;
  private f YIk;
  private com.tencent.mm.videocomposition.b.g YIl;
  public com.tencent.mm.videocomposition.a.b YIm;
  public boolean YIn;
  private boolean YIo;
  kotlin.g.a.a<x> YIp;
  public AssetExportSession exportSession;
  private boolean isAudioTracksMerge;
  private boolean isVideoTracksMerge;
  private Rect viewRect;
  
  static
  {
    AppMethodBeat.i(248050);
    YIq = new a((byte)0);
    d locald = d.YHZ;
    d.eON();
    AppMethodBeat.o(248050);
  }
  
  public j()
  {
    AppMethodBeat.i(248048);
    this.YIe = -1L;
    this.YIf = -1L;
    this.viewRect = new Rect();
    this.YIi = 30.0F;
    this.YIj = new Rect();
    this.YIk = new f();
    this.MQY = new ArrayList();
    this.isVideoTracksMerge = true;
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "create VLogComposition", new Object[0]);
    AppMethodBeat.o(248048);
  }
  
  public j(List<b> paramList)
  {
    this();
    AppMethodBeat.i(248049);
    this.MQY.addAll((Collection)paramList);
    AppMethodBeat.o(248049);
  }
  
  private final AssetExportSession a(String paramString, b paramb, AssetWriterVideoEncoder paramAssetWriterVideoEncoder, m<? super Boolean, ? super Integer, x> paramm, final kotlin.g.a.b<? super Float, x> paramb1)
  {
    AppMethodBeat.i(248041);
    TAVSource localTAVSource = buildSource();
    ExportConfig localExportConfig = new ExportConfig(paramb.YIr.getWidth(), paramb.YIr.getHeight());
    localExportConfig.setOutputFilePath(paramString);
    localExportConfig.setNeedCorrectSizeByCodecCapabilities(paramb.correctSizeByCodecCapabilities);
    localExportConfig.setVideoBitRate(paramb.videoBitrate);
    localExportConfig.setVideoFrameRate(paramb.fps);
    localExportConfig.setVideoIFrameInterval(paramb.kSh);
    localExportConfig.setHighProfile(paramb.YIs);
    localExportConfig.setAudioBitRate(paramb.audioBitrate);
    localExportConfig.setAudioSampleRateHz(paramb.audioSampleRate);
    localExportConfig.setAudioChannelCount(paramb.audioChannelCount);
    localExportConfig.setAudioEncodeNeedCodecSpecificData(paramb.YIt);
    localExportConfig.setEncodeHevc(paramb.mfh);
    if (Build.VERSION.SDK_INT >= 24) {
      localExportConfig.setColorSpace(paramb.colorRange, paramb.colorStandard, paramb.colorTransfer);
    }
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export: config: " + localExportConfig.getOutputWidth() + ", " + localExportConfig.getOutputHeight() + "; video: " + localExportConfig.getVideoBitRate() + ", " + localExportConfig.getVideoFrameRate() + ", " + paramb.kSh + ", " + paramb.YIs + "; audio: " + paramb.audioBitrate + ", " + paramb.audioSampleRate + ", " + paramb.audioChannelCount + ", aacEncodeNeedCodecSpecificData:" + paramb.YIt + ", outputHevc:" + paramb.mfh + ", correctSizeByCodecCapabilities:" + paramb.correctSizeByCodecCapabilities, new Object[0]);
    paramb = new AssetExportSession(localTAVSource.getAsset(), localExportConfig);
    paramb.setOutputFilePath(paramString);
    paramb.setOutputFileType("mp4");
    paramb.setVideoComposition(localTAVSource.getVideoComposition());
    paramb.setAudioMix(localTAVSource.getAudioMix());
    paramb.setTimeRange(igH());
    paramb.setRevertMode(this.YIn);
    paramb.setVideoEncoder(paramAssetWriterVideoEncoder);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export duration:" + (igG() - this.YId) + " playRange:" + igH(), new Object[0]);
    paramb.exportAsynchronouslyWithCompletionHandler((AssetExportSession.ExportCallbackHandler)new c(this, paramb1, SystemClock.elapsedRealtime(), paramm));
    this.exportSession = paramb;
    AppMethodBeat.o(248041);
    return paramb;
  }
  
  private final TAVComposition kU(List<b> paramList)
  {
    AppMethodBeat.i(248032);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "createComposition: track size " + paramList.size(), new Object[0]);
    if (paramList.isEmpty())
    {
      paramList = new TAVComposition();
      AppMethodBeat.o(248032);
      return paramList;
    }
    TAVComposition localTAVComposition = new TAVComposition();
    Object localObject1 = (Iterable)paramList;
    Object localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", "add track type:" + localb.type + " startTime:" + localb.startTimeMs + ", endTime:" + localb.endTimeMs + ", trackStartTime:" + localb.MQV + ", trackEndTime:" + localb.MQW, new Object[0]);
      boolean bool = this.NmU;
      Object localObject3;
      if (localb.type != 0)
      {
        localObject1 = new TAVClip(e.YIc.e(localb));
        ((TAVClip)localObject1).setStartTime(new CMTime(localb.startTimeMs, 1000));
        ((TAVClip)localObject1).setDuration(new CMTime(localb.getDurationMs(), 1000));
        localObject3 = ((TAVClip)localObject1).getResource();
        p.j(localObject3, "clip.resource");
        ((TAVResource)localObject3).setSourceTimeRange(new CMTimeRange(new CMTime(localb.MQV, 1000), new CMTime(localb.MQW - localb.MQV, 1000)));
        if ((localb.type == 2) && (!bool))
        {
          localObject3 = ((TAVClip)localObject1).getAudioConfiguration();
          p.j(localObject3, "clip.audioConfiguration");
          ((TAVAudioConfiguration)localObject3).setVolume(0.0F);
          label380:
          localb.YHX = ((TAVClip)localObject1);
          com.tencent.mm.videocomposition.c.b.i("CompositionTrack", localb.id + " buildClip buildVideoClip, path:" + localb.path + ", video startEnd:[" + localb.MQV + ", " + localb.MQW + "], material startEnd:[" + localb.startTimeMs + ", " + localb.endTimeMs + "], volume: " + localb.volume, new Object[0]);
          label499:
          localObject3 = this.YIm;
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.videocomposition.a.b)localObject3).h(localb);
            ((TAVClip)localObject1).getAudioConfiguration().addAudioProcessorNode((TAVAudioProcessorNode)localObject3);
          }
          ((TAVClip)localObject1).putExtraTrackInfo("key_extra_track", localb);
          if (localb.startTimeMs <= 0L) {
            break label728;
          }
          localObject3 = new TAVClip((TAVResource)new TAVEmptyResource(new CMTime(localb.startTimeMs, 1000)));
          ((TAVClip)localObject3).setStartTime(CMTime.CMTimeZero);
          ((TAVClip)localObject3).setDuration(new CMTime(localb.startTimeMs, 1000));
          com.tencent.mm.videocomposition.c.b.i("VideoComposition", "add front empty clip duration:" + localb.startTimeMs, new Object[0]);
        }
      }
      label728:
      for (localObject1 = kotlin.a.j.listOf(new TAVClip[] { localObject3, localObject1 });; localObject1 = kotlin.a.j.listOf(localObject1))
      {
        ((Collection)localObject2).add(localObject1);
        break;
        localObject3 = ((TAVClip)localObject1).getAudioConfiguration();
        p.j(localObject3, "clip.audioConfiguration");
        ((TAVAudioConfiguration)localObject3).setVolume(localb.volume);
        break label380;
        localObject1 = new TAVClip((TAVResource)new TAVEmptyResource(CMTime.CMTimeZero));
        break label499;
      }
    }
    localObject1 = ((Iterable)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (List)localObject2;
      if (((b)paramList.get(i)).guq()) {
        localTAVComposition.addVideoChannel((List)localObject2);
      }
      if ((((b)paramList.get(i)).type == 2) || (((b)paramList.get(i)).type == 3) || (((b)paramList.get(i)).type == 1)) {
        localTAVComposition.addAudioChannel((List)localObject2);
      }
      i += 1;
    }
    paramList = new StringBuilder("finish build composition, duration:");
    localObject1 = localTAVComposition.getDuration();
    p.j(localObject1, "composition.duration");
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", ((CMTime)localObject1).getTimeUs() / 1000L, new Object[0]);
    AppMethodBeat.o(248032);
    return localTAVComposition;
  }
  
  public final void Ap(boolean paramBoolean)
  {
    AppMethodBeat.i(248038);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "enableVideoSound:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.NmU = paramBoolean;
    AppMethodBeat.o(248038);
  }
  
  public final void D(Rect paramRect)
  {
    AppMethodBeat.i(248036);
    p.k(paramRect, "rect");
    this.YIj.set(paramRect);
    AppMethodBeat.o(248036);
  }
  
  public final AssetExportSession a(String paramString, b paramb, m<? super Boolean, ? super Integer, x> paramm, kotlin.g.a.b<? super Float, x> paramb1)
  {
    AppMethodBeat.i(248042);
    p.k(paramString, "path");
    p.k(paramb, "config");
    paramString = a(paramString, paramb, null, paramm, paramb1);
    AppMethodBeat.o(248042);
    return paramString;
  }
  
  public final void a(com.tencent.mm.videocomposition.b.e parame)
  {
    AppMethodBeat.i(248039);
    if (parame != null) {
      this.YIk.b(parame);
    }
    AppMethodBeat.o(248039);
  }
  
  public final void aG(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(248029);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']', new Object[0]);
    this.YIe = paramLong1;
    this.YIf = paramLong2;
    AppMethodBeat.o(248029);
  }
  
  public final AssetExportSession b(String paramString, b paramb, AssetWriterVideoEncoder paramAssetWriterVideoEncoder, m<? super Boolean, ? super Integer, x> paramm, kotlin.g.a.b<? super Float, x> paramb1)
  {
    AppMethodBeat.i(248045);
    p.k(paramString, "path");
    p.k(paramb, "config");
    paramString = a(paramString, paramb, paramAssetWriterVideoEncoder, paramm, paramb1);
    AppMethodBeat.o(248045);
    return paramString;
  }
  
  public final TAVSource buildSource()
  {
    AppMethodBeat.i(248040);
    Object localObject2 = kU((List)this.MQY);
    com.tencent.mm.videocomposition.b.g localg = new com.tencent.mm.videocomposition.b.g();
    this.YIl = localg;
    long l = System.currentTimeMillis();
    Object localObject1 = this.Noe;
    if (localObject1 != null) {
      ((EffectManager)localObject1).b(com.tencent.mm.xeffect.effect.j.YZB);
    }
    int j = this.MQY.size();
    int i = 1;
    if (i < j)
    {
      localObject1 = this.MQY.get(i - 1);
      p.j(localObject1, "trackList[i - 1]");
      b localb1 = (b)localObject1;
      localObject1 = this.MQY.get(i);
      p.j(localObject1, "trackList[i]");
      b localb2 = (b)localObject1;
      g localg1 = localb2.MQX;
      if (localg1.isValid()) {
        if (localg1.NnT == null)
        {
          localObject1 = this.Noe;
          if (localObject1 == null) {
            break label236;
          }
        }
      }
      label236:
      for (localObject1 = ((EffectManager)localObject1).a(com.tencent.mm.xeffect.effect.j.YZB, localg1.path);; localObject1 = null)
      {
        localg1.NnT = ((af)localObject1);
        localObject1 = localg1.NnT;
        if (localObject1 != null) {
          ((af)localObject1).aZ(localb2.startTimeMs, localb1.endTimeMs);
        }
        localObject1 = this.Noe;
        if (localObject1 != null) {
          ((EffectManager)localObject1).b(localg1.NnT);
        }
        i += 1;
        break;
      }
    }
    new StringBuilder("buildSource: update transition cost ").append(System.currentTimeMillis() - l);
    localg.np(this.YIg, this.YIh);
    localg.c(this.Noe);
    localg.D(this.YIj);
    localg.YIo = this.YIo;
    localg.YJJ = ((com.tencent.mm.videocomposition.b.e)this.YIk);
    ((TAVComposition)localObject2).setVideoMixEffect((TAVVideoMixEffect)new com.tencent.mm.videocomposition.b.b((com.tencent.mm.videocomposition.b.a)localg));
    localObject1 = new TAVCompositionBuilder((TAVComposition)localObject2);
    ((TAVCompositionBuilder)localObject1).setReloadChannels(false);
    ((TAVCompositionBuilder)localObject1).setVideoTracksMerge(this.isVideoTracksMerge);
    ((TAVCompositionBuilder)localObject1).setAudioTracksMerge(this.isAudioTracksMerge);
    new StringBuilder("buildSource, videoTracksMerge:").append(this.isVideoTracksMerge).append(", audioTracksMerge:").append(this.isAudioTracksMerge);
    localObject1 = ((TAVCompositionBuilder)localObject1).buildSource();
    p.j(localObject1, "source");
    localObject2 = ((TAVSource)localObject1).getVideoComposition();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.tav.core.composition.MutableVideoComposition");
      AppMethodBeat.o(248040);
      throw ((Throwable)localObject1);
    }
    ((MutableVideoComposition)localObject2).setFrameDuration(new CMTime(1000L, (int)(this.YIi * 1000.0F)));
    AppMethodBeat.o(248040);
    return localObject1;
  }
  
  public final void g(b paramb)
  {
    AppMethodBeat.i(248025);
    p.k(paramb, "track");
    this.MQY.add(paramb);
    AppMethodBeat.o(248025);
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(248027);
    long l1 = gtw();
    long l2 = getPlayStart();
    AppMethodBeat.o(248027);
    return l1 - l2;
  }
  
  public final long getPlayStart()
  {
    if (this.YIe >= 0L) {
      return this.YIe;
    }
    return this.YId;
  }
  
  public final long getSourceDuration()
  {
    AppMethodBeat.i(248028);
    long l1 = igG();
    long l2 = this.YId;
    AppMethodBeat.o(248028);
    return l1 - l2;
  }
  
  public final long gtw()
  {
    AppMethodBeat.i(248023);
    if (this.YIf >= 0L)
    {
      l = this.YIf;
      AppMethodBeat.o(248023);
      return l;
    }
    long l = igG();
    AppMethodBeat.o(248023);
    return l;
  }
  
  public final long igG()
  {
    AppMethodBeat.i(248019);
    Object localObject2 = (Iterable)this.MQY;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((b)localObject3).guq()) {
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
      AppMethodBeat.o(248019);
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
        AppMethodBeat.o(248019);
        return 0L;
      }
      break label164;
    }
  }
  
  public final CMTimeRange igH()
  {
    AppMethodBeat.i(248030);
    CMTimeRange localCMTimeRange = new CMTimeRange(new CMTime(getPlayStart(), 1000), new CMTime(gtw() - getPlayStart(), 1000));
    AppMethodBeat.o(248030);
    return localCMTimeRange;
  }
  
  public final Size igI()
  {
    AppMethodBeat.i(248035);
    Size localSize = new Size(this.YIg, this.YIh);
    AppMethodBeat.o(248035);
    return localSize;
  }
  
  public final Size igJ()
  {
    AppMethodBeat.i(248037);
    if (this.YIj.isEmpty())
    {
      localSize = igI();
      AppMethodBeat.o(248037);
      return localSize;
    }
    Size localSize = new Size(this.YIj.width(), this.YIj.height());
    AppMethodBeat.o(248037);
    return localSize;
  }
  
  public final com.tencent.mm.videocomposition.b.d igK()
  {
    com.tencent.mm.videocomposition.b.g localg = this.YIl;
    if (localg != null) {
      return localg.YJL;
    }
    return null;
  }
  
  public final void nn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248033);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setAssetSize: " + paramInt1 + ", " + paramInt2, new Object[0]);
    this.YIg = paramInt1;
    this.YIh = paramInt2;
    com.tencent.mm.videocomposition.b.g localg = this.YIl;
    if (localg != null) {
      localg.np(paramInt1, paramInt2);
    }
    this.viewRect.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(248033);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/VideoComposition$Companion;", "", "()V", "EXTRA_TRACK", "", "IMAGE_SIZE_LIMIT", "", "TAG", "video_composition_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "", "targetSize", "Landroid/util/Size;", "videoBitrate", "", "fps", "iFrameInterval", "audioBitrate", "audioSampleRate", "audioChannelCount", "highProfileEnable", "", "aacEncodeNeedCodecSpecificData", "outputHevc", "(Landroid/util/Size;IIIIIIZZZ)V", "getAacEncodeNeedCodecSpecificData", "()Z", "getAudioBitrate", "()I", "getAudioChannelCount", "getAudioSampleRate", "colorRange", "getColorRange", "setColorRange", "(I)V", "colorStandard", "getColorStandard", "setColorStandard", "colorTransfer", "getColorTransfer", "setColorTransfer", "correctSizeByCodecCapabilities", "getCorrectSizeByCodecCapabilities", "setCorrectSizeByCodecCapabilities", "(Z)V", "getFps", "getHighProfileEnable", "getIFrameInterval", "getOutputHevc", "getTargetSize", "()Landroid/util/Size;", "getVideoBitrate", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "video_composition_release"})
  public static final class b
  {
    final Size YIr;
    final boolean YIs;
    final boolean YIt;
    public final int audioBitrate;
    public final int audioChannelCount;
    public final int audioSampleRate;
    public int colorRange;
    public int colorStandard;
    public int colorTransfer;
    public boolean correctSizeByCodecCapabilities;
    public final int fps;
    final int kSh;
    final boolean mfh;
    final int videoBitrate;
    
    public b(Size paramSize, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(247991);
      this.YIr = paramSize;
      this.videoBitrate = paramInt1;
      this.fps = paramInt2;
      this.kSh = paramInt3;
      this.audioBitrate = paramInt4;
      this.audioSampleRate = paramInt5;
      this.audioChannelCount = paramInt6;
      this.YIs = paramBoolean1;
      this.YIt = false;
      this.mfh = paramBoolean2;
      this.correctSizeByCodecCapabilities = true;
      AppMethodBeat.o(247991);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(247997);
      if (this != paramObject)
      {
        if (!(paramObject instanceof b)) {
          break label241;
        }
        paramObject = (b)paramObject;
        if (!p.h(this.YIr, paramObject.YIr)) {
          break label241;
        }
        if (this.videoBitrate != paramObject.videoBitrate) {
          break label196;
        }
        i = 1;
        if (i == 0) {
          break label241;
        }
        if (this.fps != paramObject.fps) {
          break label201;
        }
        i = 1;
        label66:
        if (i == 0) {
          break label241;
        }
        if (this.kSh != paramObject.kSh) {
          break label206;
        }
        i = 1;
        label83:
        if (i == 0) {
          break label241;
        }
        if (this.audioBitrate != paramObject.audioBitrate) {
          break label211;
        }
        i = 1;
        label100:
        if (i == 0) {
          break label241;
        }
        if (this.audioSampleRate != paramObject.audioSampleRate) {
          break label216;
        }
        i = 1;
        label117:
        if (i == 0) {
          break label241;
        }
        if (this.audioChannelCount != paramObject.audioChannelCount) {
          break label221;
        }
        i = 1;
        label134:
        if (i == 0) {
          break label241;
        }
        if (this.YIs != paramObject.YIs) {
          break label226;
        }
        i = 1;
        label151:
        if (i == 0) {
          break label241;
        }
        if (this.YIt != paramObject.YIt) {
          break label231;
        }
        i = 1;
        label168:
        if (i == 0) {
          break label241;
        }
        if (this.mfh != paramObject.mfh) {
          break label236;
        }
      }
      label196:
      label201:
      label206:
      label211:
      label216:
      label221:
      label226:
      label231:
      label236:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label241;
        }
        AppMethodBeat.o(247997);
        return true;
        i = 0;
        break;
        i = 0;
        break label66;
        i = 0;
        break label83;
        i = 0;
        break label100;
        i = 0;
        break label117;
        i = 0;
        break label134;
        i = 0;
        break label151;
        i = 0;
        break label168;
      }
      label241:
      AppMethodBeat.o(247997);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(247992);
      String str = "VideoOutputConfig(targetSize=" + this.YIr + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", iFrameInterval=" + this.kSh + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", highProfileEnable=" + this.YIs + ", aacEncodeNeedCodecSpecificData=" + this.YIt + ", outputHevc=" + this.mfh + ")";
      AppMethodBeat.o(247992);
      return str;
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "assetExportSession", "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "handlerCallback"})
  static final class c
    implements AssetExportSession.ExportCallbackHandler
  {
    c(j paramj, kotlin.g.a.b paramb, long paramLong, m paramm) {}
    
    public final void handlerCallback(AssetExportSession paramAssetExportSession)
    {
      AppMethodBeat.i(248002);
      p.j(paramAssetExportSession, "assetExportSession");
      AssetExportSession.AssetExportSessionStatus localAssetExportSessionStatus = paramAssetExportSession.getStatus();
      int i = paramAssetExportSession.getErrCode();
      float f = paramAssetExportSession.getProgress();
      if (localAssetExportSessionStatus == null) {}
      for (;;)
      {
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export failed other status:" + localAssetExportSessionStatus + ", progress:" + f, new Object[0]);
        paramAssetExportSession = this.qBo;
        if (paramAssetExportSession == null) {
          break;
        }
        paramAssetExportSession.invoke(Boolean.FALSE, Integer.valueOf(i));
        AppMethodBeat.o(248002);
        return;
        switch (k.$EnumSwitchMapping$0[localAssetExportSessionStatus.ordinal()])
        {
        }
      }
      paramAssetExportSession = paramb1;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.invoke(Float.valueOf(f));
        AppMethodBeat.o(248002);
        return;
      }
      AppMethodBeat.o(248002);
      return;
      paramAssetExportSession = new StringBuilder("export completed: ").append(f).append(", cost:");
      long l = this.uyk;
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", SystemClock.elapsedRealtime() - l, new Object[0]);
      paramAssetExportSession = this.qBo;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.invoke(Boolean.TRUE, Integer.valueOf(i));
        AppMethodBeat.o(248002);
        return;
      }
      AppMethodBeat.o(248002);
      return;
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export canceled: ".concat(String.valueOf(f)), new Object[0]);
      if (this.YIu.YIp != null)
      {
        paramAssetExportSession = this.YIu.YIp;
        if (paramAssetExportSession != null)
        {
          paramAssetExportSession.invoke();
          AppMethodBeat.o(248002);
          return;
        }
        AppMethodBeat.o(248002);
        return;
      }
      paramAssetExportSession = this.qBo;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.invoke(Boolean.FALSE, Integer.valueOf(i));
        AppMethodBeat.o(248002);
        return;
      }
      AppMethodBeat.o(248002);
      return;
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export failed: status:" + localAssetExportSessionStatus + ", progress:" + f, new Object[0]);
      paramAssetExportSession = this.qBo;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.invoke(Boolean.FALSE, Integer.valueOf(i));
        AppMethodBeat.o(248002);
        return;
      }
      AppMethodBeat.o(248002);
      return;
      AppMethodBeat.o(248002);
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  public static final class d
    extends q
    implements m<Long, Bitmap, x>
  {
    public d(kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.j
 * JD-Core Version:    0.7.0.1
 */