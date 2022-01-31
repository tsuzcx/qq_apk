package com.tencent.xweb.extension.video;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$3
  implements Runnable
{
  d$3(d paramd, boolean paramBoolean, double paramDouble) {}
  
  public final void run()
  {
    AppMethodBeat.i(84577);
    if ((this.BFT) && (d.a(this.BFR) != 0.0D)) {
      d.l(this.BFR).c((int)(100.0D * (this.BFU / d.a(this.BFR))), false);
    }
    d.m(this.BFR).setText(d.a(this.BFR, this.BFU));
    d.o(this.BFR).setText(d.n(this.BFR));
    AppMethodBeat.o(84577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.3
 * JD-Core Version:    0.7.0.1
 */