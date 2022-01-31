package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.plugin.wallet_core.model.am;

public class WalletPayUBalanceManagerUI
  extends WalletBalanceManagerUI
{
  public final void cRd()
  {
    AppMethodBeat.i(48325);
    s.cRG();
    if (s.cRH().tOD == null) {}
    for (boolean bool = true;; bool = false)
    {
      doSceneProgress(new a(), bool);
      AppMethodBeat.o(48325);
      return;
    }
  }
  
  public final void cRe()
  {
    AppMethodBeat.i(48327);
    startActivity(WalletPayUBalanceSaveUI.class);
    AppMethodBeat.o(48327);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48324);
    super.onCreate(paramBundle);
    AppMethodBeat.o(48324);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48326);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof a))) {
      bJ();
    }
    AppMethodBeat.o(48326);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceManagerUI
 * JD-Core Version:    0.7.0.1
 */