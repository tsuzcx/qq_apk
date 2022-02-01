package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.app.f;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.jk;
import com.tencent.mm.autogen.a.u;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ci;
import com.tencent.mm.plugin.openapi.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class as
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private t XTs;
  private ar.a XTt;
  private k XTu;
  private com.tencent.mm.pluginsdk.model.i XTv;
  private IListener<jk> XTw;
  private IListener<u> XTx;
  private IListener XTy;
  private IListener XTz;
  private q.a appForegroundListener;
  
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
    baseDBFactories.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return t.SQL_CREATE;
      }
    });
    AppMethodBeat.o(31134);
  }
  
  public as()
  {
    AppMethodBeat.i(31121);
    this.XTt = null;
    this.XTu = new k();
    this.XTv = new com.tencent.mm.pluginsdk.model.i();
    this.XTw = new SubCorePluginBase.1(this, f.hfK);
    this.XTx = new SubCorePluginBase.2(this, f.hfK);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(244851);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          com.tencent.mm.kernel.b.aZG();
        }
        AppMethodBeat.o(244851);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(244846);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          if (!com.tencent.mm.kernel.b.aZG()) {
            com.tencent.mm.blink.b.aJY().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(244875);
                as.iIL().run();
                AppMethodBeat.o(244875);
              }
            });
          }
        }
        AppMethodBeat.o(244846);
      }
    };
    this.XTy = new SubCorePluginBase.7(this, f.hfK);
    this.XTz = new SubCorePluginBase.8(this, f.hfK);
    AppMethodBeat.o(31121);
  }
  
  public static d cWJ()
  {
    AppMethodBeat.i(31124);
    d locald = a.cWJ();
    AppMethodBeat.o(31124);
    return locald;
  }
  
  public static i gxm()
  {
    AppMethodBeat.i(31125);
    i locali = a.gxm();
    AppMethodBeat.o(31125);
    return locali;
  }
  
  public static j gxn()
  {
    AppMethodBeat.i(31126);
    j localj = a.gxn();
    AppMethodBeat.o(31126);
    return localj;
  }
  
  public static q gxp()
  {
    AppMethodBeat.i(31130);
    q localq = a.gxp();
    AppMethodBeat.o(31130);
    return localq;
  }
  
  public static e gxq()
  {
    AppMethodBeat.i(31131);
    e locale = a.gxq();
    AppMethodBeat.o(31131);
    return locale;
  }
  
  private static as iIH()
  {
    AppMethodBeat.i(31122);
    bh.bCt();
    as localas2 = (as)ci.Ka(as.class.getName());
    as localas1 = localas2;
    if (localas2 == null) {
      localas1 = new as();
    }
    AppMethodBeat.o(31122);
    return localas1;
  }
  
  public static k iII()
  {
    AppMethodBeat.i(31123);
    k localk = iIH().XTu;
    AppMethodBeat.o(31123);
    return localk;
  }
  
  public static l iIJ()
  {
    AppMethodBeat.i(31127);
    l locall = a.gxo();
    AppMethodBeat.o(31127);
    return locall;
  }
  
  public static t iIK()
  {
    AppMethodBeat.i(31128);
    h.baC().aZJ();
    if (iIH().XTs == null)
    {
      localObject = iIH();
      bh.bCz();
      ((as)localObject).XTs = new t(c.getDataDB());
    }
    Object localObject = iIH().XTs;
    AppMethodBeat.o(31128);
    return localObject;
  }
  
  public static ar.a iIL()
  {
    AppMethodBeat.i(31129);
    h.baC().aZJ();
    if (iIH().XTt == null) {
      iIH().XTt = new ar.a();
    }
    ar.a locala = iIH().XTt;
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
    com.tencent.mm.model.am.a.okN = a.gxm();
    g.d.a(Integer.valueOf(47), this.XTv);
    g.d.a(Integer.valueOf(49), this.XTu);
    this.XTy.alive();
    this.XTz.alive();
    this.appForegroundListener.alive();
    this.XTw.alive();
    this.XTx.alive();
    Runnable local3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(244850);
        SightVideoJNI.registerALL();
        AppMethodBeat.o(244850);
      }
    };
    try
    {
      local3.run();
      AppMethodBeat.o(31133);
      return;
    }
    finally
    {
      if (com.tencent.mm.compatible.util.d.rc(20))
      {
        local3.run();
        AppMethodBeat.o(31133);
        return;
      }
      AppMethodBeat.o(31133);
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(31132);
    ar.a locala = iIH().XTt;
    if (locala != null) {
      locala.hxJ = 0;
    }
    g.d.b(Integer.valueOf(47), this.XTv);
    g.d.b(Integer.valueOf(49), this.XTu);
    this.appForegroundListener.dead();
    this.XTy.dead();
    this.XTz.dead();
    this.XTw.dead();
    this.XTx.dead();
    com.tencent.mm.pluginsdk.model.q.iHS();
    AppMethodBeat.o(31132);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.as
 * JD-Core Version:    0.7.0.1
 */