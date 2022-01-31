package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.g;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.e.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "bOk", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
final class StoryGalleryView$h
  implements e.c
{
  StoryGalleryView$h(StoryGalleryView paramStoryGalleryView, j paramj) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(110808);
    paramString = StoryGalleryView.sTW;
    ab.i(StoryGalleryView.access$getTAG$cp(), "delete click and click ok it " + StoryGalleryView.h(this.sTX) + ' ' + StoryGalleryView.m(this.sTX));
    if (paramBoolean)
    {
      paramString = this.sUc;
      paramBoolean = bool;
      int i;
      if (paramString != null)
      {
        if (paramString.field_storyID == 0L) {
          break label191;
        }
        i = 1;
        if (i == 0) {
          break label196;
        }
      }
      for (;;)
      {
        paramBoolean = bool;
        if (paramString != null) {
          paramBoolean = true;
        }
        paramString = this.sTX;
        Context localContext = this.sTX.getContext();
        this.sTX.getContext().getString(2131297087);
        StoryGalleryView.a(paramString, h.b(localContext, this.sTX.getContext().getString(2131304136), paramBoolean, (DialogInterface.OnCancelListener)new StoryGalleryView.h.1(this)));
        paramString = StoryGalleryView.l(this.sTX);
        if (paramString == null) {
          break label201;
        }
        paramString.gb(StoryGalleryView.h(this.sTX), StoryGalleryView.m(this.sTX));
        AppMethodBeat.o(110808);
        return;
        label191:
        i = 0;
        break;
        label196:
        paramString = null;
      }
    }
    label201:
    AppMethodBeat.o(110808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.h
 * JD-Core Version:    0.7.0.1
 */