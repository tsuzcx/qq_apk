package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class RechargeUI$6
  implements AdapterView.OnItemClickListener
{
  RechargeUI$6(RechargeUI paramRechargeUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.nrE.dismissDialog(1);
    y.d("MicroMsg.MallRechargeUI", "onItemClick : " + paramInt);
    RechargeUI.a(this.nrE, RechargeUI.g(this.nrE).wx(paramInt));
    RechargeUI.g(this.nrE).ww(paramInt);
    RechargeUI.g(this.nrE).notifyDataSetChanged();
    RechargeUI.n(this.nrE).remove(RechargeUI.r(RechargeUI.k(this.nrE).dWX, RechargeUI.k(this.nrE).bJd, RechargeUI.m(this.nrE)));
    RechargeUI.b(this.nrE);
    RechargeUI.l(this.nrE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.6
 * JD-Core Version:    0.7.0.1
 */