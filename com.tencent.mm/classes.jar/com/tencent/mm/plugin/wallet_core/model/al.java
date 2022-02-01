package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class al
{
  public int Dst;
  private int Dsu;
  
  public al()
  {
    AppMethodBeat.i(70477);
    this.Dst = 0;
    this.Dsu = 0;
    g.ajS();
    this.Dst = ((Integer)g.ajR().ajA().get(196660, Integer.valueOf(0))).intValue();
    g.ajS();
    this.Dsu = ((Integer)g.ajR().ajA().get(am.a.IZN, Integer.valueOf(0))).intValue();
    ae.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.Dst + "balanceShow:" + this.Dsu);
    AppMethodBeat.o(70477);
  }
  
  public al(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70476);
    this.Dst = 0;
    this.Dsu = 0;
    g.ajS();
    g.ajR().ajA().set(196660, Integer.valueOf(paramInt1));
    g.ajS();
    g.ajR().ajA().set(am.a.IZN, Integer.valueOf(paramInt2));
    this.Dst = paramInt1;
    this.Dsu = paramInt2;
    ae.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + paramInt1 + "balanceShow:" + paramInt2);
    AppMethodBeat.o(70476);
  }
  
  public final boolean Kr()
  {
    AppMethodBeat.i(70484);
    if ((this.Dst & 0x2000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70484);
      return bool;
    }
  }
  
  public final boolean eGi()
  {
    AppMethodBeat.i(70479);
    if ((this.Dst & 0x4) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70479);
      return bool;
    }
  }
  
  public final boolean eJA()
  {
    AppMethodBeat.i(70485);
    if ((this.Dst & 0x40000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70485);
      return bool;
    }
  }
  
  public final boolean eJB()
  {
    AppMethodBeat.i(70486);
    if ((this.Dst & 0x800000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70486);
      return bool;
    }
  }
  
  public final boolean eJC()
  {
    AppMethodBeat.i(70487);
    if ((this.Dst & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70487);
      return bool;
    }
  }
  
  public final boolean eJD()
  {
    AppMethodBeat.i(70488);
    if ((this.Dst & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70488);
      return bool;
    }
  }
  
  public final boolean eJE()
  {
    AppMethodBeat.i(70489);
    if ((this.Dst & 0x400000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70489);
      return bool;
    }
  }
  
  public final boolean eJF()
  {
    AppMethodBeat.i(70490);
    if ((this.Dst & 0x200000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70490);
      return bool;
    }
  }
  
  public final boolean eJG()
  {
    AppMethodBeat.i(70491);
    boolean bool = bu.jB(this.Dsu, 1);
    ae.i("MicroMsg.WalletSwitchConfig", "isShowBalance, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
    AppMethodBeat.o(70491);
    return bool;
  }
  
  public final boolean eJv()
  {
    AppMethodBeat.i(70478);
    if ((this.Dst & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70478);
      return bool;
    }
  }
  
  public final boolean eJw()
  {
    AppMethodBeat.i(70480);
    if ((this.Dst & 0x80) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70480);
      return bool;
    }
  }
  
  public final boolean eJx()
  {
    AppMethodBeat.i(70481);
    if ((this.Dst & 0x100) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70481);
      return bool;
    }
  }
  
  public final boolean eJy()
  {
    AppMethodBeat.i(70482);
    if ((this.Dst & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70482);
      return bool;
    }
  }
  
  public final boolean eJz()
  {
    AppMethodBeat.i(70483);
    if ((this.Dst & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Dst) });
      AppMethodBeat.o(70483);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.al
 * JD-Core Version:    0.7.0.1
 */