package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$s
  implements View.OnClickListener
{
  b$s(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155245);
    paramView = b.b(this.tqJ);
    switch (c.pRV[paramView.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(155245);
      return;
      b.i(this.tqJ, false);
      AppMethodBeat.o(155245);
      return;
      b.a(this.tqJ, b.b.tqC);
      b.b(this.tqJ, false);
      b.c(this.tqJ, true);
      paramView = b.g(this.tqJ);
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramView = b.e(this.tqJ);
      if (paramView != null) {
        paramView.setCursorVisible(false);
      }
      b.e(this.tqJ, false);
      AppMethodBeat.o(155245);
      return;
      b.a(this.tqJ, b.b.tqC);
      b.b(this.tqJ, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.s
 * JD-Core Version:    0.7.0.1
 */