package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorAudioSearchView$d
  implements View.OnClickListener
{
  EditorAudioSearchView$d(EditorAudioSearchView paramEditorAudioSearchView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75906);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    EditorAudioSearchView.b(this.Cbc);
    a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView.d
 * JD-Core Version:    0.7.0.1
 */