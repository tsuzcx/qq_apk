package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.IntentFilter;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.tx;
import com.tencent.mm.autogen.a.tx.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

class MultiTalkManager$17
  extends IListener<tx>
{
  MultiTalkManager$17(p paramp, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(284758);
    this.__eventId = tx.class.getName().hashCode();
    AppMethodBeat.o(284758);
  }
  
  private boolean a(tx paramtx)
  {
    AppMethodBeat.i(284766);
    if (paramtx != null) {
      switch (paramtx.hXN.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(284766);
      return false;
      paramtx = new IntentFilter();
      paramtx.addAction("android.intent.action.PHONE_STATE");
      paramtx.addAction("android.intent.action.PHONE_STATE_2");
      paramtx.addAction("android.intent.action.PHONE_STATE2");
      paramtx.addAction("android.intent.action.PHONE_STATE_EXT");
      paramtx.addAction("android.intent.action.DUAL_PHONE_STATE");
      paramtx.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      try
      {
        MMApplicationContext.getContext().registerReceiver(p.r(this.LoY), paramtx);
      }
      catch (Exception paramtx)
      {
        Log.e("MicroMsg.MT.MultiTalkManager", "phoneStatusReceiver register error %s", new Object[] { paramtx.fillInStackTrace() });
      }
      continue;
      try
      {
        MMApplicationContext.getContext().unregisterReceiver(p.r(this.LoY));
      }
      catch (Exception paramtx)
      {
        Log.e("MicroMsg.MT.MultiTalkManager", "phoneStatusReceiver unregister error %s", new Object[] { paramtx.fillInStackTrace() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.MultiTalkManager.17
 * JD-Core Version:    0.7.0.1
 */