package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryCommentView$i
  implements Runnable
{
  StoryCommentView$i(StoryCommentView paramStoryCommentView) {}
  
  public final void run()
  {
    AppMethodBeat.i(110422);
    StoryCommentView.f(this.sMZ).setVisibility(8);
    StoryCommentView.f(this.sMZ).setAlpha(1.0F);
    AppMethodBeat.o(110422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.i
 * JD-Core Version:    0.7.0.1
 */