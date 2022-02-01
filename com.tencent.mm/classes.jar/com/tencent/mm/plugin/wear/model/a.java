package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.wear.model.e.f;
import com.tencent.mm.plugin.wear.model.e.h;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.o;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements az
{
  private static boolean DOj = false;
  private q DNY;
  private r DNZ;
  private d DOa;
  private e DOb;
  private g DOc;
  private b DOd;
  private WearMessageLogic DOe;
  private i DOf;
  private j DOg;
  private com.tencent.mm.plugin.wear.model.g.a DOh;
  private com.tencent.mm.ak.e DOi;
  
  public a()
  {
    AppMethodBeat.i(29952);
    ae.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(29952);
  }
  
  private static a eOa()
  {
    AppMethodBeat.i(29953);
    bc.aCa();
    a locala2 = (a)cc.Ca("plugin.wear");
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      bc.aCa().a("plugin.wear", locala1);
    }
    AppMethodBeat.o(29953);
    return locala1;
  }
  
  public static g eOb()
  {
    AppMethodBeat.i(29954);
    if (eOa().DOc == null) {
      eOa().DOc = new g();
    }
    g localg = eOa().DOc;
    AppMethodBeat.o(29954);
    return localg;
  }
  
  public static b eOc()
  {
    AppMethodBeat.i(29955);
    b localb = eOa().DOd;
    AppMethodBeat.o(29955);
    return localb;
  }
  
  public static d eOd()
  {
    AppMethodBeat.i(29956);
    d locald = eOa().DOa;
    AppMethodBeat.o(29956);
    return locald;
  }
  
  public static j eOe()
  {
    AppMethodBeat.i(29957);
    j localj = eOa().DOg;
    AppMethodBeat.o(29957);
    return localj;
  }
  
  public static com.tencent.mm.plugin.wear.model.g.a eOf()
  {
    AppMethodBeat.i(29958);
    com.tencent.mm.plugin.wear.model.g.a locala = eOa().DOh;
    AppMethodBeat.o(29958);
    return locala;
  }
  
  public static q eOg()
  {
    AppMethodBeat.i(29959);
    q localq = eOa().DNY;
    AppMethodBeat.o(29959);
    return localq;
  }
  
  public static r eOh()
  {
    AppMethodBeat.i(29960);
    r localr = eOa().DNZ;
    AppMethodBeat.o(29960);
    return localr;
  }
  
  public static void eOi()
  {
    DOj = true;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(29961);
    ae.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(29961);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(29962);
    com.tencent.mm.pluginsdk.o.e.FbZ = new c();
    ae.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.DNY = new q();
    this.DNZ = new r();
    this.DOg = new j();
    this.DOb = new e();
    this.DOc = new g();
    this.DOd = new b();
    this.DOa = new d();
    this.DOe = new WearMessageLogic();
    this.DOf = new i();
    this.DOh = new com.tencent.mm.plugin.wear.model.g.a();
    this.DOi = new com.tencent.mm.plugin.wear.model.g.b();
    e.d.a(Integer.valueOf(63), this.DOi);
    this.DNY.a(this.DOa.DOr);
    this.DNY.a(this.DOa.DOs);
    this.DNY.a(this.DOa.DOt);
    this.DNY.a(new h());
    this.DNY.a(new com.tencent.mm.plugin.wear.model.e.g());
    this.DNY.a(new com.tencent.mm.plugin.wear.model.e.d());
    this.DNY.a(new com.tencent.mm.plugin.wear.model.e.c());
    this.DNY.a(new com.tencent.mm.plugin.wear.model.e.e());
    this.DNY.a(new f());
    this.DNY.a(new k());
    this.DNY.a(new m());
    this.DNY.a(new o());
    this.DNY.a(new n());
    this.DNY.a(new l());
    this.DOg.a(new com.tencent.mm.plugin.wear.model.f.c()
    {
      public final String getName()
      {
        return "PhoneStartTask";
      }
      
      public final void send()
      {
        AppMethodBeat.i(29950);
        a.a(a.this);
        r.a(20001, null, false);
        a.a(a.this);
        r.a(20008, null, false);
        AppMethodBeat.o(29950);
      }
    });
    j localj = this.DOg;
    Object localObject = new com.tencent.mm.plugin.wear.model.f.c()
    {
      public final String getName()
      {
        return "SyncFileTask";
      }
      
      public final void send()
      {
        AppMethodBeat.i(29951);
        if (a.b(a.this).eOo() != null) {
          a.b(a.this).eOo().eOu();
        }
        a.a(a.this);
        r.a(20009, null, false);
        a.a(a.this);
        r.a(20017, null, false);
        AppMethodBeat.o(29951);
      }
    };
    if (localj.lVY != null)
    {
      localObject = localj.lVY.obtainMessage(0, localObject);
      localj.lVY.sendMessageDelayed((Message)localObject, 5000L);
    }
    AppMethodBeat.o(29962);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29964);
    e.d.b(Integer.valueOf(63), this.DOi);
    this.DOi = null;
    ae.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
    this.DNY.DPq.clear();
    this.DNY = null;
    this.DNZ = null;
    Object localObject = this.DOb;
    ((e)localObject).cji.stopTimer();
    ((e)localObject).ACi.dead();
    ((e)localObject).DOw.dead();
    ((e)localObject).DOx.dead();
    ((e)localObject).lWw.dead();
    ((e)localObject).DOy.dead();
    ((e)localObject).DOz.dead();
    ((e)localObject).DOA.dead();
    ((e)localObject).fIu.dead();
    ((e)localObject).vCZ.dead();
    bc.aCg();
    com.tencent.mm.model.c.azI().a(((e)localObject).rkD);
    this.DOb = null;
    this.DOc = null;
    localObject = this.DOd;
    com.tencent.mm.sdk.b.a.IvT.d(((b)localObject).DOm);
    bc.aCg();
    com.tencent.mm.model.c.azF().b(((b)localObject).tHd);
    ((b)localObject).DOn.stopTimer();
    this.DOd = null;
    localObject = this.DOa;
    ((d)localObject).DOq.finish();
    ((d)localObject).DOu.reset();
    this.DOa = null;
    localObject = this.DOe;
    ak.getContext().unregisterReceiver((BroadcastReceiver)localObject);
    this.DOe = null;
    this.DOg.lVY.quit();
    this.DOg = null;
    localObject = this.DOf;
    ((i)localObject).audioManager = null;
    ((i)localObject).eOp();
    ak.getContext().unregisterReceiver(((i)localObject).DOR);
    this.DOf = null;
    DOj = false;
    AppMethodBeat.o(29964);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(29963);
    ae.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(29963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a
 * JD-Core Version:    0.7.0.1
 */