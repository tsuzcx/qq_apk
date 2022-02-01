package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f
  implements ax
{
  private static n.a appForegroundListener;
  private static f wwi;
  com.tencent.mm.plugin.notification.c.c wwj;
  com.tencent.mm.plugin.notification.c.c wwk;
  private com.tencent.mm.plugin.notification.a.a wwl;
  private boolean wwm;
  private com.tencent.mm.sdk.b.c wwn;
  private com.tencent.mm.sdk.b.c wwo;
  private com.tencent.mm.sdk.b.c wwp;
  private com.tencent.mm.sdk.b.c wwq;
  private com.tencent.mm.sdk.b.c wwr;
  private com.tencent.mm.sdk.b.c wws;
  
  static
  {
    AppMethodBeat.i(26809);
    wwi = null;
    appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(26801);
        if ((g.ajx()) && (g.ajA().gAD))
        {
          g.ajA();
          if (!com.tencent.mm.kernel.a.aiE())
          {
            paramAnonymousString = new gp();
            paramAnonymousString.dsy.isActive = false;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(26801);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(26800);
        if ((g.ajx()) && (g.ajA().gAD))
        {
          g.ajA();
          if (!com.tencent.mm.kernel.a.aiE())
          {
            paramAnonymousString = new gp();
            paramAnonymousString.dsy.isActive = true;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
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
    this.wwj = null;
    this.wwk = null;
    this.wwl = null;
    this.wwm = false;
    this.wwn = new com.tencent.mm.sdk.b.c() {};
    this.wwo = new com.tencent.mm.sdk.b.c() {};
    this.wwp = new com.tencent.mm.sdk.b.c() {};
    this.wwq = new com.tencent.mm.sdk.b.c() {};
    this.wwr = new com.tencent.mm.sdk.b.c() {};
    this.wws = new com.tencent.mm.sdk.b.c() {};
    b.init();
    if (this.wwk == null) {
      this.wwk = new e();
    }
    if (this.wwj == null) {
      this.wwj = new d();
    }
    AppMethodBeat.o(26802);
  }
  
  public static boolean FG()
  {
    AppMethodBeat.i(26807);
    boolean bool = dvY().wwm;
    AppMethodBeat.o(26807);
    return bool;
  }
  
  public static FailSendMsgNotification Mf(int paramInt)
  {
    AppMethodBeat.i(26803);
    FailSendMsgNotification localFailSendMsgNotification;
    if ((paramInt == 2) && (dvY().wwk != null))
    {
      ad.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
      localFailSendMsgNotification = dvY().wwk.dvK();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    if ((paramInt == 1) && (dvY().wwj != null))
    {
      ad.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
      localFailSendMsgNotification = dvY().wwj.dvK();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    AppMethodBeat.o(26803);
    return null;
  }
  
  public static ArrayList<Long> az(bu parambu)
  {
    AppMethodBeat.i(26808);
    if (parambu == null)
    {
      AppMethodBeat.o(26808);
      return null;
    }
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
    Object localObject = ((l)g.ab(l.class)).dlK().dlW();
    parambu = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parambu.add(Long.valueOf(((bu)((Iterator)localObject).next()).field_msgId));
    }
    AppMethodBeat.o(26808);
    return parambu;
  }
  
  public static f dvY()
  {
    AppMethodBeat.i(26804);
    if (wwi == null)
    {
      wwi = new f();
      ba.aBK().a("plugin.notification", wwi);
    }
    f localf = wwi;
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
    this.wwj.dvT();
    this.wwj.dvU();
    this.wwk.dvT();
    this.wwk.dvU();
    if (this.wwl == null) {
      this.wwl = new com.tencent.mm.plugin.notification.a.a();
    }
    com.tencent.mm.plugin.notification.a.a locala = this.wwl;
    if (!ba.ajx()) {
      ad.e("MicroMsg.NotificationObserver", "account not ready!");
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IbL.c(this.wwn);
      com.tencent.mm.sdk.b.a.IbL.c(this.wwo);
      com.tencent.mm.sdk.b.a.IbL.c(this.wwp);
      com.tencent.mm.sdk.b.a.IbL.c(this.wwq);
      com.tencent.mm.sdk.b.a.IbL.c(this.wwr);
      com.tencent.mm.sdk.b.a.IbL.c(this.wws);
      ba.getNotification().kN(com.tencent.mm.n.f.acx());
      ba.getNotification().cA(false);
      ad.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
      AppMethodBeat.o(26805);
      return;
      ad.d("MicroMsg.NotificationObserver", "added");
      try
      {
        ba.aBQ();
        com.tencent.mm.model.c.azv().b(locala);
        ba.aBQ();
        com.tencent.mm.model.c.azv().a(locala);
        locala.wvk = true;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bt.n(localException) });
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26806);
    this.wwj.dvV();
    this.wwj.dvW();
    this.wwk.dvV();
    this.wwk.dvW();
    com.tencent.mm.plugin.notification.a.a locala;
    if (this.wwl != null)
    {
      locala = this.wwl;
      if (!ba.ajx()) {}
    }
    try
    {
      ba.aBQ();
      com.tencent.mm.model.c.azv().b(locala);
      com.tencent.mm.sdk.b.a.IbL.d(this.wwn);
      com.tencent.mm.sdk.b.a.IbL.d(this.wwo);
      com.tencent.mm.sdk.b.a.IbL.d(this.wwp);
      com.tencent.mm.sdk.b.a.IbL.d(this.wwq);
      com.tencent.mm.sdk.b.a.IbL.d(this.wwr);
      com.tencent.mm.sdk.b.a.IbL.d(this.wws);
      ba.getNotification().kN(0);
      ba.getNotification().cA(true);
      ad.d("MicroMsg.SubCoreNotification", "onAccountRelease");
      AppMethodBeat.o(26806);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.NotificationObserver", "exception:%s", new Object[] { bt.n(localException) });
      }
    }
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.f
 * JD-Core Version:    0.7.0.1
 */