package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator;", "Landroid/view/animation/Interpolator;", "()V", "mTension", "", "getInterpolation", "t", "Companion", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
final class RadarSpecialSmoothScrollView$a
  implements Interpolator
{
  public static final a Ntj;
  private static final float Ntl;
  private final float Ntk = Ntl;
  
  static
  {
    AppMethodBeat.i(138654);
    Ntj = new a((byte)0);
    Ntl = 1.3F;
    AppMethodBeat.o(138654);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return (paramFloat * (this.Ntk + 1.0F) + this.Ntk) * (paramFloat * paramFloat) + 1.0F;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator$Companion;", "", "()V", "DEFAULT_TENSION", "", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialSmoothScrollView.a
 * JD-Core Version:    0.7.0.1
 */