package com.tencent.mm.plugin.subapp.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.tools.e.b;

final class GestureGalleryUI$13
  implements e.b
{
  GestureGalleryUI$13(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(25391);
    GestureGalleryUI.g(this.sYB).post(new GestureGalleryUI.13.2(this));
    GestureGalleryUI.a(this.sYB, false);
    AppMethodBeat.o(25391);
  }
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(25390);
    GestureGalleryUI.a(this.sYB, true);
    GestureGalleryUI.g(this.sYB).postDelayed(new GestureGalleryUI.13.1(this), 20L);
    AppMethodBeat.o(25390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.13
 * JD-Core Version:    0.7.0.1
 */