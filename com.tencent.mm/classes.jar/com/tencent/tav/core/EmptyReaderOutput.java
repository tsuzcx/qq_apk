package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.List;

public class EmptyReaderOutput
  extends AssetReaderOutput
{
  public void markConfigurationAsFinal() {}
  
  public CMSampleBuffer nextSampleBuffer()
  {
    AppMethodBeat.i(214541);
    CMSampleBuffer localCMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-1L));
    AppMethodBeat.o(214541);
    return localCMSampleBuffer;
  }
  
  void release() {}
  
  public void resetForReadingTimeRanges(List<CMTimeRange> paramList) {}
  
  void start(IContextCreate paramIContextCreate, AssetReader paramAssetReader) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.EmptyReaderOutput
 * JD-Core Version:    0.7.0.1
 */