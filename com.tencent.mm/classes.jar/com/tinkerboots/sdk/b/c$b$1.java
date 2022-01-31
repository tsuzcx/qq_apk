package com.tinkerboots.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.f.a;

final class c$b$1
  extends BroadcastReceiver
{
  c$b$1(c.b paramb, c.a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (paramIntent = "";; paramIntent = paramIntent.getAction())
    {
      a.i("Tinker.TinkerUtils", "ScreenReceiver action [%s] ", new Object[] { paramIntent });
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent))
      {
        paramContext.unregisterReceiver(this);
        if (this.xnV != null) {
          this.xnV.acE();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tinkerboots.sdk.b.c.b.1
 * JD-Core Version:    0.7.0.1
 */