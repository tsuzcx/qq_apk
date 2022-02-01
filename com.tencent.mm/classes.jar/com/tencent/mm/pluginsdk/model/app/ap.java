package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.app.n.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class ap
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private p DiX;
  private ao.a DiY;
  private k DiZ;
  private com.tencent.mm.pluginsdk.model.d Dja;
  private com.tencent.mm.sdk.b.c<hh> Djb;
  private com.tencent.mm.sdk.b.c Djc;
  private com.tencent.mm.sdk.b.c Djd;
  private n.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(31134);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return l.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new ap.3());
    AppMethodBeat.o(31134);
  }
  
  public ap()
  {
    AppMethodBeat.i(31121);
    this.DiY = null;
    this.DiZ = new k();
    this.Dja = new com.tencent.mm.pluginsdk.model.d();
    this.Djb = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(196112);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.kernel.a.afS();
        }
        AppMethodBeat.o(196112);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(196111);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS()) {
            b.TR().w(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(196110);
                ap.eLn().run();
                AppMethodBeat.o(196110);
              }
            });
          }
        }
        AppMethodBeat.o(196111);
      }
    };
    this.Djc = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(ip paramAnonymousip)
      {
        AppMethodBeat.i(196113);
        for (;;)
        {
          try
          {
            com.tencent.mm.m.e locale = com.tencent.mm.m.g.ZY();
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
          paramAnonymousip.djR.dcJ = i;
          AppMethodBeat.o(196113);
          return false;
          i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("AndroidUseUnicodeEmoji"), 0);
        }
      }
    };
    this.Djd = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(31121);
  }
  
  public static d bEO()
  {
    AppMethodBeat.i(31124);
    d locald = com.tencent.mm.plugin.s.a.bEO();
    AppMethodBeat.o(31124);
    return locald;
  }
  
  public static n dnA()
  {
    AppMethodBeat.i(31130);
    n localn = com.tencent.mm.plugin.s.a.dnA();
    AppMethodBeat.o(31130);
    return localn;
  }
  
  public static e dnB()
  {
    AppMethodBeat.i(31131);
    e locale = com.tencent.mm.plugin.s.a.dnB();
    AppMethodBeat.o(31131);
    return locale;
  }
  
  public static i dnx()
  {
    AppMethodBeat.i(31125);
    i locali = com.tencent.mm.plugin.s.a.dnx();
    AppMethodBeat.o(31125);
    return locali;
  }
  
  public static j dny()
  {
    AppMethodBeat.i(31126);
    j localj = com.tencent.mm.plugin.s.a.dny();
    AppMethodBeat.o(31126);
    return localj;
  }
  
  private static ap eLj()
  {
    AppMethodBeat.i(31122);
    az.ayG();
    ap localap2 = (ap)bz.yz(ap.class.getName());
    ap localap1 = localap2;
    if (localap2 == null) {
      localap1 = new ap();
    }
    AppMethodBeat.o(31122);
    return localap1;
  }
  
  public static k eLk()
  {
    AppMethodBeat.i(31123);
    k localk = eLj().DiZ;
    AppMethodBeat.o(31123);
    return localk;
  }
  
  public static l eLl()
  {
    AppMethodBeat.i(31127);
    l locall = com.tencent.mm.plugin.s.a.dnz();
    AppMethodBeat.o(31127);
    return locall;
  }
  
  public static p eLm()
  {
    AppMethodBeat.i(31128);
    com.tencent.mm.kernel.g.agP().afT();
    if (eLj().DiX == null)
    {
      localObject = eLj();
      az.ayM();
      ((ap)localObject).DiX = new p(com.tencent.mm.model.c.agw());
    }
    Object localObject = eLj().DiX;
    AppMethodBeat.o(31128);
    return localObject;
  }
  
  public static ao.a eLn()
  {
    AppMethodBeat.i(31129);
    com.tencent.mm.kernel.g.agP().afT();
    if (eLj().DiY == null) {
      eLj().DiY = new ao.a();
    }
    ao.a locala = eLj().DiY;
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
    com.tencent.mm.model.ag.a.hnu = com.tencent.mm.plugin.s.a.dnx();
    f.d.a(Integer.valueOf(47), this.Dja);
    f.d.a(Integer.valueOf(49), this.DiZ);
    com.tencent.mm.sdk.b.a.GpY.c(this.Djc);
    com.tencent.mm.sdk.b.a.GpY.c(this.Djd);
    this.appForegroundListener.alive();
    this.Djb.alive();
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196109);
        SightVideoJNI.registerALL();
        AppMethodBeat.o(196109);
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
      if (com.tencent.mm.compatible.util.d.la(20))
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
    ao.a locala = eLj().DiY;
    if (locala != null) {
      locala.cXb = 0;
    }
    f.d.b(Integer.valueOf(47), this.Dja);
    f.d.b(Integer.valueOf(49), this.DiZ);
    this.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.GpY.d(this.Djc);
    com.tencent.mm.sdk.b.a.GpY.d(this.Djd);
    this.Djb.dead();
    com.tencent.mm.pluginsdk.model.l.eKD();
    AppMethodBeat.o(31132);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ap
 * JD-Core Version:    0.7.0.1
 */