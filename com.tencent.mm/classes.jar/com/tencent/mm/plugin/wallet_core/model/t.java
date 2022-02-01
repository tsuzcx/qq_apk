package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.n;
import com.tencent.mm.g.a.aaf;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class t
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.co.h<ak> IaA;
  private com.tencent.mm.co.h<k> IaB;
  private com.tencent.mm.co.h<d> IaC;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.c> IaD;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.a> IaE;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.g> IaF;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.e> IaG;
  private aa IaH;
  private com.tencent.mm.co.h<f> IaI;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.j> IaJ;
  private com.tencent.mm.co.h<i> IaK;
  private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.h> IaL;
  private com.tencent.mm.plugin.wallet_core.id_verify.util.a IaM;
  private IListener IaN;
  private String IaO;
  private IListener<yq> IaP;
  private IListener<aaf> IaQ;
  private volatile x Iax;
  private com.tencent.mm.co.h<an> Iay;
  private volatile ah Iaz;
  private cj.a zjG;
  
  static
  {
    AppMethodBeat.i(70405);
    t.class.getClassLoader();
    com.tencent.mm.compatible.util.j.Ed("tenpay_utils");
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
    baseDBFactories.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new t.13());
    baseDBFactories.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.g.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new t.15());
    baseDBFactories.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new t.16());
    baseDBFactories.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return f.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new t.18());
    baseDBFactories.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new t.19());
    AppMethodBeat.o(70405);
  }
  
  public t()
  {
    AppMethodBeat.i(70383);
    this.Iax = new x();
    this.Iay = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.Iaz = null;
    this.IaA = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.IaB = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.IaC = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.IaD = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.IaE = new com.tencent.mm.co.h(new t.23(this));
    this.IaF = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.IaG = new com.tencent.mm.co.h(new t.25(this));
    this.IaH = new aa();
    this.IaI = new com.tencent.mm.co.h(new com.tencent.mm.co.c() {});
    this.IaJ = new com.tencent.mm.co.h(new t.2(this));
    this.IaK = new com.tencent.mm.co.h(new t.3(this));
    this.IaL = new com.tencent.mm.co.h(new t.4(this));
    this.IaM = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    this.IaN = new IListener() {};
    this.IaO = "";
    this.IaP = new t.6(this);
    this.IaQ = new t.7(this);
    this.zjG = new t.8(this);
    AppMethodBeat.o(70383);
  }
  
  public static boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame)
  {
    AppMethodBeat.i(70402);
    boolean bool = fQC().IaM.a(paramMMActivity, parame, 1008);
    AppMethodBeat.o(70402);
    return bool;
  }
  
  public static void aq(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(70400);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (z.aUp())
    {
      localIntent.setFlags(536870912);
      Log.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
      com.tencent.mm.br.c.b(paramContext, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    if (z.aUq())
    {
      localIntent.setFlags(536870912);
      com.tencent.mm.br.c.b(paramContext, "mall", ".ui.MallIndexOSUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    Log.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
    localIntent.setFlags(536870912);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sad, true);
    Log.i("MicroMsg.SubCoreWalletCore", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      com.tencent.mm.br.c.b(paramContext, "mall", ".ui.MallIndexUIv2", localIntent);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAi();
      if (com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
      {
        paramContext = new n(11);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(paramContext, 0);
      }
      AppMethodBeat.o(70400);
      return;
      com.tencent.mm.br.c.b(paramContext, "mall", ".ui.MallIndexUI", localIntent);
    }
  }
  
  public static boolean b(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, int paramInt)
  {
    AppMethodBeat.i(70403);
    boolean bool = fQC().IaM.a(paramMMActivity, parame, paramInt);
    AppMethodBeat.o(70403);
    return bool;
  }
  
  public static t fQC()
  {
    AppMethodBeat.i(70384);
    t localt = (t)y.at(t.class);
    AppMethodBeat.o(70384);
    return localt;
  }
  
  public static k fQD()
  {
    AppMethodBeat.i(70385);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70385);
      throw ((Throwable)localObject);
    }
    Object localObject = (k)fQC().IaB.get();
    AppMethodBeat.o(70385);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.h fQE()
  {
    AppMethodBeat.i(70386);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70386);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.h)fQC().IaL.get();
    AppMethodBeat.o(70386);
    return localObject;
  }
  
  public static d fQF()
  {
    AppMethodBeat.i(70387);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70387);
      throw ((Throwable)localObject);
    }
    Object localObject = (d)fQC().IaC.get();
    AppMethodBeat.o(70387);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.c fQG()
  {
    AppMethodBeat.i(70388);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70388);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.c)fQC().IaD.get();
    AppMethodBeat.o(70388);
    return localObject;
  }
  
  public static i fQH()
  {
    AppMethodBeat.i(70389);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70389);
      throw ((Throwable)localObject);
    }
    Object localObject = (i)fQC().IaK.get();
    AppMethodBeat.o(70389);
    return localObject;
  }
  
  public static an fQI()
  {
    AppMethodBeat.i(70390);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70390);
      throw ((Throwable)localObject);
    }
    Object localObject = (an)fQC().Iay.get();
    AppMethodBeat.o(70390);
    return localObject;
  }
  
  public static ak fQJ()
  {
    AppMethodBeat.i(70391);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70391);
      throw ((Throwable)localObject);
    }
    Object localObject = (ak)fQC().IaA.get();
    AppMethodBeat.o(70391);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.a fQK()
  {
    AppMethodBeat.i(70392);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70392);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.a)fQC().IaE.get();
    AppMethodBeat.o(70392);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.g fQL()
  {
    AppMethodBeat.i(70393);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70393);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.g)fQC().IaF.get();
    AppMethodBeat.o(70393);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.e fQM()
  {
    AppMethodBeat.i(70394);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70394);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.e)fQC().IaG.get();
    AppMethodBeat.o(70394);
    return localObject;
  }
  
  public static f fQN()
  {
    AppMethodBeat.i(70395);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70395);
      throw ((Throwable)localObject);
    }
    Object localObject = (f)fQC().IaI.get();
    AppMethodBeat.o(70395);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.j fQO()
  {
    AppMethodBeat.i(70396);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70396);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.j)fQC().IaJ.get();
    AppMethodBeat.o(70396);
    return localObject;
  }
  
  public static ah fQP()
  {
    AppMethodBeat.i(70397);
    ah localah = fQC().Iaz;
    AppMethodBeat.o(70397);
    return localah;
  }
  
  public static x fQQ()
  {
    AppMethodBeat.i(70401);
    x localx = fQC().Iax;
    AppMethodBeat.o(70401);
    return localx;
  }
  
  public static boolean fQR()
  {
    AppMethodBeat.i(70404);
    boolean bool = z.aUs();
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgT, 0);
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
    com.tencent.mm.wallet_core.c.b.hhj().init(MMApplicationContext.getContext());
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.zjG, true);
    fQI().fRy();
    this.Iaz = ah.fQU();
    ah localah = this.Iaz;
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", localah.qvw, true);
    EventCenter.instance.add(this.IaN);
    EventCenter.instance.add(this.IaH);
    EventCenter.instance.add(this.IaQ);
    EventCenter.instance.add(this.IaP);
    com.tencent.mm.pluginsdk.cmd.b.a(new t.a(), new String[] { "//cleanpaycn" });
    AppMethodBeat.o(70398);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(70399);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.zjG, true);
    fQI().and();
    Object localObject = fQJ();
    ((ak)localObject).IbE = null;
    ((ak)localObject).IbD.clear();
    ((ak)localObject).IbD = new ArrayList();
    localObject = this.Iaz;
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", ((ah)localObject).qvw, true);
    if (ah.eN != null) {
      ah.eN.clear();
    }
    this.Iaz = null;
    EventCenter.instance.removeListener(this.IaN);
    EventCenter.instance.removeListener(this.IaH);
    EventCenter.instance.removeListener(this.IaQ);
    EventCenter.instance.removeListener(this.IaP);
    AppMethodBeat.o(70399);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.t
 * JD-Core Version:    0.7.0.1
 */