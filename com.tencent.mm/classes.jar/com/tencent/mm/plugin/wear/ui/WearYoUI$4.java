package com.tencent.mm.plugin.wear.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class WearYoUI$4
  extends BroadcastReceiver
{
  WearYoUI$4(WearYoUI paramWearYoUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == "android.intent.action.CLOSE_SYSTEM_DIALOGS") {
      this.qTa.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoUI.4
 * JD-Core Version:    0.7.0.1
 */