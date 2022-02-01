package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.yt;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class k
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static Map<String, String> gAE;
  public static boolean wNr;
  public static int wNs;
  private com.tencent.mm.vending.b.b jHu;
  private aq mHandler;
  private cf.a pgl;
  private com.tencent.mm.plugin.offline.a.s wNl;
  private e wNm;
  private i wNn;
  private com.tencent.mm.plugin.offline.b.a wNo;
  private com.tencent.mm.plugin.offline.ui.d wNp;
  public f wNq;
  private com.tencent.mm.sdk.b.c<yt> wNt;
  private com.tencent.mm.sdk.b.c<kt> wNu;
  private com.tencent.mm.sdk.b.c<no> wNv;
  private m wNw;
  private com.tencent.mm.sdk.b.c<ix> wNx;
  private com.tencent.mm.sdk.b.c<ap> wNy;
  
  static
  {
    AppMethodBeat.i(66271);
    wNr = false;
    wNs = 10;
    gAE = new HashMap();
    baseDBFactories = new HashMap();
    com.tencent.mm.wallet_core.a.i("OfflineBindCardRegProcess", d.class);
    com.tencent.mm.wallet_core.a.i("OfflineBindCardProcess", c.class);
    baseDBFactories.put(Integer.valueOf("OFFLINE_ORDER_STATUS".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.offline.b.a.SQL_CREATE;
      }
    });
    AppMethodBeat.o(66271);
  }
  
  public k()
  {
    AppMethodBeat.i(66261);
    this.wNl = null;
    this.wNm = null;
    this.wNn = null;
    this.wNo = null;
    this.wNp = new com.tencent.mm.plugin.offline.ui.d();
    this.wNq = new f();
    this.wNt = new com.tencent.mm.sdk.b.c() {};
    this.wNu = new com.tencent.mm.sdk.b.c() {};
    this.wNv = new com.tencent.mm.sdk.b.c() {};
    this.mHandler = new aq(Looper.getMainLooper());
    this.pgl = new cf.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(182491);
        final String str = z.a(paramAnonymousa.gte.FNI);
        ae.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:".concat(String.valueOf(str)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182490);
            com.tencent.mm.plugin.offline.a.s locals = k.dzH();
            String str2 = str;
            long l = paramAnonymousa.gte.xrk;
            ae.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :".concat(String.valueOf(l)));
            ae.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :".concat(String.valueOf(str2)));
            label160:
            String str1;
            Map localMap;
            if (!TextUtils.isEmpty(str2))
            {
              if ((locals.wLz == null) || (locals.wLz.size() == 0)) {
                ae.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
              }
              for (;;)
              {
                i = 0;
                if (i == 0) {
                  break;
                }
                ae.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:".concat(String.valueOf(l)));
                AppMethodBeat.o(182490);
                return;
                i = 0;
                for (;;)
                {
                  if (i >= locals.wLz.size()) {
                    break label160;
                  }
                  if (((Long)locals.wLz.get(i)).longValue() == l)
                  {
                    i = 1;
                    break;
                  }
                  i += 1;
                }
              }
              str1 = null;
              localMap = bx.M(str2, "sysmsg");
              if (localMap == null) {
                break label384;
              }
              str1 = (String)localMap.get(".sysmsg.paymsg.ack_key");
            }
            label384:
            for (int i = bu.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; i = -1)
            {
              if (com.tencent.mm.plugin.offline.c.a.dAZ())
              {
                ae.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", new Object[] { Integer.valueOf(i) });
                if ((i == 7) || (i == 10))
                {
                  locals.auQ(str2);
                  locals.auR(str2);
                }
              }
              for (;;)
              {
                if (locals.wLz.size() > 10) {
                  locals.wLz.remove(locals.wLz.size() - 1);
                }
                locals.wLz.add(0, Long.valueOf(l));
                AppMethodBeat.o(182490);
                return;
                if (g.ix(str1, str2))
                {
                  ae.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 70L, 1L, true);
                  locals.auQ(str2);
                  locals.auR(str2);
                  continue;
                  g.ix(str1, str2);
                  locals.auQ(str2);
                  locals.auR(str2);
                }
              }
            }
          }
        });
        AppMethodBeat.o(182491);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.wNx = new k.7(this);
    this.wNy = new k.8(this);
    AppMethodBeat.o(66261);
  }
  
  public static String MN(int paramInt)
  {
    AppMethodBeat.i(66269);
    com.tencent.mm.kernel.g.ajS();
    String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(paramInt, null);
    AppMethodBeat.o(66269);
    return str;
  }
  
  public static void bz(int paramInt, String paramString)
  {
    AppMethodBeat.i(66268);
    if (paramString != null)
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(paramInt, paramString);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().fuc();
    }
    AppMethodBeat.o(66268);
  }
  
  public static k dzG()
  {
    AppMethodBeat.i(66262);
    k localk = (k)u.ap(k.class);
    AppMethodBeat.o(66262);
    return localk;
  }
  
  public static com.tencent.mm.plugin.offline.a.s dzH()
  {
    AppMethodBeat.i(66265);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dzG().wNl == null) {
      dzG().wNl = new com.tencent.mm.plugin.offline.a.s();
    }
    com.tencent.mm.plugin.offline.a.s locals = dzG().wNl;
    AppMethodBeat.o(66265);
    return locals;
  }
  
  public static e dzI()
  {
    AppMethodBeat.i(66266);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dzG().wNm == null) {
      dzG().wNm = new e();
    }
    e locale = dzG().wNm;
    AppMethodBeat.o(66266);
    return locale;
  }
  
  public static i dzJ()
  {
    AppMethodBeat.i(66267);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (dzG().wNn == null) {
      dzG().wNn = new i();
    }
    i locali = dzG().wNn;
    AppMethodBeat.o(66267);
    return locali;
  }
  
  public static com.tencent.mm.plugin.offline.b.a dzK()
  {
    AppMethodBeat.i(66270);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(66270);
      throw ((Throwable)localObject);
    }
    if (dzG().wNo == null)
    {
      localObject = dzG();
      com.tencent.mm.kernel.g.ajS();
      ((k)localObject).wNo = new com.tencent.mm.plugin.offline.b.a(com.tencent.mm.kernel.g.ajR().gDX);
    }
    Object localObject = dzG().wNo;
    AppMethodBeat.o(66270);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(66263);
    wNs = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.ITZ, 10);
    ae.i("MicroMsg.SubCoreOffline", "init get token count: %s", new Object[] { Integer.valueOf(wNs) });
    this.jHu = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new k.5(this));
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("paymsg", this.pgl, true);
    com.tencent.mm.sdk.b.a.IvT.c(this.wNp);
    com.tencent.mm.sdk.b.a.IvT.c(this.wNt);
    this.wNx.alive();
    this.wNy.alive();
    this.wNu.alive();
    this.wNv.alive();
    this.wNl = null;
    this.wNm = null;
    this.wNn = null;
    this.wNw = new m();
    AppMethodBeat.o(66263);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66264);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("paymsg", this.pgl, true);
    com.tencent.mm.sdk.b.a.IvT.d(this.wNp);
    com.tencent.mm.sdk.b.a.IvT.d(this.wNt);
    this.wNx.dead();
    this.wNy.dead();
    this.wNu.dead();
    this.wNv.dead();
    if (this.wNw != null)
    {
      m localm = this.wNw;
      dzG();
      dzH().b(localm);
      com.tencent.mm.sdk.b.a.IvT.d(localm.vCZ);
    }
    this.wNw = null;
    this.jHu.dead();
    AppMethodBeat.o(66264);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k
 * JD-Core Version:    0.7.0.1
 */