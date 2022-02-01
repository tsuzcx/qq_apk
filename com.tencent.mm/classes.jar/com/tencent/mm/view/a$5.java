package com.tencent.mm.view;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.sdk.platformtools.Log;

final class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(9353);
    Rect localRect = new Rect();
    this.RiD.getWindowVisibleDisplayFrame(localRect);
    int i;
    if (this.RiD.getBottom() - localRect.bottom >= 300)
    {
      i = 1;
      this.RiD.getResources().getDisplayMetrics();
      if (i != 0) {
        break label144;
      }
      i = this.RiD.getBottom() - (int)this.RiD.getResources().getDimension(2131166088);
    }
    for (;;)
    {
      if (a.b(this.RiD).getHeight() != i) {
        a.b(this.RiD).setHeight(i);
      }
      this.RiD.getViewTreeObserver().removeOnGlobalLayoutListener(this.RiD);
      this.RiD.getViewTreeObserver().addOnGlobalLayoutListener(this.RiD);
      AppMethodBeat.o(9353);
      return;
      i = 0;
      break;
      label144:
      i = this.RiD.getBottom() - i.apu() - (int)this.RiD.getResources().getDimension(2131166088);
      Log.e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", new Object[] { Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.a.5
 * JD-Core Version:    0.7.0.1
 */