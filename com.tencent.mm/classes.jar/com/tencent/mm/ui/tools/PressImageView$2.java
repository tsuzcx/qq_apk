package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.ah;

final class PressImageView$2
  implements View.OnTouchListener
{
  PressImageView$2(PressImageView paramPressImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while ((!this.wed.isClickable()) && (!this.wed.isLongClickable()))
    {
      return true;
      paramView.setPressed(true);
      paramView.invalidate();
      PressImageView.b(this.wed).removeCallbacks(PressImageView.a(this.wed));
      continue;
      PressImageView.b(this.wed).post(PressImageView.a(this.wed));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.PressImageView.2
 * JD-Core Version:    0.7.0.1
 */