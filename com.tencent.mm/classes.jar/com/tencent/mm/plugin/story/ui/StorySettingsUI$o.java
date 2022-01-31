package com.tencent.mm.plugin.story.ui;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StorySettingsUI$o
  implements View.OnClickListener
{
  public static final o sIa;
  
  static
  {
    AppMethodBeat.i(155326);
    sIa = new o();
    AppMethodBeat.o(155326);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110063);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLx, Boolean.FALSE);
    paramView = g.RL();
    j.p(paramView, "MMKernel.storage()");
    paramView.Ru().set(ac.a.yLy, Boolean.FALSE);
    AppMethodBeat.o(110063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.o
 * JD-Core Version:    0.7.0.1
 */