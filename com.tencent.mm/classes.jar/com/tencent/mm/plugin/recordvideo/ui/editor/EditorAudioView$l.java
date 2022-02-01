package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$insectBottom$1$1"})
final class EditorAudioView$l
  implements Runnable
{
  EditorAudioView$l(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(75949);
    this.ybr.setPadding(this.ybr.getPaddingLeft(), this.ybr.getPaddingTop(), this.ybr.getPaddingRight(), this.ybs);
    this.ybr.requestLayout();
    AppMethodBeat.o(75949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.l
 * JD-Core Version:    0.7.0.1
 */