package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class ae
{
  public int qza = 0;
  
  public ae()
  {
    g.DQ();
    this.qza = ((Integer)g.DP().Dz().get(196660, Integer.valueOf(0))).intValue();
    y.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.qza);
  }
  
  public ae(int paramInt)
  {
    g.DQ();
    g.DP().Dz().o(196660, Integer.valueOf(paramInt));
    this.qza = paramInt;
    y.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + paramInt);
  }
  
  public final boolean bVF()
  {
    if ((this.qza & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.qza) });
      return bool;
    }
  }
  
  public final boolean bVG()
  {
    if ((this.qza & 0x80) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.qza) });
      return bool;
    }
  }
  
  public final boolean bVH()
  {
    if ((this.qza & 0x100) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.qza) });
      return bool;
    }
  }
  
  public final boolean bVI()
  {
    if ((this.qza & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.qza) });
      return bool;
    }
  }
  
  public final boolean bVJ()
  {
    if ((this.qza & 0x200000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.qza) });
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ae
 * JD-Core Version:    0.7.0.1
 */