package com.tencent.mm.ui.base;

import android.view.animation.Interpolator;

final class MMFlipper$c
  implements Interpolator
{
  private float nmx = 1.3F;
  
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFlipper.c
 * JD-Core Version:    0.7.0.1
 */