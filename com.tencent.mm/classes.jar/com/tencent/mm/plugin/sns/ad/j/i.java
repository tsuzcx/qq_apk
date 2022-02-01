package com.tencent.mm.plugin.sns.ad.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class i
{
  private static final Random Qds;
  
  static
  {
    AppMethodBeat.i(309722);
    Qds = new Random();
    AppMethodBeat.o(309722);
  }
  
  public static float aR(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(309715);
    float f = Math.min(paramFloat1, paramFloat2);
    paramFloat1 = Math.max(paramFloat1, paramFloat2);
    paramFloat2 = Qds.nextFloat();
    AppMethodBeat.o(309715);
    return f + (paramFloat1 - f) * paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.j.i
 * JD-Core Version:    0.7.0.1
 */