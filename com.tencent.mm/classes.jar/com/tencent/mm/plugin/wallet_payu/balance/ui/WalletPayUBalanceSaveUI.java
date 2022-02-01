package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI;
import com.tencent.mm.plugin.wallet_payu.balance.a.a;
import com.tencent.mm.pluginsdk.wallet.f;

public class WalletPayUBalanceSaveUI
  extends WalletBalanceSaveUI
{
  public final void ieW()
  {
    AppMethodBeat.i(71971);
    doSceneProgress(new a(this.pJk, "ZAR"));
    AppMethodBeat.o(71971);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71970);
    super.onCreate(paramBundle);
    this.Vbx.setVisibility(8);
    AppMethodBeat.o(71970);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71972);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof a))) {
      f.b(this, ((a)paramp).hAT, "", 11, 1);
    }
    AppMethodBeat.o(71972);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceSaveUI
 * JD-Core Version:    0.7.0.1
 */