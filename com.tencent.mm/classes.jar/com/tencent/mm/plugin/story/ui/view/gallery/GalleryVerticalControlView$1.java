package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.a.a;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class GalleryVerticalControlView$1
  implements View.OnClickListener
{
  GalleryVerticalControlView$1(GalleryVerticalControlView paramGalleryVerticalControlView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110750);
    paramView = this.sSW.getOnClose();
    if (paramView != null)
    {
      paramView.invoke();
      AppMethodBeat.o(110750);
      return;
    }
    AppMethodBeat.o(110750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView.1
 * JD-Core Version:    0.7.0.1
 */