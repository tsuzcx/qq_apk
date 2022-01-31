package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class i
  implements com.tencent.mm.ah.f
{
  public ah mHandler = new ah();
  private boolean mKg = false;
  private boolean mKh = false;
  private int mKi = 10;
  private int mKj = 0;
  private String mKk = "";
  i.a mKl;
  private com.tencent.mm.plugin.offline.a.m mKm;
  public i.b mKn = new i.b(this, (byte)0);
  int mKo = 14400000;
  am mKp = new am(new i.1(this), false);
  
  public i()
  {
    try
    {
      com.tencent.mm.wallet_core.c.a.cMr();
      com.tencent.mm.wallet_core.c.a.init(ae.getContext());
      g.DQ();
      g.DO().dJT.a(385, this);
      k.bpX();
      Object localObject = k.vA(196649);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!com.tencent.mm.plugin.offline.c.a.yS((String)localObject)))
      {
        y.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        y.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=" + l1);
        localObject = this.mKp;
        l1 *= 1000L;
        ((am)localObject).S(l1, l1);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", new Object[] { localException });
        continue;
        String str = com.tencent.mm.plugin.offline.c.a.bqP();
        y.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is " + str);
        long l2 = Long.valueOf(localException).longValue();
        if (TextUtils.isEmpty(str))
        {
          y.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
        }
        else
        {
          l1 = Long.valueOf(str).longValue();
          long l3 = System.currentTimeMillis() / 1000L;
          y.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + l3 + ";");
          l1 = l2 - (l3 - l1);
        }
      }
    }
  }
  
  public static int bpW()
  {
    k.bpX();
    String str = k.vA(196617);
    com.tencent.mm.wallet_core.c.a.cMr();
    int i = com.tencent.mm.wallet_core.c.a.afd(str);
    y.i("MicroMsg.OfflineTokensMgr", "offline tokens count:" + i);
    return i;
  }
  
  public final void dx(int paramInt1, int paramInt2)
  {
    if ((aq.isNetworkConnected(ae.getContext())) && (com.tencent.mm.plugin.offline.c.a.bqH()))
    {
      y.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
      dy(paramInt1, paramInt2);
    }
  }
  
  public final void dy(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.mKg) {
      return;
    }
    this.mKg = true;
    Object localObject = new com.tencent.mm.plugin.offline.a.m(System.currentTimeMillis() / 1000L, paramInt1, paramInt2);
    g.DQ();
    g.DO().dJT.a((com.tencent.mm.ah.m)localObject, 0);
    boolean bool1 = com.tencent.mm.plugin.offline.c.a.dR(ae.getContext());
    boolean bool2 = aq.isNetworkConnected(ae.getContext());
    localObject = com.tencent.mm.plugin.report.service.h.nFQ;
    int i;
    if (bool1)
    {
      paramInt2 = 0;
      if (!bool2) {
        break label465;
      }
      i = 1;
      label99:
      if (k.mKz) {
        j = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).f(14163, new Object[] { Integer.valueOf(4), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(paramInt1), Integer.valueOf(j) });
      localObject = new ArrayList();
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool2) {
        break label470;
      }
      paramInt2 = 36;
      label204:
      localIDKey.SetKey(paramInt2);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool1) {
        break label476;
      }
      paramInt2 = 38;
      label249:
      localIDKey.SetKey(paramInt2);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!k.mKz) {
        break label482;
      }
      paramInt2 = 40;
      label295:
      localIDKey.SetKey(paramInt2);
      ((ArrayList)localObject).add(localIDKey);
      if (paramInt1 != 2) {
        break label506;
      }
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!k.mKz) {
        break label488;
      }
      paramInt1 = 42;
      label346:
      localIDKey.SetKey(paramInt1);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool1) {
        break label494;
      }
      paramInt1 = 44;
      label391:
      localIDKey.SetKey(paramInt1);
      ((ArrayList)localObject).add(localIDKey);
      localIDKey = new IDKey();
      localIDKey.SetID(135);
      localIDKey.SetValue(1L);
      if (!bool2) {
        break label500;
      }
      paramInt1 = 46;
      label436:
      localIDKey.SetKey(paramInt1);
      ((ArrayList)localObject).add(localIDKey);
    }
    label465:
    label470:
    label476:
    label482:
    label488:
    label494:
    label500:
    label506:
    do
    {
      com.tencent.mm.plugin.report.service.h.nFQ.b((ArrayList)localObject, true);
      return;
      paramInt2 = 1;
      break;
      i = 0;
      break label99;
      paramInt2 = 37;
      break label204;
      paramInt2 = 39;
      break label249;
      paramInt2 = 41;
      break label295;
      paramInt1 = 43;
      break label346;
      paramInt1 = 45;
      break label391;
      paramInt1 = 47;
      break label436;
      if (paramInt1 == 6)
      {
        localIDKey = new IDKey();
        localIDKey.SetID(135);
        localIDKey.SetValue(1L);
        if (k.mKz)
        {
          paramInt1 = 48;
          localIDKey.SetKey(paramInt1);
          ((ArrayList)localObject).add(localIDKey);
          localIDKey = new IDKey();
          localIDKey.SetID(135);
          localIDKey.SetValue(1L);
          if (!bool1) {
            break label657;
          }
          paramInt1 = 50;
          localIDKey.SetKey(paramInt1);
          ((ArrayList)localObject).add(localIDKey);
          localIDKey = new IDKey();
          localIDKey.SetID(135);
          localIDKey.SetValue(1L);
          if (!bool2) {
            break label663;
          }
        }
        for (paramInt1 = 52;; paramInt1 = 53)
        {
          localIDKey.SetKey(paramInt1);
          ((ArrayList)localObject).add(localIDKey);
          break;
          paramInt1 = 49;
          break label544;
          paramInt1 = 51;
          break label589;
        }
      }
    } while (paramInt1 != 6);
    label544:
    label589:
    IDKey localIDKey = new IDKey();
    label657:
    label663:
    localIDKey.SetID(135);
    localIDKey.SetValue(1L);
    if (bool1) {}
    for (paramInt1 = 54;; paramInt1 = 55)
    {
      localIDKey.SetKey(paramInt1);
      ((ArrayList)localObject).add(localIDKey);
      break;
    }
  }
  
  public final boolean hZ(boolean paramBoolean)
  {
    if (!com.tencent.mm.plugin.offline.c.a.bqH()) {
      y.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
    }
    do
    {
      return false;
      if (bpW() < k.mKA)
      {
        y.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", new Object[] { Integer.valueOf(k.mKA) });
        com.tencent.mm.wallet_core.c.a.cMr();
        int i = com.tencent.mm.wallet_core.c.a.getLastError();
        if (i != 0)
        {
          y.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + i + ", don't  doNetSceneToken");
          return false;
        }
        y.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
        if (paramBoolean) {
          vz(9);
        }
        for (;;)
        {
          return true;
          vz(2);
        }
      }
      if (com.tencent.mm.plugin.offline.c.a.brd())
      {
        y.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
        if (paramBoolean) {
          dy(5, 9);
        }
        for (;;)
        {
          return true;
          dy(5, 5);
        }
      }
    } while (com.tencent.mm.plugin.offline.c.a.bra());
    y.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
    if (paramBoolean) {
      dy(3, 9);
    }
    for (;;)
    {
      return true;
      dy(3, 3);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    int i = 6;
    if ((!(paramm instanceof com.tencent.mm.plugin.offline.a.h)) && (!(paramm instanceof com.tencent.mm.plugin.offline.a.f))) {}
    label353:
    do
    {
      do
      {
        do
        {
          return;
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
            com.tencent.mm.plugin.report.service.h.nFQ.b(paramString, true);
          }
          if (((paramm instanceof com.tencent.mm.plugin.offline.a.f)) && (((paramInt1 == 0) && (paramInt2 == 0)) || (paramInt1 != 0)))
          {
            y.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
            if (this.mKm != null)
            {
              boolean bool = this.mKm.bqe();
              this.mKm = null;
              if ((bool) && (this.mKl != null)) {
                this.mKl.bpR();
              }
            }
          }
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label353;
          }
          if ((paramm instanceof com.tencent.mm.plugin.offline.a.m))
          {
            this.mKj = 0;
            this.mKg = false;
            this.mHandler.removeCallbacks(this.mKn);
            this.mKm = ((com.tencent.mm.plugin.offline.a.m)paramm);
            paramString = this.mKm.mLm;
            k.bpX();
            paramString = new com.tencent.mm.plugin.offline.a.f(paramString, k.vA(196617));
            g.DQ();
            g.DO().dJT.a(paramString, 0);
            return;
          }
          if (!(paramm instanceof l)) {
            break;
          }
          this.mKh = false;
          this.mKk = ((l)paramm).mKk;
        } while (this.mKl == null);
        this.mKl.bpR();
        return;
      } while (!(paramm instanceof com.tencent.mm.plugin.offline.a.f));
      return;
      if (!(paramm instanceof com.tencent.mm.plugin.offline.a.m)) {
        break;
      }
      y.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
      this.mKj += 1;
      this.mKg = false;
      if (paramInt2 == 411)
      {
        y.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
        com.tencent.mm.plugin.offline.c.a.bqS();
        return;
      }
    } while (this.mKj >= this.mKi);
    this.mHandler.removeCallbacks(this.mKn);
    paramInt1 = this.mKj - 1;
    if (paramInt1 > 6) {
      paramInt1 = i;
    }
    for (;;)
    {
      paramInt1 = (int)Math.pow(2.0D, paramInt1);
      this.mHandler.postDelayed(this.mKn, paramInt1 * 60 * 1000);
      return;
      if ((paramm instanceof l))
      {
        this.mKh = false;
        return;
      }
      if (!(paramm instanceof com.tencent.mm.plugin.offline.a.f)) {
        break;
      }
      this.mKm = null;
      return;
    }
  }
  
  public final void vz(int paramInt)
  {
    if (bpW() > 2)
    {
      this.mHandler.postDelayed(new i.2(this, paramInt), 3000L);
      return;
    }
    dy(2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.i
 * JD-Core Version:    0.7.0.1
 */