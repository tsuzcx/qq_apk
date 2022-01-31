package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class RechargeUI$14
  implements View.OnClickListener
{
  RechargeUI$14(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    if (((RechargeUI.f(this.nrE) != null) && (RechargeUI.f(this.nrE).getCount() > 0)) || ((RechargeUI.g(this.nrE) != null) && (RechargeUI.g(this.nrE).getCount() > 0))) {
      this.nrE.showDialog(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.14
 * JD-Core Version:    0.7.0.1
 */