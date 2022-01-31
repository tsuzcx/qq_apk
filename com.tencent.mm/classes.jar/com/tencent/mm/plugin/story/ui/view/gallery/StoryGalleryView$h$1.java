package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.g;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class StoryGalleryView$h$1
  implements DialogInterface.OnCancelListener
{
  StoryGalleryView$h$1(StoryGalleryView.h paramh) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(110807);
    paramDialogInterface = StoryGalleryView.sTW;
    ab.i(StoryGalleryView.access$getTAG$cp(), "delete click and click cancel it " + StoryGalleryView.h(this.sUd.sTX) + ' ' + StoryGalleryView.m(this.sUd.sTX));
    paramDialogInterface = StoryGalleryView.l(this.sUd.sTX);
    if (paramDialogInterface != null)
    {
      StoryGalleryView.h(this.sUd.sTX);
      StoryGalleryView.m(this.sUd.sTX);
      paramDialogInterface.cCl();
      AppMethodBeat.o(110807);
      return;
    }
    AppMethodBeat.o(110807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.h.1
 * JD-Core Version:    0.7.0.1
 */