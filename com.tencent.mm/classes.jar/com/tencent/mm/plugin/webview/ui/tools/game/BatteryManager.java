package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BatteryManager
{
  public static BatteryChangedReceiver JpJ;
  public static boolean xvy;
  
  public static final class BatteryChangedReceiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(80804);
      if (paramIntent == null)
      {
        AppMethodBeat.o(80804);
        return;
      }
      if ("android.intent.action.BATTERY_OKAY".equals(paramIntent.getAction()))
      {
        BatteryManager.xvy = false;
        AppMethodBeat.o(80804);
        return;
      }
      if ("android.intent.action.BATTERY_LOW".equals(paramIntent.getAction())) {
        BatteryManager.xvy = true;
      }
      AppMethodBeat.o(80804);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager
 * JD-Core Version:    0.7.0.1
 */