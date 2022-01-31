package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.MMActivity;

final class k$3
  implements View.OnTouchListener
{
  k$3(k paramk) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((k.d(this.vLo) instanceof MMActivity)) {
      ((MMActivity)k.d(this.vLo)).XM();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k.3
 * JD-Core Version:    0.7.0.1
 */