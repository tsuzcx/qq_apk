package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.a.vf.a;
import com.tencent.mm.g.a.vf.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;

public final class aa
  extends c<vf>
  implements f
{
  private boolean cLL;
  private boolean cLM;
  private boolean mFK;
  private vf ulo;
  private m ulp;
  
  public aa()
  {
    AppMethodBeat.i(46904);
    this.mFK = false;
    this.cLL = false;
    this.cLM = false;
    this.__eventId = vf.class.getName().hashCode();
    AppMethodBeat.o(46904);
  }
  
  private static boolean Iz(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 19) || (paramInt == 20) || (paramInt == 21) || (paramInt == 22) || (paramInt == 23);
  }
  
  private void a(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(142488);
    g.Rc().b(385, this);
    g.Rc().b(1518, this);
    if ((!this.cLM) && (this.cLL) && (this.mFK))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
      AppMethodBeat.o(142488);
      return;
    }
    this.mFK = true;
    a(paramInt, paramString, paramm, true);
    AppMethodBeat.o(142488);
  }
  
  private void a(int paramInt, String paramString, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(46907);
    if (this.ulo != null)
    {
      this.ulo.cLK.errCode = paramInt;
      this.ulo.cLK.errMsg = paramString;
      this.ulo.cLK.cMp = paramm;
      this.ulo.cLK.cLN = t.cTN().cUl();
      this.ulo.cLK.cLO = t.cTN().cUK();
      this.ulo.cLK.cLP = t.cTN().cUM();
      this.ulo.cLK.cLQ = t.cTN().cUt().cUb();
      this.ulo.cLK.cLR = t.cTN().cUs();
      this.ulo.cLK.cLS = t.cTN().getTrueName();
      this.ulo.cLK.cLT = t.cTN().cUm();
      this.ulo.cLK.cLU = t.cTN().cUt().cUf();
      this.ulo.cLK.cLV = "";
      this.ulo.cLK.cMi = t.cTN().cUE();
      if ((paramm != null) && ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab)))
      {
        this.ulo.cLK.cLV = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cLV;
        this.ulo.cLK.cLW = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cLW;
        this.ulo.cLK.cLX = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cLX;
        this.ulo.cLK.cLY = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cLY;
        this.ulo.cLK.cLZ = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cLZ;
        this.ulo.cLK.scene = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).scene;
        this.ulo.cLK.cMa = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cMa;
        this.ulo.cLK.cMb = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cMb;
        this.ulo.cLK.cMc = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cMc;
        this.ulo.cLK.cMd = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cMd;
        this.ulo.cLK.cMe = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cMe;
        this.ulo.cLK.cMf = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cMf;
        this.ulo.cLK.subtitle = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).subtitle;
        this.ulo.cLK.title = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).title;
        this.ulo.cLK.cMg = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cMg;
        this.ulo.cLK.cMh = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).cMh;
        this.ulo.cLK.cMn = ((com.tencent.mm.plugin.wallet_core.c.ab)paramm).ucb;
      }
      paramString = this.ulo.cLK;
      if (!t.cTN().cUA()) {
        break label728;
      }
    }
    label728:
    for (paramInt = 1;; paramInt = 0)
    {
      paramString.cMj = paramInt;
      this.ulo.cLK.cMk = t.cTN().cUB();
      this.ulo.cLK.cMl = t.cTN().cUC();
      this.ulo.cLK.cMm = t.cTN().cUD();
      this.ulo.cLK.cMo = paramBoolean;
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.ulo.cLK.cLO + " hasNewTips : " + this.ulo.cLK.cLP + " swipeOn : " + this.ulo.cLK.cLQ);
      if (this.ulo.callback != null) {
        this.ulo.callback.run();
      }
      if (this.ulo.cLK.cLC != null) {
        this.ulo.cLK.cLC.run();
      }
      if (this.mFK) {
        this.ulo = null;
      }
      AppMethodBeat.o(46907);
      return;
    }
  }
  
  private boolean a(vf paramvf)
  {
    AppMethodBeat.i(46905);
    if (!(paramvf instanceof vf))
    {
      com.tencent.mm.sdk.platformtools.ab.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
      AppMethodBeat.o(46905);
      return false;
    }
    this.mFK = false;
    this.ulo = paramvf;
    this.cLL = paramvf.cLJ.cLL;
    this.cLM = paramvf.cLJ.cLM;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", new Object[] { Boolean.valueOf(this.cLM) });
    g.RM();
    g.RK().eHt.a(385, this);
    g.RM();
    g.RK().eHt.a(1518, this);
    if (t.cTN().cUq())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
      b(paramvf);
    }
    for (;;)
    {
      AppMethodBeat.o(46905);
      return true;
      am localam;
      long l;
      int i;
      if (paramvf.cLJ.cLL)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
        localam = t.cTN();
        l = bo.aox();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", new Object[] { Long.valueOf(l), Long.valueOf(localam.ulV) });
        if ((localam.ulV <= 0L) || (l > localam.ulV)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label273;
          }
          if (!this.cLM) {
            this.mFK = true;
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
          a(0, "", null, false);
          b(paramvf);
          break;
        }
        label273:
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
        b(paramvf);
      }
      else
      {
        localam = t.cTN();
        l = bo.gz(localam.ulU);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time ".concat(String.valueOf(l)), new Object[] { Long.valueOf(localam.ulU), Long.valueOf(System.currentTimeMillis() / 1000L) });
        if (l > 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label380;
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
          b(paramvf);
          break;
        }
        label380:
        this.mFK = true;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
        a(0, "", null, false);
      }
    }
  }
  
  private void b(vf paramvf)
  {
    AppMethodBeat.i(142487);
    if (r.ZB())
    {
      this.ulp = new a();
      g.Rc().a(this.ulp, 0);
      AppMethodBeat.o(142487);
      return;
    }
    if (Iz(paramvf.cLJ.scene)) {}
    for (int i = paramvf.cLJ.scene;; i = 0)
    {
      this.ulp = new com.tencent.mm.plugin.wallet_core.c.ab(null, i);
      g.Rc().a(this.ulp, 0);
      AppMethodBeat.o(142487);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46906);
    if ((this.ulo == null) || (this.ulo.cLJ == null))
    {
      AppMethodBeat.o(46906);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s, retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm, Integer.valueOf(this.ulo.cLJ.retryCount) });
    if (paramm != this.ulp)
    {
      AppMethodBeat.o(46906);
      return;
    }
    if (((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab)) || ((paramm instanceof a)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(paramInt2, paramString, paramm);
        AppMethodBeat.o(46906);
        return;
      }
      if (this.ulo.cLJ.retryCount == 0)
      {
        a(paramInt2, paramString, paramm);
        AppMethodBeat.o(46906);
        return;
      }
      paramString = this.ulo.cLJ;
      paramString.retryCount -= 1;
      b(this.ulo);
    }
    AppMethodBeat.o(46906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa
 * JD-Core Version:    0.7.0.1
 */