package com.tencent.tav.core.parallel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.core.AssetParallelExportSession;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.extractor.AssetExtractor;
import java.util.ArrayList;
import java.util.List;

public class PipelineParallelStrategy
  extends BaseParallelStrategy
{
  public static final int SEGMENT_DURATION_MS = 5000;
  
  public void calculateSubsection(AssetParallelExportSession paramAssetParallelExportSession, ArrayList<PipelineIndicatorInfo> paramArrayList)
  {
    AppMethodBeat.i(215519);
    AssetExtractor localAssetExtractor = new AssetExtractor();
    localAssetExtractor.setDataSource(((CompositionTrackSegment)((AssetTrack)paramAssetParallelExportSession.asset.getTracks().get(0)).getSegments().get(0)).getSourcePath());
    localAssetExtractor.selectTrack(DecoderUtils.getFirstTrackIndex(localAssetExtractor, "video/"));
    long l1 = paramAssetParallelExportSession.timeRange.getStartUs();
    int j;
    for (int i = 0;; i = j)
    {
      j = i;
      if (5000000L + l1 >= paramAssetParallelExportSession.timeRange.getEndUs()) {
        break;
      }
      localAssetExtractor.seekTo(5000000L + l1, 1);
      long l2 = localAssetExtractor.getSampleTime();
      j = i + 1;
      addPipelineIndicator(i, l1 / 1000L, l2 / 1000L, paramArrayList);
      if (l2 <= l1) {
        break;
      }
      l1 = l2;
    }
    if (l1 < paramAssetParallelExportSession.timeRange.getEndUs()) {
      addPipelineIndicator(j, l1 / 1000L, paramAssetParallelExportSession.timeRange.getEndUs() / 1000L, paramArrayList);
    }
    localAssetExtractor.release();
    AppMethodBeat.o(215519);
  }
  
  public int parallelSize()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.PipelineParallelStrategy
 * JD-Core Version:    0.7.0.1
 */