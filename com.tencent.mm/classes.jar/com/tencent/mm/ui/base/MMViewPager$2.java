package com.tencent.mm.ui.base;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.y;

final class MMViewPager$2
  implements View.OnTouchListener
{
  MMViewPager$2(MMViewPager paramMMViewPager) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    y.d("MicroMsg.MMViewPager", "alvinluo onTouch getCurrentItem: %d", new Object[] { Integer.valueOf(this.uZn.getCurrentItem()) });
    if (MMViewPager.k(this.uZn) != null) {}
    for (boolean bool1 = MMViewPager.k(this.uZn).onTouch(paramView, paramMotionEvent);; bool1 = false)
    {
      MMViewPager.a(this.uZn, false);
      paramView = MMViewPager.g(this.uZn);
      if (paramView == null)
      {
        MMViewPager.a(this.uZn, false);
        MMViewPager.a(this.uZn, paramMotionEvent);
        MMViewPager.b(this.uZn, null);
        MMViewPager.l(this.uZn).onTouchEvent(paramMotionEvent);
        if ((MMViewPager.m(this.uZn)) || (MMViewPager.n(this.uZn))) {
          bool1 = true;
        }
        return bool1;
      }
      MMViewPager.a(this.uZn, paramView);
      if ((MMViewPager.a(this.uZn) != null) && ((MMViewPager.a(this.uZn) instanceof MultiTouchImageView))) {
        MMViewPager.a(this.uZn, false);
      }
      for (;;)
      {
        boolean bool2 = MMViewPager.a(this.uZn, MMViewPager.a(this.uZn), paramMotionEvent);
        if (MMViewPager.o(this.uZn) != null) {
          MMViewPager.o(this.uZn).recycle();
        }
        MMViewPager.b(this.uZn, MotionEvent.obtainNoHistory(paramMotionEvent));
        MMViewPager.l(this.uZn).onTouchEvent(paramMotionEvent);
        this.uZn.computeScroll();
        if ((!bool2) && (!bool1)) {
          break;
        }
        return true;
        if ((MMViewPager.a(this.uZn) != null) && ((MMViewPager.a(this.uZn) instanceof WxImageView))) {
          MMViewPager.a(this.uZn, true);
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.2
 * JD-Core Version:    0.7.0.1
 */