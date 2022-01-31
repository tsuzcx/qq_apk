package com.tencent.mm.plugin.offline;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Map;

public class k
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private static Map<String, String> eEE;
  public static boolean pkO;
  public static int pkP;
  private com.tencent.mm.vending.b.b gTl;
  private bz.a kMG;
  private com.tencent.mm.sdk.platformtools.ak mHandler;
  private s pkI;
  private e pkJ;
  private i pkK;
  private com.tencent.mm.plugin.offline.b.a pkL;
  private com.tencent.mm.plugin.offline.ui.d pkM;
  public f pkN;
  private com.tencent.mm.sdk.b.c<vi> pkQ;
  private m pkR;
  private com.tencent.mm.sdk.b.c<hn> pkS;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.ak> pkT;
  
  static
  {
    AppMethodBeat.i(43372);
    pkO = false;
    pkP = 10;
    eEE = new HashMap();
    baseDBFactories = new HashMap();
    com.tencent.mm.wallet_core.a.h("OfflineBindCardRegProcess", d.class);
    com.tencent.mm.wallet_core.a.h("OfflineBindCardProcess", c.class);
    baseDBFactories.put(Integer.valueOf("OFFLINE_ORDER_STATUS".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.offline.b.a.SQL_CREATE;
      }
    });
    AppMethodBeat.o(43372);
  }
  
  public k()
  {
    AppMethodBeat.i(43362);
    this.pkI = null;
    this.pkJ = null;
    this.pkK = null;
    this.pkL = null;
    this.pkM = new com.tencent.mm.plugin.offline.ui.d();
    this.pkN = new f();
    this.pkQ = new com.tencent.mm.sdk.b.c() {};
    this.mHandler = new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper());
    this.kMG = new k.4(this);
    this.pkS = new k.5(this);
    this.pkT = new k.6(this);
    AppMethodBeat.o(43362);
  }
  
  public static String AY(int paramInt)
  {
    AppMethodBeat.i(43370);
    g.RM();
    String str = (String)g.RL().Ru().get(paramInt, null);
    AppMethodBeat.o(43370);
    return str;
  }
  
  public static void aT(int paramInt, String paramString)
  {
    AppMethodBeat.i(43369);
    if (paramString != null)
    {
      g.RM();
      g.RL().Ru().set(paramInt, paramString);
      g.RM();
      g.RL().Ru().dww();
    }
    AppMethodBeat.o(43369);
  }
  
  public static k bYF()
  {
    AppMethodBeat.i(43363);
    k localk = (k)q.S(k.class);
    AppMethodBeat.o(43363);
    return localk;
  }
  
  public static s bYG()
  {
    AppMethodBeat.i(43366);
    g.RJ().QQ();
    if (bYF().pkI == null) {
      bYF().pkI = new s();
    }
    s locals = bYF().pkI;
    AppMethodBeat.o(43366);
    return locals;
  }
  
  public static e bYH()
  {
    AppMethodBeat.i(43367);
    g.RJ().QQ();
    if (bYF().pkJ == null) {
      bYF().pkJ = new e();
    }
    e locale = bYF().pkJ;
    AppMethodBeat.o(43367);
    return locale;
  }
  
  public static i bYI()
  {
    AppMethodBeat.i(43368);
    g.RJ().QQ();
    if (bYF().pkK == null) {
      bYF().pkK = new i();
    }
    i locali = bYF().pkK;
    AppMethodBeat.o(43368);
    return locali;
  }
  
  public static com.tencent.mm.plugin.offline.b.a bYJ()
  {
    AppMethodBeat.i(43371);
    if (!g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(43371);
      throw ((Throwable)localObject);
    }
    if (bYF().pkL == null)
    {
      localObject = bYF();
      g.RM();
      ((k)localObject).pkL = new com.tencent.mm.plugin.offline.b.a(g.RL().eHS);
    }
    Object localObject = bYF().pkL;
    AppMethodBeat.o(43371);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(43364);
    this.gTl = ((com.tencent.mm.plugin.auth.a.b)g.G(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new k.3(this));
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("paymsg", this.kMG, true);
    com.tencent.mm.sdk.b.a.ymk.c(this.pkM);
    com.tencent.mm.sdk.b.a.ymk.c(this.pkQ);
    this.pkS.alive();
    this.pkT.alive();
    this.pkI = null;
    this.pkJ = null;
    this.pkK = null;
    this.pkR = new m();
    AppMethodBeat.o(43364);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(43365);
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("paymsg", this.kMG, true);
    com.tencent.mm.sdk.b.a.ymk.d(this.pkM);
    com.tencent.mm.sdk.b.a.ymk.d(this.pkQ);
    this.pkS.dead();
    this.pkT.dead();
    if (this.pkR != null)
    {
      m localm = this.pkR;
      bYF();
      bYG().b(localm);
      com.tencent.mm.sdk.b.a.ymk.d(localm.opW);
    }
    this.pkR = null;
    this.gTl.dead();
    AppMethodBeat.o(43365);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k
 * JD-Core Version:    0.7.0.1
 */