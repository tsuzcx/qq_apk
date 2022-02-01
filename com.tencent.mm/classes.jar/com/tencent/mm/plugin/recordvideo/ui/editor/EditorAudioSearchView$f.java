package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"})
final class EditorAudioSearchView$f
  implements View.OnFocusChangeListener
{
  EditorAudioSearchView$f(EditorAudioSearchView paramEditorAudioSearchView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(75908);
    EditorAudioSearchView.a(this.Cbc, paramBoolean);
    AppMethodBeat.o(75908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView.f
 * JD-Core Version:    0.7.0.1
 */