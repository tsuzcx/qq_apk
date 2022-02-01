package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import java.util.List;

class AudioInfo
{
  TAVTransitionableAudio audio;
  CompositionTrack compositionTrack;
  
  AudioInfo(CompositionTrack paramCompositionTrack, TAVTransitionableAudio paramTAVTransitionableAudio)
  {
    this.compositionTrack = paramCompositionTrack;
    this.audio = paramTAVTransitionableAudio;
  }
  
  CompositionTrackSegment getCurrentSegmentBy()
  {
    AppMethodBeat.i(218827);
    int i = 0;
    while (i < this.compositionTrack.getSegments().size())
    {
      CompositionTrackSegment localCompositionTrackSegment = (CompositionTrackSegment)this.compositionTrack.getSegments().get(i);
      if (localCompositionTrackSegment.getTimeMapping().getTarget().equals(this.audio.getTimeRange()))
      {
        AppMethodBeat.o(218827);
        return localCompositionTrackSegment;
      }
      i += 1;
    }
    AppMethodBeat.o(218827);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.AudioInfo
 * JD-Core Version:    0.7.0.1
 */