package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$f
  implements View.OnClickListener
{
  a$f(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155215);
    this.tpR.gbb = 4;
    this.tpR.cLa();
    paramView = a.a(this.tpR);
    if (paramView != null)
    {
      paramView.GW(this.tpR.gbb);
      AppMethodBeat.o(155215);
      return;
    }
    AppMethodBeat.o(155215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a.f
 * JD-Core Version:    0.7.0.1
 */