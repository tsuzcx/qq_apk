package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.sp;
import com.tencent.mm.h.a.tt;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class o
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private bx.a lYu = new o.7(this);
  private volatile q qxY = new q();
  private com.tencent.mm.ck.h<ag> qxZ = new com.tencent.mm.ck.h(new o.1(this));
  private volatile aa qya = null;
  private com.tencent.mm.ck.h<ad> qyb = new com.tencent.mm.ck.h(new o.12(this));
  private com.tencent.mm.ck.h<j> qyc = new com.tencent.mm.ck.h(new o.18(this));
  private com.tencent.mm.ck.h<com.tencent.mm.plugin.wallet_core.d.c> qyd = new com.tencent.mm.ck.h(new o.19(this));
  private com.tencent.mm.ck.h<com.tencent.mm.plugin.wallet_core.d.a> qye = new com.tencent.mm.ck.h(new com.tencent.mm.ck.c() {});
  private com.tencent.mm.ck.h<f> qyf = new com.tencent.mm.ck.h(new com.tencent.mm.ck.c() {});
  private com.tencent.mm.ck.h<com.tencent.mm.plugin.wallet_core.d.d> qyg = new com.tencent.mm.ck.h(new com.tencent.mm.ck.c() {});
  private u qyh = new u();
  private com.tencent.mm.ck.h<com.tencent.mm.plugin.wallet_core.d.e> qyi = new com.tencent.mm.ck.h(new o.23(this));
  private com.tencent.mm.ck.h<i> qyj = new com.tencent.mm.ck.h(new o.24(this));
  private com.tencent.mm.ck.h<com.tencent.mm.plugin.wallet_core.d.h> qyk = new com.tencent.mm.ck.h(new o.2(this));
  private com.tencent.mm.ck.h<com.tencent.mm.plugin.wallet_core.d.g> qyl = new com.tencent.mm.ck.h(new o.3(this));
  private com.tencent.mm.plugin.wallet_core.id_verify.util.a qym = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
  private com.tencent.mm.sdk.b.c qyn = new o.4(this);
  private String qyo = "";
  private com.tencent.mm.sdk.b.c<sp> qyp = new o.5(this);
  private com.tencent.mm.sdk.b.c<tt> qyq = new o.6(this);
  
  static
  {
    com.tencent.mm.compatible.util.k.b("tenpay_utils", o.class.getClassLoader());
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new o.8());
    dgp.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new o.9());
    dgp.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new o.10());
    dgp.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new o.11());
    dgp.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new o.13());
    dgp.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new o.14());
    dgp.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new o.15());
    dgp.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new o.16());
    dgp.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new o.17());
  }
  
  public static boolean a(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame)
  {
    return bVn().qym.a(paramMMActivity, parame, 1008);
  }
  
  public static boolean b(MMActivity paramMMActivity, com.tencent.mm.wallet_core.d.e parame)
  {
    return bVn().qym.a(paramMMActivity, parame, 1006);
  }
  
  public static q bVA()
  {
    return bVn().qxY;
  }
  
  public static o bVn()
  {
    return (o)com.tencent.mm.model.p.B(o.class);
  }
  
  public static j bVo()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    return (j)bVn().qyc.get();
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.g bVp()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    return (com.tencent.mm.plugin.wallet_core.d.g)bVn().qyl.get();
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.c bVq()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    return (com.tencent.mm.plugin.wallet_core.d.c)bVn().qyd.get();
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.h bVr()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    return (com.tencent.mm.plugin.wallet_core.d.h)bVn().qyk.get();
  }
  
  public static ag bVs()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    return (ag)bVn().qxZ.get();
  }
  
  public static ad bVt()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    return (ad)bVn().qyb.get();
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.a bVu()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    return (com.tencent.mm.plugin.wallet_core.d.a)bVn().qye.get();
  }
  
  public static f bVv()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    return (f)bVn().qyf.get();
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.d bVw()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    return (com.tencent.mm.plugin.wallet_core.d.d)bVn().qyg.get();
  }
  
  public static com.tencent.mm.plugin.wallet_core.d.e bVx()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    return (com.tencent.mm.plugin.wallet_core.d.e)bVn().qyi.get();
  }
  
  public static i bVy()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    return (i)bVn().qyj.get();
  }
  
  public static aa bVz()
  {
    return bVn().qya;
  }
  
  public static void v(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (com.tencent.mm.model.q.Gx())
    {
      localIntent.setFlags(536870912);
      y.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
      com.tencent.mm.br.d.b(paramContext, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", localIntent);
    }
    do
    {
      return;
      if (com.tencent.mm.model.q.Gy())
      {
        localIntent.setFlags(536870912);
        com.tencent.mm.br.d.b(paramContext, "mall", ".ui.MallIndexOSUI", localIntent);
        return;
      }
      y.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
      localIntent.setFlags(536870912);
      com.tencent.mm.br.d.b(paramContext, "mall", ".ui.MallIndexUI", localIntent);
      com.tencent.mm.kernel.g.DQ();
    } while (!com.tencent.mm.kernel.g.DP().isSDCardAvailable());
    paramContext = new com.tencent.mm.az.k(11);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(paramContext, 0);
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreWalletCore", "onAccountPostReset subcore walletCore");
    com.tencent.mm.wallet_core.c.a.cMr();
    com.tencent.mm.wallet_core.c.a.init(ae.getContext());
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.lYu, true);
    bVs().bVX();
    this.qya = aa.bVC();
    aa localaa = this.qya;
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", localaa.iGD, true);
    com.tencent.mm.sdk.b.a.udP.c(this.qyn);
    com.tencent.mm.sdk.b.a.udP.c(this.qyh);
    com.tencent.mm.sdk.b.a.udP.b(this.qyq);
    com.tencent.mm.sdk.b.a.udP.b(this.qyp);
    com.tencent.mm.pluginsdk.cmd.b.a(new o.a(), new String[] { "//cleanpaycn" });
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.lYu, true);
    bVs().xO();
    Object localObject = bVt();
    ((ad)localObject).qyZ = null;
    ((ad)localObject).qyY.clear();
    ((ad)localObject).qyY = new ArrayList();
    localObject = this.qya;
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", ((aa)localObject).iGD, true);
    if (aa.jOT != null) {
      aa.jOT.clear();
    }
    this.qya = null;
    com.tencent.mm.sdk.b.a.udP.d(this.qyn);
    com.tencent.mm.sdk.b.a.udP.d(this.qyh);
    com.tencent.mm.sdk.b.a.udP.d(this.qyq);
    com.tencent.mm.sdk.b.a.udP.d(this.qyp);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.o
 * JD-Core Version:    0.7.0.1
 */