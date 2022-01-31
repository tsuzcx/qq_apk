package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BatteryManager$BatteryChangedReceiver
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(8633);
    if (paramIntent == null)
    {
      AppMethodBeat.o(8633);
      return;
    }
    if ("android.intent.action.BATTERY_OKAY".equals(paramIntent.getAction()))
    {
      BatteryManager.vme = false;
      AppMethodBeat.o(8633);
      return;
    }
    if ("android.intent.action.BATTERY_LOW".equals(paramIntent.getAction())) {
      BatteryManager.vme = true;
    }
    AppMethodBeat.o(8633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager.BatteryChangedReceiver
 * JD-Core Version:    0.7.0.1
 */