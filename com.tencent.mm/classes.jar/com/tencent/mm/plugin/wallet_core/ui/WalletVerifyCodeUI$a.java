package com.tencent.mm.plugin.wallet_core.ui;

import android.os.CountDownTimer;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletVerifyCodeUI$a
  extends CountDownTimer
{
  public WalletVerifyCodeUI$a(WalletVerifyCodeUI paramWalletVerifyCodeUI, long paramLong)
  {
    super(paramLong, 1000L);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(47702);
    WalletVerifyCodeUI.f(this.uul).setClickable(true);
    WalletVerifyCodeUI.f(this.uul).setEnabled(true);
    WalletVerifyCodeUI.f(this.uul).setText(this.uul.getString(2131305706));
    AppMethodBeat.o(47702);
  }
  
  public final void onTick(long paramLong)
  {
    AppMethodBeat.i(47701);
    WalletVerifyCodeUI.f(this.uul).setText(this.uul.getString(2131305706) + "(" + paramLong / 1000L + ")");
    AppMethodBeat.o(47701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.a
 * JD-Core Version:    0.7.0.1
 */