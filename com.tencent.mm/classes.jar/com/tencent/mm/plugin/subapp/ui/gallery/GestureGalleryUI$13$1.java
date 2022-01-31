package com.tencent.mm.plugin.subapp.ui.gallery;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class GestureGalleryUI$13$1
  implements Runnable
{
  GestureGalleryUI$13$1(GestureGalleryUI.13 param13) {}
  
  public final void run()
  {
    AppMethodBeat.i(25388);
    View localView = GestureGalleryUI.f(this.sYE.sYB).cGX();
    if ((localView instanceof MultiTouchImageView)) {
      ((MultiTouchImageView)localView).dDJ();
    }
    AppMethodBeat.o(25388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.13.1
 * JD-Core Version:    0.7.0.1
 */