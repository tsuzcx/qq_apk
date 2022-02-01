package com.tencent.mm.plugin.sns.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.kz;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.ui.ap.c;
import com.tencent.mm.plugin.thumbplayer.g.b;
import com.tencent.mm.plugin.thumbplayer.g.b.b;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/video/SnsVideoDownloadTask;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "createTime", "", "localId", "", "reporter", "Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;", "provider", "Lcom/tencent/mm/plugin/sns/ui/video/SnsVideoDownloadTask$Provider;", "(Lcom/tencent/mm/protocal/protobuf/MediaObj;ILjava/lang/String;Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;Lcom/tencent/mm/plugin/sns/ui/video/SnsVideoDownloadTask$Provider;)V", "downloadScene", "getDownloadScene", "()I", "setDownloadScene", "(I)V", "downloadSec", "filename", "getFilename", "()Ljava/lang/String;", "isPlayMode", "", "()Z", "setPlayMode", "(Z)V", "length", "", "getLength", "()J", "mediaId", "getMediaId", "minRemainPercent", "getMinRemainPercent", "preloadSec", "savedPath", "getSavedPath", "videoInfo", "Lcom/tencent/mm/modelvideo/VideoInfo;", "buildReportData", "", "", "()[Ljava/lang/Object;", "finishRemaining", "", "isFinished", "refresh", "rptStopDownload", "rptVideoPause", "start", "stop", "Companion", "Provider", "plugin-sns_release"})
public final class c
  implements com.tencent.mm.plugin.thumbplayer.c.h
{
  public static final c.a LrL;
  public boolean BCS;
  private final w LrH;
  private final int LrI;
  private final b LrJ;
  private final b LrK;
  private final int createTime;
  private final String fCM;
  private final cvt fVT;
  private final String filename;
  public int iVf;
  private final String mediaId;
  private int mfN;
  private int mfO;
  
  static
  {
    AppMethodBeat.i(247107);
    LrL = new c.a((byte)0);
    AppMethodBeat.o(247107);
  }
  
  public c(cvt paramcvt, int paramInt, String paramString, b paramb, b paramb1)
  {
    AppMethodBeat.i(247104);
    this.fVT = paramcvt;
    this.createTime = paramInt;
    this.fCM = paramString;
    this.LrJ = paramb;
    this.LrK = paramb1;
    this.LrH = ax.bao(this.fCM);
    this.filename = this.fVT.TDS;
    this.mediaId = ax.cs(this.createTime, this.fVT.Url);
    this.LrI = com.tencent.mm.n.h.axc().getInt("SnsVideoFullDownloadPercent", 101);
    this.mfN = com.tencent.mm.n.h.axc().getInt("SnsVideoPreloadSec", 5);
    this.mfO = com.tencent.mm.n.h.axc().getInt("SnsVideoDownloadSec", 1);
    Log.i("MicroMsg.SnsVideoDownloadTask", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[] { Integer.valueOf(this.mfN), Integer.valueOf(this.mfO), Integer.valueOf(this.LrI) });
    AppMethodBeat.o(247104);
  }
  
  public final void bfU() {}
  
  public final String eRe()
  {
    return this.filename;
  }
  
  public final void fUK()
  {
    AppMethodBeat.i(247100);
    b.b localb = this.LrJ.goP();
    ap.c localc = this.LrK.fUy();
    int i = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
    long l = u.bBQ(localc.filePath);
    kz localkz = new kz();
    localkz.vs(i);
    localkz.amD();
    localkz.amE();
    localkz.vm(l);
    localkz.BN(localc.fLp);
    localkz.BM(localc.fLm);
    localkz.vn(localb.EFk);
    localkz.vo(localb.MTC);
    localkz.vp(localb.MTD);
    localkz.vq(localb.MTA);
    localkz.vr(localb.MTE);
    localkz.vt(localb.MTF);
    localkz.nD(localb.errorCode);
    localkz.nE(localc.scene);
    localkz.BO(localc.sessionId);
    localkz.nF((int)localc.KHs);
    localkz.bpa();
    AppMethodBeat.o(247100);
  }
  
  public final String fZd()
  {
    AppMethodBeat.i(247087);
    String str = ax.E(this.fVT);
    AppMethodBeat.o(247087);
    return str;
  }
  
  public final int fZe()
  {
    return this.LrI;
  }
  
  public final void fZf()
  {
    AppMethodBeat.i(247098);
    Log.w("MicroMsg.SnsVideoDownloadTask", "finishRemaining: savedPath=" + ax.E(this.fVT) + ", mediaId=" + this.mediaId);
    aj.fOG().a(this.fVT, this.createTime, this.fCM, false, false, 36);
    AppMethodBeat.o(247098);
  }
  
  public final String getMediaId()
  {
    return this.mediaId;
  }
  
  public final boolean isFinished()
  {
    AppMethodBeat.i(247101);
    CharSequence localCharSequence = (CharSequence)ax.a(this.fCM, this.fVT);
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(247101);
      return true;
    }
    AppMethodBeat.o(247101);
    return false;
  }
  
  public final long sr()
  {
    AppMethodBeat.i(247090);
    w localw = this.LrH;
    if (localw != null)
    {
      long l = localw.bfj();
      AppMethodBeat.o(247090);
      return l;
    }
    AppMethodBeat.o(247090);
    return 0L;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(247092);
    Log.i("MicroMsg.SnsVideoDownloadTask", "start: savedPath=" + ax.E(this.fVT) + ", mediaId=" + this.mediaId);
    CharSequence localCharSequence = (CharSequence)ax.E(this.fVT);
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)this.mediaId;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label117;
        }
      }
    }
    label117:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label122;
      }
      AppMethodBeat.o(247092);
      return false;
      i = 0;
      break;
    }
    label122:
    aj.fOG().a(this.fVT, this.createTime, this.fCM, this.BCS, true, this.iVf);
    AppMethodBeat.o(247092);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(247095);
    Log.w("MicroMsg.SnsVideoDownloadTask", "stop: savedPath=" + ax.E(this.fVT) + ", mediaId=" + this.mediaId);
    Object localObject1 = (CharSequence)this.mediaId;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject1 = aj.fOG();
      String str1 = this.mediaId;
      Object localObject3 = this.LrJ.goP();
      Object localObject2 = this.LrK.fUy();
      i = ((b.b)localObject3).EFk;
      int j = ((b.b)localObject3).MTC;
      int k = ((b.b)localObject3).MTD;
      int m = ((b.b)localObject3).MTA;
      int n = ((b.b)localObject3).MTE;
      int i1 = ((b.b)localObject3).MTF;
      int i2 = ((b.b)localObject3).errorCode;
      int i3 = ((ap.c)localObject2).scene;
      localObject3 = ((ap.c)localObject2).sessionId;
      p.j(localObject3, "uiReport.sessionId");
      long l = ((ap.c)localObject2).KHs;
      String str2 = ((ap.c)localObject2).fLp;
      p.j(str2, "uiReport.snsId");
      String str3 = ((ap.c)localObject2).fLm;
      p.j(str3, "uiReport.snsUrl");
      localObject2 = ((ap.c)localObject2).filePath;
      p.j(localObject2, "uiReport.filePath");
      ((ay)localObject1).p(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), localObject3, Long.valueOf(l), str2, str3, localObject2, Long.valueOf(this.LrK.fUz()) });
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 203L, 1L, false);
      AppMethodBeat.o(247095);
      return;
    }
    fUK();
    AppMethodBeat.o(247095);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/video/SnsVideoDownloadTask$Provider;", "", "providePlayVideoDurationByResume", "", "provideUiReport", "Lcom/tencent/mm/plugin/sns/ui/OnlineVideoViewHelper$VideoRptStruct;", "plugin-sns_release"})
  public static abstract interface b
  {
    public abstract ap.c fUy();
    
    public abstract long fUz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.c
 * JD-Core Version:    0.7.0.1
 */