package com.tencent.mm.ui.chatting;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public final class r$a
  implements View.OnTouchListener
{
  private int mColor;
  
  public r$a()
  {
    this(Color.argb(255, 136, 136, 136));
  }
  
  private r$a(int paramInt)
  {
    this.mColor = paramInt;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((paramView instanceof ImageView))
    {
      paramView = ((ImageView)paramView).getDrawable();
      if (paramView != null)
      {
        if (i != 0) {
          break label49;
        }
        paramView.setColorFilter(this.mColor, PorterDuff.Mode.MULTIPLY);
      }
    }
    for (;;)
    {
      return false;
      paramView = paramView.getBackground();
      break;
      label49:
      if ((i == 3) || (i == 1)) {
        paramView.clearColorFilter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.r.a
 * JD-Core Version:    0.7.0.1
 */