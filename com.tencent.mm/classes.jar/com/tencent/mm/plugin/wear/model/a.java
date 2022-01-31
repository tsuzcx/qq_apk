package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mm.ah.e.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
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
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.util.HashMap;

public final class a
  implements ar
{
  public j qRA;
  public com.tencent.mm.plugin.wear.model.g.a qRB;
  private com.tencent.mm.ah.e qRC;
  q qRs;
  public r qRt;
  public d qRu;
  private e qRv;
  public g qRw;
  public b qRx;
  private WearMessageLogic qRy;
  private i qRz;
  
  public a()
  {
    y.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", new Object[] { getClass().getClassLoader() });
  }
  
  public static a bYL()
  {
    au.Hq();
    a locala2 = (a)bu.iR("plugin.wear");
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      au.Hq().a("plugin.wear", locala1);
    }
    return locala1;
  }
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.pluginsdk.o.f.rSG = new c();
    y.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.qRs = new q();
    this.qRt = new r();
    this.qRA = new j();
    this.qRv = new e();
    this.qRw = new g();
    this.qRx = new b();
    this.qRu = new d();
    this.qRy = new WearMessageLogic();
    this.qRz = new i();
    this.qRB = new com.tencent.mm.plugin.wear.model.g.a();
    this.qRC = new com.tencent.mm.plugin.wear.model.g.b();
    e.d.a(Integer.valueOf(63), this.qRC);
    this.qRs.a(this.qRu.qRK);
    this.qRs.a(this.qRu.qRL);
    this.qRs.a(this.qRu.qRM);
    this.qRs.a(new h());
    this.qRs.a(new com.tencent.mm.plugin.wear.model.e.g());
    this.qRs.a(new com.tencent.mm.plugin.wear.model.e.d());
    this.qRs.a(new com.tencent.mm.plugin.wear.model.e.c());
    this.qRs.a(new com.tencent.mm.plugin.wear.model.e.e());
    this.qRs.a(new f());
    this.qRs.a(new k());
    this.qRs.a(new m());
    this.qRs.a(new o());
    this.qRs.a(new n());
    this.qRs.a(new l());
    this.qRA.a(new a.1(this));
    j localj = this.qRA;
    Object localObject = new a.2(this);
    if (localj.gNQ != null)
    {
      localObject = localj.gNQ.obtainMessage(0, localObject);
      localj.gNQ.sendMessageDelayed((Message)localObject, 5000L);
    }
  }
  
  public final void bi(boolean paramBoolean)
  {
    y.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public final void gf(int paramInt)
  {
    y.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public final void onAccountRelease()
  {
    e.d.b(Integer.valueOf(63), this.qRC);
    this.qRC = null;
    y.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
    this.qRs.qSM.clear();
    this.qRs = null;
    this.qRt = null;
    Object localObject = this.qRv;
    ((e)localObject).fjC.stopTimer();
    ((e)localObject).peY.dead();
    ((e)localObject).qRQ.dead();
    ((e)localObject).qRR.dead();
    ((e)localObject).gOo.dead();
    ((e)localObject).qRS.dead();
    ((e)localObject).qRT.dead();
    ((e)localObject).qRU.dead();
    ((e)localObject).dji.dead();
    ((e)localObject).lRT.dead();
    au.Hx();
    com.tencent.mm.model.c.Fy().a(((e)localObject).jJv);
    this.qRv = null;
    this.qRw = null;
    localObject = this.qRx;
    com.tencent.mm.sdk.b.a.udP.d(((b)localObject).qRF);
    au.Hx();
    com.tencent.mm.model.c.Fw().b(((b)localObject).kyl);
    ((b)localObject).qRG.stopTimer();
    this.qRx = null;
    localObject = this.qRu;
    ((d)localObject).qRJ.finish();
    ((d)localObject).qRN.reset();
    this.qRu = null;
    localObject = this.qRy;
    ae.getContext().unregisterReceiver((BroadcastReceiver)localObject);
    this.qRy = null;
    localObject = this.qRA;
    if (((j)localObject).handlerThread != null) {
      ((j)localObject).handlerThread.quit();
    }
    this.qRA = null;
    localObject = this.qRz;
    ((i)localObject).dui = null;
    ((i)localObject).bYS();
    ae.getContext().unregisterReceiver(((i)localObject).qSn);
    this.qRz = null;
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a
 * JD-Core Version:    0.7.0.1
 */