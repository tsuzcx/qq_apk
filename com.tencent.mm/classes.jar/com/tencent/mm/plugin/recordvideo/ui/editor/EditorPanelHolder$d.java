package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class EditorPanelHolder$d
  implements Runnable
{
  EditorPanelHolder$d(View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(206886);
    this.ycx.setVisibility(0);
    this.ycx.setTranslationY(this.ycx.getHeight());
    this.ycx.animate().translationY(0.0F).start();
    AppMethodBeat.o(206886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder.d
 * JD-Core Version:    0.7.0.1
 */