package com.tencent.mm.ui.c.a;

import android.view.animation.CycleInterpolator;

public final class b
  extends CycleInterpolator
{
  public b()
  {
    super(0.5F);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    return (float)(1.0D - Math.pow(2.0F * paramFloat - 1.0F, 2.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */