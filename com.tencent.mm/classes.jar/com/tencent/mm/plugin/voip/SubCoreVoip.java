package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.app.q.a;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.ui.j;
import com.tencent.mm.plugin.voip.video.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import com.tencent.threadpool.i;
import java.util.HashMap;

public class SubCoreVoip
  implements be
{
  private u UuW;
  private p UuX;
  private j UuY;
  com.tencent.mm.media.util.d UuZ;
  private VoipEventListener Uva;
  private SubCoreVoip.SyncPostTaskListener Uvb;
  private q.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(114810);
    c.icQ();
    AppMethodBeat.o(114810);
  }
  
  public SubCoreVoip()
  {
    AppMethodBeat.i(114804);
    this.UuW = null;
    this.UuX = new p();
    this.Uva = new VoipEventListener();
    this.Uvb = new SubCoreVoip.SyncPostTaskListener(this);
    this.appForegroundListener = new SubCoreVoip.1(this);
    AppMethodBeat.o(114804);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString)
  {
    AppMethodBeat.i(292224);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acQF, Boolean.FALSE);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acQH, Boolean.valueOf(paramBoolean1));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acQG, Boolean.valueOf(paramBoolean2));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acQI, Long.valueOf(paramLong));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acQK, paramString);
    com.tencent.mm.kernel.h.baE().ban().iZy();
    AppMethodBeat.o(292224);
  }
  
  private static SubCoreVoip hVo()
  {
    AppMethodBeat.i(114805);
    SubCoreVoip localSubCoreVoip = (SubCoreVoip)y.aL(SubCoreVoip.class);
    AppMethodBeat.o(114805);
    return localSubCoreVoip;
  }
  
  public static u hVp()
  {
    AppMethodBeat.i(114806);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(114806);
      throw ((Throwable)localObject);
    }
    if (hVo().UuW == null) {
      hVo().UuW = new u();
    }
    Object localObject = hVo().UuW;
    AppMethodBeat.o(114806);
    return localObject;
  }
  
  public static j hVq()
  {
    AppMethodBeat.i(184039);
    if (!com.tencent.mm.kernel.h.baz())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(184039);
      throw ((Throwable)localObject);
    }
    if (hVo().UuY == null) {
      hVo().UuY = new j();
    }
    Object localObject = hVo().UuY;
    AppMethodBeat.o(184039);
    return localObject;
  }
  
  public static void hVr()
  {
    AppMethodBeat.i(292226);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acQF, Boolean.TRUE);
    com.tencent.mm.kernel.h.baE().ban().iZy();
    AppMethodBeat.o(292226);
  }
  
  public static boolean hVs()
  {
    AppMethodBeat.i(292228);
    if ((z.bAR() & 0x0) == 0L)
    {
      AppMethodBeat.o(292228);
      return true;
    }
    AppMethodBeat.o(292228);
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
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acQF, null);
    boolean bool1;
    int i;
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      paramBoolean = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQH, Boolean.FALSE)).booleanValue();
      bool1 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQG, Boolean.FALSE)).booleanValue();
      long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQI, Integer.valueOf(0))).longValue();
      String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acQK, null);
      Log.i("MicroMsg.SubCoreVoip", "voip message need push is %s,%s,%s,%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Long.valueOf(l), str });
      if (paramBoolean)
      {
        localObject = cc.adkp;
        if (!bool1) {
          break label497;
        }
        i = 1;
        label175:
        s.b(str, (String)localObject, i, 6, MMApplicationContext.getContext().getString(b.g.voip_on_error_shutdown_without_time));
        hVr();
      }
    }
    else
    {
      g.d.a(Integer.valueOf(50), this.UuX);
      localObject = a.lQF;
      a.aOj();
      localObject = com.tencent.mm.media.widget.d.d.nNb;
      com.tencent.mm.media.widget.d.d.bvz();
      com.tencent.threadpool.h.ahAA.bm(new SubCoreVoip.3(this));
      hVp();
      this.UuZ = new com.tencent.mm.media.util.d();
      this.UuZ.bqm();
      this.appForegroundListener.alive();
      this.Uva.alive();
      this.Uvb.alive();
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(40);
      paramBoolean = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(73217, Boolean.TRUE)).booleanValue();
      boolean bool2 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(73218, Boolean.TRUE)).booleanValue();
      bool1 = com.tencent.mm.k.b.aQL();
      boolean bool3 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWr, Boolean.FALSE)).booleanValue();
      Log.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if (!bool3)
      {
        if ((!paramBoolean) && (!bool2)) {
          break label502;
        }
        paramBoolean = true;
        label437:
        if (paramBoolean != bool1)
        {
          if ((!paramBoolean) || (bool1)) {
            break label507;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 13L, 1L, false);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acWr, Boolean.TRUE);
      bf.vg(1);
      AppMethodBeat.o(114809);
      return;
      localObject = cc.adko;
      break;
      label497:
      i = 0;
      break label175;
      label502:
      paramBoolean = false;
      break label437;
      label507:
      if ((!paramBoolean) && (bool1)) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(500L, 14L, 1L, false);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114808);
    if (this.UuY != null) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114802);
          SubCoreVoip.a(SubCoreVoip.this).jb(true);
          SubCoreVoip.b(SubCoreVoip.this);
          AppMethodBeat.o(114802);
        }
      });
    }
    if (this.UuZ != null) {
      this.UuZ.release();
    }
    Object localObject = hVp().UBE.UvO;
    if (((l)localObject).UyW != null)
    {
      localObject = ((l)localObject).UyW;
      if (((n)localObject).UzQ != null)
      {
        ((n)localObject).UzQ.quitSafely();
        ((n)localObject).UzQ = null;
      }
    }
    this.appForegroundListener.dead();
    g.d.b(Integer.valueOf(50), this.UuX);
    hVp().unRegister();
    this.Uva.dead();
    this.Uvb.dead();
    AppMethodBeat.o(114808);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.SubCoreVoip
 * JD-Core Version:    0.7.0.1
 */