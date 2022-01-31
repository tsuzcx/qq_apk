package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class WalletLqtBasePresenterUI
  extends WalletBaseUI
{
  private c eKO = new c();
  
  public final <T extends b<? extends a>> T P(Class<? extends b<? extends a>> paramClass)
  {
    return this.eKO.a(this, paramClass);
  }
  
  public final <T extends a> T T(Class<? extends a> paramClass)
  {
    return this.eKO.b(this, paramClass);
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
    this.eKO.A(getIntent(), this);
    this.isVKBFirstTimeShown = true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.eKO.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.eKO.a(3);
  }
  
  public void onResume()
  {
    super.onResume();
    this.eKO.a(2);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI
 * JD-Core Version:    0.7.0.1
 */