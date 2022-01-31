package com.tencent.mm.plugin.priority.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.at.d;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;

final class a$a
  extends com.tencent.mm.plugin.priority.b.b.a
{
  private a$a(a parama) {}
  
  public final String getName()
  {
    return "Priority.C2CImgAutoDownloaderTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(54905);
    if (!com.tencent.mm.plugin.priority.a.a.a.biG())
    {
      AppMethodBeat.o(54905);
      return;
    }
    if (!com.tencent.mm.plugin.priority.a.a.a.a.caM())
    {
      ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "not auto download condition");
      AppMethodBeat.o(54905);
      return;
    }
    if ((this.ptF.ptz != 0L) || (this.ptF.ptC))
    {
      ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d pauseOnMonitor %b", new Object[] { Long.valueOf(this.ptF.ptz), Boolean.valueOf(this.ptF.ptC) });
      AppMethodBeat.o(54905);
      return;
    }
    float f1 = ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getBorderPriority();
    float f2 = ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getBgBorderPriority();
    int i = 0;
    Object localObject2 = null;
    if (!bo.isNullOrNil(this.ptF.talker))
    {
      localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().j(this.ptF.talker, f1);
      i = 1;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().aT(f1);
      i = 2;
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().caR();
      i = 4;
    }
    if ((localObject2 == null) && (a.caQ()))
    {
      localObject2 = ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().aS(f2);
      ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "bg normal download");
      i = 3;
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        this.ptF.ptz = 0L;
        ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "autoDownloadRes is null");
        AppMethodBeat.o(54905);
        return;
      }
      this.ptF.ptz = ((gh)localObject2).wsz;
      ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "curMsgId %d priority %.2f prioritytype %d way %d borderPriority %.2f bgBorderPriority %.2f", new Object[] { Long.valueOf(this.ptF.ptz), Double.valueOf(((gh)localObject2).wsI), Integer.valueOf(((gh)localObject2).wsJ), Integer.valueOf(i), Float.valueOf(f1), Float.valueOf(f2) });
      localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.ptF.ptz);
      localObject2 = o.ahC().gS(((dd)localObject1).field_msgSvrId);
      if (((com.tencent.mm.at.e)localObject2).dGW == 1)
      {
        ab.i("MicroMsg.Priority.C2CImgAutoDownloader", this.ptF.ptz + " already has hd thumb");
        ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().C(this.ptF.ptz, 5);
        this.ptF.ptz = 0L;
        this.ptF.start();
        AppMethodBeat.o(54905);
        return;
      }
      f.afO().fyQ.add("image_" + ((dd)localObject1).field_msgId);
      int j;
      if ((!bo.isNullOrNil(this.ptF.talker)) && (this.ptF.talker.equals(((dd)localObject1).field_talker)))
      {
        j = o.ahD().a(((com.tencent.mm.at.e)localObject2).fDL, ((dd)localObject1).field_msgId, 0, Long.valueOf(this.ptF.ptz), this.ptF.ptA, this.ptF, 60000, true);
        ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s %s result=%d", new Object[] { Long.valueOf(this.ptF.ptz), "image_" + ((dd)localObject1).field_msgId, this.ptF.talker, Integer.valueOf(j) });
        switch (j)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(54905);
        return;
        j = o.ahD().a(((com.tencent.mm.at.e)localObject2).fDL, ((dd)localObject1).field_msgId, 0, Long.valueOf(this.ptF.ptz), this.ptF.ptA, this.ptF, 60000, false);
        ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s result=%d", new Object[] { Long.valueOf(this.ptF.ptz), "image_" + ((dd)localObject1).field_msgId, Integer.valueOf(j) });
        break;
        ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().C(this.ptF.ptz, 2);
        if (i == 3)
        {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 52L, 1L, false);
          AppMethodBeat.o(54905);
          return;
        }
        if (i == 1)
        {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 50L, 1L, false);
          AppMethodBeat.o(54905);
          return;
        }
        if (i == 4)
        {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 57L, 1L, false);
          AppMethodBeat.o(54905);
          return;
        }
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 51L, 1L, false);
        AppMethodBeat.o(54905);
        return;
        ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().C(this.ptF.ptz, 3);
        if (i == 3) {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 55L, 1L, false);
        }
        this.ptF.ptz = 0L;
        this.ptF.start();
        AppMethodBeat.o(54905);
        return;
        ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().C(this.ptF.ptz, 4);
        if (i == 3) {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(957L, 56L, 1L, false);
        }
        this.ptF.ptz = 0L;
        this.ptF.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */