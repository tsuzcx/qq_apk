package com.tencent.mm.plugin.story.ui.a;

import a.f.a.m;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class f$d$b
  implements View.OnClickListener
{
  f$d$b(f.d paramd, a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138856);
    paramView = this.sIF.sIC.sIw;
    if (paramView != null)
    {
      paramView.h(this.sIE, Boolean.FALSE);
      AppMethodBeat.o(138856);
      return;
    }
    AppMethodBeat.o(138856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.f.d.b
 * JD-Core Version:    0.7.0.1
 */