package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.d.c;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorAudioView$8
  implements View.OnClickListener
{
  EditorAudioView$8(EditorAudioView paramEditorAudioView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75942);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = this.xLw;
    if (!EditorAudioView.w(this.xLw)) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.pX(bool);
      paramView = c.xHa;
      c.NN(20);
      a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75942);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.8
 * JD-Core Version:    0.7.0.1
 */