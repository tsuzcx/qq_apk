package com.tencent.tavkit.composition.resource;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.HashMap;

public class TAVImageResource
  extends TAVResource
{
  private HashMap<Thread, CIImage> ciImageHashMap;
  private CIImage image;
  
  public TAVImageResource(CIImage paramCIImage, CMTime paramCMTime)
  {
    AppMethodBeat.i(204718);
    this.ciImageHashMap = new HashMap();
    this.image = paramCIImage;
    this.duration = paramCMTime;
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
    AppMethodBeat.o(204718);
  }
  
  public TAVResource clone()
  {
    AppMethodBeat.i(204721);
    TAVImageResource localTAVImageResource = new TAVImageResource(this.image, this.duration.clone());
    localTAVImageResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVImageResource.scaledDuration = this.scaledDuration.clone();
    localTAVImageResource.ciImageHashMap = this.ciImageHashMap;
    AppMethodBeat.o(204721);
    return localTAVImageResource;
  }
  
  public CIImage imageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    AppMethodBeat.i(204719);
    if (!this.sourceTimeRange.containsTime(paramCMTime))
    {
      AppMethodBeat.o(204719);
      return null;
    }
    if (this.image == null)
    {
      AppMethodBeat.o(204719);
      return null;
    }
    Thread localThread = Thread.currentThread();
    paramCGSize = (CIImage)this.ciImageHashMap.get(localThread);
    paramCMTime = paramCGSize;
    if (paramCGSize == null)
    {
      paramCMTime = this.image.simpleClone();
      this.ciImageHashMap.put(localThread, paramCMTime);
    }
    paramCMTime.reset();
    AppMethodBeat.o(204719);
    return paramCMTime;
  }
  
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204720);
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(204720);
      return null;
    }
    TrackInfo localTrackInfo = super.trackInfoForType(paramInt1, paramInt2);
    AppMethodBeat.o(204720);
    return localTrackInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVImageResource
 * JD-Core Version:    0.7.0.1
 */