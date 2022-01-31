package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RemittanceBaseUI$31
  implements View.OnClickListener
{
  RemittanceBaseUI$31(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142161);
    this.qmk.hideTenpayKB();
    RemittanceBaseUI.chq();
    AppMethodBeat.o(142161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.31
 * JD-Core Version:    0.7.0.1
 */