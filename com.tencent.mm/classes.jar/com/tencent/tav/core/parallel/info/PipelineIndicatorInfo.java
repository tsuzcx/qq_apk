package com.tencent.tav.core.parallel.info;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AVAssetReaderStatus;
import com.tencent.tav.core.AssetParallelSegmentStatus;
import com.tencent.tav.core.AssetWriterStatus;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.Locale;

public class PipelineIndicatorInfo
{
  public ExportErrorStatus errorStatus;
  private long exportEndTimeMs;
  private long exportStartTimeMs;
  private int index;
  private float progress;
  public AVAssetReaderStatus readerStatus;
  private int retryCount = 0;
  private AssetParallelSegmentStatus segmentStatus;
  public CMTimeRange timeRange;
  public int type;
  public AssetWriterStatus writerStatus;
  
  public PipelineIndicatorInfo(int paramInt1, int paramInt2, CMTimeRange paramCMTimeRange)
  {
    this.type = paramInt1;
    this.index = paramInt2;
    this.timeRange = paramCMTimeRange;
    this.segmentStatus = AssetParallelSegmentStatus.AssetParallelStatusUnknown;
    this.readerStatus = AVAssetReaderStatus.AssetReaderStatusUnknown;
    this.writerStatus = AssetWriterStatus.AssetWriterStatusUnknown;
    this.progress = 0.0F;
  }
  
  public static PipelineIndicatorInfo getAudioPipelineIndicatorInfo(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(215643);
    paramCMTimeRange = new PipelineIndicatorInfo(2, 0, paramCMTimeRange);
    AppMethodBeat.o(215643);
    return paramCMTimeRange;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof PipelineIndicatorInfo)) && (this.type == ((PipelineIndicatorInfo)paramObject).type) && (this.index == ((PipelineIndicatorInfo)paramObject).index);
  }
  
  public boolean finished()
  {
    return this.segmentStatus == AssetParallelSegmentStatus.AssetReaderStatusWriteFinish;
  }
  
  public long getExportCostTimeMs()
  {
    return this.exportEndTimeMs - this.exportStartTimeMs;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public float getProgress()
  {
    return this.progress;
  }
  
  public int getRetryCount()
  {
    return this.retryCount;
  }
  
  public AssetParallelSegmentStatus getSegmentStatus()
  {
    return this.segmentStatus;
  }
  
  public void retry()
  {
    this.retryCount += 1;
    this.segmentStatus = AssetParallelSegmentStatus.AssetParallelStatusUnknown;
  }
  
  public void setCurrentTime(long paramLong)
  {
    AppMethodBeat.i(215661);
    this.progress = ((float)paramLong * 1.0F / (float)this.timeRange.getDurationUs());
    AppMethodBeat.o(215661);
  }
  
  public void setProgress(float paramFloat)
  {
    this.progress = paramFloat;
  }
  
  public void setSegmentStatus(AssetParallelSegmentStatus paramAssetParallelSegmentStatus)
  {
    AppMethodBeat.i(215697);
    this.segmentStatus = paramAssetParallelSegmentStatus;
    if (paramAssetParallelSegmentStatus == AssetParallelSegmentStatus.AssetParallelStatusStarted)
    {
      this.exportStartTimeMs = System.currentTimeMillis();
      AppMethodBeat.o(215697);
      return;
    }
    if ((paramAssetParallelSegmentStatus == AssetParallelSegmentStatus.AssetReaderStatusWriteFinish) || (paramAssetParallelSegmentStatus == AssetParallelSegmentStatus.AssetParallelStatusFailed) || (paramAssetParallelSegmentStatus == AssetParallelSegmentStatus.AssetExportStatusCompleted) || (paramAssetParallelSegmentStatus == AssetParallelSegmentStatus.AssetParallelStatusCancelled)) {
      this.exportEndTimeMs = System.currentTimeMillis();
    }
    AppMethodBeat.o(215697);
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public String toString()
  {
    AppMethodBeat.i(215725);
    String str = String.format(Locale.ENGLISH, "index:%d type:%d status:%s timeRange:%s", new Object[] { Integer.valueOf(this.index), Integer.valueOf(this.type), this.segmentStatus, this.timeRange });
    AppMethodBeat.o(215725);
    return str;
  }
  
  public boolean unKnown()
  {
    return this.segmentStatus == AssetParallelSegmentStatus.AssetParallelStatusUnknown;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.info.PipelineIndicatorInfo
 * JD-Core Version:    0.7.0.1
 */