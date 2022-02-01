package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class EditorAudioView$9
  implements View.OnClickListener
{
  EditorAudioView$9(EditorAudioView paramEditorAudioView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75943);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = this.cqB;
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(75943);
      throw paramView;
    }
    if (com.tencent.mm.pluginsdk.permission.b.a((Activity)paramView, "android.permission.RECORD_AUDIO", 84, "", "")) {
      EditorAudioView.A(this.xLw);
    }
    a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.9
 * JD-Core Version:    0.7.0.1
 */