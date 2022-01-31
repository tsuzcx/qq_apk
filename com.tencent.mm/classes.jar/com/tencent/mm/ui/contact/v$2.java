package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.MMActivity;

final class v$2
  implements View.OnTouchListener
{
  v$2(v paramv) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((v.b(this.vMW) instanceof MMActivity)) {
      ((MMActivity)v.b(this.vMW)).XM();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.v.2
 * JD-Core Version:    0.7.0.1
 */