package com.tencent.mm.plugin.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class HeadsetPlugReceiver
  extends BroadcastReceiver
{
  private HeadsetPlugReceiver.a tsZ = null;
  
  public final void a(Context paramContext, HeadsetPlugReceiver.a parama)
  {
    AppMethodBeat.i(4303);
    this.tsZ = parama;
    parama = new IntentFilter();
    parama.addAction("android.intent.action.HEADSET_PLUG");
    paramContext.registerReceiver(this, parama);
    AppMethodBeat.o(4303);
  }
  
  public final void fg(Context paramContext)
  {
    AppMethodBeat.i(4304);
    try
    {
      paramContext.unregisterReceiver(this);
      this.tsZ = null;
      AppMethodBeat.o(4304);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.e("MicroMsg.HeadsetPlugReceiver", "unregisterReceiver(HeadsetPlugReceiver.this) error:%s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(4302);
    ab.d("MicroMsg.HeadsetPlugReceiver", "headset onReceive %s  %d", new Object[] { paramIntent.getAction(), Integer.valueOf(paramIntent.getIntExtra("state", 0)) });
    if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"))) {
      if (paramIntent.getIntExtra("state", 0) == 0)
      {
        if (this.tsZ != null)
        {
          this.tsZ.gj(false);
          AppMethodBeat.o(4302);
        }
      }
      else if ((paramIntent.getIntExtra("state", 0) == 1) && (this.tsZ != null)) {
        this.tsZ.gj(true);
      }
    }
    AppMethodBeat.o(4302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.HeadsetPlugReceiver
 * JD-Core Version:    0.7.0.1
 */