package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.MMActivity;

final class b$2
  implements View.OnTouchListener
{
  b$2(b paramb) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((b.a(this.vJu) instanceof MMActivity)) {
      ((MMActivity)b.a(this.vJu)).XM();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.b.2
 * JD-Core Version:    0.7.0.1
 */