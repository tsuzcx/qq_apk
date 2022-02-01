package com.tencent.mm.ui.c.a;

import android.view.animation.BounceInterpolator;

public final class a
  extends BounceInterpolator
{
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.3636363636363637D) {
      return (float)(paramFloat * 7.5625D * paramFloat);
    }
    if (paramFloat < 0.7272727272727273D)
    {
      paramFloat = (float)(paramFloat - 0.5454545454545454D);
      d = paramFloat;
      return (float)(paramFloat * (d * 7.5625D) + 0.75D);
    }
    paramFloat = (float)(paramFloat - 0.8181818181818182D);
    double d = paramFloat;
    return (float)(paramFloat * (d * 7.5625D) + 0.9375D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.a
 * JD-Core Version:    0.7.0.1
 */