package com.tencent.mm.view;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PhotoView$c
  implements Interpolator
{
  Interpolator Rlb;
  
  private PhotoView$c(PhotoView paramPhotoView)
  {
    AppMethodBeat.i(164267);
    this.Rlb = new DecelerateInterpolator();
    AppMethodBeat.o(164267);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    AppMethodBeat.i(164268);
    if (this.Rlb != null)
    {
      paramFloat = this.Rlb.getInterpolation(paramFloat);
      AppMethodBeat.o(164268);
      return paramFloat;
    }
    AppMethodBeat.o(164268);
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView.c
 * JD-Core Version:    0.7.0.1
 */