package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.g.a.yq.a;
import com.tencent.mm.g.a.yq.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class ab
  extends c<yq>
  implements f
{
  private yq DrX;
  private n DrY;
  private boolean dNY;
  private boolean dNZ;
  private boolean trs;
  
  public ab()
  {
    AppMethodBeat.i(160877);
    this.trs = false;
    this.dNY = false;
    this.dNZ = false;
    this.__eventId = yq.class.getName().hashCode();
    AppMethodBeat.o(160877);
  }
  
  private static boolean Wg(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 19) || (paramInt == 20) || (paramInt == 21) || (paramInt == 22) || (paramInt == 23);
  }
  
  private void a(int paramInt, String paramString, n paramn)
  {
    AppMethodBeat.i(70425);
    g.ajj().b(385, this);
    g.ajj().b(1518, this);
    if ((!this.dNZ) && (this.dNY) && (this.trs))
    {
      ae.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
      AppMethodBeat.o(70425);
      return;
    }
    this.trs = true;
    a(paramInt, paramString, paramn, true);
    AppMethodBeat.o(70425);
  }
  
  private void a(int paramInt, String paramString, n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(70426);
    if (this.DrX != null)
    {
      this.DrX.dNX.errCode = paramInt;
      this.DrX.dNX.errMsg = paramString;
      this.DrX.dNX.dOC = paramn;
      this.DrX.dNX.dOa = t.eJf().eJH();
      this.DrX.dNX.dOb = t.eJf().eKg();
      this.DrX.dNX.dOc = t.eJf().eKi();
      this.DrX.dNX.dOd = t.eJf().eJP().eJv();
      this.DrX.dNX.dOe = t.eJf().eJO();
      this.DrX.dNX.dOf = t.eJf().getTrueName();
      this.DrX.dNX.dOg = t.eJf().eJI();
      this.DrX.dNX.dOh = t.eJf().eJP().eJz();
      this.DrX.dNX.dOi = "";
      this.DrX.dNX.dOv = t.eJf().eKa();
      if ((paramn != null) && ((paramn instanceof ad)))
      {
        this.DrX.dNX.dOi = ((ad)paramn).dOi;
        this.DrX.dNX.dOj = ((ad)paramn).dOj;
        this.DrX.dNX.dOk = ((ad)paramn).dOk;
        this.DrX.dNX.dOl = ((ad)paramn).dOl;
        this.DrX.dNX.dOm = ((ad)paramn).dOm;
        this.DrX.dNX.scene = ((ad)paramn).scene;
        this.DrX.dNX.dOn = ((ad)paramn).dOn;
        this.DrX.dNX.dOo = ((ad)paramn).dOo;
        this.DrX.dNX.dOp = ((ad)paramn).dOp;
        this.DrX.dNX.dOq = ((ad)paramn).dOq;
        this.DrX.dNX.dOr = ((ad)paramn).dOr;
        this.DrX.dNX.dOs = ((ad)paramn).dOs;
        this.DrX.dNX.subtitle = ((ad)paramn).subtitle;
        this.DrX.dNX.title = ((ad)paramn).title;
        this.DrX.dNX.dOt = ((ad)paramn).dOt;
        this.DrX.dNX.dOu = ((ad)paramn).dOu;
        this.DrX.dNX.dOA = ((ad)paramn).DgV;
      }
      paramString = this.DrX.dNX;
      if (!t.eJf().eJW()) {
        break label728;
      }
    }
    label728:
    for (paramInt = 1;; paramInt = 0)
    {
      paramString.dOw = paramInt;
      this.DrX.dNX.dOx = t.eJf().eJX();
      this.DrX.dNX.dOy = t.eJf().eJY();
      this.DrX.dNX.dOz = t.eJf().eJZ();
      this.DrX.dNX.dOB = paramBoolean;
      ae.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.DrX.dNX.dOb + " hasNewTips : " + this.DrX.dNX.dOc + " swipeOn : " + this.DrX.dNX.dOd);
      if (this.DrX.callback != null) {
        this.DrX.callback.run();
      }
      if (this.DrX.dNX.dNO != null) {
        this.DrX.dNX.dNO.run();
      }
      if (this.trs) {
        this.DrX = null;
      }
      AppMethodBeat.o(70426);
      return;
    }
  }
  
  private boolean a(yq paramyq)
  {
    AppMethodBeat.i(70422);
    if (!(paramyq instanceof yq))
    {
      ae.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
      AppMethodBeat.o(70422);
      return false;
    }
    this.trs = false;
    this.DrX = paramyq;
    this.dNY = paramyq.dNW.dNY;
    this.dNZ = paramyq.dNW.dNZ;
    ae.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", new Object[] { Boolean.valueOf(this.dNZ) });
    g.ajS();
    g.ajQ().gDv.a(385, this);
    g.ajS();
    g.ajQ().gDv.a(1518, this);
    if (t.eJf().eJM())
    {
      ae.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
      b(paramyq);
    }
    for (;;)
    {
      AppMethodBeat.o(70422);
      return true;
      an localan;
      long l;
      int i;
      if (paramyq.dNW.dNY)
      {
        ae.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
        localan = t.eJf();
        l = bu.aRi();
        ae.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", new Object[] { Long.valueOf(l), Long.valueOf(localan.DsH) });
        if ((localan.DsH <= 0L) || (l > localan.DsH)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label273;
          }
          if (!this.dNZ) {
            this.trs = true;
          }
          ae.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
          a(0, "", null, false);
          b(paramyq);
          break;
        }
        label273:
        ae.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
        b(paramyq);
      }
      else
      {
        localan = t.eJf();
        l = bu.rZ(localan.DsG);
        ae.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time ".concat(String.valueOf(l)), new Object[] { Long.valueOf(localan.DsG), Long.valueOf(System.currentTimeMillis() / 1000L) });
        if (l > 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label380;
          }
          ae.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
          b(paramyq);
          break;
        }
        label380:
        this.trs = true;
        ae.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
        a(0, "", null, false);
      }
    }
  }
  
  private void b(yq paramyq)
  {
    AppMethodBeat.i(70423);
    if (v.aAR())
    {
      this.DrY = new a();
      g.ajj().a(this.DrY, 0);
      AppMethodBeat.o(70423);
      return;
    }
    if (Wg(paramyq.dNW.scene)) {}
    for (int i = paramyq.dNW.scene;; i = 0)
    {
      this.DrY = new ad(null, i);
      g.ajj().a(this.DrY, 0);
      AppMethodBeat.o(70423);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70424);
    if ((this.DrX == null) || (this.DrX.dNW == null))
    {
      AppMethodBeat.o(70424);
      return;
    }
    ae.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s, retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn, Integer.valueOf(this.DrX.dNW.retryCount) });
    if (paramn != this.DrY)
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
      if (this.DrX.dNW.retryCount == 0)
      {
        a(paramInt2, paramString, paramn);
        AppMethodBeat.o(70424);
        return;
      }
      paramString = this.DrX.dNW;
      paramString.retryCount -= 1;
      b(this.DrX);
    }
    AppMethodBeat.o(70424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ab
 * JD-Core Version:    0.7.0.1
 */