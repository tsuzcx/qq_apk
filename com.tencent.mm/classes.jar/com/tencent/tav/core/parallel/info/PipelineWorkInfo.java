package com.tencent.tav.core.parallel.info;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetParallelSegmentStatus;
import com.tencent.tav.core.AssetReaderOutput;
import com.tencent.tav.core.AssetWriter;
import com.tencent.tav.core.AssetWriterInput;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.Locale;

public class PipelineWorkInfo
{
  public static final int PIPELINE_TYPE_AUDIO = 2;
  public static final int PIPELINE_TYPE_VIDEO = 1;
  public AssetWriter assetWriter;
  private PipelineIndicatorInfo indicator;
  public AssetReaderOutput readerOutput;
  public HandlerThread thread;
  public int type;
  public AssetWriterInput writerInput;
  
  public PipelineWorkInfo(int paramInt, AssetReaderOutput paramAssetReaderOutput, AssetWriterInput paramAssetWriterInput, HandlerThread paramHandlerThread, PipelineIndicatorInfo paramPipelineIndicatorInfo)
  {
    AppMethodBeat.i(215639);
    this.type = paramInt;
    this.readerOutput = paramAssetReaderOutput;
    this.writerInput = paramAssetWriterInput;
    this.thread = paramHandlerThread;
    setIndicator(paramPipelineIndicatorInfo);
    AppMethodBeat.o(215639);
  }
  
  public PipelineIndicatorInfo getIndicator()
  {
    return this.indicator;
  }
  
  public void reuseWork(PipelineWorkInfo paramPipelineWorkInfo)
  {
    AppMethodBeat.i(215652);
    PipelineIndicatorInfo localPipelineIndicatorInfo = paramPipelineWorkInfo.indicator;
    paramPipelineWorkInfo.indicator = this.indicator;
    this.indicator = localPipelineIndicatorInfo;
    this.indicator.setSegmentStatus(AssetParallelSegmentStatus.AssetParallelStatusStarted);
    AppMethodBeat.o(215652);
  }
  
  public void setIndicator(PipelineIndicatorInfo paramPipelineIndicatorInfo)
  {
    AppMethodBeat.i(215647);
    this.indicator = paramPipelineIndicatorInfo;
    paramPipelineIndicatorInfo.setSegmentStatus(AssetParallelSegmentStatus.AssetParallelStatusPrepared);
    AppMethodBeat.o(215647);
  }
  
  public String toString()
  {
    AppMethodBeat.i(215659);
    Locale localLocale = Locale.ENGLISH;
    int i = hashCode();
    if (this.type == 1) {}
    for (String str = "video";; str = "audio")
    {
      str = String.format(localLocale, "[hash:%d]type:%s  segment index:%d  time[%d,%d]", new Object[] { Integer.valueOf(i), str, Integer.valueOf(this.indicator.getIndex()), Long.valueOf(this.indicator.timeRange.getStartUs() / 1000L), Long.valueOf(this.indicator.timeRange.getEndUs() / 1000L) });
      AppMethodBeat.o(215659);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.info.PipelineWorkInfo
 * JD-Core Version:    0.7.0.1
 */