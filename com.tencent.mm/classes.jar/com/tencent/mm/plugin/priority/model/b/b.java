package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.a.c.d;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.protocal.protobuf.wa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;

public final class b
  extends a
{
  private bv dCi;
  
  public b(bv parambv)
  {
    this.dCi = parambv;
  }
  
  private static void a(bv parambv, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87867);
    if (((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
    {
      ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      com.tencent.mm.plugin.priority.model.a.c.b.a(parambv, paramInt, paramDouble);
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
    if (this.dCi.field_createTime <= ((PluginPriority)g.ad(PluginPriority.class)).getInstallPriorityTime())
    {
      ae.i("MicroMsg.Priority.C2CImgReceiveTask", "onC2CImgReceive time condition not support %s", new Object[] { i.formatTime("yyyy-MM-dd HH:mm:ss", this.dCi.field_createTime / 1000L) });
      AppMethodBeat.o(87866);
      return;
    }
    if (((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().yV(this.dCi.field_msgId))
    {
      ae.i("MicroMsg.Priority.C2CImgReceiveTask", "img already exist msg %d", new Object[] { Long.valueOf(this.dCi.field_msgId) });
      AppMethodBeat.o(87866);
      return;
    }
    Object localObject1;
    double d;
    int k;
    int i;
    int j;
    if (x.wb(this.dCi.field_talker))
    {
      localObject1 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iF(this.dCi.field_talker, "@all");
      d = Math.max(Math.max(localObject1[0], localObject1[1]), localObject1[2]);
      k = 1;
      i = 0;
      localObject1 = bl.BS(this.dCi.eNd);
      if (localObject1 != null) {
        break label442;
      }
      j = 0;
      label200:
      if (j == 0)
      {
        i = 4;
        k = 0;
      }
      j = i;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.dCA())
      {
        j = i | 0x2;
        k = 0;
      }
      i = j;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.dCB())
      {
        i = j | 0x10;
        k = 0;
      }
      if (!com.tencent.mm.plugin.priority.a.a.a.a.avJ(this.dCi.field_talker)) {
        break label1260;
      }
      i |= 0x8;
    }
    label442:
    label1260:
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
      Object localObject2 = b.a.qzJ;
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
      if (!((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, com.tencent.mm.util.c.fSf()))
      {
        if (d >= ((PluginPriority)g.ad(PluginPriority.class)).getImgBorderPriority())
        {
          if (k != 0)
          {
            i |= 0x1;
            ae.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dCi.field_msgId) });
            a(this.dCi, i, d);
            ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
            localObject1 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iF(this.dCi.field_talker, this.dCi.field_talker);
            break;
            localObject1 = ((bl.b)localObject1).hJT;
            if ((!bu.isNullOrNil((String)localObject1)) && (com.tencent.mm.modelcontrol.b.Fv((String)localObject1)))
            {
              j = 0;
              break label200;
            }
            j = 1;
            break label200;
          }
          ae.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dCi.field_msgId) });
          a(this.dCi, i, d);
          AppMethodBeat.o(87866);
          return;
        }
        if ((k != 0) && (!x.wb(this.dCi.field_talker)))
        {
          j = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iG(this.dCi.field_talker, this.dCi.field_talker);
          if (j < 2)
          {
            i |= 0x80;
            ae.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dCi.field_msgId), Integer.valueOf(j) });
            a(this.dCi, i, d);
            ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
          }
        }
        ae.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dCi.field_msgId) });
        a(this.dCi, i | 0x40, d);
        AppMethodBeat.o(87866);
        return;
      }
      ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageLogic();
      localObject1 = this.dCi.field_talker;
      localObject2 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().avO((String)localObject1);
      j = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzK, 10);
      float f = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzL, 10.0F);
      ae.i("MicroMsg.Priority.C2CChatUsageLogic", "getAutoDownloadImgFlag %s %s %.2f", new Object[] { localObject1, Integer.valueOf(j), Float.valueOf(f) });
      if ((localObject2 != null) && (((wa)localObject2).uvb <= j) && (((wa)localObject2).GnY > f)) {
        j = 1;
      }
      while (j != 0) {
        if (k != 0)
        {
          i |= 0x1;
          ae.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dCi.field_msgId) });
          a(this.dCi, i, d);
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
          AppMethodBeat.o(87866);
          return;
          j = 0;
        }
        else
        {
          ae.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dCi.field_msgId) });
          a(this.dCi, i, d);
          AppMethodBeat.o(87866);
          return;
        }
      }
      if ((k != 0) && (!x.wb(this.dCi.field_talker)))
      {
        j = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iG(this.dCi.field_talker, this.dCi.field_talker);
        if (j < 2)
        {
          i |= 0x80;
          ae.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dCi.field_msgId), Integer.valueOf(j) });
          a(this.dCi, i, d);
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
          AppMethodBeat.o(87866);
          return;
        }
      }
      ae.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dCi.field_msgId) });
      a(this.dCi, i | 0x200, d);
      AppMethodBeat.o(87866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b.b
 * JD-Core Version:    0.7.0.1
 */