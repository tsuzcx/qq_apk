package com.tencent.mm.plugin.wear.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WearYoUI$4
  extends BroadcastReceiver
{
  WearYoUI$4(WearYoUI paramWearYoUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(26466);
    if (paramIntent.getAction() == "android.intent.action.CLOSE_SYSTEM_DIALOGS") {
      this.uIh.finish();
    }
    AppMethodBeat.o(26466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI.4
 * JD-Core Version:    0.7.0.1
 */