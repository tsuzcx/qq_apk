package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class ak
{
  public int BAx;
  private int BAy;
  
  public ak()
  {
    AppMethodBeat.i(70477);
    this.BAx = 0;
    this.BAy = 0;
    g.agS();
    this.BAx = ((Integer)g.agR().agA().get(196660, Integer.valueOf(0))).intValue();
    g.agS();
    this.BAy = ((Integer)g.agR().agA().get(ah.a.GSI, Integer.valueOf(0))).intValue();
    ac.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.BAx + "balanceShow:" + this.BAy);
    AppMethodBeat.o(70477);
  }
  
  public ak(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70476);
    this.BAx = 0;
    this.BAy = 0;
    g.agS();
    g.agR().agA().set(196660, Integer.valueOf(paramInt1));
    g.agS();
    g.agR().agA().set(ah.a.GSI, Integer.valueOf(paramInt2));
    this.BAx = paramInt1;
    this.BAy = paramInt2;
    ac.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + paramInt1 + "balanceShow:" + paramInt2);
    AppMethodBeat.o(70476);
  }
  
  public final boolean IJ()
  {
    AppMethodBeat.i(70484);
    if ((this.BAx & 0x2000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70484);
      return bool;
    }
  }
  
  public final boolean eoC()
  {
    AppMethodBeat.i(70479);
    if ((this.BAx & 0x4) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70479);
      return bool;
    }
  }
  
  public final boolean erO()
  {
    AppMethodBeat.i(70478);
    if ((this.BAx & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70478);
      return bool;
    }
  }
  
  public final boolean erP()
  {
    AppMethodBeat.i(70480);
    if ((this.BAx & 0x80) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70480);
      return bool;
    }
  }
  
  public final boolean erQ()
  {
    AppMethodBeat.i(70481);
    if ((this.BAx & 0x100) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70481);
      return bool;
    }
  }
  
  public final boolean erR()
  {
    AppMethodBeat.i(70482);
    if ((this.BAx & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70482);
      return bool;
    }
  }
  
  public final boolean erS()
  {
    AppMethodBeat.i(70483);
    if ((this.BAx & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70483);
      return bool;
    }
  }
  
  public final boolean erT()
  {
    AppMethodBeat.i(70485);
    if ((this.BAx & 0x40000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70485);
      return bool;
    }
  }
  
  public final boolean erU()
  {
    AppMethodBeat.i(70486);
    if ((this.BAx & 0x800000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70486);
      return bool;
    }
  }
  
  public final boolean erV()
  {
    AppMethodBeat.i(70487);
    if ((this.BAx & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70487);
      return bool;
    }
  }
  
  public final boolean erW()
  {
    AppMethodBeat.i(70488);
    if ((this.BAx & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70488);
      return bool;
    }
  }
  
  public final boolean erX()
  {
    AppMethodBeat.i(70489);
    if ((this.BAx & 0x400000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70489);
      return bool;
    }
  }
  
  public final boolean erY()
  {
    AppMethodBeat.i(70490);
    if ((this.BAx & 0x200000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
      AppMethodBeat.o(70490);
      return bool;
    }
  }
  
  public final boolean erZ()
  {
    AppMethodBeat.i(70491);
    boolean bool = bs.jl(this.BAy, 1);
    ac.i("MicroMsg.WalletSwitchConfig", "isShowBalance, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.BAx) });
    AppMethodBeat.o(70491);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ak
 * JD-Core Version:    0.7.0.1
 */