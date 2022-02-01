package com.tencent.tav.core.parallel;

import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;

public abstract class BaseParallelStrategy
  implements IParallelStrategy
{
  protected static final String TAG = "SimpleParallelStrategy";
  
  protected void addPipelineIndicator(int paramInt, long paramLong1, long paramLong2, ArrayList<PipelineIndicatorInfo> paramArrayList)
  {
    if ((paramLong1 < 0L) || (paramLong1 >= paramLong2)) {
      return;
    }
    Logger.i("SimpleParallelStrategy", "index:%d  CMRange[%d %d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    paramArrayList.add(new PipelineIndicatorInfo(1, paramInt, new CMTimeRange(CMTime.fromMs(paramLong1), CMTime.fromMs(paramLong2 - paramLong1))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.BaseParallelStrategy
 * JD-Core Version:    0.7.0.1
 */