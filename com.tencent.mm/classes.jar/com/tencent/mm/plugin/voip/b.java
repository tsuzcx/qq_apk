package com.tencent.mm.plugin.voip;

import a.f.b.j;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.an;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.ResourcePathMapper.MODE;
import com.tencent.view.raw.FilterRawGet;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.File;
import java.util.HashMap;

public class b
  implements at
{
  private static int ttf;
  private t tta;
  private o ttb;
  private com.tencent.mm.plugin.voip.ui.d ttc;
  private d ttd;
  private b.a tte;
  
  static
  {
    AppMethodBeat.i(4317);
    com.tencent.mm.plugin.voip.video.a.d.checkLibraryInit();
    ttf = 0;
    AppMethodBeat.o(4317);
  }
  
  public b()
  {
    AppMethodBeat.i(4311);
    this.tta = null;
    this.ttb = new o();
    this.ttd = new d();
    this.tte = new b.a(this);
    AppMethodBeat.o(4311);
  }
  
  private static b cLB()
  {
    AppMethodBeat.i(4312);
    b localb = (b)q.S(b.class);
    AppMethodBeat.o(4312);
    return localb;
  }
  
  public static t cLC()
  {
    AppMethodBeat.i(4313);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(4313);
      throw ((Throwable)localObject);
    }
    if (cLB().tta == null) {
      cLB().tta = new t();
    }
    Object localObject = cLB().tta;
    AppMethodBeat.o(4313);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.voip.ui.d cLD()
  {
    AppMethodBeat.i(4314);
    if (!com.tencent.mm.kernel.g.RG())
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(4314);
      throw ((Throwable)localObject);
    }
    if (cLB().ttc == null) {
      cLB().ttc = new com.tencent.mm.plugin.voip.ui.d();
    }
    Object localObject = cLB().ttc;
    AppMethodBeat.o(4314);
    return localObject;
  }
  
  public static int cLE()
  {
    return ttf;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(4316);
    e.d.a(Integer.valueOf(50), this.ttb);
    cLC();
    com.tencent.mm.sdk.b.a.ymk.c(this.ttd);
    com.tencent.mm.sdk.b.a.ymk.c(this.tte);
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    paramBoolean = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(73217, Boolean.TRUE)).booleanValue();
    boolean bool2 = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(73218, Boolean.TRUE)).booleanValue();
    boolean bool1 = com.tencent.mm.m.a.MB();
    boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yJU, Boolean.FALSE)).booleanValue();
    ab.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
    if (!bool3)
    {
      if ((!paramBoolean) && (!bool2)) {
        break label422;
      }
      paramBoolean = true;
      if (paramBoolean != bool1)
      {
        if ((!paramBoolean) || (bool1)) {
          break label427;
        }
        h.qsU.idkeyStat(500L, 13L, 1L, false);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJU, Boolean.TRUE);
      au.kA(1);
      try
      {
        Context localContext = ah.getContext();
        Object localObject1 = com.tencent.mm.plugin.voip.video.a.a.tHN;
        localObject1 = ah.getContext();
        j.p(localObject1, "MMApplicationContext.getContext()");
        localObject1 = com.tencent.mm.plugin.voip.video.a.a.getExternalFilesDir((Context)localObject1, com.tencent.mm.plugin.voip.video.a.a.ltz).getPath();
        j.p(localObject1, "getExternalFilesDir(MMAp… VIDEO_LUT_FILE_DIR).path");
        Object localObject2 = com.tencent.mm.plugin.voip.video.a.a.tHN;
        localObject2 = com.tencent.mm.plugin.voip.video.a.a.getYtDetectModelFileDir();
        Object localObject3 = com.tencent.mm.plugin.voip.video.a.a.tHN;
        localObject3 = ah.getContext();
        j.p(localObject3, "MMApplicationContext.getContext()");
        localObject3 = com.tencent.mm.plugin.voip.video.a.a.getExternalFilesDir((Context)localObject3, com.tencent.mm.plugin.voip.video.a.a.ltB).getPath();
        j.p(localObject3, "getExternalFilesDir(MMAp…DEL_BACKUP_FILE_DIR).path");
        VideoModule.init(localContext, (String)localObject1, (String)localObject2, (String)localObject3);
        ResourcePathMapper.init(ResourcePathMapper.MODE.LOCAL);
        com.tencent.mm.plugin.voip.video.a.d.checkLibraryInit();
        int i = YTCommonInterface.initAuth(ah.getContext(), "rel_wechat.lic", 0, false);
        com.tencent.view.g.sa(true);
        ttf = i;
        ab.i("MicroMsg.SubCoreVoip", "init VideoModule initAuth: %s", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          h.qsU.j(914L, 12L, 1L);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SubCoreVoip", localThrowable, "init youtu sdk failed: %s", new Object[] { localThrowable.getMessage() });
          ttf = -1;
          h.qsU.j(914L, 12L, 1L);
        }
      }
      FilterRawGet.setGetInputStream(new b.2(this));
      AppMethodBeat.o(4316);
      return;
      label422:
      paramBoolean = false;
      break;
      label427:
      if ((!paramBoolean) && (bool1)) {
        h.qsU.idkeyStat(500L, 14L, 1L, false);
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(4315);
    if (this.ttc != null) {
      al.d(new b.1(this));
    }
    e.d.b(Integer.valueOf(50), this.ttb);
    cLC();
    com.tencent.mm.sdk.b.a.ymk.d(this.ttd);
    com.tencent.mm.sdk.b.a.ymk.d(this.tte);
    AppMethodBeat.o(4315);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b
 * JD-Core Version:    0.7.0.1
 */