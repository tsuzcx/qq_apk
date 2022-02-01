package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.l;

@com.tencent.mm.ui.base.a(7)
public class WalletLqtBeforeSaveUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(68779);
    super.onCreate(paramBundle);
    paramBundle = l.c(this, false, null);
    new com.tencent.mm.plugin.wallet.balance.model.lqt.p().bFJ().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(68779);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68780);
    super.onDestroy();
    AppMethodBeat.o(68780);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBeforeSaveUI
 * JD-Core Version:    0.7.0.1
 */