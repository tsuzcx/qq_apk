package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.app.o.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.g.a.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class ao
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private p JXa;
  private an.a JXb;
  private k JXc;
  private com.tencent.mm.pluginsdk.model.e JXd;
  private IListener<ib> JXe;
  private IListener<r> JXf;
  private IListener JXg;
  private IListener JXh;
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
    baseDBFactories.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new ao.4());
    AppMethodBeat.o(31134);
  }
  
  public ao()
  {
    AppMethodBeat.i(31121);
    this.JXb = null;
    this.JXc = new k();
    this.JXd = new com.tencent.mm.pluginsdk.model.e();
    this.JXe = new ao.1(this);
    this.JXf = new IListener() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(232178);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          com.tencent.mm.kernel.a.azj();
        }
        AppMethodBeat.o(232178);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(232177);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          if (!com.tencent.mm.kernel.a.azj()) {
            b.ake().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(232176);
                ao.gnh().run();
                AppMethodBeat.o(232176);
              }
            });
          }
        }
        AppMethodBeat.o(232177);
      }
    };
    this.JXg = new IListener()
    {
      private static boolean a(jn paramAnonymousjn)
      {
        AppMethodBeat.i(232180);
        for (;;)
        {
          try
          {
            f localf = h.aqJ();
            if (localf != null) {
              continue;
            }
            i = 0;
          }
          catch (Exception localException)
          {
            int i = 0;
            continue;
          }
          paramAnonymousjn.dOq.dGy = i;
          AppMethodBeat.o(232180);
          return false;
          i = Util.getInt(h.aqJ().getValue("AndroidUseUnicodeEmoji"), 0);
        }
      }
    };
    this.JXh = new IListener() {};
    AppMethodBeat.o(31121);
  }
  
  public static d cgO()
  {
    AppMethodBeat.i(31124);
    d locald = com.tencent.mm.plugin.r.a.cgO();
    AppMethodBeat.o(31124);
    return locald;
  }
  
  public static i eAR()
  {
    AppMethodBeat.i(31125);
    i locali = com.tencent.mm.plugin.r.a.eAR();
    AppMethodBeat.o(31125);
    return locali;
  }
  
  public static j eAS()
  {
    AppMethodBeat.i(31126);
    j localj = com.tencent.mm.plugin.r.a.eAS();
    AppMethodBeat.o(31126);
    return localj;
  }
  
  public static n eAU()
  {
    AppMethodBeat.i(31130);
    n localn = com.tencent.mm.plugin.r.a.eAU();
    AppMethodBeat.o(31130);
    return localn;
  }
  
  public static e eAV()
  {
    AppMethodBeat.i(31131);
    e locale = com.tencent.mm.plugin.r.a.eAV();
    AppMethodBeat.o(31131);
    return locale;
  }
  
  private static ao gnd()
  {
    AppMethodBeat.i(31122);
    bg.aVz();
    ao localao2 = (ao)cg.KG(ao.class.getName());
    ao localao1 = localao2;
    if (localao2 == null) {
      localao1 = new ao();
    }
    AppMethodBeat.o(31122);
    return localao1;
  }
  
  public static k gne()
  {
    AppMethodBeat.i(31123);
    k localk = gnd().JXc;
    AppMethodBeat.o(31123);
    return localk;
  }
  
  public static l gnf()
  {
    AppMethodBeat.i(31127);
    l locall = com.tencent.mm.plugin.r.a.eAT();
    AppMethodBeat.o(31127);
    return locall;
  }
  
  public static p gng()
  {
    AppMethodBeat.i(31128);
    g.aAf().azk();
    if (gnd().JXa == null)
    {
      localObject = gnd();
      bg.aVF();
      ((ao)localObject).JXa = new p(c.getDataDB());
    }
    Object localObject = gnd().JXa;
    AppMethodBeat.o(31128);
    return localObject;
  }
  
  public static an.a gnh()
  {
    AppMethodBeat.i(31129);
    g.aAf().azk();
    if (gnd().JXb == null) {
      gnd().JXb = new an.a();
    }
    an.a locala = gnd().JXb;
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
    com.tencent.mm.model.am.a.iDo = com.tencent.mm.plugin.r.a.eAR();
    h.d.a(Integer.valueOf(47), this.JXd);
    h.d.a(Integer.valueOf(49), this.JXc);
    EventCenter.instance.addListener(this.JXg);
    EventCenter.instance.addListener(this.JXh);
    this.appForegroundListener.alive();
    this.JXe.alive();
    this.JXf.alive();
    ao.5 local5 = new ao.5(this);
    try
    {
      local5.run();
      AppMethodBeat.o(31133);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (com.tencent.mm.compatible.util.d.oE(20))
      {
        local5.run();
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
    an.a locala = gnd().JXb;
    if (locala != null) {
      locala.dAF = 0;
    }
    h.d.b(Integer.valueOf(47), this.JXd);
    h.d.b(Integer.valueOf(49), this.JXc);
    this.appForegroundListener.dead();
    EventCenter.instance.removeListener(this.JXg);
    EventCenter.instance.removeListener(this.JXh);
    this.JXe.dead();
    this.JXf.dead();
    m.gmv();
    AppMethodBeat.o(31132);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao
 * JD-Core Version:    0.7.0.1
 */