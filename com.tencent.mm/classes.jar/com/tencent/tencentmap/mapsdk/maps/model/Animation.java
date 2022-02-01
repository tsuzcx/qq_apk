package com.tencent.tencentmap.mapsdk.maps.model;

import android.view.animation.Interpolator;

public abstract interface Animation
{
  public abstract AnimationListener getAnimationListener();
  
  public abstract long getDuration();
  
  public abstract Interpolator getInterpolator();
  
  public abstract void setAnimationListener(AnimationListener paramAnimationListener);
  
  public abstract void setDuration(long paramLong);
  
  public abstract void setInterpolator(Interpolator paramInterpolator);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.Animation
 * JD-Core Version:    0.7.0.1
 */