package com.tencent.mm.plugin.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf.1;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.List;

final class b$13
  extends BroadcastReceiver
{
  b$13(b paramb) {}
  
  public final void onReceive(final Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(84533);
    paramContext = paramIntent.getAction();
    int i = -1;
    label92:
    boolean bool2;
    boolean bool3;
    long l;
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        bool2 = b.j(this.oRW);
        bool3 = b.k(this.oRW);
        l = b.l(this.oRW);
        if (b.m(this.oRW) != null) {}
        break;
      }
      break;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.v("MicroMsg.SubCoreBaseMonitor", "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]", new Object[] { paramContext, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l), Boolean.valueOf(bool1) });
      if ((b.m(this.oRW) == null) && (b.k(this.oRW)) && (!b.j(this.oRW))) {
        break label380;
      }
      if (b.m(this.oRW) == null) {
        break label534;
      }
      d.ysn.ak(b.m(this.oRW));
      b.a(this.oRW, null);
      ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[] { b.p(this.oRW) });
      AppMethodBeat.o(84533);
      return;
      if (!paramContext.equals("android.intent.action.SCREEN_ON")) {
        break;
      }
      i = 0;
      break;
      if (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
        break;
      }
      i = 1;
      break;
      if (!paramContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
        break;
      }
      i = 2;
      break;
      if (!paramContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
        break;
      }
      i = 3;
      break;
      b.a(this.oRW, true);
      break label92;
      b.a(this.oRW, false);
      break label92;
      b.b(this.oRW, true);
      break label92;
      b.b(this.oRW, false);
      break label92;
    }
    label380:
    if (com.tencent.mm.sdk.a.b.dsf()) {
      b.n(this.oRW);
    }
    while (SystemClock.uptimeMillis() - b.l(this.oRW) >= b.o(this.oRW) * 60000L)
    {
      paramContext = new a()
      {
        public final void a(int paramAnonymousInt, a.a paramAnonymousa)
        {
          AppMethodBeat.i(84531);
          b.a(b.13.this.oRW, System.currentTimeMillis());
          ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(b.l(b.13.this.oRW)), b.p(b.13.this.oRW), paramAnonymousa });
          b.a(b.13.this.oRW, null);
          if ((paramAnonymousInt == 0) && (!paramAnonymousa.fIp))
          {
            g.RM();
            g.RL().Ru().set(ac.a.yEh, Long.valueOf(b.l(b.13.this.oRW)));
            g.RM();
            g.RL().Ru().dww();
            try
            {
              b.b(b.13.this.oRW, paramAnonymousa);
              AppMethodBeat.o(84531);
              return;
            }
            catch (Exception paramAnonymousa)
            {
              ab.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", paramAnonymousa, "doReportSDInfo err!", new Object[0]);
              h.qsU.idkeyStat(418L, 6L, 1L, true);
            }
          }
          AppMethodBeat.o(84531);
        }
      };
      b.a(this.oRW, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(84532);
          b.a(b.13.this.oRW, null);
          List localList = ((j)g.E(j.class)).Zc().bPU();
          if (bo.es(localList)) {
            ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask all finished!");
          }
          for (int i = 0;; i = localList.size())
          {
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", new Object[] { Integer.valueOf(i) });
            if (i > 0) {
              h.qsU.idkeyStat(418L, 8L, 1L, true);
            }
            b.a(b.13.this.oRW, b.a(b.13.this.oRW, paramContext));
            ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[] { b.p(b.13.this.oRW) });
            AppMethodBeat.o(84532);
            return;
            d.post(new bf.1(localList), "checkUnfinishedDeleteMsgTask");
          }
        }
      });
      d.ysn.a(b.m(this.oRW), "MicroMsg.SubCoreBaseMonitor", b.q(this.oRW) * 60000L);
      ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[] { Long.valueOf(b.q(this.oRW)) });
      AppMethodBeat.o(84533);
      return;
    }
    ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[] { Long.valueOf(b.o(this.oRW)) });
    AppMethodBeat.o(84533);
    return;
    label534:
    if (b.p(this.oRW) != null)
    {
      b.p(this.oRW).fIp = true;
      ab.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", new Object[] { b.p(this.oRW) });
      b.a(this.oRW, null);
    }
    AppMethodBeat.o(84533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.13
 * JD-Core Version:    0.7.0.1
 */