package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.app.o.a;
import com.tencent.mm.model.at;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.voip.b.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements az
{
  private com.tencent.mm.plugin.voip.model.u CoM;
  private p CoN;
  private d CoO;
  com.tencent.mm.plugin.voip.b.b CoP;
  private e CoQ;
  private c.a CoR;
  private o.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(114810);
    com.tencent.mm.plugin.voip.video.a.c.eEx();
    AppMethodBeat.o(114810);
  }
  
  public c()
  {
    AppMethodBeat.i(114804);
    this.CoM = null;
    this.CoN = new p();
    this.CoQ = new e();
    this.CoR = new c.a(this);
    this.appForegroundListener = new c.1(this);
    AppMethodBeat.o(114804);
  }
  
  private static c eyr()
  {
    AppMethodBeat.i(114805);
    c localc = (c)com.tencent.mm.model.u.ap(c.class);
    AppMethodBeat.o(114805);
    return localc;
  }
  
  public static com.tencent.mm.plugin.voip.model.u eys()
  {
    AppMethodBeat.i(114806);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114806);
      throw ((Throwable)localObject);
    }
    if (eyr().CoM == null) {
      eyr().CoM = new com.tencent.mm.plugin.voip.model.u();
    }
    Object localObject = eyr().CoM;
    AppMethodBeat.o(114806);
    return localObject;
  }
  
  public static d eyt()
  {
    AppMethodBeat.i(184039);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(184039);
      throw ((Throwable)localObject);
    }
    if (eyr().CoO == null) {
      eyr().CoO = new d();
    }
    Object localObject = eyr().CoO;
    AppMethodBeat.o(184039);
    return localObject;
  }
  
  public static boolean eyu()
  {
    AppMethodBeat.i(209910);
    if ((com.tencent.mm.model.v.aAH() & 0x0) == 0L)
    {
      AppMethodBeat.o(209910);
      return true;
    }
    AppMethodBeat.o(209910);
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
    e.d.a(Integer.valueOf(50), this.CoN);
    eys();
    this.CoP = new com.tencent.mm.plugin.voip.b.b();
    this.CoP.eCV();
    this.appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.IvT.c(this.CoQ);
    com.tencent.mm.sdk.b.a.IvT.c(this.CoR);
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    paramBoolean = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(73217, Boolean.TRUE)).booleanValue();
    boolean bool2 = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(73218, Boolean.TRUE)).booleanValue();
    boolean bool1 = com.tencent.mm.n.a.abS();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXV, Boolean.FALSE)).booleanValue();
    ae.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
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
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 13L, 1L, false);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXV, Boolean.TRUE);
      ba.ox(1);
      AppMethodBeat.o(114809);
      return;
      label265:
      paramBoolean = false;
      break;
      label270:
      if ((!paramBoolean) && (bool1)) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 14L, 1L, false);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114808);
    if (this.CoO != null) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114802);
          c.a(c.this).rm(true);
          c.b(c.this);
          AppMethodBeat.o(114802);
        }
      });
    }
    if (this.CoP != null)
    {
      localObject = this.CoP;
      aq localaq = ((com.tencent.mm.plugin.voip.b.b)localObject).handler;
      if (localaq != null) {
        localaq.removeCallbacksAndMessages(null);
      }
      localaq = ((com.tencent.mm.plugin.voip.b.b)localObject).handler;
      if ((localaq != null) && (!localaq.isQuit()))
      {
        localaq = ((com.tencent.mm.plugin.voip.b.b)localObject).handler;
        if (localaq != null) {
          localaq.post((Runnable)new b.c((com.tencent.mm.plugin.voip.b.b)localObject));
        }
      }
    }
    Object localObject = eys().Cvg.Cpd;
    if (((l)localObject).Csl != null)
    {
      localObject = ((l)localObject).Csl;
      if (((n)localObject).Ctg != null)
      {
        ((n)localObject).Ctg.quitSafely();
        ((n)localObject).Ctg = null;
      }
    }
    this.appForegroundListener.dead();
    e.d.b(Integer.valueOf(50), this.CoN);
    eys().aKI();
    com.tencent.mm.sdk.b.a.IvT.d(this.CoQ);
    com.tencent.mm.sdk.b.a.IvT.d(this.CoR);
    AppMethodBeat.o(114808);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c
 * JD-Core Version:    0.7.0.1
 */