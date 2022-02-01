package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.a.c.d;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public final class b
  extends a
{
  private bu dBd;
  
  public b(bu parambu)
  {
    this.dBd = parambu;
  }
  
  private static void a(bu parambu, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87867);
    if (((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
    {
      ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      com.tencent.mm.plugin.priority.model.a.c.b.a(parambu, paramInt, paramDouble);
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
    if (this.dBd.field_createTime <= ((PluginPriority)g.ad(PluginPriority.class)).getInstallPriorityTime())
    {
      ad.i("MicroMsg.Priority.C2CImgReceiveTask", "onC2CImgReceive time condition not support %s", new Object[] { i.formatTime("yyyy-MM-dd HH:mm:ss", this.dBd.field_createTime / 1000L) });
      AppMethodBeat.o(87866);
      return;
    }
    if (((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().yw(this.dBd.field_msgId))
    {
      ad.i("MicroMsg.Priority.C2CImgReceiveTask", "img already exist msg %d", new Object[] { Long.valueOf(this.dBd.field_msgId) });
      AppMethodBeat.o(87866);
      return;
    }
    Object localObject1;
    double d;
    int k;
    int i;
    int j;
    if (w.vF(this.dBd.field_talker))
    {
      localObject1 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iz(this.dBd.field_talker, "@all");
      d = Math.max(Math.max(localObject1[0], localObject1[1]), localObject1[2]);
      k = 1;
      i = 0;
      localObject1 = bj.Bq(this.dBd.eLs);
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
      if (!com.tencent.mm.plugin.priority.a.a.a.a.dzj())
      {
        j = i | 0x2;
        k = 0;
      }
      i = j;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.dzk())
      {
        i = j | 0x10;
        k = 0;
      }
      if (!com.tencent.mm.plugin.priority.a.a.a.a.auu(this.dBd.field_talker)) {
        break label1260;
      }
      i |= 0x8;
    }
    label442:
    label1260:
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class);
      Object localObject2 = b.a.qsU;
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
      if (!((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, com.tencent.mm.util.c.fNK()))
      {
        if (d >= ((PluginPriority)g.ad(PluginPriority.class)).getImgBorderPriority())
        {
          if (k != 0)
          {
            i |= 0x1;
            ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dBd.field_msgId) });
            a(this.dBd, i, d);
            ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
            localObject1 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iz(this.dBd.field_talker, this.dBd.field_talker);
            break;
            localObject1 = ((bj.b)localObject1).hHb;
            if ((!bt.isNullOrNil((String)localObject1)) && (com.tencent.mm.modelcontrol.b.ET((String)localObject1)))
            {
              j = 0;
              break label200;
            }
            j = 1;
            break label200;
          }
          ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dBd.field_msgId) });
          a(this.dBd, i, d);
          AppMethodBeat.o(87866);
          return;
        }
        if ((k != 0) && (!w.vF(this.dBd.field_talker)))
        {
          j = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iA(this.dBd.field_talker, this.dBd.field_talker);
          if (j < 2)
          {
            i |= 0x80;
            ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dBd.field_msgId), Integer.valueOf(j) });
            a(this.dBd, i, d);
            ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
          }
        }
        ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dBd.field_msgId) });
        a(this.dBd, i | 0x40, d);
        AppMethodBeat.o(87866);
        return;
      }
      ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageLogic();
      localObject1 = this.dBd.field_talker;
      localObject2 = ((PluginPriority)g.ad(PluginPriority.class)).getC2CChatUsageResultStorage().auz((String)localObject1);
      j = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsV, 10);
      float f = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qsW, 10.0F);
      ad.i("MicroMsg.Priority.C2CChatUsageLogic", "getAutoDownloadImgFlag %s %s %.2f", new Object[] { localObject1, Integer.valueOf(j), Float.valueOf(f) });
      if ((localObject2 != null) && (((vx)localObject2).ujD <= j) && (((vx)localObject2).FVz > f)) {
        j = 1;
      }
      while (j != 0) {
        if (k != 0)
        {
          i |= 0x1;
          ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dBd.field_msgId) });
          a(this.dBd, i, d);
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
          AppMethodBeat.o(87866);
          return;
          j = 0;
        }
        else
        {
          ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dBd.field_msgId) });
          a(this.dBd, i, d);
          AppMethodBeat.o(87866);
          return;
        }
      }
      if ((k != 0) && (!w.vF(this.dBd.field_talker)))
      {
        j = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iA(this.dBd.field_talker, this.dBd.field_talker);
        if (j < 2)
        {
          i |= 0x80;
          ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dBd.field_msgId), Integer.valueOf(j) });
          a(this.dBd, i, d);
          ((PluginPriority)g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
          AppMethodBeat.o(87866);
          return;
        }
      }
      ad.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dBd.field_msgId) });
      a(this.dBd, i | 0x200, d);
      AppMethodBeat.o(87866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b.b
 * JD-Core Version:    0.7.0.1
 */