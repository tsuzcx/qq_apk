package com.tencent.mm.plugin.story.ui.view.editor;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class EditorAudioSearchView$n
  implements Runnable
{
  EditorAudioSearchView$n(EditorAudioSearchView paramEditorAudioSearchView) {}
  
  public final void run()
  {
    AppMethodBeat.i(110487);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.sOb.getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.showSoftInput((View)EditorAudioSearchView.a(this.sOb), 0);
      AppMethodBeat.o(110487);
      return;
    }
    AppMethodBeat.o(110487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorAudioSearchView.n
 * JD-Core Version:    0.7.0.1
 */