package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import java.util.ArrayList;

public final class i
  implements com.tencent.mm.ai.f
{
  public ak mHandler;
  i.a pkA;
  private com.tencent.mm.plugin.offline.a.m pkB;
  public i.b pkC;
  int pkD;
  ap pkE;
  private boolean pkv;
  private boolean pkw;
  private int pkx;
  private int pky;
  private String pkz;
  
  public i()
  {
    AppMethodBeat.i(43340);
    this.pkv = false;
    this.pkw = false;
    this.pkx = 10;
    this.pky = 0;
    this.pkz = "";
    this.mHandler = new ak();
    this.pkC = new i.b(this, (byte)0);
    this.pkD = 14400000;
    this.pkE = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(43337);
        if (!g.RG())
        {
          localap = i.this.pkE;
          l = i.this.pkD;
          localap.ag(l, l);
          AppMethodBeat.o(43337);
          return false;
        }
        i.this.eX(5, 5);
        ap localap = i.this.pkE;
        i locali = i.this;
        long l = a.bZR();
        if (l <= 0L) {}
        for (l = locali.pkD;; l = 1000L * l)
        {
          localap.ag(l, l);
          AppMethodBeat.o(43337);
          return false;
          ab.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:".concat(String.valueOf(l)));
        }
      }
    }, false);
    try
    {
      com.tencent.mm.wallet_core.c.b.dSi().init(ah.getContext());
      g.RM();
      g.RK().eHt.a(385, this);
      k.bYF();
      Object localObject = k.AY(196649);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!a.isNumeric((String)localObject)))
      {
        ab.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        ab.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=".concat(String.valueOf(l1)));
        localObject = this.pkE;
        l1 *= 1000L;
        ((ap)localObject).ag(l1, l1);
        AppMethodBeat.o(43340);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", new Object[] { localException });
        continue;
        String str = a.bZF();
        ab.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is ".concat(String.valueOf(str)));
        long l2 = Long.valueOf(localException).longValue();
        if (TextUtils.isEmpty(str))
        {
          ab.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
        }
        else
        {
          l1 = Long.valueOf(str).longValue();
          long l3 = System.currentTimeMillis() / 1000L;
          ab.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + l3 + ";");
          l1 = l2 - (l3 - l1);
        }
      }
    }
  }
  
  private static void AX(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(43347);
    boolean bool1 = a.eD(ah.getContext());
    boolean bool2 = at.isNetworkConnected(ah.getContext());
    Object localObject = com.tencent.mm.plugin.report.service.h.qsU;
    int i;
    int j;
    if (bool1)
    {
      i = 0;
      if (!bool2) {
        break label411;
      }
      j = 1;
      label42:
      if (k.pkO) {
        k = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).e(14163, new Object[] { Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(k) });
      localObject = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool2) {
        break label416;
      }
      i = 36;
      label145:
      localIDKey.SetKey(i);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool1) {
        break label422;
      }
      i = 38;
      label190:
      localIDKey.SetKey(i);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!k.pkO) {
        break label428;
      }
      i = 40;
      label236:
      localIDKey.SetKey(i);
      ((ArrayList)localObject).add(localIDKey);
      if (paramInt != 2) {
        break label452;
      }
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!k.pkO) {
        break label434;
      }
      paramInt = 42;
      label287:
      localIDKey.SetKey(paramInt);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool1) {
        break label440;
      }
      paramInt = 44;
      label332:
      localIDKey.SetKey(paramInt);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool2) {
        break label446;
      }
      paramInt = 46;
      label377:
      localIDKey.SetKey(paramInt);
      ((ArrayList)localObject).add(localIDKey);
    }
    label411:
    label416:
    label422:
    label428:
    label434:
    label440:
    label446:
    label452:
    label490:
    do
    {
      com.tencent.mm.plugin.report.service.h.qsU.b((ArrayList)localObject, true);
      AppMethodBeat.o(43347);
      return;
      i = 1;
      break;
      j = 0;
      break label42;
      i = 37;
      break label145;
      i = 39;
      break label190;
      i = 41;
      break label236;
      paramInt = 43;
      break label287;
      paramInt = 45;
      break label332;
      paramInt = 47;
      break label377;
      if (paramInt == 6)
      {
        localIDKey = new IDKey();
        localIDKey.SetID(135);
        localIDKey.SetValue(1L);
        if (k.pkO)
        {
          paramInt = 48;
          localIDKey.SetKey(paramInt);
          ((ArrayList)localObject).add(localIDKey);
          localIDKey = new IDKey();
          localIDKey.SetID(135);
          localIDKey.SetValue(1L);
          if (!bool1) {
            break label603;
          }
          paramInt = 50;
          localIDKey.SetKey(paramInt);
          ((ArrayList)localObject).add(localIDKey);
          localIDKey = new IDKey();
          localIDKey.SetID(135);
          localIDKey.SetValue(1L);
          if (!bool2) {
            break label609;
          }
        }
        for (paramInt = 52;; paramInt = 53)
        {
          localIDKey.SetKey(paramInt);
          ((ArrayList)localObject).add(localIDKey);
          break;
          paramInt = 49;
          break label490;
          paramInt = 51;
          break label535;
        }
      }
    } while (paramInt != 6);
    label535:
    label603:
    label609:
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(135);
    localIDKey.SetValue(1L);
    if (bool1) {}
    for (paramInt = 54;; paramInt = 55)
    {
      localIDKey.SetKey(paramInt);
      ((ArrayList)localObject).add(localIDKey);
      break;
    }
  }
  
  public static int bYE()
  {
    AppMethodBeat.i(43341);
    k.bYF();
    String str = k.AY(196617);
    com.tencent.mm.wallet_core.c.b.dSi();
    int i = com.tencent.mm.wallet_core.c.b.avW(str);
    ab.i("MicroMsg.OfflineTokensMgr", "offline tokens count:".concat(String.valueOf(i)));
    AppMethodBeat.o(43341);
    return i;
  }
  
  public final void AW(int paramInt)
  {
    AppMethodBeat.i(43344);
    if (bYE() > 2)
    {
      this.mHandler.postDelayed(new i.2(this, paramInt), 3000L);
      AppMethodBeat.o(43344);
      return;
    }
    eY(2, paramInt);
    AppMethodBeat.o(43344);
  }
  
  public final void eX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43342);
    if ((at.isNetworkConnected(ah.getContext())) && (a.bZw()))
    {
      ab.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
      eY(paramInt1, paramInt2);
      AppMethodBeat.o(43342);
      return;
    }
    AppMethodBeat.o(43342);
  }
  
  public final void eY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43345);
    if (this.pkv)
    {
      AppMethodBeat.o(43345);
      return;
    }
    this.pkv = true;
    com.tencent.mm.plugin.offline.a.m localm = new com.tencent.mm.plugin.offline.a.m(System.currentTimeMillis() / 1000L, paramInt1, paramInt2);
    g.RM();
    g.RK().eHt.a(localm, 0);
    AX(paramInt1);
    AppMethodBeat.o(43345);
  }
  
  public final boolean jV(boolean paramBoolean)
  {
    AppMethodBeat.i(43343);
    if (!a.bZw())
    {
      ab.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
      AppMethodBeat.o(43343);
      return false;
    }
    if (bYE() < k.pkP)
    {
      ab.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[] { Integer.valueOf(k.pkP) });
      com.tencent.mm.wallet_core.c.b.dSi();
      int i = com.tencent.mm.wallet_core.c.b.getLastError();
      if (i != 0)
      {
        ab.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + i + ", don't  doNetSceneToken");
        AppMethodBeat.o(43343);
        return false;
      }
      ab.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
      if (paramBoolean) {
        AW(9);
      }
      for (;;)
      {
        AppMethodBeat.o(43343);
        return true;
        AW(2);
      }
    }
    if (a.bZS())
    {
      ab.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
      if (paramBoolean) {
        eY(5, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(43343);
        return true;
        eY(5, 5);
      }
    }
    if (!a.bZP())
    {
      ab.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
      if (paramBoolean) {
        eY(3, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(43343);
        return true;
        eY(3, 3);
      }
    }
    AppMethodBeat.o(43343);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    int i = 6;
    AppMethodBeat.i(43346);
    if ((!(paramm instanceof com.tencent.mm.plugin.offline.a.h)) && (!(paramm instanceof com.tencent.mm.plugin.offline.a.f)))
    {
      AppMethodBeat.o(43346);
      return;
    }
    paramString = new ArrayList();
    if ((paramm instanceof com.tencent.mm.plugin.offline.a.m))
    {
      IDKey localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      localIDKey.SetKey(2);
      paramString.add(localIDKey);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        localIDKey = new IDKey();
        localIDKey.SetID(135);
        localIDKey.SetValue(1L);
        localIDKey.SetKey(3);
        paramString.add(localIDKey);
      }
      com.tencent.mm.plugin.report.service.h.qsU.b(paramString, true);
    }
    if (((paramm instanceof com.tencent.mm.plugin.offline.a.f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      ab.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.pkB != null)
      {
        boolean bool = this.pkB.bYK();
        this.pkB = null;
        if ((bool) && (this.pkA != null)) {
          this.pkA.bYy();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.offline.a.m))
      {
        this.pky = 0;
        this.pkv = false;
        this.mHandler.removeCallbacks(this.pkC);
        this.pkB = ((com.tencent.mm.plugin.offline.a.m)paramm);
        paramString = this.pkB.plD;
        k.bYF();
        paramString = new com.tencent.mm.plugin.offline.a.f(paramString, k.AY(196617));
        g.RM();
        g.RK().eHt.a(paramString, 0);
        AppMethodBeat.o(43346);
        return;
      }
      if ((paramm instanceof l))
      {
        this.pkw = false;
        this.pkz = ((l)paramm).pkz;
        if (this.pkA != null) {
          this.pkA.bYy();
        }
        AppMethodBeat.o(43346);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.offline.a.f)) {
        AppMethodBeat.o(43346);
      }
    }
    else if ((paramm instanceof com.tencent.mm.plugin.offline.a.m))
    {
      ab.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
      this.pky += 1;
      this.pkv = false;
      if (paramInt2 == 411)
      {
        ab.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
        a.bZH();
        AppMethodBeat.o(43346);
        return;
      }
      if (this.pky < this.pkx)
      {
        this.mHandler.removeCallbacks(this.pkC);
        paramInt1 = this.pky - 1;
        if (paramInt1 <= 6) {
          break label556;
        }
        paramInt1 = i;
      }
    }
    label556:
    for (;;)
    {
      paramInt1 = (int)Math.pow(2.0D, paramInt1);
      this.mHandler.postDelayed(this.pkC, paramInt1 * 60 * 1000);
      AppMethodBeat.o(43346);
      return;
      if ((paramm instanceof l))
      {
        this.pkw = false;
        AppMethodBeat.o(43346);
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.offline.a.f)) {
        this.pkB = null;
      }
      AppMethodBeat.o(43346);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i
 * JD-Core Version:    0.7.0.1
 */