package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class RemittanceDetailUI$15
  implements DialogInterface.OnClickListener
{
  RemittanceDetailUI$15(RemittanceDetailUI paramRemittanceDetailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45013);
    h.bO(this.qpY.getContext(), this.qpY.getString(2131302549));
    AppMethodBeat.o(45013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.15
 * JD-Core Version:    0.7.0.1
 */