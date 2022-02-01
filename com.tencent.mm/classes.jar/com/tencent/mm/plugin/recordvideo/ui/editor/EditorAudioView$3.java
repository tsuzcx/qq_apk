package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorAudioView$3
  implements View.OnClickListener
{
  EditorAudioView$3(EditorAudioView paramEditorAudioView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200539);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    EditorAudioView.q(this.xLw).oy(true);
    a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(200539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.3
 * JD-Core Version:    0.7.0.1
 */