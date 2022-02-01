package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.dc;
import com.tencent.mm.f.a.pe;
import com.tencent.mm.f.a.pf;
import com.tencent.mm.f.a.tk;
import com.tencent.mm.f.a.tl;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.notification.a.a;
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
  implements be
{
  private static f GAF;
  private static o.a appForegroundListener;
  com.tencent.mm.plugin.notification.c.c GAG;
  com.tencent.mm.plugin.notification.c.c GAH;
  private a GAI;
  private IListener GAJ;
  private IListener GAK;
  private IListener GAL;
  private IListener GAM;
  private IListener GAN;
  private IListener GAO;
  private boolean qvq;
  
  static
  {
    AppMethodBeat.i(26809);
    GAF = null;
    appForegroundListener = new f.7();
    AppMethodBeat.o(26809);
  }
  
  private f()
  {
    AppMethodBeat.i(26802);
    this.GAG = null;
    this.GAH = null;
    this.GAI = null;
    this.qvq = false;
    this.GAJ = new IListener() {};
    this.GAK = new IListener() {};
    this.GAL = new IListener() {};
    this.GAM = new IListener() {};
    this.GAN = new IListener() {};
    this.GAO = new f.6(this);
    b.init();
    if (this.GAH == null) {
      this.GAH = new e();
    }
    if (this.GAG == null) {
      this.GAG = new d();
    }
    AppMethodBeat.o(26802);
  }
  
  public static boolean SV()
  {
    AppMethodBeat.i(26807);
    boolean bool = fkA().qvq;
    AppMethodBeat.o(26807);
    return bool;
  }
  
  public static ArrayList<Long> aT(ca paramca)
  {
    AppMethodBeat.i(26808);
    if (paramca == null)
    {
      AppMethodBeat.o(26808);
      return null;
    }
    bh.beI();
    com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
    Object localObject = ((n)h.ae(n.class)).eSe().eSq();
    paramca = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramca.add(Long.valueOf(((ca)((Iterator)localObject).next()).field_msgId));
    }
    AppMethodBeat.o(26808);
    return paramca;
  }
  
  public static FailSendMsgNotification aaH(int paramInt)
  {
    AppMethodBeat.i(26803);
    FailSendMsgNotification localFailSendMsgNotification;
    if ((paramInt == 2) && (fkA().GAH != null))
    {
      Log.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
      localFailSendMsgNotification = fkA().GAH.fkl();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    if ((paramInt == 1) && (fkA().GAG != null))
    {
      Log.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
      localFailSendMsgNotification = fkA().GAG.fkl();
      AppMethodBeat.o(26803);
      return localFailSendMsgNotification;
    }
    AppMethodBeat.o(26803);
    return null;
  }
  
  public static f fkA()
  {
    AppMethodBeat.i(26804);
    if (GAF == null) {
      GAF = new f();
    }
    f localf = GAF;
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
    this.GAG.fku();
    this.GAG.fkv();
    this.GAH.fku();
    this.GAH.fkv();
    if (this.GAI == null) {
      this.GAI = new a();
    }
    a locala = this.GAI;
    if (!bh.aHB()) {
      Log.e("MicroMsg.NotificationObserver", "account not ready!");
    }
    for (;;)
    {
      EventCenter.instance.addListener(this.GAJ);
      EventCenter.instance.addListener(this.GAK);
      EventCenter.instance.addListener(this.GAL);
      EventCenter.instance.addListener(this.GAM);
      EventCenter.instance.addListener(this.GAN);
      EventCenter.instance.addListener(this.GAO);
      bh.getNotification().qg(g.awZ());
      bh.getNotification().dJ(false);
      Log.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
      AppMethodBeat.o(26805);
      return;
      Log.d("MicroMsg.NotificationObserver", "added");
      try
      {
        bh.beI();
        com.tencent.mm.model.c.bbR().remove(locala);
        bh.beI();
        com.tencent.mm.model.c.bbR().add(locala);
        locala.GzG = true;
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
    this.GAG.fkw();
    this.GAG.fkx();
    this.GAH.fkw();
    this.GAH.fkx();
    a locala;
    if (this.GAI != null)
    {
      locala = this.GAI;
      if (!bh.aHB()) {}
    }
    try
    {
      bh.beI();
      com.tencent.mm.model.c.bbR().remove(locala);
      EventCenter.instance.removeListener(this.GAJ);
      EventCenter.instance.removeListener(this.GAK);
      EventCenter.instance.removeListener(this.GAL);
      EventCenter.instance.removeListener(this.GAM);
      EventCenter.instance.removeListener(this.GAN);
      EventCenter.instance.removeListener(this.GAO);
      bh.getNotification().qg(0);
      bh.getNotification().dJ(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d.f
 * JD-Core Version:    0.7.0.1
 */