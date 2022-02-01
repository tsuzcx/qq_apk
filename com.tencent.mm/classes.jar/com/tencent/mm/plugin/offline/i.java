package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.offline.a.h;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import java.util.ArrayList;

public final class i
  implements com.tencent.mm.ak.f
{
  public aq mHandler;
  private boolean wMY;
  private boolean wMZ;
  private int wNa;
  private int wNb;
  private String wNc;
  a wNd;
  private m wNe;
  public b wNf;
  int wNg;
  aw wNh;
  
  public i()
  {
    AppMethodBeat.i(66242);
    this.wMY = false;
    this.wMZ = false;
    this.wNa = 10;
    this.wNb = 0;
    this.wNc = "";
    this.mHandler = new aq();
    this.wNf = new b((byte)0);
    this.wNg = 14400000;
    this.wNh = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66239);
        if (!com.tencent.mm.kernel.g.ajM())
        {
          localaw = i.this.wNh;
          l = i.this.wNg;
          localaw.ay(l, l);
          AppMethodBeat.o(66239);
          return false;
        }
        i.this.gT(5, 5);
        aw localaw = i.this.wNh;
        i locali = i.this;
        long l = com.tencent.mm.plugin.offline.c.a.dAT();
        if (l <= 0L) {}
        for (l = locali.wNg;; l = 1000L * l)
        {
          localaw.ay(l, l);
          AppMethodBeat.o(66239);
          return false;
          ae.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:".concat(String.valueOf(l)));
        }
      }
    }, false);
    try
    {
      com.tencent.mm.wallet_core.c.b.fVM().init(ak.getContext());
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(385, this);
      k.dzG();
      Object localObject = k.MN(196649);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!com.tencent.mm.plugin.offline.c.a.isNumeric((String)localObject)))
      {
        ae.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        ae.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=".concat(String.valueOf(l1)));
        localObject = this.wNh;
        l1 *= 1000L;
        ((aw)localObject).ay(l1, l1);
        AppMethodBeat.o(66242);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", new Object[] { localException });
        continue;
        String str = com.tencent.mm.plugin.offline.c.a.dAH();
        ae.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is ".concat(String.valueOf(str)));
        long l2 = Long.valueOf(localException).longValue();
        if (TextUtils.isEmpty(str))
        {
          ae.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
        }
        else
        {
          l1 = Long.valueOf(str).longValue();
          long l3 = System.currentTimeMillis() / 1000L;
          ae.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + l3 + ";");
          l1 = l2 - (l3 - l1);
        }
      }
    }
  }
  
  private static void MM(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(66249);
    boolean bool1 = com.tencent.mm.plugin.offline.c.a.cJ(ak.getContext());
    boolean bool2 = az.isNetworkConnected(ak.getContext());
    Object localObject = com.tencent.mm.plugin.report.service.g.yxI;
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
      if (k.wNr) {
        k = 1;
      }
      ((com.tencent.mm.plugin.report.service.g)localObject).f(14163, new Object[] { Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(k) });
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
      if (!k.wNr) {
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
      if (!k.wNr) {
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
      com.tencent.mm.plugin.report.service.g.yxI.b((ArrayList)localObject, true);
      AppMethodBeat.o(66249);
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
        if (k.wNr)
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
  
  public static int dzF()
  {
    AppMethodBeat.i(66243);
    k.dzG();
    String str = k.MN(196617);
    com.tencent.mm.wallet_core.c.b.fVM();
    int i = com.tencent.mm.wallet_core.c.b.bad(str);
    ae.i("MicroMsg.OfflineTokensMgr", "offline tokens count:".concat(String.valueOf(i)));
    AppMethodBeat.o(66243);
    return i;
  }
  
  public final void ML(final int paramInt)
  {
    AppMethodBeat.i(66246);
    if (dzF() > 2)
    {
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66240);
          i.this.gU(this.wNj, paramInt);
          AppMethodBeat.o(66240);
        }
      }, 3000L);
      AppMethodBeat.o(66246);
      return;
    }
    gU(2, paramInt);
    AppMethodBeat.o(66246);
  }
  
  public final void gT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66244);
    if ((az.isNetworkConnected(ak.getContext())) && (com.tencent.mm.plugin.offline.c.a.dAy()))
    {
      ae.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
      gU(paramInt1, paramInt2);
      AppMethodBeat.o(66244);
      return;
    }
    AppMethodBeat.o(66244);
  }
  
  public final void gU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66247);
    if (this.wMY)
    {
      AppMethodBeat.o(66247);
      return;
    }
    this.wMY = true;
    m localm = new m(System.currentTimeMillis() / 1000L, paramInt1, paramInt2);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(localm, 0);
    MM(paramInt1);
    AppMethodBeat.o(66247);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 6;
    AppMethodBeat.i(66248);
    if ((!(paramn instanceof h)) && (!(paramn instanceof com.tencent.mm.plugin.offline.a.f)))
    {
      AppMethodBeat.o(66248);
      return;
    }
    paramString = new ArrayList();
    if ((paramn instanceof m))
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
      com.tencent.mm.plugin.report.service.g.yxI.b(paramString, true);
    }
    if (((paramn instanceof com.tencent.mm.plugin.offline.a.f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      ae.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.wNe != null)
      {
        boolean bool = this.wNe.dzL();
        this.wNe = null;
        if ((bool) && (this.wNd != null)) {
          this.wNd.dzz();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof m))
      {
        this.wNb = 0;
        this.wMY = false;
        this.mHandler.removeCallbacks(this.wNf);
        this.wNe = ((m)paramn);
        paramString = this.wNe.wOi;
        k.dzG();
        paramString = new com.tencent.mm.plugin.offline.a.f(paramString, k.MN(196617));
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramn instanceof l))
      {
        this.wMZ = false;
        this.wNc = ((l)paramn).wNc;
        if (this.wNd != null) {
          this.wNd.dzz();
        }
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.f)) {
        AppMethodBeat.o(66248);
      }
    }
    else if ((paramn instanceof m))
    {
      ae.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
      this.wNb += 1;
      this.wMY = false;
      if (paramInt2 == 411)
      {
        ae.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
        com.tencent.mm.plugin.offline.c.a.dAK();
        AppMethodBeat.o(66248);
        return;
      }
      if (this.wNb < this.wNa)
      {
        this.mHandler.removeCallbacks(this.wNf);
        paramInt1 = this.wNb - 1;
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
      this.mHandler.postDelayed(this.wNf, paramInt1 * 60 * 1000);
      AppMethodBeat.o(66248);
      return;
      if ((paramn instanceof l))
      {
        this.wMZ = false;
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.f)) {
        this.wNe = null;
      }
      AppMethodBeat.o(66248);
      return;
    }
  }
  
  public final boolean pr(boolean paramBoolean)
  {
    AppMethodBeat.i(66245);
    if (!com.tencent.mm.plugin.offline.c.a.dAy())
    {
      ae.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
      AppMethodBeat.o(66245);
      return false;
    }
    if (dzF() < k.wNs)
    {
      ae.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[] { Integer.valueOf(k.wNs) });
      com.tencent.mm.wallet_core.c.b.fVM();
      int i = com.tencent.mm.wallet_core.c.b.getLastError();
      if (i != 0)
      {
        ae.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + i + ", don't  doNetSceneToken");
        AppMethodBeat.o(66245);
        return false;
      }
      ae.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
      if (paramBoolean) {
        ML(9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        ML(2);
      }
    }
    if (com.tencent.mm.plugin.offline.c.a.dAU())
    {
      ae.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
      if (paramBoolean) {
        gU(5, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        gU(5, 5);
      }
    }
    if (!com.tencent.mm.plugin.offline.c.a.dAR())
    {
      ae.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
      if (paramBoolean) {
        gU(3, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        gU(3, 3);
      }
    }
    AppMethodBeat.o(66245);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void dzz();
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(66241);
      ae.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
      if (!com.tencent.mm.kernel.g.ajP().aiZ())
      {
        ae.w("MicroMsg.OfflineTokensMgr", "account not init.");
        AppMethodBeat.o(66241);
        return;
      }
      i.this.gU(6, 6);
      AppMethodBeat.o(66241);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i
 * JD-Core Version:    0.7.0.1
 */