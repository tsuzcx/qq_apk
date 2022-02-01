package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.f.a.iq;
import com.tencent.mm.f.a.kd;
import com.tencent.mm.f.a.s;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.ab.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class ao
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private IListener QXA;
  private IListener QXB;
  private p QXu;
  private an.a QXv;
  private k QXw;
  private g QXx;
  private IListener<iq> QXy;
  private IListener<s> QXz;
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
    this.QXv = null;
    this.QXw = new k();
    this.QXx = new g();
    this.QXy = new IListener() {};
    this.QXz = new ao.2(this);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(283559);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.kernel.b.aGE();
        }
        AppMethodBeat.o(283559);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(283558);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          if (!com.tencent.mm.kernel.b.aGE()) {
            com.tencent.mm.blink.b.aqa().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(272132);
                ao.hhJ().run();
                AppMethodBeat.o(272132);
              }
            });
          }
        }
        AppMethodBeat.o(283558);
      }
    };
    this.QXA = new IListener()
    {
      private static boolean a(kd paramAnonymouskd)
      {
        AppMethodBeat.i(279443);
        for (;;)
        {
          try
          {
            f localf = com.tencent.mm.n.h.axc();
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
          paramAnonymouskd.fHB.fzj = i;
          AppMethodBeat.o(279443);
          return false;
          i = Util.getInt(com.tencent.mm.n.h.axc().getValue("AndroidUseUnicodeEmoji"), 0);
        }
      }
    };
    this.QXB = new IListener() {};
    AppMethodBeat.o(31121);
  }
  
  public static d ctZ()
  {
    AppMethodBeat.i(31124);
    d locald = a.ctZ();
    AppMethodBeat.o(31124);
    return locald;
  }
  
  public static n fmB()
  {
    AppMethodBeat.i(31130);
    n localn = a.fmB();
    AppMethodBeat.o(31130);
    return localn;
  }
  
  public static e fmC()
  {
    AppMethodBeat.i(31131);
    e locale = a.fmC();
    AppMethodBeat.o(31131);
    return locale;
  }
  
  public static i fmy()
  {
    AppMethodBeat.i(31125);
    i locali = a.fmy();
    AppMethodBeat.o(31125);
    return locali;
  }
  
  public static j fmz()
  {
    AppMethodBeat.i(31126);
    j localj = a.fmz();
    AppMethodBeat.o(31126);
    return localj;
  }
  
  private static ao hhF()
  {
    AppMethodBeat.i(31122);
    bh.beC();
    ao localao2 = (ao)ch.RZ(ao.class.getName());
    ao localao1 = localao2;
    if (localao2 == null) {
      localao1 = new ao();
    }
    AppMethodBeat.o(31122);
    return localao1;
  }
  
  public static k hhG()
  {
    AppMethodBeat.i(31123);
    k localk = hhF().QXw;
    AppMethodBeat.o(31123);
    return localk;
  }
  
  public static l hhH()
  {
    AppMethodBeat.i(31127);
    l locall = a.fmA();
    AppMethodBeat.o(31127);
    return locall;
  }
  
  public static p hhI()
  {
    AppMethodBeat.i(31128);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (hhF().QXu == null)
    {
      localObject = hhF();
      bh.beI();
      ((ao)localObject).QXu = new p(c.getDataDB());
    }
    Object localObject = hhF().QXu;
    AppMethodBeat.o(31128);
    return localObject;
  }
  
  public static an.a hhJ()
  {
    AppMethodBeat.i(31129);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (hhF().QXv == null) {
      hhF().QXv = new an.a();
    }
    an.a locala = hhF().QXv;
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
    com.tencent.mm.model.am.a.lto = a.fmy();
    h.d.a(Integer.valueOf(47), this.QXx);
    h.d.a(Integer.valueOf(49), this.QXw);
    EventCenter.instance.addListener(this.QXA);
    EventCenter.instance.addListener(this.QXB);
    this.appForegroundListener.alive();
    this.QXy.alive();
    this.QXz.alive();
    Runnable local5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(271028);
        SightVideoJNI.registerALL();
        AppMethodBeat.o(271028);
      }
    };
    try
    {
      local5.run();
      AppMethodBeat.o(31133);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (com.tencent.mm.compatible.util.d.qW(20))
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
    an.a locala = hhF().QXv;
    if (locala != null) {
      locala.ftu = 0;
    }
    h.d.b(Integer.valueOf(47), this.QXx);
    h.d.b(Integer.valueOf(49), this.QXw);
    this.appForegroundListener.dead();
    EventCenter.instance.removeListener(this.QXA);
    EventCenter.instance.removeListener(this.QXB);
    this.QXy.dead();
    this.QXz.dead();
    o.hgT();
    AppMethodBeat.o(31132);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao
 * JD-Core Version:    0.7.0.1
 */