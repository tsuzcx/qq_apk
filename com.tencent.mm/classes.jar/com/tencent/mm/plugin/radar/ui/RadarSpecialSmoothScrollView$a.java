package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Interpolator;

final class RadarSpecialSmoothScrollView$a
  implements Interpolator
{
  private static final float nmy = 1.3F;
  public static final RadarSpecialSmoothScrollView.a.a nmz = new RadarSpecialSmoothScrollView.a.a((byte)0);
  private final float nmx = nmy;
  
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return (paramFloat * (this.nmx + 1.0F) + this.nmx) * (paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialSmoothScrollView.a
 * JD-Core Version:    0.7.0.1
 */