package com.tencent.mm.plugin.story.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class CommentsContainer$d
  implements Runnable
{
  CommentsContainer$d(CommentsContainer paramCommentsContainer) {}
  
  public final void run()
  {
    AppMethodBeat.i(120052);
    a locala = this.ytZ.getOnLoop();
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(120052);
      return;
    }
    AppMethodBeat.o(120052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentsContainer.d
 * JD-Core Version:    0.7.0.1
 */