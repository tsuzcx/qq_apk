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

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/VideoComposition;", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "(Ljava/util/List;)V", "origin", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "()V", "assetHeight", "", "assetWidth", "audioProcessorFactory", "Lcom/tencent/mm/videocomposition/audio/IAudioProcessorFactory;", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "checkPerformance", "", "effect", "Lcom/tencent/mm/videocomposition/render/VLogDirectorMultiVideoCompositionEffect;", "enableOriginAudio", "id", "getId", "()J", "setId", "(J)V", "isRevert", "outputCrop", "Landroid/graphics/Rect;", "playEnd", "getPlayEnd", "playFps", "", "playStart", "getPlayStart", "setEnd", "getSetEnd", "setSetEnd", "setStart", "getSetStart", "setSetStart", "sourceEnd", "getSourceEnd", "sourceStart", "getSourceStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/VLogEffectMgr;", "viewRect", "addTrack", "", "track", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildTrackChannel", "Lcom/tencent/tavkit/composition/TAVClip;", "createComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "enableVideoSound", "enable", "export", "path", "", "config", "Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "callback", "Lkotlin/Function2;", "progressCallback", "getAssetSize", "Landroid/util/Size;", "getDisplayScreenRect", "getDurationMs", "getOutputSize", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getRenderSize", "getSourceDuration", "getThumbBitmap", "widthLimit", "getTrackList", "isEnableOriginSound", "removeTrack", "setAssetSize", "width", "height", "setAudioProcessorFactory", "setBlendBitmapProvider", "setCheckPerformance", "check", "setDisplayScreenRect", "rect", "setOutputCrop", "setPlayFps", "fps", "setPlayRange", "start", "end", "setRenderSize", "setRevert", "revert", "setTrackList", "setVLogEffectMgr", "updateTrack", "index", "Companion", "VideoOutputConfig", "video_composition_release"})
public final class h
{
  public static final h.a LmU;
  public final ArrayList<b> BGl;
  private boolean BGm;
  public VLogEffectMgr BHr;
  private final long LmJ;
  public long LmK;
  public long LmL;
  public int LmM;
  public int LmN;
  public float LmO;
  public final Rect LmP;
  private com.tencent.mm.videocomposition.b.e LmQ;
  private com.tencent.mm.videocomposition.a.a LmR;
  public boolean LmS;
  private boolean LmT;
  private d.g.a.b<? super Long, Bitmap> hkY;
  private Rect viewRect;
  
  static
  {
    AppMethodBeat.i(220857);
    LmU = new h.a((byte)0);
    d locald = d.LmF;
    d.div();
    AppMethodBeat.o(220857);
  }
  
  public h()
  {
    AppMethodBeat.i(220856);
    this.LmK = -1L;
    this.LmL = -1L;
    this.viewRect = new Rect();
    this.LmO = 30.0F;
    this.LmP = new Rect();
    this.BGl = new ArrayList();
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "create VLogComposition", new Object[0]);
    AppMethodBeat.o(220856);
  }
  
  private long fPD()
  {
    AppMethodBeat.i(220841);
    Object localObject2 = (Iterable)this.BGl;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((b)localObject3).esL()) {
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
      l1 = ((b)localObject1).hiy;
      AppMethodBeat.o(220841);
      return l1;
      localObject1 = ((Iterator)localObject3).next();
    } while (!((Iterator)localObject3).hasNext());
    long l1 = ((b)localObject1).hiy;
    label164:
    localObject2 = ((Iterator)localObject3).next();
    long l2 = ((b)localObject2).hiy;
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
        AppMethodBeat.o(220841);
        return 0L;
      }
      break label164;
    }
  }
  
  private final TAVComposition iN(List<b> paramList)
  {
    AppMethodBeat.i(220848);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "createComposition: track size " + paramList.size(), new Object[0]);
    if (paramList.isEmpty())
    {
      paramList = new TAVComposition();
      AppMethodBeat.o(220848);
      return paramList;
    }
    TAVComposition localTAVComposition = new TAVComposition();
    Object localObject1 = (Iterable)paramList;
    Object localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", "add track type:" + localb.type + " startTime:" + localb.startTimeMs + ", endTime:" + localb.hiy + ", trackStartTime:" + localb.HCU + ", trackEndTime:" + localb.HCV, new Object[0]);
      Object localObject3;
      if (localb.type != 0)
      {
        localObject1 = new TAVClip(e.LmI.b(localb));
        ((TAVClip)localObject1).setStartTime(CMTime.fromMs(localb.startTimeMs));
        ((TAVClip)localObject1).setDuration(CMTime.fromMs(localb.hiy - localb.startTimeMs));
        localObject3 = ((TAVClip)localObject1).getResource();
        p.g(localObject3, "clip.resource");
        ((TAVResource)localObject3).setSourceTimeRange(new CMTimeRange(CMTime.fromMs(localb.HCU), CMTime.fromMs(localb.HCV - localb.HCU)));
        localObject3 = ((TAVClip)localObject1).getAudioConfiguration();
        p.g(localObject3, "clip.audioConfiguration");
        ((TAVAudioConfiguration)localObject3).setVolume(localb.volume);
        com.tencent.mm.videocomposition.c.b.i("CompositionTrack", localb.id + " buildClip buildVideoClip, path:" + localb.path + ", video startEnd:[" + localb.HCU + ", " + localb.HCV + "], material startEnd:[" + localb.startTimeMs + ", " + localb.hiy + "], volume: " + localb.volume, new Object[0]);
        label448:
        localObject3 = this.LmR;
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.videocomposition.a.a)localObject3).fPG();
          if (localObject3 != null) {
            ((TAVClip)localObject1).getAudioConfiguration().addAudioProcessorNode((TAVAudioProcessorNode)localObject3);
          }
        }
        ((TAVClip)localObject1).putExtraTrackInfo("key_extra_track", localb);
        if (localb.startTimeMs <= 0L) {
          break label633;
        }
        localObject3 = new TAVClip((TAVResource)new TAVEmptyResource(CMTime.fromMs(localb.startTimeMs)));
        ((TAVClip)localObject3).setStartTime(CMTime.fromMs(0L));
        ((TAVClip)localObject3).setDuration(CMTime.fromMs(localb.startTimeMs));
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "add front empty clip duration:" + localb.startTimeMs, new Object[0]);
      }
      label633:
      for (localObject1 = j.listOf(new TAVClip[] { localObject3, localObject1 });; localObject1 = j.listOf(localObject1))
      {
        ((Collection)localObject2).add(localObject1);
        break;
        localObject1 = new TAVClip((TAVResource)new TAVEmptyResource(CMTime.CMTimeZero));
        break label448;
      }
    }
    localObject1 = ((Iterable)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.gfB();
      }
      localObject2 = (List)localObject2;
      if (((b)paramList.get(i)).esL()) {
        localTAVComposition.addVideoChannel((List)localObject2);
      }
      if (((((b)paramList.get(i)).type == 2) && (this.BGm)) || (((b)paramList.get(i)).type == 3) || (((b)paramList.get(i)).type == 1)) {
        localTAVComposition.addAudioChannel((List)localObject2);
      }
      i += 1;
    }
    paramList = new StringBuilder("finish build composition, duration:");
    localObject1 = localTAVComposition.getDuration();
    p.g(localObject1, "composition.duration");
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", ((CMTime)localObject1).getTimeUs() / 1000L, new Object[0]);
    AppMethodBeat.o(220848);
    return localTAVComposition;
  }
  
  public final void E(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(220853);
    p.h(paramb, "blendBitmapProvider");
    this.hkY = paramb;
    AppMethodBeat.o(220853);
  }
  
  public final void ar(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220846);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']', new Object[0]);
    this.LmK = paramLong1;
    this.LmL = paramLong2;
    AppMethodBeat.o(220846);
  }
  
  public final TAVSource buildSource()
  {
    AppMethodBeat.i(220854);
    Object localObject1 = iN((List)this.BGl);
    Object localObject2 = new com.tencent.mm.videocomposition.b.e();
    this.LmQ = ((com.tencent.mm.videocomposition.b.e)localObject2);
    long l2 = System.currentTimeMillis();
    Object localObject3 = this.BHr;
    if (localObject3 != null) {
      ((VLogEffectMgr)localObject3).fSr();
    }
    int j = this.BGl.size();
    int i = 1;
    if (i < j)
    {
      localObject3 = this.BGl.get(i - 1);
      p.g(localObject3, "trackList[i - 1]");
      localObject3 = (b)localObject3;
      Object localObject4 = this.BGl.get(i);
      p.g(localObject4, "trackList[i]");
      localObject4 = (b)localObject4;
      g localg = ((b)localObject4).LmB;
      VLogEffectMgr localVLogEffectMgr;
      if (localg.isValid()) {
        if (localg.xPg == 0L)
        {
          localVLogEffectMgr = this.BHr;
          if (localVLogEffectMgr == null) {
            break label236;
          }
        }
      }
      label236:
      for (long l1 = localVLogEffectMgr.a(VLogEffectMgr.a.LBm, localg.path);; l1 = 0L)
      {
        localg.xPg = l1;
        localVLogEffectMgr = this.BHr;
        if (localVLogEffectMgr != null) {
          localVLogEffectMgr.a(((b)localObject4).startTimeMs, ((b)localObject3).hiy, localg.xPg, new long[] { ((b)localObject3).id, ((b)localObject4).id });
        }
        i += 1;
        break;
      }
    }
    new StringBuilder("buildSource: update transition cost ").append(System.currentTimeMillis() - l2);
    ((com.tencent.mm.videocomposition.b.e)localObject2).kt(this.LmM, this.LmN);
    ((com.tencent.mm.videocomposition.b.e)localObject2).b(this.BHr);
    ((com.tencent.mm.videocomposition.b.e)localObject2).p(this.LmP);
    ((com.tencent.mm.videocomposition.b.e)localObject2).LmT = this.LmT;
    localObject3 = this.hkY;
    if (localObject3 != null) {
      ((com.tencent.mm.videocomposition.b.e)localObject2).E((d.g.a.b)localObject3);
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
      AppMethodBeat.o(220854);
      throw ((Throwable)localObject1);
    }
    ((MutableVideoComposition)localObject2).setFrameDuration(new CMTime(1000L, (int)(this.LmO * 1000.0F)));
    AppMethodBeat.o(220854);
    return localObject1;
  }
  
  public final void d(b paramb)
  {
    AppMethodBeat.i(220843);
    p.h(paramb, "track");
    this.BGl.add(paramb);
    AppMethodBeat.o(220843);
  }
  
  public final long esa()
  {
    AppMethodBeat.i(220842);
    if (this.LmL >= 0L)
    {
      l = this.LmL;
      AppMethodBeat.o(220842);
      return l;
    }
    long l = fPD();
    AppMethodBeat.o(220842);
    return l;
  }
  
  public final CMTimeRange esb()
  {
    AppMethodBeat.i(220847);
    CMTimeRange localCMTimeRange = CMTimeRange.fromMs(getPlayStart(), esa() - getPlayStart());
    p.g(localCMTimeRange, "CMTimeRange.fromMs(playStart, playEnd - playStart)");
    AppMethodBeat.o(220847);
    return localCMTimeRange;
  }
  
  public final long fPE()
  {
    AppMethodBeat.i(220845);
    long l1 = fPD();
    long l2 = this.LmJ;
    AppMethodBeat.o(220845);
    return l1 - l2;
  }
  
  public final Size fPF()
  {
    AppMethodBeat.i(220850);
    Size localSize = new Size(this.LmM, this.LmN);
    AppMethodBeat.o(220850);
    return localSize;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(220844);
    long l1 = esa();
    long l2 = getPlayStart();
    AppMethodBeat.o(220844);
    return l1 - l2;
  }
  
  public final long getPlayStart()
  {
    if (this.LmK >= 0L) {
      return this.LmK;
    }
    return this.LmJ;
  }
  
  public final void ks(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220849);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setAssetSize: " + paramInt1 + ", " + paramInt2, new Object[0]);
    this.LmM = paramInt1;
    this.LmN = paramInt2;
    com.tencent.mm.videocomposition.b.e locale = this.LmQ;
    if (locale != null) {
      locale.kt(paramInt1, paramInt2);
    }
    this.viewRect.set(0, 0, paramInt1, paramInt2);
    AppMethodBeat.o(220849);
  }
  
  public final void p(Rect paramRect)
  {
    AppMethodBeat.i(220851);
    p.h(paramRect, "rect");
    this.LmP.set(paramRect);
    AppMethodBeat.o(220851);
  }
  
  public final void sQ(boolean paramBoolean)
  {
    AppMethodBeat.i(220852);
    com.tencent.mm.videocomposition.c.b.i("VideoComposition", "enableVideoSound:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.BGm = paramBoolean;
    AppMethodBeat.o(220852);
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"<anonymous>", "", "assetExportSession", "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "handlerCallback"})
  static final class c
    implements AssetExportSession.ExportCallbackHandler
  {
    c(d.g.a.b paramb, long paramLong, m paramm) {}
    
    public final void handlerCallback(AssetExportSession paramAssetExportSession)
    {
      AppMethodBeat.i(220839);
      p.g(paramAssetExportSession, "assetExportSession");
      AssetExportSession.AssetExportSessionStatus localAssetExportSessionStatus = paramAssetExportSession.getStatus();
      int i = paramAssetExportSession.getErrCode();
      float f = paramAssetExportSession.getProgress();
      if (localAssetExportSessionStatus == null) {}
      for (;;)
      {
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export failed other status:" + localAssetExportSessionStatus + ", progress:" + f, new Object[0]);
        paramAssetExportSession = this.mju;
        if (paramAssetExportSession == null) {
          break;
        }
        paramAssetExportSession.p(Boolean.FALSE, Integer.valueOf(i));
        AppMethodBeat.o(220839);
        return;
        switch (i.cpQ[localAssetExportSessionStatus.ordinal()])
        {
        }
      }
      paramAssetExportSession = this.LmX;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.invoke(Float.valueOf(f));
        AppMethodBeat.o(220839);
        return;
      }
      AppMethodBeat.o(220839);
      return;
      paramAssetExportSession = new StringBuilder("export completed: ").append(f).append(", cost:");
      long l = this.snG;
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", SystemClock.elapsedRealtime() - l, new Object[0]);
      paramAssetExportSession = this.mju;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.p(Boolean.TRUE, Integer.valueOf(i));
        AppMethodBeat.o(220839);
        return;
      }
      AppMethodBeat.o(220839);
      return;
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export failed: status:" + localAssetExportSessionStatus + ", progress:" + f, new Object[0]);
      paramAssetExportSession = this.mju;
      if (paramAssetExportSession != null)
      {
        paramAssetExportSession.p(Boolean.FALSE, Integer.valueOf(i));
        AppMethodBeat.o(220839);
        return;
      }
      AppMethodBeat.o(220839);
      return;
      AppMethodBeat.o(220839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.h
 * JD-Core Version:    0.7.0.1
 */