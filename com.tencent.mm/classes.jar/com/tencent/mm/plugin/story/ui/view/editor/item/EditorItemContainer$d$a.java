package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.a.m;
import a.l;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class EditorItemContainer$d$a
  implements Runnable
{
  EditorItemContainer$d$a(EditorItemContainer.d paramd, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(110633);
    EditorItemContainer.h(this.sQU.sQT).removeView(EditorItemContainer.f(this.sQU.sQT));
    m localm = this.sQU.sQT.getItemChangeListener();
    if (localm != null) {
      localm.h(EditorItemContainer.f(this.sQU.sQT), Boolean.FALSE);
    }
    EditorItemContainer.g(this.sQU.sQT);
    EditorItemContainer.b(this.sQU.sQT);
    if ((this.lxX instanceof f))
    {
      this.sQU.sQT.setLocationView(null);
      AppMethodBeat.o(110633);
      return;
    }
    if ((this.lxX instanceof d))
    {
      this.sQU.sQT.setLyricsView(null);
      AppMethodBeat.o(110633);
      return;
    }
    if ((this.lxX instanceof h)) {
      this.sQU.sQT.setTipItemView(null);
    }
    AppMethodBeat.o(110633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer.d.a
 * JD-Core Version:    0.7.0.1
 */