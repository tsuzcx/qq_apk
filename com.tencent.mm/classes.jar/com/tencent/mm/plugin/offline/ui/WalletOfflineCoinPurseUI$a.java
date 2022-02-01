package com.tencent.mm.plugin.offline.ui;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dnz;

abstract class WalletOfflineCoinPurseUI$a
  implements a
{
  protected ImageView wQP;
  protected TextView wQQ;
  protected ImageView wQR;
  
  public WalletOfflineCoinPurseUI$a(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI)
  {
    dAu();
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    g.a(this, paramk, paramBoolean);
  }
  
  public final boolean a(boolean paramBoolean, dnz paramdnz)
  {
    if (paramBoolean)
    {
      this.wQR.setVisibility(0);
      this.wQQ.setVisibility(0);
      this.wQQ.setText(paramdnz.title);
    }
    for (;;)
    {
      return true;
      this.wQR.setVisibility(8);
      this.wQQ.setVisibility(8);
    }
  }
  
  public final boolean b(boolean paramBoolean, dnz paramdnz)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dnz paramdnz)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, dnz paramdnz)
  {
    return false;
  }
  
  public abstract void dAu();
  
  public final boolean dnD()
  {
    return false;
  }
  
  public boolean dnE()
  {
    return false;
  }
  
  public final boolean oq(boolean paramBoolean)
  {
    return g.a(paramBoolean, this);
  }
  
  public final boolean or(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.wQR.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.wQR.setVisibility(8);
    }
  }
  
  public final boolean os(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.wQP.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.wQP.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
 * JD-Core Version:    0.7.0.1
 */