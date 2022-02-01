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
    AppMethodBeat.i(191939);
    this.sourceVideoEffectProxy = new VideoEffectProxy();
    this.videoMixEffectProxy = new VideoMixEffectProxy();
    this.globalVideoEffectProxy = new VideoEffectProxy();
    AppMethodBeat.o(191939);
  }
  
  public void addGlobalFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(191942);
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    AppMethodBeat.o(191942);
  }
  
  public void addSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(191940);
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    AppMethodBeat.o(191940);
  }
  
  public void addVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    AppMethodBeat.i(191941);
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
    AppMethodBeat.o(191941);
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
    AppMethodBeat.i(191945);
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.globalVideoEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(191945);
  }
  
  public void removeSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(191943);
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.sourceVideoEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(191943);
  }
  
  public void removeVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    AppMethodBeat.i(191944);
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
    this.videoMixEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(191944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.TAVVideoEffectContext
 * JD-Core Version:    0.7.0.1
 */