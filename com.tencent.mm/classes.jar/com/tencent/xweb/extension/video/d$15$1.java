package com.tencent.xweb.extension.video;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import org.xwalk.core.Log;

final class d$15$1
  implements Runnable
{
  d$15$1(d.15 param15) {}
  
  public final void run()
  {
    AppMethodBeat.i(292798);
    if (this.abTK.abTJ)
    {
      if ((d.q(this.abTK.aade).isXWalkKernel()) && (d.a(this.abTK.aade, d.r(this.abTK.aade)) == null) && (d.b(this.abTK.aade, d.r(this.abTK.aade)) == null))
      {
        d.s(this.abTK.aade).setBackgroundColor(0);
        d.t(this.abTK.aade).setVisibility(0);
        AppMethodBeat.o(292798);
        return;
      }
      d.s(this.abTK.aade).setBackgroundColor(-16777216);
      d.u(this.abTK.aade).setBackgroundColor(0);
      d.t(this.abTK.aade).setVisibility(0);
    }
    while (Double.isInfinite(this.abTK.abTF))
    {
      Log.i("XWebNativeInterface", "onVideoEnterFullscreen duration is infinite, maybe live video");
      d.v(this.abTK.aade).setVisibility(4);
      AppMethodBeat.o(292798);
      return;
      d.s(this.abTK.aade).setBackgroundColor(0);
      d.u(this.abTK.aade).setBackgroundColor(-16777216);
    }
    d.v(this.abTK.aade).setVisibility(0);
    AppMethodBeat.o(292798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.15.1
 * JD-Core Version:    0.7.0.1
 */