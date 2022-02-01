package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.player.render.h;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import d.d.d<-Lcom.tencent.mm.plugin.vlog.model.r;>;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.ay;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "", "origin", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "asyncCreate", "", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/VlogResp;Z)V", "abaParamList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition$ABAResult;", "Lkotlin/collections/ArrayList;", "composition", "Lcom/tencent/tavkit/composition/TAVComposition;", "cropOriginSize", "Landroid/graphics/Point;", "cropRect", "Landroid/graphics/Rect;", "effect", "Lcom/tencent/mm/plugin/vlog/player/render/VLogCompositionMixEffect;", "enableMusic", "enableOriginAudio", "musicAudioChannels", "Lcom/tencent/tavkit/composition/TAVClip;", "musicPath", "", "originAudioChannels", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "playRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "addMusic", "", "asyncCreateComposition", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildTrackChannel", "track", "createComposition", "enableVideoSound", "enable", "export", "config", "callback", "Lkotlin/Function1;", "progressCallback", "", "Lkotlin/ParameterName;", "name", "progress", "getABAResult", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "", "targetHeight", "getDurationMs", "", "getEffect", "Lcom/tencent/mm/plugin/vlog/player/render/BaseMultiVideoCompositionEffect;", "getFrameTexture", "getFrameTextureHeight", "getFrameTextureWidth", "getMusicPath", "getOutputConfig", "getPlayRange", "getPlayRangeStart", "getSize", "Landroid/util/Size;", "getSourceDuration", "getThumbBitmap", "widthLimit", "Landroid/graphics/Bitmap;", "getTrackList", "initCompositionData", "isEnableMusic", "isEnableOriginSound", "renderContext", "Landroid/opengl/EGLContext;", "reportStartExport", "setBlendBitmapProvider", "blendBitmapProvider", "setFilter", "path", "weight", "setFrameRenderCallback", "Lkotlin/Function0;", "setPlayRange", "start", "end", "setRenderCrop", "width", "height", "rect", "flip", "setRenderSize", "sortVideoBitrate", "updateAudioChannels", "ABAResult", "Companion", "plugin-vlog_release"})
public final class r
{
  public static final b Aoa;
  private yp AmP;
  public TAVComposition AnR;
  public h AnS;
  public ArrayList<u> AnT;
  private Point AnU;
  private List<? extends List<? extends TAVClip>> AnV;
  private List<? extends List<? extends TAVClip>> AnW;
  boolean AnX;
  private ArrayList<a> AnY;
  private final dqm AnZ;
  String gUk;
  private final Rect gUl;
  public CMTimeRange playRange;
  private boolean wpZ;
  
  static
  {
    AppMethodBeat.i(207601);
    Aoa = new b((byte)0);
    o localo = o.AnM;
    o.cZj();
    AppMethodBeat.o(207601);
  }
  
  public r(r paramr)
  {
    this((List)paramr.AnT, paramr.AnZ, 4);
    AppMethodBeat.i(207600);
    CMTimeRange localCMTimeRange = paramr.playRange;
    if (localCMTimeRange == null) {
      k.aVY("playRange");
    }
    this.playRange = localCMTimeRange;
    a(paramr.AnU.x, paramr.AnU.y, this.gUl, false);
    AppMethodBeat.o(207600);
  }
  
  public r(List<u> paramList, dqm paramdqm, boolean paramBoolean)
  {
    AppMethodBeat.i(207598);
    this.AnZ = paramdqm;
    this.AnR = new TAVComposition();
    this.AnT = new ArrayList();
    this.AnU = new Point(0, 0);
    this.gUl = new Rect();
    this.AmP = new yp();
    this.AnV = ((List)new ArrayList());
    this.AnW = ((List)new ArrayList());
    this.gUk = "";
    this.AnY = new ArrayList();
    ac.m("MicroMsg.VLogComposition", "create VLogComposition, asyncCreate:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.AnT.clear();
    this.AnT.addAll((Collection)paramList);
    if (!paramBoolean)
    {
      this.AnR = gq((List)this.AnT);
      efy();
    }
    AppMethodBeat.o(207598);
  }
  
  private void a(int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(207586);
    k.h(paramRect, "rect");
    this.AnU = new Point(paramInt1, paramInt2);
    ac.i("MicroMsg.VLogComposition", "setCompositionDisplayArea cropRect composition renderSize:".concat(String.valueOf(new CGSize(paramRect.right - paramRect.left, paramRect.bottom - paramRect.top))));
    if ((this.AnR.getVideoMixEffect() instanceof h))
    {
      if (paramBoolean)
      {
        Rect localRect = new Rect(paramRect);
        localRect.top = (paramInt2 - paramRect.bottom);
        localRect.bottom = (paramInt2 - paramRect.top);
        this.gUl.set(localRect);
        AppMethodBeat.o(207586);
        return;
      }
      this.gUl.set(paramRect);
    }
    AppMethodBeat.o(207586);
  }
  
  private static List<TAVClip> b(u paramu)
  {
    AppMethodBeat.i(207585);
    ac.i("MicroMsg.VLogComposition", "add track type:" + paramu.type + " startTime:" + paramu.bvf + ", endTime:" + paramu.gOz + ", trackStartTime:" + paramu.Aox + ", trackEndTime:" + paramu.Aoy);
    TAVClip localTAVClip1 = paramu.efG();
    localTAVClip1.putExtraTrackInfo("key_extra_track", paramu);
    if (paramu.bvf > 0L)
    {
      TAVClip localTAVClip2 = new TAVClip((TAVResource)new TAVEmptyResource(CMTime.fromMs(paramu.bvf)));
      localTAVClip2.setStartTime(CMTime.fromMs(0L));
      localTAVClip2.setDuration(CMTime.fromMs(paramu.bvf));
      ac.i("MicroMsg.VLogComposition", "add front empty clip duration:" + paramu.bvf);
      paramu = d.a.j.listOf(new TAVClip[] { localTAVClip2, localTAVClip1 });
      AppMethodBeat.o(207585);
      return paramu;
    }
    paramu = d.a.j.listOf(localTAVClip1);
    AppMethodBeat.o(207585);
    return paramu;
  }
  
  private final void efC()
  {
    AppMethodBeat.i(207591);
    ac.i("MicroMsg.VLogComposition", hashCode() + " updateAudioChannels, enableMusic:" + this.wpZ + ", enableOriginAudio:" + this.AnX + ", musicAudioChannels:" + this.AnW.size() + ", originAudioChannels:" + this.AnV.size());
    List localList1 = (List)new ArrayList();
    Iterator localIterator;
    List localList2;
    if (this.wpZ)
    {
      localIterator = ((Iterable)this.AnW).iterator();
      while (localIterator.hasNext())
      {
        localList2 = (List)localIterator.next();
        ((ArrayList)localList1).add(localList2);
      }
    }
    if (this.AnX)
    {
      localIterator = ((Iterable)this.AnV).iterator();
      while (localIterator.hasNext())
      {
        localList2 = (List)localIterator.next();
        ((ArrayList)localList1).add(localList2);
      }
    }
    this.AnR.setAudioChannels(localList1);
    AppMethodBeat.o(207591);
  }
  
  private final void efE()
  {
    AppMethodBeat.i(207596);
    Object localObject2 = (Iterable)this.AnT;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label87:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((u)localObject3).type == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label87;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((u)((Iterator)localObject2).next()).path);
    }
    localObject1 = (List)localObject1;
    localObject2 = com.tencent.mm.plugin.vlog.model.report.a.Apq;
    int i = this.AnT.size();
    if (((List)localObject1).size() < this.AnT.size()) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.vlog.model.report.a.aF(i, bool);
      localObject2 = com.tencent.mm.plugin.vlog.model.report.a.Apq;
      com.tencent.mm.plugin.vlog.model.report.a.gt((List)localObject1);
      AppMethodBeat.o(207596);
      return;
    }
  }
  
  private final void efy()
  {
    AppMethodBeat.i(207578);
    this.playRange = new CMTimeRange(CMTime.CMTimeZero, this.AnR.getDuration());
    this.AnR.setVideoMixEffect((TAVVideoMixEffect)new h(this.AnZ));
    Object localObject = this.AnR.getVideoMixEffect();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.player.render.VLogCompositionMixEffect");
      AppMethodBeat.o(207578);
      throw ((Throwable)localObject);
    }
    this.AnS = ((h)localObject);
    AppMethodBeat.o(207578);
  }
  
  private final TAVComposition gq(List<u> paramList)
  {
    AppMethodBeat.i(207584);
    ac.i("MicroMsg.VLogComposition", "createComposition: track size " + paramList.size());
    if (paramList.isEmpty())
    {
      paramList = new TAVComposition();
      AppMethodBeat.o(207584);
      return paramList;
    }
    TAVComposition localTAVComposition = new TAVComposition();
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(b((u)((Iterator)localObject2).next()));
    }
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.fOc();
      }
      localObject2 = (List)localObject2;
      localTAVComposition.addVideoChannel((List)localObject2);
      if (((u)paramList.get(i)).type == 2)
      {
        List localList = this.AnV;
        if (localList == null)
        {
          paramList = new v("null cannot be cast to non-null type java.util.ArrayList<kotlin.collections.List<com.tencent.tavkit.composition.TAVClip>>");
          AppMethodBeat.o(207584);
          throw paramList;
        }
        ((ArrayList)localList).add(localObject2);
      }
      i += 1;
    }
    paramList = new StringBuilder("finish build composition, duration:");
    localObject1 = localTAVComposition.getDuration();
    k.g(localObject1, "composition.duration");
    ac.i("MicroMsg.VLogComposition", ((CMTime)localObject1).getTimeUs() / 1000L);
    AppMethodBeat.o(207584);
    return localTAVComposition;
  }
  
  public final void D(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(207593);
    k.h(paramb, "blendBitmapProvider");
    h localh = this.AnS;
    if (localh == null) {
      k.aVY("effect");
    }
    localh.D(paramb);
    AppMethodBeat.o(207593);
  }
  
  public final boolean a(final yp paramyp, final d.g.a.b<? super Boolean, y> paramb, final d.g.a.b<? super Float, y> paramb1)
  {
    AppMethodBeat.i(207597);
    k.h(paramyp, "config");
    efE();
    Object localObject2 = new TAVCompositionBuilder(this.AnR).buildSource();
    paramyp.gNU = com.tencent.mm.plugin.mmsight.d.IJ(paramyp.gNU);
    paramyp.gNV = com.tencent.mm.plugin.mmsight.d.IJ(paramyp.gNV);
    Object localObject1 = new EncoderWriter.OutputConfig();
    ((EncoderWriter.OutputConfig)localObject1).VIDEO_TARGET_WIDTH = paramyp.gNU;
    ((EncoderWriter.OutputConfig)localObject1).VIDEO_TARGET_HEIGHT = paramyp.gNV;
    ((EncoderWriter.OutputConfig)localObject1).VIDEO_BIT_RATE = paramyp.videoBitrate;
    ((EncoderWriter.OutputConfig)localObject1).VIDEO_FRAME_RATE = paramyp.fps;
    ((EncoderWriter.OutputConfig)localObject1).VIDEO_IFRAME_INTERVAL = paramyp.hCy;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbT, 0) == 1) {}
    String str;
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        ((EncoderWriter.OutputConfig)localObject1).VIDEO_QUALITY = true;
      }
      ((EncoderWriter.OutputConfig)localObject1).AUDIO_BIT_RATE = paramyp.audioBitrate;
      ((EncoderWriter.OutputConfig)localObject1).AUDIO_SAMPLE_RATE_HZ = paramyp.audioSampleRate;
      ((EncoderWriter.OutputConfig)localObject1).AUDIO_CHANNEL_COUNT = paramyp.gOt;
      ac.i("MicroMsg.VLogComposition", "export: config: " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_TARGET_WIDTH + ", " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_TARGET_HEIGHT + "; video: " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_BIT_RATE + ", " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_FRAME_RATE + ", " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_IFRAME_INTERVAL + ", " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_QUALITY + "; audio: " + ((EncoderWriter.OutputConfig)localObject1).AUDIO_BIT_RATE + ", " + ((EncoderWriter.OutputConfig)localObject1).AUDIO_SAMPLE_RATE_HZ + ", " + ((EncoderWriter.OutputConfig)localObject1).AUDIO_CHANNEL_COUNT + "; highProfileEnable: " + bool);
      k.g(localObject2, "source");
      localObject1 = new AssetExportSession(((TAVSource)localObject2).getAsset(), (EncoderWriter.OutputConfig)localObject1);
      str = paramyp.poB;
      localObject3 = com.tencent.mm.vfs.i.aSs(str);
      if (!com.tencent.mm.vfs.i.eA((String)localObject3)) {
        com.tencent.mm.vfs.i.aSh((String)localObject3);
      }
      if (com.tencent.mm.vfs.i.aSt(str)) {
        break;
      }
      ac.e("MicroMsg.VLogComposition", "export create file error");
      paramb.ay(Boolean.FALSE);
      AppMethodBeat.o(207597);
      return false;
    }
    Object localObject3 = new Rect();
    cnb localcnb = paramyp.Eso;
    k.g(localcnb, "config.originRect");
    c.a(localcnb, (Rect)localObject3);
    a(this, paramyp.wXZ, paramyp.wYa, (Rect)localObject3);
    hY(paramyp.gNU, paramyp.gNV);
    ((AssetExportSession)localObject1).setOutputFilePath(com.tencent.mm.vfs.i.k(str, true));
    ((AssetExportSession)localObject1).setOutputFileType("mp4");
    ((AssetExportSession)localObject1).setVideoComposition(((TAVSource)localObject2).getVideoComposition());
    ((AssetExportSession)localObject1).setAudioMix(((TAVSource)localObject2).getAudioMix());
    localObject2 = this.playRange;
    if (localObject2 == null) {
      k.aVY("playRange");
    }
    ((AssetExportSession)localObject1).setTimeRange((CMTimeRange)localObject2);
    localObject2 = new StringBuilder("export duration:").append(this.AnR.getDuration()).append(" playRange:");
    localObject3 = this.playRange;
    if (localObject3 == null) {
      k.aVY("playRange");
    }
    ac.i("MicroMsg.VLogComposition", localObject3);
    ((AssetExportSession)localObject1).exportAsynchronouslyWithCompletionHandler((AssetExportSession.ExportCallbackHandler)new d(this, paramb1, bs.Gn(), str, paramyp, paramb));
    AppMethodBeat.o(207597);
    return true;
  }
  
  public final void an(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(207581);
    ac.m("MicroMsg.VLogComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']', new Object[0]);
    CMTimeRange localCMTimeRange = this.playRange;
    if (localCMTimeRange == null) {
      k.aVY("playRange");
    }
    localCMTimeRange.setStart(CMTime.fromMs(paramLong1));
    localCMTimeRange = this.playRange;
    if (localCMTimeRange == null) {
      k.aVY("playRange");
    }
    localCMTimeRange.setDuration(CMTime.fromMs(paramLong2 - paramLong1));
    AppMethodBeat.o(207581);
  }
  
  public final void ayj(String paramString)
  {
    AppMethodBeat.i(207589);
    k.h(paramString, "musicPath");
    if (!bs.isNullOrNil(paramString)) {}
    TAVClip localTAVClip;
    for (boolean bool = true;; bool = false)
    {
      this.wpZ = bool;
      localTAVClip = new TAVClip((Asset)new URLAsset(com.tencent.mm.vfs.i.k(paramString, false)));
      localObject = this.AnW;
      if (localObject != null) {
        break;
      }
      paramString = new v("null cannot be cast to non-null type java.util.ArrayList<kotlin.collections.List<com.tencent.tavkit.composition.TAVClip>>");
      AppMethodBeat.o(207589);
      throw paramString;
    }
    Object localObject = (ArrayList)localObject;
    ((ArrayList)localObject).clear();
    CMTimeRange localCMTimeRange = this.playRange;
    if (localCMTimeRange == null) {
      k.aVY("playRange");
    }
    ((ArrayList)localObject).add(d.a.j.listOf(new TAVClip[] { new TAVClip((TAVResource)new TAVEmptyResource(localCMTimeRange.getStart())), localTAVClip }));
    this.gUk = paramString;
    efC();
    ac.i("MicroMsg.VLogComposition", "addCompositionMusic musicPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(207589);
  }
  
  public final a b(VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207595);
    k.h(paramVideoTransPara, "videoParams");
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject2 = (Iterable)this.AnT;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        if (((u)localObject3).type == 2)
        {
          i = 1;
          if (i != 0) {
            ((Collection)localObject1).add(localObject3);
          }
        }
        else
        {
          i = 0;
        }
      }
      catch (Throwable paramVideoTransPara)
      {
        paramVideoTransPara = new a(-1, 0, 0, 0, null);
        AppMethodBeat.o(207595);
        return paramVideoTransPara;
      }
    }
    Object localObject1 = (List)localObject1;
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      int j;
      if ((i != 0) && (paramVideoTransPara.hCL == 1))
      {
        localObject1 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (u)((Iterator)localObject1).next();
          localObject2 = AdaptiveAdjustBitrate.a(((u)localObject2).path, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, (float)(((u)localObject2).Aoy - ((u)localObject2).Aox) / 1000.0F, (float)((u)localObject2).Aox / 1000.0F, 4, paramVideoTransPara.hCN, paramVideoTransPara.hCO, paramVideoTransPara.hCP, paramVideoTransPara.hCQ, paramVideoTransPara.hCR, paramVideoTransPara.hCS, paramVideoTransPara.hCT);
          j = paramVideoTransPara.videoBitrate;
          i = -1;
          if (localObject2 == null) {
            break label485;
          }
          if (localObject2[3] > 0) {
            break label492;
          }
          break label485;
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.VLogComposition", "ABA:  finder video bitrate:" + j + " width: " + k + " height:" + m);
        if (com.tencent.mm.modelvideo.o.aJz() != null) {
          com.tencent.mm.an.e.q((int[])localObject2);
        }
        if (i == -1) {
          break;
        }
        this.AnY.add(new a(i, k, m, j, (int[])localObject2));
        break;
        if ((!this.AnY.isEmpty()) && (paramVideoTransPara.hCL == 1))
        {
          d.a.j.a((List)this.AnY, (Comparator)r.f.Aoj);
          paramVideoTransPara = this.AnY.get(0);
          k.g(paramVideoTransPara, "abaParamList.get(0)");
          paramVideoTransPara = (a)paramVideoTransPara;
          this.AnY.clear();
          AppMethodBeat.o(207595);
          return paramVideoTransPara;
        }
        paramVideoTransPara = new a(-1, 0, 0, 0, new int[22]);
        AppMethodBeat.o(207595);
        return paramVideoTransPara;
        label485:
        label492:
        do
        {
          m = paramInt2;
          k = paramInt1;
          break;
          if (localObject2[4] > 0)
          {
            j = localObject2[0] * 1000;
            i = 0;
          }
        } while ((localObject2 == null) || (localObject2[5] <= 0));
        int k = localObject2[1];
        int m = localObject2[2];
        i = 0;
      }
    }
  }
  
  public final TAVSource buildSource()
  {
    AppMethodBeat.i(207592);
    Object localObject = new TAVCompositionBuilder(this.AnR);
    ((TAVCompositionBuilder)localObject).setReloadChannels(false);
    localObject = ((TAVCompositionBuilder)localObject).buildSource();
    k.g(localObject, "builder.buildSource()");
    AppMethodBeat.o(207592);
    return localObject;
  }
  
  public final CMTimeRange efA()
  {
    AppMethodBeat.i(207582);
    CMTimeRange localCMTimeRange = this.playRange;
    if (localCMTimeRange == null) {
      k.aVY("playRange");
    }
    AppMethodBeat.o(207582);
    return localCMTimeRange;
  }
  
  public final long efB()
  {
    AppMethodBeat.i(207583);
    CMTimeRange localCMTimeRange = this.playRange;
    if (localCMTimeRange == null) {
      k.aVY("playRange");
    }
    long l = localCMTimeRange.getStartUs() / 1000L;
    AppMethodBeat.o(207583);
    return l;
  }
  
  public final com.tencent.mm.plugin.vlog.player.render.a efD()
  {
    AppMethodBeat.i(207594);
    Object localObject = this.AnS;
    if (localObject == null) {
      k.aVY("effect");
    }
    localObject = (com.tencent.mm.plugin.vlog.player.render.a)((h)localObject).Arn;
    AppMethodBeat.o(207594);
    return localObject;
  }
  
  public final long efz()
  {
    AppMethodBeat.i(207580);
    CMTime localCMTime = this.AnR.getDuration();
    k.g(localCMTime, "composition.duration");
    long l = localCMTime.getTimeUs() / 1000L;
    AppMethodBeat.o(207580);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(207579);
    CMTimeRange localCMTimeRange = this.playRange;
    if (localCMTimeRange == null) {
      k.aVY("playRange");
    }
    long l = localCMTimeRange.getDurationUs() / 1000L;
    AppMethodBeat.o(207579);
    return l;
  }
  
  public final void hY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207588);
    ac.i("MicroMsg.VLogComposition", "setRenderSize: " + paramInt1 + ", " + paramInt2);
    Object localObject;
    if ((!this.gUl.isEmpty()) && (this.AnU.x > 0))
    {
      float f = paramInt1 * 1.0F / this.AnU.x;
      j.b(this.gUl, f);
      this.AnU.x = Math.round(this.AnU.x * f);
      this.AnU.y = Math.round(f * this.AnU.y);
      localObject = this.AnR.getVideoMixEffect();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.player.render.VLogCompositionMixEffect");
        AppMethodBeat.o(207588);
        throw ((Throwable)localObject);
      }
      ((h)localObject).setCropRect(this.gUl);
      if ((this.AnR.getVideoMixEffect() instanceof h))
      {
        localObject = this.AnR.getVideoMixEffect();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.player.render.VLogCompositionMixEffect");
          AppMethodBeat.o(207588);
          throw ((Throwable)localObject);
        }
        ((h)localObject).ia(this.AnU.x, this.AnU.y);
      }
    }
    for (;;)
    {
      this.AnR.setRenderSize(new CGSize(paramInt1, paramInt2));
      AppMethodBeat.o(207588);
      return;
      if ((this.AnR.getVideoMixEffect() instanceof h))
      {
        localObject = this.AnR.getVideoMixEffect();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.player.render.VLogCompositionMixEffect");
          AppMethodBeat.o(207588);
          throw ((Throwable)localObject);
        }
        ((h)localObject).ia(paramInt1, paramInt2);
      }
    }
  }
  
  public final void sj(boolean paramBoolean)
  {
    AppMethodBeat.i(207590);
    ac.i("MicroMsg.VLogComposition", "enableVideoSound:".concat(String.valueOf(paramBoolean)));
    this.AnX = paramBoolean;
    efC();
    AppMethodBeat.o(207590);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition$ABAResult;", "", "errCode", "", "width", "height", "bitrate", "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class a
  {
    final int bitrate;
    final int errCode;
    final int height;
    final int[] rMF;
    final int width;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
    {
      this.errCode = paramInt1;
      this.width = paramInt2;
      this.height = paramInt3;
      this.bitrate = paramInt4;
      this.rMF = paramArrayOfInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(207564);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.errCode != paramObject.errCode) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bitrate != paramObject.bitrate) || (!k.g(this.rMF, paramObject.rMF))) {}
        }
      }
      else
      {
        AppMethodBeat.o(207564);
        return true;
      }
      AppMethodBeat.o(207564);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(207563);
      int j = this.errCode;
      int k = this.width;
      int m = this.height;
      int n = this.bitrate;
      int[] arrayOfInt = this.rMF;
      if (arrayOfInt != null) {}
      for (int i = Arrays.hashCode(arrayOfInt);; i = 0)
      {
        AppMethodBeat.o(207563);
        return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207562);
      String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.rMF) + ")";
      AppMethodBeat.o(207562);
      return str;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition$Companion;", "", "()V", "EXTRA_TRACK", "", "IMAGE_SIZE_LIMIT", "", "TAG", "asyncCreateComposition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/VlogResp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-vlog_release"})
  public static final class b
  {
    public final Object a(List<u> paramList, d.d.d<? super r> paramd)
    {
      AppMethodBeat.i(207566);
      Object localObject1;
      if ((paramd instanceof a))
      {
        localObject1 = (a)paramd;
        if ((((a)localObject1).label & 0x80000000) != 0) {
          ((a)localObject1).label += -2147483648;
        }
      }
      Object localObject2;
      d.d.a.a locala;
      for (;;)
      {
        localObject2 = ((a)localObject1).result;
        locala = d.d.a.a.KUd;
        switch (((a)localObject1).label)
        {
        default: 
          paramList = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(207566);
          throw paramList;
          localObject1 = new a(this, paramd);
        }
      }
      paramd = new r(paramList, null, true);
      ((a)localObject1).nvt = this;
      ((a)localObject1).nIC = paramList;
      ((a)localObject1).nID = null;
      ((a)localObject1).nIE = paramd;
      ((a)localObject1).nIF = paramd;
      ((a)localObject1).nIG = paramd;
      ((a)localObject1).label = 1;
      Object localObject3 = kotlinx.coroutines.g.a((d.d.f)ay.gdO(), (m)new r.c(paramd, paramList, null), (d.d.d)localObject1);
      if (localObject3 == locala)
      {
        AppMethodBeat.o(207566);
        return locala;
        paramList = (r)((a)localObject1).nIG;
        paramd = (r)((a)localObject1).nIF;
        localObject1 = (r)((a)localObject1).nIE;
      }
      for (;;)
      {
        r.a(paramList, (TAVComposition)localObject2);
        r.e(paramd);
        AppMethodBeat.o(207566);
        return localObject1;
        paramList = paramd;
        localObject1 = paramd;
        localObject2 = paramd;
        paramd = (d.d.d<? super r>)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    
    @d.d.b.a.e(c="com.tencent.mm.plugin.vlog.model.VLogComposition$Companion", f="VLogComposition.kt", l={56}, m="asyncCreateComposition")
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"asyncCreateComposition", "", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;"})
    static final class a
      extends d.d.b.a.c
    {
      int label;
      Object nIC;
      Object nID;
      Object nIE;
      Object nIF;
      Object nIG;
      Object nvt;
      
      a(r.b paramb, d.d.d paramd)
      {
        super();
      }
      
      public final Object cO(Object paramObject)
      {
        AppMethodBeat.i(207565);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.Aob.a(null, this);
        AppMethodBeat.o(207565);
        return paramObject;
      }
    }
  }
  
  @d.d.b.a.e(c="com.tencent.mm.plugin.vlog.model.VLogComposition$asyncCreateComposition$2", f="VLogComposition.kt", l={154}, m="invokeSuspend")
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/tavkit/composition/TAVComposition;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends d.d.b.a.i
    implements m<ag, d.d.d<? super TAVComposition>, Object>
  {
    int label;
    Object nIC;
    Object nID;
    Object nIE;
    Object nIF;
    Object nIG;
    Object nIH;
    int nIN;
    int nIO;
    private ag nvs;
    Object nvt;
    
    c(r paramr, List paramList, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(207572);
      k.h(paramd, "completion");
      paramd = new c(this.Aoc, this.Aod, paramd);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(207572);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(207571);
      d.d.a.a locala = d.d.a.a.KUd;
      ag localag;
      TAVComposition localTAVComposition;
      Object localObject1;
      Object localObject2;
      int i;
      Object localObject3;
      int k;
      Object localObject4;
      int j;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(207571);
        throw paramObject;
      case 0: 
        localag = this.nvs;
        ac.i("MicroMsg.VLogComposition", "async createComposition: track size " + this.Aod.size());
        if (this.Aod.isEmpty()) {
          new TAVComposition();
        }
        localTAVComposition = new TAVComposition();
        localObject1 = (Iterable)this.Aod;
        paramObject = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (u)((Iterator)localObject1).next();
          paramObject.add(kotlinx.coroutines.f.a(localag, (d.d.f)ay.gdP(), (m)new r.c.a((u)localObject2, null, this, localag), 2));
        }
        paramObject = (List)paramObject;
        localObject1 = (Iterable)paramObject;
        localObject2 = ((Iterable)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          k = i + 1;
          if (i < 0) {
            d.a.j.fOc();
          }
          localObject4 = (ap)localObject3;
          j = ((Number)Integer.valueOf(i)).intValue();
          this.nvt = localag;
          this.nIC = localTAVComposition;
          this.nID = paramObject;
          this.nIE = localObject1;
          this.nIN = k;
          this.nIF = localObject2;
          this.nIG = localObject3;
          this.nIH = localObject4;
          this.nIO = j;
          this.label = 1;
          localObject3 = ((ap)localObject4).f(this);
          if (localObject3 != locala) {
            break label514;
          }
          AppMethodBeat.o(207571);
          return locala;
        }
        break;
      case 1: 
        j = this.nIO;
        localObject2 = (Iterator)this.nIF;
        i = this.nIN;
        localObject1 = (Iterable)this.nIE;
        localObject4 = (List)this.nID;
        localTAVComposition = (TAVComposition)this.nIC;
        localag = (ag)this.nvt;
        localObject3 = paramObject;
        paramObject = localObject4;
      }
      for (;;)
      {
        localObject3 = (List)localObject3;
        localTAVComposition.addVideoChannel((List)localObject3);
        if (((u)this.Aod.get(j)).type == 2)
        {
          localObject4 = r.b(this.Aoc);
          if (localObject4 == null)
          {
            paramObject = new v("null cannot be cast to non-null type java.util.ArrayList<kotlin.collections.List<com.tencent.tavkit.composition.TAVClip>>");
            AppMethodBeat.o(207571);
            throw paramObject;
          }
          ((ArrayList)localObject4).add(localObject3);
        }
        break;
        AppMethodBeat.o(207571);
        return localTAVComposition;
        label514:
        i = k;
      }
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(207573);
      paramObject1 = ((c)a(paramObject1, (d.d.d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(207573);
      return paramObject1;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "assetExportSession", "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "handlerCallback"})
  static final class d
    implements AssetExportSession.ExportCallbackHandler
  {
    d(r paramr, d.g.a.b paramb1, long paramLong, String paramString, yp paramyp, d.g.a.b paramb2) {}
    
    public final void handlerCallback(AssetExportSession paramAssetExportSession)
    {
      AppMethodBeat.i(207574);
      k.g(paramAssetExportSession, "assetExportSession");
      Object localObject = paramAssetExportSession.getStatus();
      int i = paramAssetExportSession.getErrCode();
      if (i != 0)
      {
        com.tencent.mm.plugin.vlog.model.report.a locala = com.tencent.mm.plugin.vlog.model.report.a.Apq;
        com.tencent.mm.plugin.vlog.model.report.a.RR(i);
      }
      float f = paramAssetExportSession.getProgress();
      paramAssetExportSession = paramb1;
      if (paramAssetExportSession != null) {
        paramAssetExportSession.ay(Float.valueOf(f));
      }
      if (localObject == null) {}
      for (;;)
      {
        ac.i("MicroMsg.VLogComposition", "export failed other status:" + localObject + ", progress:" + f);
        paramAssetExportSession = this.fPt;
        if (paramAssetExportSession == null) {
          break;
        }
        paramAssetExportSession.ay(Boolean.FALSE);
        AppMethodBeat.o(207574);
        return;
        switch (s.cfA[localObject.ordinal()])
        {
        }
      }
      AppMethodBeat.o(207574);
      return;
      ac.i("MicroMsg.VLogComposition", "export completed: " + f + ", cost:" + bs.aO(this.rRt));
      paramAssetExportSession = com.tencent.mm.plugin.vlog.model.report.a.Apq;
      paramAssetExportSession = paramyp;
      k.g(paramAssetExportSession, "path");
      com.tencent.mm.plugin.vlog.model.report.a.b(paramAssetExportSession, bs.aO(this.rRt), r.c(this.Aoc), r.d(this.Aoc));
      if (!paramb.Esq.isEmpty()) {}
      try
      {
        paramAssetExportSession = paramyp;
        localObject = paramb.Esq;
        k.g(localObject, "config.abaParams");
        SightVideoJNI.addReportMetadata(paramAssetExportSession, d.a.j.q((Collection)localObject), paramb.hCL, 0);
        label303:
        paramAssetExportSession = this.fPt;
        if (paramAssetExportSession != null)
        {
          paramAssetExportSession.ay(Boolean.TRUE);
          AppMethodBeat.o(207574);
          return;
        }
        AppMethodBeat.o(207574);
        return;
        ac.i("MicroMsg.VLogComposition", "export failed: status:" + localObject + ", progress:" + f);
        paramAssetExportSession = this.fPt;
        if (paramAssetExportSession != null)
        {
          paramAssetExportSession.ay(Boolean.FALSE);
          AppMethodBeat.o(207574);
          return;
        }
        AppMethodBeat.o(207574);
        return;
        AppMethodBeat.o(207574);
        return;
      }
      catch (Throwable paramAssetExportSession)
      {
        break label303;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.r
 * JD-Core Version:    0.7.0.1
 */