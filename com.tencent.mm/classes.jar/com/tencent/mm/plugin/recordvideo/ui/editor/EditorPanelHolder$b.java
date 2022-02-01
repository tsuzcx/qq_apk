package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$insectBottom$1$1"})
final class EditorPanelHolder$b
  implements Runnable
{
  EditorPanelHolder$b(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(237719);
    this.Cct.setPadding(this.Cct.getPaddingLeft(), this.Cct.getPaddingTop(), this.Cct.getPaddingRight(), this.Ccu);
    this.Cct.requestLayout();
    AppMethodBeat.o(237719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder.b
 * JD-Core Version:    0.7.0.1
 */