package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class EditorPanelHolder$e
  implements Runnable
{
  EditorPanelHolder$e(View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(219930);
    this.HZP.setVisibility(0);
    this.HZP.setTranslationY(this.HZP.getHeight());
    this.HZP.animate().translationY(0.0F).start();
    AppMethodBeat.o(219930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder.e
 * JD-Core Version:    0.7.0.1
 */