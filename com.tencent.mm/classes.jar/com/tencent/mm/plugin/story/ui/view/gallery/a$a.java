package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$a
  implements View.OnClickListener
{
  a$a(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138935);
    paramView = this.sRD.sRw;
    if (paramView != null) {
      paramView.invoke();
    }
    this.sRD.dismiss();
    AppMethodBeat.o(138935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.a.a
 * JD-Core Version:    0.7.0.1
 */