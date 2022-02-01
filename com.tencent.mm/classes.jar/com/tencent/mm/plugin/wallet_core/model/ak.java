package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class ak
{
  public int VJX;
  private int VJY;
  
  public ak()
  {
    AppMethodBeat.i(70477);
    this.VJX = 0;
    this.VJY = 0;
    h.baF();
    this.VJX = ((Integer)h.baE().ban().d(196660, Integer.valueOf(0))).intValue();
    h.baF();
    this.VJY = ((Integer)h.baE().ban().get(at.a.acYu, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.VJX + "balanceShow:" + this.VJY);
    AppMethodBeat.o(70477);
  }
  
  public ak(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70476);
    this.VJX = 0;
    this.VJY = 0;
    h.baF();
    h.baE().ban().B(196660, Integer.valueOf(paramInt1));
    h.baF();
    h.baE().ban().set(at.a.acYu, Integer.valueOf(paramInt2));
    this.VJX = paramInt1;
    this.VJY = paramInt2;
    Log.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + paramInt1 + "balanceShow:" + paramInt2);
    AppMethodBeat.o(70476);
  }
  
  public final boolean aAL()
  {
    AppMethodBeat.i(70484);
    if ((this.VJX & 0x2000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70484);
      return bool;
    }
  }
  
  public final boolean ieT()
  {
    AppMethodBeat.i(70479);
    if ((this.VJX & 0x4) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70479);
      return bool;
    }
  }
  
  public final boolean iiS()
  {
    AppMethodBeat.i(70478);
    if ((this.VJX & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70478);
      return bool;
    }
  }
  
  public final boolean iiT()
  {
    AppMethodBeat.i(70480);
    if ((this.VJX & 0x80) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70480);
      return bool;
    }
  }
  
  public final boolean iiU()
  {
    AppMethodBeat.i(70481);
    if ((this.VJX & 0x100) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70481);
      return bool;
    }
  }
  
  public final boolean iiV()
  {
    AppMethodBeat.i(70482);
    if ((this.VJX & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70482);
      return bool;
    }
  }
  
  public final boolean iiW()
  {
    AppMethodBeat.i(70483);
    if ((this.VJX & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70483);
      return bool;
    }
  }
  
  public final boolean iiX()
  {
    AppMethodBeat.i(301168);
    if ((this.VJX & 0x4000000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupportNewPayManage, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(301168);
      return bool;
    }
  }
  
  public final boolean iiY()
  {
    AppMethodBeat.i(70485);
    if ((this.VJX & 0x40000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70485);
      return bool;
    }
  }
  
  public final boolean iiZ()
  {
    AppMethodBeat.i(70486);
    if ((this.VJX & 0x800000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70486);
      return bool;
    }
  }
  
  public final boolean ija()
  {
    AppMethodBeat.i(70487);
    if ((this.VJX & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70487);
      return bool;
    }
  }
  
  public final boolean ijb()
  {
    AppMethodBeat.i(70488);
    if ((this.VJX & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70488);
      return bool;
    }
  }
  
  public final boolean ijc()
  {
    AppMethodBeat.i(70489);
    if ((this.VJX & 0x400000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70489);
      return bool;
    }
  }
  
  public final boolean ijd()
  {
    AppMethodBeat.i(70490);
    if ((this.VJX & 0x200000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
      AppMethodBeat.o(70490);
      return bool;
    }
  }
  
  public final boolean ije()
  {
    AppMethodBeat.i(70491);
    boolean bool = Util.isEqual(this.VJY, 1);
    Log.i("MicroMsg.WalletSwitchConfig", "isShowBalance, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.VJX) });
    AppMethodBeat.o(70491);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ak
 * JD-Core Version:    0.7.0.1
 */