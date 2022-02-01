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
final class StorySettingsUI$u
  implements View.OnClickListener
{
  public static final u zDQ;
  
  static
  {
    AppMethodBeat.i(178048);
    zDQ = new u();
    AppMethodBeat.o(178048);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119692);
    paramView = g.agR();
    k.g(paramView, "MMKernel.storage()");
    paramView.agA().set(ah.a.GSN, Boolean.FALSE);
    paramView = g.agR();
    k.g(paramView, "MMKernel.storage()");
    paramView.agA().set(ah.a.GSO, Boolean.FALSE);
    AppMethodBeat.o(119692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.u
 * JD-Core Version:    0.7.0.1
 */