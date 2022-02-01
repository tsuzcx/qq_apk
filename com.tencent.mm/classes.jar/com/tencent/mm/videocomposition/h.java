package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.b.c;
import com.tencent.mm.xeffect.VLogEffectMgr;
import com.tencent.mm.xeffect.VLogEffectMgr.a;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.AssetExportSessionStatus;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.core.composition.MutableVideoComposition;
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
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/VideoComposition;", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "(Ljava/util/List;)V", "origin", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "()V", "assetHeight", "", "assetWidth", "audioProcessorFactory", "Lcom/tencent/mm/videocomposition/audio/IAudioProcessorFactory;", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "checkPerformance", "", "effect", "Lcom/tencent/mm/videocomposition/render/VLogDirectorMultiVideoCompositionEffect;", "enableOriginAudio", "id", "getId", "()J", "setId", "(J)V", "isRevert", "outputCrop", "Landroid/graphics/Rect;", "playEnd", "getPlayEnd", "playFps", "", "playStart", "getPlayStart", "setEnd", "getSetEnd", "setSetEnd", "setStart", "getSetStart", "setSetStart", "sourceEnd", "getSourceEnd", "sourceStart", "getSourceStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/VLogEffectMgr;", "viewRect", "addTrack", "", "track", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildTrackChannel", "Lcom/tencent/tavkit/composition/TAVClip;", "createComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "enableVideoSound", "enable", "export", "path", "", "config", "Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "callback", "Lkotlin/Function2;", "progressCallback", "getAssetSize", "Landroid/util/Size;", "getDisplayScreenRect", "getDurationMs", "getOutputSize", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getRenderSize", "getSourceDuration", "getThumbBitmap", "widthLimit", "getTrackList", "isEnableOriginSound", "removeTrack", "setAssetSize", "width", "height", "setAudioProcessorFactory", "setBlendBitmapProvider", "setCheckPerformance", "check", "setDisplayScreenRect", "rect", "setOutputCrop", "setPlayFps", "fps", "setPlayRange", "start", "end", "setRenderSize", "setRevert", "revert", "setTrackList", "setVLogEffectMgr", "updateTrack", "index", "Companion", "VideoOutputConfig", "video_composition_release"})
public final class h
{
  public static final h.a LJE;
  public final ArrayList<b> BXJ;
  private boolean BXK;
  public VLogEffectMgr BYQ;
  private com.tencent.mm.videocomposition.b.e LJA;
  private com.tencent.mm.videocomposition.a.a LJB;
  public boolean LJC;
  private boolean LJD;
  private final long LJt;
  public long LJu;
  public long LJv;
  public int LJw;
  public int LJx;
  public float LJy;
  public final Rect LJz;
  private d.g.a.b<? super Long, Bitmap> hnM;
  private Rect viewRect;
  
  static
  {
    AppMethodBeat.i(194993);
    LJE = new h.a((byte)0);
    d locald = d.LJp;
    d.dlu();
    AppMethodBeat.o(194993);
  }
  
  public h()
  {
    AppMethodBeat.i(194992);
    this.LJu = -1L;
    this.LJv = -1L;
    this.viewRect = new Rect();
    this.LJy = 30.0F;
    this.LJz = new Rect();
    this.BXJ = new ArrayList();
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "create VLogComposition", new Object[0]);
    AppMethodBeat.o(194992);
  }
  
  private long fTZ()
  {
    AppMethodBeat.i(194977);
    Object localObject2 = (Iterable)this.BXJ;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((b)localObject3).ews()) {
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
      l1 = ((b)localObject1).hlm;
      AppMethodBeat.o(194977);
      return l1;
      localObject1 = ((Iterator)localObject3).next();
    } while (!((Iterator)localObject3).hasNext());
    long l1 = ((b)localObject1).hlm;
    label164:
    localObject2 = ((Iterator)localObject3).next();
    long l2 = ((b)localObject2).hlm;
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
        AppMethodBeat.o(194977);
        return 0L;
      }
      break label164;
    }
  }
  
  private final TAVComposition iX(List<b> paramList)
  {
    AppMethodBeat.i(194984);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "createComposition: track size " + paramList.size(), new Object[0]);
    if (paramList.isEmpty())
    {
      paramList = new TAVComposition();
      AppMethodBeat.o(194984);
      return paramList;
    }
    TAVComposition localTAVComposition = new TAVComposition();
    Object localObject1 = (Iterable)paramList;
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", "add track type:" + localb.type + " startTime:" + localb.startTimeMs + ", endTime:" + localb.hlm + ", trackStartTime:" + localb.HWH + ", trackEndTime:" + localb.HWI, new Object[0]);
      boolean bool = this.BXK;
      Object localObject3;
      if (localb.type != 0)
      {
        localObject1 = new TAVClip(e.LJs.b(localb));
        ((TAVClip)localObject1).setStartTime(CMTime.fromMs(localb.startTimeMs));
        ((TAVClip)localObject1).setDuration(CMTime.fromMs(localb.hlm - localb.startTimeMs));
        localObject3 = ((TAVClip)localObject1).getResource();
        p.g(localObject3, "clip.resource");
        ((TAVResource)localObject3).setSourceTimeRange(new CMTimeRange(CMTime.fromMs(localb.HWH), CMTime.fromMs(localb.HWI - localb.HWH)));
        if ((localb.type == 2) && (!bool))
        {
          localObject3 = ((TAVClip)localObject1).getAudioConfiguration();
          p.g(localObject3, "clip.audioConfiguration");
          ((TAVAudioConfiguration)localObject3).setVolume(0.0F);
          label358:
          com.tencent.mm.videocomposition.c.b.i("CompositionTrack", localb.id + " buildClip buildVideoClip, path:" + localb.path + ", video startEnd:[" + localb.HWH + ", " + localb.HWI + "], material startEnd:[" + localb.startTimeMs + ", " + localb.hlm + "], volume: " + localb.volume, new Object[0]);
          label470:
          localObject3 = this.LJB;
          if (localObject3 != null)
          {
            localObject3 = ((com.tencent.mm.videocomposition.a.a)localObject3).fUc();
            if (localObject3 != null) {
              ((TAVClip)localObject1).getAudioConfiguration().addAudioProcessorNode((TAVAudioProcessorNode)localObject3);
            }
          }
          ((TAVClip)localObject1).putExtraTrackInfo("key_extra_track", localb);
          if (localb.startTimeMs <= 0L) {
            break label689;
          }
          localObject3 = new TAVClip((TAVResource)new TAVEmptyResource(CMTime.fromMs(localb.startTimeMs)));
          ((TAVClip)localObject3).setStartTime(CMTime.fromMs(0L));
          ((TAVClip)localObject3).setDuration(CMTime.fromMs(localb.startTimeMs));
          com.tencent.mm.videocomposition.c.b.i("VideoComposition", "add front empty clip duration:" + localb.startTimeMs, new Object[0]);
        }
      }
      label689:
      for (localObject1 = j.listOf(new TAVClip[] { localObject3, localObject1 });; localObject1 = j.listOf(localObject1))
      {
        ((Collection)localObject2).add(localObject1);
        break;
        localObject3 = ((TAVClip)localObject1).getAudioConfiguration();
        p.g(localObject3, "clip.audioConfiguration");
        ((TAVAudioConfiguration)localObject3).setVolume(localb.volume);
        break label358;
        localObject1 = new TAVClip((TAVResource)new TAVEmptyResource(CMTime.CMTimeZero));
        break label470;
      }
    }
    localObject1 = ((Iterable)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.gkd();
      }
      localObject2 = (List)localObject2;
      if (((b)paramList.get(i)).ews()) {
        localTAVComposition.addVideoChannel((List)localObject2);
      }
      if ((((b)paramList.get(i)).type == 2) || (((b)paramList.get(i)).type == 3) || (((b)paramList.get(i)).type == 1)) {
        localTAVComposition.addAudioChannel((List)localObject2);
      }
      i += 1;
    }
    paramList = new StringBuilder("finish build composition, duration:");
    localObject1 = localTAVComposition.getDuration();
    p.g(localObject1, "composition.duration");
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", ((CMTime)localObject1).getTimeUs() / 1000L, new Object[0]);
    AppMethodBeat.o(194984);
    return localTAVComposition;
  }
  
  public final void F(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(194989);
    p.h(paramb, "blendBitmapProvider");
    this.hnM = paramb;
    AppMethodBeat.o(194989);
  }
  
  public final void aq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194982);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']', new Object[0]);
    this.LJu = paramLong1;
    this.LJv = paramLong2;
    AppMethodBeat.o(194982);
  }
  
  public final TAVSource buildSource()
  {
    AppMethodBeat.i(194990);
    Object localObject1 = iX((List)this.BXJ);
    Object localObject2 = new com.tencent.mm.videocomposition.b.e();
    this.LJA = ((com.tencent.mm.videocomposition.b.e)localObject2);
    long l2 = System.currentTimeMillis();
    Object localObject3 = this.BYQ;
    if (localObject3 != null) {
      ((VLogEffectMgr)localObject3).fWQ();
    }
    int j = this.BXJ.size();
    int i = 1;
    if (i < j)
    {
      localObject3 = this.BXJ.get(i - 1);
      p.g(localObject3, "trackList[i - 1]");
      localObject3 = (b)localObject3;
      Object localObject4 = this.BXJ.get(i);
      p.g(localObject4, "trackList[i]");
      localObject4 = (b)localObject4;
      g localg = ((b)localObject4).LJl;
      VLogEffectMgr localVLogEffectMgr;
      if (localg.isValid()) {
        if (localg.yeZ == 0L)
        {
          localVLogEffectMgr = this.BYQ;
          if (localVLogEffectMgr == null) {
            break label236;
          }
        }
      }
      label236:
      for (long l1 = localVLogEffectMgr.a(VLogEffectMgr.a.LYm, localg.path);; l1 = 0L)
      {
        localg.yeZ = l1;
        localVLogEffectMgr = this.BYQ;
        if (localVLogEffectMgr != null) {
          localVLogEffectMgr.a(((b)localObject4).startTimeMs, ((b)localObject3).hlm, localg.yeZ, new long[] { ((b)localObject3).id, ((b)localObject4).id });
        }
        i += 1;
        break;
      }
    }
    new StringBuilder("buildSource: update transition cost ").append(System.currentTimeMillis() - l2);
    ((com.tencent.mm.videocomposition.b.e)localObject2).kA(this.LJw, this.LJx);
    ((com.tencent.mm.videocomposition.b.e)localObject2).b(this.BYQ);
    ((com.tencent.mm.videocomposition.b.e)localObject2).p(this.LJz);
    ((com.tencent.mm.videocomposition.b.e)localObject2).LJD = this.LJD;
    localObject3 = this.hnM;
    if (localObject3 != null) {
      ((com.tencent.mm.videocomposition.b.e)localObject2).F((d.g.a.b)localObject3);
    }
    ((TAVComposition)localObject1).setVideoMixEffect((TAVVideoMixEffect)new c((com.tencent.mm.videocomposition.b.a)localObject2));
    localObject1 = new TAVCompositionBuilder((TAVComposition)localObject1);
    ((TAVCompositionBuilder)localObject1).setReloadChannels(false);
    localObject1 = ((TAVCompositionBuilder)localObject1).buildSource();
    p.g(localObject1, "source");
    localObject2 = ((TAVSource)localObject1).getVideoComposition();
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.tav.core.composition.MutableVideoComposition");
      AppMethodBeat.o(194990);
      throw ((Throwable)localObject1);
    }
    ((MutableVideoComposition)localObject2).setFrameDuration(new CMTime(1000L, (int)(this.LJy * 1000.0F)));
    AppMethodBeat.o(194990);
    return localObject1;
  }
  
  public final void d(b paramb)
  {
    AppMethodBeat.i(194979);
    p.h(paramb, "track");
    this.BXJ.add(paramb);
    AppMethodBeat.o(194979);
  }
  
  public final long evH()
  {
    AppMethodBeat.i(194978);
    if (this.LJv >= 0L)
    {
      l = this.LJv;
      AppMethodBeat.o(194978);
      return l;
    }
    long l = fTZ();
    AppMethodBeat.o(194978);
    return l;
  }
  
  public final CMTimeRange evI()
  {
    AppMethodBeat.i(194983);
    CMTimeRange localCMTimeRange = CMTimeRange.fromMs(getPlayStart(), evH() - getPlayStart());
    p.g(localCMTimeRange, "CMTimeRange.fromMs(playStart, playEnd - playStart)");
    AppMethodBeat.o(194983);
    return localCMTimeRange;
  }
  
  public final long fUa()
  {
    AppMethodBeat.i(194981);
    long l1 = fTZ();
    long l2 = this.LJt;
    AppMethodBeat.o(194981);
    return l1 - l2;
  }
  
  public final Size fUb()
  {
    AppMethodBeat.i(194986);
    Size localSize = new Size(this.LJw, this.LJx);
    AppMethodBeat.o(194986);
    return localSize;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(194980);
    long l1 = evH();
    long l2 = getPlayStart();
    AppMethodBeat.o(194980);
    return l1 - l2;
  }
  
  public final long getPlayStart()
  {
    if (this.LJu >= 0L) {
      return this.LJu;
    }
    return this.LJt;
  }
  
  public final void kz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194985);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setAssetSize: " + paramInt1 + ", " + paramInt2, new Object[0]);
    this.LJw = paramInt1;
    this.LJx = paramInt2;
    com.tencent.mm.videocomposition.b.e locale = this.LJA;
    if (locale != null) {
      locale.kA(paramInt1, paramInt2);
    }
    this.viewRect.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(194985);
  }
  
  public final void p(Rect paramRect)
  {
    AppMethodBeat.i(194987);
    p.h(paramRect, "rect");
    this.LJz.set(paramRect);
    AppMethodBeat.o(194987);
  }
  
  public final void sX(boolean paramBoolean)
  {
    AppMethodBeat.i(194988);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "enableVideoSound:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.BXK = paramBoolean;
    AppMethodBeat.o(194988);
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "", "targetSize", "Landroid/util/Size;", "videoBitrate", "", "fps", "iFrameInterval", "audioBitrate", "audioSampleRate", "audioChannelCount", "highProfileEnable", "", "aacEncodeNeedCodecSpecificData", "(Landroid/util/Size;IIIIIIZZ)V", "getAacEncodeNeedCodecSpecificData", "()Z", "getAudioBitrate", "()I", "getAudioChannelCount", "getAudioSampleRate", "getFps", "getHighProfileEnable", "getIFrameInterval", "getTargetSize", "()Landroid/util/Size;", "getVideoBitrate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "video_composition_release"})
  public static final class b
  {
    final Size LJF;
    final boolean LJG;
    final boolean LJH;
    final int audioBitrate;
    public final int audioChannelCount;
    public final int audioSampleRate;
    final int fps;
    final int hkF;
    final int videoBitrate;
    
    public b(Size paramSize, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
    {
      AppMethodBeat.i(194970);
      this.LJF = paramSize;
      this.videoBitrate = paramInt1;
      this.fps = paramInt2;
      this.hkF = paramInt3;
      this.audioBitrate = paramInt4;
      this.audioSampleRate = paramInt5;
      this.audioChannelCount = paramInt6;
      this.LJG = paramBoolean;
      this.LJH = false;
      AppMethodBeat.o(194970);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(194973);
      if (this != paramObject)
      {
        if (!(paramObject instanceof b)) {
          break label219;
        }
        paramObject = (b)paramObject;
        if (!p.i(this.LJF, paramObject.LJF)) {
          break label219;
        }
        if (this.videoBitrate != paramObject.videoBitrate) {
          break label179;
        }
        i = 1;
        if (i == 0) {
          break label219;
        }
        if (this.fps != paramObject.fps) {
          break label184;
        }
        i = 1;
        label66:
        if (i == 0) {
          break label219;
        }
        if (this.hkF != paramObject.hkF) {
          break label189;
        }
        i = 1;
        label83:
        if (i == 0) {
          break label219;
        }
        if (this.audioBitrate != paramObject.audioBitrate) {
          break label194;
        }
        i = 1;
        label100:
        if (i == 0) {
          break label219;
        }
        if (this.audioSampleRate != paramObject.audioSampleRate) {
          break label199;
        }
        i = 1;
        label117:
        if (i == 0) {
          break label219;
        }
        if (this.audioChannelCount != paramObject.audioChannelCount) {
          break label204;
        }
        i = 1;
        label134:
        if (i == 0) {
          break label219;
        }
        if (this.LJG != paramObject.LJG) {
          break label209;
        }
        i = 1;
        label151:
        if (i == 0) {
          break label219;
        }
        if (this.LJH != paramObject.LJH) {
          break label214;
        }
      }
      label179:
      label184:
      label189:
      label194:
      label199:
      label204:
      label209:
      label214:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label219;
        }
        AppMethodBeat.o(194973);
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
      }
      label219:
      AppMethodBeat.o(194973);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(194971);
      String str = "VideoOutputConfig(targetSize=" + this.LJF + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", iFrameInterval=" + this.hkF + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", highProfileEnable=" + this.LJG + ", aacEncodeNeedCodecSpecificData=" + this.LJH + ")";
      AppMethodBeat.o(194971);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"<anonymous>", "", "assetExportSession", "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "handlerCallback"})
  static final class c
    implements AssetExportSession.ExportCallbackHandler
  {
    c(d.g.a.b paramb, long paramLong, m paramm) {}
    
    public final void handlerCallback(AssetExportSession paramAssetExportSession)
    {
      AppMethodBeat.i(194975);
      p.g(paramAssetExportSession, "assetExportSession");
      AssetExportSession.AssetExportSessionStatus localAssetExportSessionStatus = paramAssetExportSession.getStatus();
      int i = paramAssetExportSession.getErrCode();
      float f = paramAssetExportSession.getProgress();
      if (localAssetExportSessionStatus == null) {}
      for (;;)
      {
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export failed other status:" + localAssetExportSessionStatus + ", progress:" + f, new Object[0]);
        paramAssetExportSession = this.mor;
        if (paramAssetExportSession == null) {
          break;
        }
        paramAssetExportSession.p(Boolean.FALSE, Integer.valueOf(i));
        AppMethodBeat.o(194975);
        return;
        switch (i.cqt[localAssetExportSessionStatus.ordinal()])
        {
        }
      }
      paramAssetExportSession = this.LJI;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.invoke(Float.valueOf(f));
        AppMethodBeat.o(194975);
        return;
      }
      AppMethodBeat.o(194975);
      return;
      paramAssetExportSession = new StringBuilder("export completed: ").append(f).append(", cost:");
      long l = this.sxx;
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", SystemClock.elapsedRealtime() - l, new Object[0]);
      paramAssetExportSession = this.mor;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.p(Boolean.TRUE, Integer.valueOf(i));
        AppMethodBeat.o(194975);
        return;
      }
      AppMethodBeat.o(194975);
      return;
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export failed: status:" + localAssetExportSessionStatus + ", progress:" + f, new Object[0]);
      paramAssetExportSession = this.mor;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.p(Boolean.FALSE, Integer.valueOf(i));
        AppMethodBeat.o(194975);
        return;
      }
      AppMethodBeat.o(194975);
      return;
      AppMethodBeat.o(194975);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.h
 * JD-Core Version:    0.7.0.1
 */