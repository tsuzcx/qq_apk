package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.abc;
import com.tencent.mm.f.a.abc.a;
import com.tencent.mm.f.a.abc.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ac
  extends IListener<abc>
  implements i
{
  private boolean BxW;
  private abc OTt;
  private q OTu;
  private boolean gaj;
  private boolean gak;
  
  public ac()
  {
    AppMethodBeat.i(160877);
    this.BxW = false;
    this.gaj = false;
    this.gak = false;
    this.__eventId = abc.class.getName().hashCode();
    AppMethodBeat.o(160877);
  }
  
  private void a(int paramInt, String paramString, q paramq)
  {
    AppMethodBeat.i(70425);
    h.aGY().b(385, this);
    h.aGY().b(1518, this);
    if ((!this.gak) && (this.gaj) && (this.BxW))
    {
      Log.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
      AppMethodBeat.o(70425);
      return;
    }
    this.BxW = true;
    a(paramInt, paramString, paramq, true);
    AppMethodBeat.o(70425);
  }
  
  private void a(int paramInt, String paramString, q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(70426);
    if (this.OTt != null)
    {
      this.OTt.gai.errCode = paramInt;
      this.OTt.gai.errMsg = paramString;
      this.OTt.gai.gaN = paramq;
      this.OTt.gai.gal = u.gJo().gJQ();
      this.OTt.gai.gam = u.gJo().gKq();
      this.OTt.gai.gan = u.gJo().gKs();
      this.OTt.gai.gao = u.gJo().gJY().gJE();
      this.OTt.gai.gap = u.gJo().gJX();
      this.OTt.gai.gaq = u.gJo().getTrueName();
      this.OTt.gai.gar = u.gJo().gJR();
      this.OTt.gai.gas = u.gJo().gJY().gJI();
      this.OTt.gai.gat = "";
      this.OTt.gai.gaG = u.gJo().gKj();
      if ((paramq != null) && ((paramq instanceof ae)))
      {
        this.OTt.gai.gat = ((ae)paramq).gat;
        this.OTt.gai.gau = ((ae)paramq).gau;
        this.OTt.gai.gav = ((ae)paramq).gav;
        this.OTt.gai.gaw = ((ae)paramq).gaw;
        this.OTt.gai.gax = ((ae)paramq).gax;
        this.OTt.gai.scene = ((ae)paramq).scene;
        this.OTt.gai.gay = ((ae)paramq).gay;
        this.OTt.gai.gaz = ((ae)paramq).gaz;
        this.OTt.gai.gaA = ((ae)paramq).gaA;
        this.OTt.gai.gaB = ((ae)paramq).gaB;
        this.OTt.gai.gaC = ((ae)paramq).gaC;
        this.OTt.gai.gaD = ((ae)paramq).gaD;
        this.OTt.gai.subtitle = ((ae)paramq).subtitle;
        this.OTt.gai.title = ((ae)paramq).title;
        this.OTt.gai.gaE = ((ae)paramq).gaE;
        this.OTt.gai.gaF = ((ae)paramq).gaF;
        this.OTt.gai.gaL = ((ae)paramq).OIx;
        this.OTt.gai.gaO = ((ae)paramq).gaO;
      }
      paramString = this.OTt.gai;
      if (!u.gJo().gKf()) {
        break label745;
      }
    }
    label745:
    for (paramInt = 1;; paramInt = 0)
    {
      paramString.gaH = paramInt;
      this.OTt.gai.gaI = u.gJo().gKg();
      this.OTt.gai.gaJ = u.gJo().gKh();
      this.OTt.gai.gaK = u.gJo().gKi();
      this.OTt.gai.gaM = paramBoolean;
      Log.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.OTt.gai.gam + " hasNewTips : " + this.OTt.gai.gan + " swipeOn : " + this.OTt.gai.gao);
      if (this.OTt.callback != null) {
        this.OTt.callback.run();
      }
      if (this.OTt.gai.fZZ != null) {
        this.OTt.gai.fZZ.run();
      }
      if (this.BxW) {
        this.OTt = null;
      }
      AppMethodBeat.o(70426);
      return;
    }
  }
  
  private boolean a(abc paramabc)
  {
    AppMethodBeat.i(70422);
    if (!(paramabc instanceof abc))
    {
      Log.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
      AppMethodBeat.o(70422);
      return false;
    }
    this.BxW = false;
    this.OTt = paramabc;
    this.gaj = paramabc.gah.gaj;
    this.gak = paramabc.gah.gak;
    Log.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", new Object[] { Boolean.valueOf(this.gak) });
    h.aHH();
    h.aHF().kcd.a(385, this);
    h.aHH();
    h.aHF().kcd.a(1518, this);
    if (u.gJo().gJV())
    {
      Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
      b(paramabc);
    }
    for (;;)
    {
      AppMethodBeat.o(70422);
      return true;
      ao localao;
      long l;
      int i;
      if (paramabc.gah.gaj)
      {
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
        localao = u.gJo();
        l = Util.nowSecond();
        Log.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", new Object[] { Long.valueOf(l), Long.valueOf(localao.OUf) });
        if ((localao.OUf <= 0L) || (l > localao.OUf)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label273;
          }
          if (!this.gak) {
            this.BxW = true;
          }
          Log.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
          a(0, "", null, false);
          b(paramabc);
          break;
        }
        label273:
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
        b(paramabc);
      }
      else
      {
        localao = u.gJo();
        l = Util.secondsToNow(localao.OUe);
        Log.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time ".concat(String.valueOf(l)), new Object[] { Long.valueOf(localao.OUe), Long.valueOf(System.currentTimeMillis() / 1000L) });
        if (l > 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label380;
          }
          Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
          b(paramabc);
          break;
        }
        label380:
        this.BxW = true;
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
        a(0, "", null, false);
      }
    }
  }
  
  private static boolean amx(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 19) || (paramInt == 20) || (paramInt == 21) || (paramInt == 22) || (paramInt == 23);
  }
  
  private void b(abc paramabc)
  {
    AppMethodBeat.i(70423);
    if (z.bdq())
    {
      this.OTu = new a();
      h.aGY().a(this.OTu, 0);
      AppMethodBeat.o(70423);
      return;
    }
    if (amx(paramabc.gah.scene)) {}
    for (int i = paramabc.gah.scene;; i = 0)
    {
      this.OTu = new ae(null, i);
      h.aGY().a(this.OTu, 0);
      AppMethodBeat.o(70423);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70424);
    if ((this.OTt == null) || (this.OTt.gah == null))
    {
      AppMethodBeat.o(70424);
      return;
    }
    Log.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s, retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramq, Integer.valueOf(this.OTt.gah.retryCount) });
    if (paramq != this.OTu)
    {
      AppMethodBeat.o(70424);
      return;
    }
    if (((paramq instanceof ae)) || ((paramq instanceof a)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(paramInt2, paramString, paramq);
        AppMethodBeat.o(70424);
        return;
      }
      if (this.OTt.gah.retryCount == 0)
      {
        a(paramInt2, paramString, paramq);
        AppMethodBeat.o(70424);
        return;
      }
      paramString = this.OTt.gah;
      paramString.retryCount -= 1;
      b(this.OTt);
    }
    AppMethodBeat.o(70424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ac
 * JD-Core Version:    0.7.0.1
 */