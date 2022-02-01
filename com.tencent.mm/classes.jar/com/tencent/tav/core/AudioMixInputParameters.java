package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;

public class AudioMixInputParameters
{
  protected AudioTapProcessor audioTapProcessor;
  protected String audioTimePitchAlgorithm;
  protected int trackID;
  protected ArrayList<VolumeRange> volumeRanges;
  
  public AudioMixInputParameters(int paramInt, String paramString)
  {
    AppMethodBeat.i(201540);
    this.volumeRanges = new ArrayList();
    this.trackID = paramInt;
    this.audioTimePitchAlgorithm = paramString;
    AppMethodBeat.o(201540);
  }
  
  public boolean containsTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(201543);
    Iterator localIterator = this.volumeRanges.iterator();
    while (localIterator.hasNext()) {
      if (((VolumeRange)localIterator.next()).timeRange.containsTime(paramCMTime))
      {
        AppMethodBeat.o(201543);
        return true;
      }
    }
    AppMethodBeat.o(201543);
    return false;
  }
  
  public AudioTapProcessor getAudioTapProcessor()
  {
    return this.audioTapProcessor;
  }
  
  public String getAudioTimePitchAlgorithm()
  {
    return this.audioTimePitchAlgorithm;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
  
  public float getVolumeAtTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(201542);
    long l1 = paramCMTime.getTimeUs();
    Iterator localIterator = this.volumeRanges.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramCMTime = (VolumeRange)localIterator.next();
    } while ((l1 < paramCMTime.timeRange.getStart().getTimeUs()) || (l1 >= paramCMTime.timeRange.getEnd().getTimeUs()));
    for (;;)
    {
      if (paramCMTime == null)
      {
        AppMethodBeat.o(201542);
        return 1.0F;
      }
      long l2 = paramCMTime.timeRange.getStart().getTimeUs();
      float f1 = paramCMTime.startVolume;
      float f2 = paramCMTime.endVolume;
      float f3 = paramCMTime.startVolume;
      float f4 = 1.0F * (float)(l1 - l2) / (float)paramCMTime.timeRange.getDuration().getTimeUs();
      AppMethodBeat.o(201542);
      return f4 * (f2 - f3) + f1;
      paramCMTime = null;
    }
  }
  
  public VolumeRange getVolumeRampAtTimeRange(CMTime paramCMTime)
  {
    AppMethodBeat.i(201541);
    Iterator localIterator = this.volumeRanges.iterator();
    while (localIterator.hasNext())
    {
      VolumeRange localVolumeRange = (VolumeRange)localIterator.next();
      if (localVolumeRange.timeRange.containsTime(paramCMTime))
      {
        AppMethodBeat.o(201541);
        return localVolumeRange;
      }
    }
    AppMethodBeat.o(201541);
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(201544);
    String str = "AudioMixInputParameters{trackID=" + this.trackID + ", audioTimePitchAlgorithm='" + this.audioTimePitchAlgorithm + '\'' + ", audioTapProcessor=" + this.audioTapProcessor + ", volumeRanges=" + this.volumeRanges + '}';
    AppMethodBeat.o(201544);
    return str;
  }
  
  public class VolumeRange
  {
    public float endVolume;
    public float startVolume;
    public CMTimeRange timeRange;
    
    public VolumeRange() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.AudioMixInputParameters
 * JD-Core Version:    0.7.0.1
 */