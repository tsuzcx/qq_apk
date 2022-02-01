package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.g.a.zv.a;
import com.tencent.mm.g.a.zv.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ab
  extends IListener<zv>
  implements i
{
  private zv Ibi;
  private q Ibj;
  private boolean efT;
  private boolean efU;
  private boolean wEZ;
  
  public ab()
  {
    AppMethodBeat.i(160877);
    this.wEZ = false;
    this.efT = false;
    this.efU = false;
    this.__eventId = zv.class.getName().hashCode();
    AppMethodBeat.o(160877);
  }
  
  private void a(int paramInt, String paramString, q paramq)
  {
    AppMethodBeat.i(70425);
    g.azz().b(385, this);
    g.azz().b(1518, this);
    if ((!this.efU) && (this.efT) && (this.wEZ))
    {
      Log.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
      AppMethodBeat.o(70425);
      return;
    }
    this.wEZ = true;
    a(paramInt, paramString, paramq, true);
    AppMethodBeat.o(70425);
  }
  
  private void a(int paramInt, String paramString, q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(70426);
    if (this.Ibi != null)
    {
      this.Ibi.efS.errCode = paramInt;
      this.Ibi.efS.errMsg = paramString;
      this.Ibi.efS.egy = paramq;
      this.Ibi.efS.efV = t.fQI().fRk();
      this.Ibi.efS.efW = t.fQI().fRK();
      this.Ibi.efS.efX = t.fQI().fRM();
      this.Ibi.efS.efY = t.fQI().fRs().fQY();
      this.Ibi.efS.efZ = t.fQI().fRr();
      this.Ibi.efS.ega = t.fQI().getTrueName();
      this.Ibi.efS.egb = t.fQI().fRl();
      this.Ibi.efS.egc = t.fQI().fRs().fRc();
      this.Ibi.efS.egd = "";
      this.Ibi.efS.egr = t.fQI().fRD();
      if ((paramq != null) && ((paramq instanceof ad)))
      {
        this.Ibi.efS.egd = ((ad)paramq).egd;
        this.Ibi.efS.ege = ((ad)paramq).ege;
        this.Ibi.efS.egf = ((ad)paramq).egf;
        this.Ibi.efS.egg = ((ad)paramq).egg;
        this.Ibi.efS.egh = ((ad)paramq).egh;
        this.Ibi.efS.scene = ((ad)paramq).scene;
        this.Ibi.efS.egi = ((ad)paramq).egi;
        this.Ibi.efS.egj = ((ad)paramq).egj;
        this.Ibi.efS.egk = ((ad)paramq).egk;
        this.Ibi.efS.egm = ((ad)paramq).egm;
        this.Ibi.efS.egn = ((ad)paramq).egn;
        this.Ibi.efS.ego = ((ad)paramq).ego;
        this.Ibi.efS.subtitle = ((ad)paramq).subtitle;
        this.Ibi.efS.title = ((ad)paramq).title;
        this.Ibi.efS.egp = ((ad)paramq).egp;
        this.Ibi.efS.egq = ((ad)paramq).egq;
        this.Ibi.efS.egw = ((ad)paramq).HQo;
      }
      paramString = this.Ibi.efS;
      if (!t.fQI().fRz()) {
        break label728;
      }
    }
    label728:
    for (paramInt = 1;; paramInt = 0)
    {
      paramString.egs = paramInt;
      this.Ibi.efS.egt = t.fQI().fRA();
      this.Ibi.efS.egu = t.fQI().fRB();
      this.Ibi.efS.egv = t.fQI().fRC();
      this.Ibi.efS.egx = paramBoolean;
      Log.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.Ibi.efS.efW + " hasNewTips : " + this.Ibi.efS.efX + " swipeOn : " + this.Ibi.efS.efY);
      if (this.Ibi.callback != null) {
        this.Ibi.callback.run();
      }
      if (this.Ibi.efS.efJ != null) {
        this.Ibi.efS.efJ.run();
      }
      if (this.wEZ) {
        this.Ibi = null;
      }
      AppMethodBeat.o(70426);
      return;
    }
  }
  
  private boolean a(zv paramzv)
  {
    AppMethodBeat.i(70422);
    if (!(paramzv instanceof zv))
    {
      Log.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
      AppMethodBeat.o(70422);
      return false;
    }
    this.wEZ = false;
    this.Ibi = paramzv;
    this.efT = paramzv.efR.efT;
    this.efU = paramzv.efR.efU;
    Log.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", new Object[] { Boolean.valueOf(this.efU) });
    g.aAi();
    g.aAg().hqi.a(385, this);
    g.aAi();
    g.aAg().hqi.a(1518, this);
    if (t.fQI().fRp())
    {
      Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
      b(paramzv);
    }
    for (;;)
    {
      AppMethodBeat.o(70422);
      return true;
      an localan;
      long l;
      int i;
      if (paramzv.efR.efT)
      {
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
        localan = t.fQI();
        l = Util.nowSecond();
        Log.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", new Object[] { Long.valueOf(l), Long.valueOf(localan.IbT) });
        if ((localan.IbT <= 0L) || (l > localan.IbT)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label273;
          }
          if (!this.efU) {
            this.wEZ = true;
          }
          Log.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
          a(0, "", null, false);
          b(paramzv);
          break;
        }
        label273:
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
        b(paramzv);
      }
      else
      {
        localan = t.fQI();
        l = Util.secondsToNow(localan.IbS);
        Log.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time ".concat(String.valueOf(l)), new Object[] { Long.valueOf(localan.IbS), Long.valueOf(System.currentTimeMillis() / 1000L) });
        if (l > 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label380;
          }
          Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
          b(paramzv);
          break;
        }
        label380:
        this.wEZ = true;
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
        a(0, "", null, false);
      }
    }
  }
  
  private static boolean aeK(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 19) || (paramInt == 20) || (paramInt == 21) || (paramInt == 22) || (paramInt == 23);
  }
  
  private void b(zv paramzv)
  {
    AppMethodBeat.i(70423);
    if (z.aUo())
    {
      this.Ibj = new a();
      g.azz().a(this.Ibj, 0);
      AppMethodBeat.o(70423);
      return;
    }
    if (aeK(paramzv.efR.scene)) {}
    for (int i = paramzv.efR.scene;; i = 0)
    {
      this.Ibj = new ad(null, i);
      g.azz().a(this.Ibj, 0);
      AppMethodBeat.o(70423);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70424);
    if ((this.Ibi == null) || (this.Ibi.efR == null))
    {
      AppMethodBeat.o(70424);
      return;
    }
    Log.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s, retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramq, Integer.valueOf(this.Ibi.efR.retryCount) });
    if (paramq != this.Ibj)
    {
      AppMethodBeat.o(70424);
      return;
    }
    if (((paramq instanceof ad)) || ((paramq instanceof a)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        a(paramInt2, paramString, paramq);
        AppMethodBeat.o(70424);
        return;
      }
      if (this.Ibi.efR.retryCount == 0)
      {
        a(paramInt2, paramString, paramq);
        AppMethodBeat.o(70424);
        return;
      }
      paramString = this.Ibi.efR;
      paramString.retryCount -= 1;
      b(this.Ibi);
    }
    AppMethodBeat.o(70424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ab
 * JD-Core Version:    0.7.0.1
 */