package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$r
  implements View.OnClickListener
{
  b$r(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155244);
    b.a(this.tqJ, System.currentTimeMillis());
    paramView = b.A(this.tqJ);
    if (paramView != null) {
      paramView.gbb = b.B(this.tqJ);
    }
    paramView = b.A(this.tqJ);
    if (paramView != null) {
      paramView.cLa();
    }
    paramView = b.A(this.tqJ);
    if (paramView != null)
    {
      paramView.show();
      AppMethodBeat.o(155244);
      return;
    }
    AppMethodBeat.o(155244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.r
 * JD-Core Version:    0.7.0.1
 */