package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.a.a;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class GalleryVerticalControlView$2
  implements View.OnClickListener
{
  GalleryVerticalControlView$2(GalleryVerticalControlView paramGalleryVerticalControlView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110751);
    paramView = this.sSW.getOnMenu();
    if (paramView != null)
    {
      paramView.invoke();
      AppMethodBeat.o(110751);
      return;
    }
    AppMethodBeat.o(110751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView.2
 * JD-Core Version:    0.7.0.1
 */