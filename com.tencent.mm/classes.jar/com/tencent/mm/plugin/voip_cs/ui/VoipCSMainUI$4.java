package com.tencent.mm.plugin.voip_cs.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.mm.plugin.voip_cs.b.a.a;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class VoipCSMainUI$4
  extends BroadcastReceiver
{
  VoipCSMainUI$4(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = (PowerManager)ae.getContext().getSystemService("power");
    if (("android.intent.action.USER_PRESENT".equals(paramContext)) && (paramIntent.isScreenOn()))
    {
      y.d("MicroMsg.voipcs.VoipCSMainUI", "on user present home");
      VoipCSMainUI.e(this.qeX).bNW = false;
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!"android.intent.action.SCREEN_ON".equals(paramContext)) {
            break;
          }
          y.d("MicroMsg.voipcs.VoipCSMainUI", "screen on...");
          VoipCSMainUI.e(this.qeX).bNW = false;
        } while ((VoipCSMainUI.f(this.qeX).bRj()) || (c.bSP().qeb != 2));
        VoipCSMainUI.f(this.qeX).bSX();
        return;
      } while (!"android.intent.action.SCREEN_OFF".equals(paramContext));
      y.d("MicroMsg.voipcs.VoipCSMainUI", "screen off...");
      VoipCSMainUI.e(this.qeX).bNW = true;
    } while (VoipCSMainUI.f(this.qeX).bRj());
    VoipCSMainUI.f(this.qeX).stopRing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.4
 * JD-Core Version:    0.7.0.1
 */