package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$e
  implements View.OnClickListener
{
  a$e(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155214);
    this.tpR.gbb = 2;
    this.tpR.cLa();
    paramView = a.a(this.tpR);
    if (paramView != null)
    {
      paramView.GW(this.tpR.gbb);
      AppMethodBeat.o(155214);
      return;
    }
    AppMethodBeat.o(155214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a.e
 * JD-Core Version:    0.7.0.1
 */