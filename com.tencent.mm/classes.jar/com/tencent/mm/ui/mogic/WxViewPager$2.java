package com.tencent.mm.ui.mogic;

import android.view.animation.Interpolator;

final class WxViewPager$2
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.WxViewPager.2
 * JD-Core Version:    0.7.0.1
 */