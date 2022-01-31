package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;

public final class c$a
{
  public c$a(c paramc) {}
  
  public final void ae(Bundle paramBundle)
  {
    this.rwk.rwi = paramBundle;
    y.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
    if ((paramBundle != null) && (paramBundle.getBoolean("game_page_report_time_begin")))
    {
      this.rwk.kXo = 0L;
      this.rwk.mStartTime = System.currentTimeMillis();
      this.rwk.kXp = System.currentTimeMillis();
    }
  }
  
  public final void cfP()
  {
    this.rwk.rwi = null;
    this.rwk.mStartTime = 0L;
    this.rwk.kXo = 0L;
    this.rwk.mStartTime = 0L;
    this.rwk.kXp = 0L;
  }
  
  public final void cfQ()
  {
    this.rwk.mStartTime = System.currentTimeMillis();
    this.rwk.kXp = System.currentTimeMillis();
  }
  
  public final void onPause()
  {
    if (this.rwk.kXp != 0L) {
      this.rwk.kXo += System.currentTimeMillis() - this.rwk.kXp;
    }
  }
  
  public final void onResume()
  {
    if (this.rwk.kXp != 0L) {
      this.rwk.kXp = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.c.a
 * JD-Core Version:    0.7.0.1
 */