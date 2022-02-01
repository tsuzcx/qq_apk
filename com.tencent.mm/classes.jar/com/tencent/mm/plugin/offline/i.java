package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.offline.a.f;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.ArrayList;

public final class i
  implements com.tencent.mm.al.g
{
  public ap mHandler;
  private boolean uiZ;
  private boolean uja;
  private int ujb;
  private int ujc;
  private String ujd;
  a uje;
  private m ujf;
  public b ujg;
  int ujh;
  av uji;
  
  public i()
  {
    AppMethodBeat.i(66242);
    this.uiZ = false;
    this.uja = false;
    this.ujb = 10;
    this.ujc = 0;
    this.ujd = "";
    this.mHandler = new ap();
    this.ujg = new b((byte)0);
    this.ujh = 14400000;
    this.uji = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66239);
        if (!com.tencent.mm.kernel.g.afw())
        {
          localav = i.this.uji;
          l = i.this.ujh;
          localav.av(l, l);
          AppMethodBeat.o(66239);
          return false;
        }
        i.this.gt(5, 5);
        av localav = i.this.uji;
        i locali = i.this;
        long l = com.tencent.mm.plugin.offline.c.a.cZD();
        if (l <= 0L) {}
        for (l = locali.ujh;; l = 1000L * l)
        {
          localav.av(l, l);
          AppMethodBeat.o(66239);
          return false;
          ad.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:".concat(String.valueOf(l)));
        }
      }
    }, false);
    try
    {
      com.tencent.mm.wallet_core.c.b.fjR().init(aj.getContext());
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(385, this);
      k.cYr();
      Object localObject = k.IH(196649);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!com.tencent.mm.plugin.offline.c.a.isNumeric((String)localObject)))
      {
        ad.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        ad.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=".concat(String.valueOf(l1)));
        localObject = this.uji;
        l1 *= 1000L;
        ((av)localObject).av(l1, l1);
        AppMethodBeat.o(66242);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", new Object[] { localException });
        continue;
        String str = com.tencent.mm.plugin.offline.c.a.cZr();
        ad.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is ".concat(String.valueOf(str)));
        long l2 = Long.valueOf(localException).longValue();
        if (TextUtils.isEmpty(str))
        {
          ad.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
        }
        else
        {
          l1 = Long.valueOf(str).longValue();
          long l3 = System.currentTimeMillis() / 1000L;
          ad.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + l3 + ";");
          l1 = l2 - (l3 - l1);
        }
      }
    }
  }
  
  private static void IG(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(66249);
    boolean bool1 = com.tencent.mm.plugin.offline.c.a.cB(aj.getContext());
    boolean bool2 = ay.isNetworkConnected(aj.getContext());
    Object localObject = com.tencent.mm.plugin.report.service.h.vKh;
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
      if (k.ujs) {
        k = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).f(14163, new Object[] { Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(k) });
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
      if (!k.ujs) {
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
      if (!k.ujs) {
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
      com.tencent.mm.plugin.report.service.h.vKh.b((ArrayList)localObject, true);
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
        if (k.ujs)
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
  
  public static int cYq()
  {
    AppMethodBeat.i(66243);
    k.cYr();
    String str = k.IH(196617);
    com.tencent.mm.wallet_core.c.b.fjR();
    int i = com.tencent.mm.wallet_core.c.b.aMY(str);
    ad.i("MicroMsg.OfflineTokensMgr", "offline tokens count:".concat(String.valueOf(i)));
    AppMethodBeat.o(66243);
    return i;
  }
  
  public final void IF(final int paramInt)
  {
    AppMethodBeat.i(66246);
    if (cYq() > 2)
    {
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66240);
          i.this.gu(this.ujk, paramInt);
          AppMethodBeat.o(66240);
        }
      }, 3000L);
      AppMethodBeat.o(66246);
      return;
    }
    gu(2, paramInt);
    AppMethodBeat.o(66246);
  }
  
  public final void gt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66244);
    if ((ay.isNetworkConnected(aj.getContext())) && (com.tencent.mm.plugin.offline.c.a.cZi()))
    {
      ad.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
      gu(paramInt1, paramInt2);
      AppMethodBeat.o(66244);
      return;
    }
    AppMethodBeat.o(66244);
  }
  
  public final void gu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66247);
    if (this.uiZ)
    {
      AppMethodBeat.o(66247);
      return;
    }
    this.uiZ = true;
    m localm = new m(System.currentTimeMillis() / 1000L, paramInt1, paramInt2);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(localm, 0);
    IG(paramInt1);
    AppMethodBeat.o(66247);
  }
  
  public final boolean nQ(boolean paramBoolean)
  {
    AppMethodBeat.i(66245);
    if (!com.tencent.mm.plugin.offline.c.a.cZi())
    {
      ad.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
      AppMethodBeat.o(66245);
      return false;
    }
    if (cYq() < k.ujt)
    {
      ad.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[] { Integer.valueOf(k.ujt) });
      com.tencent.mm.wallet_core.c.b.fjR();
      int i = com.tencent.mm.wallet_core.c.b.getLastError();
      if (i != 0)
      {
        ad.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + i + ", don't  doNetSceneToken");
        AppMethodBeat.o(66245);
        return false;
      }
      ad.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
      if (paramBoolean) {
        IF(9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        IF(2);
      }
    }
    if (com.tencent.mm.plugin.offline.c.a.cZE())
    {
      ad.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
      if (paramBoolean) {
        gu(5, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        gu(5, 5);
      }
    }
    if (!com.tencent.mm.plugin.offline.c.a.cZB())
    {
      ad.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
      if (paramBoolean) {
        gu(3, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        gu(3, 3);
      }
    }
    AppMethodBeat.o(66245);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 6;
    AppMethodBeat.i(66248);
    if ((!(paramn instanceof com.tencent.mm.plugin.offline.a.h)) && (!(paramn instanceof f)))
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
      com.tencent.mm.plugin.report.service.h.vKh.b(paramString, true);
    }
    if (((paramn instanceof f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      ad.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.ujf != null)
      {
        boolean bool = this.ujf.cYw();
        this.ujf = null;
        if ((bool) && (this.uje != null)) {
          this.uje.cYk();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof m))
      {
        this.ujc = 0;
        this.uiZ = false;
        this.mHandler.removeCallbacks(this.ujg);
        this.ujf = ((m)paramn);
        paramString = this.ujf.ukj;
        k.cYr();
        paramString = new f(paramString, k.IH(196617));
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramn instanceof l))
      {
        this.uja = false;
        this.ujd = ((l)paramn).ujd;
        if (this.uje != null) {
          this.uje.cYk();
        }
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramn instanceof f)) {
        AppMethodBeat.o(66248);
      }
    }
    else if ((paramn instanceof m))
    {
      ad.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
      this.ujc += 1;
      this.uiZ = false;
      if (paramInt2 == 411)
      {
        ad.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
        com.tencent.mm.plugin.offline.c.a.cZu();
        AppMethodBeat.o(66248);
        return;
      }
      if (this.ujc < this.ujb)
      {
        this.mHandler.removeCallbacks(this.ujg);
        paramInt1 = this.ujc - 1;
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
      this.mHandler.postDelayed(this.ujg, paramInt1 * 60 * 1000);
      AppMethodBeat.o(66248);
      return;
      if ((paramn instanceof l))
      {
        this.uja = false;
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramn instanceof f)) {
        this.ujf = null;
      }
      AppMethodBeat.o(66248);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cYk();
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(66241);
      ad.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
      if (!com.tencent.mm.kernel.g.afz().aeI())
      {
        ad.w("MicroMsg.OfflineTokensMgr", "account not init.");
        AppMethodBeat.o(66241);
        return;
      }
      i.this.gu(6, 6);
      AppMethodBeat.o(66241);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i
 * JD-Core Version:    0.7.0.1
 */