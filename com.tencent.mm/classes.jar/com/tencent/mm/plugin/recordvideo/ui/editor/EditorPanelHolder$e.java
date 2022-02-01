package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class EditorPanelHolder$e
  implements Runnable
{
  EditorPanelHolder$e(View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(237722);
    this.Cdz.setVisibility(0);
    this.Cdz.setTranslationY(this.Cdz.getHeight());
    this.Cdz.animate().translationY(0.0F).start();
    AppMethodBeat.o(237722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder.e
 * JD-Core Version:    0.7.0.1
 */