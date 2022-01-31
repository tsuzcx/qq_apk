package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onTextureUpdate"})
final class EditorView$k$a
  implements e.e
{
  EditorView$k$a(EditorView.k paramk) {}
  
  public final void bSk()
  {
    AppMethodBeat.i(110591);
    EditorView.w(this.sQo.sQi).setVisibility(0);
    a locala = EditorView.u(this.sQo.sQi);
    if (locala != null) {
      locala.invoke();
    }
    EditorView.w(this.sQo.sQi).setAlpha(1.0F);
    AppMethodBeat.o(110591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.k.a
 * JD-Core Version:    0.7.0.1
 */