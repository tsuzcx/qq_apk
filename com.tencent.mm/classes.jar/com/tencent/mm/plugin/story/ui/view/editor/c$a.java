package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.a.a;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$a
  implements View.OnClickListener
{
  c$a(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138924);
    paramView = this.sPz.sPw;
    if (paramView != null) {
      paramView.invoke();
    }
    this.sPz.dismiss();
    AppMethodBeat.o(138924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.c.a
 * JD-Core Version:    0.7.0.1
 */