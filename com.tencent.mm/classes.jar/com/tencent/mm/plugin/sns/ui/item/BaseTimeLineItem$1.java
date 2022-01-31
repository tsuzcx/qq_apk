package com.tencent.mm.plugin.sns.ui.item;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseTimeLineItem$1
  implements View.OnTouchListener
{
  BaseTimeLineItem$1(BaseTimeLineItem paramBaseTimeLineItem) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(40115);
    if (paramMotionEvent.getAction() == 0) {
      paramView.setTag(2131820681, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    }
    AppMethodBeat.o(40115);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.1
 * JD-Core Version:    0.7.0.1
 */