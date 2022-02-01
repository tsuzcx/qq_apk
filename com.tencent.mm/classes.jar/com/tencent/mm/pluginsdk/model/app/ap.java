package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.app.n.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.g.a.yn;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class ap
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private p BQI;
  private ao.a BQJ;
  private k BQK;
  private com.tencent.mm.pluginsdk.model.d BQL;
  private com.tencent.mm.sdk.b.c BQM;
  private com.tencent.mm.sdk.b.c BQN;
  private com.tencent.mm.sdk.b.c<yn> Lwv;
  private n.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(31134);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new ap.2());
    baseDBFactories.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return p.SQL_CREATE;
      }
    });
    AppMethodBeat.o(31134);
  }
  
  public ap()
  {
    AppMethodBeat.i(31121);
    this.BQJ = null;
    this.BQK = new k();
    this.BQL = new com.tencent.mm.pluginsdk.model.d();
    this.Lwv = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(204862);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.kernel.a.aeC();
        }
        AppMethodBeat.o(204862);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(204861);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC()) {
            b.SX().v(new ap.5.1(this));
          }
        }
        AppMethodBeat.o(204861);
      }
    };
    this.BQM = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(ii paramAnonymousii)
      {
        AppMethodBeat.i(204863);
        for (;;)
        {
          try
          {
            com.tencent.mm.m.e locale = com.tencent.mm.m.g.Zd();
            if (locale != null) {
              continue;
            }
            i = 0;
          }
          catch (Exception localException)
          {
            int i = 0;
            continue;
          }
          paramAnonymousii.dmj.dfo = i;
          AppMethodBeat.o(204863);
          return false;
          i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("AndroidUseUnicodeEmoji"), 0);
        }
      }
    };
    this.BQN = new ap.7(this);
    AppMethodBeat.o(31121);
  }
  
  public static d bxS()
  {
    AppMethodBeat.i(31124);
    d locald = com.tencent.mm.plugin.s.a.bxS();
    AppMethodBeat.o(31124);
    return locald;
  }
  
  public static i cZP()
  {
    AppMethodBeat.i(31125);
    i locali = com.tencent.mm.plugin.s.a.cZP();
    AppMethodBeat.o(31125);
    return locali;
  }
  
  public static j cZQ()
  {
    AppMethodBeat.i(31126);
    j localj = com.tencent.mm.plugin.s.a.cZQ();
    AppMethodBeat.o(31126);
    return localj;
  }
  
  public static n cZS()
  {
    AppMethodBeat.i(31130);
    n localn = com.tencent.mm.plugin.s.a.cZS();
    AppMethodBeat.o(31130);
    return localn;
  }
  
  public static e cZT()
  {
    AppMethodBeat.i(31131);
    e locale = com.tencent.mm.plugin.s.a.cZT();
    AppMethodBeat.o(31131);
    return locale;
  }
  
  private static ap evP()
  {
    AppMethodBeat.i(31122);
    az.arP();
    ap localap2 = (ap)bz.ut(ap.class.getName());
    ap localap1 = localap2;
    if (localap2 == null) {
      localap1 = new ap();
    }
    AppMethodBeat.o(31122);
    return localap1;
  }
  
  public static k evQ()
  {
    AppMethodBeat.i(31123);
    k localk = evP().BQK;
    AppMethodBeat.o(31123);
    return localk;
  }
  
  public static l evR()
  {
    AppMethodBeat.i(31127);
    l locall = com.tencent.mm.plugin.s.a.cZR();
    AppMethodBeat.o(31127);
    return locall;
  }
  
  public static p evS()
  {
    AppMethodBeat.i(31128);
    com.tencent.mm.kernel.g.afz().aeD();
    if (evP().BQI == null)
    {
      localObject = evP();
      az.arV();
      ((ap)localObject).BQI = new p(com.tencent.mm.model.c.afg());
    }
    Object localObject = evP().BQI;
    AppMethodBeat.o(31128);
    return localObject;
  }
  
  public static ao.a evT()
  {
    AppMethodBeat.i(31129);
    com.tencent.mm.kernel.g.afz().aeD();
    if (evP().BQJ == null) {
      evP().BQJ = new ao.a();
    }
    ao.a locala = evP().BQJ;
    AppMethodBeat.o(31129);
    return locala;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(31133);
    com.tencent.mm.model.ag.a.gMU = com.tencent.mm.plugin.s.a.cZP();
    f.d.a(Integer.valueOf(47), this.BQL);
    f.d.a(Integer.valueOf(49), this.BQK);
    com.tencent.mm.sdk.b.a.ESL.c(this.BQM);
    com.tencent.mm.sdk.b.a.ESL.c(this.BQN);
    this.appForegroundListener.alive();
    this.Lwv.alive();
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204859);
        SightVideoJNI.registerALL();
        AppMethodBeat.o(204859);
      }
    };
    try
    {
      local4.run();
      AppMethodBeat.o(31133);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (com.tencent.mm.compatible.util.d.lg(20))
      {
        local4.run();
        AppMethodBeat.o(31133);
        return;
      }
      AppMethodBeat.o(31133);
      throw localThrowable;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(31132);
    ao.a locala = evP().BQJ;
    if (locala != null) {
      locala.cZF = 0;
    }
    f.d.b(Integer.valueOf(47), this.BQL);
    f.d.b(Integer.valueOf(49), this.BQK);
    this.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.ESL.d(this.BQM);
    com.tencent.mm.sdk.b.a.ESL.d(this.BQN);
    this.Lwv.dead();
    com.tencent.mm.pluginsdk.model.l.evj();
    AppMethodBeat.o(31132);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ap
 * JD-Core Version:    0.7.0.1
 */