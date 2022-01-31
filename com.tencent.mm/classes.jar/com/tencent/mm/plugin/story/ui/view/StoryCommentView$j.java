package com.tencent.mm.plugin.story.ui.view;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryCommentView$j
  implements Runnable
{
  StoryCommentView$j(StoryCommentView paramStoryCommentView) {}
  
  public final void run()
  {
    AppMethodBeat.i(138920);
    StoryCommentView.b(this.sMZ).pause();
    StoryCommentView.b(this.sMZ).setAlpha(1.0F);
    AppMethodBeat.o(138920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.j
 * JD-Core Version:    0.7.0.1
 */