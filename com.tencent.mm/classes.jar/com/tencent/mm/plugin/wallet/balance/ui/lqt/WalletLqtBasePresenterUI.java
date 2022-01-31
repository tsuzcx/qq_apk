package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class WalletLqtBasePresenterUI
  extends WalletBaseUI
{
  private c dNd = new c();
  
  public final <T extends a> T C(Class<? extends a> paramClass)
  {
    return this.dNd.b(this, paramClass);
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected int getLayoutId()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dNd.B(getIntent(), this);
    this.wCm = true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.dNd.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.dNd.a(3);
  }
  
  public void onResume()
  {
    super.onResume();
    this.dNd.a(2);
  }
  
  public final <T extends b<? extends a>> T z(Class<? extends b<? extends a>> paramClass)
  {
    return this.dNd.a(this, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI
 * JD-Core Version:    0.7.0.1
 */