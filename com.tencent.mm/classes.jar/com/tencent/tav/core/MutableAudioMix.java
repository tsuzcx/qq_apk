package com.tencent.tav.core;

import java.util.List;

public class MutableAudioMix
  extends AudioMix
{
  public MutableAudioMix(List<? extends AudioMixInputParameters> paramList)
  {
    super(paramList);
  }
  
  public void setInputParameters(List<AudioMixInputParameters> paramList)
  {
    this.inputParameters = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.MutableAudioMix
 * JD-Core Version:    0.7.0.1
 */