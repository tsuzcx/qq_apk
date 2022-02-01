package com.tencent.mm.ui.tools;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class f$3
  implements Runnable
{
  f$3(f paramf, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(143084);
    if (this.XSo.XSi == this.XSo.XSd)
    {
      Log.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
      this.XSq.requestLayout();
    }
    AppMethodBeat.o(143084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.f.3
 * JD-Core Version:    0.7.0.1
 */