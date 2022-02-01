package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.f.a.abf;
import com.tencent.mm.f.a.at;
import com.tencent.mm.f.a.kc;
import com.tencent.mm.f.a.ma;
import com.tencent.mm.f.a.pd;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class k
  implements be
{
  public static boolean GCg;
  public static int GCh;
  private static HashMap<Integer, h.b> baseDBFactories;
  private static Map<String, String> mMap;
  private s GCa;
  private e GCb;
  private i GCc;
  private com.tencent.mm.plugin.offline.b.a GCd;
  private com.tencent.mm.plugin.offline.ui.d GCe;
  public f GCf;
  private IListener<abf> GCi;
  private IListener<ma> GCj;
  private IListener<pd> GCk;
  private m GCl;
  private IListener<kc> GCm;
  private IListener<at> GCn;
  private MMHandler mHandler;
  private com.tencent.mm.vending.b.b nDk;
  private ck.a tUv;
  
  static
  {
    AppMethodBeat.i(66271);
    GCg = false;
    GCh = 10;
    mMap = new HashMap();
    baseDBFactories = new HashMap();
    com.tencent.mm.wallet_core.a.j("OfflineBindCardRegProcess", d.class);
    com.tencent.mm.wallet_core.a.j("OfflineBindCardProcess", c.class);
    baseDBFactories.put(Integer.valueOf("OFFLINE_ORDER_STATUS".hashCode()), new k.4());
    AppMethodBeat.o(66271);
  }
  
  public k()
  {
    AppMethodBeat.i(66261);
    this.GCa = null;
    this.GCb = null;
    this.GCc = null;
    this.GCd = null;
    this.GCe = new com.tencent.mm.plugin.offline.ui.d();
    this.GCf = new f();
    this.GCi = new IListener() {};
    this.GCj = new IListener() {};
    this.GCk = new IListener() {};
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.tUv = new ck.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(182491);
        final String str = z.a(paramAnonymousa.jQG.RIF);
        Log.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:".concat(String.valueOf(str)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182490);
            s locals = k.fkU();
            String str2 = str;
            long l = paramAnonymousa.jQG.HlH;
            Log.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :".concat(String.valueOf(l)));
            Log.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :".concat(String.valueOf(str2)));
            label160:
            String str1;
            Map localMap;
            if (!TextUtils.isEmpty(str2))
            {
              if ((locals.GAk == null) || (locals.GAk.size() == 0)) {
                Log.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
              }
              for (;;)
              {
                i = 0;
                if (i == 0) {
                  break;
                }
                Log.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:".concat(String.valueOf(l)));
                AppMethodBeat.o(182490);
                return;
                i = 0;
                for (;;)
                {
                  if (i >= locals.GAk.size()) {
                    break label160;
                  }
                  if (((Long)locals.GAk.get(i)).longValue() == l)
                  {
                    i = 1;
                    break;
                  }
                  i += 1;
                }
              }
              str1 = null;
              localMap = XmlParser.parseXml(str2, "sysmsg", null);
              if (localMap == null) {
                break label385;
              }
              str1 = (String)localMap.get(".sysmsg.paymsg.ack_key");
            }
            label385:
            for (int i = Util.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; i = -1)
            {
              if (com.tencent.mm.plugin.offline.c.a.fmp())
              {
                Log.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", new Object[] { Integer.valueOf(i) });
                if ((i == 7) || (i == 10))
                {
                  locals.aTy(str2);
                  locals.aTz(str2);
                }
              }
              for (;;)
              {
                if (locals.GAk.size() > 10) {
                  locals.GAk.remove(locals.GAk.size() - 1);
                }
                locals.GAk.add(0, Long.valueOf(l));
                AppMethodBeat.o(182490);
                return;
                if (g.jt(str1, str2))
                {
                  Log.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 70L, 1L, true);
                  locals.aTy(str2);
                  locals.aTz(str2);
                  continue;
                  g.jt(str1, str2);
                  locals.aTy(str2);
                  locals.aTz(str2);
                }
              }
            }
          }
        });
        AppMethodBeat.o(182491);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.GCm = new IListener() {};
    this.GCn = new IListener() {};
    AppMethodBeat.o(66261);
  }
  
  public static String aaK(int paramInt)
  {
    AppMethodBeat.i(66269);
    com.tencent.mm.kernel.h.aHH();
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(paramInt, null);
    AppMethodBeat.o(66269);
    return str;
  }
  
  public static void bL(int paramInt, String paramString)
  {
    AppMethodBeat.i(66268);
    if (paramString != null)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(paramInt, paramString);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().hxT();
    }
    AppMethodBeat.o(66268);
  }
  
  public static k fkT()
  {
    AppMethodBeat.i(66262);
    k localk = (k)y.as(k.class);
    AppMethodBeat.o(66262);
    return localk;
  }
  
  public static s fkU()
  {
    AppMethodBeat.i(66265);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fkT().GCa == null) {
      fkT().GCa = new s();
    }
    s locals = fkT().GCa;
    AppMethodBeat.o(66265);
    return locals;
  }
  
  public static e fkV()
  {
    AppMethodBeat.i(66266);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fkT().GCb == null) {
      fkT().GCb = new e();
    }
    e locale = fkT().GCb;
    AppMethodBeat.o(66266);
    return locale;
  }
  
  public static i fkW()
  {
    AppMethodBeat.i(66267);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (fkT().GCc == null) {
      fkT().GCc = new i();
    }
    i locali = fkT().GCc;
    AppMethodBeat.o(66267);
    return locali;
  }
  
  public static com.tencent.mm.plugin.offline.b.a fkX()
  {
    AppMethodBeat.i(66270);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(66270);
      throw ((Throwable)localObject);
    }
    if (fkT().GCd == null)
    {
      localObject = fkT();
      com.tencent.mm.kernel.h.aHH();
      ((k)localObject).GCd = new com.tencent.mm.plugin.offline.b.a(com.tencent.mm.kernel.h.aHG().kcF);
    }
    Object localObject = fkT().GCd;
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
    GCh = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vqq, 10);
    Log.i("MicroMsg.SubCoreOffline", "init get token count: %s", new Object[] { Integer.valueOf(GCh) });
    this.nDk = ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(182489);
        Log.i("MicroMsg.SubCoreOffline", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean) {
          k.fkW().iJ(7, 7);
        }
        AppMethodBeat.o(182489);
      }
      
      public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    });
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("paymsg", this.tUv, true);
    EventCenter.instance.addListener(this.GCe);
    EventCenter.instance.addListener(this.GCi);
    this.GCm.alive();
    this.GCn.alive();
    this.GCj.alive();
    this.GCk.alive();
    this.GCa = null;
    this.GCb = null;
    this.GCc = null;
    this.GCl = new m();
    AppMethodBeat.o(66263);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66264);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("paymsg", this.tUv, true);
    EventCenter.instance.removeListener(this.GCe);
    EventCenter.instance.removeListener(this.GCi);
    this.GCm.dead();
    this.GCn.dead();
    this.GCj.dead();
    this.GCk.dead();
    if (this.GCl != null)
    {
      m localm = this.GCl;
      fkT();
      fkU().b(localm);
      EventCenter.instance.removeListener(localm.ECh);
    }
    this.GCl = null;
    this.nDk.dead();
    AppMethodBeat.o(66264);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k
 * JD-Core Version:    0.7.0.1
 */