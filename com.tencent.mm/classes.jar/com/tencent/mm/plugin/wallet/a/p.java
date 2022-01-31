package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class p
  implements com.tencent.mm.model.ar
{
  private int ccS = 0;
  private j.a dYS = new p.4(this);
  private o qlA = new o();
  private v qlB = new v();
  private i qlC = new i();
  private m.b qlD = new m.b()
  {
    public final void a(int paramAnonymousInt, m paramAnonymousm, Object paramAnonymousObject)
    {
      if (bk.e(paramAnonymousObject, 0) == 339975)
      {
        g.DQ();
        paramAnonymousInt = ((Integer)g.DP().Dz().get(339975, Integer.valueOf(0))).intValue();
        if (paramAnonymousInt != p.a(p.this)) {
          aq.clf().reset();
        }
      }
      do
      {
        p.a(p.this, paramAnonymousInt);
        do
        {
          return;
        } while (!ac.a.usE.equals(paramAnonymousObject));
        g.DQ();
        paramAnonymousInt = ((Integer)g.DP().Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
      } while (paramAnonymousInt == p.b(p.this));
      aq.clf().reset();
      p.b(p.this, paramAnonymousInt);
    }
  };
  private com.tencent.mm.sdk.b.c qlE = new p.2(this);
  private com.tencent.mm.plugin.messenger.foundation.a.o qlF = new com.tencent.mm.plugin.messenger.foundation.a.o()
  {
    public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
    {
      if (("paymsg".equals(paramAnonymousString)) && ("30".equals(paramAnonymousMap.get(".sysmsg.paymsg.PayMsgType"))))
      {
        int i = bk.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.WalletRedDot"), 0);
        int j = bk.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.BankCardRedDot"), 0);
        paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.paymsg.NewTagBankSerial");
        paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.paymsg.WalletRedDotWording");
        y.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramAnonymousa });
        if (i != 1) {
          break label250;
        }
        com.tencent.mm.y.c.BS().b(ac.a.uxp, true);
        if (j != 1) {
          break label263;
        }
        com.tencent.mm.y.c.BS().b(ac.a.uxq, true);
      }
      for (;;)
      {
        if (!bk.bl(paramAnonymousString))
        {
          g.DQ();
          g.DP().Dz().c(ac.a.uxs, paramAnonymousString);
        }
        if (!bk.bl(paramAnonymousa))
        {
          g.DQ();
          paramAnonymousMap = (String)g.DP().Dz().get(ac.a.uxt, "");
          paramAnonymousString = paramAnonymousa;
          if (!bk.bl(paramAnonymousMap)) {
            paramAnonymousString = paramAnonymousMap + "," + paramAnonymousa;
          }
          g.DQ();
          g.DP().Dz().c(ac.a.uxt, paramAnonymousString);
        }
        return;
        label250:
        com.tencent.mm.y.c.BS().b(ac.a.uxp, false);
        break;
        label263:
        com.tencent.mm.y.c.BS().b(ac.a.uxq, false);
      }
    }
  };
  private j qlG = new j();
  private int qlz = 0;
  
  static
  {
    com.tencent.mm.wallet_core.a.i("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
    com.tencent.mm.wallet_core.a.i("BindCardProcess", com.tencent.mm.plugin.wallet_core.b.b.class);
  }
  
  public p()
  {
    File localFile = new File(com.tencent.mm.plugin.wallet_core.d.b.bWn());
    if (!localFile.exists()) {
      localFile.mkdir();
    }
  }
  
  public static String NL()
  {
    g.DQ();
    String str1 = (String)g.DP().Dz().get(6, null);
    String str2 = com.tencent.mm.sdk.platformtools.ar.Ga(str1);
    if (bk.bl(str1)) {
      return "";
    }
    return str1.substring(str2.length() + 1);
  }
  
  public static p bTK()
  {
    return (p)com.tencent.mm.model.p.B(p.class);
  }
  
  public static ag bTL()
  {
    return com.tencent.mm.plugin.wallet_core.model.o.bVs();
  }
  
  public static String bTM()
  {
    g.DQ();
    String str1 = (String)g.DP().Dz().get(6, null);
    if (bk.bl(str1)) {}
    for (str1 = "";; str1 = com.tencent.mm.sdk.platformtools.ar.Ga(str1.replace("+", "")))
    {
      String str2 = str1;
      if (bk.bl(str1))
      {
        if (!q.Gw()) {
          break;
        }
        str2 = "27";
      }
      return str2;
    }
    return "86";
  }
  
  public final void bh(boolean paramBoolean)
  {
    g.DQ();
    this.qlz = ((Integer)g.DP().Dz().get(339975, Integer.valueOf(0))).intValue();
    g.DQ();
    this.ccS = ((Integer)g.DP().Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.qlF);
    com.tencent.mm.sdk.b.a.udP.c(this.qlA);
    com.tencent.mm.sdk.b.a.udP.c(this.qlB);
    com.tencent.mm.sdk.b.a.udP.c(this.qlC);
    this.qlE.cqo();
    this.qlG.cqo();
    g.DQ();
    g.DP().Dz().a(this.qlD);
    g.DQ();
    g.DP().Dz().c(ac.a.uyY, Boolean.valueOf(false));
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.qlF);
    com.tencent.mm.sdk.b.a.udP.d(this.qlA);
    com.tencent.mm.sdk.b.a.udP.d(this.qlB);
    com.tencent.mm.sdk.b.a.udP.d(this.qlC);
    this.qlE.dead();
    this.qlG.dead();
    g.DQ();
    g.DP().Dz().b(this.qlD);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.p
 * JD-Core Version:    0.7.0.1
 */