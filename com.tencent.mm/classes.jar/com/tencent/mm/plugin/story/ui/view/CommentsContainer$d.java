package com.tencent.mm.plugin.story.ui.view;

import a.f.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class CommentsContainer$d
  implements Runnable
{
  CommentsContainer$d(CommentsContainer paramCommentsContainer) {}
  
  public final void run()
  {
    AppMethodBeat.i(138895);
    a locala = this.sLS.getOnLoop();
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(138895);
      return;
    }
    AppMethodBeat.o(138895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentsContainer.d
 * JD-Core Version:    0.7.0.1
 */