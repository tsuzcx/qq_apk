package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
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
  implements bd
{
  private static boolean Ixy = false;
  private q Ixn;
  private r Ixo;
  private d Ixp;
  private e Ixq;
  private g Ixr;
  private b Ixs;
  private WearMessageLogic Ixt;
  private i Ixu;
  private j Ixv;
  private com.tencent.mm.plugin.wear.model.g.a Ixw;
  private com.tencent.mm.ak.h Ixx;
  
  public a()
  {
    AppMethodBeat.i(29952);
    Log.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(29952);
  }
  
  private static a fVJ()
  {
    AppMethodBeat.i(29953);
    bg.aVz();
    a locala2 = (a)cg.KG("plugin.wear");
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      bg.aVz().a("plugin.wear", locala1);
    }
    AppMethodBeat.o(29953);
    return locala1;
  }
  
  public static g fVK()
  {
    AppMethodBeat.i(29954);
    if (fVJ().Ixr == null) {
      fVJ().Ixr = new g();
    }
    g localg = fVJ().Ixr;
    AppMethodBeat.o(29954);
    return localg;
  }
  
  public static b fVL()
  {
    AppMethodBeat.i(29955);
    b localb = fVJ().Ixs;
    AppMethodBeat.o(29955);
    return localb;
  }
  
  public static d fVM()
  {
    AppMethodBeat.i(29956);
    d locald = fVJ().Ixp;
    AppMethodBeat.o(29956);
    return locald;
  }
  
  public static j fVN()
  {
    AppMethodBeat.i(29957);
    j localj = fVJ().Ixv;
    AppMethodBeat.o(29957);
    return localj;
  }
  
  public static com.tencent.mm.plugin.wear.model.g.a fVO()
  {
    AppMethodBeat.i(29958);
    com.tencent.mm.plugin.wear.model.g.a locala = fVJ().Ixw;
    AppMethodBeat.o(29958);
    return locala;
  }
  
  public static q fVP()
  {
    AppMethodBeat.i(29959);
    q localq = fVJ().Ixn;
    AppMethodBeat.o(29959);
    return localq;
  }
  
  public static r fVQ()
  {
    AppMethodBeat.i(29960);
    r localr = fVJ().Ixo;
    AppMethodBeat.o(29960);
    return localr;
  }
  
  public static void fVR()
  {
    Ixy = true;
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
    com.tencent.mm.pluginsdk.o.e.JSY = new c();
    Log.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Ixn = new q();
    this.Ixo = new r();
    this.Ixv = new j();
    this.Ixq = new e();
    this.Ixr = new g();
    this.Ixs = new b();
    this.Ixp = new d();
    this.Ixt = new WearMessageLogic();
    this.Ixu = new i();
    this.Ixw = new com.tencent.mm.plugin.wear.model.g.a();
    this.Ixx = new com.tencent.mm.plugin.wear.model.g.b();
    h.d.a(Integer.valueOf(63), this.Ixx);
    this.Ixn.a(this.Ixp.IxG);
    this.Ixn.a(this.Ixp.IxH);
    this.Ixn.a(this.Ixp.IxI);
    this.Ixn.a(new com.tencent.mm.plugin.wear.model.e.h());
    this.Ixn.a(new com.tencent.mm.plugin.wear.model.e.g());
    this.Ixn.a(new com.tencent.mm.plugin.wear.model.e.d());
    this.Ixn.a(new com.tencent.mm.plugin.wear.model.e.c());
    this.Ixn.a(new com.tencent.mm.plugin.wear.model.e.e());
    this.Ixn.a(new f());
    this.Ixn.a(new k());
    this.Ixn.a(new m());
    this.Ixn.a(new o());
    this.Ixn.a(new n());
    this.Ixn.a(new l());
    this.Ixv.a(new com.tencent.mm.plugin.wear.model.f.c()
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
    j localj = this.Ixv;
    Object localObject = new com.tencent.mm.plugin.wear.model.f.c()
    {
      public final String getName()
      {
        return "SyncFileTask";
      }
      
      public final void send()
      {
        AppMethodBeat.i(29951);
        if (a.b(a.this).fVX() != null) {
          a.b(a.this).fVX().fWd();
        }
        a.a(a.this);
        r.a(20009, null, false);
        a.a(a.this);
        r.a(20017, null, false);
        AppMethodBeat.o(29951);
      }
    };
    if (localj.ndA != null)
    {
      localObject = localj.ndA.obtainMessage(0, localObject);
      localj.ndA.sendMessageDelayed((Message)localObject, 5000L);
    }
    AppMethodBeat.o(29962);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29964);
    h.d.b(Integer.valueOf(63), this.Ixx);
    this.Ixx = null;
    Log.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
    this.Ixn.IyG.clear();
    this.Ixn = null;
    this.Ixo = null;
    Object localObject = this.Ixq;
    ((e)localObject).cve.stopTimer();
    ((e)localObject).ELJ.dead();
    ((e)localObject).IxL.dead();
    ((e)localObject).IxM.dead();
    ((e)localObject).ndY.dead();
    ((e)localObject).IxN.dead();
    ((e)localObject).IxO.dead();
    ((e)localObject).IxP.dead();
    ((e)localObject).gnH.dead();
    ((e)localObject).yYb.dead();
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(((e)localObject).sMj);
    this.Ixq = null;
    this.Ixr = null;
    localObject = this.Ixs;
    EventCenter.instance.removeListener(((b)localObject).IxB);
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(((b)localObject).wYc);
    ((b)localObject).IxC.stopTimer();
    this.Ixs = null;
    localObject = this.Ixp;
    ((d)localObject).IxF.finish();
    ((d)localObject).IxJ.reset();
    this.Ixp = null;
    localObject = this.Ixt;
    MMApplicationContext.getContext().unregisterReceiver((BroadcastReceiver)localObject);
    this.Ixt = null;
    this.Ixv.ndA.quit();
    this.Ixv = null;
    localObject = this.Ixu;
    ((i)localObject).audioManager = null;
    ((i)localObject).fVY();
    MMApplicationContext.getContext().unregisterReceiver(((i)localObject).Iyh);
    this.Ixu = null;
    Ixy = false;
    AppMethodBeat.o(29964);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(29963);
    Log.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(29963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a
 * JD-Core Version:    0.7.0.1
 */