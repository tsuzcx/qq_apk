package com.tencent.mm.plugin.priority;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.priority.b.a.c;
import com.tencent.mm.plugin.priority.b.a.d;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

final class a$c
  extends com.tencent.mm.plugin.priority.b.b.a
{
  private bi cEE;
  
  public a$c(a parama, bi parambi)
  {
    this.cEE = parambi;
  }
  
  public final String getName()
  {
    return "Priority.onC2CImgReceiveTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(54877);
    if (this.cEE.field_createTime <= ((PluginPriority)g.G(PluginPriority.class)).getInstallPriorityTime())
    {
      ab.i("MicroMsg.Priority.PriorityService", "onC2CImgReceive time condition not support %s", new Object[] { h.formatTime("yyyy-MM-dd HH:mm:ss", this.cEE.field_createTime / 1000L) });
      AppMethodBeat.o(54877);
      return;
    }
    if (((PluginPriority)g.G(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().kR(this.cEE.field_msgId))
    {
      ab.i("MicroMsg.Priority.PriorityService", "already exist msg %d", new Object[] { Long.valueOf(this.cEE.field_msgId) });
      AppMethodBeat.o(54877);
      return;
    }
    int i = 1;
    Object localObject1;
    double d1;
    int n;
    Object localObject2;
    int j;
    int k;
    if (t.lA(this.cEE.field_talker))
    {
      localObject1 = ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgImgUsageStorage().fL(this.cEE.field_talker, "@all");
      double d2 = a.d((double[])localObject1);
      d1 = d2;
      n = i;
      if (t.lA(this.cEE.field_talker))
      {
        localObject2 = bo.bf(bf.pu(this.cEE.field_content), "");
        d1 = d2;
        n = i;
        if (!bo.isNullOrNil((String)localObject2))
        {
          localObject2 = ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgImgUsageStorage().fL(this.cEE.field_talker, (String)localObject2);
          j = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lTV, 101);
          d1 = d2;
          n = i;
          if (a.d((double[])localObject2) > d2)
          {
            d1 = d2;
            n = i;
            if (a.d((double[])localObject2) > j)
            {
              d1 = a.d((double[])localObject2);
              n = 2;
            }
          }
        }
      }
      k = 1;
      i = 0;
      localObject2 = bf.pA(this.cEE.dns);
      if (localObject2 != null) {
        break label603;
      }
      j = 0;
      label328:
      if (j == 0)
      {
        i = 4;
        k = 0;
      }
      j = i;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.caN())
      {
        j = i | 0x2;
        k = 0;
      }
      int m = j;
      i = k;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.caO())
      {
        m = j | 0x10;
        i = 0;
      }
      j = m;
      if (!com.tencent.mm.plugin.priority.a.a.a.a.WR(this.cEE.field_talker)) {
        break label1033;
      }
      k = m | 0x8;
      j = k;
      if (!com.tencent.mm.plugin.priority.a.a.a.caL()) {
        break label1033;
      }
      j = 0;
    }
    for (i = k;; i = k)
    {
      if (com.tencent.mm.plugin.priority.a.a.a.biG()) {
        if (d1 >= ((PluginPriority)g.G(PluginPriority.class)).getBorderPriority())
        {
          if (j != 0)
          {
            j = i;
            if (a.d((double[])localObject1) < ((PluginPriority)g.G(PluginPriority.class)).getBorderPriority()) {
              j = i | 0x100;
            }
            i = j | 0x1;
            ab.i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d1), Integer.valueOf(n), Integer.valueOf(i), Long.valueOf(this.cEE.field_msgId) });
            a.a(this.cEE, i, 1, d1, n);
            ((PluginPriority)g.G(PluginPriority.class)).getC2CImgAutoDownloader().start();
            AppMethodBeat.o(54877);
            return;
            localObject1 = ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgImgUsageStorage().fL(this.cEE.field_talker, this.cEE.field_talker);
            break;
            label603:
            localObject2 = ((bf.b)localObject2).fmR;
            if ((!bo.isNullOrNil((String)localObject2)) && (com.tencent.mm.modelcontrol.b.sM((String)localObject2)))
            {
              j = 0;
              break label328;
            }
            j = 1;
            break label328;
          }
          ab.i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d1), Integer.valueOf(n), Integer.valueOf(i), Long.valueOf(this.cEE.field_msgId) });
        }
      }
      for (;;)
      {
        a.a(this.cEE, i, 1, d1, n);
        do
        {
          AppMethodBeat.o(54877);
          return;
          if ((j != 0) && (!t.lA(this.cEE.field_talker)))
          {
            localObject1 = ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgImgUsageStorage();
            localObject2 = this.cEE.field_talker;
            String str1 = this.cEE.field_talker;
            long l = d.caS();
            String str2 = String.format("SELECT dayreceivecount FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[] { "C2CMsgImgUsage" });
            j = 0;
            localObject1 = ((d)localObject1).pte.rawQuery(str2, new String[] { localObject2, str1, String.valueOf(l) });
            if (((Cursor)localObject1).moveToNext()) {
              j = ((Cursor)localObject1).getInt(0);
            }
            ((Cursor)localObject1).close();
            if (j < 2)
            {
              i |= 0x80;
              ab.i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", new Object[] { Double.valueOf(d1), Integer.valueOf(n), Integer.valueOf(i), Long.valueOf(this.cEE.field_msgId), Integer.valueOf(j) });
              a.a(this.cEE, i, 1, d1, n);
              ((PluginPriority)g.G(PluginPriority.class)).getC2CImgAutoDownloader().start();
              AppMethodBeat.o(54877);
              return;
            }
          }
          ab.i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", new Object[] { Double.valueOf(d1), Integer.valueOf(n), Integer.valueOf(i), Long.valueOf(this.cEE.field_msgId) });
          i |= 0x40;
          break;
        } while (!com.tencent.mm.plugin.priority.a.a.a.caL());
        if (j != 0)
        {
          a.a(this.cEE, i | 0x1, 2, d1, n);
          AppMethodBeat.o(54877);
          return;
        }
      }
      label1033:
      k = j;
      j = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a.c
 * JD-Core Version:    0.7.0.1
 */