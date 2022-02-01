package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.plugin.wallet_core.model.am;

public class WalletPayUBalanceManagerUI
  extends WalletBalanceManagerUI
{
  public final void ieQ()
  {
    AppMethodBeat.i(71966);
    com.tencent.mm.plugin.wallet.model.p.ifO();
    if (com.tencent.mm.plugin.wallet.model.p.ifP().VcF == null) {}
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress(new a(), bool);
      AppMethodBeat.o(71966);
      return;
    }
  }
  
  public final void ieR()
  {
    AppMethodBeat.i(71968);
    startActivity(WalletPayUBalanceSaveUI.class);
    AppMethodBeat.o(71968);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71965);
    super.onCreate(paramBundle);
    AppMethodBeat.o(71965);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(71967);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof a))) {
      kD(false);
    }
    AppMethodBeat.o(71967);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */