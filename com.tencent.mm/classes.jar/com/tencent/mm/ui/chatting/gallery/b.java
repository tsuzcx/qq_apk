package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.thumbplayer.f.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.i.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/C2CDownloadReporter;", "Lcom/tencent/mm/plugin/thumbplayer/reporter/DownloadReporter;", "()V", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "fileName", "", "isRawVideo", "", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;Z)V", "initialSize", "", "onDownloadError", "", "ret", "", "onDownloadStarted", "timestamp", "onDownloadSucceed", "onDuplicateFileFound", "onMoovLack", "onMoovParseFailed", "onMoovParseSucceed", "onMoovReady", "offset", "length", "onNeedCompletion", "onRequestAllData", "onRequestH264", "onStartDownload", "onStopDownload", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  private final boolean aeAh;
  private long aeAi;
  private final String fileName;
  private final cc hzO;
  
  public b()
  {
    this(null, null, false);
  }
  
  public b(cc paramcc, String paramString, boolean paramBoolean)
  {
    this.hzO = paramcc;
    this.fileName = paramString;
    this.aeAh = paramBoolean;
  }
  
  public final void aoF(int paramInt)
  {
    AppMethodBeat.i(254483);
    h.OAn.idkeyStat(354L, 9L, 1L, false);
    if (this.fileName == null)
    {
      AppMethodBeat.o(254483);
      return;
    }
    z localz = ab.Qo(this.fileName);
    if (localz != null)
    {
      Object localObject;
      if (this.aeAh)
      {
        localObject = ab.Qo(localz.oYk);
        if (localObject != null)
        {
          d locald = d.aeJp;
          d.a(this.hzO, localz.getFileName(), this.aeAh, ((z)localObject).paX - this.aeAi);
          AppMethodBeat.o(254483);
        }
      }
      else
      {
        localObject = d.aeJp;
        d.a(this.hzO, localz.getFileName(), this.aeAh, localz.paX - this.aeAi);
      }
    }
    AppMethodBeat.o(254483);
  }
  
  public final void bq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(254505);
    h.OAn.idkeyStat(354L, 5L, 1L, false);
    AppMethodBeat.o(254505);
  }
  
  public final void gZM()
  {
    AppMethodBeat.i(254469);
    h.OAn.idkeyStat(354L, 1L, 1L, false);
    AppMethodBeat.o(254469);
  }
  
  public final void hLA()
  {
    AppMethodBeat.i(254521);
    h.OAn.idkeyStat(354L, 134L, 1L, false);
    AppMethodBeat.o(254521);
  }
  
  public final void hLs()
  {
    AppMethodBeat.i(254472);
    h.OAn.idkeyStat(354L, 2L, 1L, false);
    if (this.fileName == null)
    {
      AppMethodBeat.o(254472);
      return;
    }
    z localz = ab.Qo(this.fileName);
    if (localz != null)
    {
      Object localObject;
      if (this.aeAh)
      {
        localObject = ab.Qo(localz.oYk);
        if (localObject != null)
        {
          if (((z)localObject).status == 199)
          {
            AppMethodBeat.o(254472);
            return;
          }
          d locald = d.aeJp;
          d.a(this.hzO, localz.getFileName(), this.aeAh, ((z)localObject).paX - this.aeAi);
          AppMethodBeat.o(254472);
        }
      }
      else
      {
        if (localz.status == 199)
        {
          AppMethodBeat.o(254472);
          return;
        }
        localObject = d.aeJp;
        d.a(this.hzO, localz.getFileName(), this.aeAh, localz.paX - this.aeAi);
      }
    }
    AppMethodBeat.o(254472);
  }
  
  public final void hLt()
  {
    AppMethodBeat.i(254476);
    h.OAn.idkeyStat(354L, 26L, 1L, false);
    if (this.fileName == null)
    {
      AppMethodBeat.o(254476);
      return;
    }
    z localz = ab.Qo(this.fileName);
    if (localz != null)
    {
      Object localObject;
      if (this.aeAh)
      {
        localObject = ab.Qo(localz.oYk);
        if (localObject != null)
        {
          d locald = d.aeJp;
          d.a(this.hzO, localz.getFileName(), this.aeAh, ((z)localObject).paX - this.aeAi);
          AppMethodBeat.o(254476);
        }
      }
      else
      {
        localObject = d.aeJp;
        d.a(this.hzO, localz.getFileName(), this.aeAh, localz.paX - this.aeAi);
      }
    }
    AppMethodBeat.o(254476);
  }
  
  public final void hLu()
  {
    AppMethodBeat.i(254488);
    h.OAn.idkeyStat(354L, 10L, 1L, false);
    AppMethodBeat.o(254488);
  }
  
  public final void hLv()
  {
    AppMethodBeat.i(254492);
    if (this.fileName == null)
    {
      AppMethodBeat.o(254492);
      return;
    }
    z localz = ab.Qo(this.fileName);
    if (localz != null)
    {
      Object localObject;
      if (this.aeAh)
      {
        localObject = ab.Qo(localz.oYk);
        if (localObject != null)
        {
          d locald = d.aeJp;
          d.a(this.hzO, localz.getFileName(), this.aeAh, ((z)localObject).paX - this.aeAi);
          AppMethodBeat.o(254492);
        }
      }
      else
      {
        localObject = d.aeJp;
        d.a(this.hzO, localz.getFileName(), this.aeAh, localz.paX - this.aeAi);
      }
    }
    AppMethodBeat.o(254492);
  }
  
  public final void hLw()
  {
    AppMethodBeat.i(254496);
    h.OAn.idkeyStat(354L, 8L, 1L, false);
    h.OAn.b(13836, new Object[] { Integer.valueOf(302), Long.valueOf(Util.nowSecond()), "" });
    AppMethodBeat.o(254496);
  }
  
  public final void hLx()
  {
    AppMethodBeat.i(254501);
    h.OAn.idkeyStat(354L, 7L, 1L, false);
    AppMethodBeat.o(254501);
  }
  
  public final void hLy()
  {
    AppMethodBeat.i(254510);
    h.OAn.idkeyStat(354L, 6L, 1L, false);
    AppMethodBeat.o(254510);
  }
  
  public final void hLz()
  {
    AppMethodBeat.i(254516);
    h.OAn.idkeyStat(354L, 24L, 1L, false);
    h.OAn.b(13836, new Object[] { Integer.valueOf(303), Long.valueOf(Util.nowSecond()), "" });
    AppMethodBeat.o(254516);
  }
  
  public final void jy(long paramLong)
  {
    AppMethodBeat.i(254480);
    if (this.fileName == null)
    {
      AppMethodBeat.o(254480);
      return;
    }
    z localz = ab.Qo(this.fileName);
    if (localz != null) {
      if (this.aeAh)
      {
        localz = ab.Qo(localz.oYk);
        if (localz != null)
        {
          this.aeAi = localz.paX;
          AppMethodBeat.o(254480);
        }
      }
      else
      {
        this.aeAi = localz.paX;
      }
    }
    AppMethodBeat.o(254480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b
 * JD-Core Version:    0.7.0.1
 */