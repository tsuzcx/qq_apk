package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class f
{
  private static final Random zbC;
  
  static
  {
    AppMethodBeat.i(197706);
    zbC = new Random();
    AppMethodBeat.o(197706);
  }
  
  public static float ae(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(197705);
    float f = Math.min(paramFloat1, paramFloat2);
    paramFloat1 = Math.max(paramFloat1, paramFloat2);
    paramFloat2 = zbC.nextFloat();
    AppMethodBeat.o(197705);
    return f + (paramFloat1 - f) * paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.f
 * JD-Core Version:    0.7.0.1
 */