package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.sdk.platformtools.bk;

final class RechargeUI$17
  implements View.OnClickListener
{
  RechargeUI$17(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    RechargeUI.e(this.nrE).getFocus();
    if (RechargeUI.e(this.nrE).getInputRecord().bIl == 2) {
      RechargeUI.e(this.nrE).setInput(null);
    }
    if (bk.bl(RechargeUI.e(this.nrE).getText().toString())) {
      RechargeUI.e(this.nrE).nqc.showDropDown();
    }
    this.nrE.showVKB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.17
 * JD-Core Version:    0.7.0.1
 */