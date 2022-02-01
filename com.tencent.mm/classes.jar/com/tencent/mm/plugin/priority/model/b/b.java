package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.a.c.d;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;

public final class b
  extends a
{
  private bo dpq;
  
  public b(bo parambo)
  {
    this.dpq = parambo;
  }
  
  private static void a(bo parambo, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87867);
    if (((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
    {
      ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      com.tencent.mm.plugin.priority.model.a.c.b.a(parambo, paramInt, paramDouble);
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
    if (this.dpq.field_createTime <= ((PluginPriority)g.ad(PluginPriority.class)).getInstallPriorityTime())
    {
      ac.i("MicroMsg.Priority.C2CImgReceiveTask", "onC2CImgReceive time condition not support %s", new Object[] { h.formatTime("yyyy-MM-dd HH:mm:ss", this.dpq.field_createTime / 1000L) });
      AppMethodBeat.o(87866);
      return;
    }
    if (((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().wl(this.dpq.field_msgId))
    {
      ac.i("MicroMsg.Priority.C2CImgReceiveTask", "img already exist msg %d", new Object[] { Long.valueOf(this.dpq.field_msgId) });
      AppMethodBeat.o(87866);
      return;
    }
    Object localObject;
    double d;
    int k;
    int i;
    int j;
    if (w.sQ(this.dpq.field_talker))
    {
      localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().il(this.dpq.field_talker, "@all");
      d = Math.max(Math.max(localObject[0], localObject[1]), localObject[2]);
      k = 1;
      i = 0;
      localObject = bi.yr(this.dpq.eul);
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
      if (!com.tencent.mm.plugin.priority.a.a.a.a.doH())
      {
        j = i | 0x2;
        k = 0;
      }
      i = j;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.doI())
      {
        i = j | 0x10;
        k = 0;
      }
      if (!com.tencent.mm.plugin.priority.a.a.a.a.apo(this.dpq.field_talker)) {
        break label1247;
      }
      i |= 0x8;
    }
    label429:
    label1247:
    for (;;)
    {
      if (!((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOV, com.tencent.mm.util.c.fwW()))
      {
        if (d >= ((PluginPriority)g.ad(PluginPriority.class)).getImgBorderPriority())
        {
          if (k != 0)
          {
            i |= 0x1;
            ac.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dpq.field_msgId) });
            a(this.dpq, i, d);
            ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
            localObject = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().il(this.dpq.field_talker, this.dpq.field_talker);
            break;
            localObject = ((bi.b)localObject).hoJ;
            if ((!bs.isNullOrNil((String)localObject)) && (com.tencent.mm.modelcontrol.b.BU((String)localObject)))
            {
              j = 0;
              break label200;
            }
            j = 1;
            break label200;
          }
          ac.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dpq.field_msgId) });
          a(this.dpq, i, d);
          AppMethodBeat.o(87866);
          return;
        }
        if ((k != 0) && (!w.sQ(this.dpq.field_talker)))
        {
          j = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().im(this.dpq.field_talker, this.dpq.field_talker);
          if (j < 2)
          {
            i |= 0x80;
            ac.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dpq.field_msgId), Integer.valueOf(j) });
            a(this.dpq, i, d);
            ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
          }
        }
        ac.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dpq.field_msgId) });
        a(this.dpq, i | 0x40, d);
        AppMethodBeat.o(87866);
        return;
      }
      ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageLogic();
      localObject = this.dpq.field_talker;
      uc localuc = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().apt((String)localObject);
      j = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOW, 10);
      float f = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pOX, 10.0F);
      ac.i("MicroMsg.Priority.C2CChatUsageLogic", "getAutoDownloadImgFlag %s %s %.2f", new Object[] { localObject, Integer.valueOf(j), Float.valueOf(f) });
      if ((localuc != null) && (localuc.tlu <= j) && (localuc.Eoq > f)) {
        j = 1;
      }
      while (j != 0) {
        if (k != 0)
        {
          i |= 0x1;
          ac.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dpq.field_msgId) });
          a(this.dpq, i, d);
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
          AppMethodBeat.o(87866);
          return;
          j = 0;
        }
        else
        {
          ac.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dpq.field_msgId) });
          a(this.dpq, i, d);
          AppMethodBeat.o(87866);
          return;
        }
      }
      if ((k != 0) && (!w.sQ(this.dpq.field_talker)))
      {
        j = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().im(this.dpq.field_talker, this.dpq.field_talker);
        if (j < 2)
        {
          i |= 0x80;
          ac.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dpq.field_msgId), Integer.valueOf(j) });
          a(this.dpq, i, d);
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
          AppMethodBeat.o(87866);
          return;
        }
      }
      ac.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dpq.field_msgId) });
      a(this.dpq, i | 0x200, d);
      AppMethodBeat.o(87866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b.b
 * JD-Core Version:    0.7.0.1
 */