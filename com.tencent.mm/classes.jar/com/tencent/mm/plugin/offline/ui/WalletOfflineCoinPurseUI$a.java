package com.tencent.mm.plugin.offline.ui;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dnc;

abstract class WalletOfflineCoinPurseUI$a
  implements a
{
  protected ImageView wBe;
  protected TextView wBf;
  protected ImageView wBg;
  
  public WalletOfflineCoinPurseUI$a(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI)
  {
    dxe();
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    g.a(this, paramk, paramBoolean);
  }
  
  public final boolean a(boolean paramBoolean, dnc paramdnc)
  {
    if (paramBoolean)
    {
      this.wBg.setVisibility(0);
      this.wBf.setVisibility(0);
      this.wBf.setText(paramdnc.title);
    }
    for (;;)
    {
      return true;
      this.wBg.setVisibility(8);
      this.wBf.setVisibility(8);
    }
  }
  
  public final boolean b(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean dkD()
  {
    return false;
  }
  
  public boolean dkE()
  {
    return false;
  }
  
  public abstract void dxe();
  
  public final boolean ol(boolean paramBoolean)
  {
    return g.a(paramBoolean, this);
  }
  
  public final boolean om(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.wBg.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.wBg.setVisibility(8);
    }
  }
  
  public final boolean on(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.wBe.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.wBe.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
 * JD-Core Version:    0.7.0.1
 */