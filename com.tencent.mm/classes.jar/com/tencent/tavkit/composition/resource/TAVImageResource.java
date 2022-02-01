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
    AppMethodBeat.i(192090);
    this.ciImageHashMap = new HashMap();
    this.image = paramCIImage;
    this.duration = paramCMTime;
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
    AppMethodBeat.o(192090);
  }
  
  public TAVResource clone()
  {
    AppMethodBeat.i(192093);
    TAVImageResource localTAVImageResource = new TAVImageResource(this.image, this.duration.clone());
    localTAVImageResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVImageResource.scaledDuration = this.scaledDuration.clone();
    localTAVImageResource.ciImageHashMap = this.ciImageHashMap;
    AppMethodBeat.o(192093);
    return localTAVImageResource;
  }
  
  public CIImage imageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    AppMethodBeat.i(192091);
    if (!this.sourceTimeRange.containsTime(paramCMTime))
    {
      AppMethodBeat.o(192091);
      return null;
    }
    if (this.image == null)
    {
      AppMethodBeat.o(192091);
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
    AppMethodBeat.o(192091);
    return paramCMTime;
  }
  
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192092);
    if (paramInt1 != 1)
    {
      AppMethodBeat.o(192092);
      return null;
    }
    TrackInfo localTrackInfo = super.trackInfoForType(paramInt1, paramInt2);
    AppMethodBeat.o(192092);
    return localTrackInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVImageResource
 * JD-Core Version:    0.7.0.1
 */