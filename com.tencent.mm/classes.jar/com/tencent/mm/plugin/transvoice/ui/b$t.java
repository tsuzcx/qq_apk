package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$t
  implements View.OnClickListener
{
  b$t(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(156327);
    if (b.a(this.tqJ))
    {
      b.a(this.tqJ, b.b.tqD);
      b.i(this.tqJ, false);
      b.d(this.tqJ, true);
      paramView = b.f(this.tqJ);
      if (paramView != null)
      {
        paramView.setImageResource(2130838350);
        AppMethodBeat.o(156327);
        return;
      }
      AppMethodBeat.o(156327);
      return;
    }
    b.a(this.tqJ, b.b.tqE);
    b.i(this.tqJ, true);
    b.d(this.tqJ, false);
    paramView = b.f(this.tqJ);
    if (paramView != null)
    {
      paramView.setImageResource(2130838345);
      AppMethodBeat.o(156327);
      return;
    }
    AppMethodBeat.o(156327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.t
 * JD-Core Version:    0.7.0.1
 */