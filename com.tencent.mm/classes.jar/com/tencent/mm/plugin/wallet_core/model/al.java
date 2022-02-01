package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class al
{
  public int IbF;
  private int IbG;
  
  public al()
  {
    AppMethodBeat.i(70477);
    this.IbF = 0;
    this.IbG = 0;
    g.aAi();
    this.IbF = ((Integer)g.aAh().azQ().get(196660, Integer.valueOf(0))).intValue();
    g.aAi();
    this.IbG = ((Integer)g.aAh().azQ().get(ar.a.Oit, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.IbF + "balanceShow:" + this.IbG);
    AppMethodBeat.o(70477);
  }
  
  public al(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70476);
    this.IbF = 0;
    this.IbG = 0;
    g.aAi();
    g.aAh().azQ().set(196660, Integer.valueOf(paramInt1));
    g.aAi();
    g.aAh().azQ().set(ar.a.Oit, Integer.valueOf(paramInt2));
    this.IbF = paramInt1;
    this.IbG = paramInt2;
    Log.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + paramInt1 + "balanceShow:" + paramInt2);
    AppMethodBeat.o(70476);
  }
  
  public final boolean UB()
  {
    AppMethodBeat.i(70484);
    if ((this.IbF & 0x2000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70484);
      return bool;
    }
  }
  
  public final boolean fNq()
  {
    AppMethodBeat.i(70479);
    if ((this.IbF & 0x4) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70479);
      return bool;
    }
  }
  
  public final boolean fQY()
  {
    AppMethodBeat.i(70478);
    if ((this.IbF & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70478);
      return bool;
    }
  }
  
  public final boolean fQZ()
  {
    AppMethodBeat.i(70480);
    if ((this.IbF & 0x80) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70480);
      return bool;
    }
  }
  
  public final boolean fRa()
  {
    AppMethodBeat.i(70481);
    if ((this.IbF & 0x100) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70481);
      return bool;
    }
  }
  
  public final boolean fRb()
  {
    AppMethodBeat.i(70482);
    if ((this.IbF & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70482);
      return bool;
    }
  }
  
  public final boolean fRc()
  {
    AppMethodBeat.i(70483);
    if ((this.IbF & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70483);
      return bool;
    }
  }
  
  public final boolean fRd()
  {
    AppMethodBeat.i(70485);
    if ((this.IbF & 0x40000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70485);
      return bool;
    }
  }
  
  public final boolean fRe()
  {
    AppMethodBeat.i(70486);
    if ((this.IbF & 0x800000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70486);
      return bool;
    }
  }
  
  public final boolean fRf()
  {
    AppMethodBeat.i(70487);
    if ((this.IbF & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70487);
      return bool;
    }
  }
  
  public final boolean fRg()
  {
    AppMethodBeat.i(70488);
    if ((this.IbF & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70488);
      return bool;
    }
  }
  
  public final boolean fRh()
  {
    AppMethodBeat.i(70489);
    if ((this.IbF & 0x400000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70489);
      return bool;
    }
  }
  
  public final boolean fRi()
  {
    AppMethodBeat.i(70490);
    if ((this.IbF & 0x200000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
      AppMethodBeat.o(70490);
      return bool;
    }
  }
  
  public final boolean fRj()
  {
    AppMethodBeat.i(70491);
    boolean bool = Util.isEqual(this.IbG, 1);
    Log.i("MicroMsg.WalletSwitchConfig", "isShowBalance, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.IbF) });
    AppMethodBeat.o(70491);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.al
 * JD-Core Version:    0.7.0.1
 */