package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wear.model.e.f;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.o;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements be
{
  private static boolean PrD = false;
  private j PrA;
  private com.tencent.mm.plugin.wear.model.g.a PrB;
  private com.tencent.mm.an.h PrC;
  private q Prs;
  private r Prt;
  private d Pru;
  private e Prv;
  private g Prw;
  private b Prx;
  private WearMessageLogic Pry;
  private i Prz;
  
  public a()
  {
    AppMethodBeat.i(29952);
    Log.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(29952);
  }
  
  private static a gOp()
  {
    AppMethodBeat.i(29953);
    bh.beC();
    a locala2 = (a)ch.RZ("plugin.wear");
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      bh.beC().a("plugin.wear", locala1);
    }
    AppMethodBeat.o(29953);
    return locala1;
  }
  
  public static e gOq()
  {
    AppMethodBeat.i(218539);
    e locale = gOp().Prv;
    AppMethodBeat.o(218539);
    return locale;
  }
  
  public static g gOr()
  {
    AppMethodBeat.i(29954);
    if (gOp().Prw == null) {
      gOp().Prw = new g();
    }
    g localg = gOp().Prw;
    AppMethodBeat.o(29954);
    return localg;
  }
  
  public static b gOs()
  {
    AppMethodBeat.i(29955);
    b localb = gOp().Prx;
    AppMethodBeat.o(29955);
    return localb;
  }
  
  public static d gOt()
  {
    AppMethodBeat.i(29956);
    d locald = gOp().Pru;
    AppMethodBeat.o(29956);
    return locald;
  }
  
  public static j gOu()
  {
    AppMethodBeat.i(29957);
    j localj = gOp().PrA;
    AppMethodBeat.o(29957);
    return localj;
  }
  
  public static com.tencent.mm.plugin.wear.model.g.a gOv()
  {
    AppMethodBeat.i(29958);
    com.tencent.mm.plugin.wear.model.g.a locala = gOp().PrB;
    AppMethodBeat.o(29958);
    return locala;
  }
  
  public static q gOw()
  {
    AppMethodBeat.i(29959);
    q localq = gOp().Prs;
    AppMethodBeat.o(29959);
    return localq;
  }
  
  public static r gOx()
  {
    AppMethodBeat.i(29960);
    r localr = gOp().Prt;
    AppMethodBeat.o(29960);
    return localr;
  }
  
  public static void gOy()
  {
    AppMethodBeat.i(218546);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVo, 1) == 1)
    {
      PrD = true;
      Log.i("MicroMsg.Wear.SubCoreWear", "set wear connect");
    }
    AppMethodBeat.o(218546);
  }
  
  public static boolean gOz()
  {
    return PrD;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(29961);
    Log.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(29961);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(29962);
    com.tencent.mm.pluginsdk.o.e.QSd = new c();
    Log.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Prs = new q();
    this.Prt = new r();
    this.PrA = new j();
    this.Prv = new e();
    this.Prw = new g();
    this.Prx = new b();
    this.Pru = new d();
    this.Pry = new WearMessageLogic();
    this.Prz = new i();
    this.PrB = new com.tencent.mm.plugin.wear.model.g.a();
    this.PrC = new com.tencent.mm.plugin.wear.model.g.b();
    h.d.a(Integer.valueOf(63), this.PrC);
    this.Prs.a(this.Pru.PrL);
    this.Prs.a(this.Pru.PrM);
    this.Prs.a(this.Pru.PrN);
    this.Prs.a(new com.tencent.mm.plugin.wear.model.e.h());
    this.Prs.a(new com.tencent.mm.plugin.wear.model.e.g());
    this.Prs.a(new com.tencent.mm.plugin.wear.model.e.d());
    this.Prs.a(new com.tencent.mm.plugin.wear.model.e.c());
    this.Prs.a(new com.tencent.mm.plugin.wear.model.e.e());
    this.Prs.a(new f());
    this.Prs.a(new k());
    this.Prs.a(new m());
    this.Prs.a(new o());
    this.Prs.a(new n());
    this.Prs.a(new l());
    this.PrA.a(new com.tencent.mm.plugin.wear.model.f.c()
    {
      public final void gOA()
      {
        AppMethodBeat.i(29950);
        a.a(a.this);
        r.a(20001, null, false);
        a.a(a.this);
        r.a(20008, null, false);
        AppMethodBeat.o(29950);
      }
      
      public final String getName()
      {
        return "PhoneStartTask";
      }
    });
    j localj = this.PrA;
    Object localObject = new com.tencent.mm.plugin.wear.model.f.c()
    {
      public final void gOA()
      {
        AppMethodBeat.i(29951);
        if (a.b(a.this).gOH() != null) {
          a.b(a.this).gOH().gOM();
        }
        a.a(a.this);
        r.a(20009, null, false);
        a.a(a.this);
        r.a(20017, null, false);
        AppMethodBeat.o(29951);
      }
      
      public final String getName()
      {
        return "SyncFileTask";
      }
    };
    if (localj.qdR != null)
    {
      localObject = localj.qdR.obtainMessage(0, localObject);
      localj.qdR.sendMessageDelayed((Message)localObject, 5000L);
    }
    AppMethodBeat.o(29962);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29964);
    h.d.b(Integer.valueOf(63), this.PrC);
    this.PrC = null;
    Log.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
    this.Prs.PsJ.clear();
    this.Prs = null;
    this.Prt = null;
    Object localObject = this.Prv;
    ((e)localObject).cts.stopTimer();
    ((e)localObject).KZK.dead();
    ((e)localObject).PrQ.dead();
    ((e)localObject).PrR.dead();
    ((e)localObject).qep.dead();
    ((e)localObject).PrS.dead();
    ((e)localObject).PrT.dead();
    ((e)localObject).PrU.dead();
    ((e)localObject).iRQ.dead();
    ((e)localObject).ECh.dead();
    bh.beI();
    com.tencent.mm.model.c.bbO().a(((e)localObject).wse);
    this.Prv = null;
    this.Prw = null;
    localObject = this.Prx;
    EventCenter.instance.removeListener(((b)localObject).PrG);
    bh.beI();
    com.tencent.mm.model.c.bbL().remove(((b)localObject).BJY);
    ((b)localObject).PrH.stopTimer();
    this.Prx = null;
    localObject = this.Pru;
    ((d)localObject).PrK.finish();
    ((d)localObject).PrO.reset();
    this.Pru = null;
    localObject = this.Pry;
    MMApplicationContext.getContext().unregisterReceiver((BroadcastReceiver)localObject);
    this.Pry = null;
    this.PrA.qdR.quit();
    this.PrA = null;
    localObject = this.Prz;
    ((i)localObject).audioManager = null;
    MMApplicationContext.getContext().unregisterReceiver(((i)localObject).Psl);
    this.Prz = null;
    PrD = false;
    AppMethodBeat.o(29964);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(29963);
    Log.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(29963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a
 * JD-Core Version:    0.7.0.1
 */