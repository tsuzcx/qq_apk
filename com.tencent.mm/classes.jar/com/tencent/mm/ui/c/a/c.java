package com.tencent.mm.ui.c.a;

import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends DecelerateInterpolator
{
  public final float getInterpolation(float paramFloat)
  {
    AppMethodBeat.i(106220);
    if (paramFloat <= 0.5D)
    {
      paramFloat = super.getInterpolation(2.0F * paramFloat);
      AppMethodBeat.o(106220);
      return paramFloat;
    }
    AppMethodBeat.o(106220);
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */