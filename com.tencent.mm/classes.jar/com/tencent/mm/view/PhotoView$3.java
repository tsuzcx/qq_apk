package com.tencent.mm.view;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PhotoView$3
  implements Runnable
{
  PhotoView$3(PhotoView paramPhotoView) {}
  
  public final void run()
  {
    AppMethodBeat.i(164252);
    if (PhotoView.g(this.agIr) != null) {
      PhotoView.g(this.agIr).onClick(this.agIr);
    }
    AppMethodBeat.o(164252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView.3
 * JD-Core Version:    0.7.0.1
 */