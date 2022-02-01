package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.b;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.ci.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.multitalk.b.p.3;
import com.tencent.mm.plugin.multitalk.c.c;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class z
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private o.a appForegroundListener;
  private ci.a tDc;
  private m wsC;
  private o wsD;
  private s wsE;
  private a wsF;
  private q wsG;
  private com.tencent.mm.plugin.multitalk.c.a wsH;
  private c wsI;
  private p wsJ;
  
  static
  {
    AppMethodBeat.i(114636);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.multitalk.c.a.SQL_CREATE;
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
    this.tDc = new ci.a()
    {
      public final boolean aDe()
      {
        AppMethodBeat.i(114622);
        ae.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
        if (z.a(z.this) != null)
        {
          z.a(z.this).nD(true);
          if (z.a(z.this).wqU != null) {
            ae.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[] { t.g(z.a(z.this).wqU) });
          }
        }
        AppMethodBeat.o(114622);
        return true;
      }
    };
    AppMethodBeat.o(114624);
  }
  
  private static z dtF()
  {
    AppMethodBeat.i(114625);
    z localz = (z)u.ap(z.class);
    AppMethodBeat.o(114625);
    return localz;
  }
  
  public static com.tencent.mm.plugin.multitalk.c.a dtG()
  {
    AppMethodBeat.i(114626);
    g.ajP();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new b();
      AppMethodBeat.o(114626);
      throw ((Throwable)localObject);
    }
    if (dtF().wsH == null) {
      dtF().wsH = new com.tencent.mm.plugin.multitalk.c.a(g.ajR().gDX);
    }
    Object localObject = dtF().wsH;
    AppMethodBeat.o(114626);
    return localObject;
  }
  
  public static c dtH()
  {
    AppMethodBeat.i(114627);
    g.ajP();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new b();
      AppMethodBeat.o(114627);
      throw ((Throwable)localObject);
    }
    if (dtF().wsI == null) {
      dtF().wsI = new c(g.ajR().gDX);
    }
    Object localObject = dtF().wsI;
    AppMethodBeat.o(114627);
    return localObject;
  }
  
  public static s dtI()
  {
    AppMethodBeat.i(114628);
    g.ajP().aiU();
    if (dtF().wsE == null) {
      dtF().wsE = new s();
    }
    s locals = dtF().wsE;
    AppMethodBeat.o(114628);
    return locals;
  }
  
  public static m dtJ()
  {
    AppMethodBeat.i(114629);
    g.ajP().aiU();
    if (dtF().wsC == null) {
      dtF().wsC = new m();
    }
    m localm = dtF().wsC;
    AppMethodBeat.o(114629);
    return localm;
  }
  
  public static o dtK()
  {
    AppMethodBeat.i(114630);
    g.ajP().aiU();
    if (dtF().wsD == null) {
      dtF().wsD = new o();
    }
    o localo = dtF().wsD;
    AppMethodBeat.o(114630);
    return localo;
  }
  
  public static q dtL()
  {
    AppMethodBeat.i(114634);
    if (dtF().wsG == null) {
      dtF().wsG = new q();
    }
    q localq = dtF().wsG;
    AppMethodBeat.o(114634);
    return localq;
  }
  
  public static p dtM()
  {
    AppMethodBeat.i(114635);
    if (dtF().wsJ == null) {
      dtF().wsJ = new p();
    }
    p localp = dtF().wsJ;
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
    this.wsF = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("multivoip", this.wsF, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("voipmt", this.wsF, true);
    g.ajT().a(this.tDc);
    this.appForegroundListener.alive();
    g.b(d.class, dtL());
    dtL().dtx();
    AppMethodBeat.o(114632);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114633);
    Object localObject;
    if (this.wsC != null)
    {
      localObject = this.wsC;
      g.ajj().b(1918, (f)localObject);
      g.ajj().b(1919, (f)localObject);
      g.ajj().b(1927, (f)localObject);
      g.ajj().b(1928, (f)localObject);
      g.ajj().b(1929, (f)localObject);
      g.ajj().b(1931, (f)localObject);
      g.ajj().b(1932, (f)localObject);
      g.ajj().b(1933, (f)localObject);
      g.ajj().b(1935, (f)localObject);
      g.ajj().b(1937, (f)localObject);
      g.ajj().b(1938, (f)localObject);
      g.ajj().b(1939, (f)localObject);
      this.wsC = null;
    }
    if (this.wsD != null)
    {
      localObject = this.wsD;
      ak.getContext().unregisterReceiver(((o)localObject).wrv);
      com.tencent.mm.sdk.b.a.IvT.d(((o)localObject).hcQ);
      ((o)localObject).j(false, false, false);
      ae.i("MicroMsg.MT.MultiTalkManager", "steve: account release. uninit ilink so");
      com.tencent.mm.plugin.multitalk.b.p localp = com.tencent.mm.plugin.multitalk.b.p.wmO;
      localp.ad(localp.peN);
      if (((o)localObject).wrq != null) {
        ((o)localObject).wrq.clear();
      }
      this.wsD = null;
    }
    if (this.wsE != null)
    {
      this.wsE.reset();
      this.wsE = null;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("multivoip", this.wsF, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("voipmt", this.wsF, true);
    g.ajT().b(this.tDc);
    g.ac(d.class);
    AppMethodBeat.o(114633);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements cf.a
  {
    a() {}
    
    public final void a(e.a parama)
    {
      AppMethodBeat.i(114623);
      Object localObject2 = z.dtM();
      String str = com.tencent.mm.platformtools.z.a(parama.gte.FNI);
      Object localObject1 = bx.M(str, "sysmsg");
      if ((String)((Map)localObject1).get(".sysmsg.multivoip.notfriendnotifydata") != null)
      {
        ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:".concat(String.valueOf(str)));
        AppMethodBeat.o(114623);
        return;
      }
      str = (String)((Map)localObject1).get(".sysmsg.multivoip.notifydata");
      if (str != null)
      {
        localObject1 = Base64.decode(bu.bI(str, "").getBytes(), 0);
        ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + com.tencent.mm.platformtools.z.a(parama.gte.FNI) + " buffer len " + localObject1.length);
        z.dtJ().wqE.cW(bu.o((Integer)g.ajR().gDO.get(1)), v.aAC());
        z.dtJ().wqE.cO((byte[])localObject1);
        AppMethodBeat.o(114623);
        return;
      }
      str = (String)((Map)localObject1).get(".sysmsg.multivoip.banner");
      if (str != null)
      {
        ((p)localObject2).a(str, parama);
        AppMethodBeat.o(114623);
        return;
      }
      localObject2 = (String)((Map)localObject1).get(".sysmsg.voipmt.invite");
      if (localObject2 != null)
      {
        localObject1 = Base64.decode(bu.bI((String)localObject2, "").getBytes(), 0);
        ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive invite " + com.tencent.mm.platformtools.z.a(parama.gte.FNI) + " buffer len " + localObject1.length);
        com.tencent.mm.plugin.multitalk.b.p.wmO.u(bu.o((Integer)g.ajR().gDO.get(1)), v.aAC());
        parama = com.tencent.mm.plugin.multitalk.b.p.wmO;
        localObject2 = new dxn();
        try
        {
          ((dxn)localObject2).parseFrom((byte[])localObject1);
          if ((parama.wnN != null) && (parama.wnN.get(Long.valueOf(((dxn)localObject2).Gsg)) == null)) {
            parama.wnN.put(Long.valueOf(((dxn)localObject2).Gsg), localObject2);
          }
          parama.pex = true;
          parama.a(new p.3(parama, (dxn)localObject2));
          AppMethodBeat.o(114623);
          return;
        }
        catch (IOException parama)
        {
          ae.printErrStackTrace("MicroMsg.Multitalk.ILinkService", parama, "hy: unable to parse from data", new Object[0]);
          AppMethodBeat.o(114623);
          return;
        }
      }
      localObject1 = (String)((Map)localObject1).get(".sysmsg.voipmt.banner");
      if (localObject1 != null)
      {
        localObject1 = Base64.decode(bu.bI((String)localObject1, "").getBytes(), 0);
        ae.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner " + com.tencent.mm.platformtools.z.a(parama.gte.FNI) + " buffer len " + localObject1.length);
        com.tencent.mm.plugin.multitalk.b.p.wmO.u(bu.o((Integer)g.ajR().gDO.get(1)), v.aAC());
        parama = com.tencent.mm.plugin.multitalk.b.p.wmO;
        com.tencent.mm.plugin.multitalk.b.p.bt((byte[])localObject1);
      }
      AppMethodBeat.o(114623);
    }
    
    public final void a(e.c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.z
 * JD-Core Version:    0.7.0.1
 */