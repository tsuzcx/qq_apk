package com.tencent.xweb.extension.video;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$9
  implements Runnable
{
  d$9(d paramd, boolean paramBoolean, double paramDouble1, double paramDouble2) {}
  
  public final void run()
  {
    AppMethodBeat.i(84583);
    if (this.BFX) {
      d.q(this.BFR).setVisibility(0);
    }
    this.BFR.iA((int)this.BFY, (int)this.BFZ);
    AppMethodBeat.o(84583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.9
 * JD-Core Version:    0.7.0.1
 */