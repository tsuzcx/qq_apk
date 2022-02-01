package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

final class HomeUI$3
  implements Runnable
{
  HomeUI$3(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(275328);
    int i = a.kk(MMApplicationContext.getContext());
    long l = System.currentTimeMillis();
    if (l - MultiProcessMMKV.getDefault().decodeLong("font_size_report_time", 0L) > 604800000L)
    {
      h.IzE.a(14239, new Object[] { Integer.valueOf(i) });
      MultiProcessMMKV.getDefault().encode("font_size_report_time", l);
      Log.i("MicroMsg.LauncherUI.HomeUI", "using font size kvReport logID:%d , usingFontSize: %d", new Object[] { Integer.valueOf(14239), Integer.valueOf(i) });
    }
    AppMethodBeat.o(275328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.3
 * JD-Core Version:    0.7.0.1
 */