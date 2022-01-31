package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements at
{
  private static j.a appForegroundListener;
  private static f pjp;
  com.tencent.mm.plugin.notification.c.c pjq;
  com.tencent.mm.plugin.notification.c.c pjr;
  private com.tencent.mm.plugin.notification.a.a pjs;
  private boolean pjt;
  private com.tencent.mm.sdk.b.c pju;
  private com.tencent.mm.sdk.b.c pjv;
  private com.tencent.mm.sdk.b.c pjw;
  private com.tencent.mm.sdk.b.c pjx;
  private com.tencent.mm.sdk.b.c pjy;
  private com.tencent.mm.sdk.b.c pjz;
  
  static
  {
    AppMethodBeat.i(153554);
    pjp = null;
    appForegroundListener = new f.7();
    AppMethodBeat.o(153554);
  }
  
  private f()
  {
    AppMethodBeat.i(23185);
    this.pjq = null;
    this.pjr = null;
    this.pjs = null;
    this.pjt = false;
    this.pju = new f.1(this);
    this.pjv = new f.2(this);
    this.pjw = new f.3(this);
    this.pjx = new f.4(this);
    this.pjy = new f.5(this);
    this.pjz = new f.6(this);
    b.init();
    if (this.pjr == null) {
      this.pjr = new e();
    }
    if (this.pjq == null) {
      this.pjq = new d();
    }
    AppMethodBeat.o(23185);
  }
  
  public static FailSendMsgNotification AV(int paramInt)
  {
    AppMethodBeat.i(23186);
    FailSendMsgNotification localFailSendMsgNotification;
    if ((paramInt == 2) && (bYn().pjr != null))
    {
      ab.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
      localFailSendMsgNotification = bYn().pjr.bXZ();
      AppMethodBeat.o(23186);
      return localFailSendMsgNotification;
    }
    if ((paramInt == 1) && (bYn().pjq != null))
    {
      ab.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
      localFailSendMsgNotification = bYn().pjq.bXZ();
      AppMethodBeat.o(23186);
      return localFailSendMsgNotification;
    }
    AppMethodBeat.o(23186);
    return null;
  }
  
  public static boolean aJh()
  {
    AppMethodBeat.i(23190);
    boolean bool = bYn().pjt;
    AppMethodBeat.o(23190);
    return bool;
  }
  
  public static ArrayList<Long> ae(bi parambi)
  {
    AppMethodBeat.i(23191);
    if (parambi == null)
    {
      AppMethodBeat.o(23191);
      return null;
    }
    aw.aaz();
    com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
    Object localObject = ((j)g.E(j.class)).bPQ().bQb();
    parambi = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parambi.add(Long.valueOf(((bi)((Iterator)localObject).next()).field_msgId));
    }
    AppMethodBeat.o(23191);
    return parambi;
  }
  
  public static f bYn()
  {
    AppMethodBeat.i(23187);
    if (pjp == null)
    {
      pjp = new f();
      aw.aat().a("plugin.notification", pjp);
    }
    f localf = pjp;
    AppMethodBeat.o(23187);
    return localf;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(23188);
    this.pjq.bYi();
    this.pjq.bYj();
    this.pjr.bYi();
    this.pjr.bYj();
    if (this.pjs == null) {
      this.pjs = new com.tencent.mm.plugin.notification.a.a();
    }
    com.tencent.mm.plugin.notification.a.a locala = this.pjs;
    if (!aw.RG()) {
      ab.e("MicroMsg.NotificationObserver", "account not ready!");
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ymk.c(this.pju);
      com.tencent.mm.sdk.b.a.ymk.c(this.pjv);
      com.tencent.mm.sdk.b.a.ymk.c(this.pjw);
      com.tencent.mm.sdk.b.a.ymk.c(this.pjx);
      com.tencent.mm.sdk.b.a.ymk.c(this.pjy);
      com.tencent.mm.sdk.b.a.ymk.c(this.pjz);
      aw.getNotification().ih(com.tencent.mm.m.f.Nm());
      aw.getNotification().bF(false);
      ab.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
      AppMethodBeat.o(23188);
      return;
      ab.d("MicroMsg.NotificationObserver", "added");
      try
      {
        aw.aaz();
        com.tencent.mm.model.c.YF().b(locala);
        aw.aaz();
        com.tencent.mm.model.c.YF().a(locala);
        locala.pir = true;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bo.l(localException) });
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(23189);
    this.pjq.bYk();
    this.pjq.bYl();
    this.pjr.bYk();
    this.pjr.bYl();
    com.tencent.mm.plugin.notification.a.a locala;
    if (this.pjs != null)
    {
      locala = this.pjs;
      if (!aw.RG()) {}
    }
    try
    {
      aw.aaz();
      com.tencent.mm.model.c.YF().b(locala);
      com.tencent.mm.sdk.b.a.ymk.d(this.pju);
      com.tencent.mm.sdk.b.a.ymk.d(this.pjv);
      com.tencent.mm.sdk.b.a.ymk.d(this.pjw);
      com.tencent.mm.sdk.b.a.ymk.d(this.pjx);
      com.tencent.mm.sdk.b.a.ymk.d(this.pjy);
      com.tencent.mm.sdk.b.a.ymk.d(this.pjz);
      aw.getNotification().ih(0);
      aw.getNotification().bF(true);
      ab.d("MicroMsg.SubCoreNotification", "onAccountRelease");
      AppMethodBeat.o(23189);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bo.l(localException) });
      }
    }
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.f
 * JD-Core Version:    0.7.0.1
 */