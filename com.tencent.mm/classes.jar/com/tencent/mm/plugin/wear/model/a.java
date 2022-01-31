package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.wear.model.e.f;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.o;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bd;
import java.util.HashMap;

public final class a
  implements at
{
  q uGA;
  public r uGB;
  public d uGC;
  private e uGD;
  public g uGE;
  public b uGF;
  private WearMessageLogic uGG;
  private i uGH;
  public j uGI;
  public com.tencent.mm.plugin.wear.model.g.a uGJ;
  private com.tencent.mm.ai.e uGK;
  
  public a()
  {
    AppMethodBeat.i(26267);
    ab.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[] { getClass().getClassLoader() });
    AppMethodBeat.o(26267);
  }
  
  public static a cYy()
  {
    AppMethodBeat.i(26268);
    aw.aat();
    a locala2 = (a)bw.pF("plugin.wear");
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      aw.aat().a("plugin.wear", locala1);
    }
    AppMethodBeat.o(26268);
    return locala1;
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(26269);
    ab.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(26269);
  }
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26270);
    com.tencent.mm.pluginsdk.p.e.vJC = new c();
    ab.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.uGA = new q();
    this.uGB = new r();
    this.uGI = new j();
    this.uGD = new e();
    this.uGE = new g();
    this.uGF = new b();
    this.uGC = new d();
    this.uGG = new WearMessageLogic();
    this.uGH = new i();
    this.uGJ = new com.tencent.mm.plugin.wear.model.g.a();
    this.uGK = new com.tencent.mm.plugin.wear.model.g.b();
    e.d.a(Integer.valueOf(63), this.uGK);
    this.uGA.a(this.uGC.uGS);
    this.uGA.a(this.uGC.uGT);
    this.uGA.a(this.uGC.uGU);
    this.uGA.a(new com.tencent.mm.plugin.wear.model.e.h());
    this.uGA.a(new com.tencent.mm.plugin.wear.model.e.g());
    this.uGA.a(new com.tencent.mm.plugin.wear.model.e.d());
    this.uGA.a(new com.tencent.mm.plugin.wear.model.e.c());
    this.uGA.a(new com.tencent.mm.plugin.wear.model.e.e());
    this.uGA.a(new f());
    this.uGA.a(new k());
    this.uGA.a(new m());
    this.uGA.a(new o());
    this.uGA.a(new n());
    this.uGA.a(new l());
    this.uGI.a(new a.1(this));
    j localj = this.uGI;
    Object localObject = new a.2(this);
    if (localj.ipC != null)
    {
      localObject = localj.ipC.obtainMessage(0, localObject);
      localj.ipC.sendMessageDelayed((Message)localObject, 5000L);
    }
    AppMethodBeat.o(26270);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26272);
    e.d.b(Integer.valueOf(63), this.uGK);
    this.uGK = null;
    ab.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
    this.uGA.uHT.clear();
    this.uGA = null;
    this.uGB = null;
    Object localObject = this.uGD;
    ((e)localObject).bAz.stopTimer();
    ((e)localObject).rXQ.dead();
    ((e)localObject).uGY.dead();
    ((e)localObject).uGZ.dead();
    ((e)localObject).ipZ.dead();
    ((e)localObject).uHa.dead();
    ((e)localObject).uHb.dead();
    ((e)localObject).uHc.dead();
    ((e)localObject).eaA.dead();
    ((e)localObject).opW.dead();
    aw.aaz();
    com.tencent.mm.model.c.YC().a(((e)localObject).mdz);
    this.uGD = null;
    this.uGE = null;
    localObject = this.uGF;
    com.tencent.mm.sdk.b.a.ymk.d(((b)localObject).uGN);
    aw.aaz();
    com.tencent.mm.model.c.YA().b(((b)localObject).mTY);
    ((b)localObject).uGO.stopTimer();
    this.uGF = null;
    localObject = this.uGC;
    ((d)localObject).uGR.finish();
    ((d)localObject).uGV.reset();
    this.uGC = null;
    localObject = this.uGG;
    ah.getContext().unregisterReceiver((BroadcastReceiver)localObject);
    this.uGG = null;
    localObject = this.uGI;
    if (((j)localObject).handlerThread != null) {
      ((j)localObject).handlerThread.quit();
    }
    this.uGI = null;
    localObject = this.uGH;
    ((i)localObject).elW = null;
    ((i)localObject).cYF();
    ah.getContext().unregisterReceiver(((i)localObject).uHu);
    this.uGH = null;
    AppMethodBeat.o(26272);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(26271);
    ab.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(26271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a
 * JD-Core Version:    0.7.0.1
 */