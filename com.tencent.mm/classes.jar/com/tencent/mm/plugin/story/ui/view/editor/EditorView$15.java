package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.i;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorView$15
  implements View.OnClickListener
{
  EditorView$15(EditorView paramEditorView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138932);
    paramView = this.sQi;
    CharSequence localCharSequence = (CharSequence)"";
    EditorInputView.b localb = EditorInputView.sPo;
    int i = EditorInputView.cFI();
    localb = EditorInputView.sPo;
    paramView.a(true, localCharSequence, -1, i, EditorInputView.cFK());
    paramView = i.sFa;
    i.FR(18);
    AppMethodBeat.o(138932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.15
 * JD-Core Version:    0.7.0.1
 */