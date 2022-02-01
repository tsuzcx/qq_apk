package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.d.a;
import java.util.HashMap;
import java.util.Map;

public class s
  implements az
{
  private int CZk;
  private r CZl;
  private ab CZm;
  private k CZn;
  private n.b CZo;
  private d.a CZp;
  private com.tencent.mm.sdk.b.c CZq;
  private q CZr;
  private l CZs;
  private int dNN;
  
  static
  {
    AppMethodBeat.i(69200);
    com.tencent.mm.wallet_core.a.i("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
    com.tencent.mm.wallet_core.a.i("BindCardProcess", com.tencent.mm.plugin.wallet_core.b.b.class);
    AppMethodBeat.o(69200);
  }
  
  public s()
  {
    AppMethodBeat.i(69193);
    this.CZk = 0;
    this.dNN = 0;
    this.CZl = new r();
    this.CZm = new ab();
    this.CZn = new k();
    this.CZo = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(69189);
        if (bu.m(paramAnonymousObject, 0) == 339975)
        {
          g.ajS();
          paramAnonymousInt = ((Integer)g.ajR().ajA().get(339975, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.a(s.this))
          {
            ap.fdX().reset();
            s.a(s.this, paramAnonymousInt);
          }
          AppMethodBeat.o(69189);
          return;
        }
        if (am.a.IPF.equals(paramAnonymousObject))
        {
          g.ajS();
          paramAnonymousInt = ((Integer)g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.b(s.this))
          {
            ap.fdX().reset();
            s.b(s.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(69189);
      }
    };
    this.CZp = new s.2(this);
    this.CZq = new com.tencent.mm.sdk.b.c() {};
    this.CZr = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
      {
        AppMethodBeat.i(69192);
        if (("paymsg".equals(paramAnonymousString)) && ("30".equals(paramAnonymousMap.get(".sysmsg.paymsg.PayMsgType"))))
        {
          int i = bu.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.WalletRedDot"), 0);
          int j = bu.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.BankCardRedDot"), 0);
          paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.paymsg.NewTagBankSerial");
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.paymsg.WalletRedDotWording");
          ae.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramAnonymousa });
          if (i != 1) {
            break label260;
          }
          com.tencent.mm.y.c.ahI().b(am.a.IVb, true);
          if (j != 1) {
            break label273;
          }
          com.tencent.mm.y.c.ahI().b(am.a.IVc, true);
        }
        for (;;)
        {
          if (!bu.isNullOrNil(paramAnonymousString))
          {
            g.ajS();
            g.ajR().ajA().set(am.a.IVe, paramAnonymousString);
          }
          if (!bu.isNullOrNil(paramAnonymousa))
          {
            g.ajS();
            paramAnonymousMap = (String)g.ajR().ajA().get(am.a.IVf, "");
            paramAnonymousString = paramAnonymousa;
            if (!bu.isNullOrNil(paramAnonymousMap)) {
              paramAnonymousString = paramAnonymousMap + "," + paramAnonymousa;
            }
            g.ajS();
            g.ajR().ajA().set(am.a.IVf, paramAnonymousString);
          }
          AppMethodBeat.o(69192);
          return;
          label260:
          com.tencent.mm.y.c.ahI().b(am.a.IVb, false);
          break;
          label273:
          com.tencent.mm.y.c.ahI().b(am.a.IVc, false);
        }
      }
    };
    this.CZs = new l();
    com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(com.tencent.mm.plugin.wallet_core.d.b.eKI());
    if (!localk.exists()) {
      localk.mkdirs();
    }
    AppMethodBeat.o(69193);
  }
  
  public static String aHP()
  {
    AppMethodBeat.i(69198);
    g.ajS();
    String str1 = (String)g.ajR().ajA().get(6, null);
    String str2 = bb.apd(str1);
    if (bu.isNullOrNil(str1))
    {
      AppMethodBeat.o(69198);
      return "";
    }
    str1 = str1.substring(str2.length() + 1);
    AppMethodBeat.o(69198);
    return str1;
  }
  
  public static s eGW()
  {
    AppMethodBeat.i(69194);
    s locals = (s)u.ap(s.class);
    AppMethodBeat.o(69194);
    return locals;
  }
  
  public static an eGX()
  {
    AppMethodBeat.i(69197);
    an localan = t.eJf();
    AppMethodBeat.o(69197);
    return localan;
  }
  
  public static String eGY()
  {
    AppMethodBeat.i(69199);
    g.ajS();
    String str1 = (String)g.ajR().ajA().get(6, null);
    if (bu.isNullOrNil(str1))
    {
      str1 = "";
      str2 = str1;
      if (bu.isNullOrNil(str1)) {
        if (!v.aAR()) {
          break label75;
        }
      }
    }
    label75:
    for (String str2 = "27";; str2 = "86")
    {
      AppMethodBeat.o(69199);
      return str2;
      str1 = bb.apd(str1.replace("+", ""));
      break;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(69195);
    g.ajS();
    this.CZk = ((Integer)g.ajR().ajA().get(339975, Integer.valueOf(0))).intValue();
    g.ajS();
    this.dNN = ((Integer)g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("paymsg", this.CZr);
    com.tencent.mm.sdk.b.a.IvT.c(this.CZl);
    com.tencent.mm.sdk.b.a.IvT.c(this.CZm);
    com.tencent.mm.sdk.b.a.IvT.c(this.CZn);
    this.CZq.alive();
    this.CZs.alive();
    g.ajS();
    g.ajR().ajA().a(this.CZo);
    g.ajS();
    g.ajR().ajA().set(am.a.IXN, Boolean.FALSE);
    AppMethodBeat.o(69195);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(69196);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("paymsg", this.CZr);
    com.tencent.mm.sdk.b.a.IvT.d(this.CZl);
    com.tencent.mm.sdk.b.a.IvT.d(this.CZm);
    com.tencent.mm.sdk.b.a.IvT.d(this.CZn);
    this.CZq.dead();
    this.CZs.dead();
    g.ajS();
    g.ajR().ajA().b(this.CZo);
    AppMethodBeat.o(69196);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s
 * JD-Core Version:    0.7.0.1
 */