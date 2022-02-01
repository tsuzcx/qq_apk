package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorAudioSearchView$c
  implements View.OnClickListener
{
  EditorAudioSearchView$c(EditorAudioSearchView paramEditorAudioSearchView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75905);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = EditorAudioSearchView.a(this.Cbc);
    if (paramView != null)
    {
      paramView = paramView.getText();
      if (paramView != null) {
        if (((CharSequence)paramView).length() != 0) {
          break label108;
        }
      }
    }
    label108:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramView = EditorAudioSearchView.a(this.Cbc);
        if (paramView != null) {
          paramView.setText(null);
        }
      }
      a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioSearchView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75905);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView.c
 * JD-Core Version:    0.7.0.1
 */