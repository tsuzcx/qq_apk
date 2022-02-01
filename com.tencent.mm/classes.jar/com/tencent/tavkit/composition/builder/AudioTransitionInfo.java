package com.tencent.tavkit.composition.builder;

import com.tencent.tavkit.composition.audio.TAVAudioTransition;

class AudioTransitionInfo
{
  TAVAudioTransition next;
  TAVAudioTransition prev;
  
  AudioTransitionInfo(TAVAudioTransition paramTAVAudioTransition1, TAVAudioTransition paramTAVAudioTransition2)
  {
    this.prev = paramTAVAudioTransition1;
    this.next = paramTAVAudioTransition2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.AudioTransitionInfo
 * JD-Core Version:    0.7.0.1
 */