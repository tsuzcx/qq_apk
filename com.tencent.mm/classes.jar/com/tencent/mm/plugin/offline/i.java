package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.offline.a.f;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.ArrayList;

public final class i
  implements com.tencent.mm.an.i
{
  private boolean GBN;
  private boolean GBO;
  private int GBP;
  private int GBQ;
  private String GBR;
  a GBS;
  private m GBT;
  public b GBU;
  private int GBV;
  private MTimerHandler GBW;
  public MMHandler mHandler;
  
  public i()
  {
    AppMethodBeat.i(66242);
    this.GBN = false;
    this.GBO = false;
    this.GBP = 10;
    this.GBQ = 0;
    this.GBR = "";
    this.mHandler = new MMHandler();
    this.GBU = new b((byte)0);
    this.GBV = 14400000;
    this.GBW = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66239);
        if (!com.tencent.mm.kernel.h.aHB())
        {
          i.b(i.this).startTimer(i.a(i.this));
          AppMethodBeat.o(66239);
          return false;
        }
        i.this.iJ(5, 5);
        i.b(i.this).startTimer(i.c(i.this));
        AppMethodBeat.o(66239);
        return false;
      }
    }, false);
    try
    {
      com.tencent.mm.wallet_core.c.b.iiL().init(MMApplicationContext.getContext());
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(385, this);
      k.fkT();
      String str1 = k.aaK(196649);
      if ((TextUtils.isEmpty(str1)) || (!a.isNumeric(str1)))
      {
        Log.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        Log.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=".concat(String.valueOf(l1)));
        this.GBW.startTimer(l1 * 1000L);
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
        String str2 = a.flX();
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
  
  private static void aaJ(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(66249);
    boolean bool1 = a.isAppOnForeground(MMApplicationContext.getContext());
    boolean bool2 = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
    Object localObject = com.tencent.mm.plugin.report.service.h.IzE;
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
      if (k.GCg) {
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
      if (!k.GCg) {
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
      if (!k.GCg) {
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
      com.tencent.mm.plugin.report.service.h.IzE.b((ArrayList)localObject, true);
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
        if (k.GCg)
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
  
  public static void fkR()
  {
    AppMethodBeat.i(195998);
    k.fkT();
    String str = k.aaK(196617);
    com.tencent.mm.wallet_core.c.b.iiL();
    com.tencent.mm.wallet_core.c.b.clearToken(str);
    AppMethodBeat.o(195998);
  }
  
  public static int fkS()
  {
    AppMethodBeat.i(66243);
    k.fkT();
    String str = k.aaK(196617);
    com.tencent.mm.wallet_core.c.b.iiL();
    int i = com.tencent.mm.wallet_core.c.b.bCi(str);
    Log.i("MicroMsg.OfflineTokensMgr", "offline tokens count:".concat(String.valueOf(i)));
    AppMethodBeat.o(66243);
    return i;
  }
  
  public final void aaI(final int paramInt)
  {
    AppMethodBeat.i(66246);
    if (fkS() > 2)
    {
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66240);
          i.this.iK(this.GBY, paramInt);
          AppMethodBeat.o(66240);
        }
      }, 3000L);
      AppMethodBeat.o(66246);
      return;
    }
    iK(2, paramInt);
    AppMethodBeat.o(66246);
  }
  
  public final void iJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66244);
    if ((NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) && (a.flN()))
    {
      Log.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
      iK(paramInt1, paramInt2);
      AppMethodBeat.o(66244);
      return;
    }
    AppMethodBeat.o(66244);
  }
  
  public final void iK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66247);
    if (this.GBN)
    {
      AppMethodBeat.o(66247);
      return;
    }
    this.GBN = true;
    m localm = new m(System.currentTimeMillis() / 1000L, paramInt1, paramInt2);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(localm, 0);
    aaJ(paramInt1);
    AppMethodBeat.o(66247);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
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
      com.tencent.mm.plugin.report.service.h.IzE.b(paramString, true);
    }
    if (((paramq instanceof f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      Log.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.GBT != null)
      {
        boolean bool = this.GBT.fkY();
        this.GBT = null;
        if ((bool) && (this.GBS != null)) {
          this.GBS.fkL();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof m))
      {
        this.GBQ = 0;
        this.GBN = false;
        this.mHandler.removeCallbacks(this.GBU);
        this.GBT = ((m)paramq);
        paramString = this.GBT.GCW;
        k.fkT();
        paramString = new f(paramString, k.aaK(196617));
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramq instanceof l))
      {
        this.GBO = false;
        AppMethodBeat.o(66248);
        throw null;
      }
      if ((paramq instanceof f)) {
        AppMethodBeat.o(66248);
      }
    }
    else
    {
      if ((paramq instanceof m))
      {
        Log.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
        this.GBQ += 1;
        this.GBN = false;
        if (paramInt2 == 411)
        {
          Log.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
          a.fma();
          AppMethodBeat.o(66248);
          return;
        }
        if (this.GBQ < this.GBP)
        {
          this.mHandler.removeCallbacks(this.GBU);
          paramInt2 = this.GBQ - 1;
          paramInt1 = paramInt2;
          if (paramInt2 > 6) {
            paramInt1 = 6;
          }
          paramInt1 = (int)Math.pow(2.0D, paramInt1);
          this.mHandler.postDelayed(this.GBU, paramInt1 * 60 * 1000);
        }
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramq instanceof l))
      {
        this.GBO = false;
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramq instanceof f)) {
        this.GBT = null;
      }
    }
    AppMethodBeat.o(66248);
  }
  
  public final boolean vL(boolean paramBoolean)
  {
    AppMethodBeat.i(66245);
    if (!a.flN())
    {
      Log.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
      AppMethodBeat.o(66245);
      return false;
    }
    if (fkS() < k.GCh)
    {
      Log.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[] { Integer.valueOf(k.GCh) });
      com.tencent.mm.wallet_core.c.b.iiL();
      int i = com.tencent.mm.wallet_core.c.b.getLastError();
      if (i != 0)
      {
        Log.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + i + ", don't  doNetSceneToken");
        AppMethodBeat.o(66245);
        return false;
      }
      Log.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
      if (paramBoolean) {
        aaI(9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        aaI(2);
      }
    }
    if (a.fmk())
    {
      Log.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
      if (paramBoolean) {
        iK(5, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        iK(5, 5);
      }
    }
    if (!a.fmh())
    {
      Log.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
      if (paramBoolean) {
        iK(3, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        iK(3, 3);
      }
    }
    AppMethodBeat.o(66245);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void fkL();
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(66241);
      Log.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
      if (!com.tencent.mm.kernel.h.aHE().aGM())
      {
        Log.w("MicroMsg.OfflineTokensMgr", "account not init.");
        AppMethodBeat.o(66241);
        return;
      }
      i.this.iK(6, 6);
      AppMethodBeat.o(66241);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i
 * JD-Core Version:    0.7.0.1
 */