package com.tencent.tavkit.composition.builder;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;

class VideoInfo
{
  TAVTransitionableVideo clip;
  CompositionTrack compositionTrack;
  
  VideoInfo(CompositionTrack paramCompositionTrack, TAVTransitionableVideo paramTAVTransitionableVideo)
  {
    this.compositionTrack = paramCompositionTrack;
    this.clip = paramTAVTransitionableVideo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.VideoInfo
 * JD-Core Version:    0.7.0.1
 */