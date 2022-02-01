package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.abu;
import com.tencent.mm.autogen.a.adj;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelpackage.p;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.plugin.wallet_core.d.g;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class u
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cl.a KJv;
  private volatile y VIP;
  private com.tencent.mm.cp.h<am> VIQ;
  private volatile ag VIR;
  private com.tencent.mm.cp.h<aj> VIS;
  private com.tencent.mm.cp.h<com.tencent.mm.plugin.wallet_core.d.k> VIT;
  private com.tencent.mm.cp.h<d> VIU;
  private com.tencent.mm.cp.h<com.tencent.mm.plugin.wallet_core.d.c> VIV;
  private com.tencent.mm.cp.h<com.tencent.mm.plugin.wallet_core.d.a> VIW;
  private com.tencent.mm.cp.h<g> VIX;
  private com.tencent.mm.cp.h<com.tencent.mm.plugin.wallet_core.d.e> VIY;
  private WalletGetBulletinEventListener VIZ;
  private com.tencent.mm.cp.h<com.tencent.mm.plugin.wallet_core.d.f> VJa;
  private com.tencent.mm.cp.h<j> VJb;
  private com.tencent.mm.cp.h<i> VJc;
  private com.tencent.mm.cp.h<com.tencent.mm.plugin.wallet_core.d.h> VJd;
  private com.tencent.mm.plugin.wallet_core.id_verify.util.a VJe;
  private IListener VJf;
  private String VJg;
  private IListener<abu> VJh;
  private IListener<adj> VJi;
  
  static
  {
    AppMethodBeat.i(70405);
    u.class.getClassLoader();
    com.tencent.mm.compatible.util.k.DA("tenpay_utils");
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.k.SQL_CREATE;
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
    baseDBFactories.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.a.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new u.11());
    baseDBFactories.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.e.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new u.13());
    baseDBFactories.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.f.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new u.16());
    AppMethodBeat.o(70405);
  }
  
  public u()
  {
    AppMethodBeat.i(70383);
    this.VIP = new y();
    this.VIQ = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.VIR = null;
    this.VIS = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.VIT = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.VIU = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.VIV = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.VIW = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.VIX = new com.tencent.mm.cp.h(new u.21(this));
    this.VIY = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.VIZ = new WalletGetBulletinEventListener();
    this.VJa = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.VJb = new com.tencent.mm.cp.h(new com.tencent.mm.cp.c() {});
    this.VJc = new com.tencent.mm.cp.h(new u.3(this));
    this.VJd = new com.tencent.mm.cp.h(new u.4(this));
    this.VJe = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    this.VJf = new SubCoreWalletCore.13(this, com.tencent.mm.app.f.hfK);
    this.VJg = "";
    this.VJh = new SubCoreWalletCore.14(this, com.tencent.mm.app.f.hfK);
    this.VJi = new SubCoreWalletCore.15(this, com.tencent.mm.app.f.hfK);
    this.KJv = new u.5(this);
    AppMethodBeat.o(70383);
  }
  
  public static boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.c.e parame)
  {
    AppMethodBeat.i(70402);
    boolean bool = iiw().VJe.a(paramMMActivity, parame, 1008);
    AppMethodBeat.o(70402);
    return bool;
  }
  
  public static void aI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(70400);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (z.bBj())
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSr, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSs, Integer.valueOf(0));
      localIntent.setFlags(536870912);
      Log.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
      com.tencent.mm.br.c.b(paramContext, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    if (z.bBk())
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSr, Integer.valueOf(0));
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acSs, Integer.valueOf(0));
      localIntent.setFlags(536870912);
      com.tencent.mm.br.c.b(paramContext, "mall", ".ui.MallIndexOSUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    Log.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
    localIntent.setFlags(536870912);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXg, true);
    Log.i("MicroMsg.SubCoreWalletCore", " walletMallV2 switch is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {
      com.tencent.mm.br.c.b(paramContext, "mall", ".ui.MallIndexUIv2", localIntent);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baF();
      if (com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        paramContext = new p(11);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(paramContext, 0);
      }
      AppMethodBeat.o(70400);
      return;
      com.tencent.mm.br.c.b(paramContext, "mall", ".ui.MallIndexUI", localIntent);
    }
  }
  
  public static boolean b(MMActivity paramMMActivity, com.tencent.mm.wallet_core.c.e parame, int paramInt)
  {
    AppMethodBeat.i(70403);
    boolean bool = iiw().VJe.a(paramMMActivity, parame, paramInt);
    AppMethodBeat.o(70403);
    return bool;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.c iiA()
  {
    AppMethodBeat.i(70388);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70388);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.c)iiw().VIV.get();
    AppMethodBeat.o(70388);
    return localObject;
  }
  
  public static i iiB()
  {
    AppMethodBeat.i(70389);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70389);
      throw ((Throwable)localObject);
    }
    Object localObject = (i)iiw().VJc.get();
    AppMethodBeat.o(70389);
    return localObject;
  }
  
  public static am iiC()
  {
    AppMethodBeat.i(70390);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70390);
      throw ((Throwable)localObject);
    }
    Object localObject = (am)iiw().VIQ.get();
    AppMethodBeat.o(70390);
    return localObject;
  }
  
  public static aj iiD()
  {
    AppMethodBeat.i(70391);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70391);
      throw ((Throwable)localObject);
    }
    Object localObject = (aj)iiw().VIS.get();
    AppMethodBeat.o(70391);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.a iiE()
  {
    AppMethodBeat.i(70392);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70392);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.a)iiw().VIW.get();
    AppMethodBeat.o(70392);
    return localObject;
  }
  
  public static g iiF()
  {
    AppMethodBeat.i(70393);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70393);
      throw ((Throwable)localObject);
    }
    Object localObject = (g)iiw().VIX.get();
    AppMethodBeat.o(70393);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.e iiG()
  {
    AppMethodBeat.i(70394);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70394);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.e)iiw().VIY.get();
    AppMethodBeat.o(70394);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.f iiH()
  {
    AppMethodBeat.i(70395);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70395);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.f)iiw().VJa.get();
    AppMethodBeat.o(70395);
    return localObject;
  }
  
  public static j iiI()
  {
    AppMethodBeat.i(70396);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70396);
      throw ((Throwable)localObject);
    }
    Object localObject = (j)iiw().VJb.get();
    AppMethodBeat.o(70396);
    return localObject;
  }
  
  public static ag iiJ()
  {
    AppMethodBeat.i(70397);
    ag localag = iiw().VIR;
    AppMethodBeat.o(70397);
    return localag;
  }
  
  public static y iiK()
  {
    AppMethodBeat.i(70401);
    y localy = iiw().VIP;
    AppMethodBeat.o(70401);
    return localy;
  }
  
  public static boolean iiL()
  {
    AppMethodBeat.i(70404);
    boolean bool = z.bBm();
    Log.i("MicroMsg.SubCoreWalletCore", "isSupportMobileRemit() isCN:%s mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(1) });
    if (bool)
    {
      AppMethodBeat.o(70404);
      return true;
    }
    AppMethodBeat.o(70404);
    return false;
  }
  
  public static u iiw()
  {
    AppMethodBeat.i(70384);
    u localu = (u)com.tencent.mm.model.y.aL(u.class);
    AppMethodBeat.o(70384);
    return localu;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.k iix()
  {
    AppMethodBeat.i(70385);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70385);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.k)iiw().VIT.get();
    AppMethodBeat.o(70385);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.h iiy()
  {
    AppMethodBeat.i(70386);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70386);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.h)iiw().VJd.get();
    AppMethodBeat.o(70386);
    return localObject;
  }
  
  public static d iiz()
  {
    AppMethodBeat.i(70387);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70387);
      throw ((Throwable)localObject);
    }
    Object localObject = (d)iiw().VIU.get();
    AppMethodBeat.o(70387);
    return localObject;
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
    com.tencent.mm.wallet_core.model.b.jOG().init(MMApplicationContext.getContext());
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("paymsg", this.KJv, true);
    iiC().ijv();
    this.VIR = ag.iiO();
    ag localag = this.VIR;
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("paymsg", localag.wXR, true);
    this.VJf.alive();
    this.VIZ.alive();
    this.VJi.alive();
    this.VJh.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[] { "//cleanpaycn" });
    AppMethodBeat.o(70398);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(70399);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("paymsg", this.KJv, true);
    iiC().aNm();
    Object localObject = iiD();
    ((aj)localObject).VJW = null;
    ((aj)localObject).VJV.clear();
    ((aj)localObject).VJV = new ArrayList();
    localObject = this.VIR;
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("paymsg", ((ag)localObject).wXR, true);
    if (ag.zTV != null) {
      ag.zTV.clear();
    }
    this.VIR = null;
    this.VJf.dead();
    this.VIZ.dead();
    this.VJi.dead();
    this.VJh.dead();
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
      com.tencent.mm.wallet_core.model.b.jOG();
      com.tencent.mm.wallet_core.model.b.clean();
      AppMethodBeat.o(70382);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.u
 * JD-Core Version:    0.7.0.1
 */