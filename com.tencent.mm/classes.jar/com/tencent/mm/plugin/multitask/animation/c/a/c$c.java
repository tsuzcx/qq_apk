package com.tencent.mm.plugin.multitask.animation.c.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "t", "getInterpolation"})
final class c$c
  implements Interpolator
{
  public static final c AaA;
  
  static
  {
    AppMethodBeat.i(200455);
    AaA = new c();
    AppMethodBeat.o(200455);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.c.a.c.c
 * JD-Core Version:    0.7.0.1
 */