package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.d;
import com.tencent.mm.app.n.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class ao
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private p ENN;
  private an.a ENO;
  private k ENP;
  private com.tencent.mm.pluginsdk.model.d ENQ;
  private com.tencent.mm.sdk.b.c<hn> ENR;
  private com.tencent.mm.sdk.b.c ENS;
  private com.tencent.mm.sdk.b.c ENT;
  private n.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(31134);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new ao.2());
    baseDBFactories.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new ao.3());
    AppMethodBeat.o(31134);
  }
  
  public ao()
  {
    AppMethodBeat.i(31121);
    this.ENO = null;
    this.ENP = new k();
    this.ENQ = new com.tencent.mm.pluginsdk.model.d();
    this.ENR = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(193434);
        if ((com.tencent.mm.kernel.g.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD))
        {
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.kernel.a.aiE();
        }
        AppMethodBeat.o(193434);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(193433);
        if ((com.tencent.mm.kernel.g.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD))
        {
          com.tencent.mm.kernel.g.ajA();
          if (!com.tencent.mm.kernel.a.aiE()) {
            b.Wi().w(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(193432);
                ao.fai().run();
                AppMethodBeat.o(193432);
              }
            });
          }
        }
        AppMethodBeat.o(193433);
      }
    };
    this.ENS = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(ix paramAnonymousix)
      {
        AppMethodBeat.i(193435);
        for (;;)
        {
          try
          {
            com.tencent.mm.n.e locale = com.tencent.mm.n.g.acA();
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
          paramAnonymousix.dvE.dof = i;
          AppMethodBeat.o(193435);
          return false;
          i = bt.getInt(com.tencent.mm.n.g.acA().getValue("AndroidUseUnicodeEmoji"), 0);
        }
      }
    };
    this.ENT = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(31121);
  }
  
  public static d bIX()
  {
    AppMethodBeat.i(31124);
    d locald = com.tencent.mm.plugin.s.a.bIX();
    AppMethodBeat.o(31124);
    return locald;
  }
  
  public static i dxP()
  {
    AppMethodBeat.i(31125);
    i locali = com.tencent.mm.plugin.s.a.dxP();
    AppMethodBeat.o(31125);
    return locali;
  }
  
  public static j dxQ()
  {
    AppMethodBeat.i(31126);
    j localj = com.tencent.mm.plugin.s.a.dxQ();
    AppMethodBeat.o(31126);
    return localj;
  }
  
  public static n dxS()
  {
    AppMethodBeat.i(31130);
    n localn = com.tencent.mm.plugin.s.a.dxS();
    AppMethodBeat.o(31130);
    return localn;
  }
  
  public static e dxT()
  {
    AppMethodBeat.i(31131);
    e locale = com.tencent.mm.plugin.s.a.dxT();
    AppMethodBeat.o(31131);
    return locale;
  }
  
  private static ao fae()
  {
    AppMethodBeat.i(31122);
    ba.aBK();
    ao localao2 = (ao)ca.By(ao.class.getName());
    ao localao1 = localao2;
    if (localao2 == null) {
      localao1 = new ao();
    }
    AppMethodBeat.o(31122);
    return localao1;
  }
  
  public static k faf()
  {
    AppMethodBeat.i(31123);
    k localk = fae().ENP;
    AppMethodBeat.o(31123);
    return localk;
  }
  
  public static l fag()
  {
    AppMethodBeat.i(31127);
    l locall = com.tencent.mm.plugin.s.a.dxR();
    AppMethodBeat.o(31127);
    return locall;
  }
  
  public static p fah()
  {
    AppMethodBeat.i(31128);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (fae().ENN == null)
    {
      localObject = fae();
      ba.aBQ();
      ((ao)localObject).ENN = new p(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = fae().ENN;
    AppMethodBeat.o(31128);
    return localObject;
  }
  
  public static an.a fai()
  {
    AppMethodBeat.i(31129);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (fae().ENO == null) {
      fae().ENO = new an.a();
    }
    an.a locala = fae().ENO;
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
    com.tencent.mm.model.ah.a.hFM = com.tencent.mm.plugin.s.a.dxP();
    e.d.a(Integer.valueOf(47), this.ENQ);
    e.d.a(Integer.valueOf(49), this.ENP);
    com.tencent.mm.sdk.b.a.IbL.c(this.ENS);
    com.tencent.mm.sdk.b.a.IbL.c(this.ENT);
    this.appForegroundListener.alive();
    this.ENR.alive();
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193431);
        SightVideoJNI.registerALL();
        AppMethodBeat.o(193431);
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
      if (com.tencent.mm.compatible.util.d.lz(20))
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
    an.a locala = fae().ENO;
    if (locala != null) {
      locala.dis = 0;
    }
    e.d.b(Integer.valueOf(47), this.ENQ);
    e.d.b(Integer.valueOf(49), this.ENP);
    this.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.IbL.d(this.ENS);
    com.tencent.mm.sdk.b.a.IbL.d(this.ENT);
    this.ENR.dead();
    com.tencent.mm.pluginsdk.model.l.eZx();
    AppMethodBeat.o(31132);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao
 * JD-Core Version:    0.7.0.1
 */