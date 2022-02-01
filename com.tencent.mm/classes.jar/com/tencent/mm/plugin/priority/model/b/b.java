package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.a.c.d;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class b
  extends a
{
  private ca dTX;
  
  public b(ca paramca)
  {
    this.dTX = paramca;
  }
  
  private static void a(ca paramca, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87867);
    if (((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
    {
      ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      com.tencent.mm.plugin.priority.model.a.c.b.a(paramca, paramInt, paramDouble);
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
    if (this.dTX.field_createTime <= ((PluginPriority)g.ah(PluginPriority.class)).getInstallPriorityTime())
    {
      Log.i("MicroMsg.Priority.C2CImgReceiveTask", "onC2CImgReceive time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.dTX.field_createTime / 1000L) });
      AppMethodBeat.o(87866);
      return;
    }
    if (((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().HL(this.dTX.field_msgId))
    {
      Log.i("MicroMsg.Priority.C2CImgReceiveTask", "img already exist msg %d", new Object[] { Long.valueOf(this.dTX.field_msgId) });
      AppMethodBeat.o(87866);
      return;
    }
    Object localObject1;
    double d;
    int k;
    int i;
    int j;
    if (ab.Eq(this.dTX.field_talker))
    {
      localObject1 = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jr(this.dTX.field_talker, "@all");
      d = Math.max(Math.max(localObject1[0], localObject1[1]), localObject1[2]);
      k = 1;
      i = 0;
      localObject1 = bp.Ky(this.dTX.fqK);
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
      if (!com.tencent.mm.plugin.priority.a.a.a.a.eCS())
      {
        j = i | 0x2;
        k = 0;
      }
      i = j;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.eCT())
      {
        i = j | 0x10;
        k = 0;
      }
      if (!com.tencent.mm.plugin.priority.a.a.a.a.aKb(this.dTX.field_talker)) {
        break label1260;
      }
      i |= 0x8;
    }
    label442:
    label1260:
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
      Object localObject2 = b.a.rRU;
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
      if (!((com.tencent.mm.plugin.expt.b.b)localObject1).a((b.a)localObject2, com.tencent.mm.util.c.hde()))
      {
        if (d >= ((PluginPriority)g.ah(PluginPriority.class)).getImgBorderPriority())
        {
          if (k != 0)
          {
            i |= 0x1;
            Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dTX.field_msgId) });
            a(this.dTX, i, d);
            ((PluginPriority)g.ah(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
            localObject1 = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jr(this.dTX.field_talker, this.dTX.field_talker);
            break;
            localObject1 = ((bp.b)localObject1).iED;
            if ((!Util.isNullOrNil((String)localObject1)) && (com.tencent.mm.modelcontrol.b.Of((String)localObject1)))
            {
              j = 0;
              break label200;
            }
            j = 1;
            break label200;
          }
          Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dTX.field_msgId) });
          a(this.dTX, i, d);
          AppMethodBeat.o(87866);
          return;
        }
        if ((k != 0) && (!ab.Eq(this.dTX.field_talker)))
        {
          j = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().js(this.dTX.field_talker, this.dTX.field_talker);
          if (j < 2)
          {
            i |= 0x80;
            Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dTX.field_msgId), Integer.valueOf(j) });
            a(this.dTX, i, d);
            ((PluginPriority)g.ah(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
          }
        }
        Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dTX.field_msgId) });
        a(this.dTX, i | 0x40, d);
        AppMethodBeat.o(87866);
        return;
      }
      ((PluginPriority)g.ah(PluginPriority.class)).getC2CChatUsageLogic();
      localObject1 = this.dTX.field_talker;
      localObject2 = ((PluginPriority)g.ah(PluginPriority.class)).getC2CChatUsageResultStorage().aKg((String)localObject1);
      j = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRV, 10);
      float f = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRW, 10.0F);
      Log.i("MicroMsg.Priority.C2CChatUsageLogic", "getAutoDownloadImgFlag %s %s %.2f", new Object[] { localObject1, Integer.valueOf(j), Float.valueOf(f) });
      if ((localObject2 != null) && (((xi)localObject2).xNc <= j) && (((xi)localObject2).LiL > f)) {
        j = 1;
      }
      while (j != 0) {
        if (k != 0)
        {
          i |= 0x1;
          Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dTX.field_msgId) });
          a(this.dTX, i, d);
          ((PluginPriority)g.ah(PluginPriority.class)).getC2CImgAutoDownloader().start();
          AppMethodBeat.o(87866);
          return;
          j = 0;
        }
        else
        {
          Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dTX.field_msgId) });
          a(this.dTX, i, d);
          AppMethodBeat.o(87866);
          return;
        }
      }
      if ((k != 0) && (!ab.Eq(this.dTX.field_talker)))
      {
        j = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().js(this.dTX.field_talker, this.dTX.field_talker);
        if (j < 2)
        {
          i |= 0x80;
          Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dTX.field_msgId), Integer.valueOf(j) });
          a(this.dTX, i, d);
          ((PluginPriority)g.ah(PluginPriority.class)).getC2CImgAutoDownloader().start();
          AppMethodBeat.o(87866);
          return;
        }
      }
      Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.dTX.field_msgId) });
      a(this.dTX, i | 0x200, d);
      AppMethodBeat.o(87866);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b.b
 * JD-Core Version:    0.7.0.1
 */