package com.tencent.mm.plugin.story.ui.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class StoryCommentInputView$c
  implements Runnable
{
  StoryCommentInputView$c(StoryCommentInputView paramStoryCommentInputView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(120115);
    RecyclerView.i locali = StoryCommentInputView.f(this.AZQ).getLayoutManager();
    if (locali == null) {
      p.gfZ();
    }
    com.tencent.mm.hellhoundlib.b.a locala = c.a(this.ghM, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(locali, locala.ahp(), "com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$scrollToPosition$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    locali.ca(((Integer)locala.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$scrollToPosition$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(120115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.c
 * JD-Core Version:    0.7.0.1
 */