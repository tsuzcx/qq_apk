package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.zy;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.de;
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
  implements bd
{
  public static boolean AIX;
  public static int AIY;
  private static HashMap<Integer, h.b> baseDBFactories;
  private static Map<String, String> mMap;
  private com.tencent.mm.plugin.offline.a.s AIR;
  private e AIS;
  private i AIT;
  private com.tencent.mm.plugin.offline.b.a AIU;
  private com.tencent.mm.plugin.offline.ui.d AIV;
  public f AIW;
  private IListener<zy> AIZ;
  private IListener<lj> AJa;
  private IListener<og> AJb;
  private m AJc;
  private IListener<jm> AJd;
  private IListener<ar> AJe;
  private com.tencent.mm.vending.b.b kJs;
  private MMHandler mHandler;
  private cj.a qvw;
  
  static
  {
    AppMethodBeat.i(66271);
    AIX = false;
    AIY = 10;
    mMap = new HashMap();
    baseDBFactories = new HashMap();
    com.tencent.mm.wallet_core.a.j("OfflineBindCardRegProcess", d.class);
    com.tencent.mm.wallet_core.a.j("OfflineBindCardProcess", c.class);
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
    this.AIR = null;
    this.AIS = null;
    this.AIT = null;
    this.AIU = null;
    this.AIV = new com.tencent.mm.plugin.offline.ui.d();
    this.AIW = new f();
    this.AIZ = new IListener() {};
    this.AJa = new IListener() {};
    this.AJb = new IListener() {};
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.qvw = new cj.a()
    {
      public final void a(final h.a paramAnonymousa)
      {
        AppMethodBeat.i(182491);
        final String str = z.a(paramAnonymousa.heO.KHn);
        Log.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:".concat(String.valueOf(str)));
        k.a(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(182490);
            com.tencent.mm.plugin.offline.a.s locals = k.ezo();
            String str2 = str;
            long l = paramAnonymousa.heO.Brn;
            Log.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :".concat(String.valueOf(l)));
            Log.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :".concat(String.valueOf(str2)));
            label160:
            String str1;
            Map localMap;
            if (!TextUtils.isEmpty(str2))
            {
              if ((locals.AHb == null) || (locals.AHb.size() == 0)) {
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
                  if (i >= locals.AHb.size()) {
                    break label160;
                  }
                  if (((Long)locals.AHb.get(i)).longValue() == l)
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
              if (com.tencent.mm.plugin.offline.c.a.eAL())
              {
                Log.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", new Object[] { Integer.valueOf(i) });
                if ((i == 7) || (i == 10))
                {
                  locals.aJc(str2);
                  locals.aJd(str2);
                }
              }
              for (;;)
              {
                if (locals.AHb.size() > 10) {
                  locals.AHb.remove(locals.AHb.size() - 1);
                }
                locals.AHb.add(0, Long.valueOf(l));
                AppMethodBeat.o(182490);
                return;
                if (g.ji(str1, str2))
                {
                  Log.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
                  h.CyF.idkeyStat(135L, 70L, 1L, true);
                  locals.aJc(str2);
                  locals.aJd(str2);
                  continue;
                  g.ji(str1, str2);
                  locals.aJc(str2);
                  locals.aJd(str2);
                }
              }
            }
          }
        });
        AppMethodBeat.o(182491);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.AJd = new IListener() {};
    this.AJe = new IListener() {};
    AppMethodBeat.o(66261);
  }
  
  public static String TX(int paramInt)
  {
    AppMethodBeat.i(66269);
    com.tencent.mm.kernel.g.aAi();
    String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(paramInt, null);
    AppMethodBeat.o(66269);
    return str;
  }
  
  public static void bN(int paramInt, String paramString)
  {
    AppMethodBeat.i(66268);
    if (paramString != null)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(paramInt, paramString);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().gBI();
    }
    AppMethodBeat.o(66268);
  }
  
  public static k ezn()
  {
    AppMethodBeat.i(66262);
    k localk = (k)y.at(k.class);
    AppMethodBeat.o(66262);
    return localk;
  }
  
  public static com.tencent.mm.plugin.offline.a.s ezo()
  {
    AppMethodBeat.i(66265);
    com.tencent.mm.kernel.g.aAf().azk();
    if (ezn().AIR == null) {
      ezn().AIR = new com.tencent.mm.plugin.offline.a.s();
    }
    com.tencent.mm.plugin.offline.a.s locals = ezn().AIR;
    AppMethodBeat.o(66265);
    return locals;
  }
  
  public static e ezp()
  {
    AppMethodBeat.i(66266);
    com.tencent.mm.kernel.g.aAf().azk();
    if (ezn().AIS == null) {
      ezn().AIS = new e();
    }
    e locale = ezn().AIS;
    AppMethodBeat.o(66266);
    return locale;
  }
  
  public static i ezq()
  {
    AppMethodBeat.i(66267);
    com.tencent.mm.kernel.g.aAf().azk();
    if (ezn().AIT == null) {
      ezn().AIT = new i();
    }
    i locali = ezn().AIT;
    AppMethodBeat.o(66267);
    return locali;
  }
  
  public static com.tencent.mm.plugin.offline.b.a ezr()
  {
    AppMethodBeat.i(66270);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(66270);
      throw ((Throwable)localObject);
    }
    if (ezn().AIU == null)
    {
      localObject = ezn();
      com.tencent.mm.kernel.g.aAi();
      ((k)localObject).AIU = new com.tencent.mm.plugin.offline.b.a(com.tencent.mm.kernel.g.aAh().hqK);
    }
    Object localObject = ezn().AIU;
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
    AIY = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Ocn, 10);
    Log.i("MicroMsg.SubCoreOffline", "init get token count: %s", new Object[] { Integer.valueOf(AIY) });
    this.kJs = ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(182489);
        Log.i("MicroMsg.SubCoreOffline", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean) {
          k.ezq().hE(7, 7);
        }
        AppMethodBeat.o(182489);
      }
      
      public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    });
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("paymsg", this.qvw, true);
    EventCenter.instance.addListener(this.AIV);
    EventCenter.instance.addListener(this.AIZ);
    this.AJd.alive();
    this.AJe.alive();
    this.AJa.alive();
    this.AJb.alive();
    this.AIR = null;
    this.AIS = null;
    this.AIT = null;
    this.AJc = new m();
    AppMethodBeat.o(66263);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(66264);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("paymsg", this.qvw, true);
    EventCenter.instance.removeListener(this.AIV);
    EventCenter.instance.removeListener(this.AIZ);
    this.AJd.dead();
    this.AJe.dead();
    this.AJa.dead();
    this.AJb.dead();
    if (this.AJc != null)
    {
      m localm = this.AJc;
      ezn();
      ezo().b(localm);
      EventCenter.instance.removeListener(localm.yYb);
    }
    this.AJc = null;
    this.kJs.dead();
    AppMethodBeat.o(66264);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k
 * JD-Core Version:    0.7.0.1
 */