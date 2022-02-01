package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ci;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wear.model.e.f;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.o;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements be
{
  private static boolean Wiq = false;
  private q Wif;
  private r Wig;
  private d Wih;
  private e Wii;
  private g Wij;
  private b Wik;
  private WearMessageLogic Wil;
  private i Wim;
  private j Win;
  private com.tencent.mm.plugin.wear.model.g.a Wio;
  private com.tencent.mm.am.g Wip;
  
  public a()
  {
    AppMethodBeat.i(29952);
    Log.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(29952);
  }
  
  private static a inE()
  {
    AppMethodBeat.i(29953);
    bh.bCt();
    a locala2 = (a)ci.Ka("plugin.wear");
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      bh.bCt().a("plugin.wear", locala1);
    }
    AppMethodBeat.o(29953);
    return locala1;
  }
  
  public static e inF()
  {
    AppMethodBeat.i(261876);
    e locale = inE().Wii;
    AppMethodBeat.o(261876);
    return locale;
  }
  
  public static g inG()
  {
    AppMethodBeat.i(29954);
    if (inE().Wij == null) {
      inE().Wij = new g();
    }
    g localg = inE().Wij;
    AppMethodBeat.o(29954);
    return localg;
  }
  
  public static b inH()
  {
    AppMethodBeat.i(29955);
    b localb = inE().Wik;
    AppMethodBeat.o(29955);
    return localb;
  }
  
  public static d inI()
  {
    AppMethodBeat.i(29956);
    d locald = inE().Wih;
    AppMethodBeat.o(29956);
    return locald;
  }
  
  public static j inJ()
  {
    AppMethodBeat.i(29957);
    j localj = inE().Win;
    AppMethodBeat.o(29957);
    return localj;
  }
  
  public static com.tencent.mm.plugin.wear.model.g.a inK()
  {
    AppMethodBeat.i(29958);
    com.tencent.mm.plugin.wear.model.g.a locala = inE().Wio;
    AppMethodBeat.o(29958);
    return locala;
  }
  
  public static q inL()
  {
    AppMethodBeat.i(29959);
    q localq = inE().Wif;
    AppMethodBeat.o(29959);
    return localq;
  }
  
  public static r inM()
  {
    AppMethodBeat.i(29960);
    r localr = inE().Wig;
    AppMethodBeat.o(29960);
    return localr;
  }
  
  public static void inN()
  {
    AppMethodBeat.i(261884);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znS, 1) == 1)
    {
      Wiq = true;
      Log.i("MicroMsg.Wear.SubCoreWear", "set wear connect");
    }
    AppMethodBeat.o(261884);
  }
  
  public static boolean inO()
  {
    return Wiq;
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
    com.tencent.mm.pluginsdk.o.d.XNU = new c();
    Log.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Wif = new q();
    this.Wig = new r();
    this.Win = new j();
    this.Wii = new e();
    this.Wij = new g();
    this.Wik = new b();
    this.Wih = new d();
    this.Wil = new WearMessageLogic();
    this.Wim = new i();
    this.Wio = new com.tencent.mm.plugin.wear.model.g.a();
    this.Wip = new com.tencent.mm.plugin.wear.model.g.b();
    g.d.a(Integer.valueOf(63), this.Wip);
    this.Wif.a(this.Wih.Wiy);
    this.Wif.a(this.Wih.Wiz);
    this.Wif.a(this.Wih.WiA);
    this.Wif.a(new com.tencent.mm.plugin.wear.model.e.h());
    this.Wif.a(new com.tencent.mm.plugin.wear.model.e.g());
    this.Wif.a(new com.tencent.mm.plugin.wear.model.e.d());
    this.Wif.a(new com.tencent.mm.plugin.wear.model.e.c());
    this.Wif.a(new com.tencent.mm.plugin.wear.model.e.e());
    this.Wif.a(new f());
    this.Wif.a(new k());
    this.Wif.a(new m());
    this.Wif.a(new o());
    this.Wif.a(new n());
    this.Wif.a(new l());
    this.Win.a(new com.tencent.mm.plugin.wear.model.f.c()
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
    j localj = this.Win;
    Object localObject = new com.tencent.mm.plugin.wear.model.f.c()
    {
      public final String getName()
      {
        return "SyncFileTask";
      }
      
      public final void send()
      {
        AppMethodBeat.i(29951);
        if (a.b(a.this).inV() != null) {
          a.b(a.this).inV().ioa();
        }
        a.a(a.this);
        r.a(20009, null, false);
        a.a(a.this);
        r.a(20017, null, false);
        AppMethodBeat.o(29951);
      }
    };
    if (localj.tiG != null)
    {
      localObject = localj.tiG.obtainMessage(0, localObject);
      localj.tiG.sendMessageDelayed((Message)localObject, 5000L);
    }
    AppMethodBeat.o(29962);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29964);
    g.d.b(Integer.valueOf(63), this.Wip);
    this.Wip = null;
    Log.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
    this.Wif.Wjw.clear();
    this.Wif = null;
    this.Wig = null;
    Object localObject = this.Wii;
    ((e)localObject).eln.stopTimer();
    ((e)localObject).RzK.dead();
    ((e)localObject).WiD.dead();
    ((e)localObject).WiE.dead();
    ((e)localObject).tje.dead();
    ((e)localObject).WiF.dead();
    ((e)localObject).WiG.dead();
    ((e)localObject).WiH.dead();
    ((e)localObject).ltN.dead();
    ((e)localObject).Kvi.dead();
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(((e)localObject).zOk);
    this.Wii = null;
    this.Wij = null;
    localObject = this.Wik;
    ((b)localObject).Wit.dead();
    bh.bCz();
    com.tencent.mm.model.c.bzA().remove(((b)localObject).HuT);
    ((b)localObject).Wiu.stopTimer();
    this.Wik = null;
    localObject = this.Wih;
    ((d)localObject).Wix.finish();
    ((d)localObject).WiB.reset();
    this.Wih = null;
    localObject = this.Wil;
    MMApplicationContext.getContext().unregisterReceiver((BroadcastReceiver)localObject);
    this.Wil = null;
    this.Win.tiG.quit();
    this.Win = null;
    localObject = this.Wim;
    ((i)localObject).audioManager = null;
    MMApplicationContext.getContext().unregisterReceiver(((i)localObject).WiY);
    this.Wim = null;
    Wiq = false;
    AppMethodBeat.o(29964);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(29963);
    Log.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(29963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a
 * JD-Core Version:    0.7.0.1
 */