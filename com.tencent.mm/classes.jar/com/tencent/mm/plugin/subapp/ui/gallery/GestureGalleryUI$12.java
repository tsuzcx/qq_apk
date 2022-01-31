package com.tencent.mm.plugin.subapp.ui.gallery;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.e;

final class GestureGalleryUI$12
  implements ViewTreeObserver.OnPreDrawListener
{
  GestureGalleryUI$12(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(25387);
    GestureGalleryUI.a(this.sYB).getViewTreeObserver().removeOnPreDrawListener(this);
    GestureGalleryUI.d(this.sYB).a(GestureGalleryUI.a(this.sYB), null, null);
    GestureGalleryUI.e(this.sYB);
    AppMethodBeat.o(25387);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.12
 * JD-Core Version:    0.7.0.1
 */