package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;

public class DecoderTrackSegment
{
  private CMTime decoderStartTime;
  private CMTime scaledDuration;
  private CMTimeRange timeRange;
  private DecoderAssetTrack videoAsset;
  
  public DecoderTrackSegment(long paramLong)
  {
    this(new CMTimeRange(CMTime.CMTimeZero, new CMTime((float)paramLong / 1000.0F)), null);
    AppMethodBeat.i(216074);
    AppMethodBeat.o(216074);
  }
  
  public DecoderTrackSegment(AssetTrack paramAssetTrack, AssetTrackSegment paramAssetTrackSegment)
  {
    this(paramAssetTrackSegment.getTimeMapping().getSource().clone(), DecoderAssetTrack.create(paramAssetTrack, paramAssetTrackSegment));
    AppMethodBeat.i(216093);
    setScaledDuration(paramAssetTrackSegment.getScaleDuration());
    AppMethodBeat.o(216093);
  }
  
  public DecoderTrackSegment(CMTimeRange paramCMTimeRange, DecoderAssetTrack paramDecoderAssetTrack)
  {
    AppMethodBeat.i(216083);
    this.videoAsset = paramDecoderAssetTrack;
    this.timeRange = paramCMTimeRange;
    this.scaledDuration = paramCMTimeRange.getDuration();
    this.decoderStartTime = CMTime.CMTimeZero;
    AppMethodBeat.o(216083);
  }
  
  public CMTime getDecoderStartTime()
  {
    return this.decoderStartTime;
  }
  
  public CMTime getScaledDuration()
  {
    return this.scaledDuration;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public DecoderAssetTrack getVideoAsset()
  {
    return this.videoAsset;
  }
  
  public void setScaledDuration(CMTime paramCMTime)
  {
    this.scaledDuration = paramCMTime;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.DecoderTrackSegment
 * JD-Core Version:    0.7.0.1
 */