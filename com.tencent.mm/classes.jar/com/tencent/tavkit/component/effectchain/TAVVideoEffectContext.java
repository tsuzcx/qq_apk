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
    AppMethodBeat.i(204567);
    this.sourceVideoEffectProxy = new VideoEffectProxy();
    this.videoMixEffectProxy = new VideoMixEffectProxy();
    this.globalVideoEffectProxy = new VideoEffectProxy();
    AppMethodBeat.o(204567);
  }
  
  public void addGlobalFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(204570);
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    AppMethodBeat.o(204570);
  }
  
  public void addSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(204568);
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    AppMethodBeat.o(204568);
  }
  
  public void addVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    AppMethodBeat.i(204569);
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
    AppMethodBeat.o(204569);
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
    AppMethodBeat.i(204573);
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.globalVideoEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(204573);
  }
  
  public void removeSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(204571);
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.sourceVideoEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(204571);
  }
  
  public void removeVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    AppMethodBeat.i(204572);
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
    this.videoMixEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(204572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.TAVVideoEffectContext
 * JD-Core Version:    0.7.0.1
 */