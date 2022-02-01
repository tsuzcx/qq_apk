package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class WalletLqtBasePresenterUI
  extends WalletBaseUI
{
  private c htH = new c();
  
  public final <T extends b<? extends a>> T aq(Class<? extends b<? extends a>> paramClass)
  {
    return this.htH.a(this, paramClass);
  }
  
  public final <T extends a> T au(Class<? extends a> paramClass)
  {
    return this.htH.b(this, paramClass);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.htH.A(getIntent(), this);
    this.isVKBFirstTimeShown = true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.htH.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.htH.apB(3);
  }
  
  public void onResume()
  {
    super.onResume();
    this.htH.apB(2);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI
 * JD-Core Version:    0.7.0.1
 */