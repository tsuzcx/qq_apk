package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.g.a.yk.a;
import com.tencent.mm.g.a.yk.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;

public final class ab
  extends c<yk>
  implements f
{
  private yk Das;
  private n Dat;
  private boolean dMI;
  private boolean dMJ;
  private boolean tgz;
  
  public ab()
  {
    AppMethodBeat.i(160877);
    this.tgz = false;
    this.dMI = false;
    this.dMJ = false;
    this.__eventId = yk.class.getName().hashCode();
    AppMethodBeat.o(160877);
  }
  
  private static boolean Vz(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 19) || (paramInt == 20) || (paramInt == 21) || (paramInt == 22) || (paramInt == 23);
  }
  
  private void a(int paramInt, String paramString, n paramn)
  {
    AppMethodBeat.i(70425);
    g.aiU().b(385, this);
    g.aiU().b(1518, this);
    if ((!this.dMJ) && (this.dMI) && (this.tgz))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
      AppMethodBeat.o(70425);
      return;
    }
    this.tgz = true;
    a(paramInt, paramString, paramn, true);
    AppMethodBeat.o(70425);
  }
  
  private void a(int paramInt, String paramString, n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(70426);
    if (this.Das != null)
    {
      this.Das.dMH.errCode = paramInt;
      this.Das.dMH.errMsg = paramString;
      this.Das.dMH.dNm = paramn;
      this.Das.dMH.dMK = t.eFy().eGa();
      this.Das.dMH.dML = t.eFy().eGz();
      this.Das.dMH.dMM = t.eFy().eGB();
      this.Das.dMH.dMN = t.eFy().eGi().eFO();
      this.Das.dMH.dMO = t.eFy().eGh();
      this.Das.dMH.dMP = t.eFy().getTrueName();
      this.Das.dMH.dMQ = t.eFy().eGb();
      this.Das.dMH.dMR = t.eFy().eGi().eFS();
      this.Das.dMH.dMS = "";
      this.Das.dMH.dNf = t.eFy().eGt();
      if ((paramn != null) && ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)))
      {
        this.Das.dMH.dMS = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dMS;
        this.Das.dMH.dMT = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dMT;
        this.Das.dMH.dMU = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dMU;
        this.Das.dMH.dMV = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dMV;
        this.Das.dMH.dMW = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dMW;
        this.Das.dMH.scene = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).scene;
        this.Das.dMH.dMX = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dMX;
        this.Das.dMH.dMY = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dMY;
        this.Das.dMH.dMZ = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dMZ;
        this.Das.dMH.dNa = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dNa;
        this.Das.dMH.dNb = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dNb;
        this.Das.dMH.dNc = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dNc;
        this.Das.dMH.subtitle = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).subtitle;
        this.Das.dMH.title = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).title;
        this.Das.dMH.dNd = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dNd;
        this.Das.dMH.dNe = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).dNe;
        this.Das.dMH.dNk = ((com.tencent.mm.plugin.wallet_core.c.ad)paramn).CPr;
      }
      paramString = this.Das.dMH;
      if (!t.eFy().eGp()) {
        break label728;
      }
    }
    label728:
    for (paramInt = 1;; paramInt = 0)
    {
      paramString.dNg = paramInt;
      this.Das.dMH.dNh = t.eFy().eGq();
      this.Das.dMH.dNi = t.eFy().eGr();
      this.Das.dMH.dNj = t.eFy().eGs();
      this.Das.dMH.dNl = paramBoolean;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.Das.dMH.dML + " hasNewTips : " + this.Das.dMH.dMM + " swipeOn : " + this.Das.dMH.dMN);
      if (this.Das.callback != null) {
        this.Das.callback.run();
      }
      if (this.Das.dMH.dMy != null) {
        this.Das.dMH.dMy.run();
      }
      if (this.tgz) {
        this.Das = null;
      }
      AppMethodBeat.o(70426);
      return;
    }
  }
  
  private boolean a(yk paramyk)
  {
    AppMethodBeat.i(70422);
    if (!(paramyk instanceof yk))
    {
      com.tencent.mm.sdk.platformtools.ad.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
      AppMethodBeat.o(70422);
      return false;
    }
    this.tgz = false;
    this.Das = paramyk;
    this.dMI = paramyk.dMG.dMI;
    this.dMJ = paramyk.dMG.dMJ;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", new Object[] { Boolean.valueOf(this.dMJ) });
    g.ajD();
    g.ajB().gAO.a(385, this);
    g.ajD();
    g.ajB().gAO.a(1518, this);
    if (t.eFy().eGf())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
      b(paramyk);
    }
    for (;;)
    {
      AppMethodBeat.o(70422);
      return true;
      an localan;
      long l;
      int i;
      if (paramyk.dMG.dMI)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
        localan = t.eFy();
        l = bt.aQJ();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", new Object[] { Long.valueOf(l), Long.valueOf(localan.Dbd) });
        if ((localan.Dbd <= 0L) || (l > localan.Dbd)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label273;
          }
          if (!this.dMJ) {
            this.tgz = true;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
          a(0, "", null, false);
          b(paramyk);
          break;
        }
        label273:
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
        b(paramyk);
      }
      else
      {
        localan = t.eFy();
        l = bt.rM(localan.Dbc);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time ".concat(String.valueOf(l)), new Object[] { Long.valueOf(localan.Dbc), Long.valueOf(System.currentTimeMillis() / 1000L) });
        if (l > 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label380;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
          b(paramyk);
          break;
        }
        label380:
        this.tgz = true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
        a(0, "", null, false);
      }
    }
  }
  
  private void b(yk paramyk)
  {
    AppMethodBeat.i(70423);
    if (u.aAB())
    {
      this.Dat = new a();
      g.aiU().a(this.Dat, 0);
      AppMethodBeat.o(70423);
      return;
    }
    if (Vz(paramyk.dMG.scene)) {}
    for (int i = paramyk.dMG.scene;; i = 0)
    {
      this.Dat = new com.tencent.mm.plugin.wallet_core.c.ad(null, i);
      g.aiU().a(this.Dat, 0);
      AppMethodBeat.o(70423);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70424);
    if ((this.Das == null) || (this.Das.dMG == null))
    {
      AppMethodBeat.o(70424);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s, retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn, Integer.valueOf(this.Das.dMG.retryCount) });
    if (paramn != this.Dat)
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
      if (this.Das.dMG.retryCount == 0)
      {
        a(paramInt2, paramString, paramn);
        AppMethodBeat.o(70424);
        return;
      }
      paramString = this.Das.dMG;
      paramString.retryCount -= 1;
      b(this.Das);
    }
    AppMethodBeat.o(70424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ab
 * JD-Core Version:    0.7.0.1
 */