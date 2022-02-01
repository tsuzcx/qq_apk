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
    AppMethodBeat.i(197436);
    this.sourceVideoEffectProxy = new VideoEffectProxy();
    this.videoMixEffectProxy = new VideoMixEffectProxy();
    this.globalVideoEffectProxy = new VideoEffectProxy();
    AppMethodBeat.o(197436);
  }
  
  public void addGlobalFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(197439);
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    AppMethodBeat.o(197439);
  }
  
  public void addSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(197437);
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    AppMethodBeat.o(197437);
  }
  
  public void addVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    AppMethodBeat.i(197438);
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
    AppMethodBeat.o(197438);
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
    AppMethodBeat.i(197442);
    this.globalVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.globalVideoEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(197442);
  }
  
  public void removeSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(197440);
    this.sourceVideoEffectProxy.getEffects().remove(paramTAVVideoEffect);
    this.sourceVideoEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(197440);
  }
  
  public void removeVideoMixFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    AppMethodBeat.i(197441);
    this.videoMixEffectProxy.getEffects().remove(paramTAVVideoMixEffect);
    this.videoMixEffectProxy.notifyOnEffectRemove();
    AppMethodBeat.o(197441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.TAVVideoEffectContext
 * JD-Core Version:    0.7.0.1
 */