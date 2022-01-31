package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.ui.tools.o;

final class RemittanceDetailUI$2$2
  implements a.a
{
  RemittanceDetailUI$2$2(RemittanceDetailUI.2 param2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44996);
    RemittanceDetailUI.k(this.qqc.qpY).setVisibility(0);
    RemittanceDetailUI.l(this.qqc.qpY).setVisibility(8);
    o.a(this.qqc.qpY, (ScrollView)this.qqc.qpY.findViewById(2131820898), this.qqc.qpY.findViewById(2131827243), this.qqc.qpY.findViewById(2131827247), this.qqc.qpY.findViewById(2131827281));
    AppMethodBeat.o(44996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.2.2
 * JD-Core Version:    0.7.0.1
 */