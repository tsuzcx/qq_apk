package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class RechargeUI$5
  implements AdapterView.OnItemClickListener
{
  RechargeUI$5(RechargeUI paramRechargeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44310);
    this.pWS.dismissDialog(1);
    ab.d("MicroMsg.MallRechargeUI", "onItemClick : ".concat(String.valueOf(paramInt)));
    ab.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.k(this.pWS));
    RechargeUI.a(this.pWS, RechargeUI.f(this.pWS).Cj(paramInt));
    RechargeUI.f(this.pWS).Ci(paramInt);
    RechargeUI.f(this.pWS).notifyDataSetChanged();
    ab.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.k(this.pWS));
    RechargeUI.l(this.pWS);
    AppMethodBeat.o(44310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.5
 * JD-Core Version:    0.7.0.1
 */