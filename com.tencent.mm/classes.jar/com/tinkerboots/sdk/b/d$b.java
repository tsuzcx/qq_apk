package com.tinkerboots.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.f.a;

public final class d$b
{
  public d$b(Context paramContext, final d.a parama)
  {
    AppMethodBeat.i(65557);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.registerReceiver(new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(65556);
        if (paramAnonymousIntent == null) {}
        for (paramAnonymousIntent = "";; paramAnonymousIntent = paramAnonymousIntent.getAction())
        {
          a.i("Tinker.TinkerUtils", "ScreenReceiver action [%s] ", new Object[] { paramAnonymousIntent });
          if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent))
          {
            paramAnonymousContext.unregisterReceiver(this);
            if (parama != null) {
              parama.awv();
            }
          }
          AppMethodBeat.o(65556);
          return;
        }
      }
    }, localIntentFilter);
    AppMethodBeat.o(65557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tinkerboots.sdk.b.d.b
 * JD-Core Version:    0.7.0.1
 */