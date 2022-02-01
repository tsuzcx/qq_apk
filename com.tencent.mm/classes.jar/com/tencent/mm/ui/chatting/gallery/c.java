package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.e;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.modelvideo.ac.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.thumbplayer.g.b.b;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/C2CVideoDownloadTask;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "videoInfo", "Lcom/tencent/mm/modelvideo/VideoInfo;", "reporter", "Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;", "onGotTask", "Lkotlin/Function1;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/modelvideo/VideoInfo;Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;Lkotlin/jvm/functions/Function1;)V", "downloadSec", "", "filename", "", "getFilename", "()Ljava/lang/String;", "length", "", "getLength", "()J", "mediaId", "getMediaId", "minRemainPercent", "getMinRemainPercent", "()I", "setMinRemainPercent", "(I)V", "minStreamSize", "preloadSec", "savedPath", "getSavedPath", "task", "buildReportData", "", "()[Ljava/lang/Integer;", "createMpVideoDownloadTask", "createTask", "findFile", "finishRemaining", "isFinished", "", "refresh", "start", "stop", "Companion", "app_release"})
public final class c
  implements com.tencent.mm.plugin.thumbplayer.c.h
{
  public static final c.a WQQ;
  private w LrH;
  private int LrI;
  private final com.tencent.mm.plugin.thumbplayer.g.b LrJ;
  private com.tencent.mm.i.h WQN;
  private int WQO;
  private final kotlin.g.a.b<com.tencent.mm.i.h, kotlin.x> WQP;
  private final ca fvt;
  private int mfN;
  private int mfO;
  
  static
  {
    AppMethodBeat.i(268405);
    WQQ = new c.a((byte)0);
    AppMethodBeat.o(268405);
  }
  
  public c(ca paramca, w paramw, com.tencent.mm.plugin.thumbplayer.g.b paramb, kotlin.g.a.b<? super com.tencent.mm.i.h, kotlin.x> paramb1)
  {
    AppMethodBeat.i(268404);
    this.fvt = paramca;
    this.LrH = paramw;
    this.LrJ = paramb;
    this.WQP = paramb1;
    paramca = null;
    if (y.brb())
    {
      Log.i("MicroMsg.C2CVideoDownloadTask", "create c2c online task: filename=" + this.fvt.apK());
      s.bqC();
      paramca = e.VB(this.fvt.apK());
    }
    paramw = paramca;
    if (paramca == null)
    {
      paramw = paramca;
      if (this.fvt.dlS())
      {
        paramw = new com.tencent.mm.i.h();
        paramw.taskName = "task_OnlineVideoUIHelper";
        paramw.field_mediaId = com.tencent.mm.aq.c.a("downvideo", this.LrH.getCreateTime(), this.LrH.bqM(), this.LrH.getFileName());
        paramw.url = this.LrH.mhZ.lor;
        paramw.iVd = 1;
        paramw.iUX = 7;
        paramw.concurrentCount = 4;
        paramw.filename = this.LrH.getFileName();
        s.bqB();
        paramw.field_fullpath = com.tencent.mm.modelvideo.x.XT(this.LrH.getFileName());
        paramw.iVc = this.LrH.blF();
      }
    }
    this.WQN = paramw;
    paramca = com.tencent.mm.n.h.axc().getValue("AndroidOnlineVideoArgs");
    paramw = (CharSequence)paramca;
    if ((paramw == null) || (paramw.length() == 0)) {
      i = 1;
    }
    while (i == 0)
    {
      Log.i("MicroMsg.C2CVideoDownloadTask", "online video config : ".concat(String.valueOf(paramca)));
      paramca = (CharSequence)paramca;
      paramca = ((Collection)new k(";").u(paramca, 0)).toArray(new String[0]);
      if (paramca == null)
      {
        paramca = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(268404);
        throw paramca;
        i = 0;
      }
      else
      {
        paramca = (String[])paramca;
        if (paramca.length >= 4)
        {
          this.mfN = Util.getInt(paramca[0], 5);
          this.mfO = Util.getInt(paramca[1], 1);
          this.LrI = Util.getInt(paramca[2], 75);
          this.WQO = (Util.getInt(paramca[3], 1) * 1048576);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.mfN = 5;
        this.mfO = 1;
        this.LrI = 75;
        this.WQO = 1048576;
      }
      Log.i("MicroMsg.C2CVideoDownloadTask", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.mfN), Integer.valueOf(this.mfO), Integer.valueOf(this.LrI), Integer.valueOf(this.WQO) });
      AppMethodBeat.o(268404);
      return;
    }
  }
  
  private final String hRA()
  {
    AppMethodBeat.i(268403);
    Object localObject1;
    if (this.LrH.bqP() == -1) {
      if (!u.agG(this.LrH.bqN()))
      {
        s.bqB();
        localObject1 = com.tencent.mm.modelvideo.x.XT(this.fvt.apK());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(268403);
      return localObject1;
      localObject1 = this.LrH.bqN();
      continue;
      s.bqB();
      String str = com.tencent.mm.modelvideo.x.XT(this.fvt.apK());
      if ((this.fvt.apA() == 1) && (this.LrH.bqU() != null) && (this.LrH.bqU().TCA)) {}
      try
      {
        Object localObject2 = u.bBT(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        p.j(localObject1, "VFSFileOp.getParentAbsolutePath(path) ?: \"\"");
        localObject2 = localObject1;
        if (!n.pu((String)localObject1, "/")) {
          localObject2 = (String)localObject1 + "/";
        }
        localObject1 = u.bBW(str);
        localObject1 = (String)localObject2 + (String)localObject1 + "_hd.mp4";
        boolean bool = u.agG((String)localObject1);
        Log.i("MicroMsg.C2CVideoDownloadTask", "local capture video, hdFilePath: " + (String)localObject1 + ", exist: " + bool);
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.C2CVideoDownloadTask", "try to get hd filePath error: " + localException.getMessage());
        }
      }
      localObject1 = str;
    }
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(268402);
    w localw = y.Yk(eRe());
    if (localw != null)
    {
      this.LrH = localw;
      AppMethodBeat.o(268402);
      return;
    }
    AppMethodBeat.o(268402);
  }
  
  public final String eRe()
  {
    com.tencent.mm.i.h localh = this.WQN;
    if (localh != null) {
      return localh.filename;
    }
    return null;
  }
  
  public final String fZd()
  {
    AppMethodBeat.i(268396);
    String str = hRA();
    AppMethodBeat.o(268396);
    return str;
  }
  
  public final int fZe()
  {
    return this.LrI;
  }
  
  public final void fZf()
  {
    AppMethodBeat.i(268400);
    Log.i("MicroMsg.C2CVideoDownloadTask", "finishRemaining()");
    Object localObject = this.WQN;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.i.h)localObject).filename;; localObject = null)
    {
      y.aR((String)localObject, 2);
      AppMethodBeat.o(268400);
      return;
    }
  }
  
  public final String getMediaId()
  {
    com.tencent.mm.i.h localh = this.WQN;
    if (localh != null) {
      return localh.field_mediaId;
    }
    return null;
  }
  
  public final boolean isFinished()
  {
    AppMethodBeat.i(268401);
    if ((this.LrH.bqS()) || (this.LrH.getStatus() == 123))
    {
      AppMethodBeat.o(268401);
      return true;
    }
    AppMethodBeat.o(268401);
    return false;
  }
  
  public final long sr()
  {
    AppMethodBeat.i(268397);
    com.tencent.mm.i.h localh = this.WQN;
    if (localh != null)
    {
      l = localh.iVc;
      AppMethodBeat.o(268397);
      return l;
    }
    long l = this.LrH.bfj();
    AppMethodBeat.o(268397);
    return l;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(268398);
    Log.i("MicroMsg.C2CVideoDownloadTask", "start task: path=" + hRA());
    if ((this.fvt.apA() == 1) && (!this.fvt.dlS()))
    {
      AppMethodBeat.o(268398);
      return false;
    }
    if (this.WQN == null)
    {
      AppMethodBeat.o(268398);
      return false;
    }
    Object localObject = this.WQN;
    if (localObject != null) {
      this.WQP.invoke(localObject);
    }
    localObject = (CharSequence)getMediaId();
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(268398);
      return false;
    }
    long l = this.LrH.blF();
    if (l < 0L)
    {
      Log.i("MicroMsg.C2CVideoDownloadTask", "video size[" + l + "] less than config size[0], do not stream video");
      y.b(this.LrH, 9);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 17L, 1L, false);
      AppMethodBeat.o(268398);
      return false;
    }
    ab.ah(this.fvt);
    boolean bool = s.bqG().brd();
    s.bqC().a(this.WQN, bool);
    y.b(this.LrH, 1);
    AppMethodBeat.o(268398);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(268399);
    Log.i("MicroMsg.C2CVideoDownloadTask", "stop()");
    e locale = s.bqC();
    String str = getMediaId();
    b.b localb = this.LrJ.goP();
    locale.l(str, new Integer[] { Integer.valueOf(localb.EFk), Integer.valueOf(localb.MTC), Integer.valueOf(localb.MTD), Integer.valueOf(localb.MTA), Integer.valueOf(localb.MTE), Integer.valueOf(localb.MTF), Integer.valueOf(localb.errorCode) });
    AppMethodBeat.o(268399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c
 * JD-Core Version:    0.7.0.1
 */