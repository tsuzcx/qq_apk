package com.tencent.mm.plugin.sns.ui.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

final class e
{
  private static final Random xZc;
  
  static
  {
    AppMethodBeat.i(179430);
    xZc = new Random();
    AppMethodBeat.o(179430);
  }
  
  public static float Z(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(179429);
    float f = Math.min(paramFloat1, paramFloat2);
    paramFloat1 = Math.max(paramFloat1, paramFloat2);
    paramFloat2 = xZc.nextFloat();
    AppMethodBeat.o(179429);
    return f + (paramFloat1 - f) * paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.e
 * JD-Core Version:    0.7.0.1
 */