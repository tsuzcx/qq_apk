package com.tencent.tav.core.parallel;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.core.AssetParallelExportSession;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import java.util.ArrayList;
import java.util.List;

public class SimpleParallelStrategy
  extends BaseParallelStrategy
{
  AssetExtractor extractor;
  private int parallelSize;
  
  public SimpleParallelStrategy(AssetParallelExportSession paramAssetParallelExportSession)
  {
    AppMethodBeat.i(215544);
    this.parallelSize = 1;
    this.extractor = new AssetExtractor();
    paramAssetParallelExportSession = (CompositionTrackSegment)((AssetTrack)paramAssetParallelExportSession.asset.getTracks().get(0)).getSegments().get(0);
    this.extractor.setDataSource(paramAssetParallelExportSession.getSourcePath());
    int i = DecoderUtils.getFirstTrackIndex(this.extractor, "video/");
    this.extractor.selectTrack(i);
    paramAssetParallelExportSession = this.extractor.getTrackFormat(i);
    try
    {
      int k;
      if (paramAssetParallelExportSession.containsKey("width"))
      {
        i = paramAssetParallelExportSession.getInteger("width");
        if (paramAssetParallelExportSession.containsKey("height")) {
          j = paramAssetParallelExportSession.getInteger("height");
        }
        if (!paramAssetParallelExportSession.containsKey("frame-rate")) {
          break label212;
        }
        k = paramAssetParallelExportSession.getInteger("frame-rate");
        label143:
        if (!paramAssetParallelExportSession.containsKey("bitrate")) {
          break label219;
        }
      }
      label212:
      label219:
      for (long l = paramAssetParallelExportSession.getInteger("bitrate");; l = 0L)
      {
        this.parallelSize = CodecHelper.getSupportMaxParallelCount(i, j, k, l, paramAssetParallelExportSession.getString("mime"));
        Logger.i("SimpleParallelStrategy", "parallelSize %d", new Object[] { Integer.valueOf(this.parallelSize) });
        AppMethodBeat.o(215544);
        return;
        i = 0;
        break;
        k = 30;
        break label143;
      }
      return;
    }
    catch (Exception paramAssetParallelExportSession)
    {
      AppMethodBeat.o(215544);
    }
  }
  
  public void calculateSubsection(AssetParallelExportSession paramAssetParallelExportSession, ArrayList<PipelineIndicatorInfo> paramArrayList)
  {
    AppMethodBeat.i(215561);
    long l3 = paramAssetParallelExportSession.getTimeRange().getDurationUs() / this.parallelSize;
    long l1 = paramAssetParallelExportSession.timeRange.getStartUs();
    int i = 0;
    if (this.parallelSize == 1)
    {
      addPipelineIndicator(0, l1 / 1000L, paramAssetParallelExportSession.timeRange.getEndUs() / 1000L, paramArrayList);
      this.parallelSize = paramArrayList.size();
      Logger.i("SimpleParallelStrategy", "calculateSubsection final parallelSize:%d", new Object[] { Integer.valueOf(this.parallelSize) });
      AppMethodBeat.o(215561);
      return;
    }
    for (;;)
    {
      int j = i;
      if (l1 + l3 < paramAssetParallelExportSession.getTimeRange().getEndUs())
      {
        j = i;
        if (i < this.parallelSize - 1)
        {
          this.extractor.seekTo(l1 + l3, 1);
          long l2 = this.extractor.getSampleTime();
          j = i + 1;
          addPipelineIndicator(i, l1 / 1000L, l2 / 1000L, paramArrayList);
          if (l2 > l1)
          {
            i = j;
            l1 = l2;
            continue;
          }
        }
      }
      if (l1 < paramAssetParallelExportSession.timeRange.getEndUs()) {
        addPipelineIndicator(j, l1 / 1000L, paramAssetParallelExportSession.timeRange.getEndUs() / 1000L, paramArrayList);
      }
      this.extractor.release();
      break;
    }
  }
  
  public int parallelSize()
  {
    return this.parallelSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.SimpleParallelStrategy
 * JD-Core Version:    0.7.0.1
 */