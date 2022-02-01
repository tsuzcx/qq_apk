package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.wallet.balance.model.lqt.o;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.h;

@a(7)
public class WalletLqtBeforeSaveUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68779);
    super.onCreate(paramBundle);
    paramBundle = h.c(this, false, null);
    new o().aET().b(new WalletLqtBeforeSaveUI.1(this, paramBundle));
    AppMethodBeat.o(68779);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68780);
    super.onDestroy();
    AppMethodBeat.o(68780);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBeforeSaveUI
 * JD-Core Version:    0.7.0.1
 */