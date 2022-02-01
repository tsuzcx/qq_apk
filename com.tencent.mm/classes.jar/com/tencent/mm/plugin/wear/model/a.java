package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements aw
{
  private static boolean ADQ = false;
  private q ADF;
  private r ADG;
  private d ADH;
  private e ADI;
  private g ADJ;
  private b ADK;
  private WearMessageLogic ADL;
  private i ADM;
  private j ADN;
  private com.tencent.mm.plugin.wear.model.g.a ADO;
  private com.tencent.mm.al.f ADP;
  
  public a()
  {
    AppMethodBeat.i(29952);
    ad.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(29952);
  }
  
  private static a egS()
  {
    AppMethodBeat.i(29953);
    az.arP();
    a locala2 = (a)bz.ut("plugin.wear");
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      az.arP().a("plugin.wear", locala1);
    }
    AppMethodBeat.o(29953);
    return locala1;
  }
  
  public static g egT()
  {
    AppMethodBeat.i(29954);
    if (egS().ADJ == null) {
      egS().ADJ = new g();
    }
    g localg = egS().ADJ;
    AppMethodBeat.o(29954);
    return localg;
  }
  
  public static b egU()
  {
    AppMethodBeat.i(29955);
    b localb = egS().ADK;
    AppMethodBeat.o(29955);
    return localb;
  }
  
  public static d egV()
  {
    AppMethodBeat.i(29956);
    d locald = egS().ADH;
    AppMethodBeat.o(29956);
    return locald;
  }
  
  public static j egW()
  {
    AppMethodBeat.i(29957);
    j localj = egS().ADN;
    AppMethodBeat.o(29957);
    return localj;
  }
  
  public static com.tencent.mm.plugin.wear.model.g.a egX()
  {
    AppMethodBeat.i(29958);
    com.tencent.mm.plugin.wear.model.g.a locala = egS().ADO;
    AppMethodBeat.o(29958);
    return locala;
  }
  
  public static q egY()
  {
    AppMethodBeat.i(29959);
    q localq = egS().ADF;
    AppMethodBeat.o(29959);
    return localq;
  }
  
  public static r egZ()
  {
    AppMethodBeat.i(29960);
    r localr = egS().ADG;
    AppMethodBeat.o(29960);
    return localr;
  }
  
  public static void eha()
  {
    ADQ = true;
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
    com.tencent.mm.pluginsdk.n.e.BNv = new c();
    ad.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ADF = new q();
    this.ADG = new r();
    this.ADN = new j();
    this.ADI = new e();
    this.ADJ = new g();
    this.ADK = new b();
    this.ADH = new d();
    this.ADL = new WearMessageLogic();
    this.ADM = new i();
    this.ADO = new com.tencent.mm.plugin.wear.model.g.a();
    this.ADP = new com.tencent.mm.plugin.wear.model.g.b();
    f.d.a(Integer.valueOf(63), this.ADP);
    this.ADF.a(this.ADH.ADY);
    this.ADF.a(this.ADH.ADZ);
    this.ADF.a(this.ADH.AEa);
    this.ADF.a(new com.tencent.mm.plugin.wear.model.e.h());
    this.ADF.a(new com.tencent.mm.plugin.wear.model.e.g());
    this.ADF.a(new com.tencent.mm.plugin.wear.model.e.d());
    this.ADF.a(new com.tencent.mm.plugin.wear.model.e.c());
    this.ADF.a(new com.tencent.mm.plugin.wear.model.e.e());
    this.ADF.a(new com.tencent.mm.plugin.wear.model.e.f());
    this.ADF.a(new k());
    this.ADF.a(new m());
    this.ADF.a(new o());
    this.ADF.a(new n());
    this.ADF.a(new l());
    this.ADN.a(new com.tencent.mm.plugin.wear.model.f.c()
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
    j localj = this.ADN;
    Object localObject = new com.tencent.mm.plugin.wear.model.f.c()
    {
      public final String getName()
      {
        return "SyncFileTask";
      }
      
      public final void send()
      {
        AppMethodBeat.i(29951);
        if (a.b(a.this).ehg() != null) {
          a.b(a.this).ehg().ehm();
        }
        a.a(a.this);
        r.a(20009, null, false);
        a.a(a.this);
        r.a(20017, null, false);
        AppMethodBeat.o(29951);
      }
    };
    if (localj.kQO != null)
    {
      localObject = localj.kQO.obtainMessage(0, localObject);
      localj.kQO.sendMessageDelayed((Message)localObject, 5000L);
    }
    AppMethodBeat.o(29962);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(29964);
    f.d.b(Integer.valueOf(63), this.ADP);
    this.ADP = null;
    ad.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
    this.ADF.AEY.clear();
    this.ADF = null;
    this.ADG = null;
    Object localObject = this.ADI;
    ((e)localObject).cbR.stopTimer();
    ((e)localObject).xGB.dead();
    ((e)localObject).AEd.dead();
    ((e)localObject).AEe.dead();
    ((e)localObject).kRm.dead();
    ((e)localObject).AEf.dead();
    ((e)localObject).AEg.dead();
    ((e)localObject).AEh.dead();
    ((e)localObject).fkO.dead();
    ((e)localObject).tgb.dead();
    az.arV();
    com.tencent.mm.model.c.apO().a(((e)localObject).pKc);
    this.ADI = null;
    this.ADJ = null;
    localObject = this.ADK;
    com.tencent.mm.sdk.b.a.ESL.d(((b)localObject).ADT);
    az.arV();
    com.tencent.mm.model.c.apM().b(((b)localObject).rqR);
    ((b)localObject).ADU.stopTimer();
    this.ADK = null;
    localObject = this.ADH;
    ((d)localObject).ADX.finish();
    ((d)localObject).AEb.reset();
    this.ADH = null;
    localObject = this.ADL;
    aj.getContext().unregisterReceiver((BroadcastReceiver)localObject);
    this.ADL = null;
    this.ADN.kQO.quit();
    this.ADN = null;
    localObject = this.ADM;
    ((i)localObject).audioManager = null;
    ((i)localObject).ehh();
    aj.getContext().unregisterReceiver(((i)localObject).AEz);
    this.ADM = null;
    ADQ = false;
    AppMethodBeat.o(29964);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(29963);
    ad.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(29963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a
 * JD-Core Version:    0.7.0.1
 */