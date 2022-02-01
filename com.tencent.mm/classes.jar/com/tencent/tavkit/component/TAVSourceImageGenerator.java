package com.tencent.tavkit.component;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.AssetImageGeneratorResult;
import com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVSourceImageGenerator
{
  public static final String TAG = "TAVSourceImageGenerator";
  private AssetImageGenerator assetImageGenerator;
  
  public TAVSourceImageGenerator(TAVComposition paramTAVComposition, CGSize paramCGSize)
  {
    AppMethodBeat.i(200748);
    init(new TAVCompositionBuilder(paramTAVComposition).buildSource(), paramCGSize);
    AppMethodBeat.o(200748);
  }
  
  public TAVSourceImageGenerator(TAVSource paramTAVSource, CGSize paramCGSize)
  {
    AppMethodBeat.i(200749);
    init(paramTAVSource, paramCGSize);
    AppMethodBeat.o(200749);
  }
  
  private void checkRequestedTimes(List<CMTime> paramList)
  {
    AppMethodBeat.i(200754);
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if (((List)localObject).isEmpty()) {
      ((List)localObject).add(CMTime.CMTimeZero);
    }
    int i = 0;
    while (i < ((List)localObject).size())
    {
      paramList = (CMTime)((List)localObject).get(i);
      if ((paramList == null) || (paramList.getTimeUs() < 0L)) {
        ((List)localObject).set(i, CMTime.CMTimeZero);
      }
      i += 1;
    }
    paramList = new ArrayList(((List)localObject).size());
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      CMTime localCMTime = (CMTime)localIterator.next();
      if (!paramList.contains(localCMTime)) {
        paramList.add(localCMTime);
      }
    }
    ((List)localObject).clear();
    ((List)localObject).addAll(paramList);
    AppMethodBeat.o(200754);
  }
  
  private void init(TAVSource paramTAVSource, CGSize paramCGSize)
  {
    AppMethodBeat.i(200750);
    this.assetImageGenerator = new AssetImageGenerator(paramTAVSource.getAsset());
    this.assetImageGenerator.setMaximumSize(paramCGSize);
    this.assetImageGenerator.setAppliesPreferredTrackTransform(true);
    this.assetImageGenerator.setVideoComposition(paramTAVSource.getVideoComposition());
    AppMethodBeat.o(200750);
  }
  
  public void generateThumbnailAtTime(CMTime paramCMTime, AssetImageGenerator.ImageGeneratorListener paramImageGeneratorListener)
  {
    AppMethodBeat.i(200751);
    ArrayList localArrayList = new ArrayList();
    CMTime localCMTime;
    if (paramCMTime != null)
    {
      localCMTime = paramCMTime;
      if (paramCMTime.getTimeUs() >= 0L) {}
    }
    else
    {
      localCMTime = CMTime.CMTimeZero;
    }
    localArrayList.add(localCMTime);
    generateThumbnailAtTimes(localArrayList, paramImageGeneratorListener);
    AppMethodBeat.o(200751);
  }
  
  public Bitmap generateThumbnailAtTimeSync(CMTime paramCMTime)
  {
    Object localObject = null;
    AppMethodBeat.i(200753);
    if (this.assetImageGenerator != null) {
      if (paramCMTime != null) {
        localObject = paramCMTime;
      }
    }
    try
    {
      if (paramCMTime.getTimeUs() < 0L) {
        localObject = CMTime.CMTimeZero;
      }
      localObject = this.assetImageGenerator.copyCGImageAtTimeAndActualTime((CMTime)localObject, null);
      AppMethodBeat.o(200753);
      return localObject;
    }
    catch (Exception paramCMTime)
    {
      paramCMTime = new Exception(paramCMTime);
      AppMethodBeat.o(200753);
      throw paramCMTime;
    }
  }
  
  /* Error */
  public void generateThumbnailAtTimes(List<CMTime> paramList, final AssetImageGenerator.ImageGeneratorListener paramImageGeneratorListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 157
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 159	com/tencent/tavkit/component/TAVSourceImageGenerator:checkRequestedTimes	(Ljava/util/List;)V
    //   12: aload_1
    //   13: invokeinterface 54 1 0
    //   18: ifne +35 -> 53
    //   21: aload_0
    //   22: getfield 121	com/tencent/tavkit/component/TAVSourceImageGenerator:assetImageGenerator	Lcom/tencent/tav/core/AssetImageGenerator;
    //   25: ifnonnull +11 -> 36
    //   28: ldc 157
    //   30: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: getfield 121	com/tencent/tavkit/component/TAVSourceImageGenerator:assetImageGenerator	Lcom/tencent/tav/core/AssetImageGenerator;
    //   40: aload_1
    //   41: new 6	com/tencent/tavkit/component/TAVSourceImageGenerator$1
    //   44: dup
    //   45: aload_0
    //   46: aload_2
    //   47: invokespecial 162	com/tencent/tavkit/component/TAVSourceImageGenerator$1:<init>	(Lcom/tencent/tavkit/component/TAVSourceImageGenerator;Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;)V
    //   50: invokevirtual 165	com/tencent/tav/core/AssetImageGenerator:generateCGImagesAsynchronouslyForTimes	(Ljava/util/List;Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;)V
    //   53: ldc 157
    //   55: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -25 -> 33
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	TAVSourceImageGenerator
    //   0	66	1	paramList	List<CMTime>
    //   0	66	2	paramImageGeneratorListener	AssetImageGenerator.ImageGeneratorListener
    // Exception table:
    //   from	to	target	type
    //   2	33	61	finally
    //   36	53	61	finally
    //   53	58	61	finally
  }
  
  public AssetImageGenerator getAssetImageGenerator()
  {
    return this.assetImageGenerator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVSourceImageGenerator
 * JD-Core Version:    0.7.0.1
 */