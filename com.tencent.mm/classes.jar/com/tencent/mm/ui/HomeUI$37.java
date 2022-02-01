package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class HomeUI$37
  implements Runnable
{
  HomeUI$37(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33211);
    Log.d("MicroMsg.LauncherUI.HomeUI", "onMainTabCreate, send refresh broadcast");
    HomeUI.b(this.ODr).sendBroadcast(new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP"));
    AppMethodBeat.o(33211);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(33212);
    String str = super.toString() + "|sendBroadcast";
    AppMethodBeat.o(33212);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.37
 * JD-Core Version:    0.7.0.1
 */