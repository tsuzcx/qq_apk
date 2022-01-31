package com.tencent.mm.plugin.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.y;

public class HeadsetPlugReceiver
  extends BroadcastReceiver
{
  private HeadsetPlugReceiver.a pNf = null;
  
  public final void a(Context paramContext, HeadsetPlugReceiver.a parama)
  {
    this.pNf = parama;
    parama = new IntentFilter();
    parama.addAction("android.intent.action.HEADSET_PLUG");
    paramContext.registerReceiver(this, parama);
  }
  
  public final void ek(Context paramContext)
  {
    try
    {
      paramContext.unregisterReceiver(this);
      this.pNf = null;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        y.e("MicroMsg.HeadsetPlugReceiver", "unregisterReceiver(HeadsetPlugReceiver.this) error:%s", new Object[] { paramContext.getMessage() });
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    y.d("MicroMsg.HeadsetPlugReceiver", "headset onReceive %s  %d", new Object[] { paramIntent.getAction(), Integer.valueOf(paramIntent.getIntExtra("state", 0)) });
    if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG")))
    {
      if (paramIntent.getIntExtra("state", 0) != 0) {
        break label78;
      }
      if (this.pNf != null) {
        this.pNf.eH(false);
      }
    }
    label78:
    while ((paramIntent.getIntExtra("state", 0) != 1) || (this.pNf == null)) {
      return;
    }
    this.pNf.eH(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.HeadsetPlugReceiver
 * JD-Core Version:    0.7.0.1
 */