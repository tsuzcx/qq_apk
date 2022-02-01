package com.tencent.tav.core;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.report.AverageTimeReporter;
import java.util.List;

public abstract class AssetReaderOutput
{
  protected boolean alwaysCopiesSampleData = false;
  protected int mediaType;
  private StatusListener statusListener;
  protected boolean supportsRandomAccess = false;
  protected CMTimeRange timeRange;
  
  public void addStatusListener(StatusListener paramStatusListener)
  {
    this.statusListener = paramStatusListener;
  }
  
  public final CMSampleBuffer copyNextSampleBuffer(boolean paramBoolean)
  {
    CMSampleBuffer localCMSampleBuffer = nextSampleBuffer(paramBoolean);
    if (localCMSampleBuffer.getTime().getTimeUs() > 0L) {}
    do
    {
      do
      {
        return localCMSampleBuffer;
        if (localCMSampleBuffer.getState().getStateCode() != -1L) {
          break;
        }
      } while (this.statusListener == null);
      this.statusListener.statusChanged(this, AVAssetReaderStatus.AssetReaderStatusCompleted);
      return localCMSampleBuffer;
    } while (this.statusListener == null);
    this.statusListener.statusChanged(this, AVAssetReaderStatus.AssetReaderStatusFailed);
    return localCMSampleBuffer;
  }
  
  public long duration()
  {
    return 0L;
  }
  
  public AverageTimeReporter getDecodePerformance()
  {
    return null;
  }
  
  public int getMediaType()
  {
    return this.mediaType;
  }
  
  public boolean isAlwaysCopiesSampleData()
  {
    return this.alwaysCopiesSampleData;
  }
  
  public boolean isSupportsRandomAccess()
  {
    return this.supportsRandomAccess;
  }
  
  public abstract void markConfigurationAsFinal();
  
  public abstract CMSampleBuffer nextSampleBuffer(boolean paramBoolean);
  
  abstract void release();
  
  public void reset(CMTimeRange paramCMTimeRange) {}
  
  public abstract void resetForReadingTimeRanges(List<CMTimeRange> paramList);
  
  public void setAlwaysCopiesSampleData(boolean paramBoolean)
  {
    this.alwaysCopiesSampleData = paramBoolean;
  }
  
  public void setSupportsRandomAccess(boolean paramBoolean)
  {
    this.supportsRandomAccess = paramBoolean;
  }
  
  public void start(IContextCreate paramIContextCreate, CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  static abstract interface StatusListener
  {
    public abstract void statusChanged(AssetReaderOutput paramAssetReaderOutput, AVAssetReaderStatus paramAVAssetReaderStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetReaderOutput
 * JD-Core Version:    0.7.0.1
 */