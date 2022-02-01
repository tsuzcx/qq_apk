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

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/CompositionTrack;", "", "path", "", "type", "", "(Ljava/lang/String;I)V", "autoCenterCrop", "", "getAutoCenterCrop", "()Z", "setAutoCenterCrop", "(Z)V", "cropRect", "Landroid/graphics/Rect;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "durationMs", "", "getDurationMs", "()J", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "endWithTransition", "getEndWithTransition", "setEndWithTransition", "id", "getId", "setId", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "rotate", "getRotate", "()I", "setRotate", "(I)V", "sourceDuration", "getSourceDuration", "setSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "startWithTransition", "getStartWithTransition", "setStartWithTransition", "trackCropRect", "getTrackCropRect", "setTrackCropRect", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "getTransition", "()Lcom/tencent/mm/videocomposition/TrackTransition;", "setTransition", "(Lcom/tencent/mm/videocomposition/TrackTransition;)V", "getType", "setType", "volume", "getVolume", "setVolume", "buildClip", "Lcom/tencent/tavkit/composition/TAVClip;", "buildComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildVideoClip", "getResource", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "hasAudio", "hasVideo", "initImageClipInfo", "", "bitmap", "Landroid/graphics/Bitmap;", "initVideoClipInfo", "updateTime", "Companion", "video_composition_release"})
public final class b
{
  public static final b.a LmE;
  public int BGr;
  public int BGs;
  public long BMD;
  public long HCU;
  public long HCV;
  public boolean LmA;
  public g LmB;
  public long LmC;
  public long LmD;
  public Rect Lmz;
  public int dGc;
  public long hiy;
  public Rect hmm;
  public long id;
  public float llC;
  String path;
  public long startTimeMs;
  int type;
  public float volume;
  
  static
  {
    AppMethodBeat.i(220817);
    LmE = new b.a((byte)0);
    AppMethodBeat.o(220817);
  }
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(220816);
    this.path = paramString;
    this.type = paramInt;
    this.llC = 1.0F;
    this.volume = 1.0F;
    this.hmm = new Rect();
    this.Lmz = new Rect();
    this.LmA = true;
    this.LmB = new g();
    com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "create VCLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id, new Object[0]);
    String str;
    switch (this.type)
    {
    default: 
      paramString = e.LmI.b(this).getDuration();
      p.g(paramString, "getResource().duration");
      this.BMD = (paramString.getTimeUs() / 1000L);
      Bk(0L);
      Bl(this.BMD);
      Bj(this.HCV);
      AppMethodBeat.o(220816);
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
          this.BGr = i;
          this.BGs = paramInt;
          com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "initVideoClipInfo, sourceWidth:" + this.BGr + ", sourceHeight:" + this.BGs, new Object[0]);
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
        AppMethodBeat.o(220816);
      }
      e.LmI.b(this);
      paramString = e.LmI.c(this);
      if (paramString == null) {
        break;
      }
      this.BGr = paramString.getWidth();
      this.BGs = paramString.getHeight();
      com.tencent.mm.videocomposition.c.b.i("CompositionTrack", "initImageClipInfo sourceWidth:" + this.BGr + ", sourceHeight:" + this.BGs, new Object[0]);
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
  
  public final void Bi(long paramLong)
  {
    if (paramLong >= 0L) {
      this.startTimeMs = paramLong;
    }
  }
  
  public final void Bj(long paramLong)
  {
    if (paramLong >= 0L) {
      this.hiy = paramLong;
    }
  }
  
  public final void Bk(long paramLong)
  {
    if (paramLong >= 0L) {
      this.HCU = paramLong;
    }
  }
  
  public final void Bl(long paramLong)
  {
    if (paramLong >= 0L) {
      this.HCV = paramLong;
    }
  }
  
  public final boolean esL()
  {
    return (this.type == 1) || (this.type == 2);
  }
  
  public final TAVSource fPA()
  {
    AppMethodBeat.i(220814);
    Object localObject1 = new TAVClip(e.LmI.b(this));
    Object localObject2 = ((TAVClip)localObject1).getVideoConfiguration();
    p.g(localObject2, "clip.videoConfiguration");
    ((TAVVideoConfiguration)localObject2).setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localObject2 = new TAVComposition();
    ((TAVComposition)localObject2).addVideoChannel(j.listOf(localObject1));
    localObject1 = new TAVCompositionBuilder((TAVComposition)localObject2);
    ((TAVCompositionBuilder)localObject1).setReloadChannels(false);
    localObject1 = ((TAVCompositionBuilder)localObject1).buildSource();
    p.g(localObject1, "builder.buildSource()");
    AppMethodBeat.o(220814);
    return localObject1;
  }
  
  public final g fPz()
  {
    return this.LmB;
  }
  
  public final void fyp()
  {
    AppMethodBeat.i(220815);
    Bj(((float)this.startTimeMs + (float)(this.HCV - this.HCU) / this.llC));
    AppMethodBeat.o(220815);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.llC = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b
 * JD-Core Version:    0.7.0.1
 */