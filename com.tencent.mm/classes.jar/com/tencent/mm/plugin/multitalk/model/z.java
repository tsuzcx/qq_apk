package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.f;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.b;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cg.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.multitalk.b.c;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class z
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private n.a appForegroundListener;
  private cg.a tsl;
  private m wda;
  private o wdb;
  private s wdc;
  private a wdd;
  private q wde;
  private com.tencent.mm.plugin.multitalk.b.a wdf;
  private c wdg;
  private p wdh;
  
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
  
  public z()
  {
    AppMethodBeat.i(114624);
    this.appForegroundListener = new z.1(this);
    this.tsl = new cg.a()
    {
      public final boolean aCO()
      {
        AppMethodBeat.i(114622);
        ad.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
        if (z.a(z.this) != null)
        {
          z.a(z.this).nz(true);
          if (z.a(z.this).wbv != null) {
            ad.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[] { t.g(z.a(z.this).wbv) });
          }
        }
        AppMethodBeat.o(114622);
        return true;
      }
    };
    AppMethodBeat.o(114624);
  }
  
  public static void dqr()
  {
    AppMethodBeat.i(206583);
    dqw();
    AppMethodBeat.o(206583);
  }
  
  public static z dqs()
  {
    AppMethodBeat.i(114625);
    z localz = (z)com.tencent.mm.model.t.ap(z.class);
    AppMethodBeat.o(114625);
    return localz;
  }
  
  public static com.tencent.mm.plugin.multitalk.b.a dqt()
  {
    AppMethodBeat.i(114626);
    g.ajA();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new b();
      AppMethodBeat.o(114626);
      throw ((Throwable)localObject);
    }
    if (dqs().wdf == null) {
      dqs().wdf = new com.tencent.mm.plugin.multitalk.b.a(g.ajC().gBq);
    }
    Object localObject = dqs().wdf;
    AppMethodBeat.o(114626);
    return localObject;
  }
  
  public static c dqu()
  {
    AppMethodBeat.i(114627);
    g.ajA();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new b();
      AppMethodBeat.o(114627);
      throw ((Throwable)localObject);
    }
    if (dqs().wdg == null) {
      dqs().wdg = new c(g.ajC().gBq);
    }
    Object localObject = dqs().wdg;
    AppMethodBeat.o(114627);
    return localObject;
  }
  
  public static s dqv()
  {
    AppMethodBeat.i(114628);
    g.ajA().aiF();
    if (dqs().wdc == null) {
      dqs().wdc = new s();
    }
    s locals = dqs().wdc;
    AppMethodBeat.o(114628);
    return locals;
  }
  
  public static m dqw()
  {
    AppMethodBeat.i(114629);
    g.ajA().aiF();
    if (dqs().wda == null) {
      dqs().wda = new m();
    }
    m localm = dqs().wda;
    AppMethodBeat.o(114629);
    return localm;
  }
  
  public static o dqx()
  {
    AppMethodBeat.i(114630);
    g.ajA().aiF();
    if (dqs().wdb == null) {
      dqs().wdb = new o();
    }
    o localo = dqs().wdb;
    AppMethodBeat.o(114630);
    return localo;
  }
  
  public static q dqy()
  {
    AppMethodBeat.i(114634);
    if (dqs().wde == null) {
      dqs().wde = new q();
    }
    q localq = dqs().wde;
    AppMethodBeat.o(114634);
    return localq;
  }
  
  public static p dqz()
  {
    AppMethodBeat.i(114635);
    if (dqs().wdh == null) {
      dqs().wdh = new p();
    }
    p localp = dqs().wdh;
    AppMethodBeat.o(114635);
    return localp;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(114632);
    this.wdd = new a();
    ((r)g.ad(r.class)).getSysCmdMsgExtension().a("multivoip", this.wdd, true);
    g.ajE().a(this.tsl);
    this.appForegroundListener.alive();
    g.b(d.class, dqy());
    dqy().dqk();
    AppMethodBeat.o(114632);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114633);
    Object localObject;
    if (this.wda != null)
    {
      localObject = this.wda;
      g.aiU().b(1918, (f)localObject);
      g.aiU().b(1919, (f)localObject);
      g.aiU().b(1927, (f)localObject);
      g.aiU().b(1928, (f)localObject);
      g.aiU().b(1929, (f)localObject);
      g.aiU().b(1931, (f)localObject);
      g.aiU().b(1932, (f)localObject);
      g.aiU().b(1933, (f)localObject);
      g.aiU().b(1935, (f)localObject);
      g.aiU().b(1937, (f)localObject);
      g.aiU().b(1938, (f)localObject);
      g.aiU().b(1939, (f)localObject);
      this.wda = null;
    }
    if (this.wdb != null)
    {
      localObject = this.wdb;
      aj.getContext().unregisterReceiver(((o)localObject).wbW);
      com.tencent.mm.sdk.b.a.IbL.d(((o)localObject).had);
      ((o)localObject).h(false, false, false);
      this.wdb = null;
    }
    if (this.wdc != null)
    {
      this.wdc.reset();
      this.wdc = null;
    }
    ((r)g.ad(r.class)).getSysCmdMsgExtension().b("multivoip", this.wdd, true);
    g.ajE().b(this.tsl);
    g.ac(d.class);
    AppMethodBeat.o(114633);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements cd.a
  {
    a() {}
    
    public final void a(e.a parama)
    {
      AppMethodBeat.i(114623);
      Object localObject1 = z.dqz();
      String str = com.tencent.mm.platformtools.z.a(parama.gqE.Fvk);
      Object localObject2 = bw.M(str, "sysmsg");
      if ((String)((Map)localObject2).get(".sysmsg.multivoip.notfriendnotifydata") != null)
      {
        ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:".concat(String.valueOf(str)));
        AppMethodBeat.o(114623);
        return;
      }
      str = (String)((Map)localObject2).get(".sysmsg.multivoip.notifydata");
      if (str != null)
      {
        localObject1 = Base64.decode(bt.bI(str, "").getBytes(), 0);
        ad.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + com.tencent.mm.platformtools.z.a(parama.gqE.Fvk) + " buffer len " + localObject1.length);
        z.dqw().wbf.cW(bt.n((Integer)g.ajC().gBh.get(1)), u.aAm());
        z.dqw().wbf.cL((byte[])localObject1);
        AppMethodBeat.o(114623);
        return;
      }
      localObject2 = (String)((Map)localObject2).get(".sysmsg.multivoip.banner");
      if (localObject2 != null) {
        ((p)localObject1).a((String)localObject2, parama);
      }
      AppMethodBeat.o(114623);
    }
    
    public final void a(e.c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.z
 * JD-Core Version:    0.7.0.1
 */