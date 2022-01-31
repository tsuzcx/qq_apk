package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class RechargeUI$5
  implements AdapterView.OnItemClickListener
{
  RechargeUI$5(RechargeUI paramRechargeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.nrE.dismissDialog(1);
    y.d("MicroMsg.MallRechargeUI", "onItemClick : " + paramInt);
    y.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.k(this.nrE));
    RechargeUI.a(this.nrE, RechargeUI.f(this.nrE).wx(paramInt));
    RechargeUI.f(this.nrE).ww(paramInt);
    RechargeUI.f(this.nrE).notifyDataSetChanged();
    y.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.k(this.nrE));
    RechargeUI.l(this.nrE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.5
 * JD-Core Version:    0.7.0.1
 */