package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$c
  implements View.OnClickListener
{
  a$c(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110699);
    paramView = this.sRD.sRy;
    if (paramView != null) {
      paramView.invoke();
    }
    this.sRD.dismiss();
    AppMethodBeat.o(110699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.a.c
 * JD-Core Version:    0.7.0.1
 */