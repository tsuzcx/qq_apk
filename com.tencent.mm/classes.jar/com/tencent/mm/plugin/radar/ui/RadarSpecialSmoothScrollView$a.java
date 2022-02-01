package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator;", "Landroid/view/animation/Interpolator;", "()V", "mTension", "", "getInterpolation", "t", "Companion", "plugin-radar_release"})
final class RadarSpecialSmoothScrollView$a
  implements Interpolator
{
  private static final float wcy = 1.3F;
  public static final a wcz;
  private final float wcx = wcy;
  
  static
  {
    AppMethodBeat.i(138654);
    wcz = new a((byte)0);
    wcy = 1.3F;
    AppMethodBeat.o(138654);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return (paramFloat * (this.wcx + 1.0F) + this.wcx) * (paramFloat * paramFloat) + 1.0F;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator$Companion;", "", "()V", "DEFAULT_TENSION", "", "plugin-radar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialSmoothScrollView.a
 * JD-Core Version:    0.7.0.1
 */