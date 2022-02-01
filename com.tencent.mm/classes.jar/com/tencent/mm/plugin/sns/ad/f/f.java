package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class f
{
  private static final Random zsf;
  
  static
  {
    AppMethodBeat.i(219178);
    zsf = new Random();
    AppMethodBeat.o(219178);
  }
  
  public static float ae(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(219177);
    float f = Math.min(paramFloat1, paramFloat2);
    paramFloat1 = Math.max(paramFloat1, paramFloat2);
    paramFloat2 = zsf.nextFloat();
    AppMethodBeat.o(219177);
    return f + (paramFloat1 - f) * paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.f
 * JD-Core Version:    0.7.0.1
 */