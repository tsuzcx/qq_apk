package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SwitchRealnameVerifyModeUI$6
  implements DialogInterface.OnClickListener
{
  SwitchRealnameVerifyModeUI$6(SwitchRealnameVerifyModeUI paramSwitchRealnameVerifyModeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(70023);
    this.HRp.finish();
    AppMethodBeat.o(70023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.6
 * JD-Core Version:    0.7.0.1
 */