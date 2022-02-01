package com.tencent.tav.core.composition;

import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.Transform;

public abstract interface VideoCompositionLayerInstruction
{
  public abstract CropRectangleRamp getCropRectangleRampForTime(CMTime paramCMTime);
  
  public abstract OpacityRamp getOpacityRampForTime(CMTime paramCMTime);
  
  public abstract int getTrackID();
  
  public abstract TransformRamp getTransformRampForTime(CMTime paramCMTime);
  
  public static class CropRectangleRamp
  {
    public boolean available = true;
    public CGRect endCropRectangle;
    public CGRect startCropRectangle;
    public CMTimeRange timeRange;
    
    public CropRectangleRamp(CMTimeRange paramCMTimeRange)
    {
      this.timeRange = paramCMTimeRange;
    }
  }
  
  public static class OpacityRamp
  {
    public boolean available = true;
    public float endOpacity = 1.0F;
    public float startOpacity = 1.0F;
    public CMTimeRange timeRange;
    
    public OpacityRamp(CMTimeRange paramCMTimeRange)
    {
      this.timeRange = paramCMTimeRange;
    }
  }
  
  public static class TransformRamp
  {
    public boolean available = true;
    public Transform endTransform;
    public Transform startTransform;
    public CMTimeRange timeRange;
    
    public TransformRamp(CMTimeRange paramCMTimeRange)
    {
      this.timeRange = paramCMTimeRange;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoCompositionLayerInstruction
 * JD-Core Version:    0.7.0.1
 */