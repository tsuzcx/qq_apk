package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class EditorAudioSearchView$n
  implements Runnable
{
  EditorAudioSearchView$n(EditorAudioSearchView paramEditorAudioSearchView) {}
  
  public final void run()
  {
    AppMethodBeat.i(75917);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.vqD.getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localInputMethodManager.showSoftInput((View)EditorAudioSearchView.a(this.vqD), 0);
      AppMethodBeat.o(75917);
      return;
    }
    AppMethodBeat.o(75917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView.n
 * JD-Core Version:    0.7.0.1
 */