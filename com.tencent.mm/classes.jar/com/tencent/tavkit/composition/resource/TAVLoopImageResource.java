package com.tencent.tavkit.composition.resource;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavkit/composition/resource/TAVLoopImageResource;", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "images", "", "Lcom/tencent/tavkit/ciimage/CIImage;", "interval", "Lcom/tencent/tav/coremedia/CMTime;", "duration", "(Ljava/util/List;Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;)V", "ciImageHashMap", "Ljava/lang/ThreadLocal;", "Landroid/util/SparseArray;", "clone", "imageAtTime", "time", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "tavkit_release"}, k=1, mv={1, 1, 15})
public final class TAVLoopImageResource
  extends TAVResource
{
  private final ThreadLocal<SparseArray<CIImage>> ciImageHashMap;
  private final List<CIImage> images;
  private final CMTime interval;
  
  public TAVLoopImageResource(List<? extends CIImage> paramList, CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(218856);
    this.images = paramList;
    this.interval = paramCMTime1;
    this.ciImageHashMap = new ThreadLocal();
    setDuration(paramCMTime2);
    setSourceTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramCMTime2));
    AppMethodBeat.o(218856);
  }
  
  public final TAVResource clone()
  {
    AppMethodBeat.i(218875);
    Object localObject = this.images;
    CMTime localCMTime1 = this.interval;
    CMTime localCMTime2 = this.duration;
    s.r(localCMTime2, "duration");
    localObject = (TAVResource)new TAVLoopImageResource((List)localObject, localCMTime1, localCMTime2);
    AppMethodBeat.o(218875);
    return localObject;
  }
  
  public final CIImage imageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    AppMethodBeat.i(218895);
    s.t(paramCMTime, "time");
    s.t(paramCGSize, "renderSize");
    if (!this.sourceTimeRange.containsTime(paramCMTime))
    {
      AppMethodBeat.o(218895);
      return null;
    }
    if (this.images.isEmpty())
    {
      AppMethodBeat.o(218895);
      return null;
    }
    ThreadLocal localThreadLocal = this.ciImageHashMap;
    Object localObject = localThreadLocal.get();
    paramCGSize = localObject;
    if (localObject == null)
    {
      paramCGSize = new SparseArray();
      localThreadLocal.set(paramCGSize);
    }
    paramCGSize = (SparseArray)paramCGSize;
    int i = (int)(paramCMTime.getTimeUs() / this.interval.getTimeUs() % this.images.size());
    paramCMTime = (CIImage)paramCGSize.get(i);
    if (paramCMTime != null)
    {
      paramCMTime.reset();
      AppMethodBeat.o(218895);
      return paramCMTime;
    }
    paramCGSize.put(i, ((CIImage)this.images.get(i)).clone());
    paramCMTime = (CIImage)paramCGSize.get(i);
    AppMethodBeat.o(218895);
    return paramCMTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVLoopImageResource
 * JD-Core Version:    0.7.0.1
 */