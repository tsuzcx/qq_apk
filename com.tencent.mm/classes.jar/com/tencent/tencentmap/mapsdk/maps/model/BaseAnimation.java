package com.tencent.tencentmap.mapsdk.maps.model;

import android.view.animation.Interpolator;

public abstract class BaseAnimation
  implements Animation
{
  private AnimationListener mAnimationListener;
  private long mDuration;
  private Interpolator mInterpolator;
  
  public AnimationListener getAnimationListener()
  {
    return this.mAnimationListener;
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  public void setAnimationListener(AnimationListener paramAnimationListener)
  {
    this.mAnimationListener = paramAnimationListener;
  }
  
  public void setDuration(long paramLong)
  {
    this.mDuration = paramLong;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BaseAnimation
 * JD-Core Version:    0.7.0.1
 */