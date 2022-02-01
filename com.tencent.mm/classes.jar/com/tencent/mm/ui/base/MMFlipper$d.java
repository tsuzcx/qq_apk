package com.tencent.mm.ui.base;

import android.view.animation.Interpolator;

final class MMFlipper$d
  implements Interpolator
{
  private float BAe = 1.3F;
  
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFlipper.d
 * JD-Core Version:    0.7.0.1
 */