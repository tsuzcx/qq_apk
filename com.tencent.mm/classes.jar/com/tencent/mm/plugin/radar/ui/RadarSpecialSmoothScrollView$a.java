package com.tencent.mm.plugin.radar.ui;

import a.l;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator;", "Landroid/view/animation/Interpolator;", "()V", "mTension", "", "getInterpolation", "t", "Companion", "plugin-radar_release"})
final class RadarSpecialSmoothScrollView$a
  implements Interpolator
{
  private static final float pRN = 1.3F;
  public static final RadarSpecialSmoothScrollView.a.a pRO;
  private final float pRM = pRN;
  
  static
  {
    AppMethodBeat.i(103008);
    pRO = new RadarSpecialSmoothScrollView.a.a((byte)0);
    pRN = 1.3F;
    AppMethodBeat.o(103008);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return (paramFloat * (this.pRM + 1.0F) + this.pRM) * (paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialSmoothScrollView.a
 * JD-Core Version:    0.7.0.1
 */