package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.g;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryGalleryView$2
  implements View.OnClickListener
{
  StoryGalleryView$2(StoryGalleryView paramStoryGalleryView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138942);
    if ((StoryGalleryView.g(this.sTX).size() == 1) && (((ArrayList)StoryGalleryView.g(this.sTX).get(0)).isEmpty()))
    {
      paramView = StoryGalleryView.p(this.sTX);
      if (paramView != null)
      {
        paramView.cbT();
        AppMethodBeat.o(138942);
        return;
      }
    }
    AppMethodBeat.o(138942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.2
 * JD-Core Version:    0.7.0.1
 */