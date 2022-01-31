package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBaseUI$6
  implements DialogInterface.OnClickListener
{
  RemittanceBaseUI$6(RemittanceBaseUI paramRemittanceBaseUI, v paramv) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142145);
    ab.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[] { this.qml.cHz.kNB });
    e.m(this.qmk.getContext(), this.qml.cHz.kNB, false);
    AppMethodBeat.o(142145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.6
 * JD-Core Version:    0.7.0.1
 */