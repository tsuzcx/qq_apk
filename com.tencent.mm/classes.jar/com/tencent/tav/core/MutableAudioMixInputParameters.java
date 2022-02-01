package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;

public class MutableAudioMixInputParameters
  extends AudioMixInputParameters
{
  public MutableAudioMixInputParameters(AssetTrack paramAssetTrack)
  {
    super(paramAssetTrack.getTrackID(), "");
    AppMethodBeat.i(197638);
    AppMethodBeat.o(197638);
  }
  
  public MutableAudioMixInputParameters(AssetTrack paramAssetTrack, String paramString)
  {
    super(paramAssetTrack.getTrackID(), paramString);
    AppMethodBeat.i(197637);
    AppMethodBeat.o(197637);
  }
  
  public void setAudioTapProcessor(AudioTapProcessor paramAudioTapProcessor)
  {
    this.audioTapProcessor = paramAudioTapProcessor;
  }
  
  public void setAudioTimePitchAlgorithm(String paramString)
  {
    this.audioTimePitchAlgorithm = paramString;
  }
  
  public void setTrackID(int paramInt)
  {
    this.trackID = paramInt;
  }
  
  public void setVolumeAtTime(float paramFloat, CMTime paramCMTime) {}
  
  public void setVolumeForTimeRange(float paramFloat)
  {
    AppMethodBeat.i(197640);
    Iterator localIterator = this.volumeRanges.iterator();
    while (localIterator.hasNext())
    {
      AudioMixInputParameters.VolumeRange localVolumeRange = (AudioMixInputParameters.VolumeRange)localIterator.next();
      localVolumeRange.startVolume = paramFloat;
      localVolumeRange.endVolume = paramFloat;
    }
    AppMethodBeat.o(197640);
  }
  
  public void setVolumeForTimeRange(float paramFloat, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(197641);
    setVolumeRampForTimeRange(paramFloat, paramFloat, paramCMTimeRange);
    AppMethodBeat.o(197641);
  }
  
  public void setVolumeRampForTimeRange(float paramFloat1, float paramFloat2, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(197639);
    AudioMixInputParameters.VolumeRange localVolumeRange = new AudioMixInputParameters.VolumeRange(this);
    localVolumeRange.timeRange = paramCMTimeRange;
    localVolumeRange.startVolume = paramFloat1;
    localVolumeRange.endVolume = paramFloat2;
    this.volumeRanges.add(0, localVolumeRange);
    AppMethodBeat.o(197639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.core.MutableAudioMixInputParameters
 * JD-Core Version:    0.7.0.1
 */