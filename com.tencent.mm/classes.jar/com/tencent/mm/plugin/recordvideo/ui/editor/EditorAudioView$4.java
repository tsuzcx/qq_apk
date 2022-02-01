package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorAudioView$4
  implements View.OnClickListener
{
  EditorAudioView$4(EditorAudioView paramEditorAudioView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200540);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.xLw.setShow(false);
    a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(200540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.4
 * JD-Core Version:    0.7.0.1
 */