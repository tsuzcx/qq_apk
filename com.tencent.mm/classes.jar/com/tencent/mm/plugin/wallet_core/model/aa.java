package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.g.a.xf.a;
import com.tencent.mm.g.a.xf.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;

public final class aa
  extends c<xf>
  implements com.tencent.mm.al.g
{
  private xf AhF;
  private n AhG;
  private boolean dCJ;
  private boolean dCK;
  private boolean rbD;
  
  public aa()
  {
    AppMethodBeat.i(160877);
    this.rbD = false;
    this.dCJ = false;
    this.dCK = false;
    this.__eventId = xf.class.getName().hashCode();
    AppMethodBeat.o(160877);
  }
  
  private static boolean Ry(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 19) || (paramInt == 20) || (paramInt == 21) || (paramInt == 22) || (paramInt == 23);
  }
  
  private void a(int paramInt, String paramString, n paramn)
  {
    AppMethodBeat.i(70425);
    com.tencent.mm.kernel.g.aeS().b(385, this);
    com.tencent.mm.kernel.g.aeS().b(1518, this);
    if ((!this.dCK) && (this.dCJ) && (this.rbD))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
      AppMethodBeat.o(70425);
      return;
    }
    this.rbD = true;
    a(paramInt, paramString, paramn, true);
    AppMethodBeat.o(70425);
  }
  
  private void a(int paramInt, String paramString, n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(70426);
    if (this.AhF != null)
    {
      this.AhF.dCI.errCode = paramInt;
      this.AhF.dCI.errMsg = paramString;
      this.AhF.dCI.dDn = paramn;
      this.AhF.dCI.dCL = s.ecc().ecF();
      this.AhF.dCI.dCM = s.ecc().ede();
      this.AhF.dCI.dCN = s.ecc().edg();
      this.AhF.dCI.dCO = s.ecc().ecN().ecs();
      this.AhF.dCI.dCP = s.ecc().ecM();
      this.AhF.dCI.dCQ = s.ecc().getTrueName();
      this.AhF.dCI.dCR = s.ecc().ecG();
      this.AhF.dCI.dCS = s.ecc().ecN().ecw();
      this.AhF.dCI.dCT = "";
      this.AhF.dCI.dDg = s.ecc().ecY();
      if ((paramn != null) && ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)))
      {
        this.AhF.dCI.dCT = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dCT;
        this.AhF.dCI.dCU = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dCU;
        this.AhF.dCI.dCV = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dCV;
        this.AhF.dCI.dCW = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dCW;
        this.AhF.dCI.dCX = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dCX;
        this.AhF.dCI.scene = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).scene;
        this.AhF.dCI.dCY = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dCY;
        this.AhF.dCI.dCZ = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dCZ;
        this.AhF.dCI.dDa = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dDa;
        this.AhF.dCI.dDb = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dDb;
        this.AhF.dCI.dDc = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dDc;
        this.AhF.dCI.dDd = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dDd;
        this.AhF.dCI.subtitle = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).subtitle;
        this.AhF.dCI.title = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).title;
        this.AhF.dCI.dDe = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dDe;
        this.AhF.dCI.dDf = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dDf;
        this.AhF.dCI.dDl = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).zWI;
      }
      paramString = this.AhF.dCI;
      if (!s.ecc().ecU()) {
        break label728;
      }
    }
    label728:
    for (paramInt = 1;; paramInt = 0)
    {
      paramString.dDh = paramInt;
      this.AhF.dCI.dDi = s.ecc().ecV();
      this.AhF.dCI.dDj = s.ecc().ecW();
      this.AhF.dCI.dDk = s.ecc().ecX();
      this.AhF.dCI.dDm = paramBoolean;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.AhF.dCI.dCM + " hasNewTips : " + this.AhF.dCI.dCN + " swipeOn : " + this.AhF.dCI.dCO);
      if (this.AhF.callback != null) {
        this.AhF.callback.run();
      }
      if (this.AhF.dCI.dCz != null) {
        this.AhF.dCI.dCz.run();
      }
      if (this.rbD) {
        this.AhF = null;
      }
      AppMethodBeat.o(70426);
      return;
    }
  }
  
  private boolean a(xf paramxf)
  {
    AppMethodBeat.i(70422);
    if (!(paramxf instanceof xf))
    {
      com.tencent.mm.sdk.platformtools.ad.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
      AppMethodBeat.o(70422);
      return false;
    }
    this.rbD = false;
    this.AhF = paramxf;
    this.dCJ = paramxf.dCH.dCJ;
    this.dCK = paramxf.dCH.dCK;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", new Object[] { Boolean.valueOf(this.dCK) });
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(385, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1518, this);
    if (s.ecc().ecK())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
      b(paramxf);
    }
    for (;;)
    {
      AppMethodBeat.o(70422);
      return true;
      am localam;
      long l;
      int i;
      if (paramxf.dCH.dCJ)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
        localam = s.ecc();
        l = bt.aGK();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", new Object[] { Long.valueOf(l), Long.valueOf(localam.Aiq) });
        if ((localam.Aiq <= 0L) || (l > localam.Aiq)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label273;
          }
          if (!this.dCK) {
            this.rbD = true;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
          a(0, "", null, false);
          b(paramxf);
          break;
        }
        label273:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
        b(paramxf);
      }
      else
      {
        localam = s.ecc();
        l = bt.lZ(localam.Aip);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time ".concat(String.valueOf(l)), new Object[] { Long.valueOf(localam.Aip), Long.valueOf(System.currentTimeMillis() / 1000L) });
        if (l > 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label380;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
          b(paramxf);
          break;
        }
        label380:
        this.rbD = true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
        a(0, "", null, false);
      }
    }
  }
  
  private void b(xf paramxf)
  {
    AppMethodBeat.i(70423);
    if (u.aqV())
    {
      this.AhG = new a();
      com.tencent.mm.kernel.g.aeS().a(this.AhG, 0);
      AppMethodBeat.o(70423);
      return;
    }
    if (Ry(paramxf.dCH.scene)) {}
    for (int i = paramxf.dCH.scene;; i = 0)
    {
      this.AhG = new com.tencent.mm.plugin.wallet_core.c.ad(null, i);
      com.tencent.mm.kernel.g.aeS().a(this.AhG, 0);
      AppMethodBeat.o(70423);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70424);
    if ((this.AhF == null) || (this.AhF.dCH == null))
    {
      AppMethodBeat.o(70424);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s, retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn, Integer.valueOf(this.AhF.dCH.retryCount) });
    if (paramn != this.AhG)
    {
      AppMethodBeat.o(70424);
      return;
    }
    if (((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)) || ((paramn instanceof a)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(paramInt2, paramString, paramn);
        AppMethodBeat.o(70424);
        return;
      }
      if (this.AhF.dCH.retryCount == 0)
      {
        a(paramInt2, paramString, paramn);
        AppMethodBeat.o(70424);
        return;
      }
      paramString = this.AhF.dCH;
      paramString.retryCount -= 1;
      b(this.AhF);
    }
    AppMethodBeat.o(70424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa
 * JD-Core Version:    0.7.0.1
 */