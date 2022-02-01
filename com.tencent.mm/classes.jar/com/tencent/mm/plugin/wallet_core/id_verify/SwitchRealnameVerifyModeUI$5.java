package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.e;

final class SwitchRealnameVerifyModeUI$5
  implements DialogInterface.OnClickListener
{
  SwitchRealnameVerifyModeUI$5(SwitchRealnameVerifyModeUI paramSwitchRealnameVerifyModeUI, e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(70022);
    paramDialogInterface = this.Vzk.hPH;
    paramDialogInterface.putInt("real_name_verify_mode", 3);
    paramDialogInterface.putString("verify_card_flag", "1");
    a.k(this.Vzj, paramDialogInterface);
    AppMethodBeat.o(70022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.5
 * JD-Core Version:    0.7.0.1
 */