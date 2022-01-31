package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class HomeUI$34
  implements Runnable
{
  HomeUI$34(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(29381);
    ab.d("MicroMsg.LauncherUI.HomeUI", "onMainTabCreate, send refresh broadcast");
    HomeUI.b(this.yYw).sendBroadcast(new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP"));
    AppMethodBeat.o(29381);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153786);
    String str = super.toString() + "|sendBroadcast";
    AppMethodBeat.o(153786);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.34
 * JD-Core Version:    0.7.0.1
 */