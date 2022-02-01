package com.tencent.tavkit.composition.audio;

import com.tencent.tav.core.AudioTapProcessor;

public abstract interface TAVAudioProcessorNode
{
  public abstract TAVAudioProcessorEffect createAudioProcessor();
  
  public abstract String getIdentifier();
  
  public static abstract interface TAVAudioProcessorEffect
    extends AudioTapProcessor
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.composition.audio.TAVAudioProcessorNode
 * JD-Core Version:    0.7.0.1
 */