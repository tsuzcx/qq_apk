package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.model.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.d;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUBankcardManageUI
  extends WalletBankcardManageUI
{
  public final void Hs(boolean paramBoolean)
  {
    AppMethodBeat.i(71995);
    if (paramBoolean)
    {
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.b.a(), false);
      AppMethodBeat.o(71995);
      return;
    }
    doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.b.a());
    AppMethodBeat.o(71995);
  }
  
  public final void f(Bankcard paramBankcard)
  {
    AppMethodBeat.i(71999);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_bankcard", paramBankcard);
    com.tencent.mm.wallet_core.a.a(this, d.class, localBundle);
    AppMethodBeat.o(71999);
  }
  
  public final com.tencent.mm.plugin.wallet.bind.ui.a ifH()
  {
    AppMethodBeat.i(71998);
    a locala = new a(this, this.Vkp);
    AppMethodBeat.o(71998);
    return locala;
  }
  
  public final void ifI()
  {
    AppMethodBeat.i(71996);
    com.tencent.mm.wallet_core.a.a(this, c.class, null);
    AppMethodBeat.o(71996);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71994);
    super.onCreate(paramBundle);
    AppMethodBeat.o(71994);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71997);
    if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.b.a))
    {
      ifJ();
      AppMethodBeat.o(71997);
      return true;
    }
    AppMethodBeat.o(71997);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI
 * JD-Core Version:    0.7.0.1
 */