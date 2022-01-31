package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.g;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class StoryGalleryView$l
  implements DialogInterface.OnClickListener
{
  StoryGalleryView$l(StoryGalleryView paramStoryGalleryView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(110812);
    paramDialogInterface = StoryGalleryView.l(this.sTX);
    if (paramDialogInterface != null)
    {
      paramInt = StoryGalleryView.h(this.sTX);
      int i = StoryGalleryView.m(this.sTX);
      a locala = StoryGalleryView.o(this.sTX);
      if (locala != null) {}
      for (boolean bool = locala.rUw;; bool = false)
      {
        paramDialogInterface.n(paramInt, i, bool);
        AppMethodBeat.o(110812);
        return;
      }
    }
    AppMethodBeat.o(110812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.l
 * JD-Core Version:    0.7.0.1
 */