package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class i$3
  extends BroadcastReceiver
{
  i$3(i parami) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.hasExtra("state")) && (paramIntent.getIntExtra("state", 2) == 0)) {
      this.qSo.bYS();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.i.3
 * JD-Core Version:    0.7.0.1
 */