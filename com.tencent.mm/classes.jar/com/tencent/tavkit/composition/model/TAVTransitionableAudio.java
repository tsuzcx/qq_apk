package com.tencent.tavkit.composition.model;

import com.tencent.tavkit.composition.audio.TAVAudioTransition;

public abstract interface TAVTransitionableAudio
  extends TAVAudio
{
  public abstract TAVAudioTransition getAudioTransition();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVTransitionableAudio
 * JD-Core Version:    0.7.0.1
 */