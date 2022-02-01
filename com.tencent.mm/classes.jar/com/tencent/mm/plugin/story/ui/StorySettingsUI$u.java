package com.tencent.mm.plugin.story.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StorySettingsUI$u
  implements View.OnClickListener
{
  public static final u yqs;
  
  static
  {
    AppMethodBeat.i(178048);
    yqs = new u();
    AppMethodBeat.o(178048);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119692);
    paramView = g.afB();
    k.g(paramView, "MMKernel.storage()");
    paramView.afk().set(ae.a.FuT, Boolean.FALSE);
    paramView = g.afB();
    k.g(paramView, "MMKernel.storage()");
    paramView.afk().set(ae.a.FuU, Boolean.FALSE);
    AppMethodBeat.o(119692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.u
 * JD-Core Version:    0.7.0.1
 */