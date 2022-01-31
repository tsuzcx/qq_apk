package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class ak
{
  public int ulJ;
  private int ulK;
  
  public ak()
  {
    AppMethodBeat.i(46949);
    this.ulJ = 0;
    this.ulK = 0;
    g.RM();
    this.ulJ = ((Integer)g.RL().Ru().get(196660, Integer.valueOf(0))).intValue();
    g.RM();
    this.ulK = ((Integer)g.RL().Ru().get(ac.a.yLt, Integer.valueOf(0))).intValue();
    ab.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.ulJ + "balanceShow:" + this.ulK);
    AppMethodBeat.o(46949);
  }
  
  public ak(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46948);
    this.ulJ = 0;
    this.ulK = 0;
    g.RM();
    g.RL().Ru().set(196660, Integer.valueOf(paramInt1));
    g.RM();
    g.RL().Ru().set(ac.a.yLt, Integer.valueOf(paramInt2));
    this.ulJ = paramInt1;
    this.ulK = paramInt2;
    ab.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + paramInt1 + "balanceShow:" + paramInt2);
    AppMethodBeat.o(46948);
  }
  
  public final boolean aec()
  {
    AppMethodBeat.i(46956);
    if ((this.ulJ & 0x2000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
      AppMethodBeat.o(46956);
      return bool;
    }
  }
  
  public final boolean cRf()
  {
    AppMethodBeat.i(46951);
    if ((this.ulJ & 0x4) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
      AppMethodBeat.o(46951);
      return bool;
    }
  }
  
  public final boolean cUb()
  {
    AppMethodBeat.i(46950);
    if ((this.ulJ & 0x2) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
      AppMethodBeat.o(46950);
      return bool;
    }
  }
  
  public final boolean cUc()
  {
    AppMethodBeat.i(46952);
    if ((this.ulJ & 0x80) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
      AppMethodBeat.o(46952);
      return bool;
    }
  }
  
  public final boolean cUd()
  {
    AppMethodBeat.i(46953);
    if ((this.ulJ & 0x100) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
      AppMethodBeat.o(46953);
      return bool;
    }
  }
  
  public final boolean cUe()
  {
    AppMethodBeat.i(46954);
    if ((this.ulJ & 0x400) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
      AppMethodBeat.o(46954);
      return bool;
    }
  }
  
  public final boolean cUf()
  {
    AppMethodBeat.i(46955);
    if ((this.ulJ & 0x800) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
      AppMethodBeat.o(46955);
      return bool;
    }
  }
  
  public final boolean cUg()
  {
    AppMethodBeat.i(46957);
    if ((this.ulJ & 0x40000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
      AppMethodBeat.o(46957);
      return bool;
    }
  }
  
  public final boolean cUh()
  {
    AppMethodBeat.i(46958);
    if ((this.ulJ & 0x800000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
      AppMethodBeat.o(46958);
      return bool;
    }
  }
  
  public final boolean cUi()
  {
    AppMethodBeat.i(46959);
    if ((this.ulJ & 0x8000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
      AppMethodBeat.o(46959);
      return bool;
    }
  }
  
  public final boolean cUj()
  {
    AppMethodBeat.i(46960);
    if ((this.ulJ & 0x200000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
      AppMethodBeat.o(46960);
      return bool;
    }
  }
  
  public final boolean cUk()
  {
    AppMethodBeat.i(46961);
    boolean bool = bo.hl(this.ulK, 1);
    ab.i("MicroMsg.WalletSwitchConfig", "isShowBalance, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.ulJ) });
    AppMethodBeat.o(46961);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ak
 * JD-Core Version:    0.7.0.1
 */