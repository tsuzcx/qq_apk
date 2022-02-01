package com.tencent.tav.core.parallel;

import com.tencent.tav.core.AssetParallelExportSession;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import java.util.ArrayList;

public abstract interface IParallelStrategy
{
  public abstract void calculateSubsection(AssetParallelExportSession paramAssetParallelExportSession, ArrayList<PipelineIndicatorInfo> paramArrayList);
  
  public abstract int parallelSize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.IParallelStrategy
 * JD-Core Version:    0.7.0.1
 */