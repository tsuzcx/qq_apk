package com.tencent.mm.plugin.voip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.b;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements aw
{
  private n.a appForegroundListener;
  private u zfk;
  private p zfl;
  private d zfm;
  private e zfn;
  private c.a zfo;
  
  static
  {
    AppMethodBeat.i(114810);
    com.tencent.mm.plugin.voip.video.a.c.dXw();
    AppMethodBeat.o(114810);
  }
  
  public c()
  {
    AppMethodBeat.i(114804);
    this.zfk = null;
    this.zfl = new p();
    this.zfn = new e();
    this.zfo = new c.a(this);
    this.appForegroundListener = new c.1(this);
    AppMethodBeat.o(114804);
  }
  
  private static c dRP()
  {
    AppMethodBeat.i(114805);
    c localc = (c)t.ap(c.class);
    AppMethodBeat.o(114805);
    return localc;
  }
  
  public static u dRQ()
  {
    AppMethodBeat.i(114806);
    if (!g.afw())
    {
      localObject = new b();
      AppMethodBeat.o(114806);
      throw ((Throwable)localObject);
    }
    if (dRP().zfk == null) {
      dRP().zfk = new u();
    }
    Object localObject = dRP().zfk;
    AppMethodBeat.o(114806);
    return localObject;
  }
  
  public static d dRR()
  {
    AppMethodBeat.i(184039);
    if (!g.afw())
    {
      localObject = new b();
      AppMethodBeat.o(184039);
      throw ((Throwable)localObject);
    }
    if (dRP().zfm == null) {
      dRP().zfm = new d();
    }
    Object localObject = dRP().zfm;
    AppMethodBeat.o(184039);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(114809);
    f.d.a(Integer.valueOf(50), this.zfl);
    dRQ();
    this.appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.ESL.c(this.zfn);
    com.tencent.mm.sdk.b.a.ESL.c(this.zfo);
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    paramBoolean = ((Boolean)g.afB().afk().get(73217, Boolean.TRUE)).booleanValue();
    boolean bool2 = ((Boolean)g.afB().afk().get(73218, Boolean.TRUE)).booleanValue();
    boolean bool1 = com.tencent.mm.m.a.Ym();
    boolean bool3 = ((Boolean)g.afB().afk().get(ae.a.Ftf, Boolean.FALSE)).booleanValue();
    ad.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
    if (!bool3)
    {
      if ((!paramBoolean) && (!bool2)) {
        break label246;
      }
      paramBoolean = true;
      if (paramBoolean != bool1)
      {
        if ((!paramBoolean) || (bool1)) {
          break label251;
        }
        h.vKh.idkeyStat(500L, 13L, 1L, false);
      }
    }
    for (;;)
    {
      g.afB().afk().set(ae.a.Ftf, Boolean.TRUE);
      ax.ng(1);
      AppMethodBeat.o(114809);
      return;
      label246:
      paramBoolean = false;
      break;
      label251:
      if ((!paramBoolean) && (bool1)) {
        h.vKh.idkeyStat(500L, 14L, 1L, false);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114808);
    if (this.zfm != null) {
      com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114802);
          c.a(c.this).pE(true);
          c.b(c.this);
          AppMethodBeat.o(114802);
        }
      });
    }
    Object localObject = dRQ().zlR.zfA;
    if (((l)localObject).zjb != null)
    {
      localObject = ((l)localObject).zjb;
      if (((n)localObject).zjW != null)
      {
        ((n)localObject).zjW.quitSafely();
        ((n)localObject).zjW = null;
      }
    }
    this.appForegroundListener.dead();
    f.d.b(Integer.valueOf(50), this.zfl);
    dRQ().aAo();
    com.tencent.mm.sdk.b.a.ESL.d(this.zfn);
    com.tencent.mm.sdk.b.a.ESL.d(this.zfo);
    AppMethodBeat.o(114808);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c
 * JD-Core Version:    0.7.0.1
 */