package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$insectBottom$1$1"})
final class EditorAudioView$c
  implements Runnable
{
  EditorAudioView$c(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(75949);
    this.wBc.setPadding(this.wBc.getPaddingLeft(), this.wBc.getPaddingTop(), this.wBc.getPaddingRight(), this.wBd);
    this.wBc.requestLayout();
    AppMethodBeat.o(75949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.c
 * JD-Core Version:    0.7.0.1
 */