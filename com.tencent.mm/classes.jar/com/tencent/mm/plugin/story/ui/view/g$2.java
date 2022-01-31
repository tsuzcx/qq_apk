package com.tencent.mm.plugin.story.ui.view;

import a.f.a.a;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class g$2
  implements View.OnClickListener
{
  g$2(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110470);
    paramView = this.sNA.getClickListener();
    if (paramView != null)
    {
      paramView.invoke();
      AppMethodBeat.o(110470);
      return;
    }
    AppMethodBeat.o(110470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.g.2
 * JD-Core Version:    0.7.0.1
 */