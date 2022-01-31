package com.tencent.mm.plugin.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class b$13
  extends BroadcastReceiver
{
  b$13(b paramb) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i = -1;
    label108:
    boolean bool1;
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        boolean bool2 = b.j(this.msl);
        boolean bool3 = b.k(this.msl);
        long l = b.l(this.msl);
        if (b.m(this.msl) == null)
        {
          bool1 = true;
          label148:
          y.v("MicroMsg.SubCoreBaseMonitor", "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]", new Object[] { paramContext, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l), Boolean.valueOf(bool1) });
          if ((b.m(this.msl) != null) || (!b.k(this.msl)) || (b.j(this.msl))) {
            break label504;
          }
          if (System.currentTimeMillis() - b.l(this.msl) >= b.n(this.msl) * 60000L) {
            break label428;
          }
          y.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", new Object[] { Long.valueOf(b.n(this.msl)) });
        }
        break;
      }
      break;
    }
    label428:
    label504:
    do
    {
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
      if (!paramContext.equals("android.intent.action.TIME_SET")) {
        break;
      }
      i = 4;
      break;
      if (!paramContext.equals("android.intent.action.DATE_CHANGED")) {
        break;
      }
      i = 5;
      break;
      b.a(this.msl, true);
      break label108;
      b.a(this.msl, false);
      break label108;
      b.b(this.msl, true);
      break label108;
      b.b(this.msl, false);
      break label108;
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv hardcoder Action time change");
      WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_DAY_RECEIVER);
      return;
      bool1 = false;
      break label148;
      paramContext = new b.13.1(this);
      b.a(this.msl, new b.13.2(this, paramContext));
      g.DS().k(b.m(this.msl), b.p(this.msl) * 60000L);
      y.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", new Object[] { Long.valueOf(b.p(this.msl)) });
      return;
      if (b.m(this.msl) != null)
      {
        g.DS().crf().removeCallbacks(b.m(this.msl));
        b.a(this.msl, null);
        y.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", new Object[] { b.o(this.msl) });
        return;
      }
    } while (b.o(this.msl) == null);
    b.o(this.msl).esC = true;
    y.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", new Object[] { b.o(this.msl) });
    b.a(this.msl, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.13
 * JD-Core Version:    0.7.0.1
 */