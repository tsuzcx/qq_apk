package com.tencent.mm.view;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ab;

final class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(116376);
    Rect localRect = new Rect();
    this.AQD.getWindowVisibleDisplayFrame(localRect);
    int i;
    if (this.AQD.getBottom() - localRect.bottom >= 300)
    {
      i = 1;
      this.AQD.getResources().getDisplayMetrics();
      if (i != 0) {
        break label142;
      }
      i = this.AQD.getBottom() - (int)this.AQD.getResources().getDimension(2131428235);
    }
    for (;;)
    {
      if (a.b(this.AQD).getHeight() != i) {
        a.b(this.AQD).setHeight(i);
      }
      this.AQD.getViewTreeObserver().removeOnGlobalLayoutListener(this.AQD);
      this.AQD.getViewTreeObserver().addOnGlobalLayoutListener(this.AQD);
      AppMethodBeat.o(116376);
      return;
      i = 0;
      break;
      label142:
      i = this.AQD.getBottom() - j.Mr() - (int)this.AQD.getResources().getDimension(2131428235);
      ab.e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", new Object[] { Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.a.5
 * JD-Core Version:    0.7.0.1
 */