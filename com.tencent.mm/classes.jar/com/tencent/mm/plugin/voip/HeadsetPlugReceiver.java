package com.tencent.mm.plugin.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class HeadsetPlugReceiver
  extends BroadcastReceiver
{
  private a zfj = null;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(114794);
    ad.d("MicroMsg.HeadsetPlugReceiver", "headset onReceive %s  %d", new Object[] { paramIntent.getAction(), Integer.valueOf(paramIntent.getIntExtra("state", 0)) });
    if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"))) {
      if (paramIntent.getIntExtra("state", 0) == 0)
      {
        if (this.zfj != null) {
          AppMethodBeat.o(114794);
        }
      }
      else {
        paramIntent.getIntExtra("state", 0);
      }
    }
    AppMethodBeat.o(114794);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.HeadsetPlugReceiver
 * JD-Core Version:    0.7.0.1
 */