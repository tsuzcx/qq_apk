package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.ag.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.thumbplayer.downloader.h.a;
import com.tencent.mm.plugin.thumbplayer.f.b.b;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/C2CVideoDownloadTask;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "videoInfo", "Lcom/tencent/mm/modelvideo/VideoInfo;", "reporter", "Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;", "onGotTask", "Lkotlin/Function1;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/modelvideo/VideoInfo;Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;Lkotlin/jvm/functions/Function1;)V", "downloadSec", "", "filename", "", "getFilename", "()Ljava/lang/String;", "length", "", "getLength", "()J", "localMsgId", "getLocalMsgId", "()Ljava/lang/Long;", "mediaId", "getMediaId", "minRemainPercent", "getMinRemainPercent", "()I", "setMinRemainPercent", "(I)V", "minStreamSize", "preloadSec", "savedPath", "getSavedPath", "task", "buildReportData", "", "()[Ljava/lang/Integer;", "createMpVideoDownloadTask", "createTask", "findFile", "finishRemaining", "isFinished", "", "refresh", "start", "stop", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements com.tencent.mm.plugin.thumbplayer.downloader.h
{
  public static final e.a aeAr;
  private final com.tencent.mm.plugin.thumbplayer.f.b RUM;
  private int RUO;
  private z aeAk;
  private com.tencent.mm.g.h aeAm;
  private int aeAo;
  private final kotlin.g.a.b<com.tencent.mm.g.h, ah> aeAs;
  private final cc hzO;
  private int oYJ;
  private int oYK;
  
  static
  {
    AppMethodBeat.i(254528);
    aeAr = new e.a((byte)0);
    AppMethodBeat.o(254528);
  }
  
  public e(cc paramcc, z paramz, com.tencent.mm.plugin.thumbplayer.f.b paramb, kotlin.g.a.b<? super com.tencent.mm.g.h, ah> paramb1)
  {
    AppMethodBeat.i(254517);
    this.hzO = paramcc;
    this.aeAk = paramz;
    this.RUM = paramb;
    this.aeAs = paramb1;
    paramcc = null;
    com.tencent.mm.modelcontrol.e.bIg();
    if (com.tencent.mm.modelcontrol.e.bIt())
    {
      Log.i("MicroMsg.C2CVideoDownloadTask", s.X("create c2c online task: filename=", this.hzO.field_imgPath));
      v.bOi();
      paramcc = j.NA(this.hzO.field_imgPath);
    }
    paramz = paramcc;
    if (paramcc == null)
    {
      paramz = paramcc;
      if (this.hzO.dSI())
      {
        paramz = new com.tencent.mm.g.h();
        paramz.taskName = "task_OnlineVideoUIHelper";
        paramz.field_mediaId = com.tencent.mm.modelcdntran.h.a("downvideo", this.aeAk.createTime, this.aeAk.bOs(), this.aeAk.getFileName());
        paramz.url = this.aeAk.pbk.nTu;
        paramz.lxi = 1;
        paramz.lxc = 7;
        paramz.concurrentCount = 4;
        paramz.filename = this.aeAk.getFileName();
        v.bOh();
        paramz.field_fullpath = aa.PX(this.aeAk.getFileName());
        paramz.lxh = this.aeAk.osy;
      }
    }
    this.aeAm = paramz;
    paramcc = i.aRC().getValue("AndroidOnlineVideoArgs");
    paramz = (CharSequence)paramcc;
    if ((paramz == null) || (paramz.length() == 0)) {
      i = 1;
    }
    while (i == 0)
    {
      Log.i("MicroMsg.C2CVideoDownloadTask", s.X("online video config : ", paramcc));
      s.s(paramcc, "config");
      paramcc = (CharSequence)paramcc;
      paramcc = ((Collection)new k(";").o(paramcc, 0)).toArray(new String[0]);
      if (paramcc == null)
      {
        paramcc = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(254517);
        throw paramcc;
        i = 0;
      }
      else
      {
        paramcc = (String[])paramcc;
        if (paramcc.length >= 4)
        {
          this.oYJ = Util.getInt(paramcc[0], 5);
          this.oYK = Util.getInt(paramcc[1], 1);
          this.RUO = Util.getInt(paramcc[2], 75);
          this.aeAo = (Util.getInt(paramcc[3], 1) * 1048576);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.oYJ = 5;
        this.oYK = 1;
        this.RUO = 75;
        this.aeAo = 1048576;
      }
      Log.i("MicroMsg.C2CVideoDownloadTask", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.oYJ), Integer.valueOf(this.oYK), Integer.valueOf(this.RUO), Integer.valueOf(this.aeAo) });
      AppMethodBeat.o(254517);
      return;
    }
  }
  
  private final String juX()
  {
    AppMethodBeat.i(254526);
    Object localObject1;
    if (this.aeAk.pbi == -1) {
      if (!y.ZC(this.aeAk.bOt()))
      {
        v.bOh();
        localObject1 = aa.PX(this.hzO.field_imgPath);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(254526);
      return localObject1;
      localObject1 = this.aeAk.bOt();
      continue;
      v.bOh();
      String str = aa.PX(this.hzO.field_imgPath);
      if ((this.hzO.field_isSend == 1) && (this.aeAk.pbl != null) && (this.aeAk.pbl.aaSg)) {}
      try
      {
        Object localObject2 = y.bEo(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (!n.rs((String)localObject1, "/")) {
          localObject2 = s.X((String)localObject1, "/");
        }
        localObject1 = y.bEq(str);
        localObject1 = (String)localObject2 + localObject1 + "_hd.mp4";
        boolean bool = y.ZC((String)localObject1);
        Log.i("MicroMsg.C2CVideoDownloadTask", "local capture video, hdFilePath: " + (String)localObject1 + ", exist: " + bool);
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.C2CVideoDownloadTask", s.X("try to get hd filePath error: ", localException.getMessage()));
        }
      }
      localObject1 = str;
    }
  }
  
  public final long RU()
  {
    AppMethodBeat.i(254548);
    Object localObject = this.aeAm;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Long.valueOf(((com.tencent.mm.g.h)localObject).lxh))
    {
      l = this.aeAk.omT;
      AppMethodBeat.o(254548);
      return l;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(254548);
    return l;
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(254585);
    z localz = ab.Qo(fZN());
    if (localz != null) {
      this.aeAk = localz;
    }
    AppMethodBeat.o(254585);
  }
  
  public final String fZN()
  {
    com.tencent.mm.g.h localh = this.aeAm;
    if (localh == null) {
      return null;
    }
    return localh.filename;
  }
  
  public final String getMediaId()
  {
    com.tencent.mm.g.h localh = this.aeAm;
    if (localh == null) {
      return null;
    }
    return localh.field_mediaId;
  }
  
  public final String hso()
  {
    AppMethodBeat.i(254538);
    String str = juX();
    AppMethodBeat.o(254538);
    return str;
  }
  
  public final Long hsp()
  {
    return null;
  }
  
  public final int hsq()
  {
    return this.RUO;
  }
  
  public final h.a hsr()
  {
    AppMethodBeat.i(254595);
    s.u(this, "this");
    AppMethodBeat.o(254595);
    return null;
  }
  
  public final void hst()
  {
    AppMethodBeat.i(254571);
    Log.i("MicroMsg.C2CVideoDownloadTask", "finishRemaining()");
    Object localObject = this.aeAm;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.g.h)localObject).filename)
    {
      ab.bf((String)localObject, 2);
      AppMethodBeat.o(254571);
      return;
    }
  }
  
  public final boolean isDownloading()
  {
    AppMethodBeat.i(254590);
    s.u(this, "this");
    AppMethodBeat.o(254590);
    return true;
  }
  
  public final boolean isFinished()
  {
    AppMethodBeat.i(254580);
    if ((this.aeAk.bOx()) || (this.aeAk.status == 123))
    {
      AppMethodBeat.o(254580);
      return true;
    }
    AppMethodBeat.o(254580);
    return false;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(254563);
    Log.i("MicroMsg.C2CVideoDownloadTask", s.X("start task: path=", juX()));
    if ((this.hzO.field_isSend == 1) && (!this.hzO.dSI()))
    {
      AppMethodBeat.o(254563);
      return false;
    }
    if (this.aeAm == null)
    {
      AppMethodBeat.o(254563);
      return false;
    }
    Object localObject = this.aeAm;
    if (localObject != null) {
      this.aeAs.invoke(localObject);
    }
    localObject = (CharSequence)getMediaId();
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(254563);
      return false;
    }
    long l = this.aeAk.osy;
    if (l < 0L)
    {
      Log.i("MicroMsg.C2CVideoDownloadTask", "video size[" + l + "] less than config size[0], do not stream video");
      ab.b(this.aeAk, 9);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 17L, 1L, false);
      AppMethodBeat.o(254563);
      return false;
    }
    ac.am(this.hzO);
    boolean bool = v.bOm().bOJ();
    v.bOi().a(this.aeAm, bool);
    ab.b(this.aeAk, 1);
    AppMethodBeat.o(254563);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(254566);
    Log.i("MicroMsg.C2CVideoDownloadTask", "stop()");
    j localj = v.bOi();
    String str = getMediaId();
    b.b localb = this.RUM.hLI();
    localj.l(str, new Integer[] { Integer.valueOf(localb.Kyp), Integer.valueOf(localb.TGg), Integer.valueOf(localb.TGh), Integer.valueOf(localb.Gpp), Integer.valueOf(localb.TGi), Integer.valueOf(localb.TGj), Integer.valueOf(localb.errorCode) });
    AppMethodBeat.o(254566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e
 * JD-Core Version:    0.7.0.1
 */