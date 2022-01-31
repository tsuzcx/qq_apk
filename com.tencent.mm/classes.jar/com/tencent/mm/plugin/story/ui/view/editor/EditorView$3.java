package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.d.b.a;
import com.tencent.mm.plugin.story.g.i;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorView$3
  implements View.OnClickListener
{
  EditorView$3(EditorView paramEditorView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151223);
    this.sQi.getPresenter().zY();
    paramView = i.sFa;
    i.FR(12);
    AppMethodBeat.o(151223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.3
 * JD-Core Version:    0.7.0.1
 */