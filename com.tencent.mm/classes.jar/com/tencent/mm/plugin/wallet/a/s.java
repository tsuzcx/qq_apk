package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.g.a.wx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.d.a;
import java.util.HashMap;
import java.util.Map;

public class s
  implements aw
{
  private int dCy;
  private int zOW;
  private r zOX;
  private aa zOY;
  private k zOZ;
  private n.b zPa;
  private d.a zPb;
  private com.tencent.mm.sdk.b.c zPc;
  private p zPd;
  private l zPe;
  
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
    this.zOW = 0;
    this.dCy = 0;
    this.zOX = new r();
    this.zOY = new aa();
    this.zOZ = new k();
    this.zPa = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(69189);
        if (bt.i(paramAnonymousObject, 0) == 339975)
        {
          g.afC();
          paramAnonymousInt = ((Integer)g.afB().afk().get(339975, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.a(s.this))
          {
            aq.evU().reset();
            s.a(s.this, paramAnonymousInt);
          }
          AppMethodBeat.o(69189);
          return;
        }
        if (ae.a.Fla.equals(paramAnonymousObject))
        {
          g.afC();
          paramAnonymousInt = ((Integer)g.afB().afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.b(s.this))
          {
            aq.evU().reset();
            s.b(s.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(69189);
      }
    };
    this.zPb = new s.2(this);
    this.zPc = new com.tencent.mm.sdk.b.c() {};
    this.zPd = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(69192);
        if (("paymsg".equals(paramAnonymousString)) && ("30".equals(paramAnonymousMap.get(".sysmsg.paymsg.PayMsgType"))))
        {
          int i = bt.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.WalletRedDot"), 0);
          int j = bt.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.BankCardRedDot"), 0);
          paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.paymsg.NewTagBankSerial");
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.paymsg.WalletRedDotWording");
          ad.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramAnonymousa });
          if (i != 1) {
            break label260;
          }
          com.tencent.mm.z.c.adr().b(ae.a.Fqr, true);
          if (j != 1) {
            break label273;
          }
          com.tencent.mm.z.c.adr().b(ae.a.Fqs, true);
        }
        for (;;)
        {
          if (!bt.isNullOrNil(paramAnonymousString))
          {
            g.afC();
            g.afB().afk().set(ae.a.Fqu, paramAnonymousString);
          }
          if (!bt.isNullOrNil(paramAnonymousa))
          {
            g.afC();
            paramAnonymousMap = (String)g.afB().afk().get(ae.a.Fqv, "");
            paramAnonymousString = paramAnonymousa;
            if (!bt.isNullOrNil(paramAnonymousMap)) {
              paramAnonymousString = paramAnonymousMap + "," + paramAnonymousa;
            }
            g.afC();
            g.afB().afk().set(ae.a.Fqv, paramAnonymousString);
          }
          AppMethodBeat.o(69192);
          return;
          label260:
          com.tencent.mm.z.c.adr().b(ae.a.Fqr, false);
          break;
          label273:
          com.tencent.mm.z.c.adr().b(ae.a.Fqs, false);
        }
      }
    };
    this.zPe = new l();
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.wallet_core.d.b.edz());
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(69193);
  }
  
  public static String axB()
  {
    AppMethodBeat.i(69198);
    g.afC();
    String str1 = (String)g.afB().afk().get(6, null);
    String str2 = ba.aew(str1);
    if (bt.isNullOrNil(str1))
    {
      AppMethodBeat.o(69198);
      return "";
    }
    str1 = str1.substring(str2.length() + 1);
    AppMethodBeat.o(69198);
    return str1;
  }
  
  public static s dZT()
  {
    AppMethodBeat.i(69194);
    s locals = (s)t.ap(s.class);
    AppMethodBeat.o(69194);
    return locals;
  }
  
  public static am dZU()
  {
    AppMethodBeat.i(69197);
    am localam = com.tencent.mm.plugin.wallet_core.model.s.ecc();
    AppMethodBeat.o(69197);
    return localam;
  }
  
  public static String dZV()
  {
    AppMethodBeat.i(69199);
    g.afC();
    String str1 = (String)g.afB().afk().get(6, null);
    if (bt.isNullOrNil(str1))
    {
      str1 = "";
      str2 = str1;
      if (bt.isNullOrNil(str1)) {
        if (!u.aqV()) {
          break label75;
        }
      }
    }
    label75:
    for (String str2 = "27";; str2 = "86")
    {
      AppMethodBeat.o(69199);
      return str2;
      str1 = ba.aew(str1.replace("+", ""));
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
    g.afC();
    this.zOW = ((Integer)g.afB().afk().get(339975, Integer.valueOf(0))).intValue();
    g.afC();
    this.dCy = ((Integer)g.afB().afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("paymsg", this.zPd);
    com.tencent.mm.sdk.b.a.ESL.c(this.zOX);
    com.tencent.mm.sdk.b.a.ESL.c(this.zOY);
    com.tencent.mm.sdk.b.a.ESL.c(this.zOZ);
    this.zPc.alive();
    this.zPe.alive();
    g.afC();
    g.afB().afk().a(this.zPa);
    g.afC();
    g.afB().afk().set(ae.a.FsX, Boolean.FALSE);
    AppMethodBeat.o(69195);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(69196);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("paymsg", this.zPd);
    com.tencent.mm.sdk.b.a.ESL.d(this.zOX);
    com.tencent.mm.sdk.b.a.ESL.d(this.zOY);
    com.tencent.mm.sdk.b.a.ESL.d(this.zOZ);
    this.zPc.dead();
    this.zPe.dead();
    g.afC();
    g.afB().afk().b(this.zPa);
    AppMethodBeat.o(69196);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s
 * JD-Core Version:    0.7.0.1
 */