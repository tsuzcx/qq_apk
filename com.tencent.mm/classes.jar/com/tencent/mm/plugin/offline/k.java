package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.g.a.yn;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class k
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static Map<String, String> gxX;
  public static boolean wxG;
  public static int wxH;
  private com.tencent.mm.vending.b.b jEv;
  private com.tencent.mm.sdk.platformtools.ap mHandler;
  private cd.a oZH;
  private s wxA;
  private e wxB;
  private i wxC;
  private com.tencent.mm.plugin.offline.b.a wxD;
  private com.tencent.mm.plugin.offline.ui.d wxE;
  public f wxF;
  private com.tencent.mm.sdk.b.c<yn> wxI;
  private com.tencent.mm.sdk.b.c<ks> wxJ;
  private com.tencent.mm.sdk.b.c<nn> wxK;
  private m wxL;
  private com.tencent.mm.sdk.b.c<iw> wxM;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.ap> wxN;
  
  static
  {
    AppMethodBeat.i(66271);
    wxG = false;
    wxH = 10;
    gxX = new HashMap();
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
    this.wxA = null;
    this.wxB = null;
    this.wxC = null;
    this.wxD = null;
    this.wxE = new com.tencent.mm.plugin.offline.ui.d();
    this.wxF = new f();
    this.wxI = new com.tencent.mm.sdk.b.c() {};
    this.wxJ = new com.tencent.mm.sdk.b.c() {};
    this.wxK = new com.tencent.mm.sdk.b.c() {};
    this.mHandler = new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper());
    this.oZH = new cd.a()
    {
      public final void a(final e.a paramAnonymousa)
      {
        AppMethodBeat.i(182491);
        final String str = z.a(paramAnonymousa.gqE.Fvk);
        ad.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:".concat(String.valueOf(str)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182490);
            s locals = k.dwr();
            String str2 = str;
            long l = paramAnonymousa.gqE.xbt;
            ad.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :".concat(String.valueOf(l)));
            ad.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :".concat(String.valueOf(str2)));
            label160:
            String str1;
            Map localMap;
            if (!TextUtils.isEmpty(str2))
            {
              if ((locals.wvO == null) || (locals.wvO.size() == 0)) {
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
                  if (i >= locals.wvO.size()) {
                    break label160;
                  }
                  if (((Long)locals.wvO.get(i)).longValue() == l)
                  {
                    i = 1;
                    break;
                  }
                  i += 1;
                }
              }
              str1 = null;
              localMap = bw.M(str2, "sysmsg");
              if (localMap == null) {
                break label384;
              }
              str1 = (String)localMap.get(".sysmsg.paymsg.ack_key");
            }
            label384:
            for (int i = bt.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; i = -1)
            {
              if (com.tencent.mm.plugin.offline.c.a.dxJ())
              {
                ad.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", new Object[] { Integer.valueOf(i) });
                if ((i == 7) || (i == 10))
                {
                  locals.atB(str2);
                  locals.atC(str2);
                }
              }
              for (;;)
              {
                if (locals.wvO.size() > 10) {
                  locals.wvO.remove(locals.wvO.size() - 1);
                }
                locals.wvO.add(0, Long.valueOf(l));
                AppMethodBeat.o(182490);
                return;
                if (g.ir(str1, str2))
                {
                  ad.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 70L, 1L, true);
                  locals.atB(str2);
                  locals.atC(str2);
                  continue;
                  g.ir(str1, str2);
                  locals.atB(str2);
                  locals.atC(str2);
                }
              }
            }
          }
        });
        AppMethodBeat.o(182491);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.wxM = new com.tencent.mm.sdk.b.c() {};
    this.wxN = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(66261);
  }
  
  public static String Mi(int paramInt)
  {
    AppMethodBeat.i(66269);
    com.tencent.mm.kernel.g.ajD();
    String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(paramInt, null);
    AppMethodBeat.o(66269);
    return str;
  }
  
  public static void bz(int paramInt, String paramString)
  {
    AppMethodBeat.i(66268);
    if (paramString != null)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(paramInt, paramString);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().fqc();
    }
    AppMethodBeat.o(66268);
  }
  
  public static k dwq()
  {
    AppMethodBeat.i(66262);
    k localk = (k)t.ap(k.class);
    AppMethodBeat.o(66262);
    return localk;
  }
  
  public static s dwr()
  {
    AppMethodBeat.i(66265);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dwq().wxA == null) {
      dwq().wxA = new s();
    }
    s locals = dwq().wxA;
    AppMethodBeat.o(66265);
    return locals;
  }
  
  public static e dws()
  {
    AppMethodBeat.i(66266);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dwq().wxB == null) {
      dwq().wxB = new e();
    }
    e locale = dwq().wxB;
    AppMethodBeat.o(66266);
    return locale;
  }
  
  public static i dwt()
  {
    AppMethodBeat.i(66267);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (dwq().wxC == null) {
      dwq().wxC = new i();
    }
    i locali = dwq().wxC;
    AppMethodBeat.o(66267);
    return locali;
  }
  
  public static com.tencent.mm.plugin.offline.b.a dwu()
  {
    AppMethodBeat.i(66270);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(66270);
      throw ((Throwable)localObject);
    }
    if (dwq().wxD == null)
    {
      localObject = dwq();
      com.tencent.mm.kernel.g.ajD();
      ((k)localObject).wxD = new com.tencent.mm.plugin.offline.b.a(com.tencent.mm.kernel.g.ajC().gBq);
    }
    Object localObject = dwq().wxD;
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
    wxH = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IzA, 10);
    ad.i("MicroMsg.SubCoreOffline", "init get token count: %s", new Object[] { Integer.valueOf(wxH) });
    this.jEv = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(182489);
        ad.i("MicroMsg.SubCoreOffline", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean) {
          k.dwt().gS(7, 7);
        }
        AppMethodBeat.o(182489);
      }
      
      public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    });
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("paymsg", this.oZH, true);
    com.tencent.mm.sdk.b.a.IbL.c(this.wxE);
    com.tencent.mm.sdk.b.a.IbL.c(this.wxI);
    this.wxM.alive();
    this.wxN.alive();
    this.wxJ.alive();
    this.wxK.alive();
    this.wxA = null;
    this.wxB = null;
    this.wxC = null;
    this.wxL = new m();
    AppMethodBeat.o(66263);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66264);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("paymsg", this.oZH, true);
    com.tencent.mm.sdk.b.a.IbL.d(this.wxE);
    com.tencent.mm.sdk.b.a.IbL.d(this.wxI);
    this.wxM.dead();
    this.wxN.dead();
    this.wxJ.dead();
    this.wxK.dead();
    if (this.wxL != null)
    {
      m localm = this.wxL;
      dwq();
      dwr().b(localm);
      com.tencent.mm.sdk.b.a.IbL.d(localm.vqU);
    }
    this.wxL = null;
    this.jEv.dead();
    AppMethodBeat.o(66264);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k
 * JD-Core Version:    0.7.0.1
 */