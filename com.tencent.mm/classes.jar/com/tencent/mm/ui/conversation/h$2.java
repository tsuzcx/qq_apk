package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$2
  implements View.OnTouchListener
{
  h$2(h paramh) {}
  
  @TargetApi(21)
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153998);
    paramView.findViewById(2131823252).getBackground().setHotspot(paramMotionEvent.getX(), paramMotionEvent.getY());
    AppMethodBeat.o(153998);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h.2
 * JD-Core Version:    0.7.0.1
 */