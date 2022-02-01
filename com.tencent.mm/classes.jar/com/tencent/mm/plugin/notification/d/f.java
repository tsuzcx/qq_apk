package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements aw
{
  private static n.a appForegroundListener;
  private static f vqQ;
  com.tencent.mm.plugin.notification.c.c vqR;
  com.tencent.mm.plugin.notification.c.c vqS;
  private com.tencent.mm.plugin.notification.a.a vqT;
  private boolean vqU;
  private com.tencent.mm.sdk.b.c vqV;
  private com.tencent.mm.sdk.b.c vqW;
  private com.tencent.mm.sdk.b.c vqX;
  private com.tencent.mm.sdk.b.c vqY;
  private com.tencent.mm.sdk.b.c vqZ;
  private com.tencent.mm.sdk.b.c vra;
  
  static
  {
    AppMethodBeat.i(26809);
    vqQ = null;
    appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(26801);
        if ((g.agM()) && (g.agP().ggT))
        {
          g.agP();
          if (!com.tencent.mm.kernel.a.afS())
          {
            paramAnonymousString = new gm();
            paramAnonymousString.dha.isActive = false;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(26801);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(26800);
        if ((g.agM()) && (g.agP().ggT))
        {
          g.agP();
          if (!com.tencent.mm.kernel.a.afS())
          {
            paramAnonymousString = new gm();
            paramAnonymousString.dha.isActive = true;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
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
    this.vqR = null;
    this.vqS = null;
    this.vqT = null;
    this.vqU = false;
    this.vqV = new com.tencent.mm.sdk.b.c() {};
    this.vqW = new com.tencent.mm.sdk.b.c() {};
    this.vqX = new com.tencent.mm.sdk.b.c() {};
    this.vqY = new com.tencent.mm.sdk.b.c() {};
    this.vqZ = new com.tencent.mm.sdk.b.c() {};
    this.vra = new com.tencent.mm.sdk.b.c() {};
    b.init();
    if (this.vqS == null) {
      this.vqS = new e();
    }
    if (this.vqR == null) {
      this.vqR = new d();
    }
    AppMethodBeat.o(26802);
  }
  
  public static FailSendMsgNotification KD(int paramInt)
  {
    AppMethodBeat.i(26803);
    FailSendMsgNotification localFailSendMsgNotification;
    if ((paramInt == 2) && (dlH().vqS != null))
    {
      ac.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
      localFailSendMsgNotification = dlH().vqS.dlt();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    if ((paramInt == 1) && (dlH().vqR != null))
    {
      ac.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
      localFailSendMsgNotification = dlH().vqR.dlt();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    AppMethodBeat.o(26803);
    return null;
  }
  
  public static ArrayList<Long> aw(bo parambo)
  {
    AppMethodBeat.i(26808);
    if (parambo == null)
    {
      AppMethodBeat.o(26808);
      return null;
    }
    az.ayM();
    com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
    Object localObject = ((k)g.ab(k.class)).dcr().dcC();
    parambo = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parambo.add(Long.valueOf(((bo)((Iterator)localObject).next()).field_msgId));
    }
    AppMethodBeat.o(26808);
    return parambo;
  }
  
  public static boolean bqq()
  {
    AppMethodBeat.i(26807);
    boolean bool = dlH().vqU;
    AppMethodBeat.o(26807);
    return bool;
  }
  
  public static f dlH()
  {
    AppMethodBeat.i(26804);
    if (vqQ == null)
    {
      vqQ = new f();
      az.ayG().a("plugin.notification", vqQ);
    }
    f localf = vqQ;
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
    this.vqR.dlC();
    this.vqR.dlD();
    this.vqS.dlC();
    this.vqS.dlD();
    if (this.vqT == null) {
      this.vqT = new com.tencent.mm.plugin.notification.a.a();
    }
    com.tencent.mm.plugin.notification.a.a locala = this.vqT;
    if (!az.agM()) {
      ac.e("MicroMsg.NotificationObserver", "account not ready!");
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.GpY.c(this.vqV);
      com.tencent.mm.sdk.b.a.GpY.c(this.vqW);
      com.tencent.mm.sdk.b.a.GpY.c(this.vqX);
      com.tencent.mm.sdk.b.a.GpY.c(this.vqY);
      com.tencent.mm.sdk.b.a.GpY.c(this.vqZ);
      com.tencent.mm.sdk.b.a.GpY.c(this.vra);
      az.getNotification().kq(com.tencent.mm.m.f.ZV());
      az.getNotification().cy(false);
      ac.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
      AppMethodBeat.o(26805);
      return;
      ac.d("MicroMsg.NotificationObserver", "added");
      try
      {
        az.ayM();
        com.tencent.mm.model.c.awG().b(locala);
        az.ayM();
        com.tencent.mm.model.c.awG().a(locala);
        locala.vpS = true;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bs.m(localException) });
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26806);
    this.vqR.dlE();
    this.vqR.dlF();
    this.vqS.dlE();
    this.vqS.dlF();
    com.tencent.mm.plugin.notification.a.a locala;
    if (this.vqT != null)
    {
      locala = this.vqT;
      if (!az.agM()) {}
    }
    try
    {
      az.ayM();
      com.tencent.mm.model.c.awG().b(locala);
      com.tencent.mm.sdk.b.a.GpY.d(this.vqV);
      com.tencent.mm.sdk.b.a.GpY.d(this.vqW);
      com.tencent.mm.sdk.b.a.GpY.d(this.vqX);
      com.tencent.mm.sdk.b.a.GpY.d(this.vqY);
      com.tencent.mm.sdk.b.a.GpY.d(this.vqZ);
      com.tencent.mm.sdk.b.a.GpY.d(this.vra);
      az.getNotification().kq(0);
      az.getNotification().cy(true);
      ac.d("MicroMsg.SubCoreNotification", "onAccountRelease");
      AppMethodBeat.o(26806);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bs.m(localException) });
      }
    }
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.f
 * JD-Core Version:    0.7.0.1
 */