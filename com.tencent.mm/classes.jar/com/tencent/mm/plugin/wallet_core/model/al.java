package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class al
{
  public int DaP;
  private int DaQ;
  
  public al()
  {
    AppMethodBeat.i(70477);
    this.DaP = 0;
    this.DaQ = 0;
    g.ajD();
    this.DaP = ((Integer)g.ajC().ajl().get(196660, Integer.valueOf(0))).intValue();
    g.ajD();
    this.DaQ = ((Integer)g.ajC().ajl().get(al.a.IFn, Integer.valueOf(0))).intValue();
    ad.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.DaP + "balanceShow:" + this.DaQ);
    AppMethodBeat.o(70477);
  }
  
  public al(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70476);
    this.DaP = 0;
    this.DaQ = 0;
    g.ajD();
    g.ajC().ajl().set(196660, Integer.valueOf(paramInt1));
    g.ajD();
    g.ajC().ajl().set(al.a.IFn, Integer.valueOf(paramInt2));
    this.DaP = paramInt1;
    this.DaQ = paramInt2;
    ad.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + paramInt1 + "balanceShow:" + paramInt2);
    AppMethodBeat.o(70476);
  }
  
  public final boolean Kj()
  {
    AppMethodBeat.i(70484);
    if ((this.DaP & 0x2000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70484);
      return bool;
    }
  }
  
  public final boolean eCB()
  {
    AppMethodBeat.i(70479);
    if ((this.DaP & 0x4) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70479);
      return bool;
    }
  }
  
  public final boolean eFO()
  {
    AppMethodBeat.i(70478);
    if ((this.DaP & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70478);
      return bool;
    }
  }
  
  public final boolean eFP()
  {
    AppMethodBeat.i(70480);
    if ((this.DaP & 0x80) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70480);
      return bool;
    }
  }
  
  public final boolean eFQ()
  {
    AppMethodBeat.i(70481);
    if ((this.DaP & 0x100) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70481);
      return bool;
    }
  }
  
  public final boolean eFR()
  {
    AppMethodBeat.i(70482);
    if ((this.DaP & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70482);
      return bool;
    }
  }
  
  public final boolean eFS()
  {
    AppMethodBeat.i(70483);
    if ((this.DaP & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70483);
      return bool;
    }
  }
  
  public final boolean eFT()
  {
    AppMethodBeat.i(70485);
    if ((this.DaP & 0x40000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70485);
      return bool;
    }
  }
  
  public final boolean eFU()
  {
    AppMethodBeat.i(70486);
    if ((this.DaP & 0x800000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70486);
      return bool;
    }
  }
  
  public final boolean eFV()
  {
    AppMethodBeat.i(70487);
    if ((this.DaP & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70487);
      return bool;
    }
  }
  
  public final boolean eFW()
  {
    AppMethodBeat.i(70488);
    if ((this.DaP & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70488);
      return bool;
    }
  }
  
  public final boolean eFX()
  {
    AppMethodBeat.i(70489);
    if ((this.DaP & 0x400000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70489);
      return bool;
    }
  }
  
  public final boolean eFY()
  {
    AppMethodBeat.i(70490);
    if ((this.DaP & 0x200000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
      AppMethodBeat.o(70490);
      return bool;
    }
  }
  
  public final boolean eFZ()
  {
    AppMethodBeat.i(70491);
    boolean bool = bt.jx(this.DaQ, 1);
    ad.i("MicroMsg.WalletSwitchConfig", "isShowBalance, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.DaP) });
    AppMethodBeat.o(70491);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.al
 * JD-Core Version:    0.7.0.1
 */