package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.cn.a;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.multitalk.b.o.3;
import com.tencent.mm.plugin.multitalk.c.a;
import com.tencent.mm.plugin.multitalk.c.c;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.fce;
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

public class ad
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private cn.a BFY;
  private o Fun;
  private q Fuo;
  private n Fup;
  private m Fuq;
  private u Fur;
  private a Fus;
  private s Fut;
  private a Fuu;
  private c Fuv;
  private r Fuw;
  private o.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(114636);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return a.SQL_CREATE;
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
  
  public ad()
  {
    AppMethodBeat.i(114624);
    this.appForegroundListener = new ad.1(this);
    this.BFY = new cn.a()
    {
      public final boolean bfH()
      {
        AppMethodBeat.i(114622);
        Log.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
        if (ad.a(ad.this) != null)
        {
          ad.a(ad.this).to(true);
          if (ad.a(ad.this).FrY != null) {
            Log.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[] { v.g(ad.a(ad.this).FrY) });
          }
        }
        AppMethodBeat.o(114622);
        return true;
      }
    };
    AppMethodBeat.o(114624);
  }
  
  private static ad eXX()
  {
    AppMethodBeat.i(114625);
    ad localad = (ad)y.as(ad.class);
    AppMethodBeat.o(114625);
    return localad;
  }
  
  public static a eXY()
  {
    AppMethodBeat.i(114626);
    h.aHE();
    if (com.tencent.mm.kernel.b.getUin() == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114626);
      throw ((Throwable)localObject);
    }
    if (eXX().Fuu == null) {
      eXX().Fuu = new a(h.aHG().kcF);
    }
    Object localObject = eXX().Fuu;
    AppMethodBeat.o(114626);
    return localObject;
  }
  
  public static c eXZ()
  {
    AppMethodBeat.i(114627);
    h.aHE();
    if (com.tencent.mm.kernel.b.getUin() == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114627);
      throw ((Throwable)localObject);
    }
    if (eXX().Fuv == null) {
      eXX().Fuv = new c(h.aHG().kcF);
    }
    Object localObject = eXX().Fuv;
    AppMethodBeat.o(114627);
    return localObject;
  }
  
  public static u eYa()
  {
    AppMethodBeat.i(114628);
    h.aHE().aGH();
    if (eXX().Fur == null) {
      eXX().Fur = new u();
    }
    u localu = eXX().Fur;
    AppMethodBeat.o(114628);
    return localu;
  }
  
  public static o eYb()
  {
    AppMethodBeat.i(114629);
    h.aHE().aGH();
    if (eXX().Fun == null) {
      eXX().Fun = new o();
    }
    o localo = eXX().Fun;
    AppMethodBeat.o(114629);
    return localo;
  }
  
  public static q eYc()
  {
    AppMethodBeat.i(114630);
    h.aHE().aGH();
    if (eXX().Fuo == null) {
      eXX().Fuo = new q();
    }
    q localq = eXX().Fuo;
    AppMethodBeat.o(114630);
    return localq;
  }
  
  public static n eYd()
  {
    AppMethodBeat.i(205800);
    h.aHE().aGH();
    if (eXX().Fup == null) {
      eXX().Fup = new n();
    }
    n localn = eXX().Fup;
    AppMethodBeat.o(205800);
    return localn;
  }
  
  public static m eYe()
  {
    AppMethodBeat.i(205801);
    h.aHE().aGH();
    if (eXX().Fuq == null) {
      eXX().Fuq = new m();
    }
    m localm = eXX().Fuq;
    AppMethodBeat.o(205801);
    return localm;
  }
  
  public static s eYf()
  {
    AppMethodBeat.i(114634);
    if (eXX().Fut == null) {
      eXX().Fut = new s();
    }
    s locals = eXX().Fut;
    AppMethodBeat.o(114634);
    return locals;
  }
  
  public static r eYg()
  {
    AppMethodBeat.i(114635);
    if (eXX().Fuw == null) {
      eXX().Fuw = new r();
    }
    r localr = eXX().Fuw;
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
    this.Fus = new a();
    ((com.tencent.mm.plugin.messenger.foundation.a.v)h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("multivoip", this.Fus, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("voipmt", this.Fus, true);
    h.aHI().a(this.BFY);
    this.appForegroundListener.alive();
    h.b(d.class, eYf());
    eYf().eXK();
    AppMethodBeat.o(114632);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114633);
    Object localObject;
    if (this.Fun != null)
    {
      localObject = this.Fun;
      h.aGY().b(1918, (i)localObject);
      h.aGY().b(1919, (i)localObject);
      h.aGY().b(1927, (i)localObject);
      h.aGY().b(1928, (i)localObject);
      h.aGY().b(1929, (i)localObject);
      h.aGY().b(1931, (i)localObject);
      h.aGY().b(1932, (i)localObject);
      h.aGY().b(1933, (i)localObject);
      h.aGY().b(1935, (i)localObject);
      h.aGY().b(1937, (i)localObject);
      h.aGY().b(1938, (i)localObject);
      h.aGY().b(1939, (i)localObject);
      ((o)localObject).eWA();
      this.Fun = null;
    }
    if (this.Fuo != null)
    {
      localObject = this.Fuo;
      MMApplicationContext.getContext().unregisterReceiver(((q)localObject).FsE);
      EventCenter.instance.removeListener(((q)localObject).kLS);
      ((q)localObject).i(false, false, false);
      Log.i("MicroMsg.MT.MultiTalkManager", "steve: account release. uninit ilink so");
      ((q)localObject).FrV = false;
      com.tencent.mm.plugin.multitalk.b.o localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
      localo.am(localo.tSC);
      if (((q)localObject).Fsw != null) {
        ((q)localObject).Fsw.clear();
      }
      this.Fuo = null;
    }
    if (this.Fur != null)
    {
      this.Fur.reset();
      this.Fur = null;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.v)h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("multivoip", this.Fus, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("voipmt", this.Fus, true);
    h.aHI().b(this.BFY);
    h.af(d.class);
    AppMethodBeat.o(114633);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements ck.a
  {
    a() {}
    
    public final void a(h.a parama)
    {
      AppMethodBeat.i(114623);
      Object localObject2 = ad.eYg();
      String str = com.tencent.mm.platformtools.z.a(parama.jQG.RIF);
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
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + com.tencent.mm.platformtools.z.a(parama.jQG.RIF) + " buffer len " + localObject1.length);
        ad.eYb().Frw.ds(Util.nullAsNil((Integer)h.aHG().kcw.get(1)), com.tencent.mm.model.z.bcZ());
        ad.eYb().Frw.dq((byte[])localObject1);
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
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive invite " + com.tencent.mm.platformtools.z.a(parama.jQG.RIF) + " buffer len " + localObject1.length);
        com.tencent.mm.plugin.multitalk.b.o.Fne.F(Util.nullAsNil((Integer)h.aHG().kcw.get(1)), com.tencent.mm.model.z.bcZ());
        parama = com.tencent.mm.plugin.multitalk.b.o.Fne;
        localObject2 = new fce();
        try
        {
          ((fce)localObject2).parseFrom((byte[])localObject1);
          if ((parama.Fon != null) && (parama.Fon.get(Long.valueOf(((fce)localObject2).SoR)) == null)) {
            parama.Fon.put(Long.valueOf(((fce)localObject2).SoR), localObject2);
          }
          parama.tSm = true;
          parama.a(new o.3(parama, (fce)localObject2));
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
        Log.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive banner " + com.tencent.mm.platformtools.z.a(parama.jQG.RIF) + " buffer len " + localObject1.length);
        com.tencent.mm.plugin.multitalk.b.o.Fne.F(Util.nullAsNil((Integer)h.aHG().kcw.get(1)), com.tencent.mm.model.z.bcZ());
        com.tencent.mm.plugin.multitalk.b.o.Fne.ca((byte[])localObject1);
      }
      AppMethodBeat.o(114623);
    }
    
    public final void a(h.c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ad
 * JD-Core Version:    0.7.0.1
 */