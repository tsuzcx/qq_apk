package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceBusiUI$14
  implements DialogInterface.OnClickListener
{
  RemittanceBusiUI$14(RemittanceBusiUI paramRemittanceBusiUI, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142186);
    if (bo.hl(((i)this.ckS).qji.wBB, 1))
    {
      if (e.chr().chs()) {
        ab.w("MicroMsg.RemittanceBusiUI", "finish RemittanceF2fDynamicCodeUI");
      }
      this.qoF.finish();
    }
    AppMethodBeat.o(142186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.14
 * JD-Core Version:    0.7.0.1
 */