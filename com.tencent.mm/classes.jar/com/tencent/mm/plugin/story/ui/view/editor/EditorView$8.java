package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.g.i;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorView$8
  implements View.OnClickListener
{
  EditorView$8(EditorView paramEditorView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110574);
    paramView = this.sQi;
    CharSequence localCharSequence = (CharSequence)"";
    EditorInputView.b localb = EditorInputView.sPo;
    int i = EditorInputView.cFH();
    localb = EditorInputView.sPo;
    int j = EditorInputView.cFI();
    localb = EditorInputView.sPo;
    paramView.a(true, localCharSequence, i, j, EditorInputView.cFJ());
    paramView = i.sFa;
    i.FR(8);
    AppMethodBeat.o(110574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView.8
 * JD-Core Version:    0.7.0.1
 */