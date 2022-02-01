package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.d;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.media.k.d.c;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bf;
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
  implements be
{
  private u NIU;
  private p NIV;
  private com.tencent.mm.plugin.voip.ui.d NIW;
  com.tencent.mm.media.k.d NIX;
  private e NIY;
  private c.a NIZ;
  private o.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(114810);
    com.tencent.mm.plugin.voip.video.a.c.gEc();
    AppMethodBeat.o(114810);
  }
  
  public c()
  {
    AppMethodBeat.i(114804);
    this.NIU = null;
    this.NIV = new p();
    this.NIY = new e();
    this.NIZ = new c.a(this);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(114801);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.kernel.b.aGE();
        }
        AppMethodBeat.o(114801);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(114800);
        if ((com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
        {
          com.tencent.mm.kernel.h.aHE();
          if (!com.tencent.mm.kernel.b.aGE()) {
            com.tencent.mm.blink.b.aqa().arrange(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114799);
                u localu = c.gxs();
                u.b localb = localu.NPq;
                if (localb != null)
                {
                  Log.i("MicroMsg.Voip.VoipService", "on voip resume");
                  String str = localb.toUser;
                  boolean bool1 = localb.NPE;
                  boolean bool2 = localb.NPF;
                  long l = localb.DPJ;
                  localu.eXr();
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
    AppMethodBeat.i(237432);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vpd, Boolean.FALSE);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vpf, Boolean.valueOf(paramBoolean1));
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vpe, Boolean.valueOf(paramBoolean2));
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vpg, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vpi, paramString);
    com.tencent.mm.kernel.h.aHG().aHp().hxT();
    AppMethodBeat.o(237432);
  }
  
  private static c gxr()
  {
    AppMethodBeat.i(114805);
    c localc = (c)y.as(c.class);
    AppMethodBeat.o(114805);
    return localc;
  }
  
  public static u gxs()
  {
    AppMethodBeat.i(114806);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114806);
      throw ((Throwable)localObject);
    }
    if (gxr().NIU == null) {
      gxr().NIU = new u();
    }
    Object localObject = gxr().NIU;
    AppMethodBeat.o(114806);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.voip.ui.d gxt()
  {
    AppMethodBeat.i(184039);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(184039);
      throw ((Throwable)localObject);
    }
    if (gxr().NIW == null) {
      gxr().NIW = new com.tencent.mm.plugin.voip.ui.d();
    }
    Object localObject = gxr().NIW;
    AppMethodBeat.o(184039);
    return localObject;
  }
  
  public static void gxu()
  {
    AppMethodBeat.i(237433);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vpd, Boolean.TRUE);
    com.tencent.mm.kernel.h.aHG().aHp().hxT();
    AppMethodBeat.o(237433);
  }
  
  public static boolean gxv()
  {
    AppMethodBeat.i(237434);
    if ((z.bde() & 0x0) == 0L)
    {
      AppMethodBeat.o(237434);
      return true;
    }
    AppMethodBeat.o(237434);
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
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vpd, null);
    boolean bool1;
    int i;
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      paramBoolean = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vpf, Boolean.FALSE)).booleanValue();
      bool1 = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vpe, Boolean.FALSE)).booleanValue();
      long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vpg, Integer.valueOf(0))).longValue();
      String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vpi, null);
      Log.i("MicroMsg.SubCoreVoip", "voip message need push is %s,%s,%s,%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Long.valueOf(l), str });
      if (paramBoolean)
      {
        localObject = ca.VGy;
        if (!bool1) {
          break label572;
        }
        i = 1;
        label175:
        s.b(str, (String)localObject, i, 6, MMApplicationContext.getContext().getString(b.g.voip_on_error_shutdown_without_time));
        gxu();
      }
    }
    else
    {
      h.d.a(Integer.valueOf(50), this.NIV);
      if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wag, 0) != 1) && (!com.tencent.mm.protocal.d.RAG) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.DEBUG)) {
        break label577;
      }
      paramBoolean = true;
      label257:
      Log.i("MicroMsg.SubCoreVoip", "onAccountPostReset before initCameraNumbers, useMMKVCache : %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localObject = com.tencent.mm.compatible.c.a.jnC;
      com.tencent.mm.compatible.c.a.dP(paramBoolean);
      localObject = com.tencent.mm.media.widget.d.d.lit;
      com.tencent.mm.media.widget.d.d.baH();
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235293);
          if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wak, 1) == 1) || (com.tencent.mm.protocal.d.RAG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
          for (boolean bool = true;; bool = false)
          {
            Log.i("MicroMsg.SubCoreVoip", "makeCameraCache getCodecCountCache : ", new Object[] { Boolean.valueOf(bool) });
            if (bool)
            {
              com.tencent.mm.compatible.c.a locala = com.tencent.mm.compatible.c.a.jnC;
              com.tencent.mm.compatible.c.a.atQ();
            }
            com.tencent.mm.compatible.c.a.jnC.atR();
            AppMethodBeat.o(235293);
            return;
          }
        }
      });
      gxs();
      this.NIX = new com.tencent.mm.media.k.d();
      this.NIX.aVE();
      this.appForegroundListener.alive();
      EventCenter.instance.addListener(this.NIY);
      EventCenter.instance.addListener(this.NIZ);
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
      paramBoolean = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(73217, Boolean.TRUE)).booleanValue();
      boolean bool2 = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(73218, Boolean.TRUE)).booleanValue();
      bool1 = com.tencent.mm.n.b.awk();
      boolean bool3 = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VuI, Boolean.FALSE)).booleanValue();
      Log.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if (!bool3)
      {
        if ((!paramBoolean) && (!bool2)) {
          break label582;
        }
        paramBoolean = true;
        label512:
        if (paramBoolean != bool1)
        {
          if ((!paramBoolean) || (bool1)) {
            break label587;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 13L, 1L, false);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuI, Boolean.TRUE);
      bf.uV(1);
      AppMethodBeat.o(114809);
      return;
      localObject = ca.VGx;
      break;
      label572:
      i = 0;
      break label175;
      label577:
      paramBoolean = false;
      break label257;
      label582:
      paramBoolean = false;
      break label512;
      label587:
      if ((!paramBoolean) && (bool1)) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 14L, 1L, false);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114808);
    if (this.NIW != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114802);
          c.a(c.this).ic(true);
          c.b(c.this);
          AppMethodBeat.o(114802);
        }
      });
    }
    if (this.NIX != null)
    {
      localObject = this.NIX;
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
    Object localObject = gxs().NPf.NJk;
    if (((l)localObject).NMk != null)
    {
      localObject = ((l)localObject).NMk;
      if (((n)localObject).NNc != null)
      {
        ((n)localObject).NNc.quitSafely();
        ((n)localObject).NNc = null;
      }
    }
    this.appForegroundListener.dead();
    h.d.b(Integer.valueOf(50), this.NIV);
    gxs().unRegister();
    EventCenter.instance.removeListener(this.NIY);
    EventCenter.instance.removeListener(this.NIZ);
    AppMethodBeat.o(114808);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c
 * JD-Core Version:    0.7.0.1
 */