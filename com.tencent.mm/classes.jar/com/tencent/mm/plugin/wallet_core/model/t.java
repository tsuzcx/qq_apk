package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class t
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private bz.a oxZ;
  private volatile v ukH;
  private com.tencent.mm.cm.h<am> ukI;
  private volatile ag ukJ;
  private com.tencent.mm.cm.h<aj> ukK;
  private com.tencent.mm.cm.h<j> ukL;
  private com.tencent.mm.cm.h<com.tencent.mm.plugin.wallet_core.d.c> ukM;
  private com.tencent.mm.cm.h<com.tencent.mm.plugin.wallet_core.d.a> ukN;
  private com.tencent.mm.cm.h<f> ukO;
  private com.tencent.mm.cm.h<com.tencent.mm.plugin.wallet_core.d.d> ukP;
  private z ukQ;
  private com.tencent.mm.cm.h<com.tencent.mm.plugin.wallet_core.d.e> ukR;
  private com.tencent.mm.cm.h<i> ukS;
  private com.tencent.mm.cm.h<com.tencent.mm.plugin.wallet_core.d.h> ukT;
  private com.tencent.mm.cm.h<com.tencent.mm.plugin.wallet_core.d.g> ukU;
  private com.tencent.mm.plugin.wallet_core.id_verify.util.a ukV;
  private com.tencent.mm.sdk.b.c ukW;
  private String ukX;
  private com.tencent.mm.sdk.b.c<ui> ukY;
  private com.tencent.mm.sdk.b.c<vp> ukZ;
  
  static
  {
    AppMethodBeat.i(46886);
    com.tencent.mm.compatible.util.k.a("tenpay_utils", t.class.getClassLoader());
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new t.9());
    baseDBFactories.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new t.10());
    baseDBFactories.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new t.11());
    baseDBFactories.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new t.13());
    baseDBFactories.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wallet_core.d.h.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new t.15());
    baseDBFactories.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new t.16());
    baseDBFactories.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new t.17());
    AppMethodBeat.o(46886);
  }
  
  public t()
  {
    AppMethodBeat.i(46866);
    this.ukH = new v();
    this.ukI = new com.tencent.mm.cm.h(new t.1(this));
    this.ukJ = null;
    this.ukK = new com.tencent.mm.cm.h(new t.12(this));
    this.ukL = new com.tencent.mm.cm.h(new t.18(this));
    this.ukM = new com.tencent.mm.cm.h(new t.19(this));
    this.ukN = new com.tencent.mm.cm.h(new t.20(this));
    this.ukO = new com.tencent.mm.cm.h(new t.21(this));
    this.ukP = new com.tencent.mm.cm.h(new t.22(this));
    this.ukQ = new z();
    this.ukR = new com.tencent.mm.cm.h(new t.23(this));
    this.ukS = new com.tencent.mm.cm.h(new t.24(this));
    this.ukT = new com.tencent.mm.cm.h(new t.2(this));
    this.ukU = new com.tencent.mm.cm.h(new t.3(this));
    this.ukV = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    this.ukW = new t.4(this);
    this.ukX = "";
    this.ukY = new t.5(this);
    this.ukZ = new t.6(this);
    this.oxZ = new bz.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(46856);
        paramAnonymousa = aa.a(paramAnonymousa.eyJ.woR);
        Map localMap = br.F(paramAnonymousa, "sysmsg");
        if (localMap == null)
        {
          AppMethodBeat.o(46856);
          return;
        }
        int i = bo.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        ab.i("MicroMsg.SubCoreWalletCore", "got a pay msg, type = ".concat(String.valueOf(i)));
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(46856);
          return;
          i = bo.getInt((String)localMap.get(".sysmsg.paymsg.WalletType"), -1);
          ab.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i)));
          if (i >= 0)
          {
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RL().Ru().set(339975, Integer.valueOf(i));
            AppMethodBeat.o(46856);
            return;
            i = bo.getInt((String)localMap.get(".sysmsg.paymsg.Flag"), 0);
            ab.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i)));
            if (i == 1)
            {
              ab.i("MicroMsg.SubCoreWalletCore", "open wallet");
              r.Zx();
              AppMethodBeat.o(46856);
              return;
            }
            if (i == 2)
            {
              ab.i("MicroMsg.SubCoreWalletCore", "close wallet");
              i = r.Zt();
              com.tencent.mm.kernel.g.RM();
              com.tencent.mm.kernel.g.RL().Ru().set(40, Integer.valueOf(i & 0xFFFF7FFF));
              AppMethodBeat.o(46856);
              return;
              ab.i("MicroMsg.SubCoreWalletCore", "receive c2c content update msg: %s", new Object[] { paramAnonymousa });
              com.tencent.mm.kernel.g.RM();
              com.tencent.mm.kernel.g.RO().ac(new t.7.1(this, localMap));
            }
          }
        }
      }
    };
    AppMethodBeat.o(46866);
  }
  
  public static void B(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(46882);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (r.ZC())
    {
      localIntent.setFlags(536870912);
      ab.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
      com.tencent.mm.bq.d.b(paramContext, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", localIntent);
      AppMethodBeat.o(46882);
      return;
    }
    if (r.ZD())
    {
      localIntent.setFlags(536870912);
      com.tencent.mm.bq.d.b(paramContext, "mall", ".ui.MallIndexOSUI", localIntent);
      AppMethodBeat.o(46882);
      return;
    }
    ab.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
    localIntent.setFlags(536870912);
    com.tencent.mm.bq.d.b(paramContext, "mall", ".ui.MallIndexUI", localIntent);
    com.tencent.mm.kernel.g.RM();
    if (com.tencent.mm.kernel.g.RL().isSDCardAvailable())
    {
      paramContext = new com.tencent.mm.ba.k(11);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(paramContext, 0);
    }
    AppMethodBeat.o(46882);
  }
  
  public static boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame)
  {
    AppMethodBeat.i(46884);
    boolean bool = cTI().ukV.a(paramMMActivity, parame, 1008);
    AppMethodBeat.o(46884);
    return bool;
  }
  
  public static boolean b(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame, int paramInt)
  {
    AppMethodBeat.i(142486);
    boolean bool = cTI().ukV.a(paramMMActivity, parame, paramInt);
    AppMethodBeat.o(142486);
    return bool;
  }
  
  public static t cTI()
  {
    AppMethodBeat.i(46867);
    t localt = (t)q.S(t.class);
    AppMethodBeat.o(46867);
    return localt;
  }
  
  public static j cTJ()
  {
    AppMethodBeat.i(46868);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(46868);
      throw ((Throwable)localObject);
    }
    Object localObject = (j)cTI().ukL.get();
    AppMethodBeat.o(46868);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.g cTK()
  {
    AppMethodBeat.i(46869);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(46869);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.g)cTI().ukU.get();
    AppMethodBeat.o(46869);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.c cTL()
  {
    AppMethodBeat.i(46870);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(46870);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.c)cTI().ukM.get();
    AppMethodBeat.o(46870);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.h cTM()
  {
    AppMethodBeat.i(46871);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(46871);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.h)cTI().ukT.get();
    AppMethodBeat.o(46871);
    return localObject;
  }
  
  public static am cTN()
  {
    AppMethodBeat.i(46872);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(46872);
      throw ((Throwable)localObject);
    }
    Object localObject = (am)cTI().ukI.get();
    AppMethodBeat.o(46872);
    return localObject;
  }
  
  public static aj cTO()
  {
    AppMethodBeat.i(46873);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(46873);
      throw ((Throwable)localObject);
    }
    Object localObject = (aj)cTI().ukK.get();
    AppMethodBeat.o(46873);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.a cTP()
  {
    AppMethodBeat.i(46874);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(46874);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.a)cTI().ukN.get();
    AppMethodBeat.o(46874);
    return localObject;
  }
  
  public static f cTQ()
  {
    AppMethodBeat.i(46875);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(46875);
      throw ((Throwable)localObject);
    }
    Object localObject = (f)cTI().ukO.get();
    AppMethodBeat.o(46875);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.d cTR()
  {
    AppMethodBeat.i(46876);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(46876);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.d)cTI().ukP.get();
    AppMethodBeat.o(46876);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.e cTS()
  {
    AppMethodBeat.i(46877);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(46877);
      throw ((Throwable)localObject);
    }
    Object localObject = (com.tencent.mm.plugin.wallet_core.d.e)cTI().ukR.get();
    AppMethodBeat.o(46877);
    return localObject;
  }
  
  public static i cTT()
  {
    AppMethodBeat.i(46878);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(46878);
      throw ((Throwable)localObject);
    }
    Object localObject = (i)cTI().ukS.get();
    AppMethodBeat.o(46878);
    return localObject;
  }
  
  public static ag cTU()
  {
    AppMethodBeat.i(46879);
    ag localag = cTI().ukJ;
    AppMethodBeat.o(46879);
    return localag;
  }
  
  public static v cTV()
  {
    AppMethodBeat.i(46883);
    v localv = cTI().ukH;
    AppMethodBeat.o(46883);
    return localv;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(46880);
    ab.i("MicroMsg.SubCoreWalletCore", "onAccountPostReset subcore walletCore");
    com.tencent.mm.wallet_core.c.b.dSi().init(ah.getContext());
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.oxZ, true);
    cTN().cUz();
    this.ukJ = ag.cTY();
    ag localag = this.ukJ;
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", localag.kMG, true);
    com.tencent.mm.sdk.b.a.ymk.b(this.ukW);
    com.tencent.mm.sdk.b.a.ymk.b(this.ukQ);
    com.tencent.mm.sdk.b.a.ymk.b(this.ukZ);
    com.tencent.mm.sdk.b.a.ymk.b(this.ukY);
    com.tencent.mm.pluginsdk.cmd.b.a(new t.a(), new String[] { "//cleanpaycn" });
    AppMethodBeat.o(46880);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(46881);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.oxZ, true);
    cTN().Kg();
    Object localObject = cTO();
    ((aj)localObject).ulI = null;
    ((aj)localObject).ulH.clear();
    ((aj)localObject).ulH = new ArrayList();
    localObject = this.ukJ;
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", ((ag)localObject).kMG, true);
    if (ag.mjj != null) {
      ag.mjj.clear();
    }
    this.ukJ = null;
    com.tencent.mm.sdk.b.a.ymk.d(this.ukW);
    com.tencent.mm.sdk.b.a.ymk.d(this.ukQ);
    com.tencent.mm.sdk.b.a.ymk.d(this.ukZ);
    com.tencent.mm.sdk.b.a.ymk.d(this.ukY);
    AppMethodBeat.o(46881);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.t
 * JD-Core Version:    0.7.0.1
 */