package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class am
{
  public int OTR;
  private int OTS;
  
  public am()
  {
    AppMethodBeat.i(70477);
    this.OTR = 0;
    this.OTS = 0;
    h.aHH();
    this.OTR = ((Integer)h.aHG().aHp().b(196660, Integer.valueOf(0))).intValue();
    h.aHH();
    this.OTS = ((Integer)h.aHG().aHp().get(ar.a.VwJ, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.OTR + "balanceShow:" + this.OTS);
    AppMethodBeat.o(70477);
  }
  
  public am(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70476);
    this.OTR = 0;
    this.OTS = 0;
    h.aHH();
    h.aHG().aHp().i(196660, Integer.valueOf(paramInt1));
    h.aHH();
    h.aHG().aHp().set(ar.a.VwJ, Integer.valueOf(paramInt2));
    this.OTR = paramInt1;
    this.OTS = paramInt2;
    Log.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + paramInt1 + "balanceShow:" + paramInt2);
    AppMethodBeat.o(70476);
  }
  
  public final boolean YT()
  {
    AppMethodBeat.i(70484);
    if ((this.OTR & 0x2000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70484);
      return bool;
    }
  }
  
  public final boolean gFU()
  {
    AppMethodBeat.i(70479);
    if ((this.OTR & 0x4) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70479);
      return bool;
    }
  }
  
  public final boolean gJE()
  {
    AppMethodBeat.i(70478);
    if ((this.OTR & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70478);
      return bool;
    }
  }
  
  public final boolean gJF()
  {
    AppMethodBeat.i(70480);
    if ((this.OTR & 0x80) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70480);
      return bool;
    }
  }
  
  public final boolean gJG()
  {
    AppMethodBeat.i(70481);
    if ((this.OTR & 0x100) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70481);
      return bool;
    }
  }
  
  public final boolean gJH()
  {
    AppMethodBeat.i(70482);
    if ((this.OTR & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70482);
      return bool;
    }
  }
  
  public final boolean gJI()
  {
    AppMethodBeat.i(70483);
    if ((this.OTR & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70483);
      return bool;
    }
  }
  
  public final boolean gJJ()
  {
    AppMethodBeat.i(70485);
    if ((this.OTR & 0x40000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70485);
      return bool;
    }
  }
  
  public final boolean gJK()
  {
    AppMethodBeat.i(70486);
    if ((this.OTR & 0x800000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70486);
      return bool;
    }
  }
  
  public final boolean gJL()
  {
    AppMethodBeat.i(70487);
    if ((this.OTR & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70487);
      return bool;
    }
  }
  
  public final boolean gJM()
  {
    AppMethodBeat.i(70488);
    if ((this.OTR & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70488);
      return bool;
    }
  }
  
  public final boolean gJN()
  {
    AppMethodBeat.i(70489);
    if ((this.OTR & 0x400000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70489);
      return bool;
    }
  }
  
  public final boolean gJO()
  {
    AppMethodBeat.i(70490);
    if ((this.OTR & 0x200000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
      AppMethodBeat.o(70490);
      return bool;
    }
  }
  
  public final boolean gJP()
  {
    AppMethodBeat.i(70491);
    boolean bool = Util.isEqual(this.OTS, 1);
    Log.i("MicroMsg.WalletSwitchConfig", "isShowBalance, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OTR) });
    AppMethodBeat.o(70491);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.am
 * JD-Core Version:    0.7.0.1
 */