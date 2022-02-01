package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.player.a.h;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
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
import d.d.d<-Lcom.tencent.mm.plugin.vlog.model.v;>;
import d.g.a.b;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.coroutines.al;
import kotlinx.coroutines.at;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "", "origin", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "asyncCreate", "", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/VlogResp;Z)V", "abaParamList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition$ABAResult;", "Lkotlin/collections/ArrayList;", "composition", "Lcom/tencent/tavkit/composition/TAVComposition;", "cropOriginSize", "Landroid/graphics/Point;", "cropRect", "Landroid/graphics/Rect;", "effect", "Lcom/tencent/mm/plugin/vlog/player/render/VLogCompositionMixEffect;", "enableMusic", "enableOriginAudio", "musicAudioChannels", "Lcom/tencent/tavkit/composition/TAVClip;", "musicPath", "", "originAudioChannels", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "playRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "addMusic", "", "asyncCreateComposition", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildTrackChannel", "track", "createComposition", "enableVideoSound", "enable", "export", "config", "callback", "Lkotlin/Function1;", "progressCallback", "", "Lkotlin/ParameterName;", "name", "progress", "getABAResult", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "", "targetHeight", "getDurationMs", "", "getFrameTexture", "getFrameTextureHeight", "getFrameTextureWidth", "getMusicPath", "getOutputConfig", "getPlayRange", "getSize", "Landroid/util/Size;", "getSourceDuration", "getThumbBitmap", "widthLimit", "Landroid/graphics/Bitmap;", "getTrackList", "initCompositionData", "isEnableMusic", "isEnableOriginSound", "renderContext", "Landroid/opengl/EGLContext;", "reportStartExport", "setBlendBitmapProvider", "blendBitmapProvider", "setFilter", "path", "weight", "setFrameRenderCallback", "Lkotlin/Function0;", "setPlayRange", "start", "end", "setRenderCrop", "width", "height", "rect", "flip", "setRenderSize", "sortVideoBitrate", "updateAudioChannels", "ABAResult", "Companion", "plugin-vlog_release"})
public final class v
{
  public static final b LqS;
  public TAVComposition LqJ;
  public h LqK;
  public ArrayList<y> LqL;
  private Point LqM;
  private List<? extends List<? extends TAVClip>> LqN;
  private List<? extends List<? extends TAVClip>> LqO;
  boolean LqP;
  private ArrayList<a> LqQ;
  private final dkv LqR;
  private dxx Lqd;
  String gtC;
  private final Rect gtE;
  public CMTimeRange playRange;
  private boolean vhn;
  
  static
  {
    AppMethodBeat.i(200915);
    LqS = new b((byte)0);
    t localt = t.LqH;
    t.cLD();
    AppMethodBeat.o(200915);
  }
  
  public v(v paramv)
  {
    this((List)paramv.LqL, paramv.LqR, 4);
    AppMethodBeat.i(200914);
    CMTimeRange localCMTimeRange = paramv.playRange;
    if (localCMTimeRange == null) {
      k.aPZ("playRange");
    }
    this.playRange = localCMTimeRange;
    a(paramv.LqM.x, paramv.LqM.y, this.gtE, false);
    AppMethodBeat.o(200914);
  }
  
  public v(List<y> paramList, dkv paramdkv, boolean paramBoolean)
  {
    AppMethodBeat.i(200912);
    this.LqR = paramdkv;
    this.LqJ = new TAVComposition();
    this.LqL = new ArrayList();
    this.LqM = new Point(0, 0);
    this.gtE = new Rect();
    this.Lqd = new dxx();
    this.LqN = ((List)new ArrayList());
    this.LqO = ((List)new ArrayList());
    this.gtC = "";
    this.LqQ = new ArrayList();
    com.tencent.mm.sdk.platformtools.ad.m("MicroMsg.VLogComposition", "create VLogComposition, asyncCreate:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.LqL.clear();
    this.LqL.addAll((Collection)paramList);
    if (!paramBoolean)
    {
      this.LqJ = iZ((List)this.LqL);
      fYG();
    }
    AppMethodBeat.o(200912);
  }
  
  private void a(int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(200899);
    k.h(paramRect, "rect");
    this.LqM = new Point(paramInt1, paramInt2);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "setCompositionDisplayArea cropRect composition renderSize:".concat(String.valueOf(new CGSize(paramRect.right - paramRect.left, paramRect.bottom - paramRect.top))));
    if ((this.LqJ.getVideoMixEffect() instanceof h))
    {
      if (paramBoolean)
      {
        Rect localRect = new Rect(paramRect);
        localRect.top = (paramInt2 - paramRect.bottom);
        localRect.bottom = (paramInt2 - paramRect.top);
        this.gtE.set(localRect);
        AppMethodBeat.o(200899);
        return;
      }
      this.gtE.set(paramRect);
    }
    AppMethodBeat.o(200899);
  }
  
  private static List<TAVClip> b(y paramy)
  {
    AppMethodBeat.i(200898);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "add track type:" + paramy.type + " startTime:" + paramy.bxw + ", endTime:" + paramy.gnO + ", trackStartTime:" + paramy.Lro + ", trackEndTime:" + paramy.Lrp);
    TAVClip localTAVClip1 = paramy.fYM();
    localTAVClip1.putExtraTrackInfo("key_extra_track", paramy);
    if (paramy.bxw > 0L)
    {
      TAVClip localTAVClip2 = new TAVClip((TAVResource)new TAVEmptyResource(CMTime.fromMs(paramy.bxw)));
      localTAVClip2.setStartTime(CMTime.fromMs(0L));
      localTAVClip2.setDuration(CMTime.fromMs(paramy.bxw));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "add front empty clip duration:" + paramy.bxw);
      paramy = d.a.j.listOf(new TAVClip[] { localTAVClip2, localTAVClip1 });
      AppMethodBeat.o(200898);
      return paramy;
    }
    paramy = d.a.j.listOf(localTAVClip1);
    AppMethodBeat.o(200898);
    return paramy;
  }
  
  private final void fYG()
  {
    AppMethodBeat.i(200892);
    this.playRange = new CMTimeRange(CMTime.CMTimeZero, this.LqJ.getDuration());
    this.LqJ.setVideoMixEffect((TAVVideoMixEffect)new h(this.LqR));
    Object localObject = this.LqJ.getVideoMixEffect();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.player.render.VLogCompositionMixEffect");
      AppMethodBeat.o(200892);
      throw ((Throwable)localObject);
    }
    this.LqK = ((h)localObject);
    AppMethodBeat.o(200892);
  }
  
  private final void fYJ()
  {
    AppMethodBeat.i(200904);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", hashCode() + " updateAudioChannels, enableMusic:" + this.vhn + ", enableOriginAudio:" + this.LqP + ", musicAudioChannels:" + this.LqO.size() + ", originAudioChannels:" + this.LqN.size());
    List localList1 = (List)new ArrayList();
    Iterator localIterator;
    List localList2;
    if (this.vhn)
    {
      localIterator = ((Iterable)this.LqO).iterator();
      while (localIterator.hasNext())
      {
        localList2 = (List)localIterator.next();
        ((ArrayList)localList1).add(localList2);
      }
    }
    if (this.LqP)
    {
      localIterator = ((Iterable)this.LqN).iterator();
      while (localIterator.hasNext())
      {
        localList2 = (List)localIterator.next();
        ((ArrayList)localList1).add(localList2);
      }
    }
    this.LqJ.setAudioChannels(localList1);
    AppMethodBeat.o(200904);
  }
  
  private final void fYK()
  {
    AppMethodBeat.i(200910);
    Object localObject2 = (Iterable)this.LqL;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label87:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((y)localObject3).type == 2) {}
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
      ((Collection)localObject1).add(((y)((Iterator)localObject2).next()).path);
    }
    localObject1 = (List)localObject1;
    localObject2 = com.tencent.mm.plugin.vlog.model.a.a.LrI;
    int i = this.LqL.size();
    if (((List)localObject1).size() < this.LqL.size()) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.vlog.model.a.a.bh(i, bool);
      localObject2 = com.tencent.mm.plugin.vlog.model.a.a.LrI;
      com.tencent.mm.plugin.vlog.model.a.a.jc((List)localObject1);
      AppMethodBeat.o(200910);
      return;
    }
  }
  
  private final TAVComposition iZ(List<y> paramList)
  {
    AppMethodBeat.i(200897);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "createComposition: track size " + paramList.size());
    if (paramList.isEmpty())
    {
      paramList = new TAVComposition();
      AppMethodBeat.o(200897);
      return paramList;
    }
    TAVComposition localTAVComposition = new TAVComposition();
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(b((y)((Iterator)localObject2).next()));
    }
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.fvx();
      }
      localObject2 = (List)localObject2;
      localTAVComposition.addVideoChannel((List)localObject2);
      if (((y)paramList.get(i)).type == 2)
      {
        List localList = this.LqN;
        if (localList == null)
        {
          paramList = new d.v("null cannot be cast to non-null type java.util.ArrayList<kotlin.collections.List<com.tencent.tavkit.composition.TAVClip>>");
          AppMethodBeat.o(200897);
          throw paramList;
        }
        ((ArrayList)localList).add(localObject2);
      }
      i += 1;
    }
    paramList = new StringBuilder("finish build composition, duration:");
    localObject1 = localTAVComposition.getDuration();
    k.g(localObject1, "composition.duration");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", ((CMTime)localObject1).getTimeUs() / 1000L);
    AppMethodBeat.o(200897);
    return localTAVComposition;
  }
  
  public final void K(b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(200906);
    k.h(paramb, "blendBitmapProvider");
    h localh = this.LqK;
    if (localh == null) {
      k.aPZ("effect");
    }
    localh.K(paramb);
    AppMethodBeat.o(200906);
  }
  
  public final void U(d.g.a.a<d.y> parama)
  {
    AppMethodBeat.i(200908);
    k.h(parama, "callback");
    h localh = this.LqK;
    if (localh == null) {
      k.aPZ("effect");
    }
    localh.U(parama);
    AppMethodBeat.o(200908);
  }
  
  public final boolean a(final dxx paramdxx, final b<? super Boolean, d.y> paramb, final b<? super Float, d.y> paramb1)
  {
    AppMethodBeat.i(200911);
    k.h(paramdxx, "config");
    fYK();
    Object localObject2 = new TAVCompositionBuilder(this.LqJ).buildSource();
    Object localObject1 = new EncoderWriter.OutputConfig();
    ((EncoderWriter.OutputConfig)localObject1).VIDEO_TARGET_WIDTH = paramdxx.gnh;
    ((EncoderWriter.OutputConfig)localObject1).VIDEO_TARGET_HEIGHT = paramdxx.gni;
    ((EncoderWriter.OutputConfig)localObject1).VIDEO_BIT_RATE = paramdxx.videoBitrate;
    ((EncoderWriter.OutputConfig)localObject1).VIDEO_FRAME_RATE = paramdxx.fps;
    ((EncoderWriter.OutputConfig)localObject1).VIDEO_IFRAME_INTERVAL = paramdxx.hbW;
    ((EncoderWriter.OutputConfig)localObject1).VIDEO_QUALITY = true;
    ((EncoderWriter.OutputConfig)localObject1).AUDIO_BIT_RATE = paramdxx.audioBitrate;
    ((EncoderWriter.OutputConfig)localObject1).AUDIO_SAMPLE_RATE_HZ = paramdxx.audioSampleRate;
    ((EncoderWriter.OutputConfig)localObject1).AUDIO_CHANNEL_COUNT = paramdxx.gnH;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "export: config: " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_TARGET_WIDTH + ", " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_TARGET_HEIGHT + "; video: " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_BIT_RATE + ", " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_FRAME_RATE + ", " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_IFRAME_INTERVAL + ", " + ((EncoderWriter.OutputConfig)localObject1).VIDEO_QUALITY + "; audio: " + ((EncoderWriter.OutputConfig)localObject1).AUDIO_BIT_RATE + ", " + ((EncoderWriter.OutputConfig)localObject1).AUDIO_SAMPLE_RATE_HZ + ", " + ((EncoderWriter.OutputConfig)localObject1).AUDIO_CHANNEL_COUNT);
    k.g(localObject2, "source");
    localObject1 = new AssetExportSession(((TAVSource)localObject2).getAsset(), (EncoderWriter.OutputConfig)localObject1);
    String str = paramdxx.oLh;
    Object localObject3 = i.aMQ(str);
    if (!i.eK((String)localObject3)) {
      i.aMF((String)localObject3);
    }
    if (!i.aMR(str))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.VLogComposition", "export create file error");
      paramb.aA(Boolean.FALSE);
      AppMethodBeat.o(200911);
      return false;
    }
    localObject3 = new Rect();
    ebn localebn = paramdxx.LwW;
    k.g(localebn, "config.originRect");
    m.a(localebn, (Rect)localObject3);
    a(this, paramdxx.vNE, paramdxx.vNF, (Rect)localObject3);
    lg(paramdxx.gnh, paramdxx.gni);
    ((AssetExportSession)localObject1).setOutputFilePath(i.k(str, true));
    ((AssetExportSession)localObject1).setOutputFileType("mp4");
    ((AssetExportSession)localObject1).setVideoComposition(((TAVSource)localObject2).getVideoComposition());
    ((AssetExportSession)localObject1).setAudioMix(((TAVSource)localObject2).getAudioMix());
    localObject2 = this.playRange;
    if (localObject2 == null) {
      k.aPZ("playRange");
    }
    ((AssetExportSession)localObject1).setTimeRange((CMTimeRange)localObject2);
    localObject2 = new StringBuilder("export duration:").append(this.LqJ.getDuration()).append(" playRange:");
    localObject3 = this.playRange;
    if (localObject3 == null) {
      k.aPZ("playRange");
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", localObject3);
    ((AssetExportSession)localObject1).exportAsynchronouslyWithCompletionHandler((AssetExportSession.ExportCallbackHandler)new d(this, paramb1, bt.GC(), str, paramdxx, paramb));
    AppMethodBeat.o(200911);
    return true;
  }
  
  public final void aD(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(200895);
    com.tencent.mm.sdk.platformtools.ad.m("MicroMsg.VLogComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']', new Object[0]);
    CMTimeRange localCMTimeRange = this.playRange;
    if (localCMTimeRange == null) {
      k.aPZ("playRange");
    }
    localCMTimeRange.setStart(CMTime.fromMs(paramLong1));
    localCMTimeRange = this.playRange;
    if (localCMTimeRange == null) {
      k.aPZ("playRange");
    }
    localCMTimeRange.setDuration(CMTime.fromMs(paramLong2 - paramLong1));
    AppMethodBeat.o(200895);
  }
  
  public final void aVU(String paramString)
  {
    AppMethodBeat.i(200902);
    k.h(paramString, "musicPath");
    if (!bt.isNullOrNil(paramString)) {}
    TAVClip localTAVClip;
    for (boolean bool = true;; bool = false)
    {
      this.vhn = bool;
      localTAVClip = new TAVClip((Asset)new URLAsset(i.k(paramString, false)));
      localObject = this.LqO;
      if (localObject != null) {
        break;
      }
      paramString = new d.v("null cannot be cast to non-null type java.util.ArrayList<kotlin.collections.List<com.tencent.tavkit.composition.TAVClip>>");
      AppMethodBeat.o(200902);
      throw paramString;
    }
    Object localObject = (ArrayList)localObject;
    ((ArrayList)localObject).clear();
    ((ArrayList)localObject).add(d.a.j.listOf(localTAVClip));
    this.gtC = paramString;
    fYJ();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "addCompositionMusic musicPath:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(200902);
  }
  
  public final a b(VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200909);
    k.h(paramVideoTransPara, "videoParams");
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject2 = (Iterable)this.LqL;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        if (((y)localObject3).type == 2)
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
        AppMethodBeat.o(200909);
        return paramVideoTransPara;
      }
    }
    Object localObject1 = (List)localObject1;
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      int j;
      if ((i != 0) && (paramVideoTransPara.hcj == 1))
      {
        localObject1 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (y)((Iterator)localObject1).next();
          localObject2 = AdaptiveAdjustBitrate.a(((y)localObject2).path, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, (float)(((y)localObject2).Lrp - ((y)localObject2).Lro) / 1000.0F, (float)((y)localObject2).Lro / 1000.0F, 4, paramVideoTransPara.hcl, paramVideoTransPara.hcm, paramVideoTransPara.hcn, paramVideoTransPara.hco, paramVideoTransPara.hcp, 0);
          j = paramVideoTransPara.videoBitrate;
          i = -1;
          if (localObject2 == null) {
            break label479;
          }
          if (localObject2[3] > 0) {
            break label486;
          }
          break label479;
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "ABA:  finder video bitrate:" + j + " width: " + k + " height:" + m);
        if (o.aCJ() != null) {
          com.tencent.mm.ao.e.p((int[])localObject2);
        }
        if (i == -1) {
          break;
        }
        this.LqQ.add(new a(i, k, m, j, (int[])localObject2));
        break;
        if ((!this.LqQ.isEmpty()) && (paramVideoTransPara.hcj == 1))
        {
          d.a.j.a((List)this.LqQ, (Comparator)f.Lrb);
          paramVideoTransPara = this.LqQ.get(0);
          k.g(paramVideoTransPara, "abaParamList.get(0)");
          paramVideoTransPara = (a)paramVideoTransPara;
          this.LqQ.clear();
          AppMethodBeat.o(200909);
          return paramVideoTransPara;
        }
        paramVideoTransPara = new a(-1, 0, 0, 0, new int[22]);
        AppMethodBeat.o(200909);
        return paramVideoTransPara;
        label479:
        label486:
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
    AppMethodBeat.i(200905);
    Object localObject = new TAVCompositionBuilder(this.LqJ);
    ((TAVCompositionBuilder)localObject).setReloadChannels(false);
    localObject = ((TAVCompositionBuilder)localObject).buildSource();
    k.g(localObject, "builder.buildSource()");
    AppMethodBeat.o(200905);
    return localObject;
  }
  
  public final long cuR()
  {
    AppMethodBeat.i(200893);
    CMTimeRange localCMTimeRange = this.playRange;
    if (localCMTimeRange == null) {
      k.aPZ("playRange");
    }
    long l = localCMTimeRange.getDurationUs() / 1000L;
    AppMethodBeat.o(200893);
    return l;
  }
  
  public final long fYH()
  {
    AppMethodBeat.i(200894);
    CMTime localCMTime = this.LqJ.getDuration();
    k.g(localCMTime, "composition.duration");
    long l = localCMTime.getTimeUs() / 1000L;
    AppMethodBeat.o(200894);
    return l;
  }
  
  public final CMTimeRange fYI()
  {
    AppMethodBeat.i(200896);
    CMTimeRange localCMTimeRange = this.playRange;
    if (localCMTimeRange == null) {
      k.aPZ("playRange");
    }
    AppMethodBeat.o(200896);
    return localCMTimeRange;
  }
  
  public final void lg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200901);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "setRenderSize: " + paramInt1 + ", " + paramInt2);
    Object localObject;
    if ((!this.gtE.isEmpty()) && (this.LqM.x > 0))
    {
      float f = paramInt1 * 1.0F / this.LqM.x;
      p.b(this.gtE, f);
      this.LqM.x = Math.round(this.LqM.x * f);
      this.LqM.y = Math.round(f * this.LqM.y);
      localObject = this.LqJ.getVideoMixEffect();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.player.render.VLogCompositionMixEffect");
        AppMethodBeat.o(200901);
        throw ((Throwable)localObject);
      }
      ((h)localObject).setCropRect(this.gtE);
      if ((this.LqJ.getVideoMixEffect() instanceof h))
      {
        localObject = this.LqJ.getVideoMixEffect();
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.player.render.VLogCompositionMixEffect");
          AppMethodBeat.o(200901);
          throw ((Throwable)localObject);
        }
        ((h)localObject).li(this.LqM.x, this.LqM.y);
      }
    }
    for (;;)
    {
      this.LqJ.setRenderSize(new CGSize(paramInt1, paramInt2));
      AppMethodBeat.o(200901);
      return;
      if ((this.LqJ.getVideoMixEffect() instanceof h))
      {
        localObject = this.LqJ.getVideoMixEffect();
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.player.render.VLogCompositionMixEffect");
          AppMethodBeat.o(200901);
          throw ((Throwable)localObject);
        }
        ((h)localObject).li(paramInt1, paramInt2);
      }
    }
  }
  
  public final void p(String paramString, float paramFloat)
  {
    AppMethodBeat.i(200907);
    k.h(paramString, "path");
    h localh = this.LqK;
    if (localh == null) {
      k.aPZ("effect");
    }
    localh.p(paramString, paramFloat);
    AppMethodBeat.o(200907);
  }
  
  public final void zd(boolean paramBoolean)
  {
    AppMethodBeat.i(200903);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "enableVideoSound:".concat(String.valueOf(paramBoolean)));
    this.LqP = paramBoolean;
    fYJ();
    AppMethodBeat.o(200903);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition$ABAResult;", "", "errCode", "", "width", "height", "bitrate", "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class a
  {
    final int bitrate;
    final int errCode;
    final int height;
    final int[] qQH;
    final int width;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
    {
      this.errCode = paramInt1;
      this.width = paramInt2;
      this.height = paramInt3;
      this.bitrate = paramInt4;
      this.qQH = paramArrayOfInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(200878);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.errCode != paramObject.errCode) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bitrate != paramObject.bitrate) || (!k.g(this.qQH, paramObject.qQH))) {}
        }
      }
      else
      {
        AppMethodBeat.o(200878);
        return true;
      }
      AppMethodBeat.o(200878);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(200877);
      int j = this.errCode;
      int k = this.width;
      int m = this.height;
      int n = this.bitrate;
      int[] arrayOfInt = this.qQH;
      if (arrayOfInt != null) {}
      for (int i = Arrays.hashCode(arrayOfInt);; i = 0)
      {
        AppMethodBeat.o(200877);
        return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200876);
      String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.qQH) + ")";
      AppMethodBeat.o(200876);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition$Companion;", "", "()V", "EXTRA_TRACK", "", "IMAGE_SIZE_LIMIT", "", "TAG", "asyncCreateComposition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "(Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/VlogResp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-vlog_release"})
  public static final class b
  {
    public final Object a(List<y> paramList, d.d.d<? super v> paramd)
    {
      AppMethodBeat.i(200880);
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
        locala = d.d.a.a.JgJ;
        switch (((a)localObject1).label)
        {
        default: 
          paramList = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(200880);
          throw paramList;
          localObject1 = new a(this, paramd);
        }
      }
      paramd = new v(paramList, null, true);
      ((a)localObject1).mTb = this;
      ((a)localObject1).nfO = paramList;
      ((a)localObject1).nfP = null;
      ((a)localObject1).nfQ = paramd;
      ((a)localObject1).nfR = paramd;
      ((a)localObject1).nfS = paramd;
      ((a)localObject1).label = 1;
      Object localObject3 = kotlinx.coroutines.e.a((d.d.f)at.gaG(), (d.g.a.m)new v.c(paramd, paramList, null), (d.d.d)localObject1);
      if (localObject3 == locala)
      {
        AppMethodBeat.o(200880);
        return locala;
        paramList = (v)((a)localObject1).nfS;
        paramd = (v)((a)localObject1).nfR;
        localObject1 = (v)((a)localObject1).nfQ;
      }
      for (;;)
      {
        v.a(paramList, (TAVComposition)localObject2);
        v.e(paramd);
        AppMethodBeat.o(200880);
        return localObject1;
        paramList = paramd;
        localObject1 = paramd;
        localObject2 = paramd;
        paramd = (d.d.d<? super v>)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    
    @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.VLogComposition$Companion", f="VLogComposition.kt", l={51}, m="asyncCreateComposition")
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"asyncCreateComposition", "", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;"})
    static final class a
      extends d.d.b.a.d
    {
      int label;
      Object mTb;
      Object nfO;
      Object nfP;
      Object nfQ;
      Object nfR;
      Object nfS;
      
      a(v.b paramb, d.d.d paramd)
      {
        super();
      }
      
      public final Object cP(Object paramObject)
      {
        AppMethodBeat.i(200879);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.LqT.a(null, this);
        AppMethodBeat.o(200879);
        return paramObject;
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.VLogComposition$asyncCreateComposition$2", f="VLogComposition.kt", l={145}, m="invokeSuspend")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/tavkit/composition/TAVComposition;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends d.d.b.a.j
    implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super TAVComposition>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    Object nfO;
    Object nfP;
    Object nfQ;
    Object nfR;
    Object nfS;
    Object nfT;
    int nfX;
    int nfY;
    
    c(v paramv, List paramList, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(200886);
      k.h(paramd, "completion");
      paramd = new c(this.LqU, this.LqV, paramd);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(200886);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(200885);
      d.d.a.a locala = d.d.a.a.JgJ;
      final kotlinx.coroutines.ad localad;
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
        AppMethodBeat.o(200885);
        throw paramObject;
      case 0: 
        localad = this.mTa;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "async createComposition: track size " + this.LqV.size());
        if (this.LqV.isEmpty()) {
          new TAVComposition();
        }
        localTAVComposition = new TAVComposition();
        localObject1 = (Iterable)this.LqV;
        paramObject = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (y)((Iterator)localObject1).next();
          paramObject.add(kotlinx.coroutines.d.b(localad, (d.d.f)at.fLg(), (d.g.a.m)new a((y)localObject2, null, this, localad), 2));
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
            d.a.j.fvx();
          }
          localObject4 = (al)localObject3;
          j = ((Number)Integer.valueOf(i)).intValue();
          this.mTb = localad;
          this.nfO = localTAVComposition;
          this.nfP = paramObject;
          this.nfQ = localObject1;
          this.nfX = k;
          this.nfR = localObject2;
          this.nfS = localObject3;
          this.nfT = localObject4;
          this.nfY = j;
          this.label = 1;
          localObject3 = ((al)localObject4).f(this);
          if (localObject3 != locala) {
            break label514;
          }
          AppMethodBeat.o(200885);
          return locala;
        }
        break;
      case 1: 
        j = this.nfY;
        localObject2 = (Iterator)this.nfR;
        i = this.nfX;
        localObject1 = (Iterable)this.nfQ;
        localObject4 = (List)this.nfP;
        localTAVComposition = (TAVComposition)this.nfO;
        localad = (kotlinx.coroutines.ad)this.mTb;
        localObject3 = paramObject;
        paramObject = localObject4;
      }
      for (;;)
      {
        localObject3 = (List)localObject3;
        localTAVComposition.addVideoChannel((List)localObject3);
        if (((y)this.LqV.get(j)).type == 2)
        {
          localObject4 = v.b(this.LqU);
          if (localObject4 == null)
          {
            paramObject = new d.v("null cannot be cast to non-null type java.util.ArrayList<kotlin.collections.List<com.tencent.tavkit.composition.TAVClip>>");
            AppMethodBeat.o(200885);
            throw paramObject;
          }
          ((ArrayList)localObject4).add(localObject3);
        }
        break;
        AppMethodBeat.o(200885);
        return localTAVComposition;
        label514:
        i = k;
      }
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(200887);
      paramObject1 = ((c)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
      AppMethodBeat.o(200887);
      return paramObject1;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/tavkit/composition/TAVClip;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/model/VLogComposition$asyncCreateComposition$2$requests$1$1"})
    static final class a
      extends d.d.b.a.j
      implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super List<? extends TAVClip>>, Object>
    {
      int label;
      private kotlinx.coroutines.ad mTa;
      
      a(y paramy, d.d.d paramd, v.c paramc, kotlinx.coroutines.ad paramad)
      {
        super();
      }
      
      public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
      {
        AppMethodBeat.i(200883);
        k.h(paramd, "completion");
        paramd = new a(this.LqW, paramd, jdField_this, localad);
        paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
        AppMethodBeat.o(200883);
        return paramd;
      }
      
      public final Object cP(Object paramObject)
      {
        AppMethodBeat.i(200882);
        paramObject = d.d.a.a.JgJ;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(200882);
          throw paramObject;
        }
        paramObject = v.c(this.LqW);
        AppMethodBeat.o(200882);
        return paramObject;
      }
      
      public final Object n(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(200884);
        paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
        AppMethodBeat.o(200884);
        return paramObject1;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "assetExportSession", "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "handlerCallback"})
  static final class d
    implements AssetExportSession.ExportCallbackHandler
  {
    d(v paramv, b paramb1, long paramLong, String paramString, dxx paramdxx, b paramb2) {}
    
    public final void handlerCallback(AssetExportSession paramAssetExportSession)
    {
      AppMethodBeat.i(200888);
      k.g(paramAssetExportSession, "assetExportSession");
      Object localObject = paramAssetExportSession.getStatus();
      int i = paramAssetExportSession.getErrCode();
      if (i != 0)
      {
        com.tencent.mm.plugin.vlog.model.a.a locala = com.tencent.mm.plugin.vlog.model.a.a.LrI;
        com.tencent.mm.plugin.vlog.model.a.a.aih(i);
      }
      float f = paramAssetExportSession.getProgress();
      paramAssetExportSession = paramb1;
      if (paramAssetExportSession != null) {
        paramAssetExportSession.aA(Float.valueOf(f));
      }
      if (localObject == null) {}
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "export failed other status:" + localObject + ", progress:" + f);
        paramAssetExportSession = this.fLH;
        if (paramAssetExportSession == null) {
          break;
        }
        paramAssetExportSession.aA(Boolean.FALSE);
        AppMethodBeat.o(200888);
        return;
        switch (w.ciE[localObject.ordinal()])
        {
        }
      }
      AppMethodBeat.o(200888);
      return;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "export completed: " + f + ", cost:" + bt.aS(this.vdX));
      paramAssetExportSession = com.tencent.mm.plugin.vlog.model.a.a.LrI;
      paramAssetExportSession = paramdxx;
      k.g(paramAssetExportSession, "path");
      com.tencent.mm.plugin.vlog.model.a.a.b(paramAssetExportSession, bt.aS(this.vdX), v.c(this.LqU), v.d(this.LqU));
      if (!paramb.LwY.isEmpty()) {}
      try
      {
        paramAssetExportSession = paramdxx;
        localObject = paramb.LwY;
        k.g(localObject, "config.abaParams");
        SightVideoJNI.addReportMetadata(paramAssetExportSession, d.a.j.p((Collection)localObject), paramb.hcj, 0);
        label303:
        paramAssetExportSession = this.fLH;
        if (paramAssetExportSession != null)
        {
          paramAssetExportSession.aA(Boolean.TRUE);
          AppMethodBeat.o(200888);
          return;
        }
        AppMethodBeat.o(200888);
        return;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.VLogComposition", "export failed: status:" + localObject + ", progress:" + f);
        paramAssetExportSession = this.fLH;
        if (paramAssetExportSession != null)
        {
          paramAssetExportSession.aA(Boolean.FALSE);
          AppMethodBeat.o(200888);
          return;
        }
        AppMethodBeat.o(200888);
        return;
        AppMethodBeat.o(200888);
        return;
      }
      catch (Throwable paramAssetExportSession)
      {
        break label303;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  public static final class e
    extends d.g.b.l
    implements d.g.a.m<Long, Bitmap, d.y>
  {
    public e(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition$ABAResult;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class f<T>
    implements Comparator<v.a>
  {
    public static final f Lrb;
    
    static
    {
      AppMethodBeat.i(200891);
      Lrb = new f();
      AppMethodBeat.o(200891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.v
 * JD-Core Version:    0.7.0.1
 */