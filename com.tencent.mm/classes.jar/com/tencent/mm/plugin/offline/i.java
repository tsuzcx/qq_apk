package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.offline.a.h;
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
  implements com.tencent.mm.al.f
{
  public ap mHandler;
  private boolean wxn;
  private boolean wxo;
  private int wxp;
  private int wxq;
  private String wxr;
  a wxs;
  private m wxt;
  public b wxu;
  int wxv;
  av wxw;
  
  public i()
  {
    AppMethodBeat.i(66242);
    this.wxn = false;
    this.wxo = false;
    this.wxp = 10;
    this.wxq = 0;
    this.wxr = "";
    this.mHandler = new ap();
    this.wxu = new b((byte)0);
    this.wxv = 14400000;
    this.wxw = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66239);
        if (!com.tencent.mm.kernel.g.ajx())
        {
          localav = i.this.wxw;
          l = i.this.wxv;
          localav.az(l, l);
          AppMethodBeat.o(66239);
          return false;
        }
        i.this.gS(5, 5);
        av localav = i.this.wxw;
        i locali = i.this;
        long l = com.tencent.mm.plugin.offline.c.a.dxD();
        if (l <= 0L) {}
        for (l = locali.wxv;; l = 1000L * l)
        {
          localav.az(l, l);
          AppMethodBeat.o(66239);
          return false;
          ad.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:".concat(String.valueOf(l)));
        }
      }
    }, false);
    try
    {
      com.tencent.mm.wallet_core.c.b.fRq().init(aj.getContext());
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(385, this);
      k.dwq();
      Object localObject = k.Mi(196649);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!com.tencent.mm.plugin.offline.c.a.isNumeric((String)localObject)))
      {
        ad.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        ad.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=".concat(String.valueOf(l1)));
        localObject = this.wxw;
        l1 *= 1000L;
        ((av)localObject).az(l1, l1);
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
        String str = com.tencent.mm.plugin.offline.c.a.dxr();
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
  
  private static void Mh(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(66249);
    boolean bool1 = com.tencent.mm.plugin.offline.c.a.cH(aj.getContext());
    boolean bool2 = ay.isNetworkConnected(aj.getContext());
    Object localObject = com.tencent.mm.plugin.report.service.g.yhR;
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
      if (k.wxG) {
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
      if (!k.wxG) {
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
      if (!k.wxG) {
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
      com.tencent.mm.plugin.report.service.g.yhR.b((ArrayList)localObject, true);
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
        if (k.wxG)
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
  
  public static int dwp()
  {
    AppMethodBeat.i(66243);
    k.dwq();
    String str = k.Mi(196617);
    com.tencent.mm.wallet_core.c.b.fRq();
    int i = com.tencent.mm.wallet_core.c.b.aYA(str);
    ad.i("MicroMsg.OfflineTokensMgr", "offline tokens count:".concat(String.valueOf(i)));
    AppMethodBeat.o(66243);
    return i;
  }
  
  public final void Mg(final int paramInt)
  {
    AppMethodBeat.i(66246);
    if (dwp() > 2)
    {
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66240);
          i.this.gT(this.wxy, paramInt);
          AppMethodBeat.o(66240);
        }
      }, 3000L);
      AppMethodBeat.o(66246);
      return;
    }
    gT(2, paramInt);
    AppMethodBeat.o(66246);
  }
  
  public final void gS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66244);
    if ((ay.isNetworkConnected(aj.getContext())) && (com.tencent.mm.plugin.offline.c.a.dxi()))
    {
      ad.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
      gT(paramInt1, paramInt2);
      AppMethodBeat.o(66244);
      return;
    }
    AppMethodBeat.o(66244);
  }
  
  public final void gT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66247);
    if (this.wxn)
    {
      AppMethodBeat.o(66247);
      return;
    }
    this.wxn = true;
    m localm = new m(System.currentTimeMillis() / 1000L, paramInt1, paramInt2);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(localm, 0);
    Mh(paramInt1);
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
      com.tencent.mm.plugin.report.service.g.yhR.b(paramString, true);
    }
    if (((paramn instanceof com.tencent.mm.plugin.offline.a.f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      ad.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.wxt != null)
      {
        boolean bool = this.wxt.dwv();
        this.wxt = null;
        if ((bool) && (this.wxs != null)) {
          this.wxs.dwj();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof m))
      {
        this.wxq = 0;
        this.wxn = false;
        this.mHandler.removeCallbacks(this.wxu);
        this.wxt = ((m)paramn);
        paramString = this.wxt.wyx;
        k.dwq();
        paramString = new com.tencent.mm.plugin.offline.a.f(paramString, k.Mi(196617));
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramn instanceof l))
      {
        this.wxo = false;
        this.wxr = ((l)paramn).wxr;
        if (this.wxs != null) {
          this.wxs.dwj();
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
      ad.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
      this.wxq += 1;
      this.wxn = false;
      if (paramInt2 == 411)
      {
        ad.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
        com.tencent.mm.plugin.offline.c.a.dxu();
        AppMethodBeat.o(66248);
        return;
      }
      if (this.wxq < this.wxp)
      {
        this.mHandler.removeCallbacks(this.wxu);
        paramInt1 = this.wxq - 1;
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
      this.mHandler.postDelayed(this.wxu, paramInt1 * 60 * 1000);
      AppMethodBeat.o(66248);
      return;
      if ((paramn instanceof l))
      {
        this.wxo = false;
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.offline.a.f)) {
        this.wxt = null;
      }
      AppMethodBeat.o(66248);
      return;
    }
  }
  
  public final boolean pj(boolean paramBoolean)
  {
    AppMethodBeat.i(66245);
    if (!com.tencent.mm.plugin.offline.c.a.dxi())
    {
      ad.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
      AppMethodBeat.o(66245);
      return false;
    }
    if (dwp() < k.wxH)
    {
      ad.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[] { Integer.valueOf(k.wxH) });
      com.tencent.mm.wallet_core.c.b.fRq();
      int i = com.tencent.mm.wallet_core.c.b.getLastError();
      if (i != 0)
      {
        ad.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + i + ", don't  doNetSceneToken");
        AppMethodBeat.o(66245);
        return false;
      }
      ad.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
      if (paramBoolean) {
        Mg(9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        Mg(2);
      }
    }
    if (com.tencent.mm.plugin.offline.c.a.dxE())
    {
      ad.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
      if (paramBoolean) {
        gT(5, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        gT(5, 5);
      }
    }
    if (!com.tencent.mm.plugin.offline.c.a.dxB())
    {
      ad.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
      if (paramBoolean) {
        gT(3, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        gT(3, 3);
      }
    }
    AppMethodBeat.o(66245);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void dwj();
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(66241);
      ad.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
      if (!com.tencent.mm.kernel.g.ajA().aiK())
      {
        ad.w("MicroMsg.OfflineTokensMgr", "account not init.");
        AppMethodBeat.o(66241);
        return;
      }
      i.this.gT(6, 6);
      AppMethodBeat.o(66241);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i
 * JD-Core Version:    0.7.0.1
 */