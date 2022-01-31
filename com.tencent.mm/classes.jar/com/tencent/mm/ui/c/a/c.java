package com.tencent.mm.ui.c.a;

import android.view.animation.DecelerateInterpolator;

public final class c
  extends DecelerateInterpolator
{
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.5D) {
      return super.getInterpolation(2.0F * paramFloat);
    }
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */