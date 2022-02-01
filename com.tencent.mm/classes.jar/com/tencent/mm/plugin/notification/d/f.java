package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements bd
{
  private static f AHw;
  private static o.a appForegroundListener;
  private IListener AHA;
  private IListener AHB;
  private IListener AHC;
  private IListener AHD;
  private IListener AHE;
  private IListener AHF;
  com.tencent.mm.plugin.notification.c.c AHx;
  com.tencent.mm.plugin.notification.c.c AHy;
  private com.tencent.mm.plugin.notification.a.a AHz;
  private boolean ntv;
  
  static
  {
    AppMethodBeat.i(26809);
    AHw = null;
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(26801);
        if ((com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
        {
          com.tencent.mm.kernel.g.aAf();
          if (!com.tencent.mm.kernel.a.azj())
          {
            paramAnonymousString = new gu();
            paramAnonymousString.dKP.isActive = false;
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(26801);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(26800);
        if ((com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
        {
          com.tencent.mm.kernel.g.aAf();
          if (!com.tencent.mm.kernel.a.azj())
          {
            paramAnonymousString = new gu();
            paramAnonymousString.dKP.isActive = true;
            EventCenter.instance.publish(paramAnonymousString);
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
    this.AHx = null;
    this.AHy = null;
    this.AHz = null;
    this.ntv = false;
    this.AHA = new IListener() {};
    this.AHB = new IListener() {};
    this.AHC = new IListener() {};
    this.AHD = new IListener() {};
    this.AHE = new IListener() {};
    this.AHF = new IListener() {};
    b.init();
    if (this.AHy == null) {
      this.AHy = new e();
    }
    if (this.AHx == null) {
      this.AHx = new d();
    }
    AppMethodBeat.o(26802);
  }
  
  public static boolean Pv()
  {
    AppMethodBeat.i(26807);
    boolean bool = eyV().ntv;
    AppMethodBeat.o(26807);
    return bool;
  }
  
  public static FailSendMsgNotification TU(int paramInt)
  {
    AppMethodBeat.i(26803);
    FailSendMsgNotification localFailSendMsgNotification;
    if ((paramInt == 2) && (eyV().AHy != null))
    {
      Log.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
      localFailSendMsgNotification = eyV().AHy.eyG();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    if ((paramInt == 1) && (eyV().AHx != null))
    {
      Log.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
      localFailSendMsgNotification = eyV().AHx.eyG();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    AppMethodBeat.o(26803);
    return null;
  }
  
  public static ArrayList<Long> aJ(ca paramca)
  {
    AppMethodBeat.i(26808);
    if (paramca == null)
    {
      AppMethodBeat.o(26808);
      return null;
    }
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
    Object localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().eiK();
    paramca = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramca.add(Long.valueOf(((ca)((Iterator)localObject).next()).field_msgId));
    }
    AppMethodBeat.o(26808);
    return paramca;
  }
  
  public static f eyV()
  {
    AppMethodBeat.i(26804);
    if (AHw == null) {
      AHw = new f();
    }
    f localf = AHw;
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
    this.AHx.eyP();
    this.AHx.eyQ();
    this.AHy.eyP();
    this.AHy.eyQ();
    if (this.AHz == null) {
      this.AHz = new com.tencent.mm.plugin.notification.a.a();
    }
    com.tencent.mm.plugin.notification.a.a locala = this.AHz;
    if (!bg.aAc()) {
      Log.e("MicroMsg.NotificationObserver", "account not ready!");
    }
    for (;;)
    {
      EventCenter.instance.addListener(this.AHA);
      EventCenter.instance.addListener(this.AHB);
      EventCenter.instance.addListener(this.AHC);
      EventCenter.instance.addListener(this.AHD);
      EventCenter.instance.addListener(this.AHE);
      EventCenter.instance.addListener(this.AHF);
      bg.getNotification().nR(com.tencent.mm.n.g.aqG());
      bg.getNotification().dj(false);
      Log.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
      AppMethodBeat.o(26805);
      return;
      Log.d("MicroMsg.NotificationObserver", "added");
      try
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().remove(locala);
        bg.aVF();
        com.tencent.mm.model.c.aST().add(locala);
        locala.AGx = true;
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
    this.AHx.eyR();
    this.AHx.eyS();
    this.AHy.eyR();
    this.AHy.eyS();
    com.tencent.mm.plugin.notification.a.a locala;
    if (this.AHz != null)
    {
      locala = this.AHz;
      if (!bg.aAc()) {}
    }
    try
    {
      bg.aVF();
      com.tencent.mm.model.c.aST().remove(locala);
      EventCenter.instance.removeListener(this.AHA);
      EventCenter.instance.removeListener(this.AHB);
      EventCenter.instance.removeListener(this.AHC);
      EventCenter.instance.removeListener(this.AHD);
      EventCenter.instance.removeListener(this.AHE);
      EventCenter.instance.removeListener(this.AHF);
      bg.getNotification().nR(0);
      bg.getNotification().dj(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.f
 * JD-Core Version:    0.7.0.1
 */