package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class i
{
  private static final Random JLF;
  
  static
  {
    AppMethodBeat.i(202392);
    JLF = new Random();
    AppMethodBeat.o(202392);
  }
  
  public static float an(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(202389);
    float f = Math.min(paramFloat1, paramFloat2);
    paramFloat1 = Math.max(paramFloat1, paramFloat2);
    paramFloat2 = JLF.nextFloat();
    AppMethodBeat.o(202389);
    return f + (paramFloat1 - f) * paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.i
 * JD-Core Version:    0.7.0.1
 */