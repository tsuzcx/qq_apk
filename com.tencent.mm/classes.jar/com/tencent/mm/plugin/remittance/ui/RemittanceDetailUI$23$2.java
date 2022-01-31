package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.ui.tools.o;

final class RemittanceDetailUI$23$2
  implements a.a
{
  RemittanceDetailUI$23$2(RemittanceDetailUI.23 param23) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45025);
    RemittanceDetailUI.e(this.qqm.qpY).setVisibility(0);
    RemittanceDetailUI.f(this.qqm.qpY).setVisibility(8);
    o.a(this.qqm.qpY, (ScrollView)this.qqm.qpY.findViewById(2131820898), this.qqm.qpY.findViewById(2131827243), this.qqm.qpY.findViewById(2131827247), this.qqm.qpY.findViewById(2131827281));
    AppMethodBeat.o(45025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.23.2
 * JD-Core Version:    0.7.0.1
 */