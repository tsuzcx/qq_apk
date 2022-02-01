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
    AppMethodBeat.i(200766);
    this.sourceVideoEffectProxy = new VideoEffectProxy();
    this.videoMixEffectProxy = new VideoMixEffectProxy();
    this.globalVideoEffectProxy = new VideoEffectProxy();
    AppMethodBeat.o(200766);
  }
  
  public void addGlobalFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(200769);
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    AppMethodBeat.o(200769);
  }
  
  public void addSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(200767);
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    AppMethodBeat.o(200767);
  }
  
  public void addVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    AppMethodBeat.i(200768);
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
    AppMethodBeat.o(200768);
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
    AppMethodBeat.i(200772);
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.globalVideoEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(200772);
  }
  
  public void removeSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(200770);
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.sourceVideoEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(200770);
  }
  
  public void removeVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    AppMethodBeat.i(200771);
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
    this.videoMixEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(200771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.TAVVideoEffectContext
 * JD-Core Version:    0.7.0.1
 */