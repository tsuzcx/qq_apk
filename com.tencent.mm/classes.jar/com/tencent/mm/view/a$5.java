package com.tencent.mm.view;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.y;

final class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public final void run()
  {
    Rect localRect = new Rect();
    this.wvE.getWindowVisibleDisplayFrame(localRect);
    int i;
    if (this.wvE.getBottom() - localRect.bottom >= 300)
    {
      i = 1;
      this.wvE.getResources().getDisplayMetrics();
      if (i != 0) {
        break label133;
      }
      i = this.wvE.getBottom() - (int)this.wvE.getResources().getDimension(a.c.color_select_layout_height);
    }
    for (;;)
    {
      if (a.b(this.wvE).getHeight() != i) {
        a.b(this.wvE).setHeight(i);
      }
      this.wvE.getViewTreeObserver().removeOnGlobalLayoutListener(this.wvE);
      this.wvE.getViewTreeObserver().addOnGlobalLayoutListener(this.wvE);
      return;
      i = 0;
      break;
      label133:
      i = this.wvE.getBottom() - u.u(this.wvE.getContext(), false) - (int)this.wvE.getResources().getDimension(a.c.color_select_layout_height);
      y.e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", new Object[] { Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.a.5
 * JD-Core Version:    0.7.0.1
 */