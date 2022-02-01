package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.a.c.c;
import com.tencent.mm.plugin.priority.model.a.c.d;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class b
  extends a
{
  private ca fNz;
  
  public b(ca paramca)
  {
    this.fNz = paramca;
  }
  
  private static void a(ca paramca, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87867);
    if (((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
    {
      ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
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
    if (this.fNz.field_createTime <= ((PluginPriority)h.ag(PluginPriority.class)).getInstallPriorityTime())
    {
      Log.i("MicroMsg.Priority.C2CImgReceiveTask", "onC2CImgReceive time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.fNz.field_createTime / 1000L) });
      AppMethodBeat.o(87866);
      return;
    }
    if (((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().Pf(this.fNz.field_msgId))
    {
      Log.i("MicroMsg.Priority.C2CImgReceiveTask", "img already exist msg %d", new Object[] { Long.valueOf(this.fNz.field_msgId) });
      AppMethodBeat.o(87866);
      return;
    }
    Object localObject;
    double d;
    int i;
    label193:
    int j;
    if (ab.Lj(this.fNz.field_talker))
    {
      localObject = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().jD(this.fNz.field_talker, "@all");
      d = Math.max(Math.max(localObject[0], localObject[1]), localObject[2]);
      localObject = bq.RR(this.fNz.hxy);
      if (localObject != null) {
        break label410;
      }
      i = 0;
      if (i != 0) {
        break label1088;
      }
      j = 4;
    }
    for (int k = 0;; k = 1)
    {
      i = j;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.foL())
      {
        i = j | 0x2;
        k = 0;
      }
      j = i;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.foM())
      {
        j = i | 0x10;
        k = 0;
      }
      if (com.tencent.mm.plugin.priority.a.a.a.a.aUy(this.fNz.field_talker)) {}
      for (i = j | 0x8;; i = j)
      {
        if (!((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyr, false))
        {
          if (d >= ((PluginPriority)h.ag(PluginPriority.class)).getImgBorderPriority())
          {
            if (k != 0)
            {
              i |= 0x1;
              Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.fNz.field_msgId) });
              a(this.fNz, i, d);
              ((PluginPriority)h.ag(PluginPriority.class)).getC2CImgAutoDownloader().start();
              AppMethodBeat.o(87866);
              return;
              localObject = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().jD(this.fNz.field_talker, this.fNz.field_talker);
              break;
              label410:
              localObject = ((bq.b)localObject).luF;
              if ((!Util.isNullOrNil((String)localObject)) && (com.tencent.mm.modelcontrol.b.VC((String)localObject)))
              {
                i = 0;
                break label193;
              }
              i = 1;
              break label193;
            }
            Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.fNz.field_msgId) });
            a(this.fNz, i, d);
            AppMethodBeat.o(87866);
            return;
          }
          if ((k != 0) && (!ab.Lj(this.fNz.field_talker)))
          {
            j = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().jE(this.fNz.field_talker, this.fNz.field_talker);
            if (j < 2)
            {
              i |= 0x80;
              Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.fNz.field_msgId), Integer.valueOf(j) });
              a(this.fNz, i, d);
              ((PluginPriority)h.ag(PluginPriority.class)).getC2CImgAutoDownloader().start();
              AppMethodBeat.o(87866);
              return;
            }
          }
          Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.fNz.field_msgId) });
          a(this.fNz, i | 0x40, d);
          AppMethodBeat.o(87866);
          return;
        }
        ((PluginPriority)h.ag(PluginPriority.class)).getC2CChatUsageLogic();
        if (com.tencent.mm.plugin.priority.model.a.a.a.aUD(this.fNz.field_talker))
        {
          if (k != 0)
          {
            i |= 0x1;
            Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.fNz.field_msgId) });
            a(this.fNz, i, d);
            ((PluginPriority)h.ag(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
          }
          Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.fNz.field_msgId) });
          a(this.fNz, i, d);
          AppMethodBeat.o(87866);
          return;
        }
        if ((k != 0) && (!ab.Lj(this.fNz.field_talker)))
        {
          j = ((PluginPriority)h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().jE(this.fNz.field_talker, this.fNz.field_talker);
          if (j < 2)
          {
            i |= 0x80;
            Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.fNz.field_msgId), Integer.valueOf(j) });
            a(this.fNz, i, d);
            ((PluginPriority)h.ag(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
          }
        }
        Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.fNz.field_msgId) });
        a(this.fNz, i | 0x200, d);
        AppMethodBeat.o(87866);
        return;
      }
      label1088:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.b.b
 * JD-Core Version:    0.7.0.1
 */