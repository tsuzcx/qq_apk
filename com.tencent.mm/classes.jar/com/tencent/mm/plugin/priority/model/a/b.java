package com.tencent.mm.plugin.priority.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.c2c.img.d;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;

public final class b
  extends a
{
  private cc hTm;
  
  public b(cc paramcc)
  {
    this.hTm = paramcc;
  }
  
  private static void a(cc paramcc, int paramInt, double paramDouble)
  {
    AppMethodBeat.i(87867);
    if (((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null)
    {
      ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
      com.tencent.mm.plugin.priority.model.c2c.img.b.a(paramcc, paramInt, paramDouble);
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
    if (this.hTm.getCreateTime() <= ((PluginPriority)h.az(PluginPriority.class)).getInstallPriorityTime())
    {
      Log.i("MicroMsg.Priority.C2CImgReceiveTask", "onC2CImgReceive time condition not support %s", new Object[] { f.formatTime("yyyy-MM-dd HH:mm:ss", this.hTm.getCreateTime() / 1000L) });
      AppMethodBeat.o(87866);
      return;
    }
    if (((PluginPriority)h.az(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().th(this.hTm.field_msgId))
    {
      Log.i("MicroMsg.Priority.C2CImgReceiveTask", "img already exist msg %d", new Object[] { Long.valueOf(this.hTm.field_msgId) });
      AppMethodBeat.o(87866);
      return;
    }
    Object localObject;
    double d;
    int i;
    label193:
    int j;
    if (au.bwE(this.hTm.field_talker))
    {
      localObject = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().kX(this.hTm.field_talker, "@all");
      d = Math.max(Math.max(localObject[0], localObject[1]), localObject[2]);
      localObject = br.JP(this.hTm.jUr);
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
      if (!com.tencent.mm.plugin.priority.a.a.a.a.gzO())
      {
        i = j | 0x2;
        k = 0;
      }
      j = i;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.gzP())
      {
        j = i | 0x10;
        k = 0;
      }
      if (com.tencent.mm.plugin.priority.a.a.a.a.aRG(this.hTm.field_talker)) {}
      for (i = j | 0x8;; i = j)
      {
        if (!((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLT, false))
        {
          if (d >= ((PluginPriority)h.az(PluginPriority.class)).getImgBorderPriority())
          {
            if (k != 0)
            {
              i |= 0x1;
              Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.hTm.field_msgId) });
              a(this.hTm, i, d);
              ((PluginPriority)h.az(PluginPriority.class)).getC2CImgAutoDownloader().start();
              AppMethodBeat.o(87866);
              return;
              localObject = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().kX(this.hTm.field_talker, this.hTm.field_talker);
              break;
              label410:
              localObject = ((br.b)localObject).omd;
              if ((!Util.isNullOrNil((String)localObject)) && (com.tencent.mm.modelcontrol.b.NB((String)localObject)))
              {
                i = 0;
                break label193;
              }
              i = 1;
              break label193;
            }
            Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.hTm.field_msgId) });
            a(this.hTm, i, d);
            AppMethodBeat.o(87866);
            return;
          }
          if ((k != 0) && (!au.bwE(this.hTm.field_talker)))
          {
            j = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().kY(this.hTm.field_talker, this.hTm.field_talker);
            if (j < 2)
            {
              i |= 0x80;
              Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.hTm.field_msgId), Integer.valueOf(j) });
              a(this.hTm, i, d);
              ((PluginPriority)h.az(PluginPriority.class)).getC2CImgAutoDownloader().start();
              AppMethodBeat.o(87866);
              return;
            }
          }
          Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.hTm.field_msgId) });
          a(this.hTm, i | 0x40, d);
          AppMethodBeat.o(87866);
          return;
        }
        ((PluginPriority)h.az(PluginPriority.class)).getC2CChatUsageLogic();
        if (com.tencent.mm.plugin.priority.model.c2c.a.a.aRL(this.hTm.field_talker))
        {
          if (k != 0)
          {
            i |= 0x1;
            Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.hTm.field_msgId) });
            a(this.hTm, i, d);
            ((PluginPriority)h.az(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
          }
          Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.hTm.field_msgId) });
          a(this.hTm, i, d);
          AppMethodBeat.o(87866);
          return;
        }
        if ((k != 0) && (!au.bwE(this.hTm.field_talker)))
        {
          j = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().kY(this.hTm.field_talker, this.hTm.field_talker);
          if (j < 2)
          {
            i |= 0x80;
            Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.hTm.field_msgId), Integer.valueOf(j) });
            a(this.hTm, i, d);
            ((PluginPriority)h.az(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(87866);
            return;
          }
        }
        Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d), Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(this.hTm.field_msgId) });
        a(this.hTm, i | 0x200, d);
        AppMethodBeat.o(87866);
        return;
      }
      label1088:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a.b
 * JD-Core Version:    0.7.0.1
 */