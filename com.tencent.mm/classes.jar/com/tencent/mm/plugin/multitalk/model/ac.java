package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.s;
import com.tencent.mm.app.q.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.co;
import com.tencent.mm.model.co.a;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.multitalk.c.o.3;
import com.tencent.mm.plugin.multitalk.d.c;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.fyp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storagebase.h.b;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ac
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private co.a HqA;
  private n LqF;
  private p LqG;
  private com.tencent.mm.plugin.multitalk.ui.widget.n LqH;
  private m LqI;
  private t LqJ;
  private a LqK;
  private r LqL;
  private com.tencent.mm.plugin.multitalk.d.a LqM;
  private c LqN;
  private q LqO;
  private q.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(114636);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.multitalk.d.a.SQL_CREATE;
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
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(114621);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.kernel.b.aZG();
        }
        AppMethodBeat.o(114621);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(114620);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG()) {
            com.tencent.mm.blink.b.aJY().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114619);
                if (ac.ggS().dro())
                {
                  p localp = ac.ggS();
                  if (localp.LoI.Mxl)
                  {
                    Log.i("MicroMsg.MT.MultiTalkManager", "no allow to show main ui");
                    localp.ggh();
                  }
                  for (int i = 0; (i != 0) && (ac.ggS().Lok == com.tencent.mm.plugin.multitalk.ui.widget.o.LvK); i = 1)
                  {
                    Log.i("MicroMsg.SubCoreMultiTalk", "multitalk resume on app foreground");
                    localp = ac.ggS();
                    if (localp.LoQ != null)
                    {
                      Log.i("MicroMsg.MT.MultiTalkManager", "on multitalk resume");
                      localp.a(localp.LoQ.Lpj, localp.LoQ.Lpk);
                      localp.ggh();
                    }
                    AppMethodBeat.o(114619);
                    return;
                  }
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
    this.HqA = new co.a()
    {
      public final boolean bDy()
      {
        AppMethodBeat.i(114622);
        Log.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
        if (ac.a(ac.this) != null)
        {
          ac.a(ac.this).xz(true);
          if (ac.a(ac.this).Lol != null) {
            Log.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[] { u.g(ac.a(ac.this).Lol) });
          }
        }
        AppMethodBeat.o(114622);
        return true;
      }
    };
    AppMethodBeat.o(114624);
  }
  
  private static ac ggN()
  {
    AppMethodBeat.i(114625);
    ac localac = (ac)y.aL(ac.class);
    AppMethodBeat.o(114625);
    return localac;
  }
  
  public static com.tencent.mm.plugin.multitalk.d.a ggO()
  {
    AppMethodBeat.i(114626);
    com.tencent.mm.kernel.h.baC();
    if (com.tencent.mm.kernel.b.getUin() == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114626);
      throw ((Throwable)localObject);
    }
    if (ggN().LqM == null) {
      ggN().LqM = new com.tencent.mm.plugin.multitalk.d.a(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = ggN().LqM;
    AppMethodBeat.o(114626);
    return localObject;
  }
  
  public static c ggP()
  {
    AppMethodBeat.i(114627);
    com.tencent.mm.kernel.h.baC();
    if (com.tencent.mm.kernel.b.getUin() == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114627);
      throw ((Throwable)localObject);
    }
    if (ggN().LqN == null) {
      ggN().LqN = new c(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = ggN().LqN;
    AppMethodBeat.o(114627);
    return localObject;
  }
  
  public static t ggQ()
  {
    AppMethodBeat.i(114628);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (ggN().LqJ == null) {
      ggN().LqJ = new t();
    }
    t localt = ggN().LqJ;
    AppMethodBeat.o(114628);
    return localt;
  }
  
  public static n ggR()
  {
    AppMethodBeat.i(114629);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (ggN().LqF == null) {
      ggN().LqF = new n();
    }
    n localn = ggN().LqF;
    AppMethodBeat.o(114629);
    return localn;
  }
  
  public static p ggS()
  {
    AppMethodBeat.i(114630);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (ggN().LqG == null) {
      ggN().LqG = new p();
    }
    p localp = ggN().LqG;
    AppMethodBeat.o(114630);
    return localp;
  }
  
  public static com.tencent.mm.plugin.multitalk.ui.widget.n ggT()
  {
    AppMethodBeat.i(284848);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (ggN().LqH == null) {
      ggN().LqH = new com.tencent.mm.plugin.multitalk.ui.widget.n();
    }
    com.tencent.mm.plugin.multitalk.ui.widget.n localn = ggN().LqH;
    AppMethodBeat.o(284848);
    return localn;
  }
  
  public static m ggU()
  {
    AppMethodBeat.i(284856);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (ggN().LqI == null) {
      ggN().LqI = new m();
    }
    m localm = ggN().LqI;
    AppMethodBeat.o(284856);
    return localm;
  }
  
  public static r ggV()
  {
    AppMethodBeat.i(114634);
    if (ggN().LqL == null) {
      ggN().LqL = new r();
    }
    r localr = ggN().LqL;
    AppMethodBeat.o(114634);
    return localr;
  }
  
  public static q ggW()
  {
    AppMethodBeat.i(114635);
    if (ggN().LqO == null) {
      ggN().LqO = new q();
    }
    q localq = ggN().LqO;
    AppMethodBeat.o(114635);
    return localq;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(114632);
    this.LqK = new a();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("multivoip", this.LqK, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("voipmt", this.LqK, true);
    com.tencent.mm.kernel.h.baG().a(this.HqA);
    this.appForegroundListener.alive();
    com.tencent.mm.kernel.h.b(d.class, ggV());
    ggV().ggy();
    AppMethodBeat.o(114632);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114633);
    Object localObject;
    if (this.LqF != null)
    {
      localObject = this.LqF;
      com.tencent.mm.kernel.h.aZW().b(1918, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(1919, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(1927, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(1928, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(1929, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(1931, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(1932, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(1933, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(1935, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(1937, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(1938, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.aZW().b(1939, (com.tencent.mm.am.h)localObject);
      ((n)localObject).gft();
      this.LqF = null;
    }
    if (this.LqG != null)
    {
      localObject = this.LqG;
      MMApplicationContext.getContext().unregisterReceiver(((p)localObject).LoW);
      ((p)localObject).nnP.dead();
      ((p)localObject).j(false, false, false);
      Log.i("MicroMsg.MT.MultiTalkManager", "steve: account release. uninit ilink so");
      ((p)localObject).Loi = false;
      com.tencent.mm.plugin.multitalk.c.o localo = com.tencent.mm.plugin.multitalk.c.o.Ljn;
      localo.au(localo.wVT);
      if (((p)localObject).LoM != null) {
        ((p)localObject).LoM.clear();
      }
      this.LqG = null;
    }
    if (this.LqJ != null)
    {
      this.LqJ.reset();
      this.LqJ = null;
    }
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("multivoip", this.LqK, true);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("voipmt", this.LqK, true);
    com.tencent.mm.kernel.h.baG().b(this.HqA);
    com.tencent.mm.kernel.h.ay(d.class);
    AppMethodBeat.o(114633);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements cl.a
  {
    a() {}
    
    public final void a(g.a parama)
    {
      AppMethodBeat.i(114623);
      Object localObject2 = ac.ggW();
      String str = w.a(parama.mpN.YFG);
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
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + w.a(parama.mpN.YFG) + " buffer len " + localObject1.length);
        ac.ggR().LnJ.em(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().mCE.get(1)), z.bAM());
        ac.ggR().LnJ.ds((byte[])localObject1);
        AppMethodBeat.o(114623);
        return;
      }
      str = (String)((Map)localObject1).get(".sysmsg.multivoip.banner");
      if (str != null)
      {
        ((q)localObject2).a(str, parama);
        AppMethodBeat.o(114623);
        return;
      }
      localObject2 = (String)((Map)localObject1).get(".sysmsg.voipmt.invite");
      if (localObject2 != null)
      {
        localObject1 = Base64.decode(Util.nullAs((String)localObject2, "").getBytes(), 0);
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive invite " + w.a(parama.mpN.YFG) + " buffer len " + localObject1.length);
        com.tencent.mm.plugin.multitalk.c.o.Ljn.T(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().mCE.get(1)), z.bAM());
        parama = com.tencent.mm.plugin.multitalk.c.o.Ljn;
        localObject2 = new fyp();
        try
        {
          ((fyp)localObject2).parseFrom((byte[])localObject1);
          if ((parama.Lkx != null) && (parama.Lkx.get(Long.valueOf(((fyp)localObject2).ZnE)) == null)) {
            parama.Lkx.put(Long.valueOf(((fyp)localObject2).ZnE), localObject2);
          }
          parama.wVD = true;
          parama.a(new o.3(parama, (fyp)localObject2));
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
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner " + w.a(parama.mpN.YFG) + " buffer len " + localObject1.length);
        com.tencent.mm.plugin.multitalk.c.o.Ljn.T(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().mCE.get(1)), z.bAM());
        com.tencent.mm.plugin.multitalk.c.o.Ljn.cc((byte[])localObject1);
      }
      AppMethodBeat.o(114623);
    }
    
    public final void a(g.c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ac
 * JD-Core Version:    0.7.0.1
 */