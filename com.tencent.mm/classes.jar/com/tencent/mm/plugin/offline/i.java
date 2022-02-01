package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.f;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.ArrayList;

public final class i
  implements com.tencent.mm.ak.i
{
  private boolean AIE;
  private boolean AIF;
  private int AIG;
  private int AIH;
  private String AII;
  a AIJ;
  private m AIK;
  public b AIL;
  int AIM;
  MTimerHandler AIN;
  public MMHandler mHandler;
  
  public i()
  {
    AppMethodBeat.i(66242);
    this.AIE = false;
    this.AIF = false;
    this.AIG = 10;
    this.AIH = 0;
    this.AII = "";
    this.mHandler = new MMHandler();
    this.AIL = new b((byte)0);
    this.AIM = 14400000;
    this.AIN = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66239);
        if (!g.aAc())
        {
          i.this.AIN.startTimer(i.this.AIM);
          AppMethodBeat.o(66239);
          return false;
        }
        i.this.hE(5, 5);
        MTimerHandler localMTimerHandler = i.this.AIN;
        i locali = i.this;
        long l = com.tencent.mm.plugin.offline.c.a.eAF();
        if (l <= 0L) {}
        for (l = locali.AIM;; l = 1000L * l)
        {
          localMTimerHandler.startTimer(l);
          AppMethodBeat.o(66239);
          return false;
          Log.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:".concat(String.valueOf(l)));
        }
      }
    }, false);
    try
    {
      com.tencent.mm.wallet_core.c.b.hhj().init(MMApplicationContext.getContext());
      g.aAi();
      g.aAg().hqi.a(385, this);
      k.ezn();
      String str1 = k.TX(196649);
      if ((TextUtils.isEmpty(str1)) || (!com.tencent.mm.plugin.offline.c.a.isNumeric(str1)))
      {
        Log.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        Log.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=".concat(String.valueOf(l1)));
        this.AIN.startTimer(l1 * 1000L);
        AppMethodBeat.o(66242);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", new Object[] { localException });
        continue;
        String str2 = com.tencent.mm.plugin.offline.c.a.eAt();
        Log.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is ".concat(String.valueOf(str2)));
        long l2 = Long.valueOf(localException).longValue();
        if (TextUtils.isEmpty(str2))
        {
          Log.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
        }
        else
        {
          l1 = Long.valueOf(str2).longValue();
          long l3 = System.currentTimeMillis() / 1000L;
          Log.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + l3 + ";");
          l1 = l2 - (l3 - l1);
        }
      }
    }
  }
  
  private static void TW(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(66249);
    boolean bool1 = com.tencent.mm.plugin.offline.c.a.isAppOnForeground(MMApplicationContext.getContext());
    boolean bool2 = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
    Object localObject = com.tencent.mm.plugin.report.service.h.CyF;
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
      if (k.AIX) {
        k = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(14163, new Object[] { Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(k) });
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
      if (!k.AIX) {
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
      if (!k.AIX) {
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
      com.tencent.mm.plugin.report.service.h.CyF.b((ArrayList)localObject, true);
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
        if (k.AIX)
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
  
  public static int ezm()
  {
    AppMethodBeat.i(66243);
    k.ezn();
    String str = k.TX(196617);
    com.tencent.mm.wallet_core.c.b.hhj();
    int i = com.tencent.mm.wallet_core.c.b.bpl(str);
    Log.i("MicroMsg.OfflineTokensMgr", "offline tokens count:".concat(String.valueOf(i)));
    AppMethodBeat.o(66243);
    return i;
  }
  
  public final void TV(final int paramInt)
  {
    AppMethodBeat.i(66246);
    if (ezm() > 2)
    {
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66240);
          i.this.hF(this.AIP, paramInt);
          AppMethodBeat.o(66240);
        }
      }, 3000L);
      AppMethodBeat.o(66246);
      return;
    }
    hF(2, paramInt);
    AppMethodBeat.o(66246);
  }
  
  public final void hE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66244);
    if ((NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) && (com.tencent.mm.plugin.offline.c.a.eAj()))
    {
      Log.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
      hF(paramInt1, paramInt2);
      AppMethodBeat.o(66244);
      return;
    }
    AppMethodBeat.o(66244);
  }
  
  public final void hF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66247);
    if (this.AIE)
    {
      AppMethodBeat.o(66247);
      return;
    }
    this.AIE = true;
    m localm = new m(System.currentTimeMillis() / 1000L, paramInt1, paramInt2);
    g.aAi();
    g.aAg().hqi.a(localm, 0);
    TW(paramInt1);
    AppMethodBeat.o(66247);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 6;
    AppMethodBeat.i(66248);
    if ((!(paramq instanceof com.tencent.mm.plugin.offline.a.h)) && (!(paramq instanceof f)))
    {
      AppMethodBeat.o(66248);
      return;
    }
    paramString = new ArrayList();
    if ((paramq instanceof m))
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
      com.tencent.mm.plugin.report.service.h.CyF.b(paramString, true);
    }
    if (((paramq instanceof f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      Log.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.AIK != null)
      {
        boolean bool = this.AIK.ezs();
        this.AIK = null;
        if ((bool) && (this.AIJ != null)) {
          this.AIJ.ezg();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof m))
      {
        this.AIH = 0;
        this.AIE = false;
        this.mHandler.removeCallbacks(this.AIL);
        this.AIK = ((m)paramq);
        paramString = this.AIK.AJO;
        k.ezn();
        paramString = new f(paramString, k.TX(196617));
        g.aAi();
        g.aAg().hqi.a(paramString, 0);
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramq instanceof l))
      {
        this.AIF = false;
        this.AII = ((l)paramq).AII;
        if (this.AIJ != null) {
          this.AIJ.ezg();
        }
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramq instanceof f)) {
        AppMethodBeat.o(66248);
      }
    }
    else if ((paramq instanceof m))
    {
      Log.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
      this.AIH += 1;
      this.AIE = false;
      if (paramInt2 == 411)
      {
        Log.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
        com.tencent.mm.plugin.offline.c.a.eAw();
        AppMethodBeat.o(66248);
        return;
      }
      if (this.AIH < this.AIG)
      {
        this.mHandler.removeCallbacks(this.AIL);
        paramInt1 = this.AIH - 1;
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
      this.mHandler.postDelayed(this.AIL, paramInt1 * 60 * 1000);
      AppMethodBeat.o(66248);
      return;
      if ((paramq instanceof l))
      {
        this.AIF = false;
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramq instanceof f)) {
        this.AIK = null;
      }
      AppMethodBeat.o(66248);
      return;
    }
  }
  
  public final boolean sx(boolean paramBoolean)
  {
    AppMethodBeat.i(66245);
    if (!com.tencent.mm.plugin.offline.c.a.eAj())
    {
      Log.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
      AppMethodBeat.o(66245);
      return false;
    }
    if (ezm() < k.AIY)
    {
      Log.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[] { Integer.valueOf(k.AIY) });
      com.tencent.mm.wallet_core.c.b.hhj();
      int i = com.tencent.mm.wallet_core.c.b.getLastError();
      if (i != 0)
      {
        Log.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + i + ", don't  doNetSceneToken");
        AppMethodBeat.o(66245);
        return false;
      }
      Log.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
      if (paramBoolean) {
        TV(9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        TV(2);
      }
    }
    if (com.tencent.mm.plugin.offline.c.a.eAG())
    {
      Log.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
      if (paramBoolean) {
        hF(5, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        hF(5, 5);
      }
    }
    if (!com.tencent.mm.plugin.offline.c.a.eAD())
    {
      Log.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
      if (paramBoolean) {
        hF(3, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        hF(3, 3);
      }
    }
    AppMethodBeat.o(66245);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void ezg();
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(66241);
      Log.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
      if (!g.aAf().azp())
      {
        Log.w("MicroMsg.OfflineTokensMgr", "account not init.");
        AppMethodBeat.o(66241);
        return;
      }
      i.this.hF(6, 6);
      AppMethodBeat.o(66241);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i
 * JD-Core Version:    0.7.0.1
 */