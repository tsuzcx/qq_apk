package com.tencent.mm.ui.anim.e;

import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends DecelerateInterpolator
{
  public final float getInterpolation(float paramFloat)
  {
    AppMethodBeat.i(141580);
    if (paramFloat <= 0.5D)
    {
      paramFloat = super.getInterpolation(2.0F * paramFloat);
      AppMethodBeat.o(141580);
      return paramFloat;
    }
    AppMethodBeat.o(141580);
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.anim.e.d
 * JD-Core Version:    0.7.0.1
 */