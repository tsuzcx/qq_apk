package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.resource.TAVResource;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/CompositionTrack;", "", "path", "", "type", "", "(Ljava/lang/String;I)V", "autoCenterCrop", "", "getAutoCenterCrop", "()Z", "setAutoCenterCrop", "(Z)V", "cropRect", "Landroid/graphics/Rect;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "durationMs", "", "getDurationMs", "()J", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "endWithTransition", "getEndWithTransition", "setEndWithTransition", "id", "getId", "setId", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "rotate", "getRotate", "()I", "setRotate", "(I)V", "sourceDuration", "getSourceDuration", "setSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "startWithTransition", "getStartWithTransition", "setStartWithTransition", "trackCropRect", "getTrackCropRect", "setTrackCropRect", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "getTransition", "()Lcom/tencent/mm/videocomposition/TrackTransition;", "setTransition", "(Lcom/tencent/mm/videocomposition/TrackTransition;)V", "getType", "setType", "volume", "getVolume", "setVolume", "buildClip", "Lcom/tencent/tavkit/composition/TAVClip;", "enableOriginAudio", "buildComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildVideoClip", "getResource", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "hasAudio", "hasVideo", "initImageClipInfo", "", "bitmap", "Landroid/graphics/Bitmap;", "initVideoClipInfo", "updateTime", "Companion", "video_composition_release"})
public final class b
{
  public static final a LJo;
  public int BXQ;
  public int BXR;
  public long Cec;
  public long HWH;
  public long HWI;
  public Rect LJj;
  public boolean LJk;
  public g LJl;
  public long LJm;
  public long LJn;
  public int dHi;
  public long hlm;
  public Rect hpa;
  public long id;
  public float lqb;
  String path;
  public long startTimeMs;
  int type;
  public float volume;
  
  static
  {
    AppMethodBeat.i(194953);
    LJo = new a((byte)0);
    AppMethodBeat.o(194953);
  }
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(194952);
    this.path = paramString;
    this.type = paramInt;
    this.lqb = 1.0F;
    this.volume = 1.0F;
    this.hpa = new Rect();
    this.LJj = new Rect();
    this.LJk = true;
    this.LJl = new g();
    com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "create VCLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id, new Object[0]);
    String str;
    switch (this.type)
    {
    default: 
      paramString = e.LJs.b(this).getDuration();
      p.g(paramString, "getResource().duration");
      this.Cec = (paramString.getTimeUs() / 1000L);
      BI(0L);
      BJ(this.Cec);
      BH(this.HWI);
      AppMethodBeat.o(194952);
      return;
    case 2: 
    case 3: 
      str = this.path;
      paramString = new MediaMetadataRetriever();
    }
    for (;;)
    {
      int i;
      try
      {
        paramString.setDataSource(str);
        str = paramString.extractMetadata(18);
        if (str != null)
        {
          paramInt = Integer.parseInt(str);
          str = paramString.extractMetadata(19);
          if (str == null) {
            continue;
          }
          i = Integer.parseInt(str);
          str = paramString.extractMetadata(24);
          if (str == null) {
            break label516;
          }
          j = Integer.parseInt(str);
          break label516;
          this.BXQ = i;
          this.BXR = paramInt;
          com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "initVideoClipInfo, sourceWidth:" + this.BXQ + ", sourceHeight:" + this.BXR, new Object[0]);
          paramString.release();
          break;
        }
        paramInt = 0;
        continue;
        i = 0;
        continue;
      }
      catch (Exception localException)
      {
        com.tencent.mm.videocomposition.c.b.printErrStackTrace("CompositionTrack", (Throwable)localException, "initVideoClipInfo error:" + localException.getMessage(), new Object[0]);
        paramString.release();
        break;
      }
      finally
      {
        paramString.release();
        AppMethodBeat.o(194952);
      }
      e.LJs.b(this);
      paramString = e.LJs.c(this);
      if (paramString == null) {
        break;
      }
      this.BXQ = paramString.getWidth();
      this.BXR = paramString.getHeight();
      com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "initImageClipInfo sourceWidth:" + this.BXQ + ", sourceHeight:" + this.BXR, new Object[0]);
      break;
      label516:
      do
      {
        j = paramInt;
        paramInt = i;
        i = j;
        break;
      } while ((j != 270) && (j != 90));
    }
  }
  
  public final void BG(long paramLong)
  {
    if (paramLong >= 0L) {
      this.startTimeMs = paramLong;
    }
  }
  
  public final void BH(long paramLong)
  {
    if (paramLong >= 0L) {
      this.hlm = paramLong;
    }
  }
  
  public final void BI(long paramLong)
  {
    if (paramLong >= 0L) {
      this.HWH = paramLong;
    }
  }
  
  public final void BJ(long paramLong)
  {
    if (paramLong >= 0L) {
      this.HWI = paramLong;
    }
  }
  
  public final boolean ews()
  {
    return (this.type == 1) || (this.type == 2);
  }
  
  public final void fCr()
  {
    AppMethodBeat.i(194951);
    BH(((float)this.startTimeMs + (float)(this.HWI - this.HWH) / this.lqb));
    AppMethodBeat.o(194951);
  }
  
  public final g fTV()
  {
    return this.LJl;
  }
  
  public final TAVSource fTW()
  {
    AppMethodBeat.i(194950);
    Object localObject1 = new TAVClip(e.LJs.b(this));
    Object localObject2 = ((TAVClip)localObject1).getVideoConfiguration();
    p.g(localObject2, "clip.videoConfiguration");
    ((TAVVideoConfiguration)localObject2).setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localObject2 = new TAVComposition();
    ((TAVComposition)localObject2).addVideoChannel(j.listOf(localObject1));
    localObject1 = new TAVCompositionBuilder((TAVComposition)localObject2);
    ((TAVCompositionBuilder)localObject1).setReloadChannels(false);
    localObject1 = ((TAVCompositionBuilder)localObject1).buildSource();
    p.g(localObject1, "builder.buildSource()");
    AppMethodBeat.o(194950);
    return localObject1;
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.lqb = paramFloat;
    }
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/CompositionTrack$Companion;", "", "()V", "TAG", "", "TypeAudio", "", "TypeImage", "TypeUnknown", "TypeVideo", "makeChain", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "video_composition_release"})
  public static final class a
  {
    public static void iW(List<b> paramList)
    {
      AppMethodBeat.i(194949);
      p.h(paramList, "trackList");
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(194949);
        return;
      }
      long l2 = 0L;
      Object localObject = null;
      Iterator localIterator = ((Iterable)paramList).iterator();
      long l1 = 0L;
      if (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        long l4 = ((float)(localb.HWI - localb.HWH) / localb.lqb);
        if (localb.LJl.isValid()) {}
        for (long l3 = localb.LJl.duration;; l3 = 0L)
        {
          l2 = Math.min(l3, Math.min(l2, l4));
          if (localObject != null) {
            localObject.LJn = (l1 - l2 / 2L);
          }
          localb.LJm = (l1 - l2 / 2L);
          localb.BG(l1 - l2);
          localb.BH(localb.startTimeMs + l4);
          l1 = localb.hlm;
          localObject = localb;
          l2 = l4;
          break;
        }
      }
      paramList = (b)j.jn(paramList);
      paramList.LJn = paramList.hlm;
      AppMethodBeat.o(194949);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b
 * JD-Core Version:    0.7.0.1
 */