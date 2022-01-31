package com.tencent.mm.plugin.order.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallOrderTransactionInfoUI$1
  implements DialogInterface.OnClickListener
{
  MallOrderTransactionInfoUI$1(MallOrderTransactionInfoUI paramMallOrderTransactionInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(43877);
    this.pru.finish();
    AppMethodBeat.o(43877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI.1
 * JD-Core Version:    0.7.0.1
 */