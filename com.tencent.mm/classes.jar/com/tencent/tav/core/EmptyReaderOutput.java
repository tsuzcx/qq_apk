package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoder;
import java.util.List;

public class EmptyReaderOutput
  extends AssetReaderOutput
{
  public void markConfigurationAsFinal() {}
  
  public CMSampleBuffer nextSampleBuffer()
  {
    AppMethodBeat.i(201556);
    CMSampleBuffer localCMSampleBuffer = new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
    AppMethodBeat.o(201556);
    return localCMSampleBuffer;
  }
  
  void release() {}
  
  public void resetForReadingTimeRanges(List<CMTimeRange> paramList) {}
  
  void start(IContextCreate paramIContextCreate, AssetReader paramAssetReader) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.core.EmptyReaderOutput
 * JD-Core Version:    0.7.0.1
 */