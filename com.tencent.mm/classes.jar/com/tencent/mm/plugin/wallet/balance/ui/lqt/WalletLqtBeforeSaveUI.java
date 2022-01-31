package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.wallet.balance.a.a.l;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;

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
    AppMethodBeat.i(45514);
    super.onCreate(paramBundle);
    paramBundle = g.c(this, false, null);
    new l().adl().b(new WalletLqtBeforeSaveUI.1(this, paramBundle));
    AppMethodBeat.o(45514);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45515);
    super.onDestroy();
    AppMethodBeat.o(45515);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBeforeSaveUI
 * JD-Core Version:    0.7.0.1
 */