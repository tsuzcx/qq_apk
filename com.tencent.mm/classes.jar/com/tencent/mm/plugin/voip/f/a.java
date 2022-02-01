package com.tencent.mm.plugin.voip.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  static boolean Itd;
  public static a ULa;
  
  public static void stop()
  {
    AppMethodBeat.i(292636);
    if (ULa != null) {
      MMApplicationContext.getContext().unregisterReceiver(ULa);
    }
    ULa = null;
    AppMethodBeat.o(292636);
  }
  
  public static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(292715);
      if (paramIntent == null)
      {
        AppMethodBeat.o(292715);
        return;
      }
      if ("android.intent.action.BATTERY_OKAY".equals(paramIntent.getAction()))
      {
        a.Itd = false;
        AppMethodBeat.o(292715);
        return;
      }
      if ("android.intent.action.BATTERY_LOW".equals(paramIntent.getAction())) {
        a.Itd = true;
      }
      AppMethodBeat.o(292715);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.a
 * JD-Core Version:    0.7.0.1
 */