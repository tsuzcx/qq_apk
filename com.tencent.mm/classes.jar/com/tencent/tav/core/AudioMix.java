package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class AudioMix<InputParameters extends AudioMixInputParameters>
{
  protected List<InputParameters> inputParameters;
  
  public AudioMix(List<InputParameters> paramList)
  {
    this.inputParameters = paramList;
  }
  
  public List<InputParameters> getInputParameters()
  {
    return this.inputParameters;
  }
  
  public InputParameters getInputParametersWithTrackID(int paramInt)
  {
    AppMethodBeat.i(197598);
    Iterator localIterator = this.inputParameters.iterator();
    while (localIterator.hasNext())
    {
      AudioMixInputParameters localAudioMixInputParameters = (AudioMixInputParameters)localIterator.next();
      if (localAudioMixInputParameters.getTrackID() == paramInt)
      {
        AppMethodBeat.o(197598);
        return localAudioMixInputParameters;
      }
    }
    AppMethodBeat.o(197598);
    return null;
  }
  
  public void release()
  {
    AppMethodBeat.i(197599);
    Iterator localIterator = this.inputParameters.iterator();
    while (localIterator.hasNext())
    {
      AudioMixInputParameters localAudioMixInputParameters = (AudioMixInputParameters)localIterator.next();
      if ((localAudioMixInputParameters != null) && (localAudioMixInputParameters.getAudioTapProcessor() != null)) {
        localAudioMixInputParameters.getAudioTapProcessor().release();
      }
    }
    AppMethodBeat.o(197599);
  }
  
  public String toString()
  {
    AppMethodBeat.i(197600);
    String str = "AudioMix{inputParameters=" + this.inputParameters + '}';
    AppMethodBeat.o(197600);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.core.AudioMix
 * JD-Core Version:    0.7.0.1
 */