package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryCommentColorSelector$3
  implements View.OnClickListener
{
  StoryCommentColorSelector$3(StoryCommentColorSelector paramStoryCommentColorSelector) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110382);
    this.sMf.setSelectedColor(StoryCommentColorSelector.cFv());
    StoryCommentColorSelector.a(this.sMf);
    AppMethodBeat.o(110382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentColorSelector.3
 * JD-Core Version:    0.7.0.1
 */