package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

final class SwitchRealnameVerifyModeUI$5
  implements DialogInterface.OnClickListener
{
  SwitchRealnameVerifyModeUI$5(SwitchRealnameVerifyModeUI paramSwitchRealnameVerifyModeUI, c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46594);
    paramDialogInterface = this.ucT.mEJ;
    paramDialogInterface.putInt("real_name_verify_mode", 3);
    paramDialogInterface.putString("verify_card_flag", "1");
    a.j(this.ucS, paramDialogInterface);
    AppMethodBeat.o(46594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.5
 * JD-Core Version:    0.7.0.1
 */