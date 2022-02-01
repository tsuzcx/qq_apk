package com.tencent.tavkit.component.effectchain;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import java.util.List;

public class TAVVideoEffectContext
  implements IVideoEffectContext
{
  protected final VideoEffectProxy globalVideoEffectProxy;
  protected final VideoEffectProxy sourceVideoEffectProxy;
  protected final VideoMixEffectProxy videoMixEffectProxy;
  
  public TAVVideoEffectContext()
  {
    AppMethodBeat.i(218715);
    this.sourceVideoEffectProxy = new VideoEffectProxy();
    this.videoMixEffectProxy = new VideoMixEffectProxy();
    this.globalVideoEffectProxy = new VideoEffectProxy();
    AppMethodBeat.o(218715);
  }
  
  public void addGlobalFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(218752);
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    AppMethodBeat.o(218752);
  }
  
  public void addSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(218740);
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    AppMethodBeat.o(218740);
  }
  
  public void addVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    AppMethodBeat.i(218746);
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
    AppMethodBeat.o(218746);
  }
  
  public TAVVideoEffect getGlobalVideoEffect()
  {
    return this.globalVideoEffectProxy;
  }
  
  public TAVVideoEffect getSourceVideoEffect()
  {
    return this.sourceVideoEffectProxy;
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    return this.videoMixEffectProxy;
  }
  
  public void removeGlobalFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(218781);
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.globalVideoEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(218781);
  }
  
  public void removeSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(218763);
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.sourceVideoEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(218763);
  }
  
  public void removeVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    AppMethodBeat.i(218770);
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
    this.videoMixEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(218770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.TAVVideoEffectContext
 * JD-Core Version:    0.7.0.1
 */