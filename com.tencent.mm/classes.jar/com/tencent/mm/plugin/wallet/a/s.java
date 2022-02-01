package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.d.a;
import java.util.HashMap;

public class s
  implements ax
{
  private int CHE;
  private r CHF;
  private ab CHG;
  private k CHH;
  private n.b CHI;
  private d.a CHJ;
  private c CHK;
  private q CHL;
  private l CHM;
  private int dMx;
  
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
    this.CHE = 0;
    this.dMx = 0;
    this.CHF = new r();
    this.CHG = new ab();
    this.CHH = new k();
    this.CHI = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(69189);
        if (bt.m(paramAnonymousObject, 0) == 339975)
        {
          g.ajD();
          paramAnonymousInt = ((Integer)g.ajC().ajl().get(339975, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.a(s.this))
          {
            ap.faj().reset();
            s.a(s.this, paramAnonymousInt);
          }
          AppMethodBeat.o(69189);
          return;
        }
        if (al.a.Ivh.equals(paramAnonymousObject))
        {
          g.ajD();
          paramAnonymousInt = ((Integer)g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
          if (paramAnonymousInt != s.b(s.this))
          {
            ap.faj().reset();
            s.b(s.this, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(69189);
      }
    };
    this.CHJ = new s.2(this);
    this.CHK = new c() {};
    this.CHL = new s.4(this);
    this.CHM = new l();
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.wallet_core.d.b.eHa());
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(69193);
  }
  
  public static String aHy()
  {
    AppMethodBeat.i(69198);
    g.ajD();
    String str1 = (String)g.ajC().ajl().get(6, null);
    String str2 = ba.aob(str1);
    if (bt.isNullOrNil(str1))
    {
      AppMethodBeat.o(69198);
      return "";
    }
    str1 = str1.substring(str2.length() + 1);
    AppMethodBeat.o(69198);
    return str1;
  }
  
  public static s eDp()
  {
    AppMethodBeat.i(69194);
    s locals = (s)com.tencent.mm.model.t.ap(s.class);
    AppMethodBeat.o(69194);
    return locals;
  }
  
  public static an eDq()
  {
    AppMethodBeat.i(69197);
    an localan = com.tencent.mm.plugin.wallet_core.model.t.eFy();
    AppMethodBeat.o(69197);
    return localan;
  }
  
  public static String eDr()
  {
    AppMethodBeat.i(69199);
    g.ajD();
    String str1 = (String)g.ajC().ajl().get(6, null);
    if (bt.isNullOrNil(str1))
    {
      str1 = "";
      str2 = str1;
      if (bt.isNullOrNil(str1)) {
        if (!u.aAB()) {
          break label75;
        }
      }
    }
    label75:
    for (String str2 = "27";; str2 = "86")
    {
      AppMethodBeat.o(69199);
      return str2;
      str1 = ba.aob(str1.replace("+", ""));
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
    g.ajD();
    this.CHE = ((Integer)g.ajC().ajl().get(339975, Integer.valueOf(0))).intValue();
    g.ajD();
    this.dMx = ((Integer)g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
    ((com.tencent.mm.plugin.messenger.foundation.a.r)g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a("paymsg", this.CHL);
    com.tencent.mm.sdk.b.a.IbL.c(this.CHF);
    com.tencent.mm.sdk.b.a.IbL.c(this.CHG);
    com.tencent.mm.sdk.b.a.IbL.c(this.CHH);
    this.CHK.alive();
    this.CHM.alive();
    g.ajD();
    g.ajC().ajl().a(this.CHI);
    g.ajD();
    g.ajC().ajl().set(al.a.IDn, Boolean.FALSE);
    AppMethodBeat.o(69195);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(69196);
    ((com.tencent.mm.plugin.messenger.foundation.a.r)g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().b("paymsg", this.CHL);
    com.tencent.mm.sdk.b.a.IbL.d(this.CHF);
    com.tencent.mm.sdk.b.a.IbL.d(this.CHG);
    com.tencent.mm.sdk.b.a.IbL.d(this.CHH);
    this.CHK.dead();
    this.CHM.dead();
    g.ajD();
    g.ajC().ajl().b(this.CHI);
    AppMethodBeat.o(69196);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s
 * JD-Core Version:    0.7.0.1
 */