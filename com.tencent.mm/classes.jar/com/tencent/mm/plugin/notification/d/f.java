package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements aw
{
  private static n.a appForegroundListener;
  private static f uhS;
  com.tencent.mm.plugin.notification.c.c uhT;
  com.tencent.mm.plugin.notification.c.c uhU;
  private com.tencent.mm.plugin.notification.a.a uhV;
  private boolean uhW;
  private com.tencent.mm.sdk.b.c uhX;
  private com.tencent.mm.sdk.b.c uhY;
  private com.tencent.mm.sdk.b.c uhZ;
  private com.tencent.mm.sdk.b.c uia;
  private com.tencent.mm.sdk.b.c uib;
  private com.tencent.mm.sdk.b.c uic;
  
  static
  {
    AppMethodBeat.i(26809);
    uhS = null;
    appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(26801);
        if ((g.afw()) && (g.afz().gcn))
        {
          g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new gl();
            paramAnonymousString.djF.isActive = false;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(26801);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(26800);
        if ((g.afw()) && (g.afz().gcn))
        {
          g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new gl();
            paramAnonymousString.djF.isActive = true;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
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
    this.uhT = null;
    this.uhU = null;
    this.uhV = null;
    this.uhW = false;
    this.uhX = new com.tencent.mm.sdk.b.c() {};
    this.uhY = new com.tencent.mm.sdk.b.c() {};
    this.uhZ = new com.tencent.mm.sdk.b.c() {};
    this.uia = new com.tencent.mm.sdk.b.c() {};
    this.uib = new com.tencent.mm.sdk.b.c() {};
    this.uic = new com.tencent.mm.sdk.b.c() {};
    b.init();
    if (this.uhU == null) {
      this.uhU = new e();
    }
    if (this.uhT == null) {
      this.uhT = new d();
    }
    AppMethodBeat.o(26802);
  }
  
  public static FailSendMsgNotification IE(int paramInt)
  {
    AppMethodBeat.i(26803);
    FailSendMsgNotification localFailSendMsgNotification;
    if ((paramInt == 2) && (cXZ().uhU != null))
    {
      ad.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
      localFailSendMsgNotification = cXZ().uhU.cXL();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    if ((paramInt == 1) && (cXZ().uhT != null))
    {
      ad.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
      localFailSendMsgNotification = cXZ().uhT.cXL();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    AppMethodBeat.o(26803);
    return null;
  }
  
  public static ArrayList<Long> au(bl parambl)
  {
    AppMethodBeat.i(26808);
    if (parambl == null)
    {
      AppMethodBeat.o(26808);
      return null;
    }
    az.arV();
    com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
    Object localObject = ((k)g.ab(k.class)).cOI().cOT();
    parambl = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parambl.add(Long.valueOf(((bl)((Iterator)localObject).next()).field_msgId));
    }
    AppMethodBeat.o(26808);
    return parambl;
  }
  
  public static boolean bjz()
  {
    AppMethodBeat.i(26807);
    boolean bool = cXZ().uhW;
    AppMethodBeat.o(26807);
    return bool;
  }
  
  public static f cXZ()
  {
    AppMethodBeat.i(26804);
    if (uhS == null)
    {
      uhS = new f();
      az.arP().a("plugin.notification", uhS);
    }
    f localf = uhS;
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
    this.uhT.cXU();
    this.uhT.cXV();
    this.uhU.cXU();
    this.uhU.cXV();
    if (this.uhV == null) {
      this.uhV = new com.tencent.mm.plugin.notification.a.a();
    }
    com.tencent.mm.plugin.notification.a.a locala = this.uhV;
    if (!az.afw()) {
      ad.e("MicroMsg.NotificationObserver", "account not ready!");
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ESL.c(this.uhX);
      com.tencent.mm.sdk.b.a.ESL.c(this.uhY);
      com.tencent.mm.sdk.b.a.ESL.c(this.uhZ);
      com.tencent.mm.sdk.b.a.ESL.c(this.uia);
      com.tencent.mm.sdk.b.a.ESL.c(this.uib);
      com.tencent.mm.sdk.b.a.ESL.c(this.uic);
      az.getNotification().kt(com.tencent.mm.m.f.YZ());
      az.getNotification().cx(false);
      ad.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
      AppMethodBeat.o(26805);
      return;
      ad.d("MicroMsg.NotificationObserver", "added");
      try
      {
        az.arV();
        com.tencent.mm.model.c.apR().b(locala);
        az.arV();
        com.tencent.mm.model.c.apR().a(locala);
        locala.ugU = true;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bt.m(localException) });
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26806);
    this.uhT.cXW();
    this.uhT.cXX();
    this.uhU.cXW();
    this.uhU.cXX();
    com.tencent.mm.plugin.notification.a.a locala;
    if (this.uhV != null)
    {
      locala = this.uhV;
      if (!az.afw()) {}
    }
    try
    {
      az.arV();
      com.tencent.mm.model.c.apR().b(locala);
      com.tencent.mm.sdk.b.a.ESL.d(this.uhX);
      com.tencent.mm.sdk.b.a.ESL.d(this.uhY);
      com.tencent.mm.sdk.b.a.ESL.d(this.uhZ);
      com.tencent.mm.sdk.b.a.ESL.d(this.uia);
      com.tencent.mm.sdk.b.a.ESL.d(this.uib);
      com.tencent.mm.sdk.b.a.ESL.d(this.uic);
      az.getNotification().kt(0);
      az.getNotification().cx(true);
      ad.d("MicroMsg.SubCoreNotification", "onAccountRelease");
      AppMethodBeat.o(26806);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bt.m(localException) });
      }
    }
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.f
 * JD-Core Version:    0.7.0.1
 */