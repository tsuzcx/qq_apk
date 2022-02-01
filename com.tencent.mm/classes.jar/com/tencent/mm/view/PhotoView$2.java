package com.tencent.mm.view;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PhotoView$2
  implements ScaleGestureDetector.OnScaleGestureListener
{
  PhotoView$2(PhotoView paramPhotoView) {}
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(164251);
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((Float.isNaN(f)) || (Float.isInfinite(f)))
    {
      AppMethodBeat.o(164251);
      return false;
    }
    PhotoView.c(this.Rla, PhotoView.f(this.Rla) * f);
    PhotoView.d(this.Rla).postScale(f, f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    PhotoView.g(this.Rla);
    AppMethodBeat.o(164251);
    return true;
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView.2
 * JD-Core Version:    0.7.0.1
 */