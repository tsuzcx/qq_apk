package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.l;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.g.a.xp;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class s
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private volatile w AgT;
  private com.tencent.mm.co.h<am> AgU;
  private volatile ag AgV;
  private com.tencent.mm.co.h<aj> AgW;
  private com.tencent.mm.co.h<k> AgX;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.d> AgY;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.c> AgZ;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.a> Aha;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.g> Ahb;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.e> Ahc;
  private z Ahd;
  private com.tencent.mm.co.h<f> Ahe;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.j> Ahf;
  private com.tencent.mm.co.h<i> Ahg;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.h> Ahh;
  private com.tencent.mm.plugin.wallet_core.id_verify.util.a Ahi;
  private com.tencent.mm.sdk.b.c Ahj;
  private String Ahk;
  private com.tencent.mm.sdk.b.c<wh> Ahl;
  private com.tencent.mm.sdk.b.c<xp> Ahm;
  private cc.a tsA;
  
  static
  {
    AppMethodBeat.i(70405);
    s.class.getClassLoader();
    com.tencent.mm.compatible.util.j.pq("tenpay_utils");
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return k.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_BANKCARD_SCENE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.c.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.a.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new s.14());
    baseDBFactories.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new s.15());
    baseDBFactories.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return i.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return f.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.j.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new s.19());
    AppMethodBeat.o(70405);
  }
  
  public s()
  {
    AppMethodBeat.i(70383);
    this.AgT = new w();
    this.AgU = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.AgV = null;
    this.AgW = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.AgX = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.AgY = new com.tencent.mm.co.h(new s.21(this));
    this.AgZ = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.Aha = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.Ahb = new com.tencent.mm.co.h(new s.24(this));
    this.Ahc = new com.tencent.mm.co.h(new s.25(this));
    this.Ahd = new z();
    this.Ahe = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.Ahf = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.Ahg = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.Ahh = new com.tencent.mm.co.h(new s.4(this));
    this.Ahi = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    this.Ahj = new s.5(this);
    this.Ahk = "";
    this.Ahl = new s.6(this);
    this.Ahm = new s.7(this);
    this.tsA = new s.8(this);
    AppMethodBeat.o(70383);
  }
  
  public static void N(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(70400);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (u.aqW())
    {
      localIntent.setFlags(536870912);
      ad.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
      com.tencent.mm.bs.d.b(paramContext, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    if (u.aqX())
    {
      localIntent.setFlags(536870912);
      com.tencent.mm.bs.d.b(paramContext, "mall", ".ui.MallIndexOSUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    ad.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
    localIntent.setFlags(536870912);
    com.tencent.mm.bs.d.b(paramContext, "mall", ".ui.MallIndexUI", localIntent);
    com.tencent.mm.kernel.g.afC();
    if (com.tencent.mm.kernel.g.afB().isSDCardAvailable())
    {
      paramContext = new l(11);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(paramContext, 0);
    }
    AppMethodBeat.o(70400);
  }
  
  public static boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame)
  {
    AppMethodBeat.i(70402);
    boolean bool = ebW().Ahi.a(paramMMActivity, parame, 1008);
    AppMethodBeat.o(70402);
    return bool;
  }
  
  public static boolean b(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, int paramInt)
  {
    AppMethodBeat.i(70403);
    boolean bool = ebW().Ahi.a(paramMMActivity, parame, paramInt);
    AppMethodBeat.o(70403);
    return bool;
  }
  
  public static s ebW()
  {
    AppMethodBeat.i(70384);
    s locals = (s)t.ap(s.class);
    AppMethodBeat.o(70384);
    return locals;
  }
  
  public static k ebX()
  {
    AppMethodBeat.i(70385);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70385);
      throw ((Throwable)localObject);
    }
    Object localObject = (k)ebW().AgX.get();
    AppMethodBeat.o(70385);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.h ebY()
  {
    AppMethodBeat.i(70386);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70386);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.h)ebW().Ahh.get();
    AppMethodBeat.o(70386);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.d ebZ()
  {
    AppMethodBeat.i(70387);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70387);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.d)ebW().AgY.get();
    AppMethodBeat.o(70387);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.c eca()
  {
    AppMethodBeat.i(70388);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70388);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.c)ebW().AgZ.get();
    AppMethodBeat.o(70388);
    return localObject;
  }
  
  public static i ecb()
  {
    AppMethodBeat.i(70389);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70389);
      throw ((Throwable)localObject);
    }
    Object localObject = (i)ebW().Ahg.get();
    AppMethodBeat.o(70389);
    return localObject;
  }
  
  public static am ecc()
  {
    AppMethodBeat.i(70390);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70390);
      throw ((Throwable)localObject);
    }
    Object localObject = (am)ebW().AgU.get();
    AppMethodBeat.o(70390);
    return localObject;
  }
  
  public static aj ecd()
  {
    AppMethodBeat.i(70391);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70391);
      throw ((Throwable)localObject);
    }
    Object localObject = (aj)ebW().AgW.get();
    AppMethodBeat.o(70391);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.a ece()
  {
    AppMethodBeat.i(70392);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70392);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.a)ebW().Aha.get();
    AppMethodBeat.o(70392);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.g ecf()
  {
    AppMethodBeat.i(70393);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70393);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.g)ebW().Ahb.get();
    AppMethodBeat.o(70393);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.e ecg()
  {
    AppMethodBeat.i(70394);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70394);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.e)ebW().Ahc.get();
    AppMethodBeat.o(70394);
    return localObject;
  }
  
  public static f ech()
  {
    AppMethodBeat.i(70395);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70395);
      throw ((Throwable)localObject);
    }
    Object localObject = (f)ebW().Ahe.get();
    AppMethodBeat.o(70395);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.j eci()
  {
    AppMethodBeat.i(70396);
    if (!com.tencent.mm.kernel.g.afw())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70396);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.j)ebW().Ahf.get();
    AppMethodBeat.o(70396);
    return localObject;
  }
  
  public static ag ecj()
  {
    AppMethodBeat.i(70397);
    ag localag = ebW().AgV;
    AppMethodBeat.o(70397);
    return localag;
  }
  
  public static w eck()
  {
    AppMethodBeat.i(70401);
    w localw = ebW().AgT;
    AppMethodBeat.o(70401);
    return localw;
  }
  
  public static boolean ecl()
  {
    AppMethodBeat.i(70404);
    com.tencent.mm.kernel.g.afC();
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fla, Integer.valueOf(-1))).intValue();
    ad.i("MicroMsg.ConfigStorageLogic", "isCNPayWalletRegion() walletRegion:%s", new Object[] { Integer.valueOf(i) });
    if ((i == 0) || (i == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ptY, 0);
      ad.i("MicroMsg.SubCoreWalletCore", "isSupportMobileRemit() isCN:%s mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((!bool) || (i != 1)) {
        break;
      }
      AppMethodBeat.o(70404);
      return true;
    }
    AppMethodBeat.o(70404);
    return false;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(70398);
    ad.i("MicroMsg.SubCoreWalletCore", "onAccountPostReset subcore walletCore");
    com.tencent.mm.wallet_core.c.b.fjR().init(com.tencent.mm.sdk.platformtools.aj.getContext());
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("paymsg", this.tsA, true);
    ecc().ecT();
    this.AgV = ag.eco();
    ag localag = this.AgV;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("paymsg", localag.nSR, true);
    com.tencent.mm.sdk.b.a.ESL.b(this.Ahj);
    com.tencent.mm.sdk.b.a.ESL.b(this.Ahd);
    com.tencent.mm.sdk.b.a.ESL.b(this.Ahm);
    com.tencent.mm.sdk.b.a.ESL.b(this.Ahl);
    com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[] { "//cleanpaycn" });
    AppMethodBeat.o(70398);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(70399);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("paymsg", this.tsA, true);
    ecc().VP();
    Object localObject = ecd();
    ((aj)localObject).Aic = null;
    ((aj)localObject).Aib.clear();
    ((aj)localObject).Aib = new ArrayList();
    localObject = this.AgV;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("paymsg", ((ag)localObject).nSR, true);
    if (ag.pPU != null) {
      ag.pPU.clear();
    }
    this.AgV = null;
    com.tencent.mm.sdk.b.a.ESL.d(this.Ahj);
    com.tencent.mm.sdk.b.a.ESL.d(this.Ahd);
    com.tencent.mm.sdk.b.a.ESL.d(this.Ahm);
    com.tencent.mm.sdk.b.a.ESL.d(this.Ahl);
    AppMethodBeat.o(70399);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  static final class a
    implements com.tencent.mm.pluginsdk.cmd.a
  {
    public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
    {
      AppMethodBeat.i(70382);
      paramContext = paramArrayOfString[0];
      int i = -1;
      switch (paramContext.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          AppMethodBeat.o(70382);
          return false;
          if (paramContext.equals("//cleanpaycn")) {
            i = 0;
          }
          break;
        }
      }
      com.tencent.mm.wallet_core.c.b.fjR();
      com.tencent.mm.wallet_core.c.b.clean();
      AppMethodBeat.o(70382);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.s
 * JD-Core Version:    0.7.0.1
 */