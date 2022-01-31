package com.tencent.mm.ui.blur;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  a$3(a parama) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(155342);
    if (Build.VERSION.SDK_INT >= 16) {
      this.zuO.zuE.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      int i = this.zuO.zuE.getMeasuredWidth();
      int j = this.zuO.zuE.getMeasuredHeight();
      this.zuO.init(i, j);
      AppMethodBeat.o(155342);
      return;
      this.zuO.zuE.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.blur.a.3
 * JD-Core Version:    0.7.0.1
 */