package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.sdk.platformtools.bo;

final class RechargeUI$17
  implements View.OnClickListener
{
  RechargeUI$17(RechargeUI paramRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44323);
    RechargeUI.e(this.pWS).getFocus();
    if (RechargeUI.e(this.pWS).getInputRecord().cpG == 2) {
      RechargeUI.e(this.pWS).setInput(null);
    }
    if (bo.isNullOrNil(RechargeUI.e(this.pWS).getText().toString())) {
      RechargeUI.e(this.pWS).pVq.showDropDown();
    }
    this.pWS.showVKB();
    AppMethodBeat.o(44323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.17
 * JD-Core Version:    0.7.0.1
 */