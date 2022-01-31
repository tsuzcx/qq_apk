package com.tencent.mm.plugin.story.ui.a;

import a.f.a.m;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class e$a$1
  implements View.OnClickListener
{
  e$a$1(e.a parama, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110101);
    int i = this.sIn.jN();
    paramView = this.sIn.sIm.Gd(i);
    if (paramView != null)
    {
      m localm = this.sIn.sIm.lxR;
      if (localm != null) {
        localm.h(Integer.valueOf(i), paramView);
      }
    }
    this.lxX.requestFocus();
    AppMethodBeat.o(110101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.e.a.1
 * JD-Core Version:    0.7.0.1
 */