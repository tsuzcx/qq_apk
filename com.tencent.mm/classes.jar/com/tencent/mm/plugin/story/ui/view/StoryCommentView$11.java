package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryCommentView$11
  implements Runnable
{
  StoryCommentView$11(StoryCommentView paramStoryCommentView) {}
  
  public final void run()
  {
    AppMethodBeat.i(151191);
    StoryCommentView.m(this.sMZ).animate().cancel();
    StoryCommentView.m(this.sMZ).animate().alpha(0.0F).withEndAction((Runnable)new StoryCommentView.11.1(this)).start();
    AppMethodBeat.o(151191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.11
 * JD-Core Version:    0.7.0.1
 */