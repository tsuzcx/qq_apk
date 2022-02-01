package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.sh;
import com.tencent.mm.f.a.sh.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class q$6
  extends IListener<sh>
{
  q$6(q paramq)
  {
    AppMethodBeat.i(199531);
    this.__eventId = sh.class.getName().hashCode();
    AppMethodBeat.o(199531);
  }
  
  private boolean a(sh paramsh)
  {
    AppMethodBeat.i(199534);
    if (paramsh != null) {
      switch (paramsh.fRP.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(199534);
      return false;
      paramsh = new IntentFilter();
      paramsh.addAction("android.intent.action.PHONE_STATE");
      paramsh.addAction("android.intent.action.PHONE_STATE_2");
      paramsh.addAction("android.intent.action.PHONE_STATE2");
      paramsh.addAction("android.intent.action.PHONE_STATE_EXT");
      paramsh.addAction("android.intent.action.DUAL_PHONE_STATE");
      paramsh.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      try
      {
        MMApplicationContext.getContext().registerReceiver(q.q(this.FsG), paramsh);
      }
      catch (Exception paramsh)
      {
        Log.e("MicroMsg.MT.MultiTalkManager", "phoneStatusReceiver register error %s", new Object[] { paramsh.fillInStackTrace() });
      }
      continue;
      try
      {
        MMApplicationContext.getContext().unregisterReceiver(q.q(this.FsG));
      }
      catch (Exception paramsh)
      {
        Log.e("MicroMsg.MT.MultiTalkManager", "phoneStatusReceiver unregister error %s", new Object[] { paramsh.fillInStackTrace() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.q.6
 * JD-Core Version:    0.7.0.1
 */