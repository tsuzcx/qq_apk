package com.tencent.mm.plugin.offline.ui;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dcb;

abstract class WalletOfflineCoinPurseUI$a
  implements a
{
  protected ImageView umO;
  protected TextView umP;
  protected ImageView umQ;
  
  public WalletOfflineCoinPurseUI$a(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI)
  {
    cZe();
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    g.a(this, paramk, paramBoolean);
  }
  
  public final boolean a(boolean paramBoolean, dcb paramdcb)
  {
    if (paramBoolean)
    {
      this.umQ.setVisibility(0);
      this.umP.setVisibility(0);
      this.umP.setText(paramdcb.title);
    }
    for (;;)
    {
      return true;
      this.umQ.setVisibility(8);
      this.umP.setVisibility(8);
    }
  }
  
  public final boolean b(boolean paramBoolean, dcb paramdcb)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dcb paramdcb)
  {
    return false;
  }
  
  public final boolean cND()
  {
    return false;
  }
  
  public boolean cNE()
  {
    return false;
  }
  
  public abstract void cZe();
  
  public final boolean d(boolean paramBoolean, dcb paramdcb)
  {
    return false;
  }
  
  public final boolean mY(boolean paramBoolean)
  {
    return g.a(paramBoolean, this);
  }
  
  public final boolean mZ(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.umQ.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.umQ.setVisibility(8);
    }
  }
  
  public final boolean na(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.umO.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.umO.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.a
 * JD-Core Version:    0.7.0.1
 */