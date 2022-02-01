package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
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
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class p
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private n.a appForegroundListener;
  private cf.a rmQ;
  private d tQd;
  private f tQe;
  private m tQf;
  private i tQg;
  private a tQh;
  private h tQi;
  private com.tencent.mm.plugin.multitalk.b.a tQj;
  private c tQk;
  private g tQl;
  
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
    this.rmQ = new cf.a()
    {
      public final boolean asU()
      {
        AppMethodBeat.i(114622);
        ad.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
        if (p.a(p.this) != null)
        {
          p.a(p.this).mm(true);
          if (p.a(p.this).tOI != null) {
            ad.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[] { j.g(p.a(p.this).tOI) });
          }
        }
        AppMethodBeat.o(114622);
        return true;
      }
    };
    AppMethodBeat.o(114624);
  }
  
  public static void cSI()
  {
    AppMethodBeat.i(189961);
    cSN();
    AppMethodBeat.o(189961);
  }
  
  public static p cSJ()
  {
    AppMethodBeat.i(114625);
    p localp = (p)t.ap(p.class);
    AppMethodBeat.o(114625);
    return localp;
  }
  
  public static com.tencent.mm.plugin.multitalk.b.a cSK()
  {
    AppMethodBeat.i(114626);
    com.tencent.mm.kernel.g.afz();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new b();
      AppMethodBeat.o(114626);
      throw ((Throwable)localObject);
    }
    if (cSJ().tQj == null) {
      cSJ().tQj = new com.tencent.mm.plugin.multitalk.b.a(com.tencent.mm.kernel.g.afB().gda);
    }
    Object localObject = cSJ().tQj;
    AppMethodBeat.o(114626);
    return localObject;
  }
  
  public static c cSL()
  {
    AppMethodBeat.i(114627);
    com.tencent.mm.kernel.g.afz();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new b();
      AppMethodBeat.o(114627);
      throw ((Throwable)localObject);
    }
    if (cSJ().tQk == null) {
      cSJ().tQk = new c(com.tencent.mm.kernel.g.afB().gda);
    }
    Object localObject = cSJ().tQk;
    AppMethodBeat.o(114627);
    return localObject;
  }
  
  public static i cSM()
  {
    AppMethodBeat.i(114628);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cSJ().tQg == null) {
      cSJ().tQg = new i();
    }
    i locali = cSJ().tQg;
    AppMethodBeat.o(114628);
    return locali;
  }
  
  public static d cSN()
  {
    AppMethodBeat.i(114629);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cSJ().tQd == null) {
      cSJ().tQd = new d();
    }
    d locald = cSJ().tQd;
    AppMethodBeat.o(114629);
    return locald;
  }
  
  public static f cSO()
  {
    AppMethodBeat.i(114630);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cSJ().tQe == null) {
      cSJ().tQe = new f();
    }
    f localf = cSJ().tQe;
    AppMethodBeat.o(114630);
    return localf;
  }
  
  public static m cSP()
  {
    AppMethodBeat.i(114631);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cSJ().tQf == null) {
      cSJ().tQf = new m();
    }
    m localm = cSJ().tQf;
    AppMethodBeat.o(114631);
    return localm;
  }
  
  public static h cSQ()
  {
    AppMethodBeat.i(114634);
    if (cSJ().tQi == null) {
      cSJ().tQi = new h();
    }
    h localh = cSJ().tQi;
    AppMethodBeat.o(114634);
    return localh;
  }
  
  public static g cSR()
  {
    AppMethodBeat.i(114635);
    if (cSJ().tQl == null) {
      cSJ().tQl = new g();
    }
    g localg = cSJ().tQl;
    AppMethodBeat.o(114635);
    return localg;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(114632);
    this.tQh = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("multivoip", this.tQh, true);
    com.tencent.mm.kernel.g.afD().a(this.rmQ);
    this.appForegroundListener.alive();
    com.tencent.mm.kernel.g.b(a.class, cSQ());
    cSQ().cSC();
    AppMethodBeat.o(114632);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114633);
    Object localObject;
    if (this.tQd != null)
    {
      localObject = this.tQd;
      com.tencent.mm.kernel.g.aeS().b(1918, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(1919, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(1927, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(1928, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(1929, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(1931, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(1932, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(1933, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(1935, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(1937, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(1938, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.kernel.g.aeS().b(1939, (com.tencent.mm.al.g)localObject);
      this.tQd = null;
    }
    if (this.tQe != null)
    {
      localObject = this.tQe;
      aj.getContext().unregisterReceiver(((f)localObject).tPf);
      com.tencent.mm.sdk.b.a.ESL.d(((f)localObject).tPg);
      ((f)localObject).g(false, false, false);
      this.tQe = null;
    }
    if (this.tQf != null)
    {
      this.tQf.cSH();
      this.tQf = null;
    }
    if (this.tQg != null)
    {
      this.tQg.reset();
      this.tQg = null;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("multivoip", this.tQh, true);
    com.tencent.mm.kernel.g.afD().b(this.rmQ);
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
      Object localObject1 = p.cSR();
      String str = z.a(parama.fTo.Cxz);
      Object localObject2 = bw.K(str, "sysmsg");
      if ((String)((Map)localObject2).get(".sysmsg.multivoip.notfriendnotifydata") != null)
      {
        ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:".concat(String.valueOf(str)));
        AppMethodBeat.o(114623);
        return;
      }
      str = (String)((Map)localObject2).get(".sysmsg.multivoip.notifydata");
      if (str != null)
      {
        localObject1 = Base64.decode(bt.by(str, "").getBytes(), 0);
        ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + z.a(parama.fTo.Cxz) + " buffer len " + localObject1.length);
        p.cSN().tOr.cL(bt.l((Integer)com.tencent.mm.kernel.g.afB().gcR.get(1)), u.aqG());
        p.cSN().tOr.cF((byte[])localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p
 * JD-Core Version:    0.7.0.1
 */