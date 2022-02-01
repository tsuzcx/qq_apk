package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.offline.a.f;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.ArrayList;

public final class i
  implements com.tencent.mm.ak.g
{
  public ao mHandler;
  private boolean vrV;
  private boolean vrW;
  private int vrX;
  private int vrY;
  private String vrZ;
  a vsa;
  private m vsb;
  public b vsc;
  int vsd;
  au vse;
  
  public i()
  {
    AppMethodBeat.i(66242);
    this.vrV = false;
    this.vrW = false;
    this.vrX = 10;
    this.vrY = 0;
    this.vrZ = "";
    this.mHandler = new ao();
    this.vsc = new b((byte)0);
    this.vsd = 14400000;
    this.vse = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66239);
        if (!com.tencent.mm.kernel.g.agM())
        {
          localau = i.this.vse;
          l = i.this.vsd;
          localau.au(l, l);
          AppMethodBeat.o(66239);
          return false;
        }
        i.this.gA(5, 5);
        au localau = i.this.vse;
        i locali = i.this;
        long l = com.tencent.mm.plugin.offline.c.a.dnl();
        if (l <= 0L) {}
        for (l = locali.vsd;; l = 1000L * l)
        {
          localau.au(l, l);
          AppMethodBeat.o(66239);
          return false;
          ac.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:".concat(String.valueOf(l)));
        }
      }
    }, false);
    try
    {
      com.tencent.mm.wallet_core.c.b.fAg().init(ai.getContext());
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
      k.dlZ();
      Object localObject = k.KG(196649);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!com.tencent.mm.plugin.offline.c.a.isNumeric((String)localObject)))
      {
        ac.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        ac.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=".concat(String.valueOf(l1)));
        localObject = this.vse;
        l1 *= 1000L;
        ((au)localObject).au(l1, l1);
        AppMethodBeat.o(66242);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", new Object[] { localException });
        continue;
        String str = com.tencent.mm.plugin.offline.c.a.dmZ();
        ac.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is ".concat(String.valueOf(str)));
        long l2 = Long.valueOf(localException).longValue();
        if (TextUtils.isEmpty(str))
        {
          ac.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
        }
        else
        {
          l1 = Long.valueOf(str).longValue();
          long l3 = System.currentTimeMillis() / 1000L;
          ac.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + l3 + ";");
          l1 = l2 - (l3 - l1);
        }
      }
    }
  }
  
  private static void KF(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(66249);
    boolean bool1 = com.tencent.mm.plugin.offline.c.a.cK(ai.getContext());
    boolean bool2 = ax.isNetworkConnected(ai.getContext());
    Object localObject = com.tencent.mm.plugin.report.service.h.wUl;
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
      if (k.vso) {
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
      if (!k.vso) {
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
      if (!k.vso) {
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
      com.tencent.mm.plugin.report.service.h.wUl.b((ArrayList)localObject, true);
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
        if (k.vso)
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
  
  public static int dlY()
  {
    AppMethodBeat.i(66243);
    k.dlZ();
    String str = k.KG(196617);
    com.tencent.mm.wallet_core.c.b.fAg();
    int i = com.tencent.mm.wallet_core.c.b.aSB(str);
    ac.i("MicroMsg.OfflineTokensMgr", "offline tokens count:".concat(String.valueOf(i)));
    AppMethodBeat.o(66243);
    return i;
  }
  
  public final void KE(final int paramInt)
  {
    AppMethodBeat.i(66246);
    if (dlY() > 2)
    {
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66240);
          i.this.gB(this.vsg, paramInt);
          AppMethodBeat.o(66240);
        }
      }, 3000L);
      AppMethodBeat.o(66246);
      return;
    }
    gB(2, paramInt);
    AppMethodBeat.o(66246);
  }
  
  public final void gA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66244);
    if ((ax.isNetworkConnected(ai.getContext())) && (com.tencent.mm.plugin.offline.c.a.dmQ()))
    {
      ac.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
      gB(paramInt1, paramInt2);
      AppMethodBeat.o(66244);
      return;
    }
    AppMethodBeat.o(66244);
  }
  
  public final void gB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66247);
    if (this.vrV)
    {
      AppMethodBeat.o(66247);
      return;
    }
    this.vrV = true;
    m localm = new m(System.currentTimeMillis() / 1000L, paramInt1, paramInt2);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(localm, 0);
    KF(paramInt1);
    AppMethodBeat.o(66247);
  }
  
  public final boolean oK(boolean paramBoolean)
  {
    AppMethodBeat.i(66245);
    if (!com.tencent.mm.plugin.offline.c.a.dmQ())
    {
      ac.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
      AppMethodBeat.o(66245);
      return false;
    }
    if (dlY() < k.vsp)
    {
      ac.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[] { Integer.valueOf(k.vsp) });
      com.tencent.mm.wallet_core.c.b.fAg();
      int i = com.tencent.mm.wallet_core.c.b.getLastError();
      if (i != 0)
      {
        ac.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + i + ", don't  doNetSceneToken");
        AppMethodBeat.o(66245);
        return false;
      }
      ac.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
      if (paramBoolean) {
        KE(9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        KE(2);
      }
    }
    if (com.tencent.mm.plugin.offline.c.a.dnm())
    {
      ac.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
      if (paramBoolean) {
        gB(5, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        gB(5, 5);
      }
    }
    if (!com.tencent.mm.plugin.offline.c.a.dnj())
    {
      ac.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
      if (paramBoolean) {
        gB(3, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        gB(3, 3);
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
      com.tencent.mm.plugin.report.service.h.wUl.b(paramString, true);
    }
    if (((paramn instanceof f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      ac.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.vsb != null)
      {
        boolean bool = this.vsb.dme();
        this.vsb = null;
        if ((bool) && (this.vsa != null)) {
          this.vsa.dlS();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof m))
      {
        this.vrY = 0;
        this.vrV = false;
        this.mHandler.removeCallbacks(this.vsc);
        this.vsb = ((m)paramn);
        paramString = this.vsb.vtf;
        k.dlZ();
        paramString = new f(paramString, k.KG(196617));
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramn instanceof l))
      {
        this.vrW = false;
        this.vrZ = ((l)paramn).vrZ;
        if (this.vsa != null) {
          this.vsa.dlS();
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
      ac.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
      this.vrY += 1;
      this.vrV = false;
      if (paramInt2 == 411)
      {
        ac.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
        com.tencent.mm.plugin.offline.c.a.dnc();
        AppMethodBeat.o(66248);
        return;
      }
      if (this.vrY < this.vrX)
      {
        this.mHandler.removeCallbacks(this.vsc);
        paramInt1 = this.vrY - 1;
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
      this.mHandler.postDelayed(this.vsc, paramInt1 * 60 * 1000);
      AppMethodBeat.o(66248);
      return;
      if ((paramn instanceof l))
      {
        this.vrW = false;
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramn instanceof f)) {
        this.vsb = null;
      }
      AppMethodBeat.o(66248);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void dlS();
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(66241);
      ac.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
      if (!com.tencent.mm.kernel.g.agP().afY())
      {
        ac.w("MicroMsg.OfflineTokensMgr", "account not init.");
        AppMethodBeat.o(66241);
        return;
      }
      i.this.gB(6, 6);
      AppMethodBeat.o(66241);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i
 * JD-Core Version:    0.7.0.1
 */