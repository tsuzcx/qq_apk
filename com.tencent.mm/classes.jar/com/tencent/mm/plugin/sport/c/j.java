package com.tencent.mm.plugin.sport.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.booter.MMReceivers.a;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  implements MMReceivers.a
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    y.i("MicroMsg.Sport.SportRebootReceiverImpl", "onReceive, save rebootTime = %d %s", new Object[] { Long.valueOf(l), n.ce(l) });
    i.S(205, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.j
 * JD-Core Version:    0.7.0.1
 */