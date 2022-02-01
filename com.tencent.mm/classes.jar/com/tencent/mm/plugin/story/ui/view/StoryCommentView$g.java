package com.tencent.mm.plugin.story.ui.view;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class StoryCommentView$g
  implements Runnable
{
  StoryCommentView$g(StoryCommentView paramStoryCommentView) {}
  
  public final void run()
  {
    AppMethodBeat.i(120154);
    StoryCommentView.f(this.FCE).setVisibility(8);
    StoryCommentView.f(this.FCE).setAlpha(1.0F);
    AppMethodBeat.o(120154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.g
 * JD-Core Version:    0.7.0.1
 */