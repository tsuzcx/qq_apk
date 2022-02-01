package com.tencent.mm.view.refreshLayout.c;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/interpolator/ReboundInterpolator;", "Landroid/view/animation/Interpolator;", "type", "", "(I)V", "getInterpolation", "", "input", "viscousFluid", "outX", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements Interpolator
{
  public static final a agQp;
  private static float agQq;
  private static float agQr;
  private static float agQs;
  private final int type;
  
  static
  {
    AppMethodBeat.i(235167);
    agQp = new a((byte)0);
    agQq = 8.0F;
    AppMethodBeat.o(235167);
  }
  
  public a()
  {
    AppMethodBeat.i(235157);
    this.type = 0;
    agQr = 1.0F / eA(1.0F);
    agQs = 1.0F - agQr * eA(1.0F);
    AppMethodBeat.o(235157);
  }
  
  private static float eA(float paramFloat)
  {
    AppMethodBeat.i(235163);
    paramFloat = agQq * paramFloat;
    if (paramFloat < 1.0F) {}
    for (paramFloat -= 1.0F - (float)Math.exp(-paramFloat);; paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * 0.6321206F + 0.3678795F)
    {
      AppMethodBeat.o(235163);
      return paramFloat;
    }
  }
  
  public final float getInterpolation(float paramFloat)
  {
    AppMethodBeat.i(235171);
    if (this.type == 1)
    {
      AppMethodBeat.o(235171);
      return 1.0F - (1.0F - paramFloat) * (1.0F - paramFloat);
    }
    paramFloat = agQr * eA(paramFloat);
    if (paramFloat > 0.0F)
    {
      float f = agQs;
      AppMethodBeat.o(235171);
      return paramFloat + f;
    }
    AppMethodBeat.o(235171);
    return paramFloat;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/interpolator/ReboundInterpolator$Companion;", "", "()V", "INTERPOLATOR_DECELERATE", "", "INTERPOLATOR_VISCOUS_FLUID", "VISCOUS_FLUID_NORMALIZE", "", "VISCOUS_FLUID_OFFSET", "VISCOUS_FLUID_SCALE", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.c.a
 * JD-Core Version:    0.7.0.1
 */