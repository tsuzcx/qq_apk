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
    AppMethodBeat.i(215239);
    AppMethodBeat.o(215239);
  }
  
  public MutableAudioMixInputParameters(AssetTrack paramAssetTrack, String paramString)
  {
    super(paramAssetTrack.getTrackID(), paramString);
    AppMethodBeat.i(215232);
    AppMethodBeat.o(215232);
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
    AppMethodBeat.i(215273);
    Iterator localIterator = this.volumeRanges.iterator();
    while (localIterator.hasNext())
    {
      AudioMixInputParameters.VolumeRange localVolumeRange = (AudioMixInputParameters.VolumeRange)localIterator.next();
      localVolumeRange.startVolume = paramFloat;
      localVolumeRange.endVolume = paramFloat;
    }
    AppMethodBeat.o(215273);
  }
  
  public void setVolumeForTimeRange(float paramFloat, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(215280);
    setVolumeRampForTimeRange(paramFloat, paramFloat, paramCMTimeRange);
    AppMethodBeat.o(215280);
  }
  
  public void setVolumeRampForTimeRange(float paramFloat1, float paramFloat2, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(215263);
    AudioMixInputParameters.VolumeRange localVolumeRange = new AudioMixInputParameters.VolumeRange();
    localVolumeRange.timeRange = paramCMTimeRange;
    localVolumeRange.startVolume = paramFloat1;
    localVolumeRange.endVolume = paramFloat2;
    this.volumeRanges.add(0, localVolumeRange);
    AppMethodBeat.o(215263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.MutableAudioMixInputParameters
 * JD-Core Version:    0.7.0.1
 */