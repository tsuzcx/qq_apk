package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.be.o;
import com.tencent.mm.f.a.abm;
import com.tencent.mm.f.a.zx;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.plugin.wallet_core.d.g;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class u
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ck.a EOX;
  private volatile y OSI;
  private com.tencent.mm.cw.h<ao> OSJ;
  private volatile ai OSK;
  private com.tencent.mm.cw.h<al> OSL;
  private com.tencent.mm.cw.h<k> OSM;
  private com.tencent.mm.cw.h<d> OSN;
  private com.tencent.mm.cw.h<com.tencent.mm.plugin.wallet_core.d.c> OSO;
  private com.tencent.mm.cw.h<com.tencent.mm.plugin.wallet_core.d.a> OSP;
  private com.tencent.mm.cw.h<g> OSQ;
  private com.tencent.mm.cw.h<com.tencent.mm.plugin.wallet_core.d.e> OSR;
  private ab OSS;
  private com.tencent.mm.cw.h<com.tencent.mm.plugin.wallet_core.d.f> OST;
  private com.tencent.mm.cw.h<com.tencent.mm.plugin.wallet_core.d.j> OSU;
  private com.tencent.mm.cw.h<i> OSV;
  private com.tencent.mm.cw.h<com.tencent.mm.plugin.wallet_core.d.h> OSW;
  private com.tencent.mm.plugin.wallet_core.id_verify.util.a OSX;
  private IListener OSY;
  private String OSZ;
  private IListener<zx> OTa;
  private IListener<abm> OTb;
  
  static
  {
    AppMethodBeat.i(70405);
    u.class.getClassLoader();
    com.tencent.mm.compatible.util.j.KW("tenpay_utils");
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
        return d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_BANKCARD_SCENE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.c.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new u.13());
    baseDBFactories.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return g.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.e.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new u.16());
    baseDBFactories.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.f.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new u.18());
    baseDBFactories.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new u.19());
    AppMethodBeat.o(70405);
  }
  
  public u()
  {
    AppMethodBeat.i(70383);
    this.OSI = new y();
    this.OSJ = new com.tencent.mm.cw.h(new com.tencent.mm.cw.c() {});
    this.OSK = null;
    this.OSL = new com.tencent.mm.cw.h(new com.tencent.mm.cw.c() {});
    this.OSM = new com.tencent.mm.cw.h(new com.tencent.mm.cw.c() {});
    this.OSN = new com.tencent.mm.cw.h(new com.tencent.mm.cw.c() {});
    this.OSO = new com.tencent.mm.cw.h(new com.tencent.mm.cw.c() {});
    this.OSP = new com.tencent.mm.cw.h(new u.23(this));
    this.OSQ = new com.tencent.mm.cw.h(new com.tencent.mm.cw.c() {});
    this.OSR = new com.tencent.mm.cw.h(new com.tencent.mm.cw.c() {});
    this.OSS = new ab();
    this.OST = new com.tencent.mm.cw.h(new u.26(this));
    this.OSU = new com.tencent.mm.cw.h(new u.2(this));
    this.OSV = new com.tencent.mm.cw.h(new u.3(this));
    this.OSW = new com.tencent.mm.cw.h(new u.4(this));
    this.OSX = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    this.OSY = new u.5(this);
    this.OSZ = "";
    this.OTa = new u.6(this);
    this.OTb = new IListener() {};
    this.EOX = new u.8(this);
    AppMethodBeat.o(70383);
  }
  
  public static boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame)
  {
    AppMethodBeat.i(70402);
    boolean bool = gJi().OSX.a(paramMMActivity, parame, 1008);
    AppMethodBeat.o(70402);
    return bool;
  }
  
  public static void az(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(70400);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (z.bdr())
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VqP, Integer.valueOf(0));
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VqQ, Integer.valueOf(0));
      localIntent.setFlags(536870912);
      Log.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
      com.tencent.mm.by.c.b(paramContext, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    if (z.bds())
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VqP, Integer.valueOf(0));
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VqQ, Integer.valueOf(0));
      localIntent.setFlags(536870912);
      com.tencent.mm.by.c.b(paramContext, "mall", ".ui.MallIndexOSUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    Log.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
    localIntent.setFlags(536870912);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHh, true);
    Log.i("MicroMsg.SubCoreWalletCore", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      com.tencent.mm.by.c.b(paramContext, "mall", ".ui.MallIndexUIv2", localIntent);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHH();
      if (com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
      {
        paramContext = new o(11);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(paramContext, 0);
      }
      AppMethodBeat.o(70400);
      return;
      com.tencent.mm.by.c.b(paramContext, "mall", ".ui.MallIndexUI", localIntent);
    }
  }
  
  public static boolean b(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, int paramInt)
  {
    AppMethodBeat.i(70403);
    boolean bool = gJi().OSX.a(paramMMActivity, parame, paramInt);
    AppMethodBeat.o(70403);
    return bool;
  }
  
  public static u gJi()
  {
    AppMethodBeat.i(70384);
    u localu = (u)com.tencent.mm.model.y.as(u.class);
    AppMethodBeat.o(70384);
    return localu;
  }
  
  public static k gJj()
  {
    AppMethodBeat.i(70385);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70385);
      throw ((Throwable)localObject);
    }
    Object localObject = (k)gJi().OSM.get();
    AppMethodBeat.o(70385);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.h gJk()
  {
    AppMethodBeat.i(70386);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70386);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.h)gJi().OSW.get();
    AppMethodBeat.o(70386);
    return localObject;
  }
  
  public static d gJl()
  {
    AppMethodBeat.i(70387);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70387);
      throw ((Throwable)localObject);
    }
    Object localObject = (d)gJi().OSN.get();
    AppMethodBeat.o(70387);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.c gJm()
  {
    AppMethodBeat.i(70388);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70388);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.c)gJi().OSO.get();
    AppMethodBeat.o(70388);
    return localObject;
  }
  
  public static i gJn()
  {
    AppMethodBeat.i(70389);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70389);
      throw ((Throwable)localObject);
    }
    Object localObject = (i)gJi().OSV.get();
    AppMethodBeat.o(70389);
    return localObject;
  }
  
  public static ao gJo()
  {
    AppMethodBeat.i(70390);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70390);
      throw ((Throwable)localObject);
    }
    Object localObject = (ao)gJi().OSJ.get();
    AppMethodBeat.o(70390);
    return localObject;
  }
  
  public static al gJp()
  {
    AppMethodBeat.i(70391);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70391);
      throw ((Throwable)localObject);
    }
    Object localObject = (al)gJi().OSL.get();
    AppMethodBeat.o(70391);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.a gJq()
  {
    AppMethodBeat.i(70392);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70392);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.a)gJi().OSP.get();
    AppMethodBeat.o(70392);
    return localObject;
  }
  
  public static g gJr()
  {
    AppMethodBeat.i(70393);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70393);
      throw ((Throwable)localObject);
    }
    Object localObject = (g)gJi().OSQ.get();
    AppMethodBeat.o(70393);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.e gJs()
  {
    AppMethodBeat.i(70394);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70394);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.e)gJi().OSR.get();
    AppMethodBeat.o(70394);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.f gJt()
  {
    AppMethodBeat.i(70395);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70395);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.f)gJi().OST.get();
    AppMethodBeat.o(70395);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.j gJu()
  {
    AppMethodBeat.i(70396);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70396);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.j)gJi().OSU.get();
    AppMethodBeat.o(70396);
    return localObject;
  }
  
  public static ai gJv()
  {
    AppMethodBeat.i(70397);
    ai localai = gJi().OSK;
    AppMethodBeat.o(70397);
    return localai;
  }
  
  public static y gJw()
  {
    AppMethodBeat.i(70401);
    y localy = gJi().OSI;
    AppMethodBeat.o(70401);
    return localy;
  }
  
  public static boolean gJx()
  {
    AppMethodBeat.i(70404);
    boolean bool = z.bdu();
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQT, 0);
    Log.i("MicroMsg.SubCoreWalletCore", "isSupportMobileRemit() isCN:%s mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((bool) && (i == 1))
    {
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
    Log.i("MicroMsg.SubCoreWalletCore", "onAccountPostReset subcore walletCore");
    com.tencent.mm.wallet_core.c.b.iiL().init(MMApplicationContext.getContext());
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("paymsg", this.EOX, true);
    gJo().gKe();
    this.OSK = ai.gJA();
    ai localai = this.OSK;
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("paymsg", localai.tUv, true);
    EventCenter.instance.add(this.OSY);
    EventCenter.instance.add(this.OSS);
    EventCenter.instance.add(this.OTb);
    EventCenter.instance.add(this.OTa);
    com.tencent.mm.pluginsdk.cmd.b.a(new u.a(), new String[] { "//cleanpaycn" });
    AppMethodBeat.o(70398);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(70399);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("paymsg", this.EOX, true);
    gJo().ate();
    Object localObject = gJp();
    ((al)localObject).OTQ = null;
    ((al)localObject).OTP.clear();
    ((al)localObject).OTP = new ArrayList();
    localObject = this.OSK;
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("paymsg", ((ai)localObject).tUv, true);
    if (ai.aeb != null) {
      ai.aeb.clear();
    }
    this.OSK = null;
    EventCenter.instance.removeListener(this.OSY);
    EventCenter.instance.removeListener(this.OSS);
    EventCenter.instance.removeListener(this.OTb);
    EventCenter.instance.removeListener(this.OTa);
    AppMethodBeat.o(70399);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.u
 * JD-Core Version:    0.7.0.1
 */