package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.a.c.d;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;

public final class b
  extends a
{
  private bl drF;
  
  public b(bl parambl)
  {
    this.drF = parambl;
  }
  
  private static void a(bl parambl, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87867);
    if (((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
    {
      ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      com.tencent.mm.plugin.priority.model.a.c.b.a(parambl, paramInt, paramDouble);
    }
    AppMethodBeat.o(87867);
  }
  
  public final String getName()
  {
    return "Priority.onC2CImgReceiveTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(87866);
    if (this.drF.field_createTime <= ((PluginPriority)g.ad(PluginPriority.class)).getInstallPriorityTime())
    {
      ad.i("MicroMsg.Priority.C2CImgReceiveTask", "onC2CImgReceive time condition not support %s", new Object[] { h.formatTime("yyyy-MM-dd HH:mm:ss", this.drF.field_createTime / 1000L) });
      AppMethodBeat.o(87866);
      return;
    }
    if (((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().rI(this.drF.field_msgId))
    {
      ad.i("MicroMsg.Priority.C2CImgReceiveTask", "img already exist msg %d", new Object[] { Long.valueOf(this.drF.field_msgId) });
      AppMethodBeat.o(87866);
      return;
    }
    Object localObject;
    double d;
    int k;
    int i;
    int j;
    if (w.pF(this.drF.field_talker))
    {
      localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().hS(this.drF.field_talker, "@all");
      d = Math.max(Math.max(localObject[0], localObject[1]), localObject[2]);
      k = 1;
      i = 0;
      localObject = bi.ul(this.drF.esh);
      if (localObject != null) {
        break label429;
      }
      j = 0;
      label200:
      if (j == 0)
      {
        i = 4;
        k = 0;
      }
      j = i;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.daZ())
      {
        j = i | 0x2;
        k = 0;
      }
      i = j;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.dba())
      {
        i = j | 0x10;
        k = 0;
      }
      if (!com.tencent.mm.plugin.priority.a.a.a.a.akp(this.drF.field_talker)) {
        break label1247;
      }
      i |= 0x8;
    }
    label429:
    label1247:
    for (;;)
    {
      if (!((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plz, com.tencent.mm.util.c.fgW()))
      {
        if (d >= ((PluginPriority)g.ad(PluginPriority.class)).getImgBorderPriority())
        {
          if (k != 0)
          {
            i |= 0x1;
            ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.drF.field_msgId) });
            a(this.drF, i, d);
            ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
            localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().hS(this.drF.field_talker, this.drF.field_talker);
            break;
            localObject = ((bi.b)localObject).gOj;
            if ((!bt.isNullOrNil((String)localObject)) && (com.tencent.mm.modelcontrol.b.xO((String)localObject)))
            {
              j = 0;
              break label200;
            }
            j = 1;
            break label200;
          }
          ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.drF.field_msgId) });
          a(this.drF, i, d);
          AppMethodBeat.o(87866);
          return;
        }
        if ((k != 0) && (!w.pF(this.drF.field_talker)))
        {
          j = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().hT(this.drF.field_talker, this.drF.field_talker);
          if (j < 2)
          {
            i |= 0x80;
            ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.drF.field_msgId), Integer.valueOf(j) });
            a(this.drF, i, d);
            ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
          }
        }
        ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.drF.field_msgId) });
        a(this.drF, i | 0x40, d);
        AppMethodBeat.o(87866);
        return;
      }
      ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageLogic();
      localObject = this.drF.field_talker;
      ts localts = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().aku((String)localObject);
      j = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plA, 10);
      float f = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plB, 10.0F);
      ad.i("MicroMsg.Priority.C2CChatUsageLogic", "getAutoDownloadImgFlag %s %s %.2f", new Object[] { localObject, Integer.valueOf(j), Float.valueOf(f) });
      if ((localts != null) && (localts.sdA <= j) && (localts.CVG > f)) {
        j = 1;
      }
      while (j != 0) {
        if (k != 0)
        {
          i |= 0x1;
          ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.drF.field_msgId) });
          a(this.drF, i, d);
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
          AppMethodBeat.o(87866);
          return;
          j = 0;
        }
        else
        {
          ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.drF.field_msgId) });
          a(this.drF, i, d);
          AppMethodBeat.o(87866);
          return;
        }
      }
      if ((k != 0) && (!w.pF(this.drF.field_talker)))
      {
        j = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().hT(this.drF.field_talker, this.drF.field_talker);
        if (j < 2)
        {
          i |= 0x80;
          ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.drF.field_msgId), Integer.valueOf(j) });
          a(this.drF, i, d);
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
          AppMethodBeat.o(87866);
          return;
        }
      }
      ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.drF.field_msgId) });
      a(this.drF, i | 0x200, d);
      AppMethodBeat.o(87866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b.b
 * JD-Core Version:    0.7.0.1
 */