package com.tencent.mm.ui.base;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMViewPager$2
  implements View.OnTouchListener
{
  MMViewPager$2(MMViewPager paramMMViewPager) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106898);
    ab.d("MicroMsg.MMViewPager", "alvinluo onTouch getCurrentItem: %d", new Object[] { Integer.valueOf(this.znE.getCurrentItem()) });
    if (MMViewPager.k(this.znE) != null) {}
    for (boolean bool1 = MMViewPager.k(this.znE).onTouch(paramView, paramMotionEvent);; bool1 = false)
    {
      paramView = this.znE.getSelectedImageView();
      if (paramView == null)
      {
        MMViewPager.a(this.znE, paramMotionEvent);
        MMViewPager.b(this.znE, null);
        MMViewPager.l(this.znE).onTouchEvent(paramMotionEvent);
        if ((MMViewPager.m(this.znE)) || (MMViewPager.n(this.znE)))
        {
          AppMethodBeat.o(106898);
          return true;
        }
        AppMethodBeat.o(106898);
        return bool1;
      }
      MMViewPager.a(this.znE, paramView);
      boolean bool2 = MMViewPager.c(this.znE, paramMotionEvent);
      if (MMViewPager.o(this.znE) != null) {
        MMViewPager.o(this.znE).recycle();
      }
      MMViewPager.b(this.znE, MotionEvent.obtainNoHistory(paramMotionEvent));
      MMViewPager.l(this.znE).onTouchEvent(paramMotionEvent);
      this.znE.computeScroll();
      if ((bool2) || (bool1))
      {
        AppMethodBeat.o(106898);
        return true;
      }
      AppMethodBeat.o(106898);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.2
 * JD-Core Version:    0.7.0.1
 */