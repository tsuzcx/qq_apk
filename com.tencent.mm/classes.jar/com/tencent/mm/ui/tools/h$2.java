package com.tencent.mm.ui.tools;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  h$2(h paramh) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(155380);
    if (this.AvB.Avq != null)
    {
      int i = this.AvB.Avs.bottom;
      this.AvB.Avt.getWindowVisibleDisplayFrame(this.AvB.Avs);
      if (this.AvB.Avs.bottom != i)
      {
        ab.i("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", new Object[] { Integer.valueOf(i), this.AvB.Avs.toShortString() });
        h.a(this.AvB);
      }
    }
    AppMethodBeat.o(155380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.h.2
 * JD-Core Version:    0.7.0.1
 */