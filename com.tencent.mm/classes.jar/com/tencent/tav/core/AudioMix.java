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
    AppMethodBeat.i(214518);
    Iterator localIterator = this.inputParameters.iterator();
    while (localIterator.hasNext())
    {
      AudioMixInputParameters localAudioMixInputParameters = (AudioMixInputParameters)localIterator.next();
      if (localAudioMixInputParameters.getTrackID() == paramInt)
      {
        AppMethodBeat.o(214518);
        return localAudioMixInputParameters;
      }
    }
    AppMethodBeat.o(214518);
    return null;
  }
  
  public void release()
  {
    AppMethodBeat.i(214519);
    Iterator localIterator = this.inputParameters.iterator();
    while (localIterator.hasNext())
    {
      AudioMixInputParameters localAudioMixInputParameters = (AudioMixInputParameters)localIterator.next();
      if ((localAudioMixInputParameters != null) && (localAudioMixInputParameters.getAudioTapProcessor() != null)) {
        localAudioMixInputParameters.getAudioTapProcessor().release();
      }
    }
    AppMethodBeat.o(214519);
  }
  
  public String toString()
  {
    AppMethodBeat.i(214520);
    String str = "AudioMix{inputParameters=" + this.inputParameters + '}';
    AppMethodBeat.o(214520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.AudioMix
 * JD-Core Version:    0.7.0.1
 */