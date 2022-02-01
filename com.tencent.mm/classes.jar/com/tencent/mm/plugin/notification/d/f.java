package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements az
{
  private static o.a appForegroundListener;
  private static f wLU;
  private boolean mjb;
  com.tencent.mm.plugin.notification.c.c wLV;
  com.tencent.mm.plugin.notification.c.c wLW;
  private com.tencent.mm.plugin.notification.a.a wLX;
  private com.tencent.mm.sdk.b.c wLY;
  private com.tencent.mm.sdk.b.c wLZ;
  private com.tencent.mm.sdk.b.c wMa;
  private com.tencent.mm.sdk.b.c wMb;
  private com.tencent.mm.sdk.b.c wMc;
  private com.tencent.mm.sdk.b.c wMd;
  
  static
  {
    AppMethodBeat.i(26809);
    wLU = null;
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(26801);
        if ((g.ajM()) && (g.ajP().gDk))
        {
          g.ajP();
          if (!com.tencent.mm.kernel.a.aiT())
          {
            paramAnonymousString = new gq();
            paramAnonymousString.dtE.isActive = false;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(26801);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(26800);
        if ((g.ajM()) && (g.ajP().gDk))
        {
          g.ajP();
          if (!com.tencent.mm.kernel.a.aiT())
          {
            paramAnonymousString = new gq();
            paramAnonymousString.dtE.isActive = true;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
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
    this.wLV = null;
    this.wLW = null;
    this.wLX = null;
    this.mjb = false;
    this.wLY = new com.tencent.mm.sdk.b.c() {};
    this.wLZ = new com.tencent.mm.sdk.b.c() {};
    this.wMa = new com.tencent.mm.sdk.b.c() {};
    this.wMb = new com.tencent.mm.sdk.b.c() {};
    this.wMc = new com.tencent.mm.sdk.b.c() {};
    this.wMd = new com.tencent.mm.sdk.b.c() {};
    b.init();
    if (this.wLW == null) {
      this.wLW = new e();
    }
    if (this.wLV == null) {
      this.wLV = new d();
    }
    AppMethodBeat.o(26802);
  }
  
  public static boolean FM()
  {
    AppMethodBeat.i(26807);
    boolean bool = dzo().mjb;
    AppMethodBeat.o(26807);
    return bool;
  }
  
  public static FailSendMsgNotification MK(int paramInt)
  {
    AppMethodBeat.i(26803);
    FailSendMsgNotification localFailSendMsgNotification;
    if ((paramInt == 2) && (dzo().wLW != null))
    {
      ae.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
      localFailSendMsgNotification = dzo().wLW.dyZ();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    if ((paramInt == 1) && (dzo().wLV != null))
    {
      ae.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
      localFailSendMsgNotification = dzo().wLV.dyZ();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    AppMethodBeat.o(26803);
    return null;
  }
  
  public static ArrayList<Long> ay(bv parambv)
  {
    AppMethodBeat.i(26808);
    if (parambv == null)
    {
      AppMethodBeat.o(26808);
      return null;
    }
    bc.aCg();
    com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
    Object localObject = ((l)g.ab(l.class)).doJ().doV();
    parambv = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parambv.add(Long.valueOf(((bv)((Iterator)localObject).next()).field_msgId));
    }
    AppMethodBeat.o(26808);
    return parambv;
  }
  
  public static f dzo()
  {
    AppMethodBeat.i(26804);
    if (wLU == null) {
      wLU = new f();
    }
    f localf = wLU;
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
    this.wLV.dzi();
    this.wLV.dzj();
    this.wLW.dzi();
    this.wLW.dzj();
    if (this.wLX == null) {
      this.wLX = new com.tencent.mm.plugin.notification.a.a();
    }
    com.tencent.mm.plugin.notification.a.a locala = this.wLX;
    if (!bc.ajM()) {
      ae.e("MicroMsg.NotificationObserver", "account not ready!");
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IvT.c(this.wLY);
      com.tencent.mm.sdk.b.a.IvT.c(this.wLZ);
      com.tencent.mm.sdk.b.a.IvT.c(this.wMa);
      com.tencent.mm.sdk.b.a.IvT.c(this.wMb);
      com.tencent.mm.sdk.b.a.IvT.c(this.wMc);
      com.tencent.mm.sdk.b.a.IvT.c(this.wMd);
      bc.getNotification().kP(com.tencent.mm.n.f.acI());
      bc.getNotification().cA(false);
      ae.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
      AppMethodBeat.o(26805);
      return;
      ae.d("MicroMsg.NotificationObserver", "added");
      try
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().b(locala);
        bc.aCg();
        com.tencent.mm.model.c.azL().a(locala);
        locala.wKV = true;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bu.o(localException) });
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26806);
    this.wLV.dzk();
    this.wLV.dzl();
    this.wLW.dzk();
    this.wLW.dzl();
    com.tencent.mm.plugin.notification.a.a locala;
    if (this.wLX != null)
    {
      locala = this.wLX;
      if (!bc.ajM()) {}
    }
    try
    {
      bc.aCg();
      com.tencent.mm.model.c.azL().b(locala);
      com.tencent.mm.sdk.b.a.IvT.d(this.wLY);
      com.tencent.mm.sdk.b.a.IvT.d(this.wLZ);
      com.tencent.mm.sdk.b.a.IvT.d(this.wMa);
      com.tencent.mm.sdk.b.a.IvT.d(this.wMb);
      com.tencent.mm.sdk.b.a.IvT.d(this.wMc);
      com.tencent.mm.sdk.b.a.IvT.d(this.wMd);
      bc.getNotification().kP(0);
      bc.getNotification().cA(true);
      ae.d("MicroMsg.SubCoreNotification", "onAccountRelease");
      AppMethodBeat.o(26806);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bu.o(localException) });
      }
    }
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.f
 * JD-Core Version:    0.7.0.1
 */