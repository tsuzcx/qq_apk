package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.resource.TAVResource;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/CompositionTrack;", "", "path", "", "type", "", "(Ljava/lang/String;I)V", "autoCenterCrop", "", "getAutoCenterCrop", "()Z", "setAutoCenterCrop", "(Z)V", "cropRect", "Landroid/graphics/Rect;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "durationMs", "", "getDurationMs", "()J", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "endWithTransition", "getEndWithTransition", "setEndWithTransition", "id", "getId", "setId", "internalClip", "Lcom/tencent/tavkit/composition/TAVClip;", "internalEnableOriginAudio", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "rotate", "getRotate", "()I", "setRotate", "(I)V", "sourceDuration", "getSourceDuration", "setSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "startWithTransition", "getStartWithTransition", "setStartWithTransition", "trackCropRect", "getTrackCropRect", "setTrackCropRect", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "getTransition", "()Lcom/tencent/mm/videocomposition/TrackTransition;", "setTransition", "(Lcom/tencent/mm/videocomposition/TrackTransition;)V", "getType", "setType", "volume", "getVolume", "setVolume", "buildClip", "enableOriginAudio", "buildComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildVideoClip", "getResource", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "hasAudio", "hasVideo", "initImageClipInfo", "", "bitmap", "Landroid/graphics/Bitmap;", "initVideoClipInfo", "updateTime", "Companion", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class b
{
  public static final a agDF;
  public Rect Gl;
  public long TDw;
  public long TDx;
  public g TDy;
  public int UaC;
  public int UaD;
  public long UjZ;
  public boolean agDA;
  public long agDB;
  public long agDC;
  private boolean agDD;
  TAVClip agDE;
  public Rect agDz;
  public long endTimeMs;
  public int hYK;
  public long id;
  public String path;
  public float sAn;
  public long startTimeMs;
  public int type;
  public float volume;
  
  static
  {
    AppMethodBeat.i(233516);
    agDF = new a((byte)0);
    AppMethodBeat.o(233516);
  }
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(233509);
    this.path = paramString;
    this.type = paramInt;
    this.sAn = 1.0F;
    this.volume = 1.0F;
    this.Gl = new Rect();
    this.agDz = new Rect();
    this.agDA = true;
    this.TDy = new g();
    this.agDD = true;
    com.tencent.mm.videocomposition.d.b.i("CompositionTrack", "create VCLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id, new Object[0]);
    switch (this.type)
    {
    }
    for (;;)
    {
      paramString = e.agDJ.e(this).getDuration();
      s.r(paramString, "getResource().duration");
      this.UjZ = (paramString.getTimeUs() / 1000L);
      wB(0L);
      wC(this.UjZ);
      wA(this.TDx);
      AppMethodBeat.o(233509);
      return;
      paramString = this.path;
      paramString = e.agDJ.bEy(paramString);
      if (paramString != null)
      {
        this.UaC = paramString.width;
        this.UaD = paramString.height;
        com.tencent.mm.videocomposition.d.b.i("CompositionTrack", "initVideoClipInfo, sourceWidth:" + this.UaC + ", sourceHeight:" + this.UaD, new Object[0]);
      }
      else
      {
        com.tencent.mm.videocomposition.d.b.i("CompositionTrack", "initVideoClipInfo failed", new Object[0]);
        continue;
        e.agDJ.e(this);
        paramString = e.agDJ.f(this);
        if (paramString != null)
        {
          this.UaC = paramString.getWidth();
          this.UaD = paramString.getHeight();
          com.tencent.mm.videocomposition.d.b.i("CompositionTrack", "initImageClipInfo sourceWidth:" + this.UaC + ", sourceHeight:" + this.UaD, new Object[0]);
        }
      }
    }
  }
  
  public final void I(Rect paramRect)
  {
    AppMethodBeat.i(233555);
    s.t(paramRect, "<set-?>");
    this.agDz = paramRect;
    AppMethodBeat.o(233555);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(233564);
    s.t(paramg, "<set-?>");
    this.TDy = paramg;
    AppMethodBeat.o(233564);
  }
  
  public final long getDurationMs()
  {
    return this.endTimeMs - this.startTimeMs;
  }
  
  public final boolean hSf()
  {
    return (this.type == 1) || (this.type == 2);
  }
  
  public final g jLO()
  {
    return this.TDy;
  }
  
  public final TAVSource jLP()
  {
    AppMethodBeat.i(233572);
    Object localObject1 = new TAVClip(e.agDJ.e(this));
    Object localObject2 = ((TAVClip)localObject1).getVideoConfiguration();
    s.r(localObject2, "clip.videoConfiguration");
    ((TAVVideoConfiguration)localObject2).setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localObject2 = new TAVComposition();
    ((TAVComposition)localObject2).addVideoChannel(p.listOf(localObject1));
    localObject1 = new TAVCompositionBuilder((TAVComposition)localObject2);
    ((TAVCompositionBuilder)localObject1).setReloadChannels(false);
    localObject1 = ((TAVCompositionBuilder)localObject1).buildSource();
    s.r(localObject1, "builder.buildSource()");
    AppMethodBeat.o(233572);
    return localObject1;
  }
  
  public final void jLQ()
  {
    AppMethodBeat.i(233578);
    wA(((float)this.startTimeMs + (float)(this.TDx - this.TDw) / this.sAn));
    AppMethodBeat.o(233578);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(233549);
    s.t(paramRect, "<set-?>");
    this.Gl = paramRect;
    AppMethodBeat.o(233549);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.sAn = paramFloat;
    }
  }
  
  public final void setStartTimeMs(long paramLong)
  {
    if (paramLong >= 0L) {
      this.startTimeMs = paramLong;
    }
  }
  
  public final void setVolume(float paramFloat)
  {
    AppMethodBeat.i(233544);
    this.volume = paramFloat;
    if ((this.type != 2) || (this.agDD))
    {
      Object localObject = this.agDE;
      if (localObject != null)
      {
        localObject = ((TAVClip)localObject).getAudioConfiguration();
        if (localObject != null)
        {
          ((TAVAudioConfiguration)localObject).setVolume(paramFloat);
          AppMethodBeat.o(233544);
          return;
        }
      }
    }
    AppMethodBeat.o(233544);
  }
  
  public final void wA(long paramLong)
  {
    if (paramLong >= 0L) {
      this.endTimeMs = paramLong;
    }
  }
  
  public final void wB(long paramLong)
  {
    if (paramLong >= 0L) {
      this.TDw = paramLong;
    }
  }
  
  public final void wC(long paramLong)
  {
    if (paramLong >= 0L) {
      this.TDx = paramLong;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/CompositionTrack$Companion;", "", "()V", "TAG", "", "TypeAudio", "", "TypeImage", "TypeUnknown", "TypeVideo", "makeChain", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static final class a
  {
    public static void lS(List<b> paramList)
    {
      AppMethodBeat.i(233456);
      s.t(paramList, "trackList");
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(233456);
        return;
      }
      long l2 = 0L;
      Object localObject = null;
      Iterator localIterator = ((Iterable)paramList).iterator();
      long l1 = 0L;
      if (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        long l4 = ((float)(localb.TDx - localb.TDw) / localb.sAn);
        if (localb.TDy.isValid()) {}
        for (long l3 = localb.TDy.duration;; l3 = 0L)
        {
          l2 = Math.min(l3, Math.min(l2, l4));
          if (localObject != null) {
            localObject.agDC = (l1 - l2 / 2L);
          }
          localb.agDB = (l1 - l2 / 2L);
          localb.setStartTimeMs(l1 - l2);
          localb.wA(localb.startTimeMs + l4);
          l1 = localb.endTimeMs;
          localObject = localb;
          l2 = l4;
          break;
        }
      }
      paramList = (b)p.oM(paramList);
      paramList.agDC = paramList.endTimeMs;
      AppMethodBeat.o(233456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b
 * JD-Core Version:    0.7.0.1
 */