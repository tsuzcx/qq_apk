package com.tencent.mm.plugin.multitask.animation.c.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "t", "getInterpolation"})
final class b$c
  implements Interpolator
{
  public static final c FGq;
  
  static
  {
    AppMethodBeat.i(247706);
    FGq = new c();
    AppMethodBeat.o(247706);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.a.b.c
 * JD-Core Version:    0.7.0.1
 */