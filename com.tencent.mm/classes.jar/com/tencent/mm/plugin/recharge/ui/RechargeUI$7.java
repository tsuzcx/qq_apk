package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ListViewInScrollView;

final class RechargeUI$7
  implements View.OnClickListener
{
  RechargeUI$7(RechargeUI paramRechargeUI, View paramView1, TextView paramTextView1, int paramInt1, ListViewInScrollView paramListViewInScrollView1, View paramView2, TextView paramTextView2, int paramInt2, ListViewInScrollView paramListViewInScrollView2, TextView paramTextView3) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44312);
    this.pWT.setVisibility(0);
    this.pWU.setTextColor(this.pWV);
    this.pWW.setVisibility(0);
    this.pWX.setVisibility(8);
    this.pWY.setTextColor(this.pWZ);
    this.pXa.setVisibility(8);
    if (RechargeUI.f(this.pWS).getCount() == 0)
    {
      this.pXb.setVisibility(0);
      AppMethodBeat.o(44312);
      return;
    }
    this.pXb.setVisibility(8);
    AppMethodBeat.o(44312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.7
 * JD-Core Version:    0.7.0.1
 */