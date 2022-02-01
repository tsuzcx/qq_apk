package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.resource.TAVResource;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/CompositionTrack;", "", "path", "", "type", "", "(Ljava/lang/String;I)V", "autoCenterCrop", "", "getAutoCenterCrop", "()Z", "setAutoCenterCrop", "(Z)V", "cropRect", "Landroid/graphics/Rect;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "durationMs", "", "getDurationMs", "()J", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "endWithTransition", "getEndWithTransition", "setEndWithTransition", "id", "getId", "setId", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "rotate", "getRotate", "()I", "setRotate", "(I)V", "sourceDuration", "getSourceDuration", "setSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "startWithTransition", "getStartWithTransition", "setStartWithTransition", "trackCropRect", "getTrackCropRect", "setTrackCropRect", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "getTransition", "()Lcom/tencent/mm/videocomposition/TrackTransition;", "setTransition", "(Lcom/tencent/mm/videocomposition/TrackTransition;)V", "getType", "setType", "volume", "getVolume", "setVolume", "buildClip", "Lcom/tencent/tavkit/composition/TAVClip;", "enableOriginAudio", "buildComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildVideoClip", "getResource", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "hasAudio", "hasVideo", "initImageClipInfo", "", "bitmap", "Landroid/graphics/Bitmap;", "initVideoClipInfo", "updateTime", "Companion", "video_composition_release"})
public final class d
{
  public static final a Rhf;
  public long GGA;
  public long GGz;
  public long GJB;
  public int Gzu;
  public int Gzv;
  public Rect Rha;
  public boolean Rhb;
  public k Rhc;
  public long Rhd;
  public long Rhe;
  public int dYT;
  public long endTimeMs;
  public long id;
  public Rect iiw;
  public float mwH;
  public String path;
  public long startTimeMs;
  public int type;
  public float volume;
  
  static
  {
    AppMethodBeat.i(216744);
    Rhf = new a((byte)0);
    AppMethodBeat.o(216744);
  }
  
  public d(String paramString, int paramInt)
  {
    AppMethodBeat.i(216743);
    this.path = paramString;
    this.type = paramInt;
    this.mwH = 1.0F;
    this.volume = 1.0F;
    this.iiw = new Rect();
    this.Rha = new Rect();
    this.Rhb = true;
    this.Rhc = new k();
    b.i("CompositionTrack", "create VCLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id, new Object[0]);
    switch (this.type)
    {
    }
    for (;;)
    {
      paramString = i.Rhj.c(this).getDuration();
      p.g(paramString, "getResource().duration");
      this.GJB = (paramString.getTimeUs() / 1000L);
      KQ(0L);
      KR(this.GJB);
      KP(this.GGA);
      AppMethodBeat.o(216743);
      return;
      paramString = this.path;
      paramString = i.Rhj.bpj(paramString);
      if (paramString != null)
      {
        this.Gzu = paramString.width;
        this.Gzv = paramString.height;
        b.i("CompositionTrack", "initVideoClipInfo, sourceWidth:" + this.Gzu + ", sourceHeight:" + this.Gzv, new Object[0]);
      }
      else
      {
        b.i("CompositionTrack", "initVideoClipInfo failed", new Object[0]);
        continue;
        i.Rhj.c(this);
        paramString = i.Rhj.d(this);
        if (paramString != null)
        {
          this.Gzu = paramString.getWidth();
          this.Gzv = paramString.getHeight();
          b.i("CompositionTrack", "initImageClipInfo sourceWidth:" + this.Gzu + ", sourceHeight:" + this.Gzv, new Object[0]);
        }
      }
    }
  }
  
  public final void KO(long paramLong)
  {
    if (paramLong >= 0L) {
      this.startTimeMs = paramLong;
    }
  }
  
  public final void KP(long paramLong)
  {
    if (paramLong >= 0L) {
      this.endTimeMs = paramLong;
    }
  }
  
  public final void KQ(long paramLong)
  {
    if (paramLong >= 0L) {
      this.GGz = paramLong;
    }
  }
  
  public final void KR(long paramLong)
  {
    if (paramLong >= 0L) {
      this.GGA = paramLong;
    }
  }
  
  public final boolean fCr()
  {
    return (this.type == 1) || (this.type == 2);
  }
  
  public final void gKp()
  {
    AppMethodBeat.i(216742);
    KP(((float)this.startTimeMs + (float)(this.GGA - this.GGz) / this.mwH));
    AppMethodBeat.o(216742);
  }
  
  public final long getDurationMs()
  {
    return this.endTimeMs - this.startTimeMs;
  }
  
  public final TAVSource hfj()
  {
    AppMethodBeat.i(216741);
    Object localObject1 = new TAVClip(i.Rhj.c(this));
    Object localObject2 = ((TAVClip)localObject1).getVideoConfiguration();
    p.g(localObject2, "clip.videoConfiguration");
    ((TAVVideoConfiguration)localObject2).setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localObject2 = new TAVComposition();
    ((TAVComposition)localObject2).addVideoChannel(j.listOf(localObject1));
    localObject1 = new TAVCompositionBuilder((TAVComposition)localObject2);
    ((TAVCompositionBuilder)localObject1).setReloadChannels(false);
    localObject1 = ((TAVCompositionBuilder)localObject1).buildSource();
    p.g(localObject1, "builder.buildSource()");
    AppMethodBeat.o(216741);
    return localObject1;
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.mwH = paramFloat;
    }
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/CompositionTrack$Companion;", "", "()V", "TAG", "", "TypeAudio", "", "TypeImage", "TypeUnknown", "TypeVideo", "makeChain", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "video_composition_release"})
  public static final class a
  {
    public static void jZ(List<d> paramList)
    {
      AppMethodBeat.i(216740);
      p.h(paramList, "trackList");
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(216740);
        return;
      }
      long l2 = 0L;
      Object localObject = null;
      Iterator localIterator = ((Iterable)paramList).iterator();
      long l1 = 0L;
      if (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        long l4 = ((float)(locald.GGA - locald.GGz) / locald.mwH);
        if (locald.Rhc.isValid()) {}
        for (long l3 = locald.Rhc.duration;; l3 = 0L)
        {
          l2 = Math.min(l3, Math.min(l2, l4));
          if (localObject != null) {
            localObject.Rhe = (l1 - l2 / 2L);
          }
          locald.Rhd = (l1 - l2 / 2L);
          locald.KO(l1 - l2);
          locald.KP(locald.startTimeMs + l4);
          l1 = locald.endTimeMs;
          localObject = locald;
          l2 = l4;
          break;
        }
      }
      paramList = (d)j.ku(paramList);
      paramList.Rhe = paramList.endTimeMs;
      AppMethodBeat.o(216740);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.d
 * JD-Core Version:    0.7.0.1
 */