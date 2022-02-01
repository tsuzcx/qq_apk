package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.app.o.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class ao
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private p Fgj;
  private an.a Fgk;
  private k Fgl;
  private com.tencent.mm.pluginsdk.model.d Fgm;
  private com.tencent.mm.sdk.b.c<ho> Fgn;
  private com.tencent.mm.sdk.b.c Fgo;
  private com.tencent.mm.sdk.b.c Fgp;
  private o.a appForegroundListener;
  
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
    baseDBFactories.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new ao.3());
    AppMethodBeat.o(31134);
  }
  
  public ao()
  {
    AppMethodBeat.i(31121);
    this.Fgk = null;
    this.Fgl = new k();
    this.Fgm = new com.tencent.mm.pluginsdk.model.d();
    this.Fgn = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(186714);
        if ((com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk))
        {
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.kernel.a.aiT();
        }
        AppMethodBeat.o(186714);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(186713);
        if ((com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk))
        {
          com.tencent.mm.kernel.g.ajP();
          if (!com.tencent.mm.kernel.a.aiT()) {
            b.Wq().u(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(186712);
                ao.fdW().run();
                AppMethodBeat.o(186712);
              }
            });
          }
        }
        AppMethodBeat.o(186713);
      }
    };
    this.Fgo = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(iy paramAnonymousiy)
      {
        AppMethodBeat.i(186715);
        for (;;)
        {
          try
          {
            com.tencent.mm.n.e locale = com.tencent.mm.n.g.acL();
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
          paramAnonymousiy.dwJ.dpk = i;
          AppMethodBeat.o(186715);
          return false;
          i = bu.getInt(com.tencent.mm.n.g.acL().getValue("AndroidUseUnicodeEmoji"), 0);
        }
      }
    };
    this.Fgp = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(31121);
  }
  
  public static d bJV()
  {
    AppMethodBeat.i(31124);
    d locald = com.tencent.mm.plugin.s.a.bJV();
    AppMethodBeat.o(31124);
    return locald;
  }
  
  public static i dBf()
  {
    AppMethodBeat.i(31125);
    i locali = com.tencent.mm.plugin.s.a.dBf();
    AppMethodBeat.o(31125);
    return locali;
  }
  
  public static j dBg()
  {
    AppMethodBeat.i(31126);
    j localj = com.tencent.mm.plugin.s.a.dBg();
    AppMethodBeat.o(31126);
    return localj;
  }
  
  public static n dBi()
  {
    AppMethodBeat.i(31130);
    n localn = com.tencent.mm.plugin.s.a.dBi();
    AppMethodBeat.o(31130);
    return localn;
  }
  
  public static e dBj()
  {
    AppMethodBeat.i(31131);
    e locale = com.tencent.mm.plugin.s.a.dBj();
    AppMethodBeat.o(31131);
    return locale;
  }
  
  private static ao fdS()
  {
    AppMethodBeat.i(31122);
    bc.aCa();
    ao localao2 = (ao)cc.Ca(ao.class.getName());
    ao localao1 = localao2;
    if (localao2 == null) {
      localao1 = new ao();
    }
    AppMethodBeat.o(31122);
    return localao1;
  }
  
  public static k fdT()
  {
    AppMethodBeat.i(31123);
    k localk = fdS().Fgl;
    AppMethodBeat.o(31123);
    return localk;
  }
  
  public static l fdU()
  {
    AppMethodBeat.i(31127);
    l locall = com.tencent.mm.plugin.s.a.dBh();
    AppMethodBeat.o(31127);
    return locall;
  }
  
  public static p fdV()
  {
    AppMethodBeat.i(31128);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (fdS().Fgj == null)
    {
      localObject = fdS();
      bc.aCg();
      ((ao)localObject).Fgj = new p(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = fdS().Fgj;
    AppMethodBeat.o(31128);
    return localObject;
  }
  
  public static an.a fdW()
  {
    AppMethodBeat.i(31129);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (fdS().Fgk == null) {
      fdS().Fgk = new an.a();
    }
    an.a locala = fdS().Fgk;
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
    com.tencent.mm.model.ai.a.hIE = com.tencent.mm.plugin.s.a.dBf();
    e.d.a(Integer.valueOf(47), this.Fgm);
    e.d.a(Integer.valueOf(49), this.Fgl);
    com.tencent.mm.sdk.b.a.IvT.c(this.Fgo);
    com.tencent.mm.sdk.b.a.IvT.c(this.Fgp);
    this.appForegroundListener.alive();
    this.Fgn.alive();
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186711);
        SightVideoJNI.registerALL();
        AppMethodBeat.o(186711);
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
      if (com.tencent.mm.compatible.util.d.lB(20))
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
    an.a locala = fdS().Fgk;
    if (locala != null) {
      locala.dju = 0;
    }
    e.d.b(Integer.valueOf(47), this.Fgm);
    e.d.b(Integer.valueOf(49), this.Fgl);
    this.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.IvT.d(this.Fgo);
    com.tencent.mm.sdk.b.a.IvT.d(this.Fgp);
    this.Fgn.dead();
    com.tencent.mm.pluginsdk.model.l.fdl();
    AppMethodBeat.o(31132);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao
 * JD-Core Version:    0.7.0.1
 */