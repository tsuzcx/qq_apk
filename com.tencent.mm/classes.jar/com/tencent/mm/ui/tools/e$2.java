package com.tencent.mm.ui.tools;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class e$2
  implements Runnable
{
  e$2(e parame, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(107642);
    if (this.Avj.Avh == this.Avj.Avc)
    {
      ab.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
      this.Avk.requestLayout();
    }
    AppMethodBeat.o(107642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e.2
 * JD-Core Version:    0.7.0.1
 */