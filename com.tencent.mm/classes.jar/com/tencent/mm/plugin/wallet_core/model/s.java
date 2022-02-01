package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.l;
import com.tencent.mm.g.a.ws;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class s
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.cn.h<i> BzA;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.h> BzB;
  private com.tencent.mm.plugin.wallet_core.id_verify.util.a BzC;
  private com.tencent.mm.sdk.b.c BzD;
  private String BzE;
  private com.tencent.mm.sdk.b.c<ws> BzF;
  private com.tencent.mm.sdk.b.c<ya> BzG;
  private volatile w Bzn;
  private com.tencent.mm.cn.h<am> Bzo;
  private volatile ag Bzp;
  private com.tencent.mm.cn.h<aj> Bzq;
  private com.tencent.mm.cn.h<k> Bzr;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.d> Bzs;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.c> Bzt;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.a> Bzu;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.g> Bzv;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.e> Bzw;
  private z Bzx;
  private com.tencent.mm.cn.h<f> Bzy;
  private com.tencent.mm.cn.h<com.tencent.mm.plugin.wallet_core.d.j> Bzz;
  private cc.a uAT;
  
  static
  {
    AppMethodBeat.i(70405);
    s.class.getClassLoader();
    com.tencent.mm.compatible.util.j.sC("tenpay_utils");
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
    baseDBFactories.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.g.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.e.SQL_CREATE;
      }
    });
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
    baseDBFactories.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.h.SQL_CREATE;
      }
    });
    AppMethodBeat.o(70405);
  }
  
  public s()
  {
    AppMethodBeat.i(70383);
    this.Bzn = new w();
    this.Bzo = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.Bzp = null;
    this.Bzq = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.Bzr = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.Bzs = new com.tencent.mm.cn.h(new s.21(this));
    this.Bzt = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.Bzu = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.Bzv = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.Bzw = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.Bzx = new z();
    this.Bzy = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.Bzz = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.BzA = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.BzB = new com.tencent.mm.cn.h(new com.tencent.mm.cn.c() {});
    this.BzC = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    this.BzD = new s.5(this);
    this.BzE = "";
    this.BzF = new com.tencent.mm.sdk.b.c() {};
    this.BzG = new com.tencent.mm.sdk.b.c() {};
    this.uAT = new s.8(this);
    AppMethodBeat.o(70383);
  }
  
  public static boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame)
  {
    AppMethodBeat.i(70402);
    boolean bool = ers().BzC.a(paramMMActivity, parame, 1008);
    AppMethodBeat.o(70402);
    return bool;
  }
  
  public static void ab(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(70400);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (u.axM())
    {
      localIntent.setFlags(536870912);
      ac.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
      com.tencent.mm.br.d.b(paramContext, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    if (u.axN())
    {
      localIntent.setFlags(536870912);
      com.tencent.mm.br.d.b(paramContext, "mall", ".ui.MallIndexOSUI", localIntent);
      AppMethodBeat.o(70400);
      return;
    }
    ac.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
    localIntent.setFlags(536870912);
    com.tencent.mm.br.d.b(paramContext, "mall", ".ui.MallIndexUI", localIntent);
    com.tencent.mm.kernel.g.agS();
    if (com.tencent.mm.kernel.g.agR().isSDCardAvailable())
    {
      paramContext = new l(11);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(paramContext, 0);
    }
    AppMethodBeat.o(70400);
  }
  
  public static boolean b(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, int paramInt)
  {
    AppMethodBeat.i(70403);
    boolean bool = ers().BzC.a(paramMMActivity, parame, paramInt);
    AppMethodBeat.o(70403);
    return bool;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.a erA()
  {
    AppMethodBeat.i(70392);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70392);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.a)ers().Bzu.get();
    AppMethodBeat.o(70392);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.g erB()
  {
    AppMethodBeat.i(70393);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70393);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.g)ers().Bzv.get();
    AppMethodBeat.o(70393);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.e erC()
  {
    AppMethodBeat.i(70394);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70394);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.e)ers().Bzw.get();
    AppMethodBeat.o(70394);
    return localObject;
  }
  
  public static f erD()
  {
    AppMethodBeat.i(70395);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70395);
      throw ((Throwable)localObject);
    }
    Object localObject = (f)ers().Bzy.get();
    AppMethodBeat.o(70395);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.j erE()
  {
    AppMethodBeat.i(70396);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70396);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.j)ers().Bzz.get();
    AppMethodBeat.o(70396);
    return localObject;
  }
  
  public static ag erF()
  {
    AppMethodBeat.i(70397);
    ag localag = ers().Bzp;
    AppMethodBeat.o(70397);
    return localag;
  }
  
  public static w erG()
  {
    AppMethodBeat.i(70401);
    w localw = ers().Bzn;
    AppMethodBeat.o(70401);
    return localw;
  }
  
  public static boolean erH()
  {
    AppMethodBeat.i(70404);
    com.tencent.mm.kernel.g.agS();
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIP, Integer.valueOf(-1))).intValue();
    ac.i("MicroMsg.ConfigStorageLogic", "isCNPayWalletRegion() walletRegion:%s", new Object[] { Integer.valueOf(i) });
    if ((i == 0) || (i == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pYm, 0);
      ac.i("MicroMsg.SubCoreWalletCore", "isSupportMobileRemit() isCN:%s mobileRemitSwitch:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((!bool) || (i != 1)) {
        break;
      }
      AppMethodBeat.o(70404);
      return true;
    }
    AppMethodBeat.o(70404);
    return false;
  }
  
  public static s ers()
  {
    AppMethodBeat.i(70384);
    s locals = (s)t.ap(s.class);
    AppMethodBeat.o(70384);
    return locals;
  }
  
  public static k ert()
  {
    AppMethodBeat.i(70385);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70385);
      throw ((Throwable)localObject);
    }
    Object localObject = (k)ers().Bzr.get();
    AppMethodBeat.o(70385);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.h eru()
  {
    AppMethodBeat.i(70386);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70386);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.h)ers().BzB.get();
    AppMethodBeat.o(70386);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.d erv()
  {
    AppMethodBeat.i(70387);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70387);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.d)ers().Bzs.get();
    AppMethodBeat.o(70387);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.c erw()
  {
    AppMethodBeat.i(70388);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70388);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.c)ers().Bzt.get();
    AppMethodBeat.o(70388);
    return localObject;
  }
  
  public static i erx()
  {
    AppMethodBeat.i(70389);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70389);
      throw ((Throwable)localObject);
    }
    Object localObject = (i)ers().BzA.get();
    AppMethodBeat.o(70389);
    return localObject;
  }
  
  public static am ery()
  {
    AppMethodBeat.i(70390);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70390);
      throw ((Throwable)localObject);
    }
    Object localObject = (am)ers().Bzo.get();
    AppMethodBeat.o(70390);
    return localObject;
  }
  
  public static aj erz()
  {
    AppMethodBeat.i(70391);
    if (!com.tencent.mm.kernel.g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(70391);
      throw ((Throwable)localObject);
    }
    Object localObject = (aj)ers().Bzq.get();
    AppMethodBeat.o(70391);
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
    ac.i("MicroMsg.SubCoreWalletCore", "onAccountPostReset subcore walletCore");
    com.tencent.mm.wallet_core.c.b.fAg().init(ai.getContext());
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("paymsg", this.uAT, true);
    ery().eso();
    this.Bzp = ag.erK();
    ag localag = this.Bzp;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("paymsg", localag.owm, true);
    com.tencent.mm.sdk.b.a.GpY.b(this.BzD);
    com.tencent.mm.sdk.b.a.GpY.b(this.Bzx);
    com.tencent.mm.sdk.b.a.GpY.b(this.BzG);
    com.tencent.mm.sdk.b.a.GpY.b(this.BzF);
    com.tencent.mm.pluginsdk.cmd.b.a(new a(), new String[] { "//cleanpaycn" });
    AppMethodBeat.o(70398);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(70399);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("paymsg", this.uAT, true);
    ery().WN();
    Object localObject = erz();
    ((aj)localObject).BAw = null;
    ((aj)localObject).BAv.clear();
    ((aj)localObject).BAv = new ArrayList();
    localObject = this.Bzp;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("paymsg", ((ag)localObject).owm, true);
    if (ag.qyC != null) {
      ag.qyC.clear();
    }
    this.Bzp = null;
    com.tencent.mm.sdk.b.a.GpY.d(this.BzD);
    com.tencent.mm.sdk.b.a.GpY.d(this.Bzx);
    com.tencent.mm.sdk.b.a.GpY.d(this.BzG);
    com.tencent.mm.sdk.b.a.GpY.d(this.BzF);
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
      com.tencent.mm.wallet_core.c.b.fAg();
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