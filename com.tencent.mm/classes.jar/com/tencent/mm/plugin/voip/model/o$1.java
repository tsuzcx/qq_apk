package com.tencent.mm.plugin.voip.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.sdk.platformtools.ae;

final class o$1
  extends BroadcastReceiver
{
  o$1(o paramo) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = (PowerManager)ae.getContext().getSystemService("power");
    if (("android.intent.action.USER_PRESENT".equals(paramContext)) && (paramIntent.isScreenOn())) {
      o.a(this.pSP, false);
    }
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_ON".equals(paramContext))
        {
          o.a(this.pSP, false);
          return;
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramContext));
      o.a(this.pSP, true);
    } while ((com.tencent.mm.plugin.voip.a.b.Aw(o.a(this.pSP).mState)) || (o.b(this.pSP)));
    com.tencent.mm.plugin.voip.b.bPx().stopRing();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o.1
 * JD-Core Version:    0.7.0.1
 */