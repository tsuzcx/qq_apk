package com.tencent.mm.ui;

import android.content.Intent;
import androidx.i.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class HomeUI$39
  implements Runnable
{
  HomeUI$39(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33211);
    Log.d("MicroMsg.LauncherUI.HomeUI", "onMainTabCreate, send refresh broadcast");
    a.al(MMApplicationContext.getContext()).d(new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.39
 * JD-Core Version:    0.7.0.1
 */