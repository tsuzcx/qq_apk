package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletOpenLqbProxyUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48160);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    paramBundle = getProcess();
    if (paramBundle != null)
    {
      int i = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.uyJ, 0);
      String str = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.uyP);
      ab.i("MicroMsg.WalletOpenLqbProxyUI", "WalletOpenLqbProxyUI onCreate, openScene: %s, extraData: %s", new Object[] { Integer.valueOf(i), str });
      if (i == 3)
      {
        getNetController().p(new Object[] { Integer.valueOf(i), str });
        AppMethodBeat.o(48160);
        return;
      }
      paramBundle.b(this, getInput());
      finish();
    }
    AppMethodBeat.o(48160);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI
 * JD-Core Version:    0.7.0.1
 */