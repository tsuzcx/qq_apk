package com.tencent.tavkit.composition.model;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.ciimage.CIImage;

public abstract interface TAVVideoCompositionTrack
{
  public abstract Object getExtraTrackInfo(String paramString);
  
  public abstract int numberOfVideoTracks();
  
  public abstract void putExtraTrackInfo(String paramString, Object paramObject);
  
  public abstract CIImage sourceImageAtTime(CMTime paramCMTime, CGSize paramCGSize);
  
  public abstract CompositionTrack videoCompositionTrackForComposition(MutableComposition paramMutableComposition, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVVideoCompositionTrack
 * JD-Core Version:    0.7.0.1
 */