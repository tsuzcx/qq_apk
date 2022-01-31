package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$b
  implements View.OnClickListener
{
  a$b(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110698);
    paramView = this.sRD.sRz;
    if (paramView != null) {
      paramView.invoke();
    }
    this.sRD.dismiss();
    AppMethodBeat.o(110698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.a.b
 * JD-Core Version:    0.7.0.1
 */