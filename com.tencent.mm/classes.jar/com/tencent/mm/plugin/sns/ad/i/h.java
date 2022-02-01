package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class h
{
  private static final Random DAg;
  
  static
  {
    AppMethodBeat.i(202361);
    DAg = new Random();
    AppMethodBeat.o(202361);
  }
  
  public static float al(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(202360);
    float f = Math.min(paramFloat1, paramFloat2);
    paramFloat1 = Math.max(paramFloat1, paramFloat2);
    paramFloat2 = DAg.nextFloat();
    AppMethodBeat.o(202360);
    return f + (paramFloat1 - f) * paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.h
 * JD-Core Version:    0.7.0.1
 */