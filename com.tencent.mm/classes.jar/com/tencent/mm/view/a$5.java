package com.tencent.mm.view;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.sdk.platformtools.ad;

final class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(9353);
    Rect localRect = new Rect();
    this.LnY.getWindowVisibleDisplayFrame(localRect);
    int i;
    if (this.LnY.getBottom() - localRect.bottom >= 300)
    {
      i = 1;
      this.LnY.getResources().getDisplayMetrics();
      if (i != 0) {
        break label144;
      }
      i = this.LnY.getBottom() - (int)this.LnY.getResources().getDimension(2131166048);
    }
    for (;;)
    {
      if (a.b(this.LnY).getHeight() != i) {
        a.b(this.LnY).setHeight(i);
      }
      this.LnY.getViewTreeObserver().removeOnGlobalLayoutListener(this.LnY);
      this.LnY.getViewTreeObserver().addOnGlobalLayoutListener(this.LnY);
      AppMethodBeat.o(9353);
      return;
      i = 0;
      break;
      label144:
      i = this.LnY.getBottom() - i.abo() - (int)this.LnY.getResources().getDimension(2131166048);
      ad.e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", new Object[] { Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.a.5
 * JD-Core Version:    0.7.0.1
 */