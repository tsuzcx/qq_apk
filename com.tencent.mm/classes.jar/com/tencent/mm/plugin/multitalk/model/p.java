package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.multitalk.b.c;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class p
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private n.a appForegroundListener;
  private cf.a svK;
  private d uYD;
  private f uYE;
  private m uYF;
  private i uYG;
  private a uYH;
  private h uYI;
  private com.tencent.mm.plugin.multitalk.b.a uYJ;
  private c uYK;
  private g uYL;
  
  static
  {
    AppMethodBeat.i(114636);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.multitalk.b.a.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("MULTITALKMEMBER_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return c.SQL_CREATE;
      }
    });
    AppMethodBeat.o(114636);
  }
  
  public p()
  {
    AppMethodBeat.i(114624);
    this.appForegroundListener = new p.1(this);
    this.svK = new cf.a()
    {
      public final boolean azL()
      {
        AppMethodBeat.i(114622);
        ac.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
        if (p.a(p.this) != null)
        {
          p.a(p.this).nf(true);
          if (p.a(p.this).uXk != null) {
            ac.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[] { j.g(p.a(p.this).uXk) });
          }
        }
        AppMethodBeat.o(114622);
        return true;
      }
    };
    AppMethodBeat.o(114624);
  }
  
  public static g dgA()
  {
    AppMethodBeat.i(114635);
    if (dgs().uYL == null) {
      dgs().uYL = new g();
    }
    g localg = dgs().uYL;
    AppMethodBeat.o(114635);
    return localg;
  }
  
  public static void dgr()
  {
    AppMethodBeat.i(200695);
    dgw();
    AppMethodBeat.o(200695);
  }
  
  public static p dgs()
  {
    AppMethodBeat.i(114625);
    p localp = (p)t.ap(p.class);
    AppMethodBeat.o(114625);
    return localp;
  }
  
  public static com.tencent.mm.plugin.multitalk.b.a dgt()
  {
    AppMethodBeat.i(114626);
    com.tencent.mm.kernel.g.agP();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new b();
      AppMethodBeat.o(114626);
      throw ((Throwable)localObject);
    }
    if (dgs().uYJ == null) {
      dgs().uYJ = new com.tencent.mm.plugin.multitalk.b.a(com.tencent.mm.kernel.g.agR().ghG);
    }
    Object localObject = dgs().uYJ;
    AppMethodBeat.o(114626);
    return localObject;
  }
  
  public static c dgu()
  {
    AppMethodBeat.i(114627);
    com.tencent.mm.kernel.g.agP();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new b();
      AppMethodBeat.o(114627);
      throw ((Throwable)localObject);
    }
    if (dgs().uYK == null) {
      dgs().uYK = new c(com.tencent.mm.kernel.g.agR().ghG);
    }
    Object localObject = dgs().uYK;
    AppMethodBeat.o(114627);
    return localObject;
  }
  
  public static i dgv()
  {
    AppMethodBeat.i(114628);
    com.tencent.mm.kernel.g.agP().afT();
    if (dgs().uYG == null) {
      dgs().uYG = new i();
    }
    i locali = dgs().uYG;
    AppMethodBeat.o(114628);
    return locali;
  }
  
  public static d dgw()
  {
    AppMethodBeat.i(114629);
    com.tencent.mm.kernel.g.agP().afT();
    if (dgs().uYD == null) {
      dgs().uYD = new d();
    }
    d locald = dgs().uYD;
    AppMethodBeat.o(114629);
    return locald;
  }
  
  public static f dgx()
  {
    AppMethodBeat.i(114630);
    com.tencent.mm.kernel.g.agP().afT();
    if (dgs().uYE == null) {
      dgs().uYE = new f();
    }
    f localf = dgs().uYE;
    AppMethodBeat.o(114630);
    return localf;
  }
  
  public static m dgy()
  {
    AppMethodBeat.i(114631);
    com.tencent.mm.kernel.g.agP().afT();
    if (dgs().uYF == null) {
      dgs().uYF = new m();
    }
    m localm = dgs().uYF;
    AppMethodBeat.o(114631);
    return localm;
  }
  
  public static h dgz()
  {
    AppMethodBeat.i(114634);
    if (dgs().uYI == null) {
      dgs().uYI = new h();
    }
    h localh = dgs().uYI;
    AppMethodBeat.o(114634);
    return localh;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(114632);
    this.uYH = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("multivoip", this.uYH, true);
    com.tencent.mm.kernel.g.agT().a(this.svK);
    this.appForegroundListener.alive();
    com.tencent.mm.kernel.g.b(a.class, dgz());
    dgz().dgl();
    AppMethodBeat.o(114632);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114633);
    Object localObject;
    if (this.uYD != null)
    {
      localObject = this.uYD;
      com.tencent.mm.kernel.g.agi().b(1918, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(1919, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(1927, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(1928, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(1929, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(1931, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(1932, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(1933, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(1935, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(1937, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(1938, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.kernel.g.agi().b(1939, (com.tencent.mm.ak.g)localObject);
      this.uYD = null;
    }
    if (this.uYE != null)
    {
      localObject = this.uYE;
      ai.getContext().unregisterReceiver(((f)localObject).uXH);
      com.tencent.mm.sdk.b.a.GpY.d(((f)localObject).gGt);
      ((f)localObject).h(false, false, false);
      this.uYE = null;
    }
    if (this.uYF != null)
    {
      this.uYF.dgq();
      this.uYF = null;
    }
    if (this.uYG != null)
    {
      this.uYG.reset();
      this.uYG = null;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("multivoip", this.uYH, true);
    com.tencent.mm.kernel.g.agT().b(this.svK);
    com.tencent.mm.kernel.g.ac(a.class);
    AppMethodBeat.o(114633);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements cc.a
  {
    a() {}
    
    public final void a(f.a parama)
    {
      AppMethodBeat.i(114623);
      Object localObject1 = p.dgA();
      String str = z.a(parama.fXi.DPV);
      Object localObject2 = bv.L(str, "sysmsg");
      if ((String)((Map)localObject2).get(".sysmsg.multivoip.notfriendnotifydata") != null)
      {
        ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:".concat(String.valueOf(str)));
        AppMethodBeat.o(114623);
        return;
      }
      str = (String)((Map)localObject2).get(".sysmsg.multivoip.notifydata");
      if (str != null)
      {
        localObject1 = Base64.decode(bs.bG(str, "").getBytes(), 0);
        ac.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + z.a(parama.fXi.DPV) + " buffer len " + localObject1.length);
        p.dgw().uWU.cO(bs.m((Integer)com.tencent.mm.kernel.g.agR().ghx.get(1)), u.axw());
        p.dgw().uWU.cE((byte[])localObject1);
        AppMethodBeat.o(114623);
        return;
      }
      localObject2 = (String)((Map)localObject2).get(".sysmsg.multivoip.banner");
      if (localObject2 != null) {
        ((g)localObject1).a((String)localObject2, parama);
      }
      AppMethodBeat.o(114623);
    }
    
    public final void a(f.c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p
 * JD-Core Version:    0.7.0.1
 */