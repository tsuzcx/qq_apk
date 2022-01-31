package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class RechargeUI$6
  implements AdapterView.OnItemClickListener
{
  RechargeUI$6(RechargeUI paramRechargeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44311);
    this.pWS.dismissDialog(1);
    ab.d("MicroMsg.MallRechargeUI", "onItemClick : ".concat(String.valueOf(paramInt)));
    RechargeUI.a(this.pWS, RechargeUI.g(this.pWS).Cj(paramInt));
    RechargeUI.g(this.pWS).Ci(paramInt);
    RechargeUI.g(this.pWS).notifyDataSetChanged();
    RechargeUI.n(this.pWS).remove(RechargeUI.B(RechargeUI.k(this.pWS).fnf, RechargeUI.k(this.pWS).cqx, RechargeUI.m(this.pWS)));
    RechargeUI.b(this.pWS);
    RechargeUI.l(this.pWS);
    AppMethodBeat.o(44311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.6
 * JD-Core Version:    0.7.0.1
 */