package com.tencent.tavkit.component.effectchain;

import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;

public abstract interface IVideoEffectContext
{
  public abstract TAVVideoEffect getGlobalVideoEffect();
  
  public abstract TAVVideoEffect getSourceVideoEffect();
  
  public abstract TAVVideoMixEffect getVideoMixEffect();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.IVideoEffectContext
 * JD-Core Version:    0.7.0.1
 */