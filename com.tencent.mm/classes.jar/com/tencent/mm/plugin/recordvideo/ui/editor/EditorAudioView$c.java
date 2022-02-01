package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$insectBottom$1$1"})
final class EditorAudioView$c
  implements Runnable
{
  EditorAudioView$c(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(75949);
    this.vre.setPadding(this.vre.getPaddingLeft(), this.vre.getPaddingTop(), this.vre.getPaddingRight(), this.vrf);
    this.vre.requestLayout();
    AppMethodBeat.o(75949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.c
 * JD-Core Version:    0.7.0.1
 */