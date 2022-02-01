package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$insectBottom$1$1"})
final class EditorAudioView$o
  implements Runnable
{
  EditorAudioView$o(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(75949);
    this.xLx.setPadding(this.xLx.getPaddingLeft(), this.xLx.getPaddingTop(), this.xLx.getPaddingRight(), this.xLy);
    this.xLx.requestLayout();
    AppMethodBeat.o(75949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.o
 * JD-Core Version:    0.7.0.1
 */