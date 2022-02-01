package com.tencent.mm.plugin.sns.ui.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

final class f
{
  private static final Random zmc;
  
  static
  {
    AppMethodBeat.i(179430);
    zmc = new Random();
    AppMethodBeat.o(179430);
  }
  
  public static float ad(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(179429);
    float f = Math.min(paramFloat1, paramFloat2);
    paramFloat1 = Math.max(paramFloat1, paramFloat2);
    paramFloat2 = zmc.nextFloat();
    AppMethodBeat.o(179429);
    return f + (paramFloat1 - f) * paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.f
 * JD-Core Version:    0.7.0.1
 */