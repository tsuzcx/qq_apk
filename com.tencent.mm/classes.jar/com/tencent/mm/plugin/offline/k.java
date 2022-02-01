package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.autogen.a.adc;
import com.tencent.mm.autogen.a.ay;
import com.tencent.mm.autogen.a.lg;
import com.tencent.mm.autogen.a.ng;
import com.tencent.mm.autogen.a.qp;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.offline.a.u;
import com.tencent.mm.plugin.offline.ui.SyncOfflineTokenListener;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class k
  implements be
{
  public static boolean Myo;
  public static int Myp;
  private static HashMap<Integer, h.b> baseDBFactories;
  private static Map<String, String> mMap;
  private u Myi;
  private e Myj;
  private i Myk;
  private com.tencent.mm.plugin.offline.b.a Myl;
  private SyncOfflineTokenListener Mym;
  public f Myn;
  private IListener<adc> Myq;
  private IListener<ng> Myr;
  private IListener<qp> Mys;
  private m Myt;
  private IListener<lg> Myu;
  private IListener<ay> Myv;
  private MMHandler mHandler;
  private com.tencent.mm.vending.b.b qDd;
  private cl.a wXR;
  
  static
  {
    AppMethodBeat.i(66271);
    Myo = false;
    Myp = 10;
    mMap = new HashMap();
    baseDBFactories = new HashMap();
    com.tencent.mm.wallet_core.a.n("OfflineBindCardRegProcess", d.class);
    com.tencent.mm.wallet_core.a.n("OfflineBindCardProcess", c.class);
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
    this.Myi = null;
    this.Myj = null;
    this.Myk = null;
    this.Myl = null;
    this.Mym = new SyncOfflineTokenListener();
    this.Myn = new f();
    this.Myq = new SubCoreOffline.1(this, com.tencent.mm.app.f.hfK);
    this.Myr = new SubCoreOffline.2(this, com.tencent.mm.app.f.hfK);
    this.Mys = new SubCoreOffline.3(this, com.tencent.mm.app.f.hfK);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.wXR = new cl.a()
    {
      public final void a(final g.a paramAnonymousa)
      {
        AppMethodBeat.i(182491);
        final String str = w.a(paramAnonymousa.mpN.YFG);
        Log.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:".concat(String.valueOf(str)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182490);
            u localu = k.gvk();
            String str2 = str;
            long l = paramAnonymousa.mpN.Njv;
            Log.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :".concat(String.valueOf(l)));
            Log.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :".concat(String.valueOf(str2)));
            label160:
            String str1;
            Map localMap;
            if (!TextUtils.isEmpty(str2))
            {
              if ((localu.Mwu == null) || (localu.Mwu.size() == 0)) {
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
                  if (i >= localu.Mwu.size()) {
                    break label160;
                  }
                  if (((Long)localu.Mwu.get(i)).longValue() == l)
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
                break label436;
              }
              str1 = (String)localMap.get(".sysmsg.paymsg.ack_key");
            }
            label436:
            for (int i = Util.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; i = -1)
            {
              boolean bool1 = com.tencent.mm.plugin.offline.c.d.gxc();
              boolean bool2 = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).isUseCaseAlive("offline");
              if (bool1)
              {
                Log.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", new Object[] { Integer.valueOf(i) });
                if ((i == 7) || (i == 10))
                {
                  localu.aQB(str2);
                  localu.aQC(str2);
                }
              }
              for (;;)
              {
                if (localu.Mwu.size() > 10) {
                  localu.Mwu.remove(localu.Mwu.size() - 1);
                }
                localu.Mwu.add(0, Long.valueOf(l));
                AppMethodBeat.o(182490);
                return;
                if (bool2)
                {
                  localu.aQA(str2);
                }
                else if (g.kK(str1, str2))
                {
                  Log.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 70L, 1L, true);
                  localu.aQB(str2);
                  localu.aQC(str2);
                  continue;
                  if (bool2)
                  {
                    localu.aQA(str2);
                  }
                  else
                  {
                    g.kK(str1, str2);
                    localu.aQB(str2);
                    localu.aQC(str2);
                  }
                }
              }
            }
          }
        });
        AppMethodBeat.o(182491);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.Myu = new SubCoreOffline.7(this, com.tencent.mm.app.f.hfK);
    this.Myv = new SubCoreOffline.8(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(66261);
  }
  
  public static String afd(int paramInt)
  {
    AppMethodBeat.i(66269);
    com.tencent.mm.kernel.h.baF();
    String str = (String)com.tencent.mm.kernel.h.baE().ban().d(paramInt, null);
    AppMethodBeat.o(66269);
    return str;
  }
  
  public static void ct(int paramInt, String paramString)
  {
    AppMethodBeat.i(66268);
    if (paramString != null)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().B(paramInt, paramString);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().iZy();
    }
    AppMethodBeat.o(66268);
  }
  
  public static k gvj()
  {
    AppMethodBeat.i(66262);
    k localk = (k)y.aL(k.class);
    AppMethodBeat.o(66262);
    return localk;
  }
  
  public static u gvk()
  {
    AppMethodBeat.i(66265);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gvj().Myi == null) {
      gvj().Myi = new u();
    }
    u localu = gvj().Myi;
    AppMethodBeat.o(66265);
    return localu;
  }
  
  public static e gvl()
  {
    AppMethodBeat.i(66266);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gvj().Myj == null) {
      gvj().Myj = new e();
    }
    e locale = gvj().Myj;
    AppMethodBeat.o(66266);
    return locale;
  }
  
  public static i gvm()
  {
    AppMethodBeat.i(66267);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gvj().Myk == null) {
      gvj().Myk = new i();
    }
    i locali = gvj().Myk;
    AppMethodBeat.o(66267);
    return locali;
  }
  
  public static com.tencent.mm.plugin.offline.b.a gvn()
  {
    AppMethodBeat.i(66270);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(66270);
      throw ((Throwable)localObject);
    }
    if (gvj().Myl == null)
    {
      localObject = gvj();
      com.tencent.mm.kernel.h.baF();
      ((k)localObject).Myl = new com.tencent.mm.plugin.offline.b.a(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = gvj().Myl;
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
    Myp = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acRS, 10);
    Log.i("MicroMsg.SubCoreOffline", "init get token count: %s", new Object[] { Integer.valueOf(Myp) });
    this.qDd = ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b()
    {
      public final void onAuthResponse(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(182489);
        Log.i("MicroMsg.SubCoreOffline", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean) {
          k.gvm().kp(7, 7);
        }
        AppMethodBeat.o(182489);
      }
      
      public final void onRegResponse(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    });
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("paymsg", this.wXR, true);
    this.Mym.alive();
    this.Myq.alive();
    this.Myu.alive();
    this.Myv.alive();
    this.Myr.alive();
    this.Mys.alive();
    this.Myi = null;
    this.Myj = null;
    this.Myk = null;
    this.Myt = new m();
    AppMethodBeat.o(66263);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66264);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("paymsg", this.wXR, true);
    this.Mym.dead();
    this.Myq.dead();
    this.Myu.dead();
    this.Myv.dead();
    this.Myr.dead();
    this.Mys.dead();
    if (this.Myt != null)
    {
      m localm = this.Myt;
      gvj();
      gvk().b(localm);
      localm.Kvi.dead();
    }
    this.Myt = null;
    this.qDd.dead();
    AppMethodBeat.o(66264);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k
 * JD-Core Version:    0.7.0.1
 */