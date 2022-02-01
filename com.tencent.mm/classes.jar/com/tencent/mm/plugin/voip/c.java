package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.d;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements aw
{
  private com.tencent.mm.plugin.voip.model.u AxQ;
  private p AxR;
  private d AxS;
  com.tencent.mm.plugin.voip.b.b AxT;
  private e AxU;
  private c.a AxV;
  private n.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(114810);
    com.tencent.mm.plugin.voip.video.a.c.emR();
    AppMethodBeat.o(114810);
  }
  
  public c()
  {
    AppMethodBeat.i(114804);
    this.AxQ = null;
    this.AxR = new p();
    this.AxU = new e();
    this.AxV = new c.a(this);
    this.appForegroundListener = new c.1(this);
    AppMethodBeat.o(114804);
  }
  
  private static c eha()
  {
    AppMethodBeat.i(114805);
    c localc = (c)t.ap(c.class);
    AppMethodBeat.o(114805);
    return localc;
  }
  
  public static com.tencent.mm.plugin.voip.model.u ehb()
  {
    AppMethodBeat.i(114806);
    if (!g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114806);
      throw ((Throwable)localObject);
    }
    if (eha().AxQ == null) {
      eha().AxQ = new com.tencent.mm.plugin.voip.model.u();
    }
    Object localObject = eha().AxQ;
    AppMethodBeat.o(114806);
    return localObject;
  }
  
  public static d ehc()
  {
    AppMethodBeat.i(184039);
    if (!g.agM())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(184039);
      throw ((Throwable)localObject);
    }
    if (eha().AxS == null) {
      eha().AxS = new d();
    }
    Object localObject = eha().AxS;
    AppMethodBeat.o(184039);
    return localObject;
  }
  
  public static boolean ehd()
  {
    AppMethodBeat.i(208206);
    if ((com.tencent.mm.model.u.axB() & 0x0) == 0L)
    {
      AppMethodBeat.o(208206);
      return true;
    }
    AppMethodBeat.o(208206);
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
    f.d.a(Integer.valueOf(50), this.AxR);
    ehb();
    this.AxT = new com.tencent.mm.plugin.voip.b.b();
    this.AxT.elD();
    this.appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.GpY.c(this.AxU);
    com.tencent.mm.sdk.b.a.GpY.c(this.AxV);
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    paramBoolean = ((Boolean)g.agR().agA().get(73217, Boolean.TRUE)).booleanValue();
    boolean bool2 = ((Boolean)g.agR().agA().get(73218, Boolean.TRUE)).booleanValue();
    boolean bool1 = com.tencent.mm.m.a.Zj();
    boolean bool3 = ((Boolean)g.agR().agA().get(ah.a.GQY, Boolean.FALSE)).booleanValue();
    ac.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
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
        h.wUl.idkeyStat(500L, 13L, 1L, false);
      }
    }
    for (;;)
    {
      g.agR().agA().set(ah.a.GQY, Boolean.TRUE);
      ax.nU(1);
      AppMethodBeat.o(114809);
      return;
      label265:
      paramBoolean = false;
      break;
      label270:
      if ((!paramBoolean) && (bool1)) {
        h.wUl.idkeyStat(500L, 14L, 1L, false);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114808);
    if (this.AxS != null) {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114802);
          c.a(c.this).qD(true);
          c.b(c.this);
          AppMethodBeat.o(114802);
        }
      });
    }
    if (this.AxT != null)
    {
      localObject = this.AxT;
      ao localao = ((com.tencent.mm.plugin.voip.b.b)localObject).handler;
      if (localao != null) {
        localao.removeCallbacksAndMessages(null);
      }
      localao = ((com.tencent.mm.plugin.voip.b.b)localObject).handler;
      if ((localao != null) && (!localao.isQuit()))
      {
        localao = ((com.tencent.mm.plugin.voip.b.b)localObject).handler;
        if (localao != null) {
          localao.post((Runnable)new b.c((com.tencent.mm.plugin.voip.b.b)localObject));
        }
      }
    }
    Object localObject = ehb().AEF.Ayh;
    if (((l)localObject).ABL != null)
    {
      localObject = ((l)localObject).ABL;
      if (((n)localObject).ACG != null)
      {
        ((n)localObject).ACG.quitSafely();
        ((n)localObject).ACG = null;
      }
    }
    this.appForegroundListener.dead();
    f.d.b(Integer.valueOf(50), this.AxR);
    ehb().aHe();
    com.tencent.mm.sdk.b.a.GpY.d(this.AxU);
    com.tencent.mm.sdk.b.a.GpY.d(this.AxV);
    AppMethodBeat.o(114808);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c
 * JD-Core Version:    0.7.0.1
 */