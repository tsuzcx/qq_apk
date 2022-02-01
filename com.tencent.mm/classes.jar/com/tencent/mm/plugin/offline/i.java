package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.offline.a.j;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.ArrayList;

public final class i
  implements com.tencent.mm.am.h
{
  private boolean MxW;
  private int MxX;
  private int MxY;
  private String MxZ;
  a Mya;
  private o Myb;
  public b Myc;
  private int Myd;
  private MTimerHandler Mye;
  public MMHandler mHandler;
  private boolean vWk;
  
  public i()
  {
    AppMethodBeat.i(66242);
    this.vWk = false;
    this.MxW = false;
    this.MxX = 10;
    this.MxY = 0;
    this.MxZ = "";
    this.mHandler = new MMHandler();
    this.Myc = new b((byte)0);
    this.Myd = 14400000;
    this.Mye = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(66239);
        if (!com.tencent.mm.kernel.h.baz())
        {
          i.b(i.this).startTimer(i.a(i.this));
          AppMethodBeat.o(66239);
          return false;
        }
        i.this.kp(5, 5);
        i.b(i.this).startTimer(i.c(i.this));
        AppMethodBeat.o(66239);
        return false;
      }
    }, false);
    try
    {
      com.tencent.mm.wallet_core.model.b.jOG().init(MMApplicationContext.getContext());
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(385, this);
      k.gvj();
      String str1 = k.afd(196649);
      if ((TextUtils.isEmpty(str1)) || (!d.isNumeric(str1)))
      {
        Log.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        Log.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=".concat(String.valueOf(l1)));
        this.Mye.startTimer(l1 * 1000L);
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
        String str2 = d.gwJ();
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
  
  private static void afc(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(66249);
    MMApplicationContext.getContext();
    boolean bool1 = d.gwX();
    boolean bool2 = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
    Object localObject = com.tencent.mm.plugin.report.service.h.OAn;
    int i;
    int j;
    if (bool1)
    {
      i = 0;
      if (!bool2) {
        break label412;
      }
      j = 1;
      label43:
      if (k.Myo) {
        k = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).b(14163, new Object[] { Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(k) });
      localObject = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool2) {
        break label417;
      }
      i = 36;
      label146:
      localIDKey.SetKey(i);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool1) {
        break label423;
      }
      i = 38;
      label191:
      localIDKey.SetKey(i);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!k.Myo) {
        break label429;
      }
      i = 40;
      label237:
      localIDKey.SetKey(i);
      ((ArrayList)localObject).add(localIDKey);
      if (paramInt != 2) {
        break label453;
      }
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!k.Myo) {
        break label435;
      }
      paramInt = 42;
      label288:
      localIDKey.SetKey(paramInt);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool1) {
        break label441;
      }
      paramInt = 44;
      label333:
      localIDKey.SetKey(paramInt);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool2) {
        break label447;
      }
      paramInt = 46;
      label378:
      localIDKey.SetKey(paramInt);
      ((ArrayList)localObject).add(localIDKey);
    }
    label412:
    label417:
    label423:
    label429:
    label435:
    label441:
    label447:
    label453:
    label491:
    do
    {
      com.tencent.mm.plugin.report.service.h.OAn.b((ArrayList)localObject, true);
      AppMethodBeat.o(66249);
      return;
      i = 1;
      break;
      j = 0;
      break label43;
      i = 37;
      break label146;
      i = 39;
      break label191;
      i = 41;
      break label237;
      paramInt = 43;
      break label288;
      paramInt = 45;
      break label333;
      paramInt = 47;
      break label378;
      if (paramInt == 6)
      {
        localIDKey = new IDKey();
        localIDKey.SetID(135);
        localIDKey.SetValue(1L);
        if (k.Myo)
        {
          paramInt = 48;
          localIDKey.SetKey(paramInt);
          ((ArrayList)localObject).add(localIDKey);
          localIDKey = new IDKey();
          localIDKey.SetID(135);
          localIDKey.SetValue(1L);
          if (!bool1) {
            break label604;
          }
          paramInt = 50;
          localIDKey.SetKey(paramInt);
          ((ArrayList)localObject).add(localIDKey);
          localIDKey = new IDKey();
          localIDKey.SetID(135);
          localIDKey.SetValue(1L);
          if (!bool2) {
            break label610;
          }
        }
        for (paramInt = 52;; paramInt = 53)
        {
          localIDKey.SetKey(paramInt);
          ((ArrayList)localObject).add(localIDKey);
          break;
          paramInt = 49;
          break label491;
          paramInt = 51;
          break label536;
        }
      }
    } while (paramInt != 6);
    label536:
    label604:
    label610:
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
  
  public static void dgR()
  {
    AppMethodBeat.i(269108);
    k.gvj();
    String str = k.afd(196617);
    com.tencent.mm.wallet_core.model.b.jOG();
    com.tencent.mm.wallet_core.model.b.clearToken(str);
    AppMethodBeat.o(269108);
  }
  
  public static int gvi()
  {
    AppMethodBeat.i(66243);
    k.gvj();
    String str = k.afd(196617);
    com.tencent.mm.wallet_core.model.b.jOG();
    int i = com.tencent.mm.wallet_core.model.b.bED(str);
    Log.i("MicroMsg.OfflineTokensMgr", "offline tokens count:".concat(String.valueOf(i)));
    AppMethodBeat.o(66243);
    return i;
  }
  
  public final boolean Ah(boolean paramBoolean)
  {
    AppMethodBeat.i(66245);
    if (!d.gwA())
    {
      Log.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
      AppMethodBeat.o(66245);
      return false;
    }
    if (gvi() < k.Myp)
    {
      Log.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[] { Integer.valueOf(k.Myp) });
      com.tencent.mm.wallet_core.model.b.jOG();
      int i = com.tencent.mm.wallet_core.model.b.getLastError();
      if (i != 0)
      {
        Log.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + i + ", don't  doNetSceneToken");
        AppMethodBeat.o(66245);
        return false;
      }
      Log.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
      if (paramBoolean) {
        afb(9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        afb(2);
      }
    }
    if (d.gwW())
    {
      Log.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
      if (paramBoolean) {
        kq(5, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        kq(5, 5);
      }
    }
    if (!d.gwT())
    {
      Log.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
      if (paramBoolean) {
        kq(3, 9);
      }
      for (;;)
      {
        AppMethodBeat.o(66245);
        return true;
        kq(3, 3);
      }
    }
    AppMethodBeat.o(66245);
    return false;
  }
  
  public final void afb(final int paramInt)
  {
    AppMethodBeat.i(66246);
    if (gvi() > 2)
    {
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66240);
          i.this.kq(this.Myg, paramInt);
          AppMethodBeat.o(66240);
        }
      }, 3000L);
      AppMethodBeat.o(66246);
      return;
    }
    kq(2, paramInt);
    AppMethodBeat.o(66246);
  }
  
  public final void kp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66244);
    if ((NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) && (d.gwA()))
    {
      Log.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
      kq(paramInt1, paramInt2);
      AppMethodBeat.o(66244);
      return;
    }
    AppMethodBeat.o(66244);
  }
  
  public final void kq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66247);
    if (this.vWk)
    {
      AppMethodBeat.o(66247);
      return;
    }
    Object localObject = com.tencent.mm.plugin.offline.a.b.MyA;
    if (com.tencent.mm.plugin.offline.a.b.gvo())
    {
      Log.w("MicroMsg.OfflineTokensMgr", "is doing setofflinepayment");
      AppMethodBeat.o(66247);
      return;
    }
    this.vWk = true;
    localObject = new o(System.currentTimeMillis() / 1000L, paramInt1, paramInt2);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
    afc(paramInt1);
    AppMethodBeat.o(66247);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 6;
    AppMethodBeat.i(66248);
    if ((!(paramp instanceof j)) && (!(paramp instanceof com.tencent.mm.plugin.offline.a.h)))
    {
      AppMethodBeat.o(66248);
      return;
    }
    paramString = new ArrayList();
    if ((paramp instanceof o))
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
      com.tencent.mm.plugin.report.service.h.OAn.b(paramString, true);
    }
    if (((paramp instanceof com.tencent.mm.plugin.offline.a.h)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
    {
      Log.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (this.Myb != null)
      {
        boolean bool = this.Myb.gvp();
        this.Myb = null;
        if ((bool) && (this.Mya != null)) {
          this.Mya.gvc();
        }
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof o))
      {
        this.MxY = 0;
        this.vWk = false;
        this.mHandler.removeCallbacks(this.Myc);
        this.Myb = ((o)paramp);
        if ((((o)paramp).gvp()) && (this.Mya != null)) {
          this.Mya.gvc();
        }
        AppMethodBeat.o(66248);
        return;
      }
      if ((paramp instanceof n))
      {
        this.MxW = false;
        AppMethodBeat.o(66248);
        throw null;
      }
      if ((paramp instanceof com.tencent.mm.plugin.offline.a.h)) {
        AppMethodBeat.o(66248);
      }
    }
    else if ((paramp instanceof o))
    {
      Log.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
      this.MxY += 1;
      this.vWk = false;
      if (paramInt2 == 411)
      {
        Log.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
        d.gwM();
        AppMethodBeat.o(66248);
        return;
      }
      if (paramInt2 == 268465326) {
        break label493;
      }
      if (this.MxY < this.MxX)
      {
        this.mHandler.removeCallbacks(this.Myc);
        paramInt1 = this.MxY - 1;
        if (paramInt1 <= 6) {
          break label500;
        }
        paramInt1 = i;
      }
    }
    label493:
    label500:
    for (;;)
    {
      paramInt1 = (int)Math.pow(2.0D, paramInt1);
      this.mHandler.postDelayed(this.Myc, paramInt1 * 60 * 1000);
      AppMethodBeat.o(66248);
      return;
      if ((paramp instanceof n)) {
        this.MxW = false;
      }
      AppMethodBeat.o(66248);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void gvc();
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(66241);
      Log.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
      if (!com.tencent.mm.kernel.h.baC().aZN())
      {
        Log.w("MicroMsg.OfflineTokensMgr", "account not init.");
        AppMethodBeat.o(66241);
        return;
      }
      i.this.kq(6, 6);
      AppMethodBeat.o(66241);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i
 * JD-Core Version:    0.7.0.1
 */