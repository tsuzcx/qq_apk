package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class EditorInputView$c
  implements Runnable
{
  EditorInputView$c(EditorInputView paramEditorInputView) {}
  
  public final void run()
  {
    AppMethodBeat.i(110556);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.sPp.getContext().getSystemService("input_method");
    int i = EditorInputView.e(this.sPp);
    EditorInputView.b localb = EditorInputView.sPo;
    if (i == EditorInputView.cFJ())
    {
      if (localInputMethodManager != null)
      {
        localInputMethodManager.showSoftInput((View)EditorInputView.f(this.sPp), 0);
        AppMethodBeat.o(110556);
        return;
      }
      AppMethodBeat.o(110556);
      return;
    }
    if (localInputMethodManager != null)
    {
      localInputMethodManager.showSoftInput((View)EditorInputView.b(this.sPp), 0);
      AppMethodBeat.o(110556);
      return;
    }
    AppMethodBeat.o(110556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorInputView.c
 * JD-Core Version:    0.7.0.1
 */