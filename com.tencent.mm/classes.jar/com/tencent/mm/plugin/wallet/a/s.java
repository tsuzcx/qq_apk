package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.HashMap;

public class s
  implements at
{
  private int cLB;
  private int tUL;
  private r tUM;
  private aa tUN;
  private k tUO;
  private n.b tUP;
  private c tUQ;
  private o tUR;
  private l tUS;
  
  static
  {
    AppMethodBeat.i(45859);
    com.tencent.mm.wallet_core.a.h("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
    com.tencent.mm.wallet_core.a.h("BindCardProcess", com.tencent.mm.plugin.wallet_core.b.b.class);
    AppMethodBeat.o(45859);
  }
  
  public s()
  {
    AppMethodBeat.i(45852);
    this.tUL = 0;
    this.cLB = 0;
    this.tUM = new r();
    this.tUN = new aa();
    this.tUO = new k();
    this.tUP = new s.1(this);
    this.tUQ = new s.2(this);
    this.tUR = new s.3(this);
    this.tUS = new l();
    File localFile = new File(com.tencent.mm.plugin.wallet_core.d.b.cVf());
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    AppMethodBeat.o(45852);
  }
  
  public static String agz()
  {
    AppMethodBeat.i(45857);
    g.RM();
    String str1 = (String)g.RL().Ru().get(6, null);
    String str2 = av.RC(str1);
    if (bo.isNullOrNil(str1))
    {
      AppMethodBeat.o(45857);
      return "";
    }
    str1 = str1.substring(str2.length() + 1);
    AppMethodBeat.o(45857);
    return str1;
  }
  
  public static s cRG()
  {
    AppMethodBeat.i(45853);
    s locals = (s)q.S(s.class);
    AppMethodBeat.o(45853);
    return locals;
  }
  
  public static am cRH()
  {
    AppMethodBeat.i(45856);
    am localam = t.cTN();
    AppMethodBeat.o(45856);
    return localam;
  }
  
  public static String cRI()
  {
    AppMethodBeat.i(45858);
    g.RM();
    String str1 = (String)g.RL().Ru().get(6, null);
    if (bo.isNullOrNil(str1))
    {
      str1 = "";
      str2 = str1;
      if (bo.isNullOrNil(str1)) {
        if (!com.tencent.mm.model.r.ZB()) {
          break label75;
        }
      }
    }
    label75:
    for (String str2 = "27";; str2 = "86")
    {
      AppMethodBeat.o(45858);
      return str2;
      str1 = av.RC(str1.replace("+", ""));
      break;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(45854);
    g.RM();
    this.tUL = ((Integer)g.RL().Ru().get(339975, Integer.valueOf(0))).intValue();
    g.RM();
    this.cLB = ((Integer)g.RL().Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("paymsg", this.tUR);
    com.tencent.mm.sdk.b.a.ymk.c(this.tUM);
    com.tencent.mm.sdk.b.a.ymk.c(this.tUN);
    com.tencent.mm.sdk.b.a.ymk.c(this.tUO);
    this.tUQ.alive();
    this.tUS.alive();
    g.RM();
    g.RL().Ru().a(this.tUP);
    g.RM();
    g.RL().Ru().set(ac.a.yJM, Boolean.FALSE);
    AppMethodBeat.o(45854);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(45855);
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("paymsg", this.tUR);
    com.tencent.mm.sdk.b.a.ymk.d(this.tUM);
    com.tencent.mm.sdk.b.a.ymk.d(this.tUN);
    com.tencent.mm.sdk.b.a.ymk.d(this.tUO);
    this.tUQ.dead();
    this.tUS.dead();
    g.RM();
    g.RL().Ru().b(this.tUP);
    AppMethodBeat.o(45855);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s
 * JD-Core Version:    0.7.0.1
 */