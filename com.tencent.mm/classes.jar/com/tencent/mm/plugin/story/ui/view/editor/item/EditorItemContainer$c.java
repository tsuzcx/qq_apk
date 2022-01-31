package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class EditorItemContainer$c
  implements Runnable
{
  EditorItemContainer$c(EditorItemContainer paramEditorItemContainer) {}
  
  public final void run()
  {
    AppMethodBeat.i(110632);
    if (EditorItemContainer.a(this.sQT) != null)
    {
      EditorItemContainer localEditorItemContainer = this.sQT;
      View localView = EditorItemContainer.a(this.sQT);
      if (localView == null) {
        j.ebi();
      }
      localEditorItemContainer.s(localView, false);
    }
    AppMethodBeat.o(110632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer.c
 * JD-Core Version:    0.7.0.1
 */