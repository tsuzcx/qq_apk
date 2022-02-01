package com.tencent.tavkit.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.component.effectchain.IVideoEffectContext;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.utils.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVComposition
{
  private List<List<? extends TAVTransitionableAudio>> audioChannels;
  private List<? extends TAVAudio> audios;
  private int backgroundColor;
  private CMTime frameDuration;
  private TAVVideoEffect globalVideoEffect;
  private List<? extends TAVVideo> overlays;
  private VideoComposition.RenderLayoutMode renderLayoutMode;
  private CGSize renderSize;
  private TAVVideoEffect sourceVideoEffect;
  private List<List<? extends TAVTransitionableVideo>> videoChannels;
  private TAVVideoMixEffect videoMixEffect;
  
  public TAVComposition()
  {
    AppMethodBeat.i(211695);
    this.videoChannels = new ArrayList();
    this.audioChannels = new ArrayList();
    this.backgroundColor = -16777216;
    AppMethodBeat.o(211695);
  }
  
  public TAVComposition(List<TAVClip> paramList)
  {
    this(paramList, paramList);
    AppMethodBeat.i(211691);
    AppMethodBeat.o(211691);
  }
  
  public TAVComposition(List<? extends TAVTransitionableVideo> paramList, List<? extends TAVTransitionableAudio> paramList1)
  {
    this();
    AppMethodBeat.i(211693);
    addVideoChannel(paramList);
    addAudioChannel(paramList1);
    AppMethodBeat.o(211693);
  }
  
  public TAVComposition(TAVClip... paramVarArgs)
  {
    this(ListUtils.listWithObjects(paramVarArgs));
    AppMethodBeat.i(211689);
    AppMethodBeat.o(211689);
  }
  
  public void addAudioChannel(List<? extends TAVTransitionableAudio> paramList)
  {
    AppMethodBeat.i(211719);
    if (this.audioChannels == null) {
      this.audioChannels = new ArrayList();
    }
    this.audioChannels.add(new ArrayList(paramList));
    AppMethodBeat.o(211719);
  }
  
  public void addVideoChannel(List<? extends TAVTransitionableVideo> paramList)
  {
    AppMethodBeat.i(211716);
    if (this.videoChannels == null) {
      this.videoChannels = new ArrayList();
    }
    this.videoChannels.add(new ArrayList(paramList));
    AppMethodBeat.o(211716);
  }
  
  public void attachVideoEffectChain(IVideoEffectContext paramIVideoEffectContext)
  {
    AppMethodBeat.i(211721);
    this.sourceVideoEffect = paramIVideoEffectContext.getSourceVideoEffect();
    this.videoMixEffect = paramIVideoEffectContext.getVideoMixEffect();
    this.globalVideoEffect = paramIVideoEffectContext.getGlobalVideoEffect();
    AppMethodBeat.o(211721);
  }
  
  public List<List<? extends TAVTransitionableAudio>> getAudioChannels()
  {
    return this.audioChannels;
  }
  
  public List<? extends TAVAudio> getAudios()
  {
    return this.audios;
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(211726);
    if (this.videoChannels == null)
    {
      localObject1 = CMTime.CMTimeZero;
      AppMethodBeat.o(211726);
      return localObject1;
    }
    int j = this.videoChannels.size();
    Object localObject2 = CMTime.CMTimeZero;
    Object localObject1 = CMTime.CMTimeZero;
    int i = 0;
    if (i < j)
    {
      Object localObject3 = (List)this.videoChannels.get(i);
      if (localObject3 == null) {
        break label164;
      }
      localObject3 = ((List)localObject3).iterator();
      label117:
      while (((Iterator)localObject3).hasNext())
      {
        TAVTransitionableVideo localTAVTransitionableVideo = (TAVTransitionableVideo)((Iterator)localObject3).next();
        if (localTAVTransitionableVideo == null) {
          break label161;
        }
        localObject1 = ((CMTime)localObject1).add(localTAVTransitionableVideo.getDuration());
      }
      if (!((CMTime)localObject1).bigThan((CMTime)localObject2)) {
        break label155;
      }
      label129:
      localObject3 = CMTime.CMTimeZero;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    label155:
    label161:
    label164:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(211726);
      return localObject2;
      localObject1 = localObject2;
      break label129;
      break label117;
    }
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public TAVVideoEffect getGlobalVideoEffect()
  {
    return this.globalVideoEffect;
  }
  
  public List<? extends TAVVideo> getOverlays()
  {
    return this.overlays;
  }
  
  public VideoComposition.RenderLayoutMode getRenderLayoutMode()
  {
    return this.renderLayoutMode;
  }
  
  public CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  public TAVVideoEffect getSourceVideoEffect()
  {
    return this.sourceVideoEffect;
  }
  
  public List<List<? extends TAVTransitionableVideo>> getVideoChannels()
  {
    return this.videoChannels;
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    return this.videoMixEffect;
  }
  
  public void setAudioChannels(List<List<? extends TAVTransitionableAudio>> paramList)
  {
    this.audioChannels = paramList;
  }
  
  public void setAudios(List<? extends TAVAudio> paramList)
  {
    this.audios = paramList;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void setFrameDuration(CMTime paramCMTime)
  {
    this.frameDuration = paramCMTime;
  }
  
  public void setGlobalVideoEffect(TAVVideoEffect paramTAVVideoEffect)
  {
    this.globalVideoEffect = paramTAVVideoEffect;
  }
  
  public void setOverlays(List<? extends TAVVideo> paramList)
  {
    this.overlays = paramList;
  }
  
  public void setRenderLayoutMode(VideoComposition.RenderLayoutMode paramRenderLayoutMode)
  {
    this.renderLayoutMode = paramRenderLayoutMode;
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    this.renderSize = paramCGSize;
  }
  
  public void setSourceVideoEffect(TAVVideoEffect paramTAVVideoEffect)
  {
    this.sourceVideoEffect = paramTAVVideoEffect;
  }
  
  public void setVideoChannels(List<List<? extends TAVTransitionableVideo>> paramList)
  {
    this.videoChannels = paramList;
  }
  
  public void setVideoMixEffect(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    this.videoMixEffect = paramTAVVideoMixEffect;
  }
  
  public String toString()
  {
    AppMethodBeat.i(211729);
    String str = "TAVComposition{\nrenderSize=" + this.renderSize + ", renderLayoutMode=" + this.renderLayoutMode + ", backgroundColor=" + this.backgroundColor + ", frameDuration=" + this.frameDuration + "\nvideoChannels=" + this.videoChannels + "\naudioChannels=" + this.audioChannels + "\noverlays=" + this.overlays + "\naudios=" + this.audios + '}';
    AppMethodBeat.o(211729);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.TAVComposition
 * JD-Core Version:    0.7.0.1
 */