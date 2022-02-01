package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class k
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static Map<String, String> fZH;
  public static boolean ujs;
  public static int ujt;
  private com.tencent.mm.vending.b.b iKz;
  private ap mHandler;
  private cc.a nSR;
  private s ujm;
  private e ujn;
  private i ujo;
  private com.tencent.mm.plugin.offline.b.a ujp;
  private com.tencent.mm.plugin.offline.ui.d ujq;
  public f ujr;
  private com.tencent.mm.sdk.b.c<xi> uju;
  private com.tencent.mm.sdk.b.c<kb> ujv;
  private com.tencent.mm.sdk.b.c<mw> ujw;
  private m ujx;
  private com.tencent.mm.sdk.b.c<ih> ujy;
  private com.tencent.mm.sdk.b.c<ao> ujz;
  
  static
  {
    AppMethodBeat.i(66271);
    ujs = false;
    ujt = 10;
    fZH = new HashMap();
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
    this.ujm = null;
    this.ujn = null;
    this.ujo = null;
    this.ujp = null;
    this.ujq = new com.tencent.mm.plugin.offline.ui.d();
    this.ujr = new f();
    this.uju = new com.tencent.mm.sdk.b.c() {};
    this.ujv = new com.tencent.mm.sdk.b.c() {};
    this.ujw = new com.tencent.mm.sdk.b.c() {};
    this.mHandler = new ap(Looper.getMainLooper());
    this.nSR = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(182491);
        final String str = z.a(paramAnonymousa.fTo.Cxz);
        ad.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:".concat(String.valueOf(str)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182490);
            s locals = k.cYs();
            String str2 = str;
            long l = paramAnonymousa.fTo.uKZ;
            ad.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :".concat(String.valueOf(l)));
            ad.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :".concat(String.valueOf(str2)));
            label160:
            String str1;
            Map localMap;
            if (!TextUtils.isEmpty(str2))
            {
              if ((locals.uhy == null) || (locals.uhy.size() == 0)) {
                ad.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
              }
              for (;;)
              {
                i = 0;
                if (i == 0) {
                  break;
                }
                ad.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:".concat(String.valueOf(l)));
                AppMethodBeat.o(182490);
                return;
                i = 0;
                for (;;)
                {
                  if (i >= locals.uhy.size()) {
                    break label160;
                  }
                  if (((Long)locals.uhy.get(i)).longValue() == l)
                  {
                    i = 1;
                    break;
                  }
                  i += 1;
                }
              }
              str1 = null;
              localMap = bw.K(str2, "sysmsg");
              if (localMap == null) {
                break label384;
              }
              str1 = (String)localMap.get(".sysmsg.paymsg.ack_key");
            }
            label384:
            for (int i = bt.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; i = -1)
            {
              if (com.tencent.mm.plugin.offline.c.a.cZJ())
              {
                ad.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", new Object[] { Integer.valueOf(i) });
                if ((i == 7) || (i == 10))
                {
                  locals.ajD(str2);
                  locals.ajE(str2);
                }
              }
              for (;;)
              {
                if (locals.uhy.size() > 10) {
                  locals.uhy.remove(locals.uhy.size() - 1);
                }
                locals.uhy.add(0, Long.valueOf(l));
                AppMethodBeat.o(182490);
                return;
                if (g.hN(str1, str2))
                {
                  ad.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
                  h.vKh.idkeyStat(135L, 70L, 1L, true);
                  locals.ajD(str2);
                  locals.ajE(str2);
                  continue;
                  g.hN(str1, str2);
                  locals.ajD(str2);
                  locals.ajE(str2);
                }
              }
            }
          }
        });
        AppMethodBeat.o(182491);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.ujy = new com.tencent.mm.sdk.b.c() {};
    this.ujz = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(66261);
  }
  
  public static String IH(int paramInt)
  {
    AppMethodBeat.i(66269);
    com.tencent.mm.kernel.g.afC();
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(paramInt, null);
    AppMethodBeat.o(66269);
    return str;
  }
  
  public static void bp(int paramInt, String paramString)
  {
    AppMethodBeat.i(66268);
    if (paramString != null)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(paramInt, paramString);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().eKy();
    }
    AppMethodBeat.o(66268);
  }
  
  public static k cYr()
  {
    AppMethodBeat.i(66262);
    k localk = (k)t.ap(k.class);
    AppMethodBeat.o(66262);
    return localk;
  }
  
  public static s cYs()
  {
    AppMethodBeat.i(66265);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cYr().ujm == null) {
      cYr().ujm = new s();
    }
    s locals = cYr().ujm;
    AppMethodBeat.o(66265);
    return locals;
  }
  
  public static e cYt()
  {
    AppMethodBeat.i(66266);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cYr().ujn == null) {
      cYr().ujn = new e();
    }
    e locale = cYr().ujn;
    AppMethodBeat.o(66266);
    return locale;
  }
  
  public static i cYu()
  {
    AppMethodBeat.i(66267);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cYr().ujo == null) {
      cYr().ujo = new i();
    }
    i locali = cYr().ujo;
    AppMethodBeat.o(66267);
    return locali;
  }
  
  public static com.tencent.mm.plugin.offline.b.a cYv()
  {
    AppMethodBeat.i(66270);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(66270);
      throw ((Throwable)localObject);
    }
    if (cYr().ujp == null)
    {
      localObject = cYr();
      com.tencent.mm.kernel.g.afC();
      ((k)localObject).ujp = new com.tencent.mm.plugin.offline.b.a(com.tencent.mm.kernel.g.afB().gda);
    }
    Object localObject = cYr().ujp;
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
    ujt = com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.Fpt, 10);
    ad.i("MicroMsg.SubCoreOffline", "init get token count: %s", new Object[] { Integer.valueOf(ujt) });
    this.iKz = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(182489);
        ad.i("MicroMsg.SubCoreOffline", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean) {
          k.cYu().gt(7, 7);
        }
        AppMethodBeat.o(182489);
      }
      
      public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    });
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("paymsg", this.nSR, true);
    com.tencent.mm.sdk.b.a.ESL.c(this.ujq);
    com.tencent.mm.sdk.b.a.ESL.c(this.uju);
    this.ujy.alive();
    this.ujz.alive();
    this.ujv.alive();
    this.ujw.alive();
    this.ujm = null;
    this.ujn = null;
    this.ujo = null;
    this.ujx = new m();
    AppMethodBeat.o(66263);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66264);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("paymsg", this.nSR, true);
    com.tencent.mm.sdk.b.a.ESL.d(this.ujq);
    com.tencent.mm.sdk.b.a.ESL.d(this.uju);
    this.ujy.dead();
    this.ujz.dead();
    this.ujv.dead();
    this.ujw.dead();
    if (this.ujx != null)
    {
      m localm = this.ujx;
      cYr();
      cYs().b(localm);
      com.tencent.mm.sdk.b.a.ESL.d(localm.tgb);
    }
    this.ujx = null;
    this.iKz.dead();
    AppMethodBeat.o(66264);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k
 * JD-Core Version:    0.7.0.1
 */