package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acz;
import com.tencent.mm.autogen.a.acz.a;
import com.tencent.mm.autogen.a.acz.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public class WalletGetUserInfoEventListener
  extends IListener<acz>
  implements com.tencent.mm.am.h
{
  private boolean Hfz;
  private acz VJA;
  private p VJB;
  private boolean igs;
  private boolean igt;
  
  public WalletGetUserInfoEventListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160877);
    this.Hfz = false;
    this.igs = false;
    this.igt = false;
    this.__eventId = acz.class.getName().hashCode();
    AppMethodBeat.o(160877);
  }
  
  private void a(int paramInt, String paramString, p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(70426);
    if (this.VJA != null)
    {
      this.VJA.igr.errCode = paramInt;
      this.VJA.igr.errMsg = paramString;
      this.VJA.igr.igX = paramp;
      this.VJA.igr.igu = u.iiC().ijf();
      this.VJA.igr.igv = u.iiC().ijH();
      this.VJA.igr.igw = u.iiC().ijJ();
      this.VJA.igr.igx = u.iiC().ijp().iiS();
      this.VJA.igr.igy = u.iiC().ijo();
      this.VJA.igr.igz = u.iiC().getTrueName();
      this.VJA.igr.igA = u.iiC().ijg();
      this.VJA.igr.igB = u.iiC().ijp().iiW();
      this.VJA.igr.igC = "";
      this.VJA.igr.igQ = u.iiC().ijA();
      if ((paramp != null) && ((paramp instanceof ae)))
      {
        this.VJA.igr.igC = ((ae)paramp).igC;
        this.VJA.igr.igD = ((ae)paramp).igD;
        this.VJA.igr.igE = ((ae)paramp).igE;
        this.VJA.igr.igF = ((ae)paramp).igF;
        this.VJA.igr.igG = ((ae)paramp).igG;
        this.VJA.igr.scene = ((ae)paramp).scene;
        this.VJA.igr.igH = ((ae)paramp).igH;
        this.VJA.igr.igI = ((ae)paramp).igI;
        this.VJA.igr.igJ = ((ae)paramp).igJ;
        this.VJA.igr.igK = ((ae)paramp).igK;
        this.VJA.igr.igL = ((ae)paramp).igL;
        this.VJA.igr.igM = ((ae)paramp).igM;
        this.VJA.igr.igN = ((ae)paramp).igN;
        this.VJA.igr.title = ((ae)paramp).title;
        this.VJA.igr.igO = ((ae)paramp).igO;
        this.VJA.igr.igP = ((ae)paramp).igP;
        this.VJA.igr.igV = ((ae)paramp).Vyj;
        this.VJA.igr.igY = ((ae)paramp).igY;
      }
      paramString = this.VJA.igr;
      if (!u.iiC().ijw()) {
        break label746;
      }
    }
    label746:
    for (paramInt = 1;; paramInt = 0)
    {
      paramString.igR = paramInt;
      this.VJA.igr.igS = u.iiC().ijx();
      this.VJA.igr.igT = u.iiC().ijy();
      this.VJA.igr.igU = u.iiC().ijz();
      this.VJA.igr.igW = paramBoolean;
      Log.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.VJA.igr.igv + " hasNewTips : " + this.VJA.igr.igw + " swipeOn : " + this.VJA.igr.igx);
      if (this.VJA.callback != null) {
        this.VJA.callback.run();
      }
      if (this.VJA.igr.igh != null) {
        this.VJA.igr.igh.run();
      }
      if (this.Hfz) {
        this.VJA = null;
      }
      AppMethodBeat.o(70426);
      return;
    }
  }
  
  private boolean a(acz paramacz)
  {
    AppMethodBeat.i(70422);
    if (!(paramacz instanceof acz))
    {
      Log.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
      AppMethodBeat.o(70422);
      return false;
    }
    this.Hfz = false;
    this.VJA = paramacz;
    this.igs = paramacz.igq.igs;
    this.igt = paramacz.igq.igt;
    Log.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", new Object[] { Boolean.valueOf(this.igt) });
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(385, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1518, this);
    if (u.iiC().ijl())
    {
      Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
      b(paramacz);
    }
    for (;;)
    {
      AppMethodBeat.o(70422);
      return true;
      am localam;
      long l;
      int i;
      if (paramacz.igq.igs)
      {
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
        localam = u.iiC();
        l = Util.nowSecond();
        Log.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", new Object[] { Long.valueOf(l), Long.valueOf(localam.VKl) });
        if ((localam.VKl <= 0L) || (l > localam.VKl)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label278;
          }
          if (!this.igt) {
            this.Hfz = true;
          }
          Log.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
          a(0, "", null, false);
          b(paramacz);
          break;
        }
        label278:
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
        b(paramacz);
      }
      else
      {
        localam = u.iiC();
        l = Util.secondsToNow(localam.VKk);
        Log.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time ".concat(String.valueOf(l)), new Object[] { Long.valueOf(localam.VKk), Long.valueOf(System.currentTimeMillis() / 1000L) });
        if (l > 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label387;
          }
          Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
          b(paramacz);
          break;
        }
        label387:
        this.Hfz = true;
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
        a(0, "", null, false);
      }
    }
  }
  
  private static boolean ask(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11) || (paramInt == 12) || (paramInt == 13) || (paramInt == 14) || (paramInt == 15) || (paramInt == 16) || (paramInt == 17) || (paramInt == 18) || (paramInt == 19) || (paramInt == 20) || (paramInt == 21) || (paramInt == 22) || (paramInt == 23);
  }
  
  private void b(int paramInt, String paramString, p paramp)
  {
    AppMethodBeat.i(70425);
    com.tencent.mm.kernel.h.aZW().b(385, this);
    com.tencent.mm.kernel.h.aZW().b(1518, this);
    if ((!this.igt) && (this.igs) && (this.Hfz))
    {
      Log.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
      AppMethodBeat.o(70425);
      return;
    }
    this.Hfz = true;
    a(paramInt, paramString, paramp, true);
    AppMethodBeat.o(70425);
  }
  
  private void b(acz paramacz)
  {
    AppMethodBeat.i(70423);
    if (z.bBi())
    {
      this.VJB = new a();
      com.tencent.mm.kernel.h.aZW().a(this.VJB, 0);
      AppMethodBeat.o(70423);
      return;
    }
    if (ask(paramacz.igq.scene)) {}
    for (int i = paramacz.igq.scene;; i = 0)
    {
      this.VJB = new ae(null, i);
      com.tencent.mm.kernel.h.aZW().a(this.VJB, 0);
      AppMethodBeat.o(70423);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(70424);
    if ((this.VJA == null) || (this.VJA.igq == null))
    {
      AppMethodBeat.o(70424);
      return;
    }
    Log.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s, retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramp, Integer.valueOf(this.VJA.igq.retryCount) });
    if (paramp != this.VJB)
    {
      AppMethodBeat.o(70424);
      return;
    }
    if (((paramp instanceof ae)) || ((paramp instanceof a)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        b(paramInt2, paramString, paramp);
        AppMethodBeat.o(70424);
        return;
      }
      if (this.VJA.igq.retryCount == 0)
      {
        b(paramInt2, paramString, paramp);
        AppMethodBeat.o(70424);
        return;
      }
      paramString = this.VJA.igq;
      paramString.retryCount -= 1;
      b(this.VJA);
    }
    AppMethodBeat.o(70424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.WalletGetUserInfoEventListener
 * JD-Core Version:    0.7.0.1
 */