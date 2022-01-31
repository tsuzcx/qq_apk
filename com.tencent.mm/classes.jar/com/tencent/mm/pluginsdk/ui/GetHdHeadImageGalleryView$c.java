package com.tencent.mm.pluginsdk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

final class GetHdHeadImageGalleryView$c
  implements MMGestureGallery.f
{
  private GetHdHeadImageGalleryView$c(GetHdHeadImageGalleryView paramGetHdHeadImageGalleryView) {}
  
  public final void bdW()
  {
    AppMethodBeat.i(79685);
    if (GetHdHeadImageGalleryView.a(this.vQD) != null) {
      GetHdHeadImageGalleryView.a(this.vQD).dismiss();
    }
    AppMethodBeat.o(79685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView.c
 * JD-Core Version:    0.7.0.1
 */