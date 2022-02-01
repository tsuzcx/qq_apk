package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class ak
{
  public int Aid;
  private int Aie;
  
  public ak()
  {
    AppMethodBeat.i(70477);
    this.Aid = 0;
    this.Aie = 0;
    g.afC();
    this.Aid = ((Integer)g.afB().afk().get(196660, Integer.valueOf(0))).intValue();
    g.afC();
    this.Aie = ((Integer)g.afB().afk().get(ae.a.FuO, Integer.valueOf(0))).intValue();
    ad.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.Aid + "balanceShow:" + this.Aie);
    AppMethodBeat.o(70477);
  }
  
  public ak(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70476);
    this.Aid = 0;
    this.Aie = 0;
    g.afC();
    g.afB().afk().set(196660, Integer.valueOf(paramInt1));
    g.afC();
    g.afB().afk().set(ae.a.FuO, Integer.valueOf(paramInt2));
    this.Aid = paramInt1;
    this.Aie = paramInt2;
    ad.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + paramInt1 + "balanceShow:" + paramInt2);
    AppMethodBeat.o(70476);
  }
  
  public final boolean Ja()
  {
    AppMethodBeat.i(70484);
    if ((this.Aid & 0x2000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70484);
      return bool;
    }
  }
  
  public final boolean dZg()
  {
    AppMethodBeat.i(70479);
    if ((this.Aid & 0x4) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70479);
      return bool;
    }
  }
  
  public final boolean ecA()
  {
    AppMethodBeat.i(70487);
    if ((this.Aid & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70487);
      return bool;
    }
  }
  
  public final boolean ecB()
  {
    AppMethodBeat.i(70488);
    if ((this.Aid & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70488);
      return bool;
    }
  }
  
  public final boolean ecC()
  {
    AppMethodBeat.i(70489);
    if ((this.Aid & 0x400000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70489);
      return bool;
    }
  }
  
  public final boolean ecD()
  {
    AppMethodBeat.i(70490);
    if ((this.Aid & 0x200000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70490);
      return bool;
    }
  }
  
  public final boolean ecE()
  {
    AppMethodBeat.i(70491);
    boolean bool = bt.iY(this.Aie, 1);
    ad.i("MicroMsg.WalletSwitchConfig", "isShowBalance, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
    AppMethodBeat.o(70491);
    return bool;
  }
  
  public final boolean ecs()
  {
    AppMethodBeat.i(70478);
    if ((this.Aid & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70478);
      return bool;
    }
  }
  
  public final boolean ect()
  {
    AppMethodBeat.i(70480);
    if ((this.Aid & 0x80) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70480);
      return bool;
    }
  }
  
  public final boolean ecu()
  {
    AppMethodBeat.i(70481);
    if ((this.Aid & 0x100) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70481);
      return bool;
    }
  }
  
  public final boolean ecv()
  {
    AppMethodBeat.i(70482);
    if ((this.Aid & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70482);
      return bool;
    }
  }
  
  public final boolean ecw()
  {
    AppMethodBeat.i(70483);
    if ((this.Aid & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70483);
      return bool;
    }
  }
  
  public final boolean ecx()
  {
    AppMethodBeat.i(182526);
    if ((this.Aid & 0x2000000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isSupportBindCardOpt, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(182526);
      return bool;
    }
  }
  
  public final boolean ecy()
  {
    AppMethodBeat.i(70485);
    if ((this.Aid & 0x40000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70485);
      return bool;
    }
  }
  
  public final boolean ecz()
  {
    AppMethodBeat.i(70486);
    if ((this.Aid & 0x800000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Aid) });
      AppMethodBeat.o(70486);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ak
 * JD-Core Version:    0.7.0.1
 */