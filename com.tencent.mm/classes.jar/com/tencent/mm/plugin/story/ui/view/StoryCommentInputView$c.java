package com.tencent.mm.plugin.story.ui.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class StoryCommentInputView$c
  implements Runnable
{
  StoryCommentInputView$c(StoryCommentInputView paramStoryCommentInputView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(120115);
    RecyclerView.LayoutManager localLayoutManager = StoryCommentInputView.f(this.FCb).getLayoutManager();
    if (localLayoutManager == null) {
      p.hyc();
    }
    com.tencent.mm.hellhoundlib.b.a locala = c.a(this.gUj, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, locala.axQ(), "com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$scrollToPosition$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    localLayoutManager.scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localLayoutManager, "com/tencent/mm/plugin/story/ui/view/StoryCommentInputView$scrollToPosition$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(120115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentInputView.c
 * JD-Core Version:    0.7.0.1
 */