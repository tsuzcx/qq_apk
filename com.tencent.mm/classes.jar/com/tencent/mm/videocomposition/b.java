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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/CompositionTrack;", "", "path", "", "type", "", "(Ljava/lang/String;I)V", "autoCenterCrop", "", "getAutoCenterCrop", "()Z", "setAutoCenterCrop", "(Z)V", "cropRect", "Landroid/graphics/Rect;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "durationMs", "", "getDurationMs", "()J", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "endWithTransition", "getEndWithTransition", "setEndWithTransition", "id", "getId", "setId", "internalClip", "Lcom/tencent/tavkit/composition/TAVClip;", "internalEnableOriginAudio", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "rotate", "getRotate", "()I", "setRotate", "(I)V", "sourceDuration", "getSourceDuration", "setSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "startWithTransition", "getStartWithTransition", "setStartWithTransition", "trackCropRect", "getTrackCropRect", "setTrackCropRect", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "getTransition", "()Lcom/tencent/mm/videocomposition/TrackTransition;", "setTransition", "(Lcom/tencent/mm/videocomposition/TrackTransition;)V", "getType", "setType", "volume", "getVolume", "setVolume", "buildClip", "enableOriginAudio", "buildComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildVideoClip", "getResource", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "hasAudio", "hasVideo", "initImageClipInfo", "", "bitmap", "Landroid/graphics/Bitmap;", "initVideoClipInfo", "updateTime", "Companion", "video_composition_release"})
public final class b
{
  public static final a YHY;
  public long MQV;
  public long MQW;
  public g MQX;
  public int Nna;
  public int Nnb;
  public long NwS;
  public Rect YHS;
  public boolean YHT;
  public long YHU;
  public long YHV;
  private boolean YHW;
  TAVClip YHX;
  public long endTimeMs;
  public int fSM;
  public long id;
  public Rect kXj;
  public String path;
  public float pvh;
  public long startTimeMs;
  public int type;
  public float volume;
  
  static
  {
    AppMethodBeat.i(247924);
    YHY = new a((byte)0);
    AppMethodBeat.o(247924);
  }
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(247923);
    this.path = paramString;
    this.type = paramInt;
    this.pvh = 1.0F;
    this.volume = 1.0F;
    this.kXj = new Rect();
    this.YHS = new Rect();
    this.YHT = true;
    this.MQX = new g();
    this.YHW = true;
    com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "create VCLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id, new Object[0]);
    switch (this.type)
    {
    }
    for (;;)
    {
      paramString = e.YIc.e(this).getDuration();
      p.j(paramString, "getResource().duration");
      this.NwS = (paramString.getTimeUs() / 1000L);
      Sn(0L);
      So(this.NwS);
      Sm(this.MQW);
      AppMethodBeat.o(247923);
      return;
      paramString = this.path;
      paramString = e.YIc.bCf(paramString);
      if (paramString != null)
      {
        this.Nna = paramString.width;
        this.Nnb = paramString.height;
        com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "initVideoClipInfo, sourceWidth:" + this.Nna + ", sourceHeight:" + this.Nnb, new Object[0]);
      }
      else
      {
        com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "initVideoClipInfo failed", new Object[0]);
        continue;
        e.YIc.e(this);
        paramString = e.YIc.f(this);
        if (paramString != null)
        {
          this.Nna = paramString.getWidth();
          this.Nnb = paramString.getHeight();
          com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "initImageClipInfo sourceWidth:" + this.Nna + ", sourceHeight:" + this.Nnb, new Object[0]);
        }
      }
    }
  }
  
  public final void A(Rect paramRect)
  {
    AppMethodBeat.i(247917);
    p.k(paramRect, "<set-?>");
    this.YHS = paramRect;
    AppMethodBeat.o(247917);
  }
  
  public final void Sl(long paramLong)
  {
    if (paramLong >= 0L) {
      this.startTimeMs = paramLong;
    }
  }
  
  public final void Sm(long paramLong)
  {
    if (paramLong >= 0L) {
      this.endTimeMs = paramLong;
    }
  }
  
  public final void Sn(long paramLong)
  {
    if (paramLong >= 0L) {
      this.MQV = paramLong;
    }
  }
  
  public final void So(long paramLong)
  {
    if (paramLong >= 0L) {
      this.MQW = paramLong;
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(247920);
    p.k(paramg, "<set-?>");
    this.MQX = paramg;
    AppMethodBeat.o(247920);
  }
  
  public final long getDurationMs()
  {
    return this.endTimeMs - this.startTimeMs;
  }
  
  public final boolean guq()
  {
    return (this.type == 1) || (this.type == 2);
  }
  
  public final TAVSource igB()
  {
    AppMethodBeat.i(247921);
    Object localObject1 = new TAVClip(e.YIc.e(this));
    Object localObject2 = ((TAVClip)localObject1).getVideoConfiguration();
    p.j(localObject2, "clip.videoConfiguration");
    ((TAVVideoConfiguration)localObject2).setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localObject2 = new TAVComposition();
    ((TAVComposition)localObject2).addVideoChannel(j.listOf(localObject1));
    localObject1 = new TAVCompositionBuilder((TAVComposition)localObject2);
    ((TAVCompositionBuilder)localObject1).setReloadChannels(false);
    localObject1 = ((TAVCompositionBuilder)localObject1).buildSource();
    p.j(localObject1, "builder.buildSource()");
    AppMethodBeat.o(247921);
    return localObject1;
  }
  
  public final void igC()
  {
    AppMethodBeat.i(247922);
    Sm(((float)this.startTimeMs + (float)(this.MQW - this.MQV) / this.pvh));
    AppMethodBeat.o(247922);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(247915);
    p.k(paramRect, "<set-?>");
    this.kXj = paramRect;
    AppMethodBeat.o(247915);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.pvh = paramFloat;
    }
  }
  
  public final void setVolume(float paramFloat)
  {
    AppMethodBeat.i(247914);
    this.volume = paramFloat;
    if ((this.type != 2) || (this.YHW))
    {
      Object localObject = this.YHX;
      if (localObject != null)
      {
        localObject = ((TAVClip)localObject).getAudioConfiguration();
        if (localObject != null)
        {
          ((TAVAudioConfiguration)localObject).setVolume(paramFloat);
          AppMethodBeat.o(247914);
          return;
        }
      }
    }
    AppMethodBeat.o(247914);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/CompositionTrack$Companion;", "", "()V", "TAG", "", "TypeAudio", "", "TypeImage", "TypeUnknown", "TypeVideo", "makeChain", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "video_composition_release"})
  public static final class a
  {
    public static void iK(List<b> paramList)
    {
      AppMethodBeat.i(247908);
      p.k(paramList, "trackList");
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(247908);
        return;
      }
      long l2 = 0L;
      Object localObject = null;
      Iterator localIterator = ((Iterable)paramList).iterator();
      long l1 = 0L;
      if (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        long l4 = ((float)(localb.MQW - localb.MQV) / localb.pvh);
        if (localb.MQX.isValid()) {}
        for (long l3 = localb.MQX.duration;; l3 = 0L)
        {
          l2 = Math.min(l3, Math.min(l2, l4));
          if (localObject != null) {
            localObject.YHV = (l1 - l2 / 2L);
          }
          localb.YHU = (l1 - l2 / 2L);
          localb.Sl(l1 - l2);
          localb.Sm(localb.startTimeMs + l4);
          l1 = localb.endTimeMs;
          localObject = localb;
          l2 = l4;
          break;
        }
      }
      paramList = (b)j.lq(paramList);
      paramList.YHV = paramList.endTimeMs;
      AppMethodBeat.o(247908);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b
 * JD-Core Version:    0.7.0.1
 */