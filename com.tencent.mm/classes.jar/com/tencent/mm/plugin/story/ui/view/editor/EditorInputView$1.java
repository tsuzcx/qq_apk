package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
final class EditorInputView$1
  implements View.OnFocusChangeListener
{
  EditorInputView$1(EditorInputView paramEditorInputView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(110550);
    EditorInputView.a(this.sPp, paramBoolean);
    AppMethodBeat.o(110550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.1
 * JD-Core Version:    0.7.0.1
 */