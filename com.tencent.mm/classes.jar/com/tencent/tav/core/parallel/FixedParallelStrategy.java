package com.tencent.tav.core.parallel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.core.AssetParallelExportSession;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.w;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/core/parallel/FixedParallelStrategy;", "Lcom/tencent/tav/core/parallel/BaseParallelStrategy;", "exportSession", "Lcom/tencent/tav/core/AssetParallelExportSession;", "(Lcom/tencent/tav/core/AssetParallelExportSession;)V", "getExportSession", "()Lcom/tencent/tav/core/AssetParallelExportSession;", "setExportSession", "parallelSize", "", "calculateSubsection", "", "list", "Ljava/util/ArrayList;", "Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;", "Companion", "avfoundation_release"}, k=1, mv={1, 1, 15})
public final class FixedParallelStrategy
  extends BaseParallelStrategy
{
  public static final FixedParallelStrategy.Companion Companion;
  private static final String TAG = "MicroMsg.FixedParallelStrategy";
  private AssetParallelExportSession exportSession;
  private int parallelSize;
  
  static
  {
    AppMethodBeat.i(215510);
    Companion = new FixedParallelStrategy.Companion(null);
    AppMethodBeat.o(215510);
  }
  
  public FixedParallelStrategy(AssetParallelExportSession paramAssetParallelExportSession)
  {
    AppMethodBeat.i(215501);
    this.exportSession = paramAssetParallelExportSession;
    this.parallelSize = 5;
    if (CodecHelper.HARD_CODE_PARALLEL_COUNT > 0)
    {
      this.parallelSize = CodecHelper.HARD_CODE_PARALLEL_COUNT;
      Logger.i("MicroMsg.FixedParallelStrategy", "CodecHelper set debug suggestParallelCount:" + this.parallelSize);
      AppMethodBeat.o(215501);
      return;
    }
    paramAssetParallelExportSession = this.exportSession.getExportConfig();
    s.r(paramAssetParallelExportSession, "exportSession.exportConfig");
    if (paramAssetParallelExportSession.getSuggestParallelCount() > 0)
    {
      paramAssetParallelExportSession = this.exportSession.getExportConfig();
      s.r(paramAssetParallelExportSession, "exportSession.exportConfig");
      this.parallelSize = paramAssetParallelExportSession.getSuggestParallelCount();
      Logger.i("MicroMsg.FixedParallelStrategy", "exportSession set suggestParallelCount:" + this.parallelSize);
    }
    AppMethodBeat.o(215501);
  }
  
  public final void calculateSubsection(AssetParallelExportSession paramAssetParallelExportSession, ArrayList<PipelineIndicatorInfo> paramArrayList)
  {
    AppMethodBeat.i(215528);
    if (paramAssetParallelExportSession == null) {
      s.klw();
    }
    Object localObject1 = paramAssetParallelExportSession.getTimeRange();
    s.r(localObject1, "exportSession!!.getTimeRange()");
    this.parallelSize = k.qv((int)(((CMTimeRange)localObject1).getDurationUs() / 10000000L), this.parallelSize);
    localObject1 = paramAssetParallelExportSession.timeRange;
    s.r(localObject1, "exportSession.timeRange");
    long l1 = ((CMTimeRange)localObject1).getStartUs();
    if (this.parallelSize <= 1)
    {
      l1 /= 1000L;
      paramAssetParallelExportSession = paramAssetParallelExportSession.timeRange;
      s.r(paramAssetParallelExportSession, "exportSession.timeRange");
      addPipelineIndicator(0, l1, paramAssetParallelExportSession.getEndUs() / 1000L, paramArrayList);
      Logger.i("MicroMsg.FixedParallelStrategy", "parallel size is 1");
      AppMethodBeat.o(215528);
      return;
    }
    localObject1 = paramAssetParallelExportSession.getTimeRange();
    s.r(localObject1, "exportSession.getTimeRange()");
    long l2 = ((CMTimeRange)localObject1).getDurationUs() / this.parallelSize;
    Logger.i("MicroMsg.FixedParallelStrategy", "calculateSubsection offset:%d currentPts:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
    int i = 0;
    if (this.parallelSize == 1)
    {
      l1 /= 1000L;
      paramAssetParallelExportSession = paramAssetParallelExportSession.timeRange;
      s.r(paramAssetParallelExportSession, "exportSession.timeRange");
      addPipelineIndicator(0, l1, paramAssetParallelExportSession.getEndUs() / 1000L, paramArrayList);
    }
    for (;;)
    {
      if (paramArrayList == null) {
        s.klw();
      }
      this.parallelSize = paramArrayList.size();
      Logger.i("MicroMsg.FixedParallelStrategy", "calculateSubsection final parallelSize:%d", new Object[] { Integer.valueOf(this.parallelSize) });
      AppMethodBeat.o(215528);
      return;
      localObject1 = new AssetExtractor();
      Object localObject2 = paramAssetParallelExportSession.asset;
      s.r(localObject2, "exportSession.asset");
      localObject2 = ((Asset)localObject2).getTracks().get(0);
      if (localObject2 == null)
      {
        paramAssetParallelExportSession = new w("null cannot be cast to non-null type com.tencent.tav.asset.AssetTrack<*>");
        AppMethodBeat.o(215528);
        throw paramAssetParallelExportSession;
      }
      localObject2 = ((AssetTrack)localObject2).getSegments().get(0);
      if (localObject2 == null)
      {
        paramAssetParallelExportSession = new w("null cannot be cast to non-null type com.tencent.tav.asset.CompositionTrackSegment");
        AppMethodBeat.o(215528);
        throw paramAssetParallelExportSession;
      }
      ((AssetExtractor)localObject1).setDataSource(((CompositionTrackSegment)localObject2).getSourcePath());
      ((AssetExtractor)localObject1).selectTrack(DecoderUtils.getFirstTrackIndex((AssetExtractor)localObject1, "video/"));
      for (;;)
      {
        localObject2 = paramAssetParallelExportSession.getTimeRange();
        s.r(localObject2, "exportSession.getTimeRange()");
        if ((l1 + l2 >= ((CMTimeRange)localObject2).getEndUs()) || (i >= this.parallelSize - 1)) {
          break;
        }
        ((AssetExtractor)localObject1).seekTo(l1 + l2, 1);
        long l3 = ((AssetExtractor)localObject1).getSampleTime();
        Logger.i("MicroMsg.FixedParallelStrategy", "currentPts:%d sampleTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l3) });
        if ((l3 <= 0L) && (l1 == 0L))
        {
          if (this.parallelSize <= 1) {
            break;
          }
          this.parallelSize -= 1;
          localObject2 = paramAssetParallelExportSession.getTimeRange();
          s.r(localObject2, "exportSession.getTimeRange()");
          l2 = ((CMTimeRange)localObject2).getDurationUs() / this.parallelSize;
          Logger.i("MicroMsg.FixedParallelStrategy", "update parallel size:" + this.parallelSize + " offset:" + l2);
        }
        else
        {
          if (l3 <= l1) {
            break;
          }
          addPipelineIndicator(i, l1 / 1000L, l3 / 1000L, paramArrayList);
          i += 1;
          l1 = l3;
        }
      }
      localObject2 = paramAssetParallelExportSession.timeRange;
      s.r(localObject2, "exportSession.timeRange");
      if (l1 < ((CMTimeRange)localObject2).getEndUs())
      {
        l2 = l1 / 1000L;
        localObject2 = paramAssetParallelExportSession.timeRange;
        s.r(localObject2, "exportSession.timeRange");
        Logger.i("MicroMsg.FixedParallelStrategy", "add last currentPts:%d sampleTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(((CMTimeRange)localObject2).getEndUs()) });
        paramAssetParallelExportSession = paramAssetParallelExportSession.timeRange;
        s.r(paramAssetParallelExportSession, "exportSession.timeRange");
        addPipelineIndicator(i, l2, paramAssetParallelExportSession.getEndUs() / 1000L, paramArrayList);
      }
      ((AssetExtractor)localObject1).release();
    }
  }
  
  public final AssetParallelExportSession getExportSession()
  {
    return this.exportSession;
  }
  
  public final int parallelSize()
  {
    return this.parallelSize;
  }
  
  public final void setExportSession(AssetParallelExportSession paramAssetParallelExportSession)
  {
    AppMethodBeat.i(215536);
    s.t(paramAssetParallelExportSession, "<set-?>");
    this.exportSession = paramAssetParallelExportSession;
    AppMethodBeat.o(215536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.FixedParallelStrategy
 * JD-Core Version:    0.7.0.1
 */