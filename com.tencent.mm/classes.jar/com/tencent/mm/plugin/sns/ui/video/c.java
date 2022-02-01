package com.tencent.mm.plugin.sns.ui.video;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ny;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.bh;
import com.tencent.mm.plugin.sns.ui.aq.c;
import com.tencent.mm.plugin.thumbplayer.downloader.h.a;
import com.tencent.mm.plugin.thumbplayer.f.b.b;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.vfs.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/video/SnsVideoDownloadTask;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask;", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "createTime", "", "localId", "", "reporter", "Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;", "provider", "Lcom/tencent/mm/plugin/sns/ui/video/SnsVideoDownloadTask$Provider;", "(Lcom/tencent/mm/protocal/protobuf/MediaObj;ILjava/lang/String;Lcom/tencent/mm/plugin/thumbplayer/reporter/LegacyPlayerReporter;Lcom/tencent/mm/plugin/sns/ui/video/SnsVideoDownloadTask$Provider;)V", "downloadScene", "getDownloadScene", "()I", "setDownloadScene", "(I)V", "downloadSec", "filename", "getFilename", "()Ljava/lang/String;", "isPlayMode", "", "()Z", "setPlayMode", "(Z)V", "length", "", "getLength", "()J", "localMsgId", "getLocalMsgId", "()Ljava/lang/Long;", "mediaId", "getMediaId", "minRemainPercent", "getMinRemainPercent", "preloadSec", "savedPath", "getSavedPath", "buildReportData", "", "", "()[Ljava/lang/Object;", "finishRemaining", "", "isDownloading", "isFinished", "refresh", "rptStopDownload", "rptVideoPause", "start", "stat", "Lcom/tencent/mm/plugin/thumbplayer/downloader/VideoDownloadTask$Stat;", "stop", "Companion", "Provider", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.plugin.thumbplayer.downloader.h
{
  public static final c.a RUL;
  public boolean HlA;
  private final com.tencent.mm.plugin.thumbplayer.f.b RUM;
  private final b RUN;
  private final int RUO;
  private final int createTime;
  private final String filename;
  private final String hHB;
  private final dmz ibT;
  public int lxk;
  private final String mediaId;
  private int oYJ;
  private int oYK;
  
  static
  {
    AppMethodBeat.i(308585);
    RUL = new c.a((byte)0);
    AppMethodBeat.o(308585);
  }
  
  public c(dmz paramdmz, int paramInt, String paramString, com.tencent.mm.plugin.thumbplayer.f.b paramb, b paramb1)
  {
    AppMethodBeat.i(308576);
    this.ibT = paramdmz;
    this.createTime = paramInt;
    this.hHB = paramString;
    this.RUM = paramb;
    this.RUN = paramb1;
    this.filename = this.ibT.aaTy;
    this.mediaId = az.de(this.createTime, this.ibT.Url);
    this.RUO = com.tencent.mm.k.i.aRC().getInt("SnsVideoFullDownloadPercent", 101);
    this.oYJ = com.tencent.mm.k.i.aRC().getInt("SnsVideoPreloadSec", 5);
    this.oYK = com.tencent.mm.k.i.aRC().getInt("SnsVideoDownloadSec", 1);
    Log.i("MicroMsg.SnsVideoDownloadTask", "createTime=" + this.createTime + ", localId=" + this.hHB + ", createTime=" + this.createTime + ", preloadSec=" + this.oYJ + " downloadSec=" + this.oYK + "], needFinish=" + this.RUO + ',');
    AppMethodBeat.o(308576);
  }
  
  private static final void a(c paramc)
  {
    int i = 1;
    AppMethodBeat.i(308583);
    s.u(paramc, "this$0");
    b.b localb = paramc.RUM.hLI();
    aq.c localc = paramc.RUN.hhZ();
    ny localny = new ny();
    localny.iVU = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
    localny.irv = 0L;
    localny.irw = 0L;
    localny.iYT = y.bEl(localc.filePath);
    localny.vW(localc.hQX);
    localny.vV(localc.hQU);
    localny.iXC = localb.Kyp;
    localny.iYV = localb.TGg;
    localny.iYW = localb.TGh;
    localny.iYX = localb.Gpp;
    localny.iRV = localb.TGi;
    localny.iZq = localb.TGj;
    localny.iZr = localb.errorCode;
    localny.jgO = localc.scene;
    localny.vX(localc.sessionId);
    localny.jgQ = ((int)localc.RgS);
    try
    {
      paramc = com.tencent.mm.plugin.sight.base.f.aVX(az.E(paramc.ibT));
      if (paramc != null)
      {
        localny.jgR = paramc.width;
        localny.jgS = paramc.height;
        localny.jgT = paramc.frameRate;
        localny.jgU = localb.TGk;
        if ((localb.TGe & 0x1) != 0)
        {
          j = 1;
          if ((localb.TGe & 0x2) == 0) {
            break label417;
          }
          k = 1;
          localny.jgV = localny.iYX;
          localny.jgW = localny.iRV;
          if ((j == 0) || (k == 0)) {
            break label422;
          }
          i = 3;
          localny.jgX = i;
          if (paramc.videoDuration != 0)
          {
            if (!localb.TGl) {
              break label440;
            }
            l = 10000L;
            localny.jgY = l;
          }
          localny.wa(paramc.width + 'x' + paramc.height);
        }
      }
      else
      {
        localny.bMH();
        AppMethodBeat.o(308583);
        return;
      }
    }
    finally
    {
      for (;;)
      {
        long l;
        Log.w("MicroMsg.SnsVideoDownloadTask", "Failed to getMediaInfo");
        paramc = null;
        continue;
        int j = 0;
        continue;
        label417:
        int k = 0;
        continue;
        label422:
        if (j == 0) {
          if (k != 0)
          {
            i = 2;
          }
          else
          {
            i = 0;
            continue;
            label440:
            l = Math.min(10000L, localb.TGf * 10000L / paramc.videoDuration);
          }
        }
      }
    }
  }
  
  private final Object[] hss()
  {
    AppMethodBeat.i(308580);
    b.b localb1 = this.RUM.hLI();
    Object localObject3 = this.RUN.hhZ();
    try
    {
      com.tencent.mm.plugin.sight.base.b localb = com.tencent.mm.plugin.sight.base.f.aVX(az.E(this.ibT));
      if ((localb1.TGe & 0x1) != 0)
      {
        i = 1;
        if ((localb1.TGe & 0x2) == 0) {
          break label455;
        }
        m = 1;
        if ((localb == null) || (localb.videoDuration == 0)) {
          break label489;
        }
        if (!localb1.TGl) {
          break label461;
        }
        l1 = 10000L;
        int i1 = localb1.Kyp;
        int i2 = localb1.TGg;
        int i3 = localb1.TGh;
        int i4 = localb1.Gpp;
        int i5 = localb1.TGi;
        int i6 = localb1.TGj;
        int i7 = localb1.errorCode;
        int i8 = ((aq.c)localObject3).scene;
        String str1 = ((aq.c)localObject3).sessionId;
        s.s(str1, "uiReport.sessionId");
        long l2 = ((aq.c)localObject3).RgS;
        String str2 = ((aq.c)localObject3).hQX;
        s.s(str2, "uiReport.snsId");
        String str3 = ((aq.c)localObject3).hQU;
        s.s(str3, "uiReport.snsUrl");
        localObject3 = ((aq.c)localObject3).filePath;
        s.s(localObject3, "uiReport.filePath");
        long l3 = this.RUN.hia();
        if (localb != null) {
          break label495;
        }
        j = 0;
        if (localb != null) {
          break label504;
        }
        k = 0;
        if (localb != null) {
          break label513;
        }
        n = 0;
        long l4 = localb1.TGk;
        if ((i == 0) || (m == 0)) {
          break label523;
        }
        i = 3;
        AppMethodBeat.o(308580);
        return new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), str1, Long.valueOf(l2), str2, str3, localObject3, Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Long.valueOf(l4), Integer.valueOf(i), Long.valueOf(l1) };
      }
    }
    finally
    {
      for (;;)
      {
        Log.w("MicroMsg.SnsVideoDownloadTask", "Failed to getMediaInfo");
        Object localObject2 = null;
        continue;
        int i = 0;
        continue;
        label455:
        int m = 0;
        continue;
        label461:
        long l1 = Math.min(10000L, localb1.TGf * 10000L / localObject2.videoDuration);
        continue;
        label489:
        l1 = 0L;
        continue;
        label495:
        int j = localObject2.width;
        continue;
        label504:
        int k = localObject2.height;
        continue;
        label513:
        int n = localObject2.frameRate;
        continue;
        label523:
        if (i != 0) {
          i = 1;
        } else if (m != 0) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
  }
  
  public final long RU()
  {
    AppMethodBeat.i(308591);
    z localz = az.aYH(this.hHB);
    if (localz == null)
    {
      Log.w("MicroMsg.SnsVideoDownloadTask", s.X("Couldn't find video info for ", this.hHB));
      AppMethodBeat.o(308591);
      return 0L;
    }
    long l = localz.omT;
    AppMethodBeat.o(308591);
    return l;
  }
  
  public final void bDL() {}
  
  public final String fZN()
  {
    return this.filename;
  }
  
  public final String getMediaId()
  {
    return this.mediaId;
  }
  
  public final void hnb()
  {
    AppMethodBeat.i(308600);
    com.tencent.threadpool.h.ahAA.g(new c..ExternalSyntheticLambda0(this), "rptVideoPause");
    AppMethodBeat.o(308600);
  }
  
  public final String hso()
  {
    AppMethodBeat.i(308589);
    String str = az.E(this.ibT);
    AppMethodBeat.o(308589);
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
    AppMethodBeat.i(308596);
    Object localObject = al.hgz();
    String str = this.hHB;
    localObject = ((ba)localObject).QyD;
    if ((localObject != null) && (!TextUtils.isEmpty(((bh)localObject).hES)) && (((bh)localObject).hES.equals(str))) {}
    while (localObject == null)
    {
      AppMethodBeat.o(308596);
      return null;
      localObject = null;
    }
    localObject = new h.a(((bh)localObject).progress, ((bh)localObject).dUJ, ((bh)localObject).QzJ, ((bh)localObject).QzK);
    AppMethodBeat.o(308596);
    return localObject;
  }
  
  public final void hst()
  {
    AppMethodBeat.i(308598);
    Log.w("MicroMsg.SnsVideoDownloadTask", "finishRemaining: savedPath=" + az.E(this.ibT) + ", mediaId=" + this.mediaId);
    al.hgz().a(this.ibT, this.createTime, this.hHB, false, false, 36);
    AppMethodBeat.o(308598);
  }
  
  public final boolean isDownloading()
  {
    AppMethodBeat.i(308597);
    ba localba = al.hgz();
    Object localObject = this.ibT;
    int i = this.createTime;
    String str = this.hHB;
    bh localbh = localba.QyD;
    if ((localbh != null) && (!TextUtils.isEmpty(localbh.hES)) && (localbh.hES.equals(str)))
    {
      AppMethodBeat.o(308597);
      return true;
    }
    localObject = az.de(i, ((dmz)localObject).Url);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AppMethodBeat.o(308597);
      return false;
    }
    boolean bool = localba.QyF.containsKey(localObject);
    AppMethodBeat.o(308597);
    return bool;
  }
  
  public final boolean isFinished()
  {
    AppMethodBeat.i(308603);
    CharSequence localCharSequence = (CharSequence)az.a(this.hHB, this.ibT);
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(308603);
      return true;
    }
    AppMethodBeat.o(308603);
    return false;
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(308594);
    Log.i("MicroMsg.SnsVideoDownloadTask", "start: savedPath=" + az.E(this.ibT) + ", mediaId=" + this.mediaId);
    CharSequence localCharSequence = (CharSequence)az.E(this.ibT);
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
      AppMethodBeat.o(308594);
      return false;
      i = 0;
      break;
    }
    label122:
    al.hgz().a(this.ibT, this.createTime, this.hHB, this.HlA, true, this.lxk);
    AppMethodBeat.o(308594);
    return true;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(308595);
    Log.w("MicroMsg.SnsVideoDownloadTask", "stop: savedPath=" + az.E(this.ibT) + ", mediaId=" + this.mediaId);
    CharSequence localCharSequence = (CharSequence)this.mediaId;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      al.hgz().p(this.mediaId, hss());
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 203L, 1L, false);
      AppMethodBeat.o(308595);
      return;
    }
    hnb();
    AppMethodBeat.o(308595);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/video/SnsVideoDownloadTask$Provider;", "", "providePlayVideoDurationByResume", "", "provideUiReport", "Lcom/tencent/mm/plugin/sns/ui/OnlineVideoViewHelper$VideoRptStruct;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract aq.c hhZ();
    
    public abstract long hia();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.c
 * JD-Core Version:    0.7.0.1
 */