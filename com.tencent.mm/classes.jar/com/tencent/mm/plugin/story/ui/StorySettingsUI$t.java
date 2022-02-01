package com.tencent.mm.plugin.story.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StorySettingsUI$t
  implements View.OnClickListener
{
  public static final t zDP;
  
  static
  {
    AppMethodBeat.i(119691);
    zDP = new t();
    AppMethodBeat.o(119691);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119690);
    paramView = g.agR();
    k.g(paramView, "MMKernel.storage()");
    paramView.agA().set(ah.a.GSL, Boolean.FALSE);
    AppMethodBeat.o(119690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.t
 * JD-Core Version:    0.7.0.1
 */