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
    if (PhotoView.h(this.Rla) != null) {
      PhotoView.h(this.Rla).onClick(this.Rla);
    }
    AppMethodBeat.o(164252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView.3
 * JD-Core Version:    0.7.0.1
 */