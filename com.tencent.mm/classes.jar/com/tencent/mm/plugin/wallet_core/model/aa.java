package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.a;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class aa
  extends c<xq>
  implements com.tencent.mm.ak.g
{
  private n BAa;
  private xq BzZ;
  private boolean dAv;
  private boolean dAw;
  private boolean sjX;
  
  public aa()
  {
    AppMethodBeat.i(160877);
    this.sjX = false;
    this.dAv = false;
    this.dAw = false;
    this.__eventId = xq.class.getName().hashCode();
    AppMethodBeat.o(160877);
  }
  
  private static boolean TH(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 19) || (paramInt == 20) || (paramInt == 21) || (paramInt == 22) || (paramInt == 23);
  }
  
  private void a(int paramInt, String paramString, n paramn)
  {
    AppMethodBeat.i(70425);
    com.tencent.mm.kernel.g.agi().b(385, this);
    com.tencent.mm.kernel.g.agi().b(1518, this);
    if ((!this.dAw) && (this.dAv) && (this.sjX))
    {
      ac.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
      AppMethodBeat.o(70425);
      return;
    }
    this.sjX = true;
    a(paramInt, paramString, paramn, true);
    AppMethodBeat.o(70425);
  }
  
  private void a(int paramInt, String paramString, n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(70426);
    if (this.BzZ != null)
    {
      this.BzZ.dAu.errCode = paramInt;
      this.BzZ.dAu.errMsg = paramString;
      this.BzZ.dAu.dAZ = paramn;
      this.BzZ.dAu.dAx = s.ery().esa();
      this.BzZ.dAu.dAy = s.ery().esz();
      this.BzZ.dAu.dAz = s.ery().esB();
      this.BzZ.dAu.dAA = s.ery().esi().erO();
      this.BzZ.dAu.dAB = s.ery().esh();
      this.BzZ.dAu.dAC = s.ery().getTrueName();
      this.BzZ.dAu.dAD = s.ery().esb();
      this.BzZ.dAu.dAE = s.ery().esi().erS();
      this.BzZ.dAu.dAF = "";
      this.BzZ.dAu.dAS = s.ery().est();
      if ((paramn != null) && ((paramn instanceof ad)))
      {
        this.BzZ.dAu.dAF = ((ad)paramn).dAF;
        this.BzZ.dAu.dAG = ((ad)paramn).dAG;
        this.BzZ.dAu.dAH = ((ad)paramn).dAH;
        this.BzZ.dAu.dAI = ((ad)paramn).dAI;
        this.BzZ.dAu.dAJ = ((ad)paramn).dAJ;
        this.BzZ.dAu.scene = ((ad)paramn).scene;
        this.BzZ.dAu.dAK = ((ad)paramn).dAK;
        this.BzZ.dAu.dAL = ((ad)paramn).dAL;
        this.BzZ.dAu.dAM = ((ad)paramn).dAM;
        this.BzZ.dAu.dAN = ((ad)paramn).dAN;
        this.BzZ.dAu.dAO = ((ad)paramn).dAO;
        this.BzZ.dAu.dAP = ((ad)paramn).dAP;
        this.BzZ.dAu.subtitle = ((ad)paramn).subtitle;
        this.BzZ.dAu.title = ((ad)paramn).title;
        this.BzZ.dAu.dAQ = ((ad)paramn).dAQ;
        this.BzZ.dAu.dAR = ((ad)paramn).dAR;
        this.BzZ.dAu.dAX = ((ad)paramn).Bpc;
      }
      paramString = this.BzZ.dAu;
      if (!s.ery().esp()) {
        break label728;
      }
    }
    label728:
    for (paramInt = 1;; paramInt = 0)
    {
      paramString.dAT = paramInt;
      this.BzZ.dAu.dAU = s.ery().esq();
      this.BzZ.dAu.dAV = s.ery().esr();
      this.BzZ.dAu.dAW = s.ery().ess();
      this.BzZ.dAu.dAY = paramBoolean;
      ac.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.BzZ.dAu.dAy + " hasNewTips : " + this.BzZ.dAu.dAz + " swipeOn : " + this.BzZ.dAu.dAA);
      if (this.BzZ.callback != null) {
        this.BzZ.callback.run();
      }
      if (this.BzZ.dAu.dAl != null) {
        this.BzZ.dAu.dAl.run();
      }
      if (this.sjX) {
        this.BzZ = null;
      }
      AppMethodBeat.o(70426);
      return;
    }
  }
  
  private boolean a(xq paramxq)
  {
    AppMethodBeat.i(70422);
    if (!(paramxq instanceof xq))
    {
      ac.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
      AppMethodBeat.o(70422);
      return false;
    }
    this.sjX = false;
    this.BzZ = paramxq;
    this.dAv = paramxq.dAt.dAv;
    this.dAw = paramxq.dAt.dAw;
    ac.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", new Object[] { Boolean.valueOf(this.dAw) });
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(1518, this);
    if (s.ery().esf())
    {
      ac.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
      b(paramxq);
    }
    for (;;)
    {
      AppMethodBeat.o(70422);
      return true;
      am localam;
      long l;
      int i;
      if (paramxq.dAt.dAv)
      {
        ac.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
        localam = s.ery();
        l = bs.aNx();
        ac.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", new Object[] { Long.valueOf(l), Long.valueOf(localam.BAL) });
        if ((localam.BAL <= 0L) || (l > localam.BAL)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label273;
          }
          if (!this.dAw) {
            this.sjX = true;
          }
          ac.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
          a(0, "", null, false);
          b(paramxq);
          break;
        }
        label273:
        ac.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
        b(paramxq);
      }
      else
      {
        localam = s.ery();
        l = bs.pN(localam.BAK);
        ac.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time ".concat(String.valueOf(l)), new Object[] { Long.valueOf(localam.BAK), Long.valueOf(System.currentTimeMillis() / 1000L) });
        if (l > 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label380;
          }
          ac.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
          b(paramxq);
          break;
        }
        label380:
        this.sjX = true;
        ac.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
        a(0, "", null, false);
      }
    }
  }
  
  private void b(xq paramxq)
  {
    AppMethodBeat.i(70423);
    if (u.axL())
    {
      this.BAa = new a();
      com.tencent.mm.kernel.g.agi().a(this.BAa, 0);
      AppMethodBeat.o(70423);
      return;
    }
    if (TH(paramxq.dAt.scene)) {}
    for (int i = paramxq.dAt.scene;; i = 0)
    {
      this.BAa = new ad(null, i);
      com.tencent.mm.kernel.g.agi().a(this.BAa, 0);
      AppMethodBeat.o(70423);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70424);
    if ((this.BzZ == null) || (this.BzZ.dAt == null))
    {
      AppMethodBeat.o(70424);
      return;
    }
    ac.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s, retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn, Integer.valueOf(this.BzZ.dAt.retryCount) });
    if (paramn != this.BAa)
    {
      AppMethodBeat.o(70424);
      return;
    }
    if (((paramn instanceof ad)) || ((paramn instanceof a)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(paramInt2, paramString, paramn);
        AppMethodBeat.o(70424);
        return;
      }
      if (this.BzZ.dAt.retryCount == 0)
      {
        a(paramInt2, paramString, paramn);
        AppMethodBeat.o(70424);
        return;
      }
      paramString = this.BzZ.dAt;
      paramString.retryCount -= 1;
      b(this.BzZ);
    }
    AppMethodBeat.o(70424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa
 * JD-Core Version:    0.7.0.1
 */