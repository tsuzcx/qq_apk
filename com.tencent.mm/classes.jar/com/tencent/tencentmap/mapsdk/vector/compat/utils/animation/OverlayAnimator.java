package com.tencent.tencentmap.mapsdk.vector.compat.utils.animation;

import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;

public abstract class OverlayAnimator
{
  private Object a;
  private long b;
  private AnimatorSet c;
  
  protected OverlayAnimator(Object paramObject, long paramLong)
  {
    this.a = paramObject;
    this.b = paramLong;
    this.c = new AnimatorSet();
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.c.addListener(paramAnimatorListener);
  }
  
  public void cancelAnimation()
  {
    try
    {
      this.c.cancel();
      return;
    }
    finally {}
  }
  
  protected abstract ValueAnimator createSegmentAnimator(int paramInt);
  
  public void endAnimation()
  {
    try
    {
      this.c.end();
      return;
    }
    finally {}
  }
  
  protected AnimatorSet getAnimatorSet()
  {
    return this.c;
  }
  
  public long getDuration()
  {
    return this.b;
  }
  
  public Object getObject()
  {
    return this.a;
  }
  
  protected void setAnimatorSet(AnimatorSet paramAnimatorSet)
  {
    this.c = paramAnimatorSet;
  }
  
  public void setDuration(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void setObject(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public void startAnimation()
  {
    try
    {
      if (!this.c.isRunning()) {
        this.c.start();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.OverlayAnimator
 * JD-Core Version:    0.7.0.1
 */