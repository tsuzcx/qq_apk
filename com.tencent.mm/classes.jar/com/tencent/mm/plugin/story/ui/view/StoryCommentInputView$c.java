package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryCommentInputView$c
  implements Runnable
{
  StoryCommentInputView$c(StoryCommentInputView paramStoryCommentInputView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(151173);
    StoryCommentInputView.f(this.sMv).getLayoutManager().bJ(this.euX);
    AppMethodBeat.o(151173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.c
 * JD-Core Version:    0.7.0.1
 */