package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ui.ListViewInScrollView;

final class RechargeUI$8
  implements View.OnClickListener
{
  RechargeUI$8(RechargeUI paramRechargeUI, View paramView1, TextView paramTextView1, int paramInt1, ListViewInScrollView paramListViewInScrollView1, View paramView2, TextView paramTextView2, int paramInt2, ListViewInScrollView paramListViewInScrollView2, TextView paramTextView3) {}
  
  public final void onClick(View paramView)
  {
    this.nrJ.setVisibility(0);
    this.nrK.setTextColor(this.nrH);
    this.nrM.setVisibility(0);
    this.nrF.setVisibility(8);
    this.nrG.setTextColor(this.nrL);
    this.nrI.setVisibility(8);
    if (RechargeUI.g(this.nrE).getCount() == 0)
    {
      this.nrN.setVisibility(0);
      return;
    }
    this.nrN.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.8
 * JD-Core Version:    0.7.0.1
 */