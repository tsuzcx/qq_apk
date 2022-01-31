package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c$a
{
  public c$a(c paramc) {}
  
  public final void ax(Bundle paramBundle)
  {
    AppMethodBeat.i(8682);
    this.vmC.vmA = paramBundle;
    ab.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
    if ((paramBundle != null) && (paramBundle.getBoolean("game_page_report_time_begin")))
    {
      this.vmC.nvq = 0L;
      this.vmC.mStartTime = System.currentTimeMillis();
      this.vmC.nvr = System.currentTimeMillis();
    }
    AppMethodBeat.o(8682);
  }
  
  public final void dgb()
  {
    this.vmC.vmA = null;
    this.vmC.mStartTime = 0L;
    this.vmC.nvq = 0L;
    this.vmC.mStartTime = 0L;
    this.vmC.nvr = 0L;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(8684);
    if (this.vmC.nvr != 0L) {
      this.vmC.nvq += System.currentTimeMillis() - this.vmC.nvr;
    }
    AppMethodBeat.o(8684);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(8683);
    if (this.vmC.nvr != 0L) {
      this.vmC.nvr = System.currentTimeMillis();
    }
    AppMethodBeat.o(8683);
  }
  
  public final void uG()
  {
    AppMethodBeat.i(8681);
    this.vmC.mStartTime = System.currentTimeMillis();
    this.vmC.nvr = System.currentTimeMillis();
    AppMethodBeat.o(8681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.c.a
 * JD-Core Version:    0.7.0.1
 */