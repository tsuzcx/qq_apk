package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.cm.a;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.multitalk.b.p;
import com.tencent.mm.plugin.multitalk.b.p.3;
import com.tencent.mm.plugin.multitalk.c.c;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.ert;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.an;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ac
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private o.a appForegroundListener;
  private cm.a wUb;
  private o zOO;
  private q zOP;
  private n zOQ;
  private m zOR;
  private u zOS;
  private a zOT;
  private s zOU;
  private com.tencent.mm.plugin.multitalk.c.a zOV;
  private c zOW;
  private r zOX;
  
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
  
  public ac()
  {
    AppMethodBeat.i(114624);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(114621);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          com.tencent.mm.kernel.a.azj();
        }
        AppMethodBeat.o(114621);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(114620);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          if (!com.tencent.mm.kernel.a.azj()) {
            com.tencent.mm.blink.b.ake().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114619);
                if (ac.eom().czl())
                {
                  Log.i("MicroMsg.SubCoreMultiTalk", "multitalk resume on app foreground");
                  q localq = ac.eom();
                  if (localq.zNe != null)
                  {
                    Log.i("MicroMsg.MT.MultiTalkManager", "on multitalk resume");
                    localq.a(localq.zNe.zNs, localq.zNe.zNt);
                    localq.enB();
                  }
                  AppMethodBeat.o(114619);
                  return;
                }
                Log.i("MicroMsg.SubCoreMultiTalk", "do not need resume multitalk ");
                AppMethodBeat.o(114619);
              }
            });
          }
        }
        AppMethodBeat.o(114620);
      }
    };
    this.wUb = new cm.a()
    {
      public final boolean aWC()
      {
        AppMethodBeat.i(114622);
        Log.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
        if (ac.a(ac.this) != null)
        {
          ac.a(ac.this).qm(true);
          if (ac.a(ac.this).zME != null) {
            Log.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[] { v.g(ac.a(ac.this).zME) });
          }
        }
        AppMethodBeat.o(114622);
        return true;
      }
    };
    AppMethodBeat.o(114624);
  }
  
  private static ac eoh()
  {
    AppMethodBeat.i(114625);
    ac localac = (ac)y.at(ac.class);
    AppMethodBeat.o(114625);
    return localac;
  }
  
  public static com.tencent.mm.plugin.multitalk.c.a eoi()
  {
    AppMethodBeat.i(114626);
    g.aAf();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114626);
      throw ((Throwable)localObject);
    }
    if (eoh().zOV == null) {
      eoh().zOV = new com.tencent.mm.plugin.multitalk.c.a(g.aAh().hqK);
    }
    Object localObject = eoh().zOV;
    AppMethodBeat.o(114626);
    return localObject;
  }
  
  public static c eoj()
  {
    AppMethodBeat.i(114627);
    g.aAf();
    if (com.tencent.mm.kernel.a.getUin() == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114627);
      throw ((Throwable)localObject);
    }
    if (eoh().zOW == null) {
      eoh().zOW = new c(g.aAh().hqK);
    }
    Object localObject = eoh().zOW;
    AppMethodBeat.o(114627);
    return localObject;
  }
  
  public static u eok()
  {
    AppMethodBeat.i(114628);
    g.aAf().azk();
    if (eoh().zOS == null) {
      eoh().zOS = new u();
    }
    u localu = eoh().zOS;
    AppMethodBeat.o(114628);
    return localu;
  }
  
  public static o eol()
  {
    AppMethodBeat.i(114629);
    g.aAf().azk();
    if (eoh().zOO == null) {
      eoh().zOO = new o();
    }
    o localo = eoh().zOO;
    AppMethodBeat.o(114629);
    return localo;
  }
  
  public static q eom()
  {
    AppMethodBeat.i(114630);
    g.aAf().azk();
    if (eoh().zOP == null) {
      eoh().zOP = new q();
    }
    q localq = eoh().zOP;
    AppMethodBeat.o(114630);
    return localq;
  }
  
  public static n eon()
  {
    AppMethodBeat.i(239430);
    g.aAf().azk();
    if (eoh().zOQ == null) {
      eoh().zOQ = new n();
    }
    n localn = eoh().zOQ;
    AppMethodBeat.o(239430);
    return localn;
  }
  
  public static m eoo()
  {
    AppMethodBeat.i(239431);
    g.aAf().azk();
    if (eoh().zOR == null) {
      eoh().zOR = new m();
    }
    m localm = eoh().zOR;
    AppMethodBeat.o(239431);
    return localm;
  }
  
  public static s eop()
  {
    AppMethodBeat.i(114634);
    if (eoh().zOU == null) {
      eoh().zOU = new s();
    }
    s locals = eoh().zOU;
    AppMethodBeat.o(114634);
    return locals;
  }
  
  public static r eoq()
  {
    AppMethodBeat.i(114635);
    if (eoh().zOX == null) {
      eoh().zOX = new r();
    }
    r localr = eoh().zOX;
    AppMethodBeat.o(114635);
    return localr;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(114632);
    this.zOT = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("multivoip", this.zOT, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("voipmt", this.zOT, true);
    g.aAj().a(this.wUb);
    this.appForegroundListener.alive();
    g.b(d.class, eop());
    eop().enU();
    AppMethodBeat.o(114632);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114633);
    Object localObject;
    if (this.zOO != null)
    {
      localObject = this.zOO;
      g.azz().b(1918, (i)localObject);
      g.azz().b(1919, (i)localObject);
      g.azz().b(1927, (i)localObject);
      g.azz().b(1928, (i)localObject);
      g.azz().b(1929, (i)localObject);
      g.azz().b(1931, (i)localObject);
      g.azz().b(1932, (i)localObject);
      g.azz().b(1933, (i)localObject);
      g.azz().b(1935, (i)localObject);
      g.azz().b(1937, (i)localObject);
      g.azz().b(1938, (i)localObject);
      g.azz().b(1939, (i)localObject);
      ((o)localObject).emL();
      this.zOO = null;
    }
    if (this.zOP != null)
    {
      localObject = this.zOP;
      MMApplicationContext.getContext().unregisterReceiver(((q)localObject).zNh);
      EventCenter.instance.removeListener(((q)localObject).hXn);
      ((q)localObject).j(false, false, false);
      Log.i("MicroMsg.MT.MultiTalkManager", "steve: account release. uninit ilink so");
      p localp = p.zHS;
      localp.aj(localp.qtQ);
      if (((q)localObject).zNb != null) {
        ((q)localObject).zNb.clear();
      }
      this.zOP = null;
    }
    if (this.zOS != null)
    {
      this.zOS.reset();
      this.zOS = null;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("multivoip", this.zOT, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("voipmt", this.zOT, true);
    g.aAj().b(this.wUb);
    g.ag(d.class);
    AppMethodBeat.o(114633);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements cj.a
  {
    a() {}
    
    public final void a(h.a parama)
    {
      AppMethodBeat.i(114623);
      Object localObject2 = ac.eoq();
      String str = com.tencent.mm.platformtools.z.a(parama.heO.KHn);
      Object localObject1 = XmlParser.parseXml(str, "sysmsg", null);
      if ((String)((Map)localObject1).get(".sysmsg.multivoip.notfriendnotifydata") != null)
      {
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:".concat(String.valueOf(str)));
        AppMethodBeat.o(114623);
        return;
      }
      str = (String)((Map)localObject1).get(".sysmsg.multivoip.notifydata");
      if (str != null)
      {
        localObject1 = Base64.decode(Util.nullAs(str, "").getBytes(), 0);
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + com.tencent.mm.platformtools.z.a(parama.heO.KHn) + " buffer len " + localObject1.length);
        ac.eol().zMd.dr(Util.nullAsNil((Integer)g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
        ac.eol().zMd.cR((byte[])localObject1);
        AppMethodBeat.o(114623);
        return;
      }
      str = (String)((Map)localObject1).get(".sysmsg.multivoip.banner");
      if (str != null)
      {
        ((r)localObject2).a(str, parama);
        AppMethodBeat.o(114623);
        return;
      }
      localObject2 = (String)((Map)localObject1).get(".sysmsg.voipmt.invite");
      if (localObject2 != null)
      {
        localObject1 = Base64.decode(Util.nullAs((String)localObject2, "").getBytes(), 0);
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive invite " + com.tencent.mm.platformtools.z.a(parama.heO.KHn) + " buffer len " + localObject1.length);
        p.zHS.y(Util.nullAsNil((Integer)g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
        parama = p.zHS;
        localObject2 = new ert();
        try
        {
          ((ert)localObject2).parseFrom((byte[])localObject1);
          if ((parama.zIX != null) && (parama.zIX.get(Long.valueOf(((ert)localObject2).Lnw)) == null)) {
            parama.zIX.put(Long.valueOf(((ert)localObject2).Lnw), localObject2);
          }
          parama.qtA = true;
          parama.a(new p.3(parama, (ert)localObject2));
          AppMethodBeat.o(114623);
          return;
        }
        catch (IOException parama)
        {
          Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", parama, "hy: unable to parse from data", new Object[0]);
          AppMethodBeat.o(114623);
          return;
        }
      }
      localObject1 = (String)((Map)localObject1).get(".sysmsg.voipmt.banner");
      if (localObject1 != null)
      {
        localObject1 = Base64.decode(Util.nullAs((String)localObject1, "").getBytes(), 0);
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner " + com.tencent.mm.platformtools.z.a(parama.heO.KHn) + " buffer len " + localObject1.length);
        p.zHS.y(Util.nullAsNil((Integer)g.aAh().hqB.get(1)), com.tencent.mm.model.z.aTY());
        p.zHS.bK((byte[])localObject1);
      }
      AppMethodBeat.o(114623);
    }
    
    public final void a(h.c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ac
 * JD-Core Version:    0.7.0.1
 */