package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.g.a.xt;
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
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class k
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private static Map<String, String> gen;
  public static boolean vso;
  public static int vsp;
  private com.tencent.mm.vending.b.b jkF;
  private ao mHandler;
  private cc.a owm;
  private s vsi;
  private e vsj;
  private i vsk;
  private com.tencent.mm.plugin.offline.b.a vsl;
  private com.tencent.mm.plugin.offline.ui.d vsm;
  public f vsn;
  private com.tencent.mm.sdk.b.c<xt> vsq;
  private com.tencent.mm.sdk.b.c<kj> vsr;
  private com.tencent.mm.sdk.b.c<nf> vss;
  private m vst;
  private com.tencent.mm.sdk.b.c<io> vsu;
  private com.tencent.mm.sdk.b.c<ap> vsv;
  
  static
  {
    AppMethodBeat.i(66271);
    vso = false;
    vsp = 10;
    gen = new HashMap();
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
    this.vsi = null;
    this.vsj = null;
    this.vsk = null;
    this.vsl = null;
    this.vsm = new com.tencent.mm.plugin.offline.ui.d();
    this.vsn = new f();
    this.vsq = new com.tencent.mm.sdk.b.c() {};
    this.vsr = new com.tencent.mm.sdk.b.c() {};
    this.vss = new com.tencent.mm.sdk.b.c() {};
    this.mHandler = new ao(Looper.getMainLooper());
    this.owm = new cc.a()
    {
      public final void a(final f.a paramAnonymousa)
      {
        AppMethodBeat.i(182491);
        final String str = z.a(paramAnonymousa.fXi.DPV);
        ac.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:".concat(String.valueOf(str)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182490);
            s locals = k.dma();
            String str2 = str;
            long l = paramAnonymousa.fXi.vTQ;
            ac.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :".concat(String.valueOf(l)));
            ac.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :".concat(String.valueOf(str2)));
            label160:
            String str1;
            Map localMap;
            if (!TextUtils.isEmpty(str2))
            {
              if ((locals.vqw == null) || (locals.vqw.size() == 0)) {
                ac.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
              }
              for (;;)
              {
                i = 0;
                if (i == 0) {
                  break;
                }
                ac.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:".concat(String.valueOf(l)));
                AppMethodBeat.o(182490);
                return;
                i = 0;
                for (;;)
                {
                  if (i >= locals.vqw.size()) {
                    break label160;
                  }
                  if (((Long)locals.vqw.get(i)).longValue() == l)
                  {
                    i = 1;
                    break;
                  }
                  i += 1;
                }
              }
              str1 = null;
              localMap = bv.L(str2, "sysmsg");
              if (localMap == null) {
                break label384;
              }
              str1 = (String)localMap.get(".sysmsg.paymsg.ack_key");
            }
            label384:
            for (int i = bs.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; i = -1)
            {
              if (com.tencent.mm.plugin.offline.c.a.dnr())
              {
                ac.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", new Object[] { Integer.valueOf(i) });
                if ((i == 7) || (i == 10))
                {
                  locals.aoB(str2);
                  locals.aoC(str2);
                }
              }
              for (;;)
              {
                if (locals.vqw.size() > 10) {
                  locals.vqw.remove(locals.vqw.size() - 1);
                }
                locals.vqw.add(0, Long.valueOf(l));
                AppMethodBeat.o(182490);
                return;
                if (g.ig(str1, str2))
                {
                  ac.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
                  h.wUl.idkeyStat(135L, 70L, 1L, true);
                  locals.aoB(str2);
                  locals.aoC(str2);
                  continue;
                  g.ig(str1, str2);
                  locals.aoB(str2);
                  locals.aoC(str2);
                }
              }
            }
          }
        });
        AppMethodBeat.o(182491);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.vsu = new com.tencent.mm.sdk.b.c() {};
    this.vsv = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(66261);
  }
  
  public static String KG(int paramInt)
  {
    AppMethodBeat.i(66269);
    com.tencent.mm.kernel.g.agS();
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(paramInt, null);
    AppMethodBeat.o(66269);
    return str;
  }
  
  public static void bu(int paramInt, String paramString)
  {
    AppMethodBeat.i(66268);
    if (paramString != null)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(paramInt, paramString);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().faa();
    }
    AppMethodBeat.o(66268);
  }
  
  public static k dlZ()
  {
    AppMethodBeat.i(66262);
    k localk = (k)t.ap(k.class);
    AppMethodBeat.o(66262);
    return localk;
  }
  
  public static s dma()
  {
    AppMethodBeat.i(66265);
    com.tencent.mm.kernel.g.agP().afT();
    if (dlZ().vsi == null) {
      dlZ().vsi = new s();
    }
    s locals = dlZ().vsi;
    AppMethodBeat.o(66265);
    return locals;
  }
  
  public static e dmb()
  {
    AppMethodBeat.i(66266);
    com.tencent.mm.kernel.g.agP().afT();
    if (dlZ().vsj == null) {
      dlZ().vsj = new e();
    }
    e locale = dlZ().vsj;
    AppMethodBeat.o(66266);
    return locale;
  }
  
  public static i dmc()
  {
    AppMethodBeat.i(66267);
    com.tencent.mm.kernel.g.agP().afT();
    if (dlZ().vsk == null) {
      dlZ().vsk = new i();
    }
    i locali = dlZ().vsk;
    AppMethodBeat.o(66267);
    return locali;
  }
  
  public static com.tencent.mm.plugin.offline.b.a dmd()
  {
    AppMethodBeat.i(66270);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(66270);
      throw ((Throwable)localObject);
    }
    if (dlZ().vsl == null)
    {
      localObject = dlZ();
      com.tencent.mm.kernel.g.agS();
      ((k)localObject).vsl = new com.tencent.mm.plugin.offline.b.a(com.tencent.mm.kernel.g.agR().ghG);
    }
    Object localObject = dlZ().vsl;
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
    vsp = com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GNj, 10);
    ac.i("MicroMsg.SubCoreOffline", "init get token count: %s", new Object[] { Integer.valueOf(vsp) });
    this.jkF = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(182489);
        ac.i("MicroMsg.SubCoreOffline", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean) {
          k.dmc().gA(7, 7);
        }
        AppMethodBeat.o(182489);
      }
      
      public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    });
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("paymsg", this.owm, true);
    com.tencent.mm.sdk.b.a.GpY.c(this.vsm);
    com.tencent.mm.sdk.b.a.GpY.c(this.vsq);
    this.vsu.alive();
    this.vsv.alive();
    this.vsr.alive();
    this.vss.alive();
    this.vsi = null;
    this.vsj = null;
    this.vsk = null;
    this.vst = new m();
    AppMethodBeat.o(66263);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66264);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("paymsg", this.owm, true);
    com.tencent.mm.sdk.b.a.GpY.d(this.vsm);
    com.tencent.mm.sdk.b.a.GpY.d(this.vsq);
    this.vsu.dead();
    this.vsv.dead();
    this.vsr.dead();
    this.vss.dead();
    if (this.vst != null)
    {
      m localm = this.vst;
      dlZ();
      dma().b(localm);
      com.tencent.mm.sdk.b.a.GpY.d(localm.uoq);
    }
    this.vst = null;
    this.jkF.dead();
    AppMethodBeat.o(66264);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k
 * JD-Core Version:    0.7.0.1
 */