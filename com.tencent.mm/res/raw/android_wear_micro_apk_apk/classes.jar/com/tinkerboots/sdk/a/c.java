package com.tinkerboots.sdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.tinker.lib.e.a;

public final class c
{
  public c(Context paramContext, final b paramb)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.registerReceiver(new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent == null) {}
        for (paramAnonymousIntent = "";; paramAnonymousIntent = paramAnonymousIntent.getAction())
        {
          a.c("Tinker.TinkerUtils", "ScreenReceiver action [%s] ", new Object[] { paramAnonymousIntent });
          if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent))
          {
            paramAnonymousContext.unregisterReceiver(this);
            if (paramb != null) {
              paramb.os();
            }
          }
          return;
        }
      }
    }, localIntentFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tinkerboots.sdk.a.c
 * JD-Core Version:    0.7.0.1
 */