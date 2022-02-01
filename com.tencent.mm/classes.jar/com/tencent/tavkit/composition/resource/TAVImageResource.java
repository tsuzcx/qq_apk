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
  private boolean emptyAudioTrack;
  private CIImage image;
  
  public TAVImageResource(CIImage paramCIImage, CMTime paramCMTime)
  {
    this(paramCIImage, paramCMTime, false);
  }
  
  public TAVImageResource(CIImage paramCIImage, CMTime paramCMTime, boolean paramBoolean)
  {
    AppMethodBeat.i(219889);
    this.ciImageHashMap = new HashMap();
    this.image = paramCIImage;
    this.duration = paramCMTime;
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
    this.emptyAudioTrack = paramBoolean;
    AppMethodBeat.o(219889);
  }
  
  public TAVResource clone()
  {
    AppMethodBeat.i(219892);
    TAVImageResource localTAVImageResource = new TAVImageResource(this.image, this.duration.clone(), this.emptyAudioTrack);
    localTAVImageResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVImageResource.scaledDuration = this.scaledDuration.clone();
    localTAVImageResource.ciImageHashMap = this.ciImageHashMap;
    AppMethodBeat.o(219892);
    return localTAVImageResource;
  }
  
  public CIImage imageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    AppMethodBeat.i(219890);
    if (!this.sourceTimeRange.containsTime(paramCMTime))
    {
      AppMethodBeat.o(219890);
      return null;
    }
    if (this.image == null)
    {
      AppMethodBeat.o(219890);
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
    AppMethodBeat.o(219890);
    return paramCMTime;
  }
  
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219891);
    TrackInfo localTrackInfo;
    if (paramInt1 == 1)
    {
      localTrackInfo = newEmptyTrackInfo(paramInt1, paramInt2);
      AppMethodBeat.o(219891);
      return localTrackInfo;
    }
    if ((this.emptyAudioTrack) && (paramInt1 == 2))
    {
      localTrackInfo = newEmptyTrackInfo(paramInt1, paramInt2);
      AppMethodBeat.o(219891);
      return localTrackInfo;
    }
    AppMethodBeat.o(219891);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVImageResource
 * JD-Core Version:    0.7.0.1
 */