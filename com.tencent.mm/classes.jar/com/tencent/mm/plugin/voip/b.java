package com.tencent.mm.plugin.voip;

import com.tencent.mm.ah.e.d;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.al;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.as;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.video.a.c;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.ttpic.VideoModule;
import com.tencent.view.raw.FilterRawGet;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.util.HashMap;

public class b
  implements ar
{
  private static int pNl = 0;
  private r pNg = null;
  private n pNh = new n();
  private com.tencent.mm.plugin.voip.ui.g pNi;
  private d pNj = new d();
  private b.a pNk = new b.a(this);
  
  static {}
  
  private static b bPw()
  {
    return (b)p.B(b.class);
  }
  
  public static r bPx()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    if (bPw().pNg == null) {
      bPw().pNg = new r();
    }
    return bPw().pNg;
  }
  
  public static com.tencent.mm.plugin.voip.ui.g bPy()
  {
    if (!com.tencent.mm.kernel.g.DK()) {
      throw new com.tencent.mm.model.b();
    }
    if (bPw().pNi == null) {
      bPw().pNi = new com.tencent.mm.plugin.voip.ui.g();
    }
    return bPw().pNi;
  }
  
  public static int bPz()
  {
    return pNl;
  }
  
  public final void bh(boolean paramBoolean)
  {
    e.d.a(Integer.valueOf(50), this.pNh);
    bPx();
    r.bRk();
    com.tencent.mm.sdk.b.a.udP.c(this.pNj);
    com.tencent.mm.sdk.b.a.udP.c(this.pNk);
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    paramBoolean = ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(73217, Boolean.valueOf(true))).booleanValue();
    boolean bool2 = ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(73218, Boolean.valueOf(true))).booleanValue();
    boolean bool1 = com.tencent.mm.m.a.zT();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzg, Boolean.valueOf(false))).booleanValue();
    y.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
    label218:
    com.tencent.mm.bw.a locala;
    if (!bool3)
    {
      if ((paramBoolean) || (bool2))
      {
        paramBoolean = true;
        if (paramBoolean != bool1)
        {
          if ((!paramBoolean) || (bool1)) {
            break label424;
          }
          h.nFQ.a(500L, 13L, 1L, false);
        }
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzg, Boolean.valueOf(true));
      }
    }
    else
    {
      as.hO(1);
      y.i("MicroMsg.SubCoreVoip", "start init beauty download");
      locala = com.tencent.mm.bw.a.uav;
      y.i("MicroMsg.BeautyDownloadLogic", "init, downloadSoPath: %s, downloadResPath: %s", new Object[] { com.tencent.mm.bw.a.uas, com.tencent.mm.bw.a.uat });
      com.tencent.mm.sdk.b.a.udP.b(locala.ekJ);
      b.c.clv();
      com.tencent.mm.pluginsdk.g.a.a.b.DL(56);
      if (!com.tencent.mm.bw.a.NF()) {
        break label449;
      }
      y.i("MicroMsg.BeautyDownloadLogic", "init check local has resource");
      com.tencent.mm.bw.a.uau = true;
      h.nFQ.f(15861, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
      h.nFQ.h(914L, 0L, 1L);
    }
    for (;;)
    {
      try
      {
        VideoModule.init(ae.getContext());
        int i = YTCommonInterface.initAuth(ae.getContext(), "rel_wechat.lic", 0, true);
        pNl = i;
        y.i("MicroMsg.SubCoreVoip", "init VideoModule initAuth: %s", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          h.nFQ.h(914L, 12L, 1L);
        }
      }
      catch (Throwable localThrowable)
      {
        label424:
        label449:
        String str;
        y.printErrStackTrace("MicroMsg.SubCoreVoip", localThrowable, "init youtu sdk failed: %s", new Object[] { localThrowable.getMessage() });
        pNl = -1;
        h.nFQ.h(914L, 12L, 1L);
        continue;
      }
      FilterRawGet.setGetInputStream(new b.2(this));
      return;
      paramBoolean = false;
      break;
      if ((paramBoolean) || (!bool1)) {
        break label218;
      }
      h.nFQ.a(500L, 14L, 1L, false);
      break label218;
      h.nFQ.h(914L, 1L, 1L);
      b.c.clv();
      str = com.tencent.mm.pluginsdk.g.a.a.b.eV(56, 1);
      if (com.tencent.mm.vfs.e.bK(str))
      {
        y.i("MicroMsg.BeautyDownloadLogic", "init, cache file %s exist, try unzip", new Object[] { str });
        h.nFQ.h(914L, 2L, 1L);
        locala.d(str, 56, 1, 1);
      }
      else
      {
        y.i("MicroMsg.BeautyDownloadLogic", "init cannot find beauty resource");
        h.nFQ.f(15861, new Object[] { Integer.valueOf(0), Integer.valueOf(2) });
      }
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    if (this.pNi != null) {
      ai.d(new b.1(this));
    }
    e.d.b(Integer.valueOf(50), this.pNh);
    bPx();
    r.bRl();
    com.tencent.mm.sdk.b.a.udP.d(this.pNj);
    com.tencent.mm.sdk.b.a.udP.d(this.pNk);
    com.tencent.mm.bw.a locala = com.tencent.mm.bw.a.uav;
    y.i("MicroMsg.BeautyDownloadLogic", "unInit");
    com.tencent.mm.sdk.b.a.udP.d(locala.ekJ);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b
 * JD-Core Version:    0.7.0.1
 */