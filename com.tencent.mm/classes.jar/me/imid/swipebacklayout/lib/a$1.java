package me.imid.swipebacklayout.lib;

import android.view.animation.Interpolator;

final class a$1
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.a.1
 * JD-Core Version:    0.7.0.1
 */