package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI;
import com.tencent.mm.plugin.wallet_payu.balance.a.a;
import com.tencent.mm.pluginsdk.wallet.h;

public class WalletPayUBalanceSaveUI
  extends WalletBalanceSaveUI
{
  public final void cRi()
  {
    AppMethodBeat.i(48331);
    doSceneProgress(new a(this.qlk, "ZAR"));
    AppMethodBeat.o(48331);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48330);
    super.onCreate(paramBundle);
    this.tNK.setVisibility(8);
    AppMethodBeat.o(48330);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48332);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof a))) {
      h.a(this, ((a)paramm).cnI, "", 11, 1);
    }
    AppMethodBeat.o(48332);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceSaveUI
 * JD-Core Version:    0.7.0.1
 */