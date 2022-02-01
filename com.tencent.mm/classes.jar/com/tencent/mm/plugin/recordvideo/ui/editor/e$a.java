package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class e$a
  implements View.OnClickListener
{
  e$a(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(76010);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog$initNotifySnsBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = this.Cdt.Cdr;
    if (paramView != null) {
      paramView.invoke();
    }
    this.Cdt.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog$initNotifySnsBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(76010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.e.a
 * JD-Core Version:    0.7.0.1
 */