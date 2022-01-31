package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class OrderHandlerUI$5
  implements DialogInterface.OnClickListener
{
  OrderHandlerUI$5(OrderHandlerUI paramOrderHandlerUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142591);
    paramDialogInterface.dismiss();
    this.uAT.finish();
    AppMethodBeat.o(142591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI.5
 * JD-Core Version:    0.7.0.1
 */