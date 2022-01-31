package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;

final class MallProductSubmitUI$3
  implements View.OnClickListener
{
  MallProductSubmitUI$3(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44141);
    paramView = MallProductSubmitUI.d(this.pxb);
    if (paramView.pvR.cbi())
    {
      if (paramView.pvR.caZ() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        g.RM();
        g.RK().eHt.a(new k(paramView.pvR.cbk()), 0);
        AppMethodBeat.o(44141);
        return;
      }
      g.RM();
      g.RK().eHt.a(new l(paramView.pvR.cbk(), paramView.pvR.getAppId()), 0);
    }
    AppMethodBeat.o(44141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.3
 * JD-Core Version:    0.7.0.1
 */