package com.tencent.mm.plugin.story.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class StoryCommentView$j
  implements Runnable
{
  StoryCommentView$j(StoryCommentView paramStoryCommentView) {}
  
  public final void run()
  {
    AppMethodBeat.i(120157);
    StoryCommentView.b(this.FCE).pause();
    StoryCommentView.b(this.FCE).setAlpha(1.0F);
    AppMethodBeat.o(120157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.j
 * JD-Core Version:    0.7.0.1
 */