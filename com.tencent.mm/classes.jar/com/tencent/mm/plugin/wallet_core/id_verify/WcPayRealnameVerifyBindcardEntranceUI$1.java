package com.tencent.mm.plugin.wallet_core.id_verify;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;

final class WcPayRealnameVerifyBindcardEntranceUI$1
  implements View.OnClickListener
{
  WcPayRealnameVerifyBindcardEntranceUI$1(WcPayRealnameVerifyBindcardEntranceUI paramWcPayRealnameVerifyBindcardEntranceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142411);
    this.udj.getInput().putBoolean("realname_verify_process_do_bind", true);
    a.j(this.udj.getContext(), this.udj.getInput());
    AppMethodBeat.o(142411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyBindcardEntranceUI.1
 * JD-Core Version:    0.7.0.1
 */