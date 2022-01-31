package com.tencent.mm.plugin.multitalk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class f$2
  extends BroadcastReceiver
{
  f$2(f paramf) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.mtZ.bkD()) {
      return;
    }
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      this.mtZ.mtW.removeCallbacksAndMessages(null);
      this.mtZ.mtW.postDelayed(new f.2.1(this), 8000L);
      return;
    }
    int i = j.u(paramContext, paramIntent);
    y.i("MicroMsg.MT.MultiTalkManager", "phone state %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      ai.d(new f.2.2(this));
      return;
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        p.blE().mtp.oh(true);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.f.2
 * JD-Core Version:    0.7.0.1
 */