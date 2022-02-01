package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.g.a.xi;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.d.a;
import java.util.HashMap;
import java.util.Map;

public class s
  implements aw
{
  private int Bhq;
  private r Bhr;
  private aa Bhs;
  private k Bht;
  private n.b Bhu;
  private d.a Bhv;
  private com.tencent.mm.sdk.b.c Bhw;
  private p Bhx;
  private l Bhy;
  private int dAk;
  
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
    this.Bhq = 0;
    this.dAk = 0;
    this.Bhr = new r();
    this.Bhs = new aa();
    this.Bht = new k();
    this.Bhu = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(69189);
        if (bs.l(paramAnonymousObject, 0) == 339975)
        {
          g.agS();
          paramAnonymousInt = ((Integer)g.agR().agA().get(339975, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.a(s.this))
          {
            aq.eLo().reset();
            s.a(s.this, paramAnonymousInt);
          }
          AppMethodBeat.o(69189);
          return;
        }
        if (ah.a.GIP.equals(paramAnonymousObject))
        {
          g.agS();
          paramAnonymousInt = ((Integer)g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.b(s.this))
          {
            aq.eLo().reset();
            s.b(s.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(69189);
      }
    };
    this.Bhv = new s.2(this);
    this.Bhw = new com.tencent.mm.sdk.b.c() {};
    this.Bhx = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(69192);
        if (("paymsg".equals(paramAnonymousString)) && ("30".equals(paramAnonymousMap.get(".sysmsg.paymsg.PayMsgType"))))
        {
          int i = bs.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.WalletRedDot"), 0);
          int j = bs.getInt((String)paramAnonymousMap.get(".sysmsg.paymsg.BankCardRedDot"), 0);
          paramAnonymousa = (String)paramAnonymousMap.get(".sysmsg.paymsg.NewTagBankSerial");
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.paymsg.WalletRedDotWording");
          ac.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramAnonymousa });
          if (i != 1) {
            break label260;
          }
          com.tencent.mm.y.c.aeH().b(ah.a.GOh, true);
          if (j != 1) {
            break label273;
          }
          com.tencent.mm.y.c.aeH().b(ah.a.GOi, true);
        }
        for (;;)
        {
          if (!bs.isNullOrNil(paramAnonymousString))
          {
            g.agS();
            g.agR().agA().set(ah.a.GOk, paramAnonymousString);
          }
          if (!bs.isNullOrNil(paramAnonymousa))
          {
            g.agS();
            paramAnonymousMap = (String)g.agR().agA().get(ah.a.GOl, "");
            paramAnonymousString = paramAnonymousa;
            if (!bs.isNullOrNil(paramAnonymousMap)) {
              paramAnonymousString = paramAnonymousMap + "," + paramAnonymousa;
            }
            g.agS();
            g.agR().agA().set(ah.a.GOl, paramAnonymousString);
          }
          AppMethodBeat.o(69192);
          return;
          label260:
          com.tencent.mm.y.c.aeH().b(ah.a.GOh, false);
          break;
          label273:
          com.tencent.mm.y.c.aeH().b(ah.a.GOi, false);
        }
      }
    };
    this.Bhy = new l();
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.wallet_core.d.b.esU());
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(69193);
  }
  
  public static String aEt()
  {
    AppMethodBeat.i(69198);
    g.agS();
    String str1 = (String)g.agR().agA().get(6, null);
    String str2 = az.ajo(str1);
    if (bs.isNullOrNil(str1))
    {
      AppMethodBeat.o(69198);
      return "";
    }
    str1 = str1.substring(str2.length() + 1);
    AppMethodBeat.o(69198);
    return str1;
  }
  
  public static s epp()
  {
    AppMethodBeat.i(69194);
    s locals = (s)t.ap(s.class);
    AppMethodBeat.o(69194);
    return locals;
  }
  
  public static am epq()
  {
    AppMethodBeat.i(69197);
    am localam = com.tencent.mm.plugin.wallet_core.model.s.ery();
    AppMethodBeat.o(69197);
    return localam;
  }
  
  public static String epr()
  {
    AppMethodBeat.i(69199);
    g.agS();
    String str1 = (String)g.agR().agA().get(6, null);
    if (bs.isNullOrNil(str1))
    {
      str1 = "";
      str2 = str1;
      if (bs.isNullOrNil(str1)) {
        if (!u.axL()) {
          break label75;
        }
      }
    }
    label75:
    for (String str2 = "27";; str2 = "86")
    {
      AppMethodBeat.o(69199);
      return str2;
      str1 = az.ajo(str1.replace("+", ""));
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
    g.agS();
    this.Bhq = ((Integer)g.agR().agA().get(339975, Integer.valueOf(0))).intValue();
    g.agS();
    this.dAk = ((Integer)g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("paymsg", this.Bhx);
    com.tencent.mm.sdk.b.a.GpY.c(this.Bhr);
    com.tencent.mm.sdk.b.a.GpY.c(this.Bhs);
    com.tencent.mm.sdk.b.a.GpY.c(this.Bht);
    this.Bhw.alive();
    this.Bhy.alive();
    g.agS();
    g.agR().agA().a(this.Bhu);
    g.agS();
    g.agR().agA().set(ah.a.GQQ, Boolean.FALSE);
    AppMethodBeat.o(69195);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(69196);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("paymsg", this.Bhx);
    com.tencent.mm.sdk.b.a.GpY.d(this.Bhr);
    com.tencent.mm.sdk.b.a.GpY.d(this.Bhs);
    com.tencent.mm.sdk.b.a.GpY.d(this.Bht);
    this.Bhw.dead();
    this.Bhy.dead();
    g.agS();
    g.agR().agA().b(this.Bhu);
    AppMethodBeat.o(69196);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s
 * JD-Core Version:    0.7.0.1
 */