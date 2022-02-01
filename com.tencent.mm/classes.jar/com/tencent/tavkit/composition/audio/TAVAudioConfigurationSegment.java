package com.tencent.tavkit.composition.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;

public class TAVAudioConfigurationSegment
{
  public final TAVAudioConfiguration audioConfiguration;
  public final CMTimeRange compositionTimeRange;
  
  public TAVAudioConfigurationSegment(CMTimeRange paramCMTimeRange, TAVAudioConfiguration paramTAVAudioConfiguration)
  {
    this.audioConfiguration = paramTAVAudioConfiguration;
    this.compositionTimeRange = paramCMTimeRange;
  }
  
  public String toString()
  {
    AppMethodBeat.i(197496);
    String str = "TAVAudioConfigurationSegment{compositionTimeRange=" + this.compositionTimeRange.toSimpleString() + ", audioConfiguration=" + this.audioConfiguration + '}';
    AppMethodBeat.o(197496);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.audio.TAVAudioConfigurationSegment
 * JD-Core Version:    0.7.0.1
 */