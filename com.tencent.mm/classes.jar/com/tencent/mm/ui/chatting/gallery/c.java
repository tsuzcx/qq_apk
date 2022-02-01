package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.a;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.ae;
import com.tencent.mm.modelvideo.ag.a;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.thumbplayer.downloader.h.a;
import com.tencent.mm.plugin.thumbplayer.f.b;
import com.tencent.mm.plugin.thumbplayer.f.b.b;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/C2COriginVideoDownloadTask;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "videoInfo", "Lcom/tencent/mm/modelvideo/VideoInfo;", "reporter", "Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;", "parseInfo", "Lcom/tencent/mm/modelvideo/VideoParseInfo;", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/modelvideo/VideoInfo;Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;Lcom/tencent/mm/modelvideo/VideoParseInfo;)V", "downloadSec", "", "filename", "", "getFilename", "()Ljava/lang/String;", "length", "", "getLength", "()J", "localMsgId", "getLocalMsgId", "()Ljava/lang/Long;", "mediaId", "getMediaId", "minRemainPercent", "getMinRemainPercent", "()I", "setMinRemainPercent", "(I)V", "minStreamSize", "originVideoInfo", "preloadSec", "savedPath", "getSavedPath", "task", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "buildReportData", "", "()[Ljava/lang/Integer;", "createMpVideoDownloadTask", "createOriginVideoInfo", "originFileName", "createOriginVideoTask", "createTask", "findFile", "finishRemaining", "", "isFinished", "", "refresh", "start", "stop", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.plugin.thumbplayer.downloader.h
{
  public static final c.a aeAj;
  private final b RUM;
  private int RUO;
  private z aeAk;
  private final ae aeAl;
  private com.tencent.mm.g.h aeAm;
  private z aeAn;
  private int aeAo;
  private final cc hzO;
  private int oYJ;
  private int oYK;
  
  static
  {
    AppMethodBeat.i(254490);
    aeAj = new c.a((byte)0);
    AppMethodBeat.o(254490);
  }
  
  public c(cc paramcc, z paramz, b paramb, ae paramae)
  {
    AppMethodBeat.i(254473);
    this.hzO = paramcc;
    this.aeAk = paramz;
    this.RUM = paramb;
    this.aeAl = paramae;
    paramcc = i.aRC().getValue("AndroidOnlineVideoArgs");
    paramz = (CharSequence)paramcc;
    if ((paramz == null) || (paramz.length() == 0)) {
      i = 1;
    }
    while (i == 0)
    {
      Log.i("MicroMsg.C2COriginVideoDownloadTask", s.X("online video config : ", paramcc));
      s.s(paramcc, "config");
      paramcc = (CharSequence)paramcc;
      paramcc = ((Collection)new k(";").o(paramcc, 0)).toArray(new String[0]);
      if (paramcc == null)
      {
        paramcc = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(254473);
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
      Log.i("MicroMsg.C2COriginVideoDownloadTask", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.oYJ), Integer.valueOf(this.oYK), Integer.valueOf(this.RUO), Integer.valueOf(this.aeAo) });
      AppMethodBeat.o(254473);
      return;
    }
  }
  
  private final z bBg(String paramString)
  {
    AppMethodBeat.i(254479);
    if (paramString != null)
    {
      this.aeAk.PP(paramString);
      z localz = new z();
      localz.hVQ = this.aeAk.bOs();
      localz.paV = this.aeAk.bOq();
      localz.createTime = this.hzO.getCreateTime();
      localz.hTh = this.aeAk.hTh;
      localz.pbc = this.aeAk.pbc;
      localz.osy = this.aeAl.pbT;
      localz.omT = this.aeAk.omT;
      localz.pbf = 0;
      localz.fileName = paramString;
      localz.pba = Util.nowSecond();
      localz.pbd = 0;
      localz.pbi = 1;
      localz.status = 111;
      AppMethodBeat.o(254479);
      return localz;
    }
    AppMethodBeat.o(254479);
    return null;
  }
  
  private final String juX()
  {
    AppMethodBeat.i(254485);
    if (Util.isNullOrNil(this.aeAk.oYk))
    {
      AppMethodBeat.o(254485);
      return null;
    }
    Object localObject1;
    if (this.aeAk.pbi == -1) {
      if (!y.ZC(this.aeAk.bOt()))
      {
        com.tencent.mm.modelvideo.v.bOh();
        localObject1 = aa.PX(this.aeAk.oYk);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(254485);
      return localObject1;
      localObject1 = this.aeAk.bOt();
      continue;
      com.tencent.mm.modelvideo.v.bOh();
      String str = aa.PX(this.aeAk.oYk);
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
        Log.i("MicroMsg.C2COriginVideoDownloadTask", "local capture video, hdFilePath: " + (String)localObject1 + ", exist: " + bool);
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.C2COriginVideoDownloadTask", s.X("try to get hd filePath error: ", localException.getMessage()));
        }
      }
      localObject1 = str;
    }
  }
  
  public final long RU()
  {
    AppMethodBeat.i(254508);
    Object localObject = this.aeAm;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Long.valueOf(((com.tencent.mm.g.h)localObject).lxh))
    {
      l = this.aeAk.omT;
      AppMethodBeat.o(254508);
      return l;
    }
    long l = ((Long)localObject).longValue();
    AppMethodBeat.o(254508);
    return l;
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(254549);
    z localz = ab.Qo(fZN());
    if (localz != null) {
      this.aeAn = localz;
    }
    AppMethodBeat.o(254549);
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
    AppMethodBeat.i(254498);
    String str = juX();
    AppMethodBeat.o(254498);
    return str;
  }
  
  public final Long hsp()
  {
    AppMethodBeat.i(254514);
    long l = this.hzO.field_msgId;
    AppMethodBeat.o(254514);
    return Long.valueOf(l);
  }
  
  public final int hsq()
  {
    return this.RUO;
  }
  
  public final h.a hsr()
  {
    AppMethodBeat.i(254559);
    s.u(this, "this");
    AppMethodBeat.o(254559);
    return null;
  }
  
  public final void hst()
  {
    AppMethodBeat.i(254541);
    Log.i("MicroMsg.C2COriginVideoDownloadTask", "finishRemaining()");
    Object localObject = this.aeAm;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.g.h)localObject).filename)
    {
      ab.bf((String)localObject, 2);
      AppMethodBeat.o(254541);
      return;
    }
  }
  
  public final boolean isDownloading()
  {
    AppMethodBeat.i(254553);
    s.u(this, "this");
    AppMethodBeat.o(254553);
    return true;
  }
  
  public final boolean isFinished()
  {
    boolean bool2 = false;
    AppMethodBeat.i(254545);
    z localz = this.aeAn;
    boolean bool1 = bool2;
    if (localz != null) {
      if (!localz.bOx())
      {
        bool1 = bool2;
        if (localz.status != 123) {}
      }
      else
      {
        bool1 = true;
      }
    }
    AppMethodBeat.o(254545);
    return bool1;
  }
  
  public final boolean start()
  {
    com.tencent.mm.g.h localh = null;
    AppMethodBeat.i(254531);
    Log.i("MicroMsg.C2COriginVideoDownloadTask", s.X("start task: path=", juX()));
    if ((this.hzO.field_isSend == 1) && (!this.hzO.dSI()))
    {
      AppMethodBeat.o(254531);
      return false;
    }
    Object localObject1 = this.aeAk.oYk;
    boolean bool;
    if (!Util.isNullOrNil((String)localObject1))
    {
      com.tencent.mm.modelvideo.v.bOh();
      bool = y.ZC(aa.PX((String)localObject1));
      localObject1 = ab.Qo((String)localObject1);
      if ((bool) && (localObject1 != null) && (((z)localObject1).status == 199)) {
        Log.i("MicroMsg.C2COriginVideoDownloadTask", "origin file had been downloaded, return");
      }
    }
    label794:
    label795:
    for (;;)
    {
      this.aeAm = localh;
      String str;
      Object localObject2;
      if (this.aeAm == null)
      {
        AppMethodBeat.o(254531);
        return false;
        str = this.aeAk.oYk;
        if (Util.isNullOrNil(str))
        {
          localObject2 = s.X(this.aeAk.getFileName(), "origin");
          localObject1 = bBg((String)localObject2);
          if (localObject1 == null)
          {
            Log.d("MicroMsg.C2COriginVideoDownloadTask", s.X("create info Error fileName:", localObject2));
            continue;
          }
          if (!com.tencent.mm.modelvideo.v.bOh().b((z)localObject1))
          {
            Log.d("MicroMsg.C2COriginVideoDownloadTask", s.X("Insert Error fileName:", ((z)localObject1).getFileName()));
            continue;
          }
          ab.f(this.aeAk);
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label795;
        }
        this.aeAn = ((z)localObject1);
        localh = new com.tencent.mm.g.h();
        localh.taskName = "task_NetSceneDownloadVideo";
        localh.field_mediaId = com.tencent.mm.modelcdntran.h.a("downvideo", ((z)localObject1).createTime, this.aeAk.bOs(), ((z)localObject1).getFileName());
        localh.filename = ((z)localObject1).getFileName();
        localh.lxg = this.aeAl.pbP;
        localh.lxh = this.aeAl.pbT;
        localh.lxi = 0;
        localh.hQQ = this.aeAk.bOq();
        localh.lxj = this.aeAk.bOs();
        if (au.bwG(this.aeAk.bOs()))
        {
          i = com.tencent.mm.model.v.getMembersCountByChatRoomName(this.aeAk.bOs());
          label382:
          localh.hQS = i;
          com.tencent.mm.modelvideo.v.bOh();
          localh.field_fullpath = aa.PX(((z)localObject1).getFileName());
          localh.field_fileType = a.MediaType_VIDEO;
          localh.field_totalLen = ((z)localObject1).osy;
          localh.field_aesKey = this.aeAl.pbS;
          localh.field_fileId = this.aeAl.pbQ;
          localh.field_priority = a.lvZ;
          if (!au.bwG(this.aeAk.bOs())) {
            break label628;
          }
        }
        label628:
        for (int i = 1;; i = 0)
        {
          localh.field_chattype = i;
          localh.lxk = 1;
          localh.field_autostart = false;
          localh.lwM = 0;
          localh.lwN = 0;
          localh.lxm = this.hzO.getCreateTime();
          localh.hTh = this.hzO.field_msgSvrId;
          localh.lxn = 0;
          localh.field_requestVideoFormat = e.a(0, (z)localObject1);
          ((z)localObject1).clientId = localh.field_mediaId;
          break;
          localObject2 = ab.Qo(str);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = bBg(str);
          }
          if (com.tencent.mm.modelvideo.v.bOh().c((z)localObject1)) {
            break label794;
          }
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((z)localObject1).getFileName())
          {
            Log.d("MicroMsg.C2COriginVideoDownloadTask", s.X("update Error fileName:", localObject1));
            break;
          }
          i = 0;
          break label382;
        }
        localObject1 = (CharSequence)getMediaId();
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
        for (i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(254531);
          return false;
        }
        long l = this.aeAk.osy;
        if (l < 0L)
        {
          Log.i("MicroMsg.C2COriginVideoDownloadTask", "video size[" + l + "] less than config size[0], do not stream video");
          ab.b(this.aeAk, 9);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 17L, 1L, false);
          AppMethodBeat.o(254531);
          return false;
        }
        ac.am(this.hzO);
        bool = com.tencent.mm.modelvideo.v.bOm().bOJ();
        com.tencent.mm.modelvideo.v.bOi().a(this.aeAm, bool);
        ab.b(this.aeAk, 1);
        AppMethodBeat.o(254531);
        return true;
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(254537);
    Log.i("MicroMsg.C2COriginVideoDownloadTask", "stop()");
    j localj = com.tencent.mm.modelvideo.v.bOi();
    String str = getMediaId();
    b.b localb = this.RUM.hLI();
    localj.l(str, new Integer[] { Integer.valueOf(localb.Kyp), Integer.valueOf(localb.TGg), Integer.valueOf(localb.TGh), Integer.valueOf(localb.Gpp), Integer.valueOf(localb.TGi), Integer.valueOf(localb.TGj), Integer.valueOf(localb.errorCode) });
    AppMethodBeat.o(254537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c
 * JD-Core Version:    0.7.0.1
 */