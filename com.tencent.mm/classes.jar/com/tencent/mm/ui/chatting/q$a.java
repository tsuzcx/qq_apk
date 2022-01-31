package com.tencent.mm.ui.chatting;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q$a
  implements View.OnTouchListener
{
  private int mColor;
  
  public q$a()
  {
    this(Color.argb(255, 136, 136, 136));
    AppMethodBeat.i(30694);
    AppMethodBeat.o(30694);
  }
  
  private q$a(int paramInt)
  {
    this.mColor = paramInt;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30695);
    int i = paramMotionEvent.getAction();
    if ((paramView instanceof ImageView))
    {
      paramView = ((ImageView)paramView).getDrawable();
      if (paramView != null)
      {
        if (i != 0) {
          break label61;
        }
        paramView.setColorFilter(this.mColor, PorterDuff.Mode.MULTIPLY);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30695);
      return false;
      paramView = paramView.getBackground();
      break;
      label61:
      if ((i == 3) || (i == 1)) {
        paramView.clearColorFilter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.a
 * JD-Core Version:    0.7.0.1
 */