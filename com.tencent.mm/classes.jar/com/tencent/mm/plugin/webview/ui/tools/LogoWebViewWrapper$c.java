package com.tencent.mm.plugin.webview.ui.tools;

import android.support.v4.view.t;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LogoWebViewWrapper$c
  implements Runnable
{
  private final long duration;
  private long startTime;
  private final Interpolator vaF;
  private final int vaG;
  private final int vaH;
  private boolean vaI;
  private int vaJ;
  
  public LogoWebViewWrapper$c(LogoWebViewWrapper paramLogoWebViewWrapper, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(7392);
    this.vaI = true;
    this.startTime = -1L;
    this.vaJ = -1;
    this.vaH = paramInt1;
    this.vaG = paramInt2;
    if (LogoWebViewWrapper.b(paramLogoWebViewWrapper)) {}
    for (paramLogoWebViewWrapper = new AccelerateInterpolator();; paramLogoWebViewWrapper = new DecelerateInterpolator())
    {
      this.vaF = paramLogoWebViewWrapper;
      this.duration = paramLong;
      AppMethodBeat.o(7392);
      return;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(7393);
    if (this.startTime == -1L) {
      this.startTime = System.currentTimeMillis();
    }
    for (;;)
    {
      if ((this.vaI) && (this.vaG != this.vaJ)) {
        t.b(this.vaE, this);
      }
      AppMethodBeat.o(7393);
      return;
      long l = 500L;
      if (this.duration > 0L) {
        l = Math.max(Math.min((System.currentTimeMillis() - this.startTime) * 1000L / this.duration, 1000L), 0L);
      }
      float f = this.vaH - this.vaG;
      int i = Math.round(this.vaF.getInterpolation((float)l / 1000.0F) * f);
      this.vaJ = (this.vaH - i);
      this.vaE.Kp(this.vaJ);
      if (LogoWebViewWrapper.c(this.vaE) != null) {
        LogoWebViewWrapper.c(this.vaE).P(this.vaJ, false);
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(7394);
    this.vaI = false;
    this.vaE.removeCallbacks(this);
    AppMethodBeat.o(7394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.c
 * JD-Core Version:    0.7.0.1
 */