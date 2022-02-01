package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletOpenLqbProxyUI
  extends WalletBaseUI
{
  public com.tencent.mm.plugin.wallet.balance.ui.lqt.a Pjh;
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71795);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.Pjh = new com.tencent.mm.plugin.wallet.balance.ui.lqt.a(this);
    paramBundle = getProcess();
    if (paramBundle != null)
    {
      int i = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.PhY, 0);
      String str = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.Pie);
      Log.i("MicroMsg.WalletOpenLqbProxyUI", "WalletOpenLqbProxyUI onCreate, openScene: %s, extraData: %s", new Object[] { Integer.valueOf(i), str });
      if (i == 3)
      {
        getNetController().r(new Object[] { Integer.valueOf(i), str });
        AppMethodBeat.o(71795);
        return;
      }
      paramBundle.b(this, getInput());
      finish();
    }
    AppMethodBeat.o(71795);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI
 * JD-Core Version:    0.7.0.1
 */