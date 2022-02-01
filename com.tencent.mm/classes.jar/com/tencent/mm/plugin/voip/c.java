package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.d;
import com.tencent.mm.app.n.a;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.voip.b.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements ax
{
  private com.tencent.mm.plugin.voip.model.u BXl;
  private p BXm;
  private d BXn;
  com.tencent.mm.plugin.voip.b.b BXo;
  private e BXp;
  private c.a BXq;
  private n.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(114810);
    com.tencent.mm.plugin.voip.video.a.c.eAP();
    AppMethodBeat.o(114810);
  }
  
  public c()
  {
    AppMethodBeat.i(114804);
    this.BXl = null;
    this.BXm = new p();
    this.BXp = new e();
    this.BXq = new c.a(this);
    this.appForegroundListener = new c.1(this);
    AppMethodBeat.o(114804);
  }
  
  private static c euL()
  {
    AppMethodBeat.i(114805);
    c localc = (c)t.ap(c.class);
    AppMethodBeat.o(114805);
    return localc;
  }
  
  public static com.tencent.mm.plugin.voip.model.u euM()
  {
    AppMethodBeat.i(114806);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114806);
      throw ((Throwable)localObject);
    }
    if (euL().BXl == null) {
      euL().BXl = new com.tencent.mm.plugin.voip.model.u();
    }
    Object localObject = euL().BXl;
    AppMethodBeat.o(114806);
    return localObject;
  }
  
  public static d euN()
  {
    AppMethodBeat.i(184039);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(184039);
      throw ((Throwable)localObject);
    }
    if (euL().BXn == null) {
      euL().BXn = new d();
    }
    Object localObject = euL().BXn;
    AppMethodBeat.o(184039);
    return localObject;
  }
  
  public static boolean euO()
  {
    AppMethodBeat.i(216235);
    if ((com.tencent.mm.model.u.aAr() & 0x0) == 0L)
    {
      AppMethodBeat.o(216235);
      return true;
    }
    AppMethodBeat.o(216235);
    return false;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(114809);
    e.d.a(Integer.valueOf(50), this.BXm);
    euM();
    this.BXo = new com.tencent.mm.plugin.voip.b.b();
    this.BXo.ezn();
    this.appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.IbL.c(this.BXp);
    com.tencent.mm.sdk.b.a.IbL.c(this.BXq);
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    paramBoolean = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(73217, Boolean.TRUE)).booleanValue();
    boolean bool2 = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(73218, Boolean.TRUE)).booleanValue();
    boolean bool1 = com.tencent.mm.n.a.abJ();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IDv, Boolean.FALSE)).booleanValue();
    ad.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
    if (!bool3)
    {
      if ((!paramBoolean) && (!bool2)) {
        break label265;
      }
      paramBoolean = true;
      if (paramBoolean != bool1)
      {
        if ((!paramBoolean) || (bool1)) {
          break label270;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 13L, 1L, false);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDv, Boolean.TRUE);
      ay.ou(1);
      AppMethodBeat.o(114809);
      return;
      label265:
      paramBoolean = false;
      break;
      label270:
      if ((!paramBoolean) && (bool1)) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(500L, 14L, 1L, false);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114808);
    if (this.BXn != null) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114802);
          c.a(c.this).rf(true);
          c.b(c.this);
          AppMethodBeat.o(114802);
        }
      });
    }
    if (this.BXo != null)
    {
      localObject = this.BXo;
      ap localap = ((com.tencent.mm.plugin.voip.b.b)localObject).handler;
      if (localap != null) {
        localap.removeCallbacksAndMessages(null);
      }
      localap = ((com.tencent.mm.plugin.voip.b.b)localObject).handler;
      if ((localap != null) && (!localap.isQuit()))
      {
        localap = ((com.tencent.mm.plugin.voip.b.b)localObject).handler;
        if (localap != null) {
          localap.post((Runnable)new b.c((com.tencent.mm.plugin.voip.b.b)localObject));
        }
      }
    }
    Object localObject = euM().CdF.BXC;
    if (((l)localObject).CaK != null)
    {
      localObject = ((l)localObject).CaK;
      if (((n)localObject).CbF != null)
      {
        ((n)localObject).CbF.quitSafely();
        ((n)localObject).CbF = null;
      }
    }
    this.appForegroundListener.dead();
    e.d.b(Integer.valueOf(50), this.BXm);
    euM().aKp();
    com.tencent.mm.sdk.b.a.IbL.d(this.BXp);
    com.tencent.mm.sdk.b.a.IbL.d(this.BXq);
    AppMethodBeat.o(114808);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c
 * JD-Core Version:    0.7.0.1
 */