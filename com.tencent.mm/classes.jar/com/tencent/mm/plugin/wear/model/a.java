package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.o;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements aw
{
  private static boolean BWk = false;
  private q BVZ;
  private r BWa;
  private d BWb;
  private e BWc;
  private g BWd;
  private b BWe;
  private WearMessageLogic BWf;
  private i BWg;
  private j BWh;
  private com.tencent.mm.plugin.wear.model.g.a BWi;
  private com.tencent.mm.ak.f BWj;
  
  public a()
  {
    AppMethodBeat.i(29952);
    ac.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(29952);
  }
  
  private static a ewm()
  {
    AppMethodBeat.i(29953);
    az.ayG();
    a locala2 = (a)bz.yz("plugin.wear");
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      az.ayG().a("plugin.wear", locala1);
    }
    AppMethodBeat.o(29953);
    return locala1;
  }
  
  public static g ewn()
  {
    AppMethodBeat.i(29954);
    if (ewm().BWd == null) {
      ewm().BWd = new g();
    }
    g localg = ewm().BWd;
    AppMethodBeat.o(29954);
    return localg;
  }
  
  public static b ewo()
  {
    AppMethodBeat.i(29955);
    b localb = ewm().BWe;
    AppMethodBeat.o(29955);
    return localb;
  }
  
  public static d ewp()
  {
    AppMethodBeat.i(29956);
    d locald = ewm().BWb;
    AppMethodBeat.o(29956);
    return locald;
  }
  
  public static j ewq()
  {
    AppMethodBeat.i(29957);
    j localj = ewm().BWh;
    AppMethodBeat.o(29957);
    return localj;
  }
  
  public static com.tencent.mm.plugin.wear.model.g.a ewr()
  {
    AppMethodBeat.i(29958);
    com.tencent.mm.plugin.wear.model.g.a locala = ewm().BWi;
    AppMethodBeat.o(29958);
    return locala;
  }
  
  public static q ews()
  {
    AppMethodBeat.i(29959);
    q localq = ewm().BVZ;
    AppMethodBeat.o(29959);
    return localq;
  }
  
  public static r ewt()
  {
    AppMethodBeat.i(29960);
    r localr = ewm().BWa;
    AppMethodBeat.o(29960);
    return localr;
  }
  
  public static void ewu()
  {
    BWk = true;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(29961);
    ac.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(29961);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(29962);
    com.tencent.mm.pluginsdk.n.e.DfF = new c();
    ac.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.BVZ = new q();
    this.BWa = new r();
    this.BWh = new j();
    this.BWc = new e();
    this.BWd = new g();
    this.BWe = new b();
    this.BWb = new d();
    this.BWf = new WearMessageLogic();
    this.BWg = new i();
    this.BWi = new com.tencent.mm.plugin.wear.model.g.a();
    this.BWj = new com.tencent.mm.plugin.wear.model.g.b();
    f.d.a(Integer.valueOf(63), this.BWj);
    this.BVZ.a(this.BWb.BWs);
    this.BVZ.a(this.BWb.BWt);
    this.BVZ.a(this.BWb.BWu);
    this.BVZ.a(new com.tencent.mm.plugin.wear.model.e.h());
    this.BVZ.a(new com.tencent.mm.plugin.wear.model.e.g());
    this.BVZ.a(new com.tencent.mm.plugin.wear.model.e.d());
    this.BVZ.a(new com.tencent.mm.plugin.wear.model.e.c());
    this.BVZ.a(new com.tencent.mm.plugin.wear.model.e.e());
    this.BVZ.a(new com.tencent.mm.plugin.wear.model.e.f());
    this.BVZ.a(new k());
    this.BVZ.a(new m());
    this.BVZ.a(new o());
    this.BVZ.a(new n());
    this.BVZ.a(new l());
    this.BWh.a(new com.tencent.mm.plugin.wear.model.f.c()
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
    j localj = this.BWh;
    Object localObject = new com.tencent.mm.plugin.wear.model.f.c()
    {
      public final String getName()
      {
        return "SyncFileTask";
      }
      
      public final void send()
      {
        AppMethodBeat.i(29951);
        if (a.b(a.this).ewA() != null) {
          a.b(a.this).ewA().ewG();
        }
        a.a(a.this);
        r.a(20009, null, false);
        a.a(a.this);
        r.a(20017, null, false);
        AppMethodBeat.o(29951);
      }
    };
    if (localj.lso != null)
    {
      localObject = localj.lso.obtainMessage(0, localObject);
      localj.lso.sendMessageDelayed((Message)localObject, 5000L);
    }
    AppMethodBeat.o(29962);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29964);
    f.d.b(Integer.valueOf(63), this.BWj);
    this.BWj = null;
    ac.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
    this.BVZ.BXs.clear();
    this.BVZ = null;
    this.BWa = null;
    Object localObject = this.BWc;
    ((e)localObject).bYO.stopTimer();
    ((e)localObject).yTo.dead();
    ((e)localObject).BWx.dead();
    ((e)localObject).BWy.dead();
    ((e)localObject).lsM.dead();
    ((e)localObject).BWz.dead();
    ((e)localObject).BWA.dead();
    ((e)localObject).BWB.dead();
    ((e)localObject).foi.dead();
    ((e)localObject).uoq.dead();
    az.ayM();
    com.tencent.mm.model.c.awD().a(((e)localObject).qsJ);
    this.BWc = null;
    this.BWd = null;
    localObject = this.BWe;
    com.tencent.mm.sdk.b.a.GpY.d(((b)localObject).BWn);
    az.ayM();
    com.tencent.mm.model.c.awB().b(((b)localObject).szL);
    ((b)localObject).BWo.stopTimer();
    this.BWe = null;
    localObject = this.BWb;
    ((d)localObject).BWr.finish();
    ((d)localObject).BWv.reset();
    this.BWb = null;
    localObject = this.BWf;
    ai.getContext().unregisterReceiver((BroadcastReceiver)localObject);
    this.BWf = null;
    this.BWh.lso.quit();
    this.BWh = null;
    localObject = this.BWg;
    ((i)localObject).audioManager = null;
    ((i)localObject).ewB();
    ai.getContext().unregisterReceiver(((i)localObject).BWT);
    this.BWg = null;
    BWk = false;
    AppMethodBeat.o(29964);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(29963);
    ac.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(29963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a
 * JD-Core Version:    0.7.0.1
 */