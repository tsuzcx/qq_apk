package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.k.d.c;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.u.b;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements bd
{
  private u GSJ;
  private p GSK;
  private com.tencent.mm.plugin.voip.ui.d GSL;
  com.tencent.mm.media.k.d GSM;
  private e GSN;
  private c.a GSO;
  private o.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(114810);
    com.tencent.mm.plugin.voip.video.a.c.fLC();
    AppMethodBeat.o(114810);
  }
  
  public c()
  {
    AppMethodBeat.i(114804);
    this.GSJ = null;
    this.GSK = new p();
    this.GSN = new e();
    this.GSO = new c.a(this);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(114801);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          com.tencent.mm.kernel.a.azj();
        }
        AppMethodBeat.o(114801);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(114800);
        if ((g.aAc()) && (g.aAf().hpY))
        {
          g.aAf();
          if (!com.tencent.mm.kernel.a.azj()) {
            com.tencent.mm.blink.b.ake().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114799);
                u localu = c.fFg();
                u.b localb = localu.GZc;
                if (localb != null)
                {
                  Log.i("MicroMsg.Voip.VoipService", "on voip resume");
                  String str = localb.toUser;
                  boolean bool1 = localb.GZs;
                  boolean bool2 = localb.GZt;
                  long l = localb.ypH;
                  localu.enB();
                  localu.a(MMApplicationContext.getContext(), str, l, bool1, bool2, true);
                  AppMethodBeat.o(114799);
                  return;
                }
                Log.i("MicroMsg.Voip.VoipService", "do not need voip resume");
                AppMethodBeat.o(114799);
              }
            });
          }
        }
        AppMethodBeat.o(114800);
      }
    };
    AppMethodBeat.o(114804);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString)
  {
    AppMethodBeat.i(235470);
    g.aAh().azQ().set(ar.a.Oba, Boolean.FALSE);
    g.aAh().azQ().set(ar.a.Obc, Boolean.valueOf(paramBoolean1));
    g.aAh().azQ().set(ar.a.Obb, Boolean.valueOf(paramBoolean2));
    g.aAh().azQ().set(ar.a.Obd, Long.valueOf(paramLong));
    g.aAh().azQ().set(ar.a.Obf, paramString);
    g.aAh().azQ().gBI();
    AppMethodBeat.o(235470);
  }
  
  private static c fFf()
  {
    AppMethodBeat.i(114805);
    c localc = (c)y.at(c.class);
    AppMethodBeat.o(114805);
    return localc;
  }
  
  public static u fFg()
  {
    AppMethodBeat.i(114806);
    if (!g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114806);
      throw ((Throwable)localObject);
    }
    if (fFf().GSJ == null) {
      fFf().GSJ = new u();
    }
    Object localObject = fFf().GSJ;
    AppMethodBeat.o(114806);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.voip.ui.d fFh()
  {
    AppMethodBeat.i(184039);
    if (!g.aAc())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(184039);
      throw ((Throwable)localObject);
    }
    if (fFf().GSL == null) {
      fFf().GSL = new com.tencent.mm.plugin.voip.ui.d();
    }
    Object localObject = fFf().GSL;
    AppMethodBeat.o(184039);
    return localObject;
  }
  
  public static void fFi()
  {
    AppMethodBeat.i(235471);
    g.aAh().azQ().set(ar.a.Oba, Boolean.TRUE);
    g.aAh().azQ().gBI();
    AppMethodBeat.o(235471);
  }
  
  public static boolean fFj()
  {
    AppMethodBeat.i(235472);
    if ((z.aUd() & 0x0) == 0L)
    {
      AppMethodBeat.o(235472);
      return true;
    }
    AppMethodBeat.o(235472);
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
    Object localObject = g.aAh().azQ().get(ar.a.Oba, null);
    boolean bool1;
    int i;
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      paramBoolean = ((Boolean)g.aAh().azQ().get(ar.a.Obc, Boolean.FALSE)).booleanValue();
      bool1 = ((Boolean)g.aAh().azQ().get(ar.a.Obb, Boolean.FALSE)).booleanValue();
      long l = ((Long)g.aAh().azQ().get(ar.a.Obd, Integer.valueOf(0))).longValue();
      String str = (String)g.aAh().azQ().get(ar.a.Obf, null);
      Log.i("MicroMsg.SubCoreVoip", "voip message need push is %s,%s,%s,%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Long.valueOf(l), str });
      if (paramBoolean)
      {
        localObject = ca.OqC;
        if (!bool1) {
          break label571;
        }
        i = 1;
        label175:
        s.c(str, (String)localObject, i, 6, MMApplicationContext.getContext().getString(2131767341));
        fFi();
      }
    }
    else
    {
      h.d.a(Integer.valueOf(50), this.GSK);
      if ((((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soG, 0) != 1) && (!com.tencent.mm.protocal.d.KyR) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG)) {
        break label576;
      }
      paramBoolean = true;
      label256:
      Log.i("MicroMsg.SubCoreVoip", "onAccountPostReset before initCameraNumbers, useMMKVCache : %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localObject = com.tencent.mm.compatible.c.a.gDs;
      com.tencent.mm.compatible.c.a.dp(paramBoolean);
      localObject = com.tencent.mm.media.widget.d.c.itl;
      com.tencent.mm.media.widget.d.c.aRN();
      com.tencent.f.h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235469);
          if ((((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soI, 1) == 1) || (com.tencent.mm.protocal.d.KyR) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
          for (boolean bool = true;; bool = false)
          {
            Log.i("MicroMsg.SubCoreVoip", "makeCameraCache getCodecCountCache : ", new Object[] { Boolean.valueOf(bool) });
            if (bool)
            {
              com.tencent.mm.compatible.c.a locala = com.tencent.mm.compatible.c.a.gDs;
              com.tencent.mm.compatible.c.a.anO();
            }
            AppMethodBeat.o(235469);
            return;
          }
        }
      });
      fFg();
      this.GSM = new com.tencent.mm.media.k.d();
      this.GSM.aNb();
      this.appForegroundListener.alive();
      EventCenter.instance.addListener(this.GSN);
      EventCenter.instance.addListener(this.GSO);
      ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
      paramBoolean = ((Boolean)g.aAh().azQ().get(73217, Boolean.TRUE)).booleanValue();
      boolean bool2 = ((Boolean)g.aAh().azQ().get(73218, Boolean.TRUE)).booleanValue();
      bool1 = com.tencent.mm.n.b.apR();
      boolean bool3 = ((Boolean)g.aAh().azQ().get(ar.a.Ogs, Boolean.FALSE)).booleanValue();
      Log.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if (!bool3)
      {
        if ((!paramBoolean) && (!bool2)) {
          break label581;
        }
        paramBoolean = true;
        label511:
        if (paramBoolean != bool1)
        {
          if ((!paramBoolean) || (bool1)) {
            break label586;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 13L, 1L, false);
        }
      }
    }
    for (;;)
    {
      g.aAh().azQ().set(ar.a.Ogs, Boolean.TRUE);
      be.rY(1);
      AppMethodBeat.o(114809);
      return;
      localObject = ca.OqB;
      break;
      label571:
      i = 0;
      break label175;
      label576:
      paramBoolean = false;
      break label256;
      label581:
      paramBoolean = false;
      break label511;
      label586:
      if ((!paramBoolean) && (bool1)) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(500L, 14L, 1L, false);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114808);
    if (this.GSL != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114802);
          c.a(c.this).rX(true);
          c.b(c.this);
          AppMethodBeat.o(114802);
        }
      });
    }
    if (this.GSM != null)
    {
      localObject = this.GSM;
      MMHandler localMMHandler = ((com.tencent.mm.media.k.d)localObject).handler;
      if (localMMHandler != null) {
        localMMHandler.removeCallbacksAndMessages(null);
      }
      localMMHandler = ((com.tencent.mm.media.k.d)localObject).handler;
      if ((localMMHandler != null) && (!localMMHandler.isQuit()))
      {
        localMMHandler = ((com.tencent.mm.media.k.d)localObject).handler;
        if (localMMHandler != null) {
          localMMHandler.post((Runnable)new d.c((com.tencent.mm.media.k.d)localObject));
        }
      }
    }
    Object localObject = fFg().GYS.GSZ;
    if (((l)localObject).GVX != null)
    {
      localObject = ((l)localObject).GVX;
      if (((n)localObject).GWP != null)
      {
        ((n)localObject).GWP.quitSafely();
        ((n)localObject).GWP = null;
      }
    }
    this.appForegroundListener.dead();
    h.d.b(Integer.valueOf(50), this.GSK);
    fFg().unRegister();
    EventCenter.instance.removeListener(this.GSN);
    EventCenter.instance.removeListener(this.GSO);
    AppMethodBeat.o(114808);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c
 * JD-Core Version:    0.7.0.1
 */