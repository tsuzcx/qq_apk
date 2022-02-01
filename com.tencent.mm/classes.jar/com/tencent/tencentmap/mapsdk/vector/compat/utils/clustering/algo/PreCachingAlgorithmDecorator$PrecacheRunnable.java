package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import com.tencent.matrix.trace.core.AppMethodBeat;

class PreCachingAlgorithmDecorator$PrecacheRunnable
  implements Runnable
{
  private final int b;
  
  public PreCachingAlgorithmDecorator$PrecacheRunnable(PreCachingAlgorithmDecorator paramPreCachingAlgorithmDecorator, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    AppMethodBeat.i(217732);
    try
    {
      Thread.sleep((Math.random() * 500.0D + 500.0D));
      label20:
      PreCachingAlgorithmDecorator.a(this.a, this.b);
      AppMethodBeat.o(217732);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label20;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.PreCachingAlgorithmDecorator.PrecacheRunnable
 * JD-Core Version:    0.7.0.1
 */