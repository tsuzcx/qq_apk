package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.d;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements ax
{
  private static boolean DwE = false;
  private i DwA;
  private j DwB;
  private com.tencent.mm.plugin.wear.model.g.a DwC;
  private com.tencent.mm.al.e DwD;
  private q Dwt;
  private r Dwu;
  private d Dwv;
  private e Dww;
  private g Dwx;
  private b Dwy;
  private WearMessageLogic Dwz;
  
  public a()
  {
    AppMethodBeat.i(29952);
    ad.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(29952);
  }
  
  public static void eKA()
  {
    DwE = true;
  }
  
  private static a eKs()
  {
    AppMethodBeat.i(29953);
    ba.aBK();
    a locala2 = (a)ca.By("plugin.wear");
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      ba.aBK().a("plugin.wear", locala1);
    }
    AppMethodBeat.o(29953);
    return locala1;
  }
  
  public static g eKt()
  {
    AppMethodBeat.i(29954);
    if (eKs().Dwx == null) {
      eKs().Dwx = new g();
    }
    g localg = eKs().Dwx;
    AppMethodBeat.o(29954);
    return localg;
  }
  
  public static b eKu()
  {
    AppMethodBeat.i(29955);
    b localb = eKs().Dwy;
    AppMethodBeat.o(29955);
    return localb;
  }
  
  public static d eKv()
  {
    AppMethodBeat.i(29956);
    d locald = eKs().Dwv;
    AppMethodBeat.o(29956);
    return locald;
  }
  
  public static j eKw()
  {
    AppMethodBeat.i(29957);
    j localj = eKs().DwB;
    AppMethodBeat.o(29957);
    return localj;
  }
  
  public static com.tencent.mm.plugin.wear.model.g.a eKx()
  {
    AppMethodBeat.i(29958);
    com.tencent.mm.plugin.wear.model.g.a locala = eKs().DwC;
    AppMethodBeat.o(29958);
    return locala;
  }
  
  public static q eKy()
  {
    AppMethodBeat.i(29959);
    q localq = eKs().Dwt;
    AppMethodBeat.o(29959);
    return localq;
  }
  
  public static r eKz()
  {
    AppMethodBeat.i(29960);
    r localr = eKs().Dwu;
    AppMethodBeat.o(29960);
    return localr;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(29961);
    ad.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(29961);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(29962);
    com.tencent.mm.pluginsdk.o.e.EJB = new c();
    ad.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Dwt = new q();
    this.Dwu = new r();
    this.DwB = new j();
    this.Dww = new e();
    this.Dwx = new g();
    this.Dwy = new b();
    this.Dwv = new d();
    this.Dwz = new WearMessageLogic();
    this.DwA = new i();
    this.DwC = new com.tencent.mm.plugin.wear.model.g.a();
    this.DwD = new com.tencent.mm.plugin.wear.model.g.b();
    e.d.a(Integer.valueOf(63), this.DwD);
    this.Dwt.a(this.Dwv.DwM);
    this.Dwt.a(this.Dwv.DwN);
    this.Dwt.a(this.Dwv.DwO);
    this.Dwt.a(new h());
    this.Dwt.a(new com.tencent.mm.plugin.wear.model.e.g());
    this.Dwt.a(new com.tencent.mm.plugin.wear.model.e.d());
    this.Dwt.a(new com.tencent.mm.plugin.wear.model.e.c());
    this.Dwt.a(new com.tencent.mm.plugin.wear.model.e.e());
    this.Dwt.a(new f());
    this.Dwt.a(new k());
    this.Dwt.a(new m());
    this.Dwt.a(new o());
    this.Dwt.a(new n());
    this.Dwt.a(new l());
    this.DwB.a(new com.tencent.mm.plugin.wear.model.f.c()
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
    j localj = this.DwB;
    Object localObject = new com.tencent.mm.plugin.wear.model.f.c()
    {
      public final String getName()
      {
        return "SyncFileTask";
      }
      
      public final void send()
      {
        AppMethodBeat.i(29951);
        if (a.b(a.this).eKG() != null) {
          a.b(a.this).eKG().eKM();
        }
        a.a(a.this);
        r.a(20009, null, false);
        a.a(a.this);
        r.a(20017, null, false);
        AppMethodBeat.o(29951);
      }
    };
    if (localj.lRx != null)
    {
      localObject = localj.lRx.obtainMessage(0, localObject);
      localj.lRx.sendMessageDelayed((Message)localObject, 5000L);
    }
    AppMethodBeat.o(29962);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29964);
    e.d.b(Integer.valueOf(63), this.DwD);
    this.DwD = null;
    ad.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
    this.Dwt.DxL.clear();
    this.Dwt = null;
    this.Dwu = null;
    Object localObject = this.Dww;
    ((e)localObject).cjg.stopTimer();
    ((e)localObject).AkV.dead();
    ((e)localObject).DwR.dead();
    ((e)localObject).DwS.dead();
    ((e)localObject).lRV.dead();
    ((e)localObject).DwT.dead();
    ((e)localObject).DwU.dead();
    ((e)localObject).DwV.dead();
    ((e)localObject).fGq.dead();
    ((e)localObject).vqU.dead();
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(((e)localObject).rcx);
    this.Dww = null;
    this.Dwx = null;
    localObject = this.Dwy;
    com.tencent.mm.sdk.b.a.IbL.d(((b)localObject).DwH);
    ba.aBQ();
    com.tencent.mm.model.c.azp().b(((b)localObject).twm);
    ((b)localObject).DwI.stopTimer();
    this.Dwy = null;
    localObject = this.Dwv;
    ((d)localObject).DwL.finish();
    ((d)localObject).DwP.reset();
    this.Dwv = null;
    localObject = this.Dwz;
    aj.getContext().unregisterReceiver((BroadcastReceiver)localObject);
    this.Dwz = null;
    this.DwB.lRx.quit();
    this.DwB = null;
    localObject = this.DwA;
    ((i)localObject).audioManager = null;
    ((i)localObject).eKH();
    aj.getContext().unregisterReceiver(((i)localObject).Dxm);
    this.DwA = null;
    DwE = false;
    AppMethodBeat.o(29964);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(29963);
    ad.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(29963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a
 * JD-Core Version:    0.7.0.1
 */