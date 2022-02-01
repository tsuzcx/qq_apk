package com.tencent.mm.plugin.notification.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.hm;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.notification.a.a;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements be
{
  private static f MwP;
  private static q.a appForegroundListener;
  com.tencent.mm.plugin.notification.base.c MwQ;
  com.tencent.mm.plugin.notification.base.c MwR;
  private a MwS;
  private IListener MwT;
  private IListener MwU;
  private IListener MwV;
  private IListener MwW;
  private IListener MwX;
  private IListener MwY;
  private boolean tAh;
  
  static
  {
    AppMethodBeat.i(26809);
    MwP = null;
    appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(26801);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG())
          {
            paramAnonymousString = new hm();
            paramAnonymousString.hIu.isActive = false;
            paramAnonymousString.publish();
          }
        }
        AppMethodBeat.o(26801);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(26800);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!com.tencent.mm.kernel.b.aZG())
          {
            paramAnonymousString = new hm();
            paramAnonymousString.hIu.isActive = true;
            paramAnonymousString.publish();
          }
        }
        AppMethodBeat.o(26800);
      }
    };
    AppMethodBeat.o(26809);
  }
  
  private f()
  {
    AppMethodBeat.i(26802);
    this.MwQ = null;
    this.MwR = null;
    this.MwS = null;
    this.tAh = false;
    this.MwT = new SubCoreNotification.1(this, com.tencent.mm.app.f.hfK);
    this.MwU = new SubCoreNotification.2(this, com.tencent.mm.app.f.hfK);
    this.MwV = new SubCoreNotification.3(this, com.tencent.mm.app.f.hfK);
    this.MwW = new SubCoreNotification.4(this, com.tencent.mm.app.f.hfK);
    this.MwX = new SubCoreNotification.5(this, com.tencent.mm.app.f.hfK);
    this.MwY = new SubCoreNotification.6(this, com.tencent.mm.app.f.hfK);
    b.init();
    if (this.MwR == null) {
      this.MwR = new e();
    }
    if (this.MwQ == null) {
      this.MwQ = new d();
    }
    AppMethodBeat.o(26802);
  }
  
  public static FailSendMsgNotification afa(int paramInt)
  {
    AppMethodBeat.i(26803);
    FailSendMsgNotification localFailSendMsgNotification;
    if ((paramInt == 2) && (guR().MwR != null))
    {
      Log.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
      localFailSendMsgNotification = guR().MwR.guC();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    if ((paramInt == 1) && (guR().MwQ != null))
    {
      Log.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
      localFailSendMsgNotification = guR().MwQ.guC();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    AppMethodBeat.o(26803);
    return null;
  }
  
  public static boolean atA()
  {
    AppMethodBeat.i(26807);
    boolean bool = guR().tAh;
    AppMethodBeat.o(26807);
    return bool;
  }
  
  public static ArrayList<Long> bk(cc paramcc)
  {
    AppMethodBeat.i(26808);
    if (paramcc == null)
    {
      AppMethodBeat.o(26808);
      return null;
    }
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().gbl();
    paramcc = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramcc.add(Long.valueOf(((cc)((Iterator)localObject).next()).field_msgId));
    }
    AppMethodBeat.o(26808);
    return paramcc;
  }
  
  public static f guR()
  {
    AppMethodBeat.i(26804);
    if (MwP == null) {
      MwP = new f();
    }
    f localf = MwP;
    AppMethodBeat.o(26804);
    return localf;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26805);
    this.MwQ.guL();
    this.MwQ.guM();
    this.MwR.guL();
    this.MwR.guM();
    if (this.MwS == null) {
      this.MwS = new a();
    }
    a locala = this.MwS;
    if (!bh.baz()) {
      Log.e("MicroMsg.NotificationObserver", "account not ready!");
    }
    for (;;)
    {
      this.MwT.alive();
      this.MwU.alive();
      this.MwV.alive();
      this.MwW.alive();
      this.MwX.alive();
      this.MwY.alive();
      bh.getNotification().qg(com.tencent.mm.k.h.aRz());
      bh.getNotification().ev(false);
      Log.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
      AppMethodBeat.o(26805);
      return;
      Log.d("MicroMsg.NotificationObserver", "added");
      try
      {
        bh.bCz();
        com.tencent.mm.model.c.bzG().remove(locala);
        bh.bCz();
        com.tencent.mm.model.c.bzG().add(locala);
        locala.MvP = true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26806);
    this.MwQ.guN();
    this.MwQ.guO();
    this.MwR.guN();
    this.MwR.guO();
    a locala;
    if (this.MwS != null)
    {
      locala = this.MwS;
      if (!bh.baz()) {}
    }
    try
    {
      bh.bCz();
      com.tencent.mm.model.c.bzG().remove(locala);
      this.MwT.dead();
      this.MwU.dead();
      this.MwV.dead();
      this.MwW.dead();
      this.MwX.dead();
      this.MwY.dead();
      bh.getNotification().qg(0);
      bh.getNotification().ev(true);
      Log.d("MicroMsg.SubCoreNotification", "onAccountRelease");
      AppMethodBeat.o(26806);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.model.f
 * JD-Core Version:    0.7.0.1
 */