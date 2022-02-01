package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$insectBottom$1$1"})
final class EditorAudioView$m
  implements Runnable
{
  EditorAudioView$m(View paramView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(75949);
    this.Cct.setPadding(this.Cct.getPaddingLeft(), this.Cct.getPaddingTop(), this.Cct.getPaddingRight(), this.Ccu);
    this.Cct.requestLayout();
    AppMethodBeat.o(75949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.m
 * JD-Core Version:    0.7.0.1
 */