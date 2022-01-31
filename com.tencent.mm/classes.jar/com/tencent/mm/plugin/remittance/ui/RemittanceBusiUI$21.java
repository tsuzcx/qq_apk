package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBusiUI$21
  implements DialogInterface.OnClickListener
{
  RemittanceBusiUI$21(RemittanceBusiUI paramRemittanceBusiUI, i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142193);
    ab.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", new Object[] { this.qoJ.qji.wBn.kNB });
    e.m(this.qoF.getContext(), this.qoJ.qji.wBn.kNB, false);
    AppMethodBeat.o(142193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.21
 * JD-Core Version:    0.7.0.1
 */